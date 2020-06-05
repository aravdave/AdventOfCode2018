// Arav Dave
// Anything typed after "//" in a line or between "/*" and "*/" within multiple lines is ignored by the program. Look for the double forward slash and the single forward slash with an asterisk to find my comments.

/*At this point, I'm allowing these Java programs (i.e. java.io.BufferedReader) to be accessed by my program so I can use the functions within them.
  These programs are within standard packages that are installed when Java is installed on a computer.
  To make all of the programs within a standard package accessible by my program, I typed a period and asterisk (.*) after I indicated which package I want accessible.

  The BufferedReader program can be used by my program to read a text file line by line.
  The java.nio.file.* package can be used to allow the program to access a specific file on my computer.

  The java.util.* program allows my program to create ArrayList, a type of data structure, objects.
  ArrayLists are simply ordered lists that only contain one type of object. This means that an ArrayList<String> can only contain a list of strings.
*/
import java.io.BufferedReader;
import java.nio.file.*;
import java.util.*;

// "Part2" is the name of my class. A class contains a constructor (an object of the class itself) and methods (functions).
public class Part2 {

    // "Part2()" is the name of my constructor. Constructors have to be named the same as the class.
    public Part2() {

        // "path" is an object of Path. Basically, "path" contains the location of the puzzle input data that the program will access.
        Path path = Paths.get("C:/Users/aravd.000/Desktop/PuzzleInput.txt");

        /* This is a try-catch block. The program will try to run the code within the first open curly bracket and the last curly bracket right before the catch statement.
           If an error occurs within the try block, the program will skip to the code in the catch block. Otherwise, the code in the catch block is not run by the program.
           "br" is an object of BufferedReader that is accessing the file indicated by the path object.
        */
        try(BufferedReader br = Files.newBufferedReader(path)) {

            // "stringList" is an ArrayList<String> object, which means only string objects can be added to "stringList".
            ArrayList<String> stringList = new ArrayList<String>();

            // The line below is creating a string object that will contain (a) character(s).
            String line;

            // "line = br.readLine()" is assigning the first ID in the puzzle input to the string object "line".
            // This while loop with add each ID in the puzzle input to the ArrayList "stringList".
            while((line = br.readLine()) != null) {
                stringList.add(line);
            }

            // The purpose of these two for loops is to compare each ID with every other ID in the puzzle input.
            // The first for loop iterates through each element (ID) in the ArrayList "stringList".
            for (int i = 0; i < stringList.size(); i++) {

                // "firstID" stores the ID that will be compared to every other ID.
                String firstID = stringList.get(i);

                // The second for loop starts with the ID following the position of the first ID in "stringList" so memory resources aren't used comparing two IDs that already have been compared.
                for (int j = i+1; j < stringList.size(); j++) {

                    //"secondID" stores the secondary ID that will be compared to the first ID.
                    String secondID = stringList.get(j);

                    // "numOfLettersChanged" is an integer object that is instantiated (set) with a value of zero.
                    // The reason why "numOfLettersChanged" is set to zero within the second for loop is to reset the number of letter differences when the ID from the second loop changes.
                    // Similarly, "commonLetters" is reset to a blank string every time the second ID changes.
                    // The string "commonLetters" is only relevant when the number of letter differences equals one, but the program is most efficient when the common letters of the two IDs that are being compared is constantly recorded.
                    int numOfLettersChanged = 0;
                    String commonLetters = "";

                    // This for loop is used for the iteration of each letter in both IDs. It allows the comparison of two characters, one from each ID, at the same position in the string.
                    for (int k = 0; k < stringList.get(i).length(); k++) {

                        // Since the letters of two correct box IDs should only differ by one letter, every time the letters at the same position in both strings differ, the variable that stores the number of letter differences increments by one.
                        // If the letters are the same at that unique position, that common letter is concatenated (added) to "commonLetters".
                        if (firstID.charAt(k) != secondID.charAt(k))
                            numOfLettersChanged++;
                        else
                            commonLetters = commonLetters + Character.toString(firstID.charAt(k));
                    }

                    // After all the letters from both IDs are compared, if there is only one letter difference between the two IDs, then the program has found the two correct box IDs.
                    // If that is the case, the program prints out (displays to the user) the common letters that were recorded between the two IDs and it terminates itself.
                    // The program terminates itself to avoid wasting resources and time looking for another pair of IDs that only have one letter difference since there's one correct pair.
                    if (numOfLettersChanged == 1) {
                        System.out.println(commonLetters);
                        System.exit(0);
                    }
                }
            }

        //If an exception (error) occurs, the catch block will print out (display to the user) what line the exception occured and why.
        //Try-catch blocks are generally used for debugging when the program is not functioning as expected.
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    //The following is the main method of the Java class. When a Java class is run, the main method is the first thing the computer looks at.
    //The "throws Exception" modifier is used since the path that I indicated could lead to a file other than a text file and the computer doesn't want that to occur.
    //Therefore, by acknowledging that the program may throw an exception, I'm forcing the computer to continue to run the program even if there's no valid file in that location in the computer's memory.
    public static void main(String[] args) throws Exception {

        //This statement creates a "Part1" object (so an object of this class).
        //When an object is created and instantiated (assigned a spot in the memory as indicated with the "new" keyword), the constructor of the object's class is automatically run.
        //In this case, the "public Part1()" constructor is run, which is basically all of the code in this program.
        new Part2();
    }
}
//The output of this program is "megsdlpulxvinkatfoyzxcbvq", which is the correct answer to my unique puzzle input.