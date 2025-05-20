package ecuacuacionLineal;

import java.text.DecimalFormat;
import utilidades.Consola;

public class Termino<T extends Number> {

    private T coeficiente;
    private char variable;

    public Termino() {
        this.coeficiente = null;
        this.variable = ' ';
    }

    public void generarTerminoInt (char x){
        leerTerminoInt();
        setVariable(x);
    }
    
    public void generarTerminoDouble ( char x){
        leerTerminoDouble();
        setVariable(x);
    }
    
    private void leerTerminoInt() {
        Integer x;
        do {
            Consola.emitirMensaje("Ingresar coeficiene entero:");
             x = Consola.leerInt();
            if (x == 0) {
                Consola.emitirMensajeLN("Error, el coeficiente no debe ser igual a 0");
            }
        } while (x == 0);
        setCooeficiente((T)x);
    }

    private void leerTerminoDouble() {
        Double x;
        do {
            Consola.emitirMensaje("Ingresar coeficiene real:");
             x = Consola.leerDouble();
            if (x == 0) {
                Consola.emitirMensajeLN("Error, el coeficiente no debe ser igual a 0");
            }
        } while (x == 0);
        setCooeficiente((T)x);
    }
    
    public T getCooeficiente() {
        return coeficiente;
    }

    private void setCooeficiente(T cooeficiente) {
        this.coeficiente = cooeficiente;
    }

    public char getVariable() {
        return variable;
    }

    private void setVariable(char variable) {
        this.variable = variable;
    }

    @Override
    public String toString() {
        DecimalFormat formato = new DecimalFormat("0.##");
        return "" + formato.format(this.coeficiente) + this.variable + "";
    }

}
