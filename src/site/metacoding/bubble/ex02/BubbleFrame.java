package site.metacoding.bubble.ex02;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 
 * @author ������ ���� : ���ȭ�� ����, ĳ���� �߰�
 * 
 */

public class BubbleFrame extends JFrame {

	private JLabel backgroundMap;
	private Player player;

	public BubbleFrame() {
		initObject();
		initSetting();
		setVisible(true); // ���ο� paintComponent() ȣ�� �ڵ尡 �ִ�. Ÿ���� ������ ������ �������� �ٽ� �׸���.
	}

	// new �ϴ� ��
	private void initObject() {
		backgroundMap = new JLabel(new ImageIcon("image/backgroundMap.png"));
//		add(backgroundMap); // �׳� add�ϸ� ��ġ�� ����־�� �Ѵ�.
		setContentPane(backgroundMap); // ���ȭ�� ���� - �г���ü�� ���̴°�

		player = new Player();
		player.x = 300;
		add(player); // x�� �������� �ٽ� �׷����� �ʾ�(setLocation) �ݿ��� ���� �ʴ´�.
		System.out.println(player.x);
	}

	private void initSetting() {
		setSize(1000, 640); // ������ ����
		getContentPane().setLayout(null); // JFrame�� �⺻ JPanel�� ���̾ƿ� ����
		setLocationRelativeTo(null); // ��� ��ġ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x��ư Ŭ���� JVM ���� �����ϱ�
	}

	public static void main(String[] args) {
		new BubbleFrame();

	}

}
