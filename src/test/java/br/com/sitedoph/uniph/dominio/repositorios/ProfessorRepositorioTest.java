package br.com.sitedoph.uniph.dominio.repositorios;

import br.com.sitedoph.uniph.dominio.entidade.Professor;
import br.com.sitedoph.uniph.tests.BaseTest;
import br.com.six2six.fixturefactory.Fixture;
import org.junit.Test;

import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

public class ProfessorRepositorioTest extends BaseTest {

    @Test
    public void deveFuncionarORepositorio() {

        ProfessorRepositorio repo = new ProfessorRepositorio();

        Professor professor = Fixture.from(Professor.class).gimme(VALID);

        Professor buscarPorCPF = repo.buscarPorCPF(professor.getCpf());

        if (buscarPorCPF != null) {
            professor = buscarPorCPF;
        }

        professor = repo.salvarOuAtualizar(professor);

        assertReflectionEquals(professor, repo.buscarPorId(professor.getId()));

        repo.excluir(professor);

        for (Professor professor1 : repo.buscarTodos()) {
            System.out.println(professor1);
        }

    }

}
