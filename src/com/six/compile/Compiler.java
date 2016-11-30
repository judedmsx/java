package com.six.compile;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URI;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import javax.tools.Diagnostic;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

public class Compiler {
	public static void main(String[] args) throws Exception {
		demo3();
		String urlString = "com.six.compile.Target";   
	    URI uri = URI.create(urlString);   
	    System.out.println(uri.getPath());   
	   
	}
	
	/**
	 * 
	 * 运行时编译java文件           .<br>
	 *
	 * @throws FileNotFoundException  void
	 */
	public static void demo1()throws FileNotFoundException {
		String fullQuanlifiedFileName = "D:\\workspaces\\java\\src\\com\\six\\compile\\Target.java";
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		FileOutputStream err = new FileOutputStream("err.txt");
		int result = compiler.run(null, null,err, "-verbose",fullQuanlifiedFileName);
		if(result == 0)
			System.out.println("done");
		else
			System.out.println("fail");
	}
	
	/**
	 * 
	 * CompilationTask 进行编译          .<br>
	 *  void
	 */
	public static void demo2(){
		String fullQuanlifiedFileName = "D:\\workspaces\\java\\src\\com\\six\\compile\\Calculator.java";
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
		Iterable<? extends JavaFileObject> files = fileManager.getJavaFileObjectsFromStrings(
				Arrays.asList(fullQuanlifiedFileName));
		 DiagnosticCollector<JavaFileObject> collector =
		           new DiagnosticCollector<JavaFileObject>(); 
		JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, collector, null, null, files);
		
		Boolean result = task.call();
		
		List<Diagnostic<? extends JavaFileObject>> diagonstics = collector.getDiagnostics();
		for(Diagnostic<? extends JavaFileObject> d : diagonstics){
			System.out.println("Line Number->" + d.getLineNumber());
			System.out.println("Message->"+ 
			  		         d.getMessage(Locale.ENGLISH));
			 System.out.println("Source" + d.getCode());
			System.out.println("\n");
		}
		
		
		if(result == true)
			System.out.println("succeed");
		
	}
	
	/**
	 * 
	 * 编译非文本形式的源文件           .<br>
	 *  void
	 * @throws FileNotFoundException 
	 */
	public static void demo3() throws FileNotFoundException{
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
		JavaFileObject file = constructTestor();
		Iterable<? extends JavaFileObject> files = Arrays.asList(file);
		DiagnosticCollector<JavaFileObject> collector =
		           new DiagnosticCollector<JavaFileObject>(); 
		JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, collector, null, null, files);
		
		Boolean result = task.call();
		
		List<Diagnostic<? extends JavaFileObject>> diagonstics = collector.getDiagnostics();
		for(Diagnostic<? extends JavaFileObject> d : diagonstics){
			System.out.println("Line Number->" + d.getLineNumber());
			System.out.println("Message->"+ 
			  		         d.getMessage(Locale.ENGLISH));
			 System.out.println("Source" + d.getCode());
			System.out.println("\n");
		}
		
		if(result == true)
			System.out.println("succeed");
	}
	
	public static SimpleJavaFileObject constructTestor(){
		StringBuilder contents = new StringBuilder(
		           "package com.six.compile;" +
		           "class CalculatorTest {\n" +
		      	   "  public void testMultiply() {\n" +
				   "    Calculator c = new Calculator();\n" +
				   "    System.out.println(c.multiply(2, 4));\n" +
				   "  }\n" +
				   "  public static void main(String[] args) {\n" +
				   "    CalculatorTest ct = new CalculatorTest();\n" +
				   "    ct.testMultiply();\n" +
				   "  }\n" +
				   "}\n");
		StringObject so = null;
		try {
			so = new StringObject("com.six.compile.CalculatorTest", contents.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return so;
	}
}
