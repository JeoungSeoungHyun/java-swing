package site.metacoding.bubble.test2;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * 
 * @author 정성현 / 필요: 1.플레이어 이미지아이콘 2.add하기위한 좌표
 *
 */
public class Player extends JLabel {

	private int x;
	private int y;
	private ImageIcon playerR;

	public Player() {
		initObject();
		initSetting();
	}

	private void initObject() {
		playerR = new ImageIcon("image/playerR.png");
	}

	private void initSetting() {

		// add 위한 좌표
		x = 70;
		y = 535;

		// 플레이어 사이즈와 그리기
		setIcon(playerR);
		setSize(50, 50);
		setLocation(x, y);
	}
}