package test;
import java.util.Scanner;
// four in a row game 
// ben weinstein
// 214271397
public class FourInRow
{
	
	// a function that generate the empty game board 
    public static String[][] generateBoard()
    {
        String[][] board = new String[7][15];
        for (int i =0;i<board.length;i++)
        {
            for (int j =0;j<board[i].length;j++)
            {
               if (j % 2 == 0) board[i][j] = "|";
                
                  else  board[i][j] = " ";
                 

            }
        }
        for(int i = 0; i<board[6].length;i++) {
        	
        	board[6][i] = "*";
        }
        return board;
    }

    // a function that print the game board
    public static void printBoard(String[][] board)
    {
        for (int i =0;i<board.length;i++)
        {
            for (int j=0;j<board[i].length;j++)
            {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }

    }



    // a function that drop a X player piece on the lowest spot on the requested column
    public static void dropX(String[][] board)

    {
        System.out.println("X turn (insert column 0–6): ");
        Scanner scan = new Scanner (System.in); 

        int c = 2*scan.nextInt()+1; // get the requested cloumn using the scanner

        // a loop that runs on the requested cloumn from the buttom
        for (int i =5;i>=0;i--)

        {
            
            if (board[i][c] == " ") 
            {
            	board[i][c] = "X";
                break;

            }


        }

    }

    // a function that drop a O player piece on the lowest spot on the requested column
    public static void dropO(String[][] board)

    {
        System.out.println("O turn (insert column 0–6): ");
        Scanner scan = new Scanner (System.in);
        int c = 2*scan.nextInt()+1; // get the requested column using the scanner

        // a loop that runs on the requested column from the buttom
        for (int i =5;i>=0;i--)

        {

            if (board[i][c] == " ") 

            {

            	board[i][c] = "O";

                break;

            }

        }

    }

    // a function that checks if one of the players won
    public static String checkWinner(String[][] board)
    {

    	// checking for a win in the same row
        for (int i =0;i<6;i++)

        {
            for (int j=0;j<7;j+=2)

            {

                if ((board[i][j+1] != " ")

                        && (board[i][j+3] != " ")

                        && (board[i][j+5] != " ")

                        && (board[i][j+7] != " ")

                        && ((board[i][j+1] == board[i][j+3])

                        && (board[i][j+3] == board[i][j+5])

                        && (board[i][j+5] == board[i][j+7])))

                return board[i][j+1]; // return X\O if there is a win
            }
        }
        
        // checking for column win
        for (int i=1;i<15;i+=2)
        {
            for (int j =0;j<3;j++)
            {
                if((board[j][i] != " ")

                        && (board[j+1][i] != " ")

                        && (board[j+2][i] != " ")

                        && (board[j+3][i] != " ")

                        && ((board[j][i] == board[j+1][i])

                        && (board[j+1][i] == board[j+2][i])

                        && (board[j+2][i] == board[j+3][i])))

                return board[j][i]; // return X\O if there is a win

            }
        }

        // checking for downwards diagnol win
        for (int i=0;i<3;i++)
        {

            for (int j=1;j<9;j+=2)

            {

                if((board[i][j] != " ")

                        && (board[i+1][j+2] != " ")

                        && (board[i+2][j+4] != " ")

                        && (board[i+3][j+6] != " ")

                        && ((board[i][j] == board[i+1][j+2])

                        && (board[i+1][j+2] == board[i+2][j+4])

                        && (board[i+2][j+4] == board[i+3][j+6])))

                return board[i][j]; // return X\O if there is a win

            }

        }


        // checking for upwards diagnol win
        for (int i=0;i<3;i++)
        {
            for (int j=7;j<15;j+=2)
            {

                if((board[i][j] != " ")

                        && (board[i+1][j-2] != " ")

                        && (board[i+2][j-4] != " ")

                        && (board[i+3][j-6] != " ")

                        && ((board[i][j] == board[i+1][j-2])

                        && (board[i+1][j-2] == board[i+2][j-4])

                        && (board[i+2][j-4] == board[i+3][j-6])))

                return board[i][j]; // return X\O if there is a win

            }

        }

      
        // if no one is currently winning then (nothing has been returned yet) return null
        return null;
    }


    public static void main(String args[]) {
    	
        String[][] board = generateBoard(); // generate the game board
        boolean loop = true; 
        int count = 0; // turns counter

        printBoard(board); 

        while(loop)
        {
            if (count % 2 == 0) dropX(board); // red starts so when count is even its the X turn and when count is odd its the O turn
             else dropO(board);

            count++; 
            printBoard(board); // print the board
          
            // check if there is a winner after the turn
            if (checkWinner(board) != null)
            {
                if (checkWinner(board) == "X")
                System.out.println("X won!!!");
                else if (checkWinner(board)== "O")
                System.out.println("O won!!!");
                // if there is a winner change loop to flase so the game loop will stop
                loop = false;
            }
        }
    }
}
