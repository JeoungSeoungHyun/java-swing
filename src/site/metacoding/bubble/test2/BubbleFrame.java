package site.metacoding.bubble.test2;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 
 * @author 정성현 / 목적 : 플레이어 좌우이동 / 필요 : 1.키보드 액션 인식 위한 리스너 2.캐릭터 클래스 좌우이동 메서드
 *
 */
public class BubbleFrame extends JFrame {

	private JLabel backgroundMap;
	private Player player;

	// 생성자를 통해 프레임 생성 및 설정
	public BubbleFrame() {
		initObject();
		initSetting();
		addObject();
		initListener();
		setVisible(true);
	}

	// 오브젝트 생성 메서드
	private void initObject() {
		backgroundMap = new JLabel(new ImageIcon("image/backgroundMap.png"));

		player = new Player();
	}

	// 세팅 메서드
	private void initSetting() {

		// 프레임 사이즈 설정
		setSize(1000, 640);

		// 프레임 중앙 위치
		setLocationRelativeTo(null);

		// 프레임의 패널 레이아웃 null 설정
		getContentPane().setLayout(null);

		// x키 클릭시 JVM 종료
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	// 오브젝트 붙이기 메서드
	private void addObject() {

		// 배경화면 추가
		setContentPane(backgroundMap);

		// 플레이어 추가
		add(player);

	}

	// 키보드 액션 인식 위한 리스너 (인터페이스가 3개이므로 람다식 불가능. 익명클래스 사용)
	// 키 이벤트를 처리하기 위한 키코드 필요
	private void initListener() {
		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					player.left();
				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					player.right();
				}

			}
		});
	}

	public static void main(String[] args) {
		new BubbleFrame();
	}

}
