package InitializationLab1;

import java.util.Random;

public class InitializationLab2 {

    public static void main(String[] args) {

        // Testing constructor that takes an integer arraySize
        ThingContainer container1 = new ThingContainer(3);
        ThingContainer container2 = new ThingContainer(4);
        ThingContainer container3 = new ThingContainer(5);

        Random rand = new Random();
        int counter = rand.nextInt(15);
        System.out.println(counter);

        for(int i = 0; i < counter; i++) {
            System.out.println(container3.add(new ColorfulThing(MyColor.GREEN)));
        }
        System.out.println(container3.print());

        container3.remove(MyColor.GREEN);
        System.out.println(container3.print());

        container3.remove(new ColorfulThing(MyColor.GREEN));
        System.out.println(container3.print());

        // Testing constructor that takes an array of ColorfulThings
        ColorfulThing[] colorfulArray = {
                new ColorfulThing(MyColor.RED),
                new ColorfulThing(MyColor.BLUE),
                new ColorfulThing(MyColor.YELLOW),
                new ColorfulThing(MyColor.PURPLE),
                new ColorfulThing(MyColor.FUSCIA)
        };

        ThingContainer container4 = new ThingContainer(colorfulArray);

        System.out.println(container4.print());

    }

}
