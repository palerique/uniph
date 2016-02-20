package br.com.sitedoph.uniph.aplicacao.managedsbeans;

import java.util.Collection;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.validation.ConstraintViolationException;

import br.com.sitedoph.uniph.aplicacao.util.MensagensUtil;
import br.com.sitedoph.uniph.dominio.entidades.Usuario;
import br.com.sitedoph.uniph.dominio.services.UsuarioService;

@ViewScoped
@ManagedBean
public class UsuarioBean {

	private Usuario usuario = new Usuario();
	private Collection<Usuario> usuarios;

	private UsuarioService service = new UsuarioService();

	public void gravar() {

		try {
			service.salvarOuAtualizar(usuario);
			limpar();
			usuarios = service.buscarTodos();
			MensagensUtil.info("Usuário foi Cadastrado com Sucesso!");
		} catch (ConstraintViolationException e) {
			MensagensUtil.adicionarMensagensDeValidacao(e);
		} catch (org.hibernate.exception.ConstraintViolationException e) {
			MensagensUtil.erro("Login ou endereço de e-mail em uso!");
		}
	}

	public void cancelar() {
		limpar();
	}

	private void limpar() {
		usuario = new Usuario();
	}

	public void remover(Usuario usuario) {
		service.excluir(usuario);
		usuarios = service.buscarTodos();
	}

	public Collection<Usuario> getUsuarios() {

		if (usuarios == null) {
			usuarios = service.buscarTodos();
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
