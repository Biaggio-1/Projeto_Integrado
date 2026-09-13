package programa;

public class Produto {

    private String nome;
    private int quantidade;

    public Produto(String nome, int quantidade){
        this.nome = nome;
        this.quantidade = quantidade;
    }
    public String getNome(){return nome;}

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
}
