package br.com.fiap.estabelecimento_saude.entities.record.response;

import java.util.UUID;

public record UsuarioDtoResponse(UUID id,
                                 String nome,
                                 String email,
                                 String matricula,
                                 Boolean ativo,
                                 String cpf,
                                 EnderecoDtoResponse dadosEndereco,
                                 PerfilDtoResponse perfil) { }