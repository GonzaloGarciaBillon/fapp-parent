package cl.fapp.restapi.controller.libros;

import java.math.BigDecimal;
import java.math.BigInteger;

import com.opencsv.bean.CsvBindByPosition;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RegistroCompraVentaCSVPositionBean extends RegistroCompraVentaBean {

	@CsvBindByPosition(position = 0)
	private BigInteger TpoDoc;

	@CsvBindByPosition(position = 1)
	private BigInteger NroDoc;

	@CsvBindByPosition(position = 2)
	private String RUTDoc;

	@CsvBindByPosition(position = 3)
	private BigDecimal TasaImp;

	@CsvBindByPosition(position = 4)
	private String RznSoc;

	@CsvBindByPosition(position = 5)
	private BigInteger TpoImp;

	@CsvBindByPosition(position = 6)
	private String FchDoc;

	@CsvBindByPosition(position = 7)
	private String Anulado;

	@CsvBindByPosition(position = 8)
	private BigInteger MntExe;

	@CsvBindByPosition(position = 9)
	private BigInteger MntNeto;

	@CsvBindByPosition(position = 10)
	private BigInteger MntIVA;

	@CsvBindByPosition(position = 11)
	private String IVANoRec;

	@CsvBindByPosition(position = 12)
	private String IVAUsoComun;
	
	@CsvBindByPosition(position = 13)
	private String OtrosImp;

	@CsvBindByPosition(position = 14)
	private BigInteger MntSinCred;

	@CsvBindByPosition(position = 15)
	private BigInteger MntActivoFijo;

	@CsvBindByPosition(position = 16)
	private BigInteger MntIVAActivoFijo;

	@CsvBindByPosition(position = 17)
	private String IVANoRetenido;

	@CsvBindByPosition(position = 18)
	private BigInteger TabPuros;

	@CsvBindByPosition(position = 19)
	private BigInteger TabCigarrillos;

	@CsvBindByPosition(position = 20)
	private BigInteger TabElaborado;

	@CsvBindByPosition(position = 21)
	private BigInteger ImpVehiculo;

	@CsvBindByPosition(position = 22)
	private BigInteger CdgSIISucur;

	@CsvBindByPosition(position = 23)
	private String NumInt;

	@CsvBindByPosition(position = 24)
	private BigInteger Emisor;

	@CsvBindByPosition(position = 25)
	private String IVANoRec_CodIVANoRec;

	@CsvBindByPosition(position = 26)
	private String IVANoRec_MntIVANoRec;

	@CsvBindByPosition(position = 27)
	private String OtrosImp_CodImp;

	@CsvBindByPosition(position = 28)
	private String OtrosImp_TasaImp;

	@CsvBindByPosition(position = 29)
	private String OtrosImp_MntImp;

	@CsvBindByPosition(position = 30)
	private BigInteger MntTotal;
}
