package ecuacuacionLineal;
/**
 *
 * @author willi
 */
public interface Resoluble <T extends Number> {
   void generarEcuacion();
   void verificarSolucion();
   void resolver(int par);
   void campararEcuaciones();
}
