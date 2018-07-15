package opengl;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.awt.GLJPanel;
import com.jogamp.opengl.glu.GLU;

public class Application implements GLEventListener,MouseListener
{
	private GLJPanel canvas;
	private float count=0;
	private GLU glu = new GLU();
	
	public Application(GLJPanel canvas) {
		super();
		this.canvas = canvas;
	}
	@Override
	public void init(GLAutoDrawable drawable) {
		// TODO Auto-generated method stub
		//System.out.println("init");
		GL2 gl = drawable.getGL().getGL2();
		gl.glEnable(GL2.GL_DEPTH_TEST);
		gl.glEnable(GL2.GL_LINE_SMOOTH);
		//gl.glEnable(GL2.GL_POLYGON_SMOOTH);
		//gl.glFrontFace(GL2.GL_CCW);
		//gl.glEnable(GL2.GL_CULL_FACE); 
		//gl.glEnable(GL2.GL_LIGHTING); 
		//gl.glEnable(GL2.GL_COLOR_MATERIAL);  
	}

	@Override
	public void dispose(GLAutoDrawable drawable) {
		// TODO Auto-generated method stub
		//System.out.println("dispose");
	}

	@Override
	public void display(GLAutoDrawable drawable) {
		// TODO Auto-generated method stub
		//System.out.println("display");
		GL2 gl = drawable.getGL().getGL2();
	
		gl.glClearColor(0,0,0,0);
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
		gl.glBegin(GL2.GL_TRIANGLE_FAN);
		gl.glColor3f(1f, 0f, 0f);
		gl.glVertex3f(-0.5f, 0.5f, 0.5f);
		gl.glColor3f(0f, 1f, 0f);
		gl.glVertex3f(-0.5f, -0.5f, 0.5f);
		gl.glColor3f(0f, 0f, 1f);
		gl.glVertex3f(0.5f, -0.5f, 0.5f);
		gl.glColor3f(0f, 0f, 1f);
		gl.glVertex3f(0.5f, 0.5f, 0.5f);
		
		
		/*gl.glColor3f(0f, 1f, 0f);
		gl.glVertex3f(0f, 0.5f, 0.5f);
		gl.glColor3f(1f, 0f, 0f);
		gl.glVertex3f(-0.5f, -0.5f, 0.5f);
		gl.glColor3f(0f, 0f, 1f);
		gl.glVertex3f(0.5f, -0.5f, 0.5f);*/
		gl.glEnd();
		//System.out.println(count);
		gl.glRotatef(count,0,0,1);
		gl.glFlush();
	}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
		// TODO Auto-generated method stub
		//System.out.println("reshape");
		/*GL2 gl = drawable.getGL().getGL2();
		gl.glMatrixMode( GL2.GL_PROJECTION );
		gl.glLoadIdentity();
		float  fAspect =(float) width / height;
		glu.gluPerspective( 45.0f, fAspect, 0.1, 1 );
		gl.glMatrixMode( GL2.GL_MODELVIEW );*/
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		count+=90;
		canvas.display();
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {
		JFrame frame = new JFrame("OPENGL");
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GLCapabilities capabilities= new GLCapabilities(null);
		GLJPanel canvas = new GLJPanel(capabilities);
		Application application = new Application(canvas);
		canvas.addGLEventListener(application);
		canvas.addMouseListener(application);
		frame.add(canvas);
		frame.setVisible(true);
	}
}
