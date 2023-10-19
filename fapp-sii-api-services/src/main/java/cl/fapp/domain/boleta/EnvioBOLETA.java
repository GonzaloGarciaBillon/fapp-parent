package cl.fapp.domain.boleta;

public class EnvioBOLETA {
	private String version;
	private EnvioBOLETA_SetDTE setdte;

	public EnvioBOLETA() {
		super();
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public EnvioBOLETA_SetDTE getSetdte() {
		return setdte;
	}

	public void setSetdte(EnvioBOLETA_SetDTE setdte) {
		this.setdte = setdte;
	}

}
