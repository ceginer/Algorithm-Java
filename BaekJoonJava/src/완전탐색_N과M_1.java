import java.util.*;

public class 완전탐색_N과M_1 {
    static List<String> list1 = new ArrayList<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int M = in.nextInt();
        String others = "";
        for (int i=1; i<= N; i++){
            others += i;
        }

        recursive("", others, M);
        for(String list : list1){
            if (list.length() == M)
            {
                for (int i=0; i<list.length(); i++){
                    System.out.print(list.charAt(i) + " ");
                }
                System.out.println();
            }
        }

    }
    private static void recursive(String str, String others, int M){
        if(!str.equals("") && str.length() <= M){
            list1.add(str);

        }
        for (int i =0; i<others.length(); i++){
            recursive(str+others.charAt(i), others.substring(0,i) + others.substring(i+1),M);
        }
    }
}
