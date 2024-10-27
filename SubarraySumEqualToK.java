import java.util.*;

public class SubarraySumEqualToK {
    public static void main(String args[]){

        // int arr[]={1,2,3};
        int arr[]={10 ,2,-2,-20,10};
        int k=-10;

        //store sum and index
        HashMap<Integer,Integer> map=new HashMap<>();

        // intital me man lenge ek subarray hai
        map.put(0,1);

        int sum=0;
        int lenOfSubArr=0;

        for(int i=0;i<arr.length;i++){

          sum += arr[i];
            if(map.containsKey(sum-k)){
                lenOfSubArr += map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }

        System.out.println("Subarray equal to K:"+lenOfSubArr);
    }
}
