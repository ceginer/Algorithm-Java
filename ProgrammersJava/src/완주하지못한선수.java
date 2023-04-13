import java.util.*;

public class 완주하지못한선수 {

    class Solution {
        public String solution(String[] participant, String[] completion) {
            List<String> runner = new ArrayList<String>(Arrays.asList(participant));
            for(String i : completion){
                runner.remove(i);
            }
            System.out.println(runner.get(0));
            return runner.get(0);
        }
    }
}
