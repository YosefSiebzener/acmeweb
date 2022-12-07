package com.acme.statusmgr.beans;

public abstract class DetailsBaseImplementation {

    protected long id;                // Unique identifier of request, sequential number
    protected String contentHeader;   // Some info about the request
    protected int requestCost;  // the cost in pennies of this request.
    private DetailsBaseImplementation dbi;
    protected String statusDesc = "";  // the status being returned
    protected static SystemInformationFacadeInterface sifi = new ServerDetailsFacade();

    DetailsBaseImplementation(DetailsBaseImplementation dbi, int requestCost) {
        this.dbi = dbi;
        this.requestCost = requestCost;
    }

    DetailsBaseImplementation(String statusDesc, int requestCost) {
        this.statusDesc = statusDesc;
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
        return dbi.getStatusDesc() + statusDesc;
    }

    public void setStatusDesc(String s) {
        statusDesc = s;
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
        return dbi.getId();
    }

    public static void setSifi(SystemInformationFacadeInterface sifi) {
        DetailsBaseImplementation.sifi = sifi;
    }
}
