public class 연습문제2 {
    public static void main(String[] args){
        String[] arr = {"INT","INT","BOOL","SHORT","LONG"};
        String answer = "";
        int count = 0;
        int allConut=0;

        for(int i=0;i<arr.length;i++){
            if(arr[i].equals("INT")){ // 8이상의 바이트
                for(int k=0;k<8-count;k++){
                    answer += ".";
                }
                answer +=",";
                allConut+=8-count;
                count = 0;
                for(int l=0;l<8;l++){
                    answer+="#";
                }

            }
        }
    }
}
