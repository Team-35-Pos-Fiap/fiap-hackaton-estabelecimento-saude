package br.com.fiap.estabelecimento_saude.mappers;

import br.com.fiap.estabelecimento_saude.entities.db.EstabelecimentoEntity;
import br.com.fiap.estabelecimento_saude.entities.domain.EstabelecimentoDomain;
import br.com.fiap.estabelecimento_saude.entities.record.request.EstabelecimentoRecordRequest;
import br.com.fiap.estabelecimento_saude.entities.record.response.*;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public abstract class EstabelecimentoMapper {

	// record -> domain -> entity
	
	// 1 - record -> domain
	public static EstabelecimentoDomain toEstabelecimento(EstabelecimentoRecordRequest estabelecimento) {
		return new EstabelecimentoDomain(null,
                estabelecimento.nome(),
                estabelecimento.email(),
                estabelecimento.cnes(),
                LocalDateTime.now(),
                null,
                true,
                EnderecoMapper.toDadosEndereco(estabelecimento.dadosEndereco()),
                estabelecimento.idResponsavel());
	}

	// 2 - domain -> entity
	
	public static EstabelecimentoEntity toEstabelecimento(EstabelecimentoDomain estabelecimento) {
		return new EstabelecimentoEntity(
                estabelecimento.getId(),
                estabelecimento.getNome(),
                estabelecimento.getEmail(),
                estabelecimento.getCnes(),
                estabelecimento.getDataCriacao(),
                estabelecimento.getDataAtualizacao(),
                estabelecimento.getIsAtivo(),
                EnderecoMapper.toDadosEndereco(estabelecimento.getDadosEndereco()),
                estabelecimento.getIdResponsavel());
	}
	
	// entity -> domain -> record
	
	// 3 - entity -> domain
	
	public static EstabelecimentoDomain toEstabelecimento(EstabelecimentoEntity estabelecimento) {
		return new EstabelecimentoDomain(estabelecimento.getId(),
                estabelecimento.getNome(),
                estabelecimento.getEmail(),
                estabelecimento.getCnes(),
                estabelecimento.getDataCriacao(),
                estabelecimento.getDataAtualizacao(),
                estabelecimento.getIsAtivo(),
                EnderecoMapper.toDadosEndereco(estabelecimento.getDadosEndereco()),
                estabelecimento.getIdResponsavel());
	}
	
	// 4 - domain -> record
	
	public static EstabelecimentoRecordResponseUsuario toEstabelecimentoRecord(EstabelecimentoDomain estabelecimento, UsuarioDtoResponse usuario) {
		return new EstabelecimentoRecordResponseUsuario(estabelecimento.getId(),
            estabelecimento.getNome(),
            estabelecimento.getEmail(),
            estabelecimento.getIsAtivo(),
            EnderecoMapper.toDadosEnderecoRecord(estabelecimento.getDadosEndereco()),
            usuario);
	}

    public static EstabelecimentoRecordResponse toEstabelecimentoRecord(EstabelecimentoDomain estabelecimento) {
        return new EstabelecimentoRecordResponse(estabelecimento.getId(),
                estabelecimento.getNome(),
                estabelecimento.getEmail(),
                estabelecimento.getIsAtivo(),
                EnderecoMapper.toDadosEnderecoRecord(estabelecimento.getDadosEndereco()),
                estabelecimento.getIdResponsavel());
    }

	public static EstabelecimentoRecordPaginacaoResponse toEstabelecimento(Page<EstabelecimentoEntity> dados) {
		List<EstabelecimentoRecordResponse> estabelecimentos = dados.toList()
													.stream()
													.map(u -> EstabelecimentoMapper.toEstabelecimento(u))
													.map(u -> EstabelecimentoMapper.toEstabelecimentoRecord(u))
													.collect(Collectors.toList());
		
		PaginacaoRecordResponse dadosPaginacao = new PaginacaoRecordResponse(dados.getNumber() + 1, dados.getTotalPages(), Long.valueOf(dados.getTotalElements()).intValue());
		
		return new EstabelecimentoRecordPaginacaoResponse(estabelecimentos, dadosPaginacao);
	}
}