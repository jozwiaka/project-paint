package org.example;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

public class MyJPanel extends JPanel{
	  private List<ElementRysunku> lista = new ArrayList<>();
	    private Okno okno1;
	    private int count = 0;
	    
	    //kolo
	    Dimension srodek;int rTemp;
	    
	    //lamana
	    int x1,y1,x2Temp,y2Temp;
	    
	    //prostokat
	    int xA,yA,xCTemp,yCTemp;
	    
	    //bazgrol
	    int x,y;
	    public int siatkuj(int n, Okno okno)
	    {
	    	if(okno.siatkaWlaczona)
	    	{
	    	int i=(n/40);
	    	if(n<=(i*40+(i+1)*40)/2)
	    	{
	    		return i*40;
	    	}
	    	else return (i+1)*40;
	    	}
	    	return n;
	    }
	    public Dimension siatkuj(Dimension d, Okno okno)
	    {
	    	Dimension dS = new Dimension(siatkuj(d.width,okno),siatkuj(d.height,okno));
	    	return dS;
	    }
	   
	    
	    public MyJPanel(Okno okno) {
	        okno1=okno;
	        srodek=new Dimension();
	        rTemp=0;
	        x1=0;y1=0;x2Temp=0;y2Temp=0;
	        xA=0;yA=0;xCTemp=0;yCTemp=0;
		addMouseListener( new MouseAdapter() {

			public void mousePressed(MouseEvent e) {
				if(okno1.getTryb()==0)
				{
					srodek = new Dimension( e.getX(), e.getY() );
				}
				if(okno1.getTryb()==1)
				{
					xA=e.getX();
					yA=e.getY();
				}
				if(okno1.getTryb()==2)
				{
					srodek = new Dimension( e.getX(), e.getY() );
				}
				repaint();
			}

			public void mouseReleased(MouseEvent e) {
				if(okno1.getTryb()==0)
				{
					int r = (int)Math.sqrt( (e.getX()-
							srodek.width)*(e.getX()-srodek.width) + 
							(e.getY()-srodek.height)*(e.getY()-srodek.height) );
					System.out.println("Kolo: srodek=("+srodek.width+","+srodek.height+")"+"; promien="+r);
					lista.add( new Kolo(siatkuj(srodek,okno1), siatkuj(r,okno1),okno1.bColors[okno1.kolor].getBackground()));
					srodek = null;
					rTemp = 2;
				}
				if(okno1.getTryb()==1)
				{
					int xC =e.getX();
					int yC =e.getY();
					System.out.println("Kwadrat: "+Math.abs(xA-xC)+"x"+Math.abs(yA-yC));
					lista.add(new Prostokat(siatkuj(xA,okno1),siatkuj(yA,okno1),siatkuj(xC,okno1),siatkuj(yC,okno1),okno1.bColors[okno1.kolor].getBackground()));
					xA=0; yA=0;
				}
				if(okno1.getTryb()==2)
				{
					int r = (int)Math.sqrt( (e.getX()-
							srodek.width)*(e.getX()-srodek.width) + 
							(e.getY()-srodek.height)*(e.getY()-srodek.height) );
					System.out.println("Elipsa: srodek=("+srodek.width+","+srodek.height+")"+"; promienX="+r+"; promienY="+r/2);
					lista.add( new Elipsa( siatkuj(srodek,okno1), siatkuj(r,okno1),okno1.bColors[okno1.kolor].getBackground() ));
					srodek = null;
					rTemp = 2;
				}
				repaint();
			}
			public void mouseClicked(MouseEvent e) {
				if(okno1.getTryb()==3) {

                if(e.getButton() == MouseEvent.BUTTON3)
                	{
                		x1=0;
                		y1=0;
                		
                		repaint();
                		return;
                	}
                count++;
                if(count==1)
                {
                    if(x1!=0&&y1!=0){count++;}
                    else 
                    {
	                    x1=e.getX(); 
	                    y1=e.getY();
                    }
                }
                if(count==2)
                {
	                int x2=e.getX(); int y2=e.getY();
	                System.out.println("Lamana: p1=("+x1+","+y1+"); p2=("+x2+","+y2+")");
	                lista.add(new Lamana(siatkuj(x1,okno1),siatkuj(y1,okno1),siatkuj(x2,okno1),siatkuj(y2,okno1),okno1.bColors[okno1.kolor].getBackground()));
	                count = 0;
	                x1=x2;y1=y2;
                }
                repaint();
				}
            }

		} );
		addMouseMotionListener( new MouseAdapter() {
			
			public void mouseDragged(MouseEvent e)
			{
				if(okno1.getTryb()==0)
				{
				rTemp = (int)Math.sqrt( (e.getX()-
						srodek.width)*(e.getX()-srodek.width) + 
						(e.getY()-srodek.height)*(e.getY()-srodek.height) );
				}
				if(okno1.getTryb()==1)
				{
				xCTemp =e.getX();
				yCTemp =e.getY();
				}
				if(okno1.getTryb()==2)
				{
				rTemp = (int)Math.sqrt( (e.getX()-
						srodek.width)*(e.getX()-srodek.width) + 
						(e.getY()-srodek.height)*(e.getY()-srodek.height) );
				}
				if(okno1.getTryb()==4)
				{
					lista.add(new Bazgrol(e.getX(),e.getY(),okno1.bColors[okno1.kolor].getBackground()));
				}
				repaint();
				
			}
			public void mouseMoved(MouseEvent e)
            {
				if(okno1.getTryb()==3)
				{
	                x2Temp=e.getX(); y2Temp=e.getY();
	                repaint();
                }
            }
		});
	}

	    @Override
	    public void paintComponent(Graphics g)
	    {
	        super.paintComponent(g);
	        Graphics2D g2d = (Graphics2D)g;
	        g.setColor( Color.gray );
	        g2d.setStroke(new BasicStroke(2));
	        
				if(okno1.siatkaWlaczona)
		    	{
		    		Graphics2D g2d1 = (Graphics2D)g;
		    		int j=0;
		    		int k=0;
		    		g.setColor(Color.lightGray);
		    		for(int i = 0;i<100;i++)
		    		{	j=j+40;
		    		g2d1.drawLine(j,0,j, 10000);
		    		}
		    		g.setColor(Color.lightGray);
		    		for(int i = 0;i<100;i++)
		    		{	k=k+40;
		    		g2d1.drawLine(0,k,10000,k);
		    		}
		    		g.setColor(Color.gray);
		    	}   
	            //kolo
	            if(okno1.getTryb()==0)
	            {
	                if (srodek != null)
	                {
	                	srodek=siatkuj(srodek,okno1);
	                    int x = srodek.width;
	                    int y = srodek.height;
	                    int r = siatkuj(rTemp,okno1);
	                    g2d.drawOval(x-r,y-r,2*r,2*r);
	                }
	            }
	            //prostokat
	            if(okno1.getTryb()==1)
	            {
	            	if(xA != 0 && yA !=0)
	                {
	                    g2d.drawRect(siatkuj(xA,okno1),siatkuj(yA,okno1),siatkuj(Math.abs(xCTemp-xA),okno1),siatkuj(Math.abs(yCTemp-yA),okno1));
	                }   
	            }
	            //elipsa
	            if(okno1.getTryb()==2)
	            {
	            	if (srodek != null)
	                {
	                    int x = siatkuj(srodek.width,okno1);
	                    int y = siatkuj(srodek.height,okno1);
	                    int r = siatkuj(rTemp,okno1);
	                    g2d.drawOval(x-r,y-r/2,2*r,2*r/2);
	                }
	            }
	            //lamana
	            if(okno1.getTryb()==3)
	            {
	                if(x1 != 0 && y1 !=0)
	                {
	                    
	                    g2d.drawLine(siatkuj(x1,okno1),siatkuj(y1,okno1),siatkuj(x2Temp,okno1),siatkuj(y2Temp,okno1));
	                    
	                }   
	            }
	            //bazgrol
	            if(okno1.getTryb()==4)
	            {
	            
	            }
	    repaint();
	        for (ElementRysunku e:lista)
	        {
	            e.rysuj(g);
	        }
	    }
	}