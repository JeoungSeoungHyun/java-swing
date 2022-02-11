package site.metacoding.bubble.test3;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 
 * @author ������ ���� : ���� �������� �߻縸 �ϱ�
 * 
 */
// main�� ���� Ŭ������ �ش� ���α׷��� ���ؽ�Ʈ(����)�� �� �˰� �ִ�.
public class BubbleFrame extends JFrame {

	private BubbleFrame context = this;
	private JLabel backgroundMap;
	private Player player;
	int count = 0;

	public BubbleFrame() {
		initObject();
		initSetting();
		initListener();
		initServiece();
		setVisible(true); // ���ο� paintComponent() ȣ�� �ڵ尡 �ִ�. Ÿ���� ������ ������ �������� �ٽ� �׸���.
	}

	private void initServiece() {
		new Thread(new BackgroundMapService(player)).start();
	}

	// new �ϴ� ��
	private void initObject() {
		backgroundMap = new JLabel(new ImageIcon("image/backgroundMap.png"));
//		add(backgroundMap); // �׳� add�ϸ� ��ġ�� ����־�� �Ѵ�.
		setContentPane(backgroundMap); // ���ȭ�� ���� - �г���ü�� ���̴°�

		player = new Player(context);
		add(player); // x�� �������� �ٽ� �׷����� �ʾ�(setLocation) �ݿ��� ���� �ʴ´�.
		System.out.println(player.getX());

	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
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
					if (player.isRight() == false && player.isRightWallCrash() == false) {
						player.Right();
						player.setDirection(1);
//						System.out.println("������ �̵�");
					}
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					if (player.isLeft() == false && player.isLeftWallCrash() == false) {
						player.left();
						player.setDirection(0);
					}
				} else if (e.getKeyCode() == KeyEvent.VK_UP) { // 1. �� ������ ������ �̺�Ʈ ���� ����� ���ϴ� ��!! => ������ ��ϵ� ������ �˻絵 2��
																// �Ŀ� �Ǳ� ������ �̷��� �������� ����.
					if (player.isUp() == false && player.isDown() == false) {
						player.up(); // 2. �޼��� ���ο��� if �б� ó���� �̺�Ʈ ������ ����� �Ǵµ� ������ �ȵǰ� �ϴ� ��!!
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