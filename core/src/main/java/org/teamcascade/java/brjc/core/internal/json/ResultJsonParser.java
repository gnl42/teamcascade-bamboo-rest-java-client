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
import org.teamcascade.java.bamboo.rest.client.api.domain.Result;

public class ResultJsonParser implements JsonObjectParser<Result> {

    @Override
    public Result parse(JSONObject json) throws JSONException {
        return new Result(json.getString("key"), json.getString("state"), json.getString("buildStartedTime"));
    }
}
