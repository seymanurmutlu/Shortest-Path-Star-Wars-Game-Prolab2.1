
import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;

public class starWarsProject extends JFrame {

    public starWarsProject(String title) throws HeadlessException {
        super(title);

    }

    public static ArrayList<Character> chr = new ArrayList<Character>();

    /*karakterlerin tutulacagi
    arraylist, bu vectorun lastindexindeki karakter daima iyi karakter olacaktir. Cunku
    txt okumadan sonra iyi karakter secimi yapiyoruz. Grap[hic kutuphanesi icin
    kullanilacagi zaman bu sira goz onunde tutulmalidir*/
    public ArrayList<Character> getCharacters() {
        return starWarsProject.chr;
    }

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        File harita = new File("harita.txt");
        int row = 0, i, j = 0;
        byte stormtrooperNum = 0, darthVaderNum = 0, kyloRenNum = 0;
        int[][] map = new int[11][14];
        String[] output = null;
        String[] doors = new String[20];
        /*kotu karakterlerin girecegi kapilar icin dizi olusturuldu*/

//        Location place = new Location();
        if (!harita.exists()) {
            System.out.println(harita.getName() + " adli dosya bulunamadi.");
            System.exit(0);
        }

        BufferedReader reader = null;
        /*satirlari okumak icin olusturuldu*/
        FileReader forMap = null;

        try {
            reader = new BufferedReader(new FileReader(harita));
            forMap = new FileReader("harita.txt");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(starWarsProject.class.getName()).log(Level.SEVERE, null, ex);
        }

        String line = reader.readLine();/*satiri okumak icin tutulacak degisken */

        while (!(line.startsWith("0") || line.startsWith("1"))) {
            /*bu while blogu 
            icerisinde txtden karakterleri okuma ve uygun nesneleri olusturma
            islemi yapilir*/
 /*harita kodu basladiginda satir basinda 1 veya 0 bulunacagi icin 
            bu yontemi kullandik txt icerisinde basi 0 veya 1 le baslayan satir varsa
            okuma islemi durur*/

            if (line.length() > 0) {
                row++;
                output = line.split("[,:]");/*string parse etme islemleri*/
                System.out.println(output[1]);/*karakter adini verir*/
                System.out.println(output[3]);/*kapi bilgisini verir*/
                doors[row - 1] = output[3];

                if (output[1].equalsIgnoreCase("stormtrooper")) {
                    chr.add(new Stormtrooper("Stormtrooper" + stormtrooperNum, "kotu"));
                    stormtrooperNum++;

                } else if (output[1].equalsIgnoreCase("darth vader")) {
                    chr.add(new DarthVader("DarthVader" + darthVaderNum, "kotu"));
                    darthVaderNum++;

                } else if (output[1].equalsIgnoreCase("kylo ren")) {
                    chr.add(new KyloRen("KyloRen" + kyloRenNum, "kotu"));
                    kyloRenNum++;
                }
            }
            line = reader.readLine();
        }

        try {

            int value, say = 1;
            /*sutun sayilarini hesaplamak icin say degiskeni atandi*/
            i = 0;
            while ((value = forMap.read()) != -1) {
                /*value dosyadan okunan char degeridir.Value,dosyanin sonuna gelince -1 olur*/

                if (value == '0' || value == '1') /*harita bilgisinden onceki verileri kullanmamak icin boyle bir kosul yerlestirdik*/ {
                    //System.out.print((char)value+"\t"); SILINECEK
                    if (value == 48) /*value integer bir deger oldugu icin char okurken onun ascII tablosundaki degerini gosterir*/ {
                        map[i][j] = 0;
                        /*ascII tablosuna gore 0 sayisi 48 e esit gelir ve okunan degeri map dizisine atadik*/
                    } else {
                        map[i][j] = 1;/*ascII tablosuna gore 1 sayisi 49 e esit gelir ve okunan degeri map dizisine atadik*/
                    }

                    say++;
                    /*sutun sayisini arttirdik*/
                    j++;
                    if (say == 15) {
                        //System.out.println();  SILINECEK
                        say = 1;
                        j = 0;
                        /*map dizisinde sutun degerini gosteren j degiskenini sifirladik*/
                        i++;
                        /*map dizisinde satir sayisinin degerini gosteren i degiskenini arttirdik*/
                    }
                }

            }
        } finally {
            forMap.close();
            /*haritayi okumak icin acilan dosya kapatildi*/
        }

        /*haritanin konum bilgileri ekrana basildi  SILINECEK*/
        for (i = 0; i < 11; i++) {
            for (j = 0; j < 14; j++) {
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }
//               	// input maze
//		int[][] mat =
//		{
//			{ 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 },
//			{ 0, 1, 1, 1, 1, 1, 0, 1, 0, 1 },
//			{ 0, 0, 1, 0, 1, 1, 1, 0, 0, 1 },
//			{ 1, 0, 1, 1, 1, 0, 1, 1, 0, 1 },
//			{ 0, 0, 0, 1, 0, 0, 0, 1, 0, 1 },
//			{ 1, 0, 1, 1, 1, 0, 0, 1, 1, 0 },
//			{ 0, 0, 0, 0, 1, 0, 0, 1, 0, 1 },
//			{ 0, 1, 1, 1, 1, 1, 1, 1, 0, 0 },
//			{ 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 },
//			{ 0, 0, 1, 0, 0, 1, 1, 0, 0, 1 },
//		};

        System.out.println("\ngecici satir " + row);
        /*SILINECEK*/

        System.out.println("KARAKTERLER:\nMaster Yoda'nin canlari yarim gider.MASTER YODA ICIN M HAFINE BASIN\nLuke Skywalker'ın ekstra özelliği yoktur.LUKE SKYWALKER ICIN S HAFINE BASIN");
        System.out.println("\nKARAKTERINI SEC VE BASLA !\nSECIM:");
        String gamerchr = input.nextLine();

        if (gamerchr.equalsIgnoreCase("m")) {
            chr.add(new MasterYoda("MasterYoda", "Iyi"));
        } else if (gamerchr.equalsIgnoreCase("s")) {
            chr.add(new LukeSkywalker("LukeSkywalker", "Iyi"));
        } else {
            while (!(gamerchr.equalsIgnoreCase("m") || gamerchr.equalsIgnoreCase("s"))) {
                System.out.println("Lutfen S ya da M harfi giriniz!");
                gamerchr = input.nextLine();
                if (gamerchr.equalsIgnoreCase("m")) {
                    chr.add(new MasterYoda("MasterYoda", "Iyi"));
                } else if (gamerchr.equalsIgnoreCase("s")) {
                    chr.add(new LukeSkywalker("LukeSkywalker", "Iyi"));
                }
            }

        }

        Graphic graphic = new Graphic();
        /*grafik nesnesi olusturuldu*/
        graphic.grphcChr = chr;
        /*graphic classinin icindeki grphcChr arraylistine main içindeki arraylist atandi*/
        graphic.grphcMap = map;
        /*Graphic classina harita konum bilgilerini iceren map dizisi gonderildi*/

        
        
        starWarsProject screen = new starWarsProject("Star Wars");
        screen.setSize(700, 700);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Find shortest path from source (0, 0) to
        // destination (7, 5)
        chr.get(0).shortestPath(map, 0, 12, 5, 6);

        graphic.requestFocus();
        /*Klavyeden girdi alinacagi icin odagi graphic nesnesine verdik*/
        graphic.addKeyListener(graphic);
        /*Klavyeden gonderilen girdileri alir*/
        graphic.setFocusable(true);
        /*Odak graphic nesnesine verildi*/
        graphic.setFocusTraversalKeysEnabled(false);
        /*Klavye islemlerinnin gerceklesmesi icin yazildi*/

        // Find shortest path from source (0, 0) to
        // destination (7, 5)
        chr.get(0).shortestPath(map, 0, 12, 4, 6);

        screen.add(graphic);
        screen.setVisible(true);
        /*JFramemin gozukmesi icin girilmis bir komut*/
        screen.setResizable(true);
        /*Pencere boyutu degistirilebilir nitelikte olmasi icin yazildi*/

        graphic.choosenCharacter = gamerchr;
        /*kullanicinin sectigi iyi karakter Graphic classina atandi*/
        graphic.grphcDoors = doors;
        /*kotu karakterlerin oyuna girdigi kapilar Graphic classina atandi*/
    }
}
