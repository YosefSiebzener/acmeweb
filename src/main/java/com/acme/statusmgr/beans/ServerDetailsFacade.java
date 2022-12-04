package com.acme.statusmgr.beans;

public class ServerDetailsFacade {
    static StringBuilder detailsStringBuilder = new StringBuilder();
    static Runtime runtime = Runtime.getRuntime();

    /**
     * Returns easily understandable string containing data requested by the user
     * @param request data that user is requesting
     * @return String
     */
    static String getDetails(String request) {
        String[] requestArray = request.split(",");
        for (String s :
                requestArray) {
            switch (s) {
                case "availableProcessors":
                    detailsStringBuilder.append(getAvailableProcessors());
                    break;
                case "freeJVMMemory":
                    detailsStringBuilder.append(getFreeMemory());
                    break;
                case "totalJVMMemory":
                    detailsStringBuilder.append(getTotalMemory());
                    break;
                case "jreVersion":
                    detailsStringBuilder.append(getJreVersion());
                    break;
                case "tempLocation":
                    detailsStringBuilder.append(getTempLocation());
                    break;
                default:
                    return ", not implemented request";
            }
        }
        return detailsStringBuilder.toString();
    }

    /**
     * Easily understandable string containing the amount of available processors
     *
     * @return String
     */
    static String getAvailableProcessors() {
        return ", and there are " + runtime.availableProcessors() +
                " processors available";
    }

    /**
     * Easily understandable string containing the amount of free memory
     *
     * @return String
     */
    static String getFreeMemory() {
        return ", and there are " + runtime.freeMemory() +
                "bytes of JVM memory free";
    }

    /**
     * Easily understandable string containing the total amount of memory
     *
     * @return String
     */
    static String getTotalMemory() {
        return ", and there is a total of " + runtime.totalMemory() +
                "bytes of JVM memory";
    }

    /**
     * Easily understandable string containing the JRE version info
     *
     * @return String
     */
    static String getJreVersion() {

        return ", and the JRE version is " + Runtime.version();
    }

    /**
     * Easily understandable string containing the location of the temp file
     *
     * @return String
     */
    static String getTempLocation() {
        return ", and the server's temp file location is " + System.getenv("TEMP");
    }

}
