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
2wdXgejaKCr1dP3uE3wfvLHF9gW8+IdXbwddts1/q4bCGDA4M3dH8C2PEEMnfDqqdF4ZhcSc
1BeEnHMVjhSkm7CZw0KuxFS1gOmxfpAYpPIlt71P7K9nJjGAAfr/N7ahY58sSdxYRLcY4mg5
VTqT1FLKSIeU1nbxIhalYTgJkV4U5VujUL0Ge0VJrcBq5PtFStw7ZwX8MioHNw==*/
/*--------------------------------------------------------------------------------------------------------------------------*/
/**
 *
 * Copyright Notice
 * =====================================
 * This file contains proprietary information of
 * Huawei Technologies India Pvt Ltd.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2012
 * =====================================
 *
 */
package com.huawei.unibi.molap.graphgenerator;

import java.util.Locale;

/**
 * 
 * @author K00900841
 *
 */
public class GraphGeneratorException extends Exception
{

    /**
     * default serial version ID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The Error message.
     */
    private String msg = "";


    /**
     * Constructor
     * 
     * @param errorCode
     *            The error code for this exception.
     * @param msg
     *            The error message for this exception.
     * 
     */
    public GraphGeneratorException(String msg)
    {
        super(msg);
        this.msg = msg;
    }
    
    /**
     * Constructor
     * 
     * @param errorCode
     *            The error code for this exception.
     * @param msg
     *            The error message for this exception.
     * 
     */
    public GraphGeneratorException(String msg, Throwable t)
    {
        super(msg,t);
        this.msg = msg;
    }

    /**
     * This method is used to get the localized message.
     * 
     * @param locale
     *            - A Locale object represents a specific geographical,
     *            political, or cultural region.
     * @return - Localized error message.
     */
    public String getLocalizedMessage(Locale locale)
    {
        return "";
    }

    /**
     * getLocalizedMessage
     */
    @Override
    public String getLocalizedMessage()
    {
        return super.getLocalizedMessage();
    }

    /**
     * getMessage
     */
    public String getMessage()
    {
        return this.msg;
    }

}
