package ecuacuacionLineal;

import java.text.DecimalFormat;
import java.util.Objects;
import utilidades.Consola;

public class EcucacionUnaVariable<T extends Number> extends EcuacionLineal<T> {

    public EcucacionUnaVariable() {
        super();
    }

    public void cargarEcuaconInt() {
        Consola.emitirMensajeLN("Cargar coeficiente X");

        super.terminoX.generarTerminoInt('x');
        super.leerConstanteInt();
        super.leerTerminoIndependienteInt();
    }

    public void cargarEcuacionDouble() {
        Consola.emitirMensajeLN("Cargar coeficiente X");

        super.terminoX.generarTerminoDouble('x');
        super.leerConstanteDouble();
        super.leerTerminoIndependienteDouble();
    }

    //Genera una ecuacion de una variable ya sea entera o real
    @Override
    public void generarEcuacion() {
        int o;
        do {
            Consola.emitirMensaje("Que tipo de ecuacion desesa generar 1:REAL 2:ENTER0 :");
            o = Consola.leerInt();
            switch (o) {
                case 1:
                    cargarEcuacionDouble();
                    break;
                case 2:
                    cargarEcuaconInt();
                    break;
                default:
                    Consola.emitirMensajeLN("Opcion invalida!");
            }
        } while (!esOpcionValida(o));
        Consola.emitirMensajeLN("Ecuacion generada correctamente");
    }

    private boolean esOpcionValida(int op) {
        return op > 0 && op < 3;
    }

    @Override
    public String toString() {
        DecimalFormat formato = new DecimalFormat("0.##");
        return terminoX.toString() + "+" + formato.format(this.constante) + "=" + formato.format(this.terminoIndependiente);
    }

    //Desarollo de metodo abstracto reslver. calcula la solucion y muestra el resultado en formato
    @Override
    public void resolver(int par) {
        DecimalFormat formato = new DecimalFormat("0.##");
        Double x = calcularSolucin();
        Consola.emitirMensajeLN("Solucin para :" + toString() + " Es X =" + formato.format(x));
    }

    //calcula la sulucion de una ecuacion lineal de una variable. con la formuma (c - b) / a. te retorna el valor de x
    public Double calcularSolucin() {
        double a = terminoX.getCoeficiente().doubleValue();
        double b = constante.doubleValue();
        double c = terminoIndependiente.doubleValue();

        return (c - b) / a;
    }

    @Override
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
        return this.terminoIndependiente.doubleValue() == (this.terminoX.getCoeficiente().doubleValue() * x + this.constante.doubleValue());
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

    public boolean sonEquivalentes(EcucacionUnaVariable otro) {
        return Objects.equals(otro.calcularSolucin(), this.calcularSolucin());
    }

    public T getTerminoIndependiente() {
        return terminoIndependiente;
    }

}
