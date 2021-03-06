/*
 *
 *  * Copyright 2014 Orient Technologies.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *      http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package com.orientechnologies.lucene.tx;

import com.orientechnologies.orient.core.db.record.OIdentifiable;
import org.apache.lucene.document.Document;
import org.apache.lucene.search.Filter;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;

import java.io.IOException;
import java.util.Set;

/**
 * Created by Enrico Risa on 15/09/15.
 */
public interface OLuceneTxChanges {

  public void put(Object key, OIdentifiable value, Document doc) throws IOException;

  public void remove(Object key, OIdentifiable value) throws IOException;

  public IndexSearcher searcher() throws IOException;

  public long numDocs();

  public Set<Document> getDeletedDocs();

  public boolean isDeleted(Document document, Object key, OIdentifiable value);

  public boolean isUpdated(Document document, Object key, OIdentifiable value);


  public long deletedDocs(Query query, Filter filter);
}
