package site.metacoding.bubble.test3;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Bubble extends JLabel {

	private BubbleFrame context;
	private Player player;
	private int x;
	private int y;
	private ImageIcon bubble, bomb;

	private final int BUBBLESPEED = 1;

	public Bubble(BubbleFrame context) {
		this.context = context;
		this.player = context.getPlayer();
		move();
		initObject();
		initSetting();
	}

	private void initObject() {
		bubble = new ImageIcon("image/bubble.png");
		bomb = new ImageIcon("image/bubble.png");
	}

	private void initSetting() {
		x = player.getX();
		y = player.getY();
		setIcon(bubble);
		setSize(50, 50);
		setLocation(x, y);
	}

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

	private void move() {
		if (player.getDirection() == 0) {
			left();
		} else {
			right();
		}
	}
}
