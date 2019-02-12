package tasks.task18_observer;

import java.util.HashSet;
import java.util.Set;

/**
 * Created on 06/02/19.
 *
 * @author Yuri Lupandin
 * @version 1.0
 */
public class Publisher {
    private final Set<ISubscriber> subscribers = new HashSet<>();

    public void subscribe(final ISubscriber s) {
        subscribers.add(s);
    }

    public void unsubscribe(final ISubscriber s) {
        subscribers.remove(s);
    }

    public void notifySubscribers(String action) {
        for (ISubscriber s : subscribers) {
            s.action(action);
        }
    }

    public void runAction() {
        notifySubscribers("Action");
    }
}
