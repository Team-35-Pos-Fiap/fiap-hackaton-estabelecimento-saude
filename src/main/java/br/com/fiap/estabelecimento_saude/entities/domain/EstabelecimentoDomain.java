package br.com.fiap.estabelecimento_saude.entities.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class EstabelecimentoDomain {
	private UUID id;
	private String nome;
	private String email;
    private String cnes;
	private LocalDateTime dataCriacao;
	private LocalDateTime dataAtualizacao;
	private Boolean isAtivo;
	private EnderecoDomain dadosEndereco;
    private UUID idResponsavel;
}