import java.security.cert.PolicyQualifierInfo;
import java.util.*;

public class test11 {
    public static void main(String[] args) {
        ArrayList<int[]> list = new ArrayList<>();
        int [] A = new int[3];
        int [] B = new int[3];

        for (int i =0;i<3; i ++){
            A[i] = i;
            B[i] = i+1;
        }
        list.add(A);
        list.add(B);
        for (int[] i : list){
            System.out.println(Arrays.toString(i));
        }



    }
}
