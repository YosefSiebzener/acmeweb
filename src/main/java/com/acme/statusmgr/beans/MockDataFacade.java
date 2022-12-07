package com.acme.statusmgr.beans;

/**
 * This class returns static values for testing purposes.
 */
public class MockDataFacade implements SystemInformationFacadeInterface {
    @Override
    public int getAvailableProcessors() {
        return 4;
    }

    @Override
    public long getFreeMemory() {
        return 127268272;
    }

    @Override
    public long getTotalMemory() {
        return 159383552;
    }

    @Override
    public String getJreVersion() {
        return "15.0.2+7-27";
    }

    @Override
    public String getTempLocation() {
        return "M:\\AppData\\Local\\Temp";
    }

    @Override
    public String getServerStatus() {
        return "up";
    }
}
