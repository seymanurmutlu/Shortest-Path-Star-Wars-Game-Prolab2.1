
import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;


public class starWarsProject extends JFrame {

    public starWarsProject(String title) throws HeadlessException {
        super(title);

    }

    ArrayList<Character> chr = new ArrayList<>();
    
    public ArrayList<Character> getCharacters(){
            return this.chr;
        }
    
    
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        File harita = new File("harita.txt");
        int geciciSatir = 0;
        byte stormtrooperNum = 0,darthVaderNum = 0, kyloRenNum = 0;
        ArrayList<Character> chr = new ArrayList<Character>(); 
        /*karakterlerin tutulacagi
        arraylist, bu arraylist lastindexindeki karakter daima iyi karakter olacaktir. Cunku
        txt okumadan sonra iyi karakter secimi yapiyoruz. Grap[hic kutuphanesi icin
        kullanilacagi zaman bu sira goz onunde tutulmalidir*/
         
        if (!harita.exists()) {
            System.out.println(harita.getName() + " adli dosya bulunamadi.");
            System.exit(0);
        }

        BufferedReader reader = null; /*satirlari okumak icin olusturuldu*/  
        try {
            reader = new BufferedReader(new FileReader(harita));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(starWarsProject.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String line = reader.readLine();/*satiri okumak icin tutulacak degisken */
        
        while(!(line.startsWith("0") || line.startsWith("1")) ){ /*bu while blogu 
            icerisinde txtden karakterleri okuma ve uygun nesneleri olusturma
            islemi yapilir*/
            /*harita kodu basladiginda satir basinda 1 veya 0 bulunacagi icin 
            bu yontemi kullandik txt icerisinde basi 0 veya 1 le baslayan satir varsa
            okuma islemi durur*/
            if (line.length() > 0) {
                geciciSatir++;
                String[] output  = line.split("[,:]");/*string parse etme islemleri*/
                System.out.println(output[1]);/*karakter adini verir*/
                System.out.println(output[3]);/*karakter turunu verir*/
                if(output[1].equalsIgnoreCase("stormtrooper")){
                    chr.add(new Stormtrooper("Stormtrooper"+stormtrooperNum,"kotu"));
                    stormtrooperNum++;
                }
                else if(output[1].equalsIgnoreCase("darth vader")){
                    chr.add(new Stormtrooper("DarthVader"+darthVaderNum,"kotu"));
                    darthVaderNum++;
                }
                else if(output[1].equalsIgnoreCase("kylo ren")){
                    chr.add(new Stormtrooper("KyloRen"+kyloRenNum,"kotu"));
                    kyloRenNum++;
                }
            }
                line = reader.readLine();
        }
        System.out.println("gecici satir " +geciciSatir);

        System.out.println("KARAKTERLER:\nMaster Yoda'nin canlari yarim gider.MASTER YODA ICIN M HAFINE BASIN\nLuke Skywalker'ın ekstra özelliği yoktur.LUKE SKYWALKER ICIN S HAFINE BASIN");
        System.out.println("KARAKTERINI SEC VE BASLA !\nSECIM:");
        String gamerchr = input.nextLine();
        
            if(gamerchr.equalsIgnoreCase("m")){
                chr.add(new MasterYoda("MasterYoda","Iyi"));
            }else if(gamerchr.equalsIgnoreCase("s")){
                chr.add(new LukeSkywalker("LukeSkywalker","Iyi"));
            }else{
                System.out.println("Duzgun secim yap.");
            }
                
            
                

        
        
            starWarsProject screen = new starWarsProject("Star Wars");
            screen.setSize(700, 700);
            screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		
            Graphic graphic = new Graphic();
            graphic.requestFocus(); /*Klavyeden girdi alinacagi icin odagi graphic nesnesine verdik*/
            graphic.addKeyListener(graphic); /*Klavyeden gonderilen girdileri alir*/
            graphic.setFocusable(true);       /*Odak graphic nesnesine verildi*/
            graphic.setFocusTraversalKeysEnabled(false); /*Klavye islemlerinnin gerceklesmesi icin yazildi*/
            
            screen.add(graphic);
            screen.setVisible(true);   /*JFramemin gozukmesi icin girilmis bir komut*/
            screen.setResizable(true); /*Pencere boyutu degistirilebilir nitelikte olmasi icin yazildi*/
        
        
            System.out.println("dogru mu"+chr.size());

    }

}
