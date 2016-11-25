package com.wangsy.Utils;

import java.util.HashMap;

/** 
* 
* @author hongliang.dinghl 
* 定义XML文档建立与解析的接口 
*/ 
public interface XmlDocument { 
/** 
* 建立XML文档 
* @param fileName 文件全路径名称 
*/ 
public void createXml(String fileName); 
/** 
* 解析XML文档 
* @param fileName 文件全路径名称 
*/ 
public HashMap<String, Locator> readXMLDocument(String path, String pageName); 
}

