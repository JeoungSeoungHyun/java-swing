package site.metacoding.test;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import site.metacoding.bubble.ex02.Player;

/**
 * 
 * @author ������ ���� : �÷��̾� ����
 *
 */
public class BubbleFrame extends JFrame {

	private JLabel backgroundMap;
	private JLabel player;

	// 1. �����ڸ� ���� �������� �����Ѵ�.
	public BubbleFrame() {
		initSetting();
		initObject();
		addObject();
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

	public static void main(String[] args) {
		new BubbleFrame();
	}

}
