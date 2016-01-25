package InitializationLab1;
import java.util.*;

/**
 * Created by willhorton on 1/20/16.
 */
public class ThingContainer {

    public ColorfulThing[] colorsArray;
    private int arraySize;

    public ThingContainer(int arraySize) {

        this.arraySize = arraySize;
        this.colorsArray = new ColorfulThing[arraySize];

    }

    public ThingContainer(ColorfulThing[] colorsArray) {

        this.arraySize = colorsArray.length;
        this.colorsArray = colorsArray;

    }

    public String add(ColorfulThing newThing) {

        for(int i = 0; i < colorsArray.length; i++) {

            if(colorsArray[i] == null) {
                colorsArray[i] = newThing;
                return "New ColorfulThing added successfully";
            }

        }

        return "ThingContainer is full";

    }

    public String print() {

        String result = "";

        for(int i = 0; i < colorsArray.length; i++) {
            if(colorsArray[i] != null) {
                result += (i == colorsArray.length - 1) ? colorsArray[i].getColor() : colorsArray[i].getColor() + " ";
            }
        }

        return result;

    }

    public ColorfulThing pop() {

        // If array is empty return null
        if(colorsArray[0] == null) {
            return null;
        }

        // Initialize lastIndex to value not in array so compiler doesn't complain
        int lastIndex = -1;
        ColorfulThing poppedThing;

        for(int i = 0; i < colorsArray.length; i++) {
            if(colorsArray[i] == null) {
                lastIndex = i - 1;
                break;
            } else {
                lastIndex = colorsArray.length - 1;
            }
        }

        poppedThing = colorsArray[lastIndex];
        colorsArray[lastIndex] = null;
        return poppedThing;

    }

    public ColorfulThing remove(MyColor color) {

        ColorfulThing removedThing = null;
        int indexOfRemoved = 0;
        boolean found = false;

        // Find and remove first element that matches method parameter,
        // then break out of loop to avoid removing more than one element
        for(int i = 0; i < colorsArray.length; i++) {
            if( (colorsArray[i] != null) && (colorsArray[i].getColor() == color) ) {
                removedThing = colorsArray[i];
                colorsArray[i] = null;
                found = true;
                indexOfRemoved = i;
                break;
            }
        }

        // Shift remaining elements to the right
        if(found) {
            for(int i = indexOfRemoved; i < colorsArray.length - 1; i++) {
                colorsArray[i] = colorsArray[i + 1];
            }
            colorsArray[colorsArray.length - 1] = null;
        }

        return removedThing;

    }

    // Overload remove() to take ColorfulThing as argument
    public ColorfulThing remove(ColorfulThing removedThing) {

        MyColor color = removedThing.getColor();

        return this.remove(color);

    }

}