import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Chamado> chamados = new ArrayList<>();

        int proximoId = 1;
        int opcao;

        do {

            System.out.println("\n=== SISTEMA DE CHAMADOS ===");
            System.out.println("1 - Listar chamados");
            System.out.println("2 - Buscar chamado");
            System.out.println("3 - Criar chamado");
            System.out.println("4 - Alterar status");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:

                    System.out.println("\n=== LISTA DE CHAMADOS ===");

                    if (chamados.isEmpty()) {
                        System.out.println("Nenhum chamado cadastrado.");
                    } else {

                        for (Chamado chamado : chamados) {

                            System.out.println("ID: " + chamado.getId());
                            System.out.println("Título: " + chamado.getTitulo());
                            System.out.println("Descrição: " + chamado.getDescricao());
                            System.out.println("Status: " + chamado.getStatus());
                            System.out.println("-------------------------");
                        }
                    }

                    break;

                case 2:

                    System.out.print("\nDigite o ID do chamado: ");
                    int idBusca = scanner.nextInt();
                    scanner.nextLine();

                    boolean encontrado = false;

                    for (Chamado chamado : chamados) {

                        if (chamado.getId() == idBusca) {

                            System.out.println("\n=== CHAMADO ENCONTRADO ===");
                            System.out.println("ID: " + chamado.getId());
                            System.out.println("Título: " + chamado.getTitulo());
                            System.out.println("Descrição: " + chamado.getDescricao());
                            System.out.println("Status: " + chamado.getStatus());

                            encontrado = true;
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("Chamado não encontrado.");
                    }

                    break;

                case 3:

                    System.out.println("\n=== NOVO CHAMADO ===");

                    System.out.print("Digite o título: ");
                    String titulo = scanner.nextLine();

                    System.out.print("Digite a descrição: ");
                    String descricao = scanner.nextLine();

                    Chamado novoChamado = new Chamado(
                        proximoId,
                        titulo,
                        descricao
                    );

                    chamados.add(novoChamado);

                    System.out.println("Chamado criado com sucesso!");
                    System.out.println("ID do chamado: " + proximoId);

                    proximoId++;

                    break;

                case 4:

                    System.out.print("\nDigite o ID do chamado: ");
                    int idAlterar = scanner.nextInt();
                    scanner.nextLine();

                    boolean chamadoEncontrado = false;

                    for (Chamado chamado : chamados) {

                        if (chamado.getId() == idAlterar) {

                            System.out.println("\n1 - Aberto");
                            System.out.println("2 - Em andamento");
                            System.out.println("3 - Encerrado");

                            System.out.print("Escolha o novo status: ");
                            int novoStatus = scanner.nextInt();
                            scanner.nextLine();

                            if (novoStatus == 1) {
                                chamado.alterarStatus("Aberto");
                            } else if (novoStatus == 2) {
                                chamado.alterarStatus("Em andamento");
                            } else if (novoStatus == 3) {
                                chamado.alterarStatus("Encerrado");
                            } else {
                                System.out.println("Status inválido.");
                                break;
                            }

                            System.out.println("Status alterado com sucesso!");

                            chamadoEncontrado = true;
                            break;
                        }
                    }

                    if (!chamadoEncontrado) {
                        System.out.println("Chamado não encontrado.");
                    }

                    break;

                case 5:

                    System.out.println("\nSistema encerrado.");
                    break;

                default:

                    System.out.println("Opção inválida.");
            }

        } while (opcao != 5);

        scanner.close();
    }
}