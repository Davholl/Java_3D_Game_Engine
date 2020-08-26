package engineTester;

import org.lwjgl.opengl.Display;

import renderEngine.DisplayManager;
import renderEngine.Loader;
import renderEngine.RawModel;
import renderEngine.Renderer;

public class MainGameLoop {
	
	public static void main(String[] args) {
		DisplayManager.createDisplay();
		
		Loader loader = new Loader();
		Renderer renderer = new Renderer();
		
		//vertices de um retangulo de exemplo para testar
		//Os vertices dos triangulos são lidos no sentido antihorario
		float[] vertices = {
				//Os vertices totais do retângulo
				-0.5f, 0.5f, 0f, //v0
				-0.5f, -0.5f, 0f,//v1
				 0.5f, -0.5f, 0f,  //v2
				 0.5f, 0.5f, 0f //v3
		};
		
		//Especificando os vertices que vão compor os 2 triangulos
		int[] indices = {
				0, 1, 3,
				3, 1 , 2
		};
		
		RawModel model = loader.loadToVAO(vertices, indices);
		
		while(!Display.isCloseRequested()) {
			renderer.prepare();
			//logic
			//render
			renderer.render(model);
			DisplayManager.updateDisplay();
		}
		
		loader.cleanUp();
		DisplayManager.closeDisplay();
	}

}
