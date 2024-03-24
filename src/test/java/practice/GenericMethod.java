package practice;

public class GenericMethod {

	public static void main(String[] args) {//calling/caller method/function
		int sum=add(10,20);
		System.out.println(sum);
		int diff=sub(20,10);
		System.out.println(diff);
	}
	//parameterisation
	public static int add(int a, int b)//called/callee method/function-->generic and reusable
	{
		int c = a+b;
		return c;
	}
	public static int sub(int a, int b)
	{
		int c = a-b;
		return c;
	}

}
