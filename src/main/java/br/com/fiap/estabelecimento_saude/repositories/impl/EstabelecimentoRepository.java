package br.com.fiap.estabelecimento_saude.repositories.impl;

import br.com.fiap.estabelecimento_saude.entities.db.EstabelecimentoEntity;
import br.com.fiap.estabelecimento_saude.repositories.exceptions.EstabelecimentoNaoEncontradoException;
import br.com.fiap.estabelecimento_saude.repositories.interfaces.IEstabelecimentoRepository;
import br.com.fiap.estabelecimento_saude.repositories.interfaces.jpa.IEstabelecimentoJpaRepository;
import br.com.fiap.estabelecimento_saude.services.exceptions.PaginaInvalidaException;
import br.com.fiap.estabelecimento_saude.utils.MensagensUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class EstabelecimentoRepository implements IEstabelecimentoRepository {

	private final IEstabelecimentoJpaRepository estabelecimentoRepository;
	private final Integer QUANTIDADE_REGISTROS = 5;

	public EstabelecimentoRepository(IEstabelecimentoJpaRepository estabelecimentoRepository) {

        this.estabelecimentoRepository = estabelecimentoRepository;
	}

	@Override
	public EstabelecimentoEntity recuperaDadosEstabelecimentoPorId(UUID id) {

        return getEstabelecimentoEntity(estabelecimentoRepository.findById(id));
	}

	@Override
	public EstabelecimentoEntity recuperaDadosEstabelecimentoInativoPorId(UUID id) {
		return getEstabelecimentoEntity(estabelecimentoRepository.findByIdAndIsAtivoFalse(id));
	}

	@Override
	public EstabelecimentoEntity recuperaDadosEstabelecimentoAtivoPorId(UUID id) {
		return getEstabelecimentoEntity(estabelecimentoRepository.findByIdAndIsAtivoTrue(id));
	}

	@Override
	public Page<EstabelecimentoEntity> recuperaDadosEstabelecimentos(final Integer pagina) {
		if (pagina == null || pagina < 1) {
			throw new PaginaInvalidaException();
		}
		Page<EstabelecimentoEntity> estabelecimentos = estabelecimentoRepository.findAll(PageRequest.of(pagina - 1, QUANTIDADE_REGISTROS));
		
		if(estabelecimentos.toList().isEmpty()) {		
			throw new EstabelecimentoNaoEncontradoException(MensagensUtil.recuperarMensagem(MensagensUtil.ERRO_ESTABELECIMENTOS_NAO_ENCONTRADOS));
		} else {
			return estabelecimentos;
		}
	}

	@Override
	public void salvar(EstabelecimentoEntity estabelecimento) {
		estabelecimentoRepository.save(estabelecimento);
	}

	@Override
	public boolean emailJaCadastrado(String email) {
		return estabelecimentoRepository.existsByEmail(email);
	}

	private EstabelecimentoEntity getEstabelecimentoEntity(Optional<EstabelecimentoEntity> dadosEstabelecimento) {
		if(dadosEstabelecimento.isPresent()) {		
			return dadosEstabelecimento.get();
		} else {
			throw new EstabelecimentoNaoEncontradoException(MensagensUtil.recuperarMensagem(MensagensUtil.ERRO_ESTABELECIMENTO_NAO_ENCONTRADO));
		}
	}
}