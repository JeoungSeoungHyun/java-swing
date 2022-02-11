package site.metacoding.bubble.test;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 
 * @author ������ ���� : ��� ����
 *
 */
public class BubbleFrame extends JFrame {

	private JLabel backgroundMap;
	private Player player;
	private BubbleFrame context = this;

	// �����ڸ� ���� �������� �����Ѵ�.
	public BubbleFrame() {
		initSetting();
		initObject();
		addObject();
		initService();
		initListener();
		setVisible(true);
	}

	// 5. ���񽺸� ���� �޼��� ����
	private void initService() {
		// 6. ���񽺴� ��� ���ư��� �ϱ� ������ ���ο� �����带 ����� �ش�.
		// 7. ���ο� �������� Ÿ���� ����ֱ� ���ؼ� BackgroundMapServiceŬ������ Runnable�� implements���ش�.
		new Thread(new BackgroundMapService(player)).start();
	}

	// ������Ʈ ���� �޼���
	private void initObject() {
		// ���ȭ���� ���� ���̺� ���� �� ���ȭ�鿡 �߰�
		backgroundMap = new JLabel(new ImageIcon("image/backgroundMap.png"));

		// �÷��̾� ����
		player = new Player(context);

	}

	// �����Ӽ��� �޼���
	private void initSetting() {
		// ������ ������ ����
		setSize(1000, 640);

		// �������� �г� ���̾ƿ��� null�� ����
		getContentPane().setLayout(null);

		// �������� �߾ӿ� ��ġ�ϵ��� ����
		setLocationRelativeTo(null);

		// ������ ����� JVM�� ���� �����ϵ��� ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	private void addObject() {
		// �����ӿ� �������� ���ȭ�� �߰�
		setContentPane(backgroundMap);

		// �÷��̾� �߰�
		add(player);
	}

	private void initListener() {
		// Ű���� �׼ǿ� ���� ������ �߰� (�������̽��� 3���̹Ƿ� ���ٽ� ��� �Ұ�. �͸�Ŭ���� ���)
		// Ű �̺�Ʈ�� ���� Ű�ڵ尡 �ʿ� (���� - 37 / ���� - 38 / ������ - 39 / �Ʒ��� - 40)
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
					if (!player.isLeft() && !player.isLeftWallCrash()) {
						player.left();
					}
				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					if (!player.isRight() && !player.isRightWallCrash()) {
						player.right();
					}
				} else if (e.getKeyCode() == KeyEvent.VK_UP) {
					if (!player.isUp()) {
						player.up();
					}
				} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					player.attack();
				}
			}
		});

	}

	public static void main(String[] args) {
		new BubbleFrame();
	}

}
