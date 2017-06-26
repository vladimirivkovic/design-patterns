package designpattern.creational.factorymethod.example;

public class GifReader implements ImageReader {
	private DecodedImage decodedImage;
	
	public GifReader(String image) {
		this.decodedImage = new DecodedImage(image);
	}

	@Override
	public DecodedImage getDecodedImage() {
		return decodedImage;
	}

}
