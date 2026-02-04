package br.com.fiap.estabelecimento_saude.clients;

import br.com.fiap.estabelecimento_saude.entities.record.response.UsuarioDtoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(
    name = "hackaton-usuarios",
    url = "${services.hackaton-usuarios:}"
)
public interface IUsuarioServiceClient {
    @GetMapping("/hackaton-usuarios/usuarios/{id}")
    UsuarioDtoResponse buscarUsuarioPorId(@PathVariable UUID id);
}

