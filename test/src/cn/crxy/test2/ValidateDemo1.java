package cn.crxy.test2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateDemo1 {

	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//������Ƕ������,ƥ���ַ���.
//		String reg = "";
//		String password = "abc";
//		 boolean matches = password.matches(reg);
//		System.out.println(matches);
		
		//ʹ�ò���:
//		Pattern compile = Pattern.compile("a*b");
//		Matcher matcher = compile.matcher("aaaaab");
//		boolean matches = matcher.matches();
//		
//		System.out.println(matches);
		//��д����:
		//1.�ַ�:\t \n \r ת���ַ�\.
		//2.�ַ���:[ab] [^ab] [a-zA-Z] [0-9]	ע:[]�п��Ա�д����Ϸ�Χ. �����ַ�.
		//3.Ԥ�����ַ���: . \d \D \w \W \s \S
		//4.�߽�ƥ����: ^ $  \b \B ע:\\d[a-z]*\\d һ��ֻ��ƥ��һ������.123���ҵ�ʱ��123 0123 1234�������ҵ�. �ӹ��߽��޶�ֻ���ҵ�123.
		//			\A \Z \z : ����Ŀ�ͷ���β.ע:��ͬ��^ $.
		//5.������:	x? x* x+  x{n} x{n,} x{n,m} Greedy:ȫ����,����. Reluctant:��ǰ���෴,�Ȱ������Ҫ����,������ƥ��. Possessive: ����������ȫ�������һ��һ��.���������ǲ���.
		
		String str = "123213a12321b";
		
		Pattern compile = Pattern.compile(".{2,9}+[a-z]");
		Matcher matcher = compile.matcher(str);
//		boolean matches = matcher.matches();
		boolean find = matcher.find();
		
		System.out.println(find+" -- "+matcher.start()+" --- "+matcher.end());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
