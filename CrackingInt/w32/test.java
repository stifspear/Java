import java.util.*;
class test
{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		ModuloInverse ob = new ModuloInverse();
		System.out.println(ob.fermatsMod(in.nextLong(),in.nextLong()));	
		ExpSquare ob1 = new ExpSquare();
		System.out.println(ob1.getPower(1,3,9));
	}
}
