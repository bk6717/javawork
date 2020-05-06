import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Jump {

	private JFrame frame;
	int x = 200;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jump window = new Jump();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Jump() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	class MyPanel extends JPanel{
		void jump1() {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					
					int a = 100;
					while (a>0) {
						
						if(a >50) {
							x = x-1;
						} else {
							x = x+1;
						}
						repaint();
					}
				}
			}).start();
		}
		
		public MyPanel() {
			setFocusable(true);
			addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if(e.getKeyCode() == KeyEvent.VK_SPACE) {
						jump1();
					}
				}
			});
		}
		
		
	}
	
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new MyPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		
	}
	

}
