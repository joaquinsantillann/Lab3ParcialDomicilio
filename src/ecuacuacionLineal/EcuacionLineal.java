package ecuacuacionLineal;

/**
 *
 * @author willi
 */

public abstract class EcuacionLineal <T extends Number> implements Resoluble {
    protected Termino <T> terminoX;
    protected T constante; 
    protected T TerminoIndependiente;
    
    public abstract EcuacionLineal<T> generarEcuacion();
    
    public abstract T resolver();
    
    public abstract  void verificarSolucion();
    
    public abstract void campararEcuaciones();

    public Termino<T> getTerminoX() {
        return terminoX;
    }

    protected void setTerminoX(Termino<T> terminoX) {
        this.terminoX = terminoX;
    }

    public T getConstante() {
        return constante;
    }

    protected void setConstante(T constante) {
        this.constante = constante;
    }

    protected void setTerminoIndependiente(T TerminoIndependiente) {
        this.TerminoIndependiente = TerminoIndependiente;
    }
    
    
}
