class myDouble implements Value{
	private double d;

	public myDouble(double pDouble) {
		this.d=pDouble;
	}
	public myDouble() {
		this(0);
	}

	public myDouble add(Value t) {
		return new myDouble(this.d+((myDouble)t).d);
	}

	public myDouble sub(Value t) {
		return new myDouble(this.d-((myDouble)t).d);

	}

	public myDouble mul(Value t) {
		return new myDouble(this.d*((myDouble)t).d);
	}

	public myDouble div(Value t) throws DivisionException {
		if(((myDouble)t).d==0) {
			throw new DivisionException();
		}
		return new myDouble(this.d/((myDouble)t).d);
	}
	public String toString() {
		return this.d+"";

	}
}
