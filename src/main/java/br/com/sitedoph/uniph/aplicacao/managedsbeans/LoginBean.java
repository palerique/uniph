package br.com.sitedoph.uniph.aplicacao.managedsbeans;

import br.com.sitedoph.uniph.dominio.entidades.Usuario;
import br.com.sitedoph.uniph.dominio.services.UsuarioService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

/**
 * Created by paulohl on 22/02/2016.
 */
@SessionScoped
@ManagedBean
public class LoginBean implements Serializable {

    private static final long serialVersionUID = 8038996478747618529L;

    private Usuario usuario = new Usuario();

    private boolean logado;

    public String efetuarLogin() {

        String outcome = "login";

        UsuarioService service = new UsuarioService();

        Usuario usuarioExistente = service.buscarPorLoginESenha(usuario.getLogin(), usuario.getSenha());

        if (usuarioExistente != null && usuarioExistente.getId() != null) {

            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

            String uri = request.getRequestURI();

            uri = uri.replace("/uniph/", "");
            uri = uri.replace(".xhtml", "");
            uri = uri.replace("/", "");

            if (uri.equals("login")) {
                uri = "usuario";
            }

            outcome = uri + "?faces-redirect=true";

            logado = true;
        } else {
            usuario = new Usuario();
            logado = false;
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

