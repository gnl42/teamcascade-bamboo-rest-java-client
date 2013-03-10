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

import com.atlassian.httpclient.api.HttpClient;

import java.net.URI;

/**
 * Factory for producing BambooRestClient instance with selected authentication handler
 *
 * @since v0.1
 */
public interface BambooRestClientFactory {

	/**
	 * Creates an instance of BambooRestClient with default HttpClient settings.
	 *
	 * @param serverUri             - URI of Bamboo instance.
	 * @param authenticationHandler - requests authenticator.
	 */
	BambooRestClient create(final URI serverUri, final AuthenticationHandler authenticationHandler);

	/**
	 * Creates an instance of BambooRestClient with default HttpClient settings. HttpClient will conduct a
	 * basic authentication for given credentials.
	 *
	 * @param serverUri - URI or Bamboo instance.
	 * @param username  - username of the user used to log in to Bamboo.
	 * @param password  - password of the user used to log in to Bamboo.
	 */
	BambooRestClient createWithBasicHttpAuthentication(final URI serverUri, final String username, final String password);

	/**
	 * Creates an instance of BambooRestClient with given Atlassian HttpClient.
	 *
	 * @param serverUri  - URI of Bamboo instance.
	 * @param httpClient - instance of Atlassian HttpClient.
	 */
	BambooRestClient create(final URI serverUri, final HttpClient httpClient);
}
