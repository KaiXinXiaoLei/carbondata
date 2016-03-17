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
 * Generated on 29 Jul, 2013 2:28:56 PM
 * Time to generate: 00:19.306 seconds
 *
 */

package com.huawei.unibi.molap.datastorage.store.impl.key.uncompressed;

import com.agitar.lib.junit.AgitarTestCase;
import com.huawei.unibi.molap.datastorage.store.FileHolder;
import com.huawei.unibi.molap.datastorage.store.impl.FileHolderImpl;

public class AbstractSingleArrayKeyStoreAgitarTest extends AgitarTestCase {
    
    public Class getTargetClass()  {
        return AbstractSingleArrayKeyStore.class;
    }
    
    public void testClear() throws Throwable {
        AbstractSingleArrayKeyStore singleArrayKeyFileStore = new SingleArrayKeyFileStore(0, 100, 100L, "testAbstractSingleArrayKeyStoreFilePath", 1000);
        singleArrayKeyFileStore.clear();
        assertEquals("(SingleArrayKeyFileStore) singleArrayKeyFileStore.datastore.length", 0, ((SingleArrayKeyFileStore) singleArrayKeyFileStore).datastore.length);
    }
    
    public void testGet() throws Throwable {
        byte[] result = new SingleArrayKeyInMemoryStore(100, 0).get(100, new FileHolderImpl());
        assertEquals("result.length", 0, result.length);
    }
    
    public void testGet1() throws Throwable {
        byte[] result = new SingleArrayKeyInMemoryStore(100, 1000).get(0, new FileHolderImpl());
        assertEquals("result.length", 1000, result.length);
        assertEquals("result[0]", (byte)0, result[0]);
    }
    
    public void testGetBackArray() throws Throwable {
        FileHolder fileHolder = new FileHolderImpl(100);
        byte[] result = new SingleArrayKeyInMemoryStore(100, 1000).getBackArray(fileHolder);
        assertEquals("result.length", 100000, result.length);
        assertEquals("result[0]", (byte)0, result[0]);
    }
    
    public void testGetBackArray1() throws Throwable {
        byte[] result = new SingleArrayKeyInMemoryStore(100, 0).getBackArray(new FileHolderImpl());
        assertEquals("result.length", 0, result.length);
    }
    
    public void testGetWritableKeyArray() throws Throwable {
        byte[] result = new SingleArrayKeyFileStore(100, 1000).getWritableKeyArray();
        assertEquals("result.length", 100000, result.length);
        assertEquals("result[0]", (byte)0, result[0]);
    }
    
    public void testGetWritableKeyArray1() throws Throwable {
        AbstractSingleArrayKeyStore singleArrayKeyFileStore = new SingleArrayKeyFileStore(0, 100, 100L, "testAbstractSingleArrayKeyStoreFilePath", 1000);
        byte[] result = singleArrayKeyFileStore.getWritableKeyArray();
        assertNull("result", result);
    }
    
    public void testGetWritableKeyArray2() throws Throwable {
        byte[] result = new SingleArrayKeyInMemoryStore(100, 0).getWritableKeyArray();
        assertEquals("result.length", 0, result.length);
    }
    
    public void testPut() throws Throwable {
        AbstractSingleArrayKeyStore singleArrayKeyInMemoryStore = new SingleArrayKeyInMemoryStore(100, 0);
        byte[] value = new byte[1];
        singleArrayKeyInMemoryStore.put(100, value);
        assertEquals("(SingleArrayKeyInMemoryStore) singleArrayKeyInMemoryStore.datastore.length", 0, ((SingleArrayKeyInMemoryStore) singleArrayKeyInMemoryStore).datastore.length);
        assertEquals("(SingleArrayKeyInMemoryStore) singleArrayKeyInMemoryStore.sizeOfEachElement", 0, ((SingleArrayKeyInMemoryStore) singleArrayKeyInMemoryStore).sizeOfEachElement);
    }
    
    public void testGetThrowsArrayIndexOutOfBoundsException() throws Throwable {
        try {
            new SingleArrayKeyInMemoryStore(100, 1000).get(100, new FileHolderImpl());
            fail("Expected ArrayIndexOutOfBoundsException to be thrown");
        } catch (ArrayIndexOutOfBoundsException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(System.class, ex);
        }
    }
    
    public void testGetThrowsNegativeArraySizeException() throws Throwable {
        try {
            new SingleArrayKeyInMemoryStore(0, -1).get(100, new FileHolderImpl());
            fail("Expected NegativeArraySizeException to be thrown");
        } catch (NegativeArraySizeException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(AbstractSingleArrayKeyStore.class, ex);
        }
    }
    
    public void testPutThrowsArrayIndexOutOfBoundsException() throws Throwable {
        AbstractSingleArrayKeyStore singleArrayKeyFileStore = new SingleArrayKeyFileStore(0, 100, 100L, "testAbstractSingleArrayKeyStoreFilePath", 1000);
        singleArrayKeyFileStore.clear();
        byte[] value = new byte[1];
        try {
            singleArrayKeyFileStore.put(100, value);
            fail("Expected ArrayIndexOutOfBoundsException to be thrown");
        } catch (ArrayIndexOutOfBoundsException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(System.class, ex);
        }
    }
    
    public void testPutThrowsNullPointerException() throws Throwable {
        try {
            new SingleArrayKeyInMemoryStore(100, 1000).put(100, (byte[]) null);
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(System.class, ex);
        }
    }
}

