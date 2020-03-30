package nl.tikal.svg.element;

import nl.tikal.svg.create.builder.ElementBuilder;

import java.util.List;
import java.util.stream.Collectors;

public class Polygon extends SvgElement {

    private List<Point> points;
    private String fillClass;
    private String strokeClass;

    public Polygon(List<Point> points, String fillClass, String strokeClass) {
        super();
        this.points = points;
        this.fillClass = fillClass;
        this.strokeClass = strokeClass;
    }

    public static class PolygonBuilder extends ElementBuilder {
        private List<Point> points;
        private String fillClass;
        private String strokeClass;

        public PolygonBuilder(List<Point> points, String fillClass, String strokeClass) {
            this.points = points;
            this.fillClass = fillClass;
            this.strokeClass = strokeClass;
        }

        @Override
        public Polygon build() {
            return new Polygon(points, fillClass, strokeClass);
        }
    }

    public String toString() {
        return "<polygon " +
                "points=\"" + points.stream()
                .map(Object::toString)
                .collect(Collectors.joining(" ")) +
                "\" " +
                " fill=\"" + fillClass + "\"" +
                " stroke=\"" + strokeClass + "\"" +
                "/>";
    }
}
