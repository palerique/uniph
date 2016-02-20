package br.com.sitedoph.uniph.aplicacao.managedsbeans;

import javax.faces.bean.ManagedBean;

import br.com.sitedoph.uniph.dominio.entidades.Usuario;
import br.com.sitedoph.uniph.dominio.services.UsuarioService;

@ManagedBean
public class UsuarioBean {

	private Usuario usuario = new Usuario();

	private UsuarioService service = new UsuarioService();

	public void gravar() {

		System.out.println(usuario);

		service.salvarOuAtualizar(usuario);

		usuario = new Usuario();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
