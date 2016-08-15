package cn.crxy.test1;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * �����°�����֪��
 * 1.һ��ʼ�����̳߳�δ����ʱ��,���������л�������. һ���������̳߳�����5��ʱ��.�Ϳ�ʼ���������.
 * 2.��������з���ʱ.��ʼ�����µ��̵߳��̳߳���.
 * 
 * ����ע: ���̳߳��е��߳��Ѿ�ȫ����ִ���Լ�������. ������������Ѿ���δ����ȡִ�е�������ʱ,�ᱨ��.�ܾ�����������.
 * 10���߳�����ִ��+ 5���������. 15������ʱ�պ�. 16��������ᱨ��.�������߳̿���,������ȡ,����������㹻��. 
 * @author XH
 *
 */

public class Demo3 {

	public static void main(String[] args) {
		ThreadPoolExecutor tpe = new ThreadPoolExecutor(5, 10, 200,
				TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(5));

		for (int i = 0; i < 16; i++) {
			MyTask task = new MyTask(i);
			tpe.execute(task);
			System.out.println("�̳߳ص�����Ϊ:" + tpe.getPoolSize() + ", �����еȴ���������Ϊ:"
					+ tpe.getQueue().size() + ",�Ѿ�ִ����ɵ�������ĿΪ:"
					+ tpe.getCompletedTaskCount());
		}
		
		tpe.shutdown();

	}

}

class MyTask implements Runnable {
	private int taskNum;

	public MyTask(int num) {
		this.taskNum = num;
	}

	@Override
	public void run() {
		System.out.println("����ִ��:" + taskNum);
//		try {
//			Thread.currentThread().sleep(2000);˯��.�˴������˯��,�����Ը㶨10���̺߳�5����������������. 16������Ҳ�ǿ���ִ�е�.
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		System.out.println("ִ�н���:" + taskNum);
	}

}