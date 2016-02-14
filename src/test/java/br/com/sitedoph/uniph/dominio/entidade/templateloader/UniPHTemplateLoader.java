package br.com.sitedoph.uniph.dominio.entidade.templateloader;

import br.com.sitedoph.uniph.dominio.entidade.*;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by paler on 13/02/2016.
 */
public class UniPHTemplateLoader implements TemplateLoader {

    private static final Object[] NOMES = {"Daivdson Batista", "José Roberto", "Marcos de Jesus", "Enildo Lima", "Juvenal Batista", "Francisco Ferreira", "Douglas Souza", "Marcos Lima", "Danilo Pereira"};
    private static final long MILLIS = Calendar.getInstance().getTimeInMillis();
    private static final Object[] LOGINS = {"nerd" + MILLIS, "geek" + MILLIS, "demolidor" + MILLIS};
    private static final Object[] CPFS = {"027.782.366-86", "857.278.411-00", "468.907.742-80"};
    private static final Object[] EMAILS = {"${login}@gmail.com", "${login}@hotmail.com", "${login}@yahoo.com"};
    private static final Object[] CVS = {"professor formado em Harvard", "Estudou no MIT", "Foi aluno do ITA"};
    private static final Object[] TELEFONES = {"81818181", "99999999", "91919191"};
    private static final Object[] DESCS_TURMA = {"Turma A", "Turma B", "Turma C"};
    private static final Object[] DIAS_DA_SEMANA = {"Segunda, quarta e sexta", "Terça e quinta", "Sábados"};
    private static final Object[] DESCS_DISC = {"Java", "OO", "UML"};
    private static final Object[] CARGAS = {"8 horas", "12 horas", "32 horas"};

    private static final String PASSWORD = "1234567";
    private static final String VALID = "valid";

    @Override
    public void load() {

        Fixture.of(Usuario.class).addTemplate(VALID, new Rule() {{
            add("nomeCompleto", random(NOMES));
            add("login", random(LOGINS));
            add("email", random(EMAILS));
            add("senha", PASSWORD);
        }});

        Fixture.of(Aluno.class).addTemplate(VALID, new Rule() {{
            add("nomeCompleto", random(NOMES));
            add("cpf", random(CPFS));
            add("rg", random(CPFS));
            add("dataDeNascimento", randomDate("2011-04-15", "2011-11-07", new SimpleDateFormat("yyyy-MM-dd")));
            add("telefone", random(TELEFONES));
            add("email", MILLIS + "@gmail.com");
            add("sexo", Sexo.MASCULINO);
        }});

        Fixture.of(Professor.class).addTemplate(VALID, new Rule() {{
            add("nomeCompleto", random(NOMES));
            add("cpf", random(CPFS));
            add("telefone", random(TELEFONES));
            add("email", MILLIS + "@gmail.com");
            add("dataDeCadastro", randomDate("2011-04-15", "2011-11-07", new SimpleDateFormat("yyyy-MM-dd")));
            add("currriculo", random(CVS));
        }});

        Fixture.of(Disciplina.class).addTemplate(VALID, new Rule() {{
            add("descricao", random(DESCS_DISC));
            add("professor", one(Professor.class, VALID));
            add("cargaHoraria", random(CARGAS));
        }});

        Fixture.of(Turma.class).addTemplate(VALID, new Rule() {{
            add("descricao", random(DESCS_TURMA));
            add("diasDaSemana", random(DIAS_DA_SEMANA));
            add("horario", random(CARGAS));
            add("alunos", has(1).of(Aluno.class, VALID));
            add("disciplinas", has(1).of(Disciplina.class, VALID));
        }});

    }
}
