package org.example.entities;

public class Passageiro {
    private int id;
    private String nome;
    private String cpf;
    private String email;

    public Passageiro(int id, String nome, String cpf, String email) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean cpfValido() {
        String cpfNumeros = this.cpf.replaceAll("[^\\d]", "");

        if (cpfNumeros.length() != 11 || cpfNumeros.matches("(\\d)\\1{10}")) {
            return false;
        }

        try {
            int soma = 0;
            for (int i = 0; i < 9; i++) {
                soma += Character.getNumericValue(cpfNumeros.charAt(i)) * (10 - i);
            }

            int primeiroDigito = 11 - (soma % 11);
            if (primeiroDigito >= 10) primeiroDigito = 0;

            soma = 0;
            for (int i = 0; i < 10; i++) {
                soma += Character.getNumericValue(cpfNumeros.charAt(i)) * (11 - i);
            }

            int segundoDigito = 11 - (soma % 11);
            if (segundoDigito >= 10) segundoDigito = 0;

            return primeiroDigito == Character.getNumericValue(cpfNumeros.charAt(9)) &&
                    segundoDigito == Character.getNumericValue(cpfNumeros.charAt(10));
        } catch (Exception e) {
            return false;
        }
    }

    public boolean emailValido() {
        String regex = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
        return this.email != null && this.email.matches(regex);
    }

}
