package com.acme.statusmgr.beans;

/**
 * Decorator used for getting amount of available processors and recording the price for the request.
 * @see com.acme.statusmgr.beans.DetailsBaseImplementation
 */
public class AvailableProcessorsDecorator extends DetailsBaseImplementation {

    public AvailableProcessorsDecorator(DetailsBaseImplementation dbi) {
        super(dbi, 3);
        // the status being returned
        String statusDesc = ", and there are " + sifi.getAvailableProcessors() + " processors available";
        setStatusDesc(statusDesc);
    }
}
