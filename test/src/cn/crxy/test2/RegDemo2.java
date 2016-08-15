package cn.crxy.test2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegDemo2 {

	public static void main(String[] args) {
		
		//使用正则进行字符串中子内容获取:
		
		//创建表达式
		Pattern compile = Pattern.compile("([0-9]+)([a-z]+)");
		
		//匹配操作引擎
		Matcher matcher = compile.matcher("1223asd124asd");
		
		//下边两个匹配,会相当于匹配了一次find()
		//匹配完整字符串.
//		boolean matches = matcher.matches();
		//从字符串开头进行匹配.
//		boolean lookingAt = matcher.lookingAt();
//		System.out.println(lookingAt);
		
		//使用引擎获取子字符串:
		while(matcher.find()){
			System.out.println(matcher.group()+" - "+matcher.start()+" - "+matcher.end());
		}
		
		
	}

}
