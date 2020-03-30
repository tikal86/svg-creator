package nl.tikal.svg.create;

import static org.junit.Assert.assertThat;
import nl.tikal.svg.element.Circle;
import nl.tikal.svg.element.Style;
import nl.tikal.svg.element.Svg;
import nl.tikal.svg.element.Text;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

/**
 * Unit test for SvgCreator.
 */
public class SvgCreatorTest
{
    @Test
    public void shouldCreateSvgWithCircleAndText() throws IOException {
        SvgCreator.main(new String[]{"Hello world"});
        final Svg svg = new Svg.SvgBuilder(0, 0, 300, 100)
                .with(new Style()
                        .addClassDeclaration(".red { font: italic 40px serif; fill: red; }")
                        .addClassDeclaration(".small { font: italic 13px sans-serif; }")
                        .addClassDeclaration(".heavy { font: bold 30px sans-serif; }")
                )
                .with(new Circle.CircleBuilder(50, 50, 50).build())
                .with(new Text.TextBuilder(50,50, "test", "red").build())
                .build();
        File svgFile = new File("target/blog-deel1.svg");
        final String svgString = printToString(svg);
        assertThat(svgString, CoreMatchers.startsWith("<svg viewBox="));
        assertThat(svgString, CoreMatchers.containsString("viewBox=\"0 0 300 100\""));
        assertThat(svgString, CoreMatchers.containsString("<circle"));
        assertThat(svgString, CoreMatchers.containsString("</circle>"));
        assertThat(svgString, CoreMatchers.containsString("<text"));
        assertThat(svgString, CoreMatchers.containsString("</text>"));
        assertThat(svgString, CoreMatchers.endsWith("</svg>"));
        System.out.println(svgString);
        writeToFile(svgFile, svgString);
        return;
    }

    @Test
    public void shouldCreateSvgWithCircle() throws IOException {
        SvgCreator.main(new String[]{"Hello world"});
        final Svg svg = new Svg.SvgBuilder(0, 0, 300, 100)
                .with(new Circle.CircleBuilder(50, 50, 50).build())
                .build();
        File svgFile = new File("target/blog-deel1.svg");
        final String svgString = printToString(svg);
        assertThat(svgString, CoreMatchers.startsWith("<svg viewBox="));
        assertThat(svgString, CoreMatchers.containsString("viewBox=\"0 0 300 100\""));
        assertThat(svgString, CoreMatchers.containsString("cx=\"50\""));
        assertThat(svgString, CoreMatchers.containsString("cy=\"50\""));
        assertThat(svgString, CoreMatchers.containsString("r=\"50\""));
        assertThat(svgString, CoreMatchers.containsString("cx=\"50\""));
        assertThat(svgString, CoreMatchers.endsWith("</svg>"));
        System.out.println(svgString);
    }

    @Test
    public void shouldCreateSvgWithText() throws IOException {
        SvgCreator.main(new String[]{"Hello world"});
        final Svg svg = new Svg.SvgBuilder(0, 0, 300, 100)
                .with(new Text.TextBuilder(50,50, "test", "small").build())
                .build();
        File svgFile = new File("target/blog-deel1.svg");
        final String svgString = printToString(svg);
        assertThat(svgString, CoreMatchers.startsWith("<svg viewBox="));
        assertThat(svgString, CoreMatchers.containsString("viewBox=\"0 0 300 100\""));
        assertThat(svgString, CoreMatchers.containsString("x=\"50\""));
        assertThat(svgString, CoreMatchers.containsString("y=\"50\""));
        assertThat(svgString, CoreMatchers.containsString("class=\"small\""));
        assertThat(svgString, CoreMatchers.containsString(">test<"));
        assertThat(svgString, CoreMatchers.endsWith("</svg>"));
        System.out.println(svgString);
    }

    private void writeToFile(File svgFile, String svgString) throws IOException {
        FileWriter fileWriter = new FileWriter(svgFile);
        fileWriter.write(svgString);
        fileWriter.flush();
        fileWriter.close();
    }

    private String printToString(Svg svg) throws IOException {
        StringWriter writer = new StringWriter();
        writer.write(svg.toString());
        final String svgString = writer.toString();
        writer.flush();
        writer.close();
        return  svgString;
    }

}
