package br.com.sitedoph.uniph.aplicacao.util;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

public class MensagensUtil {

	public static void info(String mensagem) {
		adicionarMensagem(FacesMessage.SEVERITY_INFO, mensagem);
	}

	private static void adicionarMensagem(Severity severityInfo, String mensagem) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severityInfo, mensagem, mensagem));
	}

	public static void erro(String mensagem) {
		adicionarMensagem(FacesMessage.SEVERITY_ERROR, mensagem);
	}

	public static void warning(String mensagem) {
		adicionarMensagem(FacesMessage.SEVERITY_WARN, mensagem);
	}

	public static void adicionarMensagensDeValidacao(
			ConstraintViolationException e){
		
		for(ConstraintViolation<?> violacao : 
			e.getConstraintViolations()){
			
			warning(violacao.getMessage());
			
		}
		
	}

}
