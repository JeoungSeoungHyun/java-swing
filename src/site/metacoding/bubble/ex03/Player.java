package site.metacoding.bubble.ex03;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * 
 * @author 정성현 플레이어는 좌우 이동이 가능하다. 점프가 가능하다. 방울 발사
 *
 */
public class Player extends JLabel {

	public int x;
	private int y;
	private ImageIcon playerR;
	private ImageIcon playerL;

	public Player() {
		initObject();
		initSetting();

	}

	private void initObject() {
		playerR = new ImageIcon("image/playerR.png");
		playerL = new ImageIcon("image/playerL.png");
	}

	private void initSetting() {
		x = 70;
		y = 535;
		setIcon(playerR);
		setSize(50, 50); // 위치도 필요함
		setLocation(x, y); // paintComponent 호출
	}

	public void left() {
		if (x >= 80) {
			x = x - 10;
			setIcon(playerL);
			setLocation(x, y);
//			System.out.println(x);
		}
	}

	public void Right() {
		if (x <= 870) {
			x = x + 10;
			setIcon(playerR);
			setLocation(x, y);
//			System.out.println(x);
		}
	}
}
