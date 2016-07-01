package org.teamcascade.java.brjc.core.internal.async;

import com.atlassian.httpclient.api.HttpClient;
import org.junit.Test;
import org.teamcascade.java.bamboo.rest.client.api.domain.Range;

import javax.ws.rs.core.UriBuilder;
import java.net.URI;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;

public class AsynchronousResultRestClientTest {

    @Test
    public void testGetUri() throws Exception {
        HttpClient httpClient = null;
        final AsynchronousResultRestClient client = new AsynchronousResultRestClient(UriBuilder.fromUri("/baseUri").build(), httpClient);

        URI result = client.getUri("PLANKEY", null, null);
        assertThat(result.getRawQuery(), containsString("expand=results.result"));
        assertThat(result.getRawQuery(), containsString("max-results=25"));

        result = client.getUri("PLANKEY", "myLabel", null);
        assertThat(result.getRawQuery(), containsString("expand=results.result"));
        assertThat(result.getRawQuery(), containsString("max-results=25"));
        assertThat(result.getRawQuery(), containsString("label=myLabel"));

        result = client.getUri("PLANKEY", null, new Range(0, 25));
        assertThat(result.getRawQuery(), containsString("expand=results%5B0:24%5D.result"));
        assertThat(result.getRawQuery(), containsString("max-results=25"));

        result = client.getUri("PLANKEY", null, new Range(25, 25));
        assertThat(result.getRawQuery(), containsString("expand=results%5B25:49%5D.result"));
        assertThat(result.getRawQuery(), containsString("max-results=50"));

        result = client.getUri("PLANKEY", "myLabel", new Range(25, 25));
        assertThat(result.getRawQuery(), containsString("expand=results%5B25:49%5D.result"));
        assertThat(result.getRawQuery(), containsString("max-results=50"));
        assertThat(result.getRawQuery(), containsString("label=myLabel"));
    }

}