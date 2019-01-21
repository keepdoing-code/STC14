package tasks.task02_generic;

/**
 * @author Lupandin Yuri
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Integer[] intArray = {0, 4, 2, 7, 1, 1};
        Double[] dblArray = {10d, 5d, 0d, 45d, 45d};

        MathBox<Integer> box = new MathBox<>(intArray);
        System.out.println("hashcode: " + box.hashCode());
        System.out.println(box.toString());
        System.out.println(box.splitter().toString());
        System.out.println(box.amount());
        box.deleteObject(0);

        System.out.println();

        MathBox<Double> boxd = new MathBox<>(dblArray);
        System.out.println("hashcode: " + boxd.hashCode());
        System.out.println(boxd);
        System.out.println(boxd.splitter().toString());
        System.out.println(boxd.amount());


        try {
            box.addObject(34l);
//            box.addObject(new Point());
//            box.addObject(new Object());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(box.toString());
    }

}
