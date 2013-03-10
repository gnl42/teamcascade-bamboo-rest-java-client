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
import java.util.Collection;

/**
 * Complete information about single Bamboo project.
 * Many REST resources instead include just @{}BasicProject
 *
 * @since v0.1
 */
public class Project extends BasicProject {
	private final Collection<Plan> plans;

	public Project(URI self, String key, String name,Collection<Plan> plans) {
		super(self, key, name);
		this.plans = plans;
	}



	/**
	 * @return plans defined for this project
	 */
	public Iterable<Plan> getPlans() {
		return plans;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Objects.ToStringHelper getToStringHelper() {
		return super.getToStringHelper().
				add("plans", plans);
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Project) {
			Project that = (Project) o;
			return super.equals(that)
					&& Objects.equal(this.plans, that.plans);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(super.hashCode());
	}
}
