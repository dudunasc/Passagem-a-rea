package org.example.application;

import org.example.entities.Aviao;
import org.example.entities.Voo;
import org.example.repositories.AviaoRepository;

public class AviaoApplication {

    private AviaoRepository aviaoRepository;

    public AviaoApplication(AviaoRepository aviaoRepository) {
        this.aviaoRepository = aviaoRepository;
    }

    public void cadastrarAviao(Aviao aviao) {
        if (aviao.getCapacidade() <= 0) {
            throw new IllegalArgumentException("Capacidade do avião deve ser maior que zero.");
        }

        if (aviaoRepository.exists(aviao.getId())) {
            throw new IllegalArgumentException("Já existe um avião com este ID.");
        }

        aviaoRepository.append(aviao);
    }

    public Aviao buscarPorId(int id) {
        if (!aviaoRepository.exists(id)) {
            throw new IllegalArgumentException("Avião não encontrado.");
        }

        return aviaoRepository.getById(id);
    }

    public void atualizarAviao(int id, Aviao novoAviao) {
        if (!aviaoRepository.exists(id)) {
            throw new IllegalArgumentException("Avião não encontrado.");
        }

        if (novoAviao.getCapacidade() <= 0) {
            throw new IllegalArgumentException("Capacidade do avião deve ser maior que zero.");
        }

        aviaoRepository.update(id, novoAviao);
    }

    public void removerAviao(int id) {
        if (!aviaoRepository.exists(id)) {
            throw new IllegalArgumentException("Avião não encontrado.");
        }

        aviaoRepository.remove(id);
    }

    public void associarVoo(int idAviao, Voo voo) {
        if (!aviaoRepository.exists(idAviao)) {
            throw new IllegalArgumentException("Avião não encontrado.");
        }

        Aviao aviao = aviaoRepository.getById(idAviao);
        aviao.adicionarVoo(voo);
        aviaoRepository.update(idAviao, aviao);
    }

}
