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
        return alive;
    }

    public void setDie() {
        this.alive = false;
    }

    public boolean attack(User user, Point point) {
        user.ships.forEach(ship -> {
            if (ship.getShot(point, user.positionBoard)) {
                attackBoard.board[point.getX()][point.getY()] = 'X';
                if (ship.isSunk(ship, user.positionBoard)) {
                    for (int i = 0; i < ship.getTamano(); i++) {
                        switch (ship.getOrientation()) {
                            case NORTH -> {
                                attackBoard.board[ship.getPuntoInicial().getX()][ship.getPuntoInicial().getY() - i] = 'X';
                            }
                            case SOUTH -> {
                                attackBoard.board[ship.getPuntoInicial().getX()][ship.getPuntoInicial().getY() + i] = 'X';
                            }
                            case EAST -> {
                                attackBoard.board[ship.getPuntoInicial().getX() - i][ship.getPuntoInicial().getY()] = 'X';
                            }
                            case WEST -> {
                                attackBoard.board[ship.getPuntoInicial().getX() + i][ship.getPuntoInicial().getY()] = 'X';
                            }
                        }
                    }
                    System.out.println("You sunk a ship!");
                }
                if (!user.isAlive()) {
                    user.setDie();
                    System.out.println("You sank the last ship. You won. Congratulations!");
                }
            } else {
                attackBoard.board[point.getX()][point.getY()] = 'M';
            }
        });
        return true;
    }


}
