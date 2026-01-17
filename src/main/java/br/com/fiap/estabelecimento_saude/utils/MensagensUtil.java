package br.com.fiap.estabelecimento_saude.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class MensagensUtil {
	private static MessageSource messageSource;
	
	private static Locale locale = Locale.of("pt", "BR");
	
	public static final String ERRO_INTERNAL_SERVER_ERROR = "exception.internal_server_error";
	public static final String ERRO_ESTABELECIMENTO_NAO_ENCONTRADO = "exception.estabelecimento_nao_encontrado";
	public static final String ERRO_ESTABELECIMENTOS_NAO_ENCONTRADOS = "exception.estabelecimentos_nao_encontrados";
	public static final String ERRO_PARAMETRO_INVALIDO = "exception.erro_parametro_invalido";
	public static final String ERRO_PAGINA_INVALIDA = "exception.pagina_invalida";
	public static final String ERRO_EMAIL_DUPLICADO = "exception.email_duplicado";

	public static final String SUCESSO_INATIVACAO_ESTABELECIMENTO = "sucesso.inativacao_estabelecimento";
	public static final String SUCESSO_REATIVACAO_ESTABELECIMENTO = "sucesso.reativacao_estabelecimento";

	@Autowired
	public void setMessageSource(MessageSource messageSource) {
		MensagensUtil.messageSource = messageSource;
	}
	
	public static String recuperarMensagem(String mensagem, Object ... parametros) {
		return messageSource.getMessage(mensagem, parametros, locale);
	}
}