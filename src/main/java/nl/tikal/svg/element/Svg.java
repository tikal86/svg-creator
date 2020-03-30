package nl.tikal.svg.element;

import java.util.ArrayList;
import java.util.List;

public class Svg {
    private int viewbox_minx = 0;
    private int viewbox_miny = 0;
    private int viewbox_width = 0;
    private int viewbox_height = 0;
    private final List<SvgElement> elements;

    public Svg(final int min_x, final int min_y, final int width, final int height, final List<SvgElement> elements) {
        viewbox_minx = min_x;
        viewbox_miny = min_y;
        viewbox_width = width;
        viewbox_height = height;
        this.elements = elements;
    }

    public String toString() {
        return "<svg viewBox=\"" +
                viewbox_minx + " " +
                viewbox_miny + " " +
                viewbox_width + " " +
                viewbox_height + "\"" +
                " xmlns=\"http://www.w3.org/2000/svg\">" +
                elements.stream()
                        .map(Object::toString)
                        .reduce((elementsString, element)  -> elementsString + element )
                .orElse("")+
                "</svg>";
    }

    public static class SvgBuilder {
        private int viewbox_minx = 0;
        private int viewbox_miny = 0;
        private int viewbox_width = 0;
        private int viewbox_height = 0;

        private List<SvgElement> elements;

        public SvgBuilder(int minx, int miny, int width, int height) {
            this.viewbox_minx = minx;
            this.viewbox_miny = miny;
            this.viewbox_width = width;
            this.viewbox_height = height;
            elements = new ArrayList<>();
        }

        public SvgBuilder with(SvgElement element) {
            elements.add(element);
            return this;
        }

        public Svg build() {
            Svg svg = new Svg(viewbox_minx, viewbox_miny, viewbox_width, viewbox_height, elements);
            return svg;
        }

    }

}
