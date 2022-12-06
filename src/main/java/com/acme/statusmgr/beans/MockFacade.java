package com.acme.statusmgr.beans;

public class MockFacade implements SystemInformationFacadeInterface {
    @Override
    public int getAvailableProcessors() {
        return 0;
    }

    @Override
    public long getFreeMemory() {
        return 0;
    }

    @Override
    public long getTotalMemory() {
        return 0;
    }

    @Override
    public String getJreVersion() {
        return null;
    }

    @Override
    public String getTempLocation() {
        return null;
    }
}
