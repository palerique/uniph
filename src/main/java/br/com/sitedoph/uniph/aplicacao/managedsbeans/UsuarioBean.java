package br.com.sitedoph.uniph.aplicacao.managedsbeans;

import br.com.sitedoph.uniph.aplicacao.util.MensagensUtil;
import br.com.sitedoph.uniph.dominio.entidades.Usuario;
import br.com.sitedoph.uniph.dominio.services.UsuarioService;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.ConstraintViolationException;
import java.util.Collection;

@ViewScoped
@Named
public class UsuarioBean {

    private Usuario usuario = new Usuario();
    private Collection<Usuario> usuarios;

    @Inject
    private UsuarioService service;

    public void gravar() {

        try {
            new UsuarioService().salvarOuAtualizar(usuario);
            limpar();
            usuarios = new UsuarioService().buscarTodos();
            MensagensUtil.info("Usuário foi Cadastrado com Sucesso!");
        } catch (Exception e) {

            if (e.getCause() instanceof ConstraintViolationException) {
                MensagensUtil.adicionarMensagensDeValidacao((ConstraintViolationException) e.getCause());
            } else if (e.getCause() instanceof javax.persistence.PersistenceException) {
                MensagensUtil.erro("Login ou endereço de e-mail em uso!");
            } else {
                throw e;
            }

        }

    }

    public void cancelar() {
        limpar();
    }

    private void limpar() {
        usuario = new Usuario();
    }

    public void remover(Usuario usuario) {
        new UsuarioService().excluir(usuario);
        usuarios = new UsuarioService().buscarTodos();
    }

    public Collection<Usuario> getUsuarios() {
        if (usuarios == null) {
            usuarios = new UsuarioService().buscarTodos();
        }

        return usuarios;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
