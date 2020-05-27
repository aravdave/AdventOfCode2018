import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Part2 {
    public Part2() {
        Path path = Paths.get("C:/Users/aravd.000/Desktop/PuzzleInput.txt");
        try(BufferedReader br = Files.newBufferedReader(path)) {

            ArrayList<String> stringList = new ArrayList<String>();
            //Map<String, Integer> numOfUniqueLetters = new HashMap<>();
            //Map<Character, Integer> charactersAtPosition = new HashMap<>();
            String line;

            while((line = br.readLine()) != null) {
                stringList.add(line);
                //numOfUniqueLetters.put(line, 0);
            }

            /*for(int i = 0; i < stringList.get(0).length(); i++) {
                
                for(String j : stringList) {
                    char letterAtPositionI = j.charAt(i);
                    if (charactersAtPosition.containsKey(letterAtPositionI)) {
                        int numOfOccurencesOfChar = charactersAtPosition.get(letterAtPositionI);
                        charactersAtPosition.put(letterAtPositionI,++numOfOccurencesOfChar);
                    }
                    else
                        charactersAtPosition.put(letterAtPositionI, 1);
                }
                for(int k = (stringList.size()-1); k >= 0; k--){
                    String string = stringList.get(k);
                    char letterAtPositionI = string.charAt(i);
                    if (charactersAtPosition.get(letterAtPositionI) == 2){

                    }
                    if (charactersAtPosition.get(letterAtPositionI) < 2) {
                        int updatedNumOfUniqueLetters = numOfUniqueLetters.get(string) + 1;
                        numOfUniqueLetters.put(string, updatedNumOfUniqueLetters);
                        if (numOfUniqueLetters.get(string) >= 2) {
                            stringList.remove(string);
                            numOfUniqueLetters.remove(string);
                        }
                    }
                }
                charactersAtPosition.clear();
            }

            System.out.println(stringList);

            String commonLetters = "";
            for(int k = 0; k < stringList.get(0).length(); k++) {
                if (stringList.get(0).charAt(k) == stringList.get(1).charAt(k))
                    commonLetters = commonLetters + stringList.get(0).charAt(k);
            }

            System.out.println(commonLetters);*/

            for (int i = 0; i < stringList.size(); i++) {
                String firstID = stringList.get(i);
                for (int j = i+1; j < stringList.size(); j++) {
                    String secondID = stringList.get(j);
                    int numOfLettersChanged = 0;
                    String commonLetters = "";
                    for (int k = 0; k < stringList.get(i).length(); k++) {
                        if (firstID.charAt(k) != secondID.charAt(k))
                            numOfLettersChanged++;
                        else
                            commonLetters = commonLetters + Character.toString(firstID.charAt(k));
                    }
                    if (numOfLettersChanged == 1) {
                        System.out.println(commonLetters);
                        System.exit(0);
                    }
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws Exception {
        new Part2();
    }
}