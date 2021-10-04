package by.lashkevich.informationhandling.entity.impl;

import by.lashkevich.informationhandling.entity.TextComponent;
import by.lashkevich.informationhandling.entity.Composite;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements Composite {
    private static final String STANDARD_FIRST_GLUE_SYMBOL = "";
    private static final String STANDARD_SECOND_GLUE_SYMBOL = "";
    private final List<TextComponent> components;
    private String firstGlueSymbol;
    private String secondGlueSymbol;

    public TextComposite() {
        this.components = new ArrayList<>();
        this.firstGlueSymbol = STANDARD_FIRST_GLUE_SYMBOL;
        this.secondGlueSymbol = STANDARD_SECOND_GLUE_SYMBOL;
    }

    public TextComposite(String firstGlueSymbol, String secondGlueSymbol) {
        this.components = new ArrayList<>();
        this.firstGlueSymbol = firstGlueSymbol;
        this.secondGlueSymbol = secondGlueSymbol;
    }

    @Override
    public void add(TextComponent component) {
        components.add(component);
    }

    @Override
    public void remove(TextComponent component) {
        components.remove(component);
    }

    @Override
    public TextComponent getChild(int index) {
        return components.get(index);
    }

    @Override
    public List<TextComponent> getComponents() {
        return new ArrayList<>(components);
    }

    @Override
    public String collect() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < components.size(); i++) {
            if (i == components.size() - 1) {
                stringBuilder.append(firstGlueSymbol).append(components.get(i).collect());
            } else {
                stringBuilder.append(firstGlueSymbol).append(components.get(i).collect()).append(secondGlueSymbol);
            }
        }

        return stringBuilder.toString();
    }
}
