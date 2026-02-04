package br.com.fiap.estabelecimento_saude.controllers;

import br.com.fiap.estabelecimento_saude.controllers.response.MensagemResponse;
import br.com.fiap.estabelecimento_saude.controllers.response.SucessoResponse;
import br.com.fiap.estabelecimento_saude.entities.record.request.EmailRecordRequest;
import br.com.fiap.estabelecimento_saude.entities.record.request.EnderecoRecordRequest;
import br.com.fiap.estabelecimento_saude.entities.record.request.NomeRecordRequest;
import br.com.fiap.estabelecimento_saude.entities.record.request.EstabelecimentoRecordRequest;
import br.com.fiap.estabelecimento_saude.entities.record.response.EstabelecimentoRecordPaginacaoResponse;
import br.com.fiap.estabelecimento_saude.entities.record.response.EstabelecimentoRecordResponse;
import br.com.fiap.estabelecimento_saude.entities.record.response.EstabelecimentoRecordResponseUsuario;
import br.com.fiap.estabelecimento_saude.services.interfaces.IEstabelecimentoService;
import br.com.fiap.estabelecimento_saude.utils.MensagensUtil;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/estabelecimentos")
@Slf4j
public class EstabelecimentoController {

	private final IEstabelecimentoService estabelecimentoService;

	public EstabelecimentoController(IEstabelecimentoService estabelecimentoService) {
		this.estabelecimentoService = estabelecimentoService;
	}

	@PostMapping
	public ResponseEntity<Void> cadastrar(@Valid @RequestBody @NotNull EstabelecimentoRecordRequest estabelecimento) {
		log.info("cadastrar():dados do Estabelecimento {}", estabelecimento);
		
		estabelecimentoService.cadastrar(estabelecimento);
		
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@DeleteMapping("/{id}/status")
	public ResponseEntity<MensagemResponse> inativar(@Valid @PathVariable @NotNull UUID id) {
		log.info("inativar():id {}", id);

		estabelecimentoService.atualizarStatus(id, false);

		MensagemResponse sucessoResponse = new SucessoResponse(MensagensUtil.recuperarMensagem(MensagensUtil.SUCESSO_INATIVACAO_ESTABELECIMENTO));
		return ResponseEntity.ok(sucessoResponse);
	}
	
	@PatchMapping("/{id}/status")
	public ResponseEntity<MensagemResponse> reativar(@Valid @PathVariable @NotNull UUID id) {
		log.info("reativar():id {}", id);

		estabelecimentoService.atualizarStatus(id, true);

		MensagemResponse sucessoResponse = new SucessoResponse(MensagensUtil.recuperarMensagem(MensagensUtil.SUCESSO_REATIVACAO_ESTABELECIMENTO));
		return ResponseEntity.ok(sucessoResponse);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EstabelecimentoRecordResponseUsuario> buscarEstabelecimentoPorId(@PathVariable @NotNull @Valid UUID id) {
		log.info("buscarEstabelecimentoPorId():id {}", id);
		
		return ResponseEntity.ok().body(estabelecimentoService.buscarPorId(id));
	}
	
	@GetMapping
	public ResponseEntity<EstabelecimentoRecordPaginacaoResponse> buscarEstabelecimentos(@RequestParam(defaultValue = "1") final Integer pagina) {
		log.info("buscarEstabelecimentos() - pagina {}", pagina);

		return ResponseEntity.ok().body(estabelecimentoService.buscarEstabelecimentos(pagina));
	}

	@PatchMapping("/{id}/endereco")
	public ResponseEntity<Void> atualizarEndereco(@Valid @PathVariable @NotNull UUID id, @Valid @RequestBody @NotNull EnderecoRecordRequest dadosEndereco) {
		estabelecimentoService.atualizarDadosEndereco(id, dadosEndereco);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); 
	}

	@PatchMapping("/{id}/nome")
	public ResponseEntity<Void> atualizarNome(@Valid @PathVariable @NotNull UUID id, @Valid @RequestBody @NotNull NomeRecordRequest dados) {
		estabelecimentoService.atualizarNome(id, dados.nome());

		return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); 
	}

	@PatchMapping("/{id}/email")
	public ResponseEntity<Void> atualizarEmail(@Valid @PathVariable @NotNull UUID id, @Valid @RequestBody @NotNull EmailRecordRequest dados) {
		estabelecimentoService.atualizarEmail(id, dados.email());

		return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); 
	}

}