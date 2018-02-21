/**
 * @author Meng Li
 *
 */
public class Student {
    /**
     * The first name of a student.
     */
    private String firstname;
    /**
     * The andrew id of a student.
     */
    private String andrewid;
    /**
     * The last name of a student.
     */
    private String lastname;
    /**
     * The phone Number of a student.
     */
    private String phonenumber;

    /**
     * This is the constructor method.
     * @param andrewId andrewId
     */
    public Student(String andrewId) {
        andrewid = new String(andrewId);
    }


    public String getFirstName() {
        return firstname;
    }

    public String getAndrewId() {
        return andrewid;
    }

    public String getLastName() {
        return lastname;
    }

    /**
     * Returns phone number.
     * @return String value of phone number
     */
    public String getPhoneNumber() {
        return phonenumber;
    }

    /**
     * Set first name.
     * @param s first name
     */
    public void setFirstName(String s) {
        firstname = new String(s);
    }

    /**
     * Set last name.
     * @param s last name
     */
    public void setLastName(String  s) {
        lastname = new String(s);
    }

    /**
     * Set phone number.
     * @param s phone number
     */
    public void setPhoneNumber(String s) {
        phonenumber = new String(s);
    }

    /**
     * Set phone number.
     * @return new student
     */
    public Student newStudent() {
        String a = new String(getAndrewId());
        Student snew = new Student(a);
        String b = new String(getFirstName());
        snew.setFirstName(b);
        String c = new String(getLastName());
        snew.setLastName(c);
        String d = new String(getPhoneNumber());
        snew.setPhoneNumber(d);
        return snew;
    }

    /**
     * Returns Spring representation of Student object.
     * @return String representation of Student object
     */
    @Override
    public String toString() {
        return firstname + " " + lastname + " (Andrew ID: " + andrewid + ", Phone Number: " + phonenumber + ")";
    }
}
