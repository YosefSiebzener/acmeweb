package com.acme.statusmgr.beans;

public class TotalMemoryDecorator extends DetailsBaseImplementation {

    private String statusDesc = ", and there is a total of " + sifi.getTotalMemory() + " bytes of JVM memory";  // the status being returned

    public TotalMemoryDecorator(DetailsBaseImplementation dbi) {
        super(dbi, 13);
        setStatusDesc(statusDesc);
    }
}
