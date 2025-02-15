import java.util.Scanner;

public class Calculadora {
    public static void main (String[]  args) {
        Scanner scanner = new Scanner(System.in);

        int numero1 = getNumero(scanner);
        int numero2 = getNumero(scanner);
        String sinal = getSinal(scanner);

        if (sinal.equals("/")) {
            if (numero2 == 0){
                System.out.println("Digite um numero Valido");
                numero2 = getNumero(scanner);
            } else {
                System.out.println("Resultado: " + (numero1 / numero2));
            }
        }
        else if (sinal.equals("*")) {
            System.out.println("Resultado: " + (numero1 * numero2));
        }

        else if (sinal.equals("-")) {
            System.out.println("Resultado: " + (numero1 - numero2));
        }

        else if (sinal.equals("+")){
            System.out.println("Resultado: " + ((numero1 + numero2)));
        }

        else {
            System.out.println("Sinal INVALIDO");
        }
    scanner.close();
    }

    public static int getNumero (Scanner scanner) {
        System.out.println("Digite um numero");
        return scanner.nextInt();
    }

    public static String getSinal (Scanner scanner) {
        System.out.println("Digite o sinal (/, +, -, *)");
        return scanner.next();
    }
}