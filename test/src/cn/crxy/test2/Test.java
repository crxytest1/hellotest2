package cn.crxy.test2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Test {

	public static void main(String[] args) {
//		test2(new int[]{10,202});
			
		//泛型擦除.
		ArrayList<String> list = new ArrayList<String>();
		list.add("asadasd");
		
		test3(list);
		
		ArrayList<Person> list2 = new ArrayList<Person>();
		
		ArrayList<Student> list3 = new ArrayList<Student>();
		
		
		list2.addAll(list3);
	}
	
	public static void test2(int... s){
		int sum = 0;
		for (int i = 0; i < s.length; i++) {
			sum+=s[i];
		}
		System.out.println(sum);
		
	}
	
	//?只能当通配符去匹配.
	public static void test3(Collection<?> c){
		Iterator<?> it = c.iterator();
		Object a = it.next();
		
		System.out.println(a);
	}
}
//泛型的限定
class Student extends Person{}
class Person{}
class A<E>{
	public  A(A<? super E> a){
		
	}
}
