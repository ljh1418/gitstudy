package gittest;

public class Hello {

	public static void main(String[] args) {
		hello();
		helloName("leejunho");
		helloName("kante");
		soccer("BEST");
		
	}
	public static void hello() {
		System.out.println("Hello~");
	}
	
	
	public static void helloName(String name) {
		System.out.println("Hello" + name);
	}
	public static void soccer(String name) {
		System.out.println("chelsea" + name);
	}

}
