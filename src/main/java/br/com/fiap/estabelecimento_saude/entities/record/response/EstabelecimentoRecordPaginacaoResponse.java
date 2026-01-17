package br.com.fiap.estabelecimento_saude.entities.record.response;

import java.util.List;

public record EstabelecimentoRecordPaginacaoResponse(List<EstabelecimentoRecordResponse> estabelecimentos, PaginacaoRecordResponse dadosPaginacao) { }