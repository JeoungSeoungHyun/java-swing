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
	private boolean isJump;

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

	// �÷��̾� �����ڸ� ���� ����
	public Player() {
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
		isJump = false;
	}

	// �÷��̾� ������ �̵� �޼���
	public void right() {
		new Thread(() -> {

			isRight = true;
			while (isRight) {
				if (x <= 870) {
					x = x + SPEED;
					setIcon(playerR);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					setLocation(x, y);
				}
			}
		}).start();
	}

	// �÷��̾� ���� �̵� �޼���
	public void left() {
		new Thread(() -> {
			isLeft = true;

			while (isLeft) {
				if (x >= 80) {
					x = x - SPEED;
					setIcon(playerL);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					setLocation(x, y);
				}
			}
		}).start();
	}

	// �÷��̾� ���� �޼���
	public void jump() {
		new Thread(() -> {
			isJump = true;

			for (int i = 0; i < 130 / JUMPSPEED; i++) {
				y = y - JUMPSPEED;
				setLocation(x, y);
				try {
					Thread.sleep(5);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			for (int i = 0; i < 130 / JUMPSPEED; i++) {
				y = y + JUMPSPEED;
				setLocation(x, y);
				try {
					Thread.sleep(3);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			isJump = false;
		}).start();
	}
}