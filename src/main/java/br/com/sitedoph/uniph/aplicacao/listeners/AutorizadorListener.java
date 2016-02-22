package br.com.sitedoph.uniph.aplicacao.listeners;

import br.com.sitedoph.uniph.aplicacao.managedsbeans.LoginBean;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

/**
 * Created by paulohl on 22/02/2016.
 */
public class AutorizadorListener implements PhaseListener {

    private static final long serialVersionUID = -2083922299995604065L;

    @Override
    public void afterPhase(PhaseEvent event) {

        FacesContext contexto = event.getFacesContext();

        if ("/login.xhtml".equals(contexto.getViewRoot().getViewId())) {
            return;
        }

        LoginBean loginBean = contexto.getApplication().evaluateExpressionGet(contexto, "#{loginBean}", LoginBean.class);

        if (!loginBean.isLogado()) {
            NavigationHandler gerente = contexto.getApplication().getNavigationHandler();

            gerente.handleNavigation(contexto, null, "login?faces-redirect=true");

            contexto.renderResponse();
        }

    }

    @Override
    public void beforePhase(PhaseEvent event) {

        // Deixado em branco intencionalmente

    }

    @Override
    public PhaseId getPhaseId() {

        return PhaseId.RESTORE_VIEW;
    }

}

