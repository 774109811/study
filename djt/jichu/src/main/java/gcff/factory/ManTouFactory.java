package gcff.factory;

public class ManTouFactory implements GcFactory {

	@Override
	public Food creatFactory() {
		
		return new ManTou();
	}

}
