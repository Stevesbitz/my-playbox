import lombok.Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws ParseException {
//        String st = "agte6352hs";
//        System.out.println("original string "+st);
//
//        String encoded = encode(st);
//        System.out.println("after encoded "+encoded);
//
//        System.out.println("after decoded "+ decode(encoded));
//        List<String> listA = List.of("A","B","C","D","E");
//        List<String> listB = List.of("S","T","U","V","W");
//        List<String> combinedList = Stream.of(listA, listB)
//                .flatMap(Collection::stream).collect(Collectors.toList());
//        dateChecker("30-Aug-2022");
        BlacklistItems low = new BlacklistItems("BI01", Severity.LOW);
        BlacklistItems medium = new BlacklistItems("BI02", Severity.MEDIUM);
        BlacklistItems high =  new BlacklistItems("BI03", Severity.HIGH);

        List<BlackListed> blacklistUsersRepository = List.of(
               new BlackListed(medium, "US01", Status.NEW) ,
               new BlackListed(high, "US01", Status.RESOLVED) ,
               new BlackListed(medium, "US04", Status.NEW) ,
               new BlackListed(medium, "US06", Status.NEW) ,
               new BlackListed(low, "US01", Status.RESOLVED) //findAllByUserIdAndBlacklistStatus
        );


        List<BlackListed> unresolvedBlackListRecord = blacklistUsersRepository.stream()
                .filter(i -> i.getUserId().equals("US01") && i.getStatus().equals(Status.NEW)).collect(Collectors.toList());
        List<BlackListed> resolvedBlackListRecord = blacklistUsersRepository.stream()
                .filter(i -> i.getUserId().equals("US01") && i.getStatus().equals(Status.RESOLVED)).collect(Collectors.toList());


//        System.out.println("unresolved "+unresolvedBlackListRecord+"\nresolved: "+ resolvedBlackListRecord);
//        List<BlacklistItems> unresolvedBlackListItems = unresolvedBlackListRecord.stream()
//                .map(record -> blacklistItemsRequestRepository.findById(record.getBlacklistId()).get()).collect(Collectors.toList());
//
//        List<BlacklistItems> unresolvedBlackListItems = List.of(
//                new BlacklistItems("01", Status.NEW, Severity.LOW)
////                new BlacklistItems("01", Status.NEW, Severity.MEDIUM)
////                new BlacklistItems("01", Status.NEW, Severity.MEDIUM),
////                new BlacklistItems("01", Status.NEW, Severity.HIGH)
//        );
//
        Severity query = Severity.HIGH;
        boolean status = checkSeverity(unresolvedBlackListRecord, query);
//        System.out.println(status ? status+" blacklisted" : status+" not blacklisted");

        dateChecker("24/06/2022");

    }

    static boolean checkSeverity(List<BlackListed> list, Severity severity) {
        return list.stream().anyMatch(item -> item.getBlackListItems().getSeverity().equals(severity) || item.getBlackListItems().getSeverity().ordinal() > severity.ordinal());
//        return list.stream().anyMatch(item -> item.getSeverity().equals(severity) || item.getSeverity().ordinal() > severity.ordinal());
    }

    static void dateChecker(String date) throws ParseException {
//        SimpleDateFormat formatter =new SimpleDateFormat("dd-MMM-yyyy");
        SimpleDateFormat formatter =new SimpleDateFormat("dd/MM/yyyy");
        Date pDate = formatter.parse(date);

        boolean isExp = new Date().after(pDate);
        System.out.printf("pDate %s,\nis-expired: %s", pDate, isExp);

        /**
         *   LocalDate expiryDate = LocalDate.parse(date);
         *   return LocalDate.now().isAfter(expiryDate);
         */
//        Date pDate = new Date("29-Aug-2022");
    }
}

@Data
class BlacklistItems {
    private String id;
    private Severity severity;

    public BlacklistItems(String id, Severity severity) {
        this.id = id;
        this.severity = severity;
    }
}

@Data
class BlackListed {
    private BlacklistItems blackListItems;
    private String userId;
    private Status status;


    public BlackListed(BlacklistItems blackListItems, String userId, Status status) {
        this.blackListItems = blackListItems;
        this.userId = userId;
        this.status = status;
    }
}

enum Status {
    NEW, RESOLVED
}

enum Severity {
    LOW, MEDIUM, HIGH
}
