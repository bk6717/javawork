package exModule;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class button {

	private JFrame frame;
	private JTextField textField;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					button window = new button();
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
	public button() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 321, 278);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uC704\uCE58");
		lblNewLabel.setBounds(12, 24, 31, 15);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(52, 21, 116, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(12, 52, 281, 151);
		frame.getContentPane().add(textArea);
		
		JButton btnNewButton = new JButton("\uAC80\uC0C9");
		btnNewButton.addMouseListener(new MouseAdapter() { //���콺 ������ �߰�
			public void mouseClicked(MouseEvent e) { //���콺 Ŭ���� �ݹ�
				Data d1 = new Data(); // �౹������ �ҷ����� ��� ��ü ����
				
				Module1 d2 = d1.getInfo(); //�౹ ������ �������� 
				
				StringBuilder sb = new StringBuilder(); //�౹ ������ �ϳ��� �������� ��Ʈ�� ����
				
				int storeNum = d2.getStoreInfos().size(); //�ҷ��� �౹�� �� 
				
				for (int i = 0; i < storeNum; i++) { //�౹�� ����ŭ �ݺ�
					
					//�ؽ�Ʈ �ʵ忡 �Է��� ����� ��ġ�ϴ� ��ġ�� �౹�� ��Ʈ��������
					if((d2.getStoreInfos().get(i).getAddr().contains(textField.getText()))) {
						String name = d2.getStoreInfos().get(i).getName();
						String addr = d2.getStoreInfos().get(i).getAddr();
						sb.append(name + "�� ��ġ��" + addr + "\n");
						System.out.println();
					}
				}
				textArea.setText(sb.toString()); // ��Ʈ�������� ��� ������ textArea�� ������
			}
		});
		btnNewButton.setBounds(196, 20, 97, 23);
		frame.getContentPane().add(btnNewButton);
		
		
	}
}
