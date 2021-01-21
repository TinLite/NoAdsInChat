package vn.teamgamervn.noadsinchat.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Checker {

    public boolean checkRegex(String text, String regEx) {
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) return true;
        return false;
    }

    public boolean checkText(String text, String quer) {
        text = text.toLowerCase();
        quer = quer.toLowerCase();
        return text.contains(quer);
    }
}
