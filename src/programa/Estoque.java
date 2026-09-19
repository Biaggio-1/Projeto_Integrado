package programa;
import  java.util.HashMap;

public class Estoque {

    public HashMap<String, Produto> produtos = new HashMap<>();
    //HashMap recebe String > nome do produto para o indice e a propria instancia da classe Produto

    public void addProdutos(Produto produto) {
        produtos.put(produto.getNome(), produto);
    }

    public String delProduto(String chave) {
        if (produtos.containsKey(chave)) {
            produtos.remove(chave);
            return "Produto removido com sucesso!";
        }
        return "Produto não encontrado!";
    }

    public Produto buscarProduto(String chave) {
        Produto produto = produtos.get(chave);
        return produto;
    }

    public int size(){
        return produtos.size();
    }

    public void listarNomes() {
        for (Produto produto : produtos.values()) {
            System.out.printf("nome: %s%n",produto.getNome());

        }
        
    }
    
    public static void limparTerminal(){
        for(int i = 0 ;i < 50; i++){
            System.out.println();
        }
    }
}