/**
 * @author Meng Li
 *
 */
public class Test {
    /**
     * Demo code to test different shapes.
     * @param args arguments
     */
    public static void main(String[] args) {
        Student c = new Student("mengl1");
        c.setFirstName("Meng");
        c.setLastName("Li");
        c.setPhoneNumber("412-807-0153");
        
        Student a = new Student("mengl2");
        a.setFirstName("Mengl");
        a.setLastName("Li");
        a.setPhoneNumber("412-807-0154");
        
        Student b = new Student("terryhong");
        b.setFirstName("terry");
        b.setLastName("hong");
        b.setPhoneNumber("412-464-475");

        Directory d = new Directory();
        d.addStudent(c);
        d.addStudent(a);
        d.addStudent(b);
        
        System.out.println(d.searchByAndrewId("mengl2"));
        //d.deleteStudent("mengl1");
        //d.deleteStudent("mengl2");
        System.out.println(d.size());
        System.out.println(d.searchByLastName("Li"));
        
    }
}
