package cl.fapp.sii.factory.adapters;

import java.util.Base64;
import jakarta.xml.bind.annotation.adapters.XmlAdapter;

public class BinaryAdapter extends XmlAdapter<byte[], byte[]> {

	/**
	 * obj -> xml
	 */
	@Override
	public byte[] marshal(byte[] v) throws Exception {
		System.out.println("[4]marshal---Base64.getEncoder().encode(v) ");
		return Base64.getEncoder().encode(v);
	}

	/**
	 * xml -> obj
	 */
	@Override
	public byte[] unmarshal(byte[] v) throws Exception {
		try {
			System.out.println("[5]unmarshal---Base64.getDecoder().decode(v) ");
			return Base64.getDecoder().decode(v);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}