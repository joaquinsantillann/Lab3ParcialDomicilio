package ecuacuacionLineal;

import java.text.DecimalFormat;
import java.util.Objects;
import utilidades.Consola;

public class EcucacionUnaVariable extends EcuacionLineal<Double>  {

    public EcucacionUnaVariable() {
        this.constante = 0.0;
        this.terminoX = null;
        this.TerminoIndependiente = 0.0;
    }

    public EcuacionLineal<Double> generarEcuacion() {
        leerTermino();
        leerConstante();
        leerTerminoIndependiente();
        return this;
    }

   private Termino<Double> leerTermino() {
       Consola.emitirMensajeLN("Ingresar valores para X");
        terminoX = new Termino<>(leerCoeficiente(), 'x');
        return this.terminoX;
    }

    protected Double leerConstante() {
        Double c;
        Consola.emitirMensaje("Ingresar el valor de la constante :");
        c = Consola.leerDouble();
        setConstante(c);
        return this.constante;
    }

    protected Double leerCoeficiente() {
        Double c;
        do {
            Consola.emitirMensaje("Ingresar el cooficiente :");
            c = Consola.leerDouble();
            if (c == 0) {
                Consola.emitirMensajeLN("Error, el coeficiente debe ser distinto a 0");
            }
        } while (c == 0);
        return c;
    }

    protected Double leerTerminoIndependiente() {
        Double c;
        Consola.emitirMensaje("Ingresar el valor de el termino independiente:");
        c = Consola.leerDouble();
        setTerminoIndependiente(c);
        return c;
    }

    @Override
    public String toString() {
        DecimalFormat formato = new DecimalFormat("0.##");
        return terminoX.toString() + "+" + formato.format(this.constante) + "=" + formato.format(this.TerminoIndependiente);
    }
    

    
    public void mostrarSolucion (){
        DecimalFormat formato = new DecimalFormat("0.##");
        Double x = resolver();
        Consola.emitirMensajeLN("Solucin para :" + toString() + " Es X =" + formato.format(x));
    }
    
    
    @Override
    public Double resolver() {
        Double x = (this.TerminoIndependiente - constante) / this.terminoX.getCooeficiente();
        return x;

    }

    public void verificarSolucion() {
        Consola.emitirMensaje("Ingresar el valor para x:");
        Double x = Consola.leerDouble();
        DecimalFormat formato = new DecimalFormat("0.##");
        if (esValida(x)) {
            Consola.emitirMensajeLN("X=" + formato.format(x) + " Es una solucion valida para :" + toString());
        } else {
            Consola.emitirMensajeLN("X=" + formato.format(x) + " No es una solcuion valida para :" + toString());
        }
    }

    public Boolean esValida(Number y) {
        Double x = y.doubleValue();
        
        return this.TerminoIndependiente == (this.terminoX.getCooeficiente() * x + this.constante);
    }

    @Override
    public void campararEcuaciones() {
        EcucacionUnaVariable comparable = new EcucacionUnaVariable();
        comparable.generarEcuacion();
         if (this.sonEquivalentes(comparable)) {
            Consola.emitirMensajeLN("Las ecuaciones son equivalentes.");
        } else {
            Consola.emitirMensajeLN("Las ecuaciones NO son equivalentes.");
        }
        
    }

    public boolean sonEquivalentes (EcucacionUnaVariable otro){
        return Objects.equals(otro.resolver(), this.resolver());
    }
    
}
