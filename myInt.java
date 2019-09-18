class myInt implements Value{
	private int val;
	public myInt(int pval){
		this.val=pval;
	}
	public myInt() {
		this(0);
	}
	public myInt add(Value t) {
		return new myInt(this.val+((myInt)t).val);
	}
	public myInt sub(Value t) {
		return new myInt(this.val-((myInt)t).val);
	}
	public myInt mul(Value t) {
		return new myInt(this.val*((myInt)t).val);

	}
	public myInt div(Value t) throws DivisionException{
		if(((myInt)t).val==0) {
			throw new DivisionException();
		}
		return new myInt(this.val/((myInt)t).val);
	}

	public boolean isNull() {
		if (this.val==0) {
			return true;
		}
		return false;
	}
	public String toString() {
		return this.val+"";
	}
}
