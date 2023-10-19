package cl.fapp.domain.boleta;

public class EnvioBOLETA_SetDTE_DTE_Documento_TED {
	private String version;
	private EnvioBOLETA_SetDTE_DTE_Documento_TED_DD dd;
	private EnvioBOLETA_SetDTE_DTE_Documento_TED_FRMT frmt;

	public EnvioBOLETA_SetDTE_DTE_Documento_TED() {
		super();
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public EnvioBOLETA_SetDTE_DTE_Documento_TED_DD getDd() {
		return dd;
	}

	public void setDd(EnvioBOLETA_SetDTE_DTE_Documento_TED_DD dd) {
		this.dd = dd;
	}

	public EnvioBOLETA_SetDTE_DTE_Documento_TED_FRMT getFrmt() {
		return frmt;
	}

	public void setFrmt(EnvioBOLETA_SetDTE_DTE_Documento_TED_FRMT frmt) {
		this.frmt = frmt;
	}

}
