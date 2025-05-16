package org.example.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PassageiroTest {
    Passageiro passageiroEmailValido;
    Passageiro passageiroEmailInvalido;

    @BeforeEach
    public void setUp() {
        passageiroEmailValido = new Passageiro(1, "Lucas", "529.982.247-25", "lucas@email.com");
        passageiroEmailInvalido = new Passageiro(2, "Julia", "529.982.247-25", "juliaemail.com");
    }

    @Test
    public void verificarSeEmailValidoOuInvalido() {
        Assertions.assertTrue(passageiroEmailValido.emailValido(), "O e-mail deve ser considerado válido");
        Assertions.assertFalse(passageiroEmailInvalido.emailValido(), "O e-mail deve ser considerado inválido");
    }
}