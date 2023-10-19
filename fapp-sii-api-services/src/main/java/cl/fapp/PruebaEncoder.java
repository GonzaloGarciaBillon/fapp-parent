package cl.fapp;

import java.util.Base64;

public class PruebaEncoder {

	public static void main(String[] args) {

		byte[] b = {28, -15, -16, 20, -88, 116, -21, 59, 90, 73, 89, 54, 66, 40, -58, -104, -58, 84, -124, 52, 57, -112, -35, 117, -59, 47, -20, 96, 20, 86, -16, -87, -113, 79, -54, -18, -111, -66, 99, 49, -60, 41, 40, 65, 88, -52, -59, -25, 111, 127, -15, 125, -26, 46, 108, 24, -53, 53, 105, 0, 125, -61, 3, -119, -95, -120, 95, 74, -103, 64, -42, -54, 79, -87, 36, -115, 5, 110, -38, -95, -10, 79, -53, -18, -33, 57, 65, -116, -36, -66, 23, 58, 76, 23, -115, -127, -7, -126, 71, 38, 15, -10, -47, 104, 6, 65, -97, -66, 36, 0, 102, 106, 65, -113, -71, -31, -69, -84, -20, 16, -113, 123, 118, 70, -48, -121, 65, -72, -12, 90, -15, -66, 24, 74, 4, -100, -128, 71, 2, 119, 77, -63, -14, -105, -102, 44, -46, 89, -45, -33, 72, 92, 45, 30, 101, 109, 13, -90, -20, -119, -56, 41, -1, -97, 21, 18, -76, 90, -62, -75, -30, 44, 78, -87, -126, -81, 85, -91, 67, 6, 95, 65, 14, -71, 41, 31, -127, 72, 29, -20, -125, 7, -73, -68, -106, -33, 50, -19, 123, 82, 66, -84, 86, 58, -1, -12, -81, -93, -123, 85, 61, -123, -56, -16, -116, 18, 16, 119, -113, 45, 78, -105, -43, -26, 33, -93, -37, 100, 47, 26, -41, 84, 78, 2, 125, 124, -121, 7, 64, -116, 62, -53, 2, -92, 24, -69, 24, -102, -61, -22, 39, 118, 76, -97, 99, 68};
		
		
		byte[] digest= {30, -125, -47, 15, 25, 124, -19, 60, 64, 97, 53, -57, 118, 53, -126, -73, 108, 18, 18, -44};
		byte[] decodedDigest= {64, -35, 127, -6, 63, 40, -25, 94, -56, -25, -124, 47, 12, -81, 127, -99, -63, 100, 117, 90};
		byte[] calculado = {64, -35, 127, -6, 63, 40, -25, 94, -56, -25, -124, 47, 12, -81, 127, -99, -63, 100, 117, 90};
		String strDigest = Base64.getEncoder().encodeToString(digest);
		String strDecodeDigest = Base64.getEncoder().encodeToString(decodedDigest);
		String strCalculado = Base64.getEncoder().encodeToString(calculado);
		String strB = Base64.getEncoder().encodeToString(b);

		System.out.println("digest=[" + strDigest + "]");
		System.out.println("decodedDigest=[" + strDecodeDigest + "]");
		System.out.println("calculado=[" + strCalculado + "]");
		System.out.println("B=[" + strB + "]");
		
		String digestEnArchivo = "qU/3PG/VZccy30xH3SbTyuFSYyo=";
		
		@SuppressWarnings("unused")
		byte[] digestDecoded = Base64.getDecoder().decode(digestEnArchivo);
		
	}

}
