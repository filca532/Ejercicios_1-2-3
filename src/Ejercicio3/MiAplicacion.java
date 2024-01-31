package Ejercicio3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MiAplicacion {
    private JFrame frame;
    private JDialog dialog;
    private JComboBox<String> comboBox;
    private JPopupMenu popupMenu;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MiAplicacion window = new MiAplicacion();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public MiAplicacion() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Etiqueta");
        lblNewLabel.setBounds(10, 11, 46, 14);
        frame.getContentPane().add(lblNewLabel);

        JButton btnNewButton = new JButton("Botón");
        btnNewButton.setBounds(10, 36, 89, 23);
        frame.getContentPane().add(btnNewButton);

        JCheckBox chckbxNewCheckBox = new JCheckBox("Casilla de verificación");
        chckbxNewCheckBox.setBounds(10, 66, 128, 23);
        frame.getContentPane().add(chckbxNewCheckBox);

        JRadioButton rdbtnNewRadioButton = new JRadioButton("Botón de opción");
        rdbtnNewRadioButton.setBounds(10, 92, 109, 23);
        frame.getContentPane().add(rdbtnNewRadioButton);

        String[] items = {"Item 1", "Item 2", "Item 3"};
        comboBox = new JComboBox<>(items);
        comboBox.setBounds(10, 122, 91, 20);
        frame.getContentPane().add(comboBox);

        popupMenu = new JPopupMenu();
        JMenuItem menuItem = new JMenuItem("Opción del menú emergente");
        popupMenu.add(menuItem);

        frame.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent me) {
                if (me.isPopupTrigger())
                    popupMenu.show(me.getComponent(), me.getX(), me.getY());
            }
        });

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dialog = new JDialog(frame, "Confirmación", true);
                dialog.setLayout(new FlowLayout());

                JButton okButton = new JButton ("OK");
                okButton.addActionListener ( new ActionListener() {
                    public void actionPerformed( ActionEvent e ) {
                        dialog.setVisible(false);
                        frame.dispose();
                    }
                });

                dialog.add(new JLabel ("¿Estás seguro de que quieres cerrar la ventana?"));
                dialog.add(okButton);
                dialog.setSize(300,100);
                dialog.setVisible(true);
            }
        });

        frame.getContentPane().setBackground(Color.CYAN);

        ImageIcon img = new ImageIcon("src/Ejercicio3/imagen.png");
        frame.setIconImage(img.getImage());
    }
}

