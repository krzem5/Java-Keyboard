package com.krzem.keyboard;



import java.awt.Graphics2D;
import java.lang.Exception;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;



public class Keyboard extends Constants implements NativeKeyListener{
	public Main cls;
	private Map<String,Boolean> _kmap;
	private List<Key> _kl;



	public Keyboard(Main cls){
		this.cls=cls;
		this._register();
		this._kmap=new HashMap<String,Boolean>();
		this._kl=new ArrayList<Key>();
		this._generate();
	}



	public void update(){

	}



	public void draw(Graphics2D g){
		g.setColor(new java.awt.Color(204,204,204,187));
		g.fillRect(0,0,K_WINDOW_SIZE.w,K_WINDOW_SIZE.h);
		for (Key k:this._kl){
			k.draw(g);
		}
	}



	public void dispose(){
		try{
			GlobalScreen.unregisterNativeHook();
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}



	public boolean pressed(String k){
		if (this._kmap.get(k)==null){
			return false;
		}
		return (this._kmap.get(k)==true);
	}



	private void _register(){
		try{
			Logger logger=Logger.getLogger(GlobalScreen.class.getPackage().getName());
			logger.setLevel(Level.OFF);
			logger.setUseParentHandlers(false);
			GlobalScreen.registerNativeHook();
			GlobalScreen.addNativeKeyListener(this);
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}



	private void _key(NativeKeyEvent e,boolean st){
		int l=e.getKeyLocation();
		switch (l){
			case 0:
			case 1:
				l=0;
				break;
			case 2:
				l=1;
				break;
			case 3:
				l=2;
				break;
			case 4:
				l=3;
				break;
		}
		String c=String.format("%d-%d",e.getKeyCode(),l);
		this._kmap.put(c,st);
	}



	private void _generate(){
		this._kl.add(new Key(this.cls,this,new Rectangle(0,0,52,25),"1-0","Esc"));
		this._kl.add(new Key(this.cls,this,new Rectangle(52,0,52,25),"59-0","F1"));
		this._kl.add(new Key(this.cls,this,new Rectangle(104,0,52,25),"60-0","F2"));
		this._kl.add(new Key(this.cls,this,new Rectangle(156,0,52,25),"61-0","F3"));
		this._kl.add(new Key(this.cls,this,new Rectangle(208,0,52,25),"62-0","F4"));
		this._kl.add(new Key(this.cls,this,new Rectangle(260,0,52,25),"63-0","F5"));
		this._kl.add(new Key(this.cls,this,new Rectangle(312,0,52,25),"64-0","F6"));
		this._kl.add(new Key(this.cls,this,new Rectangle(364,0,52,25),"65-0","F7"));
		this._kl.add(new Key(this.cls,this,new Rectangle(416,0,52,25),"66-0","F8"));
		this._kl.add(new Key(this.cls,this,new Rectangle(468,0,52,25),"67-0","F9"));
		this._kl.add(new Key(this.cls,this,new Rectangle(520,0,52,25),"68-0","F10"));
		this._kl.add(new Key(this.cls,this,new Rectangle(572,0,52,25),"87-0","F11"));
		this._kl.add(new Key(this.cls,this,new Rectangle(624,0,52,25),"88-0","F12"));
		this._kl.add(new Key(this.cls,this,new Rectangle(676,0,52,25),"3639-0","Prtscn"));
		this._kl.add(new Key(this.cls,this,new Rectangle(0,25,50,50),"41-0","~\t`"));
		this._kl.add(new Key(this.cls,this,new Rectangle(50,25,50,50),"2-0","!\t1"));
		this._kl.add(new Key(this.cls,this,new Rectangle(100,25,50,50),"3-0","@\t2"));
		this._kl.add(new Key(this.cls,this,new Rectangle(150,25,50,50),"4-0","#\t3"));
		this._kl.add(new Key(this.cls,this,new Rectangle(200,25,50,50),"5-0","$\t4"));
		this._kl.add(new Key(this.cls,this,new Rectangle(250,25,50,50),"6-0","%\t5"));
		this._kl.add(new Key(this.cls,this,new Rectangle(300,25,50,50),"7-0","^\t6"));
		this._kl.add(new Key(this.cls,this,new Rectangle(350,25,50,50),"8-0","&\t7"));
		this._kl.add(new Key(this.cls,this,new Rectangle(400,25,50,50),"9-0","*\t8"));
		this._kl.add(new Key(this.cls,this,new Rectangle(450,25,50,50),"10-0","(\t9"));
		this._kl.add(new Key(this.cls,this,new Rectangle(500,25,50,50),"11-0",")\t0"));
		this._kl.add(new Key(this.cls,this,new Rectangle(550,25,50,50),"12-0","_\t-"));
		this._kl.add(new Key(this.cls,this,new Rectangle(600,25,50,50),"13-0","+\t="));
		this._kl.add(new Key(this.cls,this,new Rectangle(650,25,78,50),"14-0","Backspace"));
		this._kl.add(new Key(this.cls,this,new Rectangle(0,75,78,50),"15-0","Tab"));
		this._kl.add(new Key(this.cls,this,new Rectangle(78,75,50,50),"16-0","Q"));
		this._kl.add(new Key(this.cls,this,new Rectangle(128,75,50,50),"17-0","W"));
		this._kl.add(new Key(this.cls,this,new Rectangle(178,75,50,50),"18-0","E"));
		this._kl.add(new Key(this.cls,this,new Rectangle(228,75,50,50),"19-0","R"));
		this._kl.add(new Key(this.cls,this,new Rectangle(278,75,50,50),"20-0","T"));
		this._kl.add(new Key(this.cls,this,new Rectangle(328,75,50,50),"21-0","Y"));
		this._kl.add(new Key(this.cls,this,new Rectangle(378,75,50,50),"22-0","U"));
		this._kl.add(new Key(this.cls,this,new Rectangle(428,75,50,50),"23-0","I"));
		this._kl.add(new Key(this.cls,this,new Rectangle(478,75,50,50),"24-0","O"));
		this._kl.add(new Key(this.cls,this,new Rectangle(528,75,50,50),"25-0","P"));
		this._kl.add(new Key(this.cls,this,new Rectangle(578,75,50,50),"26-0","{\t["));
		this._kl.add(new Key(this.cls,this,new Rectangle(628,75,50,50),"27-0","}\t]"));
		this._kl.add(new Key(this.cls,this,new Rectangle(678,75,50,50),"43-0","|\t\\"));
		this._kl.add(new Key(this.cls,this,new Rectangle(0,125,89,50),"58-0","Caps Lock"));
		this._kl.add(new Key(this.cls,this,new Rectangle(89,125,50,50),"30-0","A"));
		this._kl.add(new Key(this.cls,this,new Rectangle(139,125,50,50),"31-0","S"));
		this._kl.add(new Key(this.cls,this,new Rectangle(189,125,50,50),"32-0","D"));
		this._kl.add(new Key(this.cls,this,new Rectangle(239,125,50,50),"33-0","F"));
		this._kl.add(new Key(this.cls,this,new Rectangle(289,125,50,50),"34-0","G"));
		this._kl.add(new Key(this.cls,this,new Rectangle(339,125,50,50),"35-0","H"));
		this._kl.add(new Key(this.cls,this,new Rectangle(389,125,50,50),"36-0","J"));
		this._kl.add(new Key(this.cls,this,new Rectangle(439,125,50,50),"37-0","K"));
		this._kl.add(new Key(this.cls,this,new Rectangle(489,125,50,50),"38-0","L"));
		this._kl.add(new Key(this.cls,this,new Rectangle(539,125,50,50),"39-0",":\t;"));
		this._kl.add(new Key(this.cls,this,new Rectangle(589,125,50,50),"40-0","\"\t\'"));
		this._kl.add(new Key(this.cls,this,new Rectangle(639,125,89,50),"28-0","Enter"));
		this._kl.add(new Key(this.cls,this,new Rectangle(0,175,114,50),"42-1","Shift"));
		this._kl.add(new Key(this.cls,this,new Rectangle(114,175,50,50),"44-0","Z"));
		this._kl.add(new Key(this.cls,this,new Rectangle(164,175,50,50),"45-0","X"));
		this._kl.add(new Key(this.cls,this,new Rectangle(214,175,50,50),"46-0","C"));
		this._kl.add(new Key(this.cls,this,new Rectangle(264,175,50,50),"47-0","V"));
		this._kl.add(new Key(this.cls,this,new Rectangle(314,175,50,50),"48-0","B"));
		this._kl.add(new Key(this.cls,this,new Rectangle(364,175,50,50),"49-0","N"));
		this._kl.add(new Key(this.cls,this,new Rectangle(414,175,50,50),"50-0","M"));
		this._kl.add(new Key(this.cls,this,new Rectangle(464,175,50,50),"51-0","<\t,"));
		this._kl.add(new Key(this.cls,this,new Rectangle(514,175,50,50),"52-0",">\t."));
		this._kl.add(new Key(this.cls,this,new Rectangle(564,175,50,50),"53-0","?\t/"));
		this._kl.add(new Key(this.cls,this,new Rectangle(614,175,114,50),"3638-2","Shift"));
		this._kl.add(new Key(this.cls,this,new Rectangle(0,225,89,50),"29-1","Ctrl"));
		this._kl.add(new Key(this.cls,this,new Rectangle(89,225,50,50),"3675-1","Win"));
		this._kl.add(new Key(this.cls,this,new Rectangle(139,225,78,50),"56-1","Alt"));
		this._kl.add(new Key(this.cls,this,new Rectangle(217,225,244,50),"57-0","Space"));
		this._kl.add(new Key(this.cls,this,new Rectangle(461,225,78,50),"56-2","Alt Gr"));
		this._kl.add(new Key(this.cls,this,new Rectangle(539,225,50,50),"3675-2","Win"));
		this._kl.add(new Key(this.cls,this,new Rectangle(589,225,50,50),"3677-0","Ctx\tMenu"));
		this._kl.add(new Key(this.cls,this,new Rectangle(639,225,89,50),"29-2","Ctrl"));
	}



	@Override
	public void nativeKeyPressed(NativeKeyEvent e){
		this._key(e,true);
	}



	@Override
	public void nativeKeyReleased(NativeKeyEvent e){
		this._key(e,false);
	}



	@Override
	public void nativeKeyTyped(NativeKeyEvent e){
		this._key(e,false);
	}
}
