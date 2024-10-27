import java.util.*;

public class MaxMInDiif {
    
    static int FindMaxMinDiff(int arr[],int N,int K){

        //step 1 : sort the array

        Arrays.sort(arr);

        int ans=Integer.MAX_VALUE;
        //step 2 : find max Min diff
        for(int i=0;i<=(N-K);i++){

            int currDiff=arr[i+K-1] - arr[i];

             ans=Math.min(ans,currDiff);
        }
        return ans;
    }

    public static void main(String args[]){

        // int arr[]={5,1,10,6};
        int arr[]={3,5,100,101,102};

        int N=arr.length;

        int k=3;

        System.out.println(FindMaxMinDiff(arr,N,k));
    }
}
