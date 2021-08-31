package by.lashkevich.bills.view.locale;

import java.util.Arrays;
import java.util.Locale;
import java.util.function.Predicate;

/**
 * Enum with fast access to locale types
 * @author Roman Laskevich
 */
public enum LocaleType {
    RUSSIAN_LOCALE(1) {
        @Override
        Locale getLocale() {
            return new Locale(RU_LANGUAGE, RU_COUNTRY);
        }
    },
    USA_LOCALE(2) {
        @Override
        Locale getLocale() {
            return new Locale(EN_LANGUAGE, US_COUNTRY);
        }
    };

    private static final String RU_LANGUAGE = "ru";
    private static final String EN_LANGUAGE = "en";
    private static final String RU_COUNTRY = "RU";
    private static final String US_COUNTRY = "US";
    private int localeNumber;

    LocaleType(int localeNumber) {
        this.localeNumber = localeNumber;
    }

    abstract Locale getLocale();

    public int getLocaleNumber() {
        return localeNumber;
    }

    public static LocaleType findLocaleType(int localeNumber) {
        Predicate<LocaleType> localeTypePredicate = localeType -> localeNumber == localeType.getLocaleNumber();
        return Arrays.stream(LocaleType.values())
                .filter(localeTypePredicate)
                .findAny().orElse(USA_LOCALE);
    }
}
