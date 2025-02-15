import java.util.Scanner;

public class GerenciadorBancario {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        float saldo = 0;
        boolean fim = false;

        while (fim == false) {
            int op = getOp(scanner);
            if (op == 1) {
                float valor = getValor(scanner, "Qunato você gostaria de depositar");
                saldo += valor;
            }
            else if (op == 2) {
                float valor = getValor(scanner, "Qunato você gostaria de sacar");
                saldo -= valor;
            }
            else if (op == 3) {
                System.out.println("Seu saldo é: " + saldo);
            }
            else {
                System.out.println("Obrigado por usar o Comercio Eletrônico");
                fim = true;
            }
        }
        scanner.close();
    }

    public static int getOp (Scanner scanner) {
        System.out.println("1 - Depositar");
        System.out.println("2 - Sacar");
        System.out.println("3 - Ver saldo");
        System.out.println("4 - Sair");
        System.out.println("Escolha uma opção: ");
        return scanner.nextInt();
    }

    public static float getValor (Scanner scanner, String texto) {
        System.out.println(texto);
        return scanner.nextFloat();
    }


}
