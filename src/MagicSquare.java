public class MagicSquare
{
    private int[][] square;
    private int i; // index of next available space

    /**
     * Constructs an n by n MagicSquare
     * @param n
     */
    public MagicSquare(int n)
    {
        i = 0;
        square = new int[n][n];
    }

    /**
     * Inserts x at the index i, the next available
     *  slot following row-major order.
     * @param x
     */
    public void add(int x)
    {
        for (int r = i / square[0].length; r < square.length; r++)
        {
            for (int c = 0; c < square[r].length; c++)
            {
                square[r][i % square[r].length] = x;
                i++;
                break; //breaks to make sure it doesnt fill the rest
            }
            break;
        }
    }

    /**
     * @param nums
     * @return The sum of nums
     */
    private int sum(int[] nums)
    {
        int sum = 0;

        for (int r = 0; r < square.length; r++)
        {
            for (int c = 0; c < square[r].length; c++)
            {
                sum += square[r][c];
            }
        }

        return sum;
    }

    /**
     * @return The constant that each row, column,
     *          and diagonal should add-up to.
     */
    private int getConstant()
    {
        return 1; // did not use this method
    }

    /**
     * @return true if each row, column, and diagonal
     *          add-up to the constant; false otherwise
     */
    public boolean isMagical()
    {
        return  isMagicalColumns() || isMagicalRows() || isMagicalDiagonals();
    }

    /**
     * @return true if each row adds-up to the constant;
     *          false otherwise
     */
    private boolean isMagicalRows()
    {
        int sum1 = 0; // sum of first row
        int sum2 = 0; // temporary sum for the rest of the rows to compare to sum1

        for (int c = 0; c < square[0].length; c++)
        {
            sum1 += square[0][c]; // first row
        }

        for (int r = 1; r < square.length ; r++)
        {
            for (int c = 0; c < square[r].length; c++)
            {
                sum2 += square[r][c];
            }

            if(sum1 != sum2)
            {
                return false;
            }
            sum2 = 0;

        }

        return true;
    }

    /**
     * @return true if each column adds-up to the constant;
     *          false otherwise
     */
    private boolean isMagicalColumns()
    {
        int sum1 = 0; //sum of first column
        int sum2 = 0; //temporary sum for the rest of the rows to compare to sum1

        for (int r = 0; r < square.length; r++)
        {
            sum1 += square[r][0]; //first column
        }

        for (int c = 1; c < square[0].length ; c++)
        {
            for (int r = 0; r < square.length; r++)
            {
                sum2 += square[r][c];
            }

            if(sum1 != sum2)
            {
                return false;
            }
            sum2 = 0;

        }

        return true;
    }

    /**
     * @return true if each diagonal adds-up to the constant;
     *          false otherwise
     */
    private boolean isMagicalDiagonals()
    {
        int sum1 = 0; //sum of first diagonal
        int sum2 = 0; //sum of second diagonal

        int x = 0; //index for which column for sum1
        int y = square[0].length - 1; //index for which column for sum2
        for (int r = 0; r < square.length; r++)
        {
            sum1 += square[r][x];
            x++;
        }

        for (int r2 = square.length - 1; r2 > 0; r2--)
        {
            sum2 += square[r2][y];
        }

        if(sum1 != sum2)
        {
            return false;
        }

        return true;
    }

    /**
     * @return A String representation of this MagicSquare.
     */
    public String toString()
    {
        String rtn = "";

        for(int[] row : square)
        {
            for (int element : row)
                rtn += element + "\t";
            rtn += "\n";
        }

        return rtn;
    }
}