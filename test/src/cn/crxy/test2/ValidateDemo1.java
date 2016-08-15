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
		
		//正则就是定义规则,匹配字符串.
//		String reg = "";
//		String password = "abc";
//		 boolean matches = password.matches(reg);
//		System.out.println(matches);
		
		//使用步骤:
//		Pattern compile = Pattern.compile("a*b");
//		Matcher matcher = compile.matcher("aaaaab");
//		boolean matches = matcher.matches();
//		
//		System.out.println(matches);
		//编写正则:
		//1.字符:\t \n \r 转义字符\.
		//2.字符类:[ab] [^ab] [a-zA-Z] [0-9]	注:[]中可以编写任意断范围. 任意字符.
		//3.预定义字符类: . \d \D \w \W \s \S
		//4.边界匹配器: ^ $  \b \B 注:\\d[a-z]*\\d 一次只能匹配一个单词.123在找的时候123 0123 1234都可以找到. 加过边界限定只能找到123.
		//			\A \Z \z : 输入的开头与结尾.注:等同于^ $.
		//5.数量词:	x? x* x+  x{n} x{n,} x{n,m} Greedy:全吞完,再吐. Reluctant:与前者相反,先按照最低要求吞,在依次匹配. Possessive: 按照数量词全部吞与第一个一样.但是区别是不吐.
		
		String str = "123213a12321b";
		
		Pattern compile = Pattern.compile(".{2,9}+[a-z]");
		Matcher matcher = compile.matcher(str);
//		boolean matches = matcher.matches();
		boolean find = matcher.find();
		
		System.out.println(find+" -- "+matcher.start()+" --- "+matcher.end());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
