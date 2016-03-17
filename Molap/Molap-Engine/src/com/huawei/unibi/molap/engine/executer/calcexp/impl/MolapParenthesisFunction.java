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
QO/t7ObejZKgoI9dO8d3XGQw4Uys4/dW8UAUleKU/moA+0pN4Y5v3qIwqexEk2kcN+eIUc6X
C47RRq60pl/t9wNkZeC1ajQrm9Me79eSRpMRChq+L+5yQTgF2BUuM2bDrZtK7g==*/
/*--------------------------------------------------------------------------------------------------------------------------*/
/**
 * 
 */
package com.huawei.unibi.molap.engine.executer.calcexp.impl;

//import mondrian.mdx.ResolvedFunCall;
//import mondrian.olap.Exp;

import com.huawei.unibi.molap.olap.Exp;
import com.huawei.unibi.molap.engine.aggregator.MeasureAggregator;

/**
 * It is scope or parenthesis function
 * @author R00900208
 *
 */
public class MolapParenthesisFunction extends AbstractMolapCalcFunction
{

    /**
     * 
     */
    private static final long serialVersionUID = 1059864932134112437L;

    @Override
    public double calculate(MeasureAggregator[] msrAggs)
    {
        return leftOperand.calculate(msrAggs);
    }
    
    @Override
    public void compile(CalcExpressionModel model, Exp exp)
    {
//        ResolvedFunCall funCall = (ResolvedFunCall)exp;
//        Exp[] args = funCall.getArgs();
//        leftOperand = getOperand(args[0],model);
    }

}
