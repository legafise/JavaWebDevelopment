package by.lashkevich.arrays.arraysutill.reader;

import java.util.ResourceBundle;

/**
 * Class for fast properties reading
 * @author Roman Lashkevich
 * @see LocaleType
 */
public class ArraysPropertiesReader {
    private static final String BUNDLE_NAME = "locale.keywords";
    private static ArraysPropertiesReader instance;
    private ResourceBundle resourceBundle;

    private ArraysPropertiesReader() {
        resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME);
    }

    public static ArraysPropertiesReader getInstance() {
        if (instance == null) {
            instance = new ArraysPropertiesReader();
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
