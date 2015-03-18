/**Tyler Lofgren
 * http://www.codechef.com/problems/GERALD03
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Segments
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0)
		{
			//initialize
			int n = Integer.parseInt(br.readLine());
			int[] lefts = new int[n];
			int[] rights = new int[n];
			
			for (int i = 0; i < n; i++)
			{
				String[] line = br.readLine().split(" ");
				lefts[i] = Integer.parseInt(line[0]);
				rights[i] = Integer.parseInt(line[1]);
			}
			
			//perform operations
			int ops = 0;
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < n - 1; i++)
			{
//				while (lefts[i] < lefts[i+1] || rights[i] < rights[i+1])
				while (lefts[i] != lefts[i+1] || rights[i] != rights[i+1])
				{
					if (lefts[i] < lefts[i+1] && lefts[i] + 1 != rights[i])
					{
						lefts[i]++;
						sb.append("L+");
						ops++;
					}
					else if (lefts[i] > lefts[i+1] && lefts[i] - 1 != rights[i])
					{
						lefts[i]--;
						sb.append("L-");
						ops++;
					}
					else if (rights[i] < rights[i+1] && rights[i] + 1 != lefts[i])
					{
						rights[i]++;
						sb.append("R+");
						ops++;
					}
					else if (rights[i] > rights[i+1] && rights[i] - 1 != lefts[i])
					{
						rights[i]--;
						sb.append("R-");
						ops++;
					}
				}
		
//				while (Math.abs(lefts[i] - rights[i]) != 1)
//				{
//					if (lefts[i] < lefts[i+1])
//					{
//						lefts[i]++;
//						sb.append("L+");
//						ops++;
//					}
//					else if (rights[i] < rights[i+1])
//					{
//						rights[i]++;
//						sb.append("R+");
//						ops++;
//					}
//					else if (lefts[i] > lefts[i+1])
//					{
//						lefts[i]--;
//						sb.append("L-");
//						ops++;
//					}
//					else if (rights[i] > rights[i+1])
//					{
//						rights[i]--;
//						sb.append("R-");
//						ops++;
//					}
//				}
			}
			
			//print results
			System.out.println(ops);
			System.out.println(sb.toString());
		}
		
		br.close();
	}
}
