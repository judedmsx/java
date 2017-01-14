package com.vm;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MyClassLoader extends ClassLoader{
	private String classPath;
	
	public MyClassLoader(){
		System.out.println("MyClassLoader init!");
	}
	 
    public MyClassLoader(String classPath)
    {
    		super(null);
        this.classPath = classPath;
    }
    
    private byte[] getData(String className)
    {
        String path = classPath + File.separatorChar+className.replace('.', File.separatorChar)+".class";
       System.out.println(path);
        try
        {
            InputStream is = new FileInputStream(path);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            byte[] buffer = new byte[2048];
            int num = 0;
            while((num = is.read(buffer))!=-1)
            {
                stream.write(buffer,0,num);
            }
            is.close();
            return stream.toByteArray();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
 
        return null;
    }
    
    
    
    @Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
    		byte[] classData = getData(name);
        if (classData == null)
        {
            throw new ClassNotFoundException();
        }
        else
        {
            return defineClass(name, classData, 0, classData.length);
        }
	}

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		ClassLoader cl = new MyClassLoader("/Users/maosx/Documents/workspace/java/bin");
		Class c = cl.loadClass("com.vm.TestPermSize");
		Object obj = c.newInstance();
		System.out.println(obj instanceof com.vm.TestPermSize);
	}
}
