import java.awt.*;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //khoi tao bang
        char GameBoard[][] = new char[3][3];
        for (int i = 0;i <3;i++){
            for (int j = 0;j < 3;j++){
                GameBoard[i][j] = '-';
            }
        }
        printGameBoard(GameBoard);
        //khoi tao luot choi p1 dau tien
        boolean isP1turn = true;

        //dinh nghia ki hieu x-o
        char symbol =' ';

        //khoi tao bien chu chi so ham cot
        int row = 0,col = 0;

        boolean isPlaying = true;

        //chuong trinh game
    while(isPlaying) {
        if(isP1turn) System.out.println("Lượt của x");
        else System.out.println("Lượt của O");
        System.out.println("Vui lòng nhập vị trí");
         row = sc.nextInt();
         col = sc.nextInt();

        if(isP1turn) symbol ='x';
        else symbol = 'o';

        //kiem tra hang cot
        if (row > 2 || row < 0 || col > 2 || col < 0) System.out.println("Vui long nhap lai vi tri");
        else if (GameBoard[row][col] != '-') System.out.println("Vui long nhap lai vi tri");
        else {
            GameBoard[row][col] = symbol;
            isP1turn = !isP1turn;
        }
        printGameBoard(GameBoard);
        if(CheckWinner(GameBoard) == 'x') {
            System.out.println("X thắng");
            isPlaying = false;
        }
        if(CheckWinner(GameBoard) == 'o') {
            System.out.println("O Thắng");
            isPlaying = false;
        }
        if(CheckTied(GameBoard)){
            System.out.println("Hòa cờ");
            isPlaying = false;
        }
    }
    }
    public static void printGameBoard(char[][] GameBoard){
        for (int i = 0;i <3;i++){
            for (int j = 0;j < 3;j++){
                System.out.print(GameBoard[i][j]);
            }
            System.out.print('\n');
        }
    }

    public static char CheckWinner(char[][] GameBoard){
        //kiem tra theo hang
        for(int i = 0;i < 3;i++){
            if(GameBoard[i][0] == GameBoard[i][1] && GameBoard[i][0] == GameBoard[i][2]) return GameBoard[i][0];
            if(GameBoard[0][i] == GameBoard[1][i] && GameBoard[0][i] == GameBoard[2][i]) return GameBoard[0][i];
        }
        if(GameBoard[0][0] == GameBoard[1][1] && GameBoard[0][0] == GameBoard[2][2]) return GameBoard[0][0];
        if(GameBoard[0][2] == GameBoard[1][1] && GameBoard[2][0] == GameBoard[0][2]) return GameBoard[0][0];

        return '-';
    }
    public static boolean CheckTied(char[][] GameBoard){
        for (int i = 0;i <3;i++){
            for (int j = 0;j < 3;j++){
                if(GameBoard[i][j] == '-') return false;
            }
        }
        return true;
    }
}