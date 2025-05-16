package org.example.entities;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.Date;

public class Voo {
    private int id;
    private String origem;
    private String destino;
    private LocalDateTime dataHora;
    private String aviao;

    public Voo(int id, String origem, String destino, LocalDateTime dataHora, String aviao) {
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

    public String getAviao() {
        return aviao;
    }

    public void setAviao(String aviao) {
        this.aviao = aviao;
    }
}