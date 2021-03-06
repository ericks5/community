/********************************************************************************* 
* Ephesoft is a Intelligent Document Capture and Mailroom Automation program 
* developed by Ephesoft, Inc. Copyright (C) 2015 Ephesoft Inc. 
* 
* This program is free software; you can redistribute it and/or modify it under 
* the terms of the GNU Affero General Public License version 3 as published by the 
* Free Software Foundation with the addition of the following permission added 
* to Section 15 as permitted in Section 7(a): FOR ANY PART OF THE COVERED WORK 
* IN WHICH THE COPYRIGHT IS OWNED BY EPHESOFT, EPHESOFT DISCLAIMS THE WARRANTY 
* OF NON INFRINGEMENT OF THIRD PARTY RIGHTS. 
* 
* This program is distributed in the hope that it will be useful, but WITHOUT 
* ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS 
* FOR A PARTICULAR PURPOSE.  See the GNU Affero General Public License for more 
* details. 
* 
* You should have received a copy of the GNU Affero General Public License along with 
* this program; if not, see http://www.gnu.org/licenses or write to the Free 
* Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 
* 02110-1301 USA. 
* 
* You can contact Ephesoft, Inc. headquarters at 111 Academy Way, 
* Irvine, CA 92617, USA. or at email address info@ephesoft.com. 
* 
* The interactive user interfaces in modified source and object code versions 
* of this program must display Appropriate Legal Notices, as required under 
* Section 5 of the GNU Affero General Public License version 3. 
* 
* In accordance with Section 7(b) of the GNU Affero General Public License version 3, 
* these Appropriate Legal Notices must retain the display of the "Ephesoft" logo. 
* If the display of the logo is not reasonably feasible for 
* technical reasons, the Appropriate Legal Notices must display the words 
* "Powered by Ephesoft". 
********************************************************************************/ 

package com.ephesoft.dcma.util;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/** Provides access to class-related utility operations */
public final class ClassUtil {

	private ClassUtil() {
		// private constructor for utility class
	}

	/**
	 * @param <T> the type
	 * @param target the target
	 * @return the parameterized type of {@code target}'s class
	 */
	public static <T> Class<T> getEntityClass(Object target) {
		Class<?> targetClass = target.getClass();
		return getParameterizedClass(targetClass);
	}

	/**
	 * @param <T> the type of the class
	 * @param targetClass the requested target class
	 * @return the generic type of {@code targetClass}
	 * @throws IllegalArgumentException if the underlying parameterized class could not be inferred via reflection.
	 */
	@SuppressWarnings("unchecked")
	public static <T> Class<T> getParameterizedClass(Class<?> targetClass) throws IllegalArgumentException {
		Type type = targetClass.getGenericSuperclass();
		if (type instanceof ParameterizedType) {
			ParameterizedType paramType = (ParameterizedType) type;
			return (Class<T>) paramType.getActualTypeArguments()[0];
		}
		Class<?> superClass = targetClass.getSuperclass();
		if (superClass != targetClass) {
			// check that we do not run into recursion
			return getParameterizedClass(superClass);
		}
		throw new IllegalArgumentException("Could not guess entity class by reflection");
	}

	/**
	 * Gets a field value from an <code>Object</code> not caring about its scope. Note that only fields from the <code>Class</code>
	 * directly are accessible with this method, not from any super <code>Class</code>.
	 * 
	 * @param object
	 * @param field
	 * @return the field value
	 * @throws NoSuchFieldException
	 * @throws IllegalAccessException
	 */
	public static Object getField(Object object, String field) throws NoSuchFieldException, IllegalAccessException {
		Field decField = object.getClass().getDeclaredField(field);
		decField.setAccessible(true);
		return decField.get(object);
	}

}
