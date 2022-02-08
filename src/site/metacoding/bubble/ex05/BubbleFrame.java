package site.metacoding.bubble.ex05;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 
 * @author ������ ���� : ���� �߰�
 * 
 */

public class BubbleFrame extends JFrame {

	private JLabel backgroundMap;
	private Player player;

	public BubbleFrame() {
		initObject();
		initSetting();
		initListener();
		setVisible(true); // ���ο� paintComponent() ȣ�� �ڵ尡 �ִ�. Ÿ���� ������ ������ �������� �ٽ� �׸���.
	}

	// new �ϴ� ��
	private void initObject() {
		backgroundMap = new JLabel(new ImageIcon("image/backgroundMap.png"));
//		add(backgroundMap); // �׳� add�ϸ� ��ġ�� ����־�� �Ѵ�.
		setContentPane(backgroundMap); // ���ȭ�� ���� - �г���ü�� ���̴°�

		player = new Player();
		add(player); // x�� �������� �ٽ� �׷����� �ʾ�(setLocation) �ݿ��� ���� �ʴ´�.
		System.out.println(player.x);
	}

	private void initSetting() {
		setSize(1000, 640); // ������ ����
		getContentPane().setLayout(null); // JFrame�� �⺻ JPanel�� ���̾ƿ� ����
		setLocationRelativeTo(null); // ��� ��ġ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x��ư Ŭ���� JVM ���� �����ϱ�
	}

	private void initListener() {
		addKeyListener(new KeyListener() { // �޼��尡 3���̹Ƿ� ���ٷδ� ����� �ȵȴ�.

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
//				System.out.println("Ű���� ������");
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) { // �Ǽ��� �� �ֱ� ������ final static���� �Ǿ��ִ°� �̵��Ѵ�.
					// isRight�� false
					player.setRight(false);
				} else if (e.getKeyCode() == 37) {
					player.setLeft(false);
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// ���� : 37 ������ : 39 ���� : 38 �Ʒ��� : 40
//				System.out.println("Ű���� ������ : " + e.getKeyCode());
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) { // �Ǽ��� �� �ֱ� ������ final static���� �Ǿ��ִ°� �̵��Ѵ�.
					// Ű���带 ������ �ִ� ���� right �޼��带 �ѹ��� �����ϰ� �ʹ�.
					if (!player.isRight()) {
						player.Right();
//						System.out.println("������ �̵�");
					}
				} else if (e.getKeyCode() == 37) {
					if (!player.isLeft()) {
						player.left();
					}
				} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					if (!player.isJump()) {
						player.Jump();
					}
				}
			}

		});
	}

	public static void main(String[] args) {
		new BubbleFrame();
	}

}
