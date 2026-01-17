package br.com.fiap.estabelecimento_saude.entities.record.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record EstabelecimentoRecordRequest(@NotBlank(message = "O campo nome precisa estar preenchido.")
								   @Size(min = 3, max = 150, message = "O campo nome precisa ter entre 3 e 150 caracteres.") 
								   String nome,

                                   @NotBlank(message = "O campo email precisa estar preenchido.")
								   @Email(message = "O e-mail precisa ser válido")
							       @Size(min = 3, max = 70, message = "O campo email precisa ter entre 3 e 70 caracteres.") 
								   String email,

                                   @NotBlank(message = "O campo CNES precisa estar preenchido.")
                                   @Size(min = 7, max = 7, message = "O campo CNES precisa ter 7 caracteres.")
                                   String cnes,

                                   @NotNull(message = "É necessário informar os dados de endereço para o Estabelecimento.")
								   @Valid
								   EnderecoRecordRequest dadosEndereco) { }