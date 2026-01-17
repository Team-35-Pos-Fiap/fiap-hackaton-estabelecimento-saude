-- ESTABELECIMENTO 1
insert into endereco (id, cidade, bairro, estado, endereco, numero, complemento, sem_numero, cep)
values (RANDOM_UUID(), 'Niterói', 'Fonseca', 'Rio de Janeiro', 'Rua Conselheiro Otaviano', '150', 'Próximo ao posto', 0, '24020150');

insert into estabelecimento (id, nome, email, cnes, ativo, data_criacao, data_atualizacao, id_endereco)
values (RANDOM_UUID(), 'UBS Fonseca', 'ubs.fonseca@saude.gov.br', 7890123, 1, current_timestamp, null,
    (SELECT id FROM endereco WHERE cidade = 'Niterói' AND endereco = 'Rua Conselheiro Otaviano'));

-- ESTABELECIMENTO 2
insert into endereco (id, cidade, bairro, estado, endereco, numero, complemento, sem_numero, cep)
values (RANDOM_UUID(), 'Belford Roxo', 'Centro', 'Rio de Janeiro', 'Avenida dos Trabalhadores', '420', 'Sala 1', 0, '26180000');

insert into estabelecimento (id, nome, email, cnes, ativo, data_criacao, data_atualizacao, id_endereco)
values (RANDOM_UUID(), 'UPA Centro Belford Roxo', 'upa.belfordroxo@saude.gov.br', 8901234, 1, current_timestamp, null,
    (SELECT id FROM endereco WHERE cidade = 'Belford Roxo' AND endereco = 'Avenida dos Trabalhadores'));

-- ESTABELECIMENTO 3
insert into endereco (id, cidade, bairro, estado, endereco, numero, complemento, sem_numero, cep)
values (RANDOM_UUID(), 'Nova Iguaçu', 'Austin', 'Rio de Janeiro', 'Rua Pará', '77', '', 0, '26060000');

insert into estabelecimento (id, nome, email, cnes, ativo, data_criacao, data_atualizacao, id_endereco)
values (RANDOM_UUID(), 'ESF Austin', 'esf.austin@saude.gov.br', 9012345, 1, current_timestamp, null,
    (SELECT id FROM endereco WHERE cidade = 'Nova Iguaçu' AND endereco = 'Rua Pará'));

-- ESTABELECIMENTO 4
insert into endereco (id, cidade, bairro, estado, endereco, numero, complemento, sem_numero, cep)
values (RANDOM_UUID(), 'Duque de Caxias', 'Parque Lafaiete', 'Rio de Janeiro', 'Travessa das Oliveiras', '12', 'Próximo à praça', 0, '25045000');

insert into estabelecimento (id, nome, email, cnes, ativo, data_criacao, data_atualizacao, id_endereco)
values (RANDOM_UUID(), 'Centro de Saúde Parque Lafaiete', 'cs.parquelf@saude.gov.br', 9123456, 1, current_timestamp, null,
    (SELECT id FROM endereco WHERE cidade = 'Duque de Caxias' AND endereco = 'Travessa das Oliveiras'));

-- ESTABELECIMENTO 5
insert into endereco (id, cidade, bairro, estado, endereco, numero, complemento, sem_numero, cep)
values (RANDOM_UUID(), 'Petrópolis', 'Itaipava', 'Rio de Janeiro', 'Estrada União e Indústria', '1500', 'Em frente ao condomínio', 0, '25720000');

insert into estabelecimento (id, nome, email, cnes, ativo, data_criacao, data_atualizacao, id_endereco)
values (RANDOM_UUID(), 'UBS Itaipava', 'ubs.itaipava@saude.gov.br', 9234567, 1, current_timestamp, null,
    (SELECT id FROM endereco WHERE cidade = 'Petrópolis' AND endereco = 'Estrada União e Indústria'));

-- ESTABELECIMENTO 6
insert into endereco (id, cidade, bairro, estado, endereco, numero, complemento, sem_numero, cep)
values (RANDOM_UUID(), 'Itaboraí', 'Centro', 'Rio de Janeiro', 'Avenida Amaral Peixoto', '420', 'Próximo à rodoviária', 0, '24800000');

insert into estabelecimento (id, nome, email, cnes, ativo, data_criacao, data_atualizacao, id_endereco)
values (RANDOM_UUID(), 'UPA Centro Itaboraí', 'upa.itaborai@saude.gov.br', 9345678, 1, current_timestamp, null,
    (SELECT id FROM endereco WHERE cidade = 'Itaboraí' AND endereco = 'Avenida Amaral Peixoto'));

-- ESTABELECIMENTO 7
insert into endereco (id, cidade, bairro, estado, endereco, numero, complemento, sem_numero, cep)
values (RANDOM_UUID(), 'Mesquita', 'Mesquita Centro', 'Rio de Janeiro', 'Rua Coronel Cardoso', '210', '', 0, '26550000');

insert into estabelecimento (id, nome, email, cnes, ativo, data_criacao, data_atualizacao, id_endereco)
values (RANDOM_UUID(), 'ESF Mesquita Centro', 'esf.mesquita@saude.gov.br', 9456789, 1, current_timestamp, null,
    (SELECT id FROM endereco WHERE cidade = 'Mesquita' AND endereco = 'Rua Coronel Cardoso'));

-- ESTABELECIMENTO 8
insert into endereco (id, cidade, bairro, estado, endereco, numero, complemento, sem_numero, cep)
values (RANDOM_UUID(), 'Rio de Janeiro', 'Tijuca', 'Rio de Janeiro', 'Rua Conde de Bonfim', '1020', 'Bloco C', 0, '20520000');

insert into estabelecimento (id, nome, email, cnes, ativo, data_criacao, data_atualizacao, id_endereco)
values (RANDOM_UUID(), 'UBS Tijuca Norte', 'ubs.tijuca@saude.gov.br', 9567890, 1, current_timestamp, null,
    (SELECT id FROM endereco WHERE cidade = 'Rio de Janeiro' AND endereco = 'Rua Conde de Bonfim'));

-- ESTABELECIMENTO 9
insert into endereco (id, cidade, bairro, estado, endereco, numero, complemento, sem_numero, cep)
values (RANDOM_UUID(), 'Itaguaí', 'Praia', 'Rio de Janeiro', 'Avenida Beira Mar', '45', 'Anexo ao posto', 0, '23820000');

insert into estabelecimento (id, nome, email, cnes, ativo, data_criacao, data_atualizacao, id_endereco)
values (RANDOM_UUID(), 'Centro de Saúde Beira Mar', 'cs.beiramar@saude.gov.br', 9678901, 1, current_timestamp, null,
    (SELECT id FROM endereco WHERE cidade = 'Itaguaí' AND endereco = 'Avenida Beira Mar'));

-- ESTABELECIMENTO 10
insert into endereco (id, cidade, bairro, estado, endereco, numero, complemento, sem_numero, cep)
values (RANDOM_UUID(), 'Maricá', 'Centro', 'Rio de Janeiro', 'Rua das Flores', '250', 'Próximo à prefeitura', 0, '24900000');

insert into estabelecimento (id, nome, email, cnes, ativo, data_criacao, data_atualizacao, id_endereco)
values (RANDOM_UUID(), 'UBS Centro Maricá', 'ubs.marica@saude.gov.br', 9789012, 1, current_timestamp, null,
    (SELECT id FROM endereco WHERE cidade = 'Maricá' AND endereco = 'Rua das Flores'));

-- ESTABELECIMENTO 11
insert into endereco (id, cidade, bairro, estado, endereco, numero, complemento, sem_numero, cep)
values (RANDOM_UUID(), 'Cabo Frio', 'Peró', 'Rio de Janeiro', 'Avenida do Canal', '1200', 'Em frente ao posto', 0, '28950000');

insert into estabelecimento (id, nome, email, cnes, ativo, data_criacao, data_atualizacao, id_endereco)
values (RANDOM_UUID(), 'UPA Peró Cabo Frio', 'upa.pero@saude.gov.br', 9890123, 1, current_timestamp, null,
    (SELECT id FROM endereco WHERE cidade = 'Cabo Frio' AND endereco = 'Avenida do Canal'));

-- ESTABELECIMENTO 12
insert into endereco (id, cidade, bairro, estado, endereco, numero, complemento, sem_numero, cep)
values (RANDOM_UUID(), 'Angra dos Reis', 'Centro', 'Rio de Janeiro', 'Praça da Matriz', '45', 'Anexo ao mercado', 0, '23900000');

insert into estabelecimento (id, nome, email, cnes, ativo, data_criacao, data_atualizacao, id_endereco)
values (RANDOM_UUID(), 'ESF Praça Angra', 'esf.praca@saude.gov.br', 9901234, 1, current_timestamp, null,
    (SELECT id FROM endereco WHERE cidade = 'Angra dos Reis' AND endereco = 'Praça da Matriz'));

-- ESTABELECIMENTO 13
insert into endereco (id, cidade, bairro, estado, endereco, numero, complemento, sem_numero, cep)
values (RANDOM_UUID(), 'Barra Mansa', 'Centro', 'Rio de Janeiro', 'Rua Coronel Pime', '98', 'Sala 3', 0, '27320000');

insert into estabelecimento (id, nome, email, cnes, ativo, data_criacao, data_atualizacao, id_endereco)
values (RANDOM_UUID(), 'UBS Centro Barra Mansa', 'ubs.barramansa@saude.gov.br', 9912345, 1, current_timestamp, null,
    (SELECT id FROM endereco WHERE cidade = 'Barra Mansa' AND endereco = 'Rua Coronel Pime'));

-- ESTABELECIMENTO 14
insert into endereco (id, cidade, bairro, estado, endereco, numero, complemento, sem_numero, cep)
values (RANDOM_UUID(), 'Queimados', 'Centro', 'Rio de Janeiro', 'Avenida Getúlio Vargas', '600', '', 0, '26310000');

insert into estabelecimento (id, nome, email, cnes, ativo, data_criacao, data_atualizacao, id_endereco)
values (RANDOM_UUID(), 'Centro de Saúde Queimados', 'cs.queimados@saude.gov.br', 9923456, 1, current_timestamp, null,
    (SELECT id FROM endereco WHERE cidade = 'Queimados' AND endereco = 'Avenida Getúlio Vargas'));

-- ESTABELECIMENTO 15
insert into endereco (id, cidade, bairro, estado, endereco, numero, complemento, sem_numero, cep)
values (RANDOM_UUID(), 'Miguel Pereira', 'Vila Esperança', 'Rio de Janeiro', 'Rua das Acácias', '22', 'Próximo ao campo', 0, '26980000');

insert into estabelecimento (id, nome, email, cnes, ativo, data_criacao, data_atualizacao, id_endereco)
values (RANDOM_UUID(), 'ESF Vila Esperança', 'esf.vilaesperanca@saude.gov.br', 9934567, 1, current_timestamp, null,
    (SELECT id FROM endereco WHERE cidade = 'Miguel Pereira' AND endereco = 'Rua das Acácias'));