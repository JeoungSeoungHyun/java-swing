package site.metacoding.test;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 
 * @author ������ ���� : �����ӿ� ���ȭ�� �߰�
 *
 */
public class BubbleFrame extends JFrame {

	private JLabel backgroundMap;

	// 1. �����ڸ� ���� �������� �����Ѵ�.
	public BubbleFrame() {
		initSetting();
		initObject();
		setVisible(true);
	}

	// ������Ʈ ���� �޼���
	private void initObject() {
		backgroundMap = new JLabel(new ImageIcon("image/backgroundMap.png"));
		setContentPane(backgroundMap);
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

	public static void main(String[] args) {
		new BubbleFrame();
	}

}
