package cn.crxy.test2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegDemo2 {

	public static void main(String[] args) {
		
		//ʹ����������ַ����������ݻ�ȡ:
		
		//�������ʽ
		Pattern compile = Pattern.compile("([0-9]+)([a-z]+)");
		
		//ƥ���������
		Matcher matcher = compile.matcher("1223asd124asd");
		
		//�±�����ƥ��,���൱��ƥ����һ��find()
		//ƥ�������ַ���.
//		boolean matches = matcher.matches();
		//���ַ�����ͷ����ƥ��.
//		boolean lookingAt = matcher.lookingAt();
//		System.out.println(lookingAt);
		
		//ʹ�������ȡ���ַ���:
		while(matcher.find()){
			System.out.println(matcher.group()+" - "+matcher.start()+" - "+matcher.end());
		}
		
		
	}

}
