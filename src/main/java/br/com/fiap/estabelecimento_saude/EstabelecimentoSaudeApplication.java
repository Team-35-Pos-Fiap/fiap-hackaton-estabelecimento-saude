package br.com.fiap.estabelecimento_saude;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EstabelecimentoSaudeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstabelecimentoSaudeApplication.class, args);
	}

}
