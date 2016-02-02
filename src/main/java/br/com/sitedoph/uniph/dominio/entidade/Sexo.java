package br.com.sitedoph.uniph.dominio.entidade;

/**
 * Enum Sexo.
 */
public enum Sexo {

    /**
     * feminino.
     */
    FEMININO(2, "Feminino"), /**
     * masculino.
     */
    MASCULINO(1, "Masculino");

    /**
     * descricao.
     */
    private final String descricao;

    /**
     * id.
     */
    private final Integer id;

    /**
     * Instancia um novo sexo.
     *
     * @param chave a chave
     * @param valor o valor
     */
    Sexo(final Integer chave, final String valor) {

        id = chave;
        descricao = valor;
    }

    /**
     * Obtém a descricao.
     *
     * @return a descricao
     */
    public String getDescricao() {

        return descricao;
    }

    /**
     * Obtém o id.
     *
     * @return o id
     */
    public Integer getId() {

        return id;
    }

}