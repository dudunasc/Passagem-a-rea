package org.example.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PassageiroTest {

    @Test
    void testCpfValido() {
        Passageiro p1 = new Passageiro(1, "João", "123.456.789-09", "joao@email.com");
        assertTrue(p1.cpfValido());

        Passageiro p2 = new Passageiro(2, "Maria", "111.111.111-11", "maria@email.com");
        assertFalse(p2.cpfValido());

        Passageiro p3 = new Passageiro(3, "Pedro", "12345678900", "pedro@email.com");
        assertFalse(p3.cpfValido());
    }

    @Test
    void testEmailValido() {
        Passageiro p1 = new Passageiro(1, "João", "123.456.789-09", "joao@email.com");
        Assertions.assertTrue(p1.emailValido());

        Passageiro p2 = new Passageiro(2, "Maria", "123.456.789-09", "mariaemail.com");
        Assertions.assertFalse(p2.emailValido());

        Passageiro p3 = new Passageiro(3, "Pedro", "123.456.789-09", "pedro@email");
        Assertions.assertFalse(p3.emailValido());

    }
}