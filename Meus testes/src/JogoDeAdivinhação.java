import java.util.Scanner;
import java.util.Random;

public class JogoDeAdivinhação {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int numero = getNumero(scanner);
        int numeroAleatorio = random.nextInt(100) + 1;
        int tentativas = 1;

        while (numero != numeroAleatorio) {
            System.out.println("Numero errado! Digite outro: ");
            System.out.println(posicao(numero, numeroAleatorio));
            numero = getNumero(scanner);
            tentativas++;
        }
        System.out.println("Você precisou de " + tentativas + " tentativas");
        scanner.close();
    }


    public static int getNumero(Scanner scanner) {
        System.out.println("Digite um numero: ");
        return scanner.nextInt();
    }

    public static String posicao (int numero, int numeroCerto) {
        if (numero > numeroCerto) {
            return "Número maior!";
        } else {
            return "Número menor!";
        }
    }

}
