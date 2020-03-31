package nl.tikal.svg.element;

import nl.tikal.svg.create.builder.ElementBuilder;

import java.util.ArrayList;
import java.util.List;

public class CircleWithText extends SvgElement {
    private static final int TEXT_OFFSET_ONE_DIGIT = 6;
    private static final int TEXT_OFFSET_TWO_DIGITS = 11;

    private int textOffset;
    private List<SvgElement> elements;

    public CircleWithText(int center_x, int center_y, int radius, String strokeClass, String styleClass, String text) {
        super();
        textOffset = TEXT_OFFSET_ONE_DIGIT;
        if (text.length() == 2) {
            textOffset = TEXT_OFFSET_TWO_DIGITS;
        }
        elements = new ArrayList<>();
            elements.add(new Circle.CircleBuilder(center_x, center_y, radius, strokeClass, styleClass).build());
        elements.add(new Text.TextBuilder(center_x - textOffset,center_y + 7, text, "small").build());

    }

    public static class CircleWithTextBuilder extends ElementBuilder {
        private final int center_x;
        private final int center_y;
        private final int radius;
        private String strokeClass;
        private String styleClass;
        private String text;

        public CircleWithTextBuilder(int center_x, int center_y, int radius, String strokeClass, String styleClass, String text) {
            this.center_x = center_x;
            this.center_y = center_y;
            this.radius = radius;
            this.strokeClass = strokeClass;
            this.styleClass = styleClass;
            this.text = text;
        }

        @Override
        public CircleWithText build() {
            return new CircleWithText(center_x, center_y, radius, strokeClass, styleClass, text);
        }
    }

    public String toString() {
        return "<g> " +
                elements.stream()
                        .map(Object::toString)
                        .reduce((elementsString, element)  -> elementsString + element )
                        .orElse("") +
                "></g>";
    }
}
