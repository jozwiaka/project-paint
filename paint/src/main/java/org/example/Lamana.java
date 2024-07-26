package org.example;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Lamana implements ElementRysunku{
	
	private int x1,y1,x2,y2;
	Color c;
	
	public Lamana(int x1,int y1, int x2, int y2, Color c)
	{
		this.x1=x1;
		this.y1=y1;
		this.x2=x2;
		this.y2=y2;
		this.c=c;
	}
	
	public void rysuj(Graphics g)
	{
		g.setColor(c);
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawLine(x1,y1,x2,y2);
	}
}
