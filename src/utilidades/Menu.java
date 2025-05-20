package utilidades;

/**
 *
 * @author willi
 */
public class Menu {

    private String[] items;
    private int itemCount;

    public Menu(int maxItems) {
        this.items = new String[maxItems];
        this.itemCount = 0;
    }

    public void addItem(String item) {
        if (itemCount < items.length) {
            items[itemCount] = item;
            itemCount++;
          //  System.out.println("Item agregado correctamente");
        } else {
            Consola.emitirMensajeLN("No hay lugar para mas items");
        }
    }

    public  void removeItem(int pos) {
        if (itemCount == 0) {
            Consola.emitirMensajeLN("No hay items para remover");
            return;
        }
        if (pos < 1 || pos > itemCount) {
            Consola.emitirMensajeLN("La posición ingresada esta fuera de rango");
            return;
        }
        for (int i = pos - 1; i < itemCount - 1; i++) {
            items[i] = items[i + 1];
        }
        items[itemCount - 1] = null;
        itemCount--;
        Consola.emitirMensajeLN("El item se ha eliminado correctamente.");
    }

    public  void visualizar() {
        for (int i = 0; i < itemCount; i++) {
            Consola.emitirMensajeLN("El item " + (i + 1) + ": " + items[i]);
        }
    }

    public int ejecutar() {
    int opcion;
    do {
        visualizar();
        Consola.emitirMensaje("Ingresar Opcion:");
        opcion = Consola.leerInt();  // Leemos la opción del usuario

        // Validamos que la opción esté en el rango correcto
        if (opcion < 0 || opcion > itemCount) {
            Consola.emitirMensajeLN("Opcion invalida, vuelva a ingresar.");
        }
    } while (opcion < 0 || opcion > itemCount);  // Aseguramos que la opción esté en el rango correcto

    return opcion;
}

}
