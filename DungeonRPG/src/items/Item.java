package items;

public abstract class Item {
	protected String name;
	protected String sDesc;
	protected String lDesc;
	
	public Item() {
		name = "";
		sDesc = "";
		lDesc = "";
	}

	public String getName() {
		return name;
	}

	public String getsDesc() {
		return sDesc;
	}

	public String getlDesc() {
		return lDesc;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setsDesc(String sDesc) {
		this.sDesc = sDesc;
	}

	public void setlDesc(String lDesc) {
		this.lDesc = lDesc;
	}

}
