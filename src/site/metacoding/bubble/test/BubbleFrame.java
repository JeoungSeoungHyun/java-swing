package site.metacoding.bubble.test;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 
 * @author 정성현 목적 : 플레이어 좌우 이동 개선 //문제 :키를 누르는 동안 메서드가 계속 호출된다. ->키를 누르는 동안 메서드는
 *         한번 호출되고 손을 떼면 메서드가 중단된다. // 필요:메서드가 실행중인 것을 알 수 있는 상태
 *
 */
public class BubbleFrame extends JFrame {

	private JLabel backgroundMap;
	private Player player;

	// 생성자를 통해 프레임을 생성한다.
	public BubbleFrame() {
		initSetting();
		initObject();
		addObject();
		initListener();
		setVisible(true);
	}

	// 오브젝트 생성 메서드
	private void initObject() {
		// 배경화면을 위한 레이블 생성 후 배경화면에 추가
		backgroundMap = new JLabel(new ImageIcon("image/backgroundMap.png"));

		// 플레이어 생성
		player = new Player();

	}

	// 프레임세팅 메서드
	private void initSetting() {
		// 프레임 사이즈 세팅
		setSize(1000, 640);

		// 프레임의 패널 레이아웃을 null로 변경
		getContentPane().setLayout(null);

		// 프레임이 중앙에 위치하도록 세팅
		setLocationRelativeTo(null);

		// 프레임 종료시 JVM도 같이 종료하도록 세팅
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void addObject() {
		// 프레임에 스테이지 배경화면 추가
		setContentPane(backgroundMap);

		// 플레이어 추가
		add(player);
	}

	private void initListener() {
		// 키보드 액션에 대한 리스너 추가 (인터페이스가 3개이므로 람다식 사용 불가. 익명클래스 사용)
		// 키 이벤트에 대한 키코드가 필요 (왼쪽 - 37 / 위쪽 - 38 / 오른쪽 - 39 / 아래쪽 - 40)
		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					player.setLeft(false);
				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					player.setRight(false);
				}

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					if (!player.isLeft()) {
						player.left();
					}
				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					if (!player.isRight()) {
						player.right();
					}
				}
			}
		});
	}

	public static void main(String[] args) {
		new BubbleFrame();
	}

}
