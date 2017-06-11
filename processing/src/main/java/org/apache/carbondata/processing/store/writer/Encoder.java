/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.carbondata.processing.store.writer;

import org.apache.carbondata.core.datastore.columnar.IndexStorage;
import org.apache.carbondata.processing.store.TablePage;

public interface Encoder {

  EncodedData encode(TablePage tablePage);

  // result result of all columns
  class EncodedData {
    // dimension data that include rowid (index)
    public IndexStorage[] indexStorages;

    // encoded and compressed dimension data
    public byte[][] dimensions;

    // encoded and compressed measure data
    public byte[][] measures;
  }
}