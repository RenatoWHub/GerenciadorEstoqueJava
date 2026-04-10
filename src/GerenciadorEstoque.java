import java.sql.SQLOutput;
import java.util.Scanner;

public class GerenciadorEstoque{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        String[] produto = {"Monitor", "Mouse", "Teclado", "Fan", "Estabilizador"};
        int[] quantidade = {8, 4, 10, 9, 3};
        String saldo;
        int opcao;



        do{
            System.out.println("-------GERENCIADOR DE ESTOQUE--------------");
            System.out.println("1. Listar Produto");
            System.out.println("2. Registar Venda");
            System.out.println("3. Sair");
            System.out.println("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            if(opcao == 1){
                System.out.println("------RELATORIO DE ESTOQUE----------");
                for (int i = 0; i < produto.length; i++) {
                    boolean estoqueCritico = quantidade[i] < 5;
                String status = estoqueCritico ? "[ALERTA: ESTOQUE BAIXO]" : "[OK]";
                    System.out.println(i + " - " + produto[i] + ": " + quantidade[i] + " unidades " + status);

                }
            } else if (opcao == 2) {
                System.out.println("Digite o nome do produto para registrar a venda");
                String busca = scanner.nextLine();
                boolean encontrado = false;
                for (int i = 0; i < produto.length; i++) {
                    if (busca.equalsIgnoreCase(produto[i])){
                        encontrado = true;
                        System.out.println("Quantidade para vender: ");
                        int qtdVenda = scanner.nextInt();
                        if (qtdVenda <= quantidade[i]){
                            quantidade[i] -= qtdVenda;
                            System.out.println("Venda realizada");
                        } else {
                            System.out.println("Saldo Insuficiente");
                        }
                        break;
                    }
                }
                if (!encontrado){
                    System.out.println("Produto não encontrado");
                }
            }
        } while (opcao == 3);
    }

}