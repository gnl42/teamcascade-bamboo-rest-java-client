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

import org.teamcascade.java.brjc.api.domain.*;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.net.URI;
import java.util.Collection;

public class ProjectJsonParser implements JsonObjectParser<Project> {

	private final PlanJsonParser planJsonParser = new PlanJsonParser();

	@Override
	public Project parse(JSONObject json) throws JSONException {
		URI self = JsonParseUtil.getSelfUri(json);
		final String key = json.getString("key");
		final String name = JsonParseUtil.getOptionalString(json, "name");

		final Collection<Plan> plans = JsonParseUtil.parseJsonArray(json.getJSONArray("plans"), planJsonParser);

		return new Project(self, key, name, plans);
 	}


}
