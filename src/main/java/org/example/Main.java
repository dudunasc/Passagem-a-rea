package org.example;

import org.example.entities.Passageiro;
import org.example.repositories.PassageiroRepository;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PassageiroRepository repository = new PassageiroRepository();
        int opcao;

        do {
            System.out.println("=== Menu ===");
            System.out.println("1 - Cadastrar passageiro");
            System.out.println("2 - Listar passageiros");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();

                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    Passageiro passageiro = new Passageiro(id, nome, cpf, email);

                    if (!passageiro.cpfValido()) {
                        System.out.println("CPF inválido! Passageiro não cadastrado.");
                    } else if (!passageiro.emailValido()) {
                        System.out.println("Email inválido! Passageiro não cadastrado.");
                    } else {
                        repository.adicionarPassageiros(passageiro);
                        System.out.println("Passageiro cadastrado com sucesso!");
                    }
                    break;

                case 2:
                    List<Passageiro> lista = repository.listarPassageiros();
                    if (lista.isEmpty()) {
                        System.out.println("Nenhum passageiro cadastrado.");
                    } else {
                        System.out.println("=== Lista de Passageiros ===");
                        for (Passageiro p : lista) {
                            System.out.println("ID: " + p.getId() + ", Nome: " + p.getNome() + ", CPF: " + p.getCpf() + ", Email: " + p.getEmail());
                        }
                    }
                    break;

                case 3:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

            System.out.println();

        } while (opcao != 3);

        scanner.close();
    }
}
