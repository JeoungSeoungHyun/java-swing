package site.metacoding.bubble.test;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * 
 * @author ������ / ����: ���� ������ /�ʿ� : if��
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
	private static final int SPEED = 5;

	// �޼����� ���ۻ���
	private boolean isRight;
	private boolean isLeft;

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
	}

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
}