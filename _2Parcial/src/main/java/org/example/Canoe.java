package org.example;

import java.util.Hashtable;

public class Canoe extends Ship{

    public Canoe(Point puntoInicial, CardinalPoints orientation, Board board) {
        super(puntoInicial, orientation, 1);
        board.board[puntoInicial.getX()][puntoInicial.getY()] = 'C';
    }
}
