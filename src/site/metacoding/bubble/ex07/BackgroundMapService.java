package site.metacoding.bubble.ex07;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

// ��׶��� ���� (�������� ������� ������ �Ѵ�.) -> ���ν������ ������ �̰͹ۿ� ���ϴϱ�
public class BackgroundMapService implements Runnable {
	private Player player;
	private BufferedImage image;

	public BackgroundMapService(Player player) {
		this.player = player;

		try {
			image = ImageIO.read(new File("image/backgroundMapService.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (true) {
			// ���� Ȯ��
			try {
				Color leftColor = new Color(image.getRGB(player.getX() - 10, player.getY() + 25));
				Color rightColor = new Color(image.getRGB(player.getX() + 50 + 15, player.getY() + 25));
				System.out.println(image.getRGB(player.getX(), player.getY()));

				// �Ͼ���̸� -1 �ƴϸ� �ٸ� ��
				int bottomColor = image.getRGB(player.getX() + 10, player.getY() + 50 + 5) // -1
						+ image.getRGB(player.getX() + 50 - 10, player.getY() + 50 + 5); // -1
//				System.out.println("leftColor : " + leftColor);
//				System.out.println("rightColor : " + rightColor);

				if (bottomColor != -2) { // ���� �浹
					player.setDown(false);
				}

				if (leftColor.getRed() == 255 && leftColor.getBlue() == 0 && leftColor.getGreen() == 0) {
//					System.out.println("���� ���� �浹��");
					player.setLeftWallCrash(true);
					player.setLeft(false);
				} else if (rightColor.getRed() == 255 && rightColor.getBlue() == 0 && rightColor.getGreen() == 0) {
//					System.out.println("������ ���� �浹��");
					player.setRightWallCrash(true);
					player.setRight(false);
				} else {
					player.setLeftWallCrash(false);
					player.setRightWallCrash(false);
				}
				Thread.sleep(10);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}