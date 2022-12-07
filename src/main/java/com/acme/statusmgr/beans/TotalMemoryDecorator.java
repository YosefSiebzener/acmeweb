package com.acme.statusmgr.beans;

/**
 * Decorator used for getting the total JVM memory and recording the price for the request.
 * @see com.acme.statusmgr.beans.DetailsBaseImplementation
 */
public class TotalMemoryDecorator extends DetailsBaseImplementation {

    private String statusDesc = ", and there is a total of " + sifi.getTotalMemory() + " bytes of JVM memory";  // the status being returned

    public TotalMemoryDecorator(DetailsBaseImplementation dbi) {
        super(dbi, 13);
        setStatusDesc(statusDesc);
    }
}
