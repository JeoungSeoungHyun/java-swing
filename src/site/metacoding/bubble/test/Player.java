package site.metacoding.bubble.test;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * 
 * @author ������ / ����: ���� /�ʿ�: 1.���� �޼��� 2.���� �޼��� ���� Ȯ�� ���� ���� 3. ���� ���ǵ� ����
 *
 */
public class Player extends JLabel {
	// �÷��̾� ��ǥ
	private int x;
	private int y;

	// �÷��̾� �̹���������
	private ImageIcon playerR;
	private ImageIcon playerL;

	// �÷��̾� �̵��ӷ�
	private static final int SPEED = 4;

	// �÷��̾� �����ӷ�
	private static final int JUMPSPEED = 2;

	// �޼����� ���ۻ���
	private boolean isRight;
	private boolean isLeft;
	private boolean isUp;
	private boolean isDown;

	// �浹 ���� Ȯ�� ����
	private boolean leftWallCrash;
	private boolean rightWallCrash;

	// context�� �˱� ���� ����
	private BubbleFrame context;

	// ĳ������ ������ �˱� ���� ����
	private int direction; // 0-�� / 1-����

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
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

	// �÷��̾� �����ڸ� ���� ����
	public Player(BubbleFrame context) {
		this.context = context;

		initObject();
		initSetting();
	}

	private void initObject() {
		// �̹��������� ����
		playerR = new ImageIcon("image/playerR.png");
		playerL = new ImageIcon("image/playerL.png");
	}

	private void initSetting() {
		// add�ϱ� ���� �ʿ��� �ʱ���ǥ ����
		x = 70;
		y = 535;

		// setIcon�� setSize�� ���ϴ� �̹��������� ���� �� setLocation���� �ٽ� �׷��ֱ�
		setIcon(playerR);
		setSize(50, 50);
		setLocation(x, y);

		isRight = false;
		isLeft = false;
		isUp = false;
		isDown = false;
		leftWallCrash = false;
		rightWallCrash = false;
		direction = -1;
	}

	// �÷��̾� ������ �̵� �޼���
	public void right() {
		new Thread(() -> {

			isRight = true;
			while (isRight) {
				x = x + SPEED;
				setIcon(playerR);
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				setLocation(x, y);

			}
		}).start();
	}

	// �÷��̾� ���� �̵� �޼���
	public void left() {
		new Thread(() -> {
			isLeft = true;

			while (isLeft) {
				x = x - SPEED;
				setIcon(playerL);
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				setLocation(x, y);
			}

		}).start();
	}

	// �÷��̾� ���� �޼��� �����丵
	public void up() {
		new Thread(() -> {
			isUp = true;

			for (int i = 0; i < 130 / JUMPSPEED; i++) {
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

	// �÷��̾� �ٿ� �޼��� �����丵
	public void down() {
		new Thread(() -> {
			isDown = true;
			while (isDown) {
				y = y + JUMPSPEED;
				setLocation(x, y);
				try {
					Thread.sleep(3);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

	// �÷��̾� ��� ���� �޼���
	public void attack() {
		Bubble bubble = new Bubble(context);
		context.add(bubble);
	}
}