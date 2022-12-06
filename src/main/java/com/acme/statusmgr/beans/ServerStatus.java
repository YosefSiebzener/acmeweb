package com.acme.statusmgr.beans;

import com.acme.servermgr.ServerManager;

/**
 * A POJO that represents Server Status and can be returned as the result of a request.
 */
public class ServerStatus extends DetailsBaseImplementation {

    /**
     * Construct a ServerStatus using info passed in for identification, and obtaining current
     * server status from the appropriate Manager class.
     * This class must return a pretty, english-like representation of the server status.
     *
     * @param id            a numeric identifier/counter of which request this is
     * @param contentHeader info about the request
     */
    public ServerStatus(long id, String contentHeader) {
        super(id, contentHeader, "Server is " + ServerManager.getCurrentServerStatus(), 1);
    }
}
