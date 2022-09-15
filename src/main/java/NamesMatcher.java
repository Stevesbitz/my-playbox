import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.similarity.JaroWinklerSimilarity;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Data
public class NamesMatcher {
    public final static int DEFAULT_MIN_MATCH_COUNT = 2;
    public final static double DEFAULT_SIMILARITY_THRESHOLD = 0.90;
    public final static double DEFAULT_MIN_MATCH_PERCENT = 0.65;

    /**
     * This indicates the minimum number of names that must in the groups compared
     * Expects (number of matches) >= minMatchCount
     */
    private final int minMatchCount;

    /**
     * Indicates the minimum threshold to use before considering names as the same.
     * For a & b to be considered a match, similarity(a, b) >= similarityThreshold
     */
    private final double similarityThreshold;

    /**
     * Indicates the minimum number of percentage of names. This is bounded by minimum match.
     * The (number of matches / length of longer group) >=  minMatchPercent
     */
    private final double minMatchPercent;

    private final JaroWinklerSimilarity jaroWinklerSimilarity;

    public NamesMatcher(int minMatchCount, double similarityThreshold, double minMatchPercent) {
        this.minMatchCount = minMatchCount;
        this.similarityThreshold = similarityThreshold;
        this.minMatchPercent = minMatchPercent;
        jaroWinklerSimilarity = new JaroWinklerSimilarity();
    }

    public NamesMatcher() {
        this(DEFAULT_MIN_MATCH_COUNT, DEFAULT_SIMILARITY_THRESHOLD, DEFAULT_MIN_MATCH_PERCENT);
    }


    private static List<String> breakApart(String name) {
        List<String> parts = new LinkedList<>(Arrays.asList(name.trim().toUpperCase().split("[ ,]+")));
        parts.sort((c1, c2) -> c2.length() - c1.length());
        return parts;
    }

    public boolean checkMatch(String names1, String names2) {
        List<String> group1 = breakApart(names1);
        List<String> group2 = breakApart(names2);
        float largerGroupSize = Math.max(group1.size(), group2.size());
        int matches = 0;
        for (String baseName : group1) {
            Iterator<String> it = group2.iterator();
            while (it.hasNext()) {
                String compName = it.next();
                if (isSimilar(baseName, compName)) {
                    it.remove();
                    matches++;
                    break;
                }
            }
        }

        float matchPercent = matches / largerGroupSize;

        System.out.printf("%s <> %s => Matches = %s, Match percent = %s\n", names1, names2, matches, matchPercent);
        return matches >= minMatchCount && matchPercent >= minMatchPercent;
    }

    private boolean isSimilar(String s1, String s2) {
        double forwardScore = jaroWinklerSimilarity.apply(s1, s2);
        System.out.printf("%s <> %s FORWARD SCORE %s\n", s1, s2, forwardScore);
        if (forwardScore >= similarityThreshold) {
            return true;
        }

        double reverseScore = jaroWinklerSimilarity.apply(StringUtils.reverse(s1), StringUtils.reverse(s2));
        System.out.printf("%s <> %s REVERSE SCORE %s\n", s1, s2, reverseScore);
        return reverseScore >= similarityThreshold;
    }

    public static void main(String[] args) {
        NamesMatcher matcher = new NamesMatcher();

//        System.out.println(matcher.checkMatch("SA'ADAT SHUAIB", "SAADAT SHUAIB"));
        System.out.println(matcher.checkMatch("adebayo ifeoluwa s", "ifeoluwa stephen adebayo"));
    }
}
