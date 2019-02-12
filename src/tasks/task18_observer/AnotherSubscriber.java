package tasks.task18_observer;

/**
 * Created on 06/02/19.
 *
 * @author Yuri Lupandin
 * @version 1.0
 */
public class AnotherSubscriber implements ISubscriber {
    @Override
    public void action(String str) {
        System.out.print("Another subscriber: ");
        System.out.println(str);
    }
}
