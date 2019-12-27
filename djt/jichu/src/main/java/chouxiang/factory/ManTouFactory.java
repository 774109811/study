package chouxiang.factory;

public class ManTouFactory implements CxFactory {

	@Override
	public BigFood creatFactory() {
		
		return new BigManTou();
	}

	@Override
	public SmallFood createFactory() {
		
		return new SmallManTou();
	}

}
