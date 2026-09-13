package programa;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        Estoque estoque = new Estoque();
        Scanner inputDados = new Scanner(System.in);
        String entrada;
        String nome;
        int quantidade;

        while (true) {
            System.out.println("*****-Menu-*****\n     Digite:\n(A)dicionar (L)istar (D)eletar (P)rocurar (S)air");
            entrada = inputDados.nextLine().toLowerCase();

            if (entrada.equals("a")) {

                System.out.println("Nome do Produto: ");
                nome = inputDados.nextLine();
                if(nome == null || nome.isBlank()){
                    System.out.println("Nome inválido");
                    continue;
                }
                System.out.println("Quantidade do Produto: ");
                if (inputDados.hasNextInt()) {
                    quantidade = inputDados.nextInt();
                    inputDados.nextLine();
                    if(quantidade <=0){
                        System.out.println("Quantidade inválida");
                        continue;
                    }
                } else {
                    System.out.println("Digite uma quantidade válida");
                    inputDados.nextLine();
                    continue;
                }
                Produto produto = new Produto(nome, quantidade);
                estoque.addProdutos(produto);

            } else if (entrada.equals("l")) {
                System.out.printf("itens: %d", estoque.size());
                System.out.println();
                if (estoque.produtos.isEmpty()) {
                    System.out.println("O estoque está vazio.");
                } else {
                    estoque.listar();
                }
                System.out.println();
                continue;
            } else if (entrada.equals("d")) {
                if (estoque.produtos.isEmpty()) {
                    System.out.println("O estoque está vazio.");
                    continue;
                } else {
                    estoque.listarNomes();
                    System.out.println();
                    System.out.println("Digite o nome do produto para deletar:");
                    nome = inputDados.nextLine();
                    if (estoque.produtos.containsKey(nome)) {
                        System.out.println(estoque.delProduto(nome));
                        continue;
                    } else {
                        System.out.println("Produto não encontrado");
                        continue;
                    }
                }

            } else if (entrada.equals("s")) {
                System.out.println("Bye!");
                break;

            } else if (entrada.equals("p")) {
                if (estoque.produtos.isEmpty()) {
                    System.out.println("O estoque está vazio.");
                    continue;
                } else {
                    estoque.listarNomes();
                    System.out.println();
                }
                System.out.println("Digite o nome do produto para mais informações:");
                String busca = inputDados.nextLine();
                Produto produto = estoque.buscarProduto(busca);
                if (produto != null) {
                    while (true) {
                        System.out.println("Nome: " + produto.getNome());
                        System.out.println("Quantidade: " + produto.getQuantidade());
                        System.out.println();
                        System.out.print("Digite o nome do produto ou (S)air");
                        System.out.println();
                        busca = inputDados.nextLine().toLowerCase();
                        produto = estoque.buscarProduto(busca);
                        if (busca.equals("s")) {
                            break;
                        }
                        else if(produto != null) {
                            while (true) {
                                System.out.print("Digite o novo nome do produto: ");
                                nome = inputDados.nextLine();
                                System.out.print("Quantidade do produto: ");
                                if (inputDados.hasNextInt()) {
                                    quantidade = inputDados.nextInt();
                                    inputDados.nextLine();
                                } else {
                                    System.out.println("Digite uma quantidade válida");
                                    continue;
                                }
                                produto = estoque.produtos.remove(busca);
                                produto.setNome(nome);
                                produto.setQuantidade(quantidade);
                                estoque.produtos.put(nome,produto);
                                break;


                            }

                        }

                        }
                    }else{
                        System.out.println("Produto não encontrado");
                    }
                } else {
                    System.out.println("Opção inválida");
                    continue;
                }
            }
        }

    }

