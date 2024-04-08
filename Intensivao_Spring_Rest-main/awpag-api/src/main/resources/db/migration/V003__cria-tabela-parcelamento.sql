CREATE TABLE parcelamento (
    id BIGINT NOT NULL AUTO_INCREMENT,
    cliente_id BIGINT NOT NULL,
    descricao VARCHAR(20) NOT NULL,
    valor_total DECIMAL(10,2) NOT NULL,
    quantidade_parcelas INT NOT NULL,
    data_criacao DATETIME NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (cliente_id) REFERENCES cliente (id)
);