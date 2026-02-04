package br.com.fiap.estabelecimento_saude.services;

import br.com.fiap.estabelecimento_saude.clients.IUsuarioServiceClient;
import br.com.fiap.estabelecimento_saude.entities.db.EstabelecimentoEntity;
import br.com.fiap.estabelecimento_saude.entities.domain.EstabelecimentoDomain;
import br.com.fiap.estabelecimento_saude.entities.record.request.EnderecoRecordRequest;
import br.com.fiap.estabelecimento_saude.entities.record.request.EstabelecimentoRecordRequest;
import br.com.fiap.estabelecimento_saude.entities.record.response.EstabelecimentoRecordPaginacaoResponse;
import br.com.fiap.estabelecimento_saude.entities.record.response.EstabelecimentoRecordResponse;
import br.com.fiap.estabelecimento_saude.entities.record.response.EstabelecimentoRecordResponseUsuario;
import br.com.fiap.estabelecimento_saude.entities.record.response.UsuarioDtoResponse;
import br.com.fiap.estabelecimento_saude.mappers.EstabelecimentoMapper;
import br.com.fiap.estabelecimento_saude.repositories.interfaces.IEstabelecimentoRepository;
import br.com.fiap.estabelecimento_saude.services.exceptions.EmailDuplicadoException;
import br.com.fiap.estabelecimento_saude.services.interfaces.IEnderecoService;
import br.com.fiap.estabelecimento_saude.services.interfaces.IEstabelecimentoService;
import br.com.fiap.estabelecimento_saude.utils.MensagensUtil;
import feign.FeignException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EstabelecimentoService implements IEstabelecimentoService {

	private final IEstabelecimentoRepository estabelecimentoRepository;
	private final IEnderecoService enderecoService;
    private final IUsuarioServiceClient usuarioServiceClient;

	public EstabelecimentoService(IEstabelecimentoRepository estabelecimentoRepository, IEnderecoService enderecoService, IUsuarioServiceClient usuarioServiceClient) {
		this.estabelecimentoRepository = estabelecimentoRepository;
		this.enderecoService = enderecoService;
        this.usuarioServiceClient = usuarioServiceClient;
	}

	@Override
	public EstabelecimentoRecordResponseUsuario buscarPorId(UUID id) {
		EstabelecimentoEntity estabelecimentoEntity = estabelecimentoRepository.recuperaDadosEstabelecimentoPorId(id);

        UsuarioDtoResponse usuario = validarSeUsuarioExiste(estabelecimentoEntity.getIdResponsavel());

		EstabelecimentoDomain estabelecimentoDomain = EstabelecimentoMapper.toEstabelecimento(estabelecimentoEntity);

		return EstabelecimentoMapper.toEstabelecimentoRecord(estabelecimentoDomain, usuario);
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

        validarSeUsuarioExiste(estabelecimento.idResponsavel());

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

    @Override
    public UsuarioDtoResponse validarSeUsuarioExiste(UUID idResponsavel) {
        try {
            return usuarioServiceClient.buscarUsuarioPorId(idResponsavel);
        } catch (FeignException.NotFound e) {
            throw new IllegalArgumentException("Usuário não encontrado no serviço de usuários");
        } catch (FeignException e) {
            throw new RuntimeException("Erro ao consultar serviço de usuários: " + e.status(), e);
        }
    }
}