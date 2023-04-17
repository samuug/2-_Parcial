package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Hashtable;

public class Board{

    public char board[][];
    public final int SIZE = 10;


    public Board() {
        this.board = new char[SIZE][SIZE];
    }

    public char[][] getBoard() {
        return board;
    }

    public void setBoard(char[][] board) {
        this.board = board;
    }

    public void fillBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[j][i] = '~';
            }
        }
    }

    public void showBoard(){
        System.out.println("  0 1 2 3 4 5 6 7 8 9");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[j][i] + " ");
            }
            System.out.println();
        }
    }
}
