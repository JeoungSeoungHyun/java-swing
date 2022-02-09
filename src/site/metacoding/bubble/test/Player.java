package site.metacoding.bubble.test;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * 
 * @author ������ / ����: �¿� �̵� / �ʿ�: 1.ĳ���� �̵� ���� ���� speed 2. right /left �޼��� 3. ����
 *         ���� �̹��� ������
 *
 */
public class Player extends JLabel {
	// �÷��̾� �����ڸ� ���� ����
	private int x;
	private int y;
	private ImageIcon playerR;
	private ImageIcon playerL;
	private static final int SPEED = 5;

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
	}

	public void right() {
		x = x + SPEED;
		setIcon(playerR);
		setLocation(x, y);
	}

	public void left() {
		x = x - SPEED;
		setIcon(playerL);
		setLocation(x, y);
	}

}
