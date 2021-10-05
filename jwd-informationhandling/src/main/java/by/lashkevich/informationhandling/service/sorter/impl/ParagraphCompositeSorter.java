package by.lashkevich.informationhandling.service.sorter.impl;

import by.lashkevich.informationhandling.entity.TextComponent;
import by.lashkevich.informationhandling.entity.impl.TextComposite;
import by.lashkevich.informationhandling.service.sorter.CompositeSorter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ParagraphCompositeSorter implements CompositeSorter {
    @Override
    public TextComposite sort(TextComposite composite) {
        Comparator<TextComponent> comparing = (Comparator.comparingInt(component -> component.collect()
                .split("[A-ZА-Я]([^.]{3}|[^?!.])*([.]{3}|[.?!])").length));
        List<TextComponent> paragraphs = new ArrayList<>(composite.getComponents());
        paragraphs.sort(comparing);
        TextComposite textComposite = new TextComposite("\t", "\n\n");
        paragraphs.forEach(textComposite::add);
        return textComposite;
    }
}
