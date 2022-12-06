package com.acme.statusmgr.beans;

public class DetailsBaseImplementation {

    private long id;                // Unique identifier of request, sequential number
    private String contentHeader;   // Some info about the request
    DetailsBaseImplementation dbi;
    private StringBuilder statusDesc;  // the status being returned
    private int requestCost = 0;  // the cost in pennies of this request.
    SystemInformationFacadeInterface sifi = new ServerDetailsFacade();

    public DetailsBaseImplementation(DetailsBaseImplementation dbi) {
        this.dbi = dbi;
        setStatusDesc();
    }
    DetailsBaseImplementation(DetailsBaseImplementation dbi, int requestCost) {
        this.dbi = dbi;
        this.requestCost = requestCost;
    }

    DetailsBaseImplementation(DetailsBaseImplementation dbi,
                              int requestCost, SystemInformationFacadeInterface sifi) {
        this.dbi = dbi;
        this.requestCost = requestCost;
        this.sifi = sifi;
    }

    DetailsBaseImplementation(long id, String contentHeader, int requestCost) {
        this.id = id;
        this.contentHeader = contentHeader;
        this.requestCost = requestCost;
    }

    /**
     * Get the content header that was specified by the request
     *
     * @return some string
     */
    public String getContentHeader() {
        return dbi.getContentHeader();
    }

    /**
     * Get an english-like description of the server's status
     *
     * @return A string describing status
     */
    public String getStatusDesc() {
        return statusDesc.toString();
    }

    private void setStatusDesc() {
         statusDesc.append(", and unknown request");
    }

    public void setStatusDesc(String s) {
        statusDesc.append(s);
    }

    /**
     * Get the cost of this request
     * @return Integer representing the cost of request as number of pennies
     */
    public int getRequestCost() {
        return dbi.getRequestCost() + requestCost;
    }

    /**
     * get the id of this request
     *
     * @return a numeric id that increases during life of server for each request .
     */
    public long getId() {
        return id;
    }

    SystemInformationFacadeInterface getSystemInformationFacade() {
        return sifi;
    }
}
