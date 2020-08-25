package engineTester;

import org.lwjgl.opengl.Display;

import renderEngine.DisplayManager;

public class MainGameLoop {
	
	public static void main(String[] args) {
		DisplayManager.createDisplay();
		
		while(!Display.isCloseRequested()) {
			//logic
			//render
			DisplayManager.updateDisplay();
			Display.setTitle("Janelina");
		}
		
		DisplayManager.closeDisplay();
	}

}
