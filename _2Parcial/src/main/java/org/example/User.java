package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {
    public boolean alive;
    public List<Ship> ships;

    public Board positionBoard;
    public Board attackBoard;


    public User() {
        this.alive = true;
        this.ships = new ArrayList<>();
        this.positionBoard = new Board();
        this.attackBoard = new Board();
    }

    public boolean isAlive() {
        int contador = 0;
        for (Ship ship : ships) {
            for (int i = 0; i < ship.getTamano(); i++) {
                switch (ship.getOrientation()){
                    case NORTH -> {
                        if (positionBoard.board[ship.getPuntoInicial().getX()][ship.getPuntoInicial().getY() - i] == 'X') {
                            contador++;
                        }
                    }
                    case SOUTH -> {
                        if (positionBoard.board[ship.getPuntoInicial().getX()][ship.getPuntoInicial().getY() + i] == 'X') {
                            contador++;
                        }
                    }
                    case WEST -> {
                        if (positionBoard.board[ship.getPuntoInicial().getX()-i][ship.getPuntoInicial().getY()] == 'X') {
                            contador++;
                        }
                    }
                    case EAST -> {
                        if (positionBoard.board[ship.getPuntoInicial().getX()+i][ship.getPuntoInicial().getY()] == 'X') {
                            contador++;
                        }
                    }
                }
            }
        }
        if (contador == 9){
            return false;
        } else {
            return true;
        }
    }

    public void setDie() {
        this.alive = false;
    }

    public boolean attack(User user, Point point) {
        for (Ship ship : user.ships){
            if (ship.getShot(point, user.positionBoard, attackBoard)) {
                if (ship.isSunk(ship, user.positionBoard)) {
                    System.out.println("You sunk a ship!");
                }else if (!user.isAlive()) {
                    user.setDie();
                    System.out.println("You sank the last ship. You won. Congratulations!");
                }
            } else {
                System.out.println("You missed!");
            }
        }
        return false;
    }

    public boolean canBePlace(Point puntoInicial, CardinalPoints orientation, int tamano){
        for (int i = 0; i < tamano; i++) {
            switch (orientation){
                case NORTH -> {
                    if (positionBoard.board[puntoInicial.getX()][puntoInicial.getY() - i] != '~') {
                        return false;
                    }
                }
                case SOUTH -> {
                    if (positionBoard.board[puntoInicial.getX()][puntoInicial.getY() + i] != '~') {
                        return false;
                    }
                }
                case WEST -> {
                    if (positionBoard.board[puntoInicial.getX()-i][puntoInicial.getY()] != '~') {
                        return false;
                    }
                }
                case EAST -> {
                    if (positionBoard.board[puntoInicial.getX()+i][puntoInicial.getY()] != '~') {
                       return false;
                    }
                }
            }
        }
        return true;
    }

}
