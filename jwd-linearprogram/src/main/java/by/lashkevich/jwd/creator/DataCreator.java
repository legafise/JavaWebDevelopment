package by.lashkevich.jwd.creator;

import by.lashkevich.jwd.entity.Ring;
import by.lashkevich.jwd.entity.Triangle;

public interface DataCreator {
    Triangle createTriangle();
    Ring createRing();
    char createSymbol();
}
