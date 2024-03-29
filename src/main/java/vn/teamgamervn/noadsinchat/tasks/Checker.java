package vn.teamgamervn.noadsinchat.tasks;

import vn.teamgamervn.noadsinchat.data.Config;

import java.util.HashSet;
import java.util.Locale;
import java.util.regex.Pattern;

public class Checker {
    HashSet<Pattern> patterns;

    public Checker() {
        patterns = new HashSet<>();
        loadChecker();
    }

    public void loadChecker() {
        patterns.clear();
        if (Config.isRegexEnabled())
            for (String i : Config.getTriggers()) {
                patterns.add(Pattern.compile(i));
            }
    }

    public boolean checkMessage(String message) {
        if (!Config.isRegexEnabled()) {
            String msg = message.toLowerCase(Locale.ROOT);
            for (String i : Config.getTriggers()) {
                if (msg.contains(i.toLowerCase(Locale.ROOT))) return true;
            }
        } else {
            for (Pattern pattern : patterns) {
                if (pattern.matcher(message).find()) {
                    return true;
                }
            }
        }
        return false;
    }
}
