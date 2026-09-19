package programa;
import java.lang.classfile.attribute.SourceDebugExtensionAttribute;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        Estoque estoque = new Estoque();
        Scanner inputDados = new Scanner(System.in);
        String entrada;
        String nome;
        int quantidade;
        boolean exe = true;


        while (exe) {
            System.out.println("*****-Menu-*****\n     Digite:\n(A)dicionar (D)eletar (P)rocurar (S)air");
            entrada = inputDados.nextLine().toLowerCase();
            switch (entrada) {
                case "a":
                    estoque.limparTerminal();
                    System.out.println("Nome do Produto: ");
                    nome = inputDados.nextLine();
                    if (nome == null || nome.isBlank()) {
                        estoque.limparTerminal();
                        System.out.println("Nome inválido");
                        continue;
                    }
                    System.out.println("Quantidade do Produto: ");
                    if (inputDados.hasNextInt()) {
                        quantidade = inputDados.nextInt();
                        inputDados.nextLine();
                        if (quantidade <= 0) {
                            estoque.limparTerminal();
                            System.out.println("Quantidade inválida");
                            continue;
                        }
                    } else {
                        estoque.limparTerminal();
                        System.out.println("Digite uma quantidade válida");
                        inputDados.nextLine();
                        continue;
                    }
                    Produto produto = new Produto(nome, quantidade);
                    estoque.addProdutos(produto);
                    estoque.limparTerminal();
                    System.out.println("Produto adicionado!");
                    break;

                case "d":
                    estoque.limparTerminal();
                    if (estoque.produtos.isEmpty()) {
                        estoque.limparTerminal();
                        System.out.println("O estoque está vazio.");
                        continue;
                    } else {
                        estoque.listarNomes();
                        System.out.println();
                        System.out.println("Digite o nome do produto para deletar:");
                        nome = inputDados.nextLine();

                        if (estoque.produtos.containsKey(nome)) {
                            estoque.limparTerminal();
                            System.out.println(estoque.delProduto(nome));
                            continue;
                        } else {
                            estoque.limparTerminal();
                            System.out.println("Produto não encontrado");
                            continue;
                        }
                    }

                case "s":
                    estoque.limparTerminal();
                    exe = false;
                    System.out.println("Encerrando...");
                    break;

                case "p":
                    estoque.limparTerminal();
                    if (estoque.produtos.isEmpty()) {
                        System.out.println("O estoque está vazio.");
                        continue;
                    }
                    boolean condicao = true;
                    while(condicao) {
                        estoque.limparTerminal();
                        System.out.println("1-Editar\n2-Sair");
                        if(inputDados.hasNextInt()) {
                            int opcao = inputDados.nextInt();
                            inputDados.nextLine();
                        switch (opcao) {

                            case 1:
                                estoque.limparTerminal();
                                estoque.listarNomes();
                                System.out.println();
                                System.out.println("Digite o nome do produto para edita-lo:");
                                String busca = inputDados.nextLine();
                                produto = estoque.buscarProduto(busca);


                                if (produto != null) {
                                    estoque.limparTerminal();
                                    System.out.print("Digite o novo nome do produto: ");
                                    nome = inputDados.nextLine();
                                    if (nome == null || nome.isBlank()) {
                                        estoque.limparTerminal();
                                        System.out.println("Nome inválido");
                                        break;
                                    }
                                    System.out.print("Quantidade do produto: ");
                                    if (inputDados.hasNextInt()) {
                                        quantidade = inputDados.nextInt();
                                        inputDados.nextLine();
                                        if (quantidade <= 0) {
                                            estoque.limparTerminal();
                                            System.out.println("Quantidade inválida");
                                            break;
                                        }
                                    } else {
                                        estoque.limparTerminal();
                                        System.out.println("Apenas dígitos.");
                                        break;
                                    }
                                    produto = estoque.produtos.remove(busca);
                                    produto.setNome(nome);
                                    produto.setQuantidade(quantidade);
                                    estoque.produtos.put(produto.getNome(), produto);
                                    estoque.limparTerminal();
                                    System.out.println("Produto editado com sucesso!");
                                    break;

                                }
                                estoque.limparTerminal();
                                System.out.println("Produto não encontrado");
                                break;

                            case 2:
                                estoque.limparTerminal();
                                System.out.println("Saindo...");
                                condicao = false;
                                break;


                            default:
                                estoque.limparTerminal();
                                System.out.println("Digite apenas 1 ou 2.");
                                break;


                        }

                    }else{
                            estoque.limparTerminal();
                            System.out.println("Digite apenas 1 ou 2.");
                            inputDados.nextLine();
                            break;
                        }
                }
                break;
                default:
                    estoque.limparTerminal();
                    System.out.println("Opção inválida");
                    break;
            }
        }
    }
}