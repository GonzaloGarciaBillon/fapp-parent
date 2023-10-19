package cl.fapp.domain.boleta;

public class EnvioBOLETA_SetDTE_DTE_Documento {
	private String id;
	private EnvioBOLETA_SetDTE_DTE_Documento_Encabezado encabezado;
	private EnvioBOLETA_SetDTE_DTE_Documento_Detalle detalle;
	private EnvioBOLETA_SetDTE_DTE_Documento_SubTotInfo subtotinfo;
	private EnvioBOLETA_SetDTE_DTE_Documento_DscRcgGlobal dscrcgglobal;
	private EnvioBOLETA_SetDTE_DTE_Documento_Referencia referencia;
	private EnvioBOLETA_SetDTE_DTE_Documento_TED ted;
	private String tmstfirma;

	public EnvioBOLETA_SetDTE_DTE_Documento() {
		super();
	}

	public EnvioBOLETA_SetDTE_DTE_Documento_Encabezado getEncabezado() {
		return encabezado;
	}

	public void setEncabezado(EnvioBOLETA_SetDTE_DTE_Documento_Encabezado encabezado) {
		this.encabezado = encabezado;
	}

	public EnvioBOLETA_SetDTE_DTE_Documento_Detalle getDetalle() {
		return detalle;
	}

	public void setDetalle(EnvioBOLETA_SetDTE_DTE_Documento_Detalle detalle) {
		this.detalle = detalle;
	}

	public EnvioBOLETA_SetDTE_DTE_Documento_SubTotInfo getSubtotinfo() {
		return subtotinfo;
	}

	public void setSubtotinfo(EnvioBOLETA_SetDTE_DTE_Documento_SubTotInfo subtotinfo) {
		this.subtotinfo = subtotinfo;
	}

	public EnvioBOLETA_SetDTE_DTE_Documento_DscRcgGlobal getDscrcgglobal() {
		return dscrcgglobal;
	}

	public void setDscrcgglobal(EnvioBOLETA_SetDTE_DTE_Documento_DscRcgGlobal dscrcgglobal) {
		this.dscrcgglobal = dscrcgglobal;
	}

	public EnvioBOLETA_SetDTE_DTE_Documento_Referencia getReferencia() {
		return referencia;
	}

	public void setReferencia(EnvioBOLETA_SetDTE_DTE_Documento_Referencia referencia) {
		this.referencia = referencia;
	}

	public EnvioBOLETA_SetDTE_DTE_Documento_TED getTed() {
		return ted;
	}

	public void setTed(EnvioBOLETA_SetDTE_DTE_Documento_TED ted) {
		this.ted = ted;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTmstfirma() {
		return tmstfirma;
	}

	public void setTmstfirma(String tmstfirma) {
		this.tmstfirma = tmstfirma;
	}

}
