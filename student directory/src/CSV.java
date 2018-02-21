import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Name
 */
public class CSV {
    
    /**
     * Demo code to test different shapes.
     * @param args arguments
     * @throws IOException 
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        Directory d = new Directory();
        
        if (args.length != 1) {
            System.out.println("Usage: java CSVReaderTest <filename>");
        }
        else {
            FileReader fr = new FileReader(args[0]);
            BufferedReader c = new BufferedReader(fr);

            int lineNum = 0;
            boolean eof = false;
            
            while (!eof) {
                String line = c.readLine();
                
                if (line == null) {
                    eof = true;
                }
                else{
                    // Allocate an array of the necessary size to return the strings
                    String[] values = new String[4];
                    // Start beginIndex at the beginning of the String, position 0
                    int beginIndex = 0;

                    for (int i = 0; i < 3; i++) {
                        int endIndex;
                        endIndex = line.indexOf(',', beginIndex);

                        // if the argument begins and ends with quotes, remove them
                        if (line.charAt(beginIndex) == '"' && line.charAt(endIndex - 1) == '"') {
                            values[i] = line.substring(beginIndex + 1, endIndex - 1);

                        } else {
                            values[i] = line.substring(beginIndex, endIndex);
                        }

                        beginIndex = endIndex + 1;
                    }

                    if (line.charAt(beginIndex) == '"' && line.charAt(line.length() - 1) == '"') {
                        values[3] = line.substring(beginIndex + 1, line.length() - 1);
                    } else {
                        values[3] = line.substring(beginIndex, line.length());
                    }
                    
                    if (lineNum > 1) {
                        lineNum = lineNum + 1;
                        Student s = new Student(values[0]);
                        s.setFirstName(values[1]);
                        s.setLastName(values[2]);
                        s.setPhoneNumber(values[3]);
                        d.addStudent(s);
                        System.out.println(s);
                    }

                    }
                }
            c.close();
        }
        
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

        d.addStudent(c);
        d.addStudent(a);
        d.addStudent(b);
        
        //System.out.println(d.searchByAndrewId("mengl2"));
        //d.deleteStudent("terryhong");
        System.out.println(d.size());
       // System.out.println(d.searchByLastName("Li"));

    }
}