package br.com.sitedoph.uniph.dominio.services;

import br.com.sitedoph.uniph.dominio.entidades.Usuario;
import br.com.sitedoph.uniph.dominio.repositorios.UsuarioRepositorio;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

public class UsuarioService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private UsuarioRepositorio repo;

    public Usuario buscarPorId(Long id) {
        return this.repo.buscarPorId(id);
    }

    public Usuario buscarPorLoginESenha(String login, String senha) {
        return this.repo.buscarPorLoginESenha(login, senha);
    }

    public List<Usuario> buscarTodos() {
        return this.repo.buscarTodos();
    }

    public void excluir(Usuario usuario) {
        this.repo.excluir(usuario);
    }

    public Usuario salvarOuAtualizar(Usuario usuario) {
        return this.repo.salvarOuAtualizar(usuario);
    }
}
