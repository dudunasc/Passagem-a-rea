package org.example.repositories;

import org.example.entities.Aviao;

import java.util.ArrayList;
import java.util.List;

public class AviaoRepository {
    private List<Aviao> avioes = new ArrayList<>();

    public List<Aviao> getAvioes(){
        return avioes;
    }

    public Aviao getById(int id){
        Aviao aviao = avioes.stream().filter(p -> p.getId() == id).findFirst().get();
        return aviao;
    }

    public boolean exists(int id) {
        return avioes.stream().anyMatch(p -> p.getId() == id);
    }

    public void append(Aviao aviao) {
        avioes.add(aviao);
    }

    public void remove(int id) {
        avioes.removeIf(product -> product.getId() == id);
    }

    public void update(int id, Aviao aviao) {
        Aviao aviaoInDb = avioes.stream().filter(p -> p.getId() == id).findFirst().get();

        aviaoInDb.setCapacidade(aviao.getCapacidade());
        aviaoInDb.setFabricante(aviao.getFabricante());
        aviaoInDb.setModelo(aviao.getModelo());
    }
}
