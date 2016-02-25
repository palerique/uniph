package br.com.sitedoph.uniph.aplicacao.managedsbeans;


import br.com.sitedoph.uniph.dominio.entidades.Usuario;
import br.com.sitedoph.uniph.dominio.services.UsuarioService;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Named
@ViewScoped
public class UsuarioBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private UsuarioService usuarioService;

    private Usuario usuario = new Usuario();
    private List<Usuario> usuarios;

    public void salvar() {
        usuarioService.salvarOuAtualizar(usuario);
        usuario = new Usuario();

        FacesMessage msg = new FacesMessage("Usuário cadastrado com sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void remover(Usuario usuario) {
        usuarioService.excluir(usuario);
        usuarios = usuarioService.buscarTodos();
    }

    public Collection<Usuario> getUsuarios() {
        if (usuarios == null) {
            usuarios = usuarioService.buscarTodos();
        }

        return usuarios;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void limparFormulario() {
        this.usuario = new Usuario();
    }
}