package br.com.sitedoph.uniph.dominio.repositorios;

import br.com.sitedoph.uniph.dominio.entidades.Disciplina;
import br.com.sitedoph.uniph.tests.BaseTest;
import br.com.six2six.fixturefactory.Fixture;
import org.junit.Test;

import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

public class DisciplinaRepositorioTest extends BaseTest {

    @Test
    public void deveFuncionarORepositorio() {

        DisciplinaRepositorio repo = new DisciplinaRepositorio();
        ProfessorRepositorio repoProfessor = new ProfessorRepositorio();

        Disciplina disciplina = Fixture.from(Disciplina.class).gimme(VALID);

        disciplina.setProfessor(repoProfessor.buscarTodos().get(0));

        Disciplina buscarPorDescricao = repo.buscarPorDescricao(disciplina.getDescricao());

        if (buscarPorDescricao != null) {
            disciplina = buscarPorDescricao;
        }

        disciplina = repo.salvarOuAtualizar(disciplina);

        assertReflectionEquals(disciplina, repo.buscarPorId(disciplina.getId()));

        repo.excluir(disciplina);

        for (Disciplina disciplina1 : repo.buscarTodos()) {
            System.out.println(disciplina1);
        }

    }

}
