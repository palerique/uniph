package br.com.sitedoph.uniph.dominio.repositorios;

import br.com.sitedoph.uniph.dominio.entidades.Usuario;
import br.com.sitedoph.uniph.infraestrutura.persistencia.dao.impl.UsuarioDAO;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

public class UsuarioRepositorio implements Serializable {

    @Inject
    private UsuarioDAO DAO;

    public Usuario buscarPorId(Long id) {

        Usuario u = DAO.buscarPorId(id);

        return u;
    }

    public Usuario buscarPorLoginESenha(String login, String senha) {

        Usuario u = DAO.buscarPorLoginESenha(login, senha);

        return u;
    }

    public List<Usuario> buscarTodos() {

        List<Usuario> lista = DAO.buscarTodos();

        return lista;
    }

    public void excluir(final Usuario usuario) {
        DAO.excluir(usuario);
    }

    public Usuario salvarOuAtualizar(Usuario usuario) {

        usuario = DAO.salvarOuAtualizar(usuario);

        return usuario;
    }
}
