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

package com.ephesoft.dcma.webservice.customexceptions;

import org.springframework.http.HttpStatus;

import com.ephesoft.dcma.webservice.constants.WebServiceConstants;
import com.ephesoft.dcma.webservice.exceptionhandler.RestError;

/**
 * The Class NoUserRoleException.
 * The class to represent the 'no user roles for authenticated user' error while a call to a webservice is made.
 *
 * @author Ephesoft
 * <b>
 * created on</b>  Jun 5, 2013 <br/>
 * @version 3.0 <br/>
 * $LastChangedDate: 2013-06-28 12:44:43 +0530 (Fri, 28 Jun 2013) $ <br/>
 * $LastChangedRevision: 6220 $ <br/>
 */
public class NoUserRoleException extends WebServicesException {

	/**
	 * default serial version id.
	 */
	private static final long serialVersionUID = 1L;

	public NoUserRoleException() {
		super(WebServiceConstants.NO_USER_ROLE_EXCEPTION_MESSAGE,
				new RestError(HttpStatus.FORBIDDEN, WebServiceConstants.NO_USER_ROLE_EXCEPTION_CODE,						
						WebServiceConstants.NO_USER_ROLE_EXCEPTION_MESSAGE,
						WebServiceConstants.NO_USER_ROLE_EXCEPTION_MESSAGE,
						WebServiceConstants.DEFAULT_URL));
	}
}