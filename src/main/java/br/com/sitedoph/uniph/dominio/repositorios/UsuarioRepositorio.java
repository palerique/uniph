package br.com.sitedoph.uniph.dominio.repositorios;

import br.com.sitedoph.uniph.dominio.entidades.Usuario;

import java.io.Serializable;
import java.util.List;

public interface UsuarioRepositorio extends Serializable {

    Usuario buscarPorId(Long id);

    List<Usuario> buscarTodos();

    void excluir(Usuario usuario);

    Usuario salvarOuAtualizar(Usuario usuario);

    Usuario buscarPorLoginESenha(String login, String senha);
}
