package by.lashkevich.informationhandling.entity;

import java.util.List;

public interface Composite extends TextComponent {
    void add(TextComponent component);
    void remove(TextComponent component);
    TextComponent getChild(int index);
    List<TextComponent> getComponents();
}
