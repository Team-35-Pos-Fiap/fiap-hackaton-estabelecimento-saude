package br.com.fiap.estabelecimento_saude.services;

import br.com.fiap.estabelecimento_saude.entities.db.EstabelecimentoEntity;
import br.com.fiap.estabelecimento_saude.entities.domain.EstabelecimentoDomain;
import br.com.fiap.estabelecimento_saude.entities.record.request.EnderecoRecordRequest;
import br.com.fiap.estabelecimento_saude.entities.record.request.EstabelecimentoRecordRequest;
import br.com.fiap.estabelecimento_saude.entities.record.response.EstabelecimentoRecordPaginacaoResponse;
import br.com.fiap.estabelecimento_saude.entities.record.response.EstabelecimentoRecordResponse;
import br.com.fiap.estabelecimento_saude.mappers.EstabelecimentoMapper;
import br.com.fiap.estabelecimento_saude.repositories.interfaces.IEstabelecimentoRepository;
import br.com.fiap.estabelecimento_saude.services.exceptions.EmailDuplicadoException;
import br.com.fiap.estabelecimento_saude.services.interfaces.IEnderecoService;
import br.com.fiap.estabelecimento_saude.services.interfaces.IEstabelecimentoService;
import br.com.fiap.estabelecimento_saude.utils.MensagensUtil;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EstabelecimentoService implements IEstabelecimentoService {

	private final IEstabelecimentoRepository estabelecimentoRepository;
	private final IEnderecoService enderecoService;

	public EstabelecimentoService(IEstabelecimentoRepository estabelecimentoRepository, IEnderecoService enderecoService) {
		this.estabelecimentoRepository = estabelecimentoRepository;
		this.enderecoService = enderecoService;
	}

	@Override
	public EstabelecimentoRecordResponse buscarPorId(UUID id) {
		EstabelecimentoEntity estabelecimentoEntity = estabelecimentoRepository.recuperaDadosEstabelecimentoPorId(id);
		EstabelecimentoDomain estabelecimentoDomain = EstabelecimentoMapper.toEstabelecimento(estabelecimentoEntity);
		
		return EstabelecimentoMapper.toEstabelecimentoRecord(estabelecimentoDomain);
	}

	@Override
	public EstabelecimentoRecordPaginacaoResponse buscarEstabelecimentos(final Integer pagina) {
		return EstabelecimentoMapper.toEstabelecimento(estabelecimentoRepository.recuperaDadosEstabelecimentos(pagina));
	}

	@Override
	public void cadastrar(EstabelecimentoRecordRequest estabelecimento) {
		if(estabelecimentoRepository.emailJaCadastrado(estabelecimento.email())){
			throw new EmailDuplicadoException(MensagensUtil.recuperarMensagem(MensagensUtil.ERRO_EMAIL_DUPLICADO));
		}

		EstabelecimentoDomain estabelecimentoDomain = EstabelecimentoMapper.toEstabelecimento(estabelecimento);
		EstabelecimentoEntity estabelecimentoEntity = EstabelecimentoMapper.toEstabelecimento(estabelecimentoDomain);
		
		salvar(estabelecimentoEntity);
	}

	@Override
	public void atualizarStatus(UUID id, boolean isAtivo) {
		EstabelecimentoEntity estabelecimento;
		
		if(isAtivo) {
            estabelecimento = estabelecimentoRepository.recuperaDadosEstabelecimentoInativoPorId(id);

            estabelecimento.reativar();
		} else {
            estabelecimento = estabelecimentoRepository.recuperaDadosEstabelecimentoAtivoPorId(id);

            estabelecimento.inativar();
		}
		
		salvar(estabelecimento);
	}

	@Override
	public void salvar(EstabelecimentoEntity estabelecimento) {

        estabelecimentoRepository.salvar(estabelecimento);
	}

	@Override
	public void atualizarNome(UUID id, String nome) {
		EstabelecimentoEntity estabelecimento = estabelecimentoRepository.recuperaDadosEstabelecimentoAtivoPorId(id);

        estabelecimento.atualizarNome(nome);
			
		salvar(estabelecimento);
	}

	@Override
	public void atualizarEmail(UUID id, String email) {
		EstabelecimentoEntity estabelecimento = estabelecimentoRepository.recuperaDadosEstabelecimentoAtivoPorId(id);

		if(estabelecimentoRepository.emailJaCadastrado(email)){
			throw new EmailDuplicadoException(MensagensUtil.recuperarMensagem(MensagensUtil.ERRO_EMAIL_DUPLICADO));
		}

        estabelecimento.atualizarEmail(email);
		
		salvar(estabelecimento);
	}

	@Override
	public void atualizarDadosEndereco(UUID id, EnderecoRecordRequest dadosEndereco) {
		EstabelecimentoEntity estabelecimento = estabelecimentoRepository.recuperaDadosEstabelecimentoPorId(id);

		enderecoService.atualizarEndereco(estabelecimento.getDadosEndereco(), dadosEndereco);
	}
}