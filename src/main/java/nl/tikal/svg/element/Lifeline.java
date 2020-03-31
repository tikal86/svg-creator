package nl.tikal.svg.element;

import nl.tikal.svg.create.builder.ElementBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lifeline extends SvgElement {

    private final int start_x;
    private final int end_x;
    private final int start_y;
    private final int end_y;
    private final String styleClass;
    private List<SvgElement> elements;

    public Lifeline(int start_x, int start_y, int end_x, int end_y, String styleClass) {
        super();
        this.start_x = start_x;
        this.end_x = end_x;
        this.start_y = start_y;
        this.end_y = end_y;
        this.styleClass = styleClass;
        elements = new ArrayList<>();
        elements.add(new Line.LineBuilder(start_x,start_y,end_x,end_y, "black").build());
        elements.add(new Line.LineBuilder(end_x - 40,start_y - 15,end_x - 40,start_y + 15, "black").build());
        elements.add(new Polygon.PolygonBuilder(Arrays.asList(new Point(end_x,start_y -10), new Point(end_x + 30,start_y), new Point(end_x,start_y + 10)),"black","black").build());

    }

    public static class LifelineBuilder extends ElementBuilder {
        private final int start_x;
        private final int end_x;
        private final int start_y;
        private final int end_y;
        private final String styleClass;

        public LifelineBuilder(int start_x, int start_y, int end_x, int end_y, String styleClass) {
            this.start_x = start_x;
            this.end_x = end_x;
            this.start_y = start_y;
            this.end_y = end_y;
            this.styleClass = styleClass;
        }

        @Override
        public Lifeline build() {
            return new Lifeline(start_x, start_y, end_x, end_y, styleClass);
        }
    }

    public String toString() {
        return "<g> " +
                elements.stream()
                        .map(Object::toString)
                        .reduce((elementsString, element)  -> elementsString + element )
                        .orElse("") +
                "</g>";
    }
}
