package programa;

import java.util.Scanner;

public class Menu {

    int quantidade;
    String nome;
    Scanner inputDados = new Scanner(System.in);

    public void adiconar() {
        while (true) {
            System.out.println("Nome do Produto: ");
            nome = inputDados.nextLine();
            System.out.println("Quantidade do Produto: ");
            if (inputDados.hasNextInt()) {
                quantidade = inputDados.nextInt();
                inputDados.nextLine();
            } else {
                System.out.println("Digite uma quantidade válida");
                continue;

            }
        }
    }
}
