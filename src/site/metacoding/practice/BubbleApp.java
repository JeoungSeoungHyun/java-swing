package site.metacoding.practice;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class BubbleApp extends JFrame implements Init {

	// 3. 태그 만들어주기
	private static final String TAG = "BubbleApp : ";

	// 2. context 초기화
	private BubbleApp mContext = this;

	private BackgroundMap backgroundMap;

	private Player player;

	// 1. 생성자
	public BubbleApp() {

		// 4. 생성자 실행 확인
//		System.out.println(TAG + "생성자 실행 ");

		// 6. init 실행
		initObject();
		initSetting();
		initListener();
		setVisible(true);
	}

	@Override
	public void initObject() {
		backgroundMap = new BackgroundMap();
		setContentPane(backgroundMap);

		player = new Player(backgroundMap);
		add(player);

	}

	// 7. 기본세팅 후 확인
	@Override
	public void initSetting() {
		setSize(1000, 640);
		getContentPane().setLayout(null); // JFrame의 기본 JPanel의 레이아웃 설정
		setLocationRelativeTo(null); // 가운데 배치
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x버튼 클릭시 JVM 같이 종료하기
	}

	@Override
	public void initListener() {
		mContext.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) { // switch 값과 case값을 비교
				case KeyEvent.VK_RIGHT:
					if (!player.isRight() && !player.isRightWallCrash() && !player.isLeft())
						player.right();
					break; // 스위치 종료
				case KeyEvent.VK_LEFT:
					if (!player.isLeft() && !player.isLeftWallCrash() && !player.isRight())
						player.left();
					break;
				case KeyEvent.VK_UP:
					if (!player.isUp())
						player.up();
					break;
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				switch (e.getKeyCode()) { // switch 값과 case값을 비교
				case KeyEvent.VK_RIGHT:
					player.setRight(false);
					break; // 스위치 종료
				case KeyEvent.VK_LEFT:
					player.setLeft(false);
					break;
				}
			}
		});
	}

	public static void main(String[] args) {
		new BubbleApp();
	}
}
