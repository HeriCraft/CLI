package tv.nosy.cli.models.utilities;

import java.nio.charset.Charset;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import tv.nosy.cli.models.dao.Cd;

public class Generater {
    public static String generateKeyValue() {
        byte[] array = new byte[10]; // length is bounded by 7
        new Random().nextBytes(array);
        String key = new String(array, Charset.forName("UTF-8"));

        return key;
    }

    public static Cd generateLittleCode(String cd) throws NoSuchAlgorithmException {
        Cd res = new Cd();
        res.setCode(cd);
        res.setIdCd(0);

        return res;
    }
}
