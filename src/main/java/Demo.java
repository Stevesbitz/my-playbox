import java.util.List;
import java.util.StringTokenizer;
import java.util.UUID;

public class Demo {

    public static void main(String[] args) {
        UUID uUserId = UUID.randomUUID();

        String msg = String.format(ErrorType.BLACKLISTED_USER.getMessage(), uUserId);
//        System.out.println(msg);
        List<BLACKLIST_SEVERITY> unresolvedBlackListItems = List.of(BLACKLIST_SEVERITY.MEDIUM, BLACKLIST_SEVERITY.HIGH);
        var query = BLACKLIST_SEVERITY.LOW;
        boolean status = unresolvedBlackListItems.stream()
                .anyMatch(item -> item.equals(query) || item.ordinal() > query.ordinal());
//        boolean status3 = unresolvedBlackListItems.stream()
//                .anyMatch(item -> item.ordinal() >= query.ordinal());
        boolean status2 = unresolvedBlackListItems.stream()
                .anyMatch(item -> item.equals(query));
        System.out.println(status);
        System.out.println(status2);
//        System.out.println(status3);

    }


    public enum ErrorType {
        BLACKLISTED_USER("UNRESOLVED OFFENSE WITH MEDIUM SEVERITY FOUND FOR USER %s");

        private String message;

        ErrorType(String message) {
            this.message = message;
        }
        public String getMessage() {
            return message;
        }

    }

    public enum BLACKLIST_SEVERITY {
        LOW, MEDIUM, HIGH
    }
}
