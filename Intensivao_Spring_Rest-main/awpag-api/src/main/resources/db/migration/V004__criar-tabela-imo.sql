CREATE TABLE imo (
                     id BIGINT PRIMARY KEY AUTO_INCREMENT,
                     nome VARCHAR(60) NOT NULL,
                     loa FLOAT NOT NULL,
                     boca FLOAT NOT NULL,
                     pontal FLOAT NOT NULL,
                     calado FLOAT NOT NULL,
                     imo_numero  VARCHAR(255) NOT NULL UNIQUE
);