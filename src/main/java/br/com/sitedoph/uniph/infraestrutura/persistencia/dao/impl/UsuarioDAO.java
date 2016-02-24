package br.com.sitedoph.uniph.infraestrutura.persistencia.dao.impl;

import br.com.sitedoph.uniph.dominio.entidades.Usuario;
import br.com.sitedoph.uniph.dominio.repositorios.UsuarioRepositorio;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

public class UsuarioDAO extends GenericDAOHibernate<Usuario> implements UsuarioRepositorio {

    private EntityManager entityManager;

    @Inject
    public UsuarioDAO(EntityManager entityManager) {
        super(Usuario.class, entityManager);
        this.entityManager = entityManager;
    }

    public Usuario buscarPorLoginESenha(String login, String senha) {

        Usuario exemplo = new Usuario();
        exemplo.setLogin(login);
        exemplo.setSenha(senha);

        List<Usuario> list = buscarPorExemplo(exemplo);

        if (list != null && !list.isEmpty()) {
            return list.get(0);
        } else {
            return null;
        }
    }

}
