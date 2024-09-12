package Gui;

import static Logica.Ejercico3Poe.usuarios;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.PasswordAuthentication;
import java.util.Arrays;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author ACER
 */
public class Login extends JFrame {
    
    JButton btnInicio, btnSalir;
    JPasswordField passContraseña;
    JTextField texUsuario;
    JLabel lbIcono, lbPassword, lbUsuario;
    JPanel panel;

    public Login() {
        setTitle("Autenticacion");
        setResizable(false);
        setSize(400, 600);
        setLocationRelativeTo(null);
        setUndecorated(true);
        iniciarComponentes();
        add(panel);
    }

    private void iniciarComponentes() {

        panel = new JPanel();
        panel.setLayout(null);
        panel.setSize(400, 600);

        //boton salir :V
        btnSalir = new JButton("x");
        btnSalir.setFont(new Font("", 0, 14));
        btnSalir.setBounds(350, 0, 50, 30);
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        //
        lbIcono = new JLabel(new ImageIcon(getClass().getResource("/imagenes/User.png")));
        lbIcono.setBounds(50, 70, 300, 300);

        lbUsuario = new JLabel("Usuario:");
        lbUsuario.setBounds(100, 410, 60, 25);

        texUsuario = new JTextField();
        texUsuario.setBounds(160, 410, 120, 25);

        lbPassword = new JLabel("Contraseña:");
        lbPassword.setBounds(77, 440, 120, 25);

        passContraseña = new JPasswordField();
        passContraseña.setBounds(160, 440, 120, 25);

        btnInicio = new JButton("Inicio");
        btnInicio.setBounds(170, 500, 80, 30);
        btnInicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    boolean aux = false;
                    validarTextoVacio(texUsuario);
                    validarContraseñaVacia(passContraseña);
                    for (PasswordAuthentication usuario : usuarios) {
                        boolean contrasena = Arrays.equals(usuario.getPassword(), passContraseña.getPassword());
                        boolean usuari = usuario.getUserName().equals(texUsuario.getText());
                        if (contrasena && usuari) {
                            aux = true;
                            VentanaPrincipal x = new VentanaPrincipal();
                            x.setVisible(true);
                            dispose();
                            break;
                        }
                    }
                    if (!aux) {
                        JOptionPane.showMessageDialog(null, "Usuario o Contraseña erroneo");
                    }
                    texUsuario.setText("");
                    passContraseña.setText("");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Por favor diligencie los campos vacios", "Error", JOptionPane.ERROR_MESSAGE, null);
                }
            }
        });

        panel.add(btnInicio);
        panel.add(btnSalir);
        panel.add(passContraseña);
        panel.add(texUsuario);
        panel.add(lbIcono);
        panel.add(lbPassword);
        panel.add(lbUsuario);
    }

    public void validarTextoVacio(JTextField cuadro) throws Exception {
        if (cuadro.getText().trim().equals("")) {
            throw new Exception();
        }
    }

    public void validarContraseñaVacia(JPasswordField cuadro) throws Exception {
        if (cuadro.getPassword().length == 0) {
            throw new Exception();
        }
    }   
}
