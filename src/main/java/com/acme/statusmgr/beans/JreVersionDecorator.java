package com.acme.statusmgr.beans;

public class JreVersionDecorator extends DetailsBaseImplementation {
    private String statusDesc = ", and the JRE version is " + sifi.getJreVersion();  // the status being returned

    public JreVersionDecorator(DetailsBaseImplementation dbi) {
        super(dbi, 19);
        setStatusDesc(statusDesc);
    }
}
