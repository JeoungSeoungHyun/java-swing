package site.metacoding.test;

import javax.swing.JFrame;

/**
 * 
 * @author 정성현 목적 : 기본 프레임 추가
 *
 */
public class BubbleFrame extends JFrame {

	// 1. 생성자를 통해 프레임을 생성한다.
	public BubbleFrame() {
		initSetting();
		initObject();
		setVisible(true);
	}

	// 오브젝트 생성 메서드
	private void initObject() {

	}

	// 프레임세팅 메서드
	private void initSetting() {
		// 프레임 사이즈 세팅
		setSize(1000, 640);

		// 프레임의 패널 레이아웃을 null로 변경
		getContentPane().setLayout(null);

		// 프레임이 중앙에 위치하도록 세팅
		setLocationRelativeTo(null);

		// 프레임 종료시 JVM도 같이 종료하도록 세팅
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new BubbleFrame();
	}

}
