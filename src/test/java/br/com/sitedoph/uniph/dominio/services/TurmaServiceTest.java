package br.com.sitedoph.uniph.dominio.services;

import br.com.sitedoph.uniph.dominio.entidades.Turma;
import br.com.sitedoph.uniph.tests.BaseTest;
import br.com.six2six.fixturefactory.Fixture;
import org.junit.Test;

import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;
import static org.unitils.reflectionassert.ReflectionComparatorMode.IGNORE_DEFAULTS;

/**
 * Created by paler on 14/02/2016.
 */
public class TurmaServiceTest extends BaseTest {

    @Test
    public void deveFuncionarOService() {

        TurmaService service = new TurmaService();

        Turma turma = Fixture.from(Turma.class).gimme(VALID);

        Turma buscarPorDescricao = service.buscarPorDescricao(turma.getDescricao());

        if (buscarPorDescricao != null) {
            turma = buscarPorDescricao;
        }

        turma.setDisciplinas(null);
        turma.setAlunos(null);

        turma = service.salvarOuAtualizar(turma);

        assertReflectionEquals(turma, service.buscarPorId(turma.getId()), IGNORE_DEFAULTS);

        service.excluir(turma);

        service.buscarTodos().forEach(System.out::println);

    }
}