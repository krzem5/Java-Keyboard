package com.krzem.keyboard;



import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;



public class Key extends Constants{
	public Main cls;
	public Keyboard kb;
	public Rectangle r;
	public String kd;
	public String[] knm;



	public Key(Main cls,Keyboard kb,Rectangle r,String kd,String knm){
		this.cls=cls;
		this.kb=kb;
		this.r=r;
		this.kd=kd;
		this.knm=knm.split("\t");
	}



	public void draw(Graphics2D g){
		if (this.kb.pressed(this.kd)){
			g.setColor(new Color(195,195,195));
		}
		else{
			g.setColor(new Color(60,60,60));
		}
		g.fillRect(this.r.x*SCALE+10,this.r.y*SCALE+10,this.r.w*SCALE-10,this.r.h*SCALE-10);
		if (this.kb.pressed(this.kd)){
			g.setColor(new Color(60,60,60));
		}
		else{
			g.setColor(new Color(195,195,195));
		}
		g.setFont(new Font("Monospaced",Font.BOLD,38));
		FontMetrics fm=g.getFontMetrics();
		if (this.knm.length==1){
			g.drawString(this.knm[0],this.r.x*SCALE+this.r.w*SCALE/2-fm.stringWidth(this.knm[0])/2+5,this.r.y*SCALE+this.r.h*SCALE/2+fm.getDescent()+2);
		}
		else{
			g.drawString(this.knm[0],this.r.x*SCALE+this.r.w*SCALE/2-fm.stringWidth(this.knm[0])/2+5,this.r.y*SCALE+this.r.h*SCALE/3+fm.getDescent()+2);
			g.drawString(this.knm[1],this.r.x*SCALE+this.r.w*SCALE/2-fm.stringWidth(this.knm[1])/2+5,this.r.y*SCALE+this.r.h*SCALE*2/3+fm.getDescent()+2);
		}
	}
}