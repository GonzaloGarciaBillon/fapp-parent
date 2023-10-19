package cl.fapp.domain.boleta;

public class EnvioBOLETA_SetDTE_DTE_Documento_Detalle {
	private String nrolindet;
	private CdgItem cdgitem;
	private String nmbitem;
	private String qtyitem;
	private String prcitem;
	private String montoitem;

	public EnvioBOLETA_SetDTE_DTE_Documento_Detalle() {
		super();
	}

	public String getNrolindet() {
		return nrolindet;
	}

	public void setNrolindet(String nrolindet) {
		this.nrolindet = nrolindet;
	}

	public CdgItem getCdgitem() {
		return cdgitem;
	}

	public void setCdgitem(CdgItem cdgitem) {
		this.cdgitem = cdgitem;
	}

	public String getNmbitem() {
		return nmbitem;
	}

	public void setNmbitem(String nmbitem) {
		this.nmbitem = nmbitem;
	}

	public String getQtyitem() {
		return qtyitem;
	}

	public void setQtyitem(String qtyitem) {
		this.qtyitem = qtyitem;
	}

	public String getPrcitem() {
		return prcitem;
	}

	public void setPrcitem(String prcitem) {
		this.prcitem = prcitem;
	}

	public String getMontoitem() {
		return montoitem;
	}

	public void setMontoitem(String montoitem) {
		this.montoitem = montoitem;
	}

	public class CdgItem {
		private String tpocodigo;
		private String vlrcodigo;

		public CdgItem() {
			super();
		}

		public String getTpocodigo() {
			return tpocodigo;
		}

		public void setTpocodigo(String tpocodigo) {
			this.tpocodigo = tpocodigo;
		}

		public String getVlrcodigo() {
			return vlrcodigo;
		}

		public void setVlrcodigo(String vlrcodigo) {
			this.vlrcodigo = vlrcodigo;
		}

	}

}
