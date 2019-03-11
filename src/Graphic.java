
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Graphic extends JPanel implements KeyListener, ActionListener {

    private BufferedImage heart, reward, darth, luke, master, kylo, stormtrooper, right, left, up, down;
    Timer timer = new Timer(100, this);

    public int choosenCharacterX = 306;
    public int choosenCharacterY = 336;
    public int moveX = 40;
    public String[] grphcDoors = new String[20];
    public String choosenCharacter;
    public int[][] grphcMap = new int[11][14];
    int i;

    // Location lokas = new Location();
    ArrayList<Character> grphcChr = new ArrayList<Character>();

    /*arraylistin lastindexindeki karakter daima iyi karakter olacaktir. Cunku
     txt okumadan sonra iyi karakter secimi yapiyoruz. Grap[hic kutuphanesi icin
     kullanilacagi zaman bu sira goz onunde tutulmalidir*/
    public Graphic() {
        try {
            heart = ImageIO.read(new FileImageInputStream(new File("heart.png")));
            darth = ImageIO.read(new FileImageInputStream(new File("darth.png")));
            luke = ImageIO.read(new FileImageInputStream(new File("luke.png")));
            master = ImageIO.read(new FileImageInputStream(new File("master.png")));
            reward = ImageIO.read(new FileImageInputStream(new File("reward.png")));
            kylo = ImageIO.read(new FileImageInputStream(new File("kylo.png")));
            stormtrooper = ImageIO.read(new FileImageInputStream(new File("stormtrooper.png")));
            right = ImageIO.read(new FileImageInputStream(new File("right.png")));
            left = ImageIO.read(new FileImageInputStream(new File("left.png")));
            up = ImageIO.read(new FileImageInputStream(new File("up.png")));
            down = ImageIO.read(new FileImageInputStream(new File("down.png")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        setBackground(Color.black);

        timer.start();
    }

    @Override
    public void paint(Graphics g) {

        super.paint(g);

        int i, j, a;
        for (i = 0, a = 0; i < 3; a = a + 40, i++) {
            g.drawImage(heart, 520 + a, 20, heart.getWidth() / 15, heart.getHeight() / 15, this);
        }

        for (j = 0, a = 0; j < 15; a = a + 40, j++) {
            g.setColor(Color.black);
            g.drawLine(60 + a, 130, 60 + a, 570);
        }

        for (i = 0, a = 0; i < 12; a = a + 40, i++) {
            g.drawLine(60, 130 + a, 620, 130 + a);
        }

        Font font = new Font("Tahoma", Font.CENTER_BASELINE, 12);

        g.setFont(font);

        int locationValues = 0;//matris'i koordinat sistemi gibi kullanaca˝m˝z iÁin say˝land˝rma yapt˝k 
        String sLocationValues; //integer olan locationValues'u stringe Áevirip bast˝rmak iÁin
        for (i = 0; i < 521; i += 40) {
            sLocationValues = String.valueOf(locationValues); //int degeri ekrana basabilmek icin stringe cevirdik
            g.drawString(sLocationValues, i + 75, 590); //y sabit x artarak ekrana basiliyor(matrisin x-ekseni)
            // g.drawString(sLocationValues, 45, i + 30); //matrisin y-ekseni
            locationValues++;
        }
        locationValues = 0;
        for (i = 0; i < 401; i += 40) {
            sLocationValues = String.valueOf(locationValues); //int degeri ekrana basabilmek icin stringe cevirdik
            g.drawString(sLocationValues, 45, i + 155); //matrisin y-ekseni
            locationValues++;
        }
        g.setColor(Color.white);
        g.drawString("Canlar", 475, 40);

        g.setColor(Color.GRAY);

        int y = 0;
        for (i = 0; i < 11; i++) {
            for (j = 0; j < 14; j++) {
                if (grphcMap[i][j] == 0) {
                    g.fillRect(60 + (j * 40), 130 + y, 40, 40);
                }
            }
            y += 40;
        }

        g.setColor(Color.CYAN);
        g.fillRect(220, 130, 40, 40); //Door B
        g.fillRect(540, 130, 40, 40); //Door C
        g.fillRect(60, 330, 40, 40);  //Door A
        g.fillRect(220, 530, 40, 40); //Door E
        g.fillRect(580, 330, 40, 40); //Door D
        g.setColor(Color.yellow);
        g.fillRect(300, 330, 40, 40); //Start point

        g.setColor(Color.black);
        g.drawString("B", 237, 153);
        g.drawString("C", 557, 153);
        g.drawString("A", 77, 353);
        g.drawString("E", 237, 553);
        g.drawString("D", 597, 353);

        /*Asagida grafikte bulunan kapi girisleri ve cikista yer alan odul sembolu kodlanmistir*/
        g.drawImage(reward, 620, 480, reward.getWidth() / 10, reward.getHeight() / 10, this);
        g.drawImage(right, 5, 335, right.getWidth() / 7, right.getHeight() / 7, this);
        g.drawImage(left, 625, 315, left.getWidth() / 7, left.getHeight() / 7, this);
        g.drawImage(up, 225, 570, up.getWidth() / 7, up.getHeight() / 7, this);
        g.drawImage(down, 210, 80, down.getWidth() / 7, down.getHeight() / 7, this);
        g.drawImage(down, 530, 80, down.getWidth() / 7, down.getHeight() / 7, this);

        /*Kullanici tarafindan secilen iyi karakterin turune gore konumu kodlanmistir */
        if (choosenCharacter.equalsIgnoreCase("s")) {
            g.drawImage(luke, choosenCharacterX, choosenCharacterY, luke.getWidth() / 15, luke.getHeight() / 15, this);
        } else if (choosenCharacter.equalsIgnoreCase("m")) {
            g.drawImage(master, choosenCharacterX, choosenCharacterY, master.getWidth() / 15, master.getHeight() / 15, this);
        }

        /*harita.txt den alinan bilgilere gore kotu karakterlerin turune ve sayisine gore konumlari kodlanmistir*/
        for (i = 0; i < grphcChr.size() - 1; i++) {

            if (grphcChr.get(i).getName().contains("DarthVader")) {
                if (grphcDoors[i].equalsIgnoreCase("A")) {
                    g.drawImage(darth, 68, 335, darth.getWidth() / 15, darth.getHeight() / 15, this);
                } else if (grphcDoors[i].equalsIgnoreCase("B")) {
                    g.drawImage(darth, 230, 138, darth.getWidth() / 15, darth.getHeight() / 15, this);
                } else if (grphcDoors[i].equalsIgnoreCase("C")) {
                    g.drawImage(darth, 545, 138, darth.getWidth() / 15, darth.getHeight() / 15, this);
                } else if (grphcDoors[i].equalsIgnoreCase("D")) {
                    g.drawImage(darth, 585, 335, darth.getWidth() / 15, darth.getHeight() / 15, this);
                } else if (grphcDoors[i].equalsIgnoreCase("E")) {
                    g.drawImage(darth, 230, 535, darth.getWidth() / 15, darth.getHeight() / 15, this);
                }
            } else if (grphcChr.get(i).getName().contains("Stormtrooper")) {
                if (grphcDoors[i].equalsIgnoreCase("A")) {
                    g.drawImage(stormtrooper, 68, 335, stormtrooper.getWidth() / 15, stormtrooper.getHeight() / 15, this);
                } else if (grphcDoors[i].equalsIgnoreCase("B")) {
                    g.drawImage(stormtrooper, 230, 138, stormtrooper.getWidth() / 15, stormtrooper.getHeight() / 15, this);
                } else if (grphcDoors[i].equalsIgnoreCase("C")) {
                    g.drawImage(stormtrooper, 545, 138, stormtrooper.getWidth() / 15, stormtrooper.getHeight() / 15, this);
                } else if (grphcDoors[i].equalsIgnoreCase("D")) {
                    g.drawImage(stormtrooper, 585, 335, stormtrooper.getWidth() / 15, stormtrooper.getHeight() / 15, this);
                } else if (grphcDoors[i].equalsIgnoreCase("E")) {
                    g.drawImage(stormtrooper, 230, 535, stormtrooper.getWidth() / 15, stormtrooper.getHeight() / 15, this);
                }
            } else if (grphcChr.get(i).getName().contains("KyloRen")) {
                if (grphcDoors[i].equalsIgnoreCase("A")) {
                    g.drawImage(kylo, 68, 335, kylo.getWidth() / 15, kylo.getHeight() / 15, this);
                } else if (grphcDoors[i].equalsIgnoreCase("B")) {
                    g.drawImage(kylo, 230, 138, kylo.getWidth() / 15, kylo.getHeight() / 15, this);
                } else if (grphcDoors[i].equalsIgnoreCase("C")) {
                    g.drawImage(kylo, 545, 138, kylo.getWidth() / 15, kylo.getHeight() / 15, this);
                } else if (grphcDoors[i].equalsIgnoreCase("D")) {
                    g.drawImage(kylo, 585, 335, kylo.getWidth() / 15, kylo.getHeight() / 15, this);
                } else if (grphcDoors[i].equalsIgnoreCase("E")) {
                    g.drawImage(kylo, 230, 535, kylo.getWidth() / 15, kylo.getHeight() / 15, this);
                }
            }

        }
    }

    @Override
    public void repaint() {

        super.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        repaint();

    }

    @Override
    public void keyPressed(KeyEvent e) {
/*Bu fonksiyon blogunda her bir tusa basildiginda matrise gore ve kordinat sistemine gore 
        konumlari yeniden set eder. Istenilen harekete gore (sol,sag,yukari,asagi) bulundugu
        konumun bir sonraki halinin matriste 0'a mi, 1'e mi denk geldigine bakar boylece 0 olan
        yerlere ilerleyemez. Unutulmamalidir ki kordinat sistemi duzeni ile matris sistemi duzeni
        birbirinden farkli duzenlendir bu yuzden xAxis ve yAxis kordinat duzlemindeki hareketi temsil
        ederken, matrisRow ve matrisCol matris uzerideki hareketi temsil eder.*/
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            if (choosenCharacterX <= 60) {
                choosenCharacterX = 60;

            } else {

                if (grphcMap[grphcChr.get(2).getLocation().matrixRow][grphcChr.get(2).getLocation().matrixCol - 1] == 0) {/*5,6 sola gidince 5,5 sola gidince 5,4 */
                    System.out.println("grphcChr" + "[" + (grphcChr.get(2).getLocation().matrixRow) + "] [" + (grphcChr.get(2).getLocation().matrixCol - 1) + "]");/*bu
                    satir matris uzerinde hangi hucrede olacagini-oldugunu verir*/
                    System.out.println(grphcMap[grphcChr.get(2).getLocation().matrixRow][grphcChr.get(2).getLocation().matrixCol - 1]);/*bu satir gidilmek istenen
                    hucrede 0 mi 1 mi oldugunu verir*/
                    choosenCharacterX -= 0;/*gidilecek noktada sifir var ise hareket etmemesini saglar*/
                } else {
                    choosenCharacterX -= moveX;
                    grphcChr.get(2).setLocation(grphcChr.get(2).getLocation().xAxis - 1, grphcChr.get(2).getLocation().yAxis);/*kordinat duzlemine gore sola hareket
                    edince x ekseninde azalma olur*/
                    grphcChr.get(2).setMatrix(grphcChr.get(2).getLocation().matrixRow, grphcChr.get(2).getLocation().matrixCol - 1);
                }
            }

        } else if (key == KeyEvent.VK_RIGHT) {
            if (choosenCharacterX >= 580) {
                choosenCharacterX = 580;
            } else {

                if (grphcMap[grphcChr.get(2).getLocation().matrixRow][grphcChr.get(2).getLocation().matrixCol + 1] == 0) {
                    System.out.println("grphcChr" + "[" + grphcChr.get(2).getLocation().matrixRow + "] [" + (grphcChr.get(2).getLocation().matrixCol + 1) + "]");
                    System.out.println(grphcMap[grphcChr.get(2).getLocation().matrixRow][grphcChr.get(2).getLocation().matrixCol + 1]);
                    choosenCharacterX += 0;
                } else {
                    choosenCharacterX += moveX;
                    grphcChr.get(2).setLocation(grphcChr.get(2).getLocation().xAxis + 1, grphcChr.get(2).getLocation().yAxis);
                    grphcChr.get(2).setMatrix(grphcChr.get(2).getLocation().matrixRow, grphcChr.get(2).getLocation().matrixCol + 1);
                }

            }
        } else if (key == KeyEvent.VK_UP) {

            if (choosenCharacterY <= 130) {
                choosenCharacterY = 130;
            } else {

                if (grphcMap[grphcChr.get(2).getLocation().matrixRow - 1][grphcChr.get(2).getLocation().matrixCol] == 0) {/*5,6 sola gidince 5,5 sola gidince 5,4 */
                    System.out.println("grphcChr" + "[" + (grphcChr.get(2).getLocation().matrixRow - 1) + "] [" + (grphcChr.get(2).getLocation().matrixCol) + "]");/*bu
                    satir matris uzerinde hangi hucrede olacagini-oldugunu verir*/
                    System.out.println(grphcMap[grphcChr.get(2).getLocation().matrixRow - 1][grphcChr.get(2).getLocation().matrixCol]);/*bu satir gidilmek istenen
                    hucrede 0 mi 1 mi oldugunu verir*/
                    choosenCharacterY -= 0;/*gidilecek noktada sifir var ise hareket etmemesini saglar*/
                } else {
                    choosenCharacterY -= moveX;
                    grphcChr.get(2).setLocation(grphcChr.get(2).getLocation().xAxis, grphcChr.get(2).getLocation().yAxis - 1);
                    grphcChr.get(2).setMatrix(grphcChr.get(2).getLocation().matrixRow - 1, grphcChr.get(2).getLocation().matrixCol);
                }

            }
        } else if (key == KeyEvent.VK_DOWN) {
            if (choosenCharacterY >= 540) {
                choosenCharacterY = 540;
            } else {

                if (grphcMap[grphcChr.get(2).getLocation().matrixRow + 1][grphcChr.get(2).getLocation().matrixCol] == 0) {/*5,6 sola gidince 5,5 sola gidince 5,4 */
                    System.out.println("grphcChr" + "[" + (grphcChr.get(2).getLocation().matrixRow + 1) + "] [" + (grphcChr.get(2).getLocation().matrixCol) + "]");/*bu
                    satir matris uzerinde hangi hucrede olacagini-oldugunu verir*/
                    System.out.println(grphcMap[grphcChr.get(2).getLocation().matrixRow + 1][grphcChr.get(2).getLocation().matrixCol]);/*bu satir gidilmek istenen
                    hucrede 0 mi 1 mi oldugunu verir*/
                    choosenCharacterY += 0;/*gidilecek noktada sifir var ise hareket etmemesini saglar*/
                } else {
                    choosenCharacterY += moveX;
                    grphcChr.get(2).setLocation(grphcChr.get(2).getLocation().xAxis, grphcChr.get(2).getLocation().yAxis + 1);
                    grphcChr.get(2).setMatrix(grphcChr.get(2).getLocation().matrixRow + 1, grphcChr.get(2).getLocation().matrixCol);
                }
            }
        }
        grphcChr.get(2).getLocation();
        grphcChr.get(2).printLocation();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

}
