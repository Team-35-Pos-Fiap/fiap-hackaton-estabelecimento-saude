package br.com.fiap.estabelecimento_saude.entities.record.response;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record PerfilDtoResponse(@NotNull(message = "É necessário informar o perfil de acesso para o usuário.")
                               @Positive(message = "O id do perfil precisa ser maior do que 0.")
                               Integer idPerfil) { }
