package tv.nosy.cli.models.utilities;

import java.nio.charset.Charset;
import java.util.Random;

public class Generater {
    public static String generateKeyValue(){
        byte[] array = new byte[10]; // length is bounded by 7
        new Random().nextBytes(array);
        String key = new String(array, Charset.forName("UTF-8"));
        
        return key;
    }
}
