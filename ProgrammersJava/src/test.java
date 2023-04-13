import java.util.HashSet;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        // '' = char, "" = String
        String[] participant = {"hi","how are"};
        String[] completion = {"dex","wddx"};
        List<String> runner = ArrayList<String>(Arrays.asList(participant));
        for(String i : completion){
            runner.remove(i);
        }
        return i.toString();
    }
}
