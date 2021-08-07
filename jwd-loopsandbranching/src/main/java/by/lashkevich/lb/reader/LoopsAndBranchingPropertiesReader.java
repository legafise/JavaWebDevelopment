package by.lashkevich.lb.reader;

import java.util.ResourceBundle;

/**
 * Class for fast properties reading
 * @author Roman Lashkevich
 * @see by.lashkevich.lb.reader.LocaleType
 */
public class LoopsAndBranchingPropertiesReader {
    private static final String BUNDLE_NAME = "properties.keywords";
    private static LoopsAndBranchingPropertiesReader instance;
    private ResourceBundle resourceBundle;

    private LoopsAndBranchingPropertiesReader() {
        resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME);
    }

    public static LoopsAndBranchingPropertiesReader getInstance() {
        if (instance == null) {
            instance = new LoopsAndBranchingPropertiesReader();
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
