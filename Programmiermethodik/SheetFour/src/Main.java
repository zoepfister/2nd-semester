/**
 * Created by clemenspfister on 06/04/2017.
 */
public class Main {

    public static void main(String[] args) {
        Secretary secretary1 = new Secretary("Augusta", "Fernanda", 2002.20);
        Room room1 = new Room(10, 30);
        Seminar seminar1 = new Seminar(1, room1, secretary1, 11);
        Employee employee1 = new Professor("Mat", "Hematik", 1000.10);
        Employee professor1 = new Professor("Anna", "Konda", 2312.10);

        Person p1 = new Person("Kamma", "Corder", 12);
        Person p2 = new Person("Corinna", "Cucumber", 21);
        Person p3 = new Person("Marth", "Candle", 20);
        // Person p4 = new Person("Sonya", "Phillipsson", 18);
        Student p4 = new Student(1, "Sonya", "Phillipsson");

        // salary = payout
        System.out.println(secretary1.salary);

        System.out.println(Secretary.minSalary);

        System.out.println(professor1.minSalary);

        System.out.println(seminar1.getEmployee());

        System.out.println(seminar1.students.size());

        System.out.println(p2.getAge());

        System.out.println(professor1.toString());

        System.out.println(p1.toString());

        // Must be Student in order for this to work
        // System.out.println(p4.getFirstname());

        // Works with students as well as persons
        System.out.println(p4.firstname);

        // Defined in Object.java
        System.out.println(p4.getClass());

        secretary1.raisePayOut(1.4f);
        System.out.println(secretary1.salary);

//        Person professor2 = new Person("Ham", "Egg", 12);
//        Professor p23 = (Professor) professor2;
//        professor2.getAge();


        System.out.println(p4.equals(p1));


    }
}

