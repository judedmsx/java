package com.six.script;

import java.lang.reflect.Field;
import java.util.List;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class JavaScriptDemo {
	public static Object jsObjFunc() throws NoSuchMethodException, ScriptException{
		String str="var obj={"
				+ "run:function(){return 'run abc'+this.next('test')+'';},"
				+ "next:function(str){return 'ÎÒÀ´×Ô next function '+str+'';}}";
		ScriptEngineManager sem = new ScriptEngineManager();
		ScriptEngine eng = sem.getEngineByName("js");
		eng.eval(str);
		Object obj = eng.get("obj");
		Invocable inv = (Invocable)eng;
		return inv.invokeMethod(obj, "run");
	}
	
	public static void getArray() throws ScriptException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		ScriptEngineManager sem = new ScriptEngineManager();
		ScriptEngine eng = sem.getEngineByName("js");
		String str = "var obj={array:['test',true,1,1.01,111111]}";
		eng.eval(str);
		Object object = eng.eval("obj.array");
		System.out.println(object);
		Class<?> clazz = object.getClass();
		for(Field denseField:clazz.getDeclaredFields()){
			if("[object Array]".equals(denseField.getName()))
				System.out.println(denseField.get(object));
		}
		
	}
	
	
	public static void main(String[] args) throws Exception {
//		System.out.println(jsObjFunc());
		getArray();
	}
}
