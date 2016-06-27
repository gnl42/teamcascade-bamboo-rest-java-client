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


package org.teamcascade.java.brjc.core.auth;

import com.atlassian.httpclient.api.Request;
import org.teamcascade.java.bamboo.rest.client.api.AuthenticationHandler;

/**
 * Anonymous handler - no credentials passed to the server. Only anonymously accessible operations will be possible.
 *
 * @since v0.1
 */
public class AnonymousAuthenticationHandler implements AuthenticationHandler {

	@Override
	public void configure(Request request) {
	}

}
