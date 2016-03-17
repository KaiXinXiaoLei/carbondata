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
 * Generated on 29 Jul, 2013 4:59:37 PM
 * Time to generate: 00:24.104 seconds
 *
 */

package com.huawei.unibi.molap.engine.scanner.impl;

import com.agitar.lib.junit.AgitarTestCase;
import com.agitar.lib.mockingbird.Mockingbird;
import com.huawei.unibi.molap.datastorage.store.FileHolder;
import com.huawei.unibi.molap.datastorage.store.compression.ValueCompressionModel;
import com.huawei.unibi.molap.datastorage.store.compression.ValueCompressionUtil;
import com.huawei.unibi.molap.datastorage.store.impl.FileHolderImpl;
import com.huawei.unibi.molap.datastorage.store.impl.data.compressed.HeavyCompressedDoubleArrayDataFileStore;
import com.huawei.unibi.molap.engine.datastorage.DataStoreBlock;
import com.huawei.unibi.molap.engine.datastorage.tree.CSBInternalNode;
import com.huawei.unibi.molap.engine.datastorage.tree.CSBTreeLeafNode;
import com.huawei.unibi.molap.keygenerator.KeyGenerator;
import com.huawei.unibi.molap.keygenerator.mdkey.AbstractKeyGenerator;
import com.huawei.unibi.molap.keygenerator.mdkey.MultiDimKeyVarLengthGenerator;
import com.huawei.unibi.molap.metadata.LeafNodeInfo;

public class KeyValueAgitarTest extends AgitarTestCase {
    
    public Class getTargetClass()  {
        return KeyValue.class;
    }
    
    public void testConstructor() throws Throwable {
        KeyValue keyValue = new KeyValue();
        assertEquals("keyValue.getKeyLength()", 0, keyValue.getKeyLength());
    }
    
    public void testGetArray() throws Throwable {
        byte[] backKeyArray = new byte[0];
        KeyValue keyValue = new KeyValue();
        keyValue.setBackKeyArray(backKeyArray);
        byte[] result = keyValue.getArray();
        assertSame("result", backKeyArray, result);
    }
    
    public void testGetArray1() throws Throwable {
        byte[] backKeyArray = new byte[3];
        KeyValue keyValue = new KeyValue();
        keyValue.setBackKeyArray(backKeyArray);
        byte[] result = keyValue.getArray();
        assertSame("result", backKeyArray, result);
        assertEquals("backKeyArray[0]", (byte)0, backKeyArray[0]);
    }
    
    public void testGetOriginalKey() throws Throwable {
        byte[] key = new byte[3];
        KeyValue keyValue = new KeyValue();
        keyValue.setOriginalKey(key);
        byte[] result = keyValue.getOriginalKey();
        assertSame("result", key, result);
        assertEquals("key[0]", (byte)0, key[0]);
    }
    
    public void testGetOriginalKey1() throws Throwable {
        byte[] backKeyArray = new byte[3];
        KeyValue keyValue = new KeyValue();
        keyValue.setBackKeyArray(backKeyArray);
        byte[] result = keyValue.getOriginalKey();
        assertEquals("result.length", 0, result.length);
    }
    
    public void testGetOriginalValue() throws Throwable {
        double[] val = new double[3];
        KeyValue keyValue = new KeyValue();
        keyValue.setOrigainalValue(val);
        double[] result = keyValue.getOriginalValue();
        assertSame("result", val, result);
        assertEquals("val[0]", 0.0, val[0], 1.0E-6);
    }
    
    public void testGetOriginalValue1() throws Throwable {
        KeyValue keyValue = new KeyValue();
        double[] val = new double[0];
        keyValue.setOrigainalValue(val);
        Mockingbird.enterTestMode(KeyValue.class);
        double[] result = keyValue.getOriginalValue();
        assertEquals("result.length", 0, result.length);
    }
    
    public void testIncrement() throws Throwable {
        KeyValue keyValue = new KeyValue();
        keyValue.increment();
        assertEquals("keyValue.getRow()", 1, keyValue.getRow());
        assertEquals("keyValue.getValueOffset()", 0, keyValue.getValueOffset());
        assertEquals("keyValue.getKeyOffset()", 0, keyValue.getKeyOffset());
    }
    
    public void testReset() throws Throwable {
        KeyValue keyValue = new KeyValue();
        keyValue.reset();
        assertTrue("keyValue.isReset()", keyValue.isReset());
        assertEquals("keyValue.getValueOffset()", 0, keyValue.getValueOffset());
        assertEquals("keyValue.getRow()", 0, keyValue.getRow());
        assertEquals("keyValue.getKeyOffset()", 0, keyValue.getKeyOffset());
    }
    
    public void testResetOffsets() throws Throwable {
        KeyValue keyValue = new KeyValue();
        keyValue.resetOffsets();
        assertEquals("keyValue.getValueOffset()", 0, keyValue.getValueOffset());
        assertEquals("keyValue.getRow()", 0, keyValue.getRow());
        assertEquals("keyValue.getKeyOffset()", 0, keyValue.getKeyOffset());
    }
    
    public void testSearchInternal() throws Throwable {
        KeyValue keyValue = new KeyValue();
        keyValue.setRow(-1);
        byte[] key = new byte[0];
        MultiDimKeyVarLengthGenerator keyGenerator = (MultiDimKeyVarLengthGenerator) Mockingbird.getProxyObject(MultiDimKeyVarLengthGenerator.class);
        Mockingbird.enterRecordingMode();
        Mockingbird.setReturnValue(true, keyGenerator.compare(key, 100, 1000, (byte[]) null, 0, -1), 0);
        Mockingbird.enterTestMode(KeyValue.class);
        int result = keyValue.searchInternal(key, keyGenerator);
        assertEquals("keyValue.getRow()", Integer.MAX_VALUE, keyValue.getRow());
        assertEquals("result", Integer.MAX_VALUE, result);
        assertEquals("keyValue.getValueOffset()", 0, keyValue.getValueOffset());
        assertEquals("keyValue.getKeyOffset()", 0, keyValue.getKeyOffset());
    }
    
    public void testSearchInternal1() throws Throwable {
        int[] lens = new int[2];
        byte[] key = new byte[3];
        int result = new KeyValue().searchInternal(key, new MultiDimKeyVarLengthGenerator(lens));
        assertEquals("result", -1, result);
    }
    
    public void testSearchInternalWithAggressiveMocks() throws Throwable {
        KeyValue keyValue = (KeyValue) Mockingbird.getProxyObject(KeyValue.class, true);
        byte[] bytes = new byte[0];
        setPrivateField(keyValue, "row", new Integer(1));
        keyValue.setKeyOffset(0);
        setPrivateField(keyValue, "nKeys", new Integer(1));
        keyValue.setValueLength((short)0);
        keyValue.setKeyLength(0);
        Mockingbird.enterTestMode(KeyValue.class);
        int result = keyValue.searchInternal(bytes, null);
        assertEquals("result", 0, result);
        assertEquals("keyValue.getValueOffset()", 0, keyValue.getValueOffset());
        assertEquals("keyValue.getRow()", 0, keyValue.getRow());
        assertEquals("keyValue.getKeyOffset()", 0, keyValue.getKeyOffset());
    }
    
    public void testSetBackKeyArray() throws Throwable {
        KeyValue keyValue = new KeyValue();
        byte[] backKeyArray = new byte[2];
        keyValue.setBackKeyArray(backKeyArray);
        assertSame("keyValue.getBackKeyArray()", backKeyArray, keyValue.getBackKeyArray());
    }
    
    public void testSetBlock() throws Throwable {
        KeyValue keyValue = new KeyValue();
        byte[] backKeyArray = new byte[0];
        keyValue.setBlock(new CSBInternalNode(100, 1000, "testKeyValueTableName"), backKeyArray, new FileHolderImpl());
        assertSame("keyValue.getBackKeyArray()", backKeyArray, keyValue.getBackKeyArray());
        assertNull("keyValue.msrData", getPrivateField(keyValue, "msrData"));
        assertEquals("keyValue.nKeys", 0, ((Number) getPrivateField(keyValue, "nKeys")).intValue());
    }
    
    public void testSetBlock1() throws Throwable {
        KeyValue keyValue = new KeyValue();
        keyValue.setBlock(new CSBTreeLeafNode(100, 1000, 0, false), new FileHolderImpl());
        assertEquals("keyValue.getBackKeyArray().length", 100000, keyValue.getBackKeyArray().length);
        assertNull("keyValue.msrData", getPrivateField(keyValue, "msrData"));
        assertEquals("keyValue.nKeys", 0, ((Number) getPrivateField(keyValue, "nKeys")).intValue());
    }
    
    public void testSetKey() throws Throwable {
        KeyValue keyValue = new KeyValue();
        byte[] key = new byte[1];
        keyValue.setKey(key);
        assertSame("keyValue.getKey()", key, keyValue.getKey());
    }
    
    public void testSetKeyLength() throws Throwable {
        KeyValue keyValue = new KeyValue();
        keyValue.setKeyLength(100);
        assertEquals("keyValue.getKeyLength()", 100, keyValue.getKeyLength());
    }
    
    public void testSetKeyOffset() throws Throwable {
        KeyValue keyValue = new KeyValue();
        keyValue.setKeyOffset(100);
        assertEquals("keyValue.getKeyOffset()", 100, keyValue.getKeyOffset());
    }
    
    public void testSetMsrCols() throws Throwable {
        KeyValue keyValue = new KeyValue();
        int[] msrCols = new int[2];
        keyValue.setMsrCols(msrCols);
        assertSame("keyValue.getMsrCols()", msrCols, keyValue.getMsrCols());
    }
    
    public void testSetOrigainalValue() throws Throwable {
        KeyValue keyValue = new KeyValue();
        double[] val = new double[1];
        keyValue.setOrigainalValue(val);
        assertSame("keyValue.val", val, getPrivateField(keyValue, "val"));
    }
    
    public void testSetOriginalKey() throws Throwable {
        KeyValue keyValue = new KeyValue();
        byte[] key = new byte[2];
        keyValue.setOriginalKey(key);
        assertSame("keyValue.getKey()", key, keyValue.getKey());
    }
    
    public void testSetReset() throws Throwable {
        KeyValue keyValue = new KeyValue();
        keyValue.setReset(true);
        assertTrue("keyValue.isReset()", keyValue.isReset());
    }
    
    public void testSetRow() throws Throwable {
        KeyValue keyValue = new KeyValue();
        keyValue.setRow(100);
        assertEquals("keyValue.getRow()", 100, keyValue.getRow());
        assertEquals("keyValue.getValueOffset()", 0, keyValue.getValueOffset());
        assertEquals("keyValue.getKeyOffset()", 0, keyValue.getKeyOffset());
    }
    
    public void testSetValueLength() throws Throwable {
        KeyValue keyValue = new KeyValue();
        keyValue.setValueLength((short)100);
        assertEquals("keyValue.getValueLength()", (short)100, keyValue.getValueLength());
    }
    
    public void testSetValueOffset() throws Throwable {
        KeyValue keyValue = new KeyValue();
        keyValue.setValueOffset(100);
        assertEquals("keyValue.getValueOffset()", 100, keyValue.getValueOffset());
    }
    
    public void testGetOriginalKeyThrowsArrayIndexOutOfBoundsException() throws Throwable {
        byte[] backKeyArray = new byte[2];
        KeyValue keyValue = new KeyValue();
        keyValue.setBackKeyArray(backKeyArray);
        keyValue.setKeyOffset(100);
        try {
            keyValue.getOriginalKey();
            fail("Expected ArrayIndexOutOfBoundsException to be thrown");
        } catch (ArrayIndexOutOfBoundsException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(System.class, ex);
        }
    }
    
    public void testGetOriginalKeyThrowsNegativeArraySizeException() throws Throwable {
        KeyValue keyValue = new KeyValue();
        keyValue.setKeyLength(-1);
        try {
            keyValue.getOriginalKey();
            fail("Expected NegativeArraySizeException to be thrown");
        } catch (NegativeArraySizeException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(KeyValue.class, ex);
        }
    }
    
    public void testGetOriginalKeyThrowsNullPointerException() throws Throwable {
        try {
            new KeyValue().getOriginalKey();
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(System.class, ex);
        }
    }
    
    public void testGetOriginalValueThrowsNullPointerException() throws Throwable {
        KeyValue keyValue = new KeyValue();
        try {
            keyValue.getOriginalValue();
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(KeyValue.class, ex);
            assertNull("keyValue.msrData", getPrivateField(keyValue, "msrData"));
        }
    }
    
    public void testGetValueThrowsNullPointerException() throws Throwable {
        KeyValue keyValue = new KeyValue();
        try {
            keyValue.getValue(100);
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(KeyValue.class, ex);
            assertNull("keyValue.msrData", getPrivateField(keyValue, "msrData"));
        }
    }
    
    public void testSearchInternalThrowsArrayIndexOutOfBoundsException() throws Throwable {
        KeyValue keyValue = new KeyValue();
        int[] lens = new int[2];
        keyValue.setKeyLength(100);
        KeyGenerator keyGenerator = new MultiDimKeyVarLengthGenerator(lens);
        keyValue.setRow(-1);
        byte[] key = new byte[0];
        try {
            keyValue.searchInternal(key, keyGenerator);
            fail("Expected ArrayIndexOutOfBoundsException to be thrown");
        } catch (ArrayIndexOutOfBoundsException ex) {
            assertEquals("ex.getMessage()", "0", ex.getMessage());
            assertThrownBy(AbstractKeyGenerator.class, ex);
            assertEquals("keyValue.getValueOffset()", 0, keyValue.getValueOffset());
            assertEquals("keyValue.getRow()", -1, keyValue.getRow());
            assertEquals("keyValue.getKeyOffset()", -100, keyValue.getKeyOffset());
            assertEquals("(MultiDimKeyVarLengthGenerator) keyGenerator.getDimCount()", 2, ((MultiDimKeyVarLengthGenerator) keyGenerator).getDimCount());
        }
    }
    
    public void testSearchInternalThrowsNullPointerException() throws Throwable {
        KeyValue keyValue = new KeyValue();
        keyValue.setRow(-1);
        byte[] key = new byte[0];
        try {
            keyValue.searchInternal(key, null);
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(KeyValue.class, ex);
            assertEquals("keyValue.getValueOffset()", 0, keyValue.getValueOffset());
            assertEquals("keyValue.getRow()", -1, keyValue.getRow());
            assertEquals("keyValue.getKeyOffset()", 0, keyValue.getKeyOffset());
        }
    }
    
    public void testSetBlockThrowsArrayIndexOutOfBoundsException() throws Throwable {
        KeyValue keyValue = new KeyValue();
        FileHolderImpl fileHolder = (FileHolderImpl) Mockingbird.getProxyObject(FileHolderImpl.class);
        CSBTreeLeafNode block = (CSBTreeLeafNode) Mockingbird.getProxyObject(CSBTreeLeafNode.class);
        Mockingbird.enterRecordingMode();
        Mockingbird.setException(true, block.getNodeMsrDataWrapper((int[]) null, fileHolder), (Throwable) Mockingbird.getProxyObject(ArrayIndexOutOfBoundsException.class));
        Mockingbird.enterTestMode(KeyValue.class);
        try {
            keyValue.setBlock(block, fileHolder);
            fail("Expected ArrayIndexOutOfBoundsException to be thrown");
        } catch (ArrayIndexOutOfBoundsException ex) {
            assertNull("keyValue.getBackKeyArray()", keyValue.getBackKeyArray());
            assertNull("keyValue.msrData", getPrivateField(keyValue, "msrData"));
            assertEquals("keyValue.nKeys", 0, ((Number) getPrivateField(keyValue, "nKeys")).intValue());
            assertNull("block.getNext()", block.getNext());
        }
    }
    
    public void testSetBlockThrowsNullPointerException() throws Throwable {
        KeyValue keyValue = new KeyValue();
        byte[] backKeyArray = new byte[0];
        try {
            keyValue.setBlock(null, backKeyArray, new FileHolderImpl());
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(KeyValue.class, ex);
            assertNull("keyValue.getBackKeyArray()", keyValue.getBackKeyArray());
            assertNull("keyValue.msrData", getPrivateField(keyValue, "msrData"));
            assertEquals("keyValue.nKeys", 0, ((Number) getPrivateField(keyValue, "nKeys")).intValue());
        }
    }
    
    public void testSetBlockThrowsNullPointerException1() throws Throwable {
        int[] measureLength = new int[2];
        LeafNodeInfo leafNodeInfo = new LeafNodeInfo();
        leafNodeInfo.setMeasureLength(measureLength);
        KeyValue keyValue = new KeyValue();
        FileHolder fileHolder = new FileHolderImpl(100);
        ValueCompressionModel compressionModel = ValueCompressionUtil.getValueCompressionModel("testKeyValueMeasureMetaDataFileLocation", 100);
        DataStoreBlock block = new CSBTreeLeafNode(0, 100, true, fileHolder, leafNodeInfo, compressionModel);
        try {
            keyValue.setBlock(block, new FileHolderImpl());
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(HeavyCompressedDoubleArrayDataFileStore.class, ex);
            assertNull("keyValue.getBackKeyArray()", keyValue.getBackKeyArray());
            assertNull("keyValue.msrData", getPrivateField(keyValue, "msrData"));
            assertEquals("keyValue.nKeys", 0, ((Number) getPrivateField(keyValue, "nKeys")).intValue());
            assertEquals("(CSBTreeLeafNode) block.getnKeys()", 0, ((CSBTreeLeafNode) block).getnKeys());
        }
    }
}

