CREATE TABLE Venda (
    id_venda INT AUTO_INCREMENT PRIMARY KEY,
    data_venda DATETIME DEFAULT CURRENT_TIMESTAMP,
    valor_total DECIMAL(10,2) NOT NULL,
    id_cliente INT NOT NULL,

    FOREIGN KEY (id_cliente)
        REFERENCES Cliente(id_cliente)
);