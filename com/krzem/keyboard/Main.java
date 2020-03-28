package com.krzem.keyboard;



import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.Exception;
import java.lang.Math;
import javax.swing.JFrame;



public class Main extends Constants{
	public static void main(String[] args){
		new Main(args);
	}



	public double FPS=1;
	public JFrame frame;
	public Canvas canvas;
	public Keyboard KEYBOARD;
	private boolean _break=false;



	public Main(String[] args){
		this.init();
		this.frame_init();
		this.run();
	}



	public void init(){
		this.KEYBOARD=new Keyboard(this);
	}



	public void frame_init(){
		Main cls=this;
		this.frame=new JFrame("Keyboard");
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setUndecorated(true);
		this.frame.setResizable(false);
		this.frame.setSize(K_WINDOW_SIZE.w,K_WINDOW_SIZE.h);
		this.frame.setLocationRelativeTo(null);
		this.frame.setAlwaysOnTop(true);
		this.frame.setLocation(K_WINDOW_SIZE.x,K_WINDOW_SIZE.y);
		this.frame.setBackground(new Color(0,0,0,0));
		this.frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				cls.quit();
			}
		});
		this.canvas=new Canvas(this);
		this.canvas.setSize(K_WINDOW_SIZE.w,K_WINDOW_SIZE.h);
		this.canvas.setPreferredSize(new Dimension(K_WINDOW_SIZE.w,K_WINDOW_SIZE.h));
		this.frame.setContentPane(this.canvas);
		this.frame.setVisible(true);
	}



	public void run(){
		Main cls=this;
		new Thread(new Runnable(){
			@Override
			public void run(){
				while (cls._break==false){
					Long s=System.currentTimeMillis();
					try{
						cls.update();
						cls.canvas.repaint();
					}
					catch (Exception e){
						e.printStackTrace();
					}
					Long d=System.currentTimeMillis()-s;
					if (d==0){
						d=1L;
					}
					if ((double)Math.floor(1/(double)d*1e8)/1e5>cls.MAX_FPS){
						try{
							Thread.sleep((long)(1/(double)cls.MAX_FPS*1e3)-d);
						}
						catch (InterruptedException e){}
					}
					cls.FPS=(double)Math.floor(1/(double)(System.currentTimeMillis()-s)*1e8)/1e5;
				}
			}
		}).start();
	}



	public void update(){
		this.KEYBOARD.update();
	}



	public void draw(Graphics2D g){
		this.KEYBOARD.draw(g);
	}



	private void quit(){
		if (this._break==true){
			return;
		}
		this._break=true;
		this.KEYBOARD.dispose();
		this.frame.dispose();
		this.frame.dispatchEvent(new WindowEvent(this.frame,WindowEvent.WINDOW_CLOSING));
	}
}