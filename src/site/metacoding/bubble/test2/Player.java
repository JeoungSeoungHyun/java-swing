package site.metacoding.bubble.test2;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * 
 * @author ������ / �ʿ�: 1.right, left �޼��� �۵� Ȯ�� ���� 2.�̺�Ʈ ó�� ���� ������(�޼��帶�� ����)
 */
public class Player extends JLabel {

	// ��ǥ�� ���� ����
	private int x;
	private int y;

	// �÷��̾� �̹��� ������ ����
	private ImageIcon playerR;
	private ImageIcon playerL;

	// �÷��̾� �̵��ӷ� ����
	private final static int SPEED = 4;

	// �޼��� �۵� Ȯ�� ����
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

	// ������ ���� �÷��̾� ���� �� ����
	public Player() {
		initObject();
		initSetting();
	}

	// ������Ʈ ���� �޼���
	private void initObject() {

		// �̹��� ������ ����
		playerR = new ImageIcon("image/playerR.png");
		playerL = new ImageIcon("image/playerL.png");
	}

	// �⺻ ���� �޼���
	private void initSetting() {

		// add ���� �ʱ���ǥ
		x = 70;
		y = 535;

		// �÷��̾� ������ ������ �׸���
		setIcon(playerR);
		setSize(50, 50);
		setLocation(x, y);

		// �ʱ� �޼��� �۵� ���¼���
		isRight = false;
		isLeft = false;
	}

	// ������ �̵� �޼���
	public void right() {
		new Thread(() -> {
			isRight = true;
			while (isRight) {
				x = x + SPEED;
				setLocation(x, y);
				setIcon(playerR);
				try {
					Thread.sleep(10);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

	// ���� �̵� �޼���
	public void left() {
		x = x - SPEED;
		setLocation(x, y);
		setIcon(playerL);
	}
}