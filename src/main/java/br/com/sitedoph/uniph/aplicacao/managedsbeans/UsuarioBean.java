package br.com.sitedoph.uniph.aplicacao.managedsbeans;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.sitedoph.uniph.dominio.entidades.Usuario;
import br.com.sitedoph.uniph.dominio.services.UsuarioService;

@Named
@ViewScoped
public class UsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Usuario usuario = new Usuario();
	private List<Usuario> usuarios;

	@Inject
	private UsuarioService usuarioService;

	public void salvar() {

		boolean edicao = this.usuario.getId() != null;

		usuarioService.salvarOuAtualizar(this.usuario);
		this.usuario = new Usuario();
		this.usuarios = usuarioService.buscarTodos();

		FacesMessage msg;
		if (edicao) {
			msg = new FacesMessage("Usuário alterado com sucesso!");
		} else {
			msg = new FacesMessage("Usuário cadastrado com sucesso!");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void remover(Usuario usuario) {
		usuarioService.excluir(usuario);
		this.usuarios = usuarioService.buscarTodos();

		FacesMessage msg = new FacesMessage("Usuário excluído com sucesso!");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void limpar() {
		usuario = new Usuario();
	}

	public Collection<Usuario> getUsuarios() {
		if (this.usuarios == null) {
			this.usuarios = usuarioService.buscarTodos();
		}

		return this.usuarios;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}