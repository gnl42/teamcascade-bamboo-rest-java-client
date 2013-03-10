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

package org.teamcascade.java.brjc.api;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.Iterator;

/**
 * Represent iterable which is optional (for example due to lack of field in old REST API version).<br/>
 * This iterable is intended to be not null, so you can always get items by using iterator. If you need
 * to check if value was actually provided then use {@link OptionalIterable#isSupported}.
 *
 * @since v1.0
 */
public class OptionalIterable<T> implements Iterable<T> {

	@SuppressWarnings("unchecked")
	private static final OptionalIterable absentInstance = new OptionalIterable(null);

	@Nullable
	private final Iterable<T> iterable;

	@SuppressWarnings("unchecked")
	public static <T> OptionalIterable<T> absent() {
		return absentInstance;
	}

	public OptionalIterable(@Nullable Iterable<T> iterable) {
		this.iterable = iterable;
	}

	/**
	 * @return iterator for original iterable if {@link OptionalIterable#isSupported} is true,
	 *         or empty iterator in other case.
	 */
	@Override
	public Iterator<T> iterator() {
		return isSupported()
				? iterable.iterator()
				: Collections.<T>emptyList().iterator();
	}

	/**
	 * @return true if server supports this field
	 */
	public boolean isSupported() {
		return iterable != null;
	}
}
