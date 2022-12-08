package com.acme.statusmgr.beans;

/**
 * Decorator used for getting the temp file location and recording the price for the request.
 * @see com.acme.statusmgr.beans.DetailsBaseImplementation
 */
public class TempLocationDecorator extends DetailsBaseImplementation {

    private String statusDesc = ", and the server's temp file location is " + sifi.getTempLocation();  // the status being returned

    public TempLocationDecorator(DetailsBaseImplementation dbi) {
        super(dbi, 29);
        setStatusDesc(statusDesc);
    }
}
