package pacman;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class PacView extends Canvas{
	
	private static final long serialVersionUID = 1L;
	private PacModel world;
	private final int t=40;
	
	public PacView(PacModel world) {
		this.world=world;	
		setSize(world.getWidth()*t,world.getHeight()*t);
	}
	
	public void paint(Graphics g)
	{
		g.setColor(Color.white);
		g.fillRect(0, 0, getWidth(),getHeight());
		g.setColor(Color.black);
		
		for(int x=0; x<world.getWidth();x++){
			for(int y=0;y<world.getHeight();y++)
			{
				char c=world.getCell(x,y);
				switch(c)
				{
					case '.': g.drawOval(x*t+t/3, y*t+t/3, t/3, t/3); break;
					case '#': g.fillRect(x*t, y*t, t, t);break;
					case 'o': g.drawOval(x*t+1, y*t+1, t-1, t-1);break;
					default : System.err.println(c+" Not found");
				}
			}
		}
	}

}
