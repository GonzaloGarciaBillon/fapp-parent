package cl.fapp.domain.boleta;

import java.util.ArrayList;
import java.util.List;

public class EnvioBOLETA_SetDTE {
	private String id;
	private EnvioBOLETA_SetDTE_Caratula caratula;
	private List<EnvioBOLETA_SetDTE_DTE> dte = new ArrayList<EnvioBOLETA_SetDTE_DTE>();

	public EnvioBOLETA_SetDTE() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public EnvioBOLETA_SetDTE_Caratula getCaratula() {
		return caratula;
	}

	public void setCaratula(EnvioBOLETA_SetDTE_Caratula caratula) {
		this.caratula = caratula;
	}

	public List<EnvioBOLETA_SetDTE_DTE> getDte() {
		return dte;
	}

	public void setDte(List<EnvioBOLETA_SetDTE_DTE> dte) {
		this.dte = dte;
	}

}
