package interpretation.uCD33;

import java.io.File;
import java.util.ArrayList;

import org.w3c.dom.Node;

import information.FileObject;
import information.dU34.Mes.Deal_Set;
import information.dU34.Mes.DeaSet.Deal;
import information.dU34.Mes.DeaSet.Dea.Collateral;
import output.PrintError;
import specification.dU34.Enumeration;
import validation.ComputeError;

public class Interpreter extends interpretation.Interpreter{
	
	public Interpreter(){}

	@Override
	public FileObject interpret(File subject) {
		FileObject result = new information.uCD33.Message();
		
		// TODO Auto-generated method stub
		
		return result;
	}
	
	
	
	
	
	
	
	
//	public boolean matchProperty_Valuation_Detail(Node currentNode)
//	{
//		boolean result = true;
//		
//		//Property_Valuation_Detail
//		if(currentNode.getNodeName().toLowerCase().equals("Property_Valuation_Detail".toLowerCase())){
//			Node parentNode = currentNode;
//			
//			//check child nodes
//			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
//				currentNode = parentNode.getChildNodes().item(x);
//				
//				//if an attribute or element
//				if(isAttributeOrElement(currentNode)){
//					//start matching
//					
//					//@IdentifierOwnerURI
//					if(currentNode.getNodeName().toLowerCase().equals("IdentifierOwnerURI".toLowerCase())){
//						
//					}
//					//AppraisalIdentifier
//					else if(currentNode.getNodeName().toLowerCase().equals("AppraisalIdentifier".toLowerCase())){
//						//if node information is string of length 1 to 10
//						if(ComputeError.isWithinStringLength(currentNode.getFirstChild().getNodeValue(),1,10)){
//							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get Collaterals, then the last Collateral //get last Property_Valuation, get Property_Valuation_Detail //set AppraisalIdentifier
//							((Property_Valuation) ( (Collateral) ( (Deal) ( (Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Collateral")).getSubject_Property().getLast("Property_Valuation")).getProperty_Valuation_Detail().setAppraisalIdentifier(currentNode.getFirstChild().getNodeValue());
//						}
//						else
//							//report error
//							errorList.add(PrintError.stringLengthOutsideRange(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(),1,10));
//					}
//					//PropertyValuationAmount
//					else if(currentNode.getNodeName().toLowerCase().equals("PropertyValuationAmount".toLowerCase())){
//						//if is a positive number
//						if(ComputeError.isPositiveNumber(currentNode.getFirstChild().getNodeValue()))
//							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get Collaterals, then the last Collateral //get last Property_Valuation, get Property_Valuation_Detail //set PropertyValuationAmount
//							((Property_Valuation) ( (Collateral) ( (Deal) ( (Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Collateral")).getSubject_Property().getLast("Property_Valuation")).getProperty_Valuation_Detail().setPropertyValuationAmount(currentNode.getFirstChild().getNodeValue());
//						else
//							//report error
//							errorList.add(PrintError.notAPositiveNumber(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue()));
//					}
//					//PropertyValuationMethodType
//					else if(currentNode.getNodeName().toLowerCase().equals("PropertyValuationMethodType".toLowerCase())){
//						//if node information is an expected enumeration
//						if(Enumeration.getPropertyValuationMethodType().contains(currentNode.getFirstChild().getNodeValue())){
//							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get Collaterals, then the last Collateral //get last Property_Valuation, get Property_Valuation_Detail //set PropertyValuationMethodType
//							((Property_Valuation) ( (Collateral) ( (Deal) ( (Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Collateral")).getSubject_Property().getLast("Property_Valuation")).getProperty_Valuation_Detail().setPropertyValuationMethodType(currentNode.getFirstChild().getNodeValue());
//						}
//						else
//							//report error
//							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getPropertyValuationMethodType(), "PropertyValuationMethodType"));
//					}
//					//PropertyValuationMethodTypeOtherDescription
//					else if(currentNode.getNodeName().toLowerCase().equals("PropertyValuationMethodTypeOtherDescription".toLowerCase())){
//						//if node information is an expected enumeration
//						if(Enumeration.getPropertyValuationMethodType().contains(currentNode.getFirstChild().getNodeValue())){
//							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get Collaterals, then the last Collateral //get last Property_Valuation, get Property_Valuation_Detail //set PropertyValuationMethodTypeOtherDescription
//							((Property_Valuation) ( (Collateral) ( (Deal) ( (Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Collateral")).getSubject_Property().getLast("Property_Valuation")).getProperty_Valuation_Detail().setPropertyValuationMethodTypeOtherDescription(currentNode.getFirstChild().getNodeValue());
//						}
//						else
//							//report error
//							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getPropertyValuationMethodType(), "PropertyValuationMethodTypeOtherDescription"));
//					}
//					else
//						//report error
//						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Property_Valuation"));
//				}
//			}
//		}
//		else
//			result = false;
//		
//		return result;
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
