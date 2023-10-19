package cl.fapp.domain.boleta;

public class EnvioBOLETA_SetDTE_DTE_Documento_Encabezado {
	private IdDoc iddoc;
	private Emisor emisor;
	private Receptor receptor;
	private Totales totales;

	public EnvioBOLETA_SetDTE_DTE_Documento_Encabezado() {
		super();
	}

	public IdDoc getIddoc() {
		return iddoc;
	}

	public void setIddoc(IdDoc iddoc) {
		this.iddoc = iddoc;
	}

	public Emisor getEmisor() {
		return emisor;
	}

	public void setEmisor(Emisor emisor) {
		this.emisor = emisor;
	}

	public Receptor getReceptor() {
		return receptor;
	}

	public void setReceptor(Receptor receptor) {
		this.receptor = receptor;
	}

	public Totales getTotales() {
		return totales;
	}

	public void setTotales(Totales totales) {
		this.totales = totales;
	}

	public class IdDoc {
		private String tipodte;
		private String folio;
		private String fchemis;
		private String indservicio;

		public IdDoc() {
			super();
		}

		public String getTipodte() {
			return tipodte;
		}

		public void setTipodte(String tipodte) {
			this.tipodte = tipodte;
		}

		public String getFolio() {
			return folio;
		}

		public void setFolio(String folio) {
			this.folio = folio;
		}

		public String getFchemis() {
			return fchemis;
		}

		public void setFchemis(String fchemis) {
			this.fchemis = fchemis;
		}

		public String getIndservicio() {
			return indservicio;
		}

		public void setIndservicio(String indservicio) {
			this.indservicio = indservicio;
		}

	}

	public class Emisor {
		private String rutemisor;
		private String rznsocemisor;
		private String giroemisor;
		private String cdgsiisucur;
		private String dirorigen;
		private String cmnaorigen;
		private String ciudadorigen;

		public Emisor() {
			super();
		}

		public String getRutemisor() {
			return rutemisor;
		}

		public void setRutemisor(String rutemisor) {
			this.rutemisor = rutemisor;
		}

		public String getRznsocemisor() {
			return rznsocemisor;
		}

		public void setRznsocemisor(String rznsocemisor) {
			this.rznsocemisor = rznsocemisor;
		}

		public String getGiroemisor() {
			return giroemisor;
		}

		public void setGiroemisor(String giroemisor) {
			this.giroemisor = giroemisor;
		}

		public String getDirorigen() {
			return dirorigen;
		}

		public void setDirorigen(String dirorigen) {
			this.dirorigen = dirorigen;
		}

		public String getCmnaorigen() {
			return cmnaorigen;
		}

		public void setCmnaorigen(String cmnaorigen) {
			this.cmnaorigen = cmnaorigen;
		}

		public String getCiudadorigen() {
			return ciudadorigen;
		}

		public void setCiudadorigen(String ciudadorigen) {
			this.ciudadorigen = ciudadorigen;
		}

		public String getCdgsiisucur() {
			return cdgsiisucur;
		}

		public void setCdgsiisucur(String cdgsiisucur) {
			this.cdgsiisucur = cdgsiisucur;
		}

	}

	public class Receptor {
		private String rutrecep;
		private String rznrecep;
		private String girorecep;

		public Receptor() {
			super();
		}

		public String getRutrecep() {
			return rutrecep;
		}

		public void setRutrecep(String rutrecep) {
			this.rutrecep = rutrecep;
		}

		public String getRznrecep() {
			return rznrecep;
		}

		public void setRznrecep(String rznrecep) {
			this.rznrecep = rznrecep;
		}

		public String getGirorecep() {
			return girorecep;
		}

		public void setGirorecep(String girorecep) {
			this.girorecep = girorecep;
		}

	}

	public class Totales {
		private String mntneto;
		private String mntexe;
		private String iva;
		private String mnttotal;
		private String montonf;
		private String totalperiodo;
		private String saldoanterior;
		private String vlrpagar;

		public Totales() {
			super();
		}

		public String getMntneto() {
			return mntneto;
		}

		public void setMntneto(String mntneto) {
			this.mntneto = mntneto;
		}

		public String getMntexe() {
			return mntexe;
		}

		public void setMntexe(String mntexe) {
			this.mntexe = mntexe;
		}

		public String getIva() {
			return iva;
		}

		public void setIva(String iva) {
			this.iva = iva;
		}

		public String getMnttotal() {
			return mnttotal;
		}

		public void setMnttotal(String mnttotal) {
			this.mnttotal = mnttotal;
		}

		public String getMontonf() {
			return montonf;
		}

		public void setMontonf(String montonf) {
			this.montonf = montonf;
		}

		public String getTotalperiodo() {
			return totalperiodo;
		}

		public void setTotalperiodo(String totalperiodo) {
			this.totalperiodo = totalperiodo;
		}

		public String getSaldoanterior() {
			return saldoanterior;
		}

		public void setSaldoanterior(String saldoanterior) {
			this.saldoanterior = saldoanterior;
		}

		public String getVlrpagar() {
			return vlrpagar;
		}

		public void setVlrpagar(String vlrpagar) {
			this.vlrpagar = vlrpagar;
		}

	}
}
