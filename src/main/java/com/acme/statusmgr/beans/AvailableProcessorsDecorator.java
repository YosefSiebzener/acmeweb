package com.acme.statusmgr.beans;

public class AvailableProcessorsDecorator extends DetailsBaseImplementation {

    private String statusDesc = ", and there are " + sifi.getAvailableProcessors() + " processors available";  // the status being returned

    public AvailableProcessorsDecorator(DetailsBaseImplementation dbi) {
        super(dbi, 3);
        setStatusDesc(statusDesc);
    }
}
