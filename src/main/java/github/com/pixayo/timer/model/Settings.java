package github.com.pixayo.timer.model;

import java.util.prefs.Preferences;

public class Settings {

    private static final Preferences prefs = Preferences.userNodeForPackage(Settings.class);

    private static final String DARK_MODE_KEY = "dark_mode";
    private static final String DISABLE_LABEL_KEY = "disable_label";

    public static boolean isDarkMode() {
        return prefs.getBoolean(DARK_MODE_KEY, true);
    }

    public static void setDarkMode(boolean isDark) {
        prefs.putBoolean(DARK_MODE_KEY, isDark);
    }

    public static boolean isLabelDisabled() {
        return prefs.getBoolean(DISABLE_LABEL_KEY, false);
    }

    public static void setLabelDisabled(boolean isDisabled) {
        prefs.putBoolean(DISABLE_LABEL_KEY, isDisabled);
    }
}