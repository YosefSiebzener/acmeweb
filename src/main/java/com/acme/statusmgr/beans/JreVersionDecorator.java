package com.acme.statusmgr.beans;

/**
 * Decorator used for getting the JRE version and recording the price for the request.
 * @see com.acme.statusmgr.beans.DetailsBaseImplementation
 */
public class JreVersionDecorator extends DetailsBaseImplementation {

    public JreVersionDecorator(DetailsBaseImplementation dbi) {
        super(dbi, 19);
        // the status being returned
        String statusDesc = ", and the JRE version is " + sifi.getJreVersion();
        setStatusDesc(statusDesc);
    }
}
