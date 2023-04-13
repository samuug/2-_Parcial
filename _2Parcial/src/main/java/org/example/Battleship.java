package org.example;

import java.util.Hashtable;
import java.util.List;

public class Battleship extends Ship{

    public Battleship(Point puntoInicial, CardinalPoints orientation, Board board) {
        super(puntoInicial, orientation, 5);
        setBarco(puntoInicial, orientation, 5, board);
    }

    public void setBarco(Point puntoInicial, CardinalPoints orientation, int tamano, Board board) {
        switch (orientation){
            case NORTH -> {
                for (int i = 0; i < tamano; i++) {
                    board.board[puntoInicial.getX()][puntoInicial.getY() - i] = 'B';
                }
                System.out.println("Battleship placed");
            }
            case SOUTH -> {
                for (int i = 0; i < tamano; i++) {
                    board.board[puntoInicial.getX()][puntoInicial.getY() + i] = 'B';
                }
                System.out.println("Battleship placed");
            }
            case EAST -> {
                for (int i = 0; i < tamano; i++) {
                    board.board[puntoInicial.getX()-i][puntoInicial.getY()] = 'B';
                }
                System.out.println("Battleship placed");
            }
            case WEST -> {
                for (int i = 0; i < tamano; i++) {
                    board.board[puntoInicial.getX()+i][puntoInicial.getY()] = 'B';
                }
                System.out.println("Battleship placed");
            }
        }
    }
}
