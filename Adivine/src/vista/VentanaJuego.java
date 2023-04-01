/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import logica.JuegoMemoria;
import modelo.Jugador;

/**
 *
 * @author Yovany Romo
 */
public class VentanaJuego extends JFrame{
    private Header jpHeader;
    private JLabel jlJugador;
    private JLabel jlNombreJugador;
    private JLabel jlNumeroRonda;
    private JLabel jlRonda;
    private JLabel jlIntento;
    private JLabel jlNumero;
    private JLabel jlNumeroIntento;
    private JPanel jpContenido;
    private JTextField txtNumero;
    private JButton btnAdivinar;
    
    private JuegoMemoria juegoMemoria;
    
    public VentanaJuego(Jugador jugador){
        juegoMemoria = new JuegoMemoria(jugador);
        juegoMemoria.iniciarRonda();
        iniciarComponentes();
        setSize(519,530);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setTitle("Jugando a Adivinar");
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }
    
    private void iniciarComponentes(){
        
        Toolkit miPantalla = Toolkit.getDefaultToolkit();
        //Configuración del Encabezado
        jpHeader = new Header("/imagenes/header.png");
        jpContenido = new JPanel();
        
        jlJugador = new JLabel("Jugador : ");
        jlJugador.setBounds(5,110, 519,35);
        jlJugador.setForeground(new Color(0,87,193));
        jlJugador.setFont(new Font("arial", Font.BOLD, 20));
               
        String nombre = juegoMemoria.getJugador();
        nombre =    nombre.substring(0,1).toUpperCase() + 
                    nombre.substring(1).toLowerCase();
        jlNombreJugador = new JLabel(nombre);
        jlNombreJugador.setBounds(100,110, 519,35);
        jlNombreJugador.setForeground(Color.GRAY);
        jlNombreJugador.setFont(new Font("arial", Font.BOLD, 20));
        
        jlRonda = new JLabel("Ronda # : ");
        jlRonda.setBounds(230,110, 519,35);
        jlRonda.setForeground(new Color(0,87,193));
        jlRonda.setFont(new Font("arial", Font.BOLD, 20));
                
        jlNumeroRonda = new JLabel(
                String.valueOf(juegoMemoria.getNumeroRonda()));
        jlNumeroRonda.setBounds(330,110, 519,35);
        jlNumeroRonda.setForeground(Color.GRAY);
        jlNumeroRonda.setFont(new Font("arial", Font.BOLD, 20));
        
        jlIntento = new JLabel("Intento # : ");
        jlIntento.setBounds(375,110, 519,35);
        jlIntento.setForeground(new Color(0,87,193));
        jlIntento.setFont(new Font("arial", Font.BOLD, 20));
        
        jlNumeroIntento = new JLabel(
                String.valueOf(juegoMemoria.getIntentosRonda()));
        jlNumeroIntento.setBounds(475,110, 519,35);
        jlNumeroIntento.setForeground(Color.GRAY);
        jlNumeroIntento.setFont(new Font("arial", Font.BOLD, 20));
        
        jlNumero = new JLabel("¿Cuál es el número?",SwingConstants.CENTER );
        jlNumero.setBounds(0,180, 519,35);
        jlNumero.setForeground(new Color(0,87,193));
        jlNumero.setFont(new Font("arial", Font.BOLD, 20));
        
        jpContenido.add(jlJugador);
        jpContenido.add(jlNombreJugador);
        jpContenido.add(jlRonda);
        jpContenido.add(jlNumeroRonda);
        jpContenido.add(jlIntento);
        jpContenido.add(jlNumeroIntento);
        jpContenido.add(jlNumero);
        
       
        jpHeader.setSize(519,97);
        
        
        jpContenido.setSize(519,500);        
        jpContenido.setBounds(0,110, 519, 500);
        jpContenido.setLayout(null);
        
        add(jpHeader);
        add(jpContenido);
        
        txtNumero = new JTextField("");
        txtNumero.setHorizontalAlignment(JTextField.CENTER);
        txtNumero.setForeground(Color.GRAY);
        txtNumero.setFont(new Font("arial", Font.BOLD, 20)); 
        
        btnAdivinar = new JButton("Adivinar");
        btnAdivinar.setBounds(210,300, 100,35);
        
        jpContenido.add(txtNumero);
        jpContenido.add(btnAdivinar);
        
        txtNumero.setBounds(50,230,410, 40);    
        
        Image miIcono = miPantalla.getImage("src/imagenes/icono.png");
	setIconImage(miIcono);
        
        btnAdivinar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int numero = 0;
                try{
                    numero = Integer.parseInt(txtNumero.getText());
                    adivinarNumero(numero);
                } catch(NumberFormatException ex){
                     JOptionPane.showMessageDialog(null,
                    "Por favor ingrese un numero", 
                    "Error de Entrada de Dato",
                    JOptionPane.ERROR_MESSAGE);
                }                
            }
        });
        
        txtNumero.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                
            }

            @Override
            public void keyPressed(KeyEvent e) {
               
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode() == e.VK_ENTER){
                    btnAdivinar.doClick();
                }
            }
        });
        
        addWindowListener(new WindowAdapter() {
             @Override
            public void windowClosing(WindowEvent evt) {
                cerrarVentana();
            }
        });
               
    }
    
    private void cerrarVentana(){
        int respuesta;

        respuesta = JOptionPane.showConfirmDialog(
                    null,"¿Realmente dese abandonar el juego?", "Advertencia",
                    JOptionPane.YES_NO_OPTION, 
                    JOptionPane.WARNING_MESSAGE);
        if(respuesta == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }
    
    public void adivinarNumero(int numero){
        int numeroAdivinar = juegoMemoria.getNumeroAdivinar();
        String mensaje = "";
        System.out.println(numeroAdivinar); 

        if(numeroAdivinar > numero){
            mensaje = " MAYOR ";
        } else {
            mensaje = " MENOR ";
        }

        boolean acierto = juegoMemoria.esElNumero(numero);

        jlNumeroIntento.setText(
                String.valueOf(juegoMemoria.getIntentosRonda()));

        if(acierto){
            JOptionPane.showMessageDialog(null,
            "¡IMPRESIONANTE!, \n\nHaz adivinado"
            + " el número en " +
            juegoMemoria.getIntentosRonda() +
            "  intentos. \n\nFELICITACIONES!!!\n", "Haz ganado",
            JOptionPane.INFORMATION_MESSAGE);

            juegoMemoria.compararRondas();

            jugarOtraVez();

        } else {
             JOptionPane.showMessageDialog(null,
            "Lo siento, haz fallado!!. \n\nPero no importa, " +
            "en el siguiente intento lo lograras! " +
            "\n\nEl número a adivinar es [ " + mensaje + 
            " ] al número ingresado [ " + numero + " ]", 
            "Haz fallado - Llevas " +
            juegoMemoria.getIntentosRonda() + " intentos" ,
            JOptionPane.ERROR_MESSAGE);
            txtNumero.setSelectionStart(0);
            txtNumero.setSelectionEnd(txtNumero.getText().trim().length());
        }                
        txtNumero.requestFocusInWindow();
    }
    
    public void jugarOtraVez(){
        int respuesta;
        
        respuesta = JOptionPane.showConfirmDialog(
                null,"¿Desea jugar otra vez?", "Información",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        if(respuesta == JOptionPane.YES_OPTION){
            juegoMemoria.iniciarRonda();
            jlNumeroRonda.setText(
                    String.valueOf(juegoMemoria.getNumeroRonda()));
            
            jlNumeroIntento.setText(
                        String.valueOf(juegoMemoria.getIntentosRonda()));
            txtNumero.setText("");
        } else {
            dispose();
            JOptionPane.showMessageDialog(null,
            "ESTADÍSTICAS DEL JUEGO\n\n" + 
            "Total Rondas : " + juegoMemoria.getNumeroRonda() +
            "\nLa mejor Ronda fue la # " + 
            juegoMemoria.getMejorRonda().getNumeroRonda() + " con " +
                    juegoMemoria.getMejorRonda().getIntentosRonda() +
                    " Intentos", 
            "Hasta la vista Baby!!!",
            JOptionPane.INFORMATION_MESSAGE);            
        }
    }
}
