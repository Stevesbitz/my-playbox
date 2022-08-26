import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
//        String st = "agte6352hs";
//        System.out.println("original string "+st);
//
//        String encoded = encode(st);
//        System.out.println("after encoded "+encoded);
//
//        System.out.println("after decoded "+ decode(encoded));
        List<String> listA = List.of("A","B","C","D","E");
        List<String> listB = List.of("S","T","U","V","W");
        List<String> combinedList = Stream.of(listA, listB)
                .flatMap(Collection::stream).collect(Collectors.toList());

        System.out.println("A-"+listA +"\nB-"+listA+" combined-"+combinedList);
    }
}
