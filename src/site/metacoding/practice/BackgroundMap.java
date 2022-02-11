package site.metacoding.practice;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class BackgroundMap extends JLabel {

	private ImageIcon backgroundMap; // ���� ���̴� ��
	private BufferedImage image; // ���� �Ⱥ��̴� ����

//	private int x, y;	//������ �����Ƿ� �������� ���¸� ���� �ʿ䰡 ����.

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public BackgroundMap() {

		try {
			image = ImageIO.read(new File("image/backgroundMapService.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		backgroundMap = new ImageIcon("image/backgroundMap.png");
		setIcon(backgroundMap); // Div �ڽ��� �̹��� �ֱ�
	}
}
