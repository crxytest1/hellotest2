package cn.crxy.test1;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 由以下案例可知：
 * 1.一开始核心线程池未满的时候,不往队列中缓存任务. 一旦到核心线程池数到5的时候.就开始放任务队列.
 * 2.当任务队列放满时.开始创建新的线程到线程池中.
 * 
 * 核心注: 当线程池中的线程已经全部在执行自己的任务. 并且任务队列已经有未被领取执行的任务满时,会报错.拒绝接受新任务.
 * 10个线程正在执行+ 5个任务队列. 15个任务时刚好. 16个任务则会报错.除非有线程空闲,继续领取,或任务队列足够大. 
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
			System.out.println("线程池的数量为:" + tpe.getPoolSize() + ", 队列中等待的任务数为:"
					+ tpe.getQueue().size() + ",已经执行完成的任务数目为:"
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
		System.out.println("正在执行:" + taskNum);
//		try {
//			Thread.currentThread().sleep(2000);睡眠.此处如果不睡眠,则会可以搞定10个线程和5个任务队列满的情况. 16个任务也是可以执行的.
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		System.out.println("执行结束:" + taskNum);
	}

}