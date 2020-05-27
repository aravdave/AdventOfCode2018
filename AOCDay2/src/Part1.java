import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Part1 {
    public Part1() {
        Path path = Paths.get("C:/Users/aravd.000/Desktop/PuzzleInput.txt");
        int lettersThatAppearTwice = 0, lettersThatAppearThreeTimes = 0;
        try(BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            while((line = br.readLine()) != null) {
                Map<String, Integer> letterCounter = new HashMap<>();
                for(int i = 0; i < line.length(); i++) {
                    String letter = Character.toString(line.charAt(i));
                    if (!(letterCounter.containsKey(letter)))
                        letterCounter.put(letter, 1);
                    else {
                        int occurence = letterCounter.get(letter);
                        letterCounter.put(letter, ++occurence);
                    }
                }
                if (letterCounter.containsValue(2))
                    lettersThatAppearTwice++;
                if (letterCounter.containsValue(3))
                    lettersThatAppearThreeTimes++;
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println(lettersThatAppearTwice * lettersThatAppearThreeTimes);
    }
    public static void main(String[] args) throws Exception {
        new Part1();
    }
}
