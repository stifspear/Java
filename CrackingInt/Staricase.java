import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Staricase {
    
    public static int count;
    public static int[] dp;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        for(int a0 = 0; a0 < s; a0++){
            int n = in.nextInt();
            count=0;
            dp = new int[n+1];
            dp[0]=1;
            for(int i=1;i<n+1;i++)
                dp[i]=0;
            
            System.out.println(doRecursion(n));
        }
    }
    public static int doRecursion(int n){
        if(n==0){
            System.out.println(n+"low");
            return 1;
        }
        if(n>0&&dp[n-1]!=0){
		System.out.println(n+"mid");
            return dp[n-1];
        }

        if(n-1>=0){
            return 0+doRecursion(n-1);
        }
        if(n-2>=0){
            return 0+doRecursion(n-2);
        }
        if(n-3>=0){
            return 0+doRecursion(n-3);
        }
        
        
        return 0;
       
    }
}

