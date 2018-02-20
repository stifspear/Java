/*
 * Program Description:
 * Date Created: Fri 18 Aug 2017 09:57:39 PM IST
 * Author : Stif Spear Subba
 */
import java.io.*;
import java.util.*;
class Stock{
	int day;
	int price;
}
public class BuyMaximum{

	static int buyMaximumProducts(int k, Stock[] a) {
		Arrays.sort(a, (x,y) -> x.price-y.price);
		int temp = 0;
		for(Stock cur:a){
			temp += cur.day;
			k-=cur.price;
			if(k<0)
				return temp-cur.day;

		}
		return temp;

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Stock[] arr = new Stock[n];
		for(int arr_i = 0; arr_i < n; arr_i++){
			Stock ob = new Stock();
			ob.day = arr_i+1;
			ob.price = in.nextInt();
			arr[arr_i] = ob;

		}
		int k = in.nextInt();
		int result = buyMaximumProducts(k, arr);
		System.out.println(result);
		in.close();

	}

}

