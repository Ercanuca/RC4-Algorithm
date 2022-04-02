/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rc4;
import java.io.DataInputStream;
import java.io.IOException;




class RC4{

    static  String show(int d[]){
    String me = "";
    for(int l=0;l<d.length;l++){
        me += (char)d[l];
    }
        return (me);
    }
/**
 *
 * @author ercan
 */
 public static int [] Rc4(String key, String entry){
        int temp=0;  
        
        int s[]=new int[256]; //Bilgimiz için 0 255 arası dizi 
        int k[]=new int[256]; // Anahtarımız için 0 255 arası dizi    
        
        char entryc[]=entry.toCharArray();
        char keyc[]=key.toCharArray();    
        
        int cipher[]=new int[entry.length()]; 
      
         
        int entryi[]=new int[entry.length()];  
        int keyi[]= new int[entry.length()];
        
        for(int i=0;i<entry.length();i++){
        
        entryi[i]=(int)entryc[i]; 
        
        }
        for(int i=0;i<key.length();i++){
        keyi[i]=(int)keyc[i];  
        }
        
       for(int i=0;i<255;i++){
       s[i]=i;  
       k[i]=keyi[i%key.length()]; 
       }
       int j=0;
       for(int i=0;i<255;i++){
       j=(j+s[i]+k[i])%256; 
       temp=s[i];
       s[i]=s[j];
       s[j]=temp;
       }
        
       int i=0;
           j=0;
       int z=0;
       
       for(int l=0;l<entry.length();l++){
       i=(l+1)%256; // burda ise  l den bir fazlasını alıp mod 255 yapıp i'ye atıyor
       j=(j+s[i])%256; 
       //  yer değiştirme
       temp=s[i];  
        s[i]=s[j];
       s[j]=temp;
       z=s[(s[i]+s[j])%256]; 
       cipher[l]=z^entryi[l]; //  şifreli metni elde ediyor
    }
       return cipher;
    }
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
    String anahtar,metin;
       
        DataInputStream in=new DataInputStream(System.in); 
        System.out.println("Girilecek Bilgi:");
        metin=in.readLine();
        System.out.println("\nAnahtarı Girin:");
        anahtar=in.readLine();

        int [] sonuc = Rc4(anahtar, metin);
        System.out.print("\nŞifrelenmiş Hali:\n");
        
        String plainText = show(sonuc);
        System.out.println(plainText);
        
     //  anahtar = "Selim";
        int [] cSonuc = Rc4(anahtar, plainText);
        System.out.print("\nÇözülmüş Hali:\n");
        
        String chipterText = show(cSonuc);
        System.out.println(chipterText); }
    
}
