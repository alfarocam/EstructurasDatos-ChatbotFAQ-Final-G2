/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

import java.util.Random;
import java.util.Scanner;

public class Juego {

    private ColaDeJugadores ColaDeJugadores;
    private Chatbot Chatbot;
    private BITACORA_HISTORICA BITACORA_HISTORICA;
    private Premios Premios;
    private Castigos Castigos;
    private Random random;
    private int Jugador;
    private int cantidadDeJugadores;
    private String SiSePuede;
    private int TamañoLaberinto;

    public Juego() {
        ColaDeJugadores = new ColaDeJugadores();
        Chatbot = new Chatbot();
        BITACORA_HISTORICA = new BITACORA_HISTORICA();
        Premios = new Premios();
        Castigos = new Castigos();
        random = new Random();
        this.Jugador = 0;
        this.cantidadDeJugadores = 4;
        this.SiSePuede = "S";
        this.TamañoLaberinto = 30;
    }

    public int getJugador() {
        return Jugador;
    }

    public void setJugador(int Jugador) {
        this.Jugador = Jugador;
    }

    public int getCantidadDeJugadores() {
        return cantidadDeJugadores;
    }

    public void setCantidadDeJugadores(int cantidadDeJugadores) {
        this.cantidadDeJugadores = cantidadDeJugadores;
    }

    public int getTamañoLaberinto() {
        return TamañoLaberinto;
    }

    public void setTamañoLaberinto(int TamañoLaberinto) {
        this.TamañoLaberinto = TamañoLaberinto;
    }

    /**
     * Con este Metodo hacemos el que el juego hinicie el menu
     *
     * @author Ian Villalobos Alvarez
     * @return No retorna nada
     */
    public void iniciarJuego() {
        Premios.agregaPremio();
        Castigos.agregarCastigo();
        Chatbot.ChatBotPreguntas();

        Scanner scanner = new Scanner(System.in);
        System.out.println("*****************************************************");
        System.out.println("*                                                   *");
        System.out.println("*              Bienvenidos al Juego de              *");
        System.out.println("*                                                   *");
        System.out.println("*                Dados del GRUPO #2!                *");
        System.out.println("*                                                   *");
        System.out.println("*                   Buena Suerte                    *");
        System.out.println("*                                                   *");
        System.out.println("*****************************************************");
        boolean jugando = true;

        while (jugando) {
            System.out.println("\nSeleccione una opcion:");
            System.out.println("1. Agregar jugador");
            System.out.println("2. Opsiones del juego");
            System.out.println("3. Eliminar jugador");
            System.out.println("4. Mostrar jugadores");
            System.out.println("5. Jugar");
            System.out.println("6. Salirse del juego");
            System.out.println("7. Mostrar posiciones");
            System.out.println("8. Cambiar turno");
            System.out.println("9. Mostrar Pila de Premios");
            System.out.println("10. Mostrar Pila de Castigos");
            System.out.println("11. Agregar premios, castigos");
            System.out.println("12. Ayuda");
            System.out.println("13. Chatbot");
            System.out.println("14. Salir");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    boolean agregarmas = true;
                    while (agregarmas) {
                        System.out.print("Ingrese el nombre del jugador: ");
                        String nombre = scanner.next();
                        if (ColaDeJugadores.cuentaParticipantes() < cantidadDeJugadores) {
                            NodoCola actual = ColaDeJugadores.getFrente();
                            boolean existe = false;

                            while (actual != null) {
                                if (actual.getDato().getNombreJugador().equals(nombre)) {
                                    System.out.println("El jugador ya existe");
                                    existe = true;
                                    break;
                                }
                                actual = actual.getSiguiente();
                            }

                            if (existe) {
                                System.out.println("Este jugador ya existe.");
                            } else {
                                ListaEnlazada miListaEnlazada = new ListaEnlazada();

                                ColaDeJugadores.encolar(nombre, Jugador);
                                miListaEnlazada.insertaOrdenado(Jugador);
                                BITACORA_HISTORICA.insertar(nombre, miListaEnlazada);
                                BITACORA_HISTORICA.getUltimo().getAnterior().getDato().getPosicion().recorrer();
                            }
                        } else {
                            System.out.println("Ya se encuentran 4 jugadores, no se pueden agregar más!!");
                        }
                        System.out.print("Desea agregar otro usuario? (S/N): ");
                        String agregar = scanner.next();
                        if (agregar.equals("S")) {

                        } else {
                            agregarmas = false;
                        }
                    }

                    break;
                case 2:
                    System.out.print("Ingrese el tamaño del laberinto: ");
                    TamañoLaberinto = scanner.nextInt();
                    System.out.print("Ingrese la cantidad de jugadores que pueden jugar: ");
                    cantidadDeJugadores = scanner.nextInt();
                    System.out.print("Se podra agregar mas jugadores despues de iniciar el juego? (S/N): ");
                    SiSePuede = scanner.next();

                    break;
                case 3:
                    System.out.print("Ingrese el nombre del jugador: ");
                    String eliminado = scanner.next();
                    boolean existente = false;

                    NodoCola actuall = ColaDeJugadores.getFrente();
                    while (actuall != null) {
                        if (actuall.getDato().getNombreJugador().equals(eliminado)) {
                            existente = true;
                            break;
                        }
                        actuall = actuall.getSiguiente();
                    }

                    if (existente) {
                        BITACORA_HISTORICA.desencolar(eliminado);
                        ColaDeJugadores.desencolar(eliminado);
                        System.out.println("Se ha eliminado a " + eliminado);
                        BITACORA_HISTORICA.imprimir();
                    } else {
                        System.out.println("el Jugador no xsite");

                    }
                    break;
                case 4:
                    ColaDeJugadores.ImprimirParticipantes("n", TamañoLaberinto);
                    break;
                case 5:
                    jugar();
                    break;
                case 6:
                    System.out.print("Ingrese el ID del jugador que desea salir: ");
                    String agregar13 = scanner.next();
                            if (agregar13 != null) {
                                BITACORA_HISTORICA.desencolar(ColaDeJugadores.getFrente().getDato().getNombreJugador());
                                ColaDeJugadores.desencolar(ColaDeJugadores.getFrente().getDato().getNombreJugador());
                                System.out.println("Se ha eliminado a " + agregar13);
                                BITACORA_HISTORICA.imprimir();
                            } else {
                                System.out.println("Jugador no encontrado en la cola.");
                            }
                    break;
                case 7:
                    ColaDeJugadores.mostrarPosiciones();
                    break;
                case 8:
                    /**
                     * colaDeJugadores.cambiarTurno(); *
                     */
                    break;
                case 9:
                    Premios.imprimirPila();
                    break;
                case 10:
                    Castigos.imprimirPila();
                    break;

                case 11:
                    System.out.print("que desea agregar?:");
                    String editar = scanner.next();
                    if (editar.equals("Premio")) {

                        System.out.print("Posicion de premio:");
                        String Premio = scanner.next();
                        System.out.print("descripcion del premio:");
                        String descripcion = scanner.next();
                        System.out.print("cantidad de posiciones que tendra el premio: ");
                        int cantidad = scanner.nextInt();
                        Premios.apilar(Premio, descripcion, cantidad);
                    }
                    if (editar.equals("Castigo")) {
                        System.out.print("Posicion de castigo:");
                        String Castigo = scanner.next();
                        System.out.print("descripcion del castigo:");
                        String descripcion = scanner.next();
                        System.out.print("cantidad de posiciones que tendra el castigo: ");
                        int cantidad = scanner.nextInt();
                        Castigos.apilar(Castigo, descripcion, cantidad);

                    } else {
                        break;
                    }
                    break;
                case 12:
                    mostrarAyuda();
                    break;
                case 13:
                    boolean pregunta = true;
                    while (pregunta) {
                        System.out.println("Hola, soy su ChatBot de confianza, ¿En qué le puedo ayudar hoy?");
                        System.out.println("1. Ver Chatbot");
                        System.out.println("2. Mantenimiento del chatbot");
                        System.out.println("3. Salir del chatbot");

                        int opcionchat = scanner.nextInt();
                        scanner.nextLine(); // limpiar buffer

                        if (opcionchat == 1) {
                            Chatbot.postOrdenRecpregunta1();
                            Chatbot.postOrdenPrueba();
                        } else if (opcionchat == 2) {
                            boolean mant = true;
                            while (mant) {
                                System.out.println("\n--- Mantenimiento Chatbot ---");
                                System.out.println("1. Insertar/Modificar pregunta padre");
                                System.out.println("2. Insertar/Modificar pregunta hija");
                                System.out.println("3. Ver todas las preguntas del arbol");
                                System.out.println("4. Volver al chatbot");
                                int sub = scanner.nextInt();
                                scanner.nextLine();

                                switch (sub) {
                                    case 1:
                                        System.out.print("Código del padre: ");
                                        int codPadre = scanner.nextInt();
                                        scanner.nextLine();
                                        System.out.print("Texto de la pregunta padre: ");
                                        String textoPadre = scanner.nextLine();
                                        System.out.print("Descripción: ");
                                        String desc = scanner.nextLine();
                                        Chatbot.insertarOModificarPadre(codPadre, textoPadre, desc);
                                        break;
                                    case 2:
                                        System.out.print("Código del nodo hoja: ");
                                        int codHija = scanner.nextInt();
                                        scanner.nextLine();
                                        System.out.print("Texto de la pregunta hija: ");
                                        String textoHija = scanner.nextLine();
                                        System.out.print("Respuesta: ");
                                        String resp = scanner.nextLine();
                                        Chatbot.insertarOModificarHija(codHija, textoHija, resp);
                                        break;
                                    case 3:
                                        Chatbot.postOrden();
                                    case 4:
                                        mant = false;
                                        break;
                                    default:
                                        System.out.println("Opción no válida.");
                                }
                            }

                        } else if (opcionchat == 3) {
                            System.out.println("Fue muy divertido estar aqui para servirte nos vemos, chatbot fuera");
                            pregunta = false;
                        } else {
                            System.out.println("Debe elegir una opción válida del menú.");
                        }
                    }
                    break;
                case 14:
                    jugando = false;
                    System.out.println("Gracias por jugar!");

                default:
                    System.out.println("Opcion no valida");
            }
        }

        scanner.close();
    }

    /**
     * Con este Metodo mostramos la opcion ayuda
     *
     * @author Ian Villalobos Alvarez
     * @return No retorna nada
     */
    private void mostrarAyuda() {
        System.out.println("*****************************************************");
        System.out.println("*                   Ayuda del Juego                 *");
        System.out.println("*                                                   *");
        System.out.println("*                  Version: V 1.0.3                 *");
        System.out.println("*                                                   *");
        System.out.println("*             Desarrolladores:                      *");
        System.out.println("*               - Camila Alfaro Rivera              *");
        System.out.println("*               - Kevin Guifarro Orellana           *");
        System.out.println("*               - Ian Villalobos Alvarez            *");
        System.out.println("*               - Jose Pablo Murillo Villamil       *");
        System.out.println("*****************************************************");
    }

    /**
     *
     * Este metodo es el que se encarga de todas las "reglas", es decir tirar
     * los dados, realizar la suma y en base a eso aplicar ya sea las
     * intrucciones de premios o castigos; también lleva el control de turnos y
     * posiciones por jugador
     *
     * si la suma es par el jugador recibe un premio de la pila de premios si la
     * suma es impar el jugador recibe un castigo de la pila de castigos
     *
     *
     *
     */
    /**
     * Con este Metodo iniciamos el juego
     *
     * @author Ian Villalobos Alvarez
     * @return No retorna nada
     */
    private void jugar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("!!!!!Inicia el Juego!!!!!!!");
        System.out.println("                            ");
        System.out.println("El primer jugador en llegar a " + TamañoLaberinto + " es el gadador");
        System.out.println("                            ");
        System.out.println("Participantes");
        ColaDeJugadores.ImprimirParticipantes("n", TamañoLaberinto);
        boolean juegoActivo = true;

        while (ColaDeJugadores.getFrente().getDato().getPosicionActual() < TamañoLaberinto && juegoActivo) {  // Cambié la condición para continuar hasta alcanzar o superar la posición 30
            String Menu = "pe";
            DatosJugadores JugadorActual = ColaDeJugadores.getFrente().getDato();
            String Turno = BITACORA_HISTORICA.getCabeza().getDato().getNombreJugador();
            int Posicion = JugadorActual.getPosicionActual();

            System.out.println("Es el turno de: " + Turno + " Se encuentra en posición " + Posicion);

            System.out.print("Listo para tirar los dados?(Y/N): ");
            String respuesta = scanner.nextLine();
            if (respuesta.equals("Y")) {
                System.out.println("¡Tira los dados!");
                int dado1 = random.nextInt(6) + 1;
                int dado2 = random.nextInt(6) + 1;
                int sumaDados = dado1 + dado2;

                System.out.println("Tu dado 1 quedó en: " + dado1 + ", tu dado 2 quedó en " + dado2 + ". En total tienes: " + sumaDados);

                if (sumaDados % 2 == 0) {
                    System.out.println("!!!!FELICIDADES!!!!!");
                    System.out.println("Obtuviste un número par, debes tomar un premio de la pila. Mucha Suerte");
                    DatosPremios premio = Premios.despilar();
                    System.out.println(premio.getPremio());
                    JugadorActual.setPosicionActual(JugadorActual.getPosicionActual() + premio.getPosicionesMas());
                    System.out.println(JugadorActual.getPosicionActual());
                    System.out.println("Jugador " + Turno + " estas en la posición " + Posicion + ", puedes avanzar " + premio.getPosicionesMas() + " posiciones en la carrera. Ahora su nueva posición es " + JugadorActual.getPosicionActual());
                    System.out.println("Tu posición actual es: " + JugadorActual.getPosicionActual());
                    /**
                     * *
                     */
                    BITACORA_HISTORICA.getCabeza().getDato().getPosicion().insertaOrdenado(JugadorActual.getPosicionActual());
                    System.out.println(BITACORA_HISTORICA.getCabeza().getDato().getNombreJugador());
                    BITACORA_HISTORICA.getCabeza().getDato().getPosicion().recorrer();

                } else {
                    System.out.println("!!!!Mala Suerte!!!!!");
                    System.out.println("Obtuviste un número impar, debes tomar un castigo de la pila. Mejor suerte la próxima vez");

                    if (JugadorActual.getPosicionActual() == 0) {
                        System.out.println("No tienes puntos para restar, puntos eliminados = 0");
                        System.out.println("Jugador " + Turno + " estas en la posición " + Posicion + ", puedes avanzar 0 posiciones en la carrera. Ahora su nueva posición es " + JugadorActual.getPosicionActual());
                        System.out.println("Tu posición actual es: " + JugadorActual.getPosicionActual());
                        /**
                         * *
                         */
                        BITACORA_HISTORICA.getCabeza().getDato().getPosicion().insertaOrdenado(JugadorActual.getPosicionActual());
                        System.out.println(BITACORA_HISTORICA.getCabeza().getDato().getNombreJugador());
                        BITACORA_HISTORICA.getCabeza().getDato().getPosicion().recorrer();

                    } else {
                        DatosCastigos castigo = Castigos.despilar();
                        System.out.println(castigo.getCastigo());
                        JugadorActual.setPosicionActual(JugadorActual.getPosicionActual() - castigo.getPosicionesMenos());
                        System.out.println(JugadorActual.getPosicionActual());
                        System.out.println("Jugador" + Turno + "estas en la posición" + Posicion + ", puedes avanzar" + castigo.getPosicionesMenos() + "posiciones en la carrera. Ahora su nueva posición es " + JugadorActual.getPosicionActual());
                        System.out.println("Tu posición actual es: " + JugadorActual.getPosicionActual());
                        /**
                         * *
                         */
                        BITACORA_HISTORICA.getCabeza().getDato().getPosicion().insertaOrdenado(JugadorActual.getPosicionActual());
                        System.out.println(BITACORA_HISTORICA.getCabeza().getDato().getNombreJugador());
                        BITACORA_HISTORICA.getCabeza().getDato().getPosicion().recorrer();

                    }
                }

                while (!Menu.equals("pp")) {
                    NodoCola actual = ColaDeJugadores.getFrente();
                    System.out.println("\nSeleccione una opcion:");
                    System.out.println("1. Pasar turno");
                    System.out.println("2. Historial de jugadas");
                    System.out.println("3. Agregar Jugador");
                    System.out.println("4. Estado Actual del Juego");
                    System.out.println("5. Salirse del juego Jugador:" + ColaDeJugadores.getFrente().getDato().getNombreJugador());
                    System.out.println("6. Mostrar Premios restantes");
                    System.out.println("7. Mostrar Castigos restantes");
                    System.out.println("8. Terminar Juego");
                    int opcion = scanner.nextInt();

                    switch (opcion) {
                        case 1:
                            ColaDeJugadores.moverJugadorAlFinal();

                            if (BITACORA_HISTORICA.getCabeza().getDato() != ColaDeJugadores.getFrente().getDato()) {
                                BITACORA_HISTORICA.setCabeza(BITACORA_HISTORICA.getCabeza().getSiguiente());
                            }

                            Menu = "pp";
                            break;
                        case 2:

                            boolean jugador = true;
                            NodoCola historialActual = BITACORA_HISTORICA.getCabeza();

                            while (jugador) {
                                System.out.println(historialActual.getDato().getNombreJugador());
                                historialActual.getDato().getPosicion().recorrer();
                                System.out.print("Escriba Exit si decea salir");
                                System.out.print("Recorrer jugadores");
                                System.out.print(" siguiente <> anterior: ");
                                String opciones = scanner.next();

                                if (opciones.equals("siguiente")) {
                                    historialActual = historialActual.getSiguiente();
                                } else if (opciones.equals("anterior")) {
                                    historialActual = historialActual.getAnterior();
                                } else {
                                    break;
                                }
                            }
                            break;

                        case 3:
                            boolean agregarmas = true;
                            if (SiSePuede.equals("S")) {
                                while (agregarmas) {
                                    System.out.print("Ingrese el nombre del jugador: ");
                                    String nombre = scanner.next();
                                    if (ColaDeJugadores.cuentaParticipantes() < cantidadDeJugadores) {

                                        boolean existe = false;

                                        while (actual != null) {
                                            if (actual.getDato().getNombreJugador().equals(nombre)) {
                                                existe = true;
                                                break;
                                            }
                                            actual = actual.getSiguiente();
                                        }

                                        if (existe) {
                                            System.out.println("Este jugador ya existe.");
                                        } else {
                                            ListaEnlazada miListaEnlazada = new ListaEnlazada();
                                            ColaDeJugadores.encolar(nombre, Jugador);
                                            miListaEnlazada.insertaOrdenado(Jugador);
                                            BITACORA_HISTORICA.insertar(nombre, miListaEnlazada);
                                            BITACORA_HISTORICA.getUltimo().getAnterior().getDato().getPosicion().recorrer();

                                        }
                                    } else {
                                        System.out.println("Ya se encuentran 4 jugadores, no se pueden agregar más!!");
                                    }
                                    System.out.print("Desea agregar otro usuario? (S/N): ");
                                    String agregar = scanner.next();
                                    if (agregar.equals("S")) {
                                    } else {
                                        agregarmas = false;
                                    }
                                }
                            } else {
                                System.out.println("¡ERROR! La configuración de este juego no permite ingresar más jugadores, deberá esperar a que inicie uno nuevo.");
                            }
                            break;
                        case 4:
                            ColaDeJugadores.ImprimirParticipantes("n", TamañoLaberinto);

                            break;
                        case 5:

                            String eliminado = ColaDeJugadores.getFrente().getDato().getNombreJugador();

                            if (eliminado != null) {
                                BITACORA_HISTORICA.desencolar(ColaDeJugadores.getFrente().getDato().getNombreJugador());
                                ColaDeJugadores.desencolar(ColaDeJugadores.getFrente().getDato().getNombreJugador());
                                System.out.println("Se ha eliminado a " + eliminado);
                                BITACORA_HISTORICA.imprimir();
                                Menu = "pp";
                            } else {
                                System.out.println("Jugador no encontrado en la cola.");
                                Menu = "pp";
                            }
                            break;
                        case 6:
                            Premios.imprimirPila();

                            break;
                        case 7:
                            Castigos.imprimirPila();

                            break;
                        case 8:
                            System.out.println("Juego finalizado, los jugadores quedaron:");
                            ColaDeJugadores.ImprimirParticipantes("n", TamañoLaberinto);

                            while (actual != null) {
                                actual.getDato().setPosicionActual(0);
                                actual = actual.getSiguiente();
                            }
                            juegoActivo = false;
                            Menu = "pp";  // O cualquier otro valor según tu lógica
                            break;
                    }
                }
            }
        }
        if (ColaDeJugadores.getFrente().getDato().getPosicionActual() >= TamañoLaberinto) {
            System.out.println("¡El juego ha terminado! El jugador " + ColaDeJugadores.getFrente().getDato().getNombreJugador() + " ha ganado.");
        } else {
            System.out.println("Fin del juego");
        }
    }
}
