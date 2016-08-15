package cn.crxy.test1;

public class Demo2 {

	public static void main(String[] args) {
		
		int[] scores3 = {100,80,99,90,198,8};
		
		//数组的常见操作.
		//选择排序.
		/*for( int i = 0 ; i <scores3.length-1  ;  i++ ){
			for (int j = i+1; j < scores3.length; j++) {
				if( scores3[i]<scores3[j] ){
					int a = scores3[i];
					scores3[i] = scores3[j];
					scores3[j]= a;
				}
			}
		}*/
		
		//冒泡排序.
		/*for (int i = 0; i < scores3.length-1; i++) {
			for (int j = 0; j < scores3.length-i-1; j++) {
				if(scores3[j]>scores3[j+1]){
					int a = scores3[j];
					scores3[j] = scores3[j+1];
					scores3[j+1]= a;
				}
			}
		}*/
		
		//超级冒泡.
		/*for (int i = 0; i < scores3.length-1; i++) {
			for (int j = 0; j < scores3.length-i-1; j++) {
				if(scores3[j]>scores3[j+1]){
					int a = scores3[j];
					scores3[j] = scores3[j+1];
					scores3[j+1]= a;
				}
			}
			
			for (int j = scores3.length-1; j > i ; j--) {
				if(scores3[j]<scores3[j-1]){
					int a = scores3[j];
					scores3[j] = scores3[j-1];
					scores3[j-1]= a;
				}
			}
		}*/
		
//		超级冒泡优化:
		int a = 0;
		int b = scores3.length-1;
		while(a<b){
			for(int i = a; i <b-a; i++ ){
				if(scores3[i]>scores3[i+1]){
					int c = scores3[i];
					scores3[i] = scores3[i+1];
					scores3[i+1]= c;
				}
			}
			b--;
			
			for (int i = b; i > a; i--) {
				if(scores3[i]<scores3[i-1]){
					int c = scores3[i];
					scores3[i] = scores3[i-1];
					scores3[i-1]= c;
				}
			}
			a++;
		}
		
		
		
		for (int i = 0; i < scores3.length; i++) {
			System.out.print(scores3[i]+"  ");
		}
		
		
	}

}
