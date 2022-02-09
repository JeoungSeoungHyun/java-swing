package site.metacoding.bubble.test2;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * 
 * @author 정성현 / 필요: 1.right, left 메서드 작동 확인 변수 2.이벤트 처리 위한 스레드(메서드마다 각자)
 */
public class Player extends JLabel {

	// 좌표를 위한 변수
	private int x;
	private int y;

	// 플레이어 이미지 아이콘 변수
	private ImageIcon playerR;
	private ImageIcon playerL;

	// 플레이어 이동속력 변수
	private final static int SPEED = 4;

	// 메서드 작동 확인 변수
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

	// 생성자 통해 플레이어 생성 및 설정
	public Player() {
		initObject();
		initSetting();
	}

	// 오브젝트 생성 메서드
	private void initObject() {

		// 이미지 아이콘 생성
		playerR = new ImageIcon("image/playerR.png");
		playerL = new ImageIcon("image/playerL.png");
	}

	// 기본 세팅 메서드
	private void initSetting() {

		// add 위한 초기좌표
		x = 70;
		y = 535;

		// 플레이어 사이즈 설정과 그리기
		setIcon(playerR);
		setSize(50, 50);
		setLocation(x, y);

		// 초기 메서드 작동 상태설정
		isRight = false;
		isLeft = false;
	}

	// 오른쪽 이동 메서드
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

	// 왼쪽 이동 메서드
	public void left() {
		x = x - SPEED;
		setLocation(x, y);
		setIcon(playerL);
	}
}