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

/*--------------------------------------------------------------------------------------------------------------------------*/
/*!!Warning: This is a key information asset of Huawei Tech Co.,Ltd                                                         */
/*CODEMARK:kOyQZYzjDpyGdBAEC2GaWmnksNUG9RKxzMKuuAYTdbJ5ajFrCnCGALet/FDi0nQqbEkSZoTs
2wdXgejaKCr1dP3uE3wfvLHF9gW8+IdXbweRARwUrjYxPx0CUk3mVB7mxOcZSaagKrMQNlhB
QO/t7Ip8YjNrUAKR5h97TPnr/ORpDb+29S2s1BBT4MLUf+e1FoNoiQpvWPuMv8W2ACLOFrWQ
b8RBW+jbyBmaN6ECK4saqWAD5GA3+jWHGKPF8j7L4MGUH9gvqTOAcOtfsTanoQ==*/
/*--------------------------------------------------------------------------------------------------------------------------*/
/**
 * 
 */
package com.huawei.unibi.molap.engine.executer.impl;

import java.util.ArrayList;
import java.util.List;

import com.huawei.unibi.molap.constants.MolapCommonConstants;

/**
 * This class is used to count the rows while executing the query
 * 
 * @author R00900208
 *
 */
public class QueryRowCounter
{
    /**
     * Counter for rows
     */
    private int counter;
    
    /**
     * Row limit to fire listner
     */
    private int rowLimit;
    
    /**
     * Row count listners
     */
    private List<RowCounterListner> listners = new ArrayList<RowCounterListner>(MolapCommonConstants.CONSTANT_SIZE_TEN);
    
    
    public QueryRowCounter(int rowLimit)
    {
       this.rowLimit = rowLimit;
    }
    
    /**
     * Increment the row count by passed value 
     * @param count
     * @throws Exception 
     */
    public synchronized void incrementRowCount(int count) throws Exception
    {
        counter += count;
        if(counter > rowLimit)
        {
            fireRowCountListner();   
        }
    }
    
    /**
     * Increment the row count by passed value 
     * @param count
     * @throws Exception 
     */
    public void setRowCount(int count) throws Exception
    {
        counter = count;
        if(counter > rowLimit)
        {
            fireRowCountListner();   
        }
    }
    
    /**
     * Register the listner
     * @param listner
     */
    public void registerRowCountListner(RowCounterListner listner)
    {
        listners.add(listner);
    }
    
    /**
     * Fire the event.
     * @throws Exception 
     */
    private void fireRowCountListner() throws Exception
    {
        for(RowCounterListner listner : listners)
        {
            listner.rowLimitExceeded();
        }
    }

    /**
     * @param rowLimit the rowLimit to set
     */
    public void setRowLimit(int rowLimit)
    {
        this.rowLimit = rowLimit;
    }

    /**
     * @return the rowLimit
     */
    public int getRowLimit()
    {
        return rowLimit;
    }
    
}
