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

import com.google.common.collect.Lists;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.teamcascade.java.bamboo.rest.client.api.domain.Result;
import org.teamcascade.java.bamboo.rest.client.api.domain.Results;

import java.util.List;

public class ResultsJsonParser implements JsonObjectParser<Results> {

	private final ResultJsonParser resultJsonParser = new ResultJsonParser();

	@Override
	public Results parse(JSONObject json) throws JSONException {
		json = json.getJSONObject("results");
		final int size = json.getInt("size");
		final List<Result> results = Lists.newArrayList();
		if (size > 0) {
			final JSONArray resultArray = json.getJSONArray("result");
			for (int i = 0; i < resultArray.length(); i++) {
				results.add(resultJsonParser.parse(resultArray.getJSONObject(i)));
			}
		}
		return new Results(size, json.getInt("start-index"), json.getInt("max-result"), results);
 	}


}
