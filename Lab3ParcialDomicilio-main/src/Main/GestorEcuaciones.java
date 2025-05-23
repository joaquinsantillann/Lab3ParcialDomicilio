package Main;

import utilidades.*;
import ecuacuacionLineal.*;

public class GestorEcuaciones {

    private EcucacionUnaVariable ecuacionUnaVariable;
    private SistemaEcuacionesLineales sistemaDeEcuaciones;

    public GestorEcuaciones() {
        this.ecuacionUnaVariable = null;
        this.sistemaDeEcuaciones = null;
    }

    public void crearUnaEcuacionLineal() {
        int o;
        Consola.emitirMensaje("Que desea crear? 1:Ecuacion lineal de una variable. 2:Sistema de ecuaciones lineales de dos variables. :");
        o = Consola.leerInt();
        switch (o) {
            case 1:
                ecuacionUnaVariable = new EcucacionUnaVariable();
                ecuacionUnaVariable.generarEcuacion();
                break;
            case 2:
                sistemaDeEcuaciones = new SistemaEcuacionesLineales();
                sistemaDeEcuaciones.generarEcuacion();
                break;
            default:
                Consola.emitirMensajeLN("Opcion invalida!");
                break;
        }
    }

    public void resolverParaUnaVariableDada() {
        switch (leerTipo()) {
            case 0:
                Consola.emitirMensajeLN("Opcion incalida");
                break;
            case 1:
                ecuacionUnaVariable.resolver(5);
                break;
            case 2:
                sistemaDeEcuaciones.resolver(5);
                break;
        }
    }

    public void verificarSiUnValorEsSolucion() {
        switch (leerTipo()) {
            case 0:
                Consola.emitirMensajeLN("Opcion incalida");
                break;
            case 1:
                ecuacionUnaVariable.verificarSolucion();
                break;
            case 2:
                sistemaDeEcuaciones.verificarSolucion();
                break;
        }
    }

    public void compararSiDosEcuacinesSonequivalentes() {
        switch (leerTipo()) {
            case 0:
                Consola.emitirMensajeLN("Opcion incalida");
                break;
            case 1:
                ecuacionUnaVariable.campararEcuaciones();
                break;
            case 2:
                sistemaDeEcuaciones.campararEcuaciones();
                break;
        }
    }

    public void ejecutar() {
        Menu menu = new Menu(6);
        menu.addItem("Crear una ecuacion lineal o sistema");
        menu.addItem("Resolverla para una variabale dada ");
        menu.addItem("Verificar si un valor propuesto es solucion");
        menu.addItem("Comparar  si dos ecuaciones o sistemas son equivalentes");
        menu.addItem("Salir");
        int op;
        do {
            Consola.emitirMensajeLN(GestorSalidaConsola.mostrarTitulo("Gestor de ECUACINES LINEALES", 10, '-', '-'));
            op = menu.ejecutar();
            switch (op) {
                case 1:
                    crearUnaEcuacionLineal();
                    break;
                case 2:
                    resolverParaUnaVariableDada();
                    break;
                case 3:
                    verificarSiUnValorEsSolucion();
                    break;
                case 4:
                    compararSiDosEcuacinesSonequivalentes();
                    break;
                case 5:
                    Consola.emitirMensajeLN("Fin de la ejecucion");
                    break;
                default:
                    Consola.emitirMensajeLN("Error opcion invalida");
                    break;
            }
        } while (op != 5);

    }

    private int leerTipo() {
        int o;
        Consola.emitirMensaje("Que desea resolver? 1: Ecuacion lineal. 2: Sistema de ecuaciones: ");
        o = Consola.leerInt();
        switch (o) {
            case 1:
                if (ecuacionUnaVariable == null) {
                    Consola.emitirMensajeLN("Error: No se ha creado una ecuación.");
                    return 0;
                }
                return 1;
            case 2:
                if (sistemaDeEcuaciones == null) {
                    Consola.emitirMensajeLN("Error: No se ha creado un sistema.");
                    return 0;
                }
                return 2;
            default:
                Consola.emitirMensajeLN("Opcion invalida.");
                break;
        }

            return 0;
    }
}
