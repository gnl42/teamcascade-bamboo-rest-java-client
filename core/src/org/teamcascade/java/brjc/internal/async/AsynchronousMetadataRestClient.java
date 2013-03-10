/*
 * Copyright (C) 2012 Atlassian
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

import com.atlassian.httpclient.api.HttpClient;
import org.teamcascade.java.brjc.api.MetadataRestClient;
import org.teamcascade.java.brjc.api.domain.*;

import org.teamcascade.java.brjc.core.internal.json.*;
import com.atlassian.util.concurrent.Promise;

import javax.ws.rs.core.UriBuilder;
import java.net.URI;

/**
 * Asynchronous implementation of MetadataRestClient.
 *
 * @since v0.1
 */
public class AsynchronousMetadataRestClient extends AbstractAsynchronousRestClient implements MetadataRestClient {

	private static final String SERVER_INFO_RESOURCE = "/serverInfo";
	private final ServerInfoJsonParser serverInfoJsonParser = new ServerInfoJsonParser();
	private final URI baseUri;

	public AsynchronousMetadataRestClient(final URI baseUri, HttpClient httpClient) {
		super(httpClient);
		this.baseUri = baseUri;

	}

    @Override
    public Promise<ServerInfo> getServerInfo() {
        final URI serverInfoUri = UriBuilder.fromUri(baseUri).path(SERVER_INFO_RESOURCE).build();
        return getAndParse(serverInfoUri, serverInfoJsonParser);
    }

}
