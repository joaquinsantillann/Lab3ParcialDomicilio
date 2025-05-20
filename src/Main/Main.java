package Main;

import ecuacuacionLineal.*;

/**
 *
 * @author willi
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EcuacionDosVariables x = new EcuacionDosVariables();
        EcuacionDosVariables y = new  EcuacionDosVariables();

        x.generarEcuacion();
        y.generarEcuacion();
         

        System.out.println(x.toString());
        System.out.println(y.toString());
    }

}
