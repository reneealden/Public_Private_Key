/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lenovo
 */
public class main {
    public static void main(String[] args) throws Exception {
         
         
        //Definimos un texto a cifrar
        String str = "Este es el texto a cifrar";
         
        System.out.println("\nTexto a cifrar:");
        System.out.println(str);
         
        //Instanciamos la clase
        RSA rsa = new RSA();
         
        //Generamos un par de claves
        //Admite claves de 512, 1024, 2048 y 4096 bits
        rsa.genKeyPair(512);
         
         
        String file_private = "/tmp/rsa.pri";
        String file_public = "/tmp/rsa.pub";
         
        //Las guardamos asi podemos usarlas despues
        //a lo largo del tiempo
        rsa.saveToDiskPrivateKey("D://rsa.pri");
        rsa.saveToDiskPublicKey("D://rsa.pub");
         
        //Ciframos y e imprimimos, el texto cifrado
        //es devuelto en la variable secure
        String secure = rsa.Encrypt(str);
         
        System.out.println("\nCifrado:");
        System.out.println(secure);
         
                 
         
        //A modo de ejemplo creamos otra clase rsa
        RSA rsa2 = new RSA();
         
        //A diferencia de la anterior aca no creamos
        //un nuevo par de claves, sino que cargamos
        //el juego de claves que habiamos guadado
        rsa2.openFromDiskPrivateKey("D://rsa.pri");    
        rsa2.openFromDiskPublicKey("D://rsa.pub");
         
        //Le pasamos el texto cifrado (secure) y nos 
        //es devuelto el texto ya descifrado (unsecure) 
        String unsecure = rsa2.Decrypt(secure);
         
        //Imprimimos
        System.out.println("\nDescifrado:");
        System.out.println(unsecure);   
         
 
         
    }
}
