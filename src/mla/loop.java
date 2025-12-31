package mla;
import java.util.*;
public class loop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * for(int i=0;i<=10;i+=2) { System.out.print(i+" "); } int i=1;
		 * System.out.println(); while(i<=10){ System.out.print(i+" "); i+=2;
		 * 
		 * }
		 */
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a number");
		int a=sc.nextInt();
		if(a%2==0) 
			{
				System.out.println("the given number is even: "+a);
			}
			else {
				System.out.println("the given number is odd:"+a);
			}
		int[] numbers= {1,2,3,4};
		for(int b:numbers) {
			System.out.println(b+" ");
		}
		
	}

}
