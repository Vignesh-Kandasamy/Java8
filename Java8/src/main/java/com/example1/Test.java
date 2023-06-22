package com.example1;

public class Test
{
	public static void main(String args[])
	{
//		Infra i=(s,n)->System.out.println(s*n);
//		i.getLength(2, 9);
//		i.getLength(59, 69);
		
		Runnable r=()->{
							for(int i=0;i<10;i++)
							{
								System.out.println("child thread");
								try {
									Thread.sleep(5000);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
					   };
		Thread t=new Thread(r);
		t.start();
		for(int i=0;i<10;i++)
		{
			System.out.println("Main thread");
		}
	}
}
