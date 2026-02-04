package br.com.fiap.estabelecimento_saude.services.interfaces;

import br.com.fiap.estabelecimento_saude.entities.db.EstabelecimentoEntity;
import br.com.fiap.estabelecimento_saude.entities.record.request.EnderecoRecordRequest;
import br.com.fiap.estabelecimento_saude.entities.record.request.EstabelecimentoRecordRequest;
import br.com.fiap.estabelecimento_saude.entities.record.response.EstabelecimentoRecordPaginacaoResponse;
import br.com.fiap.estabelecimento_saude.entities.record.response.EstabelecimentoRecordResponse;
import br.com.fiap.estabelecimento_saude.entities.record.response.EstabelecimentoRecordResponseUsuario;
import br.com.fiap.estabelecimento_saude.entities.record.response.UsuarioDtoResponse;

import java.util.UUID;

public interface IEstabelecimentoService {
    EstabelecimentoRecordResponseUsuario buscarPorId(UUID id);
    EstabelecimentoRecordPaginacaoResponse buscarEstabelecimentos(final Integer pagina);
    void cadastrar(EstabelecimentoRecordRequest estabelecimento);
    void atualizarStatus(UUID id, boolean isAtivo);
    void salvar(EstabelecimentoEntity estabelecimento);
    void atualizarNome(UUID id, String nome);
    void atualizarEmail(UUID id, String email);
    void atualizarDadosEndereco(UUID id, EnderecoRecordRequest dadosEndereco);
    UsuarioDtoResponse validarSeUsuarioExiste(UUID idResponsavel);
}
