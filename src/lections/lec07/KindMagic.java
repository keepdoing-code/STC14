package lections.lec07;

/**
 * Created on 22.01.19.
 *
 * @author Yuri Lupandin
 * @version 1.0
 */
public class KindMagic implements Magic {
    static {
        System.out.println("Hottabych");
    }

    @Override
    public void doMagic() {
        System.out.println("Abra-kadabra");
    }


}
