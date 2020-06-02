// Arav Dave
// Anything typed after "//" in a line or between "/*" and "*/" within multiple lines is ignored by the program. Look for the double forward slash and the single forward slash with an asterisk to find my comments.

/*At this point, I'm allowing these Java programs (i.e. java.io.BufferedReader) to be accessed by my program so I can use the functions within them.
  These programs are within standard packages that are installed when Java is installed on a computer.
  To make all of the programs within a standard package accessible by my program, I typed a period and asterisk (.*) after I indicated which package I want accessible.

  The BufferedReader program can be used by my program to read a text file line by line.
  The java.nio.file.* package can be used to allow the program to access a specific file on my computer.

  The java.util.HashMap program allows my program to create objects of HashMap, a type of data structure.
  An object is a unique instance of a data structure. Let's say we have two objects: yourCar and myCar. Both of these objects are a type of car (the data strucure).
  HashMaps are unordered lists of key-value pairs. Since it's unordered, if you try to access the pairs in the HashMap, they may be in a different order than the order in which you added the pairs to the HashMap.
  For example, if you added <"Hi", 123>, <"Hello", 456>, and <"Wow", 789> in that order, the HashMap may store the objects in this order: <"Wow", 789>, <"Hi", 123>, and <"Hello", 456>.
  The key can be a different type of data structure than the value in the pair. In the HashMap mentioned above, the keys were strings (one or more characters between quotation marks) and the values were integers (numbers without decimals).

  The java.util.Map program is used by my program to access and alter my HashMap objects.

  When naming objects/variables, the appropriate naming convention states that the first letter of the first word in the name must be lowercase and the first letter of the rest of the words must be uppercase.
  */
import java.io.BufferedReader;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Map;

// "Part1" is the name of my class. A class contains a constructor (an object of the class itself) and methods (functions).
public class Part1 {

    // "Part1()" is the name of my constructor. Constructors have to be named the same as the class.
    public Part1() {

        // "path" is an object of Path. Basically, "path" contains the location of the puzzle input data that the program will access.
        Path path = Paths.get("C:/Users/aravd.000/Desktop/PuzzleInput.txt");

        // I am creating two int (integer) objects here: lettersThatAppearTwice, and lettersThatAppearThreeTimes. Although I referred to them as objects, these are just integer variables. I am assigning both of these objects to the integer zero. 
        int lettersThatAppearTwice = 0, lettersThatAppearThreeTimes = 0;

        /* This is a try-catch block. The program will try to run the code within the first open curly bracket and the last curly bracket right before the catch statement.
           If an error occurs within the try block, the program will skip to the code in the catch block. Otherwise, the code in the catch block is not run by the program.
           "br" is an object of BufferedReader that is accessing the file indicated by the path object.
        */
        try(BufferedReader br = Files.newBufferedReader(path)) {

            // The line below is creating a string object that will contain (a) character(s).
            String line;

            // "line = br.readLine()" is assigning the first ID in the puzzle input to the string object "line".
            // The code within the while loop will continue to run until there's no more IDs in the puzzle input (when the next line in the puzzle input equals null).
            // Every the conditional statement of the while loop is read by the computer, the next ID is stored as a string under the "line" object.
            while((line = br.readLine()) != null) {

                // The line below is creating a HashMap object called letterCounter that will have a string key and integer value in each pair in "letterCounter".
                Map<String, Integer> letterCounter = new HashMap<>();

                // This for loop iterates from the beginning of the ID through each letter until it reaches the end of the ID.
                // During each iteration, a letter of the ID is accessed. If the letter is not a key in "letterCounter", than the letter and a integer value of one is added as a key-value pair to "letterCounter".
                // If the letter (key) already contains a value, that value will be incrememented by one and reassigned to that key.
                // By incrementing the value of a letter (key) every time it appears in the string, the program can count the number of times each letter appears in the string and storing that data as a key-value pair in "letterCounter".
                for(int i = 0; i < line.length(); i++) {
                    String letter = Character.toString(line.charAt(i));
                    if (!(letterCounter.containsKey(letter)))
                        letterCounter.put(letter, 1);
                    else {
                        int occurence = letterCounter.get(letter);
                        letterCounter.put(letter, ++occurence);
                    }
                }

                // The HashMap "letterCounter" will now have the number of times a letter appears in a string.
                // The following statements determine if there's a value (number of occurences of a letter) of two and/or three and then increments the total number of IDs that contain a letter twice and/or three times, respectfully.
                if (letterCounter.containsValue(2))
                    lettersThatAppearTwice++;
                if (letterCounter.containsValue(3))
                    lettersThatAppearThreeTimes++;
            }
        //If an exception (error) occurs, the catch block will print out (display to the user) what line the exception occured and why.
        //Try-catch blocks are generally used for debugging when the program is not functioning as expected.
        } catch(Exception e) {
            e.printStackTrace();
        }

        //This statement prints out the product of the number of IDs that contained a letter twice times the numer of IDs that contained a letter three times.
        //In other words, it prints out the checksum for my list of box IDs.
        System.out.println(lettersThatAppearTwice * lettersThatAppearThreeTimes);
    }

    //The following is the main method of the Java class. When a Java class is run, the main method is the first thing the computer looks at.
    //The "throws Exception" modifier is used since the path that I indicated could lead to a file other than a text file and the computer doesn't want that to occur.
    //Therefore, by acknowledging that the program may throw an exception, I'm forcing the computer to continue to run the program even if there's no valid file in that location in the computer's memory.
    public static void main(String[] args) throws Exception {

        //This statement creates a "Part1" object (so an object of this class).
        //When an object is created and instantiated (assigned a spot in the memory as indicated with the "new" keyword), the constructor of the object's class is automatically ran.
        //In this case, the "public Part1()" constructor is run, which is basically all of the code in this program.
        new Part1();
    }
}
