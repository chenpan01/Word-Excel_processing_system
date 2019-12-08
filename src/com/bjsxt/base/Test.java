package com.bjsxt.base;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;

class A
{
	protected Class clazz ;
	A()
	{
				ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
				//带有真实类型参数的对象
				clazz = (Class)pt.getActualTypeArguments()[0];
				System.out.println(clazz);
	}
	public void AA()
	{
		try 
		{
			Object obj=clazz.getConstructor().newInstance();
			System.out.println(obj.getClass().getName());
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally
		{
			
		}
		
	}
}
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		A a=new A();
		a.AA();
	}

}
