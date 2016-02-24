package br.com.sitedoph.uniph.infraestrutura.persistencia.dao.impl;

import br.com.sitedoph.uniph.dominio.entidades.Usuario;
import br.com.sitedoph.uniph.dominio.repositorios.UsuarioRepositorio;

import javax.inject.Inject;
import java.util.List;

public class UsuarioDAO implements UsuarioRepositorio {

    @Inject
    private GenericDAOHibernate<Usuario> genericDAOHibernate;

    public Usuario buscarPorId(Long id) {
        return genericDAOHibernate.buscarPorId(id);
    }

    public Usuario buscarPorLoginESenha(String login, String senha) {

        Usuario exemplo = new Usuario();
        exemplo.setLogin(login);
        exemplo.setSenha(senha);

        List<Usuario> list = genericDAOHibernate.buscarPorExemplo(exemplo);

        if (list != null && !list.isEmpty()) {
            return list.get(0);
        } else {
            return null;
        }
    }

    public List<Usuario> buscarTodos() {
        return genericDAOHibernate.buscarTodos();
    }

    public void excluir(Usuario usuario) {
        genericDAOHibernate.excluir(usuario);
    }

    public Usuario salvarOuAtualizar(Usuario usuario) {
        return genericDAOHibernate.salvarOuAtualizar(usuario);
    }

}
