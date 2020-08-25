import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        /* Sample Input:
        3
        5 8 9 6 7 4 2 1 3
        7 4 3 1 8 2 9 5 6
        1 2 6 9 5 3 8 7 4
        9 3 5 4 2 1 7 6 8
        4 1 2 8 6 7 3 9 5
        6 7 8 3 9 5 1 4 2
        8 6 4 2 1 9 5 3 7
        3 9 7 5 4 8 6 2 1
        2 5 1 7 3 6 4 8 9
        
         */

        // reading n of the array to get sqaure matrix number
        int n = input.nextInt();

        //its a sqaure matrix so also has small matrix of size n
        int square = n * n;

        int[][] sudoku = new int[square][square];
        int total = 0;


        // reading the whole  sudoku from console and saving in an array
        for (int i = 0; i < square; i++) {
            for (int j = 0; j < square; j++) {
                sudoku[i][j] = Integer.parseInt(input.next());
            }
        }

        // a sudoku is correct if total number is for example size n = 3 and sqaured = 9 then correct will have total 45
        // in box/column/row whateves;
        for (int i = 1; i <= square; i++) {
            total += i;
        }

//        System.out.println("total = " + total);

//        for (int [] vector : sudoku
//             ) {
//            System.out.println(Arrays.toString(vector));
//        }

        boolean flag = true;

        //checking the rows to see if sudoku if correct /  if total is equal is 45

        for (int i = 0; i < square; i++) {

            int smalltotal = 0;
            for (int j = 0; j < square; j++) {
                smalltotal += sudoku[i][j];
            }

            if (total != smalltotal) {
//                System.out.println("small total = " + smalltotal);
                flag = false;
                break;
            }
        }


// checking the smaller matrix  of size n if sudo is correct
        int smallTotal = 0;
        int x = 0;
        int y = 0;
        int row = n;
        int column = n;



// infinite loop to check all the matrixes
// if one of the smaller matrix is wrong it breaks out of loop , if not
        // goes throu the whole thing and then breaks
        while (flag) {


            for (int i = x; i < row; i++) {
                for (int j = y; j < column; j++) {
//                    System.out.println("adding to small number = " + sudoku[i][j] + " at " + i + j);
                    smallTotal += sudoku[i][j];
                }
            }
// remember total is 45 for for example
            if (smallTotal != total) {
                flag = false;
                break;
            }

//
//            System.out.println("xx loop " + row);
//            System.out.println("yy loop " + column);
//            System.out.println("x loop " + x);
//            System.out.println("y loop " + y);


            smallTotal = 0;


            // BREAKS WHEN  IT FINISHES THE LAST SMALLER MATRIXS
            if (row == square && column == square) {
                break;
            }

            //ones it doest with the columns, the code moves the rows to middle matrixs


            if (column == square) {

                //System.out.println("YY is equal nine " + count + " times moving on to next row of matrix");
                row += n;
                x += n;
                column = n;
                y = 0;
                continue;

            }


            y += n;
            column += n;


        }
        // checking the columns
        if(flag){

            //System.out.println("Checking the rows");

            for (int i = 0; i < square; i++) {

                int smalltotal = 0;
                for (int j = 0; j < square; j++) {
                    smalltotal += sudoku[j][i];
                }

                if (total != smalltotal) {
                    //System.out.println("small total = " + smalltotal);
                    flag = false;
                    break;
                }
            }

        }


        if (flag)
            System.out.println("YES");
        else
            System.out.println("NO");

    }
}