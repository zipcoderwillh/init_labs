package InitializationLab1;

import java.awt.*;

/**
 * Created by willhorton on 1/20/16.
 */

public class InitializationLab1 {

    public static void main(String[] args) {

        MyColor[] colors = {MyColor.GREEN, MyColor.ORANGE, MyColor.YELLOW, MyColor.RED, MyColor.FUSCIA};

        for(int i = 0; i < 5; i++) {

            ColorfulThing ct = new ColorfulThing(colors[i]);
            System.out.println(ct.getColor());

            BoringThing bt = new BoringThing();

        }

        // Doesn't work without argument:

        //ColorfulThing newCt = new ColorfulThing();

    }

}
