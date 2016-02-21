package br.com.sitedoph.uniph.dominio.entidades;

import br.com.sitedoph.uniph.infraestrutura.validacao.util.ValidadorUtil;
import org.junit.Assert;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

public class UsuarioTest {

    @Test
    public void deveValidar() {

        Validator validador = ValidadorUtil.getValidator();

        Usuario xpto = new Usuario();

        Set<ConstraintViolation<Usuario>> violacoes =
                validador.validate(xpto);

        violacoes.forEach(System.out::println);

        Assert.assertEquals(4, violacoes.size());
    }

}
