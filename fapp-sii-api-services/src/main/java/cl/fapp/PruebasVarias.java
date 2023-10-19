package cl.fapp;

import cl.fapp.common.domain.statuses.EntityStatuses;

public class PruebasVarias {

	public static void main(String[] args) {
		
		//PruebasVarias pruebasVarias = new PruebasVarias();
/*		
		VentasDiariasMapper vdm = new VentasDiariasMapper();
		
		BigInteger[] valores= {
				//BigInteger.valueOf(1),
				new BigInteger("1"),
				new BigInteger("2"),
				new BigInteger("9"),
				new BigInteger("11"),
				new BigInteger("12"),
				new BigInteger("13"),
				new BigInteger("17"),
				new BigInteger("18"),
		};
		
		//pruebasVarias.vdm.cacularTotales("76447325-6", EntityDTEStatuses.SETDTEASIGNADO);
		RangosResumenRVD resp2 = vdm.getRangoFoliosUtilizadosAnulados(valores, valores.length);
		System.out.println("RESP=" + resp2);
*/	

		System.out.println("CAF=" + EntityStatuses.getStatuses(EntityStatuses.CAF.class));
		System.out.println("DTE=" + EntityStatuses.getStatuses(EntityStatuses.DTE.class));
		System.out.println("SETDTE=" + EntityStatuses.getStatuses(EntityStatuses.SETDTE.class));
		System.out.println("EMISORES=" + EntityStatuses.getStatuses(EntityStatuses.EMISORES.class));
		System.out.println("FIRMANTES=" + EntityStatuses.getStatuses(EntityStatuses.FIRMANTES.class));
	}
}
