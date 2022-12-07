package com.acme.statusmgr.beans;

public abstract class DetailsBaseImplementation {

    private long id;                // Unique identifier of request, sequential number
    private String contentHeader;   // Some info about the request
    private int requestCost = 0;  // the cost in pennies of this request.
    DetailsBaseImplementation dbi;
    private String statusDesc = "";  // the status being returned
    SystemInformationFacadeInterface sifi = new ServerDetailsFacade();

    DetailsBaseImplementation(DetailsBaseImplementation dbi, int requestCost) {
        this.dbi = dbi;
        this.requestCost = dbi.getRequestCost() + requestCost;
        this.contentHeader = dbi.getContentHeader();
        this.id = dbi.getId();
        this.sifi = dbi.getSystemInformationFacade();
    }

    DetailsBaseImplementation(DetailsBaseImplementation dbi,
                              int requestCost, SystemInformationFacadeInterface sifi) {
        this.dbi = dbi;
        this.requestCost += requestCost;
        this.sifi = sifi;
    }

    DetailsBaseImplementation(long id, String contentHeader, String statusDesc, int requestCost) {
        this.id = id;
        this.contentHeader = contentHeader;
        this.statusDesc = statusDesc;
        this.requestCost = requestCost;
    }

    /**
     * Get the content header that was specified by the request
     *
     * @return some string
     */
    public String getContentHeader() {
        return contentHeader;
    }

    /**
     * Get an english-like description of the server's status
     *
     * @return A string describing status
     */
    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String s) {
        statusDesc = dbi.getStatusDesc() + s;
    }

    /**
     * Get the cost of this request
     * @return Integer representing the cost of request as number of pennies
     */
    public int getRequestCost() {
        return requestCost;
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
