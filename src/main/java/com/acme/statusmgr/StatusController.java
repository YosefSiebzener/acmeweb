package com.acme.statusmgr;

import com.acme.statusmgr.beans.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
 * a param of 'name' specifies a requestor name to appear in response
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
                                  @RequestParam List<String> details) {
        ServerStatus serverStatus = getStatus(name, details);
        return iterateThroughDetails(serverStatus, details);
    }

    private DetailsBaseImplementation iterateThroughDetails(ServerStatus serverStatus, List<String> details) {
        DetailsBaseImplementation dbi = serverStatus;
        for (String detail :
                details) {
            switch (detail) {
                case "availableProcessors":
                    dbi = new AvailableProcessorsDecorator(dbi);
                    break;
                case "freeJVMMemory":
                    dbi = new FreeMemoryDecorator(dbi);
                    break;
                case "jreVersion":
                    dbi = new JreVersionDecorator(dbi);
                    break;
                case "tempLocation":
                    dbi = new TempLocationDecorator(dbi);
                    break;
                case "totalJVMMemory":
                    dbi = new TotalMemoryDecorator(dbi);
                    break;
                default:
                    dbi = new DetailsBaseImplementation(dbi);
            }
        }
        return dbi;
    }
}
