package nl.tikal.svg.element;

import nl.tikal.svg.create.builder.ElementBuilder;

public class Text extends SvgElement {

    private final int x;
    private final int y;
    private final String styleClass;
    private final String text;

    public Text(int x, int y, String text, String styleClass) {
        super();
        this.x = x;
        this.y = y;
        this.styleClass = styleClass;
        this.text = text;
    }

    public static class TextBuilder extends ElementBuilder {
        private final int x;
        private final int y;
        private String text;
        private final String styleClass;

        public TextBuilder(int x, int y, String text, String styleClass) {
            this.x = x;
            this.y = y;
            this.text = text;
            this.styleClass = styleClass;
        }

        @Override
        public Text build() {
            return new Text(x, y, text, styleClass);
        }
    }

    public String toString() {
        return "<text " +
                "x=\"" + x + "\" " +
                "y=\"" + y + "\" " +
                "class=\"" + styleClass + "\"" +
                ">" +
                text +
                "</text>";
    }
}
