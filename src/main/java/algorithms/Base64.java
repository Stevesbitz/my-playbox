package algorithms;

import org.apache.commons.codec.binary.StringUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Base64 {
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
