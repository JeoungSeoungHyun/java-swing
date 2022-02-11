package site.metacoding.bubble.test;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * 
 * @author 정성현 / 목적: 점프 /필요: 1.점프 메서드 2.점프 메서드 동작 확인 위한 상태 3. 점프 스피드 상태
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
	private static final int SPEED = 4;

	// 플레이어 점프속력
	private static final int JUMPSPEED = 2;

	// 메서드의 동작상태
	private boolean isRight;
	private boolean isLeft;
	private boolean isUp;
	private boolean isDown;

	// 충돌 감지 확인 변수
	private boolean leftWallCrash;
	private boolean rightWallCrash;

	// context를 알기 위한 변수
	private BubbleFrame context;

	// 캐릭터의 방향을 알기 위한 변수
	private int direction; // 0-왼 / 1-오른

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public boolean isLeftWallCrash() {
		return leftWallCrash;
	}

	public void setLeftWallCrash(boolean leftWallCrash) {
		this.leftWallCrash = leftWallCrash;
	}

	public boolean isRightWallCrash() {
		return rightWallCrash;
	}

	public void setRightWallCrash(boolean rightWallCrash) {
		this.rightWallCrash = rightWallCrash;
	}

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

	public boolean isUp() {
		return isUp;
	}

	public void setUp(boolean isUp) {
		this.isUp = isUp;
	}

	public boolean isDown() {
		return isDown;
	}

	public void setDown(boolean isDown) {
		this.isDown = isDown;
	}

	// 플레이어 생성자를 통해 생성
	public Player(BubbleFrame context) {
		this.context = context;

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
		isUp = false;
		isDown = false;
		leftWallCrash = false;
		rightWallCrash = false;
		direction = -1;
	}

	// 플레이어 오른쪽 이동 메서드
	public void right() {
		new Thread(() -> {

			isRight = true;
			while (isRight) {
				x = x + SPEED;
				setIcon(playerR);
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				setLocation(x, y);

			}
		}).start();
	}

	// 플레이어 왼쪽 이동 메서드
	public void left() {
		new Thread(() -> {
			isLeft = true;

			while (isLeft) {
				x = x - SPEED;
				setIcon(playerL);
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				setLocation(x, y);
			}

		}).start();
	}

	// 플레이어 점프 메서드 리팩토링
	public void up() {
		new Thread(() -> {
			isUp = true;

			for (int i = 0; i < 130 / JUMPSPEED; i++) {
				y = y - JUMPSPEED;
				setLocation(x, y);
				try {
					Thread.sleep(5);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			isUp = false;
			down();
		}).start();
	}

	// 플레이어 다운 메서드 리팩토링
	public void down() {
		new Thread(() -> {
			isDown = true;
			while (isDown) {
				y = y + JUMPSPEED;
				setLocation(x, y);
				try {
					Thread.sleep(3);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

	// 플레이어 방울 생성 메서드
	public void attack() {
		Bubble bubble = new Bubble(context);
		context.add(bubble);
	}
}