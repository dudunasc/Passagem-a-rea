package org.example.entities;

import java.util.ArrayList;
import java.util.List;

public class Aviao {
    private int id;
    private String modelo;
    private int capacidade;
    private String fabricante;

    public Aviao(int id, String modelo, int capacidade, String fabricante) {
        this.id = id;
        this.modelo = modelo;
        this.capacidade = capacidade;
        this.fabricante = fabricante;
    }

    public Aviao(int id, String modelo, int capacidade) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    private final List<Voo> voos = new ArrayList<>();

    public List<Voo> getVoos(){
        return voos;
    }

    public void adicionarVoo(Voo voo) {
        voos.add(voo);
    }
}
