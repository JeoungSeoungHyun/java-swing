package site.metacoding.ex13;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import site.metacoding.ex13.constant.BorderConstant;

enum Constant {
	North, EAST, WEST, SOUTH, CENTER
}

public class BorderLayoutEx01 extends MyFrame {

	public BorderLayoutEx01() {
		super(500, 500); // ������ ������ϸ�

		JPanel panel = (JPanel) getContentPane();
		panel.setLayout(new BorderLayout()); // ��������!! ����Ʈ�� BorderLayout �̴ϱ�

		JButton btnNorth = new JButton("����");
		JButton btnEast = new JButton("����");
		JButton btnWest = new JButton("����");
		JButton btnSouth = new JButton("����");
		JButton btnCenter = new JButton("���");

		// Border���̾ƿ��� ������ ��ư add�� ������ �����־�� �ϴµ� ������ ���� �������� �Ǽ��� �߻��� �� �ֱ� ������
		// ����� ����� �Ǽ��� ���� �ʵ��� �Ѵ�. �̷��� �ص� �Ǽ��� ���ü������Ƿ� enum�� ����Ѵ�.
		panel.add(btnNorth, BorderConstant.NORTH);
		panel.add(btnEast, BorderConstant.EAST);
		panel.add(btnWest, BorderConstant.WEST);
		panel.add(btnSouth, BorderConstant.SOUTH);
		panel.add(btnCenter, BorderConstant.CENTER);

		setVisible(true); // paint �޼��� //���� �������� setVisible���־�ߵ�
	}

	public static void main(String[] args) {
		new BorderLayoutEx01();
	}

}
