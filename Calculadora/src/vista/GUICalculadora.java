package vista;


import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


/**
 *
 * @author Yovany Romo
 */
public class GUICalculadora extends JFrame {

    private JLabel lblNumero1;
    private JLabel lblNumero2;
    private JTextField txtNumero1;
    private JTextField txtNumero2;
    private JTextField txtResultado;
    private JButton btnSumar;
    private JButton btnRestar;
    private JButton btnMultiplicar;
    private JButton btnDividir;
    private JPanel panelIngreso;
    private JPanel panelBotones;
    private JPanel panelResultado;
    private Container contenedorPrincipal;
    
    public GUICalculadora()
    {
        lblNumero1 = new JLabel("Numero 1:");
        lblNumero2 = new JLabel("Numero 2:");
        
        txtNumero1 = new JTextField();
        txtNumero2 = new JTextField();
        txtResultado = new JTextField(25);
        
        btnSumar = new JButton("Sumar");
        btnRestar = new JButton("Restar");
        btnMultiplicar = new JButton("Multiplicar");
        btnDividir = new JButton("Dividir");
        
        
        panelIngreso = new JPanel();
        panelBotones = new JPanel();
        panelResultado = new JPanel();
        
        panelIngreso.setLayout(new GridLayout(2,2));
        panelIngreso.add(lblNumero1); 
        panelIngreso.add(txtNumero1);
        panelIngreso.add(lblNumero2); 
        panelIngreso.add(txtNumero2);
        
        panelBotones.setLayout(new GridLayout(1, 4,5,0));
        panelBotones.add(btnSumar); 
        panelBotones.add(btnRestar); 
        panelBotones.add(btnMultiplicar); 
        panelBotones.add(btnDividir);
        
        panelResultado.add(txtResultado);
        
        panelIngreso.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.BLUE,3),"Ingreso de Datos"));
        panelBotones.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.BLUE,3),"Controles"));
        panelResultado.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.BLUE,3),"Resultados"));
        
        contenedorPrincipal = getContentPane();

        contenedorPrincipal.setLayout(new GridLayout(3, 1));
        contenedorPrincipal.add(panelIngreso); 
        contenedorPrincipal.add(panelBotones); 
        contenedorPrincipal.add(panelResultado);
        
        setTitle("Ejemplo Calculadora");
        setSize(500, 250);        
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }        

     
}
