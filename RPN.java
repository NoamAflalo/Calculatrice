
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class RPN {
	private List<Value> stack;
	public RPN() {
		this.stack=new LinkedList<Value>();
	}
	public List<Value> getStack(){
		return this.stack;
	}
	public void setStack(List<Value> pstack) {
		this.stack=pstack;
	}


	public void getAction(String s, int choice) throws OperationException, DivisionException, SizeException {
		if (this.isInteger(s)&& choice==1) {
			this.stack.add(new myInt(Integer.parseInt(s)));
		}
		else if (this.isDouble(s)&&choice==2) {
			this.stack.add(new myDouble(Double.parseDouble(s)));

		}
		else if (this.isRational(s)&&choice==3) {
			this.stack.add(new Rational(s));
		}
		else if(this.isOperator(s)) {
			if(this.stack.size()==0 || this.stack.size()==1) {
				throw new SizeException();
			}
			this.operation(s);
		}
		else {
			throw new OperationException();
		}
		System.out.println(this.stack);
	}

	private void operation(String s) throws DivisionException {
		int lastIndex=this.stack.size()-1;
		Value result = null;
		Value v1=this.stack.get(lastIndex-1);
		Value v2=this.stack.get(lastIndex);

		switch (s.charAt(0)) {
		case'+':
			result=v1.add(v2);
			break;
		case'-':
			result=v1.sub(v2);
			break;
		case'/':
			result=v1.div(v2);;
			break;
		case'*':
			result=v1.mul(v2);;
			break;
		}
		this.stack.remove(lastIndex);
		this.stack.remove(lastIndex-1);
		this.stack.add(result);
	}

	public boolean isInteger(String str) {
		if (str.length()==0) {
			return false;
		}
		for(int i=0; i<str.length();i++) {
			if (str.codePointAt(i)<48 || str.codePointAt(i)>57) {
				return false;
			}
		}
		return true;
	}

	public boolean isDouble(String str) {
		int counter=0;
		if (str.length()==0) {
			return false;
		}
		for(int i=0; i<str.length();i++) {
			if (str.codePointAt(i)==46) {
				if(i==0||i==str.length()-1)  {
					return false;
				}
				counter++;
			}
			else if (str.codePointAt(i)<48 || str.codePointAt(i)>57) {
				return false;
			}
		}
		if (counter>1) {
			return false;
		}
		return true;
	}

	public boolean isRational(String str) {
		int counter=0;
		if (str.length()==0) {
			return false;
		}
		for(int i=0; i<str.length();i++) {
			if (str.codePointAt(i)==47) {
				if(i==0||i==str.length()-1)  {
					return false;
				}
				counter++;
			}
			else if (str.codePointAt(i)<48 || str.codePointAt(i)>57) {
				return false;
			}
		}
		if (counter>1) {
			return false;
		}
		return true;
	}


	public boolean isOperator(String str) {
		if (str.length()!=1) {
			return false;
		}
		for(int i=0; i<str.length();i++) {
			//Le code ASCII pour les operandes.
			if (str.codePointAt(i)!=42 && str.codePointAt(i)!=43 && str.codePointAt(i)!=45 && str.codePointAt(i)!=47) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) throws OperationException, DivisionException, SizeException {
		RPN calculator =new RPN();
		Scanner sc = new Scanner(System.in);
		System.out.println("What type of calculator is this ? 1=Int, 2=Double, 3=Rational.");
		int choice=sc.nextInt();
		while(choice!=1&&choice!=2&&choice!=3){
			System.out.println("What type of calculator is this ? 1=Int, 2=Double, 3=Rational.");
			choice=sc.nextInt();
		}
		System.out.println("Enter number, operation or Exit to exit");
		sc = new Scanner(System.in);
		String tmp=sc.nextLine();
		while (!tmp.equals("Exit")){
			try {
				calculator.getAction(tmp,choice);
			}
			catch(OperationException | DivisionException | SizeException e) {

			}
			sc = new Scanner(System.in);
			tmp=sc.nextLine();
		}

	}
}
