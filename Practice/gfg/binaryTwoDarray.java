package Practice.gfg;

public class binaryTwoDarray {
    public static void search(int[][] arr, int n, int x) {

        // set indexes for top right element
        int row = 0, col = n - 1;


        while (row < n && col >= 0) {
            if (arr[row][col] == x)
            {
                System.out.print("Found at (" + row + ", " + col + ")");
                return;
            }
            if (x < arr[row][col])
                col--;
            else // if mat[row][col] < x
                row++;
        }

        System.out.print("Element not found");
        return; // if ( row==n || col== -1 )
    }

    public static void main(String[] args)
    {
        int arr[][] = {
                { 10, 20, 30, 40 },
                { 15, 25, 35, 45 },
                { 27, 29, 37, 48 },
                { 32, 33, 39, 50 }
        };

        search(arr, 4, 29);
    }
}
