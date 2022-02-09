package site.metacoding.bubble.test2;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 
 * @author 정성현 / 목적 : 플레이어 추가 / 필요 : 플레이어 클래스
 *
 */
public class BubbleFrame extends JFrame {

	private JLabel backgroundMap;
	private Player player;

	// 생성자를 통해 프레임 생성 및 설정
	public BubbleFrame() {
		initObject();
		initSetting();
		addObject();
		setVisible(true);
	}

	// 오브젝트 생성 메서드
	private void initObject() {
		backgroundMap = new JLabel(new ImageIcon("image/backgroundMap.png"));

		player = new Player();
	}

	// 세팅 메서드
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

	// 오브젝트 붙이기 메서드
	private void addObject() {

		// 배경화면 추가
		setContentPane(backgroundMap);

		// 플레이어 추가
		add(player);

	}

	public static void main(String[] args) {
		new BubbleFrame();
	}

}
