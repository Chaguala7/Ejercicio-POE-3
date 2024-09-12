
package Logica;

import Gui.Login;
import com.formdev.flatlaf.intellijthemes.FlatCyanLightIJTheme;
import java.net.PasswordAuthentication;
import java.util.ArrayList;

/**
 *
 * @author ACER
 */
public class Ejercico3Poe {

    public static ArrayList<PasswordAuthentication> usuarios = new ArrayList();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PasswordAuthentication admin = new PasswordAuthentication("admin", "admin".toCharArray());
        PasswordAuthentication requisito = new PasswordAuthentication("POE-2024", "POE-2024".toCharArray());
        usuarios.add(admin);
        usuarios.add(requisito);
        try {
            FlatCyanLightIJTheme.setup();

        } catch (Exception e) {
            System.out.println("Error");
        }
        Login inicio = new Login();
        inicio.setVisible(true);
    }
    
}
