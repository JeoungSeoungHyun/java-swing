package site.metacoding.test;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import site.metacoding.bubble.ex02.Player;

/**
 * 
 * @author 정성현 목적 : 플레이어 생성
 *
 */
public class BubbleFrame extends JFrame {

	private JLabel backgroundMap;
	private JLabel player;

	// 1. 생성자를 통해 프레임을 생성한다.
	public BubbleFrame() {
		initSetting();
		initObject();
		addObject();
		setVisible(true);
	}

	// 오브젝트 생성 메서드
	private void initObject() {
		// 배경화면을 위한 레이블 생성 후 배경화면에 추가
		backgroundMap = new JLabel(new ImageIcon("image/backgroundMap.png"));

		// 플레이어 생성
		player = new Player();
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

	private void addObject() {
		// 프레임에 스테이지 배경화면 추가
		setContentPane(backgroundMap);

		// 플레이어 추가
		add(player);
	}

	public static void main(String[] args) {
		new BubbleFrame();
	}

}
