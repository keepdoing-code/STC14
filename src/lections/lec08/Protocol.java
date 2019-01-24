package lections.lec08;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

/**
 * Created on 23.01.19.
 *
 * @author Yuri Lupandin
 * @version 1.0
 */
public class Protocol extends URLStreamHandler {
    @Override
    protected URLConnection openConnection(URL u) throws IOException {
        URL url = Protocol.class.getClassLoader().getResource(u.getHost());
        return url == null ? null : url.openConnection();
    }
}
