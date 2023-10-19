package cl.fapp.sii.factory.adapters;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;


public class GYearMonthAdapter extends XmlAdapter<String, Date> {

    private final static SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM");

    @Override
    public String marshal(Date v) throws Exception{
        synchronized (dateTimeFormat) {
        	//System.out.println("[3]Marshal---ejecutado para: " + v + ", QUEDA:" + dateTimeFormat.format(v));
            return dateTimeFormat.format(v);
        }
    }

    @Override
    public Date unmarshal(String v) throws Exception {
        synchronized (dateTimeFormat) {
            try {
            	//System.out.println("[3]unmarshal---ejecutado para: " + v + ", QUEDA:" + dateTimeFormat.parse(v));
				return dateTimeFormat.parse(v);
			} catch (ParseException e) {
				e.printStackTrace();
				return null;
			}
        }
    }
}