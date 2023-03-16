package BasicJava.day00003.point02RegularExpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CaptureGroups {
    public static void main(String[] args) {
        String line = "This order was placed for QT3000! OK?";
        String pattern = "(.*)(\\d+)(.*)";

        Pattern pattern1 = Pattern.compile(pattern);

        Matcher matcher = pattern1.matcher(line);
        if (matcher.find()) {
            System.out.println("Found value: " + matcher.group(0));
            System.out.println("Found value: " + matcher.group(1));
            System.out.println("Found value: " + matcher.group(2));
        } else {
            System.out.println("NO MATCH");
        }
    }
}
