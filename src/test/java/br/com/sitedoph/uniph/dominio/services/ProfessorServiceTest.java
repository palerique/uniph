package br.com.sitedoph.uniph.dominio.services;

import br.com.sitedoph.uniph.dominio.entidades.Professor;
import br.com.sitedoph.uniph.tests.BaseTest;
import br.com.six2six.fixturefactory.Fixture;
import org.junit.Test;

import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

/**
 * Created by paler on 14/02/2016.
 */
public class ProfessorServiceTest extends BaseTest {

    @Test
    public void deveFuncionarOService() {

        ProfessorService service = new ProfessorService();

        Professor professor = Fixture.from(Professor.class).gimme(VALID);

        Professor buscarPorLoginESenha = service.buscarPorCPF(professor.getCpf());

        if (buscarPorLoginESenha != null) {
            professor = buscarPorLoginESenha;
        }

        professor = service.salvarOuAtualizar(professor);

        assertReflectionEquals(professor, service.buscarPorId(professor.getId()));

        service.excluir(professor);

        service.buscarTodos().forEach(System.out::println);

    }
}