package site.metacoding.bubble.ex02;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 
 * @author 정성현 목적 : 배경화면 설정, 캐릭터 추가
 * 
 */

public class BubbleFrame extends JFrame {

	private JLabel backgroundMap;
	private Player player;

	public BubbleFrame() {
		initObject();
		initSetting();
		setVisible(true); // 내부에 paintComponent() 호출 코드가 있다. 타겟을 정하지 않으면 프레임을 다시 그린다.
	}

	// new 하는 것
	private void initObject() {
		backgroundMap = new JLabel(new ImageIcon("image/backgroundMap.png"));
//		add(backgroundMap); // 그냥 add하면 위치를 잡아주어야 한다.
		setContentPane(backgroundMap); // 배경화면 설정 - 패널자체에 붙이는것

		player = new Player();
		player.x = 300;
		add(player); // x는 변했지만 다시 그려지지 않아(setLocation) 반영이 되지 않는다.
		System.out.println(player.x);
	}

	private void initSetting() {
		setSize(1000, 640); // 사이즈 설정
		getContentPane().setLayout(null); // JFrame의 기본 JPanel의 레이아웃 설정
		setLocationRelativeTo(null); // 가운데 배치
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x버튼 클릭시 JVM 같이 종료하기
	}

	public static void main(String[] args) {
		new BubbleFrame();

	}

}
