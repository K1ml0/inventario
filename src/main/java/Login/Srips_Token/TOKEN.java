/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Login.Srips_Token;
import Login.Token;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.InvalidKeyException;
import io.jsonwebtoken.security.Keys;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.SecretKey;
import javax.swing.JOptionPane;

/**
 *
 * @author JONATHAN ZULETA
 */
public class TOKEN {
    
    public static final String SECRET_KEY = "LLave de Recuperacón njjhhhhhhggbb";

    public static void main(String[] args) {
     
        
    }
    public static void verificador(){
        String tok = Token.jTextField2.getText();
        try{
            Jwts.parser()
                .verifyWith(generateKey())
                .build()
                .parseSignedClaims(tok)
                .getBody();
            
                JOptionPane.showMessageDialog(null, "Token correcto iniciando sesion..");
                inicio_vetana_cambiar_cuenta();
                
               
        }
        catch(ExpiredJwtException j){
             JOptionPane.showMessageDialog(null, j.getMessage(), "INCORRECTO TOKEN EXPIRADO", JOptionPane.ERROR_MESSAGE);
            
        }
        catch(JwtException | IllegalArgumentException e){
             System.out.println(e.getMessage());
             JOptionPane.showMessageDialog(null, e.getMessage(), "INCORRECTO", JOptionPane.ERROR_MESSAGE);
             
        }
    }
     public static String Llave(Map<String, Object> extraClaims) throws InvalidKeyException {
        Date issuedAt = new Date(System.currentTimeMillis());
        Date expiration = new Date(issuedAt.getTime() + ( 1* 2000 * 60 ));
        String jwt = Jwts.builder()
                
                .header()
                .type("JWT")
                .and()
                
                .subject("Jonathan")
                .expiration(expiration)
                .issuedAt(issuedAt)
                .claims(extraClaims)
                
                .signWith(generateKey(), Jwts.SIG.HS256)
                
                .compact();
        return jwt;
    }

    public static Map<String, Object> GetExtraClaims() {
        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("name", "Andres");
        return extraClaims;
    }
    
    public static SecretKey generateKey(){
            return Keys.hmacShaKeyFor(SECRET_KEY.getBytes()); 
        }
     public static void inicio_vetana_cambiar_cuenta(){
        Login.Token.jPanel1.setVisible(false);
        Login.Token.jPanel2.setVisible(false);
       
     
    }
}
