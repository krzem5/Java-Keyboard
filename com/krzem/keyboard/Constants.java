package com.krzem.keyboard;



import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;



public class Constants{
	public static final int SCALE=3;
	public static final int DISPLAY_ID=0;
	public static final GraphicsDevice SCREEN=GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[DISPLAY_ID];
	public static final java.awt.Rectangle WINDOW_SIZE=SCREEN.getDefaultConfiguration().getBounds();
	public static final Rectangle K_WINDOW_SIZE=new Rectangle(WINDOW_SIZE.width/2-364*SCALE,WINDOW_SIZE.height-275*SCALE-10-60,728*SCALE+10,275*SCALE+10);
	public static final int MAX_FPS=60;
}