package site.metacoding.bubble.test2;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 
 * @author ������ / ���� : �÷��̾� �̵� ����2(���� �ε�������) / �ʿ� : ���� ��ǥ��x
 *
 */
public class BubbleFrame extends JFrame {

	private JLabel backgroundMap;
	private Player player;

	// �����ڸ� ���� ������ ���� �� ����
	public BubbleFrame() {
		initObject();
		initSetting();
		addObject();
		initListener();
		setVisible(true);
	}

	// ������Ʈ ���� �޼���
	private void initObject() {

		// ���ȭ�� ���̺� ����
		backgroundMap = new JLabel(new ImageIcon("image/backgroundMap.png"));

		// �÷��̾� ����
		player = new Player();
	}

	// ������ ���� �޼���
	private void initSetting() {

		// ������ ������ ����
		setSize(1000, 640);

		// ������ �߾� ��ġ
		setLocationRelativeTo(null);

		// �������� �г� ���̾ƿ� null ����
		getContentPane().setLayout(null);

		// ������ ����� JVM ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	// ������Ʈ ���̱� �޼���
	private void addObject() {

		// ���ȭ�� �߰�
		setContentPane(backgroundMap);

		// �÷��̾� �߰�
		add(player);

	}

	// Ű���� �׼� �ν� ���� ������ (�������̽��� 3���̹Ƿ� ���ٽ� �Ұ���. �͸�Ŭ���� ���)
	// Ű �̺�Ʈ�� ó���ϱ� ���� Ű�ڵ� �ʿ�
	private void initListener() {
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
