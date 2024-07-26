package org.example;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;


public class Okno extends JFrame {
	private JPanel p;
	private JPanel customPanel;
	private JButton[] bFigures;
	public JButton[] bColors;
	private Okno okno = this;
	private int  tryb = 0;
	public int kolor = 0;
	public boolean siatkaWlaczona = false;
	
	public int getTryb() {
		return tryb;
	}

	public void setTryb(int tryb) {
		this.tryb = tryb;
	}

	Okno() {
		JPanel background = new JPanel();
		background.setBackground(Color.GRAY);
		background.setLayout(new FlowLayout(FlowLayout.LEFT));
		setTitle("Paint");
		getContentPane().setBackground(Color.GRAY);
		setSize(1520,850);
		setLayout(new BorderLayout());
		JMenuBar menuBar = new JMenuBar();
		
		JMenu fileMenu = new JMenu("File");
		
		JMenu newItem = new JMenu("New");
		
		JMenuItem normalItem = new JMenuItem("Normal");
		JMenuItem customSizeItem = new JMenuItem("Custom Size");
		
		
		customSizeItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				JFrame window = new JFrame();
				window.setLayout(new FlowLayout());
				customPanel = new JPanel();
				
				customPanel.setLayout(new BorderLayout());
				customPanel.setSize(new Dimension(400,200));
				
				JPanel size = new JPanel();
				customPanel.add(size,BorderLayout.NORTH);
				size.setLayout(new FlowLayout(FlowLayout.LEADING));
				
				JTextField x = new JTextField(4);
				JTextField y = new JTextField(4);
				size.add(new JLabel("Width:"));
				size.add(x);
				size.add(new JLabel("Height:"));
				size.add(y);
				
				JButton ok = new JButton("Ok");
				ok.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e)
					{
						if(p!=null) background.remove(p);
						int X = Integer.parseInt(x.getText());
						int Y = Integer.parseInt(y.getText());
						p = new MyJPanel(okno);
						p.setPreferredSize(new Dimension(X,Y));
						background.add(p);
						p.revalidate();
				        repaint();
				        window.dispatchEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSING));
					}
				});
				customPanel.add(ok,BorderLayout.SOUTH);
				window.add(customPanel);
				customPanel.revalidate();
				repaint();
				window.setResizable(false);
				window.pack();
				window.setVisible(true);
				
			}
		});
		normalItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if(p!=null) background.remove(p);
				p = new MyJPanel(okno);
				p.setPreferredSize(new Dimension(1520,850));
				
				background.add(p);
				p.revalidate();
		        repaint();
				
				
			}
		});

		fileMenu.add(newItem);
		
		newItem.add(normalItem);
		newItem.add(customSizeItem);
		
		menuBar.add(fileMenu);
		setJMenuBar(menuBar);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		JPanel panel1 = new JPanel();
		panel1.setPreferredSize(new Dimension(300,100));
		panel1.setLayout(new GridLayout(2,3));
		JButton bKolo = new JButton("Kolo");
		JButton bProstokat = new JButton("Prostokat");
		JButton bElipsa = new JButton("Elipsa");
		JButton bLamana = new JButton("Lamana");
		JButton bBazgrol = new JButton("Bazgrol");
		bFigures = new JButton[]{bKolo,bProstokat,bElipsa,bLamana,bBazgrol};
		for(int i=0;i<bFigures.length;i++)
		{
		final int index = i;
		bFigures[i].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				tryb=index;
			}
		});
		}
		JPanel panel2 = new JPanel();
		panel2.setPreferredSize(new Dimension(500,100));
		panel2.setLayout(new GridLayout(2,5));
		JButton black = new JButton();
		JButton red = new JButton();
		JButton blue = new JButton();
		JButton yellow = new JButton();
		JButton green = new JButton();
		JButton gray = new JButton();
		JButton orange = new JButton();
		JButton pink = new JButton();
		JButton magenta = new JButton();
		JButton cyan = new JButton();
		bColors = new JButton[] {black,red,blue,yellow,green,gray,orange,pink,magenta,cyan};
		for(int i=0;i<bColors.length;i++)
		{
		final int index = i;
		bColors[i].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				kolor=index;
			}
		});
		}
		
		black.setBackground(Color.BLACK);
		red.setBackground(Color.RED);
		blue.setBackground(Color.BLUE);
		yellow.setBackground(Color.YELLOW);
		green.setBackground(Color.GREEN);
		gray.setBackground(Color.GRAY);
		orange.setBackground(Color.ORANGE);
		pink.setBackground(Color.PINK);
		magenta.setBackground(Color.MAGENTA);
		cyan.setBackground(Color.CYAN);
		
		panel1.add(bKolo);
		panel1.add(bProstokat);
		panel1.add(bElipsa);
		panel1.add(bLamana);
		panel1.add(bBazgrol);
		panel.add(panel1);
		
		panel2.add(black);
		panel2.add(red);
		panel2.add(blue);
		panel2.add(yellow);
		panel2.add(green);
		panel2.add(gray);
		panel2.add(orange);
		panel2.add(pink);
		panel2.add(magenta);
		panel2.add(cyan);
		panel.add(panel2);

		JPanel panel3 = new JPanel();
		panel3.setPreferredSize(new Dimension(100,50));
		panel3.setLayout(new BorderLayout());
		JCheckBox check = new JCheckBox();
		check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				siatkaWlaczona = check.isSelected();
				System.out.println(siatkaWlaczona);
			}
		});
		JLabel label = new JLabel("punkty siatki");
		panel3.add(label,BorderLayout.NORTH);
		panel3.add(check,BorderLayout.SOUTH);
		panel.add(panel3);
		
		
		add(panel,BorderLayout.NORTH);
		add(new JScrollPane(background),BorderLayout.CENTER);
		//setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}