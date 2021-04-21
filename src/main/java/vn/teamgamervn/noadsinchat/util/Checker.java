package vn.teamgamervn.noadsinchat.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Checker {

    public boolean checkRegex(String text, String regEx) {
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(text);
        return matcher.find();
    }
}
