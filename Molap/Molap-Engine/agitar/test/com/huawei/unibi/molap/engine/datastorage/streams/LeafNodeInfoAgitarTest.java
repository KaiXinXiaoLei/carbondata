/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

/**
 * Generated by Agitar build: AgitarOne Version 5.3.0.000022 (Build date: Jan 04, 2012) [5.3.0.000022]
 * JDK Version: 1.6.0_14
 *
 * Generated on 29 Jul, 2013 4:59:41 PM
 * Time to generate: 00:14.194 seconds
 *
 */

package com.huawei.unibi.molap.engine.datastorage.streams;

import com.agitar.lib.junit.AgitarTestCase;

public class LeafNodeInfoAgitarTest extends AgitarTestCase {
    
    public Class getTargetClass()  {
        return LeafNodeInfo.class;
    }
    
    public void testConstructor() throws Throwable {
        LeafNodeInfo leafNodeInfo = new LeafNodeInfo();
        assertNull("leafNodeInfo.getFileName()", leafNodeInfo.getFileName());
    }
    
    public void testSetFileName() throws Throwable {
        LeafNodeInfo leafNodeInfo = new LeafNodeInfo();
        leafNodeInfo.setFileName("testLeafNodeInfoFileName");
        assertEquals("leafNodeInfo.getFileName()", "testLeafNodeInfoFileName", leafNodeInfo.getFileName());
    }
    
    public void testSetKeyLength() throws Throwable {
        LeafNodeInfo leafNodeInfo = new LeafNodeInfo();
        leafNodeInfo.setKeyLength(100);
        assertEquals("leafNodeInfo.getKeyLength()", 100, leafNodeInfo.getKeyLength());
    }
    
    public void testSetKeyOffset() throws Throwable {
        LeafNodeInfo leafNodeInfo = new LeafNodeInfo();
        leafNodeInfo.setKeyOffset(100L);
        assertEquals("leafNodeInfo.getKeyOffset()", 100L, leafNodeInfo.getKeyOffset());
    }
    
    public void testSetMeasureLength() throws Throwable {
        LeafNodeInfo leafNodeInfo = new LeafNodeInfo();
        int[] measureLength = new int[2];
        leafNodeInfo.setMeasureLength(measureLength);
        assertSame("leafNodeInfo.getMeasureLength()", measureLength, leafNodeInfo.getMeasureLength());
    }
    
    public void testSetMeasureOffset() throws Throwable {
        LeafNodeInfo leafNodeInfo = new LeafNodeInfo();
        long[] measureOffset = new long[2];
        leafNodeInfo.setMeasureOffset(measureOffset);
        assertSame("leafNodeInfo.getMeasureOffset()", measureOffset, leafNodeInfo.getMeasureOffset());
    }
    
    public void testSetNumberOfKeys() throws Throwable {
        LeafNodeInfo leafNodeInfo = new LeafNodeInfo();
        leafNodeInfo.setNumberOfKeys(100);
        assertEquals("leafNodeInfo.getNumberOfKeys()", 100, leafNodeInfo.getNumberOfKeys());
    }
}

