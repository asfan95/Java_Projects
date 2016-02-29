import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
/**
 * @author asfan
 *
 */
public class Main extends JFrame
{    
	public static void main(String[] args) 
	{
		
	    JFrame frame = new JFrame("My Window");
	    JPanel panel = new JPanel(null);
		   // Create a "clickable" image icon.
	    ImageIcon micIcon = new ImageIcon("mic.png");
	    ImageIcon searchIcon = new ImageIcon("search.png");
	    ImageIcon exitIcon = new ImageIcon("exit.png");
	    ImageIcon eggIcon = new ImageIcon("egg.png");
	    
	    JTextField search= new JTextField();

	    JLabel micLabel = new JLabel(micIcon);
	    JLabel searchLabel = new JLabel(searchIcon);
	    JLabel exitLabel = new JLabel(exitIcon);
	    JLabel eggLabel = new JLabel(eggIcon);
	    //-------------------------------------
	    //These are shortCut keys
	    //-------------------------------------
	    frame.addKeyListener(new KeyListener() {
	        @Override
	        public void keyTyped(KeyEvent e) 
	        {
	        }
	        @Override
	        public void keyPressed(KeyEvent e) 
	        {
	            System.out.println("Key pressed code=" + e.getKeyCode() + ", char=" + e.getKeyChar());
	            //Checks that control is held down
	            if(e.isControlDown())
	            {
	            	//if a is pressed, we minimize the screen
	            	if(e.getKeyCode()==65)
	            	{
			            frame.setState(Frame.ICONIFIED);	
	            	}
	            	//if a is pressed, we minimize the screen
	            	if(e.getKeyCode()==83)
	            	{
	        	        System.exit(0);
	            	}
	            	//if a is pressed, we minimize the screen
	            	if(e.getKeyCode()==68)
	            	{
	                    search.setBounds(75,75,75,25);
	                    search.setLocation(250,250);
	                    panel.add(search);
	    		    	panel.repaint();

	                }
	            }
	        }
	        @Override
	        public void keyReleased(KeyEvent e)
	        {
	        }
	    });
	    //-------------------------------------
	    //If SomeOne Clicked on the searchLabel
	    //-------------------------------------
	    searchLabel.addMouseListener(new MouseAdapter()
	    {
	    	public void mouseClicked(MouseEvent me) {
		    	  if(Desktop.isDesktopSupported())
		    	  {
		    	    try {
						Desktop.getDesktop().browse(new URI("http://www."+search.getText()+".com"));
					} catch (IOException | URISyntaxException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		    	  }
		    	  
		    	System.out.println(search.getText());
		    	panel.remove(search);
		    	panel.repaint();
		      }
		    });
	    //-------------------------------------
	    //If SomeOne Clicked on the exitLabel
	    //-------------------------------------
	    exitLabel.addMouseListener(new MouseAdapter() 
	    {
	      public void mouseClicked(MouseEvent me) {
	        System.exit(0);
	      }
	    });

	    // Add it to a frame.
	    frame.setBounds(100, 100, 600, 450);
		frame.setUndecorated(true);
		frame.setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
        frame.setAlwaysOnTop( true );

        eggLabel.setLocation(200, 50);

        panel.add(eggLabel);
        panel.add(exitLabel);
        panel.add(micLabel);
        panel.add(searchLabel);
        //search.setEnabled(false);
        exitLabel.setSize(50, 50);
        micLabel.setSize(50, 50);
        searchLabel.setSize(50, 50);
        exitLabel.setLocation(275, 300);
        searchLabel.setLocation(200, 300);
        micLabel.setLocation(350, 300);

        eggLabel.setSize(200, 200);

        panel.setOpaque(false);
        frame.getContentPane().add(panel);

	    frame.setVisible(true);
	}
}
