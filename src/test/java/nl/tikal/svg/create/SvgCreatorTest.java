package nl.tikal.svg.create;

import static org.junit.Assert.assertTrue;

import nl.tikal.svg.create.SvgCreator;
import nl.tikal.svg.element.Circle;
import nl.tikal.svg.element.Svg;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class SvgCreatorTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        SvgCreator.main(new String[]{"Hello world"});
        new Svg.SvgBuilder(0,0,300,100)
                .with(new Circle.CircleBuilder(50, 50, 50).build())
        .build();
    }
}
