package lections.lec13;

import lections.lec13.auth.User;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created on 30/01/19.
 *
 * @author Yuri Lupandin
 * @version 1.0
 */
public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        LOGGER.info("Stating app with args: " + Arrays.toString(args));

        if (args.length < 1) {
            System.out.println("java... <login>");
            LOGGER.fatal("Empty args <login>");
            return;
        }

        User user = new User();

        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String login = sc.nextLine();
            if ("quit".equals(login)) {
                return;
            }
            try {
                user.doLogin(login);
            } catch (Exception e) {
                LOGGER.error("Error occurred");
            }
        }
    }
}
