package programa;

public class Produto {

    private String nome;
    private int quantidade;
    private String categoria;

    public Produto(String nome, int quantidade, String categoria){
        this.nome = nome;
        this.quantidade = quantidade;
        this.categoria = categoria;
    }
    public String getNome(){return nome;}
    public String getCategoria(){return categoria;}
    public int getQuantidade(){return quantidade;}

    public void setNome(String nome){
        if(nome == null || nome.isBlank()){
            System.out.println("Nome inválido");
        }
        this.nome = nome;
    }
    public void setQuantidade(int qtd){
        if(qtd <= 0){
            System.out.println("Quantidade inválida");
        }
        this.quantidade = qtd;
    }
    public void setCategoria(String categoria){
        if(categoria == null || categoria.isBlank()){
            System.out.println("Categoria inválida");
        }
        this.categoria = categoria;
    }
}
