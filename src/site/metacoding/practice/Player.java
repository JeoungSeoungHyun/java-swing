package site.metacoding.practice;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player extends JLabel implements Moveable {

	private final static String TAG = "Player : ";
	private ImageIcon playerR, playerL;

	private int x, y;

	private BackgroundMap backgroundMap;

	private boolean leftWallCrash, rightWallCrash;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

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

	public boolean isUp() {
		return isUp;
	}

	public void setUp(boolean isUp) {
		this.isUp = isUp;
	}

	public boolean isDown() {
		return isDown;
	}

	public void setDown(boolean isDown) {
		this.isDown = isDown;
	}

	private boolean isRight, isLeft, isUp, isDown;

	public Player(BackgroundMap backgroundMap) {
		this.backgroundMap = backgroundMap;
		playerR = new ImageIcon("image/playerR.png");
		playerL = new ImageIcon("image/playerL.png");

		x = 70;
		y = 535;
		setIcon(playerR);
		setSize(50, 50);
		setLocation(x, y); // JLabel의 위치

		isLeft = false;
		isRight = false;
		isUp = false;
		isDown = false;
		leftWallCrash = false;
		rightWallCrash = false;
	}

	@Override
	public void left() {
		System.out.println(TAG + "left()");
		new Thread(() -> {
			isLeft = true;
			rightWallCrash = false;
			try {
				setIcon(playerL);
				while (isLeft) {
					x = x - 4;
					setLocation(x, y); // paintComponent()를 자동 호출해준다. 내부적으로 repaint가 된다.
					Thread.sleep(10);
					왼쪽벽충돌감지();
					바닥충돌감지();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}).start();
	}

	@Override
	public void right() {
		System.out.println(TAG + "right()");
		new Thread(() -> {
			isRight = true;
			leftWallCrash = false;
			try {
				setIcon(playerR);
				while (isRight) {
					x = x + 4;
					setLocation(x, y); // paintComponent()를 자동 호출해준다. 내부적으로 repaint가 된다.
					Thread.sleep(10);
					오른쪽벽충돌감지();
					바닥충돌감지();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}).start();
	} // 이게 종료될 때 paintComponent() -> repaint() 호출됨.

	@Override
	public void up() {
		System.out.println(TAG + "up()");
		new Thread(() -> {
			isUp = true;
			try {
				for (int i = 0; i < 65; i++) {
					y = y - 2;
					setLocation(x, y);
					Thread.sleep(5);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			isUp = false;
			down();
		}).start();
	}

	@Override
	public void down() {
		System.out.println(TAG + "dwon()");
		new Thread(() -> {
			isDown = true;
			try {
				while (isDown) {
					y = y + 2;
					setLocation(x, y);
					Thread.sleep(3);
					바닥충돌감지();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}).start();
	}

	private void 왼쪽벽충돌감지() {
//		System.out.println(TAG + "왼쪽 벽 충돌 계산중");
		Color leftColor = new Color(backgroundMap.getImage().getRGB(x - 10, y + 25));

		if (leftColor.getRed() == 255 && leftColor.getBlue() == 0 && leftColor.getGreen() == 0) {
//			System.out.println(TAG + "왼쪽 벽에 충돌함");
			isLeft = false;
			leftWallCrash = true;
		}
	}

	private void 오른쪽벽충돌감지() {
//		System.out.println(TAG + "오른쪽 벽 충돌 계산중");
		Color rightColor = new Color(backgroundMap.getImage().getRGB(x + 50 + 5, y + 25));

		if (rightColor.getRed() == 255 && rightColor.getBlue() == 0 && rightColor.getGreen() == 0) {
//			System.out.println(TAG + "오른쪽 벽에 충돌함");
			isRight = false;
			rightWallCrash = true;
		}
	}

	private void 바닥충돌감지() {
//		System.out.println(TAG + " 바닥 충돌 계산중");
		int bottomColor = backgroundMap.getImage().getRGB(x + 10, y + 50 + 5) // -1
				+ backgroundMap.getImage().getRGB(x + 50 - 10, y + 50 + 5); // -1

		if (bottomColor != -2) {
			System.out.println(TAG + "바닥에 장애물이 있어요");
			isDown = false;
		} else {
			System.out.println(TAG + "바닥이 흰색 ");
			if (isDown == false && isUp == false) {
				down();
			}
		}
	}

	public boolean isLeftWallCrash() {
		return leftWallCrash;
	}

	public void setLeftWallCrash(boolean leftWallCrash) {
		this.leftWallCrash = leftWallCrash;
	}

	public boolean isRightWallCrash() {
		return rightWallCrash;
	}

	public void setRightWallCrash(boolean rightWallCrash) {
		this.rightWallCrash = rightWallCrash;
	}
}
