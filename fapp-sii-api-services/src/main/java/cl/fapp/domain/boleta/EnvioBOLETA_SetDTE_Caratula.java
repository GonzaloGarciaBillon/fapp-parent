package cl.fapp.domain.boleta;

public class EnvioBOLETA_SetDTE_Caratula {
	private String rutemisor;
	private String rutenvia;
	private String rutreceptor;
	private String fchresol;
	private String nroresol;
	private String tmstfirmaenv;
	private EnvioBOLETA_SetDTE_Caratula_SubTotDTE subtotdte;

	public EnvioBOLETA_SetDTE_Caratula() {
		super();
	}

	public String getRutemisor() {
		return rutemisor;
	}

	public void setRutemisor(String rutemisor) {
		this.rutemisor = rutemisor;
	}

	public String getRutenvia() {
		return rutenvia;
	}

	public void setRutenvia(String rutenvia) {
		this.rutenvia = rutenvia;
	}

	public String getRutreceptor() {
		return rutreceptor;
	}

	public void setRutreceptor(String rutreceptor) {
		this.rutreceptor = rutreceptor;
	}

	public String getFchresol() {
		return fchresol;
	}

	public void setFchresol(String fchresol) {
		this.fchresol = fchresol;
	}

	public String getNroresol() {
		return nroresol;
	}

	public void setNroresol(String nroresol) {
		this.nroresol = nroresol;
	}

	public String getTmstfirmaenv() {
		return tmstfirmaenv;
	}

	public void setTmstfirmaenv(String tmstfirmaenv) {
		this.tmstfirmaenv = tmstfirmaenv;
	}

	public EnvioBOLETA_SetDTE_Caratula_SubTotDTE getSubtotdte() {
		return subtotdte;
	}

	public void setSubtotdte(EnvioBOLETA_SetDTE_Caratula_SubTotDTE subtotdte) {
		this.subtotdte = subtotdte;
	}

}
