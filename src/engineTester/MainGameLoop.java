package engineTester;

import org.lwjgl.opengl.Display;

import models.RawModel;
import models.TexturedModel;
import renderEngine.DisplayManager;
import renderEngine.Loader;
import renderEngine.Renderer;
import shaders.StaticShader;
import textures.ModelTexture;

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
		
		float[] textureCoords = {
				0,0, //v1
				0,1, //v1
				1,1, //v2
				1,0  //v3
		};
		
		RawModel model = loader.loadToVAO(vertices, textureCoords, indices);
		ModelTexture texture = new ModelTexture(loader.loadTexture("parrot"));
		TexturedModel texturedModel = new TexturedModel(model, texture);
		
		while(!Display.isCloseRequested()) {
			
			//logic
			
			//render
			renderer.prepare();
			shader.start();
			renderer.render(texturedModel);
			shader.stop();
			DisplayManager.updateDisplay();
		}
		
		shader.cleanUp();
		loader.cleanUp();
		DisplayManager.closeDisplay();
	}

}
