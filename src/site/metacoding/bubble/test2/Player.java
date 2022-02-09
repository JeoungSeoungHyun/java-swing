package site.metacoding.bubble.test2;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * 
 * @author 정성현 / 필요: 1.right메서드 2.left메서드 3.플레이어 이동속도 4.플레이어 왼쪽방향 이미지아이콘
 */
public class Player extends JLabel {

	private int x;
	private int y;
	private ImageIcon playerR;
	private ImageIcon playerL;
	private final static int SPEED = 4;

	// 생성자 통해 플레이어 생성 및 설정
	public Player() {
		initObject();
		initSetting();
	}

	// 오브젝트 생성 메서드
	private void initObject() {
		playerR = new ImageIcon("image/playerR.png");
		playerL = new ImageIcon("image/playerL.png");
	}

	// 기본 세팅 메서드
	private void initSetting() {

		// add 위한 좌표
		x = 70;
		y = 535;

		// 플레이어 사이즈 설정과 그리기
		setIcon(playerR);
		setSize(50, 50);
		setLocation(x, y);
	}

	// 오른쪽 이동 메서드
	public void right() {
		x = x + SPEED;
		setLocation(x, y);
		setIcon(playerR);
	}

	// 왼쪽 이동 메서드
	public void left() {
		x = x - SPEED;
		setLocation(x, y);
		setIcon(playerL);
	}
}