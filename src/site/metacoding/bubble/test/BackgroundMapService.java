package site.metacoding.bubble.test;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BackgroundMapService implements Runnable {

	// 2. �����ڰ� �÷��̾��� �������� �˾ƾ��ϱ⶧���� �÷��̾� ���� ����� �����ڿ��� �Ű������� �ޱ�
	private Player player;

	// 3. �̹����� ���̴� ���� �ƴ� Ȱ���ϱ� ���Ѱ��̱� ������ BufferedImage�� �޴´�. -> BufferedImage���� �ʿ�
	private BufferedImage image;

	// 1. ������ ������ֱ�
	public BackgroundMapService(Player player) {
		this.player = player;

		// 4. �̹��� ���� -> ���۷� �޴°Ŷ� try/catch
		try {
			image = ImageIO.read(new File("image/backgroundMapService.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// 9. ��� ���ư����� while�� �ɾ��ش�.
		while (true) {
			// 8. ���� Ȯ���� ���� Color ���� ����
			try {
				Color color = new Color(image.getRGB(player.getX(), player.getY()));
				System.out.println("Red : " + color.getRed());
				System.out.println("Green : " + color.getGreen());
				System.out.println("Blue : " + color.getBlue());
				System.out.println("====================================");
				// 9. ������ ����
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
