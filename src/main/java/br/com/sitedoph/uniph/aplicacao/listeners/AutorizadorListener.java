package br.com.sitedoph.uniph.aplicacao.listeners;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import br.com.sitedoph.uniph.aplicacao.managedsbeans.LoginBean;

public class AutorizadorListener implements PhaseListener {

	@Override
	public void afterPhase(PhaseEvent evento) {

		FacesContext contexto = evento.getFacesContext();

		if ("/login.xhtml".equals(contexto.getViewRoot().getViewId())) {
			return;
		}

		LoginBean loginBean = contexto.getApplication().evaluateExpressionGet(contexto, "#{loginBean}",
				LoginBean.class);

		if (!loginBean.isLogado()) {
			NavigationHandler gerente = 
					contexto.getApplication()
					.getNavigationHandler();

			gerente.handleNavigation(contexto, 
					null, "login?faces-redirect=true");

			contexto.renderResponse();
		}

	}

	@Override
	public void beforePhase(PhaseEvent arg0) {
		// intencionalmente deixado em branco!
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}
