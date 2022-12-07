package com.acme.statusmgr.beans;

public class TempLocationDecorator extends DetailsBaseImplementation {

    private String statusDesc = ", and the server's temp file location is " + sifi.getTempLocation();  // the status being returned

    public TempLocationDecorator(DetailsBaseImplementation dbi) {
        super(dbi, 29);
        setStatusDesc(statusDesc);
    }
}
