package site.metacoding.practice;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class BubbleApp extends JFrame implements Init {

	// 3. �±� ������ֱ�
	private static final String TAG = "BubbleApp : ";

	// 2. context �ʱ�ȭ
	private BubbleApp mContext = this;

	private BackgroundMap backgroundMap;

	private Player player;

	// 1. ������
	public BubbleApp() {

		// 4. ������ ���� Ȯ��
//		System.out.println(TAG + "������ ���� ");

		// 6. init ����
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

	// 7. �⺻���� �� Ȯ��
	@Override
	public void initSetting() {
		setSize(1000, 640);
		getContentPane().setLayout(null); // JFrame�� �⺻ JPanel�� ���̾ƿ� ����
		setLocationRelativeTo(null); // ��� ��ġ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x��ư Ŭ���� JVM ���� �����ϱ�
	}

	@Override
	public void initListener() {
		mContext.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) { // switch ���� case���� ��
				case KeyEvent.VK_RIGHT:
					if (!player.isRight() && !player.isRightWallCrash() && !player.isLeft())
						player.right();
					break; // ����ġ ����
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
				switch (e.getKeyCode()) { // switch ���� case���� ��
				case KeyEvent.VK_RIGHT:
					player.setRight(false);
					break; // ����ġ ����
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
