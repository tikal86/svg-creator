package nl.tikal.svg.element;

import nl.tikal.svg.create.builder.ElementBuilder;

public class Circle extends SvgElement {

    private final int center_x;
    private final int center_y;
    private final int radius;

    public Circle(int center_x, int center_y, int radius) {
        super();
        this.center_x = center_x;
        this.center_y = center_y;
        this.radius = radius;
    }

    public static class CircleBuilder extends ElementBuilder {
        private final int center_x;
        private final int center_y;
        private final int radius;

        public CircleBuilder(int center_x, int center_y, int radius) {
            this.center_x = center_x;
            this.center_y = center_y;
            this.radius = radius;
        }

        @Override
        public Circle build() {
            return new Circle(center_x, center_y, radius);
        }
    }

    public String toString() {
        return "<circle " +
                "cx=\"" + center_x + "\" " +
                "cy=\"" + center_y + "\" " +
                "r=\"" + radius + "\"" +
                "></circle>";
    }
}
