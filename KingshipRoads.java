/**Tyler Lofgren
 * http://www.codechef.com/problems/KINGSHIP
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class KingshipRoads
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0)
		{
			int n = Integer.parseInt(br.readLine());
			int[] c = new int[n];
			String[] line = br.readLine().split("\\s+");
			for (int i = 0; i < n; ++i)
			{
				c[i] = Integer.parseInt(line[i]);
			}
			
			Arrays.sort(c);
			long sum = 0;
			for (int i = 1; i < n; ++i)
			{
				sum += c[i];
			}
			System.out.println(sum * ((long) c[0]));
		}
		br.close();
	}
}