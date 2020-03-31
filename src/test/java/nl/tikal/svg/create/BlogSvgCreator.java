package nl.tikal.svg.create;

import nl.tikal.svg.element.*;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Arrays;

import static org.junit.Assert.assertThat;

/**
 * Unit test for SvgCreator.
 */
public class BlogSvgCreator
{
    @Test
    public void shouldCreateBlogDeel1Svg() throws IOException {
        SvgCreator.main(new String[]{"Blog deel 1"});
        final Svg svg = new Svg.SvgBuilder(0, 0, 660, 340)
                .with(new Style()
                        .addClassDeclaration(".red { font: 40px serif; fill: red; }")
                        .addClassDeclaration(".small { font: 20px sans-serif; }")
                        .addClassDeclaration(".yellowish {fill: rgb(255,203,70); }")
                        .addClassDeclaration(".blue {fill: rgb(62,161,203);}")
                        .addClassDeclaration(".green {fill: rgb(130,215,54);}")
                )
                .with(new Lifeline.LifelineBuilder(20,200,600,200, "black").build())
                .with(new CircleWithText.CircleWithTextBuilder(100, 200, 20, "black", "yellowish", "2").build())
                .with(new Circle.CircleBuilder(200, 200, 20, "black", "blue").build())
                .with(new Text.TextBuilder(189,207, "30", "small").build())
                .with(new Circle.CircleBuilder(250, 200, 20, "black", "green").build())
                .with(new Text.TextBuilder(244,207, "5", "small").build())
                .build();
        File svgFile = new File("target/blog-deel1.svg");
        final String svgString = printToString(svg);
        assertThat(svgString, CoreMatchers.startsWith("<svg viewBox="));
        assertThat(svgString, CoreMatchers.endsWith("</svg>"));
        System.out.println(svgString);
        writeToFile(svgFile, svgString);
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
