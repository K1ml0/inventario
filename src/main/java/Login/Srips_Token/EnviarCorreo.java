/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Login.Srips_Token;
import Login.Diseño_login;
import Login.Token;
import Login.Srips_Token.TOKEN;
import Ventanas_progreso.Progreso;
import static Ventanas_progreso.Progreso.Progreso;
import static java.awt.SystemColor.window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.Properties;
import java.util.function.Consumer;
import javax.crypto.SecretKey;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.Timer;
import ventanaPrincipal.VentanaPrincipal;
import static ventanaPrincipal.VentanaPrincipal.main;
import conex.conexion;
/**
 *
 * @author juan
 */
public class EnviarCorreo {
    public static final int maximo = 100;
    public static int i =0;
    private static final int INTERVALO = 1000;
    private static int DURACION_TOTAL = 02 * 60;
    private static int tiempoRestante = DURACION_TOTAL;
    public static Timer timer;
    // Configuración del servidor SMTP de Gmail
  
    public static String destinatario ="jd.alzate29@ciaf.edu.co";//Remplazar y crear la base de datos
    private static String asunto = "Recuperacion de cuenta";
    public static String token = "";
    public static SecretKey llave_secreta ;
    public static Boolean Mensage_enviado_correctamente = false;
    public static void main(String[] args) {

        llave_secreta = TOKEN.generateKey();
        Iniciar_programa_Mensage_gmail();
    }
    public static void Iniciar_programa_Mensage_gmail(){
        
        String username = conex.conexion.username_gmail;
        String password = conex.conexion.password_gmail;
                
        Map<String, Object> extraClaims = TOKEN.GetExtraClaims();
        token = TOKEN.Llave(extraClaims);
        //new Progreso().setVisible(true);
        Token.jProgressBar1.setMinimum(0);
        Token.jProgressBar1.setMaximum(maximo);
        Token.jProgressBar1.setStringPainted(true);
        SwingWorker<Void, Integer> trabajo = new SwingWorker<Void, Integer>(){//hilo de tranbajo background en segundo plano
           protected Void doInBackground() throws Exception{  
               for(i =1; i <= maximo; i++){
                   publish(i);//enviar datos
                   if(!Mensage_enviado_correctamente){
                        if(destinatario != ""){
                            Diseño_login.jButton1.setEnabled(false);
                            if(!VentanaPrincipal.Estado_ventana_Token){
                                new Token().setVisible(true);
                                Token.jPanel1.setVisible(false);   
                                Token.jPanel2.setVisible(true); 
                            }
                            if(Crear_y_Enviar_Mensaje(username, password, destinatario, asunto, token)){//si mensage no se ha enviado se envia
                                CRONOMETRO();
                                Mensage_enviado_correctamente = true;

                            }else{
                                i=100;
                                JOptionPane.showMessageDialog(null, "Error inesperado. Intenta mas tarde", "Error", JOptionPane.ERROR_MESSAGE);
                                new Token().setVisible(false);
                                Token.jPanel1.setVisible(false);   
                                Token.jPanel2.setVisible(false); 
                          
                            }
                             
                        }else{
                             i=100;
                             JOptionPane.showMessageDialog(null, "Hubo un error al intentar acceder a la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
                       }
                   }else{
                       Thread.sleep(10);
                       if(i==maximo){
                           VentanaPrincipal.Estado_ventana_Token = false;
                           Token.jPanel1.setVisible(true);
                           Token.jPanel2.setVisible(false);
                                    
                       }
                   }  
               }
              return null;
           }
           protected void process(java.util.List<Integer> chunks){
               int progress = chunks.get(chunks.size()-1);
               Token.jProgressBar1.setValue(progress);
           }

       };
       trabajo.execute();
     
    }
    public static void desactivae_activar_botones(boolean valor){
         Token.jButton2.setEnabled(valor);//deshabilitar noton
    }
    public static void CRONOMETRO(){
        ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                tiempoRestante--;
                if (tiempoRestante >= 0) {
                    actualizarComponente();
                    desactivae_activar_botones(false);
                } else {
                    detener();
                    desactivae_activar_botones(true);
                    Mensage_enviado_correctamente = false;
                    tiempoRestante = DURACION_TOTAL;//recargar cronometro
                }
            }
        };
        timer = new Timer(INTERVALO, actionListener);
        timer.start();
    }
    private static void actualizarComponente(){
        int horas = tiempoRestante / 3600;
        int minutos = (tiempoRestante % 3600) / 60;
        int segundos = tiempoRestante % 60;
        Token.Labels(Token.jLabel5,String.format("%02d : %02d : %02d", horas ,minutos, segundos));//etiqueta jlabel
    }
    public static void detener(){
        timer.stop();
    }
    private static boolean Crear_y_Enviar_Mensaje(String username, String password, String destinatario, String asunto, String token){
        // Configuración de propiedades
        boolean mensaje_enviado = false;
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587"); // Puerto SMTP de Gmail

        // Creación de la sesión
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Creación del mensaje
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username)); // Remitente
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario)); // Destinatario
            message.setSubject(asunto); // Asunto
            String Contenido_en_HTML = HTML(destinatario, token);
            message.setContent(Contenido_en_HTML, "text/html");
            
            // Envío del mensaje
            Transport.send(message);
            mensaje_enviado = true;

        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return mensaje_enviado;
    }
    private static String HTML(String usuario, String token){
         String codigo ="<html>" +
            "<head>" +
                 "<style>body{" +
                    "background-color: white;" +
                    "}" +
                    ".titulo{" +
                    "text-transform: uppercase;"+
                    "font-family: Georgia, 'Times New Roman', Times, serif;" +
                    "color: BLUE;" +
                    "font-size: 22px;" +
                    "text-align: center;" +
                    "}" +
                    ".codigo{ " +
                    "color: rgb(5, 44, 243); font-size: 24px; " +
                    "font-family: Georgia, 'Times New Roman', Times, serif;" +
                    "text-align: center;"+
                    "font-size: 19px;"+
                    "}" +
                    "p { " +
                    "font-family: Georgia, 'Times New Roman', Times, serif;" +
                    "color: BLACK; " +
                    "font-size: 16px; " +
                    "text-align: center;" +
                    "}" +
                    ".pie_ppajina{" +
                    "position: relative;" +
                    "top: 100px;" +
                    "}" +
                    ".contenedor{" +
                    "top: 100px;" +
                    "max-width: 500px;" +
                    "padding: 50px;" +
                    "margin: 0 auto;" +
                    "background-color: rgb(238, 238, 238);" +
                    "border-radius: 2px;" +
                    "position: relative;" +
                    "border-color: black;" +
                    "border-style: solid;" +
                    "border-width: 1px;" +
                    "}</style>"+
            "</head>" +
            "<body>" +
            "<div class=contenedor>" +
            "<h1 class= 'titulo' >Codigo de recuperación de cuenta</h1>" +
            "<p>!Hola¡ "+usuario+ ". Hemos recibido tu petición de recuperación de cuenta. Este es tu código de recuperación de cuenta.</p>" +
            "<h1 class= 'codigo' >"+token+
            "</h1>" +
            "<p>Si no utilizas este código dentro de 24 horas caducará. Recuerda no compartirlo con nadie.</p>" +
            "</div>" +
            "<p class=pie_ppajina> Si no fuiste tú quien realizó la petición de este mensaje, ignóralo</p>" +
            "</body>" +
            "</html>";
         return codigo;
    }
}
