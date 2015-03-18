/**Tyler Lofgren
 * http://www.codechef.com/problems/FIRESC
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class FireEscape
{
	static final int BIGPRIME = 1000000007;
	static int[] groups, sizes, rank;
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0)
		{
			String[] line = br.readLine().split("\\s+");
			int numEmployees = Integer.parseInt(line[0]);
			int numRelationships = Integer.parseInt(line[1]);
			groups = new int[numEmployees + 1];
			sizes = new int[numEmployees + 1];
			rank = new int[numEmployees + 1];
			for (int i = 0; i < groups.length; ++i)
			{
				groups[i] = i;
				sizes[i] = 1;
			}
			for (int i = 0; i < numRelationships; ++i)
			{
				line = br.readLine().split("\\s+");
				int a = Integer.parseInt(line[0]);
				int b = Integer.parseInt(line[1]);
				join(a,b);
			}
			int captains = 0;
			long combos = 1;
			for (int i = 1; i < groups.length; i++)
			{
				if (groups[i] == i)
				{
					captains++;
					combos = (combos * sizes[i]) % BIGPRIME;
				}
			}
			System.out.println(captains + " " + combos);
		}
		br.close();
	}
	
	public static void join(int i, int j)
	{
		int cI = findCaptain(i);
		int cJ = findCaptain(j);
		if (cI == cJ)
			return;
		if (rank[cI] < rank[cJ])
		{
			groups[cI] = cJ;
			sizes[cJ] += sizes[cI];
		}
		else if (rank[cI] > rank[cJ])
		{
			groups[cJ] = cI;
			sizes[cI] += sizes[cJ];
		}
		else
		{
			groups[cJ] = cI;
			sizes[cI] += sizes[cJ];
			rank[cI]++;
		}
	}
	
	public static int findCaptain(int x)
	{
		boolean done = false;
		int val = groups[x];
		while (!done)
		{
			if (groups[val] != val)
				val = groups[val];
			else
				done = true;
		}
		return val;
	}
}