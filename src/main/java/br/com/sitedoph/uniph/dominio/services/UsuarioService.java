package br.com.sitedoph.uniph.dominio.services;

import br.com.sitedoph.uniph.dominio.entidades.Usuario;
import br.com.sitedoph.uniph.dominio.repositorios.UsuarioRepositorio;

import java.util.List;

public class UsuarioService {

    private final UsuarioRepositorio repo = new UsuarioRepositorio();

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

    public Usuario salvarOuAtualizar(Usuario usuario) {
        return repo.salvarOuAtualizar(usuario);
    }
}
