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

package com.ephesoft.dcma.imagemagick;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.ephesoft.dcma.batch.dao.impl.BatchPluginPropertyContainer.BatchPluginConfiguration;
import com.ephesoft.dcma.batch.service.PluginPropertiesService;
import com.ephesoft.dcma.core.common.FileType;
import com.ephesoft.dcma.core.component.ICommonConstants;
import com.ephesoft.dcma.core.exception.DCMAApplicationException;
import com.ephesoft.dcma.core.threadpool.BatchInstanceThread;
import com.ephesoft.dcma.core.threadpool.EphesoftProcessExecutor;
import com.ephesoft.dcma.da.domain.BatchClass;
import com.ephesoft.dcma.da.domain.BatchInstance;
import com.ephesoft.dcma.imagemagick.constant.ImageMagicKConstants;
import com.ephesoft.dcma.util.ApplicationConfigProperties;
import com.ephesoft.dcma.util.EphesoftStringUtil;
import com.ephesoft.dcma.util.OSUtil;

/**
 * Provides functionalities to convert multipage tiff and PDF file into single page tiff files using ImageMagik and GhostScript.
 * 
 * @author Ephesoft
 * 
 *         <b>created on</b> Jun 20, 2013 <br/>
 * @version $LastChangedDate:$ <br/>
 *          $LastChangedRevision:$ <br/>
 */
public class MultiPageToSinglePageConverter implements ICommonConstants, IImageMagickCommonConstants {

	private static final String IMAGEMAGICK_GHOSTSCRIPT_EXE = "imagemagick.ghostscript_command";

	private static final String IMAGEMAGICK_PROPERTY_FILE_NAME = "imagemagick";

	private static final String IMAGEMAGICK_FOLDER = "dcma-imagemagick";

	private static final String MULTIPAGE_COMMAND_PARAMETER = "-%04d";

	private static final String QUOTES = "\"";

	private static final String SPACE = " ";
	private static final String GHOSTSCRIPT_EXECUTOR = "EphesoftExecutor.exe";
	private static final String IMAGEMAGICK_EXECUTOR = "EphesoftImageMagickExecutor.exe";

	/*
	 * String constant for image word.
	 */
	private static final String IMAGE = "image";

	/**
	 * Instance of PluginProperties Service {@link PluginPropertiesService}
	 */
	@Autowired
	@Qualifier("batchInstancePluginPropertiesService")
	private PluginPropertiesService biPluginPropertiesService;

	@Autowired
	@Qualifier("batchClassPluginPropertiesService")
	private PluginPropertiesService pluginPropertiesService;

	public static final String IM4JAVA_TOOLPATH = "IM4JAVA_TOOLPATH";

	private static final Logger LOGGER = LoggerFactory.getLogger(MultiPageToSinglePageConverter.class);

	/**
	 * Converts a given tiff/pdf into tiff. In case of a multi-page pdf/tiff single tiff's for each page will be created.
	 * 
	 * @param batchClass {@link BatchClass} instance to work upon
	 * @param imageFile {@link File} instance to process
	 * @param outputFile Output {@link File} instance created as the result of processing
	 * @param batchInstanceThread {@link BatchInstanceThread} instance will be used to execute command
	 * @param allowPdfConversion {@link Boolean} to determine whether to allow pdf conversion or not
	 * @param deleteImage to determine whether to delete input file after processing or not
	 * 
	 * @throws DCMAApplicationException will be thrown if batchInstanceThread is unable to execute command for conversion
	 */
	public void convertPdfOrMultiPageTiffToTiff(final BatchClass batchClass, File imageFile, File outputFile,
			BatchInstanceThread batchInstanceThread, final Boolean allowPdfConversion, boolean deleteImage)
			throws DCMAApplicationException {
		String inputParams = getInputPluginConfigForIM(batchClass);
		String outputParams = getOutputPluginConfigForIM(batchClass);
		String imagePath = imageFile.getAbsolutePath();
		int indexOf = imagePath.toLowerCase().lastIndexOf(FileType.TIF.getExtensionWithDot());
		if (indexOf == -1) {
			indexOf = imagePath.toLowerCase().lastIndexOf(FileType.TIFF.getExtensionWithDot());
			if (indexOf == -1)
				if (allowPdfConversion) {
					indexOf = imagePath.toLowerCase().lastIndexOf(FileType.PDF.getExtensionWithDot());
				}
		}
		if (indexOf == -1) {
			LOGGER.error("Unsupported file format");
			return;
		}
		convertPdfOrMultiPageTiffToTiffUsingIM(inputParams, imageFile, outputParams, outputFile, batchInstanceThread, indexOf,
				deleteImage);

	}

	/**
	 * Converts a given tiff/pdf into tiff. In case of a multi-page pdf/tiff single tiff's for each page will be created.
	 * 
	 * @param batchInstance {@link BatchClass} instance to work upon
	 * @param imageFile {@link File} instance to process
	 * @param outputFile Output {@link File} instance created as the result of processing
	 * @param batchInstanceThread {@link BatchInstanceThread} instance will be used to execute command
	 * @param allowPdfConversion {@link Boolean} to determine whether to allow pdf conversion or not
	 * @param deleteImage to determine whether to delete input file after processing or not
	 * 
	 * @throws DCMAApplicationException will be thrown if batchInstanceThread is unable to execute command for conversion
	 */
	public void convertPdfOrMultiPageTiffToTiff(final BatchInstance batchInstance, File imageFile, File outputFile,
			BatchInstanceThread batchInstanceThread, final Boolean allowPdfConversion, boolean deleteImage)
			throws DCMAApplicationException {
		String inputParams = getInputPluginConfigForIM(batchInstance);
		String outputParams = getOutputPluginConfigForIM(batchInstance);

		String imagePath = imageFile.getAbsolutePath();
		int indexOf = imagePath.toLowerCase().lastIndexOf(FileType.TIF.getExtensionWithDot());
		if (indexOf == -1) {
			indexOf = imagePath.toLowerCase().lastIndexOf(FileType.TIFF.getExtensionWithDot());
			if (indexOf == -1)
				if (allowPdfConversion) {
					indexOf = imagePath.toLowerCase().lastIndexOf(FileType.PDF.getExtensionWithDot());
				}
		}
		if (indexOf == -1) {
			LOGGER.error("Unsupported file format");
			return;
		}
		convertPdfOrMultiPageTiffToTiffUsingIM(inputParams, imageFile, outputParams, outputFile, batchInstanceThread, indexOf,
				deleteImage);

	}

	/**
	 * This method converts input tiff/pdf to output tiff file, using input and output params of batch class using imageMagick.
	 * 
	 * @param batchClass {@link BatchClass}
	 * @param imageFile {@link File}
	 * @param outputFile {@link File}
	 * @param thread {@link BatchInstanceThread}
	 * @throws DCMAApplicationException
	 */
	public void convertPdfOrMultiPageTiffToTiff(BatchClass batchClass, File imageFile, File outputFile, BatchInstanceThread thread)
			throws DCMAApplicationException {
		String inputParams = getInputPluginConfigForIM(batchClass);
		String outputParams = getOutputPluginConfigForIM(batchClass);

		if (imageFile != null) {
			convertInputFileToOutputFileUsingIM(inputParams, imageFile.getAbsolutePath(), outputParams, imageFile.getAbsolutePath(),
					thread);
		}
	}

	/**
	 * Converts a given tiff/pdf into tiff using ImageMagik. In case of a multi-page pdf/tiff single tiff's for each page will be
	 * created.
	 * 
	 * @param inputParams {@link String} input parameters for ImageMagik command
	 * @param imageFile {@link File} instance to process
	 * @param outputParams {@link String} output parameters for ImageMagik command
	 * @param outputFile Output {@link File} instance created as the result of processing
	 * @param batchInstanceThread {@link BatchInstanceThread} instance will be used to execute command
	 * @param indexOf index of file extension in imageFile name
	 * @param deleteImage to determine whether to delete input file after processing or not
	 * 
	 * @throws DCMAApplicationException will be thrown if batchInstanceThread is unable to execute command for conversion
	 */
	public void convertPdfOrMultiPageTiffToTiffUsingIM(final String inputParams, final File imageFile, final String outputParams,
			final File outputFile, final BatchInstanceThread batchInstanceThread, final int indexOf, final boolean deleteImage)
			throws DCMAApplicationException {
		String repairImageMagickFileUtilityPath = System.getenv(REPAIR_IMAGE_MAGICK_FILES_ENV_VARIABLE);
		if (imageFile != null) {
			String imagePath = imageFile.getAbsolutePath();

			String outputImagePath = imagePath.substring(0, indexOf);
			String fileExtension = MULTIPAGE_COMMAND_PARAMETER + FileType.TIF.getExtensionWithDot();
			if (outputFile != null) {
				outputImagePath = outputFile.getAbsolutePath();
				if (outputImagePath.endsWith(DOUBLE_BACKWARD_SLASH) || outputImagePath.endsWith(FORWARD_SLASH)) {
					fileExtension = EphesoftStringUtil.concatenate(IMAGE, fileExtension);
				}
			}
			try {
				String command = ICommonConstants.EMPTY_STRING;
				ArrayList<String> commandList = new ArrayList<String>();
				if (OSUtil.isWindows()) {
					commandList.add(EphesoftStringUtil.concatenate(repairImageMagickFileUtilityPath, File.separator,
							IMAGEMAGICK_EXECUTOR));
					createImageMagickCommandforWindows(commandList, inputParams,
							EphesoftStringUtil.concatenate(QUOTES, System.getenv(IM4JAVA_TOOLPATH), File.separator, "convert\""),
							EphesoftStringUtil.concatenate(QUOTES, imagePath, QUOTES), outputParams,
							EphesoftStringUtil.concatenate(QUOTES, outputImagePath, fileExtension, QUOTES));

				} else {
					String outputImageName = EphesoftStringUtil.concatenate(outputImagePath, fileExtension);
					commandList.add("convert");
					createCommandForLinux(commandList, inputParams, EphesoftStringUtil.concatenate(SPACE, imagePath, SPACE),
							outputParams, EphesoftStringUtil.concatenate(SPACE, outputImageName, SPACE));
				}
				String[] cmds = (String[]) commandList.toArray(new String[commandList.size()]);

				if (batchInstanceThread != null) {
					LOGGER.info("Adding generated command to thread pool. Command is : ");
					for (int ind = 0; ind < cmds.length; ind++) {
						LOGGER.info(EphesoftStringUtil.concatenate(cmds[ind], SPACE));
					}
					/*
					 * if (OSUtil.isWindows()) { thread.add(new ProcessExecutor(cmds, null)); } else { thread.add(new
					 * ProcessExecutor(cmds, new File(System.getenv(IM4JAVA_TOOLPATH)))); }
					 */

					if (OSUtil.isWindows()) {
						// Replacing ProcessExecutor with EphesoftProcessExecutor
						batchInstanceThread.add(new EphesoftProcessExecutor(cmds, null, ApplicationConfigProperties
								.getWaitTimeProperty(IM_WAIT_TIME_PROPERTY), true, deleteImage, imageFile, false));

					} else {
						batchInstanceThread.add(new EphesoftProcessExecutor(cmds, new File(System.getenv(IM4JAVA_TOOLPATH)),
								ApplicationConfigProperties.getWaitTimeProperty(IM_WAIT_TIME_PROPERTY), true, deleteImage, imageFile,
								false));
					}
				} else {
					LOGGER.error(EphesoftStringUtil.concatenate("Command ", command, " cannot be run"));
					throw new DCMAApplicationException(EphesoftStringUtil.concatenate("Command ", command, " cannot be run"));
				}

			} catch (Exception exception) {
				LOGGER.error("Problem generating tiffs");
				throw new DCMAApplicationException("Problem generating tiffs", exception);
			}
		}
	}

	// New Method
	public void convertPdfOrMultiPageTiffToPNGOrTifUsingIM(final String inputParams, final File imageFile, final String outputParams,
			final File outputFile, final BatchInstanceThread batchInstanceThread, final int indexOf, final boolean deleteImage,
			final boolean isConvertToTif) throws DCMAApplicationException {
		String repairImageMagickFileUtilityPath = System.getenv(REPAIR_IMAGE_MAGICK_FILES_ENV_VARIABLE);
		if (imageFile != null) {
			String imagePath = imageFile.getAbsolutePath();

			String outputImagePath = imagePath.substring(0, indexOf);
			String fileExtension = "";
			if (isConvertToTif) {
				fileExtension = MULTIPAGE_COMMAND_PARAMETER + FileType.TIF.getExtensionWithDot();
			} else {
				fileExtension = MULTIPAGE_COMMAND_PARAMETER + FileType.PNG.getExtensionWithDot();
			}

			if (outputFile != null) {
				outputImagePath = outputFile.getAbsolutePath();
				if (outputImagePath.endsWith(DOUBLE_BACKWARD_SLASH) || outputImagePath.endsWith(FORWARD_SLASH)) {
					fileExtension = EphesoftStringUtil.concatenate(IMAGE, fileExtension);
				}
			}
			try {
				String command = ICommonConstants.EMPTY_STRING;
				ArrayList<String> commandList = new ArrayList<String>();
				if (OSUtil.isWindows()) {
					commandList.add(EphesoftStringUtil.concatenate(repairImageMagickFileUtilityPath, File.separator,
							IMAGEMAGICK_EXECUTOR));
					createImageMagickCommandforWindows(commandList, inputParams,
							EphesoftStringUtil.concatenate(QUOTES, System.getenv(IM4JAVA_TOOLPATH), File.separator, "convert\""),
							EphesoftStringUtil.concatenate(QUOTES, imagePath, QUOTES), outputParams,
							EphesoftStringUtil.concatenate(QUOTES, outputImagePath, fileExtension, QUOTES));

				} else {
					String outputImageName = EphesoftStringUtil.concatenate(outputImagePath, fileExtension);
					commandList.add("convert");
					createCommandForLinux(commandList, inputParams, EphesoftStringUtil.concatenate(SPACE, imagePath, SPACE),
							outputParams, EphesoftStringUtil.concatenate(SPACE, outputImageName, SPACE));
				}
				String[] cmds = (String[]) commandList.toArray(new String[commandList.size()]);

				if (batchInstanceThread != null) {
					LOGGER.info("Adding generated command to thread pool. Command is : ");
					for (int ind = 0; ind < cmds.length; ind++) {
						LOGGER.info(EphesoftStringUtil.concatenate(cmds[ind], SPACE));
					}
					/*
					 * if (OSUtil.isWindows()) { thread.add(new ProcessExecutor(cmds, null)); } else { thread.add(new
					 * ProcessExecutor(cmds, new File(System.getenv(IM4JAVA_TOOLPATH)))); }
					 */

					if (OSUtil.isWindows()) {
						// Replacing ProcessExecutor with EphesoftProcessExecutor
						batchInstanceThread.add(new EphesoftProcessExecutor(cmds, null, ApplicationConfigProperties
								.getWaitTimeProperty(IM_WAIT_TIME_PROPERTY), true, deleteImage, imageFile, false));

					} else {
						batchInstanceThread.add(new EphesoftProcessExecutor(cmds, new File(System.getenv(IM4JAVA_TOOLPATH)),
								ApplicationConfigProperties.getWaitTimeProperty(IM_WAIT_TIME_PROPERTY), true, deleteImage, imageFile,
								false));
					}
				} else {
					LOGGER.error(EphesoftStringUtil.concatenate("Command ", command, " cannot be run"));
					throw new DCMAApplicationException(EphesoftStringUtil.concatenate("Command ", command, " cannot be run"));
				}

			} catch (Exception exception) {
				LOGGER.error("Problem generating tiffs");
				throw new DCMAApplicationException("Problem generating tiffs", exception);
			}
		}
	}

	private String createImageMagickCommandforWindows(ArrayList<String> commandList, String inputParams, String environment,
			String inputImageName, String outputParams, String outputImageName) {
		if (environment != null) {
			commandList.add(environment);
		}
		StringBuffer command = new StringBuffer(ICommonConstants.EMPTY_STRING);
		if (inputImageName != null && outputImageName != null && inputParams != null) {
			commandList.add(QUOTES + inputParams.trim() + QUOTES);

			commandList.add(inputImageName.trim());
			commandList.add(QUOTES + outputParams.trim() + QUOTES);
			commandList.add(outputImageName.trim());

		}
		return command.toString();
	}

	private String createGhostScriptCommandforWindows(ArrayList<String> commandList, final String imageParams,
			final String environment, final String inputImageName, final String outputImageName) throws DCMAApplicationException {

		StringBuffer command = new StringBuffer(ICommonConstants.EMPTY_STRING);
		Properties imageMagickProperties = null;
		String ghostScriptExe = null;
		try {
			imageMagickProperties = ApplicationConfigProperties.getApplicationConfigProperties().getAllProperties(
					IMAGEMAGICK_FOLDER + File.separator + IMAGEMAGICK_PROPERTY_FILE_NAME);
			ghostScriptExe = imageMagickProperties.getProperty(IMAGEMAGICK_GHOSTSCRIPT_EXE);
		} catch (IOException ioException) {
			LOGGER.error("Unable to get Ghostscript command for windows from imagemagick properties file");
			throw new DCMAApplicationException("Unable to get Ghostscript command for windows from imagemagick properties file",
					ioException);
		}
		String splitParams[] = imageParams.split(" ");
		StringBuffer inputParameterBuffer = new StringBuffer();
		if (environment != null) {
			commandList.add(QUOTES + environment + ghostScriptExe + QUOTES);
		}
		for (int i = 0; i < splitParams.length; i++) {
			inputParameterBuffer.append(splitParams[i] + " ");
		}
		commandList.add(inputParameterBuffer.toString().trim());
		commandList.add(OUTPUT_FILE_PARAMETER_GHOSTSCRIPT);
		commandList.add(outputImageName);
		commandList.add(inputImageName);
		return command.toString();
	}

	private String createCommandForLinux(ArrayList<String> commandList, final String inputParams, final String inputImageName,
			final String outputParams, final String outputImageName) {
		StringBuffer command = new StringBuffer(ICommonConstants.EMPTY_STRING);
		if (!inputParams.isEmpty()) {
			String inputParamsArr[] = inputParams.split(SPACE);
			for (String string : inputParamsArr) {
				commandList.add(string.trim());
			}

		}
		commandList.add(inputImageName.trim());

		if (!outputParams.isEmpty()) {
			String outputParamsArr[] = outputParams.split(SPACE);
			for (String string : outputParamsArr) {
				commandList.add(string.trim());
			}
		}
		commandList.add(outputImageName.trim());
		return command.toString();
	}

	/**
	 * This API is used to convert multipage PDF files into TIFF files.
	 * 
	 * @param batchClass {@link BatchClass} This is the reference of batch class of concerned batch instance.
	 * @param imagePath {@link File} This is the path of input file.
	 * @param outputFilePath {@link File} This is the path where output files will be created.
	 * @param thread {@link BatchInstanceThread} This is reference of thread object where we add formed command.
	 * @param isSinglePagePDF true if the pdf passed contains a single page only
	 * @throws DCMAApplicationException If any error occurs while forming command
	 * 
	 */
	public void convertPdfToSinglePageTiffs(final BatchClass batchClass, final File imagePath, final File outputFilePath,
			final BatchInstanceThread thread, final boolean isSinglePagePDF) throws DCMAApplicationException {

		String gsParams = null;
		String outputParams = getOutputPluginConfigForIM(batchClass);

		// Getting the ghost script parameters.
		gsParams = getPluginConfigForGS(batchClass);
		convertPdfToSinglePageTiffsUsingGSAPI(gsParams, imagePath, outputParams, outputFilePath, thread, isSinglePagePDF);
	}

	/**
	 * This API is used to convert multipage PDF files into TIFF files.
	 * 
	 * @param batchInstance {@link BatchInstance} This is the reference of batch class of concerned batch instance.
	 * @param imagePath {@link File} This is the path of input file.
	 * @param outputFilePath {@link File} This is the path where output files will be created.
	 * @param thread {@link BatchInstanceThread} This is reference of thread object where we add formed command.
	 * @param isSinglePagePDF true if the pdf passed contains a single page only
	 * @throws DCMAApplicationException If any error occurs while forming command
	 * 
	 */
	public void convertPdfToSinglePageTiffs(final BatchInstance batchInstance, final File imagePath, final File outputFilePath,
			final BatchInstanceThread thread, final boolean isSinglePagePDF) throws DCMAApplicationException {

		String gsParams = null;
		String outputParams = getOutputPluginConfigForIM(batchInstance);

		// Getting the ghost script parameters.
		gsParams = getPluginConfigForGS(batchInstance);
		convertPdfToSinglePageTiffsUsingGSAPI(gsParams, imagePath, outputParams, outputFilePath, thread, isSinglePagePDF);
	}

	/**
	 * Converts multipage PDF files into TIFF files using GhostScript.
	 * 
	 * @param inputParams This is the command {@link String} for ghost script params
	 * @param imagePath This is the reference of input {@link File} to be processed
	 * @param outputParams This is the command {@link String} for defining properties of output files generated by command
	 * @param thread This is reference of {@link BatchInstanceThread} object where we add formed command
	 * @param isSinglePagePDF true if the pdf passed contains a single page only
	 * 
	 * @throws DCMAApplicationException If any error occurs while forming ghostscript command
	 * 
	 */
	public void convertPdfToSinglePageTiffsUsingGSAPI(String inputParams, File imagePath, String outputParams, File outputFilePath,
			BatchInstanceThread thread, final boolean isSinglePagePdf) throws DCMAApplicationException {
		try {
			String repairGhostScriptFileUtilityPath = System.getenv(REPAIR_FILES_THROUGH_GHOSTSCIPT_ENV_VARIABLE);
			String imageName = imagePath.getAbsolutePath();
			int indexOf = imageName.toLowerCase().indexOf(FileType.PDF.getExtensionWithDot());
			if (indexOf == -1) {
				LOGGER.info("No Pdf file format found");
				return;
			}

			String outputImagePath = imageName.substring(0, indexOf);
			String fileExtension = null;
			if (!isSinglePagePdf) {
				fileExtension = MULTIPAGE_COMMAND_PARAMETER + FileType.TIF.getExtensionWithDot();
			} else {
				fileExtension = FileType.TIF.getExtensionWithDot();
			}
			if (outputFilePath != null) {
				outputImagePath = outputFilePath.getAbsolutePath();
				if (outputImagePath.endsWith("\\") || outputImagePath.endsWith("/")) {
					fileExtension = "image" + fileExtension;
				}
			}
			String command = ICommonConstants.EMPTY_STRING;
			ArrayList<String> commandList = new ArrayList<String>();
			if (OSUtil.isWindows()) {
				commandList.add(repairGhostScriptFileUtilityPath + File.separator + GHOSTSCRIPT_EXECUTOR);
				createGhostScriptCommandforWindows(commandList, inputParams, System.getenv(GHOSTSCRIPT_ENV_VARIABLE) + File.separator,
						QUOTES + imageName + QUOTES, QUOTES + outputImagePath + fileExtension + QUOTES);

			} else {
				String outputImageName = outputImagePath + fileExtension;

				// Creating ghostscript command in case of Unix operating system.
				commandList.add(GHOST_SCRIPT_LINUX);
				createCommandForLinux(commandList, inputParams,
						EphesoftStringUtil.concatenate(SPACE, OUTPUT_FILE_PARAMETER_GHOSTSCRIPT, outputImageName, SPACE),
						IImageMagickCommonConstants.EMPTY_STRING, EphesoftStringUtil.concatenate(imageName, SPACE));
			}
			String[] cmds = (String[]) commandList.toArray(new String[commandList.size()]);

			if (thread != null) {
				LOGGER.info("Adding generated command to thread pool. Command is : ");
				for (int ind = 0; ind < cmds.length; ind++) {
					LOGGER.info(cmds[ind] + SPACE);
				}
				if (OSUtil.isWindows()) {

					// Replacing ProcessExecutor with EphesoftProcessExecutor
					thread.add(new EphesoftProcessExecutor(cmds, null, ApplicationConfigProperties
							.getWaitTimeProperty(IM_WAIT_TIME_PROPERTY), true, true, imagePath, false));
				} else {
					thread.add(new EphesoftProcessExecutor(cmds, new File(System.getenv(IM4JAVA_TOOLPATH)),
							ApplicationConfigProperties.getWaitTimeProperty(IM_WAIT_TIME_PROPERTY), true, true, imagePath, false));
				}
			} else {
				LOGGER.error("Command " + command + " cannot be run");
				throw new DCMAApplicationException("Command " + command + " cannot be run");
			}

		} catch (Exception ex) {
			LOGGER.error("Problem generating tiffs from Pdfs");
			throw new DCMAApplicationException("Problem generating tiffs from Pdfs", ex);
		}

	}

	public void convertPdfToSinglePagePNGOrTifUsingGSAPI(BatchClass batchClass, File imagePath, String outputParams,
			File outputFilePath, BatchInstanceThread thread, final boolean isSinglePagePdf, final boolean isConvertTiff,
			final boolean isDelete) throws DCMAApplicationException {
		String inputParams = getPluginConfigForGS(batchClass);
		convertPdfToSinglePagePNGOrTifUsingGSAPI(inputParams, imagePath, outputParams, outputFilePath, thread, isSinglePagePdf,
				isConvertTiff, isDelete);
	}

	public void convertPdfToSinglePagePNGOrTifUsingGSAPI(String inputParams, File imagePath, String outputParams, File outputFilePath,
			BatchInstanceThread thread, final boolean isSinglePagePdf, final boolean isConvertTiff, final boolean isDelete)
			throws DCMAApplicationException {
		try {
			String repairGhostScriptFileUtilityPath = System.getenv(REPAIR_FILES_THROUGH_GHOSTSCIPT_ENV_VARIABLE);
			String imageName = imagePath.getAbsolutePath();
			String extension = "";
			if (isConvertTiff) {
				extension = FileType.TIF.getExtensionWithDot();
			} else {
				extension = FileType.PNG.getExtensionWithDot();
			}
			int indexOf = imageName.toLowerCase().indexOf(FileType.PDF.getExtensionWithDot());
			if (indexOf == -1) {
				LOGGER.info("No Pdf file format found");
				return;
			}

			String outputImagePath = imageName.substring(0, indexOf);
			String fileExtension = null;
			if (!isSinglePagePdf) {
				fileExtension = MULTIPAGE_COMMAND_PARAMETER + extension;
			} else {
				fileExtension = extension;
			}
			if (outputFilePath != null) {
				outputImagePath = outputFilePath.getAbsolutePath();
				if (outputImagePath.endsWith("\\") || outputImagePath.endsWith("/")) {
					fileExtension = "image" + fileExtension;
				}
			}
			String command = ICommonConstants.EMPTY_STRING;
			ArrayList<String> commandList = new ArrayList<String>();
			if (OSUtil.isWindows()) {
				commandList.add(repairGhostScriptFileUtilityPath + File.separator + GHOSTSCRIPT_EXECUTOR);
				createGhostScriptCommandforWindows(commandList, inputParams, System.getenv(GHOSTSCRIPT_ENV_VARIABLE) + File.separator,
						QUOTES + imageName + QUOTES, QUOTES + outputImagePath + fileExtension + QUOTES);

			} else {
				String outputImageName = outputImagePath + fileExtension;

				// Creating ghostscript command in case of Unix operating system.
				commandList.add(GHOST_SCRIPT_LINUX);
				createCommandForLinux(commandList, inputParams,
						EphesoftStringUtil.concatenate(SPACE, OUTPUT_FILE_PARAMETER_GHOSTSCRIPT, outputImageName, SPACE),
						IImageMagickCommonConstants.EMPTY_STRING, EphesoftStringUtil.concatenate(imageName, SPACE));
			}
			String[] cmds = (String[]) commandList.toArray(new String[commandList.size()]);

			if (thread != null) {
				LOGGER.info("Adding generated command to thread pool. Command is : ");
				for (int ind = 0; ind < cmds.length; ind++) {
					LOGGER.info(cmds[ind] + SPACE);
				}
				if (OSUtil.isWindows()) {

					// Replacing ProcessExecutor with EphesoftProcessExecutor
					thread.add(new EphesoftProcessExecutor(cmds, null, ApplicationConfigProperties
							.getWaitTimeProperty(IM_WAIT_TIME_PROPERTY), true, isDelete, imagePath, false));
				} else {
					thread.add(new EphesoftProcessExecutor(cmds, new File(System.getenv(IM4JAVA_TOOLPATH)),
							ApplicationConfigProperties.getWaitTimeProperty(IM_WAIT_TIME_PROPERTY), true, isDelete, imagePath, false));
				}
			} else {
				LOGGER.error("Command " + command + " cannot be run");
				throw new DCMAApplicationException("Command " + command + " cannot be run");
			}

		} catch (Exception ex) {
			LOGGER.error("Problem generating tiff or pngs from Pdfs");
			throw new DCMAApplicationException("Problem generating tiff or pngs from Pdfs", ex);
		}

	}

	private String getOutputPluginConfigForIM(BatchClass batchClass) {
		String outputParams = "";
		BatchPluginConfiguration[] pluginConfiguration = pluginPropertiesService.getPluginProperties(batchClass.getIdentifier(),
				ImageMagicKConstants.IMPORT_MULTIPAGE_FILES_PLUGIN, ImageMagicProperties.IM_CONVERT_OUTPUT_IMAGE_PARAMETERS);
		if (pluginConfiguration != null && pluginConfiguration.length > 0 && pluginConfiguration[0].getValue() != null
				&& pluginConfiguration[0].getValue().length() > 0) {
			outputParams = pluginConfiguration[0].getValue();
		}
		return outputParams;
	}

	private String getOutputPluginConfigForIM(BatchInstance batchInstance) {
		String outputParams = "";
		BatchPluginConfiguration[] pluginConfiguration = biPluginPropertiesService.getPluginProperties(batchInstance.getIdentifier(),
				ImageMagicKConstants.IMPORT_MULTIPAGE_FILES_PLUGIN, ImageMagicProperties.IM_CONVERT_OUTPUT_IMAGE_PARAMETERS);
		if (pluginConfiguration != null && pluginConfiguration.length > 0 && pluginConfiguration[0].getValue() != null
				&& pluginConfiguration[0].getValue().length() > 0) {
			outputParams = pluginConfiguration[0].getValue();
		}
		return outputParams;
	}

	private String getInputPluginConfigForIM(BatchClass batchClass) {
		String inputParams = "";
		BatchPluginConfiguration[] pluginConfiguration = pluginPropertiesService.getPluginProperties(batchClass.getIdentifier(),
				ImageMagicKConstants.IMPORT_MULTIPAGE_FILES_PLUGIN, ImageMagicProperties.IM_CONVERT_INPUT_IMAGE_PARAMETERS);
		if (pluginConfiguration != null && pluginConfiguration.length > 0 && pluginConfiguration[0].getValue() != null
				&& pluginConfiguration[0].getValue().length() > 0) {
			inputParams = pluginConfiguration[0].getValue();
		}
		return inputParams;
	}

	private String getInputPluginConfigForIM(BatchInstance batchInstance) {
		String inputParams = "";
		BatchPluginConfiguration[] pluginConfiguration = biPluginPropertiesService.getPluginProperties(batchInstance.getIdentifier(),
				ImageMagicKConstants.IMPORT_MULTIPAGE_FILES_PLUGIN, ImageMagicProperties.IM_CONVERT_INPUT_IMAGE_PARAMETERS);
		if (pluginConfiguration != null && pluginConfiguration.length > 0 && pluginConfiguration[0].getValue() != null
				&& pluginConfiguration[0].getValue().length() > 0) {
			inputParams = pluginConfiguration[0].getValue();
		}
		return inputParams;
	}

	private String getPluginConfigForGS(BatchClass batchClass) {
		BatchPluginConfiguration[] pluginConfiguration = pluginPropertiesService.getPluginProperties(batchClass.getIdentifier(),
				ImageMagicKConstants.IMPORT_MULTIPAGE_FILES_PLUGIN, ImageMagicProperties.GS_IMAGE_PARAMETERS);
		String imageParams = ICommonConstants.EMPTY_STRING;
		if (pluginConfiguration != null && pluginConfiguration.length > 0 && pluginConfiguration[0].getValue() != null
				&& pluginConfiguration[0].getValue().length() > 0) {
			imageParams = pluginConfiguration[0].getValue();
			if (imageParams != null) {
				imageParams = imageParams.trim();
			}
		}
		return imageParams;
	}

	private String getPluginConfigForGS(BatchInstance batchInstance) {
		BatchPluginConfiguration[] pluginConfiguration = biPluginPropertiesService.getPluginProperties(batchInstance.getIdentifier(),
				ImageMagicKConstants.IMPORT_MULTIPAGE_FILES_PLUGIN, ImageMagicProperties.GS_IMAGE_PARAMETERS);
		String imageParams = ICommonConstants.EMPTY_STRING;
		if (pluginConfiguration != null && pluginConfiguration.length > 0 && pluginConfiguration[0].getValue() != null
				&& pluginConfiguration[0].getValue().length() > 0) {
			imageParams = pluginConfiguration[0].getValue();
			if (imageParams != null) {
				imageParams = imageParams.trim();
			}
		}
		return imageParams;
	}

	/**
	 * API will convert the input file to output file using image magic on the basis of input params and output params provided.
	 * 
	 * @param inputParams {@link String} input parameters for ImageMagik command
	 * @param inputImagePath {@link String} absolute path of input image.
	 * @param outputParams {@link String} output parameters for ImageMagik command
	 * @param outputImagePath {@link String} absolute path of output image.
	 * @param batchInstanceThread {@link BatchInstanceThread} instance will be used to execute command
	 * 
	 * @throws DCMAApplicationException if any error occurs while executing imageMagik command or batchInstanceThread is not proper
	 */
	public void convertInputFileToOutputFileUsingIM(final String inputParams, final String inputImagePath, final String outputParams,
			final String outputImagePath, final BatchInstanceThread batchInstanceThread) throws DCMAApplicationException {
		String repairImageMagickFileUtilityPath = System.getenv(REPAIR_IMAGE_MAGICK_FILES_ENV_VARIABLE);
		try {
			String command = ICommonConstants.EMPTY_STRING;
			ArrayList<String> commandList = new ArrayList<String>();
			if (OSUtil.isWindows()) {
				commandList
						.add(EphesoftStringUtil.concatenate(repairImageMagickFileUtilityPath, File.separator, IMAGEMAGICK_EXECUTOR));
				createImageMagickCommandforWindows(commandList, inputParams,
						EphesoftStringUtil.concatenate(QUOTES, System.getenv(IM4JAVA_TOOLPATH), File.separator, "convert\""),
						EphesoftStringUtil.concatenate(QUOTES, inputImagePath, QUOTES), outputParams,
						EphesoftStringUtil.concatenate(QUOTES, outputImagePath, QUOTES));

			} else {
				commandList.add("convert");
				createCommandForLinux(commandList, inputParams, EphesoftStringUtil.concatenate(SPACE, inputImagePath, SPACE),
						outputParams, EphesoftStringUtil.concatenate(SPACE, outputImagePath, SPACE));
			}
			String[] cmds = (String[]) commandList.toArray(new String[commandList.size()]);

			if (batchInstanceThread != null) {
				LOGGER.info("Adding generated command to thread pool. Command is : ");
				for (int ind = 0; ind < cmds.length; ind++) {
					LOGGER.info(EphesoftStringUtil.concatenate(cmds[ind], SPACE));
				}
				if (OSUtil.isWindows()) {
					// Replacing ProcessExecutor with EphesoftProcessExecutor
					batchInstanceThread.add(new EphesoftProcessExecutor(cmds, ApplicationConfigProperties
							.getWaitTimeProperty(IM_WAIT_TIME_PROPERTY)));
				} else {
					// Replacing ProcessExecutor with EphesoftProcessExecutor
					batchInstanceThread.add(new EphesoftProcessExecutor(cmds, new File(System.getenv(IM4JAVA_TOOLPATH)),
							ApplicationConfigProperties.getWaitTimeProperty(IM_WAIT_TIME_PROPERTY)));
				}
			} else {
				LOGGER.error(EphesoftStringUtil.concatenate("Command ", command, " cannot be run"));
				throw new DCMAApplicationException(EphesoftStringUtil.concatenate("Command ", command, " cannot be run"));
			}

		} catch (Exception exception) {
			LOGGER.error("Problem generating tiffs");
			throw new DCMAApplicationException("Problem generating tiffs", exception);
		}
	}

}
