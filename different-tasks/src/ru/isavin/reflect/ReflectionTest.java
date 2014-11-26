package ru.isavin.reflect;

import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicInteger;

public class ReflectionTest {

	public static void main(String[] args) {
		Reflection refl = new Reflection(11, 11L, "I'm FINAL!", 11);
		System.out.println(refl);
		try {
	        Field aField = refl.getClass().getDeclaredField("a");
	        aField.setAccessible(true);
	        aField.set(refl, 12);
	        aField.setAccessible(false);
	        Field bField = refl.getClass().getDeclaredField("b");
	        bField.setAccessible(true);
	        bField.set(refl, 12L);
	        bField.setAccessible(false);
	        Field cField = refl.getClass().getDeclaredField("c");
	        cField.setAccessible(true);
	        cField.set(refl, "I'm NOT finl anymore :(");
	        cField.setAccessible(false);
	        Field dField = refl.getClass().getDeclaredField("d");
	        dField.setAccessible(true);;
	        dField.set(refl, 12);
	        dField.setAccessible(false);
        } catch (NoSuchFieldException | SecurityException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
        } catch (IllegalArgumentException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
        } catch (IllegalAccessException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
        }
		System.out.println(refl);
		
		AtomicInteger ai = new AtomicInteger(1);
		ai.getAndIncrement();
	}

}

class Reflection {
	private int a;
	private final Long b;
	private final String c;
	private final int d;
	
	public Reflection(int a, Long b, String c, int d) {
	    super();
	    this.a = a;
	    this.b = b;
	    this.c = c;
	    this.d = d;
    }

	@Override
    public String toString() {
	    StringBuilder builder = new StringBuilder();
	    builder.append("Reflection [a=").append(a).append(", b=").append(b)
	            .append(", c=").append(c).append(", d=").append(d).append("]");
	    return builder.toString();
    }
	
	
}
