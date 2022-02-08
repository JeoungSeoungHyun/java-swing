package site.metacoding.bubble.ex05;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * 
 * @author 정성현 플레이어는 좌우 이동이 가능하다. 점프가 가능하다. 방울 발사
 *
 */
public class Player extends JLabel {

	public int x;
	public int y;
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

	public boolean isJump() {
		return isJump;
	}

	public void setJump(boolean isJump) {
		this.isJump = isJump;
	}

	private boolean isRight;
	private boolean isLeft;
	private boolean isJump;
	private boolean isUp;
	private boolean isDown;

	public Player() {
		initObject();
		initSetting();

	}

	private void initObject() {
		playerR = new ImageIcon("image/playerR.png");
		playerL = new ImageIcon("image/playerL.png");
	}

	private void initSetting() {
		x = 820;
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

	public void up() {
		new Thread(() -> {
			while (isUp) {
				for (int j = 0; j < 15; j++) {
					y = y - 10;
					setLocation(x, y);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				isUp = false;
				isDown = true;
			}
		}).start();
	}

	public void down() {
		new Thread(() -> {

			while (isDown) {
				for (int i = 0; i < 15; i++) {
					y = y + 10;
					setLocation(x, y);
//		System.out.println(y);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				isDown = false;
				isJump = false;
			}
		}).start();
	}

	public void Jump() {

		new Thread(() -> {
			isJump = true;
			isUp = true;
			if (isUp) {
				up();
			}
			System.out.println(y);

		}).start();

//		System.out.println("점프실행");
	}

}
