package nl.tikal.svg.element;

import nl.tikal.svg.create.builder.ElementBuilder;

public class Line extends SvgElement {

    private final int start_x;
    private final int end_x;
    private final int start_y;
    private final int end_y;
    private final String styleClass;

    public Line(int start_x, int start_y, int end_x, int end_y, String styleClass) {
        super();
        this.start_x = start_x;
        this.end_x = end_x;
        this.start_y = start_y;
        this.end_y = end_y;
        this.styleClass = styleClass;
    }

    public static class LineBuilder extends ElementBuilder {
        private final int start_x;
        private final int end_x;
        private final int start_y;
        private final int end_y;
        private final String styleClass;

        public LineBuilder(int start_x, int start_y, int end_x, int end_y, String styleClass) {
            this.start_x = start_x;
            this.end_x = end_x;
            this.start_y = start_y;
            this.end_y = end_y;
            this.styleClass = styleClass;
        }

        @Override
        public Line build() {
            return new Line(start_x, start_y, end_x, end_y, styleClass);
        }
    }

    public String toString() {
        return "<line " +
                "x1=\"" + start_x + "\" " +
                "y1=\"" + start_y + "\" " +
                "x2=\"" + end_x + "\" " +
                "y2=\"" + end_y + "\" " +
                "stroke=\"" + styleClass + "\"" +
                ">" +
                "</line>";
    }
}
