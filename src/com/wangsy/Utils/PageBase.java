package com.wangsy.Utils;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class PageBase {
	private final int TIMEOUT = 10;

	public PageBase() {
	}

	public PageBase(WebDriver driver) {
		PageFactory.initElements(
				new AjaxElementLocatorFactory(driver, TIMEOUT), this);
	}

	public static void initAllPages(WebDriver driver) {
		File rootFile = new File(PageBase.class.getResource(".").getFile());
		// ��ʼ����������
		setSonList(rootFile, rootFile.getAbsolutePath() + "\\", PageBase.class,
				rootFile.getAbsolutePath() + "\\", driver);
	}

	public static <T> void setSonList(File rootFile, String parentDirectory,
			Class<T> parentClass, String mainPath, WebDriver driver) {
		if (rootFile.isDirectory()) {
			File[] files = rootFile.listFiles();
			for (File file : files) {
				setSonList(file, parentDirectory, parentClass, mainPath, driver);
			}
		} else {
			String className = null;
			try {
				if (rootFile.getPath().indexOf(".class") != -1) {

					className = rootFile.getPath().replace(mainPath, "")
							.replace(".class", "").replace("\\", ".");
					System.err.println("��ʼ��Page:"
							+ parentClass.getPackage().getName() + "."
							+ className);
					Class<?> classObject = Class.forName(parentClass
							.getPackage().getName() + "." + className);
					classObject.asSubclass(parentClass);
					PageFactory.initElements(driver, (Class<?>) classObject);

				}
			} catch (ClassNotFoundException e) {
				System.err.println("�Ҳ����� " + className);
			} catch (ClassCastException e) {
				System.err.println(className + " ���� " + parentClass + " ������");
			}
		}
	}

}
