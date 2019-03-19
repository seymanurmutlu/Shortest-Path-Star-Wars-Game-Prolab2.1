
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
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Graphic extends JPanel implements KeyListener, ActionListener {

    private BufferedImage heart, reward, darth, luke, master, kylo, stormtrooper, right, left, up, down,win,gameover;
    Timer timer = new Timer(100, this);
    public int grphcDistance;
    public int choosenCharacterX = 306;
    public int choosenCharacterY = 336;
    public int moveX = 40;
    public String[] grphcDoors = new String[20];
    public String choosenCharacter;
    public int[][] grphcMap = new int[11][14];
    
   
    int i;
    int alpha = 70; 
    Color myColour0 = new Color(255, 20, 147, alpha);
    Color myColour1 = new Color(0, 255, 27, alpha);
    Color myColour2 = new Color(255, 0, 0, alpha);
    Queue<Location> copyQueue = new ArrayDeque<>();
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
            win = ImageIO.read(new FileImageInputStream(new File("win.png")));
            gameover = ImageIO.read(new FileImageInputStream(new File("gameover.png")));
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
      
   
        /*Kotu karakterlerin iyi karaktere olan en kisa yolu renklendirildi*/
        for (i = 0; i < grphcChr.size() - 1; i++) {
            for(j = 0 ; j < grphcChr.get(i).deneme.size(); j++){
                
                 if(grphcChr.get(i).getName().contains("DarthVader")) {
                	 g.setColor(myColour1);
                 }
                else if(grphcChr.get(i).getName().contains("Stormtrooper")) {
                	g.setColor(myColour2);
                }
                else if(grphcChr.get(i).getName().contains("KyloRen")){
                	g.setColor(myColour0);
                }
                 g.fillRect(60+(grphcChr.get(i).deneme.get(j).matrixCol)*40,130+(grphcChr.get(i).deneme.get(j).matrixRow)*40, 40, 40);
            }
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

            if (grphcChr.get(i).getName().contains("DarthVader")){
              g.drawImage(darth,65+(grphcChr.get(i).location.getMatrixCol())*40, 135+ (grphcChr.get(i).location.getMatrixRow()*40), darth.getWidth() / 15, darth.getHeight() / 15, this);
            }
            
            
            else if (grphcChr.get(i).getName().contains("Stormtrooper")) {
                g.drawImage(stormtrooper,65+(grphcChr.get(i).location.getMatrixCol())*40, 135+ (grphcChr.get(i).location.getMatrixRow()*40), stormtrooper.getWidth() / 15, stormtrooper.getHeight() / 15, this);
            } 
            
            
            else if (grphcChr.get(i).getName().contains("KyloRen")) {
               g.drawImage(kylo, 65+(grphcChr.get(i).location.getMatrixCol())*40, 135+ (grphcChr.get(i).location.getMatrixRow()*40), kylo.getWidth() / 15, kylo.getHeight() / 15, this);
            }

        }  
       
        /*iyi karakterin cani bittiginde oyunun bittigini ifade eder*/
		if(grphcChr.get(grphcChr.size()-1).getLives()==0){ 
			g.drawImage(gameover,0,65, gameover.getWidth(), gameover.getHeight(), this);
		}
		/*iyi karakter kupayi kazanmissa kullaniciya kazandigina dair bilgi verir*/
		if(choosenCharacterX>546){
			g.drawImage(win, 0, 65, win.getWidth(), win.getHeight(), this);
		}
		
		
        
    }

 
    public void go(Queue<Location> copyQueue, ArrayList<Character> grphcChr) {
    	
    	int i, m=0;
    	 try {
        for (i = 0; i < grphcChr.size()-1; i++) {
          	copyQueue = grphcChr.get(i).shortestPath(grphcMap, grphcChr.get(i).location.getMatrixRow(), grphcChr.get(i).location.getMatrixCol(), grphcChr.get(grphcChr.size() - 1).getLocation().matrixRow, grphcChr.get(grphcChr.size() - 1).getLocation().matrixCol);/*kotu karakter*/
            copyQueue.clear();  
            
         
          	/*	if(grphcChr.get(i).getName().contains("KyloRen"))
          	/	{    
          			System.out.print("dogru mu geliyor: "+grphcChr.get(i).deneme.get(m).matrixRow);
          			System.out.println(","+grphcChr.get(i).deneme.get(m).matrixCol);
          			grphcChr.get(i).location.setMatrixCol(grphcChr.get(i).deneme.get(m).matrixCol);
              		grphcChr.get(i).location.setMatrixRow(grphcChr.get(i).deneme.get(m).matrixRow);
              	    System.out.print(grphcChr.get(i).getName()+" "+"GITTIGI YER: "+grphcChr.get(i).location.getMatrixRow());
              	    System.out.println(","+grphcChr.get(i).location.getMatrixCol());
              	}*/
          		
          	//	else {
          			grphcChr.get(i).location.setMatrixCol(grphcChr.get(i).characterMoveX(grphcChr.get(i).location.getMatrixCol(),grphcChr.get(i).deneme.get(m).matrixCol));
              		grphcChr.get(i).location.setMatrixRow(grphcChr.get(i).characterMoveY(grphcChr.get(i).location.getMatrixRow(),grphcChr.get(i).deneme.get(m).matrixRow));
              	    System.out.print(grphcChr.get(i).getName()+" "+"GITTIGI YER: "+grphcChr.get(i).location.getMatrixRow());
             	    System.out.println(","+grphcChr.get(i).location.getMatrixCol());
          	//	}
           }
 			
 		} catch (IndexOutOfBoundsException e){
 			grphcChr.get(grphcChr.size()-1).setLives(grphcChr.get(grphcChr.size()-1).decreaseLives(grphcChr.get(grphcChr.size()-1).getLives()));
            System.out.println("\nKALAN CANINIZ: "+grphcChr.get(grphcChr.size()-1).getLives());
            
 			for(i=0;i<grphcChr.size()-1;i++)
 			{ 
 				grphcChr.get(i).location.setMatrixCol(grphcChr.get(i).startCol);
 				grphcChr.get(i).location.setMatrixRow(grphcChr.get(i).startRow);
 				grphcChr.get(i).setLocation(grphcChr.get(i).startCol,grphcChr.get(i).startRow);
 	 			grphcChr.get(i).setMatrix(grphcChr.get(i).startRow,grphcChr.get(i).startCol);
 	 		}
 			choosenCharacterX = 306;
 		    choosenCharacterY = 336;
 			grphcChr.get(grphcChr.size()-1).location.setxAxis(6);
 			grphcChr.get(grphcChr.size()-1).location.setyAxis(5);
 			grphcChr.get(grphcChr.size()-1).location.setMatrixCol(6);
 			grphcChr.get(grphcChr.size()-1).location.setMatrixRow(5);
 			grphcChr.get(grphcChr.size() - 1).setLocation(6,5);
 			grphcChr.get(grphcChr.size() - 1).setMatrix(5,6);
 		    grphcChr.get(grphcChr.size() - 1).getLocation();
 			
 			for(i=0;i<grphcChr.size()-1;i++)
 			{
 				copyQueue = grphcChr.get(i).shortestPath(grphcMap, grphcChr.get(i).location.getMatrixRow(), grphcChr.get(i).location.getMatrixCol(), grphcChr.get(grphcChr.size() - 1).getLocation().matrixRow, grphcChr.get(grphcChr.size() - 1).getLocation().matrixCol);/*kotu karakter*/
 	            copyQueue.clear();
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
 /*Sonradan eklenen ozellik; bu blokta her kotu karakter icin iyi karaktere olan en kisa mesafeyi hesaplar.*/

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            
        	if (choosenCharacterX <= 60) {
                choosenCharacterX = 60;

            } else {

                if (grphcMap[grphcChr.get(grphcChr.size() - 1).getLocation().matrixRow][grphcChr.get(grphcChr.size() - 1).getLocation().matrixCol - 1] == 0) {/*5,6 sola gidince 5,5 sola gidince 5,4 */
                    System.out.println("grphcChr" + "[" + (grphcChr.get(grphcChr.size() - 1).getLocation().matrixRow) + "] [" + (grphcChr.get(grphcChr.size() - 1).getLocation().matrixCol - 1) + "]");/*bu
                    satir matris uzerinde hangi hucrede olacagini-oldugunu verir*/
                    System.out.println(grphcMap[grphcChr.get(grphcChr.size() - 1).getLocation().matrixRow][grphcChr.get(grphcChr.size() - 1).getLocation().matrixCol - 1]);/*bu satir gidilmek istenen
                    hucrede 0 mi 1 mi oldugunu verir*/
                    choosenCharacterX -= 0;/*gidilecek noktada sifir var ise hareket etmemesini saglar*/
                } else {
                    choosenCharacterX -= moveX;
                    grphcChr.get(grphcChr.size() - 1).setLocation(grphcChr.get(grphcChr.size() - 1).getLocation().xAxis - 1, grphcChr.get(grphcChr.size() - 1).getLocation().yAxis);/*(iyi karakter)kordinat duzlemine gore sola hareket
                    edince x ekseninde azalma olur*/
                    grphcChr.get(grphcChr.size() - 1).setMatrix(grphcChr.get(grphcChr.size() - 1).getLocation().matrixRow, grphcChr.get(grphcChr.size() - 1).getLocation().matrixCol - 1);/*iyi karakter*/
                    
                    go(copyQueue, grphcChr);
                 }
            }

        } else if (key == KeyEvent.VK_RIGHT) {
            if (choosenCharacterX >= 580) {
                choosenCharacterX = 580;
            } else {

                if (grphcMap[grphcChr.get(grphcChr.size() - 1).getLocation().matrixRow][grphcChr.get(grphcChr.size() - 1).getLocation().matrixCol + 1] == 0) {
                    System.out.println("grphcChr" + "[" + grphcChr.get(grphcChr.size() - 1).getLocation().matrixRow + "] [" + (grphcChr.get(grphcChr.size() - 1).getLocation().matrixCol + 1) + "]");
                    System.out.println(grphcMap[grphcChr.get(grphcChr.size() - 1).getLocation().matrixRow][grphcChr.get(grphcChr.size() - 1).getLocation().matrixCol + 1]);
                    choosenCharacterX += 0;
                } else {
                    choosenCharacterX += moveX;
                    grphcChr.get(grphcChr.size() - 1).setLocation(grphcChr.get(grphcChr.size() - 1).getLocation().xAxis + 1, grphcChr.get(grphcChr.size() - 1).getLocation().yAxis);
                    grphcChr.get(grphcChr.size() - 1).setMatrix(grphcChr.get(grphcChr.size() - 1).getLocation().matrixRow, grphcChr.get(grphcChr.size() - 1).getLocation().matrixCol + 1);
                    go(copyQueue, grphcChr);
                }

            }
        } else if (key == KeyEvent.VK_UP) {

            if (choosenCharacterY <= 130) {
                choosenCharacterY = 130;
            } else {

                if (grphcMap[grphcChr.get(grphcChr.size() - 1).getLocation().matrixRow - 1][grphcChr.get(grphcChr.size() - 1).getLocation().matrixCol] == 0) {/*5,6 sola gidince 5,5 sola gidince 5,4 */
                    System.out.println("grphcChr" + "[" + (grphcChr.get(grphcChr.size() - 1).getLocation().matrixRow - 1) + "] [" + (grphcChr.get(grphcChr.size() - 1).getLocation().matrixCol) + "]");/*bu
                    satir matris uzerinde hangi hucrede olacagini-oldugunu verir*/
                    System.out.println(grphcMap[grphcChr.get(grphcChr.size() - 1).getLocation().matrixRow - 1][grphcChr.get(grphcChr.size() - 1).getLocation().matrixCol]);/*bu satir gidilmek istenen
                    hucrede 0 mi 1 mi oldugunu verir*/
                    choosenCharacterY -= 0;/*gidilecek noktada sifir var ise hareket etmemesini saglar*/
                } else {
                    choosenCharacterY -= moveX;
                    grphcChr.get(grphcChr.size() - 1).setLocation(grphcChr.get(grphcChr.size() - 1).getLocation().xAxis, grphcChr.get(grphcChr.size() - 1).getLocation().yAxis - 1);
                    grphcChr.get(grphcChr.size() - 1).setMatrix(grphcChr.get(grphcChr.size() - 1).getLocation().matrixRow - 1, grphcChr.get(grphcChr.size() - 1).getLocation().matrixCol);
                    go(copyQueue, grphcChr);

                }

            }
        } else if (key == KeyEvent.VK_DOWN) {
            if (choosenCharacterY >= 540) {
                choosenCharacterY = 540;
            } else {

                if (grphcMap[grphcChr.get(grphcChr.size() - 1).getLocation().matrixRow + 1][grphcChr.get(grphcChr.size() - 1).getLocation().matrixCol] == 0) {/*5,6 sola gidince 5,5 sola gidince 5,4 */
                    System.out.println("grphcChr" + "[" + (grphcChr.get(grphcChr.size() - 1).getLocation().matrixRow + 1) + "] [" + (grphcChr.get(grphcChr.size() - 1).getLocation().matrixCol) + "]");/*bu
                    satir matris uzerinde hangi hucrede olacagini-oldugunu verir*/
                    System.out.println(grphcMap[grphcChr.get(grphcChr.size() - 1).getLocation().matrixRow + 1][grphcChr.get(grphcChr.size() - 1).getLocation().matrixCol]);/*bu satir gidilmek istenen
                    hucrede 0 mi 1 mi oldugunu verir*/
                    choosenCharacterY += 0;/*gidilecek noktada sifir var ise hareket etmemesini saglar*/
                } else {
                    choosenCharacterY += moveX;
                    grphcChr.get(grphcChr.size() - 1).setLocation(grphcChr.get(grphcChr.size() - 1).getLocation().xAxis, grphcChr.get(grphcChr.size() - 1).getLocation().yAxis + 1);
                    grphcChr.get(grphcChr.size() - 1).setMatrix(grphcChr.get(grphcChr.size() - 1).getLocation().matrixRow + 1, grphcChr.get(grphcChr.size() - 1).getLocation().matrixCol);
                    go(copyQueue, grphcChr);
                }
            }
        }
       
        grphcChr.get(grphcChr.size() - 1).getLocation();
        grphcChr.get(grphcChr.size() - 1).printLocation();

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
     }

}