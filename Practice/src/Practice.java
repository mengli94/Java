import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
 * The Practice.
 * @author MengLi
 */
public class Practice extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    
    private JButton obama;
    
    private JButton romney;
    
    private JButton list1;
    
    private JButton list2;
    
    private JTextArea area;
    
    private JTextField firstname;
    
    private JTextField lastname;
    
    private JTextField amount;   

    private static List<Political> contributors = new ArrayList<Political>();
    
    private static long total_ob = 0;
    private static long total_ro = 0;
    
    java.text.DecimalFormat df;
    
    public Practice() {
        super("Midterm Champaign Contribution Application");
        setSize(780, 380);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel pane = new JPanel();

        Font bigFont = new Font(Font.SANS_SERIF, Font.CENTER_BASELINE, 12);

        JPanel line1 = new JPanel();
        lastname = new JTextField(13);
        JLabel label1 = new JLabel("Contributor Last Name: ");
        label1.setVerticalTextPosition(SwingConstants.BOTTOM);
        JLabel label5 = new JLabel("Contributor Last Name: ");
        line1.add(label5);
        label1.setFont(bigFont);
        line1.add(label1);
        line1.add(lastname);
        firstname = new JTextField(13);
        JLabel label2 = new JLabel("Contributor First Name: ");
        label2.setFont(bigFont);
        line1.add(label2);
        line1.add(firstname);
        amount = new JTextField(10);
        JLabel label3 = new JLabel("Amount: ");
        label3.setFont(bigFont);
        line1.add(label3);
        line1.add(amount);

        JPanel line2 = new JPanel();
        JPanel line3 = new JPanel();
        
        obama = new JButton("Contribute to Obama");
        line2.add(obama);
        obama.setFont(bigFont);
        obama.addActionListener(this);
        list1 = new JButton("List Obama Contributors");
        list1.setFont(bigFont);
        line3.add(list1);
        list1.addActionListener(this);
        obama.setFocusPainted(false);
        list1.setFocusPainted(false);


        romney = new JButton("Contribute to Romney");
        romney.setFont(bigFont);
        line2.add(romney);
        romney.addActionListener(this);
        list2 = new JButton("List Romney Contributors");
        list2.setFont(bigFont);
        line3.add(list2);
        list2.addActionListener(this);
        romney.setFocusPainted(false);
        list2.setFocusPainted(false);

        pane.add(line1);
        pane.add(line2);
        pane.add(line3);
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

        area = new JTextArea(8, 75);
        Font font = new Font(Font.MONOSPACED, Font.TRUETYPE_FONT, 15);
        area.setFont(font);
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        area.setEditable(false);
        JScrollPane scroller = new JScrollPane(area);

        JPanel line4 = new JPanel();
        line4.add(scroller);

        JPanel pane2 = new JPanel();
        pane2.add(pane);
        pane2.add(line4);
        setContentPane(pane2);
        setVisible(true);
        lastname.requestFocus();
        df = new java.text.DecimalFormat("#,###");
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        // TODO Auto-generated method stub
        if (event.getSource() == obama) {
            try {
                int a = Integer.parseInt(amount.getText());
                Political p = new Political(lastname.getText(), firstname.getText(), a, "obama");
                addPolitical(p);
                return;
            } catch (Exception e) {
                String info = "*** The amount must an integer";
                area.append(info + "\n");
            }
        }

        if (event.getSource() == romney) {
            try {
                int b = Integer.parseInt(amount.getText());
                Political p = new Political(lastname.getText(), firstname.getText(), b, "romney");
                addPolitical(p);
                return;
            } catch (Exception e) {
                String info = "*** The amount must an integer";
                area.append(info + "\n");
            }
        }

        if (event.getSource() == list1) {
            search("obama");
            area.append("Total contributions for Obama: $ " + df.format(total_ob) + "\n");
            return;
        }

        if (event.getSource() == list2) {
            search("romney");
            area.append("Total contributions for Romney: $ " + df.format(total_ro) + "\n");
            return;
        }
    }
    
    private void addPolitical(Political p) {
        String info;
        String a = p.getLastName();
        String b = p.getFirstName();
        int c = p.getAmount();
        String d = p.getWho();
        
        if (a.equals("")) {
            info = " Last missing in the process of add ";
            area.setText(info + "\n");
        } else if (b.equals("")) {
            info = " First Name missing in the process of add ";
            area.setText(info + "\n");
        } else if (c > 10000000 ) {
            info = "*** Contribution is too large";
            area.setText(info + "\n");
        } else if (c <= 0) {
            info = "*** Contribution is less than 0";
            area.setText(info + "\n");
        } else if (0 < c && c <= 10000000){
            if (d.equals("obama")) {
                total_ob = total_ob +c;
            } else {
                total_ro = total_ro +c;
            }
            contributors.add(p);
            area.append(p.toString() + "\n");
            amount.setText("");
            firstname.setText("");
            lastname.setText("");
        } 
    }
    
    public void search(String d) {
        area.setText("");
        Collections.sort(contributors, new MyComparator());
        for (Political sh : contributors) {
            if (sh.getWho().equals(d)) {
               area.append(sh.toString() + "\n");  
            }
        }
        area.append("\n");
    }

    private class MyComparator implements Comparator<Political> {
        @Override
        public int compare(Political arg0, Political arg1) {
            int flag;
            if (arg0.getAmount() > arg1.getAmount()) {
               flag = -1;
            } else if (arg0.getAmount() == arg1.getAmount()) {
               flag = 0;
            } else {
                flag = 1;
            }
            if (flag == 0) {
                flag = arg1.getLastName().compareTo(arg0.getLastName());
            }
            if (flag == 0) {
                flag = arg1.getFirstName().compareTo(arg0.getFirstName());
            }
            return flag;
        }
    }
    
    private class Political {
        private String last;
        private int money;
        private String first;
        private String who;

        public Political(String last1, String first1, int money1, String who1) {
             last = last1.replaceAll("\u0020","");
             first = first1.replaceAll("\u0020","");
             money = money1;
             who = who1;
             
             if (last.length()>15) {
                 last = last.substring(0, 15);
             }
             if (first.length()>15) {
                 first = first.substring(0, 15);
             }
        }
        
        public String getFirstName() {
            return first;
        }

        public int getAmount() {
            return money;
        }

        public String getLastName() {
            return last;
        }
        
        public String getWho() {
            return who;
        }
        
        @Override
        public String toString() {
            String f = last + "," + first;
            return  String.format("%-31s", f) + String.format("%15s", "$ " + df.format(money)) +  String.format("%-10s", "     " + who);
        }
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        new Practice();
    }
}
