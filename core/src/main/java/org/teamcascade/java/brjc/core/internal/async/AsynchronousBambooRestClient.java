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
package org.teamcascade.java.brjc.core.internal.async;

import org.teamcascade.java.bamboo.rest.client.api.*;
import org.teamcascade.java.bamboo.rest.client.api.MetadataRestClient;


import javax.ws.rs.core.UriBuilder;
import java.net.URI;

/**
 * Asynchronous implementation of JIRA REST com.atlassian.jira.rest.client.
 *
 * @since v2.0
 */
public class AsynchronousBambooRestClient implements BambooRestClient {


	private final ProjectRestClient projectRestClient;
    private final MetadataRestClient metadataRestClient;
	private final DisposableHttpClient httpClient;
	private final ResultRestClient resultRestClient;

	public AsynchronousBambooRestClient(final URI serverUri, final DisposableHttpClient httpClient) {
		final URI baseUri = UriBuilder.fromUri(serverUri).path("/rest/api/latest").build();

		this.httpClient = httpClient;
		projectRestClient = new AsynchronousProjectRestClient(baseUri, httpClient);
        metadataRestClient = new AsynchronousMetadataRestClient(baseUri,httpClient);
		resultRestClient = new AsynchronousResultRestClient(baseUri, httpClient);
	}

    @Override
    public MetadataRestClient getMetadataClient() {
        return metadataRestClient;
    }


	@Override
	public ProjectRestClient getProjectClient() {
		return projectRestClient;
	}

	@Override
	public ResultRestClient getResultClient() {
		return resultRestClient;
	}

	@Override
	public void destroy() throws Exception {
		httpClient.destroy();
	}
}

