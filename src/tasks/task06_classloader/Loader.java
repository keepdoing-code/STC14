package tasks.task06_classloader;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created on 28/01/19.
 *
 * @author Yuri Lupandin
 * @version 1.0
 */
public class Loader {
    private static final String className = "TestClass";
    private static final String srcData = "" +
            "public class TestClass {\n" +
            "    static {\n" +
            "        System.out.println(\"Hi man\");\n" +
            "    }\n" +
            "\n" +
            "    public static void main(String[] args) {\n" +
            "        System.out.println(\"Hello\");\n" +
            "    }\n" +
            "}";

    public static void main(String[] args) {
        Loader loader = new Loader();
//        String src = loader.readConsole();
        System.out.println(loader.compileToFile(srcData, className));
        loader.run(className);

    }


    public void run(String className) {
        try {
            File classesDir = new File(".");
            ClassLoader parentLoader = ClassLoader.getSystemClassLoader();
            URLClassLoader loader1 = new URLClassLoader(new URL[]{classesDir.toURI().toURL()}, parentLoader);
            Class cls1 = loader1.loadClass(className);
            Object obj = cls1.newInstance();

            Class[] argTypes = new Class[]{String[].class};
            Method main = cls1.getDeclaredMethod("main", argTypes);
            String[] mainArgs = {""};
            main.invoke(null, (Object) mainArgs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public boolean compileToFile(String src, String className) {
        String filename = className + ".java";
        Path path = Paths.get(filename);

        try {
            Files.write(path, src.getBytes());
            JavaCompiler javac = ToolProvider.getSystemJavaCompiler();
            return javac.run(null, null, null, filename) == 0;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String readConsole() {
        System.out.println("Print \"esc\" when done.");
        StringBuilder sb = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String text;
            while (!(text = br.readLine()).equals("esc")) {
                sb.append(text);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return sb.toString();
    }
}
