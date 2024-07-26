package org.example;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Kolo implements ElementRysunku{
	
	private Dimension srodek;
	private int r;
	Color c;

	public Kolo(Dimension srodek, int r,Color c) {
		this.srodek = srodek;
		this.r = r;
		this.c=c;
	}
	public void rysuj(Graphics g)
	{
		g.setColor( c );
		Graphics2D g2d = (Graphics2D)g;
		int x = srodek.width;
		int y = srodek.height;
		int r = this.r;
		g2d.drawOval(x-r,y-r,2*r,2*r);
	}
}
