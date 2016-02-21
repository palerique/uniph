package br.com.sitedoph.uniph.dominio.repositorios;

import br.com.sitedoph.uniph.dominio.entidades.Turma;
import br.com.sitedoph.uniph.tests.BaseTest;
import br.com.six2six.fixturefactory.Fixture;
import org.junit.Test;

import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;
import static org.unitils.reflectionassert.ReflectionComparatorMode.IGNORE_DEFAULTS;

public class TurmaRepositorioTest extends BaseTest {

    @Test
    public void deveFuncionarORepositorio() {

        TurmaRepositorio repo = new TurmaRepositorio();

        Turma turma = Fixture.from(Turma.class).gimme(VALID);

        Turma buscarPorDescricao = repo.buscarPorDescricao(turma.getDescricao());

        if (buscarPorDescricao != null) {
            turma = buscarPorDescricao;
        }

        turma.setAlunos(null);
        turma.setDisciplinas(null);

        turma = repo.salvarOuAtualizar(turma);

        assertReflectionEquals(turma, repo.buscarPorId(turma.getId()), IGNORE_DEFAULTS);

        repo.excluir(turma);

        repo.buscarTodos().forEach(System.out::println);

    }

}
