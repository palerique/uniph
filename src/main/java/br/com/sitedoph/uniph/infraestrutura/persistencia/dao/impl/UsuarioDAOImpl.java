package br.com.sitedoph.uniph.infraestrutura.persistencia.dao.impl;

import br.com.sitedoph.uniph.dominio.entidades.Usuario;
import br.com.sitedoph.uniph.infraestrutura.persistencia.dao.GenericDAOHibernate;
import br.com.sitedoph.uniph.infraestrutura.persistencia.dao.UsuarioDAO;

import java.io.Serializable;
import java.util.List;

public class UsuarioDAOImpl extends GenericDAOHibernate<Usuario, Long> implements Serializable, UsuarioDAO {

    public UsuarioDAOImpl() {
        super(Usuario.class);
    }

    @Override
    public Usuario buscarPorLoginESenha(String login, String senha) {

        Usuario exemplo = new Usuario();
        exemplo.setLogin(login);
        exemplo.setSenha(senha);

        List<Usuario> list = super.buscarPorExemplo(exemplo);

        if (list != null && !list.isEmpty()) {
            return list.get(0);
        } else {
            return null;
        }
    }

}
