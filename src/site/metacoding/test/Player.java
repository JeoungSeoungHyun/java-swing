package site.metacoding.test;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player extends JLabel {
	// 플레이어 생성자를 통해 생성
	private int x;
	private int y;
	private ImageIcon playerR;

	public Player() {
		initObject();
		initSetting();
	}

	private void initObject() {
		// 오른쪽 바라보는 이미지아이콘 생성
		playerR = new ImageIcon("image/playerR.png");
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

}
