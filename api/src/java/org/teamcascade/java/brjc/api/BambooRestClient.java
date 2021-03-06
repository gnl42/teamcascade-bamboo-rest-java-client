/*
* Copyright (C) 2013 Pascal Charbonneau
* Original Copyright (C) 2012 Atlassian
*
* Original code adapted by Pascal Charbonneau for the BRJC library
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/


package org.teamcascade.java.brjc.api;



/**
 * Main access point to Bamboo REST API .
 * As there are many types resources exposed by Bamboo REST API, various resources are grouped into clusters
 * and then handled by different specialized *RestClient classes.
 *
 * @since v0.1
 */

public interface BambooRestClient {

    /**
     * @return the API handling project metadata
     */
    ProjectRestClient getProjectClient();


    /**
     * @return the API handling basic meta-data (data dictionaries defined in Bamboo - like artifacts,vserions,etc)
     */
    MetadataRestClient getMetadataClient();

    /**
     * Destroys this instance of Bamboo Rest Client.
     *
     * @throws Exception
     */
    void destroy() throws Exception;

}
