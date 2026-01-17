package br.com.fiap.estabelecimento_saude.repositories.exceptions;

public class EstabelecimentoNaoEncontradoException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public EstabelecimentoNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
}
