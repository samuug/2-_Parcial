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
                    if (board.board[ship.getPuntoInicial().getX()][ship.getPuntoInicial().getY() - i] == 'B' || board.board[ship.getPuntoInicial().getX()][ship.getPuntoInicial().getY() - i] == 'F' || board.board[ship.getPuntoInicial().getX()][ship.getPuntoInicial().getY() - i] == 'C') {
                        return false;
                    }
                }
                case SOUTH -> {
                    if (board.board[ship.getPuntoInicial().getX()][ship.getPuntoInicial().getY() + i] == 'B' || board.board[ship.getPuntoInicial().getX()][ship.getPuntoInicial().getY() + i] == 'F' || board.board[ship.getPuntoInicial().getX()][ship.getPuntoInicial().getY() + i] == 'C') {
                        return false;
                    }
                }
                case WEST -> {
                    if (board.board[ship.getPuntoInicial().getX()-i][ship.getPuntoInicial().getY()] == 'B' || board.board[ship.getPuntoInicial().getX()-i][ship.getPuntoInicial().getY()] == 'F' || board.board[ship.getPuntoInicial().getX()-i][ship.getPuntoInicial().getY()] == 'C') {
                        return false;
                    }
                }
                case EAST -> {
                    if (board.board[ship.getPuntoInicial().getX()+i][ship.getPuntoInicial().getY()] == 'B' || board.board[ship.getPuntoInicial().getX()+i][ship.getPuntoInicial().getY()] == 'F' || board.board[ship.getPuntoInicial().getX()+i][ship.getPuntoInicial().getY()] == 'C') {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean getShot(Point punto, Board positionenemy, Board attackmine) {
        if (positionenemy.board[punto.getX()][punto.getY()] == 'C') {
            positionenemy.board[punto.getX()][punto.getY()] = 'X';
            attackmine.board[punto.getX()][punto.getY()] = 'X';
            System.out.println("Canoe get shot");
            return true;
        } else if (positionenemy.board[punto.getX()][punto.getY()] == 'F') {
            positionenemy.board[punto.getX()][punto.getY()] = 'X';
            attackmine.board[punto.getX()][punto.getY()] = 'X';
            System.out.println("Frigate get shot");
            return true;
        } else if (positionenemy.board[punto.getX()][punto.getY()] == 'B') {
            positionenemy.board[punto.getX()][punto.getY()] = 'X';
            attackmine.board[punto.getX()][punto.getY()] = 'X';
            System.out.println("Battleship get shot");
            return true;
        } else {
            positionenemy.board[punto.getX()][punto.getY()] = 'O';
            attackmine.board[punto.getX()][punto.getY()] = 'O';
            System.out.println("Water!!");
            return false;
        }
    }
}
