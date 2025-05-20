package org.example;

import java.util.Scanner;
import org.example.entities.*;
import java.util.*;
import java.time.LocalDateTime;

public class Main {
    private static final ArrayList<Passageiro> passageiros = new ArrayList<>();
    private static final ArrayList<Aviao> avioes = new ArrayList<>();
    private static final ArrayList<Voo> voos = new ArrayList<>();
    private static final ArrayList<Reserva> reservas = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("=== Menu ===");
            System.out.println("1 - Cadastrar passageiro");
            System.out.println("2 - Listar passageiros");
            System.out.println("3 - Cadastrar avião");
            System.out.println("4 - Listar aviões");
            System.out.println("5 - Cadastrar voo");
            System.out.println("6 - Listar voos");
            System.out.println("7 - Reservar passagem");
            System.out.println("8 - Listar reservas");
            System.out.println("9 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarPassageiro();
                    break;
                case 2:
                    listarPassageiros();
                    break;
                case 3:
                    cadastrarAviao();
                    break;
                case 4:
                    listarAvioes();
                    break;
                case 5:
                    cadastrarVoo();
                    break;
                case 6:
                    listarVoos();
                    break;
                case 7:
                    reservarPassagem();
                    break;
                case 8:
                    listarReservas();
                    break;
                case 9:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
            System.out.println();
        } while (opcao != 9);
        scanner.close();
    }

    private static void cadastrarPassageiro() {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF (123.456.789-10): ");
        String cpf = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        Passageiro p = new Passageiro(id, nome, cpf, email);
        if (!p.cpfValido()) {
            System.out.println("CPF inválido!");
            return;
        }
        if (!p.emailValido()) {
            System.out.println("Email inválido!");
            return;
        }
        passageiros.add(p);
        System.out.println("Passageiro cadastrado!");
    }

    private static void listarPassageiros() {
        if (passageiros.isEmpty()) {
            System.out.println("Nenhum passageiro cadastrado.");
            return;
        }
        for (Passageiro p : passageiros) {
            System.out.println("ID: " + p.getId() + ", Nome: " + p.getNome() + ", CPF: " + p.getCpf() + ", Email: " + p.getEmail());
        }
    }

    private static void cadastrarAviao() {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();
        System.out.print("Capacidade: ");
        int capacidade = scanner.nextInt();
        scanner.nextLine();
        Aviao aviao = new Aviao(id, modelo, capacidade);
        avioes.add(aviao);
        System.out.println("Avião cadastrado!");
    }

    private static void listarAvioes() {
        if (avioes.isEmpty()) {
            System.out.println("Nenhum avião cadastrado.");
            return;
        }
        for (Aviao a : avioes) {
            System.out.println("ID: " + a.getId() + ", Modelo: " + a.getModelo() + ", Capacidade: " + a.getCapacidade());
        }
    }

    private static void cadastrarVoo() {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Origem: ");
        String origem = scanner.nextLine();
        System.out.print("Destino: ");
        String destino = scanner.nextLine();
        System.out.print("Ano: ");
        int ano = scanner.nextInt();
        System.out.print("Mês: ");
        int mes = scanner.nextInt();
        System.out.print("Dia: ");
        int dia = scanner.nextInt();
        System.out.print("Hora: ");
        int hora = scanner.nextInt();
        System.out.print("Minuto: ");
        int minuto = scanner.nextInt();
        scanner.nextLine();
        System.out.print("ID do avião: ");
        int idAviao = scanner.nextInt();
        scanner.nextLine();
        Aviao aviao = avioes.stream().filter(a -> a.getId() == idAviao).findFirst().orElse(null);
        if (aviao == null) {
            System.out.println("Avião não encontrado!");
            return;
        }
        Voo voo = new Voo(id, origem, destino, LocalDateTime.of(ano, mes, dia, hora, minuto), aviao);
        voos.add(voo);
        System.out.println("Voo cadastrado!");
    }

    private static void listarVoos() {
        if (voos.isEmpty()) {
            System.out.println("Nenhum voo cadastrado.");
            return;
        }
        for (Voo v : voos) {
            System.out.println("ID: " + v.getId() + ", Origem: " + v.getOrigem() + ", Destino: " + v.getDestino() + ", DataHora: " + v.getDataHora() + ", Avião: " + v.getAviao().getModelo());
        }
    }

    private static void reservarPassagem() {
        System.out.print("ID do passageiro: ");
        int idPassageiro = scanner.nextInt();
        scanner.nextLine();
        Passageiro passageiro = passageiros.stream().filter(p -> p.getId() == idPassageiro).findFirst().orElse(null);
        if (passageiro == null) {
            System.out.println("Passageiro não encontrado!");
            return;
        }
        System.out.print("ID do voo: ");
        int idVoo = scanner.nextInt();
        scanner.nextLine();
        Voo voo = voos.stream().filter(v -> v.getId() == idVoo).findFirst().orElse(null);
        if (voo == null) {
            System.out.println("Voo não encontrado!");
            return;
        }
        if (voo.getVagasDisponiveis() <= 0) {
            System.out.println("Não há vagas disponíveis neste voo!");
            return;
        }
        Reserva reserva = new Reserva(reservas.size() + 1, passageiro, voo, LocalDateTime.now());
        reservas.add(reserva);
        voo.adicionarReserva(passageiro);
        System.out.println("Reserva realizada com sucesso!");
    }

    private static void listarReservas() {
        if (reservas.isEmpty()) {
            System.out.println("Nenhuma reserva cadastrada.");
            return;
        }
        for (Reserva r : reservas) {
            System.out.println("ID: " + r.getId() + ", Passageiro: " + r.getPassageiro().getNome() + ", Voo: " + r.getVoo().getId() + ", Data: " + r.getDataReserva());
        }
    }
}