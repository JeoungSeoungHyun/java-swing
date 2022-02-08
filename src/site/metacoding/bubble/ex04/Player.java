package site.metacoding.bubble.ex04;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * 
 * @author ������ �÷��̾�� �¿� �̵��� �����ϴ�. ������ �����ϴ�. ��� �߻�
 *
 */
public class Player extends JLabel {

	public int x;
	private int y;
	private ImageIcon playerR;
	private ImageIcon playerL;

	public boolean isRight() {
		return isRight;
	}

	public void setRight(boolean isRight) {
		this.isRight = isRight;
	}

	public boolean isLeft() {
		return isLeft;
	}

	public void setLeft(boolean isLeft) {
		this.isLeft = isLeft;
	}

	private boolean isRight;
	private boolean isLeft;

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
		setSize(50, 50); // ��ġ�� �ʿ���
		setLocation(x, y); // paintComponent ȣ��

		isRight = false; //
		isLeft = false;
	}

	public void left() {
		new Thread(() -> {
			isLeft = true;
			while (isLeft) {
				if (x >= 80) {
					x = x - 10;
					setIcon(playerL);
					setLocation(x, y);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
//			System.out.println(x);
			}
		}).start();
	}

	public void Right() {

		new Thread(() -> {
			isRight = true;
			while (isRight) {
				if (x <= 870) {
					x = x + 10;
					setIcon(playerR);
					setLocation(x, y);
					try {
						Thread.sleep(10);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}).start();

//			System.out.println(x);
	}
}
