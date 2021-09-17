package by.lashkevich.figures.view.locale;

import java.util.ResourceBundle;

/**
 * Class for fast properties reading
 * @author Roman Lashkevich
 * @see LocaleType
 */
public class LocaleReader {
    private static final String BUNDLE_NAME = "languages.keywords";
    private static LocaleReader instance;
    private ResourceBundle resourceBundle;

    private LocaleReader() {
        resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME);
    }

    public static LocaleReader getInstance() {
        if (instance == null) {
            instance = new LocaleReader();
        }

        return instance;
    }

    public void setLocaleNumber(int localeNumber) {
        resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME,
                LocaleType.findLocaleType(localeNumber).getLocale());
    }

    public String readMessageFromBundle(String key) {
        return resourceBundle.getString(key);
    }
}
