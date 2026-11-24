CREATE TABLE Item_Venda (
    id_venda INT NOT NULL,
    id_produto INT NOT NULL,
    quantidade INT NOT NULL,
    valor_unitario DECIMAL(10,2) NOT NULL,

    PRIMARY KEY (id_venda, id_produto),

    FOREIGN KEY (id_venda)
        REFERENCES Venda(id_venda),

    FOREIGN KEY (id_produto)
        REFERENCES Produto(id_produto)
);