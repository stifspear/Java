import java.util.*;

public class Fibonacci {
    
    public static int[][] matrixMult(int[][] x,int[][] y){
        int[][] res=new int[2][2];
        res[0][0]=x[0][0]*y[0][0]+x[0][1]*y[1][0];
        res[0][1]=x[0][0]*y[0][1]+x[0][1]*y[1][1];
        res[1][0]=x[1][0]*y[0][0]+x[1][1]*y[1][0];
        res[1][1]=x[1][0]*y[0][1]+x[1][1]*y[1][1];
	display(res);
        return res;
	
    }
    
    public static int[][] findPower(int[][] x,int po){
        if(po==1)
            return x;
        if(po%2==0)
            x=findPower(matrixMult(x,x),po/2);
        else
            x=matrixMult(x,findPower(matrixMult(x,x),(po-1)/2));
        return x;
    }

    
    public static int fibonacci(int n) {
        // Complete the function.
      int[][] x={{0,1},{1,1}};
      int[][] y=new int[2][2];
        y=findPower(x,n+1);
	display(y);
        if(n==0)
            return 0;
        return y[0][0];
      
    }
    public static void display(int[][] x){
	    for(int i=0;i<2;i++){
		    for(int j=0;j<2;j++){
			    System.out.print(x[i][j]+" ");
		    }
		    System.out.println();
	    }
	    System.out.println();
    }
    

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        System.out.println(fibonacci(n));
    }
}

