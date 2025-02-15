import java.util.Scanner;

//Crie um programa que peça a idade do usuário e informe se ele é criança (0-12 anos), adolescente (13-17 anos), adulto (18-64 anos) ou idoso (65+ anos).

public class VerificadorDeIdade {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        int idade = getIdade(scanner);

        if (idade <= 12) {
            System.out.println("Você é uma criança!");
        } else if (idade <= 17) {
            System.out.println("Você é um adolecente!");
        } else if (idade <= 64) {
            System.out.println("Você é um adulto!");
        } else {
            System.out.println("Você é um idoso!");
        }

    scanner.close();
    }

    public static int getIdade(Scanner scanner) {
        System.out.println("Digite sua idade: ");
        return scanner.nextInt();
    }
}
