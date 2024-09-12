package Gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author ACER
 */
public class VentanaPrincipal extends JFrame {

    JPanel panel, p1, p2, p3, panelCentral;
    JMenuBar menu;
    JMenu menu1;
    CardLayout cardLayout;
    JSlider sliNum1, sliNum2;
    JLabel num1, num2, exis, igual, resultado, verde, rosado, rojo, amarillo, azul, hola;
    JLabel lbLeer, lbVerTv, lbDeportes, lbBailar;
    JButton btnNumAleatorio;
    JTextArea area;
    JCheckBox chLeer, chVerTv, chDeportes, chBailar;
    int cont = 0;

    public VentanaPrincipal() {

        setTitle("ProyectoJAVA");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setSize(1000, 700);
        setLocationRelativeTo(null);

        // Crear el panel principal y su diseño
        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Crear la barra de menús
        menu = new JMenuBar();
        menu1 = new JMenu("Opciones");

        // Crear ítems de menú
        JMenuItem multiplicadorItem = new JMenuItem("Tablas de Multiplicar");
        JMenuItem coloresItem = new JMenuItem("Colores");
        JMenuItem ActividadesItem = new JMenuItem("Actividades preferidas");

        // Agregar ítems al menú
        menu1.add(multiplicadorItem);
        menu1.add(coloresItem);
        menu1.add(ActividadesItem);

        menu.add(menu1);

        // <editor-fold defaultstate="collapsed" desc="Codigo Panel 1">  
        // Crear paneles
        p1 = new JPanel();
        p1.setLayout(null);
//        p1.setBackground(Color.white);        

        sliNum1 = new JSlider(JSlider.VERTICAL, 0, 100, 50);
        sliNum1.setMajorTickSpacing(10);
        sliNum1.setMinorTickSpacing(1);
        sliNum1.setPaintTicks(true);
        sliNum1.setPaintLabels(true);
        sliNum1.setSnapToTicks(true);
        sliNum1.setBounds(50, 50, 50, 400);
        sliNum1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int valor = sliNum1.getValue();
                num1.setText("" + valor);
                resultado.setText((sliNum1.getValue() * sliNum2.getValue()) + "");
                area.setText(LlenarTexArea());
            }
        });

        sliNum2 = new JSlider(JSlider.VERTICAL, 0, 100, 50);
        sliNum2.setMajorTickSpacing(10);
        sliNum2.setMinorTickSpacing(1);
        sliNum2.setPaintTicks(true);
        sliNum2.setPaintLabels(true);
        sliNum2.setSnapToTicks(true);
        sliNum2.setBounds(150, 50, 50, 400);
        sliNum2.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int valor = sliNum2.getValue();
                resultado.setText((sliNum1.getValue() * sliNum2.getValue()) + "");
                num2.setText("" + valor);
            }
        });

        area = new JTextArea(LlenarTexArea());
        area.setBounds(500, 50, 300, 400);
        area.setEditable(false);
        area.setFont(new Font("", 1, 25));

        num1 = new JLabel(sliNum1.getValue() + "");
        num1.setFont(new Font("", 1, 70));
        num1.setBounds(300, 500, 150, 100);

        exis = new JLabel(" X ");
        exis.setFont(new Font("", 1, 60));
        exis.setBounds(410, 500, 80, 100);

        num2 = new JLabel(sliNum2.getValue() + "");
        num2.setFont(new Font("", 1, 70));
        num2.setBounds(480, 500, 150, 100);

        igual = new JLabel(" = ");
        igual.setFont(new Font("", 1, 60));
        igual.setBounds(590, 500, 80, 100);

        resultado = new JLabel(sliNum1.getValue() * sliNum2.getValue() + "");
        resultado.setFont(new Font("", 1, 70));
        resultado.setBounds(690, 500, 200, 100);

        btnNumAleatorio = new JButton("Numeros Aleatorios");
        btnNumAleatorio.setBounds(70, 530, 200, 40);
        btnNumAleatorio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sliNum1.setValue((int) (Math.random() * 100));
                sliNum2.setValue((int) (Math.random() * 100));
                num1.setText(sliNum1.getValue() + "");
                num2.setText(sliNum2.getValue() + "");
                resultado.setText(sliNum1.getValue() * sliNum2.getValue() + "");
                area.setText(LlenarTexArea());
            }
        });
        p1.add(area);
        p1.add(btnNumAleatorio);
        p1.add(sliNum1);
        p1.add(sliNum2);
        p1.add(num1);
        p1.add(exis);
        p1.add(num2);
        p1.add(igual);
        p1.add(resultado);

        // </editor-fold> 
        // <editor-fold defaultstate="collapsed" desc="Codigo Panel 2"> 
        //verde
        p2 = new JPanel();
        p2.setLayout(null);

        verde = new JLabel();
        verde.setBounds(90, 70, 120, 100);
        verde.setBackground(Color.GREEN);
        verde.setBorder(new LineBorder(Color.BLACK));
        verde.setOpaque(true);
        verde.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                hola.setForeground(Color.GREEN);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
//                hola.setForeground(Color.GREEN);
            }

            @Override
            public void mouseExited(MouseEvent e) {
//                hola.setForeground(Color.GREEN);
            }
        });

        // rosado
        rosado = new JLabel();
        rosado.setBounds(250, 70, 120, 100);
        rosado.setBackground(Color.PINK);
        rosado.setBorder(new LineBorder(Color.BLACK));
        rosado.setOpaque(true);
        rosado.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                hola.setForeground(Color.PINK);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        // azul
        azul = new JLabel();
        azul.setBounds(410, 70, 120, 100);
        azul.setBackground(Color.BLUE);
        azul.setBorder(new LineBorder(Color.BLACK));
        azul.setOpaque(true);
        azul.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                hola.setForeground(Color.BLUE);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        // rojo
        rojo = new JLabel();
        rojo.setBounds(570, 70, 120, 100);
        rojo.setBackground(Color.RED);
        rojo.setBorder(new LineBorder(Color.BLACK));
        rojo.setOpaque(true);
        rojo.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                hola.setForeground(Color.RED);
                cont++;
                hola.setText("Hola mundo " + cont);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        // amarillo
        amarillo = new JLabel();
        amarillo.setBounds(730, 70, 120, 100);
        amarillo.setBackground(Color.YELLOW);
        amarillo.setBorder(new LineBorder(Color.BLACK));
        amarillo.setOpaque(true);
        amarillo.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                hola.setForeground(Color.YELLOW);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        //Hola
        hola = new JLabel("Hola Mundo");
        hola.setBounds(350, 350, 350, 40);
        hola.setFont(new Font("", 1, 40));

        p2.add(verde);
        p2.add(rosado);
        p2.add(azul);
        p2.add(rojo);
        p2.add(amarillo);
        p2.add(hola);

        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="Codigo Panel 3">
        p3 = new JPanel();
        p3.setLayout(null);

        chLeer = new JCheckBox("Leer");
        chVerTv = new JCheckBox("Ver Television");
        chDeportes = new JCheckBox("Deportes");
        chBailar = new JCheckBox("Bailar");

        chLeer.setBounds(50, 70, 150, 30);
        chVerTv.setBounds(50, 150, 150, 30);
        chDeportes.setBounds(50, 230, 150, 30);
        chBailar.setBounds(50, 310, 150, 30);

        chLeer.setFont(new Font("", 1, 16));
        chVerTv.setFont(new Font("", 1, 16));
        chDeportes.setFont(new Font("", 1, 16));
        chBailar.setFont(new Font("", 1, 16));
        
        chLeer.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (chLeer.isSelected()) {
                    lbLeer.setVisible(true);
                } else {
                    lbLeer.setVisible(false);
                }
            }
        });
        chVerTv.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (chVerTv.isSelected()) {
                    lbVerTv.setVisible(true);
                } else {
                    lbVerTv.setVisible(false);
                }
            }
        });
        chDeportes.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (chDeportes.isSelected()) {
                    lbDeportes.setVisible(true);
                } else {
                    lbDeportes.setVisible(false);
                }
            }
        });
        chBailar.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (chBailar.isSelected()) {
                    lbBailar.setVisible(true);
                } else {
                    lbBailar.setVisible(false);
                }
            }
        });
        
        

        lbBailar = new JLabel(resizeImage("/imagenes/bailar.jpg", 350, 225));
        lbDeportes = new JLabel(resizeImage("/imagenes/deportes.jpg", 350, 225));
        lbLeer = new JLabel(resizeImage("/imagenes/leer.jpg", 350, 225));
        lbVerTv = new JLabel(resizeImage("/imagenes/ver-tv.jpg", 350, 225));

        lbBailar.setBounds(225, 50, 350, 225);
        lbDeportes.setBounds(225, 280, 350, 225);
        lbLeer.setBounds(580, 50, 350, 225);
        lbVerTv.setBounds(580, 280, 350, 225);

        lbBailar.setVisible(false);
        lbDeportes.setVisible(false);
        lbLeer.setVisible(false);
        lbVerTv.setVisible(false);

        p3.add(lbBailar);
        p3.add(lbDeportes);
        p3.add(lbLeer);
        p3.add(lbVerTv);

        p3.add(chLeer);
        p3.add(chVerTv);
        p3.add(chDeportes);
        p3.add(chBailar);
//        p3.setBackground(Color.darkGray);

        // </editor-fold>
        // Crear panel central con CardLayout
        cardLayout = new CardLayout();
        panelCentral = new JPanel(cardLayout);

        panelCentral.add(p1, "Tablas de Multiplicar");
        panelCentral.add(p2, "Colores");
        panelCentral.add(p3, "Actividades preferidas");

        // Agregar paneles a la ventana
        panel.add(menu, BorderLayout.NORTH);
        panel.add(panelCentral, BorderLayout.CENTER);

        // Definir acciones de los ítems del menú
        multiplicadorItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelCentral, "Tablas de Multiplicar");
                sliNum1.setValue(50);
                sliNum2.setValue(50);
            }
        });

        coloresItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelCentral, "Colores");
                cont = 0;
                hola.setText("Hola mundo");
                hola.setForeground(Color.BLACK);
            }
        });

        ActividadesItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelCentral, "Actividades preferidas");
            }
        });

        // Agregar el panel a la ventana
        add(panel);
    }

    public ImageIcon resizeImage(String imagePath, int width, int height) {
        // Asegúrate de que la ruta de la imagen es correcta
        ImageIcon icon = new ImageIcon(VentanaPrincipal.class.getResource(imagePath));
        Image img = icon.getImage();

        if (img == null) {
            System.out.println("No se pudo cargar la imagen en la ruta: " + imagePath);
            return null;
        }

        // Redimensionar la imagen
        Image resizedImage = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);

        // Crear un nuevo ImageIcon con la imagen redimensionada
        return new ImageIcon(resizedImage);
    }

    public String LlenarTexArea() {
        String aux = "";
        for (int i = 1; i < 13; i++) {
            int num = sliNum1.getValue();
            aux = aux + " " + num + " X " + i + " = " + (num * i) + " \n";
        }
        return aux;
    }
}
