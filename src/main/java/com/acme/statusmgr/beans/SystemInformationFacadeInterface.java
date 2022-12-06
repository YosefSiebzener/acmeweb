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
     * Easily the JRE version info
     *
     * @return String
     */
    public String getJreVersion();


    /**
     * Easily the location of the temp file
     *
     * @return String
     */
    public String getTempLocation();
}
