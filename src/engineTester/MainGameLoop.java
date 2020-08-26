package engineTester;

import org.lwjgl.opengl.Display;

import renderEngine.DisplayManager;
import renderEngine.Loader;
import renderEngine.RawModel;
import renderEngine.Renderer;
import shaders.StaticShader;

public class MainGameLoop {
	
	public static void main(String[] args) {
		DisplayManager.createDisplay();
		
		Loader loader = new Loader();
		Renderer renderer = new Renderer();
		StaticShader shader = new StaticShader();
		
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
			
			//logic
			
			//render
			renderer.prepare();
			shader.start();
			renderer.render(model);
			shader.stop();
			DisplayManager.updateDisplay();
		}
		
		shader.cleanUp();
		loader.cleanUp();
		DisplayManager.closeDisplay();
	}

}
