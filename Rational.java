class Rational implements Value{
	private int num;
	private int den;

	public Rational(String s) throws DivisionException {
		if(s.contains("/")) {
			this.num=Integer.parseInt(s.substring(0,s.indexOf("/")));
			this.den=Integer.parseInt(s.substring(s.indexOf("/")+1,s.length()));
			if(this.den==0) {
				throw new DivisionException();
			}
		}
		else {
			this.num=Integer.parseInt(s);
			this.den=1;
		}
	}

	public Rational simplify()throws DivisionException{
		int i;
		for(i=this.den;i>0;i--){
			if(this.num%i==0&&this.den%i==0){
				break;
			}
		}
		return new Rational(this.num/i+"/"+this.den/i);
	}

	public Rational add(Value t) throws DivisionException {
		 Rational r= new Rational((this.num*((Rational)t).den+((Rational)t).num*this.den)+"/"+this.den*((Rational)t).den);
		 return r.simplify();
	}

	public Rational sub(Value t) throws DivisionException {
		Rational r =new Rational((this.num*((Rational)t).den-((Rational)t).num*this.den)+"/"+this.den*((Rational)t).den);
		return r.simplify();
	}
	public Rational mul(Value t) throws DivisionException  {
		Rational r = new Rational(this.num*((Rational)t).num+"/"+this.den*((Rational)t).den);
		return r.simplify();
	}
	public Rational div(Value t) throws DivisionException {
		if(((Rational)t).isNull()) {
			throw new DivisionException();
		}
		Rational r = new Rational(this.num*((Rational)t).den+"/"+this.den*((Rational)t).num);
		return r.simplify();
	}
	public boolean isNull() {
		if (this.num==0) {
			return true;
		}
		return false;
	}
	public String toString(){
		return this.num+"/"+this.den;
	}
}
