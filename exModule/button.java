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
		btnNewButton.addMouseListener(new MouseAdapter() { //마우스 리스너 추가
			public void mouseClicked(MouseEvent e) { //마우스 클릭시 콜백
				Data d1 = new Data(); // 약국정보를 불러오는 모듈 객체 생성
				
				Module1 d2 = d1.getInfo(); //약국 정보를 가져오기 
				
				StringBuilder sb = new StringBuilder(); //약국 정보를 하나로 묶기위한 스트링 빌더
				
				int storeNum = d2.getStoreInfos().size(); //불러온 약국의 수 
				
				for (int i = 0; i < storeNum; i++) { //약국의 수만큼 반복
					
					//텍스트 필드에 입력한 내용과 일치하는 위치의 약국만 스트링빌더에
					if((d2.getStoreInfos().get(i).getAddr().contains(textField.getText()))) {
						String name = d2.getStoreInfos().get(i).getName();
						String addr = d2.getStoreInfos().get(i).getAddr();
						sb.append(name + "의 위치는" + addr + "\n");
						System.out.println();
					}
				}
				textArea.setText(sb.toString()); // 스트링빌더에 담긴 내용을 textArea에 덮어씌우기
			}
		});
		btnNewButton.setBounds(196, 20, 97, 23);
		frame.getContentPane().add(btnNewButton);
		
		
	}
}
