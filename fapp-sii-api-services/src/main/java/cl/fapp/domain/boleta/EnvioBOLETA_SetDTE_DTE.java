package cl.fapp.domain.boleta;

public class EnvioBOLETA_SetDTE_DTE {

	private String version;
	private EnvioBOLETA_SetDTE_DTE_Documento documento;

	public EnvioBOLETA_SetDTE_DTE() {
		super();
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public EnvioBOLETA_SetDTE_DTE_Documento getDocumento() {
		return documento;
	}

	public void setDocumento(EnvioBOLETA_SetDTE_DTE_Documento documento) {
		this.documento = documento;
	}

}
