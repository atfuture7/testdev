package exp.springb.startapp;

class TypeNotFoundException extends RuntimeException {
	TypeNotFoundException(String id) {
		super("Could not find Type " + id);
	}
}