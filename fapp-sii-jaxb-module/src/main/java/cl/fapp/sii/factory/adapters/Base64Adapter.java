package cl.fapp.sii.factory.adapters;

import java.util.Base64;
import jakarta.xml.bind.annotation.adapters.XmlAdapter;

public final class Base64Adapter extends XmlAdapter<String, byte[]> {
	
    @Override
	public byte[] unmarshal(String s) {
		if (s == null)
			return null;
		return Base64.getDecoder().decode(s); // org.apache.commons.codec.binary.Base64.decodeBase64(s);
	}

    @Override
	public String marshal(byte[] bytes) {
		if (bytes == null)
			return null;
		return Base64.getEncoder().encodeToString(bytes); // org.apache.commons.codec.binary.Base64.encodeBase64String(bytes);
	}
}
