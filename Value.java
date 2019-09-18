public interface Value {
	Value add(Value t) throws DivisionException;
	Value sub(Value t) throws DivisionException;
	Value mul(Value t) throws DivisionException;
	Value div(Value t) throws DivisionException;
}
