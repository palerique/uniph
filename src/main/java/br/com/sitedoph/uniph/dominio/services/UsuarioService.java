package br.com.sitedoph.uniph.dominio.services;

import br.com.sitedoph.uniph.dominio.entidades.Usuario;
import br.com.sitedoph.uniph.dominio.repositorios.UsuarioRepositorio;
import br.com.sitedoph.uniph.infraestrutura.persistencia.util.Transacional;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

public class UsuarioService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private UsuarioRepositorio repo;

    public Usuario buscarPorId(final Long id) {
        return repo.buscarPorId(id);
    }

    public Usuario buscarPorLoginESenha(String login, String senha) {
        return repo.buscarPorLoginESenha(login, senha);
    }

    public List<Usuario> buscarTodos() {
        return repo.buscarTodos();
    }

    public void excluir(Usuario usuario) {
        repo.excluir(usuario);
    }

    @Transacional
    public Usuario salvarOuAtualizar(Usuario usuario) {
        return repo.salvarOuAtualizar(usuario);
    }
}
