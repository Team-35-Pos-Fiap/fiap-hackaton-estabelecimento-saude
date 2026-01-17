
package br.com.fiap.estabelecimento_saude.services;

import br.com.fiap.estabelecimento_saude.entities.db.EnderecoEntity;
import br.com.fiap.estabelecimento_saude.entities.record.request.EnderecoRecordRequest;
import br.com.fiap.estabelecimento_saude.repositories.interfaces.IEnderecoRepository;
import br.com.fiap.estabelecimento_saude.services.interfaces.IEnderecoService;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService implements IEnderecoService {

	private final IEnderecoRepository enderecoRepository;

	public EnderecoService(IEnderecoRepository enderecoRepository) {
		this.enderecoRepository = enderecoRepository;
	}

	@Override
	public void atualizarEndereco(EnderecoEntity enderecoAtual, EnderecoRecordRequest dados) {
		
		enderecoRepository.salvar(trataDadosEndereco(enderecoAtual, dados));
	}
	
	private EnderecoEntity trataDadosEndereco(EnderecoEntity endereco, EnderecoRecordRequest enderecoRecord) {
		endereco.atualizarDados(enderecoRecord.endereco(), 
							 	enderecoRecord.cidade(), 
							 	enderecoRecord.bairro(), 
							 	enderecoRecord.estado(), 
							 	enderecoRecord.numero(), 
							 	enderecoRecord.cep(), 
							 	enderecoRecord.complemento(), 
							 	enderecoRecord.semNumero());
		
		return endereco;
	}
}