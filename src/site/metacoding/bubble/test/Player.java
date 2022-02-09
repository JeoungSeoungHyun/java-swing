package site.metacoding.bubble.test;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * 
 * @author 정성현 / 목적: 벽에 막히기 /필요 : if문
 *
 */
public class Player extends JLabel {
	// 플레이어 좌표
	private int x;
	private int y;

	// 플레이어 이미지아이콘
	private ImageIcon playerR;
	private ImageIcon playerL;

	// 플레이어 이동속력
	private static final int SPEED = 5;

	// 메서드의 동작상태
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

	// 플레이어 생성자를 통해 생성
	public Player() {
		initObject();
		initSetting();
	}

	private void initObject() {
		// 이미지아이콘 생성
		playerR = new ImageIcon("image/playerR.png");
		playerL = new ImageIcon("image/playerL.png");
	}

	private void initSetting() {
		// add하기 위해 필요한 초기좌표 설정
		x = 70;
		y = 535;

		// setIcon과 setSize로 원하는 이미지아이콘 설정 후 setLocation으로 다시 그려주기
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