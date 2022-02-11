package site.metacoding.bubble.test;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Bubble extends JLabel {

	// 이미지 생성 위한 변수
	private ImageIcon bubble;

	// 방울의 좌표를 위한 변수
	private int x;
	private int y;

	// 의존성 주입을 위한 context 변수
	private BubbleFrame context;
	private Player player;

	// 방울 속력 위한 변수
	private final int BUBBLESPEED = 1;

	// 생성자 통한 방울 생성
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

	// 방울 왼쪽 발사
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

	// 방울 오른쪽 발사
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
