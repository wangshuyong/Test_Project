package com.wangsy.Utils;

public class Locator {
	private String element;

    private int waitSec;

    /**
     * create a enum variable for By
     * 
     * @author wangsy
     *
     */
    public enum ByType {
        xpath, id, linkText, name, className, cssSelector, partialLinkText, tagName
    }

    private ByType byType;

    public Locator() {

    }

    /**
     * defaut Locator ,use ID
     * 
     * @author wangsy
     * @param element
     */
    public Locator(String element) {
        this.element = element;
        this.waitSec = 3;
        this.byType = ByType.id;
    }

    public Locator(String element, int waitSec) {
        this.waitSec = waitSec;
        this.element = element;
        this.byType = ByType.id;
    }

    public Locator(String element, int waitSec, ByType byType) {
        this.waitSec = waitSec;
        this.element = element;
        this.byType = byType;
    }

    public String getElement() {
        return element;
    }

    public int getWaitSec() {
        return waitSec;
    }

    public ByType getBy() {
        return byType;
    }

    public void setBy(ByType byType) {
        this.byType = byType;
    }
}
