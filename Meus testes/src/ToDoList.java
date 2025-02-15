import java.util.Scanner;
import java.util.ArrayList;

public class ToDoList {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> tarefas = new ArrayList<>();
        ArrayList<Boolean> concluindo = new ArrayList<>();

        boolean executando = true;

        while (executando) {
            int operacao = getOp(scanner);
            switch (operacao) {
                case 1:
                    addTask(tarefas, concluindo, scanner);
                    break;
                case 2:
                    listTasks(tarefas, concluindo);
                    break;
                case 3:
                    concluirTarefa(tarefas, concluindo, scanner);
                    break;
                case 4:
                    removeTask(tarefas, concluindo, scanner);
                    break;
                case 5:
                    System.out.println("Saindo...");
                    executando = false;
                    break;
                default:
                    System.out.println("Operação inválida");
            }
        }

        scanner.close();
    }

    public static int getOp (Scanner scanner) {
        System.out.println("\n===== Gerenciador de Tarefas =====");
        System.out.println("1 - Adicionar Tarefa");
        System.out.println("2 - Listar Tarefas");
        System.out.println("3 - Concluir Tarefa");
        System.out.println("4 - Remover Tarefa");
        System.out.println("5 - Sair");
        System.out.print("Escolha uma opção: ");

        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, digite um número válido.");
            scanner.next(); // Limpa entrada inválida
        }

        int opcao = scanner.nextInt();
        scanner.nextLine(); // Limpa buffer
        return opcao;
    }

    public static void addTask(ArrayList<String> tarefas, ArrayList<Boolean> concluido, Scanner scanner) {
        System.out.println("Digite o nome da tarefa que você deseja adicionar: ");
        String nomeTarefa = scanner.nextLine();
        tarefas.add(nomeTarefa);
        concluido.add(false);
        System.out.println("Tarefa adicionada com sucesso!");
    }

    public static void listTasks(ArrayList<String> tarefas, ArrayList<Boolean> concluido) {
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa adicionada.");
            return;
        }

        System.out.println("\n===== Lista de Tarefas =====");
        for (int i = 0; i < tarefas.size(); i++) {
            String status = concluido.get(i) ? "[Concluída]" : "[Pendente]";
            System.out.println((i + 1) + ". " + tarefas.get(i) + " " + status);
        }
    }

    public static void concluirTarefa(ArrayList<String> tarefas, ArrayList<Boolean> concluido, Scanner scanner) {
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa adicionada.");
            return;
        }

        listTasks(tarefas, concluido);
        System.out.println("Digite o número da tarefa que deseja concluir:");

        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, digite um número válido.");
            scanner.next();
        }

        int tarefaAconcluir = scanner.nextInt();
        scanner.nextLine(); // Limpa buffer

        if (tarefaAconcluir < 1 || tarefaAconcluir > tarefas.size()) {
            System.out.println("Número inválido! Tente novamente.");
        } else {
            concluido.set(tarefaAconcluir - 1, true);
            System.out.println("Tarefa concluída com sucesso!");
        }
    }

    public static void removeTask(ArrayList<String> tarefas, ArrayList<Boolean> concluido, Scanner scanner) {
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa adicionada.");
            return;
        }

        listTasks(tarefas, concluido);
        System.out.println("Digite o número da tarefa que deseja remover:");

        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, digite um número válido.");
            scanner.next();
        }

        int opc = scanner.nextInt();
        scanner.nextLine(); // Limpa buffer

        if (opc < 1 || opc > tarefas.size()) {
            System.out.println("Número inválido! Tente novamente.");
        } else {
            System.out.println("Tarefa \"" + tarefas.get(opc - 1) + "\" removida!");
            tarefas.remove(opc - 1);
            concluido.remove(opc - 1);
        }
    }
}
