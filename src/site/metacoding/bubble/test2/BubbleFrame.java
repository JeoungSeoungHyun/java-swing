package site.metacoding.bubble.test2;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 
 * @author ������ / ���� : �����ӿ� ���ȭ�� �ֱ�
 *
 */
public class BubbleFrame extends JFrame {

	private JLabel backgroundMap;

	// �����ڸ� ���� ������ ���� �� ����
	public BubbleFrame() {
		initObject();
		initSetting();
		addObject();
		setVisible(true);
	}

	// ������Ʈ ���� �޼���
	private void initObject() {
		backgroundMap = new JLabel(new ImageIcon("image/backgroundMap.png"));
	}

	// ���� �޼���
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

	// ������Ʈ �߰� �޼���
	private void addObject() {
		setContentPane(backgroundMap);
	}

	public static void main(String[] args) {
		new BubbleFrame();
	}

}
