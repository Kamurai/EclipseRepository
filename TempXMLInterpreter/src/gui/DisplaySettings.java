package gui;

public class DisplaySettings {
	//Application Level Sizes
	private static int applicationFrameWidth = 1920;
	private static int applicationFrameHeight = 1080;
	private static int applicationPanelWidth = applicationFrameWidth;
	private static int applicationPanelHeight = applicationFrameHeight;
	
	//Applicaton Panel
	private static int northPanelWidth = applicationPanelWidth;
	private static int northPanelHeight = (int) (applicationPanelHeight * 0.25);
	private static int southPanelWidth = applicationPanelWidth;
	private static int southPanelHeight = applicationPanelHeight - northPanelHeight;
	
	//North Panel
	private static int westPanelWidth = northPanelWidth/2;
	private static int westPanelHeight = northPanelHeight;
	private static int eastPanelWidth = northPanelWidth/2;
	private static int eastPanelHeight = northPanelHeight;
	
	//West Panel
	private static int productPanelWidth = westPanelWidth;
	private static int productPanelHeight = westPanelHeight/4;
	private static int mismoPanelWidth = westPanelWidth;
	private static int mismoPanelHeight = westPanelHeight/4;
	private static int testCasePanelWidth = westPanelWidth;
	private static int testCasePanelHeight = westPanelHeight/4;
	private static int runButtonPanelWidth = westPanelWidth;
	private static int runButtonPanelHeight = westPanelHeight/4;
	
	//Product Panel
	private static int productLabelWidth = productPanelWidth/4;
	private static int productLabelHeight = productPanelHeight;
	private static int productSelectionWidth = productPanelWidth - productLabelWidth;
	private static int productSelectionHeight = productPanelHeight;
	
	//Mismo Version Panel
	private static int mismoLabelWidth = mismoPanelWidth/4;
	private static int mismoLabelHeight = mismoPanelHeight;
	private static int mismoSelectionWidth = mismoPanelWidth - mismoLabelWidth;
	private static int mismoSelectionHeight = mismoPanelHeight;
	
	//Test Case Panel
	private static int testCaseLabelWidth = testCasePanelWidth/4;
	private static int testCaseLabelHeight = testCasePanelHeight;
	private static int testCaseSelectionWidth = testCasePanelWidth - testCaseLabelWidth;
	private static int testCaseSelectionHeight = testCasePanelHeight;
	
	//Run Button Panel
	private static int runButtonWidth = runButtonPanelWidth;
	private static int runButtonHeight = runButtonPanelHeight;
	
	//East Panel
	private static int fileChooserWidth = eastPanelWidth;
	private static int fileChooserHeight = eastPanelHeight;
	
	//South Panel
	private static int resultsLabelPanelWidth = southPanelWidth;
	private static int resultsLabelPanelHeight = southPanelHeight/10;
	private static int resultsPanelWidth = southPanelWidth;
	private static int resultsPanelHeight = southPanelHeight - resultsLabelPanelHeight;
	
	//Result Label Panel
	private static int resultLabelWidth = resultsLabelPanelWidth;
	private static int resultLabelHeight = resultsLabelPanelHeight;
	
	//Results Panel
	private static int resultScrollWidth = resultsPanelWidth - 20;
	private static int resultScrollHeight = resultsPanelHeight;
	private static int resultAreaWidth = resultScrollWidth;
	private static int resultAreaHeight = resultScrollHeight - 40;
		
	public static int getApplicationFrameWidth() {
		return applicationFrameWidth;
	}

	public void setApplicationFrameWidth(int applicationFrameWidth) {
		this.applicationFrameWidth = applicationFrameWidth;
	}

	public static int getApplicationFrameHeight() {
		return applicationFrameHeight;
	}

	public void setApplicationFrameHeight(int applicatoinFrameHeight) {
		this.applicationFrameHeight = applicatoinFrameHeight;
	}

	public static int getApplicationPanelWidth() {
		return applicationPanelWidth;
	}

	public void setApplicationPanelWidth(int applicationPanelWidth) {
		this.applicationPanelWidth = applicationPanelWidth;
	}

	public static int getApplicationPanelHeight() {
		return applicationPanelHeight;
	}

	public void setApplicationPanelHeight(int applicationPanelHeight) {
		this.applicationPanelHeight = applicationPanelHeight;
	}

	public static int getNorthPanelWidth() {
		return northPanelWidth;
	}

	public void setNorthPanelWidth(int northPanelWidth) {
		this.northPanelWidth = northPanelWidth;
	}

	public static int getNorthPanelHeight() {
		return northPanelHeight;
	}

	public void setNorthPanelHeight(int northPanelHeight) {
		this.northPanelHeight = northPanelHeight;
	}

	public static int getSouthPanelWidth() {
		return southPanelWidth;
	}

	public void setSouthPanelWidth(int southPanelWidth) {
		this.southPanelWidth = southPanelWidth;
	}

	public static int getSouthPanelHeight() {
		return southPanelHeight;
	}

	public void setSouthPanelHeight(int southPanelHeight) {
		this.southPanelHeight = southPanelHeight;
	}

	public static int getWestPanelWidth() {
		return westPanelWidth;
	}

	public void setWestPanelWidth(int westPanelWidth) {
		this.westPanelWidth = westPanelWidth;
	}

	public static int getWestPanelHeight() {
		return westPanelHeight;
	}

	public void setWestPanelHeight(int westPanelHeight) {
		this.westPanelHeight = westPanelHeight;
	}

	public static int getEastPanelWidth() {
		return eastPanelWidth;
	}

	public void setEastPanelWidth(int eastPanelWidth) {
		this.eastPanelWidth = eastPanelWidth;
	}

	public static int getEastPanelHeight() {
		return eastPanelHeight;
	}

	public void setEastPanelHeight(int eastPanelHeight) {
		this.eastPanelHeight = eastPanelHeight;
	}

	public static int getProductPanelWidth() {
		return productPanelWidth;
	}

	public void setProductPanelWidth(int productPanelWidth) {
		this.productPanelWidth = productPanelWidth;
	}

	public static int getProductPanelHeight() {
		return productPanelHeight;
	}

	public void setProductPanelHeight(int productPanelHeight) {
		this.productPanelHeight = productPanelHeight;
	}

	public static int getMismoPanelWidth() {
		return mismoPanelWidth;
	}

	public void setMismoPanelWidth(int mismoPanelWidth) {
		this.mismoPanelWidth = mismoPanelWidth;
	}

	public static int getMismoPanelHeight() {
		return mismoPanelHeight;
	}

	public void setMismoPanelHeight(int mismoPanelHeight) {
		this.mismoPanelHeight = mismoPanelHeight;
	}

	public static int getTestCasePanelWidth() {
		return testCasePanelWidth;
	}

	public void setTestCasePanelWidth(int testCasePanelWidth) {
		this.testCasePanelWidth = testCasePanelWidth;
	}

	public static int getTestCasePanelHeight() {
		return testCasePanelHeight;
	}

	public void setTestCasePanelHeight(int testCasePanelHeight) {
		this.testCasePanelHeight = testCasePanelHeight;
	}

	public static int getRunButtonPanelWidth() {
		return runButtonPanelWidth;
	}

	public void setRunButtonPanelWidth(int runButtonPanelWidth) {
		this.runButtonPanelWidth = runButtonPanelWidth;
	}

	public static int getRunButtonPanelHeight() {
		return runButtonPanelHeight;
	}

	public void setRunButtonPanelHeight(int runButtonPanelHeight) {
		this.runButtonPanelHeight = runButtonPanelHeight;
	}

	public static int getProductLabelWidth() {
		return productLabelWidth;
	}

	public void setProductLabelWidth(int productLabelWidth) {
		this.productLabelWidth = productLabelWidth;
	}

	public static int getProductLabelHeight() {
		return productLabelHeight;
	}

	public void setProductLabelHeight(int productLabelHeight) {
		this.productLabelHeight = productLabelHeight;
	}

	public static int getProductSelectionWidth() {
		return productSelectionWidth;
	}

	public void setProductSelectionWidth(int productSelectionWidth) {
		this.productSelectionWidth = productSelectionWidth;
	}

	public static int getProductSelectionHeight() {
		return productSelectionHeight;
	}

	public void setProductSelectionHeight(int productSelectionHeight) {
		this.productSelectionHeight = productSelectionHeight;
	}

	public static int getMismoLabelWidth() {
		return mismoLabelWidth;
	}

	public void setMismoLabelWidth(int mismoLabelWidth) {
		this.mismoLabelWidth = mismoLabelWidth;
	}

	public static int getMismoLabelHeight() {
		return mismoLabelHeight;
	}

	public void setMismoLabelHeight(int mismoLabelHeight) {
		this.mismoLabelHeight = mismoLabelHeight;
	}

	public static int getMismoSelectionWidth() {
		return mismoSelectionWidth;
	}

	public void setMismoSelectionWidth(int mismoSelectionWidth) {
		this.mismoSelectionWidth = mismoSelectionWidth;
	}

	public static int getMismoSelectionHeight() {
		return mismoSelectionHeight;
	}

	public void setMismoSelectionHeight(int mismoSelectionHeight) {
		this.mismoSelectionHeight = mismoSelectionHeight;
	}

	public static int getTestCaseLabelWidth() {
		return testCaseLabelWidth;
	}

	public void setTestCaseLabelWidth(int testCaseLabelWidth) {
		this.testCaseLabelWidth = testCaseLabelWidth;
	}

	public static int getTestCaseLabelHeight() {
		return testCaseLabelHeight;
	}

	public void setTestCaseLabelHeight(int testCaseLabelHeight) {
		this.testCaseLabelHeight = testCaseLabelHeight;
	}

	public static int getTestCaseSelectionWidth() {
		return testCaseSelectionWidth;
	}

	public void setTestCaseSelectionWidth(int testCaseSelectionWidth) {
		this.testCaseSelectionWidth = testCaseSelectionWidth;
	}

	public static int getTestCaseSelectionHeight() {
		return testCaseSelectionHeight;
	}

	public void setTestCaseSelectionHeight(int testCaseSelectionHeight) {
		this.testCaseSelectionHeight = testCaseSelectionHeight;
	}

	public static int getRunButtonWidth() {
		return runButtonWidth;
	}

	public void setRunButtonWidth(int runButtonWidth) {
		this.runButtonWidth = runButtonWidth;
	}

	public static int getRunButtonHeight() {
		return runButtonHeight;
	}

	public void setRunButtonHeight(int runButtonHeight) {
		this.runButtonHeight = runButtonHeight;
	}

	public static int getFileChooserWidth() {
		return fileChooserWidth;
	}

	public void setFileChooserWidth(int fileChooserWidth) {
		this.fileChooserWidth = fileChooserWidth;
	}

	public static int getFileChooserHeight() {
		return fileChooserHeight;
	}

	public void setFileChooserHeight(int fileChooserHeight) {
		this.fileChooserHeight = fileChooserHeight;
	}

	public static int getResultsLabelPanelWidth() {
		return resultsLabelPanelWidth;
	}

	public void setResultsLabelPanelWidth(int resultsLabelPanelWidth) {
		this.resultsLabelPanelWidth = resultsLabelPanelWidth;
	}

	public static int getResultsLabelPanelHeight() {
		return resultsLabelPanelHeight;
	}

	public void setResultsLabelPanelHeight(int resultsLabelPanelHeight) {
		this.resultsLabelPanelHeight = resultsLabelPanelHeight;
	}

	public static int getResultsPanelWidth() {
		return resultsPanelWidth;
	}

	public void setResultsPanelWidth(int resultsPanelWidth) {
		this.resultsPanelWidth = resultsPanelWidth;
	}

	public static int getResultsPanelHeight() {
		return resultsPanelHeight;
	}

	public void setResultsPanelHeight(int resultsPanelHeight) {
		this.resultsPanelHeight = resultsPanelHeight;
	}

	public static int getResultLabelWidth() {
		return resultLabelWidth;
	}

	public void setResultLabelWidth(int resultLabelWidth) {
		this.resultLabelWidth = resultLabelWidth;
	}

	public static int getResultLabelHeight() {
		return resultLabelHeight;
	}

	public void setResultLabelHeight(int resultLabelHeight) {
		this.resultLabelHeight = resultLabelHeight;
	}

	public static int getResultScrollWidth() {
		return resultScrollWidth;
	}

	public void setResultScrollWidth(int resultScrollWidth) {
		this.resultScrollWidth = resultScrollWidth;
	}

	public static int getResultScrollHeight() {
		return resultScrollHeight;
	}

	public void setResultScrollHeight(int resultScrollHeight) {
		this.resultScrollHeight = resultScrollHeight;
	}

	public static int getResultAreaWidth() {
		return resultAreaWidth;
	}

	public void setResultAreaWidth(int resultAreaWidth) {
		this.resultAreaWidth = resultAreaWidth;
	}

	public static int getResultAreaHeight() {
		return resultAreaHeight;
	}

	public void setResultAreaHeight(int resultAreaHeight) {
		this.resultAreaHeight = resultAreaHeight;
	}
	
	
}
