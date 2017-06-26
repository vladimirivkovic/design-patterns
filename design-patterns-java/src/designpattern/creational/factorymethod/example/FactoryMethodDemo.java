package designpattern.creational.factorymethod.example;

public class FactoryMethodDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DecodedImage decodedImage;
		ImageReader reader = null;
		
		String image = args[0];
		String format = image.substring(image.indexOf('.') + 1, image.length());
		
		if ("gif".equals(format)) {
			reader = new GifReader(image);
		}
		if ("jpeg".equals(format)) {
			reader = new JpegReader(image);
		}
		
		assert reader != null;
		decodedImage = reader.getDecodedImage();
		System.out.println(decodedImage);
	}

}
