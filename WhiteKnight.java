/**Tyler Lofgren
 * http://www.codechef.com/problems/E1/
 */

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class WhiteKnight
{
	static boolean[][] pc;		//pawn coordinates
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0)
		{
			int n = Integer.parseInt(br.readLine());
			int[][] caps = new int[n][n];		//board with number of pawns captured at each spot
			pc = new boolean[n][n];		//coordinates
			Point knight = null;
			for (int i = 0; i < n; i++)
			{
				String line = br.readLine();
				for (int j = 0; j < n; j++)
				{
					caps[i][j] = 0;
					pc[i][j] = false;
					switch (line.charAt(j))
					{
					case 'P':
						pc[i][j] = true;
						break;
					case 'K':
						knight = new Point(i, j);
						break;
					default:
						break;
					}
				}
			}
			
			for (int j = n-1; j > 0; j--)
			{
				for (int i = 0; i < n-1; i++)
				{
					update(caps, i, j);
				}
			}
			System.out.println(caps[knight.x][knight.y]);
		}
		br.close();
	}
	
	public static void update(int[][] b, int i, int j)
	{
		int p = (pc[i][j] == true) ? 1 : 0;
		b[i][j] += p;
		if (b[i][j] > 0)
		{
			//update to the left
			if (j - 1 >= 0)
			{
				if (i - 2 >= 0 && b[i][j] > b[i-2][j-1])
					b[i-2][j-1] = b[i][j];
				if (i + 2 < b.length && b[i][j] > b[i+2][j-1])
					b[i+2][j-1] = b[i][j];
			}
			if (j - 2 >= 0)
			{
				if (i - 1 >= 0 && b[i][j] > b[i-1][j-2])
					b[i-1][j-2] = b[i][j];
				if (i + 1 < b.length && b[i][j] > b[i+1][j-2])
					b[i+1][j-2] = b[i][j];
			}
		}
	}
}
