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

package org.teamcascade.java.brjc.api.domain;

import com.google.common.base.Objects;

import java.net.URI;

/**
 * Complete information about single Bamboo Plan.
 * Many REST resources instead include just @{}BasicPlan
 *
 * @since v0.1
 */

public class Plan extends BasicPlan {
    private final String shortName;
    private final String shortKey;
    private final String type;
    private final boolean enabled;

    public Plan(URI self, String key, String name, String shortName,
                String shortKey, String type, Boolean enabled) {
        super(self, key, name);
        this.shortName = shortName;
        this.shortKey = shortKey;
        this.type = type;
        this.enabled = enabled;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Objects.ToStringHelper getToStringHelper() {
        return super.getToStringHelper().
                add("shortName", shortName).
                add("shortKey", shortKey).
                add("type", type).
                add("enabled", enabled);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Plan) {
            Plan that = (Plan) o;
            return super.equals(that)
                    && Objects.equal(this.shortKey, that.shortKey)
                    && Objects.equal(this.shortName, that.shortName)
                    && Objects.equal(this.type, that.type)
                    && Objects.equal(this.enabled, that.enabled);

        }
        return false;
    }

    @Override
    public int hashCode() {
        // Verify that this is the correct way to add to the hash code
        return Objects.hashCode(super.hashCode(),shortKey,shortName,type);
    }
}
