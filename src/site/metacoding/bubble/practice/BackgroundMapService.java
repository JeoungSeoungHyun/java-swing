package site.metacoding.bubble.practice;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class BackgroundMapService implements Runnable {

	private Player player;
	private BufferedImage image;
	private boolean isRed;
	private boolean isBlue;

	public boolean isRed() {
		return isRed;
	}

	public void setRed(boolean isRed) {
		this.isRed = isRed;
	}

	public boolean isBlue() {
		return isBlue;
	}

	public void setBlue(boolean isBlue) {
		this.isBlue = isBlue;
	}

	public BackgroundMapService(Player player) {
		this.player = player;

		try {
			image = ImageIO.read(new File("image/backgroundMapService.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (true) {
			try {
				Color leftColor = new Color(image.getRGB(player.getX() - 10, player.getY() + 25));
				Color rightColor = new Color(image.getRGB(player.getX() + 50 + 15, player.getY() + 25));
				Color topColor = new Color(image.getRGB(player.getX() + 25, player.getY()));
				Color bottomColor = new Color(image.getRGB(player.getX() + 25, player.getY() + 50 + 5));
//				System.out.println("leftColor : " + leftColor);
//				System.out.println("rightColor : " + rightColor);

				if (leftColor.getRed() == 255 && leftColor.getBlue() == 0 && leftColor.getGreen() == 0) {
					isRed = true;
					System.out.println("왼쪽 벽에 충돌");
				} else if (rightColor.getRed() == 255 && rightColor.getBlue() == 0 && rightColor.getGreen() == 0) {
					isRed = true;
					System.out.println("오른쪽 벽에 충돌");
				} else if (topColor.getRed() == 0 && topColor.getBlue() == 255 && topColor.getGreen() == 0) {
					isBlue = true;
					System.out.println("위쪽 벽에 충돌");
				} else if (bottomColor.getRed() == 0 && bottomColor.getBlue() == 255 && bottomColor.getGreen() == 0) {
					isBlue = true;
					System.out.println("아래쪽 벽에 충돌");
				}
				Thread.sleep(10);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}
