package BasicJava.day00003.point02RegularExpressions.matches;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchesAndLookingAtMethods {
    private static final String REGEX = "foo";
    private static final String INPUT = "fooo";

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(INPUT);
        System.out.println("Current REGEX is: " + REGEX);
        System.out.println("Current REGEX is: " + INPUT);

        System.out.println("lookingAt(): " + matcher.lookingAt());
        System.out.println("matches(): " + matcher.matches());
    }
}
