package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AlunoTest {

    @Test
    public void NaoDeveAlterarMatriculaSemTer11Digitos() {
        Aluno aluno = new Aluno(1, "Luís", 21, "20304010005", "01020087498");
        Assertions.assertThrows(RuntimeException.class, () -> aluno.setMatricula("20304005"));
    }

    @Test
    public void NaoDeveAlterarMatriculaSeConterCaracterEspecial() {
        Aluno aluno = new Aluno(1, "Luís", 21, "20304010005", "01020087498");
        Assertions.assertThrows(RuntimeException.class, () -> aluno.setMatricula("20304010@0#$"));
    }

}
