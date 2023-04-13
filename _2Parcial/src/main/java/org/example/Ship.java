package org.example;

import java.util.Hashtable;
import java.util.Objects;

public class Ship {
    protected Point puntoInicial ;
    protected CardinalPoints orientation;
    protected int tamano;

    public Ship(Point puntoInicial, CardinalPoints orientation, int tamano) {
        this.puntoInicial = puntoInicial;
        this.orientation = orientation;
        this.tamano = tamano;
    }

    public Point getPuntoInicial() {
        return puntoInicial;
    }

    public void setPuntoInicial(Point puntoInicial) {
        this.puntoInicial = puntoInicial;
    }

    public CardinalPoints getOrientation() {
        return orientation;
    }

    public void setOrientation(CardinalPoints orientation) {
        this.orientation = orientation;
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    public boolean isSunk(Ship ship, Board board) {
        for (int i = 0; i < ship.getTamano(); i++) {
            switch (ship.getOrientation()){
                case NORTH -> {
                    if (board.board[ship.getPuntoInicial().getX()][ship.getPuntoInicial().getY() - i] == 'B') {
                        return false;
                    }
                }
                case SOUTH -> {
                    if (board.board[ship.getPuntoInicial().getX()][ship.getPuntoInicial().getY() + i] == 'B') {
                        return false;
                    }
                }
                case EAST -> {
                    if (board.board[ship.getPuntoInicial().getX()-i][ship.getPuntoInicial().getY()] == 'B') {
                        return false;
                    }
                }
                case WEST -> {
                    if (board.board[ship.getPuntoInicial().getX()+i][ship.getPuntoInicial().getY()] == 'B') {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean getShot(Point punto, Board board) {
        if (board.board[punto.getX()][punto.getY()] == 'C') {
            board.board[punto.getX()][punto.getY()] = 'X';
            return true;
        } else if (board.board[punto.getX()][punto.getY()] == 'F') {
            board.board[punto.getX()][punto.getY()] = 'X';
            return true;
        } else if (board.board[punto.getX()][punto.getY()] == 'B') {
            board.board[punto.getX()][punto.getY()] = 'X';
            return true;
        } else {
            board.board[punto.getX()][punto.getY()] = 'O';
            return false;
        }
    }

}
