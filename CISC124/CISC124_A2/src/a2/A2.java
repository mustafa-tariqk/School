package a2;

import java.awt.Color;
import java.io.File;
import java.net.URL;

public class A2 {
	/**
	 * The original image
	 */
	private static Picture orig;
	
	/**
	 * The image viewer class
	 */
	private static A2Viewer viewer;
	
	/**
	 * Returns a 300x200 image containing the Queen's flag (without the crown).
	 * 
	 * @return an image containing the Queen's flag
	 */
	public static Picture flag() {
		Picture img = new Picture(300, 200);
		int w = img.width();
		int h = img.height();

		// set the pixels in the blue stripe
		Color blue = new Color(0, 48, 95);
		for (int col = 0; col < w / 3; col++) {
		    for (int row = 0; row < h - 1; row++) {
		        img.set(col, row, blue);
		    }
		}

		// set the pixels in the yellow stripe
		Color yellow = new Color(255, 189, 17);
		for (int col = w / 3; col < 2 * w / 3; col++) {
		    for (int row = 0; row < h - 1; row++) {
		        img.set(col, row, yellow);
		    }
		}

		// set the pixels in the red stripe
		Color red = new Color(185, 17, 55);
		for (int col = 2 * w / 3; col < w; col++) {
		    for (int row = 0; row < h - 1; row++) {
		        img.set(col, row, red);
		    }
		}
		return img;
	}
	/**
	 * Copies the pixels of the input image p into a new image and returns the new image.
	 * @param p - original image
	 * @return result - copy of image
	 */
	public static Picture copy(Picture p) {
		Picture result = new Picture(p.width(), p.height());
		for (int col = 0; col < result.width(); col++) {
			for (int row = 0; row < result.height(); row++) {
				result.set(col, row, p.get(col, row));
			}
		}
		return result;
	}
	
	/**
	 * Adds a blue border of a specified thickness to an image.
	 * @param p - original image
	 * @param thickness - thickness of border
	 * @return result - image with border
	 */
	public static Picture border(Picture p, int thickness) {
		Picture result = copy(p);

		for (int col = 0; col < result.width(); col++) {
			for (int row = 0; row < thickness; row ++) {
				result.set(col, row, Color.BLUE);
				result.set(col, row + result.height() - thickness, Color.BLUE);
			}
		} 
		
		for (int row = 0; row < result.height(); row++) {
			for (int col = 0; col < thickness; col++) {
				result.set(col, row, Color.BLUE);
				result.set(col + result.width() - thickness, row, Color.BLUE);
			}
		}
		return result;
	}
	
	/**
	 * Computes the grayscale version of an image.
	 * @param p - original image
	 * @return result - grayscale image
	 */
	public static Picture toGray(Picture p) {
		Picture result = new Picture(p.width(), p.height());
		for (int col = 0; col < result.width(); col++) {
			for (int row = 0; row < result.height(); row++) {

				int red = p.get(col, row).getRed();
				int green = p.get(col, row).getGreen();
				int blue = p.get(col, row).getBlue();

				int grayValue = (int)Math.round(0.2989 * red + 0.5870 * green + 0.1140 * blue);
				Color gray = new Color(grayValue, grayValue, grayValue);

				result.set(col, row, gray);
			}
		}
		return result;
	}
	
	/**
	 * Computes the binary version of an image.
	 * @param p - original image
	 * @return result - binary image
	 */
	public static Picture toBinary(Picture p) {
		Picture result = new Picture(p.width(), p.height());
		Picture grayscale = toGray(p);
		for (int col = 0; col < grayscale.width(); col++) {
			for (int row = 0; row < grayscale.height(); row++) {
				int grayValue = grayscale.get(col, row).getRed();
				if (grayValue < 128) {
					result.set(col, row, Color.BLACK);
				} else {
					result.set(col, row, Color.WHITE);
				}
			}
		}
		return result;
	}
	
	/**
	 * Computes the vertically flipped version of an image.
	 * @param p - original image
	 * @return result - flipped image
	 */
	public static Picture flipVertical(Picture p) {
		Picture result = new Picture(p.width(), p.height());
		for (int col = 0; col < result.width(); col++) {
			for (int row = 0; row < result.height(); row++) {
				result.set(result.width() - col - 1, row, p.get(col, row));
			}
		}
		return result;
	}

	/**
	 * Computes the 90 degree rotated to the right version of an image.
	 * @param p - original image
	 * @return result - rotated image
	 */
	public static Picture rotateRight(Picture p) {
		Picture result = new Picture(p.height(), p.width());
		for (int col = 0; col < p.width(); col++) {
			for (int row = 0; row < p.height(); row++) {
				result.set(result.width() - row - 1, col, p.get(col, row));
			}
		}
		return result;
	}
	
	/**
	 * Reduces the red-eye effect in an image.
	 * @param p - original image
	 * @return result - image with reduced red-eye
	 */
	public static Picture redEye(Picture p) {
		Picture result = copy(p);
		for (int col = 0; col < result.width(); col++) {
			for (int row = 0; row < result.height(); row++) {
				
				double red = p.get(col, row).getRed(); // Find rgb values for pixel.
				double green = p.get(col, row).getGreen();
				double blue = p.get(col, row).getBlue();

				double redIntensity = red / ((green + blue) / 2); // Determine how red the pixel is.
				double RED_FILTER = 2.5;

				if (redIntensity > RED_FILTER) { // Only change pixels greater than a certain intensity.
					result.set(col, row, Color.BLACK);
				}
			}
		}
		return result;
	}
	
	/**
	 * Blurs an image using a box blur filter of a specified radius.
	 * @param p - original image
	 * @param radius - radius for boxblur
	 * @return result - blurred image
	 */
	public static Picture blur(Picture p, int radius) {
		Picture result = new Picture(p.width(), p.height());
		for (int col = 0; col < result.width(); col++) {
			for (int row = 0; row < result.height(); row++) {
				result.set(col, row, boxAvg(p, radius, col, row));
			}
		}
		return result;
	}
	
	/**
	 * Computes average color of box with certain radius around a pixel.
	 * @param p - original image
	 * @param radius - radius for boxblur
	 * @param col - centre of box column
	 * @param row - centre of box column
	 * @return result - average color of block
	 */
	public static Color boxAvg(Picture p, int radius, int col, int row) {
		int red = 0;
		int green = 0;
		int blue = 0;
		double counter = 0;
		for (int boxCol = col - radius; boxCol < col + radius + 1 && boxCol < p.width(); boxCol++) {
			for (int boxRow = row - radius; boxRow < row + radius + 1 && boxRow < p.height(); boxRow++) {
				if (boxCol < 0) {
					boxCol = 0;
				}
				if (boxRow < 0) {
					boxRow = 0;
				}
				red += p.get(boxCol, boxRow).getRed();
				green += p.get(boxCol, boxRow).getGreen();
				blue += p.get(boxCol, boxRow).getBlue();
				counter ++;
			}
		}
		
		red = (int)Math.round(red/counter);
		green = (int)Math.round(green/counter);
		blue = (int)Math.round(blue/counter);
		
		Color result = new Color(red, green, blue);
		return result;
	}
	
	/**
	 * A2Viewer class calls this method when a menu item is selected.
	 * This method computes a new image and then asks the viewer to
	 * display the computed image.
	 * 
	 * @param op the operation selected in the viewer
	 */
	public static void processImage(String op) {
		
		switch (op) {
		case A2Viewer.FLAG:
			// create a new image by copying the original image
			Picture p = A2.flag();
			A2.viewer.setComputed(p);
			break;
		case A2Viewer.COPY:
			// create a new image by copying the original image
			p = A2.copy(A2.orig);
			A2.viewer.setComputed(p);
			break;
		case A2Viewer.BORDER_1:
			// create a new image by adding a border of width 1 to the original image
			p = A2.border(A2.orig, 1);
			A2.viewer.setComputed(p);
			break;
		case A2Viewer.BORDER_5:
			// create a new image by adding a border of width 5 the original image
			p = A2.border(A2.orig, 5);
			A2.viewer.setComputed(p);
			break;
		case A2Viewer.BORDER_10:
			// create a new image by adding a border of width 10  the original image
			p = A2.border(A2.orig, 10);
			A2.viewer.setComputed(p);
			break;
		case A2Viewer.TO_GRAY:
			// create a new image by converting the original image to grayscale
			p = A2.toGray(A2.orig);
			A2.viewer.setComputed(p);
			break;
		case A2Viewer.TO_BINARY:
			// create a new image by converting the original image to black and white
			p = A2.toBinary(A2.orig);
			A2.viewer.setComputed(p);
			break;
		case A2Viewer.FLIP_VERTICAL:
			// create a new image by flipping the original image vertically
			p = A2.flipVertical(A2.orig);
			A2.viewer.setComputed(p);
			break;
		case A2Viewer.ROTATE_RIGHT:
			// create a new image by rotating the original image to the right by 90 degrees
			p = A2.rotateRight(A2.orig);
			A2.viewer.setComputed(p);
			break;
		case A2Viewer.RED_EYE:
			// create a new image by removing the redeye effect in the original image
			p = A2.redEye(A2.orig);
			A2.viewer.setComputed(p);
			break;
		case A2Viewer.BLUR_1:
			// create a new image by blurring the original image with a box blur of radius 1
			p = A2.blur(A2.orig, 1);
			A2.viewer.setComputed(p);
			break;
		case A2Viewer.BLUR_3:
			// create a new image by blurring the original image with a box blur of radius 3
			p = A2.blur(A2.orig, 3);
			A2.viewer.setComputed(p);
			break;
		case A2Viewer.BLUR_5:
			// create a new image by blurring the original image with a box blur of radius 5
			p = A2.blur(A2.orig, 5);
			A2.viewer.setComputed(p);
			break;
		default:
			// do nothing
		}
	}
	
	/**
	 * Starting point of the program. Students can comment/uncomment which image
	 * to use when testing their program.
	 * 
	 * @param args not used
	 */
	public static void main(String[] args) {
		A2.viewer = new A2Viewer();
		A2.viewer.setVisible(true);
		
		
		URL img;
		// uncomment one of the next two lines to choose which test image to use (person or cat)
		img = A2.class.getResource("redeye-400x300.jpg");   
		// img = A2.class.getResource("cat.jpg");
		
		
		A2.orig = new Picture(new File(img.getFile()));
		A2.viewer.setOriginal(A2.orig);
	}

}
