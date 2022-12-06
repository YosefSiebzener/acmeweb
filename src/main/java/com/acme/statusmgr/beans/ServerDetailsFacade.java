package com.acme.statusmgr.beans;

public class ServerDetailsFacade implements SystemInformationFacadeInterface {
    static Runtime runtime = Runtime.getRuntime();

    /**
     * Returns amount of available processors
     *
     * @return int
     */
    public int getAvailableProcessors() {
        return runtime.availableProcessors();
    }

    /**
     * Returns amount of free memory
     *
     * @return long
     */
    public long getFreeMemory() {
        return runtime.freeMemory();
    }

    /**
     * Returns total amount of memory
     *
     * @return long
     */
    public long getTotalMemory() {
        return runtime.totalMemory();
    }

    /**
     * Easily the JRE version info
     *
     * @return String
     */
    public String getJreVersion() {
        return String.valueOf(Runtime.version());
    }


    /**
     * Easily the location of the temp file
     *
     * @return String
     */
    public String getTempLocation() {
        return System.getenv("TEMP");
    }
}
