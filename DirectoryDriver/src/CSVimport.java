import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Name
 */
public class CSVimport {
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

            boolean eof = false;
            String line = c.readLine();
            
            while (!eof) {
                line = c.readLine();
                if (line == null) {
                    eof = true;
                }
                else {
                    // Count up the number of commas
                    int commaCount = 0;
                    for (int i = 0; i < line.length(); i++) {
                        if (line.charAt(i) == ',') {
                            commaCount = commaCount + 1;
                        }
                    }

                    // Allocate an array of the necessary size to return the strings
                    String[] values = new String[commaCount + 1];

                    // In a loop, set beginIndex and endIndex to the start and end
                    // positions of each argment and then use the substring method
                    // to create strings for each of the comma separate values
                    // Start beginIndex at the beginning of the String, position 0
                    int beginIndex = 0;

                    for (int i = 0; i < commaCount; i++) {
                        // set endIndex to the position of the (next) comma
                        int endIndex = line.indexOf(',', beginIndex);

                        // if the argument begins and ends with quotes, remove them
                        if (line.charAt(beginIndex) == '"' && line.charAt(endIndex - 1) == '"') {

                            // If we made it here, we have quotes around our string.
                            // Add/substract one from the start/end of the args
                            // to substring to get the value. (See else comment
                            // below for details on how this works.)
                            values[i] = line.substring(beginIndex + 1, endIndex - 1);

                        } else {
                            // If we name it here, we don't have quotes around
                            // our string. Take the substring of this line
                            // from the beginIndex to the endIndex. The substring
                            // method called on a String will return the portion
                            // of the String starting with the beginIndex and up
                            // to but not including the endIndex.
                            values[i] = line.substring(beginIndex, endIndex);
                        }

                        // Set beginIndex to the position character after the
                        // comma. (Remember, endIndex was set to the position
                        // of the comma.)
                        beginIndex = endIndex + 1;
                    }

                    // handle the value that's after the last comma
                    if (line.charAt(beginIndex) == '"' && line.charAt(line.length() - 1) == '"') {
                        values[commaCount] = line.substring(beginIndex + 1, line.length() - 1);
                    } else {
                        values[commaCount] = line.substring(beginIndex, line.length());
                    }
                    
                    Student s = new Student(values[2]);
                    s.setFirstName(values[0]);
                    s.setLastName(values[1]);
                    s.setPhoneNumber(values[3]);
                    System.out.println(s);
                    d.addStudent(s);

                }
                }
            c.close();
        }
/*
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
*/
        System.out.println(d.searchByAndrewId("¡°Meng¡±"));
        //d.deleteStudent("terryhong");
        System.out.println(d.size());
        //System.out.println(d.searchByLastName("Li"));

    }
}