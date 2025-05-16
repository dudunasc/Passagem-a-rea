package org.example.entities;

import java.time.LocalDateTime;

public class Reserva {
    private int id;
    private String passageiro;
    private String voo;
    private LocalDateTime dataReserva;

    public Reserva(int id, String passageiro, String voo, LocalDateTime dataReserva) {
        this.id = id;
        this.passageiro = passageiro;
        this.voo = voo;
        this.dataReserva = dataReserva;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassageiro() {
        return passageiro;
    }

    public void setPassageiro(String passageiro) {
        this.passageiro = passageiro;
    }

    public String getVoo() {
        return voo;
    }

    public void setVoo(String voo) {
        this.voo = voo;
    }

    public LocalDateTime getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(LocalDateTime dataReserva) {
        this.dataReserva = dataReserva;
    }
}
