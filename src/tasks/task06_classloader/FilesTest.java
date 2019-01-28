package tasks.task06_classloader;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;


/**
 * Created on 29/01/19.
 *
 * @author Yuri Lupandin
 * @version 1.0
 */
public class FilesTest {
    public static void main(String[] args) throws IOException, IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {
        File classesDir = new File(".");
        ClassLoader parentLoader = ClassLoader.getSystemClassLoader();
        URLClassLoader loader1 = new URLClassLoader(new URL[]{classesDir.toURI().toURL()}, parentLoader);
        Class cls1 = loader1.loadClass("TestClass");
        Object obj = cls1.newInstance();

        Class[] argTypes = new Class[]{String[].class};
        Method main = cls1.getDeclaredMethod("main", argTypes);
        String[] mainArgs = {""};
        main.invoke(null, (Object) mainArgs);
    }
}
