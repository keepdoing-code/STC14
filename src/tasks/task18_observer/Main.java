package tasks.task18_observer;

/**
 * Created on 06/02/19.
 *
 * @author Yuri Lupandin
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Publisher pub = new Publisher();
        pub.subscribe(new SimpleSubscriber());
        pub.subscribe(new AnotherSubscriber());

        System.out.println("");
        pub.runAction();
//        pub.notifySubscribers("Action performed");
    }
}
