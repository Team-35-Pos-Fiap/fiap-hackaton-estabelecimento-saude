package br.com.fiap.estabelecimento_saude.repositories.interfaces.jpa;

import br.com.fiap.estabelecimento_saude.entities.db.EstabelecimentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface IEstabelecimentoJpaRepository extends JpaRepository<EstabelecimentoEntity, UUID> {
	Optional<EstabelecimentoEntity> findByIdAndIsAtivoTrue(UUID id);

	Optional<EstabelecimentoEntity> findByIdAndIsAtivoFalse(UUID id);

	boolean existsByEmail(String email);
}