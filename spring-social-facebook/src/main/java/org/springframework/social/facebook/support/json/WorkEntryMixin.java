/*
 * Copyright 2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.facebook.support.json;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.social.facebook.types.Reference;

/**
 * Annotated mixin to add Jackson annotations to WorkEntry. 
 * @author Craig Walls
 */
abstract class WorkEntryMixin {
	
	@JsonCreator
	WorkEntryMixin(
			@JsonProperty("employer") Reference employer, 
			@JsonProperty("start_date") String startDate, 
			@JsonProperty("end_date") String endDate) {}
	
}
