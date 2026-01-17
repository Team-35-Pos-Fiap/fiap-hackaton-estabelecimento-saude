package br.com.fiap.estabelecimento_saude.services.interfaces;

import br.com.fiap.estabelecimento_saude.entities.db.EnderecoEntity;
import br.com.fiap.estabelecimento_saude.entities.record.request.EnderecoRecordRequest;

public interface IEnderecoService {
    void atualizarEndereco(EnderecoEntity enderecoAtual, EnderecoRecordRequest dados);
}
