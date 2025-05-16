package org.example.repositories;

import org.example.entities.Passageiro;
import java.util.ArrayList;
import java.util.List;

public class PassageiroRepository {
    private List<Passageiro> passageiros = new ArrayList<>();

    public void adicionarPassageiros(Passageiro passageiro){
        passageiros.add(passageiro);
    }
    public List<Passageiro> listarPassageiros(){
        return passageiros;
    }
}
