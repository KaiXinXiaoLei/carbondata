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

package com.huawei.unibi.molap.sortandgroupby.sortData;

import java.io.File;


/**
 * Project Name 	: Carbon 
 * Module Name 		: MOLAP Data Processor
 * Author 			: Suprith T 72079 
 * Created Date 	: 18-Aug-2015
 * FileName 		: UnCompressedTempSortFileReader.java
 * Description 		: Class for reading the uncompressed sort temp file
 * Class Version 	: 1.0
 */
public class UnCompressedTempSortFileReader extends AbstractTempSortFileReader
{

    /**
     * UnCompressedTempSortFileReader
     * 
     * @param measureCount
     * @param dimensionCount
     * @param tempFile
     * @param type
     */
    public UnCompressedTempSortFileReader(int dimensionCount, int complexDimensionCount, int measureCount,
    		File tempFile, int highCardinalityCount)
    {
        super(dimensionCount, complexDimensionCount, measureCount, tempFile,highCardinalityCount);
    }

    /**
     * below method will be used to get chunk of rows
     * 
     * @return row
     */
    @Override
    public Object[][] getRow()
    {
        int recordLength = fileHolder.readInt(filePath);
        int byteArrayLength = fileHolder.readInt(filePath);
        byte[] byteArrayFromFile = fileHolder.readByteArray(filePath, byteArrayLength);
        return prepareRecordFromByteBuffer(recordLength, byteArrayFromFile);

    }

}
