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
package com.notio.example.karaf.provision.s2;

import org.apache.commons.lang.WordUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.notio.example.karaf.provision.ExampleService;

public class ExampleServiceImpl implements ExampleService {
    private static final Logger LOG = LoggerFactory.getLogger(ExampleServiceImpl.class);
    private static final char [] INITIAL_DELIMS = {' ', '.'};

    static final String FMT = "Hello to %s from Service Implementation #2 (%s).  Your initials are '%s'";

    public String sayHello(String name) {
        if(LOG.isInfoEnabled()) {
            LOG.info("sayHello('{}')",name);
        }
        final String caps = WordUtils.capitalize(name);
        final String initials = WordUtils.initials(caps, INITIAL_DELIMS);
        return String.format(FMT,caps,ExampleServiceImpl.class.getName(),initials);
    }
}
