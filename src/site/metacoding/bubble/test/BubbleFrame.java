package site.metacoding.bubble.test;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 
 * @author ������ ���� : �÷��̾� �¿� �̵� ���� //���� :Ű�� ������ ���� �޼��尡 ��� ȣ��ȴ�. ->Ű�� ������ ���� �޼����
 *         �ѹ� ȣ��ǰ� ���� ���� �޼��尡 �ߴܵȴ�. // �ʿ�:�޼��尡 �������� ���� �� �� �ִ� ����
 *
 */
public class BubbleFrame extends JFrame {

	private JLabel backgroundMap;
	private Player player;

	// �����ڸ� ���� �������� �����Ѵ�.
	public BubbleFrame() {
		initSetting();
		initObject();
		addObject();
		initListener();
		setVisible(true);
	}

	// ������Ʈ ���� �޼���
	private void initObject() {
		// ���ȭ���� ���� ���̺� ���� �� ���ȭ�鿡 �߰�
		backgroundMap = new JLabel(new ImageIcon("image/backgroundMap.png"));

		// �÷��̾� ����
		player = new Player();

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
