package controlador;

import modelo.Conversion;
import vista.VistaConversorMonedas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ControladorConversorMonedasVista implements ActionListener {

    private VistaConversorMonedas vista;
    private List<Conversion> listaConversion = new ArrayList<>();

    public ControladorConversorMonedasVista(VistaConversorMonedas conversorMonedasVista) {
        this.vista = conversorMonedasVista;
        this.vista.convertirBt.addActionListener(this);
        cargarMonedas();
        cargarComboBoxs();
    }

    public void iniciar(){
        vista.setTitle("Conversor de monedas");
        vista.setLocationRelativeTo(null);
        vista.setSize(300, 300);
        vista.setVisible(true);
        vista.setContentPane(vista.panel1);
    }
    private void cargarMonedas() {
    Conversion pesoAdolar = new Conversion("Peso a dolar", 300);
    Conversion pesoAeuro = new Conversion("Peso a euro", 340);
    Conversion pesoAsol= new Conversion("Peso a sol", 23);
    listaConversion.add(pesoAdolar);
    listaConversion.add(pesoAeuro);
    listaConversion.add(pesoAsol);
    }
    public void cargarComboBoxs(){
        for (Conversion c: listaConversion){
            vista.primerMonedaCB.addItem((String)c.getNombre());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        double valor = Double.parseDouble(vista.cantidadJTF.getText());
        String conversion = (String) vista.primerMonedaCB.getSelectedItem();
        for(Conversion c: listaConversion) {
            if(c.getNombre().equals(conversion)){
                double convertido = valor * c.getValor();
                vista.valorConversion.setText(""+convertido);
            }
        }
    }
}
