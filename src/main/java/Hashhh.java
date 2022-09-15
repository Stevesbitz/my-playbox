import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import com.google.common.hash.Hashing;
import java.nio.charset.StandardCharsets;
import java.security.Key;

@AllArgsConstructor
public class Hashhh {

    public static void main(String[] args) {
        System.out.println(isValidHash("Hello"));
    }
    private static final Key secretKey = new Key() {
        @Override
        public String getAlgorithm() {
            return "DSA";
        }

        @Override
        public String getFormat() {
            return "X.509";
        }

        @Override
        public byte[] getEncoded() {
            return new byte[0];
        }
    };


    public static String isValidHash(String payloadBody) {
        String payloadHash = Hashing.hmacSha256(secretKey)
                .hashString(payloadBody, StandardCharsets.UTF_8)
                .toString();
        return payloadHash;
    }
}
