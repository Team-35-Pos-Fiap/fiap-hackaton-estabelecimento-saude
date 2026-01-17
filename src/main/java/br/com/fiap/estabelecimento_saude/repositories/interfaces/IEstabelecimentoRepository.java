package br.com.fiap.estabelecimento_saude.repositories.interfaces;

import br.com.fiap.estabelecimento_saude.entities.db.EstabelecimentoEntity;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface IEstabelecimentoRepository {

    EstabelecimentoEntity recuperaDadosEstabelecimentoPorId(UUID id);
    EstabelecimentoEntity recuperaDadosEstabelecimentoInativoPorId(UUID id);
    EstabelecimentoEntity recuperaDadosEstabelecimentoAtivoPorId(UUID id);
    Page<EstabelecimentoEntity> recuperaDadosEstabelecimentos(final Integer pagina);
    void salvar(EstabelecimentoEntity estabelecimento);
    boolean emailJaCadastrado(String email);
}
