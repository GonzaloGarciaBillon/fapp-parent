package cl.fapp;

import cl.fapp.bots.FoliosBotUtils;

public class PruebaIssuer {

	public static void main(String[] args) {
		String issuer = "1.2.840.113549.1.9.1=#161773636c69656e746540652d636572746368696c652e636c,CN=E-CERTCHILE CA FES 02,OU=Autoridad Certificadora,O=E-CERTCHILE,L=Santiago,ST=Region Metropolitana,C=CL";

		System.out.println(FoliosBotUtils.getIssuerForFoliosBot(issuer));

	}

}
