package site.metacoding.ex13;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EventEx01 extends JFrame { // Frame-awt는 OS swing은 java가 따라서 swing은 어디서든 된다.

	JPanel myPanel; // 패널과 버튼같은건 전역적으로 선언한다. 오래 있어야되기 때문에
	JButton btn1;// ctrl + shift + o
	JButton btn2;
	JCheckBox checkBox1;
	JLabel labelText, labelImg; // div 같은거

	public EventEx01() {
		initSetting();
		initObject();
		initAssign();
		initListener();

		setVisible(true);
	}

	private void initSetting() {
		setSize(300, 300);
		setLocationRelativeTo(null); // 프레임 화면 중앙 배치
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x버튼 클릭시 메인종료
	}

	private void initObject() {
		myPanel = new JPanel();
		btn1 = new JButton("버튼1");
		btn2 = new JButton("버튼2");
		checkBox1 = new JCheckBox();
		labelText = new JLabel("레이블1");
		// 내 프로젝트 위치부터 상대경로가 지정되어 있다.
		labelImg = new JLabel(new ImageIcon("Image/dog.jpg"));
	}

	private void initAssign() {
		add(myPanel);
		myPanel.add(btn1);
		myPanel.add(btn2);
		myPanel.add(checkBox1);
		myPanel.add(labelText);

		myPanel.add(labelImg);

	}

	private void initListener() {
		// 윈도우야 지켜봐줘!! 이 버튼을
		btn1.addActionListener(new ActionListener() { // 윈도우가 litener를 통해 지켜보는데 null로 되어있는 경우 지켜봐도 무엇을 할지 모른다.
														// 그러므로 task를 할당해주어야 한다.

			// 버튼이 클릭되면 윈도우가 해당 메서드를 콜백해준다.
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("버튼1이 클릭되었습니다.");

			}
		});

		btn2.addActionListener((ActionEvent e) -> {
			System.out.println("버튼2가 클릭되었습니다.");
		});

		checkBox1.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
//						System.out.println(e.getStateChange());
				if (e.getStateChange() == 1) {
					System.out.println("체크되었습니다.");
				} else {
					System.out.println("체크해제되었습니다.");
				}
			}
		});
	}

	public static void main(String[] args) {
		new EventEx01();
	}

}
