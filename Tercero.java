

import java.awt.event.*;
import java.io.*;
import static java.lang.Math.floor;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Tercero extends JFrame {

    String Cadena, number;
    int myInt, Contador, mitad1, mitad, fafa, cadena;
    Integer queuer, queue;
    public JPanel panel;
    public JTextArea areatexto;
    JButton boton1, boton2, boton3, boton4;
    char convertedChar;

    public Tercero() {

        setTitle("Tarea GUI");
        setSize(500, 550);
        iniciarComponentes();
        setLocationRelativeTo(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    private void iniciarComponentes() {

        ColocarPanel();
        ColocarEtiquetas();
        ColocarBoton();
        Areadetexto();
        Incio();

    }

    private void ColocarPanel() {

        panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);

    }

    private void ColocarEtiquetas() {

        JLabel etiqueta = new JLabel("Ingresa en texto en la parte de abajo");
        etiqueta.setLayout(null);
        etiqueta.setBounds(110, 7, 250, 60);
        panel.add(etiqueta);

    }

    private void ColocarBoton() {

        boton1 = new JButton("Confirmar");
        boton1.setBounds(190, 180, 100, 40);
        panel.add(boton1);
        boton2 = new JButton("Ver texto cifrado");
        boton2.setBounds(160, 320, 150, 40);
        panel.add(boton2);
        boton4 = new JButton("Crear Archivo");
        boton4.setBounds(160, 250, 150, 40);
        panel.add(boton4);
        boton3 = new JButton("Ver texto plano");
        boton3.setBounds(160, 390, 150, 40);
        panel.add(boton3);

    }

    private void Areadetexto() {

        areatexto = new JTextArea();

        areatexto.setBounds(110, 50, 250, 100);
        panel.add(areatexto);

    }

    private void Incio() {

        ActionListener oyente = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Cadena = areatexto.getText();

                separar1();

            }
        };

        boton1.addActionListener(oyente);

    }

    private void separar1() {

        Queue queue = new LinkedList<>();
        Queue queuer = new LinkedList<>();
        number = Cadena;

        Contador = Cadena.length();
        cadena = Contador - 1;

        if (Contador % 2 == 0) {

            Contador = Contador;
            mitad = Contador - 1;
            fafa = Contador / 2;

            int a = mitad;

            char[] digits1 = number.toCharArray();

            for (int i = mitad; i > -1; i--) {

                if (i >= fafa) {

                    byte[] bytes = number.getBytes(StandardCharsets.US_ASCII);

                    myInt = (bytes[a]);

                    if (digits1[i] >= 49 && digits1[i] <= 57) {

                        myInt = myInt;

                    } else {

                        myInt = myInt + 3;
                    }

                } else {

                    byte[] bytes = number.getBytes(StandardCharsets.US_ASCII);

                    myInt = (bytes[a]);

                    if (digits1[i] >= 49 && digits1[i] <= 57) {

                        myInt = myInt;

                    } else {

                        myInt = myInt + 2;
                    }
                }
                a--;

                queue.add(myInt);

                convertedChar = (char) myInt;

                queuer.add(convertedChar);

            }

        } else {

            Contador = (Contador / 2);
            mitad1 = (int) Math.floor(Contador);

            fafa = cadena;

            mitad1 = mitad1;

            int a = fafa;

            char[] digits1 = number.toCharArray();
            for (int i = fafa; i > -1; i--) {

                if (i > mitad1) {

                    byte[] bytes = number.getBytes(StandardCharsets.US_ASCII);

                    myInt = (bytes[a]);

                    if (digits1[i] >= 49 && digits1[i] <= 57) {

                        myInt = myInt;

                    } else {

                        myInt = myInt + 3;
                    }

                } else {

                    byte[] bytes = number.getBytes(StandardCharsets.US_ASCII);

                    myInt = (bytes[a]);

                    if (digits1[i] >= 49 && digits1[i] <= 57) {

                        myInt = myInt; //// es esteee

                    } else {

                        myInt = myInt + 2;
                    }
                }
                a--;

                queue.add(myInt);
                convertedChar = (char) myInt;

                queuer.add(convertedChar);

            }

        }

        ActionListener oyente1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(null, "Texto cifrado es: " + queue);

            }
        };

        boton2.addActionListener(oyente1);

        ActionListener oyente2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(null, "Texto plano es: " + queuer);

            }
        };

        boton3.addActionListener(oyente2);

        ActionListener oyente3;
        oyente3 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    String ruta = "C:/Users/Samuel Sotelo/Documents/NetBeansProjects/TAREATOPICOS/textoplano.txt";
                    String contenido = queuer.toString();
                    File file = new File(ruta);
                    // Si el archivo no existe es creado
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    FileWriter fw = new FileWriter(file);
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(contenido);
                    bw.close();

                    String ruta1 = "C:/Users/Samuel Sotelo/Documents/NetBeansProjects/TAREATOPICOS/textocifrado.vge";
                    String contenido1 = queue.toString();
                    File file1 = new File(ruta1);
                    // Si el archivo no existe es creado
                    if (!file1.exists()) {
                        file1.createNewFile();
                    }
                    FileWriter fg = new FileWriter(file);
                    BufferedWriter bg = new BufferedWriter(fg);
                    bg.write(contenido1);
                    bg.close();

                } catch (IOException ex) {
                    Logger.getLogger(Tercero.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        };

        boton4.addActionListener(oyente3);

    }

    public static void main(String[] args) {

        Tercero v1 = new Tercero();

        v1.setVisible(true);

    }

}