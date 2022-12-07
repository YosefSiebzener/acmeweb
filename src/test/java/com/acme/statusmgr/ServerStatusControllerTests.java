/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.acme.statusmgr;

import com.acme.statusmgr.beans.DetailsBaseImplementation;
import com.acme.statusmgr.beans.MockDataFacade;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.concurrent.atomic.AtomicInteger;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class ServerStatusControllerTests {

    @BeforeAll
    static void setSystemInformationFacadeToMock() {
        DetailsBaseImplementation.setSifi(new MockDataFacade());
    }

    @Autowired
    private MockMvc mockMvc;

//    /**
//     * Test to check if id is auto incrementing.
//     *
//     * <p>
//     * WARNING: Test is currently unreliable if ran with other tests at the same time.
//     * This test is only reliable if it is run by itself.
//     */
//    @Test
//    public void idIncrementationTest() throws Exception {
//        this.mockMvc.perform(get("/server/status")).andExpect(status().isOk())
//                .andExpect(jsonPath("$.id").value(1));
//        this.mockMvc.perform(get("/server/status")).andExpect(status().isOk())
//                .andExpect(jsonPath("$.id").value(2));
//        this.mockMvc.perform(get("/server/status/detailed?details=availableProcessors")).andExpect(status().isOk())
//                .andExpect(jsonPath("$.id").value(3));
//        this.mockMvc.perform(get("/server/status/detailed?details=availableProcessors")).andExpect(status().isOk())
//                .andExpect(jsonPath("$.id").value(4));
//    }

    /**
     *
     * @throws Exception
     */
    @Test
    public void noNameParamShouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/server/status")).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.statusDesc").value("Server is up"));
    }

    @Test
    public void nameParamShouldReturnTailoredMessage() throws Exception {

        this.mockMvc.perform(get("/server/status").param("name", "RebYid"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.contentHeader").value("Server Status requested by RebYid"));
    }

    @Test
    public void detailed_name_availProc() throws Exception {
        this.mockMvc.perform(get("/server/status/detailed?details=availableProcessors&name=Yankel"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.contentHeader").value("Server Status requested by Yankel"))
                .andExpect(jsonPath("$.requestCost").value(4))
                .andExpect(jsonPath("$.statusDesc").value("Server is up, and there are 4 processors available"));
    }

    @Test
    public void detailed_name_freeMem() throws Exception {
        this.mockMvc.perform(get("/server/status/detailed?details=freeJVMMemory&name=Yankel"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.contentHeader").value("Server Status requested by Yankel"))
                .andExpect(jsonPath("$.requestCost").value(8))
                .andExpect(jsonPath("$.statusDesc").value("Server is up, and there are 127268272 bytes of JVM memory free"));
    }

    @Test
    public void detailed_name_totMem() throws Exception {
        this.mockMvc.perform(get("/server/status/detailed?details=totalJVMMemory&name=Yankel"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.contentHeader").value("Server Status requested by Yankel"))
                .andExpect(jsonPath("$.requestCost").value(14))
                .andExpect(jsonPath("$.statusDesc").value("Server is up, and there is a total of 159383552 bytes of JVM memory"));
    }

    @Test
    public void detailed_name_jreVersion() throws Exception {
        this.mockMvc.perform(get("/server/status/detailed?details=jreVersion&name=Yankel"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.contentHeader").value("Server Status requested by Yankel"))
                .andExpect(jsonPath("$.requestCost").value(20))
                .andExpect(jsonPath("$.statusDesc").value("Server is up, and the JRE version is 15.0.2+7-27"));
    }

    @Test
    public void detailed_name_tempLoc() throws Exception {
        this.mockMvc.perform(get("/server/status/detailed?details=tempLocation&name=Yankel"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.contentHeader").value("Server Status requested by Yankel"))
                .andExpect(jsonPath("$.requestCost").value(30))
                .andExpect(jsonPath("$.statusDesc").value("Server is up, and the server's temp file location is M:\\AppData\\Local\\Temp"));
    }

    @Test
    public void detailed_name_tempLoc_availProc() throws Exception {
        this.mockMvc.perform(get("/server/status/detailed?details=tempLocation,availableProcessors&name=Yankel"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.contentHeader").value("Server Status requested by Yankel"))
                .andExpect(jsonPath("$.requestCost").value(33))
                .andExpect(jsonPath("$.statusDesc").value("Server is up, and the server's temp file location is M:\\AppData\\Local\\Temp, and there are 4 processors available"));
    }

    @Test
    public void detailed_name_jreVersion_freeMem_availProc_totMem_tempLoc() throws Exception {
        this.mockMvc.perform(get("/server/status/detailed?details=jreVersion,freeJVMMemory,availableProcessors,totalJVMMemory,tempLocation&name=Yankel"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.contentHeader").value("Server Status requested by Yankel"))
                .andExpect(jsonPath("$.requestCost").value(72))
                .andExpect(jsonPath("$.statusDesc").value("Server is up" +
                        ", and the JRE version is 15.0.2+7-27" +
                        ", and there are 127268272 bytes of JVM memory free" +
                        ", and there are 4 processors available" +
                        ", and there is a total of 159383552 bytes of JVM memory" +
                        ", and the server's temp file location is M:\\AppData\\Local\\Temp"));
    }

    @Test
    public void detailed_name_availProc_availProc_availProc_availProc() throws Exception {
        this.mockMvc.perform(get("/server/status/detailed?details=availableProcessors,availableProcessors,availableProcessors,availableProcessors&name=Yankel"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.contentHeader").value("Server Status requested by Yankel"))
                .andExpect(jsonPath("$.requestCost").value(13))
                .andExpect(jsonPath("$.statusDesc").value("Server is up" +
                        ", and there are 4 processors available" +
                        ", and there are 4 processors available" +
                        ", and there are 4 processors available" +
                        ", and there are 4 processors available"));
    }

    @Test
    public void detailed_name_freeMem_availProc_totMem_freeMem_availProc_totMem() throws Exception {
        this.mockMvc.perform(get("/server/status/detailed?details=freeJVMMemory,availableProcessors,totalJVMMemory," +
                        "freeJVMMemory,availableProcessors,totalJVMMemory&name=Yankel"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.contentHeader").value("Server Status requested by Yankel"))
                .andExpect(jsonPath("$.requestCost").value(47))
                .andExpect(jsonPath("$.statusDesc").value("Server is up" +
                        ", and there are 127268272 bytes of JVM memory free" +
                        ", and there are 4 processors available" +
                        ", and there is a total of 159383552 bytes of JVM memory" +
                        ", and there are 127268272 bytes of JVM memory free" +
                        ", and there are 4 processors available" +
                        ", and there is a total of 159383552 bytes of JVM memory"));
    }

    @Test
    public void unsupported_param_should_throw_exception() throws Exception {
        this.mockMvc.perform(get("/server/status/detailed?details=HelloWorld"))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(status().reason(is("Invalid details option: HelloWorld")));
    }
}
