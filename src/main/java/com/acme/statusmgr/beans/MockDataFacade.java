package com.acme.statusmgr.beans;

/**
 * This class returns static values for testing purposes.
 */
public class MockDataFacade implements SystemInformationFacadeInterface {

    /**
     * Returns fake value for available processors for testing purposes
     * @return int
     */
    @Override
    public int getAvailableProcessors() {
        return 4;
    }

    /**
     * Returns fake value for free memory for testing purposes
     * @return long
     */
    @Override
    public long getFreeMemory() {
        return 127268272;
    }

    /**
     * Returns fake value for total memory for testing purposes
     * @return long
     */
    @Override
    public long getTotalMemory() {
        return 159383552;
    }

    /**
     * Returns fake value for jre version for testing purposes
     * @return String
     */
    @Override
    public String getJreVersion() {
        return "15.0.2+7-27";
    }

    /**
     * Returns fake value for temp directory for testing purposes
     * @return String
     */
    @Override
    public String getTempLocation() {
        return "M:\\AppData\\Local\\Temp";
    }

    /**
     * Returns fake value for server status for testing purposes
     * @return String
     */
    @Override
    public String getServerStatus() {
        return "up";
    }
}
