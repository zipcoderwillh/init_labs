package TestInitializationLab1;
import InitializationLab1.*;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by willhorton on 1/20/16.
 */

public class TestThingContainer {

    @Test
    public void testAdd() {

        // Setup: instantiate test array and object with FUSCIA colors
        int arraySize = 3;
        ThingContainer testContainer = new ThingContainer(arraySize);
        MyColor[] testArray = {MyColor.FUSCIA, MyColor.FUSCIA, MyColor.FUSCIA};

        // Execute: populate new ThingContainer with fuscia ColorfulThings
        for(int i = 0; i < arraySize; i++) {
            testContainer.add(new ColorfulThing(MyColor.FUSCIA));
        }

        // Test: get colors from test container, then test that new array contains same colors as test array
        MyColor[] resultArray = new MyColor[arraySize];
        for(int i = 0; i < testContainer.colorsArray.length; i++) {
            resultArray[i] = testContainer.colorsArray[i].getColor();
        }
        assertArrayEquals(testArray, resultArray);
        // Test: see if error output is correct if array is full
        assertEquals("ThingContainer is full", testContainer.add(new ColorfulThing(MyColor.FUSCIA)));

    }

    @Test
    public void testPrint() {

        // Setup: create test container and populate with ColorfulThings
        int arraySize = 5;
        ThingContainer testContainer = new ThingContainer(arraySize);
        for(int i = 0; i < arraySize; i++) {
            testContainer.colorsArray[i] = new ColorfulThing(MyColor.BLUE);
        }

        // Test print method
        assertEquals("BLUE BLUE BLUE BLUE BLUE", testContainer.print());

    }

    @Test
    public void testPop() {

        // Setup: create test container object and fill with RED ColorfulThings
        int arraySize = 5;
        ThingContainer testContainer = new ThingContainer(arraySize);
        for(int i = 0; i < arraySize; i++) {
            testContainer.colorsArray[i] = new ColorfulThing(MyColor.RED);
        }

        // Execute: pop last element after assigning reference variable to the same object
        ColorfulThing lastThing = testContainer.colorsArray[arraySize - 1];
        ColorfulThing poppedThing = testContainer.pop();

        // Test that removed object is same as what was previously last object in array
        assertEquals(lastThing, poppedThing);
        // Test that array does NOT contain removed item
        assertFalse(Arrays.asList(testContainer.colorsArray).contains(poppedThing));

    }

    @Test
    public void testRemoveColor() {

        // Setup: instantiate container and add objects of different colors
        int arrayLength = 5;
        ThingContainer testContainer = new ThingContainer(arrayLength);
        testContainer.add(new ColorfulThing(MyColor.RED));
        testContainer.add(new ColorfulThing(MyColor.BLUE));
        testContainer.add(new ColorfulThing(MyColor.YELLOW));
        testContainer.add(new ColorfulThing(MyColor.PURPLE));
        testContainer.add(new ColorfulThing(MyColor.FUSCIA));

        // Execute: remove item of specific color
        MyColor removedColor = MyColor.PURPLE;
        ColorfulThing removedThing = testContainer.remove(removedColor);

        // Execute: count remaining items in array
        int count = 0;
        for(int i = 0; i < testContainer.colorsArray.length; i++) {
            if(testContainer.colorsArray[i] != null) {
                count += 1;
            }
        }

        // Test: is removed item present in array? Is its color the same as argument passed?
        assertFalse(Arrays.asList(testContainer.colorsArray).contains(removedThing));
        assertEquals(removedColor, removedThing.getColor());

        // Test: does array have one less item? Is the last item empty?
        assertEquals(arrayLength - 1, count);
        assertTrue(testContainer.colorsArray[arrayLength - 1] == null);

    }

    @Test
    public void testRemoveColorThing() {

        // Setup: instantiate container and add objects of different colors
        int arrayLength = 5;
        ThingContainer testContainer = new ThingContainer(arrayLength);
        testContainer.add(new ColorfulThing(MyColor.RED));
        testContainer.add(new ColorfulThing(MyColor.BLUE));
        testContainer.add(new ColorfulThing(MyColor.YELLOW));
        testContainer.add(new ColorfulThing(MyColor.PURPLE));
        testContainer.add(new ColorfulThing(MyColor.FUSCIA));

        // Execute: remove item of specific color
        MyColor removedColor = MyColor.YELLOW;
        ColorfulThing removedThing = testContainer.remove(new ColorfulThing(removedColor));

        // Execute: count remaining items in array
        int count = 0;
        for(int i = 0; i < testContainer.colorsArray.length; i++) {
            if(testContainer.colorsArray[i] != null) {
                count += 1;
            }
        }

        // Test: is removed item present in array? Is its color the same as argument passed?
        assertFalse(Arrays.asList(testContainer.colorsArray).contains(removedThing));
        assertEquals(removedColor, removedThing.getColor());

        // Test: does array have one less item? Is the last item empty?
        assertEquals(arrayLength - 1, count);
        assertTrue(testContainer.colorsArray[arrayLength - 1] == null);

    }

}