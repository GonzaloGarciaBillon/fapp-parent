package cl.fapp.common.crypto;

import javax.crypto.spec.IvParameterSpec;
import java.security.SecureRandom;

public class IVGenerator {
    public static IvParameterSpec generateIV() {
        byte[] iv = new byte[16];
        new SecureRandom().nextBytes(iv);
        return new IvParameterSpec(iv);
    }
}
