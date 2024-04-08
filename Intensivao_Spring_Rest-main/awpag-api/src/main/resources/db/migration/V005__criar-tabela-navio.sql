CREATE TABLE navio (
                       id BIGINT PRIMARY KEY AUTO_INCREMENT,
                       agente_solicitante VARCHAR(60) NOT NULL,
                       imo_id BIGINT UNIQUE,
                       FOREIGN KEY (imo_id) REFERENCES imo(id)
);
