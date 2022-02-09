package site.metacoding.test;

import javax.swing.JFrame;

/**
 * 
 * @author ������ ���� : �⺻ ������ �߰�
 *
 */
public class BubbleFrame extends JFrame {

	// 1. �����ڸ� ���� �������� �����Ѵ�.
	public BubbleFrame() {
		initSetting();
		initObject();
		setVisible(true);
	}

	// ������Ʈ ���� �޼���
	private void initObject() {

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