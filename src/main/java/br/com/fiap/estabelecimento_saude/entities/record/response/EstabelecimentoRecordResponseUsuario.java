package br.com.fiap.estabelecimento_saude.entities.record.response;

import br.com.fiap.estabelecimento_saude.entities.record.request.EnderecoRecordRequest;

import java.util.UUID;

public record EstabelecimentoRecordResponseUsuario(UUID id,
                                                   String nome,
                                                   String email,
                                                   Boolean ativo,
                                                   EnderecoRecordRequest dadosEnderecoEstabelecimento,
                                                   UsuarioDtoResponse usuarioResponsavel) { }