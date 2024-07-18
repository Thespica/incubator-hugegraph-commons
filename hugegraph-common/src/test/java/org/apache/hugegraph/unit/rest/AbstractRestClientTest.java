/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with this
 * work for additional information regarding copyright ownership. The ASF
 * licenses this file to You under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package org.apache.hugegraph.unit.rest;

import org.apache.hugegraph.rest.AbstractRestClient;
import org.junit.Assert;
import org.junit.Test;

public class AbstractRestClientTest {

    @Test
    public void testEncodeWithSpaces() {
        String raw = "hello world";
        String expected = "hello%20world";
        String encoded = AbstractRestClient.encode(raw);
        Assert.assertEquals(expected, encoded);
    }

    @Test
    public void testEncodeWithSpecialCharacters() {
        String raw = "hello@world!";
        String expected = "hello%40world%21";
        String encoded = AbstractRestClient.encode(raw);
        Assert.assertEquals(expected, encoded);
    }

    @Test
    public void testEncodeWithChineseCharacters() {
        String raw = "你好";
        String expected = "%E4%BD%A0%E5%A5%BD";
        String encoded = AbstractRestClient.encode(raw);
        Assert.assertEquals(expected, encoded);
    }

    @Test
    public void testEncodeWithNullInput() {
        String raw = null;
        Assert.assertThrows(NullPointerException.class, () -> {
            AbstractRestClient.encode(raw);
        });
    }
}