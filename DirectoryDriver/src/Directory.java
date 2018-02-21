import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

/**
 * Build a Student Directory.
 * @author Meng Li
 */
public class Directory {

    /**
     * Build map1, key is andrew id.
     */
    private static Map<String, Student> map1 = new HashMap<String, Student>();

    /**
     * Build map2, key is first name.
     */
    private static Map<String, List<Student>> map2 = new HashMap<String, List<Student>>();

    /**
     * Build map3, key is last name.
     */
    private static Map<String, List<Student>> map3 = new HashMap<String, List<Student>>();

    /**
     * Constructor.
     */
    public Directory() {
    }

    /**
     * add students.
     * @param s student
     * @throws IllegalArgumentException IllegalArgumentException
     */
    public void addStudent(Student s) throws IllegalArgumentException {
        if (s == null) {
            throw new IllegalArgumentException();
        }

        if (map1.containsKey(s.getAndrewId())) {
            throw new IllegalArgumentException();
        } else {
            Student s1 = s.newStudent();
            map1.put(s1.getAndrewId(), s1);

            if (map2.containsKey(s1.getFirstName())) {
                map2.get(s1.getFirstName()).add(s1);
            } else {
                List<Student> list = new ArrayList<Student>();
                list.add(s1);
                map2.put(s1.getFirstName(), list);
            }

            if (map3.containsKey(s1.getLastName())) {
                map3.get(s1.getLastName()).add(s1);
            } else {
                List<Student> list = new ArrayList<Student>();
                list.add(s1);
                map3.put(s1.getLastName(), list);
            }
        }
    }

    /**
     * delete students.
     * @param andrewId andrewId
     * @throws IllegalArgumentException IllegalArgumentException
     */
    public void deleteStudent(String andrewId) throws IllegalArgumentException {
        if (andrewId == null) {
            throw new IllegalArgumentException();
        }

        if (map1.containsKey(andrewId)) {
            Student s =  map1.get(andrewId);

            if (map2.containsKey(s.getFirstName())) {
                List<Student> list = new ArrayList<Student>();
                list = map2.get(s.getFirstName());

                if (list.contains(s)) {
                        list.remove(s);
                }
            }

            if (map3.containsKey(s.getLastName())) {
                List<Student> listt = new ArrayList<Student>();
                listt = map3.get(s.getLastName());

                if (listt.contains(s)) {
                    listt.remove(s);
                }
            }

            map1.remove(andrewId);

        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * search by andrewId.
     * @param andrewId andrewId
     * @return student.
     * @throws IllegalArgumentException IllegalArgumentException
     */
    public Student searchByAndrewId(String andrewId) throws IllegalArgumentException {
        if (andrewId == null) {
            throw new IllegalArgumentException();
        }

        if (map1.containsKey(andrewId)) {
           return map1.get(andrewId).newStudent();
        } else {
           return null;
        }
    }

    /**
     * search by first name.
     * @param firstName firstName
     * @return list of students.
     * @throws IllegalArgumentException IllegalArgumentException
     */
    public  List<Student> searchByFirstName(String firstName) throws IllegalArgumentException {
        if (firstName == null) {
            throw new IllegalArgumentException();
        }

        if (map2.containsKey(firstName)) {
            List<Student> list1 = new ArrayList<Student>();
            for (Student a: map2.get(firstName)) {
                list1.add(a.newStudent());
            }
            return list1;
        } else {
            List<Student> list = new ArrayList<Student>();
            return new ArrayList<Student>(list);
        }
    }

    /**
     * search by last name.
     * @param lastName lastName
     * @return list of students.
     * @throws IllegalArgumentException IllegalArgumentException
     */
    public  List<Student> searchByLastName(String lastName) throws IllegalArgumentException {
        if (lastName == null) {
            throw new IllegalArgumentException();
        }

        if (map3.containsKey(lastName)) {
            List<Student> list2 = new ArrayList<Student>();
            for (Student a: map3.get(lastName)) {
                list2.add(a.newStudent());
            }
            return list2;
        } else {
            List<Student> list = new ArrayList<Student>();
            return new ArrayList<Student>(list);
        }
    }

    /**
     * find the number of students.
     * @return size.
     * @throws IllegalArgumentException IllegalArgumentException
     */
    public int size() throws IllegalArgumentException {
        return map1.size();
    }
}

