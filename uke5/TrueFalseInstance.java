class A {}
class B extends A {}
class C extends A {}
class D extends C {}

class TrueFalseInstance {
	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		C c = new C();
		D d = new D();
		A e = new D();
		A f = new B();
		System.out.println("a) " + (b instanceof A)); //true
		System.out.println("b) " + (c instanceof D)); //false
		System.out.println("c) " + (d instanceof A)); //true
		System.out.println("d) " + (e instanceof C)); //true
		System.out.println("e) " + (f instanceof C)); //false
	}
}

