package br.com.fiap.estabelecimento_saude.controllers.response;

public abstract class MensagemResponse {

    private String mensagem;

    public MensagemResponse(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }
}
