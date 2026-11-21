CREATE TABLE Produto (
    id_produto INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    valor DECIMAL(10,2) NOT NULL,
    quantidade_estoque INT NOT NULL DEFAULT 0,
    id_categoria INT NOT NULL,

    FOREIGN KEY (id_categoria)
        REFERENCES Categoria(id_categoria)
);