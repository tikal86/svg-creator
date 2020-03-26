package nl.tikal.svg.element;

import java.util.List;

public class Svg {
    private int viewbox_minx = 0;
    private int viewbox_miny = 0;
    private int viewbox_width = 0;
    private int viewbox_height = 0;

    public Svg(int min_x, int min_y, int width, int height) {
        viewbox_minx = min_x;
        viewbox_miny = min_y;
        viewbox_width = width;
        viewbox_height = height;
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
        }

        public SvgBuilder withViewBox(int minx, int miny, int width, int height) {
            return new SvgBuilder(minx, miny, width, height);
        }

        public SvgBuilder circle(int center_x, int center_y, int radius) {
            elements.add(new Circle.CircleBuilder(center_x, center_y, radius).build());
            return this;
        }

        public SvgBuilder with(Circle circle) {
            elements.add(circle);
            return this;
        }

        public Svg build() {
            Svg svg = new Svg(viewbox_minx, viewbox_miny, viewbox_width, viewbox_height);
            return svg;
        }
    }
}
