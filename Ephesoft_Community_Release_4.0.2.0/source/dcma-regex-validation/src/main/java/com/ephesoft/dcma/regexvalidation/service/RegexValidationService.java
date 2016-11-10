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

package com.ephesoft.dcma.regexvalidation.service;

import com.ephesoft.dcma.core.DCMAException;
import com.ephesoft.dcma.da.id.BatchInstanceID;

/**
 * This service is used to validate the document level fields of document for whole batch. It will validate the DLF's on the basis of
 * regex patterns available in database. If the document level field is valid with data type and regex pattern then only document is
 * called as valid document otherwise it is taken as invalid document.
 * 
 * 
 * @author Ephesoft
 * @version 1.0
 * @see com.ephesoft.dcma.regexvalidation.service.RegexValidationServiceImpl
 */
public interface RegexValidationService {

	/**
	 * The <code>regexValidation</code> method is used to validate the document level fields of document for whole batch. It will fetch
	 * all the record corresponding to document level fields from the database and on the basis of that pattern it will validate the
	 * document level field. If all the patterns satisfied with the document level field value then only that document will marked as
	 * valid otherwise it will marked as invalid document.
	 * 
	 * @param batchInstanceIdentifier {@link BatchInstanceID}
	 * @param pluginWorkflow {@link String}
	 * @throws DCMAException If any invalid state occur during the regex based validation process.
	 */
	void regexValidation(final BatchInstanceID batchInstanceID, final String pluginWorkflow) throws DCMAException;

}