package cl.fapp.common.rut;

public class TestRUTUtils {

	public static void main(String[] args) {
		String rut="56.933.417-9";
		
		boolean rutvalido2 = RUTUtils.isValid(rut);
		System.out.println("El rut=" + rut + " es " + rutvalido2);

	}

}
