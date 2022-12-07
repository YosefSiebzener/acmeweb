package com.acme.statusmgr;

import com.acme.statusmgr.beans.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Controller for all web/REST requests about the status of servers
 * <p>
 * For initial school project - just handles info about this server
 * Syntax for URLS:
 * All start with /server
 * /status  will give back status of server
 * a param of 'name' specifies a requester name to appear in response
 * <p>
 * Examples:
 * http://localhost:8080/server/status
 * <p>
 * http://localhost:8080/server/status?name=Noach
 */
@RestController
@RequestMapping("/server")
public class StatusController {

    protected static final String template = "Server Status requested by %s";
    protected final AtomicLong counter = new AtomicLong();

    /**
     * Process a request for server status information
     *
     * @param name optional param identifying the requester
     * @param details optional param for logging details
     * @return a ServerStatus object containing the info to be returned to the requester
     */
    @RequestMapping("/status")
    public ServerStatus getStatus(@RequestParam(defaultValue = "Anonymous") String name,
                                  @RequestParam(required = false) List<String> details) {
        if (!Objects.equals(details,null)) {
            Logger logger = LoggerFactory.getLogger("StuffImInterestedIn");
            logger.info("Details were provided: " + details);
        }
        return new ServerStatus(counter.incrementAndGet(),
                String.format(template, name));
    }

    /**
     * Process a request for server system information
     *
     * @param name optional param identifying the requester
     * @param details optional param identifying the details to be provided
     * @return a ServerStatus object containing the info to be returned to the requester
     */
    @RequestMapping("status/detailed")
    public DetailsBaseImplementation getStatusDesc(@RequestParam(defaultValue = "Anonymous") String name,
                                  @RequestParam List<String> details, HttpServletResponse response) throws IOException {
        ServerStatus serverStatus = getStatus(name, details);
        return iterateThroughDetails(serverStatus, details, response);
    }

    private DetailsBaseImplementation iterateThroughDetails(ServerStatus serverStatus, List<String> details,
                                                            HttpServletResponse response) throws IOException {
        DetailsBaseImplementation dbi = serverStatus;
        for (String detail :
                details) {
            switch (detail) {
                case "availableProcessors" -> dbi = new AvailableProcessorsDecorator(dbi);
                case "freeJVMMemory" -> dbi = new FreeMemoryDecorator(dbi);
                case "jreVersion" -> dbi = new JreVersionDecorator(dbi);
                case "tempLocation" -> dbi = new TempLocationDecorator(dbi);
                case "totalJVMMemory" -> dbi = new TotalMemoryDecorator(dbi);
                default -> throwException(response, detail);
            }
        }
        return dbi;
    }

    // Based off of: https://stackoverflow.com/questions/8594645/in-spring-3-is-it-possible-to-dynamically-set-the-reason-of-responsestatus#:~:text=You%20can%20use,error%20message%22)%3B%0A%7D
    private void throwException(final HttpServletResponse response, String badParam) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value(), "Invalid details option: " + badParam);
    }
}
