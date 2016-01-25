import InitializationLab1.*;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by willhorton on 1/20/16.
 */
public class TestColorfulThing {

    @Test
    public void testGetColor() {

        // Setup: create color Enum and use it to create ColorfulThing
        MyColor input = MyColor.BLUE;
        ColorfulThing testColorThing = new ColorfulThing(input);

        // Test: is color property same as input value?
        assertEquals(input, testColorThing.getColor());

    }

}
