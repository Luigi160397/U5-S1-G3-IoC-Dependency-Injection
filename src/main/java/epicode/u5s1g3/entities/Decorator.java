package epicode.u5s1g3.entities;

public abstract class Decorator extends Pizza {
	public Pizza pizza;

	@Override
	public abstract String getNome();

	@Override
	public abstract double getPrezzo();

	@Override
	public abstract long getCalorie();

	@Override
	public abstract String getIngredienti();
}
