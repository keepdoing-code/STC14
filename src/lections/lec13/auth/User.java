package lections.lec13.auth;


import org.apache.log4j.Logger;

import javax.jws.soap.SOAPBinding;

/**
 * Created on 30/01/19.
 *
 * @author Yuri Lupandin
 * @version 1.0
 */
public class User {
    private static final Logger LOGGER = Logger.getLogger(SOAPBinding.Use.class);


    public boolean doLogin(String login) {
        LOGGER.info("Trying to login");
        if ("user".equals(login)) {
            LOGGER.info("Success auth");
            return true;
        }
        if ("root".equals(login)) {
            LOGGER.warn("Root auth warn!");
            throw new UnsupportedOperationException();
        }
        LOGGER.info("Not authorized");
        return false;
    }
}
