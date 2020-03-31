package nl.tikal.svg.element;

import nl.tikal.svg.create.builder.ElementBuilder;

public class OperationBox extends SvgElement {

    private final int start_x;
    private final int end_x;
    private final String text;

    public OperationBox(int start_x, int end_x, String text, String styleClass) {
        super();
        this.start_x = start_x;
        this.end_x = end_x;
        this.text = text;
    }

    public static class OperationBoxBuilder extends ElementBuilder {
        private final int start_x;
        private final int end_x;
        private String text;

        public OperationBoxBuilder(int start_x, int end_x, String text) {
            this.start_x = start_x;
            this.end_x = end_x;
            this.text = text;
        }

        @Override
        public OperationBox build() {
            return new OperationBox(start_x, end_x, text, text);
        }
    }

    public String toString() {
        return "<rect " +
                "x=\"" + (start_x - text.length() * 10) + "\" " +
                "y=\"" + (end_x + text.length() * 10) + "\" " +
                "width=\"" + (end_x - start_x) + "\" " +
                "height=\"" + 100 + "\" />" +
                "<text " +
                "x=\"" + (start_x - text.length() * 10) + "\" " +
                "y=\"" + (end_x + text.length() * 10) + "\" " +
                "class=\"black\"" +
                ">" +
                text +
                "</text>";
    }
}
