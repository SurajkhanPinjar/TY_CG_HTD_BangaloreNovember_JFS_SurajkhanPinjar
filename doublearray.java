import java.util.Scanner;
class DoubleArray
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the row size");
		int row=sc.nextInt();
		System.out.println("ENter the Col Size:");
		int col=sc.nextInt();
		
		double[][] a1=new double[row][col];
		
		System.out.println("Enter the elements of the array:");
		for (int i=0;i<row ;i++ )
		{
			for (int j=0; j<col ;j++ )
			{
				a1[i][j]=sc.nextDouble();
			}
		}

		System.out.println("Elements are:");
		for (int i=0;i<row ;i++ )
		{
			for (int j=0;j<col ;j++ )
			{
				System.out.print(a1[i][j]+"  ");

			}
			System.out.println();
			System.out.println();

		}
	}

}