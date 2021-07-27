package by.lashkevich.jwd.creator;

import by.lashkevich.jwd.entity.Ring;
import by.lashkevich.jwd.entity.Triangle;

import java.util.List;

public interface DataCreator {
    Triangle createTriangle();
    Ring createRing();
    char createSymbol();
    List<Double> createFormulaVariables();
}
