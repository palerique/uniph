package br.com.sitedoph.uniph.aplicacao.managedsbeans;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import br.com.sitedoph.uniph.dominio.entidades.Usuario;
import br.com.sitedoph.uniph.dominio.services.UsuarioService;

@Named
@SessionScoped
public class LoginBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Usuario usuario = new Usuario();

    @Inject
    UsuarioService usuarioService;

    private boolean logado;

    public String efetuarLogin() {
        String outcome = "login";

        Usuario existente = usuarioService.buscarPorLoginESenha(usuario.getLogin(), usuario.getSenha());

        if (existente != null && existente.getId() != null) {

            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
                    .getRequest();

            String uri = request.getRequestURI();

            uri = uri.replace("/uniph/", "");
            uri = uri.replace(".xhtml", "");

            if (uri.equals("login")) {
                uri = "usuario";
            }

            outcome = uri + "?faces-redirect=true";

            setLogado(true);

        } else {
            usuario = new Usuario();
            setLogado(false);
        }

        return outcome;
    }

    public String efetuarLogout() {
        logado = false;
        usuario = new Usuario();

        return "login?faces-redirect=true";
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public boolean isLogado() {
        return logado;
    }

    public void setLogado(boolean logado) {
        this.logado = logado;
    }

}