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

package com.huawei.datasight.molap.autoagg.model;

import junit.framework.Assert;

import org.junit.Test;

public class RequestTest
{
	@Test
	public void testGetRequest(){
		Assert.assertEquals(Request.DATA_STATS, Request.getRequest("DATA_STATS"));
		Assert.assertEquals(Request.QUERY_STATS, Request.getRequest("QUERY_STATS"));
		Assert.assertEquals("DATA_STATS", Request.DATA_STATS.getAggSuggestionType());
	}

}
