package cl.fapp.sii.factory.adapters;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

public class DateAdapter extends XmlAdapter<String, Date> {

    private final static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public String marshal(Date v) throws Exception{
        synchronized (dateFormat) {
        	//System.out.println("[1]Marshal---ejecutado para: " + v + ", QUEDA:" + dateFormat.format(v));
            return dateFormat.format(v);
        }
    }

    @Override
    public Date unmarshal(String v) throws Exception {
        synchronized (dateFormat) {
            try {
            	//System.out.println("[1]unmarshal---ejecutado para: " + v + ", QUEDA:" + dateFormat.parse(v));
				return dateFormat.parse(v);
			} catch (ParseException e) {
				e.printStackTrace();
				return null;
			}
        }
    }
}