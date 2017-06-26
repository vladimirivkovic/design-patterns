package designpattern.creational.factorymethod.example;

public class JpegReader implements ImageReader {
	private DecodedImage decodedImage;
	
	public JpegReader(String image) {
		this.decodedImage = new DecodedImage(image);
	}

	@Override
	public DecodedImage getDecodedImage() {
		return decodedImage;
	}
}
