package com.acme.statusmgr.beans;

public interface SystemInformationFacadeInterface {

    /**
     * Returns amount of available processors
     *
     * @return int
     */
    public int getAvailableProcessors();

    /**
     * Returns amount of free memory
     *
     * @return long
     */
    public long getFreeMemory();

    /**
     * Returns total amount of memory
     *
     * @return long
     */
    public long getTotalMemory();
    /**
     * Returns the JRE version info
     *
     * @return String
     */
    public String getJreVersion();


    /**
     * Returns the location of the temp file
     *
     * @return String
     */
    public String getTempLocation();

    /**
     * Returns the server status
     *
     * @return String
     */
    public String getServerStatus();
}
