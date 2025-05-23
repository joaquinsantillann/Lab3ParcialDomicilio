package ecuacuacionLineal;

import java.text.DecimalFormat;
import utilidades.Consola;

/**
 *
 * @author willi
 * @param <T>
 */
public class SistemaEcuacionesLineales<T extends Number> implements Resoluble<T> {

    private  EcuacionDosVariables<T> ecuacion1;
    private  EcuacionDosVariables<T> ecuacion2;

    public SistemaEcuacionesLineales() {
        this.ecuacion1 = new EcuacionDosVariables<>();
        this.ecuacion2 = new EcuacionDosVariables<>();
    }

    @Override
    public void generarEcuacion() {
        Consola.emitirMensajeLN("Ingresar los datos de la primera ecuacion");
        ecuacion1.generarEcuacion();
        Consola.emitirMensajeLN("Ingresar los datos para la segunda ecuacion");
        ecuacion2.generarEcuacion();
    }

    @Override
    public void verificarSolucion() {
        Consola.emitirMensaje("ingrese el valor de la variable x : ");
        double x = Consola.leerDouble();
        Consola.emitirMensaje("Ingrese el valor de la variable y : ");
        double y = Consola.leerDouble();

        Consola.emitirMensajeLN("Sistema de ecuaciones :\n" + ecuacion1.toString());
        Consola.emitirMensajeLN(ecuacion2.toString() + "\n resulucion : \n");
        int b = 0;
        b = b + mostrarOperaciones(ecuacion1, x, y);
        b = b + mostrarOperaciones(ecuacion2, x, y);
        if (b == 2) {
            Consola.emitirMensajeLN("los valores ingresados si son solucion");
        } else {
            Consola.emitirMensajeLN("los valores ingresados no son solucion");
        }
    }

    private boolean sonIguales(double a, double b) {
        return a == b;
    }

    @Override
    public void resolver(int par) {
        double coefX1 = ecuacion1.getTerminoX().getCoeficiente().doubleValue();
        double coefY1 = ecuacion1.getTerminoY().getCoeficiente().doubleValue();
        double coefX2 = ecuacion2.getTerminoX().getCoeficiente().doubleValue();
        double coefY2 = ecuacion2.getTerminoY().getCoeficiente().doubleValue();

        double terminoIndependiente1 = ecuacion1.getTerminoIndependiente().doubleValue();
        double terminoIndependiente2 = ecuacion2.getTerminoIndependiente().doubleValue();
        double constante1 = ecuacion1.getConstante().doubleValue();
        double constante2 = ecuacion2.getConstante().doubleValue();

        double resultado1 = terminoIndependiente1 - constante1;
        double resultado2 = terminoIndependiente2 - constante2;
        
        double determinante = calcularDeterminante(coefX1, coefY1, coefX2, coefY2);

        if (determinante == 0) {
            manejarSistemaSingular(coefX1, coefY1, coefX2, coefY2, resultado1, resultado2);
        } else {
            double valorX = (resultado1 * coefY2 - resultado2 * coefY1) / determinante;
            double valorY = (coefX1 * resultado2 - coefX2 * resultado1) / determinante;
            Consola.emitirMensajeLN("Solucion unica: x = " + valorX + ", y = " + valorY);
        }
    }

    private double calcularDeterminante(double coefX1, double coefY1, double coefX2, double coefY2) {
        return coefX1 * coefY2 - coefX2 * coefY1;
    }

    private void manejarSistemaSingular(
            double coefX1, double coefY1, double coefX2, double coefY2,
            double resultado1, double resultado2
    ) {
        boolean coefProporcionales = (coefX1 * coefY2 == coefX2 * coefY1);
        boolean termProporcionales = (coefX1 * resultado2 == coefX2 * resultado1);

        if (coefProporcionales == termProporcionales) {
            Consola.emitirMensajeLN("Sistema compatible indeterminado. Posee infinitas soluciones");
            if (coefX1 != 0) {
                Consola.emitirMensaje("Variable libre X = ");
                Consola.emitirMensajeLN("(" + resultado1 + " - " + coefY1 + "·y) / " + coefX1);
            } else {
                if (coefY1 != 0) {
                    Consola.emitirMensaje("Variable libre Y = ");
                    Consola.emitirMensajeLN("(" + resultado1 + " - " + coefX1 + "·x) / " + coefY1);
                } else {
                    if (resultado1 == 0) {
                        Consola.emitirMensajeLN("Identidad: cualquier par (x, y) es solucion.");
                    } else {
                        Consola.emitirMensajeLN("Ecuacion contradictoria: no tiene solucion.");
                    }
                }
            }
        } else {
            Consola.emitirMensajeLN("Sistema incompatible: no tiene solucion.");
        }
    }

    @Override
    public void campararEcuaciones() {
        SistemaEcuacionesLineales otra = new SistemaEcuacionesLineales();
        otra.generarEcuacion();

          // Verificar si las ecuaciones son proporcionales (una posible combinación)
    boolean primeraCombinacion = this.ecuacion1.esProporcionalA(otra.ecuacion1) && 
                               this.ecuacion2.esProporcionalA(otra.ecuacion2);

    // Verificar otra posible combinación (ecuaciones intercambiadas)
    boolean segundaCombinacion = this.ecuacion1.esProporcionalA(otra.ecuacion2) && 
                                this.ecuacion2.esProporcionalA(otra.ecuacion1);

        if (primeraCombinacion || segundaCombinacion) {
            Consola.emitirMensajeLN("Los sistemas de ecuaciones son equivalentes");
        } else {
            Consola.emitirMensajeLN("Los sistemas de ecuaciones no son equivalentes");
        }

    }

    @Override
    public String toString() {
        return ecuacion1.toString() + "\n" + ecuacion2.toString();
    }

    private int mostrarOperaciones(EcuacionDosVariables ecuacion, double x, double y) {
        double coefX1 = ecuacion.getTerminoX().getCoeficiente().doubleValue();
        double coefY1 = ecuacion.getTerminoY().getCoeficiente().doubleValue();
        double terminoIndependiente = ecuacion.getTerminoIndependiente().doubleValue();
        double constante = ecuacion.getConstante().doubleValue();
        DecimalFormat format = new DecimalFormat("0.##");
        double aux1 = coefX1 * x;
        double aux2 = coefY1 * y;
        Consola.emitirMensajeLN(format.format(coefX1) + "" + format.format(x) + "+" + format.format(coefY1) + "" + format.format(y) + "+" + format.format(constante) + "=" + format.format(terminoIndependiente));
        Consola.emitirMensajeLN(format.format(aux1) + "+" + format.format(aux2) + "+" + format.format(constante) + "=" + format.format(terminoIndependiente));
        aux1 = aux1 + aux2;
        Consola.emitirMensajeLN(format.format(aux1) + "+" + format.format(constante) + "=" + format.format(terminoIndependiente));
        aux1 = aux1 + constante;
        Consola.emitirMensajeLN(format.format(aux1) + "=" + format.format(terminoIndependiente));
        if (sonIguales(aux1, terminoIndependiente)) {
            Consola.emitirMensajeLN(format.format(aux1) + "=" + format.format(terminoIndependiente));
            return 1;
        } else {
            Consola.emitirMensajeLN(format.format(aux1) + "≠" + format.format(terminoIndependiente));
            return 0;

        }
    }
}
