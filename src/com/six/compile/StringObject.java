package com.six.compile;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.tools.SimpleJavaFileObject;

public class StringObject extends SimpleJavaFileObject{
	private String contents = null;
	protected StringObject(String uri, String kind) throws URISyntaxException {
		super(new URI(uri), Kind.SOURCE);
		this.contents=contents;
	}
	@Override
	public CharSequence getCharContent(boolean ignoreEncodingErrors)
			throws IOException {
		return contents;
	}

}
