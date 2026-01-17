package br.com.fiap.estabelecimento_saude.entities.record.response;

import br.com.fiap.estabelecimento_saude.entities.record.request.EnderecoRecordRequest;

import java.util.UUID;

public record EstabelecimentoRecordResponse(UUID id,
                                            String nome,
                                            String email,
                                            Boolean ativo,
                                            EnderecoRecordRequest dadosEndereco) { }