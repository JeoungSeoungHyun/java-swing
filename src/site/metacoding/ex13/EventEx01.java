package site.metacoding.ex13;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EventEx01 extends JFrame { // Frame-awt�� OS swing�� java�� ���� swing�� ��𼭵� �ȴ�.

	JPanel myPanel; // �гΰ� ��ư������ ���������� �����Ѵ�. ���� �־�ߵǱ� ������
	JButton btn1;// ctrl + shift + o
	JButton btn2;
	JCheckBox checkBox1;
	JLabel labelText, labelImg; // div ������

	public EventEx01() {
		initSetting();
		initObject();
		initAssign();
		initListener();

		setVisible(true);
	}

	private void initSetting() {
		setSize(300, 300);
		setLocationRelativeTo(null); // ������ ȭ�� �߾� ��ġ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x��ư Ŭ���� ��������
	}

	private void initObject() {
		myPanel = new JPanel();
		btn1 = new JButton("��ư1");
		btn2 = new JButton("��ư2");
		checkBox1 = new JCheckBox();
		labelText = new JLabel("���̺�1");
		// �� ������Ʈ ��ġ���� ����ΰ� �����Ǿ� �ִ�.
		labelImg = new JLabel(new ImageIcon("Image/dog.jpg"));
	}

	private void initAssign() {
		add(myPanel);
		myPanel.add(btn1);
		myPanel.add(btn2);
		myPanel.add(checkBox1);
		myPanel.add(labelText);

		myPanel.add(labelImg);

	}

	private void initListener() {
		// ������� ���Ѻ���!! �� ��ư��
		btn1.addActionListener(new ActionListener() { // �����찡 litener�� ���� ���Ѻ��µ� null�� �Ǿ��ִ� ��� ���Ѻ��� ������ ���� �𸥴�.
														// �׷��Ƿ� task�� �Ҵ����־�� �Ѵ�.

			// ��ư�� Ŭ���Ǹ� �����찡 �ش� �޼��带 �ݹ����ش�.
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("��ư1�� Ŭ���Ǿ����ϴ�.");

			}
		});

		btn2.addActionListener((ActionEvent e) -> {
			System.out.println("��ư2�� Ŭ���Ǿ����ϴ�.");
		});

		checkBox1.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
//						System.out.println(e.getStateChange());
				if (e.getStateChange() == 1) {
					System.out.println("üũ�Ǿ����ϴ�.");
				} else {
					System.out.println("üũ�����Ǿ����ϴ�.");
				}
			}
		});
	}

	public static void main(String[] args) {
		new EventEx01();
	}

}
