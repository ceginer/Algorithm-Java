import java.util.*;

// 부스트캠프 7기 모집 1번문제

public class 연습문제1 {

    public static void main(String[] args){
        int[] arr = {1,1,1,2,3,1,1,1,3,3,4,4,4};
        Arrays.sort(arr);
        Queue<Integer> que = new LinkedList<>();
        List<Integer> list =new ArrayList<>();
        que.offer(arr[0]);
        int now = que.poll();
        int count = 1;

        for(int i=1;i <arr.length; i++){
            if(now == arr[i]){
                count++;
                if(count > 1 && i == arr.length-1){
                    list.add(count);
                    count =1;
                }
            } else{
                if(count > 1){
                    list.add(count);
                    count=1;
                }
                que.offer(arr[i]);
                now = que.poll();
            }
            System.out.println(list.toString());
            System.out.println(count);
        }
        System.out.println(list.toString());
    }
}
