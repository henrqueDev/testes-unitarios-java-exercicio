package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AlunoServiceTest {

    @InjectMocks
    private AlunoService alunoService;

    @Mock
    private AlunoDAO alunoDAO;

    @Test
    public void NaoDeveInserirAlunoComMatriculaJahExistente() {
        Aluno aluno1 = new Aluno(1, "Luís", 21, "20304010005", "123");
        Mockito.doReturn(true).when(alunoDAO).existeMatriculaAtiva("20304010005");
        Assertions.assertThrows(IllegalArgumentException.class, () -> alunoService.inserirAluno(aluno1));
    }

    @Test
    public void NaoDeveInserirAlunoComCPFJahExistente() {
        Aluno aluno1 = new Aluno(1, "Luís", 21, "20304010005", "01020087498");
        Mockito.doReturn(true).when(alunoDAO).existeAlunoComCPF("01020087498");
        Assertions.assertThrows(IllegalArgumentException.class, () -> alunoService.inserirAluno(aluno1));
    }

    @Test
    void NaoDeveInserirAlunoComIdadeMenosA18Anos() {
        Aluno aluno1 = new Aluno(1, "Luís", 11, "20304010005", "01020087498");
        Assertions.assertThrows(IllegalArgumentException.class, () -> alunoService.inserirAluno(aluno1));
    }
}
