package br.com.sitedoph.uniph.dominio.services;

import br.com.sitedoph.uniph.dominio.entidades.Aluno;
import br.com.sitedoph.uniph.tests.BaseTest;
import br.com.six2six.fixturefactory.Fixture;
import org.junit.Test;

import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

/**
 * Created by paler on 14/02/2016.
 */
public class AlunoServiceTest extends BaseTest {

    @Test
    public void deveFuncionarOService() {

        AlunoService service = new AlunoService();

        Aluno aluno = Fixture.from(Aluno.class).gimme(VALID);

        Aluno buscarPorLoginESenha = service.buscarPorCPF(aluno.getCpf());

        if (buscarPorLoginESenha != null) {
            aluno = buscarPorLoginESenha;
        }

        aluno = service.salvarOuAtualizar(aluno);

        assertReflectionEquals(aluno, service.buscarPorId(aluno.getId()));

        service.excluir(aluno);

        for (Aluno aluno1 : service.buscarTodos()) {
            System.out.println(aluno1);
        }

    }
}