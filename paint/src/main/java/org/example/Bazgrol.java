package org.example;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Bazgrol implements ElementRysunku {
	private int x,y;
	Color c;
	public Bazgrol(int x, int y, Color c)
	{
		this.x=x;
		this.y=y;
		this.c=c;
	}

	public void rysuj(Graphics g)
	{
		g.setColor( c );
		Graphics2D g2d = (Graphics2D)g;
		g2d.fillOval(x-3,y-3,6,6);
	}
}