package day00003.point02RegularExpressions.matches;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AppendReplacementAndAppendTailMethods {
    private static String REGEX = "a*b";
    private static String INPUT = "aabfooaabfooabfoob";
    private static String REPLACE = "-";

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(INPUT);
        StringBuffer stringBuffer= new StringBuffer();
        while (matcher.find()){
            matcher.appendReplacement(stringBuffer,REPLACE);
        }
        matcher.appendTail(stringBuffer);
        System.out.println(stringBuffer);
    }

}
