
package ecuacuacionLineal;

import java.text.DecimalFormat;

public class Termino <T extends Number> {
    private T cooeficiente;
    private char variable;

    public Termino(T cooeficiente, char variable) {
        this.cooeficiente = cooeficiente;
        this.variable = variable;
    }

    public T getCooeficiente() {
        return cooeficiente;
    }

    public void setCooeficiente(T cooeficiente) {
        this.cooeficiente = cooeficiente;
    }

    public char getVariable() {
        return variable;
    }

    public void setVariable(char variable) {
        this.variable = variable;
    }

    @Override
    public String toString() {
        DecimalFormat formato = new DecimalFormat("0.##");
        return "" + formato.format(this.cooeficiente ) + this.variable + "";
    }

    
    
    
    
    
    
}
