package by.lashkevich.figures.controller.command.reporter;

import by.lashkevich.figures.entity.Tetrahedron;
import by.lashkevich.figures.view.locale.LocaleReader;

import java.util.Collection;

public class TetrahedronReporter {
    private static final String TETRAHEDRONS_INFO_KEY = "reporter.tetrahedrons.info";
    private static final String NEW_LINE_BREAK = "\n";
    private final LocaleReader localeReader;

    public TetrahedronReporter() {
        localeReader = LocaleReader.getInstance();
    }

    public void reportTetrahedronsInfo(Collection<Tetrahedron> tetrahedronCollection) {
        System.out.println(localeReader.readMessageFromBundle(TETRAHEDRONS_INFO_KEY)
                + tetrahedronCollection + NEW_LINE_BREAK);
    }
}
