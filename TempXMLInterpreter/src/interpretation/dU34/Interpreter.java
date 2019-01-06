package interpretation.dU34;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import information.FileObject;
import information.dU34.Message;
import information.dU34.Mes.Deal_Set;
import information.dU34.Mes.Document_Set;
import information.dU34.Mes.DeaSet.Deal;
import information.dU34.Mes.DeaSet.Dea.Asset;
import information.dU34.Mes.DeaSet.Dea.Collateral;
import information.dU34.Mes.DeaSet.Dea.Expense;
import information.dU34.Mes.DeaSet.Dea.Liability;
import information.dU34.Mes.DeaSet.Dea.Loan;
import information.dU34.Mes.DeaSet.Dea.Loa.Document_Specific_Data_Set;
import information.dU34.Mes.DeaSet.Dea.Loa.Housing_Expense;
import information.dU34.Mes.DeaSet.Dea.Loa.Origination_Fund;
import information.dU34.Mes.DeaSet.Dea.Loa.Purchase_Credit;
import information.dU34.Mes.DeaSet.Dea.Loa.CloInf.Closing_Adjustment_Item;
import information.dU34.Mes.DeaSet.Dea.Loa.CloInf.CloAdjIte.Closing_Adjustment_Item_Detail;
import information.dU34.Mes.DeaSet.Dea.Loa.Ext.Oth.LoaExt.Underwriting_Verification;
import information.dU34.Mes.DeaSet.Dea.Loa.HelOcc.HELOC_Occurence;
import information.dU34.Mes.DeaSet.Dea.Loa.Und.Automated_Underwriting;
import information.dU34.Mes.DeaSet.Dea.Party;
import information.dU34.Mes.DeaSet.Dea.Ass.OwnPro.Property;
import information.uLDD30.common.Property_Valuation;
import information.dU34.Mes.DeaSet.Dea.Col.SubPro.Sales_Contract;
import information.dU34.Mes.DeaSet.Dea.Col.SubPro.SalCon.Sales_Concession;
import information.dU34.Mes.DeaSet.Dea.Par.Language;
import information.dU34.Mes.DeaSet.Dea.Par.Role;
import information.dU34.Mes.DeaSet.Dea.Par.Ind.Alias;
import information.dU34.Mes.DeaSet.Dea.Par.Ind.Contact_Point;
import information.dU34.Mes.DeaSet.Dea.Par.Rol.License;
import information.dU34.Mes.DeaSet.Dea.Par.Rol.Party_Role_Identifier;
import information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.Bankruptcy;
import information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.Dependent;
import information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.Employer;
import information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.Emp.LegEnt.Contact;
import information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.GovMon.HMDA_Race;
import information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.GovMon.HMDARac.HMDA_Race_Designation;
import information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.Military_Service;
import information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.Residence;
import information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.Cou.Counseling_Event;
import information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.CurInc.Current_Income_Item;
import information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.Dec.Declaration_Explanation;
import information.dU34.Mes.DocSet.Doc.Signatory;
import information.dU34.common.Property_Detail;
import information.uCD33.Mes.DocSet.Doc.Relationship;
import information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Loa.Loan_Identifier;
import information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Loa.Adj.IntRatAdj.Index_Rule;
import information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Loa.Adj.IntRatAdj.Interest_Rate_Lifetime_Adjustment_Rule;
import information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Loa.Adj.IntRatAdj.Interest_Rate_Per_Change_Adjustment_Rule;
import information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Loa.Buy.Buydown_Occurrence;
import information.uCD33.Mes.DocSet.Doc.DeaSet.Dea.Par.Ind.ConPoi.Contact_Point_Telephone;
import information.uLDD30.Mes.About_Version;
import information.uLDD30.Mes.DeaSets.DeaSet.Dea.Loa.Investor_Feature;
import information.uLDD30.Mes.DeaSets.DeaSet.Dea.Par.Taxpayer_Identifier;
import information.uLDD30.Mes.DeaSets.DeaSet.Dea.Par.Rols.Rol.Bor.GovMon.Ext.Oth.GovMonExt.HMDA_Ethnicity;
import information.uLDD30.Mes.DeaSets.DeaSet.Dea.Par.Rols.Rol.Bor.GovMon.Ext.Oth.GovMonExt.HMDA_Ethnicity_Origin;
import output.PrintError;
import read.FileReader;
import read.JSONReader;
import read.XMLReader;
import specification.dU34.Enumeration;
import validation.ComputeError;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import common.ArrayListOwner;
import common.Interpret;
import common.Utility;


public class Interpreter extends interpretation.Interpreter implements Interpret{
	List<String> errorList = new ArrayList<String>();
	Message fileObject = new information.dU34.Message();
		
	public Interpreter(){}

	@Override
	public FileObject interpret(File subject) {
		String mode = "XML";
		FileReader fileReader = null;
		Document document;
		NodeList nodeList;
		Node currentNode;
		Node parentNode;
		Boolean messageFound = false;
		
		//fileReader reads XML
		if(mode == "XML")
		{
			fileReader = new XMLReader();
		}
		//fileReader reads JSON
		else if(mode == "JSON")
		{
			fileReader = new JSONReader();
		}
		
		//fileReader returns file information in a traversable format
		document = fileReader.readFile(subject);
		
		if(document == null)
			errorList.add(PrintError.couldNotReadFile());
		else
		{
			nodeList = document.getChildNodes();
			
			//check child nodes:
			for(int x = 0; x < nodeList.getLength(); x++){
				currentNode = nodeList.item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(matchMessage(currentNode))
						messageFound = true;
					else
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Root"));
				}
			}
		}
		
		
			//if Message was not found
			if(!messageFound)
				//report error
				errorList.add(PrintError.missing("Message"));
		
		return (FileObject) fileObject;
	}
	
	public boolean matchMessage(Node currentNode)
	{
		boolean result = true;
		
		//check if node is "Message"
		if(currentNode.getNodeName().toLowerCase().equals("message".toLowerCase())){
			Node parentNode = currentNode; 
			
			//check child nodes:
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//@MISMOReferenceModelIdentifier
					if(currentNode.getNodeName().toLowerCase().equals("MISMOReferenceModelIdentifier".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("MISMOReferenceModelIdentifier"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getMISMOReferenceModelIdentifier().contains(currentNode.getFirstChild().getNodeValue())){
							//set HousingExpenseTimingType
							fileObject.setMISMOReferenceModelIdentifier(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getMISMOReferenceModelIdentifier()));
					}
					//@xmlns
					else if(currentNode.getNodeName().toLowerCase().equals("xmlns".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("xmlns"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getXmlns().contains(currentNode.getFirstChild().getNodeValue())){
							//set xmlns
							fileObject.setXmlns(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getXmlns()));
					}
					//@xmlns:xsi
					else if(currentNode.getNodeName().toLowerCase().equals("xmlns:xsi".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("xmlns:xsi"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getXmlnsxsi().contains(currentNode.getFirstChild().getNodeValue())){
							//set xmlns
							fileObject.setXmlnsxsi(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getXmlnsxsi()));
					}
					//@xmlns:ULAD
					else if(currentNode.getNodeName().toLowerCase().equals("xmlns:ULAD".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("xmlns:ULAD"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getXmlnsULAD().contains(currentNode.getFirstChild().getNodeValue())){
							//set xmlnsULAD
							fileObject.setXmlnsULAD(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getXmlnsULAD()));
					}
					//@xmlns:DU
					else if(currentNode.getNodeName().toLowerCase().equals("xmlns:DU".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("xmlns:DU"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getXmlnsDU().contains(currentNode.getFirstChild().getNodeValue())){
							//set xmlnsDU
							fileObject.setXmlnsDU(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getXmlnsDU()));
					}
					//@xmlns:xlink
					else if(currentNode.getNodeName().toLowerCase().equals("xmlns:xlink".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("xmlns:xlink"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getXmlnsDU().contains(currentNode.getFirstChild().getNodeValue())){
							//set xmlnsxlink
							fileObject.setXmlnsxlink(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getXmlnsxlink()));
					}
					else if(!matchAbout_Versions(currentNode))
							if(!matchDocument_Sets(currentNode))
								if(!matchDeal_Sets(currentNode))
									//report error
									errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Message"));
				}
			}
		}
		//else
		else
			result = false;
		
		return result;
	}
	
	public boolean matchAbout_Versions(Node currentNode)
	{
		boolean result = true;
		
		//about_Versions
		if(currentNode.getNodeName().toLowerCase().equals("about_Versions".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchAbout_Version(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "About_Versions"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchAbout_Version(Node currentNode)
	{
		boolean result = true;
		
		//about_Version
		if(currentNode.getNodeName().toLowerCase().equals("about_Version".toLowerCase())){
			//create Java object
			fileObject.getAbout_Versions().add(new About_Version());
			Node parentNode = currentNode;
										
			//check child nodes
			for(int z = 0; z < parentNode.getChildNodes().getLength(); z++){
				currentNode = parentNode.getChildNodes().item(z);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//CreatedDateTime
					if(currentNode.getNodeName().toLowerCase().equals("createdDateTime".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("createdDateTime"));
						}
						//if node information is a date time value
						else if(ComputeError.isDateTime(currentNode.getFirstChild().getNodeValue()))
							((About_Version) fileObject.getLast("About_Version")).setCreatedDatetime(Utility.setDateTime(currentNode.getFirstChild().getNodeValue()));
						else
							//report error
							errorList.add(PrintError.notADateTime(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue()));
					}
					else
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "About_Version"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchDeal_Sets(Node currentNode)
	{
		boolean result = true;
		
		//deal_Sets
		if(currentNode.getNodeName().toLowerCase().equals("deal_Sets".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchDeal_Set(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "deal_Sets"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchDeal_Set(Node currentNode)
	{
		boolean result = true;
		
		//deal_Set
		if(currentNode.getNodeName().toLowerCase().equals("deal_Set".toLowerCase())){
			//create Java object
			fileObject.getDeal_Sets().add(new Deal_Set());
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchDeals(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Deal_Set"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
			
	public boolean matchDeals(Node currentNode)
	{
		boolean result = true;
		
		//deals
		if(currentNode.getNodeName().toLowerCase().equals("deals".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchDeal(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Deals"));
				}
			}
		}
		else
			result = false;
		
		
		return result;
	}
	
	public boolean matchDeal(Node currentNode)
	{
		boolean result = true;
		
		//deal
		if(currentNode.getNodeName().toLowerCase().equals("deal".toLowerCase())){
			//create Java object
			((Deal_Set) fileObject.getLast("Deal_Set")).getDeals().add(new Deal());
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//xsi:type
					if(currentNode.getNodeName().toLowerCase().equals("xsi:type".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("xsi:type"));
						}
						//if node information is a string in length from 1 to 1000
						else if(ComputeError.isWithinStringLength(currentNode.getFirstChild().getNodeValue(),1,1000)){
							//get last Deal_Set, get last Deal, get last Relationship, set xsi:type
							((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).setXsitype(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.stringLengthOutsideRange(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(),1,1000));
					}
					else if(!matchAssets(currentNode))
						if(!matchCollaterals(currentNode))
							if(!matchExpenses(currentNode))
								if(!matchLiabilities(currentNode))
									if(!matchLoans(currentNode))
										if(!matchParties(currentNode))
											if(!matchRelationships(currentNode))
												//report error
												errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Deal"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchAssets(Node currentNode)
	{
		boolean result = true;
		
		//assets
		if(currentNode.getNodeName().toLowerCase().equals("assets".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchAsset(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Assets"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchAsset(Node currentNode)
	{
		boolean result = true;
		
		//asset
		if(currentNode.getNodeName().toLowerCase().equals("asset".toLowerCase())){
			//create Java object
			((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getAssets().add(new Asset());
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//SequenceNumber
					if(currentNode.getNodeName().toLowerCase().equals("SequenceNumber".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("SequenceNumber"));
						}
						//if a Positive Numeric String of 1 to 2
						else if(isPositiveInteger(currentNode,1,2)){
							//get last Deal_Set, get last Deal, get Asset, set SequenceNumber
							((Asset) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Asset")).setSequenceNumber(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isPositiveInteger
					}
					//xlink:label
					else if(currentNode.getNodeName().toLowerCase().equals("xlink:label".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("xlink:label"));
						}
						//if node information is a string in length from 1 to 1000
						else if(ComputeError.isWithinStringLength(currentNode.getFirstChild().getNodeValue(),1,1000)){
							//get last Deal_Set, get last Deal, get Asset, set xlink:label
							((Asset) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Asset")).setXlinklabel(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.stringLengthOutsideRange(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(),1,1000));
					}
					else if(!matchAsset_Detail(currentNode))
							if(!matchAsset_Holder(currentNode))
								if(!matchOwned_Property(currentNode))
									//report error
									errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Asset"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchAsset_Detail(Node currentNode)
	{
		boolean result = true;
		
		//Asset_Detail
		if(currentNode.getNodeName().toLowerCase().equals("Asset_Detail".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
			
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//extension
					if(!matchAsset_DetailExtension(currentNode))
						//assetAccountIdentifier
						if(currentNode.getNodeName().toLowerCase().equals("AssetAccountIdentifier".toLowerCase())){
							//check if value is empty
							if(currentNode.getFirstChild() == null){
								errorList.add(PrintError.missing("AssetAccountIdentifier"));
							}
							//if node information is a string in length from 1 to 30
							else if(ComputeError.isWithinStringLength(currentNode.getFirstChild().getNodeValue(),1,30)){
								//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get Assets, then the Asset_Detail //set AssetAccountIdentifier
								((Asset) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Asset")).getAsset_Detail().setAssetAccountIdentifier(currentNode.getFirstChild().getNodeValue());
							}
							else
								//report error
								errorList.add(PrintError.stringLengthOutsideRange(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(),1,30));
						}
						//AssetCashOrMarketValueAmount
						else if(currentNode.getNodeName().toLowerCase().equals("AssetCashOrMarketValueAmount".toLowerCase())){
							//check if value is empty
							if(currentNode.getFirstChild() == null){
								errorList.add(PrintError.missing("AssetCashOrMarketValueAmount"));
							}
							//if node information is a positive amount of money
							else if(isPositiveMoney(currentNode, 12, 2)){
								//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get Assets, then the Asset_Detail //set AssetCashOrMarketValueAmount
								((Asset) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Asset")).getAsset_Detail().setAssetCashOrMarketValueAmount(currentNode.getFirstChild().getNodeValue());
							}
							//error reporting happens in isPositiveMoney
						}
						//assetType
						else if(currentNode.getNodeName().toLowerCase().equals("AssetType".toLowerCase())){
							//check if value is empty
							if(currentNode.getFirstChild() == null){
								errorList.add(PrintError.missing("AssetType"));
							}
							//if node information is an expected enumeration
							else if(Enumeration.getAssetType().contains(currentNode.getFirstChild().getNodeValue())){
								//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get Assets, then the Asset_Detail //set AssetType
								((Asset) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Asset")).getAsset_Detail().setAssetType(currentNode.getFirstChild().getNodeValue());
							}
							else
								//report error
								errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getAssetType()));
						}
						//assetTypeOtherDescription
						else if(currentNode.getNodeName().toLowerCase().equals("AssetTypeOtherDescription".toLowerCase())){
							//check if value is empty
							if(currentNode.getFirstChild() == null){
								errorList.add(PrintError.missing("AssetTypeOtherDescription"));
							}
							//if node information is an expected enumeration
							else if(Enumeration.getAssetTypeOtherDescription().contains(currentNode.getFirstChild().getNodeValue())){
								//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get Assets, then the Asset_Detail //set AssetTypeOtherDescription
								((Asset) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Asset")).getAsset_Detail().setAssetTypeOtherDescription(currentNode.getFirstChild().getNodeValue());
							}
							else
								//report error
								errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getAssetTypeOtherDescription()));
						}
						//fundsSourceType
						else if(currentNode.getNodeName().toLowerCase().equals("FundsSourceType".toLowerCase())){
							//check if value is empty
							if(currentNode.getFirstChild() == null){
								errorList.add(PrintError.missing("FundsSourceType"));
							}
							//if node information is an expected enumeration
							else if(Enumeration.getFundsSourceType().contains(currentNode.getFirstChild().getNodeValue())){
								//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get Assets, then the Asset_Detail //set FundsSourceType
								((Asset) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Asset")).getAsset_Detail().setFundsSourceType(currentNode.getFirstChild().getNodeValue());
							}
							else
								//report error
								errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getFundsSourceType()));
						}
						//fundsSourceTypeOtherDescription
						else if(currentNode.getNodeName().toLowerCase().equals("FundsSourceTypeOtherDescription".toLowerCase())){
							//check if value is empty
							if(currentNode.getFirstChild() == null){
								errorList.add(PrintError.missing("FundsSourceTypeOtherDescription"));
							}
							//if node information is an expected enumeration
							else if(Enumeration.getFundsSourceTypeOtherDescription().contains(currentNode.getFirstChild().getNodeValue())){
								//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get Assets, then the Asset_Detail //set FundsSourceTypeOtherDescription
								((Asset) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Asset")).getAsset_Detail().setFundsSourceTypeOtherDescription(currentNode.getFirstChild().getNodeValue());
							}
							else
								//report error
								errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getFundsSourceTypeOtherDescription()));
						}
						else
							//report error
							errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Asset_Detail"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchAsset_DetailExtension(Node currentNode)
	{
		boolean result = true;
		
		//Extension
		if(currentNode.getNodeName().toLowerCase().equals("Extension".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchAsset_DetailExtensionOther(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Extension"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}

	public boolean matchAsset_DetailExtensionOther(Node currentNode)
	{
		boolean result = true;
		
		//Other
		if(currentNode.getNodeName().toLowerCase().equals("Other".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchAsset_Detail_Extension(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Other"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}

	public boolean matchAsset_Detail_Extension(Node currentNode)
	{
		boolean result = true;
		
		//ULAD:Asset_Detail_Extension
		if(currentNode.getNodeName().toLowerCase().equals("ULAD:Asset_Detail_Extension".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//IncludedInAssetAccountIndicator
					if(currentNode.getNodeName().toLowerCase().equals("ULAD:IncludedInAssetAccountIndicator".toLowerCase())){
						//if node information is a boolean
						if(ComputeError.isBoolean(currentNode.getFirstChild().getNodeValue())){
							//check if value is empty
							if(currentNode.getFirstChild() == null){
								errorList.add(PrintError.missing("ULAD:IncludedInAssetAccountIndicator"));
							}
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get Assets, then the Asset_Detail, get Extension, get Other, then get ASSET_DETAIL_EXTENSION //set IncludedInAssetAccountIndicator
							else if(currentNode.getFirstChild().getNodeValue().toLowerCase() == "true")
								((Asset) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Asset")).getAsset_Detail().getExtension().getOther().getAsset_Detail_Extension().setIncludedInAssetAccountIndicator(true);
							else if(currentNode.getFirstChild().getNodeValue().toLowerCase() == "false")
								((Asset) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Asset")).getAsset_Detail().getExtension().getOther().getAsset_Detail_Extension().setIncludedInAssetAccountIndicator(false);
						}
						else{
							//report error
							errorList.add(PrintError.notABoolean(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue()));
						}
					}
					else
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "ULAD:Asset_Detail_Extension"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}

	public boolean matchAsset_Holder(Node currentNode)
	{
		boolean result = true;
		
		//Asset_Holder
		if(currentNode.getNodeName().toLowerCase().equals("Asset_Holder".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchAssetHolderName(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Asset_Holder"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchAssetHolderName(Node currentNode)
	{
		boolean result = true;
		
		//Name
		if(currentNode.getNodeName().toLowerCase().equals("Name".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//FullName
					if(currentNode.getNodeName().toLowerCase().equals("FullName".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("Asset_Holder/Name/FullName"));
						}
						//if node information is string of length 1 to 150
						else if(ComputeError.isWithinStringLength(currentNode.getFirstChild().getNodeValue(),1,150)){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get Assets, then the Asset_Holder, get Name  //set FullName
							((Asset) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Asset")).getAsset_Holder().getName().setFullName(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.stringLengthOutsideRange(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(),1,150, "Asset_Holder/Name/"));
					}
					else
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Asset_Holder/Name/"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchOwned_Property(Node currentNode)
	{
		boolean result = true;
		
		//Owned_Property
		if(currentNode.getNodeName().toLowerCase().equals("Owned_Property".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchOwned_PropertyProperty(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Owned_Property"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchOwned_PropertyProperty(Node currentNode)
	{
		boolean result = true;
		
		//Property
		if(currentNode.getNodeName().toLowerCase().equals("Property".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchOwned_PropertyPropertyAddress(currentNode))
						if(!matchOwned_PropertyPropertyProperty_Detail(currentNode))
							if(!matchOwned_PropertyPropertyProperty_Valuations(currentNode))
								if(!matchOwned_PropertyPropertySales_Contracts(currentNode))
									//report error
									errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Owned_Property/Property/"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchOwned_PropertyPropertyAddress(Node currentNode)
	{
		boolean result = true;
		
		//Address
		if(currentNode.getNodeName().toLowerCase().equals("Address".toLowerCase())){
			Node parentNode = currentNode;
	
			//start matching
				//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//AddressLineText
					if(currentNode.getNodeName().toLowerCase().equals("AddressLineText".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("AddressLineText"));
						}
						//if node information is string in length from 1 to 35
						else if(ComputeError.isWithinStringLength(currentNode.getFirstChild().getNodeValue(),1,35)){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get Assets, then the last Property //get Address //set AddressLineText
							((Asset) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Asset")).getOwned_Property().getProperty().getAddress().setAddressLineText(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.stringLengthOutsideRange(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(),1,35,"Owned_Property/Property/Address"));
					}
					//AddressUnitIdentifier
					else if(currentNode.getNodeName().toLowerCase().equals("AddressUnitIdentifier".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("AddressUnitIdentifier"));
						}
						//if node information is a string in length from 1 to 11
						else if(ComputeError.isWithinStringLength(currentNode.getFirstChild().getNodeValue(),1,11)){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get Assets, then the last Property //get Address //set AddressUnitIdentifier
							((Asset) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Asset")).getOwned_Property().getProperty().getAddress().setAddressUnitIdentifier(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.stringLengthOutsideRange(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(),1,11,"Owned_Property/Property/Address"));
					}
					//CityName
					else if(currentNode.getNodeName().toLowerCase().equals("CityName".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("CityName"));
						}
						//if node information is a string in length from 1 to 35
						else if(ComputeError.isWithinStringLength(currentNode.getFirstChild().getNodeValue(),1,35)){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get Assets, then the last Property //get Address //set CityName
							((Asset) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Asset")).getOwned_Property().getProperty().getAddress().setCityName(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.stringLengthOutsideRange(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(),1,35,"Owned_Property/Property/Address"));
					}
					//PostalCode
					else if(currentNode.getNodeName().toLowerCase().equals("PostalCode".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("PostalCode"));
						}
						//if node information is a string in length from 1 to 9
						else if(ComputeError.isWithinStringLength(currentNode.getFirstChild().getNodeValue(),1,9)){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get Assets, then the last Property //get Address //set PostalCode
							((Asset) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Asset")).getOwned_Property().getProperty().getAddress().setPostalCode(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.stringLengthOutsideRange(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(),1,9,"Owned_Property/Property/Address"));
					}
					//StateCode
					else if(currentNode.getNodeName().toLowerCase().equals("StateCode".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("StateCode"));
						}
						//if node information is a string in length from 1 to 2
						else if(ComputeError.isWithinStringLength(currentNode.getFirstChild().getNodeValue(),1,2)){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get Assets, then the last Property //get Address //set StateCode
							((Asset) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Asset")).getOwned_Property().getProperty().getAddress().setStateCode(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.stringLengthOutsideRange(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(),1,2,"Owned_Property/Property/Address"));
					}
					else
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(),"Owned_Property/Property/Address"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchOwned_PropertyPropertyProperty_Detail(Node currentNode)
	{
		boolean result = true;
		
		//Property_Detail
		if(currentNode.getNodeName().toLowerCase().equals("Property_Detail".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//ownedPropertyDispositionStatusType; //Enumeration
					if(currentNode.getNodeName().toLowerCase().equals("OwnedPropertyDispositionStatusType".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("Owned_Property/Property/Property_Detail/OwnedPropertyDispositionStatusType"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getOwnedPropertyDispositionStatusType().contains(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set, get Deals, then the last Deal, get Assets, then the last Property , get Property_Detail, set OwnedPropertyDispositionStatusType
							((Asset) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Asset")).getOwned_Property().getProperty().getProperty_Detail().setOwnedPropertyDispositionStatusType(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getOwnedPropertyDispositionStatusType(), "Owned_Property/Property/Property_Detail/"));
					}
					//ownedPropertyLienUPBAmount;
					else if(currentNode.getNodeName().toLowerCase().equals("OwnedPropertyLienUPBAmount".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("Owned_Property/Property/Property_Detail/OwnedPropertyLienUPBAmount"));
						}
						//if node information is a positive amount of money
						else if(isPositiveMoney(currentNode, 12, 2, "Owned_Property/Property/Property_Detail/")){
							//get Deal_Sets, then the last Deal_Set, get Deals, then the last Deal, get Assets, then the last Property , get Property_Detail, set LiabilityUnpaidBalanceAmount
							((Asset) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Asset")).getOwned_Property().getProperty().getProperty_Detail().setOwnedPropertyLienUPBAmount(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isPositiveMoney
					}
					//ownedPropertyMaintenanceExpenseAmount;
					else if(currentNode.getNodeName().toLowerCase().equals("OwnedPropertyMaintenanceExpenseAmount".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("Owned_Property/Property/Property_Detail/OwnedPropertyMaintenanceExpenseAmount"));
						}
						//if node information is a positive amount of money
						else if(isPositiveMoney(currentNode, 12, 2, "Owned_Property/Property/Property_Detail/")){
							//get Deal_Sets, then the last Deal_Set, get Deals, then the last Deal, get Assets, then the last Property , get Property_Detail, set OwnedPropertyMaintenanceExpenseAmount
							((Asset) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Asset")).getOwned_Property().getProperty().getProperty_Detail().setOwnedPropertyMaintenanceExpenseAmount(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isPositiveMoney
					}
					//ownedPropertyRentalIncomeGrossAmount;
					else if(currentNode.getNodeName().toLowerCase().equals("OwnedPropertyRentalIncomeGrossAmount".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("Owned_Property/Property/Property_Detail/OwnedPropertyRentalIncomeGrossAmount"));
						}
						//if node information is a positive amount of money
						else if(isPositiveMoney(currentNode, 12, 2, "Owned_Property/Property/Property_Detail/")){
							//get Deal_Sets, then the last Deal_Set, get Deals, then the last Deal, get Assets, then the last Property , get Property_Detail, set OwnedPropertyRentalIncomeGrossAmount
							((Asset) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Asset")).getOwned_Property().getProperty().getProperty_Detail().setOwnedPropertyRentalIncomeGrossAmount(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isPositiveMoney
					}
					//ownedPropertyRentalIncomeNetAmount; //+-
					else if(currentNode.getNodeName().toLowerCase().equals("OwnedPropertyRentalIncomeNetAmount".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("Owned_Property/Property/Property_Detail/OwnedPropertyRentalIncomeNetAmount"));
						}
						//if node information is an amount of money
						else if(isMoney(currentNode, 12, 2, "Owned_Property/Property/Property_Detail/")){
							//get Deal_Sets, then the last Deal_Set, get Deals, then the last Deal, get Assets, then the last Property , get Property_Detail, set OwnedPropertyRentalIncomeNetAmount
							((Asset) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Asset")).getOwned_Property().getProperty().getProperty_Detail().setOwnedPropertyRentalIncomeNetAmount(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isPositiveMoney
					}
					//OwnedPropertySubjectIndicator
					else if(currentNode.getNodeName().toLowerCase().equals("OwnedPropertySubjectIndicator".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("Owned_Property/Property/Property_Detail/OwnedPropertySubjectIndicator"));
						}
						//if node information is a boolean
						else if(ComputeError.isBoolean(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set, get Deals, then the last Deal, get Assets, then the last Property , get Property_Detail, set OwnedPropertySubjectIndicator
							if(currentNode.getFirstChild().getNodeValue().toLowerCase() == "true")
								((Asset) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Asset")).getOwned_Property().getProperty().getProperty_Detail().setOwnedPropertySubjectIndicator(true);
							else if(currentNode.getFirstChild().getNodeValue().toLowerCase() == "false")
								((Asset) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Asset")).getOwned_Property().getProperty().getProperty_Detail().setOwnedPropertySubjectIndicator(false);
						}
						else
							//report error
							errorList.add(PrintError.notABoolean(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), "Owned_Property/Property/Property_Detail/"));
					}
					//PropertyCurrentUsageType
					else if(currentNode.getNodeName().toLowerCase().equals("PropertyCurrentUsageType".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("Owned_Property/Property/Property_Detail/PropertyCurrentUsageType"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getPropertyCurrentUsageType().contains(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set, get Deals, then the last Deal, get Assets, then the last Property , get Property_Detail, set PropertyCurrentUsageType
							((Asset) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Asset")).getOwned_Property().getProperty().getProperty_Detail().setPropertyCurrentUsageType(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getPropertyCurrentUsageType(), "Owned_Property/Property/Property_Detail/"));
					}
					//PropertyEstimatedValueAmount
					else if(currentNode.getNodeName().toLowerCase().equals("PropertyEstimatedValueAmount".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("Owned_Property/Property/Property_Detail/PropertyEstimatedValueAmount"));
						}
						//if node information is a positive amount of money
						else if(isPositiveMoney(currentNode, 12, 2, "Owned_Property/Property/Property_Detail/")){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get Assets, then the last Property //get Property_Detail //set PropertyEstimatedValueAmount
							((Asset) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Asset")).getOwned_Property().getProperty().getProperty_Detail().setPropertyEstimatedValueAmount(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isPositiveMoney
					}
					else
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Owned_Property/Property/Property_Detail/"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchOwned_PropertyPropertySales_Contract_Detail(Node currentNode)
	{
		boolean result = true;
		
		//Sales_Contract_Detail
		if(currentNode.getNodeName().toLowerCase().equals("Sales_Contract_Detail".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//SalesContractAmount
					if(currentNode.getNodeName().toLowerCase().equals("SalesContractAmount".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("SalesContractAmount"));
						}
						//if node information is a positive amount of money
						else if(isPositiveMoney(currentNode, 12, 2, "Owned_Property/Property/Sales_Contracts/Sales_Contract/Sales_Contract_Detail")){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get Assets, then the last Property //get Sales_Contracts, then the last Sales_Contract //set SalesContractAmount
							((Sales_Contract) ((Asset) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Asset")).getOwned_Property().getProperty().getLast("Sales_Contract")).getSales_Contract_Detail().setSalesContractAmount(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isPositiveMoney
					}	
					else
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Owned_Property/Property/Sales_Contracts/Sales_Contract/Sales_Contract_Detail"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchOwned_PropertyPropertyProperty_Valuations(Node currentNode)
	{
		boolean result = true;
		
		//Property_Valuations
		if(currentNode.getNodeName().toLowerCase().equals("Property_Valuations".toLowerCase())){
			//create Java object
			((Asset) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Asset")).getOwned_Property().getProperty().getProperty_Valuations().add(new information.dU34.Mes.DeaSet.Dea.Ass.OwnPro.Pro.Property_Valuation());
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchOwned_PropertyPropertyProperty_Valuation(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Owned_Property/Property/Property_Valuations/"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchOwned_PropertyPropertyProperty_Valuation(Node currentNode)
	{
		boolean result = true;
		
		//Property_Valuation
		if(currentNode.getNodeName().toLowerCase().equals("Property_Valuation".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchOwned_PropertyPropertyProperty_Valuation_Detail(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Owned_Property/Property/Property_Valuations/Property_Valuation/"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchOwned_PropertyPropertyProperty_Valuation_Detail(Node currentNode)
	{
		boolean result = true;
		
		//Property_Valuation_Detail
		if(currentNode.getNodeName().toLowerCase().equals("Property_Valuation_Detail".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//PropertyValuationAmount
					if(currentNode.getNodeName().toLowerCase().equals("PropertyValuationAmount".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("Owned_Property/Property/Property_Valuations/Property_Valuation/Property_Valuation_Detail/PropertyValuationAmount"));
						}
						//if node information is a positive amount of money
						else if(isPositiveMoney(currentNode, 12, 2, "Owned_Property/Property/Property_Valuations/Property_Valuation/Property_Valuation_Detail/")){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get Assets, then the last Property //get Property_Valuations, then the last Property_Valuation //set PropertyValuationAmount
							((information.dU34.Mes.DeaSet.Dea.Ass.OwnPro.Pro.Property_Valuation) ((Asset) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Asset")).getOwned_Property().getProperty().getLast("Property_Valuation")).getProperty_Valuation_Detail().setPropertyValuationAmount(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isPositiveMoney
					}
					else
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Owned_Property/Property/Property_Valuations/Property_Valuation/Property_Valuation_Detail/"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchOwned_PropertyPropertySales_Contracts(Node currentNode)
	{
		boolean result = true;
		
		//Sales_Contracts
		if(currentNode.getNodeName().toLowerCase().equals("Sales_Contracts".toLowerCase())){
			//create Java object
			((Asset) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Asset")).getOwned_Property().getProperty().getSales_Contracts().add(new Sales_Contract());
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchOwned_PropertyPropertySales_Contract(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Owned_Property/Property/Sales_Contracts"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchOwned_PropertyPropertySales_Contract(Node currentNode)
	{
		boolean result = true;
		
		//Sales_Contract
		if(currentNode.getNodeName().toLowerCase().equals("Sales_Contract".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchOwned_PropertyPropertySales_Contract_Detail(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Owned_Property/Property/Sales_Contracts/Sales_Contract"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchCollaterals(Node currentNode)
	{
		boolean result = true;
		
		//Collaterals
		if(currentNode.getNodeName().toLowerCase().equals("Collaterals".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchCollateral(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Collaterals"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchCollateral(Node currentNode)
	{
		boolean result = true;
		
		//Collateral
		if(currentNode.getNodeName().toLowerCase().equals("Collateral".toLowerCase())){
			//create Java object
			((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getCollaterals().add(new Collateral());
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchSubject_Property(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Collateral"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchSubject_Property(Node currentNode)
	{
		boolean result = true;
		
		//Collateral
		if(currentNode.getNodeName().toLowerCase().equals("Subject_Property".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchSubject_PropertyAddress(currentNode))
						if(!matchLocation_Identifier(currentNode))
							if(!matchProperty_Detail(currentNode))
								if(!matchProperty_Valuations(currentNode))
									if(!matchProject(currentNode))
										if(!matchSales_Contracts(currentNode))
											//report error
											errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Subject_Property"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchProperty_Valuations(Node currentNode)
	{
		boolean result = true;
		
		//Property_Valuations
		if(currentNode.getNodeName().toLowerCase().equals("Property_Valuations".toLowerCase())){
			//create Java object
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchProperty_Valuation(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Subject_Property/Property_Valuations/"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchProperty_Valuation(Node currentNode)
	{
		boolean result = true;
		
		//Property_Valuation
		if(currentNode.getNodeName().toLowerCase().equals("Property_Valuation".toLowerCase())){
			//create Java object
			((Collateral) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Collateral")).getSubject_Property().getProperty_Valuations().add(new Property_Valuation());
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchProperty_Valuation_Detail(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Subject_Property/Property_Valuations/Property_Valuation/"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchProperty_Valuation_Detail(Node currentNode)
	{
		boolean result = true;
		
		//Property_Valuation_Detail
		if(currentNode.getNodeName().toLowerCase().equals("Property_Valuation_Detail".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//AppraisalIdentifier
					if(currentNode.getNodeName().toLowerCase().equals("AppraisalIdentifier".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("Subject_Property/Property_Valuations/Property_Valuation/Property_Valuation_Detail/AppraisalIdentifier"));
						}
						//if a Positive Numeric String of 1 to 50
						else if(isPositiveInteger(currentNode,1,50, "Subject_Property/Property_Valuations/Property_Valuation/Property_Valuation_Detail/")){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Borrower, get last License, get License_Detail, set AppraisalIdentifier
							((Property_Valuation) ( (Collateral) ( (Deal) ( (Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Collateral")).getSubject_Property().getLast("Property_Valuation")).getProperty_Valuation_Detail().setAppraisalIdentifier(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isPositiveInteger
					}		
					//PropertyValuationAmount
					else if(currentNode.getNodeName().toLowerCase().equals("PropertyValuationAmount".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("Subject_Property/Property_Valuations/Property_Valuation/Property_Valuation_Detail/PropertyValuationAmount"));
						}
						//if node information is a positive amount of money
						else if(isPositiveMoney(currentNode, 12, 2, "Subject_Property/Property_Valuations/Property_Valuation/Property_Valuation_Detail/")){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Borrower, get last License, get License_Detail, set PropertyValuationAmount
							((Property_Valuation) ( (Collateral) ( (Deal) ( (Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Collateral")).getSubject_Property().getLast("Property_Valuation")).getProperty_Valuation_Detail().setPropertyValuationAmount(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isPositiveMoney
					}
					else
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Subject_Property/Property_Valuations/Property_Valuation/Property_Valuation_Detail/"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchProject(Node currentNode)
	{
		boolean result = true;
		
		//Project
		if(currentNode.getNodeName().toLowerCase().equals("Project".toLowerCase())){
			//create Java object
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchProject_Detail(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Project"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchProject_Detail(Node currentNode)
	{
		boolean result = true;
		
		//Project_Detail
		if(currentNode.getNodeName().toLowerCase().equals("Project_Detail".toLowerCase())){
			//create Java object
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//ProjectDesignType
					if(currentNode.getNodeName().toLowerCase().equals("ProjectDesignType".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("ProjectDesignType"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getProjectDesignType().contains(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get Collaterals, then the last Collateral, get Subject_Property, get Project, Project_Detail //set ProjectDesignType
							( (Collateral) ( (Deal) ( (Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Collateral")).getSubject_Property().getProject().getProject_Detail().setProjectDesignType(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getProjectDesignType()));
					}	
					//ProjectLegalStructureType
					else if(currentNode.getNodeName().toLowerCase().equals("ProjectLegalStructureType".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("ProjectLegalStructureType"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getProjectLegalStructureType().contains(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get Collaterals, then the last Collateral, get Subject_Property, get Project, Project_Detail //set ProjectLegalStructureType
							( (Collateral) ( (Deal) ( (Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Collateral")).getSubject_Property().getProject().getProject_Detail().setProjectLegalStructureType(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getProjectLegalStructureType()));
					}	
					else
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Project_Detail"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchSales_Contracts(Node currentNode)
	{
		boolean result = true;
		
		//Property_Valuations
		if(currentNode.getNodeName().toLowerCase().equals("Sales_Contracts".toLowerCase())){
			//create Java object
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchSales_Contract(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Subject_Property/Sales_Contracts/"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchSales_Contract(Node currentNode)
	{
		boolean result = true;
		
		//Property_Valuation
		if(currentNode.getNodeName().toLowerCase().equals("Sales_Contract".toLowerCase())){
			//create Java object
			((Collateral) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Collateral")).getSubject_Property().getSales_Contracts().add(new Sales_Contract());
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchSales_Concessions(currentNode))
						if(!matchSales_Contract_Detail(currentNode))
							//report error
							errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Subject_Property/Sales_Contracts/Sales_Contract/"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchSales_Concessions(Node currentNode)
	{
		boolean result = true;
		
		//Property_Valuation
		if(currentNode.getNodeName().toLowerCase().equals("Sales_Concessions".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchSales_Concession(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Subject_Property/Sales_Contracts/Sales_Contract/Sales_Concessions/"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchSales_Concession(Node currentNode)
	{
		boolean result = true;
		
		//Property_Valuation_Detail
		if(currentNode.getNodeName().toLowerCase().equals("Sales_Concession".toLowerCase())){
			//Create Java Object
			((Sales_Contract) ((Collateral) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Collateral")).getSubject_Property().getLast("Sales_Contract")).getSales_Concessions().add(new Sales_Concession());
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//SalesConcessionAmount
					if(currentNode.getNodeName().toLowerCase().equals("SalesConcessionAmount".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("Subject_Property/Property_Valuations/Property_Valuation/Property_Valuation_Detail/SalesConcessionAmount"));
						}
						//if node information is a positive amount of money
						else if(isPositiveMoney(currentNode, 12, 2, "Subject_Property/Sales_Contracts/Sales_Contract/Sales_Concessions/Sales_Concession/")){
							//get last Deal_Set, get last Deal, get last Collateral, get Subject_Property, get last Sales_Contract, get Sales_Concession, set SalesConcessionAmount
							((Sales_Concession) ((Sales_Contract) ((Collateral) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Collateral")).getSubject_Property().getLast("Sales_Contract")).getLast("Sales_Concession")).setSalesConcessionAmount(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isPositiveMoney
					}
					else
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Subject_Property/Sales_Contracts/Sales_Contract/Sales_Concessions/Sales_Concession/"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchSales_Contract_Detail(Node currentNode)
	{
		boolean result = true;
		
		//Property_Valuation_Detail
		if(currentNode.getNodeName().toLowerCase().equals("Sales_Contract_Detail".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//SalesContractAmount
					if(currentNode.getNodeName().toLowerCase().equals("SalesContractAmount".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("Subject_Property/Sales_Contracts/Sales_Contract/Sales_Contract_Detail/SalesContractAmount"));
						}
						//if node information is a positive amount of money
						else if(isPositiveMoney(currentNode, 12, 2, "Subject_Property/Sales_Contracts/Sales_Contract/Sales_Contract_Detail/")){
							//get last Deal_Set, get last Deal, get last Collateral, get Subject_Property, get last Sales_Contract, get Sales_Contract_Detail, set SalesContractAmount
							((Sales_Contract) ((Collateral) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Collateral")).getSubject_Property().getLast("Sales_Contract")).getSales_Contract_Detail().setSalesContractAmount(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isPositiveMoney
					}
					else
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Subject_Property/Sales_Contracts/Sales_Contract/Sales_Contract_Detail/"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
		
	public boolean matchExpenses(Node currentNode)
	{
		boolean result = true;
		
		//Expenses
		if(currentNode.getNodeName().toLowerCase().equals("Expenses".toLowerCase())){
			//create Java object
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//SequenceNumber
					if(currentNode.getNodeName().toLowerCase().equals("SequenceNumber".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("SequenceNumber"));
						}
						//if a Positive Numeric String of 1 to 2
						else if(isPositiveInteger(currentNode,1,2)){
							//get last Deal_Set, get last Deal, get Asset, set SequenceNumber
							((Expense) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Expense")).setSequenceNumber(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isPositiveInteger
					}		
					else if(!matchExpense(currentNode))
							//report error
							errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Expenses"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchExpense(Node currentNode)
	{
		boolean result = true;
		
		//Expense
		if(currentNode.getNodeName().toLowerCase().equals("Expense".toLowerCase())){
			//create Java object
			((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getExpenses().add(new Expense());
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//SequenceNumber
					if(currentNode.getNodeName().toLowerCase().equals("SequenceNumber".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("SequenceNumber"));
						}
						//if a Positive Numeric String of 1 to 2
						else if(isPositiveInteger(currentNode,1,2)){
							//get last Deal_Set, get last Deal, get last Expense, set SequenceNumber
							((Expense) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Expense")).setSequenceNumber(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isPositiveInteger
					}
					//xlink:label
					else if(currentNode.getNodeName().toLowerCase().equals("xlink:label".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("xlink:label"));
						}
						//if node information is a string in length from 1 to 1000
						else if(ComputeError.isWithinStringLength(currentNode.getFirstChild().getNodeValue(),1,1000)){
							//get last Deal_Set, get last Deal, get last Expense, set xlink:label
							((Expense) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Expense")).setXlinklabel(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.stringLengthOutsideRange(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(),1,1000));
					}
					//ExpenseMonthlyPaymentAmount
					else if(currentNode.getNodeName().toLowerCase().equals("ExpenseMonthlyPaymentAmount".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("ExpenseMonthlyPaymentAmount"));
						}
						//if node information is a positive amount of money
						else if(isPositiveMoney(currentNode, 12, 2)){
							//get last Deal_Set, get last Deal, get last Expense, set ExpenseMonthlyPaymentAmount
							((Expense) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Expense")).setExpenseMonthlyPaymentAmount(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isPositiveMoney
					}	
					//ExpenseRemainingTermMonthsCount
					else if(currentNode.getNodeName().toLowerCase().equals("ExpenseRemainingTermMonthsCount".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("ExpenseRemainingTermMonthsCount"));
						}
						//if node information is a positive or zero number
						else if(isPositiveOrZeroInteger(currentNode,1,3)){
							//get last Deal_Set, get last Deal, get last Expense, set ExpenseTypeOtherDescription
							((Expense) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Expense")).setExpenseRemainingTermMonthsCount(Integer.parseInt(currentNode.getFirstChild().getNodeValue()));
						}
						//error reporting happens in isPositiveOrZeroInteger
					}
					//ExpenseType
					else if(currentNode.getNodeName().toLowerCase().equals("ExpenseType".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("ExpenseType"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getExpenseType().contains(currentNode.getFirstChild().getNodeValue())){
							//get last Deal_Set, get last Deal, get last Expense, set ExpenseTypeOtherDescription
							((Expense) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Expense")).setExpenseType(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getExpenseType()));
					}
					//ExpenseTypeOtherDescription
					else if(currentNode.getNodeName().toLowerCase().equals("ExpenseTypeOtherDescription".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("ExpenseTypeOtherDescription"));
						}
						//if node information is string of length 1 to 80
						else if(ComputeError.isWithinStringLength(currentNode.getFirstChild().getNodeValue(),1,80)){
							//get last Deal_Set, get last Deal, get last Expense, set ExpenseTypeOtherDescription
							((Expense) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Expense")).setExpenseTypeOtherDescription(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.stringLengthOutsideRange(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(),1,80));
					}	
					else
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Expense"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchLiabilities(Node currentNode)
	{
		boolean result = true;
		
		//Liabilities
		if(currentNode.getNodeName().toLowerCase().equals("Liabilities".toLowerCase())){
			//create Java object
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchLiability(currentNode))
						if(!matchLiability_Summary(currentNode))
							//report error
							errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Liabilities"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchLiability(Node currentNode)
	{
		boolean result = true;
		
		//Liability
		if(currentNode.getNodeName().toLowerCase().equals("Liability".toLowerCase())){
			//create Java object
			((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLiabilities().add(new Liability());
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//SequenceNumber
					if(currentNode.getNodeName().toLowerCase().equals("SequenceNumber".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("SequenceNumber"));
						}
						//if a Positive Numeric String of 1 to 2
						else if(isPositiveInteger(currentNode,1,2)){
							//get last Deal_Set, get last Deal, get Liability, set SequenceNumber
							((Liability) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Liability")).setSequenceNumber(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isPositiveInteger
					}		
					//xlink:label
					else if(currentNode.getNodeName().toLowerCase().equals("xlink:label".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("xlink:label"));
						}
						//if node information is a string in length from 1 to 1000
						else if(ComputeError.isWithinStringLength(currentNode.getFirstChild().getNodeValue(),1,1000)){
							//get last Deal_Set, get last Deal, get Liability, set xlink:label
							((Liability) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Liability")).setXlinklabel(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.stringLengthOutsideRange(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(),1,1000));
					}
					else if(!matchLiability_Detail(currentNode))
							if(!matchLiability_Holder(currentNode))
								//report error
								errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Liability"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchLiability_Holder(Node currentNode)
	{
		boolean result = true;
		
		//Liability_Holder
		if(currentNode.getNodeName().toLowerCase().equals("Liability_Holder".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchLiability_HolderName(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Liability_Holder"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchLiability_HolderName(Node currentNode)
	{
		boolean result = true;
		
		//Name
		if(currentNode.getNodeName().toLowerCase().equals("Name".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);

				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//FullName
					if(currentNode.getNodeName().toLowerCase().equals("FullName".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("Liability_Holder/Name/FullName"));
						}
						//if node information is string of length 1 to 150
						else if(ComputeError.isWithinStringLength(currentNode.getFirstChild().getNodeValue(),1,150)){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get Liabilities, then the last Liability, get Name //set FullName
							((Liability) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Liability")).getLiability_Holder().getName().setFullName(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.stringLengthOutsideRange(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(),1,150, "Liability_Holder/Name/"));
					}
					else
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Liability_Holder/Name/"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchLiability_Detail(Node currentNode)
	{
		boolean result = true;
		
		//Liability_Detail
		if(currentNode.getNodeName().toLowerCase().equals("Liability_Detail".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);

				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//HELOCMaximumBalanceAmount
					if(currentNode.getNodeName().toLowerCase().equals("HELOCMaximumBalanceAmount".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("HELOCMaximumBalanceAmount"));
						}
						//if node information is a positive amount of money
						else if(isPositiveMoney(currentNode, 12, 2)){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get Liabilities, then the last Liability //get Liability_Detail //set HELOCMaximumBalanceAmount
							( (Liability) ( (Deal) ( (Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Liability")).getLiability_Detail().setHELOCMaximumBalanceAmount(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isPositiveMoney
					}
					//LiabilityAccountIdentifier
					else if(currentNode.getNodeName().toLowerCase().equals("LiabilityAccountIdentifier".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("LiabilityAccountIdentifier"));
						}
						//if node information is string of length 1 to 30
						else if(ComputeError.isWithinStringLength(currentNode.getFirstChild().getNodeValue(),1,30)){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get Liabilities, then the last Liability //set LiabilityAccountIdentifier
							((Liability) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Liability")).getLiability_Detail().setLiabilityAccountIdentifier(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.stringLengthOutsideRange(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(),1,30));
					}
					//LiabilityExclusionIndicator
					else if(currentNode.getNodeName().toLowerCase().equals("LiabilityExclusionIndicator".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("LiabilityExclusionIndicator"));
						}
						//if node information is a boolean
						else if(ComputeError.isBoolean(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get Liabilities, then the last Liability //set LiabilityExclusionIndicator 
							if(currentNode.getFirstChild().getNodeValue().toLowerCase().equals("true"))
								((Liability) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Liability")).getLiability_Detail().setLiabilityExclusionIndicator(true);
							else if(currentNode.getFirstChild().getNodeValue().toLowerCase().equals("false"))
								((Liability) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Liability")).getLiability_Detail().setLiabilityExclusionIndicator(false);
						}
						else{
							//report error
							errorList.add(PrintError.notABoolean(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue()));
						}
					}	
					//LiabilityMonthlyPaymentAmount
					else if(currentNode.getNodeName().toLowerCase().equals("LiabilityMonthlyPaymentAmount".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("LiabilityMonthlyPaymentAmount"));
						}
						//if node information is a positive amount of money
						else if(isPositiveMoney(currentNode, 12, 2)){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get Liabilities, then the last Liability //set LiabilityMonthlyPaymentAmount
							((Liability) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Liability")).getLiability_Detail().setLiabilityMonthlyPaymentAmount(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isPositiveMoney
					}	
					//LiabilityPaymentIncludesTaxesInsuranceIndicator
					else if(currentNode.getNodeName().toLowerCase().equals("LiabilityPaymentIncludesTaxesInsuranceIndicator".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("LiabilityPaymentIncludesTaxesInsuranceIndicator"));
						}
						//if node information is a boolean
						else if(ComputeError.isBoolean(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get Liabilities, then the last Liability //set LiabilityPaymentIncludesTaxesInsuranceIndicator
							if(currentNode.getFirstChild().getNodeValue().toLowerCase().equals("true"))
								((Liability) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Liability")).getLiability_Detail().setLiabilityPaymentIncludesTaxesInsuranceIndicator(true);
							else if(currentNode.getFirstChild().getNodeValue().toLowerCase().equals("false"))
								((Liability) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Liability")).getLiability_Detail().setLiabilityPaymentIncludesTaxesInsuranceIndicator(false);
						}
						else{
							//report error
							errorList.add(PrintError.notABoolean(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue()));
						}
					}	
					//LiabilityPayoffStatusIndicator
					else if(currentNode.getNodeName().toLowerCase().equals("LiabilityPayoffStatusIndicator".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("LiabilityPayoffStatusIndicator"));
						}
						//if node information is a boolean
						else if(ComputeError.isBoolean(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get Liabilities, then the last Liability //set LiabilityPayoffStatusIndicator
							if(currentNode.getFirstChild().getNodeValue().toLowerCase().equals("true"))
								((Liability) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Liability")).getLiability_Detail().setLiabilityPayoffStatusIndicator(true);
							else if(currentNode.getFirstChild().getNodeValue().toLowerCase().equals("false"))
								((Liability) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Liability")).getLiability_Detail().setLiabilityPayoffStatusIndicator(false);
						}
						else{
							//report error
							errorList.add(PrintError.notABoolean(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue()));
						}
					}	
					//LiabilityRemainingTermMonthsCount
					else if(currentNode.getNodeName().toLowerCase().equals("LiabilityRemainingTermMonthsCount".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("LiabilityRemainingTermMonthsCount"));
						}
						//if node information is a positive or zero number
						else if(isPositiveOrZeroInteger(currentNode,1,3)){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get Liabilities, then the last Liability //set LiabilityRemainingTermMonthsCount
							((Liability) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Liability")).getLiability_Detail().setLiabilityRemainingTermMonthsCount(Integer.parseInt(currentNode.getFirstChild().getNodeValue()));
						}
						//error reporting happens in isPositiveOrZeroInteger
					}	
					//LiabilityType
					else if(currentNode.getNodeName().toLowerCase().equals("LiabilityType".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("LiabilityType"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getLiabilityType().contains(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get Liabilities, then the last Liability //set LiabilityType
							((Liability) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Liability")).getLiability_Detail().setLiabilityType(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getLiabilityType()));
					}	
					//LiabilityTypeOtherDescription
					else if(currentNode.getNodeName().toLowerCase().equals("LiabilityTypeOtherDescription".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("LiabilityTypeOtherDescription"));
						}
						//if node information is string of length 1 to 80
						else if(ComputeError.isWithinStringLength(currentNode.getFirstChild().getNodeValue(),1,80)){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get Liabilities, then the last Liability //set LiabilityTypeOtherDescription
							((Liability) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Liability")).getLiability_Detail().setLiabilityTypeOtherDescription(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.stringLengthOutsideRange(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(),1,80));
					}
					//LiabilityUnpaidBalanceAmount
					else if(currentNode.getNodeName().toLowerCase().equals("LiabilityUnpaidBalanceAmount".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("LiabilityUnpaidBalanceAmount"));
						}
						//if node information is a positive amount of money
						else if(isPositiveMoney(currentNode, 12, 2)){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get Liabilities, then the last Liability //set LiabilityUnpaidBalanceAmount
							((Liability) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Liability")).getLiability_Detail().setLiabilityMonthlyPaymentAmount(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isPositiveMoney
					}	
					else
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Liability_Detail"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchLiability_Summary(Node currentNode)
	{
		boolean result = true;
		
		//Liability_Summary
		if(currentNode.getNodeName().toLowerCase().equals("Liability_Summary".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//TotalNonSubjectPropertyDebtsToBePaidOffAmount
					if(currentNode.getNodeName().toLowerCase().equals("TotalNonSubjectPropertyDebtsToBePaidOffAmount".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("TotalNonSubjectPropertyDebtsToBePaidOffAmount"));
						}
						//if node information is a positive amount of money
						else if(isPositiveMoney(currentNode, 12, 2)){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //set TotalNonSubjectPropertyDebtsToBePaidOffAmount
							((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLiability_Summary().setTotalNonSubjectPropertyDebtsToBePaidOffAmount(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isPositiveMoney
					}
					//TotalSubjectPropertyPayoffsAndPaymentsAmount
					else if(currentNode.getNodeName().toLowerCase().equals("TotalSubjectPropertyPayoffsAndPaymentsAmount".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("TotalSubjectPropertyPayoffsAndPaymentsAmount"));
						}
						//if node information is a positive amount of money
						else if(isPositiveMoney(currentNode, 12, 2)){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //set TotalSubjectPropertyPayoffsAndPaymentsAmount
							((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLiability_Summary().setTotalSubjectPropertyPayoffsAndPaymentsAmount(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isPositiveMoney
					}
					else
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Liability_Summary"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchLoans(Node currentNode)
	{
		boolean result = true;
		
		//Parties
		if(currentNode.getNodeName().toLowerCase().equals("Loans".toLowerCase())){
			//create Java object
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchLoan(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Loans"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchLoan(Node currentNode)
	{
		boolean result = true;
		
		//Loan
		if(currentNode.getNodeName().toLowerCase().equals("Loan".toLowerCase())){
			//create Java object
			((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLoans().add(new Loan());
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//LoanRoleType
					if(currentNode.getNodeName().toLowerCase().equals("LoanRoleType".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("LoanRoleType"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getLoanRoleType().contains(currentNode.getFirstChild().getNodeValue())){
							//get last Deal_Set, get last Deal, get last Loan, set LoanRoleType
							((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).setLoanRoleType(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getLoanRoleType()));
					}
					//xlink:label
					else if(currentNode.getNodeName().toLowerCase().equals("xlink:label".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("xlink:label"));
						}
						//if node information is a string in length from 1 to 1000
						else if(ComputeError.isWithinStringLength(currentNode.getFirstChild().getNodeValue(),1,1000)){
							//get last Deal_Set, get last Deal, get last Loan, set xlink:label
							((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).setXlinklabel(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.stringLengthOutsideRange(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(),1,1000));
					}
					else if(!matchAdjustment(currentNode))
							if(!matchAffordable_Lending(currentNode))
								if(!matchAmortization(currentNode))
									if(!matchBuydown(currentNode))
										if(!matchClosing_Information(currentNode))
											if(!matchConstruction(currentNode))
												if(!matchDocument_Specific_Data_Sets(currentNode))
													if(!matchLoanExtension(currentNode))
														if(!matchGovernment_Loan(currentNode))
															if(!matchHELOC(currentNode))
																if(!matchHMDA_Loan(currentNode))
																	if(!matchHousing_Expenses(currentNode))
																		if(!matchInterest_Only(currentNode))
																			if(!matchInvestor_Features(currentNode))
																				if(!matchInvestor_Loan_Information(currentNode))
																					if(!matchLoan_Detail(currentNode))
																						if(!matchLoan_Identifiers(currentNode))
																							if(!matchLoan_Product(currentNode))
																								if(!matchMaturity(currentNode))
																									if(!matchMI_Data(currentNode))
																										if(!matchNegative_Amortization(currentNode))
																											if(!matchOrigination_Funds(currentNode))
																												if(!matchPayment(currentNode))
																													if(!matchPrepayment_Penalty(currentNode))
																														if(!matchPurchase_Credits(currentNode))
																															if(!matchQualification(currentNode))
																																if(!matchRefinance(currentNode))
																																	if(!matchTerms_Of_Loan(currentNode))
																																		if(!matchUnderwriting(currentNode))
																																			//report error
																																			errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Loan"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchAdjustment(Node currentNode)
	{
		boolean result = true;
		
		//Adjustment
		if(currentNode.getNodeName().toLowerCase().equals("Adjustment".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchInterest_Rate_Adjustment(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Adjustment"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchInterest_Rate_Adjustment(Node currentNode)
	{
		boolean result = true;
		
		//Interest_Rate_Adjustment
		if(currentNode.getNodeName().toLowerCase().equals("Interest_Rate_Adjustment".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchIndex_Rules(currentNode))
						if(!matchInterest_Rate_Lifetime_Adjustment_Rule(currentNode))
							if(!matchInterest_Per_Change_Adjustment_Rules(currentNode))
								//report error
								errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Interest_Rate_Adjustment"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchIndex_Rules(Node currentNode)
	{
		boolean result = true;
		
		//Party
		if(currentNode.getNodeName().toLowerCase().equals("Index_Rules".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchIndex_Rule(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Index_Rules"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchIndex_Rule(Node currentNode)
	{
		boolean result = true;
		
		//Party
		if(currentNode.getNodeName().toLowerCase().equals("Index_Rule".toLowerCase())){
			//create Java object
			((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getAdjustment().getInterest_Rate_Adjustment().getIndex_Rules().add(new Index_Rule());
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//IndexSourceType
					if(currentNode.getNodeName().toLowerCase().equals("IndexSourceType".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("IndexSourceType"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getIndexSourceType().contains(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Loan, get Adjustment, get Interest_Rate_Adjustment, get last Index_Rule, set IndexSourceType
							((Index_Rule) ((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getAdjustment().getInterest_Rate_Adjustment().getLast("Index_Rule")).setIndexSourceType(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getIndexSourceType()));
					}		
					//IndexSourceTypeOtherDescription
					else if(currentNode.getNodeName().toLowerCase().equals("IndexSourceTypeOtherDescription".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("IndexSourceTypeOtherDescription"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getIndexSourceTypeOtherDescription().contains(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Loan, get Adjustment, get Interest_Rate_Adjustment, get last Index_Rule, set IndexSourceTypeOtherDescription
							((Index_Rule) ((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getAdjustment().getInterest_Rate_Adjustment().getLast("Index_Rule")).setIndexSourceTypeOtherDescription(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getIndexSourceTypeOtherDescription()));
					}		
					else
					
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Index_Rule"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
		
	public boolean matchInterest_Rate_Lifetime_Adjustment_Rule(Node currentNode)
	{
		boolean result = true;
		
		//Party
		if(currentNode.getNodeName().toLowerCase().equals("Interest_Rate_Lifetime_Adjustment_Rule".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//CeilingRatePercent
					if(currentNode.getNodeName().toLowerCase().equals("CeilingRatePercent".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("CeilingRatePercent"));
						}
						//if node information is a percentage
						else if(isPositiveOrZeroPercentage(currentNode, 3, 4)){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Loan, get Adjustment, get Interest_Rate_Adjustment, get getInterest_Rate_Lifetime_Adjustment_Rule, set IndexSourceType
							((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getAdjustment().getInterest_Rate_Adjustment().getInterest_Rate_Lifetime_Adjustment_Rule().setCeilingRatePercent(currentNode.getFirstChild().getNodeValue());
						
						}
						//error reporting happens in isPositiveOrZeroPercentage
					}		
					//MarginRatePercent
					else if(currentNode.getNodeName().toLowerCase().equals("MarginRatePercent".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("MarginRatePercent"));
						}
						//if node information is an amount of money
						else if(isPositiveOrZeroPercentage(currentNode, 3, 4)){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Loan, get Adjustment, get Interest_Rate_Adjustment, get getInterest_Rate_Lifetime_Adjustment_Rule, set MarginRatePercent
							((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getAdjustment().getInterest_Rate_Adjustment().getInterest_Rate_Lifetime_Adjustment_Rule().setMarginRatePercent(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isPositiveOrZeroPercentage
					}		
					else
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Interest_Rate_Lifetime_Adjustment_Rule"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
		
	public boolean matchInterest_Per_Change_Adjustment_Rules(Node currentNode)
	{
		boolean result = true;
		
		//Party
		if(currentNode.getNodeName().toLowerCase().equals("Interest_Per_Change_Adjustment_Rules".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchInterest_Per_Change_Adjustment_Rule(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Interest_Per_Change_Adjustment_Rules"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchInterest_Per_Change_Adjustment_Rule(Node currentNode)
	{
		boolean result = true;
		
		//Party
		if(currentNode.getNodeName().toLowerCase().equals("Interest_Per_Change_Adjustment_Rule".toLowerCase())){
			//create Java object
			((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getAdjustment().getInterest_Rate_Adjustment().getInterest_Rate_Per_Change_Adjustment_Rules().add(new Interest_Rate_Per_Change_Adjustment_Rule());
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//AdjustmentRuleType
					if(currentNode.getNodeName().toLowerCase().equals("AdjustmentRuleType".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("AdjustmentRuleType"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getAdjustmentRuleType().contains(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Loan, get Adjustment, get Interest_Rate_Adjustment, get last Interest_Rate_Per_Change_Adjustment_Rule, set AdjustmentRuleType
							((Interest_Rate_Per_Change_Adjustment_Rule) ((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getAdjustment().getInterest_Rate_Adjustment().getLast("Interest_Rate_Per_Change_Adjustment_Rule")).setAdjustmentRuleType(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getAdjustmentRuleType()));
					}		
					//PerChangeMaximumIncreaseRatePercent
					else if(currentNode.getNodeName().toLowerCase().equals("PerChangeMaximumIncreaseRatePercent".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("PerChangeMaximumIncreaseRatePercent"));
						}
						//if node information is a percentage
						else if(isPositiveOrZeroPercentage(currentNode, 3, 4)){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Loan, get Adjustment, get Interest_Rate_Adjustment, get last getInterest_Rate_Lifetime_Adjustment_Rule, set PerChangeMaximumIncreaseRatePercent
							((Interest_Rate_Per_Change_Adjustment_Rule) ((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getAdjustment().getInterest_Rate_Adjustment().getLast("Interest_Rate_Per_Change_Adjustment_Rule")).setPerChangeMaximumIncreaseRatePercent(currentNode.getFirstChild().getNodeValue());
						
						}
						//error reporting happens in isPositiveOrZeroPercentage
					}		
					//PerChangeRateAdjustmentFrequencyMonthsCount
					else if(currentNode.getNodeName().toLowerCase().equals("PerChangeRateAdjustmentFrequencyMonthsCount".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("PerChangeRateAdjustmentFrequencyMonthsCount"));
						}
						//if node information is string in length from 1 to 3
						else if(ComputeError.isWithinStringLength(currentNode.getFirstChild().getNodeValue(),1,3)){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Loan, get Adjustment, get Interest_Rate_Adjustment, get last getInterest_Rate_Lifetime_Adjustment_Rule, set PerChangeRateAdjustmentFrequencyMonthsCount
							((Interest_Rate_Per_Change_Adjustment_Rule) ((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getAdjustment().getInterest_Rate_Adjustment().getLast("Interest_Rate_Per_Change_Adjustment_Rule")).setPerChangeRateAdjustmentFrequencyMonthsCount(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.stringLengthOutsideRange(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(),1,3));
					}
					else
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Interest_Per_Change_Adjustment_Rule"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
		
	public boolean matchAffordable_Lending(Node currentNode)
	{
		boolean result = true;
		
		//Affordable_Lending
		if(currentNode.getNodeName().toLowerCase().equals("Affordable_Lending".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//CommunityLendingProductType
					if(currentNode.getNodeName().toLowerCase().equals("CommunityLendingProductType".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("CommunityLendingProductType"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getCommunityLendingProductType().contains(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Employer, get Employment //set EmploymentClassificationType
							((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loans")).getAffordable_Lending().setCommunityLendingProductType(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getCommunityLendingProductType()));
					}		
					//CommunitySecondsRepaymentType
					else if(currentNode.getNodeName().toLowerCase().equals("CommunitySecondsRepaymentType".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("CommunitySecondsRepaymentType"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getCommunitySecondsRepaymentType().contains(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Employer, get Employment //set EmploymentClassificationType
							((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loans")).getAffordable_Lending().setCommunitySecondsRepaymentType(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getCommunitySecondsRepaymentType()));
					}		
					//HUDIncomeLimitAdjustmentPercent
					else if(currentNode.getNodeName().toLowerCase().equals("HUDIncomeLimitAdjustmentPercent".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("HUDIncomeLimitAdjustmentPercent"));
						}
						//if node information is an amount of money
						else if(isPositiveOrZeroPercentage(currentNode, 3, 4)){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Loan, get Adjustment, get Interest_Rate_Adjustment, get getInterest_Rate_Lifetime_Adjustment_Rule, set IndexSourceType
							((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loans")).getAffordable_Lending().setHUDIncomeLimitAdjustmentPercent(currentNode.getFirstChild().getNodeValue());
						
						}
						//error reporting happens in isPositiveOrZeroPercentage
					}		
					else
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Affordable_Lending"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchAmortization(Node currentNode)
	{
		boolean result = true;
		
		//Adjustment
		if(currentNode.getNodeName().toLowerCase().equals("Amortization".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchAmortization_Rule(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Amortization"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchAmortization_Rule(Node currentNode)
	{
		boolean result = true;
		
		//Affordable_Lending
		if(currentNode.getNodeName().toLowerCase().equals("Amortization_Rule".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//AmortizationType
					if(currentNode.getNodeName().toLowerCase().equals("AmortizationType".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("AmortizationType"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getAmortizationType().contains(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Loan, get last Role, get Amortization, get Amortizatoin_Rule, set AmortizationType
							((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getAmortization().getAmortization_Rule().setAmortizationType(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getAmortizationType()));
					}
					//AmortizationTypeOtherDescription
					else if(currentNode.getNodeName().toLowerCase().equals("AmortizationTypeOtherDescription".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("AmortizationTypeOtherDescription"));
						}
						//if node information is string in length from 1 to 80
						else if(ComputeError.isWithinStringLength(currentNode.getFirstChild().getNodeValue(),1,80)){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Loan, get last Role, get Amortization, get Amortizatoin_Rule, get Employment //set AmortizationTypeOtherDescription
							((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getAmortization().getAmortization_Rule().setAmortizationTypeOtherDescription(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.stringLengthOutsideRange(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(),1,80));
					}
					//LoanAmortizationPeriodCount
					else if(currentNode.getNodeName().toLowerCase().equals("LoanAmortizationPeriodCount".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("LoanAmortizationPeriodCount"));
						}
						//if node information is a positive or zero number
						else if(isPositiveOrZeroInteger(currentNode,1,360)){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Loan, get last Role, get Amortization, get Amortizatoin_Rule, get Employment //set LoanAmortizationPeriodCount
							((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getAmortization().getAmortization_Rule().setLoanAmortizationPeriodCount(Integer.parseInt(currentNode.getFirstChild().getNodeValue()));
						}
						//error reporting happens in isPositiveOrZeroInteger
					}	
					//LoanAmortizationPeriodType
					else if(currentNode.getNodeName().toLowerCase().equals("LoanAmortizationPeriodType".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("LoanAmortizationPeriodType"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getLoanAmortizationPeriodType().contains(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Loan, get last Role, get Amortization, get Amortizatoin_Rule, get Employment //set LoanAmortizationPeriodType
							((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getAmortization().getAmortization_Rule().setLoanAmortizationPeriodType(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getLoanAmortizationPeriodType()));
					}		
					else
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Amortization_Rule"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchBuydown(Node currentNode)
	{
		boolean result = true;
		
		//Adjustment
		if(currentNode.getNodeName().toLowerCase().equals("Buydown".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchBuydown_Occurrences(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Buydown"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchBuydown_Occurrences(Node currentNode)
	{
		boolean result = true;
		
		//Adjustment
		if(currentNode.getNodeName().toLowerCase().equals("Buydown_Occurrences".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchBuydown_Occurrence(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Buydown_Occurrences"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchBuydown_Occurrence(Node currentNode)
	{
		boolean result = true;
		
		//Adjustment
		if(currentNode.getNodeName().toLowerCase().equals("Buydown_Occurrence".toLowerCase())){
			//create Java Object
			((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getBuydown().getBuydown_Occurrences().add(new Buydown_Occurrence());
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//BuydownInitialEffectiveInterestRatePercent
					if(currentNode.getNodeName().toLowerCase().equals("BuydownInitialEffectiveInterestRatePercent".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("BuydownInitialEffectiveInterestRatePercent"));
						}
						//if node information is an amount of money
						else if(isPositiveOrZeroPercentage(currentNode, 3, 4)){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Loan, get Buydown, get Last Buydown_Occurrence, set BuydownInitialEffectiveInterestRatePercent
							((Buydown_Occurrence) ((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loans")).getBuydown().getLast("Buydown_Occurrence")).setBuydownInitialEffectiveInterestRatePercent(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isPositiveOrZeroPercentage
					}		
					else
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Buydown_Occurrence"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchClosing_Information(Node currentNode)
	{
		boolean result = true;
		
		//Adjustment
		if(currentNode.getNodeName().toLowerCase().equals("Closing_Information".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchClosing_Adjustment_Items(currentNode))
						if(!matchClosing_Information_Detail(currentNode))
							//report error
							errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Closing_Information"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchClosing_Adjustment_Items(Node currentNode)
	{
		boolean result = true;
		
		//Adjustment
		if(currentNode.getNodeName().toLowerCase().equals("Closing_Adjustment_Items".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchClosing_Adjustment_Item(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Closing_Adjustment_Items"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchClosing_Adjustment_Item(Node currentNode)
	{
		boolean result = true;
		
		//Adjustment
		if(currentNode.getNodeName().toLowerCase().equals("Closing_Adjustment_Item".toLowerCase())){
			//create Java Object
			((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getClosing_Information().getClosing_Adjustment_Items().add(new Closing_Adjustment_Item());
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchClosing_Adjustment_Item_Detail(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Closing_Adjustment_Item"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchClosing_Adjustment_Item_Detail(Node currentNode)
	{
		boolean result = true;
		
		//Adjustment
		if(currentNode.getNodeName().toLowerCase().equals("Closing_Adjustment_Item_Detail".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//ClosingAdjustmentItemAmount
					if(currentNode.getNodeName().toLowerCase().equals("ClosingAdjustmentItemAmount".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("ClosingAdjustmentItemAmount"));
						}
						//if node information is an amount of money
						else if(isMoney(currentNode, 12, 2)){
							//get Deal_Sets, then the last Deal_Set //get Deals, get last Deal, get last Loan, get Closing_Information, get Last Closing_Adjustment_Item, get Closing_Adjustment_Item_Detail, set ClosingAdjustmentItemAmount
							((Closing_Adjustment_Item) ((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getClosing_Information().getLast("Closing_Adjustment_Item")).getClosing_Adjustment_Item_Detail().setClosingAdjustmentItemAmount(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isMoney
					}		
					//ClosingAdjustmentItemType
					else if(currentNode.getNodeName().toLowerCase().equals("ClosingAdjustmentItemType".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("ClosingAdjustmentItemType"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getClosingAdjustmentItemType().contains(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, get last Deal, get last Loan, get Closing_Information, get Last Closing_Adjustment_Item, get Closing_Adjustment_Item_Detail, set ClosingAdjustmentItemType
							((Closing_Adjustment_Item) ((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getClosing_Information().getLast("Closing_Adjustment_Item")).getClosing_Adjustment_Item_Detail().setClosingAdjustmentItemType(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getClosingAdjustmentItemType()));
					}		
					else
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Closing_Adjustment_Item_Detail"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchClosing_Information_Detail(Node currentNode)
	{
		boolean result = true;
		
		//Adjustment
		if(currentNode.getNodeName().toLowerCase().equals("Closing_Information_Detail".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//CashFromBorrowerAtClosingAmount
					if(currentNode.getNodeName().toLowerCase().equals("CashFromBorrowerAtClosingAmount".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("CashFromBorrowerAtClosingAmount"));
						}
						//if node information is an amount of money
						else if(isMoney(currentNode, 12, 2)){
							//get Deal_Sets, then the last Deal_Set //get Deals, get last Deal, get last Loan, get Closing_Information, get Last Closing_Adjustment_Item, get Closing_Adjustment_Item_Detail, set CashFromBorrowerAtClosingAmount
							((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getClosing_Information().getClosing_Information_Detail().setCashFromBorrowerAtClosingAmount(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isMoney
					}		
					//CashToBorrowerAtClosingAmount
					else if(currentNode.getNodeName().toLowerCase().equals("CashToBorrowerAtClosingAmount".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("CashToBorrowerAtClosingAmount"));
						}
						//if node information is an amount of money
						else if(isMoney(currentNode, 12, 2)){
							//get Deal_Sets, then the last Deal_Set //get Deals, get last Deal, get last Loan, get Closing_Information, get Last Closing_Adjustment_Item, get Closing_Adjustment_Item_Detail, set CashToBorrowerAtClosingAmount
							((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getClosing_Information().getClosing_Information_Detail().setCashToBorrowerAtClosingAmount(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isMoney
					}		
					else
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Closing_Information_Detail"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchConstruction(Node currentNode)
	{
		boolean result = true;
		
		//Adjustment
		if(currentNode.getNodeName().toLowerCase().equals("Construction".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//ConstructionImprovementCostsAmount
					if(currentNode.getNodeName().toLowerCase().equals("ConstructionImprovementCostsAmount".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("ConstructionImprovementCostsAmount"));
						}
						//if node information is an amount of money
						else if(isMoney(currentNode, 12, 2)){
							//get Deal_Sets, then the last Deal_Set //get Deals, get last Deal, get last Loan, get Construction, set ConstructionImprovementCostsAmount
							((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getConstruction().setConstructionImprovementCostsAmount(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isMoney
					}		
					//ConstructionLoanType
					else if(currentNode.getNodeName().toLowerCase().equals("ConstructionLoanType".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("ConstructionLoanType"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getConstructionLoanType().contains(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, get last Deal, get last Loan, get Construction, set ConstructionLoanType
							((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getConstruction().setConstructionLoanType(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getConstructionLoanType()));
					}
					//ConstructionToPermanentClosingType
					else if(currentNode.getNodeName().toLowerCase().equals("ConstructionToPermanentClosingType".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("ConstructionToPermanentClosingType"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getConstructionToPermanentClosingType().contains(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, get last Deal, get last Loan, get Construction, set ConstructionToPermanentClosingType
							((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getConstruction().setConstructionToPermanentClosingType(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getConstructionToPermanentClosingType()));
					}		
					//LandAppraisedValueAmount
					else if(currentNode.getNodeName().toLowerCase().equals("LandAppraisedValueAmount".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("LandAppraisedValueAmount"));
						}
						//if node information is an amount of money
						else if(isMoney(currentNode, 12, 2)){
							//get Deal_Sets, then the last Deal_Set //get Deals, get last Deal, get last Loan, get Construction, set LandAppraisedValueAmount
							((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getConstruction().setLandAppraisedValueAmount(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isMoney
					}		
					//LandOriginalCostAmount
					else if(currentNode.getNodeName().toLowerCase().equals("LandOriginalCostAmount".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("LandOriginalCostAmount"));
						}
						//if node information is an amount of money
						else if(isMoney(currentNode, 12, 2)){
							//get Deal_Sets, then the last Deal_Set //get Deals, get last Deal, get last Loan, get Construction, set LandOriginalCostAmount
							((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getConstruction().setLandOriginalCostAmount(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isMoney
					}		
					else
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Construction"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchDocument_Specific_Data_Sets(Node currentNode)
	{
		boolean result = true;
		
		//Adjustment
		if(currentNode.getNodeName().toLowerCase().equals("Document_Specific_Data_Sets".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchDocument_Specific_Data_Set(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Document_Specific_Data_Sets"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchDocument_Specific_Data_Set(Node currentNode)
	{
		boolean result = true;
		
		//Adjustment
		if(currentNode.getNodeName().toLowerCase().equals("Document_Specific_Data_Set".toLowerCase())){
			//create Java Object
			((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getDocument_Specific_Data_Sets().add(new Document_Specific_Data_Set());
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchURLA(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Document_Specific_Data_Set"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchURLA(Node currentNode)
	{
		boolean result = true;
		
		//Adjustment
		if(currentNode.getNodeName().toLowerCase().equals("URLA".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchURLA_Detail(currentNode))
						if(!matchURLA_Total(currentNode))
							//report error
							errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "URLA"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchURLA_Detail(Node currentNode)
	{
		boolean result = true;
		
		//Adjustment
		if(currentNode.getNodeName().toLowerCase().equals("URLA_Detail".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					
					//AlterationsImprovementsAndRepairsAmount
					if(currentNode.getNodeName().toLowerCase().equals("AlterationsImprovementsAndRepairsAmount".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("AlterationsImprovementsAndRepairsAmount"));
						}
						//if node information is an amount of money
						else if(isMoney(currentNode, 12, 2)){
							//get Deal_Sets, then the last Deal_Set //get Deals, get last Deal, get last Loan, get last Document_Specific_Data_Set, get URLA, get URLA Detail, set AlterationsImprovementsAndRepairsAmount
							((Document_Specific_Data_Set) ((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getLast("Document_Specific_Data_Set")).getURLA().getURLA_Detail().setAlterationsImprovementsAndRepairsAmount(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isMoney
					}
					//ApplicationSignedByLoanOriginatorDate
					else if(currentNode.getNodeName().toLowerCase().equals("ApplicationSignedByLoanOriginatorDate".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("ApplicationSignedByLoanOriginatorDate"));
						}
						//if node information is a date time value
						else if(ComputeError.isDate(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, get last Deal, get last Loan, get last Document_Specific_Data_Set, get URLA, get URLA Detail, set ApplicationSignedByLoanOriginatorDate
							((Document_Specific_Data_Set) ((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getLast("Document_Specific_Data_Set")).getURLA().getURLA_Detail().setApplicationSignedByLoanOriginatorDate(Utility.setDate(currentNode.getFirstChild().getNodeValue()));
						}
						else
							//report error
							errorList.add(PrintError.notADate(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue()));
					}
					//BorrowerPaidDiscountPointsTotalAmount
					else if(currentNode.getNodeName().toLowerCase().equals("BorrowerPaidDiscountPointsTotalAmount".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("BorrowerPaidDiscountPointsTotalAmount"));
						}
						//if node information is an amount of money
						else if(isMoney(currentNode, 12, 2)){
							//get Deal_Sets, then the last Deal_Set //get Deals, get last Deal, get last Loan, get last Document_Specific_Data_Set, get URLA, get URLA Detail, set BorrowerPaidDiscountPointsTotalAmount
							((Document_Specific_Data_Set) ((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getLast("Document_Specific_Data_Set")).getURLA().getURLA_Detail().setBorrowerPaidDiscountPointsTotalAmount(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isMoney
					}
					//EstimatedClosingCostsAmount
					else if(currentNode.getNodeName().toLowerCase().equals("EstimatedClosingCostsAmount".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("EstimatedClosingCostsAmount"));
						}
						//if node information is an amount of money
						else if(isMoney(currentNode, 12, 2)){
							//get Deal_Sets, then the last Deal_Set //get Deals, get last Deal, get last Loan, get last Document_Specific_Data_Set, get URLA, get URLA Detail, set EstimatedClosingCostsAmount
							((Document_Specific_Data_Set) ((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getLast("Document_Specific_Data_Set")).getURLA().getURLA_Detail().setEstimatedClosingCostsAmount(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isMoney
					}
					//MIAndFundingFeeFinancedAmount
					else if(currentNode.getNodeName().toLowerCase().equals("MIAndFundingFeeFinancedAmount".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("MIAndFundingFeeFinancedAmount"));
						}
						//if node information is an amount of money
						else if(isMoney(currentNode, 12, 2)){
							//get Deal_Sets, then the last Deal_Set //get Deals, get last Deal, get last Loan, get last Document_Specific_Data_Set, get URLA, get URLA Detail, set MIAndFundingFeeFinancedAmount
							((Document_Specific_Data_Set) ((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getLast("Document_Specific_Data_Set")).getURLA().getURLA_Detail().setMIAndFundingFeeFinancedAmount(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isMoney
					}
					//MIAndFundingFeeTotalAmount
					else if(currentNode.getNodeName().toLowerCase().equals("MIAndFundingFeeTotalAmount".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("MIAndFundingFeeTotalAmount"));
						}
						//if node information is an amount of money
						else if(isMoney(currentNode, 12, 2)){
							//get Deal_Sets, then the last Deal_Set //get Deals, get last Deal, get last Loan, get last Document_Specific_Data_Set, get URLA, get URLA Detail, set MIAndFundingFeeTotalAmount
							((Document_Specific_Data_Set) ((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getLast("Document_Specific_Data_Set")).getURLA().getURLA_Detail().setMIAndFundingFeeTotalAmount(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isMoney
					}
					//PrepaidItemsEstimatedAmount
					else if(currentNode.getNodeName().toLowerCase().equals("PrepaidItemsEstimatedAmount".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("PrepaidItemsEstimatedAmount"));
						}
						//if node information is an amount of money
						else if(isMoney(currentNode, 12, 2)){
							//get Deal_Sets, then the last Deal_Set //get Deals, get last Deal, get last Loan, get last Document_Specific_Data_Set, get URLA, get URLA Detail, set PrepaidItemsEstimatedAmount
							((Document_Specific_Data_Set) ((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getLast("Document_Specific_Data_Set")).getURLA().getURLA_Detail().setPrepaidItemsEstimatedAmount(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isMoney
					}
					//RefinanceImprovementCostsAmount
					else if(currentNode.getNodeName().toLowerCase().equals("RefinanceImprovementCostsAmount".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("RefinanceImprovementCostsAmount"));
						}
						//if node information is an amount of money
						else if(isMoney(currentNode, 12, 2)){
							//get Deal_Sets, then the last Deal_Set //get Deals, get last Deal, get last Loan, get last Document_Specific_Data_Set, get URLA, get URLA Detail, set RefinanceImprovementCostsAmount
							((Document_Specific_Data_Set) ((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getLast("Document_Specific_Data_Set")).getURLA().getURLA_Detail().setRefinanceImprovementCostsAmount(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isMoney
					}
					//RefinanceImprovementsType
					else if(currentNode.getNodeName().toLowerCase().equals("RefinanceImprovementsType".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("RefinanceImprovementsType"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getRefinanceImprovementsType().contains(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, get last Deal, get last Loan, get last Document_Specific_Data_Set, get URLA, get URLA Detail, set RefinanceImprovementsType
							((Document_Specific_Data_Set) ((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getLast("Document_Specific_Data_Set")).getURLA().getURLA_Detail().setRefinanceImprovementsType(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getRefinanceImprovementsType()));
					}
					else
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "URLA_Detail"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchURLA_Total(Node currentNode)
	{
		boolean result = true;
		
		//Adjustment
		if(currentNode.getNodeName().toLowerCase().equals("URLA_Total".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//Extension
					if(!matchURLA_TotalExtension(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "URLA_Total"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchURLA_TotalExtension(Node currentNode)
	{
		boolean result = true;
		
		//Adjustment
		if(currentNode.getNodeName().toLowerCase().equals("Extension".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchURLA_TotalExtensionOther(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Extension"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchURLA_TotalExtensionOther(Node currentNode)
	{
		boolean result = true;
		
		//Adjustment
		if(currentNode.getNodeName().toLowerCase().equals("Other".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchURLA_Total_Extension(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Other"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchURLA_Total_Extension(Node currentNode)
	{
		boolean result = true;
		
		//Adjustment
		if(currentNode.getNodeName().toLowerCase().equals("ULAD:URLA_Total_Extension".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//URLATotalSellerCreditsAmount
					if(currentNode.getNodeName().toLowerCase().equals("ULAD:URLATotalSellerCreditsAmount".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("ULAD:URLATotalSellerCreditsAmount"));
						}
						//if node information is an amount of money
						else if(isMoney(currentNode, 12, 2)){
							//get Deal_Sets, then the last Deal_Set //get Deals, get last Deal, get last Loan, get last Document_Specific_Data_Set, get URLA, get URLA Total, get Extension, get Other, get URLA_Total_Extension, set URLATotalSellerCreditsAmount
							((Document_Specific_Data_Set) ((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getLast("Document_Specific_Data_Set")).getURLA().getURLA_Total().getExtension().getOther().getURLA_Total_Extension().setURLATotalSellerCreditsAmount(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isMoney
					}
					else
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "ULAD:URLA_Total_Extension"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	
	public boolean matchLoanExtension(Node currentNode)
	{
		boolean result = true;
		
		//Extension
		if(currentNode.getNodeName().toLowerCase().equals("Extension".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchLoanExtensionOther(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Extension"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchLoanExtensionOther(Node currentNode)
	{
		boolean result = true;
		
		//Other
		if(currentNode.getNodeName().toLowerCase().equals("Other".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchLoan_Extension(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Other"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchLoan_Extension(Node currentNode)
	{
		boolean result = true;
		
		//Loan_Extension
		if(currentNode.getNodeName().toLowerCase().equals("DU:Loan_Extension".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchUnderwriting_Verifications(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "DU:Loan_Extension"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchGovernment_Loan(Node currentNode)
	{
		boolean result = true;
		
		//Adjustment
		if(currentNode.getNodeName().toLowerCase().equals("Government_Loan".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					
					//FHALoanLenderIdentifier
					if(currentNode.getNodeName().toLowerCase().equals("FHALoanLenderIdentifier".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("FHALoanLenderIdentifier"));
						}
						//if a Positive Numeric String of 1 to 20
						else if(isPositiveInteger(currentNode,1,20)){
							//get Deal_Sets, then the last Deal_Set, get Deals, get last Deal, get last Loan, get Government_Loan, set FHALoanLenderIdentifier
							((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getGovernment_Loan().setFHALoanLenderIdentifier(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isPositiveInteger
					}		
					//FHALoanSponsorIdentifier
					else if(currentNode.getNodeName().toLowerCase().equals("FHALoanSponsorIdentifier".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("FHALoanSponsorIdentifier"));
						}
						//if a Positive Numeric String of 1 to 20
						else if(isPositiveInteger(currentNode,1,20)){
							//get Deal_Sets, then the last Deal_Set, get Deals, get last Deal, get last Loan, get Government_Loan, set FHALoanSponsorIdentifier
							((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getGovernment_Loan().setFHALoanSponsorIdentifier(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isPositiveInteger
					}
					//FHA_MIPremiumRefundAmount
					else if(currentNode.getNodeName().toLowerCase().equals("FHA_MIPremiumRefundAmount".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("FHA_MIPremiumRefundAmount"));
						}
						//if node information is an amount of money
						else if(isMoney(currentNode, 12, 2)){
							//get Deal_Sets, then the last Deal_Set //get Deals, get last Deal, get last Loan, get Government_Loan, set FHA_MIPremiumRefundAmount
							((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getGovernment_Loan().setFHA_MIPremiumRefundAmount(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isMoney
					}
					//GovernmentMortgageCreditCertificateAmount
					else if(currentNode.getNodeName().toLowerCase().equals("GovernmentMortgageCreditCertificateAmount".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("GovernmentMortgageCreditCertificateAmount"));
						}
						//if node information is an amount of money
						else if(isMoney(currentNode, 12, 2)){
							//get Deal_Sets, then the last Deal_Set //get Deals, get last Deal, get last Loan, get Government_Loan, set GovernmentMortgageCreditCertificateAmount
							((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getGovernment_Loan().setGovernmentMortgageCreditCertificateAmount(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isMoney
					}
					//GovernmentRefinanceType
					else if(currentNode.getNodeName().toLowerCase().equals("GovernmentRefinanceType".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("GovernmentRefinanceType"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getGovernmentRefinanceType().contains(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, get last Deal, get last Loan, get Government_Loan, set GovernmentRefinanceType
							((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getGovernment_Loan().setGovernmentRefinanceType(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getGovernmentRefinanceType()));
					}
					//GovernmentRefinanceTypeOtherDescription
					else if(currentNode.getNodeName().toLowerCase().equals("GovernmentRefinanceTypeOtherDescription".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("GovernmentRefinanceTypeOtherDescription"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getGovernmentRefinanceTypeOtherDescription().contains(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, get last Deal, get last Loan, get Government_Loan, set GovernmentRefinanceTypeOtherDescription
							((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getGovernment_Loan().setGovernmentRefinanceTypeOtherDescription(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getGovernmentRefinanceTypeOtherDescription()));
					}
					//PropertyEnergyEfficientHomeIndicator
					else if(currentNode.getNodeName().toLowerCase().equals("PropertyEnergyEfficientHomeIndicator".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("PropertyEnergyEfficientHomeIndicator"));
						}
						//if node information is a boolean
						else if(ComputeError.isBoolean(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, get last Deal, get last Loan, get Government_Loan, set PropertyEnergyEfficientHomeIndicator
							if(currentNode.getFirstChild().getNodeValue().toLowerCase().equals("true"))
								((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getGovernment_Loan().setPropertyEnergyEfficientHomeIndicator(true);
							else if(currentNode.getFirstChild().getNodeValue().toLowerCase().equals("false"))
								((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getGovernment_Loan().setPropertyEnergyEfficientHomeIndicator(false);
						}
						else{
							//report error
							errorList.add(PrintError.notABoolean(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue()));
						}
					}	
					//SectionOfActType
					else if(currentNode.getNodeName().toLowerCase().equals("SectionOfActType".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("SectionOfActType"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getSectionOfActType().contains(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, get last Deal, get last Loan, get Government_Loan, set SectionOfActType
							((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getGovernment_Loan().setSectionOfActType(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getSectionOfActType()));
					}
					//VABorrowerCoBorrowerMarriedIndicator
					else if(currentNode.getNodeName().toLowerCase().equals("VABorrowerCoBorrowerMarriedIndicator".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("VABorrowerCoBorrowerMarriedIndicator"));
						}
						//if node information is a boolean
						else if(ComputeError.isBoolean(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, get last Deal, get last Loan, get Government_Loan, set VABorrowerCoBorrowerMarriedIndicator
							if(currentNode.getFirstChild().getNodeValue().toLowerCase().equals("true"))
								((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getGovernment_Loan().setVABorrowerCoBorrowerMarriedIndicator(true);
							else if(currentNode.getFirstChild().getNodeValue().toLowerCase().equals("false"))
								((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getGovernment_Loan().setVABorrowerCoBorrowerMarriedIndicator(false);
						}
						else{
							//report error
							errorList.add(PrintError.notABoolean(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue()));
						}
					}	
					//VAEntitlementAmount
					else if(currentNode.getNodeName().toLowerCase().equals("VAEntitlementAmount".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("VAEntitlementAmount"));
						}
						//if node information is an amount of money
						else if(isMoney(currentNode, 12, 2)){
							//get Deal_Sets, then the last Deal_Set //get Deals, get last Deal, get last Loan, get Government_Loan, set VAEntitlementAmount
							((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getGovernment_Loan().setVAEntitlementAmount(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isMoney
					}
					//VAMaintenanceExpenseMonthlyAmount
					else if(currentNode.getNodeName().toLowerCase().equals("VAMaintenanceExpenseMonthlyAmount".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("VAMaintenanceExpenseMonthlyAmount"));
						}
						//if node information is an amount of money
						else if(isMoney(currentNode, 12, 2)){
							//get Deal_Sets, then the last Deal_Set //get Deals, get last Deal, get last Loan, get Government_Loan, set VAMaintenanceExpenseMonthlyAmount
							((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getGovernment_Loan().setVAMaintenanceExpenseMonthlyAmount(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isMoney
					}
					//VAUtilityExpenseMonthlyAmount
					else if(currentNode.getNodeName().toLowerCase().equals("VAUtilityExpenseMonthlyAmount".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("VAUtilityExpenseMonthlyAmount"));
						}
						//if node information is an amount of money
						else if(isMoney(currentNode, 12, 2)){
							//get Deal_Sets, then the last Deal_Set //get Deals, get last Deal, get last Loan, get Government_Loan, set VAUtilityExpenseMonthlyAmount
							((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getGovernment_Loan().setVAUtilityExpenseMonthlyAmount(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isMoney
					}
					else
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Government_Loan"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchHELOC(Node currentNode)
	{
		boolean result = true;
		
		//Adjustment
		if(currentNode.getNodeName().toLowerCase().equals("HELOC".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchHELOC_Occurences(currentNode))
						if(!matchHELOC_Rule(currentNode))
							//report error
							errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "HELOC"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchHELOC_Occurences(Node currentNode)
	{
		boolean result = true;
		
		//Adjustment
		if(currentNode.getNodeName().toLowerCase().equals("HELOC_Occurences".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchHELOC_Occurence(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "HELOC_Occurences"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchHELOC_Occurence(Node currentNode)
	{
		boolean result = true;
		
		//Adjustment
		if(currentNode.getNodeName().toLowerCase().equals("HELOC_Occurence".toLowerCase())){
			//Create Java Object
			((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getHELOC().getHELOC_Occurrences().add(new HELOC_Occurence());
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//HELOCBalanceAmount
					if(currentNode.getNodeName().toLowerCase().equals("HELOCBalanceAmount".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("HELOCBalanceAmount"));
						}
						//if node information is an amount of money
						else if(isMoney(currentNode, 12, 2)){
							//get Deal_Sets, then the last Deal_Set //get Deals, get last Deal, get last Loan, get HELOC, get last HELOC_Occurence, set HELOCBalanceAmount
							((HELOC_Occurence) ((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getHELOC().getLast("HELOC_Occurence")).setHELOCBalanceAmount(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isMoney
					}
					else
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "HELOC_Occurence"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchHELOC_Rule(Node currentNode)
	{
		boolean result = true;
		
		//Adjustment
		if(currentNode.getNodeName().toLowerCase().equals("HELOC_Rule".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//HELOCMaximumBalanceAmount
					if(currentNode.getNodeName().toLowerCase().equals("HELOCMaximumBalanceAmount".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("HELOCMaximumBalanceAmount"));
						}
						//if node information is an amount of money
						else if(isMoney(currentNode, 12, 2)){
							//get Deal_Sets, then the last Deal_Set //get Deals, get last Deal, get last Loan, get HELOC, get HELOC_Rule, set HELOCMaximumBalanceAmount
							((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getHELOC().getHELOC_Rule().setHELOCMaximumBalanceAmount(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isMoney
					}
					else
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "HELOC_Rule"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchHMDA_Loan(Node currentNode)
	{
		boolean result = true;
		
		//HMDA_Loan
		if(currentNode.getNodeName().toLowerCase().equals("HMDA_Loan".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchHMDA_Loan_Detail(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "HMDA_Loan"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchHMDA_Loan_Detail(Node currentNode)
	{
		boolean result = true;
		
		//Adjustment
		if(currentNode.getNodeName().toLowerCase().equals("HMDA_LOAN_DETAIL".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//HMDA_HOEPALoanStatusIndicator
					if(currentNode.getNodeName().toLowerCase().equals("HMDA_HOEPALoanStatusIndicator".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("HMDA_HOEPALoanStatusIndicator"));
						}
						//if node information is a boolean
						else if(ComputeError.isBoolean(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Loan, get HMDA_Loan_Detail, set HMDA_HOEPALoanStatusIndicator
							if(currentNode.getFirstChild().getNodeValue().toLowerCase().equals("true"))
								((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getHMDA_Loan().getHMDA_Loan_Detail().setHMDA_HOEPALoanStatusIndicator(true);
							else if(currentNode.getFirstChild().getNodeValue().toLowerCase().equals("false"))
								((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getHMDA_Loan().getHMDA_Loan_Detail().setHMDA_HOEPALoanStatusIndicator(false);
						}
						else{
							//report error
							errorList.add(PrintError.notABoolean(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue()));
						}
					}
					//HMDARateSpreadPercent
					else if(currentNode.getNodeName().toLowerCase().equals("HMDARateSpreadPercent".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("HMDARateSpreadPercent"));
						}
						//if node information is an amount of money
						else if(isPositiveOrZeroPercentage(currentNode, 2, 2)){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Loan, get HMDA_Loan_Detail, set HMDARateSpreadPercent
							((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getHMDA_Loan().getHMDA_Loan_Detail().setHMDARateSpreadPercent(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isPositiveOrZeroPercentage
					}
					else
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "HMDA_LOAN_DETAIL"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchHousing_Expenses(Node currentNode)
	{
		boolean result = true;
		
		//Adjustment
		if(currentNode.getNodeName().toLowerCase().equals("Housing_Expenses".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchHousing_Expense(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Housing_Expenses"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchHousing_Expense(Node currentNode)
	{
		boolean result = true;
		
		//Adjustment
		if(currentNode.getNodeName().toLowerCase().equals("Housing_Expense".toLowerCase())){
			//Create Java Object
			((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getHousing_Expenses().add(new Housing_Expense());
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					
					//HousingExpensePaymentAmount
					if(currentNode.getNodeName().toLowerCase().equals("HousingExpensePaymentAmount".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("HousingExpensePaymentAmount"));
						}
						//if node information is an amount of money
						else if(isMoney(currentNode, 12, 2)){
							//get Deal_Sets, then the last Deal_Set //get Deals, get last Deal, get last Loan, get last Housing_Expense, set HousingExpensePaymentAmount
							((Housing_Expense) ((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getLast("Housing_Expense")).setHousingExpensePaymentAmount(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isMoney
					}
					//HousingExpenseTimingType
					else if(currentNode.getNodeName().toLowerCase().equals("HousingExpenseTimingType".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("HousingExpenseTimingType"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getHousingExpenseTimingType().contains(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, get last Deal, get last Loan, get last Housing_Expense, set HousingExpenseTimingType
							((Housing_Expense) ((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getLast("Housing_Expense")).setHousingExpenseTimingType(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getHousingExpenseTimingType()));
					}
					//HousingExpenseType
					else if(currentNode.getNodeName().toLowerCase().equals("HousingExpenseType".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("HousingExpenseType"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getHousingExpenseType().contains(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, get last Deal, get last Loan, get last Housing_Expense, set HousingExpenseType
							((Housing_Expense) ((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getLast("Housing_Expense")).setHousingExpenseType(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getHousingExpenseType()));
					}
					else
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Housing_Expense"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchInterest_Only(Node currentNode)
	{
		boolean result = true;
		
		//Adjustment
		if(currentNode.getNodeName().toLowerCase().equals("Interest_Only".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//InterestOnlyTermMonthsCount
					if(currentNode.getNodeName().toLowerCase().equals("InterestOnlyTermMonthsCount".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("InterestOnlyTermMonthsCount"));
						}
						//if node information is a positive or zero number
						else if(isPositiveOrZeroInteger(currentNode,1,360)){
							//get Deal_Sets, then the last Deal_Set //get Deals, get last Deal, get last Loan, get Interest_Only, set InterestOnlyTermMonthsCount
							((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getInterest_Only().setInterestOnlyTermMonthsCount(Integer.parseInt(currentNode.getFirstChild().getNodeValue()));
						}
						//error reporting happens in isPositiveOrZeroInteger
					}	
					else
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Interest_Only"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchInvestor_Features(Node currentNode)
	{
		boolean result = true;
		
		//Adjustment
		if(currentNode.getNodeName().toLowerCase().equals("Investor_Features".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchInvestor_Feature(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Investor_Features"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchInvestor_Feature(Node currentNode)
	{
		boolean result = true;
		
		//Adjustment
		if(currentNode.getNodeName().toLowerCase().equals("Investor_Feature".toLowerCase())){
			//Create Java Object
			((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getInvestor_Features().add(new Investor_Feature());
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//InvestorFeatureIdentifier
					if(currentNode.getNodeName().toLowerCase().equals("InvestorFeatureIdentifier".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("InvestorFeatureIdentifier"));
						}
						//if node information is a string in length from 3 to 3
						else if(ComputeError.isWithinStringLength(currentNode.getFirstChild().getNodeValue(),3,3)){
							//get last Deal_Set, get last Deal, get last Loan, get last Investor_Feature, set InvestorFeatureIdentifier
							((Investor_Feature) ((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getLast("Investor_Feature")).setInvestorFeatureIdentifier(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.stringLengthOutsideRange(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(),3,3));
					}
					else
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Investor_Feature"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchInvestor_Loan_Information(Node currentNode)
	{
		boolean result = true;
		
		//Adjustment
		if(currentNode.getNodeName().toLowerCase().equals("Investor_Loan_Information".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//InvestorProductPlanIdentifier
					if(currentNode.getNodeName().toLowerCase().equals("InvestorProductPlanIdentifier".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("InvestorProductPlanIdentifier"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getInvestorProductPlanIdentifier().contains(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, get last Deal, get last Loan, get Investor_Loan_Information, set InvestorProductPlanIdentifier
							((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getInvestor_Loan_Information().setInvestorProductPlanIdentifier(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getInvestorProductPlanIdentifier()));
					}
					else
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Investor_Loan_Information"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchLoan_Detail(Node currentNode)
	{
		boolean result = true;
		
		//Adjustment
		if(currentNode.getNodeName().toLowerCase().equals("Loan_Detail".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					
					//ApplicationReceivedDate
					if(currentNode.getNodeName().toLowerCase().equals("ApplicationReceivedDate".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("ApplicationReceivedDate"));
						}
						//if node information is a date time value
						else if(ComputeError.isDate(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, get last Deal, get last Loan, get Loan_Detail, set ApplicationReceivedDate
							((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getLoan_Detail().setApplicationReceivedDate(Utility.setDate(currentNode.getFirstChild().getNodeValue()));
						}
						else
							//report error
							errorList.add(PrintError.notADate(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue()));
					}
					//BalloonIndicator
					else if(currentNode.getNodeName().toLowerCase().equals("BalloonIndicator".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("BalloonIndicator"));
						}
						//if node information is a boolean
						else if(ComputeError.isBoolean(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Loan, get Loan_Detail, set BalloonIndicator
							if(currentNode.getFirstChild().getNodeValue().toLowerCase().equals("true"))
								((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getLoan_Detail().setBalloonIndicator(true);
							else if(currentNode.getFirstChild().getNodeValue().toLowerCase().equals("false"))
								((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getLoan_Detail().setBalloonIndicator(false);
						}
						else{
							//report error
							errorList.add(PrintError.notABoolean(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue()));
						}
					}
					//BelowMarketSubordinateFinancingIndicator
					else if(currentNode.getNodeName().toLowerCase().equals("BelowMarketSubordinateFinancingIndicator".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("BelowMarketSubordinateFinancingIndicator"));
						}
						//if node information is a boolean
						else if(ComputeError.isBoolean(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Loan, get Loan_Detail, set BelowMarketSubordinateFinancingIndicator
							if(currentNode.getFirstChild().getNodeValue().toLowerCase().equals("true"))
								((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getLoan_Detail().setBelowMarketSubordinateFinancingIndicator(true);
							else if(currentNode.getFirstChild().getNodeValue().toLowerCase().equals("false"))
								((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getLoan_Detail().setBelowMarketSubordinateFinancingIndicator(false);
						}
						else{
							//report error
							errorList.add(PrintError.notABoolean(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue()));
						}
					}
					//BorrowerCount
					else if(currentNode.getNodeName().toLowerCase().equals("BorrowerCount".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("BorrowerCount"));
						}
						//if node information is a positive or zero number
						else if(isPositiveOrZeroInteger(currentNode,1,360)){
							//get Deal_Sets, then the last Deal_Set //get Deals, get last Deal, get last Loan, get Loan_Detail, set BorrowerCount
							((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getLoan_Detail().setBorrowerCount(Integer.parseInt(currentNode.getFirstChild().getNodeValue()));
						}
						//error reporting happens in isPositiveOrZeroInteger
					}
					//BuydownTemporarySubsidyFundingIndicator
					else if(currentNode.getNodeName().toLowerCase().equals("BuydownTemporarySubsidyFundingIndicator".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("BuydownTemporarySubsidyFundingIndicator"));
						}
						//if node information is a boolean
						else if(ComputeError.isBoolean(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Loan, get Loan_Detail, set BuydownTemporarySubsidyFundingIndicator
							if(currentNode.getFirstChild().getNodeValue().toLowerCase().equals("true"))
								((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getLoan_Detail().setBuydownTemporarySubsidyFundingIndicator(true);
							else if(currentNode.getFirstChild().getNodeValue().toLowerCase().equals("false"))
								((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getLoan_Detail().setBuydownTemporarySubsidyFundingIndicator(false);
						}
						else{
							//report error
							errorList.add(PrintError.notABoolean(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue()));
						}
					}
					//ConstructionLoanIndicator
					else if(currentNode.getNodeName().toLowerCase().equals("ConstructionLoanIndicator".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("ConstructionLoanIndicator"));
						}
						//if node information is a boolean
						else if(ComputeError.isBoolean(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Loan, get Loan_Detail, set ConstructionLoanIndicator
							if(currentNode.getFirstChild().getNodeValue().toLowerCase().equals("true"))
								((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getLoan_Detail().setConstructionLoanIndicator(true);
							else if(currentNode.getFirstChild().getNodeValue().toLowerCase().equals("false"))
								((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getLoan_Detail().setConstructionLoanIndicator(false);
						}
						else{
							//report error
							errorList.add(PrintError.notABoolean(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue()));
						}
					}
					//ConversionOfContractForDeedIndicator
					else if(currentNode.getNodeName().toLowerCase().equals("ConversionOfContractForDeedIndicator".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("ConversionOfContractForDeedIndicator"));
						}
						//if node information is a boolean
						else if(ComputeError.isBoolean(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Loan, get Loan_Detail, set ConversionOfContractForDeedIndicator
							if(currentNode.getFirstChild().getNodeValue().toLowerCase().equals("true"))
								((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getLoan_Detail().setConversionOfContractForDeedIndicator(true);
							else if(currentNode.getFirstChild().getNodeValue().toLowerCase().equals("false"))
								((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getLoan_Detail().setConversionOfContractForDeedIndicator(false);
						}
						else{
							//report error
							errorList.add(PrintError.notABoolean(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue()));
						}
					}
					//EnergyRelatedImprovementsIndicator
					else if(currentNode.getNodeName().toLowerCase().equals("EnergyRelatedImprovementsIndicator".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("EnergyRelatedImprovementsIndicator"));
						}
						//if node information is a boolean
						else if(ComputeError.isBoolean(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Loan, get Loan_Detail, set EnergyRelatedImprovementsIndicator
							if(currentNode.getFirstChild().getNodeValue().toLowerCase().equals("true"))
								((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getLoan_Detail().setEnergyRelatedImprovementsIndicator(true);
							else if(currentNode.getFirstChild().getNodeValue().toLowerCase().equals("false"))
								((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getLoan_Detail().setEnergyRelatedImprovementsIndicator(false);
						}
						else{
							//report error
							errorList.add(PrintError.notABoolean(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue()));
						}
					}
					//HELOCIndicator
					else if(currentNode.getNodeName().toLowerCase().equals("HELOCIndicator".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("HELOCIndicator"));
						}
						//if node information is a boolean
						else if(ComputeError.isBoolean(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Loan, get Loan_Detail, set HELOCIndicator
							if(currentNode.getFirstChild().getNodeValue().toLowerCase().equals("true"))
								((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getLoan_Detail().setHELOCIndicator(true);
							else if(currentNode.getFirstChild().getNodeValue().toLowerCase().equals("false"))
								((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getLoan_Detail().setHELOCIndicator(false);
						}
						else{
							//report error
							errorList.add(PrintError.notABoolean(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue()));
						}
					}
					//InitialFixedPeriodEffectiveMonthsCount
					else if(currentNode.getNodeName().toLowerCase().equals("InitialFixedPeriodEffectiveMonthsCount".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("InitialFixedPeriodEffectiveMonthsCount"));
						}
						//if node information is a positive or zero number
						else if(isPositiveOrZeroInteger(currentNode,1,360)){
							//get Deal_Sets, then the last Deal_Set //get Deals, get last Deal, get last Loan, get Loan_Detail, set InitialFixedPeriodEffectiveMonthsCount
							((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getLoan_Detail().setInitialFixedPeriodEffectiveMonthsCount(Integer.parseInt(currentNode.getFirstChild().getNodeValue()));
						}
						//error reporting happens in isPositiveOrZeroInteger
					}	
					//InterestOnlyIndicator
					else if(currentNode.getNodeName().toLowerCase().equals("InterestOnlyIndicator".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("InterestOnlyIndicator"));
						}
						//if node information is a boolean
						else if(ComputeError.isBoolean(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Loan, get Loan_Detail, set InterestOnlyIndicator
							if(currentNode.getFirstChild().getNodeValue().toLowerCase().equals("true"))
								((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getLoan_Detail().setInterestOnlyIndicator(true);
							else if(currentNode.getFirstChild().getNodeValue().toLowerCase().equals("false"))
								((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getLoan_Detail().setInterestOnlyIndicator(false);
						}
						else{
							//report error
							errorList.add(PrintError.notABoolean(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue()));
						}
					}
					//NegativeAmortizationIndicator
					else if(currentNode.getNodeName().toLowerCase().equals("NegativeAmortizationIndicator".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("NegativeAmortizationIndicator"));
						}
						//if node information is a boolean
						else if(ComputeError.isBoolean(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Loan, get Loan_Detail, set NegativeAmortizationIndicator
							if(currentNode.getFirstChild().getNodeValue().toLowerCase().equals("true"))
								((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getLoan_Detail().setNegativeAmortizationIndicator(true);
							else if(currentNode.getFirstChild().getNodeValue().toLowerCase().equals("false"))
								((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getLoan_Detail().setNegativeAmortizationIndicator(false);
						}
						else{
							//report error
							errorList.add(PrintError.notABoolean(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue()));
						}
					}
					//PrepaymentPenaltyIndicator
					else if(currentNode.getNodeName().toLowerCase().equals("PrepaymentPenaltyIndicator".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("PrepaymentPenaltyIndicator"));
						}
						//if node information is a boolean
						else if(ComputeError.isBoolean(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Loan, get Loan_Detail, set PrepaymentPenaltyIndicator
							if(currentNode.getFirstChild().getNodeValue().toLowerCase().equals("true"))
								((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getLoan_Detail().setPrepaymentPenaltyIndicator(true);
							else if(currentNode.getFirstChild().getNodeValue().toLowerCase().equals("false"))
								((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getLoan_Detail().setPrepaymentPenaltyIndicator(false);
						}
						else{
							//report error
							errorList.add(PrintError.notABoolean(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue()));
						}
					}
					//RenovationLoanIndicator
					else if(currentNode.getNodeName().toLowerCase().equals("RenovationLoanIndicator".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("RenovationLoanIndicator"));
						}
						//if node information is a boolean
						else if(ComputeError.isBoolean(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Loan, get Loan_Detail, set RenovationLoanIndicator
							if(currentNode.getFirstChild().getNodeValue().toLowerCase().equals("true"))
								((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getLoan_Detail().setRenovationLoanIndicator(true);
							else if(currentNode.getFirstChild().getNodeValue().toLowerCase().equals("false"))
								((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getLoan_Detail().setRenovationLoanIndicator(false);
						}
						else{
							//report error
							errorList.add(PrintError.notABoolean(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue()));
						}
					}
					//TotalSubordinateFinancingAmount
					else if(currentNode.getNodeName().toLowerCase().equals("TotalSubordinateFinancingAmount".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("TotalSubordinateFinancingAmount"));
						}
						//if node information is an amount of money
						else if(isMoney(currentNode, 12, 2)){
							//get Deal_Sets, then the last Deal_Set //get Deals, get last Deal, get last Loan, get Loan_Detail, set TotalSubordinateFinancingAmount
							((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getLoan_Detail().setTotalSubordinateFinancingAmount(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isMoney
					}
					//EXTENSION
					else if(!matchLoan_DetailExtension(currentNode))
							//report error
							errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Loan_Detail"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchLoan_DetailExtension(Node currentNode)
	{
		boolean result = true;
		
		//Extension
		if(currentNode.getNodeName().toLowerCase().equals("Extension".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchLoan_DetailExtensionOther(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Extension"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchLoan_DetailExtensionOther(Node currentNode)
	{
		boolean result = true;
		
		//Other
		if(currentNode.getNodeName().toLowerCase().equals("Other".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchLoan_Detail_Extension(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Other"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchLoan_Detail_Extension(Node currentNode)
	{
		boolean result = true;
		
		//Adjustment
		if(currentNode.getNodeName().toLowerCase().equals("DU:Loan_Detail_Extension".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//EnergyImprovementAmount
					if(currentNode.getNodeName().toLowerCase().equals("DU:EnergyImprovementAmount".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("DU:EnergyImprovementAmount"));
						}
						//if node information is an amount of money
						else if(isMoney(currentNode, 12, 2)){
							//get Deal_Sets, then the last Deal_Set //get Deals, get last Deal, get last Loan, get Loan_Detail, get Extension, get Other, get Loan_Detail_Extension, set EnergyImprovementAmount
							((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getLoan_Detail().getExtension().getOther().getLoan_Detail_Extension().setEnergyImprovementAmount(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isMoney
					}
					//PACELoanPayoffAmount
					else if(currentNode.getNodeName().toLowerCase().equals("DU:EnergyImprovementAmount".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("DU:EnergyImprovementAmount"));
						}
						//if node information is an amount of money
						else if(isMoney(currentNode, 12, 2)){
							//get Deal_Sets, then the last Deal_Set //get Deals, get last Deal, get last Loan, get Loan_Detail, get Extension, get Other, get Loan_Detail_Extension, set EnergyImprovementAmount
							((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getLoan_Detail().getExtension().getOther().getLoan_Detail_Extension().setEnergyImprovementAmount(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isMoney
					}
					else
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "DU:Loan_Detail_Extension"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
		
	public boolean matchLoan_Identifiers(Node currentNode)
	{
		boolean result = true;
		
		//Adjustment
		if(currentNode.getNodeName().toLowerCase().equals("Loan_Identifiers".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchLoan_Identifier(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Loan_Identifiers"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchLoan_Identifier(Node currentNode)
	{
		boolean result = true;
		
		//Adjustment
		if(currentNode.getNodeName().toLowerCase().equals("Loan_Identifier".toLowerCase())){
			//Create Java Object
			((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getLoan_Identifiers().add(new Loan_Identifier());
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//LoanIdentifier
					if(currentNode.getNodeName().toLowerCase().equals("LoanIdentifier".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("LoanIdentifier"));
						}
						//if node information is a string in length from 1 to 45
						else if(ComputeError.isWithinStringLength(currentNode.getFirstChild().getNodeValue(),1,45)){
							//get Deal_Sets, then the last Deal_Set //get Deals, get last Deal, get last Loan, get last Loan_Identifier, set LoanIdentifier
							((Loan_Identifier) ((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getLast("Loan_Identifier")).setLoanIdentifier(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.stringLengthOutsideRange(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(),1,45));
					}
					//LoanIdentifierType
					else if(currentNode.getNodeName().toLowerCase().equals("LoanIdentifierType".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("LoanIdentifierType"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getLoanIdentifierType().contains(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, get last Deal, get last Loan, get last Loan_Identifier, set LoanIdentifierType
							((Loan_Identifier) ((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getLast("Loan_Identifier")).setLoanIdentifierType(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getLoanIdentifierType()));
					}
					else
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Loan_Identifier"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchLoan_Product(Node currentNode)
	{
		boolean result = true;
		
		//Adjustment
		if(currentNode.getNodeName().toLowerCase().equals("Loan_Product".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchLoan_Product_Detail(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Loan_Product"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchLoan_Product_Detail(Node currentNode)
	{
		boolean result = true;
		
		//Adjustment
		if(currentNode.getNodeName().toLowerCase().equals("Loan_Product_Detail".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//ProductDescription
					if(currentNode.getNodeName().toLowerCase().equals("ProductDescription".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("ProductDescription"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getProductDescription().contains(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, get last Deal, get last Loan, get Loan_Product, get Loan_Product_Detail, set ProductDescription
							((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getLoan_Product().getLoan_Product_Detail().setProductDescription(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getProductDescription()));
					}
					else
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Loan_Product_Detail"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchMaturity(Node currentNode)
	{
		boolean result = true;
		
		//Adjustment
		if(currentNode.getNodeName().toLowerCase().equals("Maturity".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchMaturity_Rule(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Maturity"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchMaturity_Rule(Node currentNode)
	{
		boolean result = true;
		
		//Adjustment
		if(currentNode.getNodeName().toLowerCase().equals("Maturity_Rule".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//LoanMaturityPeriodType
					if(currentNode.getNodeName().toLowerCase().equals("LoanMaturityPeriodType".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("LoanMaturityPeriodType"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getLoanMaturityPeriodType().contains(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, get last Deal, get last Loan, get Maturity, get Maturity_Rule, set LoanMaturityPeriodType
							((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getMaturity().getMaturity_Rule().setLoanMaturityPeriodType(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getLoanMaturityPeriodType()));
					}
					//LoanMaturityPeriodCount
					else if(currentNode.getNodeName().toLowerCase().equals("LoanMaturityPeriodCount".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("LoanMaturityPeriodCount"));
						}
						//if node information is a positive or zero number
						else if(isPositiveOrZeroInteger(currentNode,1,360)){
							//get Deal_Sets, then the last Deal_Set //get Deals, get last Deal, get last Loan, get Maturity, get Maturity_Rule, set LoanMaturityPeriodCount
							((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getMaturity().getMaturity_Rule().setLoanMaturityPeriodCount((Integer.parseInt(currentNode.getFirstChild().getNodeValue())));
						}
						//error reporting happens in isPositiveOrZeroInteger
					}	
					else
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Maturity_Rule"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchMI_Data(Node currentNode)
	{
		boolean result = true;
		
		//Adjustment
		if(currentNode.getNodeName().toLowerCase().equals("MI_Data".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchMI_Data_Detail(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "MI_Data"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchMI_Data_Detail(Node currentNode)
	{
		boolean result = true;
		
		//Adjustment
		if(currentNode.getNodeName().toLowerCase().equals("MI_Data_Detail".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//MICoveragePercent
					if(currentNode.getNodeName().toLowerCase().equals("MICoveragePercent".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("MICoveragePercent"));
						}
						//if node information is an amount of money
						else if(isPositiveOrZeroPercentage(currentNode, 3, 4)){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Loan, get MI_Data, get MI_Data_Detail, set MICoveragePercent
							((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getMI_Data().getMI_Data_Detail().setMICoveragePercent(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isPositiveOrZeroPercentage
					}
					else
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "MI_Data_Detail"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchNegative_Amortization(Node currentNode)
	{
		boolean result = true;
		
		//Adjustment
		if(currentNode.getNodeName().toLowerCase().equals("Negative_Amortization".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchNegative_Amortization_Rule(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Negative_Amortization"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchNegative_Amortization_Rule(Node currentNode)
	{
		boolean result = true;
		
		//Adjustment
		if(currentNode.getNodeName().toLowerCase().equals("Negative_Amortization_Rule".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//NegativeAmortizationType
					if(currentNode.getNodeName().toLowerCase().equals("NegativeAmortizationType".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("NegativeAmortizationType"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getNegativeAmortizationType().contains(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, get last Deal, get last Loan, get Negative_Amortization, get Negative_Amortization_Rule, set NegativeAmortizationType
							((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getNegative_Amortization().getNegative_Amortization_Rule().setNegativeAmortizationType(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getNegativeAmortizationType()));
					}
					else
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Negative_Amortization_Rule"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchOrigination_Funds(Node currentNode)
	{
		boolean result = true;
		
		//Adjustment
		if(currentNode.getNodeName().toLowerCase().equals("Origination_Funds".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchOrigination_Fund(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Origination_Funds"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchOrigination_Fund(Node currentNode)
	{
		boolean result = true;
		
		//Adjustment
		if(currentNode.getNodeName().toLowerCase().equals("Origination_Fund".toLowerCase())){
			//Create Java Object
			((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getOrigination_Funds().add(new Origination_Fund());
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//FundsSourceType
					if(currentNode.getNodeName().toLowerCase().equals("FundsSourceType".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("FundsSourceType"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getFundsSourceType().contains(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, get last Deal, get last Loan, get last Origination_Fund, set FundsSourceType
							((Origination_Fund) ((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getLast("Origination_Fund")).setFundsSourceType(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getFundsSourceType()));
					}
					//FundsSourceTypeOtherDescription
					else if(currentNode.getNodeName().toLowerCase().equals("FundsSourceTypeOtherDescription".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("FundsSourceTypeOtherDescription"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getFundsSourceTypeOtherDescription().contains(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, get last Deal, get last Loan, get last Origination_Fund, set FundsSourceTypeOtherDescription
							((Origination_Fund) ((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getLast("Origination_Fund")).setFundsSourceTypeOtherDescription(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getFundsSourceTypeOtherDescription()));
					}
					else
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Origination_Fund"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchPayment(Node currentNode)
	{
		boolean result = true;
		
		//Adjustment
		if(currentNode.getNodeName().toLowerCase().equals("Payment".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchPayment_Rule(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Payment"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchPayment_Rule(Node currentNode)
	{
		boolean result = true;
		
		//Adjustment
		if(currentNode.getNodeName().toLowerCase().equals("Payment_Rule".toLowerCase())){
			//Create Java Object
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//InitialPrincipalAndInterestPaymentAmount
					if(currentNode.getNodeName().toLowerCase().equals("InitialPrincipalAndInterestPaymentAmount".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("InitialPrincipalAndInterestPaymentAmount"));
						}
						//if node information is an amount of money
						else if(isMoney(currentNode, 12, 2)){
							//get Deal_Sets, then the last Deal_Set //get Deals, get last Deal, get last Loan, get Payment, get Payment_Rule, set InitialPrincipalAndInterestPaymentAmount
							((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getPayment().getPayment_Rule().setInitialPrincipalAndInterestPaymentAmount(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isMoney
					}
					else
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Payment_Rule"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchPrepayment_Penalty(Node currentNode)
	{
		boolean result = true;
		
		//Adjustment
		if(currentNode.getNodeName().toLowerCase().equals("Prepayment_Penalty".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchPrepayment_Penalty_Lifetime_Rule(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Prepayment_Penalty"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchPrepayment_Penalty_Lifetime_Rule(Node currentNode)
	{
		boolean result = true;
		
		//Adjustment
		if(currentNode.getNodeName().toLowerCase().equals("Prepayment_Penalty_Lifetime_Rule".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//PrepaymentPenaltyExpirationMonthsCount
					if(currentNode.getNodeName().toLowerCase().equals("PrepaymentPenaltyExpirationMonthsCount".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("PrepaymentPenaltyExpirationMonthsCount"));
						}
						//if node information is a positive or zero number
						else if(isPositiveOrZeroInteger(currentNode,1,360)){
							//get Deal_Sets, then the last Deal_Set //get Deals, get last Deal, get last Loan, get Prepayment_Penalty, get Prepayment_Penalty_Lifetime_Rule, set PrepaymentPenaltyExpirationMonthsCount
							((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getPrepayment_Penalty().getPrepayment_Penalty_Lifetime_Rule().setPrepaymentPenaltyExpirationMonthsCount(Integer.parseInt(currentNode.getFirstChild().getNodeValue()));
						}
						//error reporting happens in isPositiveOrZeroInteger
					}	
					else
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Prepayment_Penalty_Lifetime_Rule"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchPurchase_Credits(Node currentNode)
	{
		boolean result = true;
		
		//Adjustment
		if(currentNode.getNodeName().toLowerCase().equals("Purchase_Credits".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchPurchase_Credit(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Purchase_Credits"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchPurchase_Credit(Node currentNode)
	{
		boolean result = true;
		
		//Adjustment
		if(currentNode.getNodeName().toLowerCase().equals("Purchase_Credit".toLowerCase())){
			//Create Java Object
			((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getPurchase_Credits().add(new Purchase_Credit());
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//PurchaseCreditAmount
					if(currentNode.getNodeName().toLowerCase().equals("PurchaseCreditAmount".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("PurchaseCreditAmount"));
						}
						//if node information is an amount of money
						else if(isMoney(currentNode, 12, 2)){
							//get Deal_Sets, then the last Deal_Set //get Deals, get last Deal, get last Loan, get last Purchase_Credit, set PurchaseCreditAmount
							((Purchase_Credit) ((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getLast("Purchase_Credit")).setPurchaseCreditAmount(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isMoney
					}
					//PurchaseCreditType
					else if(currentNode.getNodeName().toLowerCase().equals("PurchaseCreditType".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("PurchaseCreditType"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getPurchaseCreditType().contains(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, get last Deal, get last Loan, get last Origination_Fund, set PurchaseCreditType
							((Purchase_Credit) ((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getLast("Purchase_Credit")).setPurchaseCreditType(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getPurchaseCreditType()));
					}
					//PurchaseCreditTypeOtherDescription
					else if(currentNode.getNodeName().toLowerCase().equals("PurchaseCreditTypeOtherDescription".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("PurchaseCreditTypeOtherDescription"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getPurchaseCreditTypeOtherDescription().contains(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, get last Deal, get last Loan, get last Origination_Fund, set PurchaseCreditTypeOtherDescription
							((Purchase_Credit) ((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getLast("Purchase_Credit")).setPurchaseCreditTypeOtherDescription(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getPurchaseCreditTypeOtherDescription()));
					}
					else
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Purchase_Credit"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchQualification(Node currentNode)
	{
		boolean result = true;
		
		//Adjustment
		if(currentNode.getNodeName().toLowerCase().equals("Qualification".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//QualifyingRatePercent
					if(currentNode.getNodeName().toLowerCase().equals("QualifyingRatePercent".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("QualifyingRatePercent"));
						}
						//if node information is an amount of money
						else if(isPositiveOrZeroPercentage(currentNode, 3, 4)){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Loan, get Qualification, set QualifyingRatePercent
							((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getQualification().setQualifyingRatePercent(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isPositiveOrZeroPercentage
					}
					else
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Qualification"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchRefinance(Node currentNode)
	{
		boolean result = true;
		
		//Adjustment
		if(currentNode.getNodeName().toLowerCase().equals("Refinance".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//CurrentFirstMortgageHolderType
					if(currentNode.getNodeName().toLowerCase().equals("CurrentFirstMortgageHolderType".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("CurrentFirstMortgageHolderType"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getCurrentFirstMortgageHolderType().contains(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, get last Deal, get last Loan, get Refinance, set CurrentFirstMortgageHolderType
							((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getRefinance().setCurrentFirstMortgageHolderType(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getCurrentFirstMortgageHolderType()));
					}
					//RefinanceCashOutDeterminationType
					else if(currentNode.getNodeName().toLowerCase().equals("RefinanceCashOutDeterminationType".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("RefinanceCashOutDeterminationType"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getRefinanceCashOutDeterminationType().contains(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, get last Deal, get last Loan, get Refinance, set RefinanceCashOutDeterminationType
							((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getRefinance().setRefinanceCashOutDeterminationType(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getRefinanceCashOutDeterminationType()));
					}
					else
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Refinance"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchTerms_Of_Loan(Node currentNode)
	{
		boolean result = true;
		
		//Adjustment
		if(currentNode.getNodeName().toLowerCase().equals("Terms_Of_Loan".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//BaseLoanAmount
					if(currentNode.getNodeName().toLowerCase().equals("BaseLoanAmount".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("BaseLoanAmount"));
						}
						//if node information is an amount of money
						else if(isMoney(currentNode, 12, 2)){
							//get Deal_Sets, then the last Deal_Set //get Deals, get last Deal, get last Loan, get Terms_of_Loan, set PurchaseCreditAmount
							((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getTerms_Of_Loan().setBaseLoanAmount(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isMoney
					}
					//DisclosedIndexRatePercent
					else if(currentNode.getNodeName().toLowerCase().equals("DisclosedIndexRatePercent".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("DisclosedIndexRatePercent"));
						}
						//if node information is an amount of money
						else if(isPositiveOrZeroPercentage(currentNode, 3, 4)){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Loan, get Terms_of_Loan, set DisclosedIndexRatePercent
							((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getTerms_Of_Loan().setDisclosedIndexRatePercent(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isPositiveOrZeroPercentage
					}
					//LienPriorityType
					else if(currentNode.getNodeName().toLowerCase().equals("LienPriorityType".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("LienPriorityType"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getLienPriorityType().contains(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, get last Deal, get last Loan, get Terms_Of_Loan, set LienPriorityType
							((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getTerms_Of_Loan().setLienPriorityType(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getLienPriorityType()));
					}
					//LoanPurposeType
					else if(currentNode.getNodeName().toLowerCase().equals("LoanPurposeType".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("LoanPurposeType"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getLoanPurposeType().contains(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, get last Deal, get last Loan, get Terms_Of_Loan, set LoanPurposeType
							((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getTerms_Of_Loan().setLoanPurposeType(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getLoanPurposeType()));
					}
					//MortgageType
					else if(currentNode.getNodeName().toLowerCase().equals("MortgageType".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("MortgageType"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getMortgageType().contains(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, get last Deal, get last Loan, get Terms_Of_Loan, set MortgageType
							((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getTerms_Of_Loan().setMortgageType(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getMortgageType()));
					}
					//NoteAmount
					else if(currentNode.getNodeName().toLowerCase().equals("NoteAmount".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("NoteAmount"));
						}
						//if node information is an amount of money
						else if(isMoney(currentNode, 12, 2)){
							//get Deal_Sets, then the last Deal_Set //get Deals, get last Deal, get last Loan, get Terms_of_Loan, set NoteAmount
							((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getTerms_Of_Loan().setNoteAmount(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isMoney
					}
					//NoteRatePercent
					else if(currentNode.getNodeName().toLowerCase().equals("NoteRatePercent".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("NoteRatePercent"));
						}
						//if node information is an amount of money
						else if(isPositiveOrZeroPercentage(currentNode, 4, 3)){
							//get Deal_Sets, then the last Deal_Set //get Deals, get last Deal, get last Loan, get Terms_of_Loan, set NoteRatePercent
							((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getTerms_Of_Loan().setNoteRatePercent(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isMoney
					}
					else
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Terms_Of_Loan"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchUnderwriting(Node currentNode)
	{
		boolean result = true;
		
		//Adjustment
		if(currentNode.getNodeName().toLowerCase().equals("Underwriting".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchAutomated_Underwritings(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Underwriting"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchAutomated_Underwritings(Node currentNode)
	{
		boolean result = true;
		
		//Adjustment
		if(currentNode.getNodeName().toLowerCase().equals("Automated_Underwritings".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchAutomated_Underwriting(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Automated_Underwritings"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchAutomated_Underwriting(Node currentNode)
	{
		boolean result = true;
		
		//Adjustment
		if(currentNode.getNodeName().toLowerCase().equals("Automated_Underwriting".toLowerCase())){
			//Create Java Object
			((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getUnderwriting().getAutomated_Underwritings().add(new Automated_Underwriting());
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//AutomatedUnderwritingCaseIdentifier
					if(currentNode.getNodeName().toLowerCase().equals("AutomatedUnderwritingCaseIdentifier".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("AutomatedUnderwritingCaseIdentifier"));
						}
						//if node information is a string in length from 1 to 30
						else if(ComputeError.isWithinStringLength(currentNode.getFirstChild().getNodeValue(),1,30)){
							//get Deal_Sets, then the last Deal_Set //get Deals, get last Deal, get last Loan, get Underwriting, get last Automated_Underwriting, set AutomatedUnderwritingCaseIdentifier
							((Automated_Underwriting) ((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getUnderwriting().getLast("Automated_Underwriting")).setAutomatedUnderwritingCaseIdentifier(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.stringLengthOutsideRange(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(),1,30));
					}
					else
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Automated_Underwriting"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchParties(Node currentNode)
	{
		boolean result = true;
		
		//Parties
		if(currentNode.getNodeName().toLowerCase().equals("Parties".toLowerCase())){
			//create Java object
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchParty(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Parties"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchParty(Node currentNode)
	{
		boolean result = true;
		
		//Party
		if(currentNode.getNodeName().toLowerCase().equals("Party".toLowerCase())){
			//create Java object
			((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getParties().add(new Party());
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchPartyAddresses(currentNode))
						if(!matchIndividual(currentNode))
							if(!matchLanguages(currentNode))
								if(!matchPartyLegal_Entity(currentNode))
									if(!matchRoles(currentNode))
										if(!matchTaxpayer_Identifiers(currentNode))
											//report error
											errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Party"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchPartyAddresses(Node currentNode)
	{
		boolean result = true;
		
		//Collaterals
		if(currentNode.getNodeName().toLowerCase().equals("Addresses".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchPartyAddress(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Addresses"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchPartyAddress(Node currentNode)
	{
		boolean result = true;
		
		//Collaterals
		if(currentNode.getNodeName().toLowerCase().equals("Address".toLowerCase())){
			//create Java object
			((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getAddresses().add(new information.dU34.Mes.DeaSet.Dea.Par.Address());
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//AddressLineText
					if(currentNode.getNodeName().toLowerCase().equals("AddressLineText".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("Party/Address/AddressLineText"));
						}
						//if node information is string in length from 1 to 35
						else if(ComputeError.isWithinStringLength(currentNode.getFirstChild().getNodeValue(),1,35)){
							//get last Deal_Set, get last Deal, get Party, get last Address, set AddressLineText
							((information.dU34.Mes.DeaSet.Dea.Par.Address) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Address")).setAddressLineText(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.stringLengthOutsideRange(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(),1,35,"Party/Address/"));
					}
					//AddressType
					else if(currentNode.getNodeName().toLowerCase().equals("AddressType".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("Party/Address/AddressType"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getAddressType().contains(currentNode.getFirstChild().getNodeValue())){
							//get last Deal_Set, get last Deal, get Party, get last Address, set AddressType
							((information.dU34.Mes.DeaSet.Dea.Par.Address) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Address")).setAddressType(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getConstructionMethodType(), "Party/Address/"));
					}
					
					//AddressUnitIdentifier
					else if(currentNode.getNodeName().toLowerCase().equals("AddressUnitIdentifier".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("Party/Address/AddressUnitIdentifier"));
						}
						//if node information is a string in length from 1 to 11
						else if(ComputeError.isWithinStringLength(currentNode.getFirstChild().getNodeValue(),1,11)){
							//get last Deal_Set, get last Deal, get Party, get last Address, set AddressUnitIdentifier
							((information.dU34.Mes.DeaSet.Dea.Par.Address) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Address")).setAddressUnitIdentifier(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.stringLengthOutsideRange(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(),1,11,"Party/Address/"));
					}
					//CityName
					else if(currentNode.getNodeName().toLowerCase().equals("CityName".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("Party/Address/CityName"));
						}
						//if node information is a string in length from 1 to 35
						else if(ComputeError.isWithinStringLength(currentNode.getFirstChild().getNodeValue(),1,35)){
							//get last Deal_Set, get last Deal, get Party, get last Address, set CityName
							((information.dU34.Mes.DeaSet.Dea.Par.Address) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Address")).setCityName(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.stringLengthOutsideRange(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(),1,35,"Party/Address/"));
					}
					//CountryCode
					else if(currentNode.getNodeName().toLowerCase().equals("CountryCode".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("Party/Address/CountryCode"));
						}
						//if node information is a string in length from 1 to 2
						else if(ComputeError.isWithinStringLength(currentNode.getFirstChild().getNodeValue(),1,2)){
							//get last Deal_Set, get last Deal, get Party, get last Address, set CountryCode
							((information.dU34.Mes.DeaSet.Dea.Par.Address) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Address")).setCountryCode(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.stringLengthOutsideRange(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(),1,2,"Residence/Address"));
					}
					//PostalCode
					else if(currentNode.getNodeName().toLowerCase().equals("PostalCode".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("Party/Address/PostalCode"));
						}
						//if node information is a string in length from 1 to 9
						else if(ComputeError.isWithinStringLength(currentNode.getFirstChild().getNodeValue(),1,9)){
							//get last Deal_Set, get last Deal, get Party, get last Address, set PostalCode
							((information.dU34.Mes.DeaSet.Dea.Par.Address) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Address")).setPostalCode(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.stringLengthOutsideRange(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(),1,9,"Party/Address/"));
					}
					//StateCode
					else if(currentNode.getNodeName().toLowerCase().equals("StateCode".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("Party/Address/StateCode"));
						}
						//if node information is a string in length from 1 to 2
						else if(ComputeError.isWithinStringLength(currentNode.getFirstChild().getNodeValue(),1,2)){
							//get last Deal_Set, get last Deal, get Party, get last Address, set StateCode
							((information.dU34.Mes.DeaSet.Dea.Par.Address) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Address")).setStateCode(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.stringLengthOutsideRange(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(),1,2,"Party/Address/"));
					}
					else
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Party/Address/"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchIndividual(Node currentNode)
	{
		boolean result = true;
		
		//Individual
		if(currentNode.getNodeName().toLowerCase().equals("Individual".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchAliases(currentNode))
						if(!matchContact_Points(currentNode))
							if(!matchIndividualName(currentNode))
								//report error
								errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Individual"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchAliases(Node currentNode)
	{
		boolean result = true;
		
		//Collaterals
		if(currentNode.getNodeName().toLowerCase().equals("Aliases".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchAlias(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Aliases"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchAlias(Node currentNode)
	{
		boolean result = true;
		
		//Alias
		if(currentNode.getNodeName().toLowerCase().equals("Alias".toLowerCase())){
			//create Java object
			((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getIndividual().getAliases().add(new Alias());
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchAliasName(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Alias"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchAliasName(Node currentNode)
	{
		boolean result = true;
		
		//Name
		if(currentNode.getNodeName().toLowerCase().equals("Name".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//FirstName
					if(currentNode.getNodeName().toLowerCase().equals("FirstName".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("Party/Individual/Aliases/Alias/Name/FirstName"));
						}
						//if node information is string in length from 1 to 35
						else if(ComputeError.isWithinStringLength(currentNode.getFirstChild().getNodeValue(),1,35)){
							//get last Deal_Set //get last Deal, get last Party, get Individual, get last Alias, get Name, set FirstName
							((Alias) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getIndividual().getLast("Alias")).getName().setFirstName(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.stringLengthOutsideRange(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(),1,35, "Party/Individual/Aliases/Alias/Name/"));
					}
					//LastName
					else if(currentNode.getNodeName().toLowerCase().equals("LastName".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("Party/Individual/Aliases/Alias/Name/LastName"));
						}
						//if node information is string in length from 1 to 35
						else if(ComputeError.isWithinStringLength(currentNode.getFirstChild().getNodeValue(),1,35)){
							//get last Deal_Set //get last Deal, get last Party, get Individual, get last Alias, get Name, set LastName
							((Alias) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getIndividual().getLast("Alias")).getName().setLastName(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.stringLengthOutsideRange(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(),1,35, "Party/Individual/Aliases/Alias/Name/"));
					}
					//MiddleName
					else if(currentNode.getNodeName().toLowerCase().equals("MiddleName".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("Party/Individual/Aliases/Alias/Name/MiddleName"));
						}
						//if node information is string in length from 1 to 35
						else if(ComputeError.isWithinStringLength(currentNode.getFirstChild().getNodeValue(),1,35)){
							//get last Deal_Set //get last Deal, get last Party, get Individual, get last Alias, get Name, set MiddleName
							((Alias) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getIndividual().getLast("Alias")).getName().setMiddleName(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.stringLengthOutsideRange(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(),1,35, "Party/Individual/Aliases/Alias/Name/"));
					}
					//SuffixName
					else if(currentNode.getNodeName().toLowerCase().equals("SuffixName".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("Party/Individual/Aliases/Alias/Name/SuffixName"));
						}
						//if node information is string in length from 1 to 4
						else if(ComputeError.isWithinStringLength(currentNode.getFirstChild().getNodeValue(),1,4)){
							//get last Deal_Set //get last Deal, get last Party, get Individual, get last Alias, get Name, set SuffixName
							((Alias) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getIndividual().getLast("Alias")).getName().setSuffixName(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.stringLengthOutsideRange(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(),1,4, "Party/Individual/Aliases/Alias/Name/"));
					}
					else
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Party/Individual/Aliases/Alias/Name/"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchContact_Points(Node currentNode)
	{
		boolean result = true;
		
		//Contact_Points
		if(currentNode.getNodeName().toLowerCase().equals("Contact_Points".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchContact_Point(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Contact_Points"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchContact_Point(Node currentNode)
	{
		boolean result = true;
		
		//Contact_Point
		if(currentNode.getNodeName().toLowerCase().equals("Contact_Point".toLowerCase())){
			//create Java object
			((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getIndividual().getContact_Points().add(new Contact_Point());
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchContact_Point_Detail(currentNode))
						if(!matchContact_Point_Email(currentNode))
							if(!matchContact_Point_Telephone(currentNode))
								//report error
								errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Contact_Point"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchContact_Point_Detail(Node currentNode)
	{
		boolean result = true;
		
		//Contact_Point_Detail
		if(currentNode.getNodeName().toLowerCase().equals("Contact_Point_Detail".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//ContactPointRoleType
					if(currentNode.getNodeName().toLowerCase().equals("ContactPointRoleType".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("ContactPointRoleType"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getContactPointRoleType().contains(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Contact_Point, get Contact_Point_Detail //set ContactPointRoleType
							((Contact_Point) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getIndividual().getLast("Contact_Point")).getContact_Point_Detail().setContactPointRoleType(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getContactPointRoleType()));
					}
					else
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Contact_Point_Detail"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchContact_Point_Email(Node currentNode)
	{
		boolean result = true;
		
		//Collaterals
		if(currentNode.getNodeName().toLowerCase().equals("Contact_Point_Email".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//ContactPointEmailValue
					if(currentNode.getNodeName().toLowerCase().equals("ContactPointEmailValue".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("ContactPointEmailValue"));
						}
						//if node information is string in length from 1 to 80
						else if(ComputeError.isWithinStringLength(currentNode.getFirstChild().getNodeValue(),1,80)){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Contact_Point, get Contact_Point_Email //set ContactPointEmailValue
							((Contact_Point) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getIndividual().getLast("Contact_Point")).getContact_Point_Email().setContactPointEmailValue(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.stringLengthOutsideRange(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(),1,80));
					}
					else
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Contact_Point_Email"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}	
	
	public boolean matchContact_Point_Telephone(Node currentNode)
	{
		boolean result = true;
		
		//Collaterals
		if(currentNode.getNodeName().toLowerCase().equals("Contact_Point_Telephone".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//ContactPointTelephoneValue
					if(currentNode.getNodeName().toLowerCase().equals("ContactPointTelephoneValue".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("ContactPointTelephoneValue"));
						}
						//if a Positive Numeric String of 10 to 10
						else if(isPositiveInteger(currentNode,10,10)){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Contact_Point, get Contact_Point_Telephone //set ContactPointTelephoneValue
							((Contact_Point) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getIndividual().getLast("Contact_Point")).getContact_Point_Telephone().setContactPointTelephoneValue(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isPositiveInteger
					}
					//ContactPointTelephoneExtensionValue
					else if(currentNode.getNodeName().toLowerCase().equals("ContactPointTelephoneExtensionValue".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("ContactPointTelephoneExtensionValue"));
						}
						//if a Positive Numeric String of 6 to 6
						else if(isPositiveInteger(currentNode,6,6)){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Contact_Point, get Contact_Point_Telephone //set ContactPointTelephoneExtensionValue
							((Contact_Point) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getIndividual().getLast("Contact_Point")).getContact_Point_Telephone().setContactPointTelephoneExtensionValue(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isPositiveInteger
					}
					else
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Contact_Point_Telephone"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchIndividualName(Node currentNode)
	{
		boolean result = true;
		
		//Name
		if(currentNode.getNodeName().toLowerCase().equals("Name".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//FirstName
					if(currentNode.getNodeName().toLowerCase().equals("FirstName".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("Party/Individual/Name/FirstName"));
						}
						//if node information is string in length from 1 to 35
						else if(ComputeError.isWithinStringLength(currentNode.getFirstChild().getNodeValue(),1,35)){
							//get last Deal_Set //get last Deal, get last Party, get Individual, get Name, set FirstName
							((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getIndividual().getName().setFirstName(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.stringLengthOutsideRange(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(),1,35, "Party/Individual/Name/"));
					}
					//FullName
					else if(currentNode.getNodeName().toLowerCase().equals("FullName".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("Party/Individual/Name/FullName"));
						}
						//if node information is string in length from 1 to 150
						else if(ComputeError.isWithinStringLength(currentNode.getFirstChild().getNodeValue(),1,150)){
							//get last Deal_Set //get last Deal, get last Party, get Individual, get Name, set FullName
							((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getIndividual().getName().setFullName(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.stringLengthOutsideRange(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(),1,150, "Party/Individual/Name/"));
					}
					//LastName
					else if(currentNode.getNodeName().toLowerCase().equals("LastName".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("Party/Individual/Name/LastName"));
						}
						//if node information is string in length from 1 to 35
						else if(ComputeError.isWithinStringLength(currentNode.getFirstChild().getNodeValue(),1,35)){
							//get last Deal_Set //get last Deal, get last Party, get Individual, get Name, set LastName
							((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getIndividual().getName().setLastName(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.stringLengthOutsideRange(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(),1,35, "Party/Individual/Name/"));
					}
					//MiddleName
					else if(currentNode.getNodeName().toLowerCase().equals("MiddleName".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("Party/Individual/Name/MiddleName"));
						}
						//if node information is string in length from 1 to 35
						else if(ComputeError.isWithinStringLength(currentNode.getFirstChild().getNodeValue(),1,35)){
							//get last Deal_Set //get last Deal, get last Party, get Individual, get Name, set MiddleName
							((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getIndividual().getName().setMiddleName(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.stringLengthOutsideRange(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(),1,35, "Party/Individual/Name/"));
					}
					//SuffixName
					else if(currentNode.getNodeName().toLowerCase().equals("SuffixName".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("Party/Individual/Name/SuffixName"));
						}
						//if node information is string in length from 1 to 4
						else if(ComputeError.isWithinStringLength(currentNode.getFirstChild().getNodeValue(),1,4)){
							//get last Deal_Set //get last Deal, get last Party, get Individual, get Name, set SuffixName
							((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getIndividual().getName().setSuffixName(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.stringLengthOutsideRange(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(),1,4, "Party/Individual/Name/"));
					}
					else
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Party/Individual/Name/"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchLanguages(Node currentNode)
	{
		boolean result = true;
		
		//Languages
		if(currentNode.getNodeName().toLowerCase().equals("Languages".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchLanguage(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Languages"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchLanguage(Node currentNode)
	{
		boolean result = true;
		
		//Language
		if(currentNode.getNodeName().toLowerCase().equals("Language".toLowerCase())){
			//create Java object
			((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLanguages().add(new Language());
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchLanguageExtension(currentNode))
						//LanguageCode
						if(currentNode.getNodeName().toLowerCase().equals("LanguageCode".toLowerCase()))
							//check if value is empty
							if(currentNode.getFirstChild() == null){
								errorList.add(PrintError.missing("LanguageCode"));
							}
							//if node information is an expected enumeration
							else if(Enumeration.getLanguageCode().contains(currentNode.getFirstChild().getNodeValue()))
								//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, then the last Language //set LanguageCode
								 ((Language) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Language")).setLanguageCode(currentNode.getFirstChild().getNodeValue());
							else
								//report error
								errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getLanguageCode()));
						else	
							//report error
							errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Language"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchLanguageExtension(Node currentNode)
	{
		boolean result = true;
		
		//Extension
		if(currentNode.getNodeName().toLowerCase().equals("Extension".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchLanguageExtensionOther(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Extension"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchLanguageExtensionOther(Node currentNode)
	{
		boolean result = true;
		
		//Other
		if(currentNode.getNodeName().toLowerCase().equals("Other".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchLanguageExtensionOtherLanguage_Extension(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Other"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchLanguageExtensionOtherLanguage_Extension(Node currentNode)
	{
		boolean result = true;
		
		//Language_Extension
		if(currentNode.getNodeName().toLowerCase().equals("ULAD:Language_Extension".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//ULAD:LanguageCodeOtherDescription
					if(currentNode.getNodeName().toLowerCase().equals("ULAD:LanguageCodeOtherDescription".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("ULAD:LanguageCodeOtherDescription"));
						}
						//if node information is string in length from 1 to 80
						else if(ComputeError.isWithinStringLength(currentNode.getFirstChild().getNodeValue(),1,80)){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, then the last Language, get Extension, get Other, get Language_Extension, set LanguageCodeOtherDescription
							((Language) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Language")).getExtension().getOther().getLanguage_Extension().setLanguageCodeOtherDescription(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.stringLengthOutsideRange(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(),1,80));
					}
					//ULAD:LanguageRefusalIndicator
					else if(currentNode.getNodeName().toLowerCase().equals("ULAD:LanguageRefusalIndicator".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("ULAD:LanguageRefusalIndicator"));
						}
						//if node information is a boolean
						else if(ComputeError.isBoolean(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, then the last Language, get Extension, get Other, get Language_Extension //set LanguageRefusalIndicator
							if(currentNode.getFirstChild().getNodeValue().toLowerCase().equals("true"))
								((Language) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Language")).getExtension().getOther().getLanguage_Extension().setLanguageRefusalIndicator(true);
							else if(currentNode.getFirstChild().getNodeValue().toLowerCase().equals("false"))
								((Language) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Language")).getExtension().getOther().getLanguage_Extension().setLanguageRefusalIndicator(false);
						}
						else{
							//report error
							errorList.add(PrintError.notABoolean(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue()));
						}
					}	
					else
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "ULAD:Language_Extension"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchPartyLegal_Entity(Node currentNode)
	{
		boolean result = true;
		
		//Legal_Entity
		if(currentNode.getNodeName().toLowerCase().equals("Legal_Entity".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchPartyLegal_Entity_Detail(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Legal_Entity"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchPartyLegal_Entity_Detail(Node currentNode)
	{
		boolean result = true;
		
		//Legal_Entity_Detail
		if(currentNode.getNodeName().toLowerCase().equals("Legal_Entity_Detail".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//FullName
					if(currentNode.getNodeName().toLowerCase().equals("FullName".toLowerCase()))
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("FullName"));
						}
						//if node information is string in length from 1 to 150
						else if(ComputeError.isWithinStringLength(currentNode.getFirstChild().getNodeValue(),1,150)){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get Legal_Entity, get Legal_Entity_Detail //set FullName
							((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLegal_Entity().getLegal_Entity_Detail().setFullName(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.stringLengthOutsideRange(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(),1,150));
					else	
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Legal_Entity_Detail"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchRoles(Node currentNode)
	{
		boolean result = true;
		
		//Roles
		if(currentNode.getNodeName().toLowerCase().equals("Roles".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchRole(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Roles"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchRole(Node currentNode)
	{
		boolean result = true;
		
		//Role
		if(currentNode.getNodeName().toLowerCase().equals("Role".toLowerCase())){
			//create Java object
			((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getRoles().add(new Role());
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//SequenceNumber
					if(currentNode.getNodeName().toLowerCase().equals("SequenceNumber".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("SequenceNumber"));
						}
						//if a Positive Numeric String of 1 to 2
						else if(isPositiveInteger(currentNode,1,2)){
							//get last Deal_Set, get last Deal, get last Party, get last Role, set SequenceNumber
							((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).setSequenceNumber(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isPositiveInteger
					}		
					//xlink:label
					else if(currentNode.getNodeName().toLowerCase().equals("xlink:label".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("xlink:label"));
						}
						//if node information is a string in length from 1 to 1000
						else if(ComputeError.isWithinStringLength(currentNode.getFirstChild().getNodeValue(),1,1000)){
							//get last Deal_Set, get last Deal, get last Party, get last Role, xlink:label
							((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).setXlinklabel(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.stringLengthOutsideRange(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(),1,1000));
					}
					else if(!matchBorrower(currentNode))
							if(!matchLicenses(currentNode))
								if(!matchParty_Role_Identifiers(currentNode))
									if(!matchProperty_Owner(currentNode))
										if(!matchRole_Detail(currentNode))
											if(!matchTrust(currentNode))
												//report error
												errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Role"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchBorrower(Node currentNode)
	{
		boolean result = true;
		
		//Borrower
		if(currentNode.getNodeName().toLowerCase().equals("Borrower".toLowerCase())){
			//create Java object
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchBankruptcies(currentNode))
						if(!matchBorrower_Detail(currentNode))
							if(!matchCounseling(currentNode))
								if(!matchCurrent_Income(currentNode))
									if(!matchDeclaration(currentNode))
										if(!matchDependents(currentNode))
											if(!matchEmployers(currentNode))
												if(!matchGovernment_Borrower(currentNode))
													if(!matchGovernment_Monitoring(currentNode))
														if(!matchMilitary_Services(currentNode))
															if(!matchResidences(currentNode))
																//report error
																errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Borrower"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchBankruptcies(Node currentNode)
	{
		boolean result = true;
		
		//Bankruptcies
		if(currentNode.getNodeName().toLowerCase().equals("Bankruptcies".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchBankruptcy(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Bankruptcies"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchBankruptcy(Node currentNode)
	{
		boolean result = true;
		
		//Bankruptcy
		if(currentNode.getNodeName().toLowerCase().equals("Bankruptcy".toLowerCase())){
			//create Java object
			((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getBankruptcies().add(new Bankruptcy());
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//BankruptcyChapterType
					if(currentNode.getNodeName().toLowerCase().equals("BankruptcyChapterType".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("BankruptcyChapterType"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getBankruptcyChapterType().contains(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Taxpayer_Identifier //set BankruptcyChapterType
							((Bankruptcy) ((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getLast("Bankruptcy")).getBankruptcy_Detail().setBankruptcyChapterType(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getBankruptcyChapterType()));
					}		
					else
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Bankruptcy"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchBorrower_Detail(Node currentNode)
	{
		boolean result = true;
		
		//Dependent
		if(currentNode.getNodeName().toLowerCase().equals("Borrower_Detail".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//BorrowerBirthDate
					if(currentNode.getNodeName().toLowerCase().equals("BorrowerBirthDate".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("BorrowerBirthDate"));
						}
						//if node information is a date time value
						else if(ComputeError.isDate(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Borrower, get Borrower_Detail  //set BorrowerBirthDate
							((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getBorrower_Detail().setBorrowerBirthDate(Utility.setDate(currentNode.getFirstChild().getNodeValue()));
						}
						else
							//report error
							errorList.add(PrintError.notADate(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue()));
					}
					//BorrowerTotalMortgagedPropertiesCount
					else if(currentNode.getNodeName().toLowerCase().equals("BorrowerTotalMortgagedPropertiesCount".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("BorrowerTotalMortgagedPropertiesCount"));
						}
						//if a Positive Numeric String of 1 to 2, value of 1-4
						else if(isPositiveInteger(currentNode,1,2,1,4)){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Borrower, get Borrower_Detail  //set BorrowerTotalMortgagedPropertiesCount
							((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getBorrower_Detail().setBorrowerTotalMortgagedPropertiesCount(Integer.parseInt(currentNode.getFirstChild().getNodeValue()));
						}
						//error reporting happens in isPositiveInteger
					}
					//CommunityPropertyStateResidentIndicator
					else if(currentNode.getNodeName().toLowerCase().equals("CommunityPropertyStateResidentIndicator".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("CommunityPropertyStateResidentIndicator"));
						}
						//if node information is a boolean
						else if(ComputeError.isBoolean(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Borrower, get Borrower_Detail  //set CommunityPropertyStateResidentIndicator
							if(currentNode.getFirstChild().getNodeValue().toLowerCase().equals("true"))
								((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getBorrower_Detail().setCommunityPropertyStateResidentIndicator(true);
							else if(currentNode.getFirstChild().getNodeValue().toLowerCase().equals("false"))
								((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getBorrower_Detail().setCommunityPropertyStateResidentIndicator(false);
						}
						else{
							//report error
							errorList.add(PrintError.notABoolean(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue()));
						}
					}
					//DependentCount
					else if(currentNode.getNodeName().toLowerCase().equals("DependentCount".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("DependentCount"));
						}
						//if a Positive Numeric String of 1 to 2
						else if(isPositiveOrZeroInteger(currentNode,1,2)){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Borrower, get Borrower_Detail  //set DependentCount
							((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getBorrower_Detail().setDependentCount(Integer.parseInt(currentNode.getFirstChild().getNodeValue()));
						}
						//error reporting happens in isPositiveInteger
					}
					//DomesticRelationshipIndicator
					else if(currentNode.getNodeName().toLowerCase().equals("DomesticRelationshipIndicator".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("DomesticRelationshipIndicator"));
						}
						//if node information is a boolean
						else if(ComputeError.isBoolean(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Borrower, get Borrower_Detail  //set DomesticRelationshipIndicator
							if(currentNode.getFirstChild().getNodeValue().toLowerCase().equals("true"))
								((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getBorrower_Detail().setDomesticRelationshipIndicator(true);
							else if(currentNode.getFirstChild().getNodeValue().toLowerCase().equals("false"))
								((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getBorrower_Detail().setDomesticRelationshipIndicator(false);
						}
						else{
							//report error
							errorList.add(PrintError.notABoolean(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue()));
						}
					}
					//DomesticRelationshipStateCode
					else if(currentNode.getNodeName().toLowerCase().equals("DomesticRelationshipStateCode".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("DomesticRelationshipStateCode"));
						}
						//if node information is string in length from 2 to 2
						else if(ComputeError.isWithinStringLength(currentNode.getFirstChild().getNodeValue(),2,2)){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Borrower, get Borrower_Detail  //set DomesticRelationshipStateCode
							((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getBorrower_Detail().setDomesticRelationshipStateCode(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.stringLengthOutsideRange(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(),2,2));
					}
					//DomesticRelationshipType
					else if(currentNode.getNodeName().toLowerCase().equals("DomesticRelationshipType".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("DomesticRelationshipType"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getDomesticRelationshipType().contains(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Borrower, get Borrower_Detail  //set DomesticRelationshipType
							((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getBorrower_Detail().setDomesticRelationshipType(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getDomesticRelationshipType()));
					}
					//DomesticRelationshipTypeOtherDescription
					else if(currentNode.getNodeName().toLowerCase().equals("DomesticRelationshipTypeOtherDescription".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("DomesticRelationshipTypeOtherDescription"));
						}
						//if node information is string in length from 1 to 80
						else if(ComputeError.isWithinStringLength(currentNode.getFirstChild().getNodeValue(),1,80)){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Borrower, get Borrower_Detail  //set DomesticRelationshipTypeOtherDescription
							((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getBorrower_Detail().setDomesticRelationshipTypeOtherDescription(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.stringLengthOutsideRange(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(),1,80));
					}
					//MaritalStatusType
					else if(currentNode.getNodeName().toLowerCase().equals("MaritalStatusType".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("MaritalStatusType"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getMaritalStatusType().contains(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Borrower, get Borrower_Detail  //set MaritalStatusType
							((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getBorrower_Detail().setMaritalStatusType(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getMaritalStatusType()));
					}
					//SelfDeclaredMIlitaryServiceIndicator
					else if(currentNode.getNodeName().toLowerCase().equals("SelfDeclaredMIlitaryServiceIndicator".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("SelfDeclaredMIlitaryServiceIndicator"));
						}
						//if node information is a boolean
						else if(ComputeError.isBoolean(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Borrower, get Borrower_Detail  //set SelfDeclaredMIlitaryServiceIndicator
							if(currentNode.getFirstChild().getNodeValue().toLowerCase().equals("true"))
								((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getBorrower_Detail().setSelfDeclaredMIlitaryServiceIndicator(true);
							else if(currentNode.getFirstChild().getNodeValue().toLowerCase().equals("false"))
								((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getBorrower_Detail().setSelfDeclaredMIlitaryServiceIndicator(false);
						}
						else{
							//report error
							errorList.add(PrintError.notABoolean(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue()));
						}
					}
					//SpousalVABenefitsEligibilityIndicator
					else if(currentNode.getNodeName().toLowerCase().equals("SpousalVABenefitsEligibilityIndicator".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("SpousalVABenefitsEligibilityIndicator"));
						}
						//if node information is a boolean
						else if(ComputeError.isBoolean(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Borrower, get Borrower_Detail  //set SpousalVABenefitsEligibilityIndicator
							if(currentNode.getFirstChild().getNodeValue().toLowerCase().equals("true"))
								((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getBorrower_Detail().setSpousalVABenefitsEligibilityIndicator(true);
							else if(currentNode.getFirstChild().getNodeValue().toLowerCase().equals("false"))
								((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getBorrower_Detail().setSpousalVABenefitsEligibilityIndicator(false);
						}
						else{
							//report error
							errorList.add(PrintError.notABoolean(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue()));
						}
					}
					else
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Borrower_Detail"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchCounseling(Node currentNode)
	{
		boolean result = true;
		
		//Counseling
		if(currentNode.getNodeName().toLowerCase().equals("Counseling".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchCounseling_Events(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Counseling"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchCounseling_Events(Node currentNode)
	{
		boolean result = true;
		
		//Counseling_Events
		if(currentNode.getNodeName().toLowerCase().equals("Counseling_Events".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchCounseling_Event(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Counseling_Events"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchCounseling_Event(Node currentNode)
	{
		boolean result = true;
		
		//Counseling_Event
		if(currentNode.getNodeName().toLowerCase().equals("Counseling_Event".toLowerCase())){
			//create Java Object
			((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getCounseling().getCounseling_Events().add(new Counseling_Event());
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//SequenceNumber
					if(currentNode.getNodeName().toLowerCase().equals("SequenceNumber".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("SequenceNumber"));
						}
						//if a Positive Numeric String of 1 to 2
						else if(isPositiveInteger(currentNode,1,2)){
							//get last Deal_Set, get last Deal, get last Party, get last Role, set SequenceNumber
							((Counseling_Event) ((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getCounseling().getLast("Counseling_Event")).setSequenceNumber(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isPositiveInteger
					}		
					//xlink:label
					else if(currentNode.getNodeName().toLowerCase().equals("xlink:label".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("xlink:label"));
						}
						//if node information is a string in length from 1 to 1000
						else if(ComputeError.isWithinStringLength(currentNode.getFirstChild().getNodeValue(),1,1000)){
							//get last Deal_Set, get last Deal, get last Party, get last Role, set xlink:label
							((Counseling_Event) ((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getCounseling().getLast("Counseling_Event")).setXlinklabel(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.stringLengthOutsideRange(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(),1,1000));
					}
					else if(!matchCounseling_Event_Detail(currentNode))
							//report error
							errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Counseling_Event"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchCounseling_Event_Detail(Node currentNode)
	{
		boolean result = true;
		
		//Counseling_Event
		if(currentNode.getNodeName().toLowerCase().equals("Counseling_Event_Detail".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//CounselingCompletedDate
					if(currentNode.getNodeName().toLowerCase().equals("CounselingCompletedDate".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("CounselingCompletedDate"));
						}
						//if node information is a date time value
						else if(ComputeError.isDate(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Borrower, get Borrower_Detail, get Counseling, get last Counseling_Event, get Counseling_Event_Detail  //set CounselingCompletedDate
							((Counseling_Event) ((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getCounseling().getLast("Counseling_Event")).getCounseling_Event_Detail().setCounselingCompletedDate(Utility.setDate(currentNode.getFirstChild().getNodeValue()));
						}
						else
							//report error
							errorList.add(PrintError.notADate(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue()));
					}
					//CounselingConfirmationIndicator
					else if(currentNode.getNodeName().toLowerCase().equals("CounselingConfirmationIndicator".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("CounselingConfirmationIndicator"));
						}
						//if node information is a boolean
						else if(ComputeError.isBoolean(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Borrower, get Borrower_Detail, get Counseling, get last Counseling_Event, get Counseling_Event_Detail  //set CounselingConfirmationIndicator
							if(currentNode.getFirstChild().getNodeValue().toLowerCase().equals("true"))
								((Counseling_Event) ((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getCounseling().getLast("Counseling_Event")).getCounseling_Event_Detail().setCounselingConfirmationIndicator(true);
							else if(currentNode.getFirstChild().getNodeValue().toLowerCase().equals("false"))
								((Counseling_Event) ((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getCounseling().getLast("Counseling_Event")).getCounseling_Event_Detail().setCounselingConfirmationIndicator(false);
							}
						else{
							//report error
							errorList.add(PrintError.notABoolean(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue()));
						}
					}
					//CounselingFormatType
					else if(currentNode.getNodeName().toLowerCase().equals("CounselingFormatType".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("CounselingFormatType"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getCounselingFormatType().contains(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Borrower, get Borrower_Detail, get Counseling, get last Counseling_Event, get Counseling_Event_Detail  //set CounselingFormatType
							((Counseling_Event) ((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getCounseling().getLast("Counseling_Event")).getCounseling_Event_Detail().setCounselingFormatType(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getCounselingFormatType()));
					}
					//CounselingType
					else if(currentNode.getNodeName().toLowerCase().equals("CounselingType".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("CounselingType"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getCounselingType().contains(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Borrower, get Borrower_Detail, get Counseling, get last Counseling_Event, get Counseling_Event_Detail  //set CounselingType
							((Counseling_Event) ((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getCounseling().getLast("Counseling_Event")).getCounseling_Event_Detail().setCounselingType(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getCounselingType()));
					}
					else
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Counseling_Event_Detail"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchCurrent_Income(Node currentNode)
	{
		boolean result = true;
		
		//Current_Income
		if(currentNode.getNodeName().toLowerCase().equals("Current_Income".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchCurrent_Income_Items(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Current_Income"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchCurrent_Income_Items(Node currentNode)
	{
		boolean result = true;
		
		//Current_Income_Items
		if(currentNode.getNodeName().toLowerCase().equals("Current_Income_Items".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchCurrent_Income_Item(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Current_Income_Items"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchCurrent_Income_Item(Node currentNode)
	{
		boolean result = true;
		
		//Current_Income_Item
		if(currentNode.getNodeName().toLowerCase().equals("Current_Income_Item".toLowerCase())){
			//create Java Object
			((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getCurrent_Income().getCurrent_Income_Items().add(new Current_Income_Item());
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//SequenceNumber
					if(currentNode.getNodeName().toLowerCase().equals("SequenceNumber".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("SequenceNumber"));
						}
						//if a Positive Numeric String of 1 to 2
						else if(isPositiveInteger(currentNode,1,2)){
							//get last Deal_Set, get last Deal, get last Party, get last Role, get Borrower, get Current Income, get last Current_Income_Item, set SequenceNumber
							((Current_Income_Item) ((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getCurrent_Income().getLast("Current_Income_Item")).setSequenceNumber(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isPositiveInteger
					}		
					//xlink:label
					else if(currentNode.getNodeName().toLowerCase().equals("xlink:label".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("xlink:label"));
						}
						//if node information is a string in length from 1 to 1000
						else if(ComputeError.isWithinStringLength(currentNode.getFirstChild().getNodeValue(),1,1000)){
							////get last Deal_Set, get last Deal, get last Party, get last Role, get Borrower, get Current Income, get last Current_Income_Item, set xlink:label
							((Current_Income_Item) ((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getCurrent_Income().getLast("Current_Income_Item")).setXlinklabel(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.stringLengthOutsideRange(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(),1,1000));
					}
					else if(!matchCurrent_Income_Item_Detail(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Current_Income_Item"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchCurrent_Income_Item_Detail(Node currentNode)
	{
		boolean result = true;
		
		//Current_Income_Item_Detail
		if(currentNode.getNodeName().toLowerCase().equals("Current_Income_Item_Detail".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//CurrentIncomeMonthlyTotalAmount
					if(currentNode.getNodeName().toLowerCase().equals("CurrentIncomeMonthlyTotalAmount".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("CurrentIncomeMonthlyTotalAmount"));
						}
						//if node information is an amount of money
						else if(isMoney(currentNode, 12, 2)){
							//get Deal_Sets, get last Deal_Set, get last Deal, get last Party, get last Role, get Borrower, get Borrower_Detail, get Current_Income, get last Current_Income_Item, get Current_Income_Item_Detail, set CurrentIncomeMonthlyTotalAmount
							((Current_Income_Item) ((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getCurrent_Income().getLast("Current_Income_Item")).getCurrent_Income_Item_Detail().setCurrentIncomeMonthlyTotalAmount(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isMoney
					}
					//EmploymentIncomeIndicator
					else if(currentNode.getNodeName().toLowerCase().equals("EmploymentIncomeIndicator".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("EmploymentIncomeIndicator"));
						}
						//if node information is a boolean
						else if(ComputeError.isBoolean(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, get last Deal_Set, get last Deal, get last Party, get last Role, get Borrower, get Borrower_Detail, get Current_Income, get last Current_Income_Item, get Current_Income_Item_Detail, set EmploymentIncomeIndicator
							if(currentNode.getFirstChild().getNodeValue().toLowerCase().equals("true"))
								((Current_Income_Item) ((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getCurrent_Income().getLast("Current_Income_Item")).getCurrent_Income_Item_Detail().setEmploymentIncomeIndicator(true);
							else if(currentNode.getFirstChild().getNodeValue().toLowerCase().equals("false"))
								((Current_Income_Item) ((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getCurrent_Income().getLast("Current_Income_Item")).getCurrent_Income_Item_Detail().setEmploymentIncomeIndicator(false);
						}
						else{
							//report error
							errorList.add(PrintError.notABoolean(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue()));
						}
					}
					//IncomeType
					else if(currentNode.getNodeName().toLowerCase().equals("IncomeType".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("IncomeType"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getIncomeType().contains(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, get last Deal_Set, get last Deal, get last Party, get last Role, get Borrower, get Borrower_Detail, get Current_Income, get last Current_Income_Item, get Current_Income_Item_Detail, set IncomeType
							((Current_Income_Item) ((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getCurrent_Income().getLast("Current_Income_Item")).getCurrent_Income_Item_Detail().setIncomeType(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getIncomeType()));
					}
					//IncomeTypeOtherDescription
					else if(currentNode.getNodeName().toLowerCase().equals("IncomeTypeOtherDescription".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("IncomeTypeOtherDescription"));
						}
						//if node information is string in length from 1 to 80
						else if(ComputeError.isWithinStringLength(currentNode.getFirstChild().getNodeValue(),1,80)){
							//get Deal_Sets, get last Deal_Set, get last Deal, get last Party, get last Role, get Borrower, get Borrower_Detail, get Current_Income, get last Current_Income_Item, get Current_Income_Item_Detail, set IncomeTypeOtherDescription
							((Current_Income_Item) ((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getCurrent_Income().getLast("Current_Income_Item")).getCurrent_Income_Item_Detail().setIncomeTypeOtherDescription(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.stringLengthOutsideRange(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(),1,80));
					}
					else	
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Current_Income_Item_Detail"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchDeclaration(Node currentNode)
	{
		boolean result = true;
		
		//Declaration
		if(currentNode.getNodeName().toLowerCase().equals("Declaration".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchDeclaration_Detail(currentNode))
						if(!matchDeclaration_Explanations(currentNode))
							//report error
							errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Declaration"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchDeclaration_Detail(Node currentNode)
	{
		boolean result = true;
		
		//Declaration_Detail
		if(currentNode.getNodeName().toLowerCase().equals("Declaration_Detail".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//BankruptcyIndicator
					if(currentNode.getNodeName().toLowerCase().equals("BankruptcyIndicator".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("BankruptcyIndicator"));
						}
						//if node information is a boolean
						else if(ComputeError.isBoolean(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Borrower, get Declaration, get Declaration_Detail  //set BankruptcyIndicator
							if(currentNode.getFirstChild().getNodeValue().toLowerCase() == "true")
								((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getDeclaration().getDeclaration_Detail().setBankruptcyIndicator(true);
							else if(currentNode.getFirstChild().getNodeValue().toLowerCase() == "false")
								((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getDeclaration().getDeclaration_Detail().setBankruptcyIndicator(false);
						}
						else{
							//report error
							errorList.add(PrintError.notABoolean(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue()));
						}
					}
					//CitizenshipResidencyType
					else if(currentNode.getNodeName().toLowerCase().equals("CitizenshipResidencyType".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("CitizenshipResidencyType"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getCitizenshipResidencyType().contains(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Borrower, get Declaration, get Declaration_Detail  //set CitizenshipResidencyType
							((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getDeclaration().getDeclaration_Detail().setCitizenshipResidencyType(currentNode.getFirstChild().getNodeValue());
							}
						else
							//report error
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getCitizenshipResidencyType()));
					}
					//FHASecondaryResidenceIndicator
					else if(currentNode.getNodeName().toLowerCase().equals("FHASecondaryResidenceIndicator".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("FHASecondaryResidenceIndicator"));
						}
						//if node information is a boolean
						else if(ComputeError.isBoolean(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Borrower, get Declaration, get Declaration_Detail  //set FHASecondaryResidenceIndicator
							if(currentNode.getFirstChild().getNodeValue().toLowerCase() == "true")
								((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getDeclaration().getDeclaration_Detail().setFHASecondaryResidenceIndicator(true);
							else if(currentNode.getFirstChild().getNodeValue().toLowerCase() == "false")
								((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getDeclaration().getDeclaration_Detail().setFHASecondaryResidenceIndicator(false);
						}
						else{
							//report error
							errorList.add(PrintError.notABoolean(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue()));
						}
					}
					//HomeownerPastThreeYearsType
					else if(currentNode.getNodeName().toLowerCase().equals("HomeownerPastThreeYearsType".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("HomeownerPastThreeYearsType"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getHomeownerPastThreeYearsType().contains(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Borrower, get Declaration, get Declaration_Detail  //set HomeownerPastThreeYearsType
							((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getDeclaration().getDeclaration_Detail().setHomeownerPastThreeYearsType(currentNode.getFirstChild().getNodeValue());
							}
						else
							//report error
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getHomeownerPastThreeYearsType()));
					}
					//IntentToOccupyType
					else if(currentNode.getNodeName().toLowerCase().equals("IntentToOccupyType".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("IntentToOccupyType"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getIntentToOccupyType().contains(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Borrower, get Declaration, get Declaration_Detail  //set IntentToOccupyType
							((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getDeclaration().getDeclaration_Detail().setIntentToOccupyType(currentNode.getFirstChild().getNodeValue());
							}
						else
							//report errorIntentToOccupyType
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getIntentToOccupyType()));
					}
					//OutstandingJudgmentsIndicator
					else if(currentNode.getNodeName().toLowerCase().equals("OutstandingJudgmentsIndicator".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("OutstandingJudgmentsIndicator"));
						}
						//if node information is a boolean
						else if(ComputeError.isBoolean(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Borrower, get Declaration, get Declaration_Detail  //set OutstandingJudgmentsIndicator
							if(currentNode.getFirstChild().getNodeValue().toLowerCase() == "true")
								((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getDeclaration().getDeclaration_Detail().setOutstandingJudgmentsIndicator(true);
							else if(currentNode.getFirstChild().getNodeValue().toLowerCase() == "false")
								((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getDeclaration().getDeclaration_Detail().setOutstandingJudgmentsIndicator(false);
						}
						else{
							//report error
							errorList.add(PrintError.notABoolean(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue()));
						}
					}
					//PartyToLawsuitIndicator
					else if(currentNode.getNodeName().toLowerCase().equals("PartyToLawsuitIndicator".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("PartyToLawsuitIndicator"));
						}
						//if node information is a boolean
						else if(ComputeError.isBoolean(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Borrower, get Declaration, get Declaration_Detail  //set PartyToLawsuitIndicator
							if(currentNode.getFirstChild().getNodeValue().toLowerCase() == "true")
								((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getDeclaration().getDeclaration_Detail().setPartyToLawsuitIndicator(true);
							else if(currentNode.getFirstChild().getNodeValue().toLowerCase() == "false")
								((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getDeclaration().getDeclaration_Detail().setPartyToLawsuitIndicator(false);
						}
						else{
							//report error
							errorList.add(PrintError.notABoolean(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue()));
						}
					}
					//PresentlyDelinquentIndicator
					else if(currentNode.getNodeName().toLowerCase().equals("PresentlyDelinquentIndicator".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("PresentlyDelinquentIndicator"));
						}
						//if node information is a boolean
						else if(ComputeError.isBoolean(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Borrower, get Declaration, get Declaration_Detail  //set PresentlyDelinquentIndicator
							if(currentNode.getFirstChild().getNodeValue().toLowerCase() == "true")
								((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getDeclaration().getDeclaration_Detail().setPresentlyDelinquentIndicator(true);
							else if(currentNode.getFirstChild().getNodeValue().toLowerCase() == "false")
								((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getDeclaration().getDeclaration_Detail().setPresentlyDelinquentIndicator(false);
						}
						else{
							//report error
							errorList.add(PrintError.notABoolean(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue()));
						}
					}
					//PriorPropertyDeedInLieuConveyedIndicator
					else if(currentNode.getNodeName().toLowerCase().equals("PriorPropertyDeedInLieuConveyedIndicator".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("PriorPropertyDeedInLieuConveyedIndicator"));
						}
						//if node information is a boolean
						else if(ComputeError.isBoolean(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Borrower, get Declaration, get Declaration_Detail  //set PriorPropertyDeedInLieuConveyedIndicator
							if(currentNode.getFirstChild().getNodeValue().toLowerCase() == "true")
								((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getDeclaration().getDeclaration_Detail().setPriorPropertyDeedInLieuConveyedIndicator(true);
							else if(currentNode.getFirstChild().getNodeValue().toLowerCase() == "false")
								((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getDeclaration().getDeclaration_Detail().setPriorPropertyDeedInLieuConveyedIndicator(false);
						}
						else{
							//report error
							errorList.add(PrintError.notABoolean(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue()));
						}
					}
					//PriorPropertyForeclosureCompletedIndicator
					else if(currentNode.getNodeName().toLowerCase().equals("PriorPropertyForeclosureCompletedIndicator".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("PriorPropertyForeclosureCompletedIndicator"));
						}
						//if node information is a boolean
						else if(ComputeError.isBoolean(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Borrower, get Declaration, get Declaration_Detail  //set PriorPropertyForeclosureCompletedIndicator
							if(currentNode.getFirstChild().getNodeValue().toLowerCase() == "true")
								((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getDeclaration().getDeclaration_Detail().setPriorPropertyForeclosureCompletedIndicator(true);
							else if(currentNode.getFirstChild().getNodeValue().toLowerCase() == "false")
								((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getDeclaration().getDeclaration_Detail().setPriorPropertyForeclosureCompletedIndicator(false);
						}
						else{
							//report error
							errorList.add(PrintError.notABoolean(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue()));
						}
					}
					//PriorPropertyShortSaleCompletedIndicator
					else if(currentNode.getNodeName().toLowerCase().equals("PriorPropertyShortSaleCompletedIndicator".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("PriorPropertyShortSaleCompletedIndicator"));
						}
						//if node information is a boolean
						else if(ComputeError.isBoolean(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Borrower, get Declaration, get Declaration_Detail  //set PriorPropertyShortSaleCompletedIndicator
							if(currentNode.getFirstChild().getNodeValue().toLowerCase() == "true")
								((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getDeclaration().getDeclaration_Detail().setPriorPropertyShortSaleCompletedIndicator(true);
							else if(currentNode.getFirstChild().getNodeValue().toLowerCase() == "false")
								((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getDeclaration().getDeclaration_Detail().setPriorPropertyShortSaleCompletedIndicator(false);
						}
						else{
							//report error
							errorList.add(PrintError.notABoolean(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue()));
						}
					}
					//PriorPropertyTitleType
					else if(currentNode.getNodeName().toLowerCase().equals("PriorPropertyTitleType".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("PriorPropertyTitleType"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getPriorPropertyTitleType().contains(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Borrower, get Declaration, get Declaration_Detail  //set PriorPropertyTitleType
							((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getDeclaration().getDeclaration_Detail().setPriorPropertyTitleType(currentNode.getFirstChild().getNodeValue());
							}
						else
							//report errorIntentToOccupyType
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getPriorPropertyTitleType()));
					}
					//PriorPropertyUsageType
					else if(currentNode.getNodeName().toLowerCase().equals("PriorPropertyUsageType".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("PriorPropertyUsageType"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getPriorPropertyUsageType().contains(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Borrower, get Declaration, get Declaration_Detail  //set PriorPropertyUsageType
							((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getDeclaration().getDeclaration_Detail().setPriorPropertyUsageType(currentNode.getFirstChild().getNodeValue());
							}
						else
							//report errorIntentToOccupyType
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getPriorPropertyUsageType()));
					}
					//PropertyProposedCleanEnergyLienIndicator
					else if(currentNode.getNodeName().toLowerCase().equals("PropertyProposedCleanEnergyLienIndicator".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("PropertyProposedCleanEnergyLienIndicator"));
						}
						//if node information is a boolean
						else if(ComputeError.isBoolean(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Borrower, get Declaration, get Declaration_Detail  //set PropertyProposedCleanEnergyLienIndicator
							if(currentNode.getFirstChild().getNodeValue().toLowerCase() == "true")
								((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getDeclaration().getDeclaration_Detail().setPropertyProposedCleanEnergyLienIndicator(true);
							else if(currentNode.getFirstChild().getNodeValue().toLowerCase() == "false")
								((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getDeclaration().getDeclaration_Detail().setPropertyProposedCleanEnergyLienIndicator(false);
						}
						else{
							//report error
							errorList.add(PrintError.notABoolean(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue()));
						}
					}
					//UndisclosedBorrowedFundsAmount
					else if(currentNode.getNodeName().toLowerCase().equals("UndisclosedBorrowedFundsAmount".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("UndisclosedBorrowedFundsAmount"));
						}
						//if node information is a positive amount of money
						else if(isPositiveMoney(currentNode, 12, 2)){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get Collaterals, then the last Collateral //get last Property_Valuation, get Property_Valuation_Detail //set UndisclosedBorrowedFundsAmount
							((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getDeclaration().getDeclaration_Detail().setUndisclosedBorrowedFundsAmount(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isPositiveMoney
					}
					//UndisclosedBorrowedFundsIndicator
					else if(currentNode.getNodeName().toLowerCase().equals("UndisclosedBorrowedFundsIndicator".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("UndisclosedBorrowedFundsIndicator"));
						}
						//if node information is a boolean
						else if(ComputeError.isBoolean(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Borrower, get Declaration, get Declaration_Detail  //set UndisclosedBorrowedFundsIndicator
							if(currentNode.getFirstChild().getNodeValue().toLowerCase() == "true")
								((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getDeclaration().getDeclaration_Detail().setUndisclosedBorrowedFundsIndicator(true);
							else if(currentNode.getFirstChild().getNodeValue().toLowerCase() == "false")
								((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getDeclaration().getDeclaration_Detail().setUndisclosedBorrowedFundsIndicator(false);
						}
						else{
							//report error
							errorList.add(PrintError.notABoolean(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue()));
						}
					}
					//UndisclosedComakerOfNoteIndicator
					else if(currentNode.getNodeName().toLowerCase().equals("UndisclosedComakerOfNoteIndicator".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("UndisclosedComakerOfNoteIndicator"));
						}
						//if node information is a boolean
						else if(ComputeError.isBoolean(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Borrower, get Declaration, get Declaration_Detail  //set UndisclosedComakerOfNoteIndicator
							if(currentNode.getFirstChild().getNodeValue().toLowerCase() == "true")
								((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getDeclaration().getDeclaration_Detail().setUndisclosedComakerOfNoteIndicator(true);
							else if(currentNode.getFirstChild().getNodeValue().toLowerCase() == "false")
								((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getDeclaration().getDeclaration_Detail().setUndisclosedComakerOfNoteIndicator(false);
						}
						else{
							//report error
							errorList.add(PrintError.notABoolean(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue()));
						}
					}
					//UndisclosedCreditApplicationIndicator
					else if(currentNode.getNodeName().toLowerCase().equals("UndisclosedCreditApplicationIndicator".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("UndisclosedCreditApplicationIndicator"));
						}
						//if node information is a boolean
						else if(ComputeError.isBoolean(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Borrower, get Declaration, get Declaration_Detail  //set UndisclosedCreditApplicationIndicator
							if(currentNode.getFirstChild().getNodeValue().toLowerCase() == "true")
								((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getDeclaration().getDeclaration_Detail().setUndisclosedCreditApplicationIndicator(true);
							else if(currentNode.getFirstChild().getNodeValue().toLowerCase() == "false")
								((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getDeclaration().getDeclaration_Detail().setUndisclosedCreditApplicationIndicator(false);
						}
						else{
							//report error
							errorList.add(PrintError.notABoolean(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue()));
						}
					}
					//UndisclosedMortgageApplicationIndicator
					else if(currentNode.getNodeName().toLowerCase().equals("UndisclosedMortgageApplicationIndicator".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("UndisclosedMortgageApplicationIndicator"));
						}
						//if node information is a boolean
						else if(ComputeError.isBoolean(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Borrower, get Declaration, get Declaration_Detail  //set UndisclosedMortgageApplicationIndicator
							if(currentNode.getFirstChild().getNodeValue().toLowerCase() == "true")
								((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getDeclaration().getDeclaration_Detail().setUndisclosedMortgageApplicationIndicator(true);
							else if(currentNode.getFirstChild().getNodeValue().toLowerCase() == "false")
								((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getDeclaration().getDeclaration_Detail().setUndisclosedMortgageApplicationIndicator(false);
						}
						else{
							//report error
							errorList.add(PrintError.notABoolean(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue()));
						}
					}
					//Extension
					else if(!matchDeclaration_DetailExtension(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Declaration_Detail"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchDeclaration_DetailExtension(Node currentNode)
	{
		boolean result = true;
		
		//Extension
		if(currentNode.getNodeName().toLowerCase().equals("Extension".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchDeclaration_DetailExtensionOther(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Extension"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchDeclaration_DetailExtensionOther(Node currentNode)
	{
		boolean result = true;
		
		//Other
		if(currentNode.getNodeName().toLowerCase().equals("Other".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchDeclaration_Detail_Extension(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Other"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchDeclaration_Detail_Extension(Node currentNode)
	{
		boolean result = true;
		
		//Extension
		if(currentNode.getNodeName().toLowerCase().equals("ULAD:Declaration_Detail_Extension".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//SpecialBorrowerSellerRelationshipIndicator
					if(currentNode.getNodeName().toLowerCase().equals("ULAD:SpecialBorrowerSellerRelationshipIndicator".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("ULAD:SpecialBorrowerSellerRelationshipIndicator"));
						}
						//if node information is a boolean
						else if(ComputeError.isBoolean(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Borrower, get Declaration, get Declaration_Detail, get Extension, get Other, get Declaration_Detail_Extension  //set SpecialBorrowerSellerRelationshipIndicator
							if(currentNode.getFirstChild().getNodeValue().toLowerCase().equals("true"))
								((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getDeclaration().getDeclaration_Detail().getExtension().getOther().getDeclaration_Detail_Extension().setSpecialBorrowerSellerRelationshipIndicator(true);
							else if(currentNode.getFirstChild().getNodeValue().toLowerCase().equals("false"))
								((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getDeclaration().getDeclaration_Detail().getExtension().getOther().getDeclaration_Detail_Extension().setSpecialBorrowerSellerRelationshipIndicator(false);
						}
						else{
							//report error
							errorList.add(PrintError.notABoolean(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue()));
						}
					}	
					else	
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "ULAD:Declaration_Detail_Extension"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchDeclaration_Explanations(Node currentNode)
	{
		boolean result = true;
		
		//Declaration_Explanations
		if(currentNode.getNodeName().toLowerCase().equals("Declaration_Explanations".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchDeclaration_Explanation(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Declaration_Explanations"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchDeclaration_Explanation(Node currentNode)
	{
		boolean result = true;
		
		//Current_Income
		if(currentNode.getNodeName().toLowerCase().equals("Declaration_Explanation".toLowerCase())){
			//create Java Object
			((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getDeclaration().getDeclaration_Explanations().add(new Declaration_Explanation());
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//DeclarationExplanationDescription
					if(currentNode.getNodeName().toLowerCase().equals("DeclarationExplanationDescription".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("DeclarationExplanationDescription"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getDeclarationExplanationDescription().contains(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Borrower, get Declaration, get Declaration_Detail, get Extension, get Other, get Declaration_Detail_Extension  //set DeclarationExplanationDescription
							((Declaration_Explanation) ((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getDeclaration().getLast("Declaration_Explanation")).setDeclarationExplanationDescription(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getDeclarationExplanationDescription()));
					}
					//DeclarationExplanationType
					else if(currentNode.getNodeName().toLowerCase().equals("DeclarationExplanationType".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("DeclarationExplanationType"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getDeclarationExplanationType().contains(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Borrower, get Declaration, get Declaration_Detail, get Extension, get Other, get Declaration_Detail_Extension  //set DeclarationExplanationType
							((Declaration_Explanation) ((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getDeclaration().getLast("Declaration_Explanation")).setDeclarationExplanationType(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getDeclarationExplanationType()));
					}
					else
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Declaration_Explanation"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchDependents(Node currentNode)
	{
		boolean result = true;
		
		//Dependents
		if(currentNode.getNodeName().toLowerCase().equals("Dependents".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchDependent(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Dependents"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchDependent(Node currentNode)
	{
		boolean result = true;
		
		//Dependent
		if(currentNode.getNodeName().toLowerCase().equals("Dependent".toLowerCase())){
			//create Java object
			((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getDependents().add(new Dependent());
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//DependentAgeYearsCount
					if(currentNode.getNodeName().toLowerCase().equals("DependentAgeYearsCount".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("DependentAgeYearsCount"));
						}
						//if a Positive Numeric String of 1 to 2
						else if(isPositiveInteger(currentNode,1,2)){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Borrower, get last Military_Service  //set MilitaryStatusType
							((Dependent) ((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getLast("Dependent")).setDependentAgeYearsCount(Integer.parseInt(currentNode.getFirstChild().getNodeValue()));
						}
						//error reporting happens in isPositiveInteger
					}		
					else
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Dependent"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchEmployers(Node currentNode)
	{
		boolean result = true;
		
		//Employers
		if(currentNode.getNodeName().toLowerCase().equals("Employers".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchEmployer(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Employers"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchEmployer(Node currentNode)
	{
		boolean result = true;
		
		//Employer
		if(currentNode.getNodeName().toLowerCase().equals("Employer".toLowerCase())){
			//create Java Object
			((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getEmployers().add(new Employer());
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//SequenceNumber
					if(currentNode.getNodeName().toLowerCase().equals("SequenceNumber".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("SequenceNumber"));
						}
						//if a Positive Numeric String of 1 to 2
						else if(isPositiveInteger(currentNode,1,2)){
							//get last Deal_Set, get last Deal, get last Party, get last Role, get Borrower, get last Employer, set SequenceNumber
							((Employer) ((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getLast("Employer")).setSequenceNumber(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isPositiveInteger
					}		
					//xlink:label
					else if(currentNode.getNodeName().toLowerCase().equals("xlink:label".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("xlink:label"));
						}
						//if node information is a string in length from 1 to 1000
						else if(ComputeError.isWithinStringLength(currentNode.getFirstChild().getNodeValue(),1,1000)){
							//get last Deal_Set, get last Deal, get last Party, get last Role, get Borrower, get last Employer, set xlink:label
							((Employer) ((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getLast("Employer")).setXlinklabel(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.stringLengthOutsideRange(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(),1,1000));
					}
					else if(!matchEmployerAddress(currentNode))
							if(!matchEmployment(currentNode))
								if(!matchEmployerIndividual(currentNode))
									if(!matchEmployerLegal_Entity(currentNode))
										//report error
										errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Employer"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchEmployerAddress(Node currentNode)
	{
		boolean result = true;
		
		//Declaration
		if(currentNode.getNodeName().toLowerCase().equals("Address".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//AddressLineText
					if(currentNode.getNodeName().toLowerCase().equals("AddressLineText".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("AddressLineText"));
						}
						//if node information is string in length from 1 to 35
						else if(ComputeError.isWithinStringLength(currentNode.getFirstChild().getNodeValue(),1,35)){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Employer, get Address //set AddressLineText
							((Employer) ((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getLast("Employer")).getAddress().setAddressLineText(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.stringLengthOutsideRange(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(),1,35,"Employer/Address"));
					}
					//AddressUnitIdentifier
					else if(currentNode.getNodeName().toLowerCase().equals("AddressUnitIdentifier".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("AddressUnitIdentifier"));
						}
						//if node information is a string in length from 1 to 11
						else if(ComputeError.isWithinStringLength(currentNode.getFirstChild().getNodeValue(),1,11)){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Employer, get Address //set AddressUnitIdentifier
							((Employer) ((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getLast("Employer/Address")).getAddress().setAddressUnitIdentifier(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.stringLengthOutsideRange(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(),1,11,"Employer/Address"));
					}
					//CityName
					else if(currentNode.getNodeName().toLowerCase().equals("CityName".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("CityName"));
						}
						//if node information is a string in length from 1 to 35
						else if(ComputeError.isWithinStringLength(currentNode.getFirstChild().getNodeValue(),1,35)){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Employer, get Address //set CityName
							((Employer) ((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getLast("Employer")).getAddress().setCityName(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.stringLengthOutsideRange(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(),1,35,"Employer/Address"));
					}
					//PostalCode
					else if(currentNode.getNodeName().toLowerCase().equals("PostalCode".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("PostalCode"));
						}
						//if node information is a string in length from 1 to 9
						else if(ComputeError.isWithinStringLength(currentNode.getFirstChild().getNodeValue(),1,9)){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Employer, get Address //set PostalCode
							((Employer) ((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getLast("Employer")).getAddress().setPostalCode(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.stringLengthOutsideRange(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(),1,9,"Employer/Address"));
					}
					//StateCode
					else if(currentNode.getNodeName().toLowerCase().equals("StateCode".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("StateCode"));
						}
						//if node information is a string in length from 1 to 2
						else if(ComputeError.isWithinStringLength(currentNode.getFirstChild().getNodeValue(),1,2)){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Employer, get Address //set StateCode
							((Employer) ((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getLast("Employer")).getAddress().setStateCode(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.stringLengthOutsideRange(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(),1,2,"Employer/Address"));
					}
					else	
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Employer/Address"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchEmployment(Node currentNode)
	{
		boolean result = true;
		
		//Declaration
		if(currentNode.getNodeName().toLowerCase().equals("Employment".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//EmploymentBorrowerSelfEmployedIndicator
					if(currentNode.getNodeName().toLowerCase().equals("EmploymentBorrowerSelfEmployedIndicator".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("EmploymentBorrowerSelfEmployedIndicator"));
						}
						//if node information is a boolean
						else if(ComputeError.isBoolean(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Employer, get Employment //set EmploymentBorrowerSelfEmployedIndicator 
							if(currentNode.getFirstChild().getNodeValue().toLowerCase().equals("true"))
								((Employer) ((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getLast("Employer")).getEmployment().setEmploymentBorrowerSelfEmployedIndicator(true);
							else if(currentNode.getFirstChild().getNodeValue().toLowerCase().equals("false"))
								((Employer) ((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getLast("Employer")).getEmployment().setEmploymentBorrowerSelfEmployedIndicator(false);
						}
						else{
							//report error
							errorList.add(PrintError.notABoolean(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue()));
						}
					}	
					//EmploymentClassificationType
					else if(currentNode.getNodeName().toLowerCase().equals("EmploymentClassificationType".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("EmploymentClassificationType"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getEmploymentClassificationType().contains(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Employer, get Employment //set EmploymentClassificationType
							((Employer) ((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getLast("Employer")).getEmployment().setEmploymentClassificationType(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getEmploymentClassificationType()));
					}		
					//EmploymentEndDate
					else if(currentNode.getNodeName().toLowerCase().equals("EmploymentEndDate".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("EmploymentEndDate"));
						}
						//if node information is a date time value
						else if(ComputeError.isDate(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Employer, get Employment //set EmploymentEndDate
							((Employer) ((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getLast("Employer")).getEmployment().setEmploymentEndDate(Utility.setDate(currentNode.getFirstChild().getNodeValue()));
						}
						else
							//report error
							errorList.add(PrintError.notADate(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue()));
					}
					//EmploymentMonthlyIncomeAmount
					else if(currentNode.getNodeName().toLowerCase().equals("EmploymentMonthlyIncomeAmount".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("EmploymentMonthlyIncomeAmount"));
						}
						//if node information is an amount of money
						else if(isMoney(currentNode, 12, 2)){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Employer, get Employment //set EmploymentMonthlyIncomeAmount
							((Employer) ((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getLast("Employer")).getEmployment().setEmploymentMonthlyIncomeAmount(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isMoney
					}		
					//EmploymentPositionDescription
					else if(currentNode.getNodeName().toLowerCase().equals("EmploymentPositionDescription".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("EmploymentPositionDescription"));
						}
						//if node information is string in length from 1 to 25
						else if(ComputeError.isWithinStringLength(currentNode.getFirstChild().getNodeValue(),1,25)){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Employer, get Employment //set EmploymentPositionDescription 
							((Employer) ((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getLast("Employer")).getEmployment().setEmploymentPositionDescription(currentNode.getFirstChild().getNodeValue());
								
						}
						else
							//report error
							errorList.add(PrintError.stringLengthOutsideRange(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(),1,25));
					}
					//EmploymentStartDate
					else if(currentNode.getNodeName().toLowerCase().equals("EmploymentStartDate".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("EmploymentStartDate"));
						}
						//if node information is a date time value
						else if(ComputeError.isDate(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Employer, get Employment //set EmploymentStartDate
							((Employer) ((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getLast("Employer")).getEmployment().setEmploymentStartDate(Utility.setDate(currentNode.getFirstChild().getNodeValue()));
						}
						else
							//report error
							errorList.add(PrintError.notADate(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue()));
					}
					//EmploymentStatusType
					else if(currentNode.getNodeName().toLowerCase().equals("EmploymentStatusType".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("EmploymentStatusType"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getEmploymentStatusType().contains(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Employer, get Employment //set EmploymentStatusType
							((Employer) ((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getLast("Employer")).getEmployment().setEmploymentStatusType(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getEmploymentStatusType()));
					}
					//EmploymentTimeInLineOfWorkMonthsCount
					else if(currentNode.getNodeName().toLowerCase().equals("EmploymentTimeInLineOfWorkMonthsCount".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("EmploymentTimeInLineOfWorkMonthsCount"));
						}
						//if node information is a positive or zero number
						else if(isPositiveOrZeroInteger(currentNode,1,3)){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Employer, get Employment //set EmploymentTimeInLineOfWorkMonthsCount
							((Employer) ((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getLast("Employer")).getEmployment().setEmploymentTimeInLineOfWorkMonthsCount(Integer.parseInt(currentNode.getFirstChild().getNodeValue()));
						}
						//error reporting happens in isPositiveOrZeroInteger
					}	
					//OwnershipInterestType
					else if(currentNode.getNodeName().toLowerCase().equals("OwnershipInterestType".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("OwnershipInterestType"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getOwnershipInterestType().contains(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Employer, get Employment //set OwnershipInterestType
							((Employer) ((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getLast("Employer")).getEmployment().setOwnershipInterestType(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getOwnershipInterestType()));
					}		
					//SpecialBorrowerEmployerRelationshipIndicator
					else if(currentNode.getNodeName().toLowerCase().equals("SpecialBorrowerEmployerRelationshipIndicator".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("SpecialBorrowerEmployerRelationshipIndicator"));
						}
						//if node information is a boolean
						else if(ComputeError.isBoolean(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Employer, get Employment //set SpecialBorrowerEmployerRelationshipIndicator 
							if(currentNode.getFirstChild().getNodeValue().toLowerCase().equals("true"))
								((Employer) ((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getLast("Employer")).getEmployment().setSpecialBorrowerEmployerRelationshipIndicator(true);
							else if(currentNode.getFirstChild().getNodeValue().toLowerCase().equals("false"))
								((Employer) ((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getLast("Employer")).getEmployment().setSpecialBorrowerEmployerRelationshipIndicator(false);
						}
						else{
							//report error
							errorList.add(PrintError.notABoolean(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue()));
						}
					}	
					else if(!matchEmploymentExtension(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Employment"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchEmploymentExtension(Node currentNode)
	{
		boolean result = true;
		
		//Extension
		if(currentNode.getNodeName().toLowerCase().equals("Extension".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchEmploymentExtensionOther(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Extension"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchEmploymentExtensionOther(Node currentNode)
	{
		boolean result = true;
		
		//Other
		if(currentNode.getNodeName().toLowerCase().equals("Other".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchEmployment_Extension(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Other"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchEmployment_Extension(Node currentNode)
	{
		boolean result = true;
		
		//Extension
		if(currentNode.getNodeName().toLowerCase().equals("DU:Employment_Extension".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//ForeignIncomeIndicator
					if(currentNode.getNodeName().toLowerCase().equals("DU:ForeignIncomeIndicator".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("DU:ForeignIncomeIndicator"));
						}
						//if node information is a boolean
						else if(ComputeError.isBoolean(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, get last Deal_Set, get last Deal, get last Party, get last Role, get Borrower, get Borrower_Detail, get Current_Income, get last Current_Income_Item, get Current_Income_Item_Detail, set ForeignIncomeIndicator
							if(currentNode.getFirstChild().getNodeValue().toLowerCase().equals("true"))
								((Employer) ((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getLast("Employer")).getEmployment().getExtension().getOther().getEmployment_Extension().setForeignIncomeIndicator(true);
							else if(currentNode.getFirstChild().getNodeValue().toLowerCase().equals("false"))
								((Employer) ((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getLast("Employer")).getEmployment().getExtension().getOther().getEmployment_Extension().setForeignIncomeIndicator(false);
						}
						else{
							//report error
							errorList.add(PrintError.notABoolean(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue()));
						}
					}
					//SeasonalIncomeIndicator
					else if(currentNode.getNodeName().toLowerCase().equals("DU:SeasonalIncomeIndicator".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("DU:SeasonalIncomeIndicator"));
						}
						//if node information is a boolean
						else if(ComputeError.isBoolean(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, get last Deal_Set, get last Deal, get last Party, get last Role, get Borrower, get Borrower_Detail, get Current_Income, get last Current_Income_Item, get Current_Income_Item_Detail, set SeasonalIncomeIndicator
							if(currentNode.getFirstChild().getNodeValue().toLowerCase().equals("true"))
								((Employer) ((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getLast("Employer")).getEmployment().getExtension().getOther().getEmployment_Extension().setSeasonalIncomeIndicator(true);
							else if(currentNode.getFirstChild().getNodeValue().toLowerCase().equals("false"))
								((Employer) ((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getLast("Employer")).getEmployment().getExtension().getOther().getEmployment_Extension().setSeasonalIncomeIndicator(false);
						}
						else{
							//report error
							errorList.add(PrintError.notABoolean(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue()));
						}
					}
	
					else	
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "DU:Employment_Extension"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchUnderwriting_Verifications(Node currentNode)
	{
		boolean result = true;
		
		//Adjustment
		if(currentNode.getNodeName().toLowerCase().equals("DU:Underwriting_Verifications".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchUnderwriting_Verification(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "DU:Underwriting_Verifications"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchUnderwriting_Verification(Node currentNode)
	{
		boolean result = true;
		
		//Adjustment
		if(currentNode.getNodeName().toLowerCase().equals("DU:Underwriting_Verification".toLowerCase())){
			//create Java Object
			((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getExtension().getOther().getLoan_Extension().getUnderwriting_Verifications().add(new Underwriting_Verification());
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//SequenceNumber
					if(currentNode.getNodeName().toLowerCase().equals("SequenceNumber".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("SequenceNumber"));
						}
						//if a Positive Numeric String of 1 to 2
						else if(isPositiveInteger(currentNode,1,2)){
							//get last Deal_Set, get last Deal, get Loan, get Extension, get Other, get Loan_Extension, get last Underwriting_Verification, set SequenceNumber
							((Underwriting_Verification) ((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getExtension().getOther().getLoan_Extension().getLast("Underwriting_Verification")).setSequenceNumber(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isPositiveInteger
					}		
					//xlink:label
					else if(currentNode.getNodeName().toLowerCase().equals("xlink:label".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("xlink:label"));
						}
						//if node information is a string in length from 1 to 1000
						else if(ComputeError.isWithinStringLength(currentNode.getFirstChild().getNodeValue(),1,1000)){
							//get last Deal_Set, get last Deal, get last Loan, set xlink:label
							((Underwriting_Verification) ((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getExtension().getOther().getLoan_Extension().getLast("Underwriting_Verification")).setXlinklabel(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.stringLengthOutsideRange(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(),1,1000));
					}
					//VerificationReportIdentifier
					else if(currentNode.getNodeName().toLowerCase().equals("DU:VerificationReportIdentifier".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("DU:VerificationReportIdentifier"));
						}
						//if node information is string in length from 1 to 50
						else if(ComputeError.isWithinStringLength(currentNode.getFirstChild().getNodeValue(),1,50)){
							//get last Deal_Set, get last Deal, get last Loan, get Extension, get Other, get Loan_Extension, get last Underwriting_Verification, set VerificationReportIdentifier
							((Underwriting_Verification) ((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getExtension().getOther().getLoan_Extension().getLast("Underwriting_Verification")).setVerificationReportIdentifier(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.stringLengthOutsideRange(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(),1,50));
					}		
					//VerificationReportSupplierType
					else if(currentNode.getNodeName().toLowerCase().equals("DU:VerificationReportSupplierType".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("DU:VerificationReportSupplierType"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getVerificationReportSupplierType().contains(currentNode.getFirstChild().getNodeValue())){
							//get last Deal_Set, get last Deal, get last Loan, get Extension, get Other, get Loan_Extension, get last Underwriting_Verification, set VerificationReportSupplierType
							((Underwriting_Verification) ((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getExtension().getOther().getLoan_Extension().getLast("Underwriting_Verification")).setVerificationReportSupplierType(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getVerificationReportSupplierType()));
					}
					//VerificationReportType
					else if(currentNode.getNodeName().toLowerCase().equals("DU:VerificationReportType".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("DU:VerificationReportType"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getVerificationReportType().contains(currentNode.getFirstChild().getNodeValue())){
							//get last Deal_Set, get last Deal, get last Loan, get Extension, get Other, get Loan_Extension, get last Underwriting_Verification, set VerificationReportType
							((Underwriting_Verification) ((Loan) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Loan")).getExtension().getOther().getLoan_Extension().getLast("Underwriting_Verification")).setVerificationReportType(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getVerificationReportType()));
					}
					else
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "DU:Underwriting_Verification"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchEmployerLegal_Entity(Node currentNode)
	{
		boolean result = true;
		
		//Legal_Entity
		if(currentNode.getNodeName().toLowerCase().equals("Legal_Entity".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchEmployerLegal_EntityContacts(currentNode))
						if(!matchEmployerLegal_Entity_Detail(currentNode))
							//report error
							errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Borrower/Employers/Employer/Legal_Entity/"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchEmployerLegal_EntityContacts(Node currentNode)
	{
		boolean result = true;
		
		//Legal_Entity
		if(currentNode.getNodeName().toLowerCase().equals("CONTACTS".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchEmployerLegal_EntityContact(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Borrower/Employers/Employer/Legal_Entity/Contacts/"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchEmployerLegal_EntityContact(Node currentNode)
	{
		boolean result = true;
		
		//Contact
		if(currentNode.getNodeName().toLowerCase().equals("Contact".toLowerCase())){
			//Create Java Object
			((Employer) ((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getLast("Employer")).getLegal_Entity().getContacts().add(new Contact());
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchEmployerLegal_EntityContact_Points(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Borrower/Employers/Employer/Legal_Entity/Contacts/Contact/"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchEmployerLegal_EntityContact_Points(Node currentNode)
	{
		boolean result = true;
		
		//Contact_Points
		if(currentNode.getNodeName().toLowerCase().equals("Contact_Points".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchEmployerLegal_EntityContact_Point(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Borrower/Employers/Employer/Legal_Entity/Contacts/Contact/Contact_Points/"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchEmployerLegal_EntityContact_Point(Node currentNode)
	{
		boolean result = true;
		
		//Legal_Entity
		if(currentNode.getNodeName().toLowerCase().equals("Contact_Point".toLowerCase())){
			//Create Java Object
			((Contact) ((Employer) ((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getLast("Employer")).getLegal_Entity().getLast("Contact")).getContact_Points().add(new information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.Emp.LegEnt.Cont.Contact_Point());
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchEmployerLegal_EntityContact_Point_Telephone(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Borrower/Employers/Employer/Legal_Entity/Contacts/Contact/Contact_Points/Contact_Point/"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchEmployerLegal_EntityContact_Point_Telephone(Node currentNode)
	{
		boolean result = true;
		
		//Legal_Entity
		if(currentNode.getNodeName().toLowerCase().equals("Contact_Point_Telephone".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//ContactPointTelephoneValue
					if(currentNode.getNodeName().toLowerCase().equals("ContactPointTelephoneValue".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("Borrower/Employers/Employer/Legal_Entity/Contacts/Contact/Contact_Points/Contact_Point_Telephone/ContactPointTelephoneValue"));
						}
						//if a Positive Numeric String of 10 to 10
						else if(isPositiveInteger(currentNode,10,10)){
							//get last Deal_Set //get last Deal //get last Party, get last Role, get Borrower, get last Employer, get Legal_Entity, get last Contact, get last Contact_Point, get Contact_Point_Telephone, then set ContactPointTelephoneValue
							((information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.Emp.LegEnt.Cont.Contact_Point) ((Contact) ((Employer) ((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getLast("Employer")).getLegal_Entity().getLast("Contact")).getLast("Contact_Point")).getContact_Point_Telephone().setContactPointTelephoneValue(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isPositiveInteger
					}
					else
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Borrower/Employers/Employer/Legal_Entity/Contacts/Contact/Contact_Points/Contact_Point_Telephone/"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchEmployerLegal_Entity_Detail(Node currentNode)
	{
		boolean result = true;
		
		//Legal_Entity_Detail
		if(currentNode.getNodeName().toLowerCase().equals("Legal_Entity_Detail".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//FullName	
					if(currentNode.getNodeName().toLowerCase().equals("FullName".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("Borrower/Employers/Employer/Legal_Entity/Legal_Entity_Detail/FullName"));
						}
						//if node information is string in length from 1 to 150
						else if(ComputeError.isWithinStringLength(currentNode.getFirstChild().getNodeValue(),1,150)){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Borrower, get last Employer, get Legal_Entity, get Legal_Entity_Detail  //set FullName
							((Employer) ((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getLast("Employer")).getLegal_Entity().getLegal_Entity_Detail().setFullName(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.stringLengthOutsideRange(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(),1,150, "Borrower/Employers/Employer/Legal_Entity/Legal_Entity_Detail/"));
					}
					else
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Borrower/Employers/Employer/Legal_Entity/Legal_Entity_Detail/"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchEmployerIndividual(Node currentNode)
	{
		boolean result = true;
		
		//Declaration
		if(currentNode.getNodeName().toLowerCase().equals("Individual".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchEmployerIndividualName(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Individual"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchEmployerIndividualName(Node currentNode)
	{
		boolean result = true;
		
		//Name
		if(currentNode.getNodeName().toLowerCase().equals("Name".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//FullName	
					if(currentNode.getNodeName().toLowerCase().equals("FullName".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("Borrower/Employers/Employer/Individual/Name/FullName"));
						}
						//if node information is string in length from 1 to 150
						else if(ComputeError.isWithinStringLength(currentNode.getFirstChild().getNodeValue(),1,150)){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Borrower, get last Employer, get Individual, get Name  //set FullName
							((Employer) ((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getLast("Employer")).getIndividual().getName().setFullName(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.stringLengthOutsideRange(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(),1,150, "Borrower/Employers/Employer/Individual/Name/"));
					}
					else
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Borrower/Employers/Employer/Individual/Name/"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchMilitary_Services(Node currentNode)
	{
		boolean result = true;
		
		//Military_Services
		if(currentNode.getNodeName().toLowerCase().equals("Military_Services".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchMilitary_Service(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Military_Services"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchMilitary_Service(Node currentNode)
	{
		boolean result = true;
		
		//Bankruptcy
		if(currentNode.getNodeName().toLowerCase().equals("Military_Service".toLowerCase())){
			//create Java object
			((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getMilitary_Services().add(new Military_Service());
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//MilitaryServiceExpectedCompletionDate
					if(currentNode.getNodeName().toLowerCase().equals("MilitaryServiceExpectedCompletionDate".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("MilitaryServiceExpectedCompletionDate"));
						}
						//if node information is a date value
						else if(ComputeError.isDate(currentNode.getFirstChild().getNodeValue()))
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Borrower, get last Military_Service //set MilitaryServiceExpectedCompletionDate
							((Military_Service) ((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getLast("Military_Service")).setMilitaryServiceExpectedCompletionDate(Utility.setDate(currentNode.getFirstChild().getNodeValue()));
						else
							//report error
							errorList.add(PrintError.notADate(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue()));
					}
					//MilitaryStatusType
					else if(currentNode.getNodeName().toLowerCase().equals("MilitaryStatusType".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("MilitaryStatusType"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getMilitaryStatusType().contains(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Borrower, get last Military_Service //set MilitaryStatusType
							((Military_Service) ((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getLast("Military_Service")).setMilitaryStatusType(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getMilitaryStatusType()));
					}		
					else
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Military_Service"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchSubject_PropertyAddress(Node currentNode)
	{
		boolean result = true;
		
		//Address
		if(currentNode.getNodeName().toLowerCase().equals("Address".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//AddressLineText
					if(currentNode.getNodeName().toLowerCase().equals("AddressLineText".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("AddressLineText"));
						}
						//if node information is string of length 1 to 50
						else if(ComputeError.isWithinStringLength(currentNode.getFirstChild().getNodeValue(),1,50)){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get Collaterals, then the last Collateral //get Subject_Property, get Address, then set AddressLineText
							((Collateral) ( (Deal) ( (Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Collateral")).getSubject_Property().getAddress().setAddressLineText(currentNode.getFirstChild().getNodeValue());}
						else
							//report error
							errorList.add(PrintError.stringLengthOutsideRange(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(),1,50,"Subject_Property/Address"));
					}
					//AddressUnitIdentifier
					else if(currentNode.getNodeName().toLowerCase().equals("AddressUnitIdentifier".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("AddressUnitIdentifier"));
						}
						//if node information is string of length 1 to 11
						else if(ComputeError.isWithinStringLength(currentNode.getFirstChild().getNodeValue(),1,11)){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get Collaterals, then the last Collateral //get Subject_Property, get Address, then set AddressUnitIdentifier
							( (Collateral) ( (Deal) ( (Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Collateral")).getSubject_Property().getAddress().setAddressUnitIdentifier(currentNode.getFirstChild().getNodeValue());}
						else
							//report error
							errorList.add(PrintError.stringLengthOutsideRange(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(),1,11,"Subject_Property/Address"));
					}
					//CityName
					else if(currentNode.getNodeName().toLowerCase().equals("CityName".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("CityName"));
						}
						//if node information is string of length 1 to 35
						else if(ComputeError.isWithinStringLength(currentNode.getFirstChild().getNodeValue(),1,35)){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get Collaterals, then the last Collateral //get Subject_Property, get Address, then set CityName
							( (Collateral) ( (Deal) ( (Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Collateral")).getSubject_Property().getAddress().setCityName(currentNode.getFirstChild().getNodeValue());}
						else
							//report error
							errorList.add(PrintError.stringLengthOutsideRange(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(),1,35,"Subject_Property/Address"));
					}
					//PostalCode
					else if(currentNode.getNodeName().toLowerCase().equals("PostalCode".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("PostalCode"));
						}
						//if node information is string of length 1 to 9
						else if(ComputeError.isWithinStringLength(currentNode.getFirstChild().getNodeValue(),1,9)){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get Collaterals, then the last Collateral //get Subject_Property, get Address, then set PostalCode
							( (Collateral) ( (Deal) ( (Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Collateral")).getSubject_Property().getAddress().setPostalCode(currentNode.getFirstChild().getNodeValue());}
						else
							//report error
							errorList.add(PrintError.stringLengthOutsideRange(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(),1,9,"Subject_Property/Address"));
					}
					//StateCode
					else if(currentNode.getNodeName().toLowerCase().equals("StateCode".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("StateCode"));
						}
						//if node information is string of length 1 to 2
						else if(ComputeError.isWithinStringLength(currentNode.getFirstChild().getNodeValue(),1,2)){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get Collaterals, then the last Collateral //get Subject_Property, get Address, then set StateCode
							( (Collateral) ( (Deal) ( (Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Collateral")).getSubject_Property().getAddress().setStateCode(currentNode.getFirstChild().getNodeValue());}
						else
							//report error
							errorList.add(PrintError.stringLengthOutsideRange(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(),1,2,"Subject_Property/Address"));
					}
					else
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(),"Subject_Property/Address"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchLocation_Identifier(Node currentNode)
	{
		boolean result = true;
		
		//Location_Identifier
		if(currentNode.getNodeName().toLowerCase().equals("Location_Identifier".toLowerCase())){
			//create Java object
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchCensus_Information(currentNode))
						if(!matchFIPS_Information(currentNode))
							if(!matchGeneral_Identifier(currentNode))
								//report error
								errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Location_Identifier"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchCensus_Information(Node currentNode)
	{
		boolean result = true;
		
		//FIPS_Information
		if(currentNode.getNodeName().toLowerCase().equals("Census_Information".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//CensusTractIdentifier
					if(currentNode.getNodeName().toLowerCase().equals("CensusTractIdentifier".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("CensusTractIdentifier"));
						}
						//if a Positive Numeric String of 6 to 6
						else if(isPositiveInteger(currentNode,6,6)){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get Collaterals, then the last Collateral //get Location_Identifier, get FIPS_Information, then set CensusTractIdentifier
							((Collateral) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Collateral")).getSubject_Property().getLocation_Identifier().getCensus_Information().setCensusTractIdentifier(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isPositiveInteger
					}
					else
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Census_Information"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchFIPS_Information(Node currentNode)
	{
		boolean result = true;
		
		//FIPS_Information
		if(currentNode.getNodeName().toLowerCase().equals("FIPS_Information".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//FIPSCountyCode
					if(currentNode.getNodeName().toLowerCase().equals("FIPSCountyCode".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("FIPSCountyCode"));
						}
						//if a Positive Numeric String of 3 to 3
						else if(isPositiveInteger(currentNode,3,3)){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get Collaterals, then the last Collateral //get Location_Identifier, get FIPS_Information, then set FIPSCountyCode
							( (Collateral) ( (Deal) ( (Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Collateral")).getSubject_Property().getLocation_Identifier().getfIPS_Information().setfIPSCountyCode(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isPositiveInteger
					}
					//FIPSStateNumericCode
					else if(currentNode.getNodeName().toLowerCase().equals("FIPSStateNumericCode".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("FIPSStateNumericCode"));
						}
						//if a Positive Numeric String of 2 to 2
						else if(isPositiveInteger(currentNode,2,2)){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get Collaterals, then the last Collateral //get Location_Identifier, get FIPS_Information, then set FIPSStateNumericCode
							( (Collateral) ( (Deal) ( (Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Collateral")).getSubject_Property().getLocation_Identifier().getfIPS_Information().setfIPSStateNumericCode(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isPositiveInteger
					}
					else
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "FIPS_Information"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchGeneral_Identifier(Node currentNode)
	{
		boolean result = true;
		
		//FIPS_Information
		if(currentNode.getNodeName().toLowerCase().equals("General_Identifier".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//MSAIdentifier
					if(currentNode.getNodeName().toLowerCase().equals("MSAIdentifier".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("MSAIdentifier"));
						}
						//if a Positive Numeric String of 5 to 5
						else if(isPositiveInteger(currentNode,5,5)){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get Collaterals, then the last Collateral //get Location_Identifier, get General_Identifier, then set MSAIdentifier
							((Collateral) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Collateral")).getSubject_Property().getLocation_Identifier().getGeneral_Identifier().setMSAIdentifier(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isPositiveInteger
					}
					else
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "General_Identifier"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchProperty_Detail(Node currentNode)
	{
		boolean result = true;
		
		//Property_Detail
		if(currentNode.getNodeName().toLowerCase().equals("Property_Detail".toLowerCase())){
			//create Java object
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//AttachmentType
					if(currentNode.getNodeName().toLowerCase().equals("AttachmentType".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("Subject_Property/Property_Detail/AttachmentType"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getAttachmentType().contains(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, get last Deal_Set, get last Deal, get last Collateral, get Subject Property, get Property_Detail, set AttachmentType
							((Collateral) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Collateral")).getSubject_Property().getProperty_Detail().setAttachmentType(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getAttachmentType(), "Subject_Property/Property_Detail/"));
					}
					//CommunityPropertyStateIndicator
					else if(currentNode.getNodeName().toLowerCase().equals("CommunityPropertyStateIndicator".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("Subject_Property/Property_Detail/CommunityPropertyStateIndicator"));
						}
						//if node information is a boolean
						else if(ComputeError.isBoolean(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, get last Deal_Set, get last Deal, get last Collateral, get Subject Property, get Property_Detail, set CommunityPropertyStateIndicator
							if(currentNode.getFirstChild().getNodeValue().toLowerCase().equals("true"))
								((Collateral) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Collateral")).getSubject_Property().getProperty_Detail().setCommunityPropertyStateIndicator(true);
							else if(currentNode.getFirstChild().getNodeValue().toLowerCase().equals("false"))
								((Collateral) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Collateral")).getSubject_Property().getProperty_Detail().setCommunityPropertyStateIndicator(false);
						}
						else
							//report error
							errorList.add(PrintError.notABoolean(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), "Subject_Property/Property_Detail/"));
					}
					//ConstructionMethodType
					else if(currentNode.getNodeName().toLowerCase().equals("ConstructionMethodType".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("Subject_Property/Property_Detail/ConstructionMethodType"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getConstructionMethodType().contains(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, get last Deal_Set, get last Deal, get last Collateral, get Subject Property, get Property_Detail, set ConstructionMethodType
							((Collateral) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Collateral")).getSubject_Property().getProperty_Detail().setConstructionMethodType(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getConstructionMethodType(), "Subject_Property/Property_Detail/"));
					}
					//ConstructionMethodTypeOtherDescription
					else if(currentNode.getNodeName().toLowerCase().equals("ConstructionMethodTypeOtherDescription".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("Subject_Property/Property_Detail/ConstructionMethodTypeOtherDescription"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getConstructionMethodTypeOtherDescription().contains(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, get last Deal_Set, get last Deal, get last Collateral, get Subject Property, get Property_Detail, set ConstructionMethodTypeOtherDescription
							((Collateral) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Collateral")).getSubject_Property().getProperty_Detail().setConstructionMethodTypeOtherDescription(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getConstructionMethodTypeOtherDescription(), "Subject_Property/Property_Detail/"));
					}
					//FHASecondaryResidenceIndicator
					else if(currentNode.getNodeName().toLowerCase().equals("FHASecondaryResidenceIndicator".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("Subject_Property/Property_Detail/FHASecondaryResidenceIndicator"));
						}
						//if node information is a boolean
						else if(ComputeError.isBoolean(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, get last Deal_Set, get last Deal, get last Collateral, get Subject Property, get Property_Detail, set FHASecondaryResidenceIndicator
							if(currentNode.getFirstChild().getNodeValue().toLowerCase().equals("true"))
								((Collateral) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Collateral")).getSubject_Property().getProperty_Detail().setFHASecondaryResidenceIndicator(true);
							else if(currentNode.getFirstChild().getNodeValue().toLowerCase().equals("false"))
								((Collateral) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Collateral")).getSubject_Property().getProperty_Detail().setFHASecondaryResidenceIndicator(false);
						}
						else
							//report error
							errorList.add(PrintError.notABoolean(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), "Subject_Property/Property_Detail/"));
					}
					//FinancedUnitCount
					else if(currentNode.getNodeName().toLowerCase().equals("FinancedUnitCount".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("Subject_Property/Property_Detail/FinancedUnitCount"));
						}
						//if a Positive Numeric String within range: 1-4
						else if(ComputeError.isWithinBounds(currentNode.getFirstChild().getNodeValue(),1,4)){
							//get Deal_Sets, get last Deal_Set, get last Deal, get last Collateral, get Subject Property, get Property_Detail, set FinancedUnitCount
							((Collateral) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Collateral")).getSubject_Property().getProperty_Detail().setFinancedUnitCount(Integer.parseInt(currentNode.getFirstChild().getNodeValue()));
						}
						else
						{
							//report error
							errorList.add(PrintError.outsideRange(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), 1, 4, "Subject_Property/Property_Detail/"));
						}
					}
					//NativeAmericanLandsType
					else if(currentNode.getNodeName().toLowerCase().equals("NativeAmericanLandsType".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("Subject_Property/Property_Detail/NativeAmericanLandsType"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getNativeAmericanLandsType().contains(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, get last Deal_Set, get last Deal, get last Collateral, get Subject Property, get Property_Detail, set NativeAmericanLandsType
							((Collateral) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Collateral")).getSubject_Property().getProperty_Detail().setNativeAmericanLandsType(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getNativeAmericanLandsType(), "Subject_Property/Property_Detail/"));
					}
					//NativeAmericanLandsTypeOtherDescription
					else if(currentNode.getNodeName().toLowerCase().equals("NativeAmericanLandsTypeOtherDescription".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("Subject_Property/Property_Detail/NativeAmericanLandsTypeOtherDescription"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getNativeAmericanLandsTypeOtherDescription().contains(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, get last Deal_Set, get last Deal, get last Collateral, get Subject Property, get Property_Detail, set NativeAmericanLandsTypeOtherDescription
							((Collateral) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Collateral")).getSubject_Property().getProperty_Detail().setNativeAmericanLandsTypeOtherDescription(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getNativeAmericanLandsTypeOtherDescription(), "Subject_Property/Property_Detail/"));
					}
					//PropertyAcquiredDate
					else if(currentNode.getNodeName().toLowerCase().equals("PropertyAcquiredDate".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("Subject_Property/Property_Detail/PropertyAcquiredDate"));
						}
						//if node information is a date time value
						else if(ComputeError.isDate(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, get last Deal_Set, get last Deal, get last Collateral, get Subject Property, get Property_Detail, set PropertyAcquiredDate
							((Collateral) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Collateral")).getSubject_Property().getProperty_Detail().setPropertyAcquiredDate(Utility.setDate(currentNode.getFirstChild().getNodeValue()));
						}
						else
							//report error
							errorList.add(PrintError.notADate(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), "Subject_Property/Property_Detail/"));
					}
					//PropertyEstateType
					else if(currentNode.getNodeName().toLowerCase().equals("PropertyEstateType".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("Subject_Property/Property_Detail/PropertyEstateType"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getNativeAmericanLandsType().contains(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, get last Deal_Set, get last Deal, get last Collateral, get Subject Property, get Property_Detail, set PropertyEstateType
							((Collateral) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Collateral")).getSubject_Property().getProperty_Detail().setPropertyEstateType(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getPropertyEstateType(), "Subject_Property/Property_Detail/"));
					}
					//PropertyEstimatedValueAmount
					else if(currentNode.getNodeName().toLowerCase().equals("PropertyEstimatedValueAmount".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("Subject_Property/Property_Detail/PropertyEstimatedValueAmount"));
						}
						//if node information is a positive amount of money
						else if(isPositiveMoney(currentNode, 12, 2, "Subject_Property/Property_Detail/")){
							//get Deal_Sets, get last Deal_Set, get last Deal, get last Collateral, get Subject Property, get Property_Detail, set PropertyEstimatedValueAmount
							((Collateral) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Collateral")).getSubject_Property().getProperty_Detail().setPropertyEstimatedValueAmount(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isPositiveMoney
					}
					//PropertyExistingCleanEnergyLienIndicator
					else if(currentNode.getNodeName().toLowerCase().equals("PropertyExistingCleanEnergyLienIndicator".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("Subject_Property/Property_Detail/PropertyExistingCleanEnergyLienIndicator"));
						}
						//if node information is a boolean
						else if(ComputeError.isBoolean(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, get last Deal_Set, get last Deal, get last Collateral, get Subject Property, get Property_Detail, set PropertyExistingCleanEnergyLienIndicator
							if(currentNode.getFirstChild().getNodeValue().toLowerCase().equals("true"))
								((Collateral) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Collateral")).getSubject_Property().getProperty_Detail().setPropertyExistingCleanEnergyLienIndicator(true);
							else if(currentNode.getFirstChild().getNodeValue().toLowerCase().equals("false"))
								((Collateral) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Collateral")).getSubject_Property().getProperty_Detail().setPropertyExistingCleanEnergyLienIndicator(false);
						}
						else
							//report error
							errorList.add(PrintError.notABoolean(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), "Subject_Property/Property_Detail/"));
					}
					//PropertyGroundLeaseExpirationDate
					else if(currentNode.getNodeName().toLowerCase().equals("PropertyGroundLeaseExpirationDate".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("Subject_Property/Property_Detail/PropertyGroundLeaseExpirationDate"));
						}
						//if node information is a date time value
						else if(ComputeError.isDate(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, get last Deal_Set, get last Deal, get last Collateral, get Subject Property, get Property_Detail, set PropertyGroundLeaseExpirationDate
							((Collateral) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Collateral")).getSubject_Property().getProperty_Detail().setPropertyGroundLeaseExpirationDate(Utility.setDate(currentNode.getFirstChild().getNodeValue()));
						}
						else
							//report error
							errorList.add(PrintError.notADate(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), "Subject_Property/Property_Detail/"));
					}
					//PropertyInProjectIndicator
					else if(currentNode.getNodeName().toLowerCase().equals("PropertyInProjectIndicator".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("Subject_Property/Property_Detail/PropertyInProjectIndicator"));
						}
						//if node information is a boolean
						else if(ComputeError.isBoolean(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, get last Deal_Set, get last Deal, get last Collateral, get Subject Property, get Property_Detail, set PropertyInProjectIndicator
							if(currentNode.getFirstChild().getNodeValue().toLowerCase().equals("true"))
								((Collateral) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Collateral")).getSubject_Property().getProperty_Detail().setPropertyInProjectIndicator(true);
							else if(currentNode.getFirstChild().getNodeValue().toLowerCase().equals("false"))
								((Collateral) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Collateral")).getSubject_Property().getProperty_Detail().setPropertyInProjectIndicator(false);
						}
						else
							//report error
							errorList.add(PrintError.notABoolean(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), "Subject_Property/Property_Detail/"));
					}
					//PropertyMixedUsageIndicator
					else if(currentNode.getNodeName().toLowerCase().equals("PropertyMixedUsageIndicator".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("Subject_Property/Property_Detail/PropertyMixedUsageIndicator"));
						}
						//if node information is a boolean
						else if(ComputeError.isBoolean(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, get last Deal_Set, get last Deal, get last Collateral, get Subject Property, get Property_Detail, set PropertyMixedUsageIndicator
							if(currentNode.getFirstChild().getNodeValue().toLowerCase().equals("true"))
								((Collateral) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Collateral")).getSubject_Property().getProperty_Detail().setPropertyMixedUsageIndicator(true);
							else if(currentNode.getFirstChild().getNodeValue().toLowerCase().equals("false"))
								((Collateral) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Collateral")).getSubject_Property().getProperty_Detail().setPropertyMixedUsageIndicator(false);
						}
						else
							//report error
							errorList.add(PrintError.notABoolean(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), "Subject_Property/Property_Detail/"));
					}
					//PropertyStructureBuiltYear
					else if(currentNode.getNodeName().toLowerCase().equals("PropertyStructureBuiltYear".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("Subject_Property/Property_Detail/PropertyStructureBuiltYear"));
						}
						//if a Positive Numeric String of 4 to 4
						else if(isPositiveInteger(currentNode,4,4, "Subject_Property/Property_Detail/")){
							//get Deal_Sets, get last Deal_Set, get last Deal, get last Collateral, get Subject Property, get Property_Detail, set PropertyStructureBuiltYear
							((Collateral) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Collateral")).getSubject_Property().getProperty_Detail().setPropertyStructureBuiltYear(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isPositiveInteger
					}		
					//PropertyUsageType
					else if(currentNode.getNodeName().toLowerCase().equals("PropertyUsageType".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("Subject_Property/Property_Detail/PropertyUsageType"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getPropertyUsageType().contains(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, get last Deal_Set, get last Deal, get last Collateral, get Subject Property, get Property_Detail, set PropertyUsageType
							((Collateral) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Collateral")).getSubject_Property().getProperty_Detail().setPropertyUsageType(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getPropertyUsageType(), "Subject_Property/Property_Detail/"));
					}
					//PUDIndicator
					else if(currentNode.getNodeName().toLowerCase().equals("PUDIndicator".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("Subject_Property/Property_Detail/PUDIndicator"));
						}
						//if node information is a boolean
						else if(ComputeError.isBoolean(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, get last Deal_Set, get last Deal, get last Collateral, get Subject Property, get Property_Detail, set PUDIndicator
							if(currentNode.getFirstChild().getNodeValue().toLowerCase().equals("true"))
								((Collateral) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Collateral")).getSubject_Property().getProperty_Detail().setPUDIndicator(true);
							else if(currentNode.getFirstChild().getNodeValue().toLowerCase().equals("false"))
								((Collateral) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Collateral")).getSubject_Property().getProperty_Detail().setPUDIndicator(false);
						}
						else
							//report error
							errorList.add(PrintError.notABoolean(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), "Subject_Property/Property_Detail/"));
					}
					//RentalEstimatedGrossMonthlyRentAmount
					else if(currentNode.getNodeName().toLowerCase().equals("RentalEstimatedGrossMonthlyRentAmount".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("Subject_Property/Property_Detail/RentalEstimatedGrossMonthlyRentAmount"));
						}
						//if node information is a positive amount of money
						else if(isPositiveMoney(currentNode, 12, 2, "Subject_Property/Property_Detail/")){
							//get Deal_Sets, get last Deal_Set, get last Deal, get last Collateral, get Subject Property, get Property_Detail, set RentalEstimatedGrossMonthlyRentAmount
							((Collateral) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Collateral")).getSubject_Property().getProperty_Detail().setRentalEstimatedGrossMonthlyRentAmount(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isPositiveMoney
					}
					//RentalEstimatedNetMonthlyRentAmount
					else if(currentNode.getNodeName().toLowerCase().equals("RentalEstimatedNetMonthlyRentAmount".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("Subject_Property/Property_Detail/RentalEstimatedNetMonthlyRentAmount"));
						}
						//if node information is a positive amount of money
						else if(isPositiveMoney(currentNode, 12, 2, "Subject_Property/Property_Detail/")){
							//get Deal_Sets, get last Deal_Set, get last Deal, get last Collateral, get Subject Property, get Property_Detail, set RentalEstimatedNetMonthlyRentAmount
							((Collateral) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Collateral")).getSubject_Property().getProperty_Detail().setRentalEstimatedNetMonthlyRentAmount(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isPositiveMoney
					}
					else
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Subject_Property/Property_Detail/"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchGovernment_Borrower(Node currentNode)
	{
		boolean result = true;
		
		//Government_Borrower
		if(currentNode.getNodeName().toLowerCase().equals("Government_Borrower".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//CAIVRSIdentifier
					if(currentNode.getNodeName().toLowerCase().equals("CAIVRSIdentifier".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("CAIVRSIdentifier"));
						}
						//if node information is string in length from 1 to 10
						else if(ComputeError.isWithinStringLength(currentNode.getFirstChild().getNodeValue(),1,10)){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Borrower, get Government_Borrower //set CAIVRSIdentifier
							((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getGovernment_Borrower().setCAIVRSIdentifier(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.stringLengthOutsideRange(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(),1,10));
					}
					//VACoBorrowerNontaxableIncomeAmount
					else if(currentNode.getNodeName().toLowerCase().equals("VACoBorrowerNontaxableIncomeAmount".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("VACoBorrowerNontaxableIncomeAmount"));
						}
						//if node information is a positive or zero amount of money
						else if(isPositiveOrZeroMoney(currentNode, 12, 2)){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Borrower, get Government_Borrower //set VACoBorrowerNontaxableIncomeAmount
							((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getGovernment_Borrower().setVACoBorrowerNontaxableIncomeAmount(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isPositiveOrZeroMoney
					}
					//VACoBorrowerTaxableIncomeAmount
					else if(currentNode.getNodeName().toLowerCase().equals("VACoBorrowerTaxableIncomeAmount".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("VACoBorrowerTaxableIncomeAmount"));
						}
						//if node information is a positive or zero amount of money
						else if(isPositiveOrZeroMoney(currentNode, 12, 2)){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Borrower, get Government_Borrower //set VACoBorrowerTaxableIncomeAmount
							((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getGovernment_Borrower().setVACoBorrowerTaxableIncomeAmount(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isPositiveOrZeroMoney
					}
					//VAFederalTaxAmount
					else if(currentNode.getNodeName().toLowerCase().equals("VAFederalTaxAmount".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("VAFederalTaxAmount"));
						}
						//if node information is a positive or zero amount of money
						else if(isPositiveOrZeroMoney(currentNode, 12, 2)){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Borrower, get Government_Borrower //set VAFederalTaxAmount
							((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getGovernment_Borrower().setVAFederalTaxAmount(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isPositiveOrZeroMoney
					}
					//VALocalTaxAmount
					else if(currentNode.getNodeName().toLowerCase().equals("VALocalTaxAmount".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("VALocalTaxAmount"));
						}
						//if node information is a positive or zero amount of money
						else if(isPositiveOrZeroMoney(currentNode, 12, 2)){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Borrower, get Government_Borrower //set VALocalTaxAmount
							((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getGovernment_Borrower().setVALocalTaxAmount(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isPositiveOrZeroMoney
					}
					//VAPrimaryBorrowerNontaxableIncomeAmount
					else if(currentNode.getNodeName().toLowerCase().equals("VAPrimaryBorrowerNontaxableIncomeAmount".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("VAPrimaryBorrowerNontaxableIncomeAmount"));
						}
						//if node information is a positive or zero amount of money
						else if(isPositiveOrZeroMoney(currentNode, 12, 2)){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Borrower, get Government_Borrower //set VAPrimaryBorrowerNontaxableIncomeAmount
							((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getGovernment_Borrower().setVAPrimaryBorrowerNontaxableIncomeAmount(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isPositiveOrZeroMoney
					}
					//VAPrimaryBorrowerTaxableIncomeAmount
					else if(currentNode.getNodeName().toLowerCase().equals("VAPrimaryBorrowerTaxableIncomeAmount".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("VAPrimaryBorrowerTaxableIncomeAmount"));
						}
						//if node information is a positive or zero amount of money
						else if(isPositiveOrZeroMoney(currentNode, 12, 2)){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Borrower, get Government_Borrower //set VAPrimaryBorrowerTaxableIncomeAmount
							((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getGovernment_Borrower().setVAPrimaryBorrowerTaxableIncomeAmount(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isPositiveOrZeroMoney
					}
					//VASocialSecurityTaxAmount
					else if(currentNode.getNodeName().toLowerCase().equals("VASocialSecurityTaxAmount".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("VASocialSecurityTaxAmount"));
						}
						//if node information is a positive or zero amount of money
						else if(isPositiveOrZeroMoney(currentNode, 12, 2)){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Borrower, get Government_Borrower //set VASocialSecurityTaxAmount
							((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getGovernment_Borrower().setVASocialSecurityTaxAmount(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isPositiveOrZeroMoney
					}
					//VAStateTaxAmount
					else if(currentNode.getNodeName().toLowerCase().equals("VAStateTaxAmount".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("VAStateTaxAmount"));
						}
						//if node information is a positive or zero amount of money
						else if(isPositiveOrZeroMoney(currentNode, 12, 2)){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Borrower, get Government_Borrower //set VAStateTaxAmount
							((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getGovernment_Borrower().setVAStateTaxAmount(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isPositiveOrZeroMoney
					}
					else
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Government_Borrower"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchGovernment_Monitoring(Node currentNode)
	{
		boolean result = true;
		
		//Government_Monitoring
		if(currentNode.getNodeName().toLowerCase().equals("Government_Monitoring".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchGovernment_MonitoringExtension(currentNode))
						if(!matchHMDA_Ethnicity_Origins(currentNode))
							if(!matchGovernment_Monitoring_Detail(currentNode))
								if(!matchHMDA_Races(currentNode))
									//report error
									errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Government_Monitoring"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchGovernment_MonitoringExtension(Node currentNode)
	{
		boolean result = true;
		
		//Extension
		if(currentNode.getNodeName().toLowerCase().equals("Extension".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchGovernment_MonitoringExtensionOther(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Extension"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchGovernment_MonitoringExtensionOther(Node currentNode)
	{
		boolean result = true;
		
		//Other
		if(currentNode.getNodeName().toLowerCase().equals("Other".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchGovernment_Monitoring_Extension(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Other"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchGovernment_Monitoring_Extension(Node currentNode)
	{
		boolean result = true;
		
		//Government_Monitoring_Extension
		if(currentNode.getNodeName().toLowerCase().equals("ULAD:Government_Monitoring_Extension".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchHMDA_Ethnicities(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "ULAD:Government_Monitoring_Extension"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchHMDA_Ethnicities(Node currentNode)
	{
		boolean result = true;
		
		//HMDA_Ethnicities
		if(currentNode.getNodeName().toLowerCase().equals("ULAD:HMDA_Ethnicities".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchHMDA_Ethnicity(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "ULAD:HMDA_Ethnicities"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchHMDA_Ethnicity(Node currentNode)
	{
		boolean result = true;
		
		//HMDA_Ethnicity
		if(currentNode.getNodeName().toLowerCase().equals("ULAD:HMDA_Ethnicity".toLowerCase())){
			//create Java Object
			((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getGovernment_Monitoring().getExtension().getOther().getGovernment_Monitoring_Extension().getHMDA_Ethnicities().add(new HMDA_Ethnicity());
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//HMDAEthnicityType
					if(currentNode.getNodeName().toLowerCase().equals("ULAD:HMDAEthnicityType".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("ULAD:HMDAEthnicityType"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getHMDAEthnicityType().contains(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Borrower, get Government_Monitoring, get Extension, get Other, get Government_Monitoring_Extension, get last HMDA_Ethnicity //set HMDAEthnicityType
							((HMDA_Ethnicity) ((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getGovernment_Monitoring().getExtension().getOther().getGovernment_Monitoring_Extension().getLast("HMDA_Ethnicity")).setHMDAEthnicityType(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getHMDAEthnicityType()));
					}		
					else			
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "ULAD:HMDA_Ethnicity"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchHMDA_Ethnicity_Origins(Node currentNode)
	{
		boolean result = true;
		
		//HMDA_Ethnicity_Origins
		if(currentNode.getNodeName().toLowerCase().equals("HMDA_Ethnicity_Origins".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchHMDA_Ethnicity_Origin(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "HMDA_Ethnicity_Origins"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchHMDA_Ethnicity_Origin(Node currentNode)
	{
		boolean result = true;
		
		//HMDA_Ethnicity_Origin
		if(currentNode.getNodeName().toLowerCase().equals("HMDA_Ethnicity_Origin".toLowerCase())){
			//create Java Object
			((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getGovernment_Monitoring().getHMDA_Ethnicity_Origins().add(new HMDA_Ethnicity_Origin());
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//HMDAEthnicityOriginType
					if(currentNode.getNodeName().toLowerCase().equals("HMDAEthnicityOriginType".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("HMDAEthnicityOriginType"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getHMDAEthnicityOriginType().contains(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get Last Role, get Borrower, get Government_Monitoring, get last HMDA_Ethnicity_Origin //set HMDAEthnicityOriginType
							((HMDA_Ethnicity_Origin) ((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getGovernment_Monitoring().getLast("HMDA_Ethnicity_Origin")).setHMDAEthnicityOriginType(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getHMDAEthnicityOriginType()));
					}		
					//HMDAEthnicityOriginTypeOtherDescription
					else if(currentNode.getNodeName().toLowerCase().equals("HMDAEthnicityOriginTypeOtherDescription".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("HMDAEthnicityOriginTypeOtherDescription"));
						}
						//if node information is string in length from 1 to 100
						else if(ComputeError.isWithinStringLength(currentNode.getFirstChild().getNodeValue(),1,100)){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Taxpayer_Identifier //set HMDAEthnicityOriginTypeOtherDescription
							((HMDA_Ethnicity_Origin) ((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getGovernment_Monitoring().getLast("HMDA_Ethnicity_Origin")).setHMDAEthnicityOriginTypeOtherDescription(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.stringLengthOutsideRange(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(),1,100));
					}		
					else			
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "HMDA_Ethnicity_Origin"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchGovernment_Monitoring_Detail(Node currentNode)
	{
		boolean result = true;
		
		//Government_Monitoring_Detail
		if(currentNode.getNodeName().toLowerCase().equals("Government_Monitoring_Detail".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
						//HMDAEthnicityCollectedBasedOnVisualObservationOrSurnameIndicator
						if(currentNode.getNodeName().toLowerCase().equals("HMDAEthnicityCollectedBasedOnVisualObservationOrSurnameIndicator".toLowerCase())){
							//check if value is empty
							if(currentNode.getFirstChild() == null){
								errorList.add(PrintError.missing("HMDAEthnicityCollectedBasedOnVisualObservationOrSurnameIndicator"));
							}
							//if node information is a boolean
							else if(ComputeError.isBoolean(currentNode.getFirstChild().getNodeValue())){
								//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Borrower, get Government_Monitoring, get Government_Monitoring_Detail, set HMDAEthnicityCollectedBasedOnVisualObservationOrSurnameIndicator
								if(currentNode.getFirstChild().getNodeValue().toLowerCase().equals("true"))
									((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getGovernment_Monitoring().getGovernment_Monitoring_Detail().setHMDAEthnicityCollectedBasedOnVisualObservationOrSurnameIndicator(true);
								else if(currentNode.getFirstChild().getNodeValue().toLowerCase().equals("false"))
									((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getGovernment_Monitoring().getGovernment_Monitoring_Detail().setHMDAEthnicityCollectedBasedOnVisualObservationOrSurnameIndicator(false);
							}
							else{
								//report error
								errorList.add(PrintError.notABoolean(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue()));
							}
						}
						//HMDAEthnicityRefusalIndicator
						else if(currentNode.getNodeName().toLowerCase().equals("HMDAEthnicityRefusalIndicator".toLowerCase())){
							//check if value is empty
							if(currentNode.getFirstChild() == null){
								errorList.add(PrintError.missing("HMDAEthnicityRefusalIndicator"));
							}
							//if node information is a boolean
							else if(ComputeError.isBoolean(currentNode.getFirstChild().getNodeValue())){
								//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Borrower, get Government_Monitoring, get Government_Monitoring_Detail, set HMDAEthnicityRefusalIndicator
								if(currentNode.getFirstChild().getNodeValue().toLowerCase().equals("true"))
									((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getGovernment_Monitoring().getGovernment_Monitoring_Detail().setHMDAEthnicityRefusalIndicator(true);
								else if(currentNode.getFirstChild().getNodeValue().toLowerCase().equals("false"))
									((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getGovernment_Monitoring().getGovernment_Monitoring_Detail().setHMDAEthnicityRefusalIndicator(false);
							}
							else{
								//report error
								errorList.add(PrintError.notABoolean(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue()));
							}
						}
						//HMDAGenderCollectedBasedOnVisualObservationOrNameIndicator
						else if(currentNode.getNodeName().toLowerCase().equals("HMDAGenderCollectedBasedOnVisualObservationOrNameIndicator".toLowerCase())){
							//check if value is empty
							if(currentNode.getFirstChild() == null){
								errorList.add(PrintError.missing("HMDAGenderCollectedBasedOnVisualObservationOrNameIndicator"));
							}
							//if node information is a boolean
							else if(ComputeError.isBoolean(currentNode.getFirstChild().getNodeValue())){
								//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Borrower, get Government_Monitoring, get Government_Monitoring_Detail, set HMDAGenderCollectedBasedOnVisualObservationOrNameIndicator
								if(currentNode.getFirstChild().getNodeValue().toLowerCase().equals("true"))
									((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getGovernment_Monitoring().getGovernment_Monitoring_Detail().setHMDAGenderCollectedBasedOnVisualObservationOrNameIndicator(true);
								else if(currentNode.getFirstChild().getNodeValue().toLowerCase().equals("false"))
									((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getGovernment_Monitoring().getGovernment_Monitoring_Detail().setHMDAGenderCollectedBasedOnVisualObservationOrNameIndicator(false);
							}
							else{
								//report error
								errorList.add(PrintError.notABoolean(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue()));
							}
						}
						//HMDAGenderRefusalIndicator
						else if(currentNode.getNodeName().toLowerCase().equals("HMDAGenderRefusalIndicator".toLowerCase())){
							//check if value is empty
							if(currentNode.getFirstChild() == null){
								errorList.add(PrintError.missing("HMDAGenderRefusalIndicator"));
							}
							//if node information is a boolean
							else if(ComputeError.isBoolean(currentNode.getFirstChild().getNodeValue())){
								//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Borrower, get Government_Monitoring, get Government_Monitoring_Detail, set HMDAGenderRefusalIndicator
								if(currentNode.getFirstChild().getNodeValue().toLowerCase().equals("true"))
									((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getGovernment_Monitoring().getGovernment_Monitoring_Detail().setHMDAGenderRefusalIndicator(true);
								else if(currentNode.getFirstChild().getNodeValue().toLowerCase().equals("false"))
									((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getGovernment_Monitoring().getGovernment_Monitoring_Detail().setHMDAGenderRefusalIndicator(false);
							}
							else{
								//report error
								errorList.add(PrintError.notABoolean(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue()));
							}
						}
						//HMDARaceCollectedBasedOnVisualObservationOrSurnameIndicator
						else if(currentNode.getNodeName().toLowerCase().equals("HMDARaceCollectedBasedOnVisualObservationOrSurnameIndicator".toLowerCase())){
							//check if value is empty
							if(currentNode.getFirstChild() == null){
								errorList.add(PrintError.missing("HMDARaceCollectedBasedOnVisualObservationOrSurnameIndicator"));
							}
							//if node information is a boolean
							else if(ComputeError.isBoolean(currentNode.getFirstChild().getNodeValue())){
								//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Borrower, get Government_Monitoring, get Government_Monitoring_Detail, set HMDARaceCollectedBasedOnVisualObservationOrSurnameIndicator
								if(currentNode.getFirstChild().getNodeValue().toLowerCase().equals("true"))
									((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getGovernment_Monitoring().getGovernment_Monitoring_Detail().setHMDARaceCollectedBasedOnVisualObservationOrSurnameIndicator(true);
								else if(currentNode.getFirstChild().getNodeValue().toLowerCase().equals("false"))
									((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getGovernment_Monitoring().getGovernment_Monitoring_Detail().setHMDARaceCollectedBasedOnVisualObservationOrSurnameIndicator(false);
							}
							else{
								//report error
								errorList.add(PrintError.notABoolean(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue()));
							}
						}
						//HMDARaceRefusalIndicator
						else if(currentNode.getNodeName().toLowerCase().equals("HMDARaceRefusalIndicator".toLowerCase())){
							//check if value is empty
							if(currentNode.getFirstChild() == null){
								errorList.add(PrintError.missing("HMDARaceRefusalIndicator"));
							}
							//if node information is a boolean
							else if(ComputeError.isBoolean(currentNode.getFirstChild().getNodeValue())){
								//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Borrower, get Government_Monitoring, get Government_Monitoring_Detail, set HMDARaceRefusalIndicator
								if(currentNode.getFirstChild().getNodeValue().toLowerCase().equals("true"))
									((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getGovernment_Monitoring().getGovernment_Monitoring_Detail().setHMDARaceRefusalIndicator(true);
								else if(currentNode.getFirstChild().getNodeValue().toLowerCase().equals("false"))
									((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getGovernment_Monitoring().getGovernment_Monitoring_Detail().setHMDARaceRefusalIndicator(false);
							}
							else{
								//report error
								errorList.add(PrintError.notABoolean(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue()));
							}
						}
						else if(!matchGovernment_Monitoring_DetailExtension(currentNode))
							//report error
							errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Government_Monitoring_Detail"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchGovernment_Monitoring_DetailExtension(Node currentNode)
	{
		boolean result = true;
		
		//Extension
		if(currentNode.getNodeName().toLowerCase().equals("Extension".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchGovernment_Monitoring_DetailExtensionOther(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Extension"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchGovernment_Monitoring_DetailExtensionOther(Node currentNode)
	{
		boolean result = true;
		
		//Other
		if(currentNode.getNodeName().toLowerCase().equals("Other".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchGovernment_Monitoring_Detail_Extension(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Other"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchGovernment_Monitoring_Detail_Extension(Node currentNode)
	{
		boolean result = true;
		
		//Other
		if(currentNode.getNodeName().toLowerCase().equals("ULAD:Government_Monitoring_Detail_Extension".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//ApplicationTakenMethodType
					if(currentNode.getNodeName().toLowerCase().equals("ULAD:ApplicationTakenMethodType".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("ULAD:ApplicationTakenMethodType"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getApplicationTakenMethodType().contains(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Borrower, get Government_Monitoring, get Government_Monitoring_Detail, get Extension, get Other, get Government_Monitoring_Detail_Extension  //set ApplicationTakenMethodType
							((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getGovernment_Monitoring().getGovernment_Monitoring_Detail().getExtension().getOther().getGovernment_Monitoring_Detail_Extension().setApplicationTakenMethodType(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getApplicationTakenMethodType()));
					}
					//HMDAGenderType
					else if(currentNode.getNodeName().toLowerCase().equals("ULAD:HMDAGenderType".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("ULAD:HMDAGenderType"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getHMDAGenderType().contains(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Borrower, get Government_Monitoring, get Government_Monitoring_Detail, get Extension, get Other, get Government_Monitoring_Detail_Extension, set HMDAGenderType
							((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getGovernment_Monitoring().getGovernment_Monitoring_Detail().getExtension().getOther().getGovernment_Monitoring_Detail_Extension().setHMDAGenderType(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getHMDAGenderType()));
					}
					else
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "ULAD:Government_Monitoring_Detail_Extension"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchHMDA_Races(Node currentNode)
	{
		boolean result = true;
		
		//HMDA_Races
		if(currentNode.getNodeName().toLowerCase().equals("HMDA_Races".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchHMDA_Race(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "HMDA_Races"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchHMDA_Race(Node currentNode)
	{
		boolean result = true;
		
		//HMDA_Race
		if(currentNode.getNodeName().toLowerCase().equals("HMDA_Race".toLowerCase())){
			//create Java Object
			((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getGovernment_Monitoring().getHMDA_Races().add(new HMDA_Race());
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchHMDA_Race_Designations(currentNode))
						if(!matchHMDA_Race_Detail(currentNode))
							//report error
							errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "HMDA_Race"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchHMDA_Race_Designations(Node currentNode)
	{
		boolean result = true;
		
		//HMDA_Race_Designations
		if(currentNode.getNodeName().toLowerCase().equals("HMDA_Race_Designations".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchHMDA_Race_Designation(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "HMDA_Race_Designations"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchHMDA_Race_Designation(Node currentNode)
	{
		boolean result = true;
		
		//HMDA_Race_Designation
		if(currentNode.getNodeName().toLowerCase().equals("HMDA_Race_Designation".toLowerCase())){
			//create Java Object
			((HMDA_Race) ((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getGovernment_Monitoring().getLast("HMDA_Race")).getHMDA_Race_Designations().add(new HMDA_Race_Designation());
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchHMDA_Race_DesignationExtension(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "HMDA_Race_Designation"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchHMDA_Race_DesignationExtension(Node currentNode)
	{
		boolean result = true;
		
		//Extension
		if(currentNode.getNodeName().toLowerCase().equals("Extension".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchHMDA_Race_DesignationExtensionOther(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Extension"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchHMDA_Race_DesignationExtensionOther(Node currentNode)
	{
		boolean result = true;
		
		//Other
		if(currentNode.getNodeName().toLowerCase().equals("Other".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchHMDA_Race_Designation_Extension(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Other"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchHMDA_Race_Designation_Extension(Node currentNode)
	{
		boolean result = true;
		
		//ULAD:HMDA_Race_Designation_Extension
		if(currentNode.getNodeName().toLowerCase().equals("ULAD:HMDA_Race_Designation_Extension".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//HMDARaceDesignationOtherAsianDescription
					if(currentNode.getNodeName().toLowerCase().equals("ULAD:HMDARaceDesignationOtherAsianDescription".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("ULAD:HMDARaceDesignationOtherAsianDescription"));
						}
						//if node information is string in length from 1 to 100
						else if(ComputeError.isWithinStringLength(currentNode.getFirstChild().getNodeValue(),1,100)){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Borrower, get Government_Monitoring, get last Race, get last HMDA_Race_Designation, get Extension, get Other, get HMDA_Race_Designation_Extension //set HMDARaceDesignationOtherAsianDescription
							((HMDA_Race_Designation) ((HMDA_Race) ((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getGovernment_Monitoring().getLast("HMDA_Race")).getLast("HMDA_Race_Designation")).getExtension().getOther().getHMDA_Race_Designation_Extension().setHMDARaceDesignationOtherAsianDescription(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.stringLengthOutsideRange(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(),1,100));
					}
					//HMDARaceDesignationOtherPacificIslanderDescription
					else if(currentNode.getNodeName().toLowerCase().equals("ULAD:HMDARaceDesignationOtherPacificIslanderDescription".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("ULAD:HMDARaceDesignationOtherPacificIslanderDescription"));
						}
						//if node information is string in length from 1 to 100
						else if(ComputeError.isWithinStringLength(currentNode.getFirstChild().getNodeValue(),1,100)){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Borrower, get Government_Monitoring, get last Race, get last HMDA_Race_Designation, get Extension, get Other, get HMDA_Race_Designation_Extension //set HMDARaceDesignationOtherPacificIslanderDescription
							((HMDA_Race_Designation) ((HMDA_Race) ((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getGovernment_Monitoring().getLast("HMDA_Race")).getLast("HMDA_Race_Designation")).getExtension().getOther().getHMDA_Race_Designation_Extension().setHMDARaceDesignationOtherPacificIslanderDescription(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.stringLengthOutsideRange(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(),1,100));
					}
					//HMDARaceDesignationType
					else if(currentNode.getNodeName().toLowerCase().equals("ULAD:HMDARaceDesignationType".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("ULAD:HMDARaceDesignationType"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getHMDARaceDesignationType().contains(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Borrower, get Government_Monitoring, get last Race, get last HMDA_Race_Designation, get Extension, get Other, get HMDA_Race_Designation_Extension, set HMDARaceDesignationType
							((HMDA_Race_Designation) ((HMDA_Race) ((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getGovernment_Monitoring().getLast("HMDA_Race")).getLast("HMDA_Race_Designation")).getExtension().getOther().getHMDA_Race_Designation_Extension().setHMDARaceDesignationType(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getHMDARaceDesignationType()));
					}	
					else
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "ULAD:HMDA_Race_Designation_Extension"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchHMDA_Race_Detail(Node currentNode)
	{
		boolean result = true;
		
		//HMDA_Race_Detail
		if(currentNode.getNodeName().toLowerCase().equals("HMDA_Race_Detail".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//HMDARaceType
					if(currentNode.getNodeName().toLowerCase().equals("HMDARaceType".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("HMDARaceType"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getHMDARaceType().contains(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Borrower, get Government_Monitoring, get last Race, get HMDA_Race_Detail, set HMDARaceType
							((HMDA_Race) ((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getGovernment_Monitoring().getLast("HMDA_Race")).getHMDA_Race_Detail().setHMDARaceType(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getHMDARaceType()));
					}	
					//HMDARaceTypeAdditionalDescription
					else if(currentNode.getNodeName().toLowerCase().equals("HMDARaceTypeAdditionalDescription".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("HMDARaceTypeAdditionalDescription"));
						}
						//if node information is string in length from 1 to 100
						else if(ComputeError.isWithinStringLength(currentNode.getFirstChild().getNodeValue(),1,100)){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Borrower, get Government_Monitoring, get last Race, get HMDA_Race_Detail, set HMDARaceTypeAdditionalDescription
							((HMDA_Race) ((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getGovernment_Monitoring().getLast("HMDA_Race")).getHMDA_Race_Detail().setHMDARaceTypeAdditionalDescription(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.stringLengthOutsideRange(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(),1,100));
					}
					else
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "HMDA_Race_Designations"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchResidences(Node currentNode)
	{
		boolean result = true;
		
		//Employers
		if(currentNode.getNodeName().toLowerCase().equals("Residences".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchResidence(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Residences"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchResidence(Node currentNode)
	{
		boolean result = true;
		
		//Employer
		if(currentNode.getNodeName().toLowerCase().equals("Residence".toLowerCase())){
			//create Java Object
			((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getResidences().add(new Residence());
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchEmployerAddress(currentNode))
						if(!matchResidenceAddress(currentNode))
							if(!matchLandlord(currentNode))
								if(!matchResidence_Detail(currentNode))
									//report error
									errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Residence"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchResidenceAddress(Node currentNode)
	{
		boolean result = true;
		
		//Employer
		if(currentNode.getNodeName().toLowerCase().equals("Address".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					
					//AddressLineText
					if(currentNode.getNodeName().toLowerCase().equals("AddressLineText".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("AddressLineText"));
						}
						//if node information is string in length from 1 to 35
						else if(ComputeError.isWithinStringLength(currentNode.getFirstChild().getNodeValue(),1,35)){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Borrower, get Address, set AddressLineText
							((Residence) ((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getLast("Residence")).getAddress().setAddressLineText(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.stringLengthOutsideRange(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(),1,35,"Residence/Address"));
					}
					//AddressUnitIdentifier
					else if(currentNode.getNodeName().toLowerCase().equals("AddressUnitIdentifier".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("AddressUnitIdentifier"));
						}
						//if node information is a string in length from 1 to 11
						else if(ComputeError.isWithinStringLength(currentNode.getFirstChild().getNodeValue(),1,11)){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Borrower, get Address, set AddressUnitIdentifier
							((Residence) ((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getLast("Residence")).getAddress().setAddressUnitIdentifier(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.stringLengthOutsideRange(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(),1,11,"Residence/Address"));
					}
					//CityName
					else if(currentNode.getNodeName().toLowerCase().equals("CityName".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("CityName"));
						}
						//if node information is a string in length from 1 to 35
						else if(ComputeError.isWithinStringLength(currentNode.getFirstChild().getNodeValue(),1,35)){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Borrower, get Address, set CityName
							((Residence) ((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getLast("Residence")).getAddress().setCityName(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.stringLengthOutsideRange(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(),1,35,"Residence/Address"));
					}
					//CountryCode
					else if(currentNode.getNodeName().toLowerCase().equals("CountryCode".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("CountryCode"));
						}
						//if node information is a string in length from 1 to 2
						else if(ComputeError.isWithinStringLength(currentNode.getFirstChild().getNodeValue(),1,2)){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Borrower, get Address, set CountryCode
							((Residence) ((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getLast("Residence")).getAddress().setCountryCode(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.stringLengthOutsideRange(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(),1,2,"Residence/Address"));
					}
					//PostalCode
					else if(currentNode.getNodeName().toLowerCase().equals("PostalCode".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("PostalCode"));
						}
						//if node information is a string in length from 1 to 9
						else if(ComputeError.isWithinStringLength(currentNode.getFirstChild().getNodeValue(),1,9)){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Borrower, get Address, set PostalCode
							((Residence) ((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getLast("Residence")).getAddress().setPostalCode(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.stringLengthOutsideRange(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(),1,9,"Residence/Address"));
					}
					//StateCode
					else if(currentNode.getNodeName().toLowerCase().equals("StateCode".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("StateCode"));
						}
						//if node information is a string in length from 1 to 2
						else if(ComputeError.isWithinStringLength(currentNode.getFirstChild().getNodeValue(),1,2)){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Borrower, get Address, set StateCode
							((Residence) ((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getLast("Residence")).getAddress().setStateCode(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.stringLengthOutsideRange(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(),1,2,"Residence/Address"));
					}
					else
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(),"Residence/Address"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchLandlord(Node currentNode)
	{
		boolean result = true;
		
		//Employer
		if(currentNode.getNodeName().toLowerCase().equals("Landlord".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchEmployerAddress(currentNode))
						if(!matchLandlord_Detail(currentNode))
							//report error
							errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Landlord"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchLandlord_Detail(Node currentNode)
	{
		boolean result = true;
		
		//Employer
		if(currentNode.getNodeName().toLowerCase().equals("Landlord_Detail".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//MonthlyRentAmount
					if(isPositiveOrZeroMoney(currentNode, 12, 2)){
						//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Borrower, get Government_Borrower //set MonthlyRentAmount
						((Residence) ((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getLast("Residence")).getLandlord().getLandlord_Detail().setMonthlyRentAmount(currentNode.getFirstChild().getNodeValue());
					}
					//error reporting happens in isPositiveOrZeroMoney
					else //report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Landlord_Detail"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchResidence_Detail(Node currentNode)
	{
		boolean result = true;
		
		//Employer
		if(currentNode.getNodeName().toLowerCase().equals("Residence_Detail".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					
					//BorrowerResidencyBasisType
					if(currentNode.getNodeName().toLowerCase().equals("BorrowerResidencyBasisType".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("BorrowerResidencyBasisType"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getBorrowerResidencyBasisType().contains(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Borrower, get last Residence, get Residence_Detail, set BorrowerResidencyBasisType
							((Residence) ((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getLast("Residence")).getResidence_Detail().setBorrowerResidencyBasisType(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getBorrowerResidencyBasisType()));
					}	
					//BorrowerResidencyDurationMonthsCount
					else if(currentNode.getNodeName().toLowerCase().equals("BorrowerResidencyDurationMonthsCount".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("BorrowerResidencyDurationMonthsCount"));
						}
						//if a Positive Numeric String within range: 0-999
						else if(ComputeError.isWithinBounds(currentNode.getFirstChild().getNodeValue(),0,999)){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Borrower, get last Residence, get Residence_Detail, set BorrowerResidencyDurationMonthsCount
							((Residence) ((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getLast("Residence")).getResidence_Detail().setBorrowerResidencyDurationMonthsCount(Integer.parseInt(currentNode.getFirstChild().getNodeValue()));
						}
						else
						{
							//report error
							errorList.add(PrintError.outsideRange(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), 1, 11));
						}
					}
					//BorrowerResidencyType
					else if(currentNode.getNodeName().toLowerCase().equals("BorrowerResidencyType".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("BorrowerResidencyType"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getBorrowerResidencyType().contains(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Borrower, get last Residence, get Residence_Detail, set BorrowerResidencyType
							((Residence) ((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getLast("Residence")).getResidence_Detail().setBorrowerResidencyType(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getBorrowerResidencyType()));
					}	
					else //report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Residence_Detail"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchLicenses(Node currentNode)
	{
		boolean result = true;
		
		//Licenses
		if(currentNode.getNodeName().toLowerCase().equals("Licenses".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchLicense(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Licenses"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchLicense(Node currentNode)
	{
		boolean result = true;
		
		//License
		if(currentNode.getNodeName().toLowerCase().equals("License".toLowerCase())){
			//create Java object
			((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getLicenses().add(new License());
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchLicense_Detail(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "License"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchLicense_Detail(Node currentNode)
	{
		boolean result = true;
		
		//License_Detail
		if(currentNode.getNodeName().toLowerCase().equals("License_Detail".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//LicenseAuthorityLevelType
					if(currentNode.getNodeName().toLowerCase().equals("LicenseAuthorityLevelType".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("LicenseAuthorityLevelType"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getLicenseAuthorityLevelType().contains(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Borrower, get last License, get License_Detail //set LicenseAuthorityLevelType
							((License) ((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getLast("License")).getLicense_Detail().setLicenseAuthorityLevelType(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getLicenseAuthorityLevelType()));
					}		
					//LicenseIdentifier
					else if(currentNode.getNodeName().toLowerCase().equals("LicenseIdentifier".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("LicenseIdentifier"));
						}
						//if a Positive Numeric String of 1 to 50
						else if(isPositiveInteger(currentNode,1,50)){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Borrower, get last License, get License_Detail //set LicenseIdentifier
							((License) ((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getLast("License")).getLicense_Detail().setLicenseIdentifier(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isPositiveInteger
					}		
					else
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "License_Detail"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchParty_Role_Identifiers(Node currentNode)
	{
		boolean result = true;
		
		//Role
		if(currentNode.getNodeName().toLowerCase().equals("Party_Role_Identifiers".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchParty_Role_Identifier(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Party_Role_Identifiers"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchParty_Role_Identifier(Node currentNode)
	{
		boolean result = true;
		
		//Role
		if(currentNode.getNodeName().toLowerCase().equals("Party_Role_Identifier".toLowerCase())){
			//create Java object
			((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getParty_Role_Identifiers().add(new Party_Role_Identifier());
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//PartyRoleIdentifier
					if(currentNode.getNodeName().toLowerCase().equals("PartyRoleIdentifier".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("PartyRoleIdentifier"));
						}
						//if a Positive Numeric String of 6 to 6
						else if(isPositiveInteger(currentNode,6,6)){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Role, get Borrower, get last Party_Role_Identifier //set PartyRoleIdentifier
							((Party_Role_Identifier) ((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getBorrower().getLast("Party_Role_Identifier")).setPartyRoleIdentifier(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isPositiveInteger
					}		
					else
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Party_Role_Identifier"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchProperty_Owner(Node currentNode)
	{
		boolean result = true;
		
		//Role_Detail
		if(currentNode.getNodeName().toLowerCase().equals("Property_Owner".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//PropertyOwnerStatusType
					if(currentNode.getNodeName().toLowerCase().equals("PropertyOwnerStatusType".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("PropertyOwnerStatusType"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getPropertyOwnerStatusType().contains(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get the last Party, get last Role, get Trust //set PropertyOwnerStatusType
							((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getProperty_Owner().setPropertyOwnerStatusType(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getPropertyOwnerStatusType()));
					}
					//RelationshipVestingType
					else if(currentNode.getNodeName().toLowerCase().equals("RelationshipVestingType".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("RelationshipVestingType"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getRelationshipVestingType().contains(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get the last Party, get last Role, get Trust //set RelationshipVestingType
							((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getProperty_Owner().setRelationshipVestingType(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getRelationshipVestingType()));
					}
					//RelationshipVestingTypeOtherDescription							
					else if(currentNode.getNodeName().toLowerCase().equals("RelationshipVestingTypeOtherDescription".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("RelationshipVestingTypeOtherDescription"));
						}
						//if a Positive Numeric String of 1 to 60
						else if(isPositiveInteger(currentNode,1,60)){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get the last Party, get last Role, get Trust //set RelationshipVestingTypeOtherDescription
							((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getProperty_Owner().setRelationshipVestingTypeOtherDescription(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isPositiveInteger
					}
					else
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Property_Owner"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchRole_Detail(Node currentNode)
	{
		boolean result = true;
		
		//Role_Detail
		if(currentNode.getNodeName().toLowerCase().equals("Role_Detail".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//PartyRoleType
					if(currentNode.getNodeName().toLowerCase().equals("PartyRoleType".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("PartyRoleType"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getPartyRoleType().contains(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get the last Party, get last Role, get Trust //set PartyRoleType
							((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getRole_Detail().setPartyRoleType(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getPartyRoleType()));
					}
					else
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Role_Detail"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchTrust(Node currentNode)
	{
		boolean result = true;
		
		//Trust
		if(currentNode.getNodeName().toLowerCase().equals("Trust".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//TrustClassificationType
					if(currentNode.getNodeName().toLowerCase().equals("TrustClassificationType".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("TrustClassificationType"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getTrustClassificationType().contains(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get the last Party, get last Role, get Trust //set TrustClassificationType
							((Role) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Role")).getTrust().setTrustClassificationType(currentNode.getFirstChild().getNodeValue());
							}
						else
							//report error
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getTrustClassificationType()));
					}
					else
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Trust"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchTaxpayer_Identifiers(Node currentNode)
	{
		boolean result = true;
		
		//Roles
		if(currentNode.getNodeName().toLowerCase().equals("Taxpayer_Identifiers".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchTaxpayer_Identifier(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Taxpayer_Identifiers"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchTaxpayer_Identifier(Node currentNode)
	{
		boolean result = true;
		
		//Language
		if(currentNode.getNodeName().toLowerCase().equals("Taxpayer_Identifier".toLowerCase())){
			//create Java object
			((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getTaxpayer_Identifiers().add(new Taxpayer_Identifier());
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//TaxpayerIdentifierType
					if(currentNode.getNodeName().toLowerCase().equals("TaxpayerIdentifierType".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("TaxpayerIdentifierType"));
						}
						//if node information is an expected enumeration
						else if(Enumeration.getTaxpayerIdentifierType().contains(currentNode.getFirstChild().getNodeValue())){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Taxpayer_Identifier //set TaxpayerIdentifierType
							((Taxpayer_Identifier) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Taxpayer_Identifier")).setTaxpayerIdentifierType(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.UnexpectedEnumeration(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), Enumeration.getTaxpayerIdentifierType()));
					}		
					//TaxpayerIdentifierValue							
					else if(currentNode.getNodeName().toLowerCase().equals("TaxpayerIdentifierValue".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("TaxpayerIdentifierValue"));
						}
						//if a Positive Numeric String of 9 to 9
						else if(isPositiveInteger(currentNode,9,9)){
							//get Deal_Sets, then the last Deal_Set //get Deals, then the last Deal //get last Party, get last Taxpayer_Identifier //set TaxpayerIdentifierValue
							((Taxpayer_Identifier) ((Party) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Party")).getLast("Taxpayer_Identifier")).setTaxpayerIdentifierValue(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isPositiveInteger
					}
					else
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Taxpayer_Identifier"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchRelationships(Node currentNode)
	{
		boolean result = true;
		
		//Parties
		if(currentNode.getNodeName().toLowerCase().equals("Relationships".toLowerCase())){
			//create Java object
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchRelationship(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Relationships"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchRelationship(Node currentNode)
	{
		boolean result = true;
		
		//Party
		if(currentNode.getNodeName().toLowerCase().equals("Relationship".toLowerCase())){
			//create Java object
			((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getRelationships().add(new Relationship());
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//SequenceNumber
					if(currentNode.getNodeName().toLowerCase().equals("SequenceNumber".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("SequenceNumber"));
						}
						//if a Positive Numeric String of 1 to 2
						else if(isPositiveInteger(currentNode,1,2)){
							//get last Deal_Set, get last Deal, get last Relationship, set SequenceNumber
							((Relationship) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Relationship")).setSequenceNumber(currentNode.getFirstChild().getNodeValue());
						}
						//error reporting happens in isPositiveInteger
					}
					//xlink:arcrole
					else if(currentNode.getNodeName().toLowerCase().equals("xlink:arcrole".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("xlink:arcrole"));
						}
						//if node information is a string in length from 1 to 1000
						else if(ComputeError.isWithinStringLength(currentNode.getFirstChild().getNodeValue(),1,1000)){
							//get last Deal_Set, get last Deal, get last Relationship, set xlink:arcrole
							((Relationship) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Relationship")).setXlinkarcrole(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.stringLengthOutsideRange(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(),1,1000));
					}
					//xlink:from
					else if(currentNode.getNodeName().toLowerCase().equals("xlink:from".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("xlink:from"));
						}
						//if node information is a string in length from 1 to 1000
						else if(ComputeError.isWithinStringLength(currentNode.getFirstChild().getNodeValue(),1,1000)){
							//get last Deal_Set, get last Deal, get last Relationship, set xlink:from
							((Relationship) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Relationship")).setXlinkfrom(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.stringLengthOutsideRange(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(),1,1000));
					}
					//xlink:to
					else if(currentNode.getNodeName().toLowerCase().equals("xlink:to".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("xlink:to"));
						}
						//if node information is a string in length from 1 to 1000
						else if(ComputeError.isWithinStringLength(currentNode.getFirstChild().getNodeValue(),1,1000)){
							//get last Deal_Set, get last Deal, get last Relationship, set xlink:to
							((Relationship) ((Deal) ((Deal_Set) fileObject.getLast("Deal_Set")).getLast("Deal")).getLast("Relationship")).setXlinkfrom(currentNode.getFirstChild().getNodeValue());
						}
						else
							//report error
							errorList.add(PrintError.stringLengthOutsideRange(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(),1,1000));
					}
					else
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Relationship"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchDocument_Sets(Node currentNode)
	{
		boolean result = true;
		
		//document_Sets
		if(currentNode.getNodeName().toLowerCase().equals("document_Sets".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchDocument_Set(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Document_Sets"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchDocument_Set(Node currentNode)
	{
		boolean result = true;
		
		//document_Set
		if(currentNode.getNodeName().toLowerCase().equals("document_Set".toLowerCase())){
			//create Java object
			fileObject.getDocument_Sets().add(new Document_Set());
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchDocuments(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Document_Set"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchDocuments(Node currentNode)
	{
		boolean result = true;
		
		//documents
		if(currentNode.getNodeName().toLowerCase().equals("documents".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchDocument(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Documents"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchDocument(Node currentNode)
	{
		boolean result = true;
		
		//document
		if(currentNode.getNodeName().toLowerCase().equals("document".toLowerCase())){
			//create Java object
			((Document_Set) fileObject.getLast("Document_Set")).getDocuments().add(new information.dU34.Mes.DocSet.Document());
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchSignatories(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Document"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchSignatories(Node currentNode)
	{
		boolean result = true;
		
		//signatories
		if(currentNode.getNodeName().toLowerCase().equals("signatories".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchSignatory(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Signatories"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchSignatory(Node currentNode)
	{
		boolean result = true;
		
		//signatory
		if(currentNode.getNodeName().toLowerCase().equals("signatory".toLowerCase())){
			//create Java object
			((information.dU34.Mes.DocSet.Document) ((Document_Set) fileObject.getLast("Document_Set")).getLast("Document")).getSignatories().add(new Signatory());
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchExecution(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Signatory"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchExecution(Node currentNode)
	{
		boolean result = true;
		
		//execution
		if(currentNode.getNodeName().toLowerCase().equals("execution".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					if(!matchExecution_Detail(currentNode))
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "Execution"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
	public boolean matchExecution_Detail(Node currentNode)
	{
		boolean result = true;
		
		//execution_Detail
		if(currentNode.getNodeName().toLowerCase().equals("execution_Detail".toLowerCase())){
			Node parentNode = currentNode;
			
			//check child nodes
			for(int x = 0; x < parentNode.getChildNodes().getLength(); x++){
				currentNode = parentNode.getChildNodes().item(x);
				
				//if an attribute or element
				if(isAttributeOrElement(currentNode)){
					//start matching
					//executionDate
					if(currentNode.getNodeName().toLowerCase().equals("ExecutionDate".toLowerCase())){
						//check if value is empty
						if(currentNode.getFirstChild() == null){
							errorList.add(PrintError.missing("ExecutionDate"));
						}
						//if node information is a date time value
						else if(ComputeError.isDate(currentNode.getFirstChild().getNodeValue())){
							//get Document_Sets, then the last Document_Set //get Documents, then the last Document //get Signatories, then the last Signatory //set ExecutionDate
							((Signatory) ((information.dU34.Mes.DocSet.Document) ((Document_Set) fileObject.getLast("Document_Set")).getLast("Document")).getLast("Signatory")).getExecution().getExecution_Detail().setExecutionDate(Utility.setDate(currentNode.getFirstChild().getNodeValue()));
						}
						else
							//report error
							errorList.add(PrintError.notADate(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue()));
					}
					else
						//report error
						errorList.add(PrintError.unexpectedNode(currentNode.getNodeName(), "ExecutionDate"));
				}
			}
		}
		else
			result = false;
		
		return result;
	}
	
//General Methods
	
	private boolean isPositiveInteger(Node currentNode, int minLength, int maxLength, int minValue, int maxValue)
	{
		boolean result = true;
		
		if(!isPositiveInteger(currentNode, minLength, maxLength))
			result = false;
		
		//if value is not between minValue and maxValue
		if(!ComputeError.isWithinBounds(currentNode.getFirstChild().getNodeValue(), minValue, maxValue)){
			result = false;
			//report error
			errorList.add(PrintError.outsideRange(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), minValue, maxValue));	
		}
		
		return result;		
	}
	
	private boolean isPositiveInteger(Node currentNode, int minLength, int maxLength, int minValue, int maxValue, String forNode)
	{
		boolean result = true;
		
		if(!isPositiveInteger(currentNode, minLength, maxLength, forNode))
			result = false;
		
		//if value is not between minValue and maxValue
		if(!ComputeError.isWithinBounds(currentNode.getFirstChild().getNodeValue(), minValue, maxValue)){
			result = false;
			//report error
			errorList.add(PrintError.outsideRange(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), minValue, maxValue, forNode));	
		}
		
		return result;		
	}
	
	private boolean isPositiveInteger(Node currentNode, int minLength, int maxLength)
	{
		boolean result = true;
		
		//if not a positive number
		if(!ComputeError.isPositiveNumber(currentNode.getFirstChild().getNodeValue())){
			result = false;
			//report error
			errorList.add(PrintError.notAPositiveNumber(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue()));
		}
		
		//if node information contains a '.'
		if(!currentNode.getFirstChild().getNodeValue().contains(".")){
			if(result)
				result = true;
		}
		else{
			result = false;
			//report error
			errorList.add(PrintError.foundDecimalPoint(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue()));
		}
		
		//if not within expected number of characters characters
		if(!ComputeError.isWithinStringLength(currentNode.getFirstChild().getNodeValue(), minLength, maxLength)){
			result = false;
			//report error
			errorList.add(PrintError.stringLengthOutsideRange(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), minLength, maxLength));
		}
		
		return result;		
	}
	
	private boolean isPositiveInteger(Node currentNode, int minLength, int maxLength, String forNode)
	{
		boolean result = true;
		
		//if not a positive number
		if(!ComputeError.isPositiveNumber(currentNode.getFirstChild().getNodeValue())){
			result = false;
			//report error
			errorList.add(PrintError.notAPositiveNumber(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), forNode));
		}
		
		//if node information contains a '.'
		if(!currentNode.getFirstChild().getNodeValue().contains(".")){
			if(result)
				result = true;
		}
		else{
			result = false;
			//report error
			errorList.add(PrintError.foundDecimalPoint(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), forNode));
		}
		
		//if not within expected number of characters characters
		if(!ComputeError.isWithinStringLength(currentNode.getFirstChild().getNodeValue(), minLength, maxLength)){
			result = false;
			//report error
			errorList.add(PrintError.stringLengthOutsideRange(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), minLength, maxLength, forNode));
		}
		
		return result;		
	}
	
	private boolean isPositiveMoney(Node currentNode, int beforeDecimal, int afterDecimal)
	{
		boolean result = true;
		
		result = isPositiveMoney(currentNode, beforeDecimal, afterDecimal, "");		
		
		return result;		
	}
	
	private boolean isPositiveMoney(Node currentNode, int beforeDecimal, int afterDecimal, String forNode)
	{
		boolean result = true;
		
		//if node information is a positive amount of money
		if(!ComputeError.isPositiveMoney(currentNode.getFirstChild().getNodeValue(), beforeDecimal, afterDecimal)){
			result = false;
			
			//if not a positive number
			if(!ComputeError.isPositiveNumber(currentNode.getFirstChild().getNodeValue()))
				//report error
				errorList.add(PrintError.notAPositiveNumber(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue()));
			
			//check if the value is an amount of Money
			if(!forNode.equals(""))
				isMoney(currentNode, beforeDecimal, afterDecimal, forNode);
			else
				isMoney(currentNode, beforeDecimal, afterDecimal);
		}
				
		return result;		
	}
	
	private boolean isPositiveOrZeroMoney(Node currentNode, int beforeDecimal, int afterDecimal)
	{
		boolean result = true;
		
		//if node information is a positive amount of money
		if(!ComputeError.isPositiveOrZeroMoney(currentNode.getFirstChild().getNodeValue(), beforeDecimal, afterDecimal)){
			result = false;
			
			//if not a positive number
			if(!ComputeError.isPositiveOrZeroNumber(currentNode.getFirstChild().getNodeValue()))
				//report error
				errorList.add(PrintError.notAPositiveOrZeroNumber(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue()));
			
			//check if the value is an amount of Money
			isMoney(currentNode, beforeDecimal, afterDecimal);
		}
		
		
		return result;		
	}
	
	private boolean isMoney(Node currentNode, int beforeDecimal, int afterDecimal)
	{
		boolean result = false;
		
		result = isMoney(currentNode, beforeDecimal, afterDecimal, "");
		
		return result;		
	}
	
	private boolean isMoney(Node currentNode, int beforeDecimal, int afterDecimal, String forNode)
	{
		boolean result = false;
		
		//if node information is an amount of money
		if(ComputeError.isMoney(currentNode.getFirstChild().getNodeValue(), beforeDecimal, afterDecimal))
			result = true;
		else{
			result = false;
			
			//if node information contains a decimal place
			if(currentNode.getFirstChild().getNodeValue().contains(".")){
				//if wrong number of characters before decimal place
				if(!ComputeError.checkNumberPlaces(currentNode.getFirstChild().getNodeValue(), beforeDecimal))
					//report error
					errorList.add(PrintError.moreThanXDigitsBeforeDecimal(currentNode.getNodeName(), beforeDecimal, currentNode.getFirstChild().getNodeValue()));
				
				//if wrong number of characters after decimal place
				if(!ComputeError.checkDecimalPlacesFixed(currentNode.getFirstChild().getNodeValue(), afterDecimal))
					//report error
					errorList.add(PrintError.missingXPreciseDecimalPoints(currentNode.getNodeName(), afterDecimal, currentNode.getFirstChild().getNodeValue()));
			}
			else
				//report error
				if(!forNode.equals(""))
					errorList.add(PrintError.noDecimalPoint(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(), forNode));
				else
					errorList.add(PrintError.noDecimalPoint(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue()));
		}
		
		
		return result;		
	}
	
	private boolean isPositiveOrZeroPercentage(Node currentNode, int beforeDecimal, int afterDecimal)
	{
		boolean result = false;
		
		//if node information is an amount of money
		if(ComputeError.isPositiveOrZeroPercentage(currentNode.getFirstChild().getNodeValue(), beforeDecimal, afterDecimal))
			result = true;
		else{
			result = false;
			
			//if node information contains a decimal place
			if(currentNode.getFirstChild().getNodeValue().contains(".")){
				//if wrong number of characters before decimal place
				if(!ComputeError.checkNumberPlaces(currentNode.getFirstChild().getNodeValue(), beforeDecimal))
					//report error
					errorList.add(PrintError.moreThanXDigitsBeforeDecimal(currentNode.getNodeName(), beforeDecimal, currentNode.getFirstChild().getNodeValue()));
				
				//if wrong number of characters after decimal place
				if(!ComputeError.checkDecimalPlacesFixed(currentNode.getFirstChild().getNodeValue(), afterDecimal))
					//report error
					errorList.add(PrintError.missingXPreciseDecimalPoints(currentNode.getNodeName(), afterDecimal, currentNode.getFirstChild().getNodeValue()));
			}
			else
				//report error
				errorList.add(PrintError.noDecimalPoint(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue()));
		}
		
		
		return result;		
	}
	
	private boolean isPositiveOrZeroInteger(Node currentNode, int minLength, int maxLength){
		boolean result = false;
		
		//if node information is a positive or zero number
		if(ComputeError.isPositiveOrZeroNumber(currentNode.getFirstChild().getNodeValue())){
			result = true;
		}
		else{
			result = false;
			//report error
			errorList.add(PrintError.notAPositiveOrZeroNumber(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue()));
		}
		
		//if node information contains a '.'
		if(!currentNode.getFirstChild().getNodeValue().contains(".")){
			if(result)
				result = false;
		}
		else{
			result = false;
			//report error
			errorList.add(PrintError.foundDecimalPoint(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue()));
		}
		
		//if node information is string of length minLength to maxLength
		if(ComputeError.isWithinStringLength(currentNode.getFirstChild().getNodeValue(),minLength,maxLength)){
			if(result)
				result = true;
		}
		else{
			result = false;
			//report error
			errorList.add(PrintError.stringLengthOutsideRange(currentNode.getNodeName(), currentNode.getFirstChild().getNodeValue(),minLength,maxLength));
		}
				
				return result;		
	}
	
	public List<String> getErrorList()
	{
		return errorList;		
	}
	
	private boolean isAttributeOrElement(Node currentNode){
		boolean result = false;
		
		if(currentNode.getNodeType() == Node.ELEMENT_NODE)
			result = true;
		else if(currentNode.getNodeType() == Node.ATTRIBUTE_NODE)
			result = true;
		
		return result;
	}
}
