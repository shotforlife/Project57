package com.nix.regex;

import com.sun.xml.internal.ws.server.ServerRtException;

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
}
