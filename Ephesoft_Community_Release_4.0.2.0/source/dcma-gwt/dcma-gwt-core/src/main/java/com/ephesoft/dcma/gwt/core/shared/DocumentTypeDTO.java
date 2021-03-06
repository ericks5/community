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

package com.ephesoft.dcma.gwt.core.shared;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import com.google.gwt.user.client.rpc.IsSerializable;

public class DocumentTypeDTO implements IsSerializable {

	private BatchClassDTO batchClass;

	private int priority;

	private float minConfidenceThreshold;

	private String name;

	private String description;

	/**
	 */
	private String firstPageProjectFileName;

	/**
	 */
	private String secondPageProjectFileName;

	/**
	 */
	private String thirdPageProjectFileName;

	/**
	 */
	private String fourthPageProjectFileName;

	private String identifier;

	private boolean isDeleted;

	private boolean isNew;

	private Map<String, PageTypeDTO> pagesMap = new LinkedHashMap<String, PageTypeDTO>();

	private Map<String, FieldTypeDTO> fieldsMap = new LinkedHashMap<String, FieldTypeDTO>();

	private Map<String, TableInfoDTO> tableInfoMap = new LinkedHashMap<String, TableInfoDTO>();

	private Map<String, FunctionKeyDTO> functionKeyMap = new LinkedHashMap<String, FunctionKeyDTO>();

	private boolean isHidden;

	public BatchClassDTO getBatchClass() {
		return batchClass;
	}

	public void setBatchClass(BatchClassDTO batchClass) {
		this.batchClass = batchClass;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public float getMinConfidenceThreshold() {
		return minConfidenceThreshold;
	}

	public void setMinConfidenceThreshold(float minConfidenceThreshold) {
		this.minConfidenceThreshold = minConfidenceThreshold;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIdentifier() {
		return identifier;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	/**
	 * @return the firstPageProjectFileName
	 */
	public String getFirstPageProjectFileName() {
		return firstPageProjectFileName;
	}

	/**
	 * @param rspProjectFileName the firstPageProjectFileName to set
	 */
	public void setFirstPageProjectFileName(String rspProjectFileName) {
		this.firstPageProjectFileName = rspProjectFileName;
	}

	/**
	 * @return the secondPageProjectFileName
	 */
	public String getSecondPageProjectFileName() {
		return secondPageProjectFileName;
	}

	/**
	 * @param rspProjectFileName the secondPageProjectFileName to set
	 */
	public void setSecondPageProjectFileName(String rspProjectFileName) {
		this.secondPageProjectFileName = rspProjectFileName;
	}

	/**
	 * @return the thirdPageProjectFileName
	 */
	public String getThirdPageProjectFileName() {
		return thirdPageProjectFileName;
	}

	/**
	 * @param rspProjectFileName the thirdPageProjectFileName to set
	 */
	public void setThirdPageProjectFileName(String rspProjectFileName) {
		this.thirdPageProjectFileName = rspProjectFileName;
	}

	/**
	 * @return the fourthPageProjectFileName
	 */
	public String getFourthPageProjectFileName() {
		return fourthPageProjectFileName;
	}

	/**
	 * @param rspProjectFileName the fourthPageProjectFileName to set
	 */
	public void setFourthPageProjectFileName(String rspProjectFileName) {
		this.fourthPageProjectFileName = rspProjectFileName;
	}

	/**
	 * true for soft delete
	 * 
	 * @param isDeleted
	 */
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public boolean isNew() {
		return isNew;
	}

	public void setNew(boolean isNew) {
		this.isNew = isNew;
	}

	public void addFieldType(FieldTypeDTO fieldTypeDTO) {
		fieldsMap.put(fieldTypeDTO.getIdentifier(), fieldTypeDTO);
	}

	public void addPageType(PageTypeDTO pageTypeDTO) {
		pagesMap.put(pageTypeDTO.getIdentifier(), pageTypeDTO);
	}

	public void addFunctionKey(FunctionKeyDTO functionKeyDTO) {
		functionKeyMap.put(functionKeyDTO.getIdentifier(), functionKeyDTO);
	}

	public Collection<FieldTypeDTO> getFields(boolean includeDeleted) {
		if (includeDeleted)
			return fieldsMap.values();
		return getFields();
	}

	public Collection<FieldTypeDTO> getFields() {
		Map<String, FieldTypeDTO> fieldTypeDTOs = new LinkedHashMap<String, FieldTypeDTO>();
		for (FieldTypeDTO fieldTypeDTO : fieldsMap.values()) {
			if (!(fieldTypeDTO.isDeleted()))
				fieldTypeDTOs.put(fieldTypeDTO.getIdentifier(), fieldTypeDTO);
		}
		return fieldTypeDTOs.values();
	}

	public Collection<TableInfoDTO> getTableInfos(boolean includeDeleted) {
		if (includeDeleted)
			return tableInfoMap.values();
		return getTableInfos();
	}

	public Collection<TableInfoDTO> getTableInfos() {
		Map<String, TableInfoDTO> tableInfoDTOs = new LinkedHashMap<String, TableInfoDTO>();
		for (TableInfoDTO tableInfoDTO : tableInfoMap.values()) {
			if (!(tableInfoDTO.isDeleted()))
				tableInfoDTOs.put(tableInfoDTO.getIdentifier(), tableInfoDTO);
		}
		return tableInfoDTOs.values();
	}

	public void addFieldTypeDTO(FieldTypeDTO fieldTypeDTO) {
		fieldsMap.put("" + fieldTypeDTO.getIdentifier(), fieldTypeDTO);
	}

	public void addTableInfoDTO(TableInfoDTO tableInfoDTO) {
		tableInfoMap.put("" + tableInfoDTO.getIdentifier(), tableInfoDTO);
	}

	public Collection<PageTypeDTO> getPages(boolean includeDeleted) {
		if (includeDeleted)
			return pagesMap.values();
		return getPages();
	}

	public Collection<PageTypeDTO> getPages() {
		Map<String, PageTypeDTO> pageTypeDTOs = new LinkedHashMap<String, PageTypeDTO>();
		for (PageTypeDTO pageTypeDTO : pagesMap.values()) {
			if (!(pageTypeDTO.isDeleted())) {
				pageTypeDTOs.put(pageTypeDTO.getIdentifier(), pageTypeDTO);
			}
		}
		return pageTypeDTOs.values();
	}

	public void removeFieldTypeDTO(FieldTypeDTO fieldTypeDTO) {
		fieldsMap.remove(fieldTypeDTO.getIdentifier());
	}

	public void removeTableInfoDTO(TableInfoDTO tableInfoDTO) {
		tableInfoMap.remove(tableInfoDTO.getIdentifier());
	}

	public FieldTypeDTO getFieldTypeByName(String name) {
		Collection<FieldTypeDTO> dtos = fieldsMap.values();
		if (dtos != null)
			for (FieldTypeDTO fieldTypeDTO : dtos) {
				if (fieldTypeDTO.getName().equalsIgnoreCase(name)) {
					return fieldTypeDTO;
				}
			}
		return null;
	}

	public FieldTypeDTO getFieldTypeByIdentifier(String identifier) {
		Collection<FieldTypeDTO> dtos = fieldsMap.values();
		if (dtos != null)
			for (FieldTypeDTO fieldTypeDTO : dtos) {
				if (fieldTypeDTO.getIdentifier().equals(identifier)) {
					return fieldTypeDTO;
				}
			}
		return null;
	}

	public boolean checkFieldTypeName(String name) {
		if (getFieldTypeByName(name) != null)
			return true;
		return false;
	}

	/**
	 * Checks if the name provided is already in use by some other table in the document or not. Performs a case insensitive search on
	 * the table column name.
	 * 
	 * @param name {@link String} the name of the table to checked for availability.
	 * @return boolean, <code>true</code> if the provided name is not taken by any other existing table, <code>false</code> otherwise.
	 */
	public boolean checkTableName(String name) {
		boolean isTableNameInUse = false;
		if (null != name) {
			if (null != getTableInfoByName(name)) {
				isTableNameInUse = true;
			}
		}
		return isTableNameInUse;
	}

	/**
	 * Checks if the name provided is already in use by some other table in the document or not except for the table with given
	 * identifier. Performs a case insensitive search on the table column name.
	 * 
	 * @param name {@link String} the name of the table to checked for availability.
	 * @return boolean, <code>true</code> if the provided name is not taken by any other existing table, <code>false</code> otherwise.
	 */
	public boolean checkTableName(String name, String identifier) {
		// changed to correct checking of table info name when edit is done and name is not changed.
		boolean isTableNameInUse = false;
		if (null != name && null != identifier) {
			TableInfoDTO tableInfoDTO = getTableInfoByName(name);
			if (null != tableInfoDTO && !identifier.equals(tableInfoDTO.getIdentifier())) {
				isTableNameInUse = true;
			}
		}

		return isTableNameInUse;
	}

	public TableInfoDTO getTableInfoByIdentifier(String identifier) {
		Collection<TableInfoDTO> dtos = tableInfoMap.values();
		if (dtos != null)
			for (TableInfoDTO tableInfoDTO : dtos) {
				if (tableInfoDTO.getIdentifier().equals(identifier)) {
					return tableInfoDTO;
				}
			}
		return null;
	}

	/**
	 * Gets the <code>TableInfoDTO</code> object for table in this document which is not deleted and has the given name. Performs a
	 * case insensitive search for table name.
	 * 
	 * @param name {@link String} the name of the table to be searched.
	 * @return {@link TableInfoDTO} table info DTO for the table with the given in this document, returns <code>null</code> if no such
	 *         table is found.
	 */
	public TableInfoDTO getTableInfoByName(String name) {
		TableInfoDTO searchedTableInfoDTO = null;

		Collection<TableInfoDTO> tableDtos = tableInfoMap.values();
		if (null != tableDtos)
			for (TableInfoDTO tableInfoDTO : tableDtos) {
				if (!tableInfoDTO.isDeleted() && tableInfoDTO.getName().equalsIgnoreCase(name)) {
					searchedTableInfoDTO = tableInfoDTO;
					break;
				}
			}
		return searchedTableInfoDTO;
	}

	/**
	 * Gets the <code>TableInfoDTO</code> object for table in this document which is not deleted and has the given name. Performs a
	 * case insensitive search for table name.
	 * 
	 * @param name {@link String} the name of the table to be searched.
	 * @return {@link TableInfoDTO} table info DTO for the table with the given in this document, returns <code>null</code> if no such
	 *         table is found.
	 */
	public TableInfoDTO getTableInfoByName(String name, String identifier) {
		TableInfoDTO searchedTableInfoDTO = null;

		Collection<TableInfoDTO> tableDtos = tableInfoMap.values();
		if (null != tableDtos)
			for (TableInfoDTO tableInfoDTO : tableDtos) {
				if (!tableInfoDTO.getIdentifier().equalsIgnoreCase(identifier) && !tableInfoDTO.isDeleted()
						&& tableInfoDTO.getName().equalsIgnoreCase(name)) {
					searchedTableInfoDTO = tableInfoDTO;
					break;
				}
			}
		return searchedTableInfoDTO;
	}

	public Collection<FunctionKeyDTO> getFunctionKeys() {
		Map<String, FunctionKeyDTO> functionKeyDTOs = new LinkedHashMap<String, FunctionKeyDTO>();
		for (FunctionKeyDTO functionKeyDTO : functionKeyMap.values()) {
			if (!functionKeyDTO.isDeleted()) {
				functionKeyDTOs.put(functionKeyDTO.getIdentifier(), functionKeyDTO);
			}
		}
		return functionKeyDTOs.values();
	}

	public Collection<FunctionKeyDTO> getFunctionKeys(boolean includeDeleted) {
		if (includeDeleted)
			return functionKeyMap.values();
		return getFunctionKeys();
	}

	public FunctionKeyDTO getFunctionKeyByIdentifier(String identifier) {
		Collection<FunctionKeyDTO> dtos = functionKeyMap.values();
		if (dtos != null)
			for (FunctionKeyDTO functionKeyDTO : dtos) {
				if (functionKeyDTO.getIdentifier().equals(identifier)) {
					return functionKeyDTO;
				}
			}
		return null;
	}

	public FunctionKeyDTO getFunctionKeyDTOByShorcutKeyName(String shortcutKeyName) {
		Collection<FunctionKeyDTO> dtos = functionKeyMap.values();
		if (dtos != null)
			for (FunctionKeyDTO functionKeyDTO : dtos) {
				if (functionKeyDTO.getShortcutKeyName().equals(shortcutKeyName)) {
					return functionKeyDTO;
				}
			}
		return null;
	}

	public boolean isHidden() {
		return isHidden;
	}

	public void setHidden(boolean isHidden) {
		this.isHidden = isHidden;
	}

	/**
	 * Returns object of {@link FunctionKeyDTO } with same name as of shortcutKeyName and according to parameter includeDeleted.
	 * 
	 * @param shortcutKeyName {@link String } a value having name of Shortcut Key.
	 * @param includeDeleted a boolean value to decide whether to include deleted {@link FunctionKeyDTO } objects or not.
	 * @return returns the object of {@link FunctionKeyDTO } class if found which satisfy condition , otherwise null.
	 */
	public FunctionKeyDTO getFunctionKeyDTOByShorcutKeyName(final String shortcutKeyName, final boolean includeDeleted) {
		FunctionKeyDTO functionKeyDTOResult = null;
		final Collection<FunctionKeyDTO> functionKeyDtos = functionKeyMap.values();
		if (functionKeyDtos != null && null != shortcutKeyName) {
			if (includeDeleted) {
				for (final FunctionKeyDTO functionKeyDTO : functionKeyDtos) {
					if (null != functionKeyDTO) {
						String existingShortcutKeyName = functionKeyDTO.getShortcutKeyName();
						if (null != existingShortcutKeyName && existingShortcutKeyName.equals(shortcutKeyName)) {
							functionKeyDTOResult = functionKeyDTO;
							break;
						}
					}
				}
			} else {
				for (final FunctionKeyDTO functionKeyDTO : functionKeyDtos) {
					if (null != functionKeyDTO) {
						String existingShortcutKeyName = functionKeyDTO.getShortcutKeyName();
						if (null != existingShortcutKeyName && existingShortcutKeyName.equals(shortcutKeyName)
								&& !functionKeyDTO.isDeleted()) {
							functionKeyDTOResult = functionKeyDTO;
							break;
						}
					}
				}
			}
		}
		return functionKeyDTOResult;
	}

	/**
	 * Returns a map containing field type dtos with their identifiers.
	 * 
	 * @return {@link Map} map containing field type dtos and their identifiers.
	 */
	public Map<String, FieldTypeDTO> getFieldsMap() {
		return fieldsMap;
	}

	/**
	 * Returns a map containing table info dtos with their identifiers.
	 * 
	 * @return {@link Map} map containing table info dtos and their identifiers.
	 */
	public Map<String, TableInfoDTO> getTableInfoMap() {
		return tableInfoMap;
	}

	/**
	 * Returns a map containing function key dtos with their identifiers.
	 * 
	 * @return {@link Map} map containing function key dtos and their identifiers.
	 */
	public Map<String, FunctionKeyDTO> getFunctionKeyMap() {
		return functionKeyMap;
	}

}
