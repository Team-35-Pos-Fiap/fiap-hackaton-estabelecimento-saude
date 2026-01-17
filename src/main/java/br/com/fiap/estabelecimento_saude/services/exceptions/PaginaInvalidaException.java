package br.com.fiap.estabelecimento_saude.services.exceptions;


import br.com.fiap.estabelecimento_saude.utils.MensagensUtil;

public class PaginaInvalidaException extends RuntimeException {

    private static final long serialVersionUID = 1L;

	public PaginaInvalidaException() {
        super(MensagensUtil.recuperarMensagem(MensagensUtil.ERRO_PAGINA_INVALIDA));
    }
}