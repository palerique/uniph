package br.com.sitedoph.uniph.dominio.services;

import br.com.sitedoph.uniph.dominio.entidades.Disciplina;
import br.com.sitedoph.uniph.dominio.entidades.Professor;
import br.com.sitedoph.uniph.tests.BaseTest;
import br.com.six2six.fixturefactory.Fixture;
import org.junit.Test;

import java.util.List;

import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;
import static org.unitils.reflectionassert.ReflectionComparatorMode.IGNORE_DEFAULTS;

/**
 * Created by paler on 14/02/2016.
 */
public class DisciplinaServiceTest extends BaseTest {

    @Test
    public void deveFuncionarOService() {

        DisciplinaService service = new DisciplinaService();
        ProfessorService serviceProfessor = new ProfessorService();

        Disciplina disciplina = Fixture.from(Disciplina.class).gimme(VALID);

        List<Professor> list = serviceProfessor.buscarTodos();

        if (list.isEmpty()) {
            disciplina.setProfessor(null);
        } else {
            disciplina.setProfessor(list.get(0));
        }

        Disciplina buscarPorDescricao = service.buscarPorDescricao(disciplina.getDescricao());

        if (buscarPorDescricao != null) {
            disciplina = buscarPorDescricao;
        }

        disciplina = service.salvarOuAtualizar(disciplina);

        assertReflectionEquals(disciplina, service.buscarPorId(disciplina.getId()), IGNORE_DEFAULTS);

        service.excluir(disciplina);

        service.buscarTodos().forEach(System.out::println);

    }
}