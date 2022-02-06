package site.metacoding.ex13;

import javax.swing.JButton;
import javax.swing.JPanel;

public class NullLayoutEx01 extends MyFrame {

	int x = 0; // ���ٽ� �ȿ��� ���ú��� ���� �Ұ���(���ú����� �Ķ���� ���� ���� ���ؼ�?)
	int y = 0; // Ŭ�������� ������ �ʱ�ȭ���ش�.
	boolean isActive = true;

	public NullLayoutEx01() {
		super(300, 300);

		JPanel panel = (JPanel) getContentPane();
		panel.setLayout(null);

		JButton btn1 = new JButton("��ư1");
		panel.add(btn1);
		btn1.setSize(100, 50); // ��ưũ�� �����ֱ�
		btn1.setLocation(x, y); // ��ư ��ġ ����ֱ�

		Thread t1 = new Thread(() -> {

			while (isActive) {
				try {
					if (x < 200) {
//						System.out.println("x+1");
						x = x + 10;
						btn1.setLocation(x, y);
						Thread.sleep(10);
					} else if (x >= 200) {
//						System.out.println("���� ����");
						x = 0;
						y = y + 10;
						btn1.setLocation(x, y);
						Thread.sleep(10);
					} else if (y > 250) {
						System.out.println("�̵�����");
						isActive = false;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});
		t1.start();

		setVisible(true);
	}

	public static void main(String[] args) {
		new NullLayoutEx01();
		System.out.println("��������");
	}

}
