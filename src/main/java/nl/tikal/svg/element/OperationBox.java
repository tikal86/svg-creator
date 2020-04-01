package nl.tikal.svg.element;

import nl.tikal.svg.create.builder.ElementBuilder;

public class OperationBox extends SvgElement {

    private final int start_x;
    private final int end_x;
    private int y;
    private final String text;

    public OperationBox(int start_x, int end_x, int y, String text, String styleClass) {
        super();
        this.start_x = start_x;
        this.end_x = end_x;
        this.y = y;
        this.text = text;
    }

    public static class OperationBoxBuilder extends ElementBuilder {
        private final int start_x;
        private final int end_x;
        private int y;
        private String text;

        public OperationBoxBuilder(int start_x, int end_x, int y, String text) {
            this.start_x = start_x;
            this.end_x = end_x;
            this.y = y;
            this.text = text;
        }

        @Override
        public OperationBox build() {
            return new OperationBox(start_x, end_x, y, text, text);
        }
    }

    public String toString() {
        return "<rect class=\"operationbox\" " +
                    "fill=\"white\" stroke=\"black\" " +
                    "x=\"" + start_x + "\" " +
                    "y=\"" + (y - 50) + "\" " +
                    "width=\"" + (end_x - start_x) + "\" " +
                    "height=\"" + 100 + "\" />" +
                "<text " +
                    "x=\"" + ((end_x - start_x)/2 - text.length() * 7) + "\" " +
                    "y=\"" + (y + 14) + "\" " +
                    "class=\"large\"" +
                    ">" +
                    text +
                "</text>";
    }
}
