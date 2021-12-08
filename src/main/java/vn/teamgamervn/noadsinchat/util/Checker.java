package vn.teamgamervn.noadsinchat.util;

import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Checker {
//    HashSet<Pattern> patterns;
//    public Checker(List<String> patternList) {
//        patterns = new HashSet<>();
//        for (String i : patternList) {
//            patterns.add(Pattern.compile(i));
//        }
//    }
    public boolean checkRegex(String text, String regEx) {
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(text);
        return matcher.find();
    }
}
