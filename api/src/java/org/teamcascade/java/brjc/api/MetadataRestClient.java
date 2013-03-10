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

import com.atlassian.util.concurrent.Promise;
import org.teamcascade.java.brjc.api.domain.ServerInfo;

import java.lang.reflect.Field;

/**
 * Serves information about Bamboo metadata like server information
 * This data constitutes a data dictionary which then Bamboo builds base on.
 *
 * @since v0.1
 */
public interface MetadataRestClient {

	/**
	 * Retrieves information about this JIRA instance
	 *
	 * @return information about this JIRA instance
	 * @throws RestClientException in case of problems (connectivity, malformed messages, etc.)
	 */

	Promise<ServerInfo> getServerInfo();

	/**
	 * Retrieves information about JIRA custom and system fields.
	 *
	 * @return information about JIRA custom and system fields.
	 * @throws RestClientException in case of problems (connectivity, malformed messages, etc.)
	 */
	Promise<Iterable<Field>> getFields();
}
