package br.com.sitedoph.uniph.dominio.repositorios;

import br.com.sitedoph.uniph.dominio.entidades.Aluno;
import br.com.sitedoph.uniph.tests.BaseTest;
import br.com.six2six.fixturefactory.Fixture;
import org.junit.Test;

import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

public class AlunoRepositorioTest extends BaseTest {

    @Test
    public void deveFuncionarORepositorio() {

        AlunoRepositorio repo = new AlunoRepositorio();

        Aluno aluno = Fixture.from(Aluno.class).gimme(VALID);

        Aluno buscarPorCPF = repo.buscarPorCPF(aluno.getCpf());

        if (buscarPorCPF != null) {
            aluno = buscarPorCPF;
        }

        aluno = repo.salvarOuAtualizar(aluno);

        assertReflectionEquals(aluno, repo.buscarPorId(aluno.getId()));

        repo.excluir(aluno);

        repo.buscarTodos().forEach(System.out::println);

    }


}
