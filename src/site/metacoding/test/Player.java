package site.metacoding.test;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player extends JLabel {
	// �÷��̾� �����ڸ� ���� ����
	private int x;
	private int y;
	private ImageIcon playerR;

	public Player() {
		initObject();
		initSetting();
	}

	private void initObject() {
		// ������ �ٶ󺸴� �̹��������� ����
		playerR = new ImageIcon("image/playerR.png");
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

}
