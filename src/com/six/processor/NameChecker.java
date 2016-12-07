package com.six.processor;

import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.util.ElementScanner8;

public class NameChecker {
	private final Messager messager;
	public NameChecker(ProcessingEnvironment processingEnv){
		this.messager = processingEnv.getMessager();
	}
	
//	public void checkNames(Element)
	
	private class NameCheckScanner extends ElementScanner8<Void, Void>{

		@Override
		public Void visitVariable(VariableElement e, Void p) {
			// TODO Auto-generated method stub
			return super.visitVariable(e, p);
		}

		@Override
		public Void visitType(TypeElement e, Void p) {
			scan(e.getTypeParameters(), p);
			super.visitType(e, p);
			return null;
		}

		@Override
		public Void visitExecutable(ExecutableElement e, Void p) {
			// TODO Auto-generated method stub
			return super.visitExecutable(e, p);
		}
		
		
		private void checkCamelCase(Element e,boolean initialCaps){
			
		}
	}
}
