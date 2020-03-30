package nl.tikal.svg.element;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Style extends SvgElement {
    List<String> styles;

    public Style() {
        styles = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "<style>\n" +
                "    /* Note that the color of the text is set with the    *\n" +
                "     * fill property, the color property is for HTML only */\n" +
                styles.stream()
                .map(Object::toString)
                        .collect(Collectors.joining("\n")) +
                "</style>";
    }

    public Style addClassDeclaration(String classDeclaration) {
        styles.add(classDeclaration);
        return this;
    }
}
