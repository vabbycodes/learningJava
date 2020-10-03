package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "_________";
        int numX = 0;
        int numO = 0;
        int num_ = 0;
        int xWins = 0;
        int oWins = 0;
        for( int i = 0 ; i<9 ; i++){
            if(input.charAt(i) == 'X') numX++;
            else if(input.charAt(i) == 'O') numO++;
            else num_++;
        }

        // Grid Printer
        char[][] tttGrid = {{input.charAt(0), input.charAt(1), input.charAt(2)},
                {input.charAt(3), input.charAt(4), input.charAt(5)},
                {input.charAt(6), input.charAt(7), input.charAt(8)}};
        System.out.println("---------");
        System.out.println("| " + input.charAt(0) + " " + input.charAt(1) + " " + input.charAt(2) + " |");
        System.out.println("| " + input.charAt(3) + " " + input.charAt(4) + " " + input.charAt(5) + " |");
        System.out.println("| " + input.charAt(6) + " " + input.charAt(7) + " " + input.charAt(8) + " |");
        System.out.println("---------");
        int move = 1;

        while(true) {
            System.out.println("Enter the coordinates:");
            String x = scanner.next();
            String y = scanner.next();
            int valX = 0;
            int valY = 0;
            try {
                valX = Integer.parseInt(x);
                valY = Integer.parseInt(y);
                if (valX > 3 || valX < 1) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                } else if (valY > 3 || valY < 1) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers!");
            }

            valX = valX - 1;
            if (valY == 3) valY = 0;
            else if (valY == 2) valY = 1;
            else if (valY == 1) valY = 2;
            if (tttGrid[valY][valX] == '_') {
                if(move%2 ==0 ) tttGrid[valY][valX] = 'O';
                else tttGrid[valY][valX] = 'X';
                System.out.println("---------");
                System.out.println("| " + tttGrid[0][0] + " " + tttGrid[0][1] + " " + tttGrid[0][2] + " |");
                System.out.println("| " + tttGrid[1][0] + " " + tttGrid[1][1] + " " + tttGrid[1][2] + " |");
                System.out.println("| " + tttGrid[2][0] + " " + tttGrid[2][1] + " " + tttGrid[2][2] + " |");
                System.out.println("---------");
            } else {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }

            // Game Win Checker

            // Horizontal Matches
            if (tttGrid[0][0] == 'X' && tttGrid[0][1] == 'X' && tttGrid[0][2] == 'X') xWins++;
            if (tttGrid[1][0] == 'X' && tttGrid[1][1] == 'X' && tttGrid[1][2] == 'X') xWins++;
            if (tttGrid[2][0] == 'X' && tttGrid[2][1] == 'X' && tttGrid[2][2] == 'X') xWins++;

            // Vertical Matches
            if (tttGrid[0][0] == 'X' && tttGrid[1][0] == 'X' && tttGrid[2][0] == 'X') xWins++;
            if (tttGrid[0][1] == 'X' && tttGrid[1][1] == 'X' && tttGrid[2][1] == 'X') xWins++;
            if (tttGrid[0][2] == 'X' && tttGrid[1][2] == 'X' && tttGrid[2][2] == 'X') xWins++;

            // Diagonal Matches
            if (tttGrid[0][0] == 'X' && tttGrid[1][1] == 'X' && tttGrid[2][2] == 'X') xWins++;
            if (tttGrid[0][2] == 'X' && tttGrid[1][1] == 'X' && tttGrid[2][0] == 'X') xWins++;

            // Horizontal Matches
            if (tttGrid[0][0] == 'O' && tttGrid[0][1] == 'O' && tttGrid[0][2] == 'O') oWins++;
            if (tttGrid[1][0] == 'O' && tttGrid[1][1] == 'O' && tttGrid[1][2] == 'O') oWins++;
            if (tttGrid[2][0] == 'O' && tttGrid[2][1] == 'O' && tttGrid[2][2] == 'O') oWins++;

            // Vertical Matches
            if (tttGrid[0][0] == 'O' && tttGrid[1][0] == 'O' && tttGrid[2][0] == 'O') oWins++;
            if (tttGrid[0][1] == 'O' && tttGrid[1][1] == 'O' && tttGrid[2][1] == 'O') oWins++;
            if (tttGrid[0][2] == 'O' && tttGrid[1][2] == 'O' && tttGrid[2][2] == 'O') oWins++;

            // Diagonal Matches
            if (tttGrid[0][0] == 'O' && tttGrid[1][1] == 'O' && tttGrid[2][2] == 'O') oWins++;
            if (tttGrid[0][2] == 'O' && tttGrid[1][1] == 'O' && tttGrid[2][0] == 'O') oWins++;

            if ((((numX - numO >= 2) || (numO - numX >= 2))) || (xWins > 0 && oWins > 0))
                System.out.println("Impossible");
            else if (xWins == 0 && oWins == 0 && num_ == 0) {
                System.out.println("Draw");
                break;
            }
            else if (xWins > 0) {
                System.out.println("X wins");
                break;
            } else if (oWins > 0) {
                System.out.println("O wins");
                break;
            }
        }
    }
}
