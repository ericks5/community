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

package com.ephesoft.gxt.rv.client.view;

import com.ephesoft.dcma.batch.schema.Page;
import com.ephesoft.gxt.core.client.DragDropFlowPanel;
import com.ephesoft.gxt.core.client.DragDropFlowPanel.DragImage;
import com.ephesoft.gxt.core.shared.util.StringUtil;
import com.ephesoft.gxt.rv.client.listener.ReviewDragImageSelectionHandler;
import com.ephesoft.gxt.rv.client.presenter.ReviewDetailPresenter;
import com.ephesoft.gxt.rv.client.view.navigator.ReviewValidateNavigator;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Widget;

public class ReviewDetailView extends ReviewValidateBaseView<ReviewDetailPresenter> {

	interface Binder extends UiBinder<Widget, ReviewDetailView> {
	}

	private static final Binder binder = GWT.create(Binder.class);

	@UiField
	protected DragDropFlowPanel dragDropPanel;

	@UiField
	protected ScrollPanel dragDropScrollPanel;

	@Override
	public void initialize() {
	}

	public ReviewDetailView() {
		initWidget(binder.createAndBindUi(this));
		dragDropPanel.addStyleName("reviewDragPanel");
		dragDropPanel.setImageSelectionListener(new ReviewDragImageSelectionHandler());
		dragDropScrollPanel.addStyleName("imageDragDropPanel");
	}

	public void addImage(final DragImage dragImage) {
		dragDropPanel.add(dragImage);
	}

	public void clearThumbnailView() {
		dragDropPanel.clear();
	}

	public void selectPage(String pageIdentifier) {
		if (!StringUtil.isNullOrEmpty(pageIdentifier)) {
			int totalWidgets = dragDropPanel.getWidgetCount();
			Widget traversedWidget;
			DragImage traversedImage;
			Page traversedPage;
			for (int widgetIndex = 0; widgetIndex < totalWidgets; widgetIndex++) {
				traversedWidget = dragDropPanel.getWidget(widgetIndex);
				if (traversedWidget instanceof DragImage) {
					traversedImage = (DragImage) traversedWidget;
					traversedPage = ReviewValidateNavigator.getPage(ReviewValidateNavigator.getCurrentDocument(),
							traversedImage.getUrl());
					if (null != traversedPage && pageIdentifier.equalsIgnoreCase(traversedPage.getIdentifier())) {
						ReviewDragImageSelectionHandler.selectImage(traversedImage);
					}
				}
			}
		}
	}
}