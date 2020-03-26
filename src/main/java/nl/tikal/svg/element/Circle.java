package nl.tikal.svg.element;

import nl.tikal.svg.create.builder.ElementBuilder;

public class Circle extends SvgElement {

    public Circle(int center_x, int center_y, int radius) {
        super();
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
}
