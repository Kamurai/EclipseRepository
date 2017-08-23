package usanIDE.Managers;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import usanIDE.RegexCreature;
import usanIDE.Seeker3;

public class ManagerHelper 
{
	ArrayList<String> MasterCellTypeList = new ArrayList<String>();
	ArrayList<ArrayList<String>> MasterCellVariableList = new ArrayList<ArrayList<String>>();
	ArrayList<ArrayList<String>> MasterCellFunctionList = new ArrayList<ArrayList<String>>();
	ArrayList<ArrayList<ArrayList<String>>> MasterExternalFunctionList = new ArrayList<ArrayList<ArrayList<String>>>();
	
	RegexCreature Staryu = new RegexCreature();
	Seeker3 Pikachu = new Seeker3();
	
	public ManagerHelper()
	{
		MasterCellTypeList = CreateMasterCellTypeList();
		
		MasterCellVariableList = CreateMasterCellVariableList();
		
		MasterCellFunctionList = CreateMasterCellFunctionList();
		
		MasterExternalFunctionList = CreateMasterExternalFunctionList();
	}
	
	private ArrayList<String> CreateMasterCellTypeList()
	{
		ArrayList<String> output = new ArrayList<String>();
		
		output.add("[PROMPT");
		output.add("[WAIT_CONCURRENT_PROMPT");
		output.add("[IF");
		output.add("[MENU");
		output.add("[CHOICE");
		output.add("[TIMEOFDAYCHECK");
		output.add("[THROTTLECHECK");
		output.add("[OUTDIAL");
		output.add("[PORTCONTROL");
		output.add("[CALLTYPECHECK");
		output.add("[TRANSFERTYPECHECK");
		output.add("[CALLANDTRANSFERTYPECHECK");
		output.add("[PLAYDIGITS");
		output.add("[ASSIGN");
		output.add("[CDR");
		output.add("[CONNECTED");
		output.add("[GET_ARU");
		output.add("[HOST_TRANSACTION");
		output.add("[HOST_TRANSACTION_REPLY");
		output.add("[HOST_MESSAGE");
		output.add("[GET_OPERATOR");
		output.add("[GET_OPERATOR_REQUEST");
		output.add("[SEND_OPERATOR_REPLY");
		output.add("[ABANDON_OPERATOR");
		output.add("[THRESHOLD");
		output.add("[CREATE_DYNAPROMPT");
		output.add("[EVENT_CDR");
		output.add("[RECORD");
		
		return output;
	}
	
	private ArrayList<ArrayList<String>> CreateMasterCellVariableList()
	{
		ArrayList<ArrayList<String>> output = new ArrayList<ArrayList<String>>();
		
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_SpeechRecSelected");						//Set if caller selects SIVR at a menu
		output.get(output.size()-1).add("boolean");									//variable type
		
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_lookupAniPrompt");						//transferType actual used when transferType for a phone number is ask.  Its value is usually set by a menu choice which asks the user to pick the transfer type.
		output.get(output.size()-1).add("prompt");
		
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_lookupAniPhoneNumber");					//phone# looked up using the ani outdial db in a outdial cell.  A copy is made here so the number can be used on other cells if needed.
		output.get(output.size()-1).add("phone");
		
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_lookupDnisPrompt");						//prompt looked up using the dnis prompt db in a prompt cell.  A copy is made here so the prompt can be used on other cells if needed.
		output.get(output.size()-1).add("prompt");
		
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_lookupDnisPhoneNumber");					//phone# looked up using the dnis outdial db in a outdial cell.  A copy is made here so the number can be used on other cells if needed.
		output.get(output.size()-1).add("phone");
		
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extensionPhoneNumber");					//phone# looked up from the extensionDb in a menu choice cell.  A copy is made here so the number can be used on other cells if needed. 
		output.get(output.size()-1).add("phone");
		
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_outdialCallType");						//actual callType used in the last outdial. a copy is made here so the call type can be used in other cells
		output.get(output.size()-1).add("name");
		
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_outdialTransferType");					//actual transferType used in the last outdial. a copy is made here so the transfer type can be used in other cells
		output.get(output.size()-1).add("name");
		
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_outdialPhoneNumber");					//actual phone# (may have ,callType,transferType) used in the last outdial.  
		output.get(output.size()-1).add("phone");
		
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_outdialPort");							//actual port (OUT or OUT2) used in the last outdial
		output.get(output.size()-1).add("port");
		
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_outdialNextIdlePort");					//next idle port available for the next outdial either OUT or OUT2.
		output.get(output.size()-1).add("port");
		
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_enteredDigits");							//digits entered by used on the last menu
		output.get(output.size()-1).add("name");		
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_spokenChoice");							//the SIVR word recognized on the last menu
		output.get(output.size()-1).add("name");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_inboundAni");							//ani of the inbound call
		output.get(output.size()-1).add("phone");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_inboundDnis");							//dnis of the inbound call
		output.get(output.size()-1).add("name");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_inboundDestination");					//destination phone# on inbound call used only on non-800 type applications
		output.get(output.size()-1).add("phone");
		
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_inPortStatus");							//status of inbound port: onhook, offhook
		output.get(output.size()-1).add("name");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_outPortStatus");							//status of out2 port: onhook, offhook
		output.get(output.size()-1).add("name");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_out2PortStatus");						//status of out2 port: onhook, offhook
		output.get(output.size()-1).add("name");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_menuTries");								//the number of tries done in the last menu
		output.get(output.size()-1).add("number");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_useMenuTries");							//if set when executing a menu cell, the menu continues from where it left off based on the c_menuTries and c_enteredDigits variables. This variable is cleared after a menu looks at it.
		output.get(output.size()-1).add("boolean");
		
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_inPortHangupPeg");						//Peg Id/Name to peg if in port hangs up
		output.get(output.size()-1).add("pegList");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_outPortHangupPeg");
		output.get(output.size()-1).add("pegList");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_out2PortHangupPeg");
		output.get(output.size()-1).add("pegList");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_language");								//current language used to select all prompts to play.
		output.get(output.size()-1).add("enum");									//values: english, spanish
		
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_languageVersion");						//which language version is in effect (0-49)
		output.get(output.size()-1).add("number");
		
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_ivanResponse");
		output.get(output.size()-1).add("name");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_ivanTransactionType");
		output.get(output.size()-1).add("name");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_ivanAni");
		output.get(output.size()-1).add("name");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_ivanDestination");
		output.get(output.size()-1).add("name");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extFunctionReturn");						//see external function doc. for usage
		output.get(output.size()-1).add("enum");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_trace");									//turn on to enable tracing
		output.get(output.size()-1).add("boolean");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_traceHostFunctions");					//;turn on to enable host function tracing; c_trace must also be on
		output.get(output.size()-1).add("boolean");
		
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_traceExternalFunctions");				//turn on to enable external function; tracing - c_trace must also be on
		output.get(output.size()-1).add("boolean");
		
		
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_billToNumber");
		output.get(output.size()-1).add("name");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_destination");
		output.get(output.size()-1).add("name");		
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_productName");
		output.get(output.size()-1).add("name");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_applicationType");
		output.get(output.size()-1).add("name");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_bpTimeout");
		output.get(output.size()-1).add("number");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_opsServerName");
		output.get(output.size()-1).add("name");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_operatorType");
		output.get(output.size()-1).add("name");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_operatorPhoneNumber");
		output.get(output.size()-1).add("boolean");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_operValidateResult");
		output.get(output.size()-1).add("enum");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_operExpDate");
		output.get(output.size()-1).add("name");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_operZipCode");
		output.get(output.size()-1).add("name");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_operatorRequest");
		output.get(output.size()-1).add("enum");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_endTheCallCell");				//if specified, control is transferred to this cell on an end of call
		output.get(output.size()-1).add("cell");
		
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_creditCardType");				//used by Mod10 external function
		output.get(output.size()-1).add("enum");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_passMod10");						//used by Mod10 external function
		output.get(output.size()-1).add("boolean");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_expirationDate");				//used by checkExpirationDate external function
		output.get(output.size()-1).add("name");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_totalLUs");						//used by checkQueueDepthQ host function
		output.get(output.size()-1).add("number");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_LUsBusy");						//used by checkQueueDepthQ host function
		output.get(output.size()-1).add("number");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_LUsQueued");						//used by checkQueueDepthQ host function
		output.get(output.size()-1).add("number");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_scrapeTranType");				//used by checkQueueDepthQ host function
		output.get(output.size()-1).add("number");
		
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_cin");
		output.get(output.size()-1).add("name");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_tpic");
		output.get(output.size()-1).add("name");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_hostResult");
		output.get(output.size()-1).add("enum");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_citiBankResult");
		output.get(output.size()-1).add("number");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_tpicStatus");
		output.get(output.size()-1).add("name");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_atmPreauthPennies");
		output.get(output.size()-1).add("number");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_ccPreauthPennies");
		output.get(output.size()-1).add("number");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_createRdrs");					//must be on to create CDRs
		output.get(output.size()-1).add("boolean");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_cdrCdr");
		output.get(output.size()-1).add("enum");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_cdrTime");
		output.get(output.size()-1).add("enum");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_cdrLang");
		output.get(output.size()-1).add("enum");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_cdrTrunkDest");
		output.get(output.size()-1).add("enum");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_cdrTrunkBill");
		output.get(output.size()-1).add("enum");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_cdrTrunkBillOper");
		output.get(output.size()-1).add("enum");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_cdrTear");
		output.get(output.size()-1).add("enum");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_cdrBilling");
		output.get(output.size()-1).add("enum");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_cdrBillingVer");
		output.get(output.size()-1).add("enum");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_cdrBillingVerPTP");
		output.get(output.size()-1).add("enum");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_cdrTraffic");
		output.get(output.size()-1).add("enum");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_cdrCall");
		output.get(output.size()-1).add("enum");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_cdrFeat");
		output.get(output.size()-1).add("enum");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_cdrZone");
		output.get(output.size()-1).add("enum");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_cdrBillingPreAuth");
		output.get(output.size()-1).add("enum");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_outboundTrunk");
		output.get(output.size()-1).add("enum");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_out1Port");
		output.get(output.size()-1).add("enum");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_out2Port");
		output.get(output.size()-1).add("enum");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_functionResult");
		output.get(output.size()-1).add("boolean");
		
		//start: see setTimer external function
		
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_timerEnabled");
		output.get(output.size()-1).add("boolean");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_timerId");
		output.get(output.size()-1).add("enum");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_timerCell1");
		output.get(output.size()-1).add("cell");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_timerCell2");
		output.get(output.size()-1).add("cell");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_timerCell3");
		output.get(output.size()-1).add("cell");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_timerCell4");
		output.get(output.size()-1).add("cell");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_timerCell5");
		output.get(output.size()-1).add("cell");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_timerValue1");
		output.get(output.size()-1).add("bigNumber");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_timerValue2");
		output.get(output.size()-1).add("bigNumber");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_timerValue3");
		output.get(output.size()-1).add("bigNumber");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_timerValue4");
		output.get(output.size()-1).add("bigNumber");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_timerValue5");
		output.get(output.size()-1).add("bigNumber");
		
		//end: see setTimer external function
		
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_menuStopCharStripped");
		output.get(output.size()-1).add("boolean");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_serviceId");
		output.get(output.size()-1).add("name");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_citiCardType");
		output.get(output.size()-1).add("enum");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_traceCiti");
		output.get(output.size()-1).add("boolean");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_hangupReportId");
		output.get(output.size()-1).add("number");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_transferReportId");
		output.get(output.size()-1).add("number");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_traceAssignments");
		output.get(output.size()-1).add("boolean");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_traceDynaPrompts");
		output.get(output.size()-1).add("boolean");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_traceThreshold");
		output.get(output.size()-1).add("boolean");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_NoThresholdMatched");
		output.get(output.size()-1).add("boolean");
		
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_CallTimeLimit");				//amount of time (in seconds) allowed for call
		output.get(output.size()-1).add("number");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_CallTimeLimitCell");			//cell to go to when time is up
		output.get(output.size()-1).add("cell");

		//Start:  "Extdb" variables
		
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extdbKey");
		output.get(output.size()-1).add("string");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extdbInstance");
		output.get(output.size()-1).add("number");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extdbOperator");
		output.get(output.size()-1).add("number");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extdbName");
		output.get(output.size()-1).add("boolean");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extdbKeyMin");
		output.get(output.size()-1).add("string");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extdbKeyMax");
		output.get(output.size()-1).add("string");
		output.add(new ArrayList());
		
		output.get(output.size()-1).add("c_extdbFieldNumeric1");
		output.get(output.size()-1).add("number");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extdbFieldNumeric2");
		output.get(output.size()-1).add("number");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extdbFieldNumeric3");
		output.get(output.size()-1).add("number");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extdbFieldNumeric4");
		output.get(output.size()-1).add("number");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extdbFieldNumeric5");
		output.get(output.size()-1).add("number");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extdbFieldNumeric6");
		output.get(output.size()-1).add("number");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extdbFieldNumeric7");
		output.get(output.size()-1).add("number");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extdbFieldNumeric8");
		output.get(output.size()-1).add("number");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extdbFieldNumeric9");
		output.get(output.size()-1).add("number");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extdbFieldNumeric10");
		output.get(output.size()-1).add("number");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extdbFieldNumeric11");
		output.get(output.size()-1).add("number");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extdbFieldNumeric12");
		output.get(output.size()-1).add("number");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extdbFieldNumeric13");
		output.get(output.size()-1).add("number");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extdbFieldNumeric14");
		output.get(output.size()-1).add("number");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extdbFieldNumeric15");
		output.get(output.size()-1).add("number");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extdbFieldNumeric16");
		output.get(output.size()-1).add("number");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extdbFieldNumeric17");
		output.get(output.size()-1).add("number");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extdbFieldNumeric18");
		output.get(output.size()-1).add("number");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extdbFieldNumeric19");
		output.get(output.size()-1).add("number");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extdbFieldNumeric20");
		output.get(output.size()-1).add("number");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extdbFieldNumeric21");
		output.get(output.size()-1).add("number");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extdbFieldNumeric22");
		output.get(output.size()-1).add("number");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extdbFieldNumeric23");
		output.get(output.size()-1).add("number");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extdbFieldNumeric24");
		output.get(output.size()-1).add("number");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extdbFieldNumeric25");
		output.get(output.size()-1).add("number");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extdbFieldNumeric26");
		output.get(output.size()-1).add("number");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extdbFieldNumeric27");
		output.get(output.size()-1).add("number");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extdbFieldNumeric28");
		output.get(output.size()-1).add("number");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extdbFieldNumeric29");
		output.get(output.size()-1).add("number");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extdbFieldNumeric30");
		output.get(output.size()-1).add("number");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extdbFieldNumeric31");
		output.get(output.size()-1).add("number");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extdbFieldNumeric32");
		output.get(output.size()-1).add("number");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extdbFieldNumeric33");
		output.get(output.size()-1).add("number");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extdbFieldNumeric34");
		output.get(output.size()-1).add("number");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extdbFieldNumeric35");
		output.get(output.size()-1).add("number");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extdbFieldNumeric36");
		output.get(output.size()-1).add("number");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extdbFieldNumeric37");
		output.get(output.size()-1).add("number");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extdbFieldNumeric38");
		output.get(output.size()-1).add("number");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extdbFieldNumeric39");
		output.get(output.size()-1).add("number");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extdbFieldNumeric40");
		output.get(output.size()-1).add("number");
		
		output.get(output.size()-1).add("c_extdbFieldString1");
		output.get(output.size()-1).add("string");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extdbFieldString2");
		output.get(output.size()-1).add("string");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extdbFieldString3");
		output.get(output.size()-1).add("string");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extdbFieldString4");
		output.get(output.size()-1).add("string");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extdbFieldString5");
		output.get(output.size()-1).add("string");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extdbFieldString6");
		output.get(output.size()-1).add("string");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extdbFieldString7");
		output.get(output.size()-1).add("string");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extdbFieldString8");
		output.get(output.size()-1).add("string");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extdbFieldString9");
		output.get(output.size()-1).add("string");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extdbFieldString10");
		output.get(output.size()-1).add("string");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extdbFieldString11");
		output.get(output.size()-1).add("string");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extdbFieldString12");
		output.get(output.size()-1).add("string");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extdbFieldString13");
		output.get(output.size()-1).add("string");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extdbFieldString14");
		output.get(output.size()-1).add("string");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extdbFieldString15");
		output.get(output.size()-1).add("string");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extdbFieldString16");
		output.get(output.size()-1).add("string");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extdbFieldString17");
		output.get(output.size()-1).add("string");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extdbFieldString18");
		output.get(output.size()-1).add("string");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extdbFieldString19");
		output.get(output.size()-1).add("string");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extdbFieldString20");
		output.get(output.size()-1).add("string");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extdbFieldString21");
		output.get(output.size()-1).add("string");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extdbFieldString22");
		output.get(output.size()-1).add("string");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extdbFieldString23");
		output.get(output.size()-1).add("string");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extdbFieldString24");
		output.get(output.size()-1).add("string");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extdbFieldString25");
		output.get(output.size()-1).add("string");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extdbFieldString26");
		output.get(output.size()-1).add("string");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extdbFieldString27");
		output.get(output.size()-1).add("string");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extdbFieldString28");
		output.get(output.size()-1).add("string");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extdbFieldString29");
		output.get(output.size()-1).add("string");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extdbFieldString30");
		output.get(output.size()-1).add("string");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extdbFieldString31");
		output.get(output.size()-1).add("string");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extdbFieldString32");
		output.get(output.size()-1).add("string");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extdbFieldString33");
		output.get(output.size()-1).add("string");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extdbFieldString34");
		output.get(output.size()-1).add("string");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extdbFieldString35");
		output.get(output.size()-1).add("string");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extdbFieldString36");
		output.get(output.size()-1).add("string");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extdbFieldString37");
		output.get(output.size()-1).add("string");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extdbFieldString38");
		output.get(output.size()-1).add("string");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extdbFieldString39");
		output.get(output.size()-1).add("string");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_extdbFieldString40");
		output.get(output.size()-1).add("string");
		
		//End:  "Extdb" variables
		
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_systemTime"); 				//used by intDateTime external function
		output.get(output.size()-1).add("bigNumber");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_month");						//used by decodeDateTime external function
		output.get(output.size()-1).add("name");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_day");						//used by decodeDateTime external function
		output.get(output.size()-1).add("name");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_year");						//used by decodeDateTime external function
		output.get(output.size()-1).add("name");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_hour");						//used by decodeDateTime external function
		output.get(output.size()-1).add("name");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_minute");					//used by decodeDateTime external function
		output.get(output.size()-1).add("name");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_second");					//used by decodeDateTime external function
		output.get(output.size()-1).add("name");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_cdrHeaderString1");			//whatever the script writer places in this variable will get logged to the comma delimited cdr file
		output.get(output.size()-1).add("name");
		
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_cdrHeaderNumber1");			//whatever the script writer places in this variable will get logged to the comma delimited cdr file
		output.get(output.size()-1).add("number");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_IfStringCompareLength");
		output.get(output.size()-1).add("number");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_AruId");
		output.get(output.size()-1).add("name");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_subAppl");
		output.get(output.size()-1).add("name");
		output.add(new ArrayList());
		output.get(output.size()-1).add("c_hangupRptReason");
		output.get(output.size()-1).add("enum");
		
		
		return output;
	}
	
	private ArrayList<ArrayList<String>> CreateMasterCellFunctionList()
	{
		ArrayList<ArrayList<String>> output = new ArrayList<ArrayList<String>>();

		output.add(new ArrayList());
		output.get(output.size()-1).add("f_strcmp");				//Compare 2 strings.
		output.get(output.size()-1).add("number");					//return type: Returns (number) 0 if (string 1) < (string 2); 1 if (string 1) = (string 2); 2 if (string 1) > (string 2)
		output.get(output.size()-1).add("string");					//parameter 1
		output.get(output.size()-1).add("string");					//parameter 2
		
		output.add(new ArrayList());
		output.get(output.size()-1).add("f_strncmp");				//Compare the first (number 1) digits of 2 strings.
		output.get(output.size()-1).add("number");					//return type: Returns (number) 0 if (string 1) < (string 2); 1 if (string 1) = (string 2); 2 if (string 1) > (string 2)
		output.get(output.size()-1).add("string");					//parameter 1
		output.get(output.size()-1).add("string");					//parameter 2
		output.get(output.size()-1).add("number");					//parameter 3
				
		output.add(new ArrayList());
		output.get(output.size()-1).add("f_stricmp");				//Case-insensitive compare 2 strings.
		output.get(output.size()-1).add("number");					//return type: Returns (number) 0 if (string 1) < (string 2); 1 if (string 1) = (string 2); 2 if (string 1) > (string 2)
		output.get(output.size()-1).add("string");					//parameter 1
		output.get(output.size()-1).add("string");					//parameter 2
		
		output.add(new ArrayList());
		output.get(output.size()-1).add("f_strlen");				//Counts the number of characters in the string.
		output.get(output.size()-1).add("number");					//return type: Returns the length of a string.
		output.get(output.size()-1).add("string");					//parameter 1
		
		output.add(new ArrayList());
		output.get(output.size()-1).add("f_strcpy");				//Assigns (string 2) as (string 1).  
		output.get(output.size()-1).add("number");					//return type: Returns the number of bytes copied.
		output.get(output.size()-1).add("string");					//parameter 1
		output.get(output.size()-1).add("string");					//parameter 2
		
		output.add(new ArrayList());
		output.get(output.size()-1).add("f_strncpy");				//Assign (string 2) as the first (number 1) characters of (string 1).  
		output.get(output.size()-1).add("number");					//return type: Returns the number of bytes copied.
		output.get(output.size()-1).add("string");					//parameter 1
		output.get(output.size()-1).add("string");					//parameter 2
		output.get(output.size()-1).add("number");					//parameter 3
		
		output.add(new ArrayList());
		output.get(output.size()-1).add("f_strcat");				//Append (string 2) to (string 1) if (string 2).length + (string 1).length <= LEN_CELL_STRING). 
		output.get(output.size()-1).add("number");					//return type: Returns the new length of (string 1)
		output.get(output.size()-1).add("string");					//parameter 1
		output.get(output.size()-1).add("string");					//parameter 2
				
		output.add(new ArrayList());
		output.get(output.size()-1).add("f_strncat");				//Append the first (number 1) characters of (string 2) to (string 1) (if (string 1).length + (number 1) <= LEN_CELL_STRING). 
		output.get(output.size()-1).add("number");					//return type: Returns the new length of (string 1)
		output.get(output.size()-1).add("string");					//parameter 1
		output.get(output.size()-1).add("string");					//parameter 2
		output.get(output.size()-1).add("number");					//parameter 3
		
		output.add(new ArrayList());
		output.get(output.size()-1).add("f_strchr");				//Scans (string 1) for the first index of (character 1). 
		output.get(output.size()-1).add("number");					//return type: Returns the first index of (character 1) or 999 if char not found.
		output.get(output.size()-1).add("string");					//parameter 1
		output.get(output.size()-1).add("character");				//parameter 2
		
		output.add(new ArrayList());
		output.get(output.size()-1).add("f_strrchr");				//Scans (string 1) for the last index of (character 1). 
		output.get(output.size()-1).add("number");					//return type: Returns the last index of (character 1) or 999 if char not found.
		output.get(output.size()-1).add("string");					//parameter 1
		output.get(output.size()-1).add("character");				//parameter 2
		
		output.add(new ArrayList());
		output.get(output.size()-1).add("f_substr");				//Creates a substring of (string 1) from index (number 1) for (number 2) characters until the end of (string 1). 
		output.get(output.size()-1).add("string");					//return type: Returns the created substring.
		output.get(output.size()-1).add("string");					//parameter 1
		output.get(output.size()-1).add("number");					//parameter 2
		output.get(output.size()-1).add("number");					//parameter 3
		
		output.add(new ArrayList());
		output.get(output.size()-1).add("f_ltrim");					//Removes all the leading spaces from (string 1) 
		output.get(output.size()-1).add("string");					//return type: Returns the modified string.
		output.get(output.size()-1).add("string");					//parameter 1
		
		output.add(new ArrayList());
		output.get(output.size()-1).add("f_rtrim");					//Removes all the trailing spaces from (string 1) 
		output.get(output.size()-1).add("string");					//return type: Returns the modified string.
		output.get(output.size()-1).add("string");					//parameter 1
		
		output.add(new ArrayList());
		output.get(output.size()-1).add("f_strsearch");				//Scans (string 1) for the starting index of (string 2) in (string 1). 
		output.get(output.size()-1).add("string");					//return type: Returns 1 if found or 0 is not.  Sets (number 1) to the starting index of (string 2) inside of (string 1)
		output.get(output.size()-1).add("string");					//parameter 1
		output.get(output.size()-1).add("string");					//parameter 2
		output.get(output.size()-1).add("number");					//parameter 3
		
		output.add(new ArrayList());
		output.get(output.size()-1).add("f_lpad");					//Adds (character 1) to the beginning of (string 1) until the size of (string 1) is equal to (number 1)
		output.get(output.size()-1).add("string");					//return type: Returns new string of (string 1) padded on left with char to width (number 1).
		output.get(output.size()-1).add("string");					//parameter 1
		output.get(output.size()-1).add("character");				//parameter 2
		output.get(output.size()-1).add("number");					//parameter 3
		
		output.add(new ArrayList());
		output.get(output.size()-1).add("f_rpad");					//Adds (character 1) to the beginning of (string 1) until the size of (string 1) is equal to (number 1)
		output.get(output.size()-1).add("string");					//return type: Returns new string of (string 1) padded on right with char to width (number 1).  
		output.get(output.size()-1).add("string");					//parameter 1
		output.get(output.size()-1).add("character");				//parameter 2
		output.get(output.size()-1).add("number");					//parameter 3
		
		output.add(new ArrayList());								//pivot:  I'm not sure what "bitnum" means
		output.get(output.size()-1).add("f_setBit");				//Returns num with bit bitnum set to val. 
		output.get(output.size()-1).add("number");					//return type
		output.get(output.size()-1).add("number");					//parameter 1
		output.get(output.size()-1).add("number");					//parameter 2
		output.get(output.size()-1).add("number");					//parameter 3
		
		output.add(new ArrayList());
		output.get(output.size()-1).add("f_increment");				//Adds 1 to (number 1)
		output.get(output.size()-1).add("number");					//return type: Returns (number 1) + 1.
		output.get(output.size()-1).add("number");					//parameter 1
		
		output.add(new ArrayList());
		output.get(output.size()-1).add("f_decrement");				//Subtract 1 from (number 1)
		output.get(output.size()-1).add("number");					//return type: Returns (number 1) - 1 (or 0 if the difference is < 0).
		output.get(output.size()-1).add("number");					//parameter 1
		
		output.add(new ArrayList());
		output.get(output.size()-1).add("f_add");					//Adds two numbers
		output.get(output.size()-1).add("number");					//return type: Returns (number 1) + (number 2)
		output.get(output.size()-1).add("number");					//parameter 1
		
		output.add(new ArrayList());
		output.get(output.size()-1).add("f_subtract");				//Subtracts (number 2) from (number 1)
		output.get(output.size()-1).add("number");					//return type: Returns (number 1) - (number 2) (or 0 if the difference is < 0).
		output.get(output.size()-1).add("number");					//parameter 1
		
		output.add(new ArrayList());
		output.get(output.size()-1).add("f_atoi");					//Converts a string to a number.
		output.get(output.size()-1).add("number");					//return type: Returns the integer equivalent of (string 1).
		output.get(output.size()-1).add("string");					//parameter 1
		
		output.add(new ArrayList());
		output.get(output.size()-1).add("f_itoa");					//Converts a number to a string. 
		output.get(output.size()-1).add("string");					//return type: Returns the string equivalent of (number 1).
		output.get(output.size()-1).add("number");					//parameter 1
		
		output.add(new ArrayList());
		output.get(output.size()-1).add("f_multiply");				//Multiplies two numbers
		output.get(output.size()-1).add("number");					//return type: Returns (number 1) * (number 2)
		output.get(output.size()-1).add("number");					//parameter 1
		
		output.add(new ArrayList());
		output.get(output.size()-1).add("f_divide");				//Divides (number 1) by (number 2)
		output.get(output.size()-1).add("number");					//return type: Returns (number 1)/(number 2) rounded down.
		output.get(output.size()-1).add("number");					//parameter 1
		
		output.add(new ArrayList());
		output.get(output.size()-1).add("f_power");					//Multiplies (number 1) by itself (number 2) times
		output.get(output.size()-1).add("number");					//return type: Returns (number 1) ^ (number 2). 
		output.get(output.size()-1).add("number");					//parameter 1
		
		output.add(new ArrayList());
		output.get(output.size()-1).add("f_modulo");				//Finds the remainder after (number 1) is divided by (number 2)
		output.get(output.size()-1).add("number");					//return type: Returns the remainder of (number 1) / (number 2)
		output.get(output.size()-1).add("number");					//parameter 1
		
		output.add(new ArrayList());
		output.get(output.size()-1).add("f_compare");				//Compares two numbers
		output.get(output.size()-1).add("number");					//return type: Returns 0 if num1 < num2, 1 if num1 = num2, 2 if num1 > num2. 
		output.get(output.size()-1).add("number");					//parameter 1
		output.get(output.size()-1).add("number");					//parameter 2
		
		output.add(new ArrayList());
		output.get(output.size()-1).add("f_between");				//Determines if (number 1) is between (number 2) and (number 3). 
		output.get(output.size()-1).add("number");					//return type: Returns 1 if (number 1) is between (number 2) and (number 3) (inclusive), 0 otherwise.
		output.get(output.size()-1).add("number");					//parameter 1
		output.get(output.size()-1).add("number");					//parameter 2
		output.get(output.size()-1).add("number");					//parameter 3
		
		output.add(new ArrayList());
		output.get(output.size()-1).add("f_rand");					//Gets a random number between (number 1) and (number 2) (inclusive).
		output.get(output.size()-1).add("number");					//return type: Returns a random number between (number 1) and (number 2) (inclusive).
		output.get(output.size()-1).add("number");					//parameter 1
		output.get(output.size()-1).add("number");					//parameter 2
		
		output.add(new ArrayList());
		output.get(output.size()-1).add("f_getExtdbField");			//Gets a record by index
		output.get(output.size()-1).add("string");					//return type: Returns field (number 1) from the most recent dbn record as a string.
		output.get(output.size()-1).add("number");					//parameter 1
		
		output.add(new ArrayList());
		output.get(output.size()-1).add("f_getExtdbIntField");		//Gets a record by index
		output.get(output.size()-1).add("number");					//return type: Returns field (number 1) from the most recent dbn record as a number.
		output.get(output.size()-1).add("number");					//parameter 1
		
		output.add(new ArrayList());
		output.get(output.size()-1).add("f_getExtdbNamedValue");	//Gets a Field String from a dbn record
		output.get(output.size()-1).add("string");					//return type: Returns field (number 1) from the most recent dbn record as a string. 
		output.get(output.size()-1).add("number");					//parameter 1
		output.get(output.size()-1).add("string");					//parameter 2
		
		output.add(new ArrayList());
		output.get(output.size()-1).add("f_getExtdbNamedIntValue");	//Gets a Field Number from a dbn record
		output.get(output.size()-1).add("number");					//return type: Returns field (number 1) from the most recent dbn record as a number.
		output.get(output.size()-1).add("number");					//parameter 1
		output.get(output.size()-1).add("string");					//parameter 2
		
		
		output.add(new ArrayList());								//pivot:
		output.get(output.size()-1).add("f_setExtdbNamedValue");	//Starting at (number 1), attempts to create a named-value pair in the extdb variables (will roll to next if no space available). If a value of this name is already set, that value is removed.   
		output.get(output.size()-1).add("string");					//return type:  Returns 1 is successful or 0 otherwise.
		output.get(output.size()-1).add("string");					//parameter 1
		output.get(output.size()-1).add("string");					//parameter 2
		output.get(output.size()-1).add("string");					//parameter 3
		
		output.add(new ArrayList());								//pivot:
		output.get(output.size()-1).add("f_setExtdbNamedIntValue");	//Starting at (number 1), attempts to create a named-value pair in the extdb variables (will roll to next if no space available). If a value of this name is already set, that value is removed. 
		output.get(output.size()-1).add("string");					//return type:  Returns 1 is successful or 0 otherwise.
		output.get(output.size()-1).add("string");					//parameter 1
		output.get(output.size()-1).add("string");					//parameter 2
		output.get(output.size()-1).add("number");					//parameter 3
		
		
		output.add(new ArrayList());								//pivot:
		output.get(output.size()-1).add("f_setNamedValue");			//adding a named-value pair name= strval in (string 1), removing any value name that was set previously.
		output.get(output.size()-1).add("string");					//return type: Returns a copy of (string 1),
		output.get(output.size()-1).add("string");					//parameter 1
		output.get(output.size()-1).add("string");					//parameter 2
		output.get(output.size()-1).add("string");					//parameter 3
		
		output.add(new ArrayList());								//pivot:
		output.get(output.size()-1).add("f_setNamedIntValue");		//adding a named-value pair name= numval in (string 1), removing any value name that was set previously.
		output.get(output.size()-1).add("string");					//return type: Returns a copy of (string 1), 
		output.get(output.size()-1).add("string");					//parameter 1
		output.get(output.size()-1).add("string");					//parameter 2
		output.get(output.size()-1).add("number");					//parameter 3
		
		output.add(new ArrayList());								//pivot:
		output.get(output.size()-1).add("f_getField");				//  
		output.get(output.size()-1).add("string");					//return type: Returns the string value of the named-value pair name= value from str.
		output.get(output.size()-1).add("string");					//parameter 1
		output.get(output.size()-1).add("number");					//parameter 2
		
		output.add(new ArrayList());
		output.get(output.size()-1).add("f_citiEncrypt");			//Encrypts or decrypts (string 1) 
		output.get(output.size()-1).add("string");					//return type: returns encrypted/decrypted (string 1) if (string 2) is 0/1, respectively.
		output.get(output.size()-1).add("string");					//parameter 1
		output.get(output.size()-1).add("number");					//parameter 2
		
		output.add(new ArrayList());								//pivot:
		output.get(output.size()-1).add("f_fixedToInt");			//I have no idea. (Not very helpful) 
		output.get(output.size()-1).add("number");					//return type
		output.get(output.size()-1).add("string");					//parameter 1
		output.get(output.size()-1).add("number");					//parameter 2
		output.get(output.size()-1).add("number");					//parameter 3
		
		output.add(new ArrayList());
		output.get(output.size()-1).add("f_getLastDayOfMonth");		//Finds the last day date of month (number 1) in year (number 2)
		output.get(output.size()-1).add("number");					//return type: A number representing the last date of a month in a year: (28-31)
		output.get(output.size()-1).add("number");					//parameter 1
		output.get(output.size()-1).add("number");					//parameter 2
		
		output.add(new ArrayList());								//pivot:  I'm not sure what "callRec" is
		output.get(output.size()-1).add("f_getCallRecVar");			//Retrieves value from callRec named (number 1) (ss7CauseCode, ani, etc...) as a string. 
		output.get(output.size()-1).add("string");					//return type
		output.get(output.size()-1).add("string");					//parameter 1
		
		output.add(new ArrayList());								//pivot:  I'm not sure what "callRec" is
		output.get(output.size()-1).add("f_getCallRecIntVar");		//Retrieves value from callRec named var (ss7CauseCode, ani, etc...) as a number. 
		output.get(output.size()-1).add("number");					//return type
		output.get(output.size()-1).add("string");					//parameter 1
		
		output.add(new ArrayList());
		output.get(output.size()-1).add("f_checkSum");				//Adds up the numbers in (string 1) 
		output.get(output.size()-1).add("string");					//return type: Returns sum of numbers in string with at least 2 digits as a string.
		output.get(output.size()-1).add("string");					//parameter 1
		
		output.add(new ArrayList());
		output.get(output.size()-1).add("f_toAlphaNumeric");		//Converts (string 1) so that any characters that are not alphanumeric or contained within (string 2) are converted to spaces. 
		output.get(output.size()-1).add("string");					//return type: Returns converted string.
		output.get(output.size()-1).add("string");					//parameter 1
		output.get(output.size()-1).add("string");					//parameter 2

		output.add(new ArrayList());
		output.get(output.size()-1).add("f_toValidGrammar");		//Normalizes (string 1) legal SRGS grammar. 
		output.get(output.size()-1).add("string");					//return type: returns normalized grammar.
		output.get(output.size()-1).add("string");					//parameter 1
		
		output.add(new ArrayList());
		output.get(output.size()-1).add("f_regex");					//Check (string 1) as a regex expression against (string 2) (using perl-compatible regex engine). 
		output.get(output.size()-1).add("number");					//return type: Returns 1 for match, or 0 otherwise.
		output.get(output.size()-1).add("string");					//parameter 1
		output.get(output.size()-1).add("string");					//parameter 2
		
		output.add(new ArrayList());
		output.get(output.size()-1).add("f_spaces");				//Creates a string of spaces of (number 1) length.
		output.get(output.size()-1).add("string");					//return type: Returns a string of spaces.
		output.get(output.size()-1).add("number");					//parameter 1
		
		output.add(new ArrayList());
		output.get(output.size()-1).add("f_time");					//Determines current seconds past the epoch in zone (assumed to be EST if not provided). 
		output.get(output.size()-1).add("number");					//return type: Returns a number in seconds.
		output.get(output.size()-1).add("string");					//parameter 1
		
		output.add(new ArrayList());
		output.get(output.size()-1).add("f_formatTime");			//Determines a string of (number 1) time in seconds formatted using (string 1) (following Java SimpleDateFormat rules).  
		output.get(output.size()-1).add("string");					//return type: Returns formatted time.
		output.get(output.size()-1).add("number");					//parameter 1
		output.get(output.size()-1).add("string");					//parameter 2
		
		
		/*
		 Function: f_formatMoney
		 Purpose : Formats the given amount of pennies in the given format
		 Input   : Pennies --> number of pennies to format
		           Format  --> number of the desired format; Examples below
		                       using pennies = 101351 and -101351
		           Abs Value   0 -  no format (itoa)   (e.g.   101351)
		                       1 -   (cents)           (e.g.       51)
		                       2 -   (dollars)         (e.g.     1013)
		                       3 -   (dollars).(cents) (e.g   1013.51)
		                       4 -  $(dollars).(cents) (e.g  $1013.51)
		           Lead Sign  10 -  no format (itoa)   (e.g.  -101351)
		                      11 -   (cents)           (e.g.      -51)
		                      12 -   (dollars)         (e.g.    -1013)
		                      13 -   (dollars).(cents) (e.g  -1013.51)
		                      14 -  $(dollars).(cents) (e.g -$1013.51)
		           Trail Sign 20 -  no format (itoa)   (e.g.  101351-)
		                      21 -   (cents)           (e.g.      51-)
		                      22 -   (dollars)         (e.g.    1013-)
		                      23 -   (dollars).(cents) (e.g  1013.51-)
		                      24 -  $(dollars).(cents) (e.g $1013.51-)
		           NOTE: The "sign" only applies to negative numbers (so the
		                 results for 0..4 will be equivalent to 10..14 when
		                 positive numbers are passed);positive numbers will
		                 have a trailing space when using "Trail Sign" args.
		 Return  : passed value as a string in the format specified; if
		           invalid format is passed, the "10" format is used
		 */
		
		
		output.add(new ArrayList());
		output.get(output.size()-1).add("f_formatMoney");				//Determines a string of (number 1) in pennies formatted using (number 2) as the format. 
		output.get(output.size()-1).add("string");						//return type: Returns a value of currency.
		output.get(output.size()-1).add("number");						//parameter 1
		output.get(output.size()-1).add("number");						//parameter 2
		
		output.add(new ArrayList());
		output.get(output.size()-1).add("f_keyPadTranslate");			//Determines the string of the dtmf digits to be pushed to spell (string 1). 
		output.get(output.size()-1).add("string");						//return type: Return the translated string
		output.get(output.size()-1).add("string");						//parameter 1
		
		output.add(new ArrayList());
		output.get(output.size()-1).add("f_floatAdd");					//Adds assumed float (string 1) to assumed float (string 2) 
		output.get(output.size()-1).add("string");						//return type: Returns the string equivalent of the sum.
		output.get(output.size()-1).add("string");						//parameter 1
		output.get(output.size()-1).add("string");						//parameter 2
		
		output.add(new ArrayList());
		output.get(output.size()-1).add("f_floatSubtract");				//Subtracts assumed float  (string 2) from assumed float (string 1). 
		output.get(output.size()-1).add("string");						//return type: Returns the string equivalent of the difference.
		output.get(output.size()-1).add("string");						//parameter 1
		output.get(output.size()-1).add("string");						//parameter 2
		
		output.add(new ArrayList());
		output.get(output.size()-1).add("f_floatMultiply");				//Multiplies assumed float (string 2) from assumed float (string 1). 
		output.get(output.size()-1).add("string");						//return type: Returns the string equivalent of the product.
		output.get(output.size()-1).add("string");						//parameter 1
		output.get(output.size()-1).add("string");						//parameter 2
		
		output.add(new ArrayList());
		output.get(output.size()-1).add("f_floatDivide");				//Divides assumed float  (string 2) from assumed float (string 1).  
		output.get(output.size()-1).add("string");						//return type: Returns the string equivalent of the quotient. Returns the literal string "NaN" if (string 2) is equivalent to 0.
		output.get(output.size()-1).add("string");						//parameter 1
		output.get(output.size()-1).add("string");						//parameter 2
		
		output.add(new ArrayList());
		output.get(output.size()-1).add("f_floatGetWholePart");			//Determines the whole number from the digits to the left of the decimal of the floating point value (string 1). 
		output.get(output.size()-1).add("number");						//return type: Returns the whole number from the assumed float (string1).
		output.get(output.size()-1).add("string");						//parameter 1
		
		output.add(new ArrayList());
		output.get(output.size()-1).add("f_floatGetFractionPart");		//Determines the numeric equivalent of the first (number 1) digits to the right of the decimal of the floating point value (string 1).  
		output.get(output.size()-1).add("number");						//return type: Returns the decimal number from the assumed float (string1).
		output.get(output.size()-1).add("string");						//parameter 1
		output.get(output.size()-1).add("number");						//parameter 2
		
		output.add(new ArrayList());
		output.get(output.size()-1).add("f_floatIsNegative");			//Determines if (string 1) represents a negative float 
		output.get(output.size()-1).add("number");						//return type:  Returns 1 if (string 1) is negative, or 0 otherwise.
		output.get(output.size()-1).add("string");						//parameter 1
		
		output.add(new ArrayList());
		output.get(output.size()-1).add("f_floatIsNaN");				//Determines if assumed float (string 1) is "NaN"
		output.get(output.size()-1).add("number");						//return type: Returns 1 is (string 1) is "NaN", or 0 otherwise.
		output.get(output.size()-1).add("string");						//parameter 1
		
		output.add(new ArrayList());
		output.get(output.size()-1).add("f_floatCompare");				//Determines the relative location of (string 1) to (string 2) +/- (string 3). 
		output.get(output.size()-1).add("number");						//return type: Returns 0 if (string 1) is below the range, 1 if (string 1) is in range, and 2 if (string 1) is above range.
		output.get(output.size()-1).add("string");						//parameter 1
		output.get(output.size()-1).add("string");						//parameter 2
		output.get(output.size()-1).add("string");						//parameter 3
		
		output.add(new ArrayList());
		output.get(output.size()-1).add("f_floatRound");				//Determines the string representation of assumed float (string 1) rounded to (string 2) right of decimal point (negative for fractional significance). 
		output.get(output.size()-1).add("string");						//return type: Returns a string representation of a rounded float.
		output.get(output.size()-1).add("string");						//parameter 1
		output.get(output.size()-1).add("string");						//parameter 2
		
		output.add(new ArrayList());									//pivot: I don't know what "mime" is.
		output.get(output.size()-1).add("f_rsaEncrypt");				//Encrypts (string 3) using the (string 1) and (string 2) mime encoded. 
		output.get(output.size()-1).add("string");						//return type: Returns an encrypted string.
		output.get(output.size()-1).add("string");						//parameter 1
		output.get(output.size()-1).add("string");						//parameter 2
		output.get(output.size()-1).add("string");						//parameter 3
		
		output.add(new ArrayList());									//pivot: I don't know what "mime" is.
		output.get(output.size()-1).add("f_mime64Encode");				//Encrypts a string using "mime".
		output.get(output.size()-1).add("string");						//return type: Returns the mime encoded copy of (string 1)
		output.get(output.size()-1).add("string");						//parameter 1
		
		output.add(new ArrayList());									//pivot: I don't know what "mime" is.
		output.get(output.size()-1).add("f_mime64Decode");				//Decrypts a mime encoded string.
		output.get(output.size()-1).add("string");						//return type: Returns the mime decoded copy of (string 1)
		output.get(output.size()-1).add("string");						//parameter 1
		
		output.add(new ArrayList());
		output.get(output.size()-1).add("f_getHostname");				//Finds the fully qualified domain name for (string 1) (assumed to be 0.0.0.0 if not provided). 
		output.get(output.size()-1).add("string");						//return type: Returns a fully qualified domain name.
		output.get(output.size()-1).add("string");						//parameter 1
		
		return output;
	}
	
	private ArrayList<ArrayList<ArrayList<String>>> CreateMasterExternalFunctionList()
	{
		ArrayList<ArrayList<ArrayList<String>>> output = new ArrayList<ArrayList<ArrayList<String>>>();
		
		/*
		 	This function sends a call progress message to the acd indicating that
  			an operator has answered the call.  The acd uses this information for
  			calculating the average speed of answer for operator calls.
		 */
		output.add(new ArrayList<ArrayList<String>>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).get(0).add("setAcdOperatorAnswered");	//set external function name
		//output.get(output.size()-1).get(1).add("none");						//set return type 1
		//output.get(output.size()-1).get(2).add("none");						//set parameter 1
		
		/*
		 	Based on the enumerations of c_cdrXXX this function will cut a billing CDR
  			with modes set by the script writer.  It will also put circuit info into the
  			billing legs associated with c_out1Port, c_out2Port, c_outboundTrunk.  If
  			an application can be identified special extented CDR's will be cut.
		 */
		output.add(new ArrayList());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).get(0).add("cutBillingCdr");			//set external function name
		output.get(output.size()-1).get(1).add("none");						//return type: No return
		output.get(output.size()-1).get(2).add("c_cdrXXX");					//parameter 1
		output.get(output.size()-1).get(2).add("c_out1Port");				//parameter 2
		output.get(output.size()-1).get(2).add("c_out2Port");				//parameter 3
		output.get(output.size()-1).get(2).add("c_outboundTrunk");			//parameter 4
		
		/*
		 	Will write a comma delimited CDR with a header record and any associtated
  			detail cell records that have been accumilated during the call
		 */
		output.add(new ArrayList());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).get(0).add("writeDetailCdr");			//set external function name
		//output.get(output.size()-1).get(1).add("none");						//return type: No return
		//output.get(output.size()-1).get(2).add("none");						//parameter 1
		
		//writes an outclearing record for credit card transactions
		
		output.add(new ArrayList());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).get(0).add("writeCreditCardRecord");	//set external function name
		output.get(output.size()-1).get(1).add("none");						//return type: No return
		output.get(output.size()-1).get(2).add("c_ivanBillToNumber");		//parameter 1
		output.get(output.size()-1).get(2).add("c_expirationDate");			//parameter 2
		output.get(output.size()-1).get(2).add("c_ivanMerchantId");			//parameter 3
		output.get(output.size()-1).get(2).add("c_ccPreauthPennies");		//parameter 4
		output.get(output.size()-1).get(2).add("c_call_duration");			//parameter 4
		
		/*
			Adds the specified number of days to the specified date and puts the
  			resulting date in c_stringResult.
		 */
		output.add(new ArrayList());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).get(0).add("addDaysToDate");			//set external function name
		output.get(output.size()-1).get(1).add("c_stringResult");			//return type: string
		output.get(output.size()-1).get(2).add("c_numberOperand1");			//parameter 1: days to add
		output.get(output.size()-1).get(2).add("c_stringOperand1");			//parameter 2: date to add to in MMDDYY or MMDDYYYY format
		
		/*
			Adds the specified number of days to today and puts the resulting date
		  	in c_stringResult.
		
		  	Handles the case if the year we're in is a leap year, but does not
		  	handle subsequent leap years.  Therefore, adding more than 1 year to the
		  	current date may produce an inaccurate result.

		 */
		output.add(new ArrayList());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).get(0).add("addDaysToToday");			//set external function name
		output.get(output.size()-1).get(1).add("c_stringResult");			//return type: string
		output.get(output.size()-1).get(2).add("c_numberOperand1");			//parameter 1: days to add
		output.get(output.size()-1).get(2).add("c_stringOperand1");			//parameter 2: years to add (0 or 1 only)
		
		/*
			This function allows you to add/subtract days/months/years to an input
  			date.  The result is stored in c_dateResultString.
		 */
		output.add(new ArrayList());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).get(0).add("dateAdjust"); 				//set external function name
		output.get(output.size()-1).get(1).add("c_dateResultString");		//return type: Contains the result of adding/subtracting days/months/years to the input date.
		output.get(output.size()-1).get(2).add("c_date");					//parameter 1: The date you want to adjust.
		output.get(output.size()-1).get(2).add("c_dateCount");				//parameter 2: The number of days/months/years you wish to add to / subtract from the input date.
		output.get(output.size()-1).get(2).add("c_dateUnits");				//parameter 3: The units you wish to use to add/subtract: PLUSDAYS,PLUSMONTHS,PLUSYEARS,MINUSDAYS,MINUSMONTHS,MINUSYEARS.
		output.get(output.size()-1).get(2).add("c_dateFormat");				//parameter 4: years to add (0 or 1 only)
		
		/*
			converts any int date to a MMDDYY string
		*/
		output.add(new ArrayList());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).get(0).add("convertIntDateToMMDDYY"); 		//set external function name
		output.get(output.size()-1).get(1).add("c_stringResult");				//return type: date in MMDDYY format
		output.get(output.size()-1).get(2).add("c_bigNumberOperand1");			//parameter 1: int date to convert.
		
		/*
			Gets the current date and places the result in c_stringResult in
  			MMDDYY format.
		*/
		output.add(new ArrayList());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).get(0).add("getCurrentDate"); 				//set external function name
		output.get(output.size()-1).get(1).add("c_stringResult");				//return type:
		//output.get(output.size()-1).get(2).add("none");							//parameter 1:
		
		/*
			Gets the current date and places the result in c_stringResult in
  			YYYYMMDD format.
		*/
		output.add(new ArrayList());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).get(0).add("getCurrentDateYYYYMMDD"); 		//set external function name
		output.get(output.size()-1).get(1).add("c_stringResult");				//return type: date in MMDDYY format
		//output.get(output.size()-1).get(2).add("none");							//parameter 1:
		
		/*
			Sets c_numberResult to the day of the week, 0 being Monday and 6 being
  			Sunday.
		*/
		output.add(new ArrayList());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).get(0).add("getDateDayOfWeek"); 			//set external function name
		output.get(output.size()-1).get(1).add("c_numberResult");				//return type: date in MMDDYY format
		output.get(output.size()-1).get(2).add("c_bigNumberOperand1");			//parameter 1: time zone.
		
		/*
			Converts the date in MMDDYY format (in c_stringOperand1) to YYMMDD format
  			and places the result in c_stringResult1.
		 */
		output.add(new ArrayList());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).get(0).add("dateFromMMDDYYToYYMMDD"); 		//set external function name
		output.get(output.size()-1).get(1).add("c_stringResult");				//return type: date in MMDDYY format
		output.get(output.size()-1).get(2).add("c_stringOperand1");				//parameter 1:  (in MMDDYY format).
		
		/*
			Validates the date passed in c_stringOperand1.  If the date is valid,
	  		sets c_functionResult to 1; otherwise, sets c_functionResult to 0.
	
	  		If c_stringOperand is 4 characters, and date is less than today,
	  		the input year is assumed to be next year.  If the date is equal to today
	  		or greater, the date is assumed to be this year.
	
	  		If the date is valid, c_stringResult will be set to the input date but
	  		will be in the form YYMMDD.
		 */
		output.add(new ArrayList());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).get(0).add("validateDate"); 				//set external function name
		output.get(output.size()-1).get(1).add("c_stringResult");				//return type: 
		output.get(output.size()-1).get(1).add("c_functionResult");				//return type: 
		output.get(output.size()-1).get(2).add("c_stringOperand1");				//parameter 1:  (date in either MMDD or MMDDYY format).
		
		/*
			This function allows you to check and see if a date falls within a given
			date window.  You specify the window by setting up a reference point and
			a certain number of days/months/years before or after the window.  The
			result indicates whether the day you specified is within, before, or after
			the window.
		 */
		output.add(new ArrayList());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).get(0).add("dateWithinRange"); 				//set external function name
		output.get(output.size()-1).get(1).add("c_dateResult");					//return type: WITHIN,BEFORE,AFTER
		output.get(output.size()-1).get(2).add("c_date");						//parameter 1: The date you want to check.
		output.get(output.size()-1).get(2).add("c_dateReference");				//parameter 2: The date you want to check.
		output.get(output.size()-1).get(2).add("c_dateReference2");				//parameter 3: The starting or ending point of the window you want to check.
		output.get(output.size()-1).get(2).add("c_dateCount");					//parameter 4: Defines the ending point of the window.  If this field is empty, we use the c_dateCount to define the window endpoint.
		output.get(output.size()-1).get(2).add("c_dateUnits");					//parameter 5: The units you wish to use to extend the window: PLUSDAYS,PLUSMONTHS,PLUSYEARS,MINUSDAYS,MINUSMONTHS,MINUSYEARS.
		output.get(output.size()-1).get(2).add("c_dateFormat");					//parameter 6: The format of the dates in c_dateReference:  MMDDYY,YYMMDD,MMDD. Four character years are also handled.
		
		/*
			This function call checks if the date on an external database has changed
  			If date has changed function returns new date.
		 */
		output.add(new ArrayList());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).get(0).add("ExtdbCheckDateTime"); 			//set external function name
		output.get(output.size()-1).get(1).add("c_extdbFileChanged");			//return type: boolean value that if returns 0 file was not changed returns 1 if changed
		output.get(output.size()-1).get(1).add("c_extdbFileChangeDate");		//return type: if boolean value returns true this will contain the new date
		output.get(output.size()-1).get(2).add("c_extdbName");					//parameter 1:
		
		/*
			c_numberOperand1 should contain which field to obtain from the string
  			of comma-delimited fields contained in c_stringOperand1.  The first field
  			in the string is assumed to be 1.  The resulting field is placed in
  			c_stringOperand2.

			Example:
			  c_stringOperand1 = "aaa,bbb,ccc"
			  c_numberOperand1 = 3
			  c_stringOperand2 = "ccc"
		 */
		output.add(new ArrayList());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).get(0).add("getField"); 					//set external function name
		output.get(output.size()-1).get(1).add("c_stringOperand2");				//return type: boolean value that if returns 0 file was not changed returns 1 if changed
		output.get(output.size()-1).get(2).add("c_stringOperand1");				//parameter 1:
		output.get(output.size()-1).get(2).add("c_numberOperand1");				//parameter 2:
		
		/*
			Counts the number of comma-delimited fields in c_stringOperand1 and
		  	returns the number in c_numberOperand1.
		
		  	Example:
			
		  		aaa,bbb,cc
		
		  would return a value of 3.
		 */
		output.add(new ArrayList());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).get(0).add("getFieldCount"); 				//set external function name
		output.get(output.size()-1).get(1).add("c_numberOperand1");				//return type: boolean value that if returns 0 file was not changed returns 1 if changed
		output.get(output.size()-1).get(2).add("c_stringOperand1");				//parameter 1:

		/*
			Assumes a credit card number is in c_billToNumber and does a generic
		  	Mod 10 check on that number.  c_passMod10 is set to 1 if the number
		  	passes the check or 0 otherwise.
		
		  	Also sets c_creditCardType based on the type of credit card.
		
		  	AMEX = 1
		  	DINERS CLUB = 2
		  	CARTE_BLANC = 3
		  	DISCOVER = 4
		  	MASTER_CARD 5
		  	VISA = 6
		 */
		output.add(new ArrayList());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).get(0).add("mod10"); 					//set external function name
		output.get(output.size()-1).get(1).add("c_passMod10");				//return type: 
		output.get(output.size()-1).get(1).add("c_creditCardType");			//return type: 
		output.get(output.size()-1).get(2).add("c_billToNumber");			//parameter 1: always clear c_billToNumber post evaluation 

		/*
			The input c_stringOperand1 should be in the format:

  			d..d*c..c*

  			where d..d = dollars and c..c = cents

  			Based on this string, the function sets c_bigMoneyMathPennies1 and
  			c_bigMoneyMatchDollars1.
		 */
		output.add(new ArrayList());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).get(0).add("bigMoneyConvert"); 			//set external function name
		output.get(output.size()-1).get(1).add("c_bigMoneyMathPennies1");	//return type: 
		output.get(output.size()-1).get(1).add("c_bigMoneyMathDollars1");	//return type: 
		output.get(output.size()-1).get(2).add("c_stringOperand1");			//parameter 1: 

		/*
			The input c_stringOperand1 should be in the format:

		  	<dollars>.<cents>
		
		  	Based on this string, the function sets c_bigMoneyMathPennies1 and
		  	c_bigMoneyMatchDollars1.

		 */
		output.add(new ArrayList());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).get(0).add("bigMoneyConvertDecimal"); 	//set external function name
		output.get(output.size()-1).get(1).add("c_bigMoneyMathPennies1");	//return type: 
		output.get(output.size()-1).get(1).add("c_bigMoneyMathDollars1");	//return type: 
		output.get(output.size()-1).get(2).add("c_stringOperand1");			//parameter 1: 

		/*
			Adds c_bigMoneyMathPennies1/Dollars1 to c_bigMoneyMathPennies2/Dollars2
  			and puts the result in c_bigMoneyMathPennies/Dollars.  Accounts for
  			penny roll overs.
		 */
		output.add(new ArrayList());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).get(0).add("bigMoneyMath");					//set external function name //add
		output.get(output.size()-1).get(1).add("c_bigMoneyMathPenniesResult");	//return type: 
		output.get(output.size()-1).get(1).add("c_bigMoneyMathDollarsResult");	//return type: 
		output.get(output.size()-1).get(2).add("c_bigMoneyMathOperator");		//parameter 1: ADD(0)
		output.get(output.size()-1).get(2).add("c_bigMoneyMathPennies1");		//parameter 2: 
		output.get(output.size()-1).get(2).add("c_bigMoneyMathPennies2");		//parameter 3: 
		output.get(output.size()-1).get(2).add("c_bigMoneyMathDollars1");		//parameter 4: 
		output.get(output.size()-1).get(2).add("c_bigMoneyMathDollars2");		//parameter 5: 

		/*
			Subtracts c_bigMoneyMathPennies2/Dollars2 from
  			c_bigMoneyMathPennies1/Dollars1 and puts the result in
  			c_bigMoneyMathPennies/Dollars.  Accounts for
  			penny roll overs.
		 */
		output.add(new ArrayList());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).get(0).add("bigMoneyMath");					//set external function name //subtract
		output.get(output.size()-1).get(1).add("c_bigMoneyMathPenniesResult");	//return type: 
		output.get(output.size()-1).get(1).add("c_bigMoneyMathDollarsResult");	//return type: 
		output.get(output.size()-1).get(2).add("c_bigMoneyMathOperator");		//parameter 1: ADD(0)
		output.get(output.size()-1).get(2).add("c_bigMoneyMathPennies1");		//parameter 2: 
		output.get(output.size()-1).get(2).add("c_bigMoneyMathPennies2");		//parameter 3: 
		output.get(output.size()-1).get(2).add("c_bigMoneyMathDollars1");		//parameter 4: 
		output.get(output.size()-1).get(2).add("c_bigMoneyMathDollars2");		//parameter 5: 
		
		/*
			Adds c_bigMoneyMathPennies1/Dollars1 to c_bigMoneyMathPennies2/Dollars2
			and puts the result in c_bigMoneyMathPennies/Dollars.  Accounts for
			penny roll overs.
		 */
		output.add(new ArrayList());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).get(0).add("bigMoneyMath");					//set external function name //multiply
		output.get(output.size()-1).get(1).add("c_bigMoneyMathPenniesResult");	//return type: 
		output.get(output.size()-1).get(1).add("c_bigMoneyMathDollarsResult");	//return type: 
		output.get(output.size()-1).get(2).add("c_bigMoneyMathOperator");		//parameter 1: MULTIPLY(3)
		output.get(output.size()-1).get(2).add("c_bigMoneyMathPennies1");		//parameter 2: 
		output.get(output.size()-1).get(2).add("c_bigMoneyMathPennies2");		//parameter 3: 
		output.get(output.size()-1).get(2).add("c_bigMoneyMathDollars1");		//parameter 4: 
		output.get(output.size()-1).get(2).add("c_bigMoneyMathDollars2");		//parameter 5: 

		/*
			Compares c_bigMoneyMathPennies1/Dollars1 to
  			c_bigMoneyMathPennies2/Dollars2 and sets c_bigMoneyMathCompareResult
  			based on the result.

  			c_bigMoneyMathCompareResult
    		LESS_THAN(0)              Pennies/Dollars1 < Pennies/Dollars2
    		EQUAL_TO(1)               Pennies/Dollars1 = Pennies/Dollars2
    		GREATER_THAN(2)           Pennies/Dollars1 > Pennies/Dollars2
		 */
		output.add(new ArrayList());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).get(0).add("bigMoneyMath");					//set external function name //compare
		output.get(output.size()-1).get(1).add("c_bigMoneyMathPenniesResult");	//return type: 
		output.get(output.size()-1).get(1).add("c_bigMoneyMathDollarsResult");	//return type: 
		output.get(output.size()-1).get(1).add("c_bigMoneyMathCompareResult");	//return type: 
		output.get(output.size()-1).get(2).add("c_bigMoneyMathOperator");		//parameter 1: COMPARE(4)
		output.get(output.size()-1).get(2).add("c_bigMoneyMathPennies1");		//parameter 2: 
		output.get(output.size()-1).get(2).add("c_bigMoneyMathPennies2");		//parameter 3: 
		output.get(output.size()-1).get(2).add("c_bigMoneyMathDollars1");		//parameter 4: 
		output.get(output.size()-1).get(2).add("c_bigMoneyMathDollars2");		//parameter 5: 

		/*
			c_numberResult = c_numberOperand1 + c_numberOperand2
		 */
		output.add(new ArrayList());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).get(0).add("numberMath");					//set external function name //add
		output.get(output.size()-1).get(1).add("c_numberResult");				//return type: 
		output.get(output.size()-1).get(2).add("c_numberOperator");				//parameter 1: ADD(0)
		output.get(output.size()-1).get(2).add("c_numberOperand1");				//parameter 2: 
		output.get(output.size()-1).get(2).add("c_numberOperand2");				//parameter 3: 
		
		/*
			c_numberResult = c_numberOperand1 - c_numberOperand2
		 */
		output.add(new ArrayList());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).get(0).add("numberMath");					//set external function name //subtract
		output.get(output.size()-1).get(1).add("c_numberResult");				//return type: 
		output.get(output.size()-1).get(2).add("c_numberOperator");				//parameter 1: SUBTRACT(1)
		output.get(output.size()-1).get(2).add("c_numberOperand1");				//parameter 2: 
		output.get(output.size()-1).get(2).add("c_numberOperand2");				//parameter 3: 
		
		/*
			c_numberResult = c_numberOperand1 / c_numberOperand2
		 */
		output.add(new ArrayList());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).get(0).add("numberMath");					//set external function name //divide
		output.get(output.size()-1).get(1).add("c_numberResult");				//return type: 
		output.get(output.size()-1).get(2).add("c_numberOperator");				//parameter 1: DIVIDE(2)
		output.get(output.size()-1).get(2).add("c_numberOperand1");				//parameter 2: 
		output.get(output.size()-1).get(2).add("c_numberOperand2");				//parameter 3: 
		
		/*
			c_numberResult = c_numberOperand1 * c_numberOperand2
		 */
		output.add(new ArrayList());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).get(0).add("numberMath");					//set external function name //multiply
		output.get(output.size()-1).get(1).add("c_numberResult");				//return type: 
		output.get(output.size()-1).get(2).add("c_numberOperator");				//parameter 1: MULTIPLY(3)
		output.get(output.size()-1).get(2).add("c_numberOperand1");				//parameter 2: 
		output.get(output.size()-1).get(2).add("c_numberOperand2");				//parameter 3: 
		
		/*
			c_numberCompareResult
		       LESS_THAN (0)          c_numberOperand1 < c_numberOperand2
		       EQUAL_TO (1)           c_numberOperand1 = c_numberOperand2
		       GREATER_THAN (2)       c_numberOperand1 > c_numberOperand2
		 */
		output.add(new ArrayList());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).get(0).add("numberMath");					//set external function name //compare
		output.get(output.size()-1).get(1).add("c_numberResult");				//return type: 
		output.get(output.size()-1).get(2).add("c_numberOperator");				//parameter 1: COMPARE(4)
		output.get(output.size()-1).get(2).add("c_numberOperand1");				//parameter 2: 
		output.get(output.size()-1).get(2).add("c_numberOperand2");				//parameter 3: 
		
		/*
			c_bigNumberResult = c_bigNumberOperand1 + c_bigNumberOperand2
		 */
		output.add(new ArrayList());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).get(0).add("bigNumberMath");				//set external function name //add
		output.get(output.size()-1).get(1).add("c_bigNumberResult");			//return type: 
		output.get(output.size()-1).get(2).add("c_numberOperator");				//parameter 1: ADD(0)
		output.get(output.size()-1).get(2).add("c_bigNumberOperand1");			//parameter 2: 
		output.get(output.size()-1).get(2).add("c_bigNumberOperand2");			//parameter 3: 
		
	
		/*
			c_bigNumberResult = c_bigNumberOperand1 - c_bigNumberOperand2
		 */
		output.add(new ArrayList());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).get(0).add("bigNumberMath");				//set external function name //subtract
		output.get(output.size()-1).get(1).add("c_bigNumberResult");			//return type: 
		output.get(output.size()-1).get(2).add("c_numberOperator");				//parameter 1: SUBTRACT(1)
		output.get(output.size()-1).get(2).add("c_bigNumberOperand1");			//parameter 2: 
		output.get(output.size()-1).get(2).add("c_bigNumberOperand2");			//parameter 3: 
		
		/*
			c_bigNumberResult = c_bigNumberOperand1 / c_bigNumberOperand2
		 */
		output.add(new ArrayList());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).get(0).add("bigNumberMath");				//set external function name //divide
		output.get(output.size()-1).get(1).add("c_bigNumberResult");			//return type: 
		output.get(output.size()-1).get(2).add("c_numberOperator");				//parameter 1: DIVIDE(2)
		output.get(output.size()-1).get(2).add("c_bigNumberOperand1");			//parameter 2: 
		output.get(output.size()-1).get(2).add("c_bigNumberOperand2");			//parameter 3: 
	
		/*
			c_bigNumberResult = c_bigNumberOperand1 * c_bigNumberOperand2
		 */
		output.add(new ArrayList());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).get(0).add("bigNumberMath");				//set external function name //multiply
		output.get(output.size()-1).get(1).add("c_bigNumberResult");			//return type: 
		output.get(output.size()-1).get(2).add("c_numberOperator");				//parameter 1: MULTIPLY(3)
		output.get(output.size()-1).get(2).add("c_bigNumberOperand1");			//parameter 2: 
		output.get(output.size()-1).get(2).add("c_bigNumberOperand2");			//parameter 3: 

		/*
			c_numberCompareResult
	         LESS_THAN (0)        c_bigNumberOperand1 < c_bigNumberOperand2
	         EQUAL_TO (1)         c_bigNumberOperand1 = c_bigNumberOperand2
	         GREATER_THAN (2)     c_bigNumberOperand1 > c_bigNumberOperand2
		 */
		output.add(new ArrayList());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).get(0).add("bigNumberMath");				//set external function name //compare
		output.get(output.size()-1).get(1).add("c_numberCompareResult");		//return type: 
		output.get(output.size()-1).get(2).add("c_numberOperator");				//parameter 1: COMPARE(4)
		output.get(output.size()-1).get(2).add("c_bigNumberOperand1");			//parameter 2: 
		output.get(output.size()-1).get(2).add("c_bigNumberOperand2");			//parameter 3: 

		/*
			converts big number to regular number
		 */
		output.add(new ArrayList());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).get(0).add("bigNumberMath");				//set external function name //BIGNUMBERTONUMBER
		output.get(output.size()-1).get(1).add("c_numberResult");				//return type: 
		output.get(output.size()-1).get(2).add("c_numberOperator");				//parameter 1: BIGNUMBERTONUMBER(4)
		output.get(output.size()-1).get(2).add("c_bigNumberOperand1");			//parameter 2: 

		/*
			c_stringOperand1 should be in the format:

			d..d*cc
			
		 	where d..d = dollars and cc = cents
			
			This routine sets c_bitMoneyMathPenniesResult based on the result.
		 */
		output.add(new ArrayList());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).get(0).add("pennyConvert");					//set external function name //BIGNUMBERTONUMBER
		output.get(output.size()-1).get(1).add("c_bigMoneyMathPenniesResult");	//return type: 
		output.get(output.size()-1).get(2).add("c_stringOperand1");				//parameter 1: BIGNUMBERTONUMBER(4)
		
		/*
			c_stringResult = c_stringOperand1 + c_stringOperand2
		 */
		output.add(new ArrayList());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).get(0).add("stringFunctions");				//set external function name //strcat
		output.get(output.size()-1).get(1).add("c_stringResult");				//return type: 
		output.get(output.size()-1).get(2).add("c_stringOperator");				//parameter 1: STRCAT(0)
		output.get(output.size()-1).get(2).add("c_stringOperand1");				//parameter 2: 
		output.get(output.size()-1).get(2).add("c_stringOperand2");				//parameter 3: 
		
		/*
			c_numberResult = length of c_stringOperator1
		 */
		output.add(new ArrayList());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).get(0).add("stringFunctions");				//set external function name //strlen
		output.get(output.size()-1).get(1).add("c_numberResult");				//return type: 
		output.get(output.size()-1).get(2).add("c_stringOperator");				//parameter 1: STRLEN(1)
		output.get(output.size()-1).get(2).add("c_stringOperand1");				//parameter 2: 

		/*
			Copies y characters beginning in position x from c_stringOperand1 to
			c_stringResult.
			
			x = c_stringStartPos (first position is 0)
			y = c_stringEndPos
			
			Note:  c_stringEndPos is actually the length to copy!  If you set 
			c_stringEndPos to 0, the function copies the rest of the string beginning
			at the position you specify.
		 */
		output.add(new ArrayList());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).get(0).add("stringFunctions");				//set external function name //substr
		output.get(output.size()-1).get(1).add("c_stringResult");				//return type: 
		output.get(output.size()-1).get(2).add("c_stringOperator");				//parameter 1: SUBSTR(5)
		output.get(output.size()-1).get(2).add("c_stringOperand1");				//parameter 2: 
		output.get(output.size()-1).get(2).add("c_stringStartPos");				//parameter 3: 
		output.get(output.size()-1).get(2).add("c_stringEndPos");				//parameter 4: 

		/*
			Given a date in the past (c_stringOperand1), calculates the difference
  			in days between that date and today.
		 */
		output.add(new ArrayList());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).get(0).add("stringFunctions");				//set external function name //daysBeforeToday
		output.get(output.size()-1).get(1).add("c_numberResult");				//return type: 
		output.get(output.size()-1).get(2).add("c_stringOperator");				//parameter 1: DaysBeforeToday(6)
		output.get(output.size()-1).get(2).add("c_stringOperand1");				//parameter 2: date in YYMMDD format

		/*
			Converts c_stringOperand1 to an integer and puts the result in
  			c_numberResult.
		 */
		output.add(new ArrayList());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).get(0).add("stringFunctions");				//set external function name //atoi
		output.get(output.size()-1).get(1).add("c_numberResult");				//return type: 
		output.get(output.size()-1).get(2).add("c_numberOperator");				//parameter 1: ATOI(7)
		output.get(output.size()-1).get(2).add("c_stringOperand1");				//parameter 2: 

		/*
			Converts c_numberOperand1 to a string and puts the result in
  			c_stringResult.
		 */
		output.add(new ArrayList());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).get(0).add("stringFunctions");				//set external function name //itoa
		output.get(output.size()-1).get(2).add("c_stringResult");				//return type: 
		output.get(output.size()-1).get(2).add("c_stringOperator");				//parameter 1: ITOA(8)
		output.get(output.size()-1).get(2).add("c_numberOperand1");				//parameter 2: 

		/*
			Compares the two input dates to see if they are equal.

		  	c_stringCompareResult
		     	LESS_THAN(0)             c_stringOperand1 < c_asOfDate
		     	EQUAL_TO(1)              c_stringOperand1 = c_asOfDate
		     	GREATER_THAN(2)          c_stringOperand1 > c_asOfDate
		 */
		output.add(new ArrayList());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).get(0).add("stringFunctions");				//set external function name //compareAsOfDate
		output.get(output.size()-1).get(1).add("c_stringCompareResult");		//return type: 
		output.get(output.size()-1).get(2).add("c_stringOperator");				//parameter 1: COMPAREASOFDATE(9)
		output.get(output.size()-1).get(2).add("c_stringOperand1");				//parameter 2: (YYMMDD format)
		output.get(output.size()-1).get(2).add("c_asOfDate");					//parameter 3: (YYMMDD format)

		/*
			Compares c_stringOperand1 with c_stringOperand2 and sets
  			c_stringCompareResult based on the result.

  			c_stringCompareResult
			    LESS_THAN(0)              c_stringOperand1 < c_stringOperand2
			    EQUAL_TO(1)               c_stringOperand1 = c_stringOperand2
			    GREATER_THAN(2)           c_stringOperand1 > c_stringOperand2
		 */
		output.add(new ArrayList());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).get(0).add("stringFunctions");				//set external function name //strcmp
		output.get(output.size()-1).get(1).add("c_stringCompareResult");		//return type: 
		output.get(output.size()-1).get(2).add("c_stringOperator");				//parameter 1: STRCMP(2)
		output.get(output.size()-1).get(2).add("c_stringOperand1");				//parameter 2: 
		output.get(output.size()-1).get(2).add("c_stringOperand2");				//parameter 3: 

		/*
			Performs a case-insensitive string comparison of c_stringOperand1 and
		  	c_stringOperand2 and sets c_stringCompareResult based on the result.
		
		  	c_stringCompareResult
		    	LESS_THAN(0)              c_stringOperand1 < c_stringOperand2
		   		EQUAL_TO(1)               c_stringOperand1 = c_stringOperand2
		    	GREATER_THAN(2)           c_stringOperand1 > c_stringOperand2

		 */
		output.add(new ArrayList());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).get(0).add("stringFunctions");				//set external function name //stricmp
		output.get(output.size()-1).get(1).add("c_stringCompareResult");		//return type: 
		output.get(output.size()-1).get(2).add("c_stringOperator");				//parameter 1: STRICMP(3)
		output.get(output.size()-1).get(2).add("c_stringOperand1");				//parameter 2: 
		output.get(output.size()-1).get(2).add("c_stringOperand2");				//parameter 3: 

		/*
			Performs a case string comparison of c_stringOperand1 and
		  	c_stringOperand2 for the number of characters specified in
		  	c_numberOperand1 and sets c_stringCompareResult based on the result.
		
		  	c_stringCompareResult
		    	LESS_THAN(0)              c_stringOperand1 < c_stringOperand2
		    	EQUAL_TO(1)               c_stringOperand1 = c_stringOperand2
		    	GREATER_THAN(2)           c_stringOperand1 > c_stringOperand2

		 */
		output.add(new ArrayList());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).get(0).add("stringFunctions");				//set external function name //strncmp
		output.get(output.size()-1).get(1).add("c_stringCompareResult");		//return type: 
		output.get(output.size()-1).get(2).add("c_stringOperator");				//parameter 1: STRNCMP(4)
		output.get(output.size()-1).get(2).add("c_stringOperand1");				//parameter 2: 
		output.get(output.size()-1).get(2).add("c_stringOperand2");				//parameter 3: 
		output.get(output.size()-1).get(2).add("c_numberOperand1");				//parameter 4: 

		/*
			Given a date in the future (c_stringOperand1), sets c_numberResult to the
  			number of days between that date and today.

  			Note:  this function is not accurate if the date in the future is greater
  			than one year away!
		 */
		output.add(new ArrayList());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).get(0).add("stringFunctions");				//set external function name //strncmp
		output.get(output.size()-1).get(1).add("c_stringCompareResult");		//return type: 
		output.get(output.size()-1).get(2).add("c_stringOperator");				//parameter 1: DAYSPASTTODAY
		output.get(output.size()-1).get(2).add("c_stringOperand1");				//parameter 2: (YYMMDD format)

		/*
			Converts c_bigNumberOperand1 to a string and puts the result in
  			c_stringResult.
		 */
		output.add(new ArrayList());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).get(0).add("stringFunctions");				//set external function name //btoa
		output.get(output.size()-1).get(1).add("c_stringResult");				//return type: 
		output.get(output.size()-1).get(2).add("c_stringOperator");				//parameter 1: BTOA(12)
		output.get(output.size()-1).get(2).add("c_bigNumberOperand1");			//parameter 2: 

		/*
			Converts c_stringOperand1 to an integer and puts the result in
  			c_bigNumberResult.
		 */
		output.add(new ArrayList());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).get(0).add("stringFunctions");				//set external function name //atol
		output.get(output.size()-1).get(1).add("c_bigNumberResult");			//return type: 
		output.get(output.size()-1).get(2).add("c_stringOperator");				//parameter 1: ATOL(13)
		output.get(output.size()-1).get(2).add("c_stringOperand1");				//parameter 2: 

		/*
			Anything you want to say but say it briefly.
		 */
		output.add(new ArrayList());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).get(0).add("endConv");						//set external function name 
		output.get(output.size()-1).get(1).add("c_output");						//return type: 
		output.get(output.size()-1).get(2).add("c_input");						//parameter 1: 

		/*
			Marks the start of a conversion on the call record.  

  			If c_baConfLeg AND c_baConfCount are non-zero, marks the start of
  			a conversion on the conference call leg indicated by c_baConfLeg.
		 */
		output.add(new ArrayList());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).get(0).add("startConv");					//set external function name 
		//output.get(output.size()-1).get(1).add("none");							//return type: none
		//output.get(output.size()-1).get(2).add("none");							//parameter 1: none
		
		/*
			Sets c_stringResult to the current time in HH:MM military format.
		  	Also sets c_numberResult, but does not this value will not equal the
		  	number of seconds so far in the day.  Instead, it is the numeric
		  	equivalent of the string value.
		
		  	Example:
				c_stringResult = 30
		  		c_numberResult = 230
		
		  	If no time zone is specified in c_stringOperand1, eastern standard
		  	time is assumed.
		 */
		output.add(new ArrayList());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).get(0).add("getTime");						//set external function name 
		output.get(output.size()-1).get(1).add("c_numberResult");				//return type: 
		output.get(output.size()-1).get(1).add("c_stringResult");				//return type: 
		output.get(output.size()-1).get(2).add("c_stringOperand1");				//parameter 1: time zone

		/*
			Sets c_systemTime to the date/time of input date/time (i.e. secs since 1980).
		 */
		output.add(new ArrayList());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).get(0).add("encodeDateTime");				//set external function name 
		output.get(output.size()-1).get(1).add("c_systemTime");					//return type: 
		output.get(output.size()-1).get(2).add("c_date");						//parameter 1: time zone

		/*
			Based on the c_timerId (1-5) specified by the caller, this function
  			sets c_timerValueN to the current time plus whatever is in c_timerValueN.

  			Provided the c_timerEnabled flag is yes, each time a cell is executed
  			the engine will check to see if the current time is less than or
		  	equal to the time in c_timerValueN.  If it is, the timer is considered
		  	to be "popped" and execution will continue with the cell specified in
		  	c_timerCellN.

		  	Some notes:
				1.   Timers can be set by calling setTimer.  However, timers only
		  		take effect if c_timerEnabled is yes.
		
		  		2.   When a timer pops and the timer cell is executed, the engine
		  		turns off c_timerEnabled.  The script writer must turn this back on
		  		to re-enable timers.  The engine also clears the c_timerValueN by
		  		setting it to 0.
		
		  		3.   After a timer has been set, you can disable the timer by setting
		  		the c_timerValueN to 0.  You can alter a timer by adjusting (either adding
		  		to or subtracting from) c_timerValueN.  You can also change c_timerCellN
		  		after a timer has been set.
		
		  		4.   Timer values should be supplied in seconds.
		
		  		5.   If multiple timers pop at the same time, the engine will transfer
		  		control to the earliest applicable cell (i.e. c_timerCell1 or whichever
		  		comes first).
		 */
		output.add(new ArrayList());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).get(0).add("setTimer");					//set external function name 
		output.get(output.size()-1).get(1).add("c_timerValue[x]");			//return type: x =: 1 - 5
		output.get(output.size()-1).get(2).add("c_timerId");				//parameter 1: 
		output.get(output.size()-1).get(2).add("c_timerCell[x]");			//parameter 2: x =: 1 - 5 
		output.get(output.size()-1).get(2).add("c_timerValue[x]");			//parameter 3: x =: 1 - 5

		/*
			Compare string operand1 to operand2.
  			If operand1 is a match to operand2, turn tracing on.
  			Asterisks are allowed in string operand2.
		 */
		output.add(new ArrayList());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).get(0).add("setTraceByMatch");			//set external function name 
		output.get(output.size()-1).get(1).add("c_timerValue[x]");			//return type: callRec->trace
		output.get(output.size()-1).get(2).add("c_stringOperand1");			//parameter 1: 
		output.get(output.size()-1).get(2).add("c_stringOperand2");			//parameter 2: 

		/*
			Before using this external function, you must create a customer
  			data base using the extdb_maint.pm program.
		 */
		output.add(new ArrayList());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).get(0).add("extdb");					//set external function name 
		output.get(output.size()-1).get(1).add("c_extdbFound");				//return type: 1 if key found, 0 if not found or other error
		
		output.get(output.size()-1).get(1).add("c_extdbFieldString1");		//return type: String
		output.get(output.size()-1).get(1).add("c_extdbFieldString2");		//return type: String
		output.get(output.size()-1).get(1).add("c_extdbFieldString3");		//return type: String
		output.get(output.size()-1).get(1).add("c_extdbFieldString4");		//return type: String
		output.get(output.size()-1).get(1).add("c_extdbFieldString5");		//return type: String
		output.get(output.size()-1).get(1).add("c_extdbFieldString6");		//return type: String
		output.get(output.size()-1).get(1).add("c_extdbFieldString7");		//return type: String
		output.get(output.size()-1).get(1).add("c_extdbFieldString8");		//return type: String
		output.get(output.size()-1).get(1).add("c_extdbFieldString9");		//return type: String
		output.get(output.size()-1).get(1).add("c_extdbFieldString10");		//return type: String
		output.get(output.size()-1).get(1).add("c_extdbFieldString11");		//return type: String
		output.get(output.size()-1).get(1).add("c_extdbFieldString12");		//return type: String
		output.get(output.size()-1).get(1).add("c_extdbFieldString13");		//return type: String
		output.get(output.size()-1).get(1).add("c_extdbFieldString14");		//return type: String
		output.get(output.size()-1).get(1).add("c_extdbFieldString15");		//return type: String
		output.get(output.size()-1).get(1).add("c_extdbFieldString16");		//return type: String
		output.get(output.size()-1).get(1).add("c_extdbFieldString17");		//return type: String
		output.get(output.size()-1).get(1).add("c_extdbFieldString18");		//return type: String
		output.get(output.size()-1).get(1).add("c_extdbFieldString19");		//return type: String
		output.get(output.size()-1).get(1).add("c_extdbFieldString20");		//return type: String
		output.get(output.size()-1).get(1).add("c_extdbFieldString21");		//return type: String
		output.get(output.size()-1).get(1).add("c_extdbFieldString22");		//return type: String
		output.get(output.size()-1).get(1).add("c_extdbFieldString23");		//return type: String
		output.get(output.size()-1).get(1).add("c_extdbFieldString24");		//return type: String
		output.get(output.size()-1).get(1).add("c_extdbFieldString25");		//return type: String
		output.get(output.size()-1).get(1).add("c_extdbFieldString26");		//return type: String
		output.get(output.size()-1).get(1).add("c_extdbFieldString27");		//return type: String
		output.get(output.size()-1).get(1).add("c_extdbFieldString28");		//return type: String
		output.get(output.size()-1).get(1).add("c_extdbFieldString29");		//return type: String
		output.get(output.size()-1).get(1).add("c_extdbFieldString30");		//return type: String
		output.get(output.size()-1).get(1).add("c_extdbFieldString31");		//return type: String
		output.get(output.size()-1).get(1).add("c_extdbFieldString32");		//return type: String
		output.get(output.size()-1).get(1).add("c_extdbFieldString33");		//return type: String
		output.get(output.size()-1).get(1).add("c_extdbFieldString34");		//return type: String
		output.get(output.size()-1).get(1).add("c_extdbFieldString35");		//return type: String
		output.get(output.size()-1).get(1).add("c_extdbFieldString36");		//return type: String
		output.get(output.size()-1).get(1).add("c_extdbFieldString37");		//return type: String
		output.get(output.size()-1).get(1).add("c_extdbFieldString38");		//return type: String
		output.get(output.size()-1).get(1).add("c_extdbFieldString39");		//return type: String
		output.get(output.size()-1).get(1).add("c_extdbFieldString40");		//return type: String
		
		output.get(output.size()-1).get(1).add("c_extdbFieldNumeric1");		//return type: Number
		output.get(output.size()-1).get(1).add("c_extdbFieldNumeric2");		//return type: Number
		output.get(output.size()-1).get(1).add("c_extdbFieldNumeric3");		//return type: Number
		output.get(output.size()-1).get(1).add("c_extdbFieldNumeric4");		//return type: Number
		output.get(output.size()-1).get(1).add("c_extdbFieldNumeric5");		//return type: Number
		output.get(output.size()-1).get(1).add("c_extdbFieldNumeric6");		//return type: Number
		output.get(output.size()-1).get(1).add("c_extdbFieldNumeric7");		//return type: Number
		output.get(output.size()-1).get(1).add("c_extdbFieldNumeric8");		//return type: Number
		output.get(output.size()-1).get(1).add("c_extdbFieldNumeric9");		//return type: Number
		output.get(output.size()-1).get(1).add("c_extdbFieldNumeric10");		//return type: Number
		output.get(output.size()-1).get(1).add("c_extdbFieldNumeric11");		//return type: Number
		output.get(output.size()-1).get(1).add("c_extdbFieldNumeric12");		//return type: Number
		output.get(output.size()-1).get(1).add("c_extdbFieldNumeric13");		//return type: Number
		output.get(output.size()-1).get(1).add("c_extdbFieldNumeric14");		//return type: Number
		output.get(output.size()-1).get(1).add("c_extdbFieldNumeric15");		//return type: Number
		output.get(output.size()-1).get(1).add("c_extdbFieldNumeric16");		//return type: Number
		output.get(output.size()-1).get(1).add("c_extdbFieldNumeric17");		//return type: Number
		output.get(output.size()-1).get(1).add("c_extdbFieldNumeric18");		//return type: Number
		output.get(output.size()-1).get(1).add("c_extdbFieldNumeric19");		//return type: Number
		output.get(output.size()-1).get(1).add("c_extdbFieldNumeric20");		//return type: Number
		output.get(output.size()-1).get(1).add("c_extdbFieldNumeric21");		//return type: Number
		output.get(output.size()-1).get(1).add("c_extdbFieldNumeric22");		//return type: Number
		output.get(output.size()-1).get(1).add("c_extdbFieldNumeric23");		//return type: Number
		output.get(output.size()-1).get(1).add("c_extdbFieldNumeric24");		//return type: Number
		output.get(output.size()-1).get(1).add("c_extdbFieldNumeric25");		//return type: Number
		output.get(output.size()-1).get(1).add("c_extdbFieldNumeric26");		//return type: Number
		output.get(output.size()-1).get(1).add("c_extdbFieldNumeric27");		//return type: Number
		output.get(output.size()-1).get(1).add("c_extdbFieldNumeric28");		//return type: Number
		output.get(output.size()-1).get(1).add("c_extdbFieldNumeric29");		//return type: Number
		output.get(output.size()-1).get(1).add("c_extdbFieldNumeric30");		//return type: Number
		output.get(output.size()-1).get(1).add("c_extdbFieldNumeric31");		//return type: Number
		output.get(output.size()-1).get(1).add("c_extdbFieldNumeric32");		//return type: Number
		output.get(output.size()-1).get(1).add("c_extdbFieldNumeric33");		//return type: Number
		output.get(output.size()-1).get(1).add("c_extdbFieldNumeric34");		//return type: Number
		output.get(output.size()-1).get(1).add("c_extdbFieldNumeric35");		//return type: Number
		output.get(output.size()-1).get(1).add("c_extdbFieldNumeric36");		//return type: Number
		output.get(output.size()-1).get(1).add("c_extdbFieldNumeric37");		//return type: Number
		output.get(output.size()-1).get(1).add("c_extdbFieldNumeric38");		//return type: Number
		output.get(output.size()-1).get(1).add("c_extdbFieldNumeric39");		//return type: Number
		output.get(output.size()-1).get(1).add("c_extdbFieldNumeric40");		//return type: Number
		
		/*
		 	These types use the instance field:
		    0 = retrieve first instance of the key (default)
		    1 = retrieve next instance of the key (next is equal to
		        instance specified by c_extdbInstance + 1)
		    2 = retrieve instance specified by value in c_extdbInstance
		
		    These types just do direct VOS keyed_position.
		    4 = equal
		    5 = greater/equal
		    6 = greater
		    7 = first
		    8 = last
		 */		
		output.get(output.size()-1).get(2).add("c_extdbOperator");			//parameter 1: 
		output.get(output.size()-1).get(2).add("c_extdbName");				//parameter 2: 
		output.get(output.size()-1).get(2).add("c_extdbKey");				//parameter 3: 
		output.get(output.size()-1).get(2).add("c_extdbInstance");			//parameter 4: 
		
		/*
			When invoked, this function sets a start CDR time field in the call record
  			to the current time.  See cdrEndTime.
		 */
		output.add(new ArrayList());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).get(0).add("cdrStartTime");			//set external function name 
		//output.get(output.size()-1).get(1).add("none");					//return type: 
		//output.get(output.size()-1).get(2).add("none");					//parameter 1: 
		
		/*
			When invoked, this function sets an end CDR time field in the call record
  			to the current time.  See cdrStartTime.
		 */
		output.add(new ArrayList());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).get(0).add("cdrEndTime");			//set external function name 
		//output.get(output.size()-1).get(1).add("none");					//return type:
		//output.get(output.size()-1).get(2).add("none");					//parameter 1: 
		
		/*
			This function allows you to set the c_dnisMarketPlace and c_cinMarketPlace
			variables to the appropriate enum value given a marketplace string as
			input.  For example, if the input was the market place "CCA",
			c_dnisMarketPlace and c_cinMarketPlace would be set to 1.
			
			If an invalid market string is supplied, the c_dnisMarketPlace and
			c_cinMarketPlace will be set to a default value of 1, which is
			the "CCA" market place.
		 */
		output.add(new ArrayList());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).add(new ArrayList<String>());
		output.get(output.size()-1).get(0).add("setMarketEnum");			//set external function name 
		output.get(output.size()-1).get(1).add("c_dnisMarketPlace");		//return type:
		output.get(output.size()-1).get(1).add("c_cinMarketPlace");			//return type:
		output.get(output.size()-1).get(2).add("c_stringOperand1");			//parameter 1: 
		
		return output;
	}
	
	public boolean VariableExists(String input, String section, String content)
	{
		boolean result = false;
		
		if(section.compareTo("[CALL_VARIABLES]") == 0)
		{
			result =  CallVariableExists(input, content);
		}
		else if(section.compareTo("[APPLICATION_VARIABLES]") == 0)
		{
			result = AppVariableExists(input, content);
		}
		else if(section.compareTo("[PROMPTS") == 0)
		{
			result = PromptVariableExists(input, content);
		}
		else
		{
			result = false;
		}
		
		return result;
	}
	
	//pivot: a list of c_ vars
	//pivot: a list of valid cell types
	
	//determine if a u_ or c_ var exists
	private boolean CallVariableExists(String input, String content) 
	{
		boolean result = false;
		int mode = 0;
		boolean seeking = true;
		boolean sectionFound = false;
		boolean errorFound = false;
		String SectionTitle = "[CALL_VARIABLES]";
		String NextSectionTitle = "[APPLICATION_VARIABLES]";
		int tracker = 0;
		int errorType = 0;
		String dataType = "";
		int dataStart = 0;

		// Start Position found
		int startIndex = 0;
		// End Position
		int endIndex = 1;

		char testChar = '0';

		// find start index of section
		// seek content from start to finish:
		for (; tracker < content.length(); tracker++) 
		{
			if (content.charAt(tracker) == '\n') 
			{
			}
			// find "[CALL_VARIABLES]"
			// if not too far in the string
			if (tracker < content.length() - SectionTitle.length()) 
			{
				// if "[CALL_VARIABLES]" is found
				if (content.substring(tracker,
						(tracker + SectionTitle.length())).compareTo(SectionTitle) == 0) 
				{
					sectionFound = true;
					tracker += SectionTitle.length();
					break;
				} else 
				{
					return false; // fail
				}
			}
		}

		if (sectionFound) 
		{
			// search from start to last
			for (; tracker < content.length(); tracker++) 
			{
				// find "[APPLICATION_VARIABLES]"
				// if not too far in the string
				if (tracker < content.length() - NextSectionTitle.length()) 
				{
					// if "[APPLICATION_VARIABLES]" is found
					if (content.substring(tracker,
							(tracker + NextSectionTitle.length())).compareTo(NextSectionTitle) == 0) 
					{
						return false; // fail
					}

					if (seeking) 
					{
						if (content.charAt(tracker) == ' ' || content.charAt(tracker) == '\n') 
						{
							// do nothing, let for loop advance
							if (content.charAt(tracker) == '\n') 
							{
							}
						}
						// identify comment indicators
						else if (content.charAt(tracker) == ';') 
						{
							// turn off seeking unless appropriate end comment
							// is found
							seeking = false; // turn off seeking
							mode = 1; // single line comment mode
						}
						// identify comment indicators
						else if (content.charAt(tracker) == '/' && (tracker != content.length() - 1)) 
						{
							if (content.charAt(tracker + 1) == '*') 
							{
								// turn off seeking unless appropriate end
								// comment is found
								seeking = false; // turn off seeking
								mode = 2; // multi-line comment mode
								tracker++; // we know what x+1 is, and don't
											// care
							}
						} 
						else // not a comment
						{
							seeking = false; // turn off seeking
							mode = 3; // not a comment mode
						}
					} 
					else 
					{
						if (mode == 1) // single line comment mode
						{
							if (content.charAt(tracker) == '\n')// && x !=
																// content.length())
							{
								mode = 0; // reset mode
								seeking = true; // turn seeking back on
							} 
							else if (tracker == content.length() - 1) 
							{
							}
						} 
						else if (mode == 2) // multi-line comment mode
						{
							if (content.charAt(tracker) == '*' && (tracker != content.length() - 1)) 
							{
								if (content.charAt(tracker + 1) == '/') 
								{
									mode = 0; // reset mode
									seeking = true; // turn seeking back on
								}
							} 
							else if (tracker == content.length() - 1) 
							{
							}
						} 
						else if (mode == 3) // not a comment mode
						{
							if ((content.charAt(tracker) == ' ') || (content.charAt(tracker) == '\n') || (tracker == content.length() - 1))
							{
								// do nothing
							} else 
							{
								// if word
								// ensure non-comment fits section format
								// line begins with "c_" or "u_"
								if ((content.charAt(tracker) == 'c') || (content.charAt(tracker) == 'u')) 
								{
									startIndex = tracker;

									if (tracker < content.length() - 1) // not on last character in file
									{
										if ((content.charAt(tracker + 1) == '_')) 
										{

											// find end of word
											endIndex = findEndOfWord(startIndex, content);

											// compare to input
											if ((content.substring(startIndex,endIndex).compareTo(input) == 0)) 
											{
												// success: return true
												return true;
											}
											// fail: continue
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return result;
	}
	//determine if a u_ or c_ var exists
	public boolean CallVariableIsDuplicate(String input, int InputStartIndex, int InputEndIndex, String content) 
	{
		boolean result = false;
		int mode = 0;
		boolean seeking = true;
		boolean sectionFound = false;
		boolean errorFound = false;
		String SectionTitle = "[CALL_VARIABLES]";
		String NextSectionTitle = "[APPLICATION_VARIABLES]";
		int tracker = 0;
		int errorType = 0;
		String dataType = "";
		int dataStart = 0;

		// Start Position found
		int startIndex = 0;
		// End Position
		int endIndex = 1;

		char testChar = '0';
		String potentialWord = "";

		// find start index of section
		// seek content from start to finish:
		for (; tracker < content.length(); tracker++) 
		{
			if (content.charAt(tracker) == '\n') 
			{
			}
			// find "[CALL_VARIABLES]"
			// if not too far in the string
			if (tracker < content.length() - SectionTitle.length()) 
			{
				// if "[CALL_VARIABLES]" is found
				if (content.substring(tracker,(tracker + SectionTitle.length())).compareTo(SectionTitle) == 0) 
				{
					sectionFound = true;
					tracker += SectionTitle.length();
					break;
				} 
				/*
				else 
				{
					return false; // fail
				}
				*/
			}
		}

		if (sectionFound) 
		{
			// search from start to last
			for (; tracker < content.length(); tracker++) 
			{
				// find "[APPLICATION_VARIABLES]"
				// if not too far in the string
				if (tracker < content.length() - NextSectionTitle.length()) 
				{
					// if "[APPLICATION_VARIABLES]" is found
					if (content.substring(tracker,(tracker + NextSectionTitle.length())).compareTo(NextSectionTitle) == 0) 
					{
						return false; // fail
					}

					if (seeking) 
					{
						if (content.charAt(tracker) == ' ' || content.charAt(tracker) == '\n') 
						{
							// do nothing, let for loop advance
							if (content.charAt(tracker) == '\n') 
							{
							}
						}
						// identify comment indicators
						else if (content.charAt(tracker) == ';') 
						{
							// turn off seeking unless appropriate end comment
							// is found
							seeking = false; // turn off seeking
							mode = 1; // single line comment mode
						}
						// identify comment indicators
						else if (content.charAt(tracker) == '/' && (tracker != content.length() - 1)) 
						{
							if (content.charAt(tracker + 1) == '*') 
							{
								// turn off seeking unless appropriate end
								// comment is found
								seeking = false; // turn off seeking
								mode = 2; // multi-line comment mode
								tracker++; // we know what x+1 is, and don't
											// care
							}
						} 
						else // not a comment
						{
							seeking = false; // turn off seeking
							mode = 3; // not a comment mode
						}
					} 
					//else 
					{
						if (mode == 1) // single line comment mode
						{
							if (content.charAt(tracker) == '\n')// && x !=
																// content.length())
							{
								mode = 0; // reset mode
								seeking = true; // turn seeking back on
							} 
							else if (tracker == content.length() - 1) 
							{
							}
						} 
						else if (mode == 2) // multi-line comment mode
						{
							if (content.charAt(tracker) == '*' && (tracker != content.length() - 1)) 
							{
								if (content.charAt(tracker + 1) == '/') 
								{
									mode = 0; // reset mode
									seeking = true; // turn seeking back on
								}
							} 
							else if (tracker == content.length() - 1) 
							{
							}
						} 
						else if (mode == 3) // not a comment mode
						{
							if ((content.charAt(tracker) == ' ') || (content.charAt(tracker) == '\n') || (tracker == content.length() - 1))
							{
								// do nothing
							} 
							else 
							{
								// if word
								// ensure non-comment fits section format
								// line begins with "c_" or "u_"
								if ((content.charAt(tracker) == 'c') || (content.charAt(tracker) == 'u')) 
								{
									startIndex = tracker;

									if (tracker < content.length() - 1) // not on last character in file
									{
										if ((content.charAt(tracker + 1) == '_')) 
										{

											// find end of word
											endIndex = findEndOfWordNoCommas(startIndex, content);
											potentialWord = (content.substring(startIndex,endIndex));
											
											// compare to input
											if (potentialWord.compareTo(input) == 0)
											{
												//if not referring to the exact input string
												if((startIndex != InputStartIndex) && (endIndex != InputEndIndex))
												{
													// success: return true
													return true;
												}
											}
											// fail: continue
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return result;
	}
	//determine if an a_var exists
	private boolean AppVariableExists(String input, String content)
	{
		boolean result = false;
		int mode = 0;
		boolean seeking = true;
		boolean sectionFound = false;
		boolean errorFound = false;
		String SectionTitle = "[APPLICATION_VARIABLES]";
		String NextSectionTitle = "";
		int tracker = 0;
		int errorType = 0;
		String dataType = "";
		int dataStart = 0;

		// Start Position found
		int startIndex = 0;
		// End Position
		int endIndex = 1;

		char testChar = '0';

		// find start index of section
		// seek content from start to finish:
		for (; tracker < content.length(); tracker++) 
		{
			if (content.charAt(tracker) == '\n') 
			{
			}
			// find "[APPLICATION_VARIABLES]"
			// if not too far in the string
			if (tracker < content.length() - SectionTitle.length()) 
			{
				// if "[APPLICATION_VARIABLES]" is found
				if (content.substring(tracker, (tracker + SectionTitle.length())).compareTo(SectionTitle) == 0) 
				{
					sectionFound = true;
					tracker += SectionTitle.length();
					break;
				} else 
				{
					return false; // fail
				}
			}
		}

		if (sectionFound) 
		{
			//set NextSectionTitle as "starting cell name"
			NextSectionTitle = FindStartCellName(content);
			
			if( NextSectionTitle.compareTo("(-1)") != 0)
			{
				NextSectionTitle = FindStartCell(NextSectionTitle,content);
			}
			
			if( NextSectionTitle.compareTo("(-1)") == 0)
			{
				return false; //fail
			}
			
			// search from start to last
			for (; tracker < content.length(); tracker++) 
			{
				// find "start of app"
				// if not too far in the string
				if (tracker < content.length() - NextSectionTitle.length()) 
				{
					// if "start of app" is found
					if (content.substring(tracker,
							(tracker + NextSectionTitle.length())).compareTo(NextSectionTitle) == 0) 
					{
						return false; // fail
					}

					if (seeking) 
					{
						if (content.charAt(tracker) == ' ' || content.charAt(tracker) == '\n') 
						{
							// do nothing, let for loop advance
							if (content.charAt(tracker) == '\n') 
							{
							}
						}
						// identify comment indicators
						else if (content.charAt(tracker) == ';') 
						{
							// turn off seeking unless appropriate end comment
							// is found
							seeking = false; // turn off seeking
							mode = 1; // single line comment mode
						}
						// identify comment indicators
						else if (content.charAt(tracker) == '/' && (tracker != content.length() - 1)) 
						{
							if (content.charAt(tracker + 1) == '*') 
							{
								// turn off seeking unless appropriate end
								// comment is found
								seeking = false; // turn off seeking
								mode = 2; // multi-line comment mode
								tracker++; // we know what x+1 is, and don't
											// care
							}
						} 
						else // not a comment
						{
							seeking = false; // turn off seeking
							mode = 3; // not a comment mode
						}
					} 
					else 
					{
						if (mode == 1) // single line comment mode
						{
							if (content.charAt(tracker) == '\n')// && x !=
																// content.length())
							{
								mode = 0; // reset mode
								seeking = true; // turn seeking back on
							} 
							else if (tracker == content.length() - 1) 
							{
							}
						} 
						else if (mode == 2) // multi-line comment mode
						{
							if (content.charAt(tracker) == '*' && (tracker != content.length() - 1)) 
							{
								if (content.charAt(tracker + 1) == '/') 
								{
									mode = 0; // reset mode
									seeking = true; // turn seeking back on
								}
							} 
							else if (tracker == content.length() - 1) 
							{
							}
						} 
						else if (mode == 3) // not a comment mode
						{
							if ((content.charAt(tracker) == ' ') || (content.charAt(tracker) == '\n') || (tracker == content.length() - 1))
							{
								// do nothing
							} else 
							{
								// if word
								// ensure non-comment fits section format
								// line begins with "a_"
								if ((content.charAt(tracker) == 'a')) 
								{
									startIndex = tracker;

									if (tracker < content.length() - 1) // not on last character in file
									{
										if ((content.charAt(tracker + 1) == '_')) 
										{
											// find end of word
											endIndex = findEndOfWord(startIndex, content);

											// compare to input
											if ((content.substring(startIndex,endIndex).compareTo(input) == 0)) 
											{
												// success: return true
												return true;
											}
											// fail: continue
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return result;
	}
	//determine if an a_var exists
	public boolean AppVariableIsDuplicate(String input, int InputStartIndex, int InputEndIndex,  String content)
	{
		boolean result = false;
		int mode = 0;
		boolean seeking = true;
		boolean sectionFound = false;
		boolean errorFound = false;
		String SectionTitle = "[APPLICATION_VARIABLES]";
		String NextSectionTitle = "";
		int tracker = 0;
		int errorType = 0;
		String dataType = "";
		int dataStart = 0;

		// Start Position found
		int startIndex = 0;
		// End Position
		int endIndex = 1;

		char testChar = '0';
		String potentialWord = "";

		// find start index of section
		// seek content from start to finish:
		for (; tracker < content.length(); tracker++) 
		{
			if (content.charAt(tracker) == '\n') 
			{
			}
			// find "[APPLICATION_VARIABLES]"
			// if not too far in the string
			if (tracker < content.length() - SectionTitle.length()) 
			{
				// if "[APPLICATION_VARIABLES]" is found
				if (content.substring(tracker, (tracker + SectionTitle.length())).compareTo(SectionTitle) == 0) 
				{
					sectionFound = true;
					tracker += SectionTitle.length();
					break;
				} 
				/*
				else 
				{
					return false; // fail
				}
				*/
			}
		}

		if (sectionFound) 
		{
			//set NextSectionTitle as "starting cell name"
			NextSectionTitle = FindStartCellName(content);
			
			if( NextSectionTitle.compareTo("(-1)") != 0)
			{
				NextSectionTitle = FindStartCell(NextSectionTitle,content);
			}
			
			if( NextSectionTitle.compareTo("(-1)") == 0)
			{
				return false; //fail
			}
			
			// search from start to last
			for (; tracker < content.length(); tracker++) 
			{
				// find "start of app"
				// if not too far in the string
				if (tracker < content.length() - NextSectionTitle.length()) 
				{
					// if "start of app" is found
					if (content.substring(tracker,
							(tracker + NextSectionTitle.length())).compareTo(NextSectionTitle) == 0) 
					{
						return false; // fail
					}

					if (seeking) 
					{
						if (content.charAt(tracker) == ' ' || content.charAt(tracker) == '\n') 
						{
							// do nothing, let for loop advance
							if (content.charAt(tracker) == '\n') 
							{
							}
						}
						// identify comment indicators
						else if (content.charAt(tracker) == ';') 
						{
							// turn off seeking unless appropriate end comment
							// is found
							seeking = false; // turn off seeking
							mode = 1; // single line comment mode
						}
						// identify comment indicators
						else if (content.charAt(tracker) == '/' && (tracker != content.length() - 1)) 
						{
							if (content.charAt(tracker + 1) == '*') 
							{
								// turn off seeking unless appropriate end
								// comment is found
								seeking = false; // turn off seeking
								mode = 2; // multi-line comment mode
								tracker++; // we know what x+1 is, and don't
											// care
							}
						} 
						else // not a comment
						{
							seeking = false; // turn off seeking
							mode = 3; // not a comment mode
						}
					} 
					//else 
					{
						if (mode == 1) // single line comment mode
						{
							if (content.charAt(tracker) == '\n')// && x !=
																// content.length())
							{
								mode = 0; // reset mode
								seeking = true; // turn seeking back on
							} 
							else if (tracker == content.length() - 1) 
							{
							}
						} 
						else if (mode == 2) // multi-line comment mode
						{
							if (content.charAt(tracker) == '*' && (tracker != content.length() - 1)) 
							{
								if (content.charAt(tracker + 1) == '/') 
								{
									mode = 0; // reset mode
									seeking = true; // turn seeking back on
								}
							} 
							else if (tracker == content.length() - 1) 
							{
							}
						} 
						else if (mode == 3) // not a comment mode
						{
							if ((content.charAt(tracker) == ' ') || (content.charAt(tracker) == '\n') || (tracker == content.length() - 1))
							{
								// do nothing
							} 
							else 
							{
								// if word
								// ensure non-comment fits section format
								// line begins with "a_"
								if ((content.charAt(tracker) == 'a')) 
								{
									startIndex = tracker;

									if (tracker < content.length() - 1) // not on last character in file
									{
										if ((content.charAt(tracker + 1) == '_')) 
										{
											// find end of word
											endIndex = findEndOfWordNoCommas(startIndex, content);
											potentialWord = (content.substring(startIndex,endIndex));
											
											// compare to input
											if (potentialWord.compareTo(input) == 0)
											{
												//if not referring to the exact input string
												if((startIndex != InputStartIndex) && (endIndex != InputEndIndex))
												{
													// success: return true
													return true;
												}
											}
											// fail: continue
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return result;
	}
	/*
	//determine if a prompt exists (pivot: in all prompt sections?)
	private boolean PromptVariableExists(String input, String content)
	{
		boolean result = false;
		

		//find start index of section [PROMPTS
		
		//find start index of next section [DIGIT_PROMPTS
		
		//identify how many prompts sections there are
		
		//search from start to last
			//skip line if: return, comment
			//skip character if: space
			//if word
				//find end of word
				//compare to input
					//success: record count of var
					//fail: continue
		
		//count must equal number of prompt sections to pass
		
		return result;
	}
*/	
	//determine if an pr_var exists
	private boolean PromptVariableExists(String input, String content)
	{
		boolean result = false;
		
		ArrayList<Boolean> compositeResult = new ArrayList<Boolean>();
		
		int promptCounter = 0;
		
		int mode = 0;
		boolean seeking = true;
		boolean sectionFound = false;

		String SectionTitle = "[PROMPTS";
		String NextSectionTitle = "[DIGIT_PROMPTS";
		int tracker = 0;
		
		// Start Position found
		int startIndex = 0;
		// End Position
		int endIndex = 1;
		
		String potentialWord = "";

		
		// find start index of section
		// seek content from start to finish:
		for (; tracker < content.length(); tracker++) 
		{
			if (content.charAt(tracker) == '\n') 
			{
			}
			// find "[PROMPTS"
			// if not too far in the string
			if (tracker < content.length() - SectionTitle.length()) 
			{
				// if "[PROMPTS" is found
				if (content.substring(tracker, (tracker + SectionTitle.length())).compareTo(SectionTitle) == 0) 
				{
					sectionFound = true;
					tracker += SectionTitle.length();
					break;
				} 
				else 
				{
					return false; // fail
				}
			}
		}

		if (sectionFound) 
		{
			// search from start to last
			for (; tracker < content.length(); tracker++) 
			{
				// if not too far in the string
				if (tracker < content.length() - NextSectionTitle.length()) 
				{
					// if Digit Prompts section is found
					if (content.substring(tracker,(tracker + NextSectionTitle.length())).compareTo(NextSectionTitle) == 0) 
					{
						for(int x = 0; x < compositeResult.size(); x++)
						{
							if(compositeResult.get(x) == false)
							{
								return false; // fail
							}
						}
						return true;
					}

					// if new prompts section  is found
					if (content.substring(tracker,(tracker + SectionTitle.length())).compareTo(SectionTitle) == 0) 
					{
						//if no result was loaded
						if(compositeResult.size() == promptCounter)
						{
							//there was no target prompt found in the last section
							compositeResult.add(false);
						}
						//move onto tracking next prompts section
						promptCounter++;
					}


					if (seeking) 
					{
						if (content.charAt(tracker) == ' ' || content.charAt(tracker) == '\n') 
						{
							// do nothing, let for loop advance
							if (content.charAt(tracker) == '\n') 
							{
							}
						}
						// identify comment indicators
						else if (content.charAt(tracker) == ';') 
						{
							// turn off seeking unless appropriate end comment
							// is found
							seeking = false; // turn off seeking
							mode = 1; // single line comment mode
						}
						// identify comment indicators
						else if (content.charAt(tracker) == '/' && (tracker != content.length() - 1)) 
						{
							if (content.charAt(tracker + 1) == '*') 
							{
								// turn off seeking unless appropriate end
								// comment is found
								seeking = false; // turn off seeking
								mode = 2; // multi-line comment mode
								tracker++; // we know what x+1 is, and don't
											// care
							}
						} 
						else // not a comment
						{
							seeking = false; // turn off seeking
							mode = 3; // not a comment mode
						}
					} 
					else 
					{
						if (mode == 1) // single line comment mode
						{
							if (content.charAt(tracker) == '\n')// && x !=
																// content.length())
							{
								mode = 0; // reset mode
								seeking = true; // turn seeking back on
							} 
							else if (tracker == content.length() - 1) 
							{
							}
						} 
						else if (mode == 2) // multi-line comment mode
						{
							if (content.charAt(tracker) == '*' && (tracker != content.length() - 1)) 
							{
								if (content.charAt(tracker + 1) == '/') 
								{
									mode = 0; // reset mode
									seeking = true; // turn seeking back on
								}
							} 
							else if (tracker == content.length() - 1) 
							{
							}
						} 
						else if (mode == 3) // not a comment mode
						{
							if ((content.charAt(tracker) == ' ') || (content.charAt(tracker) == '\n') || (tracker == content.length() - 1))
							{
								// do nothing
							} else 
							{
								// if word
								// ensure non-comment fits section format
								// line begins with "pr_"
								if ((content.substring(tracker,(tracker+1)).compareTo("pr") == 0)) 
								{
									startIndex = tracker;

									if (tracker < content.length() - 2) // not on last character in file
									{
										if ((content.charAt(tracker + 2) == '_')) 
										{
											// find end of word
											endIndex = findEndOfWord(startIndex, content);
											potentialWord = (content.substring(startIndex,endIndex));
											
											// compare to input
											if (potentialWord.compareTo(input) == 0) 
											{
												// success: add result
												compositeResult.add(true);
											}
											// fail: continue
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return result;
	}
	
	public boolean IsApprovedCellType(String input)
	{
		boolean result = false;
		
		for(int x = 0; x < MasterCellTypeList.size(); x++)
		{
			if(MasterCellTypeList.get(x).compareTo(input) == 0)
			{
				result = true;
				break;
			}
		}
		
		return result;
	}
	
	public boolean IsApprovedCellName(String input)
	{
		boolean result = true;
		
		
		for(int x = 0; x < input.length(); x++)
		{
			if( (input.charAt(x) == '^') || (input.charAt(x) == '&') || (input.charAt(x) == '?') || (input.charAt(x) == '\'') )
			{
				return false;
			}
		}
		//Valid characters: ~!@#$%*()-_=+,<.>/:"\|
		//Bad characters: ^&?'
		
		
		return result;		
	}
	
	public boolean IsApprovedCellVariable(String input)
	{
		boolean result = false;
		
		for(int x = 0; x < MasterCellVariableList.size(); x++)
		{
			if(MasterCellVariableList.get(x).get(0).compareTo(input) == 0)
			{
				result = true;
				break;
			}
		}
		
		return result;
	}
	
	public boolean IsApprovedCellFunction(String input)
	{
		boolean result = false;
		
		for(int x = 0; x < MasterCellFunctionList.size(); x++)
		{
			if(MasterCellFunctionList.get(x).get(0).compareTo(input) == 0)
			{
				result = true;
				break;
			}
		}
		
		return result;
	}
	
	public boolean IsApprovedExternalFunction(String input)
	{
		boolean result = false;
		
		for(int x = 0; x < MasterExternalFunctionList.size(); x++)
		{
			if(MasterExternalFunctionList.get(x).get(0).get(0).compareTo(input) == 0)
			{
				result = true;
				break;
			}
		}
		
		return result;
	}
	
	
	public boolean CallVariableInCode(String input, String content)
	{
		boolean result = false;
		
		int mode = 0;
		boolean seeking = true;
		boolean sectionFound = false;

		String SectionTitle = "";
		String NextSectionTitle = "[PROMPTS";
		int tracker = 0;
		
		// Start Position found
		int startIndex = 0;
		// End Position
		int endIndex = 1;
		
		String potentialWord = "";
		
		
		//find start cell name
		
		//set SectionTitle as "starting cell name"
		SectionTitle = FindStartCellName(content);
		
		if( SectionTitle.compareTo("(-1)") != 0)
		{
			SectionTitle = FindStartCell(SectionTitle,content);
		}
		
		if( SectionTitle.compareTo("(-1)") == 0)
		{
			return false; //fail
		}
		
		// find start index of section
		// seek content from start to finish:
		for (; tracker < content.length(); tracker++) 
		{
			if (content.charAt(tracker) == '\n') 
			{
			}
			// find start cell
			// if not too far in the string
			if (tracker < content.length() - SectionTitle.length()) 
			{
				// if start cell is found
				if (content.substring(tracker, (tracker + SectionTitle.length())).compareTo(SectionTitle) == 0) 
				{
					tracker += SectionTitle.length();
					tracker ++; //skip assumed space
					
					sectionFound = true;
					break;
					
				} 
				/*
				else 
				{
					return false; // fail
				}
				*/
			}
		}

		if (sectionFound) 
		{
			// search from start to last
			for (; tracker < content.length(); tracker++) 
			{
				// if not too far in the string
				if (tracker < content.length() - NextSectionTitle.length()) 
				{
					// if Prompts section is found
					potentialWord = content.substring(tracker,(tracker + NextSectionTitle.length()));
					if (potentialWord.compareTo(NextSectionTitle) == 0) 
					{
						return false; //reach end with no duplicates
					}

					potentialWord = content.substring(tracker,(tracker + SectionTitle.length()));
					// if new prompts section  is found
					if (potentialWord.compareTo(SectionTitle) == 0) 
					{
						return false; //reach end with no duplicates
					}


					if (seeking) 
					{
						if (content.charAt(tracker) == ' ' || content.charAt(tracker) == '\n') 
						{
							// do nothing, let for loop advance
							if (content.charAt(tracker) == '\n') 
							{
							}
						}
						// identify comment indicators
						else if (content.charAt(tracker) == ';') 
						 {
							// turn off seeking unless appropriate end comment
							// is found
							seeking = false; // turn off seeking
							mode = 1; // single line comment mode
							tracker = findEndOfLine(tracker, content); //skip to end of line
						}
						// identify comment indicators
						else if (content.charAt(tracker) == '/' && (tracker != content.length() - 1)) 
						{
							if (content.charAt(tracker + 1) == '*') 
							{
								// turn off seeking unless appropriate end
								// comment is found
								seeking = false; // turn off seeking
								mode = 2; // multi-line comment mode
								//tracker++; // we know what x+1 is, and don't care
								tracker = findEndOfLine(tracker, content); //skip to end of line
							}
						} 
						else // not a comment
						{
							seeking = false; // turn off seeking
							mode = 3; // not a comment mode
						}
					} 
	
					if (mode == 1) // single line comment mode
					{
						if (content.charAt(tracker) == '\n')// && x !=
															// content.length())
						{
							mode = 0; // reset mode
							seeking = true; // turn seeking back on
						} 
						else if (tracker == content.length() - 1) 
						{
						}
					} 
					else if (mode == 2) // multi-line comment mode
					{
						if (content.charAt(tracker) == '*' && (tracker != content.length() - 1)) 
						{
							if (content.charAt(tracker + 1) == '/') 
							{
								mode = 0; // reset mode
								seeking = true; // turn seeking back on
							}
						} 
						else if (tracker == content.length() - 1) 
						{
						}
					} 
					else if (mode == 3) // not a comment mode
					{
						if ((content.charAt(tracker) == ' ') || (content.charAt(tracker) == '\n') || (tracker == content.length() - 1))
						{
							// do nothing
						} 
						else 
						{
							// if word
							// ensure non-comment fits section format
							// line begins with "c" or "u"
							potentialWord = (content.substring(tracker,(tracker+2)));
							if ((potentialWord.compareTo("c") == 0) || (potentialWord.compareTo("u") == 0)) 
							{
								startIndex = tracker;

								if (tracker < content.length() - 2) // not on last character in file
								{
									if ((content.charAt(tracker + 1) == '_')) 
									{
										// find end of word
										endIndex = findEndOfWord(startIndex, content);
										potentialWord = (content.substring(startIndex,endIndex));
										
										// compare to input
										if (potentialWord.compareTo(input) == 0) 
										{
											
											// success: return true
											return true;
											
										}
										// fail: continue
									}
								}
							}
						}
					}	
				}
			}
		}
		return result;
	}
	
	public boolean ApplicationVariableInCode(String input, String content)
	{
		boolean result = false;
		
		int mode = 0;
		boolean seeking = true;
		boolean sectionFound = false;

		String SectionTitle = "";
		String NextSectionTitle = "[PROMPTS";
		int tracker = 0;
		
		// Start Position found
		int startIndex = 0;
		// End Position
		int endIndex = 1;
		
		String potentialWord = "";
		
		
		//find start cell name
		
		//set SectionTitle as "starting cell name"
		SectionTitle = FindStartCellName(content);
		
		if( SectionTitle.compareTo("(-1)") != 0)
		{
			SectionTitle = FindStartCell(SectionTitle,content);
		}
		
		if( SectionTitle.compareTo("(-1)") == 0)
		{
			return false; //fail
		}
		
		// find start index of section
		// seek content from start to finish:
		for (; tracker < content.length(); tracker++) 
		{
			if (content.charAt(tracker) == '\n') 
			{
			}
			// find start cell
			// if not too far in the string
			if (tracker < content.length() - SectionTitle.length()) 
			{
				// if start cell is found
				if (content.substring(tracker, (tracker + SectionTitle.length())).compareTo(SectionTitle) == 0) 
				{
					tracker += SectionTitle.length();
					tracker ++; //skip assumed space
					
					sectionFound = true;
					break;
					
				} 
				/*
				else 
				{
					return false; // fail
				}
				*/
			}
		}

		if (sectionFound) 
		{
			// search from start to last
			for (; tracker < content.length(); tracker++) 
			{
				// if not too far in the string
				if (tracker < content.length() - NextSectionTitle.length()) 
				{
					// if Digit Prompts section is found
					potentialWord = content.substring(tracker,(tracker + NextSectionTitle.length()));
					if (potentialWord.compareTo(NextSectionTitle) == 0) 
					{
						return false; //reach end with no duplicates
					}

					potentialWord = content.substring(tracker,(tracker + SectionTitle.length()));
					// if new prompts section  is found
					if (potentialWord.compareTo(SectionTitle) == 0) 
					{
						return false; //reach end with no duplicates
					}


					if (seeking) 
					{
						if (content.charAt(tracker) == ' ' || content.charAt(tracker) == '\n') 
						{
							// do nothing, let for loop advance
							if (content.charAt(tracker) == '\n') 
							{
							}
						}
						// identify comment indicators
						else if (content.charAt(tracker) == ';') 
						 {
							// turn off seeking unless appropriate end comment
							// is found
							seeking = false; // turn off seeking
							mode = 1; // single line comment mode
						}
						// identify comment indicators
						else if (content.charAt(tracker) == '/' && (tracker != content.length() - 1)) 
						{
							if (content.charAt(tracker + 1) == '*') 
							{
								// turn off seeking unless appropriate end
								// comment is found
								seeking = false; // turn off seeking
								mode = 2; // multi-line comment mode
								tracker++; // we know what x+1 is, and don't
											// care
							}
						} 
						else // not a comment
						{
							seeking = false; // turn off seeking
							mode = 3; // not a comment mode
						}
					} 
					//else 
					{
						if (mode == 1) // single line comment mode
						{
							if (content.charAt(tracker) == '\n')// && x !=
																// content.length())
							{
								mode = 0; // reset mode
								seeking = true; // turn seeking back on
							} 
							else if (tracker == content.length() - 1) 
							{
							}
						} 
						else if (mode == 2) // multi-line comment mode
						{
							if (content.charAt(tracker) == '*' && (tracker != content.length() - 1)) 
							{
								if (content.charAt(tracker + 1) == '/') 
								{
									mode = 0; // reset mode
									seeking = true; // turn seeking back on
								}
							} 
							else if (tracker == content.length() - 1) 
							{
							}
						} 
						else if (mode == 3) // not a comment mode
						{
							if ((content.charAt(tracker) == ' ') || (content.charAt(tracker) == '\n') || (tracker == content.length() - 1))
							{
								// do nothing
							} 
							else 
							{
								// if word
								// ensure non-comment fits section format
								// line begins with "a_"
								potentialWord = (content.substring(tracker,(tracker+2)));
								if (potentialWord.compareTo("a") == 0) 
								{
									startIndex = tracker;

									if (tracker < content.length() - 2) // not on last character in file
									{
										if ((content.charAt(tracker + 1) == '_')) 
										{
											// find end of word
											endIndex = findEndOfWord(startIndex, content);
											potentialWord = (content.substring(startIndex,endIndex));
											
											// compare to input
											if (potentialWord.compareTo(input) == 0) 
											{
												
												// success: return true
												return true;
												
											}
											// fail: continue
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return result;
	}
	
	public boolean PromptVariableInCode(String input, String content)
	{
		boolean result = false;
		
		int mode = 0;
		boolean seeking = true;
		boolean sectionFound = false;

		String SectionTitle = "";
		String NextSectionTitle = "[PROMPTS";
		int tracker = 0;
		
		// Start Position found
		int startIndex = 0;
		// End Position
		int endIndex = 1;
		
		String potentialWord = "";
		
		
		//find start cell name
		
		//set SectionTitle as "starting cell name"
		SectionTitle = FindStartCellName(content);
		
		if( SectionTitle.compareTo("(-1)") != 0)
		{
			SectionTitle = FindStartCell(SectionTitle,content);
		}
		
		if( SectionTitle.compareTo("(-1)") == 0)
		{
			return false; //fail
		}
		
		// find start index of section
		// seek content from start to finish:
		for (; tracker < content.length(); tracker++) 
		{
			if (content.charAt(tracker) == '\n') 
			{
			}
			// find start cell
			// if not too far in the string
			if (tracker < content.length() - SectionTitle.length()) 
			{
				// if start cell is found
				if (content.substring(tracker, (tracker + SectionTitle.length())).compareTo(SectionTitle) == 0) 
				{
					tracker += SectionTitle.length();
					tracker ++; //skip assumed space
					
					sectionFound = true;
					break;
					
				} 
				/*
				else 
				{
					return false; // fail
				}
				*/
			}
		}

		if (sectionFound) 
		{
			// search from start to last
			for (; tracker < content.length(); tracker++) 
			{
				// if not too far in the string
				if (tracker < content.length() - NextSectionTitle.length()) 
				{
					// if Digit Prompts section is found
					potentialWord = content.substring(tracker,(tracker + NextSectionTitle.length()));
					if (potentialWord.compareTo(NextSectionTitle) == 0) 
					{
						return false; //reach end with no duplicates
					}

					potentialWord = content.substring(tracker,(tracker + SectionTitle.length()));
					// if new prompts section  is found
					if (potentialWord.compareTo(SectionTitle) == 0) 
					{
						return false; //reach end with no duplicates
					}


					if (seeking) 
					{
						if (content.charAt(tracker) == ' ' || content.charAt(tracker) == '\n') 
						{
							// do nothing, let for loop advance
							if (content.charAt(tracker) == '\n') 
							{
							}
						}
						// identify comment indicators
						else if (content.charAt(tracker) == ';') 
						 {
							// turn off seeking unless appropriate end comment
							// is found
							seeking = false; // turn off seeking
							mode = 1; // single line comment mode
						}
						// identify comment indicators
						else if (content.charAt(tracker) == '/' && (tracker != content.length() - 1)) 
						{
							if (content.charAt(tracker + 1) == '*') 
							{
								// turn off seeking unless appropriate end
								// comment is found
								seeking = false; // turn off seeking
								mode = 2; // multi-line comment mode
								tracker++; // we know what x+1 is, and don't
											// care
							}
						} 
						else // not a comment
						{
							seeking = false; // turn off seeking
							mode = 3; // not a comment mode
						}
					} 
					//else 
					{
						if (mode == 1) // single line comment mode
						{
							if (content.charAt(tracker) == '\n')// && x !=
																// content.length())
							{
								mode = 0; // reset mode
								seeking = true; // turn seeking back on
							} 
							else if (tracker == content.length() - 1) 
							{
							}
						} 
						else if (mode == 2) // multi-line comment mode
						{
							if (content.charAt(tracker) == '*' && (tracker != content.length() - 1)) 
							{
								if (content.charAt(tracker + 1) == '/') 
								{
									mode = 0; // reset mode
									seeking = true; // turn seeking back on
								}
							} 
							else if (tracker == content.length() - 1) 
							{
							}
						} 
						else if (mode == 3) // not a comment mode
						{
							if ((content.charAt(tracker) == ' ') || (content.charAt(tracker) == '\n') || (tracker == content.length() - 1))
							{
								// do nothing
							} 
							else 
							{
								// if word
								// ensure non-comment fits section format
								// line begins with "pr_"
								potentialWord = (content.substring(tracker,(tracker+2)));
								if (potentialWord.compareTo("pr") == 0) 
								{
									startIndex = tracker;

									if (tracker < content.length() - 2) // not on last character in file
									{
										if ((content.charAt(tracker + 2) == '_')) 
										{
											// find end of word
											endIndex = findEndOfWord(startIndex, content);
											potentialWord = (content.substring(startIndex,endIndex));
											
											// compare to input
											if (potentialWord.compareTo(input) == 0) 
											{
												
												// success: return true
												return true;
												
											}
											// fail: continue
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return result;
	}
	
	public boolean PromptVariableIsDuplicate(String input, String InputSubSection, int InputStartIndex, int InputEndIndex, String content)
	{
		boolean result = false;
		
		int mode = 0;
		boolean seeking = true;
		boolean sectionFound = false;

		String SectionTitle = "[PROMPTS";
		String NextSectionTitle = "[DIGIT_PROMPTS";
		int tracker = 0;
		
		// Start Position found
		int startIndex = 0;
		// End Position
		int endIndex = 1;
		
		String potentialWord = "";

		
		// find start index of section
		// seek content from start to finish:
		for (; tracker < content.length(); tracker++) 
		{
			if (content.charAt(tracker) == '\n') 
			{
			}
			// find "[PROMPTS"
			// if not too far in the string
			if (tracker < content.length() - SectionTitle.length()) 
			{
				// if "[PROMPTS" is found
				if (content.substring(tracker, (tracker + SectionTitle.length())).compareTo(SectionTitle) == 0) 
				{
					tracker += SectionTitle.length();
					tracker ++; //skip assumed space
					potentialWord = content.substring(tracker, (tracker + InputSubSection.length()));
					if(potentialWord.compareTo(InputSubSection) == 0)
					{
						sectionFound = true;
						tracker = findEndOfLine(tracker,content);
						tracker++;
						break;
					}
				} 
				/*
				else 
				{
					return false; // fail
				}
				*/
			}
		}

		if (sectionFound) 
		{
			// search from start to last
			for (; tracker < content.length(); tracker++) 
			{
				// if not too far in the string
				if (tracker < content.length() - NextSectionTitle.length()) 
				{
					// if Digit Prompts section is found
					potentialWord = content.substring(tracker,(tracker + NextSectionTitle.length()));
					if (potentialWord.compareTo(NextSectionTitle) == 0) 
					{
						return false; //reach end with no duplicates
					}

					potentialWord = content.substring(tracker,(tracker + SectionTitle.length()));
					// if new prompts section  is found
					if (potentialWord.compareTo(SectionTitle) == 0) 
					{
						return false; //reach end with no duplicates
					}


					if (seeking) 
					{
						if (content.charAt(tracker) == ' ' || content.charAt(tracker) == '\n') 
						{
							// do nothing, let for loop advance
							if (content.charAt(tracker) == '\n') 
							{
							}
						}
						// identify comment indicators
						else if (content.charAt(tracker) == ';') 
						 {
							// turn off seeking unless appropriate end comment
							// is found
							seeking = false; // turn off seeking
							mode = 1; // single line comment mode
						}
						// identify comment indicators
						else if (content.charAt(tracker) == '/'	&& (tracker != content.length() - 1)) 
						{
							if (content.charAt(tracker + 1) == '*') 
							{
								// turn off seeking unless appropriate end
								// comment is found
								seeking = false; // turn off seeking
								mode = 2; // multi-line comment mode
								tracker++; // we know what x+1 is, and don't
											// care
							}
						} 
						else // not a comment
						{
							seeking = false; // turn off seeking
							mode = 3; // not a comment mode
						}
					} 
					//else 
					{
						if (mode == 1) // single line comment mode
						{
							if (content.charAt(tracker) == '\n')// && x != content.length())
							{
								mode = 0; // reset mode
								seeking = true; // turn seeking back on
							} 
							else if (tracker == content.length() - 1) 
							{
							}
						} 
						else if (mode == 2) // multi-line comment mode
						{
							if (content.charAt(tracker) == '*' && (tracker != content.length() - 1)) 
							{
								if (content.charAt(tracker + 1) == '/') 
								{
									mode = 0; // reset mode
									seeking = true; // turn seeking back on
								}
							} 
							else if (tracker == content.length() - 1) 
							{
							}
						} 
						else if (mode == 3) // not a comment mode
						{
							if ((content.charAt(tracker) == ' ') || (content.charAt(tracker) == '\n') || (tracker == content.length() - 1))
							{
								if((content.charAt(tracker) == '\n'))
								{
									seeking = true;
								}
								else
								{
									// do nothing
								}
							} 
							else 
							{
								// if word
								// ensure non-comment fits section format
								// line begins with "pr_"
								potentialWord = (content.substring(tracker,(tracker+2)));
								if (potentialWord.compareTo("pr") == 0) 
								{
									startIndex = tracker;

									if (tracker < content.length() - 2) // not on last character in file
									{
										if ((content.charAt(tracker + 2) == '_')) 
										{
											// find end of word
											endIndex = findEndOfWord(startIndex, content);
											potentialWord = (content.substring(startIndex,endIndex));
											
											// compare to input
											if (potentialWord.compareTo(input) == 0) 
											{
												//if not referring to the exact input string
												if((startIndex != InputStartIndex) && (endIndex != InputEndIndex))
												{
													// success: return true
													return true;
												}
											}
											// fail: skip rest of line
											else
											{
												tracker = findEndOfLine(tracker,content);
												seeking = true;
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return result;
	}
	
	public boolean PromptVariableHasDuplicate(String input, String InputSubSection, int SectionStartIndex, int SectionEndIndex, String content)
	{
		boolean result = false;
		
		int mode = 0;
		boolean seeking = true;
		boolean sectionFound = false;

		String SectionTitle = "[PROMPTS";
		String NextSectionTitle = "[DIGIT_PROMPTS";
		int tracker = 0;
		
		// Start Position found
		int startIndex = 0;
		// End Position
		int endIndex = 1;
		
		String potentialWord = "";

		
		// find start index of section
		// seek content from start to finish:
		for (; tracker < content.length(); tracker++) 
		{
			if (content.charAt(tracker) == '\n') 
			{
			}
			// find "[PROMPTS"
			// if not too far in the string
			if (tracker < content.length() - SectionTitle.length()) 
			{
				// if "[PROMPTS" is found
				if (content.substring(tracker, (tracker + SectionTitle.length())).compareTo(SectionTitle) == 0) 
				{
					tracker += SectionTitle.length();
					tracker ++; //skip assumed space
					if(content.substring(tracker, (tracker + InputSubSection.length()+1)).compareTo(InputSubSection+"]") == 0)
					{
						sectionFound = true;
						break;
					}
				} 
				else 
				{
					return false; // fail
				}
			}
		}

		if (sectionFound) 
		{
			// search from start to last
			for (; tracker < content.length(); tracker++) 
			{
				// if not too far in the string
				if (tracker < content.length() - NextSectionTitle.length()) 
				{
					// if Digit Prompts section is found
					if (content.substring(tracker,(tracker + NextSectionTitle.length())).compareTo(NextSectionTitle) == 0) 
					{
						return false; //reach end with no duplicates
					}

					// if new prompts section  is found
					if (content.substring(tracker,(tracker + SectionTitle.length())).compareTo(SectionTitle) == 0) 
					{
						return false; //reach end with no duplicates
					}


					if (seeking) 
					{
						if (content.charAt(tracker) == ' ' || content.charAt(tracker) == '\n') 
						{
							// do nothing, let for loop advance
							if (content.charAt(tracker) == '\n') 
							{
							}
						}
						// identify comment indicators
						else if (content.charAt(tracker) == ';') 
						 {
							// turn off seeking unless appropriate end comment
							// is found
							seeking = false; // turn off seeking
							mode = 1; // single line comment mode
						}
						// identify comment indicators
						else if (content.charAt(tracker) == '/'
								&& (tracker != content.length() - 1)) 
						{
							if (content.charAt(tracker + 1) == '*') 
							{
								// turn off seeking unless appropriate end
								// comment is found
								seeking = false; // turn off seeking
								mode = 2; // multi-line comment mode
								tracker++; // we know what x+1 is, and don't
											// care
							}
						} 
						else // not a comment
						{
							seeking = false; // turn off seeking
							mode = 3; // not a comment mode
						}
					} 
					else 
					{
						if (mode == 1) // single line comment mode
						{
							if (content.charAt(tracker) == '\n')// && x !=
																// content.length())
							{
								mode = 0; // reset mode
								seeking = true; // turn seeking back on
							} 
							else if (tracker == content.length() - 1) 
							{
							}
						} 
						else if (mode == 2) // multi-line comment mode
						{
							if (content.charAt(tracker) == '*' && (tracker != content.length() - 1)) 
							{
								if (content.charAt(tracker + 1) == '/') 
								{
									mode = 0; // reset mode
									seeking = true; // turn seeking back on
								}
							} 
							else if (tracker == content.length() - 1) 
							{
							}
						} 
						else if (mode == 3) // not a comment mode
						{
							if ((content.charAt(tracker) == ' ') || (content.charAt(tracker) == '\n') || (tracker == content.length() - 1))
							{
								// do nothing
							} else 
							{
								// if word
								// ensure non-comment fits section format
								// line begins with "pr_"
								if ((content.substring(tracker,(tracker+1)).compareTo("pr") == 0)) 
								{
									startIndex = tracker;

									if (tracker < content.length() - 2) // not on last character in file
									{
										if ((content.charAt(tracker + 2) == '_')) 
										{
											// find end of word
											endIndex = findEndOfWord(startIndex, content);
											potentialWord = (content.substring(startIndex,endIndex));
											
											// compare to input
											if (potentialWord.compareTo(input) == 0) 
											{
												//if not referring to the exact input string
												//if((startIndex != InputStartIndex) && (endIndex != InputEndIndex))
												{
													// success: return true
													return true;
												}
											}
											// fail: continue
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return result;
	}
	
	public boolean PromptVariableHasAlternate(String input, ArrayList<ArrayList<String>> SectionList, String InputSubSection, int InputStartIndex, int InputEndIndex, String content)
	{
		boolean result = false;
		
		if(SectionList.size() < 2)
		{
			return true;
		}
		
		for(int x = 0; x < SectionList.size(); x++)
		{
			//if section is equal to original section
			if(SectionList.get(x).get(0).compareTo(InputSubSection) == 0)
			{
				continue; //skip this section
			}
			result = PromptVariableIsDuplicate(input, SectionList.get(x).get(0), InputStartIndex, InputEndIndex, content);
			
			if(!result)
			{
				break;
			}
			
		}
		
		
		return result;
	}
	
	public boolean DigitPromptVariableInCode(String input, String content)
	{
		boolean result = false;
		
		int mode = 0;
		boolean seeking = true;
		boolean sectionFound = false;

		String SectionTitle = "";
		String NextSectionTitle = "[PROMPTS";
		int tracker = 0;
		
		// Start Position found
		int startIndex = 0;
		// End Position
		int endIndex = 1;
		
		String potentialWord = "";
		
		
		//find start cell name
		
		//set SectionTitle as "starting cell name"
		SectionTitle = FindStartCellName(content);
		
		if( SectionTitle.compareTo("(-1)") != 0)
		{
			SectionTitle = FindStartCell(SectionTitle,content);
		}
		
		if( SectionTitle.compareTo("(-1)") == 0)
		{
			return false; //fail
		}
		
		// find start index of section
		// seek content from start to finish:
		for (; tracker < content.length(); tracker++) 
		{
			if (content.charAt(tracker) == '\n') 
			{
			}
			// find start cell
			// if not too far in the string
			if (tracker < content.length() - SectionTitle.length()) 
			{
				// if start cell is found
				if (content.substring(tracker, (tracker + SectionTitle.length())).compareTo(SectionTitle) == 0) 
				{
					tracker += SectionTitle.length();
					tracker ++; //skip assumed space
					
					sectionFound = true;
					break;
					
				} 
				/*
				else 
				{
					return false; // fail
				}
				*/
			}
		}

		if (sectionFound) 
		{
			// search from start to last
			for (; tracker < content.length(); tracker++) 
			{
				// if not too far in the string
				if (tracker < content.length() - NextSectionTitle.length()) 
				{
					// if Digit Prompts section is found
					potentialWord = content.substring(tracker,(tracker + NextSectionTitle.length()));
					if (potentialWord.compareTo(NextSectionTitle) == 0) 
					{
						return false; //reach end with no duplicates
					}

					potentialWord = content.substring(tracker,(tracker + SectionTitle.length()));
					// if new prompts section  is found
					if (potentialWord.compareTo(SectionTitle) == 0) 
					{
						return false; //reach end with no duplicates
					}


					if (seeking) 
					{
						if (content.charAt(tracker) == ' ' || content.charAt(tracker) == '\n') 
						{
							// do nothing, let for loop advance
							if (content.charAt(tracker) == '\n') 
							{
							}
						}
						// identify comment indicators
						else if (content.charAt(tracker) == ';') 
						 {
							// turn off seeking unless appropriate end comment
							// is found
							seeking = false; // turn off seeking
							mode = 1; // single line comment mode
						}
						// identify comment indicators
						else if (content.charAt(tracker) == '/'
								&& (tracker != content.length() - 1)) 
						{
							if (content.charAt(tracker + 1) == '*') 
							{
								// turn off seeking unless appropriate end
								// comment is found
								seeking = false; // turn off seeking
								mode = 2; // multi-line comment mode
								tracker++; // we know what x+1 is, and don't
											// care
							}
						} 
						else // not a comment
						{
							seeking = false; // turn off seeking
							mode = 3; // not a comment mode
						}
					} 
					//else 
					{
						if (mode == 1) // single line comment mode
						{
							if (content.charAt(tracker) == '\n')// && x !=
																// content.length())
							{
								mode = 0; // reset mode
								seeking = true; // turn seeking back on
							} 
							else if (tracker == content.length() - 1) 
							{
							}
						} 
						else if (mode == 2) // multi-line comment mode
						{
							if (content.charAt(tracker) == '*' && (tracker != content.length() - 1)) 
							{
								if (content.charAt(tracker + 1) == '/') 
								{
									mode = 0; // reset mode
									seeking = true; // turn seeking back on
								}
							} 
							else if (tracker == content.length() - 1) 
							{
							}
						} 
						else if (mode == 3) // not a comment mode
						{
							if ((content.charAt(tracker) == ' ') || (content.charAt(tracker) == '\n') || (tracker == content.length() - 1))
							{
								// do nothing
							} 
							else 
							{
								// if word
								// ensure non-comment fits section format
								// line begins with "pr_"
								potentialWord = (content.substring(tracker,(tracker+2)));
								if (potentialWord.compareTo("pr") == 0) 
								{
									startIndex = tracker;

									if (tracker < content.length() - 2) // not on last character in file
									{
										if ((content.charAt(tracker + 2) == '_')) 
										{
											// find end of word
											endIndex = findEndOfWord(startIndex, content);
											potentialWord = (content.substring(startIndex,endIndex));
											
											// compare to input
											if (potentialWord.compareTo(input) == 0) 
											{
												
												// success: return true
												return true;
												
											}
											// fail: continue
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return result;
	}
	
	public boolean DigitPromptVariableIsDuplicate(String input, String InputSubSection, int InputStartIndex, int InputEndIndex, String content)
	{
		boolean result = false;
		
		int mode = 0;
		boolean seeking = true;
		boolean sectionFound = false;

		String SectionTitle = "[DIGIT_PROMPTS";
		String NextSectionTitle = "[GENERAL]";
		int tracker = 0;
		
		// Start Position found
		int startIndex = 0;
		// End Position
		int endIndex = 1;
		
		String potentialWord = "";

		
		// find start index of section
		// seek content from start to finish:
		for (; tracker < content.length(); tracker++) 
		{
			if (content.charAt(tracker) == '\n') 
			{
			}
			// find "[DIGIT_PROMPTS"
			// if not too far in the string
			if (tracker < content.length() - SectionTitle.length()) 
			{
				// if "[DIGIT_PROMPTS" is found
				if (content.substring(tracker, (tracker + SectionTitle.length())).compareTo(SectionTitle) == 0) 
				{
					tracker += SectionTitle.length();
					tracker ++; //skip assumed space
					potentialWord = content.substring(tracker, (tracker + InputSubSection.length()));
					if(potentialWord.compareTo(InputSubSection) == 0)
					{
						sectionFound = true;
						tracker = findEndOfLine(tracker,content);
						tracker++;
						break;
					}
				} 
				/*
				else 
				{
					return false; // fail
				}
				*/
			}
		}

		if (sectionFound) 
		{
			// search from start to last
			for (; tracker < content.length(); tracker++) 
			{
				// if not too far in the string
				if (tracker < content.length() - NextSectionTitle.length()) 
				{
					// if Digit Prompts section is found
					potentialWord = content.substring(tracker,(tracker + NextSectionTitle.length()));
					if (potentialWord.compareTo(NextSectionTitle) == 0) 
					{
						return false; //reach end with no duplicates
					}

					potentialWord = content.substring(tracker,(tracker + SectionTitle.length()));
					// if new prompts section  is found
					if (potentialWord.compareTo(SectionTitle) == 0) 
					{
						return false; //reach end with no duplicates
					}


					if (seeking) 
					{
						if (content.charAt(tracker) == ' ' || content.charAt(tracker) == '\n') 
						{
							// do nothing, let for loop advance
							if (content.charAt(tracker) == '\n') 
							{
							}
						}
						// identify comment indicators
						else if (content.charAt(tracker) == ';') 
						 {
							// turn off seeking unless appropriate end comment
							// is found
							seeking = false; // turn off seeking
							mode = 1; // single line comment mode
						}
						// identify comment indicators
						else if (content.charAt(tracker) == '/'	&& (tracker != content.length() - 1)) 
						{
							if (content.charAt(tracker + 1) == '*') 
							{
								// turn off seeking unless appropriate end
								// comment is found
								seeking = false; // turn off seeking
								mode = 2; // multi-line comment mode
								tracker++; // we know what x+1 is, and don't
											// care
							}
						} 
						else // not a comment
						{
							seeking = false; // turn off seeking
							mode = 3; // not a comment mode
						}
					} 
					//else 
					{
						if (mode == 1) // single line comment mode
						{
							if (content.charAt(tracker) == '\n')// && x != content.length())
							{
								mode = 0; // reset mode
								seeking = true; // turn seeking back on
							} 
							else if (tracker == content.length() - 1) 
							{
							}
						} 
						else if (mode == 2) // multi-line comment mode
						{
							if (content.charAt(tracker) == '*' && (tracker != content.length() - 1)) 
							{
								if (content.charAt(tracker + 1) == '/') 
								{
									mode = 0; // reset mode
									seeking = true; // turn seeking back on
								}
							} 
							else if (tracker == content.length() - 1) 
							{
							}
						} 
						else if (mode == 3) // not a comment mode
						{
							if ((content.charAt(tracker) == ' ') || (content.charAt(tracker) == '\n') || (tracker == content.length() - 1))
							{
								if((content.charAt(tracker) == '\n'))
								{
									seeking = true;
								}
								else
								{
									// do nothing
								}
							} 
							else 
							{
								startIndex = tracker;
								
								// find end of word
								endIndex = findEndOfWord(startIndex, content);
								potentialWord = (content.substring(startIndex,endIndex));
								
								// compare to input
								if (potentialWord.compareTo(input) == 0) 
								{
									//if not referring to the exact input string
									if((startIndex != InputStartIndex) && (endIndex != InputEndIndex))
									{
										// success: return true
										return true;
									}
									// fail: skip rest of line
									else
									{
										tracker = findEndOfLine(tracker,content);
										seeking = true;
									}
								}
								// fail: skip rest of line
								else
								{
									tracker = findEndOfLine(tracker,content);
									seeking = true;
								}
							}
									
								
							
						}
					}
				}
			}
		}
		return result;
	}
	
	public boolean DigitPromptVariableHasDuplicate(String input, String InputSubSection, int SectionStartIndex, int SectionEndIndex, String content)
	{
		boolean result = false;
		
		int mode = 0;
		boolean seeking = true;
		boolean sectionFound = false;

		String SectionTitle = "[DIGIT_PROMPTS";
		String NextSectionTitle = "[GENERAL]";
		int tracker = 0;
		
		// Start Position found
		int startIndex = 0;
		// End Position
		int endIndex = 1;
		
		String potentialWord = "";

		
		// find start index of section
		// seek content from start to finish:
		for (; tracker < content.length(); tracker++) 
		{
			if (content.charAt(tracker) == '\n') 
			{
			}
			// find "[DIGIT_PROMPTS"
			// if not too far in the string
			if (tracker < content.length() - SectionTitle.length()) 
			{
				// if "[DIGIT_PROMPTS" is found
				if (content.substring(tracker, (tracker + SectionTitle.length())).compareTo(SectionTitle) == 0) 
				{
					tracker += SectionTitle.length();
					tracker ++; //skip assumed space
					if(content.substring(tracker, (tracker + InputSubSection.length()+1)).compareTo(InputSubSection+"]") == 0)
					{
						sectionFound = true;
						break;
					}
				} 
				else 
				{
					return false; // fail
				}
			}
		}

		if (sectionFound) 
		{
			// search from start to last
			for (; tracker < content.length(); tracker++) 
			{
				// if not too far in the string
				if (tracker < content.length() - NextSectionTitle.length()) 
				{
					// if Digit Prompts section is found
					if (content.substring(tracker,(tracker + NextSectionTitle.length())).compareTo(NextSectionTitle) == 0) 
					{
						return false; //reach end with no duplicates
					}

					// if new prompts section  is found
					if (content.substring(tracker,(tracker + SectionTitle.length())).compareTo(SectionTitle) == 0) 
					{
						return false; //reach end with no duplicates
					}


					if (seeking) 
					{
						if (content.charAt(tracker) == ' ' || content.charAt(tracker) == '\n') 
						{
							// do nothing, let for loop advance
							if (content.charAt(tracker) == '\n') 
							{
							}
						}
						// identify comment indicators
						else if (content.charAt(tracker) == ';') 
						 {
							// turn off seeking unless appropriate end comment
							// is found
							seeking = false; // turn off seeking
							mode = 1; // single line comment mode
						}
						// identify comment indicators
						else if (content.charAt(tracker) == '/'
								&& (tracker != content.length() - 1)) 
						{
							if (content.charAt(tracker + 1) == '*') 
							{
								// turn off seeking unless appropriate end
								// comment is found
								seeking = false; // turn off seeking
								mode = 2; // multi-line comment mode
								tracker++; // we know what x+1 is, and don't
											// care
							}
						} 
						else // not a comment
						{
							seeking = false; // turn off seeking
							mode = 3; // not a comment mode
						}
					} 
					else 
					{
						if (mode == 1) // single line comment mode
						{
							if (content.charAt(tracker) == '\n')// && x !=
																// content.length())
							{
								mode = 0; // reset mode
								seeking = true; // turn seeking back on
							} 
							else if (tracker == content.length() - 1) 
							{
							}
						} 
						else if (mode == 2) // multi-line comment mode
						{
							if (content.charAt(tracker) == '*' && (tracker != content.length() - 1)) 
							{
								if (content.charAt(tracker + 1) == '/') 
								{
									mode = 0; // reset mode
									seeking = true; // turn seeking back on
								}
							} 
							else if (tracker == content.length() - 1) 
							{
							}
						} 
						else if (mode == 3) // not a comment mode
						{
							if ((content.charAt(tracker) == ' ') || (content.charAt(tracker) == '\n') || (tracker == content.length() - 1))
							{
								// do nothing
							} else 
							{
								// if word
								startIndex = tracker;
								// find end of word
								endIndex = findEndOfWord(startIndex, content);
								potentialWord = (content.substring(startIndex,endIndex));
								
								// compare to input
								if (potentialWord.compareTo(input) == 0) 
								{
									//if not referring to the exact input string
									//if((startIndex != InputStartIndex) && (endIndex != InputEndIndex))
									{
										// success: return true
										return true;
									}
								}
								// fail: skip rest of line
								else
								{
									tracker = findEndOfLine(tracker,content);
									seeking = true;
								}
							}
						}
					}
				}
			}
		}
		return result;
	}
	
	public boolean DigitPromptVariableHasAlternate(String input, ArrayList<ArrayList<String>> SectionList, String InputSubSection, int InputStartIndex, int InputEndIndex, String content)
	{
		boolean result = false;
		
		if(SectionList.size() < 2)
		{
			return true;
		}
		
		for(int x = 0; x < SectionList.size(); x++)
		{
			//if section is equal to original section
			if(SectionList.get(x).get(0).compareTo(InputSubSection) == 0)
			{
				continue; //skip this section
			}
			result = DigitPromptVariableIsDuplicate(input, SectionList.get(x).get(0), InputStartIndex, InputEndIndex, content);
			
			if(!result)
			{
				break;
			}
			
		}
		
		
		return result;
	}
	
	public String FindBaseSection(String InputSection, ArrayList<ArrayList<String>> SectionList)
	{
		String output = InputSection;
		
		for(int x = 0; x < SectionList.size(); x++)
		{
			if(SectionList.get(x).get(0).compareTo(InputSection.substring(0,SectionList.get(x).get(0).length())) == 0)
			{
				if(SectionList.get(x).get(0).length() < InputSection.length())
				{
					output = SectionList.get(x).get(0);
					break;
				}
			}
		}
		
		
		return output;
	}
	
	public ArrayList<ArrayList<String>> GetPromptSectionsList(String SectionTitle, String NextSectionTitle, String content)
	{
		ArrayList<ArrayList<String>> output = new ArrayList<ArrayList<String>>();
		//Structure:
			//Start Position found
			int startofSectionIndex = 0;
			//End Position
			int endofSectionIndex = 1;

		
		int mode = 0;
		boolean seeking = true;
		boolean sectionFound = false;
		
		int tracker = 0;
		
		String dataType = "";
		
		String potentialWord = "";
		char testChar = '0';
		String CurrentSection = "";
		

		
		//ArrayList<ArrayList<String>> PromptSectionsList = new ArrayList<ArrayList<String>>();
		
		//seek content from start to finish:
		for(; tracker < content.length(); tracker++)
		{
			testChar = content.charAt(tracker);

			//find "[PROMPTS "
				//if not too far in the string
			if( tracker < content.length()-SectionTitle.length() )
			{
				//if "[PROMPTS " is found
				if(content.substring(tracker,(tracker+SectionTitle.length())).compareTo(SectionTitle) == 0)
				{
					tracker = tracker + SectionTitle.length();
					testChar = content.charAt(tracker);
					startofSectionIndex = tracker;
					tracker = findEndOfWordUntilRBracket(tracker,content);
					CurrentSection = content.substring(startofSectionIndex,tracker);
					
					sectionFound = true;
					//tracker += SectionTitle.length();
					tracker = findEndOfLine(tracker, content);
					testChar = content.charAt(tracker);
					break;
				}
			}
			else
			{
				return output; //escape method
			}
		}
				
		if(sectionFound)
		{
			for(; tracker < content.length(); tracker++)
			{
				testChar = content.charAt(tracker);
				//find "[DIGIT_PROMPTS "
					//if not too far in the string
				if( tracker < content.length()-NextSectionTitle.length() )
				{
					//if "[DIGIT_PROMPTS " is found
					if(content.substring(tracker,(tracker+NextSectionTitle.length())).compareTo(NextSectionTitle) == 0)
					{
						endofSectionIndex = tracker;
						
						output.add(new ArrayList<String> ());
						output.get(output.size()-1).add(CurrentSection);
						output.get(output.size()-1).add(Integer.toString(startofSectionIndex));
						output.get(output.size()-1).add(Integer.toString(endofSectionIndex));
					
						return output; //escape method
					}
				}
				
				testChar = content.charAt(tracker);
				
				if(seeking)
				{
					if( content.charAt(tracker) == ' ' || content.charAt(tracker) == '\n')
					{
						//do nothing, let for loop advance
					}
					//identify comment indicators
					else if(content.charAt(tracker) == ';')
					{
						//turn off seeking unless appropriate end comment is found
						seeking = false; //turn off seeking
						mode = 1; //single line comment mode
					}
					//identify comment indicators
					else if(content.charAt(tracker) == '/' && (tracker != content.length()-1))
					{
						if(content.charAt(tracker+1) == '*')
						{
							//turn off seeking unless appropriate end comment is found
							seeking = false; //turn off seeking
							mode = 2; //multi-line comment mode
							tracker++; //we know what x+1 is, and don't care 
							testChar = content.charAt(tracker);
						}
					}
					else //not a comment
					{
						seeking = false; //turn off seeking
						mode = 3; //not a comment mode
					}		
				}
				
				//else
				if(!seeking)
				{
					if(mode == 1) //single line comment mode
					{
						if(content.charAt(tracker) == '\n')// && x != content.length())
						{
							mode = 0; //reset mode
							seeking = true; //turn seeking back on
						}
						else if(tracker == content.length()-1)
						{
						}
					}
					else if(mode == 2) //multi-line comment mode
					{
						if(content.charAt(tracker) == '*' && (tracker != content.length()-1))
						{
							if(content.charAt(tracker+1) == '/')
							{
								mode = 0; //reset mode
								seeking = true; //turn seeking back on
							}
						}
						else if(tracker == content.length()-1)
						{
						}
					}
					else if(mode == 3) //not a comment mode
					{
						if((content.charAt(tracker) == ' ') || (content.charAt(tracker) == '\n') ||(tracker == content.length()-1))// && x != content.length())
						{
							continue;
						}
						else
						{
							//ensure non-comment fits section format
							if((content.charAt(tracker) == '['))
							{
								if( tracker < content.length()-SectionTitle.length() )
								{
									//if new "[PROMPTS " is found
									if(content.substring(tracker,(tracker+SectionTitle.length())).compareTo(SectionTitle) == 0)
									{
										endofSectionIndex = tracker;
										
										output.add(new ArrayList<String> ());
										output.get(output.size()-1).add(CurrentSection);
										output.get(output.size()-1).add(Integer.toString(startofSectionIndex));
										output.get(output.size()-1).add(Integer.toString(endofSectionIndex));
									
										
										tracker = tracker + SectionTitle.length();
										testChar = content.charAt(tracker);
										startofSectionIndex = tracker;
										tracker = findEndOfWordUntilRBracket(tracker,content);
										testChar = content.charAt(tracker);
										CurrentSection = content.substring(startofSectionIndex,tracker);
										
										
										tracker = findEndOfLine(tracker, content);
										testChar = content.charAt(tracker);
									}
								}
							}							
							else
							{
		
								
							}
							
								
								
							}
							mode = 0; //reset mode
							seeking = true; //turn seeking back on
						}
					}
					
				}
			}
		
		
		return output;
	}
	
	//determine starting cell name from [APPLICATION]
	public String FindStartCellName(String content)
	{
		int mode = 0;
		boolean seeking = true;
		boolean sectionFound = false;

		String SectionTitle = "[APPLICATION]";
		String NextSectionTitle = "[CALL_VARIABLES]";
		int tracker = 0;
		
		// Start Position found
		int startIndex = 0;
		// End Position
		int endIndex = 1;
		
		String StartCellName = "";
		char testChar = '0';
		String potentialWord = "";
		
		
		// find start index of section
		// seek content from start to finish:
		for (; tracker < content.length(); tracker++) 
		{
			testChar = content.charAt(tracker);
			if (content.charAt(tracker) == '\n') 
			{
			}
			// find "[APPLICATION]"
			// if not too far in the string
			if (tracker < content.length() - SectionTitle.length()) 
			{
				testChar = content.charAt(tracker);
				// if "[APPLICATION]" is found
				if (content.substring(tracker,(tracker + SectionTitle.length())).compareTo(SectionTitle) == 0) 
				{
					sectionFound = true;
					tracker += SectionTitle.length();
					testChar = content.charAt(tracker);
					break;
				}
			}
			else 
			{
				return "(-1)"; // fail
			}
		}

		if (sectionFound) 
		{
			// search from start to last
			for (; tracker < content.length(); tracker++) 
			{
				testChar = content.charAt(tracker);
				// find "[CALL_VARIABLES]"
				// if not too far in the string
				if (tracker < content.length() - NextSectionTitle.length()) 
				{
					// if "[CALL_VARIABLES]" is found
					if (content.substring(tracker,(tracker + NextSectionTitle.length())).compareTo(NextSectionTitle) == 0) 
					{
						return "(-1)"; // fail
					}

					if (seeking) 
					{
						if (content.charAt(tracker) == ' ' || content.charAt(tracker) == '\n') 
						{
							// do nothing, let for loop advance
							if (content.charAt(tracker) == '\n') 
							{
							}
						}
						// identify comment indicators
						else if (content.charAt(tracker) == ';') 
						{
							// turn off seeking unless appropriate end comment
							// is found
							seeking = false; // turn off seeking
							mode = 1; // single line comment mode
						}
						// identify comment indicators
						else if (content.charAt(tracker) == '/'
								&& (tracker != content.length() - 1)) 
						{
							if (content.charAt(tracker + 1) == '*') 
							{
								// turn off seeking unless appropriate end
								// comment is found
								seeking = false; // turn off seeking
								mode = 2; // multi-line comment mode
								tracker++; // we know what x+1 is, and don't
											// care
							}
						} 
						else // not a comment
						{
							seeking = false; // turn off seeking
							mode = 3; // not a comment mode
						}
					}
					
					//else
					if(!seeking)
					{
						if (mode == 1) // single line comment mode
						{
							if (content.charAt(tracker) == '\n')// && x !=
																// content.length())
							{
								mode = 0; // reset mode
								seeking = true; // turn seeking back on
							} 
							else if (tracker == content.length() - 1) 
							{
							}
						} 
						else if (mode == 2) // multi-line comment mode
						{
							if (content.charAt(tracker) == '*' && (tracker != content.length() - 1)) 
							{
								if (content.charAt(tracker + 1) == '/') 
								{
									mode = 0; // reset mode
									seeking = true; // turn seeking back on
								}
							} 
							else if (tracker == content.length() - 1) 
							{
							}
						} 
						else if (mode == 3) // not a comment mode
						{
							if ((content.charAt(tracker) == ' ') || (content.charAt(tracker) == '\n') || (tracker == content.length() - 1))
							{
								// do nothing
							} 
							else 
							{
								// if word
								if(tracker < content.length()-"startingCell".length())
								{
									startIndex = tracker;
									
									// find end of word
									tracker = findEndOfWord(startIndex, content);
									endIndex = tracker;
									
									testChar = content.charAt(tracker);
									
									potentialWord = content.substring(startIndex,endIndex);
									
									
									// compare to startingCell
									if (potentialWord.compareTo("startingCell") == 0) 
									{
										//find startingCell's value
										for (; tracker < content.length(); tracker++) 
										{
											testChar = content.charAt(tracker);
											
											if ((content.charAt(tracker) == ' ') )
											{
												// do nothing
											}
											else if( (content.charAt(tracker) == '=') )
											{
												tracker++;
												testChar = content.charAt(tracker);
												
												startIndex = tracker;
												
												// find end of word
												tracker = findEndOfWord(startIndex, content);
												testChar = content.charAt(tracker);
												
												endIndex = tracker;
												

												StartCellName = content.substring(startIndex,endIndex);
												// success: return true
												return StartCellName;
											}
											else
											{
												return "(-1)";
											}
										}
										
										
										
									}
									else
									{
										tracker = findEndOfLine(tracker,content);
										testChar = content.charAt(tracker);
										
									}
									// fail: continue

								}
							}
						}
					}
				}
			}
		}
							
		return "(-1)";
	}
	
	public String FindStartCell(String input, String content) 
	{
		int mode = 0;
		boolean seeking = true;
		int tracker = 0;
		
		// Start Position found
		int startIndex = 0;
		// End Position
		int endIndex = 1;
		String potentialWord = "";
		char testChar = '0';
		
		int CellNameStartIndex = 0;
		int CellNameEndIndex = 1;
		
		String cellWord = "";
		String potentialMatch = "";
		
		
		
		// search from start to last
		for (; tracker < content.length(); tracker++) 
		{
			testChar = content.charAt(tracker);
			
			if (seeking) 
			{
				if (content.charAt(tracker) == ' ' || content.charAt(tracker) == '\n') 
				{
					// do nothing, let for loop advance
					if (content.charAt(tracker) == '\n') 
					{
					}
				}
				// identify comment indicators
				else if (content.charAt(tracker) == ';') 
				{
					// turn off seeking unless appropriate end comment
					// is found
					seeking = false; // turn off seeking
					mode = 1; // single line comment mode
				}
				// identify comment indicators
				else if (content.charAt(tracker) == '/'	&& (tracker != content.length() - 1)) 
				{
					if (content.charAt(tracker + 1) == '*') 
					{
						// turn off seeking unless appropriate end
						// comment is found
						seeking = false; // turn off seeking
						mode = 2; // multi-line comment mode
						tracker++; // we know what x+1 is, and don't care
						testChar = content.charAt(tracker);
						
					}
				} 
				else // not a comment
				{
					seeking = false; // turn off seeking
					mode = 3; // not a comment mode
				}
			} 
			else 
			{
				if (mode == 1) // single line comment mode
				{
					if (content.charAt(tracker) == '\n')// && x !=
														// content.length())
					{
						mode = 0; // reset mode
						seeking = true; // turn seeking back on
					} 
					else if (tracker == content.length() - 1) 
					{
					}
				} 
				else if (mode == 2) // multi-line comment mode
				{
					if (content.charAt(tracker) == '*' && (tracker != content.length() - 1)) 
					{
						if (content.charAt(tracker + 1) == '/') 
						{
							mode = 0; // reset mode
							seeking = true; // turn seeking back on
						}
					} 
					else if (tracker == content.length() - 1) 
					{
					}
				} 
				else if (mode == 3) // not a comment mode
				{
					if ((content.charAt(tracker) == ' ') || (content.charAt(tracker) == '\n') || (tracker == content.length() - 1))
					{
						// do nothing
					} 
					else 
					{
						// if '['
						if (content.charAt(tracker) == '[') 
						{
							//determine if start of word
							startIndex = tracker;
							CellNameStartIndex = startIndex;
							
							//find end of word
							tracker = findEndOfWord(startIndex, content);
							endIndex = tracker;
							testChar = content.charAt(tracker);
							
							//substring word
							potentialWord = content.substring(startIndex,endIndex);

							//check word against valid cell types
							for(int x = 0; x < MasterCellTypeList.size(); x++)
							{
								cellWord = MasterCellTypeList.get(x);
								
								//compare to cell type
								if ((potentialWord.compareTo(cellWord) == 0)) 
								{
									//find start of next word
									for (; tracker < content.length(); tracker++) 
									{
										if(content.charAt(tracker) == ' ')
										{
											continue;
										}
										else if(content.charAt(tracker) != ' ')
										{
											startIndex = tracker;
											//find end of word
											tracker = findEndOfWord(startIndex, content);
											endIndex = tracker;
											testChar = content.charAt(tracker);
											
											//substring word
											potentialWord = content.substring(startIndex,endIndex);
												
											//check word against input + ']'
											if ((potentialWord.compareTo(input+']') == 0)) 
											{
												CellNameEndIndex = endIndex;
												potentialMatch = content.substring(CellNameStartIndex,CellNameEndIndex);
													
													
												//success: return true
												return potentialMatch;
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		
		return "(-1)";
	}
	
	public boolean isCellValid(String input, String content) 
	{
		boolean result = false;
		int mode = 0;
		boolean seeking = true;
		int tracker = 0;
		
		// Start Position found
		int startIndex = 0;
		// End Position
		int endIndex = 1;
		String potentialWord = "";
		
		String SectionTitle = "";
		String NextSectionTitle = "[PROMPTS ";
		
		char testChar = '0';
		boolean sectionFound = false;
		
		int CellNameStartIndex = 0;
		int CellNameEndIndex = 1;
		
		String cellWord = "";
		String potentialMatch = "";
		String helperMonkey = "";
		
		//find start cell name
		
		//set SectionTitle as "starting cell name"
		SectionTitle = FindStartCellName(content);
		
		if( SectionTitle.compareTo("(-1)") != 0)
		{
			SectionTitle = FindStartCell(SectionTitle,content);
		}
		
		if( SectionTitle.compareTo("(-1)") == 0)
		{
			return false; //fail
		}
		
		//seek content from start to finish:
		for(; tracker < content.length(); tracker++)
		{
			testChar = content.charAt(tracker);
			if(content.charAt(tracker) == '\n')
			{
				
			}
			
			//find start cell
				//if not too far in the string
			if( tracker < content.length()-SectionTitle.length() )
			{
				//if start cell is found
				if(content.substring(tracker,(tracker+SectionTitle.length())).compareTo(SectionTitle) == 0)
				{
					sectionFound = true;
					//tracker += SectionTitle.length();
					//testChar = content.charAt(tracker);
					
					break;
				}
			}
			else
			{
				return false; //escape method
			}
		}
		
		if(sectionFound)
		{
			for (; tracker < content.length(); tracker++) 
			{
				testChar = content.charAt(tracker);
				//find "[PROMPTS "
					//if not too far in the string
				if( tracker < content.length()-NextSectionTitle.length() )
				{
					//if "[PROMPTS " is found
					if(content.substring(tracker,(tracker+NextSectionTitle.length())).compareTo(NextSectionTitle) == 0)
					{
						return false; //escape method
					}
				}
				
				testChar = content.charAt(tracker);	
				
				
				if (seeking) 
				{
					if (content.charAt(tracker) == ' ' || content.charAt(tracker) == '\n') 
					{
						// do nothing, let for loop advance
						if (content.charAt(tracker) == '\n') 
						{
						}
					}
					// identify comment indicators
					else if (content.charAt(tracker) == ';') 
					{
						// turn off seeking unless appropriate end comment
						// is found
						seeking = false; // turn off seeking
						mode = 1; // single line comment mode
					}
					// identify comment indicators
					else if (content.charAt(tracker) == '/'	&& (tracker != content.length() - 1)) 
					{
						if (content.charAt(tracker + 1) == '*') 
						{
							// turn off seeking unless appropriate end
							// comment is found
							seeking = false; // turn off seeking
							mode = 2; // multi-line comment mode
							tracker++; // we know what x+1 is, and don't care
							testChar = content.charAt(tracker);	
							
						}
					} 
					else // not a comment
					{
						seeking = false; // turn off seeking
						mode = 3; // not a comment mode
					}
				} 
				
				//else
				if(!seeking)
				{
					if (mode == 1) // single line comment mode
					{
						if (content.charAt(tracker) == '\n')// && x !=
															// content.length())
						{
							mode = 0; // reset mode
							seeking = true; // turn seeking back on
						} 
						else if (tracker == content.length() - 1) 
						{
						}
					} 
					else if (mode == 2) // multi-line comment mode
					{
						if (content.charAt(tracker) == '*' && (tracker != content.length() - 1)) 
						{
							if (content.charAt(tracker + 1) == '/') 
							{
								mode = 0; // reset mode
								seeking = true; // turn seeking back on
							}
						} 
						else if (tracker == content.length() - 1) 
						{
						}
					} 
					else if (mode == 3) // not a comment mode
					{
						if ((content.charAt(tracker) == ' ') || (content.charAt(tracker) == '\n') || (tracker == content.length() - 1))
						{
							// do nothing
						} 
						else 
						{
							// if '['
							if (content.charAt(tracker) == '[') 
							{
								//determine if start of word
								startIndex = tracker;
								CellNameStartIndex = startIndex;
								
								//find end of word
								tracker = findEndOfWord(startIndex, content);
								testChar = content.charAt(tracker);	
								
								endIndex = tracker;
								
								//substring word
								potentialWord = content.substring(startIndex,endIndex);
	
								//check word against valid cell types
								for(int x = 0; x < MasterCellTypeList.size(); x++)
								{
									cellWord = MasterCellTypeList.get(x);
									
									//compare to cell type
									if ((potentialWord.compareTo(cellWord) == 0)) 
									{
										//find start of next word
										for (; tracker < content.length(); tracker++) 
										{
											testChar = content.charAt(tracker);	
											
											if(content.charAt(tracker) == ' ')
											{
												continue;
											}											
											else if(content.charAt(tracker) != ' ')
											{
												startIndex = tracker;
												//find end of word
												tracker = findEndOfWord(startIndex, content);
												testChar = content.charAt(tracker);	
												
												endIndex = tracker;
												
												
												
												//substring word
												potentialWord = content.substring(startIndex,endIndex);
												
												//check word against input + ']'
												helperMonkey = input+']';
												if ((potentialWord.compareTo(helperMonkey) == 0)) 
												{
													CellNameEndIndex = endIndex;
													
													potentialMatch = content.substring(CellNameStartIndex,CellNameEndIndex);
													return true;
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	//common helpful methods:
	
	//find the end of a word without commas
	public int findEndOfWordUntilRBracket(int tracker, String content)
	{
		int output = 0;
		
		char testchar = '0';
		
		for(; tracker < content.length(); tracker++)
		{
			testchar = content.charAt(tracker);
			
			if((content.charAt(tracker) == '\n') || (tracker == content.length()-1) || (content.charAt(tracker) == ';')) //pivot: comma?
			{
				output = tracker;
				break;
			}
			else if((content.charAt(tracker) == ']'))
			{
				output = tracker;
				break;
			}
			else if(tracker < content.length()-1) //not on last character in file
			{
				if((content.charAt(tracker) == '/'))
				{
					if((content.charAt(tracker+1) == '*'))
					{
						output = tracker;
						break;
					}
				}
			}
		}
		
		return output;		
	}
	
	//find the end of a word without commas
	public int findEndOfWordNoCommas(int tracker, String content)
	{
		int output = 0;
		
		char testchar = '0';
		
		for(; tracker < content.length(); tracker++)
		{
			testchar = content.charAt(tracker);
			
			if((content.charAt(tracker) == ' ') || (content.charAt(tracker) == '\n') || (tracker == content.length()-1) || (content.charAt(tracker) == ';')) //pivot: comma?
			{
				output = tracker;
				break;
			}
			else if((content.charAt(tracker) == '='))
			{
				output = tracker;
				break;
			}
			else if((content.charAt(tracker) == ','))
			{
				output = tracker;
				break;
			}
			else if(tracker < content.length()-1) //not on last character in file
			{
				if((content.charAt(tracker) == '/'))
				{
					if((content.charAt(tracker+1) == '*'))
					{
						output = tracker;
						break;
					}
				}
			}
		}
		
		return output;		
	}
	
	//find the end of a word
	public int findEndOfWord(int tracker, String content)
	{
		int output = 0;
		
		char testchar = '0';
		
		for(; tracker < content.length(); tracker++)
		{
			testchar = content.charAt(tracker);
			
			if((content.charAt(tracker) == ' ') || (content.charAt(tracker) == '\n') || (tracker == content.length()-1) || (content.charAt(tracker) == ';')) //pivot: comma?
			{
				output = tracker;
				break;
			}
			else if((content.charAt(tracker) == '='))
			{
				output = tracker;
				break;
			}
			else if(tracker < content.length()-1) //not on last character in file
			{
				if((content.charAt(tracker) == '/'))
				{
					if((content.charAt(tracker+1) == '*'))
					{
						output = tracker;
						break;
					}
				}
			}
		}
		
		return output;		
	}
	
	//find the end of the line
	public int findEndOfLine(int tracker, String content)
	{
		int output = 0;
		
		for(; tracker < content.length(); tracker++)
		{
			if((content.charAt(tracker) == '\n'))
			{
				output = tracker;
				return output;
			}
		}
		
		output = tracker;
		return output;		
	}
	
	public int findEndOfLineOrComment(int tracker, String content)
	{
		int output = 0;
		
		for(; tracker < content.length(); tracker++)
		{
			if((content.charAt(tracker) == '\n') ||(tracker == content.length()-1) || (content.charAt(tracker) == ';'))
			{
				output = tracker;
				break;
			}
			else if(tracker < content.length()-1) //not on last character in file
			{
				if((content.charAt(tracker) == '/'))
				{
					if((content.charAt(tracker+1) == '*'))
					{
						output = tracker;
						break;
					}
				}
			}
		}
		
		return output;		
	}
	
	public boolean isValidBoolean(String input)
	{
		//the variable contains yes/no 
		boolean result = false;
		String dataValue = input.toLowerCase();
		
		if(dataValue.compareTo("yes") == 0)
		{
			result = true;
		}
		else if(dataValue.compareTo("no") == 0)
		{
			result = true;
		}
		else if(dataValue.compareTo("y") == 0)
		{
			result = true;
		}
		else if(dataValue.compareTo("n") == 0)
		{
			result = true;
		}
		else if(dataValue.compareTo("1") == 0)
		{
			result = true;
		}
		else if(dataValue.compareTo("0") == 0)
		{
			result = true;
		}
		else if(dataValue.compareTo("true") == 0)
		{
			result = true;
		}
		else if(dataValue.compareTo("false") == 0)
		{
			result = true;
		}
		else
		{
			result = false;
		}
		
		return result;
	}
	
	public boolean isValidBigNumber(String dataValue)
	{
		/*
		 * the variable contains a number in range -2,147,483,647 
		 * to +2,147,483,647. The restriction is that bignumber 
		 * variables can not be assigned to anything else other 
		 * than other bigNumber variables, they are mainly used by 
		 * host and other custom functions to store big numbers. Big 
		 * numbers can be compared to each other, assigned to each other, etc.
		 */
		boolean result = false;
		int temp = 0;
		
		if(dataValue.compareTo("none") == 0)
		{
			result = true;
		}
		else if( isInteger(dataValue))
		{
			temp = Integer.parseInt(dataValue);
			
			if( (temp >= -2147483647) && (temp <= 2147483647) )
			{
				result = true;
			}
			else
			{
				result = false;
			}
		}
		else
		{
			result = false;
		}
			
			
		return result;
	}
	
	public boolean isValidNumber(String dataValue)
	{
		//the variable contains a number in the range 0 to 32767 
		boolean result = false;
		int temp = 0;
		
		if(dataValue.compareTo("none") == 0)
		{
			result = true;
		}
		else if( isInteger(dataValue))
		{
			temp = Integer.parseInt(dataValue);
			
			if( (temp >= 0) && (temp <=32767) )
			{
				result = true;
			}
			else
			{
				result = false;
			}
		}
		else
		{
			result = false;
		}
			
			
		return result;
	}
	
	public boolean isValidString(String dataValue)
	{
		//the variable contains a string of text up to 248 characters 
		boolean result = false;
		
		if(dataValue.length() <= 248)
		{
			result = true;
		}
		else
		{
			result = false;
		}
		
		return result;
	}
	
	public boolean isValidName(String dataValue)
	{
		//the variable contains a short string of up to 32 characters 
		boolean result = false;
		
		if(dataValue.compareTo("none") == 0)
		{
			result = true;
		}
		else if(dataValue.length() <= 32)
		{
			result = true;
		}
		else
		{
			result = false;
		}
		
		return result;
	}
	
	public boolean isValidPrompt(String dataValue, String Content)
	{
		//the prompt is comprised of m#s and pauses
			//M123
			//P10
		boolean result = false;
		
		
		if(dataValue.compareTo("none") == 0)
		{
			result = true;
		}
		else
		{
			if(dataValue.charAt(0) == 'M' || dataValue.charAt(0) == 'P')
			{
				if(dataValue.length() < 2)
				{
					result = false;
				}
				else
				{
					result = true;
					
					//all characters M, P or Integers
					for(int y = 0; y < dataValue.length(); y++)
					{
						if(!((dataValue.charAt(y) == 'M') || (dataValue.charAt(y) == 'P') || isInteger(dataValue.substring(y,y+1))))
						{
							result = false;
							break;
						}
					}
				}
			}
		}
		
		return result;
	}
	
	public boolean isValidCustomPrompt(String dataValue, String Content)
	{
		//the variable uses { and } to define a custom prompt message
		boolean result = false;
		int startIndex = 0;
		int endIndex = 1;
		boolean nextWord = true;
		String potentialWord = "";
		char testChar = '0';
		
		
		if(dataValue.compareTo("none") == 0)
		{
			result = true;
		}
		else
		{
			for(int tracker = 0; tracker < dataValue.length(); tracker++)
			{
				testChar = dataValue.charAt(tracker);
				
				if(dataValue.charAt(tracker) == '{')
				{
					continue;
				}
				else if((dataValue.charAt(tracker) == ' ') || (dataValue.charAt(tracker) == '}'))
				{
					endIndex = tracker;
					nextWord = true;
					
					potentialWord = dataValue.substring(startIndex,endIndex);
										
					//if not alpha or numeric
					if(!isAlpha(dataValue.substring(startIndex,endIndex)) && !isInteger(dataValue.substring(startIndex,endIndex)))
					{
						result = false;
						break;
					}
					
					//tracker++;
					if(dataValue.charAt(tracker) == '}')
					{
						result = true;
						break;
					}
					
				}
				
				if(nextWord)
				{
					startIndex = tracker;
					nextWord = false;
					continue;
				}
				
			}
		}
		
		return result;
	}
	public boolean isPromptValid(String dataValue, String Content)
	{
		//the variable contains the name of a prompt defined in the prompts section
		boolean result = false;
		
		if(dataValue.compareTo("none") == 0)
		{
			result = true;
		}
		else
		{
			result = VariableExists(dataValue, "[PROMPTS", Content);
			
		}
		
		return result;
	}
	
	public boolean isValidDynaPrompt(String dataValue)
	{
		/*
		 * the variable contains the dynamic prompts 
		 * which are the actual message string sent 
		 * to the ARU and can be modified at run-time 
		 * by the script. These may be call/user variables 
		 * which are maintained on a per call basis, or 
		 * application/param variables which are kept 
		 * on a per application basis. Note that assignment 
		 * of a normal prompt to dynaPrompt copies the 
		 * message string to the dynaPrompt. Assignment 
		 * of dynaPrompts to normal prompts is not allowed.
		 */
		boolean result = false;
		
		if(dataValue.compareTo("none") == 0)
		{
			result = true;
		}
		
		return result;
	}
	
	
	
	
	public boolean isValidPhone(String dataValue)
	{
		/*
		 * the variable contains a destination phone number which 
		 * is in the format: phoneNumber,callType,transferType or: 
		 * destinationName,callType,transferType the system ensures 
		 * that the phone# is numeric and the call/transfer types 
		 * are correct, andany referenced destination section is defined
		 */
		
		/* Call types:
		 * inband  picks any available outbound FG-D (non-ss7) trunk  
		 * normal  picks any available outbound ss7 trunk  
		 * rlt  picks an SS7 RLT capable outbound trunk going to the same switch as the IN port (calling party). When rlt is used with blind or preanswer, or postanswer transfer types, the call is released to the network and can no longer be manipulated on the platform after the outdial. rlt,bridge uses an RLT capable circuit, but bridges to two ports together in the USAN platform so they still can be manipulated. A portControl cell specifying rlt= can be used to RLT bridge these two ports together at a later time in the call flow and release them to the network.  
		 */
		
		/* Transfer types:
		 * blind  hangup specified port, then outdial the new number. If normal calling is used, then call progress is available, if RLT is used, then the call is released to the network and the network dials the new destination, therefore there is no call progress.  
		 * PreAnswer  hangup specified port, then outdials new number, then RLT bridges the two ports together as soon as the outdial is complete but does not wait for the answer. This is used in SS7 RLT circuits to initiate a new outbound call and then bridge them together without waiting for call progress.  
		 * PostAnswer  same as preAnswer, but waits for call progress. After the call is answered, the call is RLT bridged and released to the network.  
		 * bridge  hangup specified port, then outdials new number, waits for call progress. On answer it bridges the specified ports together. Note that there is no difference between normal, preAnswer, postAnswer and Bridge if the call type is normal or inband since they do not support ss7 RLT  
		 * consult  hangup specified port, then outdials new number, waits for call progress. On answer it bridges the OUT and OUT2 ports together  
		 * conference  same as consult, but on answer it conferences IN, OUT and OUT2  
		 * ask  Uses the transferType set in the c_askTransferType call variable. Its value should be one of the above types  
		 */
		
		boolean result = false;
		
		char testChar = ' ';
		String potentialWord = "";
		
		int startIndex = 0;
		int endIndex = 1;
		
		if(dataValue.compareTo("none") == 0)
		{
			result = true;
		}
		else if(dataValue.length() >= 10)
		{
			if(!isInteger(dataValue.substring(0,9)))
			{
				return false;
			}
			
			if(dataValue.length() > 10)
			{
				if(!(dataValue.charAt(10) == ','))
				{
					return false;
				}
				
				startIndex = 10;
				
				for(int x = 0; x < dataValue.length(); x++)
				{
					testChar = dataValue.charAt(x);
					
					if((dataValue.charAt(x) == ','))
					{
						endIndex = x;
						potentialWord = dataValue.substring(startIndex, endIndex);
						
						if((potentialWord.equals("inband")) || (potentialWord.equals("normal")) || (potentialWord.equals("rlt")))
						{
							for(int y = 0; y < dataValue.length(); y++)
							{
								testChar = dataValue.charAt(y);
								
								if((dataValue.charAt(y) == '\n') || (dataValue.charAt(y) == ' ') || (dataValue.charAt(y) == ';'))
								{
									if((potentialWord.equals("blind")) || (potentialWord.equals("PreAnswer")) || (potentialWord.equals("PostAnswer")) || (potentialWord.equals("bridge")) || (potentialWord.equals("consult")) || (potentialWord.equals("conference")) || (potentialWord.equals("ask")))
									{
										return true;
									}
									else
									{
										return false;
									}
								}
							}
						}
						else
						{
							//fail
							return false;
						}
						
						
						
					}
					else if(dataValue.charAt(x) == '\n')
					{
						return false;
					}
						
				}
				
				
				
				
				
			}
			result = true;
			
		}
		
		return result;
	}
	
	
	
	
	public boolean isValidCell(String dataValue, String content)
	{
		//the variable contains the name of a cell defined in this application
		boolean result = false;
		
		if(dataValue.compareTo("none") == 0)
		{
			result = true;
		}
		else
		{
			result = isCellValid(dataValue,content);
		}
		
		return result;
	}
	
	public boolean isValidPort(String input)
	{
		//the variable contains a port (in,aru,out or out2) 
		boolean result = false;
		String dataValue = input.toLowerCase();
		
		if(dataValue.compareTo("none") == 0)
		{
			result = true;
		}
		else if(dataValue.compareTo("in") == 0)
		{
			result = true;
		}
		else if(dataValue.compareTo("aru") == 0)
		{
			result = true;
		}
		else if(dataValue.compareTo("out") == 0)
		{
			result = true;
		}
		else if(dataValue.compareTo("out2") == 0)
		{
			result = true;
		}
		else
		{
			result = false;
		}
		
		return result;
	}
	
	public boolean isValidPortList(String dataValue)
	{
		//the variable contains a list of ports (in,aru,out,out2) 
		boolean result = false;
		
		if(dataValue.compareTo("none") == 0)
		{
			result = true;
		}
		
		return result;
	}
	
	public boolean isValidTodGroup(String dataValue)
	{
		//the variable contains the name of a timeOfDayGroup defined in this application script.
		boolean result = false;
		
		if(dataValue.compareTo("none") == 0)
		{
			result = true;
		}
		
		return result;
	}
	
	public boolean isValidPeg(String dataValue)
	{
		//the variable contains a pegId or peg name
		boolean result = false;
		
		if(dataValue.compareTo("none") == 0)
		{
			result = true;
		}
		
		return result;
	}
	
	public boolean isValidPegList(String dataValue)
	{
		//the variable contains a list of pegs 
		boolean result = false;
		
		if(dataValue.compareTo("none") == 0)
		{
			result = true;
		}
		
		return result;
	}
	
	
	
	public boolean isValidEnum(String dataValue)
	{
		/*
		 * the variable contains one of a list of enumerated 
		 * string values. The list of valid values is initially 
		 * specified in the call variables sections. On assignment, 
		 * the variable can be assigned one of the values in 
		 * the list. Internally the values are kept as numbers 
		 * corresponding to their order on the list with the 
		 * first value being assigned number zero. assigning 
		 * "none" to any enumeration is the same as assigning 
		 * it its first value on the list. Multiple enum variables 
		 * which have the exact same enumeration list are considered 
		 * equal types and may be assigned to each other. Call 
		 * and Parameter variables are predefined and their 
		 * enumeration list is also known before hand. therefore 
		 * they can be given in the variables sections with their 
		 * initial value. User and Application variables are defined 
		 * by the script. Therefore their enumaration list must be 
		 * specified in the variables section and they will always 
		 * have the first enum value as their initial value. 
		 */
		
		/*
		 * List is comma delimited restricting to 207 characters for a single element.
		 * List is limited to 207 for its total length
		 * 	This is long enough for 8 25 character strings deliminated by comma.
		 */
		
		boolean result = false;
		int tracker = 0;
		String target = "";
		int startIndex = 0;
		int endIndex = 1;
		boolean scanning = true;
		
		
		if(dataValue.compareTo("none") == 0)
		{
			result = false;
		}
		else if(dataValue.length() <= 207)
		{
			result = true;
		}
		
		return result;
		/*
		for(tracker=0; tracker < dataValue.length(); tracker++)
		{
			if(scanning == false)
			{
				scanning = true;
				startIndex = tracker;
			}
			
			if(dataValue.charAt(tracker) == (','))
			{
				endIndex = tracker;
				target = dataValue.substring(startIndex, endIndex);
				scanning = false;				
			}
			
		}
		*/
		
		
	}
	
	
	private boolean isInteger(String number)
	{
		boolean result = true;
		
		for(int x = 0; x < number.length(); x++)
		{
			if(!((number.charAt(x) == '0') || (number.charAt(x) == '1') || (number.charAt(x) == '2') || (number.charAt(x) == '3') || (number.charAt(x) == '4') || (number.charAt(x) == '5') || (number.charAt(x) == '6') || (number.charAt(x) == '7') || (number.charAt(x) == '8') || (number.charAt(x) == '9'))) 
			{
				return false;
			}
		}
		
		return result;		
	}
	
	private boolean isAlpha(String number)
	{
		boolean result = false;
		char testchar = ' ';
		
		for(int x = 0; x < number.length(); x++)
		{
			testchar = number.charAt(x);
			if(((number.charAt(x) == 'a') || (number.charAt(x) == 'b') || (number.charAt(x) == 'c') || (number.charAt(x) == 'd') || (number.charAt(x) == 'e') || (number.charAt(x) == 'f') || (number.charAt(x) == 'g') || (number.charAt(x) == 'h') || (number.charAt(x) == 'i') || (number.charAt(x) == 'j') || (number.charAt(x) == 'k') || (number.charAt(x) == 'l') || (number.charAt(x) == 'm') || (number.charAt(x) == 'n') || (number.charAt(x) == 'o') || (number.charAt(x) == 'p') || (number.charAt(x) == 'q') || (number.charAt(x) == 'r') || (number.charAt(x) == 's') || (number.charAt(x) == 't') || (number.charAt(x) == 'u') || (number.charAt(x) == 'v') || (number.charAt(x) == 'w') || (number.charAt(x) == 'x') || (number.charAt(x) == 'y') || (number.charAt(x) == 'z'))) 
			{
				return true;
			}
			else if(((number.charAt(x) == 'A') || (number.charAt(x) == 'B') || (number.charAt(x) == 'C') || (number.charAt(x) == 'D') || (number.charAt(x) == 'E') || (number.charAt(x) == 'F') || (number.charAt(x) == 'G') || (number.charAt(x) == 'H') || (number.charAt(x) == 'I') || (number.charAt(x) == 'J') || (number.charAt(x) == 'K') || (number.charAt(x) == 'L') || (number.charAt(x) == 'M') || (number.charAt(x) == 'N') || (number.charAt(x) == 'O') || (number.charAt(x) == 'P') || (number.charAt(x) == 'Q') || (number.charAt(x) == 'R') || (number.charAt(x) == 'S') || (number.charAt(x) == 'T') || (number.charAt(x) == 'U') || (number.charAt(x) == 'V') || (number.charAt(x) == 'W') || (number.charAt(x) == 'X') || (number.charAt(x) == 'Y') || (number.charAt(x) == 'Z'))) 
			{
				return true;
			}
		}
		
		return result;		
	}
	
	
	
	
	
}
