import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Agenda clinica = new Agenda();
        Scanner scanner = new Scanner(System.in);
        int op;

        do {
            System.out.println("\nEscolha uma opção: ");
            System.out.println("1. Cadastrar consulta.");
            System.out.println("2. Editar consulta.");
            System.out.println("3. Imprimir uma consulta.");
            System.out.println("4. Imprimir todas as consultas.");
            System.out.println("0. Sair.");
            System.out.print("Opção: ");
            op = scanner.nextInt();
            scanner.nextLine(); // consumir quebra de linha

            switch(op){
                case 1:
                    Consulta nova = new Consulta();
                    System.out.print("Nome do paciente: ");
                    nova.getPaciente().setNome(scanner.nextLine());
                    System.out.print("Nome do especialista: ");
                    nova.getEspecialista().setNome(scanner.nextLine());
                    System.out.print("Horário: ");
                    nova.setHorario(scanner.nextLine());
                    clinica.cadastrarAgenda(nova);
                    System.out.println("Consulta cadastrada com sucesso!");
                    break;

                case 2:
                    System.out.print("Digite o código da consulta que deseja editar: ");
                    int codEditar = scanner.nextInt();
                    scanner.nextLine(); // consumir quebra de linha
                    Consulta editar = new Consulta();
                    System.out.print("Novo nome do paciente: ");
                    editar.getPaciente().setNome(scanner.nextLine());
                    System.out.print("Novo nome do especialista: ");
                    editar.getEspecialista().setNome(scanner.nextLine());
                    System.out.print("Novo horário: ");
                    editar.setHorario(scanner.nextLine());
                    clinica.editarConsulta(codEditar, editar);
                    System.out.println("Consulta editada com sucesso!");
                    break;

                case 3:
                    System.out.print("Digite o código da consulta a ser impressa: ");
                    int codConsulta = scanner.nextInt();
                    clinica.imprimirConsulta(codConsulta);
                    break;

                case 4:
                    clinica.imprimirTodos();
                    break;

                case 0:
                    System.out.println("Saindo do sistema.");
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while(op != 0);

        scanner.close();
    }
}