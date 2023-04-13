package org.example;

import java.util.Hashtable;
import java.util.List;

public class Frigate extends Ship{

    public Frigate(Point puntoInicial, CardinalPoints orientation, Board board) {
        super(puntoInicial, orientation, 3);
        setBarco(puntoInicial, orientation, 3, board);
    }

    public void setBarco(Point puntoInicial, CardinalPoints orientation, int tamano, Board board) {
        switch (orientation){
            case NORTH -> {
                for (int i = 0; i < tamano; i++) {
                    board.board[puntoInicial.getX()][puntoInicial.getY() - i] = 'F';
                }
            }
            case SOUTH -> {
                for (int i = 0; i < tamano; i++) {
                    board.board[puntoInicial.getX()][puntoInicial.getY() + i] = 'F';
                }
            }
            case EAST -> {
                for (int i = 0; i < tamano; i++) {
                    board.board[puntoInicial.getX()-i][puntoInicial.getY()] = 'F';
                }
            }
            case WEST -> {
                for (int i = 0; i < tamano; i++) {
                    board.board[puntoInicial.getX()+i][puntoInicial.getY()] = 'F';
                }
            }
        }
    }
}
