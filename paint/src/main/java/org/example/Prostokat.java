package org.example;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Prostokat implements ElementRysunku {

	private int xA,yA,xC,yC;
	private Color c;
	public Prostokat(int xA,int yA,int xC,int yC, Color c )
	{
		this.xA=xA;
		this.yA=yA;
		this.xC=xC;
		this.yC=yC;
		this.c=c;
	}
	@Override
	public void rysuj(Graphics g) {
		g.setColor( c );
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawRect(xA,yA,Math.abs(xC-xA),Math.abs(yC-yA));

	}

}
