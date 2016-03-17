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

package com.huawei.datasight.molap.datastats.load; 

import org.junit.Test;

import mockit.Mock;
import mockit.MockUp;

import com.huawei.datasight.molap.datastats.load.FactDataHandler;
import com.huawei.datasight.molap.datastats.load.LevelMetaInfo;
import com.huawei.unibi.molap.constants.MolapCommonConstants;
import com.huawei.unibi.molap.util.MolapProperties;
import com.huawei.unibi.molap.metadata.MolapMetadata.Cube;

public class FactDataHandlerTest
{

	@Test
	public void testInitialise_falseAggKeyBlock()
	{
		MolapProperties.getInstance().addProperty( MolapCommonConstants.AGGREAGATE_COLUMNAR_KEY_BLOCK, "false");
		MolapProperties.getInstance().addProperty(MolapCommonConstants.MOLAP_IS_LOAD_FACT_TABLE_IN_MEMORY, "false");
		LevelMetaInfo levelInfo=new MockUp<LevelMetaInfo>()
		{
			@Mock
			public int[] getDimCardinality()
			{
				return new int[]{10,12};
			}
			
		}.getMockInstance();
		
		Cube cube=new MockUp<Cube>()
		{
			@Mock
			public String getCubeName()
			{
				return "default_test";
			}
			@Mock
			public String getSchemaName()
			{
				return "default";
			}
			@Mock
			public String getMode()
			{
				return "store";
				
			}
			@Mock
			public String getFactTableName()
			{
				return "factTable";
			}
			
		}.getMockInstance();
		
		FactDataHandler factHandler=new FactDataHandler(cube,levelInfo, "factTable", 0, null);
	}
	@Test
	public void testInitialise_trueAggKeyBlock_TestHighCardinality()
	{
		MolapProperties.getInstance().addProperty( MolapCommonConstants.AGGREAGATE_COLUMNAR_KEY_BLOCK, "true");
		LevelMetaInfo levelInfo=new MockUp<LevelMetaInfo>()
				{
					@Mock
					public int[] getDimCardinality()
					{
						return new int[]{1000010,12};
					}
					
				}.getMockInstance();
				
				Cube cube=new MockUp<Cube>()
				{
					@Mock
					public String getCubeName()
					{
						return "default_test";
					}
					@Mock
					public String getSchemaName()
					{
						return "default";
					}
					@Mock
					public String getMode()
					{
						return "store";
						
					}
					@Mock
					public String getFactTableName()
					{
						return "factTable";
					}
					
				}.getMockInstance();
				
				FactDataHandler factHandler=new FactDataHandler(cube,levelInfo, "factTable", 0, null);
	}
}
