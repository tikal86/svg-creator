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
    public void shouldCreateObservableSvg() throws IOException {
        SvgCreator.main(new String[]{"Blog deel 1"});
        final int start_x = 20;
        final int end_x = 600;
        final int start_y = 100;
        final int horzontal_distance = 50;
        final int vertical_distance = 100;
        final Svg svg = new Svg.SvgBuilder(0, 0, 660, 340)
                .with(new Style()
                        .addClassDeclaration(".red { font: 40px serif; fill: red; }")
                        .addClassDeclaration(".small { font: 20px sans-serif; }")
                        .addClassDeclaration(".large { font: 40px sans-serif; }")
                        .addClassDeclaration(".yellowish {fill: rgb(255,203,70); }")
                        .addClassDeclaration(".blue {fill: rgb(62,161,203);}")
                        .addClassDeclaration(".green {fill: rgb(130,215,54);}")
                        .addClassDeclaration(".red {fill: rgb(255,105,70)};")
                        .addClassDeclaration(".operationbox {fill: white;stroke: black;font: 40px sans-serif;)};")
                )
                .with(new Lifeline.LifelineBuilder(start_x,start_y,end_x,start_y, "black").build())
                .with(new CircleWithText.CircleWithTextBuilder(2 * horzontal_distance, start_y, 20, "black", "yellowish", "2").build())
                .with(new CircleWithText.CircleWithTextBuilder(3 * horzontal_distance, start_y, 20, "black", "blue", "30").build())
                .with(new CircleWithText.CircleWithTextBuilder(4 * horzontal_distance, start_y, 20, "black", "green", "22").build())
                .with(new CircleWithText.CircleWithTextBuilder(5 * horzontal_distance, start_y, 20, "black", "red", "5").build())
                .build();
        File svgFile = new File("target/observable.svg");
        final String svgString = printToString(svg);
        assertThat(svgString, CoreMatchers.startsWith("<svg viewBox="));
        assertThat(svgString, CoreMatchers.endsWith("</svg>"));
        System.out.println(svgString);
        writeToFile(svgFile, svgString);
    }

    @Test
    public void shouldCreateOperationSvg() throws IOException {
        SvgCreator.main(new String[]{"Blog deel 1"});
        final int start_x = 20;
        final int end_x = 600;
        final int start_y = 100;
        final int horzontal_distance = 50;
        final int vertical_distance = 100;
        final Svg svg = new Svg.SvgBuilder(0, 0, 660, 340)
                .with(new Style()
                        .addClassDeclaration(".red { font: 40px serif; fill: red; }")
                        .addClassDeclaration(".small { font: 20px sans-serif; }")
                        .addClassDeclaration(".large { font: 40px sans-serif; }")
                        .addClassDeclaration(".yellowish {fill: rgb(255,203,70); }")
                        .addClassDeclaration(".blue {fill: rgb(62,161,203);}")
                        .addClassDeclaration(".green {fill: rgb(130,215,54);}")
                        .addClassDeclaration(".red {fill: rgb(255,105,70)};")
                        .addClassDeclaration(".operationbox {fill: white;stroke: black;font: 40px sans-serif;)};")
                )
                .with(new OperationBox.OperationBoxBuilder(start_x, end_x, 200, "filter (x => x > 10)").build())
                .build();
        File svgFile = new File("target/operation.svg");
        final String svgString = printToString(svg);
        assertThat(svgString, CoreMatchers.startsWith("<svg viewBox="));
        assertThat(svgString, CoreMatchers.endsWith("</svg>"));
        System.out.println(svgString);
        writeToFile(svgFile, svgString);
    }

    @Test
    public void shouldCreateObserverSvg() throws IOException {
        SvgCreator.main(new String[]{"Blog deel 1"});
        final int start_x = 20;
        final int end_x = 600;
        final int start_y = 300;
        final int horzontal_distance = 50;
        final int vertical_distance = 100;
        final Svg svg = new Svg.SvgBuilder(0, 0, 660, 340)
                .with(new Style()
                        .addClassDeclaration(".red { font: 40px serif; fill: red; }")
                        .addClassDeclaration(".small { font: 20px sans-serif; }")
                        .addClassDeclaration(".large { font: 40px sans-serif; }")
                        .addClassDeclaration(".yellowish {fill: rgb(255,203,70); }")
                        .addClassDeclaration(".blue {fill: rgb(62,161,203);}")
                        .addClassDeclaration(".green {fill: rgb(130,215,54);}")
                        .addClassDeclaration(".red {fill: rgb(255,105,70)};")
                        .addClassDeclaration(".operationbox {fill: white;stroke: black;font: 40px sans-serif;)};")
                )
                .with(new Lifeline.LifelineBuilder(start_x,start_y,end_x,start_y, "black").build())
                .with(new CircleWithText.CircleWithTextBuilder(3 * horzontal_distance, start_y, 20, "black", "blue", "30").build())
                .with(new CircleWithText.CircleWithTextBuilder(4 * horzontal_distance, start_y, 20, "black", "green", "22").build())
                .build();
        File svgFile = new File("target/observer.svg");
        final String svgString = printToString(svg);
        assertThat(svgString, CoreMatchers.startsWith("<svg viewBox="));
        assertThat(svgString, CoreMatchers.endsWith("</svg>"));
        System.out.println(svgString);
        writeToFile(svgFile, svgString);
    }

    @Test
    public void shouldCreateBlogDeel1Svg() throws IOException {
        SvgCreator.main(new String[]{"Blog deel 1"});
        final int start_x = 20;
        final int end_x = 600;
        final int start_y = 100;
        final int horzontal_distance = 50;
        final int vertical_distance = 100;
        final Svg svg = new Svg.SvgBuilder(0, 0, 660, 340)
                .with(new Style()
                        .addClassDeclaration(".red { font: 40px serif; fill: red; }")
                        .addClassDeclaration(".small { font: 20px sans-serif; }")
                        .addClassDeclaration(".large { font: 40px sans-serif; }")
                        .addClassDeclaration(".yellowish {fill: rgb(255,203,70); }")
                        .addClassDeclaration(".blue {fill: rgb(62,161,203);}")
                        .addClassDeclaration(".green {fill: rgb(130,215,54);}")
                        .addClassDeclaration(".red {fill: rgb(255,105,70)};")
                        .addClassDeclaration(".operationbox {fill: white;stroke: black;font: 40px sans-serif;)};")
                )
                .with(new Lifeline.LifelineBuilder(start_x,start_y,end_x,start_y, "black").build())
                .with(new CircleWithText.CircleWithTextBuilder(2 * horzontal_distance, start_y, 20, "black", "yellowish", "2").build())
                .with(new CircleWithText.CircleWithTextBuilder(3 * horzontal_distance, start_y, 20, "black", "blue", "30").build())
                .with(new CircleWithText.CircleWithTextBuilder(4 * horzontal_distance, start_y, 20, "black", "green", "22").build())
                .with(new CircleWithText.CircleWithTextBuilder(5 * horzontal_distance, start_y, 20, "black", "red", "5").build())
                .with(new Lifeline.LifelineBuilder(start_x,300,end_x,300, "black").build())
                .with(new OperationBox.OperationBoxBuilder(start_x, end_x, 200, "filter (x => x > 10)").build())
                .with(new CircleWithText.CircleWithTextBuilder(3 * horzontal_distance, 300, 20, "black", "blue", "30").build())
                .with(new CircleWithText.CircleWithTextBuilder(4 * horzontal_distance, 300, 20, "black", "green", "22").build())
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
