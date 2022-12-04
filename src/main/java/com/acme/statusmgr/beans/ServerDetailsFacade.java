package com.acme.statusmgr.beans;

import java.util.List;

public class ServerDetailsFacade {
    static StringBuilder detailsStringBuilder = new StringBuilder();
    static Runtime runtime = Runtime.getRuntime();

    /**
     * Returns easily understandable string containing data requested by the user
     * @param request data that user is requesting
     * @return String
     */
    public static String getDetails(List<String> request) {
        for (String s :
                request) {
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
     * Returns easily understandable string containing the amount of available processors
     *
     * @return String
     */
    static String getAvailableProcessors() {
        return getAvailableProcessors(false);
    }

    /**
     * Returns easily understandable string containing the amount of available processors
     *
     * @param test sets whether method should return actual value or static value
     *             for testing purposes.
     * @return String
     */
    static String getAvailableProcessors(boolean test) {
        int amount;
        amount = test ? 4 : runtime.availableProcessors();

        return ", and there are " + amount +
                " processors available";
    }

    /**
     * Returns easily understandable string containing the amount of free memory
     *
     * @return String
     */
    static String getFreeMemory() {
        return getFreeMemory(false);
    }

    /**
     * Returns easily understandable string containing the amount of free memory
     *
     * @param test sets whether method should return actual value or static value
     *             for testing purposes.
     * @return String
     */
    static String getFreeMemory(boolean test) {
        long amount;
        amount = test ? 127268272 : runtime.freeMemory();

        return ", and there are " + amount +
                "bytes of JVM memory free";
    }

    /**
     * Returns easily understandable string containing the total amount of memory
     *
     * @return String
     */
    static String getTotalMemory() {
        return getTotalMemory(false);
    }

    /**
     * Easily understandable string containing the total amount of memory
     *
     * @param test sets whether method should return actual value or static value
     *             for testing purposes.
     * @return String
     */
    static String getTotalMemory(boolean test) {
        long amount;
        amount = test ? 159383552 : runtime.freeMemory();

        return ", and there is a total of " + amount +
                "bytes of JVM memory";
    }

    /**
     * Easily understandable string containing the JRE version info
     *
     * @return String
     */
    static String getJreVersion() {

        return getJreVersion(false);
    }

    /**
     * Easily understandable string containing the JRE version info
     *
     * @param test sets whether method should return actual value or static value
     *             for testing purposes.
     * @return String
     */
    static String getJreVersion(boolean test) {
        String version;
        version = test ? "15.0.2+7-27" : String.valueOf(Runtime.version());
        return ", and the JRE version is " + version;
    }


    /**
     * Easily understandable string containing the location of the temp file
     *
     * @return String
     */
    static String getTempLocation() {
        return getTempLocation(false);
    }

    /**
     * Easily understandable string containing the location of the temp file
     *
     * @param test sets whether method should return actual value or static value
     *             for testing purposes.
     * @return String
     */
    static String getTempLocation(boolean test) {
        String loc;
        loc = test ? "M:\\\\AppData\\\\Local\\\\Temp" : System.getenv("TEMP");
        return ", and the server's temp file location is " + loc;
    }
}
