package br.com.sitedoph.uniph.tests;

import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import org.junit.BeforeClass;

/**
 * Created by paler on 13/02/2016.
 */
public class BaseTest {
    protected static final String VALID = "valid";

    @BeforeClass
    public static void setUp() {
        FixtureFactoryLoader.loadTemplates("br.com.sitedoph.uniph.dominio.entidade.templateloader");
    }
}
