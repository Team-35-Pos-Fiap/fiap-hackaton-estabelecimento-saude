package br.com.fiap.estabelecimento_saude.repositories.impl;

import br.com.fiap.estabelecimento_saude.entities.db.EnderecoEntity;
import br.com.fiap.estabelecimento_saude.repositories.interfaces.IEnderecoRepository;
import br.com.fiap.estabelecimento_saude.repositories.interfaces.jpa.IEnderecoJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class EnderecoRepository implements IEnderecoRepository {

	private final IEnderecoJpaRepository enderecoRepository;

	public EnderecoRepository(IEnderecoJpaRepository enderecoRepository) {
		this.enderecoRepository = enderecoRepository;
	}

	@Override
	public Optional<EnderecoEntity> buscarPorId(UUID id) {
		return enderecoRepository.findById(id);
	}

	@Override
	public void salvar(EnderecoEntity endereco) {
		enderecoRepository.save(endereco);
	}
}