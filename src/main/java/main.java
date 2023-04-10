import controlador.ControladorConversorMonedasVista;
import modelo.Conversion;
import vista.VistaConversorMonedas;

public class main {
    public static void main(String[] args) {
        VistaConversorMonedas vista = new VistaConversorMonedas();
        ControladorConversorMonedasVista ctrl = new ControladorConversorMonedasVista(vista);
        ctrl.iniciar();
        vista.setVisible(true);
    }
}

