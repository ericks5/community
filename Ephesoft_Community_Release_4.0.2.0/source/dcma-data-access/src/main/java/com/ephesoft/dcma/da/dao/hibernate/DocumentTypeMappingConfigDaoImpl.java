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

package com.ephesoft.dcma.da.dao.hibernate;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ephesoft.dcma.core.dao.hibernate.HibernateDao;
import com.ephesoft.dcma.da.dao.DocumentTypeMappingConfigDao;
import com.ephesoft.dcma.da.domain.DocumentTypeMappingConfig;
import com.ephesoft.dcma.util.EphesoftStringUtil;

@Repository
public class DocumentTypeMappingConfigDaoImpl extends HibernateDao<DocumentTypeMappingConfig> implements DocumentTypeMappingConfigDao {

	private static final String FUZZY_CONNECTION_ID = "fuzzyConnections.id";
	private static final String DB_EXPORT_CONNECTION_ID = "databaseExportConnections.id";
	private static final Logger LOG = LoggerFactory.getLogger(DocumentTypeMappingConfigDaoImpl.class);

	@Override
	public List<DocumentTypeMappingConfig> getDocumentTypeMappingConfigByConnectionId(long connectionID) {
		LOG.info(EphesoftStringUtil.concatenate("connection id is :", connectionID));
		DetachedCriteria criteria = criteria();
		criteria.add(Restrictions.or(Restrictions.eq(FUZZY_CONNECTION_ID, connectionID),
				Restrictions.eq(DB_EXPORT_CONNECTION_ID, connectionID)));
		return this.find(criteria);
	}

}
