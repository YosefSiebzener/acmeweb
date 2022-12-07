package com.acme.statusmgr.beans;

import com.acme.servermgr.ServerManager;

public class ServerDetailsFacade implements SystemInformationFacadeInterface {
    static Runtime runtime = Runtime.getRuntime();

    @Override
    public int getAvailableProcessors() {
        return runtime.availableProcessors();
    }

    @Override
    public long getFreeMemory() {
        return runtime.freeMemory();
    }

    @Override
    public long getTotalMemory() {
        return runtime.totalMemory();
    }

    @Override
    public String getJreVersion() {
        return String.valueOf(Runtime.version());
    }


    @Override
    public String getTempLocation() {
        return System.getenv("TEMP");
    }

    @Override
    public String getServerStatus() {
        return ServerManager.getCurrentServerStatus();
    }
}
