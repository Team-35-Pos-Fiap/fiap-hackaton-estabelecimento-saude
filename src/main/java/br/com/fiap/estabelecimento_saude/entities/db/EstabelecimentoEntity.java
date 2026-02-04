package br.com.fiap.estabelecimento_saude.entities.db;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "estabelecimento")
public class EstabelecimentoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	private String nome;

    @Column(unique = true)
	private String email;

    @Column(unique = true)
    private String cnes;
	
	@Column(name = "data_criacao", nullable = false)
	private LocalDateTime dataCriacao;
	
	@Column(name = "data_atualizacao", nullable = true)
	private LocalDateTime dataAtualizacao;
	
	@Column(name = "ativo", columnDefinition = "tinyint")
	private Boolean isAtivo;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "id_endereco")
	private EnderecoEntity dadosEndereco;
	
	public void inativar() {
		this.isAtivo = false;
		this.dataAtualizacao = getDataAtual();
	}
	
	public void reativar() {
		this.isAtivo = true;
		this.dataAtualizacao = getDataAtual();
	}
	
	public void atualizarNome(String nome) {
		this.nome = nome;
		this.dataAtualizacao = getDataAtual();
	}
	
	public void atualizarEmail(String email) {
		this.email = email;
		this.dataAtualizacao = getDataAtual();
	}

	public void atualizarEndereco(String endereco, String cidade, String bairro,
								  String estado, Integer numero, String cep, String complemento, Boolean semNumero) {
		this.dadosEndereco.atualizarDados(endereco, cidade, bairro, estado, numero, cep, complemento, semNumero);
		this.dataAtualizacao = getDataAtual();
	}

	private LocalDateTime getDataAtual() {
		return LocalDateTime.now();
	}

    private UUID idResponsavel;
}