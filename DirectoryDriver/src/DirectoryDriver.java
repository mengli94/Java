import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * The DirectoryDiver swing.
 * @author MengLi
 */
public class DirectoryDriver extends JFrame implements ActionListener {
    /**
     * Serial version.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Reference to the add button.
     */
    private JButton addButton;
    /**
     * Reference to the delete button.
     */
    private JButton deleteButton;
    /**
     * Reference to the id button.
     */
    private JButton idButton;
    /**
     * Reference to the first button.
     */
    private JButton firstButton;
    /**
     * Reference to the last button.
     */
    private JButton lastButton;
    /**
     * Reference to the text area.
     */
    private JTextArea area;
    /**
     * Reference to the firstname text field.
     */
    private JTextField firstname;
    /**
     * Reference to the lastname text field.
     */
    private JTextField lastname;
    /**
     * Reference to the id text field.
     */
    private JTextField andiewid;
    /**
     * Reference to the phonenumber text field.
     */
    private JTextField phonenumber;
    /**
     * Reference to the id2 text field.
     */
    private JTextField andiewid2;
    /**
     * Reference to the search text field.
     */
    private JTextField search;
    /**
     * Reference to the directory class.
     */
    private Directory dir = new Directory();

    /**
     * Constructor.
     * The class itself is a sub class of JFrame here.
     */
    public DirectoryDriver() {
        super("Student Directory");
        setSize(840, 520);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel pane = new JPanel();
        JPanel ll = new JPanel();

        JPanel line = new JPanel();
        JLabel label1 = new JLabel("Add a new student", SwingConstants.LEFT);
        Font bigFont = new Font(Font.DIALOG, Font.CENTER_BASELINE, 16);
        label1.setFont(bigFont);
        line.add(label1);

        JPanel line1 = new JPanel();
        firstname = new JTextField(10);
        JLabel label11 = new JLabel("First Name");
        line1.add(label11);
        line1.add(firstname);
        lastname = new JTextField(10);
        JLabel label12 = new JLabel("Last Name");
        line1.add(label12);
        line1.add(lastname);
        andiewid = new JTextField(10);
        JLabel label13 = new JLabel("Andrew ID");
        line1.add(label13);
        line1.add(andiewid);
        phonenumber = new JTextField(10);
        JLabel label14 = new JLabel("Phone Number");
        line1.add(label14);
        line1.add(phonenumber);
        addButton = new JButton("Add");
        line1.add(addButton);
        addButton.addActionListener(this);

        JPanel line2 = new JPanel();
        JLabel label2 = new JLabel("Delete a student", SwingConstants.LEFT);
        label2.setFont(bigFont);
        line2.add(label2);

        JPanel line3 = new JPanel();
        andiewid2 = new JTextField(10);
        JLabel label21 = new JLabel("Andrew ID");
        line3.add(label21);
        line3.add(andiewid2);
        deleteButton = new JButton("Delete");
        line3.add(deleteButton);
        deleteButton.addActionListener(this);

        JPanel line4 = new JPanel();
        JLabel label3 = new JLabel("Search student(s)", SwingConstants.LEFT);
        label3.setFont(bigFont);
        line4.add(label3);

        JPanel line5 = new JPanel();
        search = new JTextField(10);
        search.addActionListener(this);
        JLabel label31 = new JLabel("Search Key");
        line5.add(label31);
        line5.add(search);
        idButton = new JButton("By Andrew ID");
        line5.add(idButton);
        idButton.addActionListener(this);
        firstButton = new JButton("By First Name");
        line5.add(firstButton);
        firstButton.addActionListener(this);
        lastButton = new JButton("By Last Name");
        line5.add(lastButton);
        lastButton.addActionListener(this);

        JPanel line6 = new JPanel();
        JLabel label4 = new JLabel("Results", SwingConstants.LEFT);
        label4.setFont(bigFont);
        line6.add(label4);

        pane.add(ll);
        pane.add(line);
        pane.add(line1);
        pane.add(line2);
        pane.add(line3);
        pane.add(line4);
        pane.add(line5);
        pane.add(line6);
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

        area = new JTextArea(8, 75);
        Font font = new Font(Font.MONOSPACED, Font.TRUETYPE_FONT, 15);
        area.setFont(font);
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        area.setEditable(false);
        area.setText("Hello!\n");
        JScrollPane scroller = new JScrollPane(area);

        JPanel line7 = new JPanel();
        line7.add(scroller);

        JPanel pane2 = new JPanel();
        pane2.add(pane);
        pane2.add(line7);
        setContentPane(pane2);
        setVisible(true);
        search.requestFocus();
        System.out.println(Thread.currentThread().getName());
    }

    /**
     * load data.
     * @param a filename.csv
     * @throws IOException IOException
     * @throws FileNotFoundException FileNotFoundException
     */
    private void dataLoad(String a) throws FileNotFoundException, IOException {
        FileReader fr = new FileReader(a);
        BufferedReader c = new BufferedReader(fr);

        boolean eof = false;
        String line = c.readLine();

        while (!eof) {
            line = c.readLine();
            if (line == null) {
                eof = true;
            } else {
                int commaCount = 0;
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) == ',') {
                        commaCount = commaCount + 1;
                    }
                }

                String[] values = new String[commaCount + 1];

                int beginIndex = 0;

                for (int i = 0; i < commaCount; i++) {
                    int endIndex = line.indexOf(',', beginIndex);

                    if (line.charAt(beginIndex) == '"' && line.charAt(endIndex - 1) == '"') {

                        values[i] = line.substring(beginIndex + 1, endIndex - 1);

                    } else {
                        values[i] = line.substring(beginIndex, endIndex);
                    }

                    beginIndex = endIndex + 1;
                }

                if (line.charAt(beginIndex) == '"' && line.charAt(line.length() - 1) == '"') {
                    values[commaCount] = line.substring(beginIndex + 1, line.length() - 1);
                } else {
                    values[commaCount] = line.substring(beginIndex, line.length());
                }

                Student s = new Student(values[2]);
                s.setFirstName(values[0]);
                s.setLastName(values[1]);
                s.setPhoneNumber(values[3]);
                dir.addStudent(s);
            }
            }
        c.close();
    }

    /*
     * Method to be invoked when buttons are clicked.
     * @param event event object
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == addButton) {
            addStudent();
            return;
        }

        if (event.getSource() == deleteButton) {
            deleteStudent(andiewid2.getText());
            return;
        }

        if (event.getSource() == idButton) {
            searchByAndrewId(search.getText());
            return;
        }

        if (event.getSource() == search) {
            searchByAndrewId(search.getText());
            return;
        }

        if (event.getSource() == firstButton) {
            searchByFirstName(search.getText());
            return;
        }

        if (event.getSource() == lastButton) {
            searchByLastName(search.getText());
            return;
        }
        throw new AssertionError("Unknown event.");
    }

    /**
     * delete students.
     * @param andrewId andrewId
     */
    private void deleteStudent(String andrewId) {
        String info;
        if (andrewId.equals("")) {
            info = " Andrew ID missing in the process of delete ";
            area.setText(info + "\n");
        } else {
            Student s = dir.searchByAndrewId(andrewId);
            if (s == null) {
                info = andrewId + " is not found in the process of delete!\n";
                area.setText(info);
            } else {
                andiewid2.setText("");
                info = andrewId + " is deleted!\n";
                area.setText(s.toString() + "\n" + info);
                dir.deleteStudent(andrewId);
            }
        }
    }

    /**
     * add students.
     */
    private void addStudent() {
        String a = andiewid.getText();
        String b = firstname.getText();
        String c = lastname.getText();
        String d = phonenumber.getText();
        Student exist = dir.searchByAndrewId(a);
        String info;
        if (a.equals("")) {
            info = " Andrew ID missing in the process of add ";
            area.setText(info + "\n");
        } else if (b.equals("")) {
            info = " First Name missing in the process of add ";
            area.setText(info + "\n");
        } else if (c.equals("")) {
            info = " Last Name missing in the process of add ";
            area.setText(info + "\n");
        } else if (exist == null) {
            Student s = new Student(a);
            s.setFirstName(b);
            s.setLastName(c);
            if (d.equals("")) {
                s.setPhoneNumber("");
            } else {
                s.setPhoneNumber(d);
            }
            info = andiewid.getText() + " is added!\n";
            andiewid.setText("");
            firstname.setText("");
            lastname.setText("");
            phonenumber.setText("");
            area.setText(s.toString() + "\n" + info);
            dir.addStudent(s);
        } else {
            info = " Data already contains an entry for this Andrew ID in the process of add";
            area.setText(info + "\n");
        }
    }

    /**
     * search by andrewId.
     * @param andrewId andrewId
     */
    private void searchByAndrewId(String andrewId) {
        String info;
        if (andrewId.equals("")) {
            info = " Andrew ID missing in the process of search by andrew id ";
            area.setText(info + "\n");
        } else {
            Student s = dir.searchByAndrewId(andrewId);
            if (s == null) {
                info = andrewId + " is not found in the process of search by andrew id!\n";
                area.setText(info);
            } else {
                search.setText("");
                area.setText(s.toString() + "\n");
            }
        }
    }

    /**
     * search by first name.
     * @param firstName firstName
     */
    private void searchByFirstName(String firstName) {
        String info;
        if (firstName.equals("")) {
            info = " Andrew ID missing in the process of search by first name ";
            area.setText(info + "\n");
        } else {
            List<Student> list1 = dir.searchByFirstName(firstName);
            List<Student> list2 = new ArrayList<Student>();
            if (list1.equals(list2)) {
                info = firstName + " is not found in the process of search by first name!\n";
                area.setText(info);
            } else {
                search.setText("");
                area.setText("");
                for (Student a: list1) {
                    area.append(a.toString() + "\n");
                }
            }
        }
    }

    /**
     * search by last name.
     * @param lastName lastName
     */
    private void searchByLastName(String lastName) {
        String info;
        if (lastName.equals("")) {
            info = " Andrew ID missing in the process of search by last name ";
            area.setText(info + "\n");
        } else {
            List<Student> list1 = dir.searchByLastName(lastName);
            List<Student> list2 = new ArrayList<Student>();
            if (list1.equals(list2)) {
                info = lastName + " is not found in the process of search by last name!\n";
                area.setText(info);
            } else {
                search.setText("");
                area.setText("");
                for (Student a: list1) {
                    area.append(a.toString() + "\n");
                }
            }
        }
    }

    /**
     * Simple program to show File frame programming for Swing.
     * @param args arguments
     * @throws IOException IOException
     * @throws FileNotFoundException FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        DirectoryDriver d = new DirectoryDriver();
        System.out.println(Thread.currentThread().getName());
        if (args.length != 1) {
            System.out.println("Usage filename");
        } else {
            d.dataLoad(args[0]);
        }
    }
}
