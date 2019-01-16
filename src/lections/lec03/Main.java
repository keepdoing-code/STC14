package lections.lec03;

import lections.lec03.Entity.Skill;
import lections.lec03.Entity.Student;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        List students = getStudents();
        for (int i = 0; i < students.size(); i++) {
            Student st = (Student) students.get(i);
            System.out.printf("%s - %s\n", st.getFirstName(), st.getLastName());
        }

        Map studentSkills = generateSkills(students);

        for (Object o : students) {
            Student s = (Student) o;
            System.out.printf("%10s %10s : %s\n", s.getFirstName(), s.getLastName(), studentSkills.get(s));
        }

        Iterator it = students.iterator();
        int i = 0;
        while (it.hasNext()) {
            Student s = (Student) it.next();
            System.out.println(s.getFirstName());
        }
    }

    private static Map generateSkills(List students) {
        Map result = new HashMap();
        for (Object o : students) {
            result.put(o, new Skill("Java", new Random().nextInt(10)));
        }
        return result;
    }

    private static List getStudents() {
        return Arrays.asList(new Student("Ivan", "Iv"),
                new Student("Sergey", "Petrov"),
                new Student("Ilya", "Sid"),
                new Student("Nik", "Chuprov"));
    }
}
