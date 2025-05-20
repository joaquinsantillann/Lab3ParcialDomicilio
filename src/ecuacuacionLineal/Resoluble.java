package ecuacuacionLineal;
/**
 *
 * @author willi
 */
public interface Resoluble <T extends Number> {
   
   void verificarSolucion();
   T resolver();
   void campararEcuaciones();
}
