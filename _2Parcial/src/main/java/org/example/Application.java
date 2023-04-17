package org.example;

import java.util.Scanner;

public class Application {
    static final Scanner scanner = new Scanner(System.in);



    public void configurarUser(User user) {
        System.out.println("Vamos a configurar su tablero de juego");
        System.out.println("RECUERDE: debe ingresar opciones válidas, de lo contrario deberá repetir el proceso de configuración");
        boolean validB = true;
        boolean validF = true;
        boolean validC = true;
        user.positionBoard.fillBoard();
        user.attackBoard.fillBoard();
        user.positionBoard.showBoard();
        do {
            System.out.println("Qué barco desea colocar?");
            System.out.println("1. Canoe");
            System.out.println("2. Frigate");
            System.out.println("3. Battleship");
            int barco = scanner.nextInt();
            System.out.println("En qué posición desea colocar el barco?");
            int x = coordenada(1);
            int y = coordenada(2);
            boolean valid;
            CardinalPoints direccionCardinal = CardinalPoints.NONE;
            do {
                System.out.println("En qué dirección desea colocar el barco?");
                System.out.println("1. NORTH");
                System.out.println("2. SOUTH");
                System.out.println("3. EAST");
                System.out.println("4. WEST");
                int direccion = scanner.nextInt();
                switch (direccion) {
                    case 1:
                        if ((barco==3 && y<4)||(barco==2 && y<2)){
                            System.out.println("No se puede colocar el barco en esa posición");
                            valid = false;
                        } else {
                            direccionCardinal = CardinalPoints.NORTH;
                            valid = true;
                        }
                        break;
                    case 2 :
                        if ((barco==3 && y>5)||(barco==2 && y>7)){
                            System.out.println("No se puede colocar el barco en esa posición");
                            valid = false;
                        } else {
                            direccionCardinal = CardinalPoints.SOUTH;
                            valid = true;
                        }
                        break;
                    case 3 :
                        if ((barco==3 && x>5)||(barco==2 && x>7)){
                            System.out.println("No se puede colocar el barco en esa posición");
                            valid = false;
                        } else {
                            direccionCardinal = CardinalPoints.EAST;
                            valid = true;
                        }
                        break;
                    case 4 :
                        if ((barco==3 && x<4)||(barco==2 && x<2)){
                            System.out.println("No se puede colocar el barco en esa posición");
                            valid = false;
                        } else {
                            direccionCardinal = CardinalPoints.WEST;
                            valid = true;
                        }
                        break;
                    default :
                        System.out.println("Opción inválida a la hora de elegir la orientación del barco");
                        valid = false;
                        break;
                }
            }while (!valid);
            int tamano;
            switch (barco) {
                case 1 :
                    if (validC) {
                        if (user.positionBoard.board[x][y] != '~') {
                            System.out.println("Ya hay un barco en esa posición");
                        } else {
                            tamano = 1;
                            if (user.canBePlace(new Point(x, y), direccionCardinal, tamano)){
                                Ship canoe = new Canoe(new Point(x, y), direccionCardinal , user.positionBoard);
                                user.ships.add(canoe);
                                System.out.println("Se colocó el canoa correctamente");
                                validC = false;
                            } else {
                                System.out.println("No se puede colocar el barco en esa posición, ya hay otro barco en esa posición");
                            }
                        }
                    } else {
                        System.out.println("Ya colocó todos los canoas");
                    }
                    break;
                case 2 :
                    if (validF) {
                        if (user.positionBoard.board[x][y] != '~') {
                            System.out.println("Ya hay un barco en esa posición");
                        } else {
                            tamano = 3;
                            if (user.canBePlace(new Point(x, y), direccionCardinal, tamano)){
                                Ship frigate = new Frigate(new Point(x, y), direccionCardinal, user.positionBoard);
                                user.ships.add(frigate);
                                System.out.println("Se colocó la fragata correctamente");
                                validF = false;
                            } else {
                                System.out.println("No se puede colocar el barco en esa posición, ya hay otro barco en esa posición");
                            }
                        }
                    } else {
                        System.out.println("Ya colocó todas las fragatas");
                    }
                    break;
                case 3 :
                    if (validB) {
                        if (user.positionBoard.board[x][y] != '~') {
                            System.out.println("Ya hay un barco en esa posición");
                        } else {
                            tamano=5;
                            if (user.canBePlace(new Point(x, y), direccionCardinal, tamano)){
                                Ship battleship = new Battleship(new Point(x, y), direccionCardinal, user.positionBoard);
                                user.ships.add(battleship);
                                System.out.println("Se colocó el Battleship correctamente");
                                validB = false;
                            } else {
                                System.out.println("No se puede colocar el barco en esa posición, ya hay otro barco en esa posición");
                            }
                        }
                    } else {
                        System.out.println("Ya colocó todos los Battleships");
                    }
                    break;
                default :
                    System.out.println("Opción inválida a la hora de escoger el tipo de barco");
                    break;
            }
            user.positionBoard.showBoard();
        } while (user.ships.size() < 3);
    }

    public int coordenada(int a){
        System.out.println("Ingrese la coordenada "+(a==1?"X":"Y"));
        int coordenada = scanner.nextInt();
        if (coordenada >= 0 && coordenada <= 9){
            return coordenada;
        } else {
            System.out.println("El valor de "+(a==1?"X":"Y")+" debe estar entre 0 y 9");
            return coordenada(a);
        }
    }



    public void turnos(User user1, User user2, int turno) {
        if (turno%2==0) {
            System.out.println("Turno de User1");
            System.out.println("Tablero de posiciones de User1");
            user1.positionBoard.showBoard();
            System.out.println("Tablero de ataques de User1");
            user1.attackBoard.showBoard();
            int x = coordenada(1);
            int y = coordenada(2);
            Point point = new Point(x, y);
            if (user1.attack(user2, point)){
                turnos(user1, user2, turno);
            }
        } else {
            System.out.println("Turno de User2");
            System.out.println("Tablero de posiciones de User2");
            user2.positionBoard.showBoard();
            System.out.println("Tablero de ataques de User2");
            user2.attackBoard.showBoard();
            int x = coordenada(1);
            int y = coordenada(2);
            Point point = new Point(x, y);
            if (user2.attack(user1, point)){
                turnos(user1, user2, turno);
            }
        }
    }



    public void jugadas(User user1, User user2) {
        System.out.println("Bienvenido al juego de batalla naval");
        System.out.println("Las reglas son simples, cada jugador tiene 3 barcos, un canoa, una fragata y un battleship");
        System.out.println("Cada barco tiene un tamaño diferente, el canoa tiene un tamaño de 1, la fragata de 3 y el battleship de 5");
        System.out.println("Cada jugador tiene un tablero de 10x10, en el tablero de posiciones se colocan los barcos");
        System.out.println("En el tablero de ataques se colocan las coordenadas donde se atacará");
        System.out.println("El juego termina cuando un jugador destruye todos los barcos del otro jugador");
        System.out.println("Comenzamos");
        System.out.println("Turno de User1");
        configurarUser(user1);
        System.out.println("Turno de User2");
        configurarUser(user2);
        int turno = 1;
        do {
            System.out.println("Turno " + (turno%2==0?"User2":"User1"));
            if (turno%2==0){
                turnos(user1, user2, turno);
            } else {
                turnos(user2, user1, turno);
            }
            turno++;
        }while (user1.alive && user2.alive);
        System.out.println("El ganador es " + (user1.alive?"User1":"User2"));
    }


}