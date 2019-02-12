package tasks.task18_observer;

/**
 * Created on 06/02/19.
 *
 * @author Yuri Lupandin
 * @version 1.0
 */
public class SimpleSubscriber implements ISubscriber {
    @Override
    public void action(String str) {
        System.out.print("Simple subscriber: ");
        System.out.println(str);
    }
}
