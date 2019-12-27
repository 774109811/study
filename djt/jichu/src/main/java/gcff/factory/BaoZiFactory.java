package gcff.factory;

public class BaoZiFactory implements GcFactory {

	@Override
	public Food creatFactory() {
		// TODO Auto-generated method stub
		return new Baozi();
	}

}
