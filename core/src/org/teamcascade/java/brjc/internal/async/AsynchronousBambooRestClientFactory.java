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

import com.atlassian.httpclient.api.HttpClient;
import org.teamcascade.java.brjc.core.auth.BasicHttpAuthenticationHandler;
import org.teamcascade.java.brjc.api.AuthenticationHandler;
import org.teamcascade.java.brjc.api.BambooRestClient;
import org.teamcascade.java.brjc.api.BambooRestClientFactory;

import java.net.URI;

/**
 * Serves asynchronous implementations of the JiraRestClient.
 *
 * @since v2.0
 */
public class AsynchronousBambooRestClientFactory implements BambooRestClientFactory {

	@Override
	public BambooRestClient create(final URI serverUri, final AuthenticationHandler authenticationHandler) {
		final DisposableHttpClient httpClient = new AsynchronousHttpClientFactory()
				.createClient(serverUri, authenticationHandler);
		return new AsynchronousBambooRestClient(serverUri, httpClient);
	}

	@Override
	public BambooRestClient createWithBasicHttpAuthentication(final URI serverUri, final String username, final String password) {
		return create(serverUri, new BasicHttpAuthenticationHandler(username, password));
	}

	@Override
	public BambooRestClient create(final URI serverUri, final HttpClient httpClient) {
		final DisposableHttpClient disposableHttpClient = new AsynchronousHttpClientFactory().createClient(httpClient);
		return new AsynchronousBambooRestClient(serverUri, disposableHttpClient);
	}
}
