package com.wangsy.Utils;

import java.util.HashMap;

public interface XmlDocument {
	public void createXml(String fileName);

	public HashMap<String, Locator> readXMLDocument(String path, String pageName);
}
