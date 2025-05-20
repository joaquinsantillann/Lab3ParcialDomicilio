
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
    public void crearUnaEcuacionLineal(){
        
    }
    public void resolverParaUnaVariables(){
        
    }
    public void verificarSiUnValorEsSolucion(){
        
    }
    public void compararSiDosEcuacinesSonequivalentes(){
        
    }
    public void ejecutar() {
        Menu menu = new Menu(6);
        menu.addItem("Crear una ecuacion lineal");
        menu.addItem("Resolverla para una variabale dada ");
        menu.addItem("Verificar si un valor propuesto es solucion");
        menu.addItem("Comparar  si dos ecuaciones son equivalentes");
        menu.addItem("Salir");
        int op = 0;
        do {
            Consola.emitirMensajeLN("Gestion de ECUACIONES LINEALES");
            op = menu.ejecutar();
             switch (op) {
            case 1:
                
                break;
            case 2:
                
                break;
            case 3:
                
                break;
            case 4:
                
                break;
            case 5:
                
                break;
        }

        } while (op != 5);
    }
}
