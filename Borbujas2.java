package com.mycompany.borbujas2;

/** @author nicozulux**/

import java.awt.Color;
import java.util.Arrays;
import javax.swing.*;
import java.awt.event.*;

public class Borbujas2 extends JFrame {
    public static void main(String[] args) {
    Borbujas2 Borbujas2 = new Borbujas2();
    Borbujas2.setVisible(true);
    }
    private JTextField entradadatos;
    private JTextArea impresion;

    public Borbujas2() {
        // Configuramos la ventana principal  la ventana
        setTitle("El trabajo final"); //el titulo de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 500);
        setLocationRelativeTo(null);

        // Crear componentes de la interfaz
        entradadatos = new JTextField(20);
        JButton botonorden = new JButton("Ordenamos?:");
        impresion = new JTextArea(20, 20);
        impresion.setEditable(false);

        // Agregar componentes a la ventana
        
        JPanel campolectura = new JPanel();
        campolectura.setBackground(Color.orange);
        campolectura.setForeground(Color.white);
        campolectura.add(new JLabel("¿Que numeros organizaremos? digita los nuemeros separados por comas: "));
        campolectura.add(entradadatos);
        botonorden.setLayout(null);
        botonorden.setBounds(30, 30, 20, 40);
        botonorden.setBackground(Color.black);
        botonorden.setForeground(Color.white);
        add(campolectura, "North");
        add(botonorden, "Center");
        add(new JScrollPane(impresion), "South");

        // aqui ponemos la logica del boton 
        botonorden.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String[] numberStrings = entradadatos.getText().split(",");
                int[] nums = new int[numberStrings.length];
                for (int i = 0; i < numberStrings.length; i++) {
                    nums[i] = Integer.parseInt(numberStrings[i].trim());
                }

                impresion.append("el desorden a aorganizar: " + Arrays.toString(nums) + "\n");

                for (int i = 0; i < nums.length - 1; i++) {
                    for (int j = 0; j < nums.length - i - 1; j++) {
                        if (nums[j] > nums[j + 1]) {
                            int temp = nums[j];
                            nums[j] = nums[j + 1];
                            nums[j + 1] = temp;
                        }
                        impresion.append(String.format("Paso %d: %s\n", i * (nums.length - 1) + j + 1, Arrays.toString(nums)));
                    }
                }

                impresion.append("Ya quedo Organizado: " + Arrays.toString(nums) + "\n");
            }
        });
    }


}
