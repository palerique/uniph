package br.com.sitedoph.uniph.aplicacao.listeners;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import br.com.sitedoph.uniph.aplicacao.managedsbeans.LoginBean;

public class AutorizadorListener implements PhaseListener {

	@Override
	public void afterPhase(PhaseEvent evento) {
		
		FacesContext contexto = evento.getFacesContext();
		
		if("/login.xhtml".equals(
				contexto.getViewRoot().getViewId())){
			return;
		}
		
		LoginBean loginBean = contexto
				.getApplication()
				.evaluateExpressionGet(contexto, 
						"#{loginBean}", 
						LoginBean.class);
		
	}

	@Override
	public void beforePhase(PhaseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}
