package ecuacuacionLineal;

import utilidades.Consola;

/**
 *
 * @author willi
 * @param <T>
 */
public class EcuacionDosVariables<T extends Number> extends EcucacionUnaVariable {

    private Termino<T> terminoY;

    //Genero un constructor con parametros por defecto
    public EcuacionDosVariables() {
        super();
        terminoY = new Termino<>();
    }

    //Genera una una ecuacion de dos variables, de tipo real o entero segun indique el usiario
    @Override
    public void generarEcuacion() {
        int o;
        do {
            Consola.emitirMensaje("Que tipo de ecuacion desesa generar 1:REAL 2:ENTER0 :");
            o = Consola.leerInt();
            switch (o) {
                case 1:
                    super.cargarEcuacionDouble();
                    Consola.emitirMensajeLN("Cargar coeficiente Y");

                    terminoY.generarTerminoDouble('y');
                    break;
                case 2:
                    super.cargarEcuaconInt();
                    Consola.emitirMensajeLN("Cargar coeficiente Y");

                    terminoY.generarTerminoInt('y');
                    break;
                default:
                    Consola.emitirMensajeLN("Opcion invalida!");
            }
        } while (!esOpcionValida(o));
        Consola.emitirMensajeLN("Ecuacion generada correctamente");
    }

    //Verfica si la opcion ingresasda se encuentra entre el rango 0 o 3
    private boolean esOpcionValida(int op) {
        return op > 0 && op < 3;
    }

    //toString modificado
    @Override
    public String toString() {
        return terminoY.toString() + "+" + super.toString();
    }

    public Termino<T> getTerminoY() {
        return terminoY;
    }

    //Identidica si una ecuacion de dos variables es proporcional, seguiendo la formula a2 = k.a1 & b2 = k.b1 & c2 = x.c1 | 
    public boolean esProporcionalA(EcuacionDosVariables otra) {
        double coefX = super.terminoX.getCoeficiente().doubleValue();
        double coefY = terminoY.getCoeficiente().doubleValue();
        double resultado = super.terminoIndependiente.doubleValue();

        double coefX2 = otra.terminoX.getCoeficiente().doubleValue();
        double coefY2 = otra.terminoY.getCoeficiente().doubleValue();
        double resultado2 = otra.terminoIndependiente.doubleValue();

        // Si hay ceros en los mismos lugares, seguimos comparando
        if (coefX == 0 && coefX2 != 0) {
            return false;
        }
        if (coefY == 0 && coefY2 != 0) {
            return false;
        }
        if (resultado == 0 && resultado2 != 0) {
            return false;
        }

        double k = 0;

        if (coefX != 0) {
            k = coefX2 / coefX;
            if (coefY * k != coefY2) {
                return false;
            }
            if (resultado * k != resultado2) {
                return false;
            }
            return true;
        }

        if (coefY != 0) {
            k = coefY2 / coefY;
            if (coefX2 * k != coefX2) {
                return false;
            }
            if (resultado * k != resultado2) {
                return false;
            }
            return true;
        }

        if (resultado != 0) {
            k = resultado2 / resultado;
            if (coefX * k != coefX2) {
                return false;
            }
            if (coefY * k != coefY2) {
                return false;
            }
            return true;
        }

        return true; // todos son cero, se consideran proporcionales
    }

}
