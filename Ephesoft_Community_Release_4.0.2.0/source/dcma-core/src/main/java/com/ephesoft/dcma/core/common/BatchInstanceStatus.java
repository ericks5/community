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

package com.ephesoft.dcma.core.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Enumerating all possible batch instance status.
 * 
 * @author Ephesoft
 * @version 1.0
 */
public enum BatchInstanceStatus {
	NEW(0, "New"), LOCKED(1, "Locked"), SUSPEND(2, "Suspend"), READY(3, "Ready"), ERROR(4, "Error"), FINISHED(5, "Finished"),
	ASSIGNED(6, "Assigned"), OPEN(7, "Open"), RUNNING(8, "Running"), READY_FOR_REVIEW(9, "Review"), READY_FOR_VALIDATION(10,
			"Validation"), RESTARTED(11, "Restarted"), DELETED(12, "Deleted"), TRANSFERRED(13, "Transferred"), RESTART_IN_PROGRESS(14,
			"Restart in progress"), REMOTE(15, "Remote");

	private Integer statusId;

	private String name;

	private BatchInstanceStatus(int statusId, String name) {
		this.statusId = statusId;
		this.name = name;
	}

	public static List<BatchInstanceStatus> valuesAsList() {
		return Arrays.asList(values());
	}

	public static List<String> valuesAsStringList() {
		List<String> values = new ArrayList<String>();
		for (BatchInstanceStatus status : BatchInstanceStatus.values()) {
			values.add(status.toString());
		}
		return values;
	}

	public Integer getId() {
		return statusId;
	}

	public String getName() {
		return name;
	}

	/**
	 * Restartable status list.<br/>
	 * The List of Batch Instance Statuses from which the batch can be restarted.
	 * 
	 * @return the list
	 */
	public static List<BatchInstanceStatus> restartableStatusList() {
		List<BatchInstanceStatus> list = new ArrayList<BatchInstanceStatus>();
		list.add(BatchInstanceStatus.ERROR);
		list.add(BatchInstanceStatus.READY_FOR_REVIEW);
		list.add(BatchInstanceStatus.READY_FOR_VALIDATION);
		list.add(BatchInstanceStatus.RUNNING);
		return list;
	}
	
	public static List<BatchInstanceStatus> deletableStatusList() {
		return restartableStatusList();
	}

	public boolean isRestartableStatus() {
		boolean canRestart = false;
		if (restartableStatusList().contains(this)) {
			canRestart = true;
		}
		return canRestart;
	}
	
	public boolean isDeletableStatus() {
		boolean canDelete = false;
		if (deletableStatusList().contains(this)) {
			canDelete = true;
		}
		return canDelete;
	}

	/**
	 * Gets the batch instance status.
	 *
	 * @param status the status
	 * @return the batch instance status
	 */
	public static BatchInstanceStatus getBatchInstanceStatus(String status) {
		BatchInstanceStatus instanceStatus = null;
		for (BatchInstanceStatus batchInstanceStatus : BatchInstanceStatus.values()) {
			if (status.equals(batchInstanceStatus.toString())) {
				instanceStatus = batchInstanceStatus;
				break;
			}
		}
		return instanceStatus;
	}

}
