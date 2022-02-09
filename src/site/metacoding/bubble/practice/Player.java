package site.metacoding.bubble.practice;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * 
 * @author 정성현 목적 :
 *
 */
public class Player extends JLabel {

	public int x;
	public int y;
	private ImageIcon playerR;
	private ImageIcon playerL;

	private boolean isRight;
	private boolean isLeft;
	private boolean isJump;
	private boolean isUp;
	private boolean isDown;

	private static final int JUMPSPEED = 2;
	private static final int SPEED = 2;

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

	public boolean isJump() {
		return isJump;
	}

	public void setJump(boolean isJump) {
		this.isJump = isJump;
	}

	public boolean isDown() {
		return isDown;
	}

	public void setDown(boolean isDown) {
		this.isDown = isDown;
	}

	public Player() {
		initObject();
		initSetting();

	}

	private void initObject() {
		playerR = new ImageIcon("image/playerR.png");
		playerL = new ImageIcon("image/playerL.png");
	}

	private void initSetting() {
		x = 190;
		y = 535;
		setIcon(playerR);
		setSize(50, 50); // 위치도 필요함
		setLocation(x, y); // paintComponent 호출

		isRight = false; //
		isLeft = false;
		isJump = false;
		isUp = false;
		isDown = false;
	}

	public void left() {
		new Thread(() -> {
			isLeft = true;
			while (isLeft) {
				if (x >= 80) {
					x = x - SPEED;
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
					x = x + SPEED;
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

	public void up() {
		while (isUp) {
			for (int j = 0; j < 130 / JUMPSPEED; j++) {
				y = y - JUMPSPEED;
				setLocation(x, y);
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			isUp = false;
		}
	}

	public void down() {
		if (x >= 120 && x <= 170 || x >= 770 && x <= 820) {
			while (isDown) {
				for (int i = 0; i < 130 / JUMPSPEED; i++) {
					if (y < 535) {
						y = y + JUMPSPEED;
						setLocation(x, y);
//			System.out.println(y);
					} else {
						break;
					}
					try {
						Thread.sleep(3);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				isDown = false;
			}
		} else {

		}

	}

	public void jump() {

		new Thread(() -> {
			isJump = true;
			isUp = true;
			up();
			isDown = true;
			down();
			isJump = false;

		}).start();

//		System.out.println("점프실행");
	}

}
