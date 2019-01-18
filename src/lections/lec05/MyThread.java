package lections.lec05;

/**
 * Created on 18.01.19.
 *
 * @author Yuri Lupandin
 * @version 1.0
 */
public class MyThread extends Thread {
    public MyThread(Runnable target) {
        super(target);
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 1000_000; i++) {
                System.out.println(i);
            }
        } finally {
            System.out.println("finally thread");
        }

//        interrupted();
//        while (!isInterrupted()){
//            System.out.println("this is thread");
//        }
    }
}
