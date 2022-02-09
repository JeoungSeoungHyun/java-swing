package site.metacoding.bubble.test2;

import javax.swing.JFrame;

/**
 * 
 * @author 정성현 / 목적 : 기본 프레임 만들기
 *
 */
public class BubbleFrame extends JFrame {

	// 생성자를 통해 프레임 생성 및 설정
	public BubbleFrame() {
		initObject();
		initSetting();
		setVisible(true);
	}

	private void initObject() {

	}

	private void initSetting() {
		// 프레임 사이즈 설정
		setSize(1000, 640);

		// 프레임 중앙 위치
		setLocationRelativeTo(null);

		// 프레임의 패널 레이아웃 null 설정
		getContentPane().setLayout(null);

		// x키 클릭시 JVM 종료
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		new BubbleFrame();
	}

}
