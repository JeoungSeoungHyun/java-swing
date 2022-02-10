package site.metacoding.bubble.test;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BackgroundMapService implements Runnable {

	// �����ڰ� �÷��̾��� �������� �˾ƾ��ϱ⶧���� �÷��̾� ���� ����� �����ڿ��� �Ű������� �ޱ�
	private Player player;

	// �̹����� ���̴� ���� �ƴ� Ȱ���ϱ� ���Ѱ��̱� ������ BufferedImage�� �޴´�. -> BufferedImage���� �ʿ�
	private BufferedImage image;

	// ������ ������ֱ�
	public BackgroundMapService(Player player) {
		this.player = player;

		// �̹��� ���� -> ���۷� �޴°Ŷ� try/catch
		try {
			image = ImageIO.read(new File("image/backgroundMapService.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {

		// ��� ���ư����� while�� �ɾ��ش�.
		while (true) {

			// ���� Ȯ���� ���� Color ���� ����
			try {

				// ���⺰ Ȯ���� Color ���� ����
				Color leftColor = new Color(image.getRGB(player.getX() - 10, player.getY() + 25));
				Color rightColor = new Color(image.getRGB(player.getX() + 50 + 15, player.getY() + 25));

				if (leftColor.getRed() == 255 && leftColor.getBlue() == 0 && leftColor.getGreen() == 0) {
					System.out.println("���� ���� �浹��");
				} else if (rightColor.getRed() == 255 && rightColor.getBlue() == 0 && rightColor.getGreen() == 0) {
					System.out.println("������ ���� �浹��");
				}

				// ������ ����
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
