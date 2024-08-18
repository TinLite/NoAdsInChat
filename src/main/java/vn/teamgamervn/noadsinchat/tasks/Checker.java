package vn.teamgamervn.noadsinchat.tasks;

import vn.teamgamervn.noadsinchat.data.Config;

import java.util.HashSet;
import java.util.Locale;
import java.util.regex.Pattern;

public class Checker {
    HashSet<Pattern> patterns;
    private static Checker instance;

    private Checker() {
        patterns = new HashSet<>();
        loadChecker();
    }

    public static Checker getChecker() {
        if (instance == null) {
            instance = new Checker();
        }
        return instance;
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
