/**
 *  Copyright (c) 2015 Intel Corporation 
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.trustedanalytics.atk.domain.datacatalog

/**
 * Response class for the data catalog entries
 */
case class IndexedMetadataEntryWithID(id: String,
                                      size: Int,
                                      title: String,
                                      dataSample: String,
                                      recordCount: Int,
                                      isPublic: Boolean,
                                      targetUri: String,
                                      orgUUID: String,
                                      category: String,
                                      format: String,
                                      creationTime: String,
                                      sourceUri: String)
/*
 * Catalog Metadata class being returned by plugins. If any plugin returns an object of type CatalogMetadata,
 * python client will send a publish request to add the entry to data catalog
 */
case class CatalogMetadata(title: String,
                           size: Int,
                           dataSample: String,
                           recordCount: Long,
                           isPublic: Boolean,
                           targetUri: String,
                           category: String,
                           format: String,
                           sourceUri: String)


/*
 * Request class to add an entry to data catalog
 */
case class InputMetadataEntry(title: String,
                              category: String,
                              recordCount: Int,
                              sourceUri: String,
                              size: Int,
                              orgUUID: String,
                              targetUri: String,
                              format: String,
                              dataSample: String,
                              isPublic: Boolean)

/*
 Converts a catalog metadata object (which is handled by ATK) to an input metadata entry for the data catalog service
 */
object ConvertCatalogMetadataToInputMetadataEntry {
  def convert(c: CatalogMetadata, orgUUID: String) = {
    InputMetadataEntry(c.title, c.category, c.recordCount.toInt, c.sourceUri, c.size, orgUUID,
      c.targetUri, c.format, c.dataSample, c.isPublic)
  }

}