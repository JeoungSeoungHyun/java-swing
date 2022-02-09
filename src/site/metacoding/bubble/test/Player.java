package site.metacoding.bubble.test;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * 
 * @author 정성현 / 목적: 좌우 이동 / 필요: 1.캐릭터 이동 위한 상태 speed 2. right /left 메서드 3. 왼쪽
 *         보는 이미지 아이콘
 *
 */
public class Player extends JLabel {
	// 플레이어 생성자를 통해 생성
	private int x;
	private int y;
	private ImageIcon playerR;
	private ImageIcon playerL;
	private static final int SPEED = 5;

	public Player() {
		initObject();
		initSetting();
	}

	private void initObject() {
		// 이미지아이콘 생성
		playerR = new ImageIcon("image/playerR.png");
		playerL = new ImageIcon("image/playerL.png");
	}

	private void initSetting() {
		// add하기 위해 필요한 초기좌표 설정
		x = 70;
		y = 535;

		// setIcon과 setSize로 원하는 이미지아이콘 설정 후 setLocation으로 다시 그려주기
		setIcon(playerR);
		setSize(50, 50);
		setLocation(x, y);
	}

	public void right() {
		x = x + SPEED;
		setIcon(playerR);
		setLocation(x, y);
	}

	public void left() {
		x = x - SPEED;
		setIcon(playerL);
		setLocation(x, y);
	}

}
