package br.com.fiap.estabelecimento_saude.repositories.interfaces.jpa;

import br.com.fiap.estabelecimento_saude.entities.db.EnderecoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IEnderecoJpaRepository extends JpaRepository<EnderecoEntity, UUID>{
}