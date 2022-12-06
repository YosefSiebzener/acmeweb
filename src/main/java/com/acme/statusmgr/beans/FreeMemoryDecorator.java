package com.acme.statusmgr.beans;

public class FreeMemoryDecorator extends DetailsBaseImplementation {

    private String statusDesc = ", and there are " + sifi.getFreeMemory() + " bytes of JVM memory free"; // the status being returned

    public FreeMemoryDecorator(DetailsBaseImplementation dbi) {
        super(dbi, 7);
        setStatusDesc(statusDesc);
    }

    public FreeMemoryDecorator(DetailsBaseImplementation dbi,
                                        SystemInformationFacadeInterface sifi) {
        super(dbi,7, sifi);
        setStatusDesc(statusDesc);
    }
}
