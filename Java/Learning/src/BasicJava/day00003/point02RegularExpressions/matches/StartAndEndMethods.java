package BasicJava.day00003.point02RegularExpressions.matches;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StartAndEndMethods {
    private static final String REGEX = "\\bcat\\b";
    private static final String INPUT = "cat cat catu cattie cat";

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(INPUT);
        int count = 0;

        while (matcher.find()){
            count++;
            System.out.println("Match Number "+count);
            System.out.println("start() "+matcher.start());
            System.out.println("end() "+matcher.end());
        }
    }

}
