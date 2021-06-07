package Usuario;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Usuario {

	public static void main(String[] args) {
		try {
            Socket socket = new Socket("localhost", 8080);
            Scanner in = new Scanner(socket.getInputStream());//lee del servidor
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);//escribe al servidor
            Scanner kb = new Scanner(System.in);//lee del teclado
            while(in.hasNextLine()) {
                String msg = in.nextLine();
                System.out.println(msg);
                if(!msg.contains("CLOSE:")) {
                    out.println(kb.nextLine());
                } else {
                    break;
                }
            }
        } catch (UnknownHostException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }

	}

}
