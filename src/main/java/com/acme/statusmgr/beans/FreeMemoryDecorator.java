package com.acme.statusmgr.beans;

/**
 * Decorator used for getting the amount of free memory (in bytes) and recording the price for the request.
 * @see com.acme.statusmgr.beans.DetailsBaseImplementation
 */
public class FreeMemoryDecorator extends DetailsBaseImplementation {

    public FreeMemoryDecorator(DetailsBaseImplementation dbi) {
        super(dbi, 7);
        // the status being returned
        String statusDesc = ", and there are " + sifi.getFreeMemory() + " bytes of JVM memory free";
        setStatusDesc(statusDesc);
    }
}
