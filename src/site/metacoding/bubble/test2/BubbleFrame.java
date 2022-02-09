package site.metacoding.bubble.test2;

import javax.swing.JFrame;

/**
 * 
 * @author ������ / ���� : �⺻ ������ �����
 *
 */
public class BubbleFrame extends JFrame {

	// �����ڸ� ���� ������ ���� �� ����
	public BubbleFrame() {
		initObject();
		initSetting();
		setVisible(true);
	}

	private void initObject() {

	}

	private void initSetting() {
		// ������ ������ ����
		setSize(1000, 640);

		// ������ �߾� ��ġ
		setLocationRelativeTo(null);

		// �������� �г� ���̾ƿ� null ����
		getContentPane().setLayout(null);

		// xŰ Ŭ���� JVM ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		new BubbleFrame();
	}

}
