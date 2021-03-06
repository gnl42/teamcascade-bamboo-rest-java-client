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
 * Basic information about a Bamboo user
 *
 * @since v0.1
 */
public class BasicUser extends AddressableNamedEntity {

	/**
	 * This value is used to mark incomplete user URI - when server response with user without selfUri set.
	 */
	public static URI INCOMPLETE_URI = URI.create("incomplete://user");

	private final String displayName;

	public BasicUser(URI self, String name, String displayName) {
		super(self, name);
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}

	@Override
	public String toString() {
		return super.getToStringHelper()
				.add("displayName", displayName)
				.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof BasicUser) {
			BasicUser that = (BasicUser) obj;
			return super.equals(that) && Objects.equal(this.displayName, that.displayName);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(super.hashCode(), displayName);
	}

	/**
	 * @return true when URI returned from server was incomplete. See {@link BasicUser#INCOMPLETE_URI} for more detail.
	 */
	public boolean isSelfUriIncomplete() {
		return INCOMPLETE_URI.equals(self);
	}

}
