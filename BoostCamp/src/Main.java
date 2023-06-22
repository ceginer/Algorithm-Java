import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Map<Integer,Integer> map1 = new HashMap<>();
        Map<Integer,Integer> map2 = new HashMap<>();
        map1.put(1,9);
        map1.put(2,7);
        map1.put(3,4);
        map1.put(4,0);
        map1.put(5,1);
        List<Integer> list= new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        Collections.sort(list, (o1, o2) -> (map1.get(o1)).compareTo(map1.get(o2)));

        System.out.println(list.toString());
    }
}