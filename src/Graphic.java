
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.JPanel;

public class Graphic extends JPanel {
	
	private BufferedImage heart;
	private BufferedImage reward;
	
	public Graphic()
	{
		try {
                    heart=ImageIO.read(new FileImageInputStream(new File("heart.png")));
                    reward=ImageIO.read(new FileImageInputStream(new File("reward.png")));
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		setBackground(Color.black);
	}

	@Override
	public void paint(Graphics g) {
		
		super.paint(g);
		
                g.drawImage(reward, 630, 480, reward.getWidth()/10, reward.getHeight()/10, this);
                
		int i,j,a;
		for(i=0,a=0;i<3;a=a+40,i++)
		{
			g.drawImage(heart,520+a,20,heart.getWidth()/15,heart.getHeight()/15,this);
		}
		    
		      for(j=0,a=0;j<15;a=a+40,j++)
			{
				g.setColor(Color.black);
				g.drawLine(60+a, 130, 60+a, 570);
			}
		
			for(i=0,a=0;i<12;a=a+40,i++)
			{
				g.drawLine(60, 130+a, 620, 130+a);
			}
		
  
	        Font font = new Font("Tahoma", Font.CENTER_BASELINE, 12);

	        g.setFont(font);

	        int locationValues = 0;//matris'i koordinat sistemi gibi kullanaca˝m˝z iÁin say˝land˝rma yapt˝k 
	        String sLocationValues; //integer olan locationValues'u stringe Áevirip bast˝rmak iÁin
	        for (i = 0; i < 521; i += 40)
	        {
	            sLocationValues = String.valueOf(locationValues); //int degeri ekrana basabilmek iÁin stringe Áevirdik
	            g.drawString(sLocationValues, i + 75, 590); //y sabit x artarak ekrana bas˝l˝yor(matrisin x-ekseni)
	           // g.drawString(sLocationValues, 45, i + 30); //matrisin y-ekseni
	            locationValues++; 
	        }
	        locationValues = 0;
	        for(i=0;i<401;i+=40)
	        {
	        	 sLocationValues = String.valueOf(locationValues); //int degeri ekrana basabilmek iÁin stringe Áevirdik
		         g.drawString(sLocationValues, 45, i+155); //matrisin y-ekseni
		         locationValues++;
	        }
            g.setColor(Color.white);
	        g.drawString("Canlar", 475, 40);
	        
	        // The painting process of the walls is coded row by line
	        // The painting process of the walls for first row
	        for(i=0,a=0;i<14;a+=40,i++)
	        {
	        	g.fillRect(60+a, 130, 40, 40);
	        	if(i==4 || i==12)
	        	{
	        		continue;
	        	}
	        }
	        
	        // The painting process of the walls for second row
	        for(i=0,a=0;i<14;a+=40,i++)
	        {
	        	if(i==0 || i==5 || i==13)
	        	{
	        		g.fillRect(60+a, 170, 40, 40);
	        	}
	        }
	        
	        // The painting process of the walls for third row
	        for(i=0,a=0;i<14;a+=40,i++)
	        {
	        	if(i==0 || i==2 || i==7 || i==9 || i==10 || i==11 || i==13)
	        	{
	        		g.fillRect(60+a, 210, 40, 40);
	        	}
	        }
	        
	        // The painting process of the walls for fourth row
	        for(i=0,a=0;i<14;a+=40,i++)
	        {
	           if(i==0 || i==2 || i==5 || i==7 || i==10 || i==13)
	        	{
	        		g.fillRect(60+a, 250, 40, 40);
	        	}
	        }
	        
	        // The painting process of the walls for fifth row
	        for(i=0,a=0;i<14;a+=40,i++)
	        {
	        	if(i==0 || i==2 || i==4 || i==5 || i==7 || i==10 || i==13)
	        	{
	        		g.fillRect(60+a, 290, 40, 40);
	        	}
	        } 	
	        
	        // The painting process of the walls for sixth row
	        for(i=0,a=0;i<14;a+=40,i++)
	        {
	        	if(i==2 || i==7 || i==9 || i==10 || i==11 || i==13)
	        	{
	        		g.fillRect(60+a, 330, 40, 40);
	        	}
	        }	
	        
	        // The painting process of the walls for seventh row
	        for(i=0,a=0;i<14;a+=40,i++)
	        {
	        	if(i==0 || i==2 || i==3 || i==5 || i==7 || i==9 || i==13)
	        	{
	        		g.fillRect(60+a, 370, 40, 40);
	        	}
	         }
	        
	        // The painting process of the walls for eighth row
	        for(i=0,a=0;i<14;a+=40,i++)
	        {
	        	if(i==0 || i==2 || i==9 || i==10 || i==11 || i==13)
	        	{
	        		g.fillRect(60+a, 410, 40, 40);
	        	}
	         }	
	       
	        // The painting process of the walls for ninth row
	        for(i=0,a=0;i<14;a+=40,i++)
	        {
	        	
	        	if(i==1 || i==3 || i==8 || i==11 || i==12)
	        	{
	        		continue;
	        	}
	        	g.fillRect(60+a, 450, 40, 40);
	        }
	        
	        // The painting process of the walls for tenth row
	        g.fillRect(60, 490, 40, 40);
	        
	        // The painting process of the walls for eleventh row
	        for(i=0,a=0;i<14;a+=40,i++)
	        {
	        	if(i==4)
	        	{
	        		continue;
	        	}
	        	g.fillRect(60+a, 530, 40, 40);
	        }
	       
	        g.setColor(Color.CYAN);
	        g.fillRect(220, 130, 40, 40); //Door B
	        g.fillRect(500, 130, 40, 40); //Door C
	        g.fillRect(60, 330, 40, 40);  //Door A
	        g.fillRect(220, 530, 40, 40); //Door E
	        g.fillRect(580, 330, 40, 40); //Door D
	        g.setColor(Color.yellow);
	        g.fillRect(300, 330, 40, 40); //Start point
	        
	        g.setColor(Color.black);
	        g.drawString("B", 237, 153);
	        g.drawString("C", 517, 153);
	        g.drawString("A", 77, 353);
	        g.drawString("E", 237, 553);
	        g.drawString("D", 597, 353);
		
	}

	
	@Override
	public void repaint() {
		
		super.repaint();
	}

}
