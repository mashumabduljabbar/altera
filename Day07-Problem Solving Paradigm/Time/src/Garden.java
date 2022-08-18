interface PlantActivity{
	public abstract void grow();
	void died();
}

class Cactus implements PlantActivity{
	@Override
	public void grow() {
		System.out.println("cactus grows~");
	}
	@Override
	public void died() {
		System.out.println("cactus died~");
	}
}

public class Garden {

}
