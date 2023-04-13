package org.example;

import java.util.Scanner;

public class Application {
    private static final Scanner scanner = new Scanner(System.in);

    public void configurarUser(User user) {
        boolean validB = true;
        boolean validF = true;
        boolean validC = true;
        System.out.println("Bienvenido al juego de batalla naval");
        user.positionBoard.fillBoard();
        user.attackBoard.fillBoard();
        do {
            user.positionBoard.showBoard();
            System.out.println("Qué barco desea colocar?");
            System.out.println("1. Canoe");
            System.out.println("2. Frigate");
            System.out.println("3. Battleship");
            int barco = scanner.nextInt();
            System.out.println("En qué posición desea colocar el barco?");
            int x = 0;
            int y = 0;
            try {
                System.out.println("Ingrese la coordenada X");
                x = scanner.nextInt();
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("El valor de X debe estar entre 0 y 9");
            }
            try {
                System.out.println("Ingrese la coordenada Y");
                y = scanner.nextInt();
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("El valor de Y debe estar entre 0 y 9");
            }
            System.out.println("En qué dirección desea colocar el barco?");
            System.out.println("1. NORTH");
            System.out.println("2. SOUTH");
            System.out.println("3. EAST");
            System.out.println("4. WEST");
            int direccion = scanner.nextInt();
            CardinalPoints direccionCardinal;
            switch (direccion) {
                case 1 -> direccionCardinal = CardinalPoints.NORTH;
                case 2 -> direccionCardinal = CardinalPoints.SOUTH;
                case 3 -> direccionCardinal = CardinalPoints.EAST;
                case 4 -> direccionCardinal = CardinalPoints.WEST;
                default -> throw new IllegalStateException("Unexpected value: " + direccion);
            }
            switch (barco) {
                case 1 -> {
                    if (validC) {
                        if (user.positionBoard.board[x][y] != '~') {
                            System.out.println("Ya hay un barco en esa posición");
                        } else {
                            Ship canoe = new Canoe(new Point(x, y), direccionCardinal , user.positionBoard);
                            user.ships.add(canoe);
                            validC = false;
                        }
                    } else {
                        System.out.println("Ya colocó todos los canoas");
                    }
                }
                case 2 -> {
                    if (validF) {
                        if (user.positionBoard.board[x][y] != '~') {
                            System.out.println("Ya hay un barco en esa posición");
                        } else {
                            Ship frigate = new Frigate(new Point(x, y), direccionCardinal, user.positionBoard);
                            user.ships.add(frigate);
                            validF = false;
                        }
                    } else {
                        System.out.println("Ya colocó todas las fragatas");
                    }
                }
                case 3 -> {
                    if (validB) {
                        if (user.positionBoard.board[x][y] != '~') {
                            System.out.println("Ya hay un barco en esa posición");
                        } else {
                            Ship battleship = new Battleship(new Point(x, y), direccionCardinal, user.positionBoard);
                            user.ships.add(battleship);
                            validB = false;
                        }
                    } else {
                        System.out.println("Ya colocó todos los buques");
                    }
                }
            }
        } while (user.ships.size() < 3);
    }



    public void turnos(User user1, User user2, int turno) {
        if (turno%2==0) {
            System.out.println("Ingrese la coordenada X");
            int x = scanner.nextInt();
            System.out.println("Ingrese la coordenada Y");
            int y = scanner.nextInt();
            Point point = new Point(x, y);
            user1.attack(user2, point);
        } else {
            System.out.println("Ingrese la coordenada X");
            int x = scanner.nextInt();
            System.out.println("Ingrese la coordenada Y");
            int y = scanner.nextInt();
            Point point = new Point(x, y);
            user2.attack(user1, point);
        }
    }



    public void jugadas(User user1, User user2) {
        System.out.println("Turno de User1");
        configurarUser(user1);
        System.out.println("Turno de User2");
        configurarUser(user2);
        int turno = 1;
        do {
            System.out.println("Turno " + (turno%2==0?"User1":"User2"));
            if (turno%2==0){
                turnos(user1, user2, turno);
            } else {
                turnos(user2, user1, turno);
            }
            turno++;

        }while (user1.alive && user2.alive);
        System.out.println("El ganador es " + (user1.alive?"User1":"User2"));
    }

    /*
        while (user1.ships.size() > 0 && user2.ships.size() > 0){

            System.out.println("Ingrese la coordenada X");
            int x = scanner.nextInt();
            System.out.println("Ingrese la coordenada Y");
            int y = scanner.nextInt();
            Point point = new Point(x, y);
            if (user2.positionBoard.board[x][y] == 'B'){
                user2.positionBoard.board[x][y] = 'X';
                user2.ships.get(0).hitPoints--;
                if (user2.ships.get(0).hitPoints == 0){
                    user2.ships.remove(0);
                }
            }
            else if (user2.positionBoard.board[x][y] == 'F'){
                user2.positionBoard.board[x][y] = 'X';
                user2.ships.get(1).hitPoints--;
                if (user2.ships.get(1).hitPoints == 0){
                    user2.ships.remove(1);
                }
            }
            else if (user2.positionBoard.board[x][y] == 'C'){
                user2.positionBoard.board[x][y] = 'X';
                user2.ships.get(2).hitPoints--;
                if (user2.ships.get(2).hitPoints == 0){
                    user2.ships.remove(2);
                }
            }
            else {
                user2.positionBoard.board[x][y] = 'O';
            }
            System.out.println("Turno de " + user2.name);
            System.out.println("Ingrese la coordenada X");
            x = scanner.nextInt();
            System.out.println("Ingrese la coordenada Y");
            y = scanner.nextInt();
            point = new Point(x, y);
            if (user1.positionBoard.board[x][y] == 'B'){
                user1.positionBoard.board[x][y] = 'X';
                user1.ships.get(0).hitPoints--;
                if (user1.ships.get(0).hitPoints == 0){
                    user1.ships.remove(0);
                }
            }
            else if (user1.positionBoard.board[x][y] == 'F'){
                user1.positionBoard.board[x][y] = 'X';
                user1.ships.get(1).hitPoints--;
                if (user1.ships.get(1).hitPoints == 0){
                    user1.ships.remove(1);
                }

            }


     */
}