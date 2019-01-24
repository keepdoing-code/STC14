package lections.lec08;


import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;


/**
 * Created on 23.01.19.
 *
 * @author Yuri Lupandin
 * @version 1.0
 */
public class ClassPathProtocol implements URLStreamHandlerFactory {

    @Override
    public URLStreamHandler createURLStreamHandler(String protocol) {
        if (protocol.equals("classpath")) {
            return new Protocol();
        }
        return null;
    }
}
