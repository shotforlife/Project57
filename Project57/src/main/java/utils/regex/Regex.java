package utils.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by mukhin on 10/10/2016.
 */
public class Regex {
    public static String regexCheck(String str) {
        String result = null;
        Pattern pattern = Pattern.compile("\\d");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            result = matcher.group();
        }
        return result;
    }

    public static double regexReadingPrice(String str) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher m = pattern.matcher(str);
        StringBuilder sb = new StringBuilder();
        while (m.find()){
            String bw = m.group();
            sb.append(bw);
        }
        String s = new String(sb);
        return new Double(s);
    }
}
