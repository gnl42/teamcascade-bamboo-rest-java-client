/*
* Copyright (C) 2013 Pascal Charbonneau
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

package org.teamcascade.java.brjc.core.internal.json;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.teamcascade.java.brjc.api.domain.BasicPlan;

import java.net.URI;

public class BasicPlanJsonParser implements JsonObjectParser<BasicPlan> {

    @Override
    public BasicPlan parse(JSONObject json) throws JSONException {
        final URI selfUri = JsonParseUtil.getSelfUri(json);
        final String key = json.getString("key");
        final String name = JsonParseUtil.getOptionalString(json, "name");
        return new BasicPlan(selfUri, key, name);
    }


}
