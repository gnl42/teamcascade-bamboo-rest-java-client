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
import com.atlassian.util.concurrent.Promise;
import org.teamcascade.java.bamboo.rest.client.api.ResultRestClient;
import org.teamcascade.java.bamboo.rest.client.api.domain.Range;
import org.teamcascade.java.bamboo.rest.client.api.domain.Results;
import org.teamcascade.java.brjc.core.internal.json.ResultsJsonParser;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;

/**
 * Asynchronous implementation of ResultRestClient.
 *
 * @since v2.0
 */
public class AsynchronousResultRestClient extends AbstractAsynchronousRestClient implements ResultRestClient {

    private static final String RESULT_URI_PREFIX = "result";
    private final ResultsJsonParser resultsJsonParser = new ResultsJsonParser();

    private final URI baseUri;

    public AsynchronousResultRestClient(final URI baseUri, final HttpClient client) {
        super(client);
        this.baseUri = baseUri;
    }

    @Override
    public Promise<Results> getResults(@Nonnull final String key) {
        return getResults(key, null, null);
    }

    @Override
    public Promise<Results> getResults(@Nonnull String key, @Nullable String filterByLabel) {
        return getResults(key, filterByLabel, null);
    }

    @Override
    public Promise<Results> getResults(@Nonnull String key, @Nullable String filterByLabel, @Nullable Range range) {
        final URI uri = getUri(key, filterByLabel, range);
        return getAndParse(uri, resultsJsonParser);
    }

    URI getUri(@Nonnull String key, @Nullable String filterByLabel, @Nullable Range range) {
        int maxResults = 25;
        String resultsRange = "";
        if (range != null) {
            maxResults = range.getEnd() + 1;
            resultsRange = String.format("[%d:%d]", range.getStart(), range.getEnd());
        }
        UriBuilder builder = UriBuilder
                .fromUri(baseUri)
                .path(RESULT_URI_PREFIX)
                .path(key)
                .queryParam("max-results", "{a}")
                .queryParam("expand", "results{b}.result");
        if (filterByLabel != null) {
            builder = builder.queryParam("label", filterByLabel);
        }
        return builder.build(maxResults, resultsRange);
    }
}
