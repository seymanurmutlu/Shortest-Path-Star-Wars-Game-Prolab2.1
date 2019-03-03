
import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;

public class starWarsProject extends JFrame {

    public starWarsProject(String title) throws HeadlessException {
        super(title);

    }

    public static void main(String[] args) throws IOException {
        File harita = new File("harita.txt");
        int geciciSatir = 0;
                
                
        
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
        
        while(!(line.startsWith("0") || line.startsWith("1")) ){ 
            /*haritalamaya basladiginda satir basinda 1 veya 0 bulunacagi icin bu yontemi kullandik*/
            if (line.length() > 0) {
                geciciSatir++;
                String[] output  = line.split("[,:]");
                System.out.println(output[1]);/*karakter adi*/
                System.out.println(output[3]);/*karakter turu*/
            }
                line = reader.readLine();
        }
        System.out.println("gecici satir " +geciciSatir);

        
        
        
        starWarsProject screen = new starWarsProject("Star Wars");
        Graphic graphic = new Graphic();
        screen.setVisible(true);   //JFramemin gozukmesi icin girilmis bir komut
        screen.setResizable(true); //Pencere boyutu degistirilebilir nitelikte olmas˝ iÁin yazildi
        screen.setSize(700, 700);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen.add(graphic);

    }

}
