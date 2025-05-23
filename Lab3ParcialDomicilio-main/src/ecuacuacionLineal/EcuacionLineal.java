package ecuacuacionLineal;

import utilidades.Consola;

/**
 *
 * @author willi
 * @param <T> Es un numero 
 */
public abstract class EcuacionLineal<T extends Number> implements Resoluble {

    protected Termino<T> terminoX;
    protected T constante;
    protected T terminoIndependiente;

    public EcuacionLineal() {
        this.terminoX = new Termino<>();
        constante = null;
        terminoIndependiente = null;
    }

    protected void leerTerminoIndependienteDouble() {
        Double c;
        Consola.emitirMensaje("Ingresar el valor de el resultado:");
        c = Consola.leerDouble();
        setTerminoIndependiente((T) c);
    }

    protected void leerConstanteInt() {
        Integer c;
        Consola.emitirMensaje("Ingresar el valor de la constante :");
        c = Consola.leerInteger();
        setConstante((T) c);
    }

    protected void leerTerminoIndependienteInt() {
        Integer c;
        Consola.emitirMensaje("Ingresar el valor de el resultado:");
        c = Consola.leerInteger();
        setTerminoIndependiente((T) c);
    }

    protected void leerConstanteDouble() {
        Double c;
        Consola.emitirMensaje("Ingresar el valor de la constante :");
        c = Consola.leerDouble();
        setConstante((T) c);
    }

    public abstract void generarEcuacion();

    public abstract void resolver(int par);

    public abstract void verificarSolucion();

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
        this.terminoIndependiente = TerminoIndependiente;
    }

}
