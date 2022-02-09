package site.metacoding.bubble.practice;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 
 * @author 정성현 목적 : 중력 구현
 * 
 */

public class BubbleFrame extends JFrame {

	private JLabel backgroundMap;
	private Player player;

	public BubbleFrame() {
		initObject();
		Gravity();
		initSetting();
		initListener();
		setVisible(true); // 내부에 paintComponent() 호출 코드가 있다. 타겟을 정하지 않으면 프레임을 다시 그린다.
	}

	// new 하는 것
	private void initObject() {
		backgroundMap = new JLabel(new ImageIcon("image/backgroundMap.png"));
//		add(backgroundMap); // 그냥 add하면 위치를 잡아주어야 한다.
		setContentPane(backgroundMap); // 배경화면 설정 - 패널자체에 붙이는것

		player = new Player();
		add(player); // x는 변했지만 다시 그려지지 않아(setLocation) 반영이 되지 않는다.
		System.out.println(player.x);
	}

	private void initSetting() {
		setSize(1000, 640); // 사이즈 설정
		getContentPane().setLayout(null); // JFrame의 기본 JPanel의 레이아웃 설정
		setLocationRelativeTo(null); // 가운데 배치
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x버튼 클릭시 JVM 같이 종료하기
	}

	private void initListener() {
		addKeyListener(new KeyListener() { // 메서드가 3개이므로 람다로는 사용이 안된다.

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
//				System.out.println("키보드 릴리즈");
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) { // 실수할 수 있기 때문에 final static으로 되어있는걸 이동한다.
					// isRight를 false
					player.setRight(false);
				} else if (e.getKeyCode() == 37) {
					player.setLeft(false);
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// 왼쪽 : 37 오른쪽 : 39 위쪽 : 38 아래쪽 : 40
//				System.out.println("키보드 프레스 : " + e.getKeyCode());
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) { // 실수할 수 있기 때문에 final static으로 되어있는걸 이동한다.
					// 키보드를 누르고 있는 동안 right 메서드를 한번만 실행하고 싶다.
					if (!player.isRight()) {
						player.Right();
//						System.out.println("오른쪽 이동");
					}
				} else if (e.getKeyCode() == 37) {
					if (!player.isLeft()) {
						player.left();
					}
				} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					if (!player.isJump()) {
						player.jump();
					}
				}
			}

		});
	}

	public void Gravity() {
		new Thread(() -> {
			while (true) {
				try {
					if (player.getX() >= 120 && player.getX() <= 170 || player.getX() >= 770 && player.getX() <= 820) {
						if (player.getY() <= 535) {
							if (!player.isJump()) {
//								System.out.println(isDown);
								while (player.getY() != 535) {
									player.setDown(true);
									player.down();
								}
							}
						}
					}
//					System.out.println("중력스레드 실행중");
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}).start();
	}

	public static void main(String[] args) {
		new BubbleFrame();
	}

}
