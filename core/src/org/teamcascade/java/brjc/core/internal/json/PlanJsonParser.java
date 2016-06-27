package org.teamcascade.java.brjc.core.internal.json;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.teamcascade.java.brjc.api.domain.Plan;

import java.net.URI;

public class PlanJsonParser implements JsonObjectParser<Plan>{

    @Override
    public Plan parse(JSONObject json) throws JSONException {
        final URI self = JsonParseUtil.getSelfUri(json);
        final String name = json.getString("name");
        final String key = json.getString("key");
        final String shortName = json.getString("shortName");
        final String shortKey = json.getString("shortKey");
        final String type = json.getString("type");
        final boolean enabled = json.getBoolean("enabled");;
        return new Plan(self,key , name, shortName, shortKey, type, enabled);
    }

}
