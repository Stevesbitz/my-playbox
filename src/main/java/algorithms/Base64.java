package algorithms;

import org.apache.commons.codec.binary.StringUtils;

public class Base64 {

    public static void main(String[] args) {
//        String st = "agte6352hs";
//        System.out.println("original string "+st);
//
//        String encoded = encode(st);
//        System.out.println("after encoded "+encoded);
//
//        System.out.println("after decoded "+ decode(encoded));

        double high = 99.99864196777344;
        double low = 49.99864196777344;
        double m = 55.0035682;

        System.out.println(low > m ? "match" : "no match");
    }

    private static final java.util.Base64.Encoder base64Encoder = java.util.Base64.getEncoder();
    private static final java.util.Base64.Decoder base64Decoder = java.util.Base64.getDecoder();

    public static String encode(String string) {
        byte[] bytes = string.getBytes();
        return base64Encoder.encodeToString(bytes);
    }

    // Generates 6 digits code.
    public static String decode(String base64) {
        byte[] bytes = base64Decoder.decode(base64);
        return StringUtils.newStringUtf8(bytes);
    }
}
