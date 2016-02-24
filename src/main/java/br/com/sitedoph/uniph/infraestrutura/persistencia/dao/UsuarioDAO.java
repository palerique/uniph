package br.com.sitedoph.uniph.infraestrutura.persistencia.dao;

import br.com.sitedoph.uniph.dominio.entidades.Usuario;

/**
 * Created by paulohl on 23/02/2016.
 */
public interface UsuarioDAO extends GenericDAO<Usuario, Long> {
    Usuario buscarPorLoginESenha(String login, String senha);
}
