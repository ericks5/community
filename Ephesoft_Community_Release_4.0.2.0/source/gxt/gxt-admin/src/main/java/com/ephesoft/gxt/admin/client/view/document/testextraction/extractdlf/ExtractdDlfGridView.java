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

package com.ephesoft.gxt.admin.client.view.document.testextraction.extractdlf;

import java.util.List;

import com.ephesoft.gxt.admin.client.presenter.document.testextraction.extractdlf.ExtractedDlfGridPresenter;
import com.ephesoft.gxt.admin.client.view.document.testextraction.TestExtractionInlineView;
import com.ephesoft.gxt.core.client.constant.PropertyAccessModel;
import com.ephesoft.gxt.core.client.ui.widget.Grid;
import com.ephesoft.gxt.core.client.ui.widget.HasResizableGrid;
import com.ephesoft.gxt.core.client.util.WidgetUtil;
import com.ephesoft.gxt.core.shared.dto.ExtractedDlfDTO;
import com.ephesoft.gxt.core.shared.dto.propertyAccessors.ExtractedDlfProperties;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;

public class ExtractdDlfGridView extends TestExtractionInlineView<ExtractedDlfGridPresenter> implements HasResizableGrid {

	@UiField(provided = true)
	protected Grid<ExtractedDlfDTO> extractedDlfGrid;

	@UiField
	protected VerticalLayoutContainer vPanel;

	interface Binder extends UiBinder<Widget, ExtractdDlfGridView> {
	}

	private static final Binder binder = GWT.create(Binder.class);

	public ExtractdDlfGridView() {
		super();
		initWidget(binder.createAndBindUi(this));
		setWidgetIds();
		extractedDlfGrid.addStyleName("gridView");
		vPanel.addStyleName("gridViewMainPanel");
		extractedDlfGrid.addStyleName("extractedDlfGrid");
		vPanel.addStyleName("extractedDlfGridViewMainPanel");
	}

	@Override
	public void initialize() {
		extractedDlfGrid = new Grid<ExtractedDlfDTO>(PropertyAccessModel.EXTRACTED_DLF) {
		};
		extractedDlfGrid.setIdProvider(ExtractedDlfProperties.property.pageName());
		extractedDlfGrid.setHasPagination(false);
	}

	public void setDataAndLoadGrid(List<ExtractedDlfDTO> extractedDlfDTOList) {
		extractedDlfGrid.setMemoryData(extractedDlfDTOList);
		reloadGrid();
	}

	private void reloadGrid() {
		WidgetUtil.reLoadGrid(extractedDlfGrid);
		clearVerticalLayoutContainer();
		vPanel.add(extractedDlfGrid);
	}

	private void setWidgetIds() {
		WidgetUtil.setID(extractedDlfGrid, "testExtraction-extracteddlf-grid");
	}

	public void clearVerticalLayoutContainer() {
		vPanel.clear();
	}

	@Override
	public Grid<ExtractedDlfDTO> getGrid() {
		return extractedDlfGrid;
	}
}
