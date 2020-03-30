package nl.tikal.svg.element;

import nl.tikal.svg.create.builder.ElementBuilder;

public class Circle extends SvgElement {

    private final int center_x;
    private final int center_y;
    private final int radius;
    private String strokeClass;
    private String styleClass;

    public Circle(int center_x, int center_y, int radius, String strokeClass, String styleClass) {
        super();
        this.center_x = center_x;
        this.center_y = center_y;
        this.radius = radius;
        this.strokeClass = strokeClass;
        this.styleClass = styleClass;
    }

    public static class CircleBuilder extends ElementBuilder {
        private final int center_x;
        private final int center_y;
        private final int radius;
        private String strokeClass;
        private String styleClass;

        public CircleBuilder(int center_x, int center_y, int radius, String strokeClass, String styleClass) {
            this.center_x = center_x;
            this.center_y = center_y;
            this.radius = radius;
            this.strokeClass = strokeClass;
            this.styleClass = styleClass;
        }

        @Override
        public Circle build() {
            return new Circle(center_x, center_y, radius, strokeClass, styleClass);
        }
    }

    public String toString() {
        return "<circle " +
                "class=\"" + styleClass + "\" " +
                "cx=\"" + center_x + "\" " +
                "cy=\"" + center_y + "\" " +
                "r=\"" + radius + "\" " +
                "stroke=\"" + strokeClass + "\" " +
                "></circle>";
    }
}
