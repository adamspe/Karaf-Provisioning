/*******************************************************************************
 * The MIT License (MIT)
 * 
 * Copyright (c) 2014 Paul Adams (adamspe@notiosoftware.com)
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 ******************************************************************************/
package com.notio.example.karaf.provision.command;

import org.apache.felix.service.command.CommandSession;
import org.apache.karaf.shell.commands.Action;
import org.apache.karaf.shell.commands.Argument;
import org.apache.karaf.shell.commands.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.notio.example.karaf.provision.ExampleService;

@Command(scope="example",name="sayHello",description="Passes a name to an OSGi service and prints the response.")
public class ExampleCommand implements Action {
    private static final Logger LOG = LoggerFactory.getLogger(ExampleCommand.class);

    @Argument(index=0,name="Name",required=true,description="Your Name",multiValued=false)
    String name;

    private CommandConfig config;
    private ExampleService service;

    public void setCommandConfig(CommandConfig cc) {
        config = cc;
    }
    public void setExampleService(ExampleService s) {
        service = s;
    }

    public Object execute(CommandSession arg0) throws Exception {
        if(LOG.isInfoEnabled()) {
            LOG.info("Sending '{}' to ExampleService.",name);
        }
        System.out.printf(config.getFmt(),service.sayHello(name));
        return null;
    }
}
