package BasicJava.day00003.point02RegularExpressions.matches;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceFirstAndReplaceAllMethods {
    private static String INPUT = "The dogG says meow. " + "All dogs say meow";

    public static void main(String[] args) {
        String REGEX = "dog";
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(INPUT);
        String REPLACE = "cat";
        INPUT = matcher.replaceAll(REPLACE);
        System.out.println(INPUT);
        INPUT = matcher.replaceFirst(REGEX);
        System.out.println(INPUT);
    }
}
