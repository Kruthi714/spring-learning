package in.sp.main;

import org.springframework.stereotype.Component;

@Component
public class MyClass {
	public void printMessage(String name) {
		System.out.println("hello: "+name);
	}

}
