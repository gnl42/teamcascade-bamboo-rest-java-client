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
package org.teamcascade.java.brjc.api.domain;


import com.google.common.base.Objects;
import org.teamcascade.java.brjc.api.AddressableEntity;
import org.teamcascade.java.brjc.api.NamedEntity;

import javax.annotation.Nullable;
import java.net.URI;

/**
 * Basic information about a Bamboo Plan
 *
 * @since v0.1
 */
public class BasicPlan implements AddressableEntity, NamedEntity {
    private final URI self;
    private final String key;
    @Nullable
    private final String name;

    public BasicPlan(URI self, String key, String name) {
        this.self = self;
        this.key = key;
        this.name = name;
    }

    @Override
    public URI getSelf() {
        return self;
    }

    public String getKey() {
        return key;
    }

    @Nullable
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getToStringHelper().toString();
    }

    protected Objects.ToStringHelper getToStringHelper() {
        return Objects.toStringHelper(this).
                add("self", self).
                add("key", key).
                add("name", name);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof BasicPlan) {
            BasicPlan that = (BasicPlan) obj;
            return Objects.equal(this.self, that.self)
                    && Objects.equal(this.name, that.name)
                    && Objects.equal(this.key, that.key);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(self, name, key);
    }
}
