package enchantments;

public abstract class Enchantment {

	protected String name;
	protected boolean suffix;
	protected String desc;
	protected String effect;
	
	protected void use() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isSuffix() {
		return suffix;
	}

	public void setSuffix(boolean suffix) {
		this.suffix = suffix;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getEffect() {
		return effect;
	}

	public void setEffect(String effect) {
		this.effect = effect;
	}
	
	
}
