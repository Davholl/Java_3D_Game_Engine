package shaders;

public class StaticShader extends ShaderProgram{
	
	private static final String VERTEX_FILE = "src/shaders/VertexShader.txt";
	private static final String FRAGMENT_FILE = "src/shaders/FragmentShader.txt";
	
	public StaticShader() {
		super(VERTEX_FILE, FRAGMENT_FILE);
	}
	
	public StaticShader(String vertexFile, String fragmentFile) {
		super(vertexFile, fragmentFile);
	}

	@Override
	protected void bindAttributes() {
		super.bindAttribute(0, "position");
	}


}
