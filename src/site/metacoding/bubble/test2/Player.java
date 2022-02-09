package site.metacoding.bubble.test2;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * 
 * @author ������ / �ʿ�: 1.right�޼��� 2.left�޼��� 3.�÷��̾� �̵��ӵ� 4.�÷��̾� ���ʹ��� �̹���������
 */
public class Player extends JLabel {

	private int x;
	private int y;
	private ImageIcon playerR;
	private ImageIcon playerL;
	private final static int SPEED = 4;

	// ������ ���� �÷��̾� ���� �� ����
	public Player() {
		initObject();
		initSetting();
	}

	// ������Ʈ ���� �޼���
	private void initObject() {
		playerR = new ImageIcon("image/playerR.png");
		playerL = new ImageIcon("image/playerL.png");
	}

	// �⺻ ���� �޼���
	private void initSetting() {

		// add ���� ��ǥ
		x = 70;
		y = 535;

		// �÷��̾� ������ ������ �׸���
		setIcon(playerR);
		setSize(50, 50);
		setLocation(x, y);
	}

	// ������ �̵� �޼���
	public void right() {
		x = x + SPEED;
		setLocation(x, y);
		setIcon(playerR);
	}

	// ���� �̵� �޼���
	public void left() {
		x = x - SPEED;
		setLocation(x, y);
		setIcon(playerL);
	}
}