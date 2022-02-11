package site.metacoding.bubble.test;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Bubble extends JLabel {

	// �̹��� ���� ���� ����
	private ImageIcon bubble;

	// ����� ��ǥ�� ���� ����
	private int x;
	private int y;

	// ������ ������ ���� context ����
	private BubbleFrame context;
	private Player player;

	// ��� �ӷ� ���� ����
	private final int BUBBLESPEED = 1;

	// ������ ���� ��� ����
	public Bubble(BubbleFrame context) {
		this.context = context;
		this.player = context.getPlayer();

		initObject();
		initSetting();
	}

	private void initObject() {
		bubble = new ImageIcon("image/bubble.png");
	}

	private void initSetting() {
		x = player.getX();
		y = player.getY();

		setIcon(bubble);
		setSize(50, 50);
		setLocation(x, y);

		if (player.getDirection() == 0) {
			left();
		} else {
			right();
		}
	}

	// ��� ���� �߻�
	private void left() {
		new Thread(() -> {
			for (int i = 0; i < 400; i++) {
				try {
					x = x - BUBBLESPEED;
					setLocation(x, y);
					Thread.sleep(1);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

	// ��� ������ �߻�
	private void right() {
		new Thread(() -> {
			for (int i = 0; i < 400; i++) {
				try {
					x = x + BUBBLESPEED;
					setLocation(x, y);
					Thread.sleep(1);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
}
