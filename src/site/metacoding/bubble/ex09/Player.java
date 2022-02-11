package site.metacoding.bubble.ex09;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * 
 * @author ������ �÷��̾�� �¿� �̵��� �����ϴ�. ������ �����ϴ�. ��� �߻�
 *
 */
public class Player extends JLabel {

	private BubbleFrame context;
	private int x;
	private int y;

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

	private ImageIcon playerR;
	private ImageIcon playerL;

	private boolean isRight;
	private boolean isLeft;
	private boolean isUp;
	private boolean isDown;
	private boolean leftWallCrash;
	private boolean rightWallCrash;

	private int direction; // 0�� ���ʹ���, 1�� ������ ����,���� ����

	private static final int JUMPSPEED = 2;
	private static final int SPEED = 4;

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

	public boolean isDown() {
		return isDown;
	}

	public void setDown(boolean isDown) {
		this.isDown = isDown;
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

	public boolean isUp() {
		return isUp;
	}

	public void setUp(boolean isUp) {
		this.isUp = isUp;
	}

	public Player(BubbleFrame context) {
		this.context = context;
		initObject();
		initSetting();

	}

	private void initObject() {
		playerR = new ImageIcon("image/playerR.png");
		playerL = new ImageIcon("image/playerL.png");
	}

	private void initSetting() {
		x = 90;
		y = 535;
		setIcon(playerR);
		setSize(50, 50); // ��ġ�� �ʿ���
		setLocation(x, y); // paintComponent ȣ��

		isRight = false; //
		isLeft = false;
		isUp = false;
		isDown = false;

		leftWallCrash = false;
		rightWallCrash = false;

		direction = -1;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public void left() {

		new Thread(() -> {
			direction = 0;
			isLeft = true;
			while (isLeft) {
				x = x - SPEED;
				setIcon(playerL);
				setLocation(x, y);
				try {
					Thread.sleep(10);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

	public void Right() {

		new Thread(() -> {
			direction = 1;
			isRight = true;
			while (isRight) {
				x = x + SPEED;
				setIcon(playerR);
				setLocation(x, y);
				try {
					Thread.sleep(10);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

	public void up() {
		new Thread(() -> {
			isUp = true;
			for (int j = 0; j < 130 / JUMPSPEED; j++) {
				y = y - JUMPSPEED;
				setLocation(x, y);
				try {
					Thread.sleep(5);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			isUp = false;
			down();
		}).start();
	}

	public void down() {
		new Thread(() -> {

			isDown = true;
			while (isDown) {
				y = y + JUMPSPEED;
				setLocation(x, y);
//		System.out.println(y);
				try {
					Thread.sleep(3);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
//		isDown = false; // �ٿ ���� ����� �浹�� �ٸ������� �ؾ��Ѵ�.

	}

	public void attack() {
		// 1. ���� new
		Bubble bubble = new Bubble(context);
		// 2. ȭ�鿡 �ٿ��� ��?
		context.add(bubble);
		// 3. �����̵�( �÷��̾� ����)
	}
}
