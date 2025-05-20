package ecuacuacionLineal;

import utilidades.Consola;
/**
 *
 * @author willi
 */
public class EcuacionDosVariables extends EcucacionUnaVariable {
    private Termino <Double> terminoY;  

    public EcuacionDosVariables() {
        super();
        this.terminoY = null;
    }
    
    public EcuacionLineal<Double> generarEcuacion(){
        leerTermino();
        super.generarEcuacion();
        return this;
    }
    
    private Termino<Double> leerTermino () {
        Consola.emitirMensajeLN("Ingresar valores para Y");
        terminoY = new Termino<>(leerCoeficiente(), 'y');
        return this.terminoY;
    }

    @Override
    public String toString() {
        return terminoY.toString() + "+" + super.toString();
    }
    
    
    
    
    
}
