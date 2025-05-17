package org.example.entities;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.Date;

public class Voo {
    private int id;
    private String origem;
    private String destino;
    private LocalDateTime dataHora;
    private Aviao aviao;

    public Voo(int id, String origem, String destino, LocalDateTime dataHora, Aviao aviao) {
        this.id = id;
        this.origem = origem;
        this.destino = destino;
        this.dataHora = dataHora;
        this.aviao = aviao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Aviao getAviao() {
        return aviao;
    }

    public void setAviao(Aviao aviao) {
        this.aviao = aviao;
    }
    public void setDataHora(int ano, int mes, int dia, int hora, int minuto) {
        try {
            this.dataHora = LocalDateTime.of(ano, mes, dia, hora, minuto);
        } catch (DateTimeException e) {
            System.out.println("Erro ao definir a data e hora do voo: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return String.format("%-10s %-20s %-20s %-20s%n",
                this.id,
                this.origem,
                this.destino,
                this.dataHora.toString());
    }
}