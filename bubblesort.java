import java.util.Scanner;
class BubbleSort
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Size of the array");
		int size=sc.nextInt();
		int[] a1=new int[size];
		System.out.println("Enter the elements of the array");
		for (int i=0;i<a1.length ;i++ )
		{
			a1[i]=sc.nextInt();
		}
		
		System.out.println("Elements before sorting");
		for (int i=0;i<a1.length ;i++ )
		{
			System.out.print(a1[i]+" " );

		}
		System.out.println();
		
		//System.out.println("ELements after sorting");
		for (int i=0;i<a1.length-1 ;i++ )
		{
			for (int j=0;j<a1.length-1 ;j++ )
			{
				if (a1[j]>a1[j+1])
				{
					int temp;
					temp=a1[j];
					a1[j]=a1[j+1];
					a1[j+1]=temp;
				}
			}
		}

		System.out.println("ELements after sorting");
		for (int i=0;i<a1.length ;i++ )
		{
			System.out.print(a1[i] +" ");
		}
	}
}