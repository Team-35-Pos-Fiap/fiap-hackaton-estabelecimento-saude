package br.com.fiap.estabelecimento_saude.repositories.interfaces;


import br.com.fiap.estabelecimento_saude.entities.db.EnderecoEntity;

import java.util.Optional;
import java.util.UUID;

public interface IEnderecoRepository {
    Optional<EnderecoEntity> buscarPorId(UUID id);
    void salvar(EnderecoEntity endereco);
}
