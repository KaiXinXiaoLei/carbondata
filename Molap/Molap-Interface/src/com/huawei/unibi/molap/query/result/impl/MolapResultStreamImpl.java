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
 *
 * Copyright Notice
 * =====================================
 * This file contains proprietary information of
 * Huawei Technologies India Pvt Ltd.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2013
 * =====================================
 *
 */
package com.huawei.unibi.molap.query.result.impl;

import java.util.ArrayList;
import java.util.List;

import com.huawei.unibi.molap.query.metadata.MolapTuple;
import com.huawei.unibi.molap.query.result.MolapResultChunk;
import com.huawei.unibi.molap.query.result.MolapResultStream;

/**
 * Implementation class for MolapResultStream
 * 
 * @author R00900208
 *
 */
public class MolapResultStreamImpl implements MolapResultStream 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 908119139427979333L;
	
	/**
	 * molapTuples
	 */
	private List<MolapTuple> molapTuples = new ArrayList<MolapTuple>(10);
	
	/**
	 * Chunk
	 */
	private MolapResultChunk chunk;
	
	/**
	 * data exists
	 */
	private boolean[] next = new boolean[]{true,false};
	
	/**
	 * iterator
	 */
	private int i;

	/**
	 * See interface comments
	 */
	@Override
	public List<MolapTuple> getColumnTuples() 
	{
		
		return molapTuples;
	}

	/**
	 * See interface comments
	 */
	@Override
	public boolean hasNext() 
	{
		return next[i++];
	}

	/**
	 * See interface comments
	 */
	@Override
	public MolapResultChunk getResult() 
	{
		
		return chunk;
	}

	/**
	 * Set column tuples to the result
	 * @param colTuples
	 */
	public void setTuples(List<MolapTuple> colTuples)
	{
		molapTuples = colTuples;
	}
	
	/**
	 * Set the chunk to the result
	 * @param chunk
	 */
	public void setMolapResultChunk(MolapResultChunk chunk)
	{
		this.chunk = chunk;
	}
	
	/**
	 * Whether more data left in the server.
	 * @param dataLeft
	 */
	public void setHasDataLeft(boolean dataLeft)
	{
		next[1] = dataLeft;
	}
	
}
