package nl.tikal.svg.create;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import nl.tikal.svg.create.SvgCreator;
import nl.tikal.svg.element.Circle;
import nl.tikal.svg.element.Svg;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

/**
 * Unit test for simple App.
 */
public class SvgCreatorTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() throws IOException {
        SvgCreator.main(new String[]{"Hello world"});
        final Svg svg = new Svg.SvgBuilder(0, 0, 300, 100)
                .with(new Circle.CircleBuilder(50, 50, 50).build())
                .build();
        File svgFile = new File("target/blog-deel1.svg");
        StringWriter writer = new StringWriter();
        writer.write(svg.toString());
        final String svgString = writer.toString();
        writer.flush();
        writer.close();
        assertThat(svgString, CoreMatchers.startsWith("<svg viewport="));
        assertThat(svgString, CoreMatchers.containsString("viewport=\"0 0 300 100\""));
        assertThat(svgString, CoreMatchers.containsString("cx=\"50\""));
        assertThat(svgString, CoreMatchers.containsString("cy=\"50\""));
        assertThat(svgString, CoreMatchers.containsString("r=\"50\""));
        assertThat(svgString, CoreMatchers.containsString("cx=\"50\""));
        assertThat(svgString, CoreMatchers.endsWith("</svg>"));
        System.out.println(svgString);
        FileWriter fileWriter = new FileWriter(svgFile);
        fileWriter.write(svgString);
        fileWriter.flush();
        fileWriter.close();
    }
}
