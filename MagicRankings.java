/**Tyler Lofgren
 * http://www.codechef.com/problems/MGCRNK
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class MagicRankings
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0)
		{
			double avg;
			int n = Integer.parseInt(br.readLine());
			int[][] cells = new int[n][n];
			for (int i = 0; i < n; i++)
			{
				String[] line = br.readLine().split(" ");
				for (int j = 0; j < n; j++)
					cells[i][j] = Integer.parseInt(line[j]);
			}
			
			//build table of max total scores			
			// first row
			for (int j = 1; j < n; j++)
				cells[0][j] += cells[0][j-1];
			//first column
			for (int i = 1; i < n; i++)
				cells[i][0] += cells[i-1][0];
			//rest of the table
			for (int i = 1; i <= n-1; i++)
				for (int j = 1; j <= n-1; j++)
					cells[i][j] += Math.max(cells[i-1][j], cells[i][j-1]);
			
			//output either double or Bad Judges
			avg = cells[n-1][n-1] / (2.0 * n - 3);
			if (avg >= 0)
				System.out.println(avg);
			else
				System.out.println("Bad Judges");
		}
		br.close();
	}
}
