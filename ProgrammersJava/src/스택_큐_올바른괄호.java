import java.util.*;


public class 스택_큐_올바른괄호 {
    // s.split 썼더니 효율성 코드 통과 X
    // s.charAt(i) 써서 했더니 효율성 코드 통과

    class Solution1 {
        boolean solution(String s) {
            // boolean answer = true;
            Queue<String> que = new LinkedList<>();
            String [] given = s.split("");

            // 사전 세팅 및 방어막
            // if (given[0].equals(")")) return false;
            // que.add(given[0]); // "("
            // System.out.println(Arrays.toString(given));

            for(int i=0;i<given.length; i++){
                if(given[i].equals("(")){
                    que.add(given[i]);
                } else {
                    if(que.isEmpty()){
                        return false;
                    } else{
                        que.poll();
                    }
                }
                // if(given[i].equals(")")){
                //     if(que.isEmpty()){
                //         return false;
                //     } else if(que.poll().equals(")")){
                //         return false;
                //     }
                // } else {
                //     que.add(given[i]);
                // }
            }

            if(que.isEmpty()){
                return true;
            } else {
                return false;
            }
        }
    }

    class Solution2 {
        boolean solution(String s) {
            // boolean answer = true;
            Queue<Character> que = new LinkedList<>();
            // String [] given = s.split("");

            // 사전 세팅 및 방어막
            // if (given[0].equals(")")) return false;
            // que.add(given[0]); // "("
            // System.out.println(Arrays.toString(given));

            for(int i=0;i<s.length(); i++){
                if(s.charAt(i) =='('){
                    que.add('(');
                } else {
                    if(que.isEmpty()){
                        return false;
                    } else{
                        que.poll();
                    }
                }
                // if(given[i].equals(")")){
                //     if(que.isEmpty()){
                //         return false;
                //     } else if(que.poll().equals(")")){
                //         return false;
                //     }
                // } else {
                //     que.add(given[i]);
                // }
            }

            if(que.isEmpty()){
                return true;
            } else {
                return false;
            }
        }
    }
}
