/**Tyler Lofgren
 * http://www.codechef.com/problems/MARCHA1
 */

import java.util.Scanner;

class PayingUpA1
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[] bills = new int[n];
			for (int i = 0; i < bills.length; i++)
			{
				bills[i] = sc.nextInt();
			}
			boolean[] am = new boolean[m + 1];		//amounts possible
			am[0] = true;
			for (int i = 1; i < am.length; i++)
			{
				am[i] = false;
			}
			
			for (int i = 0; i < bills.length; i++)
			{
				for (int j = am.length - 1; j >= 0; j--)
				{
					if (am[j] == true && j + bills[i] < am.length)
					{
						am[j + bills[i]] = true;
					}
				}
				if (bills[i] < am.length)
				{
					am[bills[i]] = true;
				}
			}
			if (am[m] == true)
				System.out.println("Yes");
			else
				System.out.println("No");
		}
		sc.close();
	}
}
