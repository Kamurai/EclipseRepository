[HISTORY]
/**********************************************************************
* Filename: CITIESLINE.APP
* History:*/
m o o m o o
/*
*  2012-06-29 ck01	CTG-4785 CESL_Update-Smith_Barney
**********************************************************************/
[APPLICATION]
name                            =CITIESLINE
filename                        =CITIESLINE.APP
description                     =Citi Employee Services Line
startingCell                    =startApplication

[CALL_VARIABLES]
c_trace,boolean                         =no
c_traceAssignments,boolean              =yes
c_traceDynaprompts,boolean              =yes
c_traceHostFunctions,boolean            =yes

c_createRdrs,boolean                    =yes
c_cdrApplCutsDet,boolean                =no
c_serviceId,name                        =MCEVsivrESAA
c_endTheCallCell,cell                   =none
c_noApplReply,boolean                   =no

/**********************************************************************
* BEGIN solicitTestParms u_vars
**********************************************************************/
u_testSequenceNumPrompt,dynaprompt      =none

u_cellReturnDebugSetup,cell             =none
u_cellReturnSolicit,cell                =none

u_askTesterForDnis,boolean              =yes
u_dnisManipulated,boolean               =no
u_askTestDnisLoopCount,number           =0
u_cellReturnAskTestDnis,cell            =none
u_testDnisFirstChar,name                =none
u_testDnisLastSix,name                  =none

u_askTesterForAni,boolean               =yes
u_aniManipulated,boolean                =no
u_askTestAniLoopCount,number            =0
u_cellReturnAskTestAni,cell             =none
u_testAniFirstChar,name                 =none
u_testAniLastNine,name                  =none

u_askTesterForNicm,boolean              =no
u_cellReturnAskNicmTask,cell            =none
/**********************************************************************
* END solicitTestParms u_vars
**********************************************************************/
u_selectOption,name                     =none
u_destRoute,phone                       =none
u_rltPreAnswer,name                     =,rlt,preAnswer
u_funcResult,number                     =0
u_delimVal,name                         =,


/**********************************************************************
* BEGIN CITI_ESLINE DB Load Declarations
**********************************************************************/
u_dnisKey,name                          =none
u_dnisLoadResult,boolean                =no
u_dnisDbReturnCell,cell                 =none
u_hoursStartClose,name                  =none

u_dnisNpa,name                          =none
u_dnisClient,name                       =none
u_dnisTrc,enum                          =NOTRACE,TEST,DEBUG,MANIP
u_dnisSivr,boolean                      =no
u_dnisGreeting,dynaPrompt               =none
u_dnisSpare5,name                       =none
u_dnisSpare4,name                       =none
u_dnisSpare3,name                       =none
u_dnisSpare2,name                       =none
u_dnisSpare1,name                       =none
u_dnisBankSrvc,phone                    =
u_dnisMortSrvc,phone                    =
u_dnisStudLoan,phone                    =
u_dnisCommBank,phone                    =
u_dnisSmithBarney,phone                 =
u_dnisChairman,phone                    =
u_dnisSmithBarneyCards,phone            =
u_dnisCredCardSrvc,phone                =
u_dnisPrivateBankClient,phone           =
u_dnisPersonalLoans,phone               =
u_dnisPrivateBank,phone                 =                          ;ap03
u_dnisBankPBSBSrvc,phone                =                          ;ap04
u_dnisMortPBSBSrvc,phone                =                          ;ap04  
u_dnisThankSBSrvc,phone                 =                          ;rs01
u_dnisThankSrvc,phone                   =                          ;rs01
u_dnisCommBankSrvc,phone                =                          ;rs02
u_dnisBusinessCrdSrvc,phone             =                          ;ath01
/**********************************************************************
*  END CITI_ESLINE DB Load Declarations
**********************************************************************/
/**********************************************************************
* BEGIN NICM u_vars ( not effective yet, but referenced)
**********************************************************************/
u_nicmTaskName,name                     =none
u_nicmDebugTrace,boolean                =yes
/**********************************************************************
* END NICM u_vars
**********************************************************************/
/**********************************************************************
* Begin HOURS OF OPERATION U_VARS                                  kt01
**********************************************************************/

u_hrsOfOpAreWeOpen,boolean              =no
u_hrsOfOpTodaysDay,name                 =none
u_hrsOfOpTodaysDate,name                =none
u_hrsOfOpTodaysTime,name                =none
u_hrsOpenCategory,name                  =none
u_hrsOfOpReturnCell,cell                =none
u_hrsOfOpTableToUse,name                =none
u_functionResult,number                 =none

[APPLICATION_VARIABLES]
/**********************************************************************
* BEGIN HOME DEPOT A_VAR INCLUDES
**********************************************************************/
a_menuTimeout,number                    =5            ;seconds
a_defaultTries,number                   =3
a_defaultHostTries,number               =1
a_defaultTimeout,number                 =5            ;seconds
/**********************************************************************
* BEGIN NICM a_vars ( not effective yet, but referenced)
**********************************************************************/
a_nicmTaskNameLocal,name                =CitiNicm
a_nicmTaskNameRemote,name               =RemoteNicm
/**********************************************************************
* END NICM a_vars
**********************************************************************/

/**********************************************************************
* Pegs for Procedure Reporting
**********************************************************************/
a_pegStartAppl,number                   =10
a_pegDnisLookup,number                  =20
a_pegDnisNotFound,number                =25
a_pegSivrOn,number                      =30
a_pegSivrOff,number                     =35
a_pegGreeting,number                    =40
a_pegMainMenu,number                    =100
a_pegBankCardMenu,number                =200
a_pegBankingMenu,number                 =220                       ;ap04
a_pegMortgageMenu,number                =240                       ;ap04
a_pegPersonalLoanMenu,number            =300
a_pegThankYouMenu,number                =305                       ;rs01
a_pegCheckWorkHours,number              =325
a_pegBankSrvcClosed,number              =330
a_pegMortSrvcClosed,number              =340
a_pegPersonalLoanClosed,number          =345
a_pegStudLoanClosed,number              =350
a_pegAutoLoanSvcProviderMsg,number      =365
a_pegCommBankClosed,number              =370
a_pegSmithBarneyClosed,number           =380
a_pegCredCardSrvcClosed,number          =390
a_pegPlayClosedHoursTotal,number        =395
a_pegTransferCall,number                =400
a_pegPrivateBankSrvcClosed,number       =410                       ;ap01
a_pegChairmanClosed,number              =420
a_pegPrivateBankClosed,number           =430                       ;ap03
a_pegBankPBSBSrvcClose,number           =435                       ;ap04
a_pegMortPBSBSrvcClose,number           =440                       ;ap04
a_pegThankSBSrvcClosed,number           =445                       ;rs01
a_pegThankSrvcClosed,number             =455                       ;rs01
a_pegCommBankSrvcClosed,number          =460                       ;rs02
a_pegBusinessCrdSrvcClosed,number       =470                       ;ath01


a_pegEndCallSBEndedDebitMsg,number      =9910                      ;ck01
a_pegSayGoodBye,number                  =9999
/**********************************************************************
* END HOME_DEPOT A_VAR INCLUDES
**********************************************************************/
/**********************************************************************
* BEGIN: Start Of Application
**********************************************************************/
[ASSIGN startApplication]
nextCell                        =startApplInitVars

[ASSIGN startApplInitVars]
id                              =10
reportId                        =a_pegStartAppl
c_hangupReportId                =!a_pegStartAppl
nextCell                        =initSetupDnisLoad

[ASSIGN initSetupDnisLoad]
id                              =20
reportId                        =a_pegDnisLookup
c_hangupReportId                =!a_pegDnisLookup
u_dnisKey                       =c_inboundDnis
u_dnisLoadResult                =no
u_dnisDbReturnCell              =initSetupDnisLoadResult
nextCell                        =dnisReadDb

/**********************************************************************
* If dnis not found in common table, transfer caller.
*   Otherwise, read table specific to app
**********************************************************************/
[IF     initSetupDnisLoadResult]
variable                        =u_dnisLoadResult
value1                          =yes
cell1                           =initSetupContinue
nextCell                        =initSetupDnisLoadFailed

[ASSIGN initSetupDnisLoadFailed]
id                              =25
reportId                        =a_pegDnisNotFound
c_hangupReportId                =!a_pegDnisNotFound
nextCell                        =sayGoodBye

/**********************************************************************
* Initial Setup Continues
* Check Trace Flag of configuration for inbound DNIS.
* For DEBUG and MANIP trace levels,
*     we voice sequence number to caller.
* For MANIP trace level,
*     we allow caller(tester) to enter test DNIS.  Using MANIP
*     level allows us to test all kinds of configurations while
*     only possessing one actual routing dnis.
**********************************************************************/
[IF     initSetupContinue]
variable                        =u_dnisTrc
value1                          =DEBUG
cell1                           =initSetupCallDebugSetup
value2                          =MANIP
cell2                           =initSetupCallDebugSetup
nextCell                        =startApplBeginNormalFlow

[ASSIGN initSetupCallDebugSetup]
u_cellReturnDebugSetup          =startApplBeginNormalFlow
nextCell                        =debugSetupModule
/**********************************************************************
* END START OF APPLICATION CELLS
**********************************************************************/
[ASSIGN startApplBeginNormalFlow]
u_selectOption                  =none
nextCell                        =checkForSivr      ;greetCaller

[IF  checkForSivr]
variable                        =u_dnisSivr
value1                          =no
cell1                           =turnSivrOff
nextCell                        =turnSivrOn

[ASSIGN    turnSivrOn]
id                              =30
reportId                        =a_pegSivrOn
c_hangupReportId                =!a_pegSivrOn
c_speechRecSelected             =yes
c_languageVersion               =1
nextCell                        =greetCaller

[ASSIGN    turnSivrOff]
id                              =35
reportId                        =a_pegSivrOff
c_hangupReportId                =!a_pegSivrOff
c_speechRecSelected             =no
c_languageVersion               =0
nextCell                        =greetCaller

[PROMPT      greetCaller]
id                              =40
reportId                        =a_pegGreeting
c_hangupReportId                =!a_pegGreeting
prompt                          =u_dnisGreeting                    ;ath01
nextCell                        =mainMenu

[MENU        mainMenu]
id                              =100
reportId                        =a_pegMainMenu
c_hangupReportId                =!a_pegMainMenu
retryPrompt                     =pr_notAvail
timeoutPrompt                   =pr_wereSorry
maxRetries                      =a_defaultTries
timeout                         =a_defaultTimeout
stopOnTimeout                   =no
selectionMethod                 =continuousAuto
sivrGrammar                     =Generic_Digit_0to9                ;rs01
sivrBargeIn                     =no
u_selectOption                  =none

[CHOICE initialGreet1Menu_Invalid]
choiceType                      =invalid
menuCell                        =mainMenu
nextCell                        =sayGoodBye

[CHOICE initialGreet1Menu_Timeout]
choiceType                      =timeout
menuCell                        =mainMenu
nextCell                        =sayGoodBye

[CHOICE mainMenu_Opt1]
dtmfChoicePrompt                =pr_forCreditCards
sivrChoicePrompt                =pr_forCreditCards
appendDigitPrompt               =yes
choiceType                      =both
choiceValue                     =1
menuCell                        =mainMenu
nextCell                        =bankcardMenu
u_selectOption                  =CreditCards
u_destRoute                     =u_dnisBankSrvc

[CHOICE mainMenu_Opt2]
dtmfChoicePrompt                =pr_forBanking
sivrChoicePrompt                =pr_forBanking
appendDigitPrompt               =yes
choiceType                      =both
choiceValue                     =2
menuCell                        =mainMenu
nextCell                        =bankingMenu                       ;ap04

[CHOICE mainMenu_Opt3]
dtmfChoicePrompt                =pr_forMortgages
sivrChoicePrompt                =pr_forMortgages
appendDigitPrompt               =yes
choiceType                      =both
choiceValue                     =3
menuCell                        =mainMenu
nextCell                        =ProOutSetupMortSrvc               ;ck01

[CHOICE mainMenu_Opt4]
dtmfChoicePrompt                =pr_forPersonalLoans
sivrChoicePrompt                =pr_forPersonalLoans
appendDigitPrompt               =yes
choiceType                      =both
choiceValue                     =4
menuCell                        =mainMenu
nextCell                        =personalLoanMenu
u_selectOption                  =PersonLoans
u_destRoute                     =u_dnisPersonalLoans


[CHOICE mainMenu_Opt5]
dtmfChoicePrompt                =pr_forStudentLoans
sivrChoicePrompt                =pr_forStudentLoans
appendDigitPrompt               =yes
choiceType                      =both
choiceValue                     =5
menuCell                        =mainMenu
u_selectOption                  =StudLoan
u_destRoute                     =u_dnisStudLoan
nextCell                        =processOutdial                    ;ap02

[CHOICE mainMenu_Opt6]
dtmfChoicePrompt                =pr_forAutoLoans
sivrChoicePrompt                =pr_forAutoLoans
appendDigitPrompt               =yes
choiceType                      =both
choiceValue                     =6
menuCell                        =mainMenu
nextCell                        =AutoLoanSvcProviderMsg            ;ath01

[CHOICE mainMenu_Opt7]
dtmfChoicePrompt                =pr_forCommBusiness
sivrChoicePrompt                =pr_forCommBusiness
appendDigitPrompt               =yes
choiceType                      =both
choiceValue                     =7
menuCell                        =mainMenu
u_selectOption                  =CommBank
u_destRoute                     =u_dnisCommBank
nextCell                        =processOutdial                    ;ap02

[CHOICE mainMenu_Opt8]
dtmfChoicePrompt                =pr_ifCallingSBClient
sivrChoicePrompt                =pr_ifCallingSBClient
appendDigitPrompt               =yes
choiceType                      =both
choiceValue                     =8
menuCell                        =mainMenu
nextCell                        =EndCallSBEndedDebitMsg            ;ck01

[CHOICE mainMenu_Opt9]                                             ;ap03
dtmfChoicePrompt                =pr_forPrivateBanking
sivrChoicePrompt                =pr_forPrivateBanking
appendDigitPrompt               =yes
choiceType                      =both
choiceValue                     =9
menuCell                        =mainMenu
u_selectOption                  =PrivateBank
u_destRoute                     =u_dnisPrivateBank
nextCell                        =processOutdial

[CHOICE mainMenu_Opt0]                                             ;rs01
dtmfChoicePrompt                =pr_forThankYouNet
sivrChoicePrompt                =pr_forThankYouNet
appendDigitPrompt               =yes
choiceType                      =both
choiceValue                     =0
menuCell                        =mainMenu
nextCell                        =thankYouMenu

[PROMPT AutoLoanSvcProviderMsg]                                    ;ath01
id                              =365
reportId                        =a_pegAutoLoanSvcProviderMsg
c_hangupReportId                =!a_pegAutoLoanSvcProviderMsg
prompt                          =pr_AutoLoanSvcProviderMsg
final                           =yes
nextCell                        =none

[MENU      bankcardMenu]
id                              =200
reportId                        =a_pegBankCardMenu
c_hangupReportId                =!a_pegBankCardMenu
retryPrompt                     =pr_notAvail
timeoutPrompt                   =pr_wereSorry
maxRetries                      =a_defaultTries
timeout                         =a_defaultTimeout
stopOnTimeout                   =no
selectionMethod                 =continuousAuto
sivrGrammar                     =Generic_Digit_1to6                ;ath01 ;rs02 ;rs01
sivrBargeIn                     =no
u_selectOption                  =0

[CHOICE bankcardMenu_Invalid]
choiceType                      =invalid
menuCell                        =bankcardMenu
nextCell                        =sayGoodBye

[CHOICE bankcardMenu_Timeout]
choiceType                      =timeout
menuCell                        =bankcardMenu
nextCell                        =sayGoodBye

[CHOICE bankcardMenu_Opt1]
dtmfChoicePrompt                =pr_citiChairmanCard
sivrChoicePrompt                =pr_citiChairmanCard
appendDigitPrompt               =yes
choiceType                      =both
choiceValue                     =1
menuCell                        =bankcardMenu
u_selectOption                  =Chairman
u_destRoute                     =u_dnisChairman
nextCell                        =processOutdial

[CHOICE bankcardMenu_Opt2]
dtmfChoicePrompt                =pr_ifCallingSBClient
sivrChoicePrompt                =pr_ifCallingSBClient
appendDigitPrompt               =yes
choiceType                      =both
choiceValue                     =2
menuCell                        =bankcardMenu
nextCell                        =EndCallSBEndedDebitMsg            ;ck01
  
[CHOICE bankcardMenu_Opt3]
dtmfChoicePrompt                =pr_forAllOtherCards
sivrChoicePrompt                =pr_forAllOtherCards
appendDigitPrompt               =yes
choiceType                      =both
choiceValue                     =3
menuCell                        =bankcardMenu
u_selectOption                  =CredCardSrvc
u_destRoute                     =u_dnisCredCardSrvc
nextCell                        =processOutdial

[CHOICE bankcardMenu_Opt4]                                         ;ap01
dtmfChoicePrompt                =pr_behalfPrivateBank
sivrChoicePrompt                =pr_behalfPrivateBank
appendDigitPrompt               =yes
choiceType                      =both
choiceValue                     =4
menuCell                        =bankcardMenu
u_selectOption                  =PrivateBankSrvc
u_destRoute                     =u_dnisPrivateBankClient
nextCell                        =processOutdial

[CHOICE bankcardMenu_Opt5]                                         ;rs02
dtmfChoicePrompt                =pr_behalfCommBankClient
sivrChoicePrompt                =pr_behalfCommBankClient
appendDigitPrompt               =yes
choiceType                      =both
choiceValue                     =5
menuCell                        =bankcardMenu
u_selectOption                  =CommBankSrvc
u_destRoute                     =u_dnisCommBankSrvc
nextCell                        =processOutdial

[CHOICE bankcardMenu_Opt6]                                         ;ath01
dtmfChoicePrompt                =pr_forBusinessCrd
sivrChoicePrompt                =pr_forBusinessCrd
appendDigitPrompt               =yes
choiceType                      =both
choiceValue                     =6
menuCell                        =bankcardMenu
u_selectOption                  =BusinessCrdSrvc
u_destRoute                     =u_dnisBusinessCrdSrvc
nextCell                        =processOutdial

[MENU bankingMenu]                                                 ;ap04
id                              =220
reportId                        =a_pegBankingMenu
c_hangupReportId                =!a_pegBankingMenu
retryPrompt                     =pr_notAvail
timeoutPrompt                   =pr_wereSorry
maxRetries                      =a_defaultTries
timeout                         =a_defaultTimeout
stopOnTimeout                   =no
selectionMethod                 =continuousAuto
sivrGrammar                     =Generic_Digit_1to2                ;rs01
sivrBargeIn                     =no
u_selectOption                  =0

[CHOICE bankingMenu_Invalid]
choiceType                      =invalid
menuCell                        =bankingMenu
nextCell                        =sayGoodBye

[CHOICE bankingMenu_Timeout]
choiceType                      =timeout
menuCell                        =bankingMenu
nextCell                        =sayGoodBye

[CHOICE bankingMenu_Opt1]
dtmfChoicePrompt                =pr_behalfPrivateBank              ;ck01
sivrChoicePrompt                =pr_behalfPrivateBank              ;ck01
appendDigitPrompt               =yes
choiceType                      =both
choiceValue                     =1
menuCell                        =bankingMenu
u_selectOption                  =BankPBSBSrvc
u_destRoute                     =u_dnisBankPBSBSrvc
nextCell                        =processOutdial

[CHOICE bankingMenu_Opt2]
dtmfChoicePrompt                =pr_allOtherBankingInq
sivrChoicePrompt                =pr_allOtherBankingInq
appendDigitPrompt               =yes
choiceType                      =both
choiceValue                     =2
menuCell                        =bankingMenu
u_selectOption                  =BankSrvc
u_destRoute                     =u_dnisBankSrvc
nextCell                        =processOutdial                    ;ap02

[MENU   personalLoanMenu]
id                              =300
reportId                        =a_pegPersonalLoanMenu
c_hangupReportId                =!a_pegPersonalLoanMenu
retryPrompt                     =pr_notAvail
timeoutPrompt                   =pr_wereSorry
maxRetries                      =a_defaultTries
timeout                         =a_defaultTimeout
stopOnTimeout                   =no
selectionMethod                 =continuousAuto
sivrGrammar                     =Generic_Digit_1to2                ;rs01
sivrBargeIn                     =no
u_selectOption                  =none

[CHOICE personalLoanMenu_Invalid]
choiceType                      =invalid
menuCell                        =personalLoanMenu
nextCell                        =sayGoodBye

[CHOICE personalLoanMenu_Timeout]
choiceType                      =timeout
menuCell                        =personalLoanMenu
nextCell                        =sayGoodBye

[CHOICE personalLoanMenu_Opt1]
dtmfChoicePrompt                =pr_forLoansReceived
sivrChoicePrompt                =pr_forLoansReceived
appendDigitPrompt               =yes
choiceType                      =both
choiceValue                     =1
menuCell                        =personalLoanMenu
u_selectOption                  =PersonLoans
u_destRoute                     =u_dnisPersonalLoans
nextCell                        =processOutdial                    ;ap02

[CHOICE personalLoanMenu_Opt2]
dtmfChoicePrompt                =pr_forAllOtherLoans
sivrChoicePrompt                =pr_forAllOtherLoans
appendDigitPrompt               =yes
choiceType                      =both
choiceValue                     =2
menuCell                        =personalLoanMenu
u_selectOption                  =BankSrvc
u_destRoute                     =u_dnisBankSrvc
nextCell                        =processOutdial                    ;ap02

[MENU thankYouMenu]                                                ;rs01
id                              =305
reportId                        =a_pegThankYouMenu
c_hangupReportId                =!a_pegThankYouMenu
retryPrompt                     =pr_notAvail
timeoutPrompt                   =pr_wereSorry
maxRetries                      =a_defaultTries
timeout                         =a_defaultTimeout
stopOnTimeout                   =no
selectionMethod                 =continuousAuto
sivrGrammar                     =Generic_Digit_1to2                ;rs01
sivrBargeIn                     =no
u_selectOption                  =none

[CHOICE thankYouMenu_Invalid]                                      ;rs01
choiceType                      =invalid
menuCell                        =thankYouMenu
nextCell                        =sayGoodBye

[CHOICE thankYouMenu_Timeout]                                      ;rs01
choiceType                      =timeout
menuCell                        =thankYouMenu
nextCell                        =sayGoodBye

[CHOICE thankYouMenu_Opt1]                                         ;rs01
dtmfChoicePrompt                =pr_ifCallingSBClient
sivrChoicePrompt                =pr_ifCallingSBClient
appendDigitPrompt               =yes
choiceType                      =both
choiceValue                     =1
menuCell                        =thankYouMenu
nextCell                        =EndCallSBEndedDebitMsg            ;ck01

[CHOICE thankYouMenu_Opt2]                                         ;rs01
dtmfChoicePrompt                =pr_allOtherThankInq
sivrChoicePrompt                =pr_allOtherThankInq
appendDigitPrompt               =yes
choiceType                      =both
choiceValue                     =2
menuCell                        =thankYouMenu
u_selectOption                  =ThankSrvc
u_destRoute                     =u_dnisThankSrvc
nextCell                        =processOutdial

;ck01 start
/************************************************************************
* Process Outdial Setup (Filter)
************************************************************************/
[ASSIGN ProOutSetupBankSrvc]
u_selectOption                  =CreditCards
u_destRoute                     =u_dnisBankSrvc
nextCell                        =processOutdial

[ASSIGN ProOutSetupMortSrvc]
u_selectOption                  =MortSrvc
u_destRoute                     =u_dnisMortSrvc
nextCell                        =processOutdial

[ASSIGN ProOutSetupStudLoan]
u_selectOption                  =StudLoan
u_destRoute                     =u_dnisStudLoan
nextCell                        =processOutdial

[ASSIGN ProOutSetupCommBank]
u_selectOption                  =CommBank
u_destRoute                     =u_dnisCommBank
nextCell                        =processOutdial

[ASSIGN ProOutSetupChairman]
u_selectOption                  =Chairman
u_destRoute                     =u_dnisChairman
nextCell                        =processOutdial

[ASSIGN ProOutSetupCredCardSrvc]
u_selectOption                  =CredCardSrvc
u_destRoute                     =u_dnisCredCardSrvc
nextCell                        =processOutdial

[ASSIGN ProOutSetupPersonalLoans]
u_selectOption                  =PersonLoans
u_destRoute                     =u_dnisPersonalLoans
nextCell                        =processOutdial

[ASSIGN ProOutSetupPrivateBankClient]
u_selectOption                  =PrivateBankSrvc
u_destRoute                     =u_dnisPrivateBankClient
nextCell                        =processOutdial

[ASSIGN ProOutSetupPrivateBank]
u_selectOption                  =PrivateBank
u_destRoute                     =u_dnisPrivateBank
nextCell                        =processOutdial

[ASSIGN ProOutSetupBankPBSBSrvc]
u_selectOption                  =BankPBSBSrvc
u_destRoute                     =u_dnisBankPBSBSrvc
nextCell                        =processOutdial

[ASSIGN ProOutSetupCommBankSrvc]
u_selectOption                  =CommBankSrvc
u_destRoute                     =u_dnisCommBankSrvc
nextCell                        =processOutdial

[ASSIGN ProOutSetupBusinessCrdSrvc]
u_selectOption                  =BusinessCrdSrvc
u_destRoute                     =u_dnisBusinessCrdSrvc
nextCell                        =processOutdial
/************************************************************************
* Process Outdial Setup
************************************************************************/
;ck01 end
/************************************************************************
* Process Outdial
************************************************************************/
[ASSIGN processOutdial]
id                              =325
reportId                        =a_pegCheckWorkHours
u_hrsOpenCategory               =!u_selectOption
u_hrsOfOpTableToUse             =CITI_ESLINE_HOURS
u_hrsOfOpReturnCell             =areWeOpen
nextCell                        =hrsOperModule

[IF     areWeOpen]
variable                        =u_hrsOfOpAreWeOpen
value1                          =yes
cell1                           =outdialAppendRltPre
nextCell                        =checkForValidSelections

[IF  checkForValidSelections]
variable                        =u_selectOption
value1                          =BankSrvc
cell1                           =BankSrvcClose
value2                          =MortSrvc
cell2                           =MortSrvcClose
value3                          =PersonLoans
cell3                           =PersLoanClose
value4                          =StudLoan
cell4                           =StudLoanClose
value5                          =BusinessCrdSrvc                   ;ath01 replaced autoLoan
cell5                           =BusinessCrdSrvcClose              ;ath01
value6                          =CommBank
cell6                           =CommBankClose
value7                          =SmithBarney
cell7                           =SmithBarneyClose
value8                          =PrivateBankSrvc
cell8                           =PrivateBankSrvcClose
value9                          =Chairman
cell9                           =ChairmanClose
value10                         =PrivateBank
cell10                          =PrivateBankClose
value11                         =BankPBSBSrvc                      ;ap04
cell11                          =BankPBSBSrvcClose                 ;ap04
value12                         =MortPBSBSrvc                      ;ap04
cell12                          =MortPBSBSrvcClose                 ;ap04
value13                         =ThankSBSrvc                       ;rs01
cell13                          =ThankSBSrvcClose                  ;rs01
value14                         =ThankSrvc                         ;rs01
cell14                          =ThankSrvcClose                    ;rs01
value15                         =CommBankSrvc                      ;rs02
cell15                          =CommBankSrvcClose                 ;rs02
nextCell                        =CredCardSrvcClose

[ASSIGN  BankSrvcClose]
id                              =330
reportId                        =a_pegBankSrvcClosed
c_hangupReportId                =!a_pegBankSrvcClosed
nextCell                        =playClosedHours

[ASSIGN  MortSrvcClose]
id                              =340
reportId                        =a_pegMortSrvcClosed
c_hangupReportId                =!a_pegMortSrvcClosed
nextCell                        =playClosedHours

[ASSIGN  PersLoanClose]
id                              =345
reportId                        =a_pegPersonalLoanClosed
c_hangupReportId                =!a_pegPersonalLoanClosed
nextCell                        =playClosedHours

[ASSIGN  StudLoanClose]
id                              =350
reportId                        =a_pegStudLoanClosed
c_hangupReportId                =!a_pegStudLoanClosed
nextCell                        =playClosedHours

[ASSIGN  CommBankClose]
id                              =370
reportId                        =a_pegCommBankClosed
c_hangupReportId                =!a_pegCommBankClosed
nextCell                        =playClosedHours

[ASSIGN  SmithBarneyClose]
id                              =380
reportId                        =a_pegSmithBarneyClosed
c_hangupReportId                =!a_pegSmithBarneyClosed
nextCell                        =playClosedHours

[ASSIGN  CredCardSrvcClose]
id                              =390
reportId                        =a_pegCredCardSrvcClosed
c_hangupReportId                =!a_pegCredCardSrvcClosed
nextCell                        =playClosedHours

[ASSIGN PrivateBankSrvcClose]
id                              =410
reportId                        =a_pegPrivateBankSrvcClosed
c_hangupReportId                =!a_pegPrivateBankSrvcClosed
nextCell                        =playClosedHours

[ASSIGN ChairmanClose]
id                              =420
reportId                        =a_pegChairmanClosed               ;ap03 changed the tense of close to closed (past tense)
c_hangupReportId                =!a_pegChairmanClosed
nextCell                        =playClosedHours

[ASSIGN PrivateBankClose]                                          ;ap03
id                              =430
reportId                        =a_pegPrivateBankClosed
c_hangupReportId                =!a_pegPrivateBankClosed
nextCell                        =playClosedHours

[ASSIGN BankPBSBSrvcClose]                                         ;ap04
id                              =435
reportId                        =a_pegBankPBSBSrvcClose
c_hangupReportId                =!a_pegBankPBSBSrvcClose
nextCell                        =playClosedHours

[ASSIGN MortPBSBSrvcClose]                                         ;ap04
id                              =440
reportId                        =a_pegMortPBSBSrvcClose
c_hangupReportId                =!a_pegMortPBSBSrvcClose
nextCell                        =playClosedHours

[ASSIGN ThankSBSrvcClose]                                          ;rs01
id                              =445
reportId                        =a_pegThankSBSrvcClosed
c_hangupReportId                =!a_pegThankSBSrvcClosed
nextCell                        =playClosedHours

[ASSIGN ThankSrvcClose]                                            ;rs01
id                              =455
reportId                        =a_pegThankSrvcClosed
c_hangupReportId                =!a_pegThankSrvcClosed
nextCell                        =playClosedHours

[ASSIGN CommBankSrvcClose]                                         ;rs02
id                              =460
reportId                        =a_pegCommBankSrvcClosed
c_hangupReportId                =!a_pegCommBankSrvcClosed
nextCell                        =playClosedHours

[ASSIGN BusinessCrdSrvcClose]                                      ;ath01
id                              =470
reportId                        =a_pegBusinessCrdSrvcClosed
c_hangupReportId                =!a_pegBusinessCrdSrvcClosed
nextCell                        =playClosedHours

[PROMPT  playClosedHours]
id                              =395
reportId                        =a_pegPlayClosedHoursTotal
c_hangupReportId                =!a_pegPlayClosedHoursTotal
prompt                          =pr_eslNotOpen
nextCell                        =sayGoodBye

/**********************************************************************
* Transfer Call Section
**********************************************************************/

[ASSIGN outdialAppendRltPre]
id                              =400
reportId                        =a_pegTransferCall
logVariables                    =u_destRoute
u_funcResult                    =f_strcat(u_destRoute,u_rltPreAnswer)
nextCell                        =outdialAgent

[OUTDIAL outdialAgent]
id                              =450
c_transferReportId              =!c_hangupReportId
c_hangupReportId                =!0
nextCell                        =none
phoneNumber                     =u_destRoute
outdialRule                     =11
outdialGroup                    =13
rnaTimeout                      =36
outdialPort                     =out
listenPorts                     =in
bridgeOnAnswer                  =in,out
bridgeOnFailure                 =in,aru
answerCell                      =connectedWaitForHangup
busyCell                        =promptSpeakOutDialError
rnaCell                         =promptSpeakOutDialError
reorderCell                     =promptSpeakOutDialError
dialErrorCell                   =promptSpeakOutDialError
allTrunksBusyCell               =promptSpeakOutDialError

[CONNECTED connectedWaitForHangup]
nextCell                        =none

[PROMPT promptSpeakOutDialError]
prompt                          =pr_busySignal
c_hangupReportId                =!c_transferReportId
c_transferReportId              =!0
final                           =yes
nextCell                        =none

/**********************************************************************
* End Call Section
**********************************************************************/

;ck01 start
[PROMPT EndCallSBEndedDebitMsg]
id                              = ;pivot
reportId                        =a_pegEndCallSBEndedDebitMsg
c_hangupReportId                =!a_pegEndCallSBEndedDebitMsg
prompt                          =pr_SBEndedDebitMsg
final                           =yes
nextCell                        =none
;ck01 end

[PROMPT sayGoodBye]
id                              =9999
reportId                        =a_pegSayGoodBye
prompt                          =pr_pleaseConsult
final                           =yes
nextCell                        =none
/**********************************************************************
* HOURS OF OPERATION MODULE                                        kt01
*  ;ap01 Cloned from STUDLOAN.APP
*
*  Inputs   : u_hrsOpenCategory
*  Outputs  : u_hrsOfOpAreWeOpen
*  Internal : u_hrsOfOpTodaysDay, u_hrsOfOpTodaysDate,
*             u_hrsOfOpTodaysTime, u_hrsOfOpTableToUse
*  Return   : u_hrsOfOpReturnCell
*  Notes    : Module determines current Date/Day/Time; Date is the
*             overriding Key, so first the module hits external table
*             u_hrsOfOpTableToUse with just Date as the Key; if a
*             table record is hit, then we know there are Date-specific
*             records in the table; module then sets up a Date/Time
*             Hit, which if found indicates open status; if the first
*             Date-only hit fails, then the module sets up a Day/Time
*             Hit, which if found indicates open status; module sets
*             u_hrsOfOpAreWeOpen accordingly and returs after all the
*             table interaction.
**********************************************************************/
[ASSIGN hrsOperModule]
u_hrsOfOpAreWeOpen              =no
u_hrsOfOpTodaysDay              =none
u_hrsOfOpTodaysDate             =none
u_hrsOfOpTodaysTime             =none
nextCell                        =hrsOperGetSysTime

[ASSIGN hrsOperGetSysTime]
externalFunction                =intDateTime
nextCell                        =hrsOperChkOnWestCoast

[IF     hrsOperChkOnWestCoast]
variable                        =c_nodeId
value1                  =400              ;node =SAC/SCU
cell1                           =hrsOperAdd3HoursToSysTime
nextCell                        =hrsOperDecodeSysTime

[ASSIGN hrsOperAdd3HoursToSysTime]
c_numberOperator                =!ADD
c_bigNumberOperand1             =!c_systemTime
c_bigNumberOperand2             =!10800          ;3 hours in seconds
externalFunction                =bigNumberMath
c_systemTime                    =c_bigNumberResult
nextCell                        =hrsOperDecodeSysTime

[ASSIGN hrsOperDecodeSysTime]
externalFunction                =decodeDateTime
nextCell                        =hrsOperBuildDate

[ASSIGN hrsOperBuildDate]
u_hrsOfOpTodaysDate             =c_year
u_functionResult                =f_strcat(u_hrsOfOpTodaysDate,c_month)
u_functionResult                =f_strcat(u_hrsOfOpTodaysDate,c_day)
nextCell                        =hrsOperChkDayOfWeek

[IF     hrsOperChkDayOfWeek]
variable                        =c_dayOfWeek
value1                          =SUNDAY
cell1                           =hrsOperSetDayOfWeek_Sunday
value2                          =MONDAY
cell2                           =hrsOperSetDayOfWeek_Monday
value3                          =TUESDAY
cell3                           =hrsOperSetDayOfWeek_Tuesday
value4                          =WEDNESDAY
cell4                           =hrsOperSetDayOfWeek_Wednesday
value5                          =THURSDAY
cell5                           =hrsOperSetDayOfWeek_Thursday
value6                          =FRIDAY
cell6                           =hrsOperSetDayOfWeek_Friday
value7                          =SATURDAY
cell7                           =hrsOperSetDayOfWeek_Saturday
nextCell                        =hrsOperExit

[ASSIGN hrsOperSetDayOfWeek_Sunday]
u_hrsOfOpTodaysDay              =Sunday
nextCell                        =hrsOperBuildTime

[ASSIGN hrsOperSetDayOfWeek_Monday]
u_hrsOfOpTodaysDay              =Monday
nextCell                        =hrsOperBuildTime

[ASSIGN hrsOperSetDayOfWeek_Tuesday]
u_hrsOfOpTodaysDay              =Tuesday
nextCell                        =hrsOperBuildTime

[ASSIGN hrsOperSetDayOfWeek_Wednesday]
u_hrsOfOpTodaysDay              =Wednesday
nextCell                        =hrsOperBuildTime

[ASSIGN hrsOperSetDayOfWeek_Thursday]
u_hrsOfOpTodaysDay              =Thursday
nextCell                        =hrsOperBuildTime

[ASSIGN hrsOperSetDayOfWeek_Friday]
u_hrsOfOpTodaysDay              =Friday
nextCell                        =hrsOperBuildTime

[ASSIGN hrsOperSetDayOfWeek_Saturday]
u_hrsOfOpTodaysDay              =Saturday
nextCell                        =hrsOperBuildTime

[ASSIGN hrsOperBuildTime]
u_hrsOfOpTodaysTime             =c_hour
u_functionResult                =f_strcat(u_hrsOfOpTodaysTime,c_minute)
nextCell                        =hrsOperTableClearExtdb

[ASSIGN hrsOperTableClearExtdb]
externalFunction                =clearExtdbFields
logVariables                    =u_hrsOfOpTodaysDate,u_hrsOfOpTodaysDay,u_hrsOfOpTodaysTime
nextCell                        =hrsOperTablePrepKeyJustDate

[ASSIGN hrsOperTablePrepKeyJustDate]
c_extdbFieldMatchType1          =StringEqual                       ;ab01
c_extdbFieldString1             =u_hrsOpenCategory                 ;ab01
c_extdbFieldMatchType2          =StringEqual
c_extdbFieldString2             =u_hrsOfOpTodaysDate
nextCell                        =hrsOperTableHitJustDate

[IF     hrsOperTableHitJustDate]
id                              =7150
c_extdbMatchWildcard            =!*
c_extdbName                     =!u_hrsOfOpTableToUse
c_extdbType                     =!loadAll
c_extdbOperator                 =!10     ;scan
externalFunction                =extdb
variable                        =c_extdbRecordIndex
value1                          =0       ;no match
cell1                           =hrsOperTablePrepKeyDayAndTime
nextCell                        =hrsOperTablePrepKeyDateAndTime

[ASSIGN hrsOperTablePrepKeyDayAndTime]
c_extdbFieldMatchType1          =StringEqual                       ;ab01
c_extdbFieldString1             =u_hrsOpenCategory                 ;ab01
c_extdbFieldMatchType2          =StringEqual
c_extdbFieldString2             =u_hrsOfOpTodaysDay
c_extdbFieldMatchType3          =StringGreaterThanEqual
c_extdbFieldString3             =u_hrsOfOpTodaysTime
c_extdbFieldMatchType4          =StringLessThanEqual
c_extdbFieldString4             =u_hrsOfOpTodaysTime
nextCell                        =hrsOperTableHitFinal

[ASSIGN hrsOperTablePrepKeyDateAndTime]
c_extdbFieldMatchType1          =StringEqual                       ;ab01
c_extdbFieldString1             =u_hrsOpenCategory                 ;ab01
c_extdbFieldMatchType2          =StringEqual
c_extdbFieldString2             =u_hrsOfOpTodaysDate
c_extdbFieldMatchType3          =StringGreaterThanEqual
c_extdbFieldString3             =u_hrsOfOpTodaysTime
c_extdbFieldMatchType4          =StringLessThanEqual
c_extdbFieldString4             =u_hrsOfOpTodaysTime
nextCell                        =hrsOperTableHitFinal

[IF     hrsOperTableHitFinal]
id                              =7155
c_extdbMatchWildcard            =!*
c_extdbName                     =!u_hrsOfOpTableToUse
c_extdbType                     =!loadAll
c_extdbOperator                 =!10     ;scan
externalFunction                =extdb
variable                        =c_extdbRecordIndex
value1                          =0       ;no match
cell1                           =hrsOperExit
nextCell                        =hrsOperTableLogRecordHit

[ASSIGN hrsOperTableLogRecordHit]
id                              =7160
logVariables                    =c_extdbFieldString1,c_extdbFieldString2,c_extdbFieldString3,c_extdbFieldString4
nextCell                        =hrsOperWeAreOpen

[ASSIGN hrsOperWeAreOpen]
u_hrsOfOpAreWeOpen              =yes
nextCell                        =hrsOperExit

[ASSIGN hrsOperExit]
nextCell                        =u_hrsOfOpReturnCell
/**********************************************************************
* HOURS OF OPERATION MODULE --> END                                kt01
**********************************************************************/

/**********************************************************************
* BEGIN: debugSetupModule
**********************************************************************/
[ASSIGN debugSetupModule]
nextCell                        =debugSetupMakeSequencePrompt

[CREATE_DYNAPROMPT debugSetupMakeSequencePrompt]
speakType1                      =number
value1                          =c_callSeqNumber
variable1                       =u_testSequenceNumPrompt
nextCell                        =debugSetupSpeakSequencePrompt

[PROMPT debugSetupSpeakSequencePrompt]
prompt                          =u_testSequenceNumPrompt
interruptable                   =yes
speakOnlyIfNotInterrupted       =yes
logEnabled                      =yes
c_traceAssignments              =yes
c_traceDynaprompts              =yes
c_traceCiti                     =yes
c_trace                         =yes
nextCell                        =debugSetupCheckForManip

[IF     debugSetupCheckForManip]
variable                        =u_dnisTrc
value1                          =MANIP
cell1                           =debugSetupCallSolicitParms
nextCell                        =debugSetupComplete

/**********************************************************************
* In MANIP mode, the caller is allow to entered alternate values for
* the inbound DNIS, the inbound ANI, as well a select the NICM interface
* to use (Citibank Production or Citibank Lab.
**********************************************************************/
[ASSIGN debugSetupCallSolicitParms]
u_cellReturnSolicit             =debugSetupDidDnisChange
nextCell                        =solicitTestParmsModule

[IF     debugSetupDidDnisChange]
variable                        =u_dnisManipulated
value1                          =yes
cell1                           =debugSetupLoadTestDnis
nextCell                        =debugSetupComplete
/**********************************************************************
* The application will re-read the dnis table. Call will
* proceed as if the entered DNIS was the actual inbound one.
**********************************************************************/
[ASSIGN debugSetupLoadTestDnis]
u_dnisKey                       =c_inboundDnis
u_dnisDbReturnCell              =debugSetupLoadTestDnisResult
nextCell                        =dnisReadDb

[IF     debugSetupLoadTestDnisResult]
variable                        =u_dnisLoadResult
value1                          =no
cell1                           =initSetupDnisLoadFailed
nextCell                        =debugSetupComplete

[ASSIGN debugSetupComplete]
nextCell                        =u_cellReturnDebugSetup
/**********************************************************************
* END debugSetupModule
**********************************************************************/

/**********************************************************************
* BEGIN solicitTestParmsModule
*  This module includes three sub-modules:
*   askTestDnisModule: asks caller for  7 digits for c_inboundDnis.
*   askTestAniModule:  asks caller for 10 digits for c_inboundAni.
*   askTestNicmModule: asks caller for choice of nicmScraper
*  If the modules are called in  the above order.
*  NOTE: Each module can be called individually
*        from elsewhere in the application.
*
* Input   u_askTesterForDnis boolean yes: invoke the askTestDnisModule
*         u_askTesterForAni  boolean yes: invoke the askTestAniModule
*         u_askTesterForNicm boolean yes: invoke the askNicmTaskModule
*         Other u_/a_ ***    See each individual module
**********************************************************************/
[ASSIGN solicitTestParmsModule]
nextCell                        =solicitTestParmsDnisOrNot

[IF     solicitTestParmsDnisOrNot]
variable                        =u_askTesterForDnis
value1                          =yes
cell1                           =askTestDnisModule
u_cellReturnAskTestDnis         =solicitTestParmsAniOrNot
nextCell                        =solicitTestParmsAniOrNot

[IF     solicitTestParmsAniOrNot]
variable                        =u_askTesterForAni
value1                          =yes
cell1                           =askTestAniModule
u_cellReturnAskTestAni          =solicitTestParmsNicmOrNot
nextCell                        =solicitTestParmsNicmOrNot

[IF     solicitTestParmsNicmOrNot]
variable                        =u_askTesterForNicm
value1                          =yes
cell1                           =askNicmTaskModule
u_cellReturnAskNicmTask         =solicitTestParmsComplete
nextCell                        =solicitTestParmsComplete

[ASSIGN solicitTestParmsComplete]
nextCell                        =u_cellReturnSolicit

/**********************************************************************
* BEGIN askTestDnisModule
* This menu will ask caller for value to substitute for c_inboundDnis.
* Caller may skip this input by hitting a # or * as first character.
* Input:  u_cellReturnAskTestDnis cell    what cell when complete?
* Output: c_inboundDnis           name    digits entered by caller.
**********************************************************************/
[ASSIGN askTestDnisModule]
u_askTestDnisLoopCount          =0
nextCell                        =askTestDnisFirstChar

[MENU   askTestDnisFirstChar]
prompt                          =pr_TestDnis
maxTries                        =1
timeout                         =5
choiceLenMin                    =1
choiceLenMax                    =1
selectionMethod                 =dtmf
nextCell                        =askTestDnisComplete

[CHOICE askTestDnisFirstCharInvalid]
choiceType                      =invalid
menuCell                        =askTestDnisFirstChar
nextCell                        =askTestDnisLoopCheck

[CHOICE askTestDnisFirstCharTimeout]
choiceType                      =timeout
menuCell                        =askTestDnisFirstChar
nextCell                        =askTestDnisLoopCheck

[CHOICE askTestDnisFirstCharGotIt]
choiceType                      =compute_dtmf
choiceValue                     =NUMERICDIGITSWITHINMINMAX
u_testDnisFirstChar             =c_enteredDigits
menuCell                        =askTestDnisFirstChar
nextCell                        =askTestDnisLastSix

[CHOICE askTestDnisFirstCharPoundSign]
enabled                         =yes
choiceType                      =dtmf
choiceValue                     =#
menuCell                        =askTestDnisFirstChar
nextCell                        =askTestDnisComplete

[CHOICE askTestDnisFirstCharStar]
enabled                         =yes
choiceType                      =dtmf
choiceValue                     =*
menuCell                        =askTestDnisFirstChar
nextCell                        =askTestDnisComplete

[MENU   askTestDnisLastSix]
enabled                         =yes
prompt                          =none
maxTries                        =1
timeout                         =5
choiceLenMin                    =6
choiceLenMax                    =6
selectionMethod                 =dtmf
nextCell                        =askTestDnisComplete

[CHOICE askTestDnisLastSixInvalid]
choiceType                      =invalid
menuCell                        =askTestDnisLastSix
nextCell                        =askTestDnisLoopCheck

[CHOICE askTestDnisLastSixTimeout]
choiceType                      =timeout
menuCell                        =askTestDnisLastSix
nextCell                        =askTestDnisLoopCheck

[CHOICE askTestDnisLastSixGotem]
choiceType                      =compute_dtmf
choiceValue                     =NUMERICDIGITSMAX
u_testDnisLastSix               =c_enteredDigits
menuCell                        =askTestDnisLastSix
nextCell                        =askTestDnisBuild

[ASSIGN askTestDnisBuild]
c_inboundDnis                   =!u_testDnisFirstChar
c_extdbFieldNumeric1            =f_strcat(c_inboundDnis, u_testDnisLastSix)
u_dnisManipulated               =yes
nextCell                        =askTestDnisComplete

[IF     askTestDnisLoopCheck]
c_extdbFieldNumeric1            =!f_increment(u_askTestDnisLoopCount)
variable                        =u_askTestDnisLoopCount
value1                          =3
cell1                           =askTestDnisComplete
nextCell                        =askTestDnisFirstChar

[ASSIGN askTestDnisComplete]
logVariables                    =c_inboundDnis
nextCell                        =u_cellReturnAskTestDnis
/**********************************************************************
* END askTestDnisModule
**********************************************************************/

/**********************************************************************
* BEGIN askTestAniModule
* This menu will ask caller for value to substitute for c_inboundAni.
* Caller may skip this input by hitting a # or * as first character.
* Input:  u_cellReturnAskTestAni cell    what cell when complete?
* Output: c_inboundAni           phone   digits entered by caller.
**********************************************************************/
[ASSIGN askTestAniModule]
u_askTestAniLoopCount           =0
nextCell                        =askTestAniFirstChar

[MENU   askTestAniFirstChar]
prompt                          =pr_TestAni
maxTries                        =1
timeout                         =5
choiceLenMin                    =1
choiceLenMax                    =1
selectionMethod                 =dtmf
nextCell                        =askTestAniComplete

[CHOICE askTestAniFirstCharInvalid]
choiceType                      =invalid
menuCell                        =askTestAniFirstChar
nextCell                        =askTestAniLoopCheck

[CHOICE askTestAniFirstCharTimeout]
choiceType                      =timeout
menuCell                        =askTestAniFirstChar
nextCell                        =askTestAniLoopCheck

[CHOICE askTestAniFirstCharGotIt]
choiceType                      =compute_dtmf
choiceValue                     =NUMERICDIGITSWITHINMINMAX
u_testAniFirstChar              =c_enteredDigits
menuCell                        =askTestAniFirstChar
nextCell                        =askTestAniLastNine

[CHOICE askTestAniFirstCharPoundSign]
enabled                         =yes
choiceType                      =dtmf
choiceValue                     =#
menuCell                        =askTestAniFirstChar
nextCell                        =askTestAniComplete

[CHOICE askTestAniFirstCharStar]
enabled                         =yes
choiceType                      =dtmf
choiceValue                     =*
menuCell                        =askTestAniFirstChar
nextCell                        =askTestAniComplete

[MENU   askTestAniLastNine]
enabled                         =yes
prompt                          =none
maxTries                        =1
timeout                         =5
choiceLenMin                    =9
choiceLenMax                    =9
selectionMethod                 =dtmf
nextCell                        =askTestAniComplete

[CHOICE askTestAniLastNineInvalid]
choiceType                      =invalid
menuCell                        =askTestAniLastNine
nextCell                        =askTestAniLoopCheck

[CHOICE askTestAniLastNineTimeout]
choiceType                      =timeout
menuCell                        =askTestAniLastNine
nextCell                        =askTestAniLoopCheck

[CHOICE askTestAniLastNineGotem]
choiceType                      =compute_dtmf
choiceValue                     =NUMERICDIGITSMAX
u_testAniLastNine               =c_enteredDigits
menuCell                        =askTestAniLastNine
nextCell                        =askTestAniBuild

[ASSIGN askTestAniBuild]
c_inboundAni                    =!u_testAniFirstChar
c_extdbFieldNumeric1            =f_strcat(c_inboundAni, u_testAniLastNine)
u_aniManipulated                =yes
nextCell                        =askTestAniComplete

[IF     askTestAniLoopCheck]
c_extdbFieldNumeric1            =!f_increment(u_askTestAniLoopCount)
variable                        =u_askTestAniLoopCount
value1                          =3
cell1                           =askTestAniComplete
nextCell                        =askTestAniFirstChar

[ASSIGN askTestAniComplete]
logVariables                    =c_inboundAni
nextCell                        =u_cellReturnAskTestAni
/**********************************************************************
* END askTestAniModule
**********************************************************************/

/**********************************************************************
* BEGIN askNicmTaskModule
* This module will ask the caller for a choice of either the production
* nicm interface(through CPZ) or the lab interface(long island, thru lab)
* NOTE1: Currently, this only is valid in the lab. This is signaled by
*        the c_nodeId being equal to 999. If the c_nodeId is not 999,
*        this module will simply return. The a_nicmTaskNameLocal will
*        cause communication thru the local nicmScraper in the lab,
*        thereby using the Citibank Long Island Lab PG. The
*        a_nicmTaskNameRemote will talk to the passthru backend process,
*        which forwards requests to the production nicmScraper on CPZ.
* NOTE2: The following three variables are not declared in the include
*        file decl.solicitParms. It is assummed that they are defined
*        elsewhere, as part of the nicm infrastructure.
*            a_nicmTaskNameLocal,name  =CitiNicm
*            a_nicmTaskNameRemote,name =RemoteNicm
*            u_nicmTaskName,name       =CitiNicm
*
* ANOTHER NOTE: the u_nicmTaskName will be set here only if the caller
*               presses 1 or 2. If this module returns for any other
*               reason, u_nicmTaskName will not be touched. It is left
*               to the coder to insure a default value.
*
* Input:  a_nicmTaskNameLocal  name ->backend nicmScraper
*         a_nicmTaskNameRemote name ->backend passthru to CPZ nicmScraper
* Output: u_nicmTaskName
* Return: u_cellReturnAskNicmTask
**********************************************************************/
[ASSIGN askNicmTaskModule]
nextCell                        =askNicmTaskCheckNodeId

[IF     askNicmTaskCheckNodeId]
variable                        =c_nodeId
value1                          =999
cell1                           =askNicmTaskMenu
nextCell                        =askNicmTaskComplete

[MENU   askNicmTaskMenu]
prompt                          =none
maxRetries                      =3
timeout                         =5
stopOnTimeout                   =no
selectionMethod                 =dtmf
nextCell                        =askNicmTaskComplete

[CHOICE askNicmTaskChoiceInvalid]
choiceType                      =invalid
menuCell                        =askNicmTaskMenu
nextCell                        =askNicmTaskComplete

[CHOICE askNicmTaskChoiceTimeout]
choiceType                      =timeout
menuCell                        =askNicmTaskMenu
nextCell                        =askNicmTaskComplete

[CHOICE askNicmTaskChoiceOne]
enabled                         =yes
dtmfChoicePrompt                =pr_ForProdNicm
appendDigitPrompt               =no
choiceType                      =dtmf
choiceValue                     =1
u_nicmTaskName                  =a_nicmTaskNameRemote
menuCell                        =askNicmTaskMenu
nextCell                        =askNicmTaskComplete

[CHOICE askNicmTaskChoiceTwo]
enabled                         =yes
dtmfChoicePrompt                =pr_ForLabNicm
appendDigitPrompt               =no
choiceType                      =dtmf
choiceValue                     =2
u_nicmTaskName                  =a_nicmTaskNameLocal
menuCell                        =askNicmTaskMenu
nextCell                        =askNicmTaskComplete

[CHOICE askNicmTaskChoicePoundSign]
enabled                         =yes
choiceType                      =dtmf
choiceValue                     =#
menuCell                        =askNicmTaskMenu
nextCell                        =askNicmTaskComplete

[CHOICE askNicmTaskChoiceStar]
enabled                         =yes
choiceType                      =dtmf
choiceValue                     =*
menuCell                        =askNicmTaskMenu
nextCell                        =askNicmTaskComplete

[ASSIGN askNicmTaskComplete]
logVariables                    =u_nicmTaskName
nextCell                        =u_cellReturnAskNicmTask
/**********************************************************************
* END: solicitTestParmsModule
**********************************************************************/
/**********************************************************************
* BEGIN: READ DNIS DATABASE
* Input:  u_dnisKey            = input DNIS(key)
*
* Output: u_dnisLoadResult       = no (Not Found)
*                                = yes (Found)
*         u_dnisXxxxxx (variables set from db record)
**********************************************************************/
[ASSIGN    dnisReadDb]
nextCell                        =dnisReadInfoFromDb

[IF dnisReadInfoFromDb]
externalFunction                =extdb
c_extdbName                     =!CITI_ESLINE
c_extdbKey                      =!u_dnisKey
c_extdbOperator                 =!0
variable                        =c_extdbFound
value1                          =0                         ;not found
cell1                           =dnisFailedDbLookup      ;not found
nextCell                        =dnisSetInfoFromDb

[ASSIGN dnisFailedDbLookup]
logvariables                    =c_extdbName,c_extdbKey,c_extdbFound
u_dnisLoadResult                =no
nextCell                        =u_dnisDbReturnCell

[ASSIGN dnisSetInfoFromDb]
nextCell                        =dnisGetFirstVars

[ASSIGN dnisGetFirstVars]
u_dnisClient                    =c_extdbFieldString1
u_dnisNpa                       =c_extdbFieldString2
;u_dnisTrc               =c_extdbFieldString3
nextCell                        =dnisTrace

/**********************************************************************
* If u_dnisTrace is already set, keep it.
**********************************************************************/
[IF     dnisTrace]
variable                        =u_dnisTrc
value1                          =NOTRACE
cell1                           =dnisTraceBranch
nextCell                        =dnisAssignRest

[IF     dnisTraceBranch]
variable                        =c_extdbFieldString3
value1                          =Prod
cell1                           =dnisTraceNone
value2                          =Test
cell2                           =dnisTraceTest
value3                          =Debug
cell3                           =dnisTraceDebug
value4                          =Manip
cell4                           =dnisTraceManip
nextCell                        =dnisTraceNone

[ASSIGN dnisTraceNone]
u_dnisTrc                       =NOTRACE
c_trace                         =no
c_traceHostFunctions            =no
u_nicmDebugTrace                =no
nextCell                        =dnisAssignRest

[ASSIGN dnisTraceTest]
u_dnisTrc                       =TEST
c_trace                         =yes
c_traceHostFunctions            =yes
u_nicmDebugTrace                =no
nextCell                        =dnisAssignRest

[ASSIGN dnisTraceDebug]
u_dnisTrc                       =DEBUG
c_trace                         =yes
c_traceHostFunctions            =yes
u_nicmDebugTrace                =yes
nextCell                        =dnisAssignRest

[ASSIGN dnisTraceManip]
u_dnisTrc                       =MANIP
c_trace                         =yes
c_traceHostFunctions            =yes
u_nicmDebugTrace                =yes
nextCell                        =dnisAssignRest

[ASSIGN dnisAssignRest]
u_dnisSivr                      =c_extdbFieldString4
u_dnisGreeting                  =c_extdbFieldString5               ;ath01
u_dnisSpare5                    =c_extdbFieldString6
u_dnisSpare4                    =c_extdbFieldString7
u_dnisSpare3                    =c_extdbFieldString8
u_dnisSpare2                    =c_extdbFieldString9
u_dnisSpare1                    =c_extdbFieldString10
u_dnisBankSrvc                  =c_extdbFieldString11
u_dnisMortSrvc                  =c_extdbFieldString12
u_dnisStudLoan                  =c_extdbFieldString13
u_dnisCommBank                  =c_extdbFieldString15
u_dnisSmithBarney               =c_extdbFieldString16              ;ck01 de-commissioned
u_dnisChairman                  =c_extdbFieldString17
u_dnisSmithBarneyCards          =c_extdbFieldString18              ;ck01 de-commissioned
u_dnisCredCardSrvc              =c_extdbFieldString19
u_dnisPersonalLoans             =c_extdbFieldString20
u_dnisPrivateBankClient         =c_extdbFieldString21              ;ap01
u_dnisPrivateBank               =c_extdbFieldString22              ;ap03
u_dnisBankPBSBSrvc              =c_extdbFieldString23              ;ap04
u_dnisMortPBSBSrvc              =c_extdbFieldString24              ;ck01 de-commissioned  
u_dnisThankSBSrvc               =c_extdbFieldString25              ;ck01 de-commissioned
u_dnisThankSrvc                 =c_extdbFieldString26              ;rs01
u_dnisCommBankSrvc              =c_extdbFieldString27              ;rs02
u_dnisBusinessCrdSrvc           =c_extdbFieldString28              ;ath01
nextCell                        =dispVars1

[ASSIGN  dispVars1]
logVariables                    =u_dnisSivr,u_dnisBankSrvc,u_dnisMortSrvc,u_dnisStudLoan
nextCell                        =dispVars2

[ASSIGN dispVars2]
logVariables                    =u_dnisCommBank,u_dnisSmithBarney,u_dnisChairman,u_dnisSmithBarneyCards
nextCell                        =dispVars3

[ASSIGN dispVars3]
logVariables                    =u_dnisCredCardSrvc, u_dnisPersonalLoans, u_dnisBankSrvc, u_dnisPrivateBank
nextCell                        =commonLoadFinish

[ASSIGN  commonLoadFinish]
nextCell                        =commonLoadFinish2

[ASSIGN commonLoadFinish2]
u_dnisLoadResult                =yes
nextCell                        =u_dnisDbReturnCell

/**********************************************************************
* END: READ COMMON DATABASE
**********************************************************************/
/**********************************************************************
* BEGIN PROMPT SECTIONS
**********************************************************************/
[PROMPTS English]
/**********************************************************************
* English Version 0 - For DTMF only mode.
* Note:  This section also covers most prompts for sivr mode(English
*        Version 1).  When English Version 1 is processed: If a prompt
*        is not found in version 1, the prompt will be pulled from
*        version 0.  This is good, since most prompts are the same,
*        regardless of the input mode.
**********************************************************************/
pr_ForLabNicm                   =M20833M4541
pr_ForProdNicm                  =M20832M4540
pr_TestAni                      =M20831
pr_TestDnis                     =M20830
pr_busySignal                   =M22002

pr_AutoLoanSvcProviderMsg       =M162350                           ;ath01
pr_SBEndedDebitMsg              =M164999                           ;ck01

pr_WelcomeCitiGroup             =M88418
pr_forCreditCards               =M88420
pr_forBanking                   =M88421
pr_forMortgages                 =M88422
pr_forPersonalLoans             =M88423
pr_forStudentLoans              =M88424
pr_forAutoLoans                 =M88425
pr_forCommBusiness              =M97128
pr_forPrivateBanking            =M141258
pr_forBusinessCrd               =M162349                           ;ath01

pr_behalfPrivateBank            =M139662

pr_behalfSBPBClient             =M143217                           ;ap04
pr_allOtherBankingInq           =M143218                           ;ap04
pr_allOtherMortInq              =M143219                           ;ap04

pr_allOtherThankInq             =M147151                           ;rs01
pr_forThankYouNet               =M147150                           ;rs01

pr_wereSorry                    =M43689
pr_notAvail                     =M88427

pr_citiChairmanCard             =M99152
pr_ifCallingSBClient            =M99153
pr_forAllOtherCards             =M99154

pr_forLoansReceived             =M97126
pr_forAllOtherLoans             =M97127
pr_eslNotOpen                   =M88419
pr_pleaseConsult                =M139562                           ;ap03M88428

pr_ThankyouForCalling           =M85033

pr_behalfCommBankClient         =M161605                           ;rs02

/**********************************************************************
* Pin Prompts English
**********************************************************************/

[PROMPTS English 1]
/**********************************************************************
* English Version 1 - Prompts for SIVR mode(speech or dtmf accepted)
* Note:  This only contains prompts which need to be different for
*        automatic detection of speech or dtmf input. If a referenced
*        prompt is not found here, the prompt is located in version 0.
**********************************************************************/

[PROMPTS Spanish]
/**********************************************************************
* Spanish Version 0 - Puerto Rican Dialect
**********************************************************************/

[DIGIT_PROMPTS English]
/**********************************************************************
*  DIGIT PROMPTS English Version 0
**********************************************************************/
dollar                          =M33254
dollars                         =M33255
/**********************************************************************
* ????
*   cent                  =
*   cents                 =
*   dollar_and            =
*   dollars_and           =
* ????
**********************************************************************/
thousandSuffix                  =M33251
millionSuffix                   =M33252
thousandsSuffix                 =M33251
millionsSuffix                  =M33252
billionSuffix                   =;??????????
thousandDollarsSuffix           =;?????????
millionDollarsSuffix            =;??????????
billionDollarsSuffix            =;??????????
/**********************************************************************
* Months: January thru December
**********************************************************************/
month_1                         =M33112
month_2                         =M33113
month_3                         =M33114
month_4                         =M33115
month_5                         =M33116
month_6                         =M33117
month_7                         =M33118
month_8                         =M33119
month_9                         =M33120
month_10                        =M33121
month_11                        =M33122
month_12                        =M33123
/**********************************************************************
* Ordinals:  first thru thirty-first
**********************************************************************/
nth_1                           =M33124
nth_2                           =M33125
nth_3                           =M33126
nth_4                           =M33127
nth_5                           =M33128
nth_6                           =M33129
nth_7                           =M33130
nth_8                           =M33131
nth_9                           =M33132
nth_10                          =M33133
nth_11                          =M33134
nth_12                          =M33135
nth_13                          =M33136
nth_14                          =M33137
nth_15                          =M33138
nth_16                          =M33139
nth_17                          =M33140
nth_18                          =M33141
nth_19                          =M33142
nth_20                          =M33143
nth_21                          =M33144
nth_22                          =M33145
nth_23                          =M33146
nth_24                          =M33147
nth_25                          =M33148
nth_26                          =M33149
nth_27                          =M33150
nth_28                          =M33151
nth_29                          =M33152
nth_30                          =M33153
nth_31                          =M33154
/**********************************************************************
* "N" ; N = 1 thru 999
**********************************************************************/
number_0                        =M30000
number_1                        =M30001
number_2                        =M30002
number_3                        =M30003
number_4                        =M30004
number_5                        =M30005
number_6                        =M30006
number_7                        =M30007
number_8                        =M30008
number_9                        =M30009
number_10                       =M30010
number_11                       =M30011
number_12                       =M30012
number_13                       =M30013
number_14                       =M30014
number_15                       =M30015
number_16                       =M30016
number_17                       =M30017
number_18                       =M30018
number_19                       =M30019
number_20                       =M30020
number_21                       =M30021
number_22                       =M30022
number_23                       =M30023
number_24                       =M30024
number_25                       =M30025
number_26                       =M30026
number_27                       =M30027
number_28                       =M30028
number_29                       =M30029
number_30                       =M30030
number_31                       =M30031
number_32                       =M30032
number_33                       =M30033
number_34                       =M30034
number_35                       =M30035
number_36                       =M30036
number_37                       =M30037
number_38                       =M30038
number_39                       =M30039
number_40                       =M30040
number_41                       =M30041
number_42                       =M30042
number_43                       =M30043
number_44                       =M30044
number_45                       =M30045
number_46                       =M30046
number_47                       =M30047
number_48                       =M30048
number_49                       =M30049
number_50                       =M30050
number_51                       =M30051
number_52                       =M30052
number_53                       =M30053
number_54                       =M30054
number_55                       =M30055
number_56                       =M30056
number_57                       =M30057
number_58                       =M30058
number_59                       =M30059
number_60                       =M30060
number_61                       =M30061
number_62                       =M30062
number_63                       =M30063
number_64                       =M30064
number_65                       =M30065
number_66                       =M30066
number_67                       =M30067
number_68                       =M30068
number_69                       =M30069
number_70                       =M30070
number_71                       =M30071
number_72                       =M30072
number_73                       =M30073
number_74                       =M30074
number_75                       =M30075
number_76                       =M30076
number_77                       =M30077
number_78                       =M30078
number_79                       =M30079
number_80                       =M30080
number_81                       =M30081
number_82                       =M30082
number_83                       =M30083
number_84                       =M30084
number_85                       =M30085
number_86                       =M30086
number_87                       =M30087
number_88                       =M30088
number_89                       =M30089
number_90                       =M30090
number_91                       =M30091
number_92                       =M30092
number_93                       =M30093
number_94                       =M30094
number_95                       =M30095
number_96                       =M30096
number_97                       =M30097
number_98                       =M30098
number_99                       =M30099
number_100                      =M30100
number_101                      =M30101
number_102                      =M30102
number_103                      =M30103
number_104                      =M30104
number_105                      =M30105
number_106                      =M30106
number_107                      =M30107
number_108                      =M30108
number_109                      =M30109
number_110                      =M30110
number_111                      =M30111
number_112                      =M30112
number_113                      =M30113
number_114                      =M30114
number_115                      =M30115
number_116                      =M30116
number_117                      =M30117
number_118                      =M30118
number_119                      =M30119
number_120                      =M30120
number_121                      =M30121
number_122                      =M30122
number_123                      =M30123
number_124                      =M30124
number_125                      =M30125
number_126                      =M30126
number_127                      =M30127
number_128                      =M30128
number_129                      =M30129
number_130                      =M30130
number_131                      =M30131
number_132                      =M30132
number_133                      =M30133
number_134                      =M30134
number_135                      =M30135
number_136                      =M30136
number_137                      =M30137
number_138                      =M30138
number_139                      =M30139
number_140                      =M30140
number_141                      =M30141
number_142                      =M30142
number_143                      =M30143
number_144                      =M30144
number_145                      =M30145
number_146                      =M30146
number_147                      =M30147
number_148                      =M30148
number_149                      =M30149
number_150                      =M30150
number_151                      =M30151
number_152                      =M30152
number_153                      =M30153
number_154                      =M30154
number_155                      =M30155
number_156                      =M30156
number_157                      =M30157
number_158                      =M30158
number_159                      =M30159
number_160                      =M30160
number_161                      =M30161
number_162                      =M30162
number_163                      =M30163
number_164                      =M30164
number_165                      =M30165
number_166                      =M30166
number_167                      =M30167
number_168                      =M30168
number_169                      =M30169
number_170                      =M30170
number_171                      =M30171
number_172                      =M30172
number_173                      =M30173
number_174                      =M30174
number_175                      =M30175
number_176                      =M30176
number_177                      =M30177
number_178                      =M30178
number_179                      =M30179
number_180                      =M30180
number_181                      =M30181
number_182                      =M30182
number_183                      =M30183
number_184                      =M30184
number_185                      =M30185
number_186                      =M30186
number_187                      =M30187
number_188                      =M30188
number_189                      =M30189
number_190                      =M30190
number_191                      =M30191
number_192                      =M30192
number_193                      =M30193
number_194                      =M30194
number_195                      =M30195
number_196                      =M30196
number_197                      =M30197
number_198                      =M30198
number_199                      =M30199
number_200                      =M30200
number_201                      =M30201
number_202                      =M30202
number_203                      =M30203
number_204                      =M30204
number_205                      =M30205
number_206                      =M30206
number_207                      =M30207
number_208                      =M30208
number_209                      =M30209
number_210                      =M30210
number_211                      =M30211
number_212                      =M30212
number_213                      =M30213
number_214                      =M30214
number_215                      =M30215
number_216                      =M30216
number_217                      =M30217
number_218                      =M30218
number_219                      =M30219
number_220                      =M30220
number_221                      =M30221
number_222                      =M30222
number_223                      =M30223
number_224                      =M30224
number_225                      =M30225
number_226                      =M30226
number_227                      =M30227
number_228                      =M30228
number_229                      =M30229
number_230                      =M30230
number_231                      =M30231
number_232                      =M30232
number_233                      =M30233
number_234                      =M30234
number_235                      =M30235
number_236                      =M30236
number_237                      =M30237
number_238                      =M30238
number_239                      =M30239
number_240                      =M30240
number_241                      =M30241
number_242                      =M30242
number_243                      =M30243
number_244                      =M30244
number_245                      =M30245
number_246                      =M30246
number_247                      =M30247
number_248                      =M30248
number_249                      =M30249
number_250                      =M30250
number_251                      =M30251
number_252                      =M30252
number_253                      =M30253
number_254                      =M30254
number_255                      =M30255
number_256                      =M30256
number_257                      =M30257
number_258                      =M30258
number_259                      =M30259
number_260                      =M30260
number_261                      =M30261
number_262                      =M30262
number_263                      =M30263
number_264                      =M30264
number_265                      =M30265
number_266                      =M30266
number_267                      =M30267
number_268                      =M30268
number_269                      =M30269
number_270                      =M30270
number_271                      =M30271
number_272                      =M30272
number_273                      =M30273
number_274                      =M30274
number_275                      =M30275
number_276                      =M30276
number_277                      =M30277
number_278                      =M30278
number_279                      =M30279
number_280                      =M30280
number_281                      =M30281
number_282                      =M30282
number_283                      =M30283
number_284                      =M30284
number_285                      =M30285
number_286                      =M30286
number_287                      =M30287
number_288                      =M30288
number_289                      =M30289
number_290                      =M30290
number_291                      =M30291
number_292                      =M30292
number_293                      =M30293
number_294                      =M30294
number_295                      =M30295
number_296                      =M30296
number_297                      =M30297
number_298                      =M30298
number_299                      =M30299
number_300                      =M30300
number_301                      =M30301
number_302                      =M30302
number_303                      =M30303
number_304                      =M30304
number_305                      =M30305
number_306                      =M30306
number_307                      =M30307
number_308                      =M30308
number_309                      =M30309
number_310                      =M30310
number_311                      =M30311
number_312                      =M30312
number_313                      =M30313
number_314                      =M30314
number_315                      =M30315
number_316                      =M30316
number_317                      =M30317
number_318                      =M30318
number_319                      =M30319
number_320                      =M30320
number_321                      =M30321
number_322                      =M30322
number_323                      =M30323
number_324                      =M30324
number_325                      =M30325
number_326                      =M30326
number_327                      =M30327
number_328                      =M30328
number_329                      =M30329
number_330                      =M30330
number_331                      =M30331
number_332                      =M30332
number_333                      =M30333
number_334                      =M30334
number_335                      =M30335
number_336                      =M30336
number_337                      =M30337
number_338                      =M30338
number_339                      =M30339
number_340                      =M30340
number_341                      =M30341
number_342                      =M30342
number_343                      =M30343
number_344                      =M30344
number_345                      =M30345
number_346                      =M30346
number_347                      =M30347
number_348                      =M30348
number_349                      =M30349
number_350                      =M30350
number_351                      =M30351
number_352                      =M30352
number_353                      =M30353
number_354                      =M30354
number_355                      =M30355
number_356                      =M30356
number_357                      =M30357
number_358                      =M30358
number_359                      =M30359
number_360                      =M30360
number_361                      =M30361
number_362                      =M30362
number_363                      =M30363
number_364                      =M30364
number_365                      =M30365
number_366                      =M30366
number_367                      =M30367
number_368                      =M30368
number_369                      =M30369
number_370                      =M30370
number_371                      =M30371
number_372                      =M30372
number_373                      =M30373
number_374                      =M30374
number_375                      =M30375
number_376                      =M30376
number_377                      =M30377
number_378                      =M30378
number_379                      =M30379
number_380                      =M30380
number_381                      =M30381
number_382                      =M30382
number_383                      =M30383
number_384                      =M30384
number_385                      =M30385
number_386                      =M30386
number_387                      =M30387
number_388                      =M30388
number_389                      =M30389
number_390                      =M30390
number_391                      =M30391
number_392                      =M30392
number_393                      =M30393
number_394                      =M30394
number_395                      =M30395
number_396                      =M30396
number_397                      =M30397
number_398                      =M30398
number_399                      =M30399
number_400                      =M30400
number_401                      =M30401
number_402                      =M30402
number_403                      =M30403
number_404                      =M30404
number_405                      =M30405
number_406                      =M30406
number_407                      =M30407
number_408                      =M30408
number_409                      =M30409
number_410                      =M30410
number_411                      =M30411
number_412                      =M30412
number_413                      =M30413
number_414                      =M30414
number_415                      =M30415
number_416                      =M30416
number_417                      =M30417
number_418                      =M30418
number_419                      =M30419
number_420                      =M30420
number_421                      =M30421
number_422                      =M30422
number_423                      =M30423
number_424                      =M30424
number_425                      =M30425
number_426                      =M30426
number_427                      =M30427
number_428                      =M30428
number_429                      =M30429
number_430                      =M30430
number_431                      =M30431
number_432                      =M30432
number_433                      =M30433
number_434                      =M30434
number_435                      =M30435
number_436                      =M30436
number_437                      =M30437
number_438                      =M30438
number_439                      =M30439
number_440                      =M30440
number_441                      =M30441
number_442                      =M30442
number_443                      =M30443
number_444                      =M30444
number_445                      =M30445
number_446                      =M30446
number_447                      =M30447
number_448                      =M30448
number_449                      =M30449
number_450                      =M30450
number_451                      =M30451
number_452                      =M30452
number_453                      =M30453
number_454                      =M30454
number_455                      =M30455
number_456                      =M30456
number_457                      =M30457
number_458                      =M30458
number_459                      =M30459
number_460                      =M30460
number_461                      =M30461
number_462                      =M30462
number_463                      =M30463
number_464                      =M30464
number_465                      =M30465
number_466                      =M30466
number_467                      =M30467
number_468                      =M30468
number_469                      =M30469
number_470                      =M30470
number_471                      =M30471
number_472                      =M30472
number_473                      =M30473
number_474                      =M30474
number_475                      =M30475
number_476                      =M30476
number_477                      =M30477
number_478                      =M30478
number_479                      =M30479
number_480                      =M30480
number_481                      =M30481
number_482                      =M30482
number_483                      =M30483
number_484                      =M30484
number_485                      =M30485
number_486                      =M30486
number_487                      =M30487
number_488                      =M30488
number_489                      =M30489
number_490                      =M30490
number_491                      =M30491
number_492                      =M30492
number_493                      =M30493
number_494                      =M30494
number_495                      =M30495
number_496                      =M30496
number_497                      =M30497
number_498                      =M30498
number_499                      =M30499
number_500                      =M30500
number_501                      =M30501
number_502                      =M30502
number_503                      =M30503
number_504                      =M30504
number_505                      =M30505
number_506                      =M30506
number_507                      =M30507
number_508                      =M30508
number_509                      =M30509
number_510                      =M30510
number_511                      =M30511
number_512                      =M30512
number_513                      =M30513
number_514                      =M30514
number_515                      =M30515
number_516                      =M30516
number_517                      =M30517
number_518                      =M30518
number_519                      =M30519
number_520                      =M30520
number_521                      =M30521
number_522                      =M30522
number_523                      =M30523
number_524                      =M30524
number_525                      =M30525
number_526                      =M30526
number_527                      =M30527
number_528                      =M30528
number_529                      =M30529
number_530                      =M30530
number_531                      =M30531
number_532                      =M30532
number_533                      =M30533
number_534                      =M30534
number_535                      =M30535
number_536                      =M30536
number_537                      =M30537
number_538                      =M30538
number_539                      =M30539
number_540                      =M30540
number_541                      =M30541
number_542                      =M30542
number_543                      =M30543
number_544                      =M30544
number_545                      =M30545
number_546                      =M30546
number_547                      =M30547
number_548                      =M30548
number_549                      =M30549
number_550                      =M30550
number_551                      =M30551
number_552                      =M30552
number_553                      =M30553
number_554                      =M30554
number_555                      =M30555
number_556                      =M30556
number_557                      =M30557
number_558                      =M30558
number_559                      =M30559
number_560                      =M30560
number_561                      =M30561
number_562                      =M30562
number_563                      =M30563
number_564                      =M30564
number_565                      =M30565
number_566                      =M30566
number_567                      =M30567
number_568                      =M30568
number_569                      =M30569
number_570                      =M30570
number_571                      =M30571
number_572                      =M30572
number_573                      =M30573
number_574                      =M30574
number_575                      =M30575
number_576                      =M30576
number_577                      =M30577
number_578                      =M30578
number_579                      =M30579
number_580                      =M30580
number_581                      =M30581
number_582                      =M30582
number_583                      =M30583
number_584                      =M30584
number_585                      =M30585
number_586                      =M30586
number_587                      =M30587
number_588                      =M30588
number_589                      =M30589
number_590                      =M30590
number_591                      =M30591
number_592                      =M30592
number_593                      =M30593
number_594                      =M30594
number_595                      =M30595
number_596                      =M30596
number_597                      =M30597
number_598                      =M30598
number_599                      =M30599
number_600                      =M30600
number_601                      =M30601
number_602                      =M30602
number_603                      =M30603
number_604                      =M30604
number_605                      =M30605
number_606                      =M30606
number_607                      =M30607
number_608                      =M30608
number_609                      =M30609
number_610                      =M30610
number_611                      =M30611
number_612                      =M30612
number_613                      =M30613
number_614                      =M30614
number_615                      =M30615
number_616                      =M30616
number_617                      =M30617
number_618                      =M30618
number_619                      =M30619
number_620                      =M30620
number_621                      =M30621
number_622                      =M30622
number_623                      =M30623
number_624                      =M30624
number_625                      =M30625
number_626                      =M30626
number_627                      =M30627
number_628                      =M30628
number_629                      =M30629
number_630                      =M30630
number_631                      =M30631
number_632                      =M30632
number_633                      =M30633
number_634                      =M30634
number_635                      =M30635
number_636                      =M30636
number_637                      =M30637
number_638                      =M30638
number_639                      =M30639
number_640                      =M30640
number_641                      =M30641
number_642                      =M30642
number_643                      =M30643
number_644                      =M30644
number_645                      =M30645
number_646                      =M30646
number_647                      =M30647
number_648                      =M30648
number_649                      =M30649
number_650                      =M30650
number_651                      =M30651
number_652                      =M30652
number_653                      =M30653
number_654                      =M30654
number_655                      =M30655
number_656                      =M30656
number_657                      =M30657
number_658                      =M30658
number_659                      =M30659
number_660                      =M30660
number_661                      =M30661
number_662                      =M30662
number_663                      =M30663
number_664                      =M30664
number_665                      =M30665
number_666                      =M30666
number_667                      =M30667
number_668                      =M30668
number_669                      =M30669
number_670                      =M30670
number_671                      =M30671
number_672                      =M30672
number_673                      =M30673
number_674                      =M30674
number_675                      =M30675
number_676                      =M30676
number_677                      =M30677
number_678                      =M30678
number_679                      =M30679
number_680                      =M30680
number_681                      =M30681
number_682                      =M30682
number_683                      =M30683
number_684                      =M30684
number_685                      =M30685
number_686                      =M30686
number_687                      =M30687
number_688                      =M30688
number_689                      =M30689
number_690                      =M30690
number_691                      =M30691
number_692                      =M30692
number_693                      =M30693
number_694                      =M30694
number_695                      =M30695
number_696                      =M30696
number_697                      =M30697
number_698                      =M30698
number_699                      =M30699
number_700                      =M30700
number_701                      =M30701
number_702                      =M30702
number_703                      =M30703
number_704                      =M30704
number_705                      =M30705
number_706                      =M30706
number_707                      =M30707
number_708                      =M30708
number_709                      =M30709
number_710                      =M30710
number_711                      =M30711
number_712                      =M30712
number_713                      =M30713
number_714                      =M30714
number_715                      =M30715
number_716                      =M30716
number_717                      =M30717
number_718                      =M30718
number_719                      =M30719
number_720                      =M30720
number_721                      =M30721
number_722                      =M30722
number_723                      =M30723
number_724                      =M30724
number_725                      =M30725
number_726                      =M30726
number_727                      =M30727
number_728                      =M30728
number_729                      =M30729
number_730                      =M30730
number_731                      =M30731
number_732                      =M30732
number_733                      =M30733
number_734                      =M30734
number_735                      =M30735
number_736                      =M30736
number_737                      =M30737
number_738                      =M30738
number_739                      =M30739
number_740                      =M30740
number_741                      =M30741
number_742                      =M30742
number_743                      =M30743
number_744                      =M30744
number_745                      =M30745
number_746                      =M30746
number_747                      =M30747
number_748                      =M30748
number_749                      =M30749
number_750                      =M30750
number_751                      =M30751
number_752                      =M30752
number_753                      =M30753
number_754                      =M30754
number_755                      =M30755
number_756                      =M30756
number_757                      =M30757
number_758                      =M30758
number_759                      =M30759
number_760                      =M30760
number_761                      =M30761
number_762                      =M30762
number_763                      =M30763
number_764                      =M30764
number_765                      =M30765
number_766                      =M30766
number_767                      =M30767
number_768                      =M30768
number_769                      =M30769
number_770                      =M30770
number_771                      =M30771
number_772                      =M30772
number_773                      =M30773
number_774                      =M30774
number_775                      =M30775
number_776                      =M30776
number_777                      =M30777
number_778                      =M30778
number_779                      =M30779
number_780                      =M30780
number_781                      =M30781
number_782                      =M30782
number_783                      =M30783
number_784                      =M30784
number_785                      =M30785
number_786                      =M30786
number_787                      =M30787
number_788                      =M30788
number_789                      =M30789
number_790                      =M30790
number_791                      =M30791
number_792                      =M30792
number_793                      =M30793
number_794                      =M30794
number_795                      =M30795
number_796                      =M30796
number_797                      =M30797
number_798                      =M30798
number_799                      =M30799
number_800                      =M30800
number_801                      =M30801
number_802                      =M30802
number_803                      =M30803
number_804                      =M30804
number_805                      =M30805
number_806                      =M30806
number_807                      =M30807
number_808                      =M30808
number_809                      =M30809
number_810                      =M30810
number_811                      =M30811
number_812                      =M30812
number_813                      =M30813
number_814                      =M30814
number_815                      =M30815
number_816                      =M30816
number_817                      =M30817
number_818                      =M30818
number_819                      =M30819
number_820                      =M30820
number_821                      =M30821
number_822                      =M30822
number_823                      =M30823
number_824                      =M30824
number_825                      =M30825
number_826                      =M30826
number_827                      =M30827
number_828                      =M30828
number_829                      =M30829
number_830                      =M30830
number_831                      =M30831
number_832                      =M30832
number_833                      =M30833
number_834                      =M30834
number_835                      =M30835
number_836                      =M30836
number_837                      =M30837
number_838                      =M30838
number_839                      =M30839
number_840                      =M30840
number_841                      =M30841
number_842                      =M30842
number_843                      =M30843
number_844                      =M30844
number_845                      =M30845
number_846                      =M30846
number_847                      =M30847
number_848                      =M30848
number_849                      =M30849
number_850                      =M30850
number_851                      =M30851
number_852                      =M30852
number_853                      =M30853
number_854                      =M30854
number_855                      =M30855
number_856                      =M30856
number_857                      =M30857
number_858                      =M30858
number_859                      =M30859
number_860                      =M30860
number_861                      =M30861
number_862                      =M30862
number_863                      =M30863
number_864                      =M30864
number_865                      =M30865
number_866                      =M30866
number_867                      =M30867
number_868                      =M30868
number_869                      =M30869
number_870                      =M30870
number_871                      =M30871
number_872                      =M30872
number_873                      =M30873
number_874                      =M30874
number_875                      =M30875
number_876                      =M30876
number_877                      =M30877
number_878                      =M30878
number_879                      =M30879
number_880                      =M30880
number_881                      =M30881
number_882                      =M30882
number_883                      =M30883
number_884                      =M30884
number_885                      =M30885
number_886                      =M30886
number_887                      =M30887
number_888                      =M30888
number_889                      =M30889
number_890                      =M30890
number_891                      =M30891
number_892                      =M30892
number_893                      =M30893
number_894                      =M30894
number_895                      =M30895
number_896                      =M30896
number_897                      =M30897
number_898                      =M30898
number_899                      =M30899
number_900                      =M30900
number_901                      =M30901
number_902                      =M30902
number_903                      =M30903
number_904                      =M30904
number_905                      =M30905
number_906                      =M30906
number_907                      =M30907
number_908                      =M30908
number_909                      =M30909
number_910                      =M30910
number_911                      =M30911
number_912                      =M30912
number_913                      =M30913
number_914                      =M30914
number_915                      =M30915
number_916                      =M30916
number_917                      =M30917
number_918                      =M30918
number_919                      =M30919
number_920                      =M30920
number_921                      =M30921
number_922                      =M30922
number_923                      =M30923
number_924                      =M30924
number_925                      =M30925
number_926                      =M30926
number_927                      =M30927
number_928                      =M30928
number_929                      =M30929
number_930                      =M30930
number_931                      =M30931
number_932                      =M30932
number_933                      =M30933
number_934                      =M30934
number_935                      =M30935
number_936                      =M30936
number_937                      =M30937
number_938                      =M30938
number_939                      =M30939
number_940                      =M30940
number_941                      =M30941
number_942                      =M30942
number_943                      =M30943
number_944                      =M30944
number_945                      =M30945
number_946                      =M30946
number_947                      =M30947
number_948                      =M30948
number_949                      =M30949
number_950                      =M30950
number_951                      =M30951
number_952                      =M30952
number_953                      =M30953
number_954                      =M30954
number_955                      =M30955
number_956                      =M30956
number_957                      =M30957
number_958                      =M30958
number_959                      =M30959
number_960                      =M30960
number_961                      =M30961
number_962                      =M30962
number_963                      =M30963
number_964                      =M30964
number_965                      =M30965
number_966                      =M30966
number_967                      =M30967
number_968                      =M30968
number_969                      =M30969
number_970                      =M30970
number_971                      =M30971
number_972                      =M30972
number_973                      =M30973
number_974                      =M30974
number_975                      =M30975
number_976                      =M30976
number_977                      =M30977
number_978                      =M30978
number_979                      =M30979
number_980                      =M30980
number_981                      =M30981
number_982                      =M30982
number_983                      =M30983
number_984                      =M30984
number_985                      =M30985
number_986                      =M30986
number_987                      =M30987
number_988                      =M30988
number_989                      =M30989
number_990                      =M30990
number_991                      =M30991
number_992                      =M30992
number_993                      =M30993
number_994                      =M30994
number_995                      =M30995
number_996                      =M30996
number_997                      =M30997
number_998                      =M30998
number_999                      =M30999
/**********************************************************************
* "N dollars"; N = 1 thru 999
**********************************************************************/
dollars_0                       =M31000
dollars_1                       =M31001
dollars_2                       =M31002
dollars_3                       =M31003
dollars_4                       =M31004
dollars_5                       =M31005
dollars_6                       =M31006
dollars_7                       =M31007
dollars_8                       =M31008
dollars_9                       =M31009
dollars_10                      =M31010
dollars_11                      =M31011
dollars_12                      =M31012
dollars_13                      =M31013
dollars_14                      =M31014
dollars_15                      =M31015
dollars_16                      =M31016
dollars_17                      =M31017
dollars_18                      =M31018
dollars_19                      =M31019
dollars_20                      =M31020
dollars_21                      =M31021
dollars_22                      =M31022
dollars_23                      =M31023
dollars_24                      =M31024
dollars_25                      =M31025
dollars_26                      =M31026
dollars_27                      =M31027
dollars_28                      =M31028
dollars_29                      =M31029
dollars_30                      =M31030
dollars_31                      =M31031
dollars_32                      =M31032
dollars_33                      =M31033
dollars_34                      =M31034
dollars_35                      =M31035
dollars_36                      =M31036
dollars_37                      =M31037
dollars_38                      =M31038
dollars_39                      =M31039
dollars_40                      =M31040
dollars_41                      =M31041
dollars_42                      =M31042
dollars_43                      =M31043
dollars_44                      =M31044
dollars_45                      =M31045
dollars_46                      =M31046
dollars_47                      =M31047
dollars_48                      =M31048
dollars_49                      =M33316
dollars_50                      =M31050
dollars_51                      =M31051
dollars_52                      =M31052
dollars_53                      =M31053
dollars_54                      =M31054
dollars_55                      =M31055
dollars_56                      =M31056
dollars_57                      =M31057
dollars_58                      =M31058
dollars_59                      =M31059
dollars_60                      =M31060
dollars_61                      =M31061
dollars_62                      =M31062
dollars_63                      =M31063
dollars_64                      =M31064
dollars_65                      =M31065
dollars_66                      =M31066
dollars_67                      =M31067
dollars_68                      =M31068
dollars_69                      =M31069
dollars_70                      =M31070
dollars_71                      =M31071
dollars_72                      =M31072
dollars_73                      =M31073
dollars_74                      =M31074
dollars_75                      =M31075
dollars_76                      =M31076
dollars_77                      =M31077
dollars_78                      =M31078
dollars_79                      =M31079
dollars_80                      =M31080
dollars_81                      =M31081
dollars_82                      =M31082
dollars_83                      =M31083
dollars_84                      =M31084
dollars_85                      =M31085
dollars_86                      =M31086
dollars_87                      =M31087
dollars_88                      =M31088
dollars_89                      =M31089
dollars_90                      =M31090
dollars_91                      =M31091
dollars_92                      =M31092
dollars_93                      =M31093
dollars_94                      =M31094
dollars_95                      =M31095
dollars_96                      =M31096
dollars_97                      =M31097
dollars_98                      =M31098
dollars_99                      =M31099
dollars_100                     =M31100
dollars_101                     =M31101
dollars_102                     =M31102
dollars_103                     =M31103
dollars_104                     =M31104
dollars_105                     =M31105
dollars_106                     =M31106
dollars_107                     =M31107
dollars_108                     =M31108
dollars_109                     =M31109
dollars_110                     =M31110
dollars_111                     =M31111
dollars_112                     =M31112
dollars_113                     =M31113
dollars_114                     =M31114
dollars_115                     =M31115
dollars_116                     =M31116
dollars_117                     =M31117
dollars_118                     =M31118
dollars_119                     =M31119
dollars_120                     =M31120
dollars_121                     =M31121
dollars_122                     =M31122
dollars_123                     =M31123
dollars_124                     =M31124
dollars_125                     =M31125
dollars_126                     =M31126
dollars_127                     =M31127
dollars_128                     =M31128
dollars_129                     =M31129
dollars_130                     =M31130
dollars_131                     =M31131
dollars_132                     =M31132
dollars_133                     =M31133
dollars_134                     =M31134
dollars_135                     =M31135
dollars_136                     =M31136
dollars_137                     =M31137
dollars_138                     =M31138
dollars_139                     =M31139
dollars_140                     =M31140
dollars_141                     =M31141
dollars_142                     =M31142
dollars_143                     =M31143
dollars_144                     =M31144
dollars_145                     =M31145
dollars_146                     =M31146
dollars_147                     =M31147
dollars_148                     =M31148
dollars_149                     =M31149
dollars_150                     =M31150
dollars_151                     =M31151
dollars_152                     =M31152
dollars_153                     =M31153
dollars_154                     =M31154
dollars_155                     =M31155
dollars_156                     =M31156
dollars_157                     =M31157
dollars_158                     =M31158
dollars_159                     =M31159
dollars_160                     =M31160
dollars_161                     =M31161
dollars_162                     =M31162
dollars_163                     =M31163
dollars_164                     =M31164
dollars_165                     =M31165
dollars_166                     =M31166
dollars_167                     =M31167
dollars_168                     =M31168
dollars_169                     =M31169
dollars_170                     =M31170
dollars_171                     =M31171
dollars_172                     =M31172
dollars_173                     =M31173
dollars_174                     =M31174
dollars_175                     =M31175
dollars_176                     =M31176
dollars_177                     =M31177
dollars_178                     =M31178
dollars_179                     =M31179
dollars_180                     =M31180
dollars_181                     =M31181
dollars_182                     =M31182
dollars_183                     =M31183
dollars_184                     =M31184
dollars_185                     =M31185
dollars_186                     =M31186
dollars_187                     =M31187
dollars_188                     =M31188
dollars_189                     =M31189
dollars_190                     =M31190
dollars_191                     =M31191
dollars_192                     =M31192
dollars_193                     =M31193
dollars_194                     =M31194
dollars_195                     =M31195
dollars_196                     =M31196
dollars_197                     =M31197
dollars_198                     =M31198
dollars_199                     =M31199
dollars_200                     =M31200
dollars_201                     =M31201
dollars_202                     =M31202
dollars_203                     =M31203
dollars_204                     =M31204
dollars_205                     =M31205
dollars_206                     =M31206
dollars_207                     =M31207
dollars_208                     =M31208
dollars_209                     =M31209
dollars_210                     =M31210
dollars_211                     =M31211
dollars_212                     =M31212
dollars_213                     =M31213
dollars_214                     =M31214
dollars_215                     =M31215
dollars_216                     =M31216
dollars_217                     =M31217
dollars_218                     =M31218
dollars_219                     =M31219
dollars_220                     =M31220
dollars_221                     =M31221
dollars_222                     =M31222
dollars_223                     =M31223
dollars_224                     =M31224
dollars_225                     =M31225
dollars_226                     =M31226
dollars_227                     =M31227
dollars_228                     =M31228
dollars_229                     =M31229
dollars_230                     =M31230
dollars_231                     =M31231
dollars_232                     =M31232
dollars_233                     =M31233
dollars_234                     =M31234
dollars_235                     =M31235
dollars_236                     =M31236
dollars_237                     =M31237
dollars_238                     =M31238
dollars_239                     =M31239
dollars_240                     =M31240
dollars_241                     =M31241
dollars_242                     =M31242
dollars_243                     =M31243
dollars_244                     =M31244
dollars_245                     =M31245
dollars_246                     =M31246
dollars_247                     =M31247
dollars_248                     =M31248
dollars_249                     =M31249
dollars_250                     =M31250
dollars_251                     =M31251
dollars_252                     =M31252
dollars_253                     =M31253
dollars_254                     =M31254
dollars_255                     =M31255
dollars_256                     =M31256
dollars_257                     =M31257
dollars_258                     =M31258
dollars_259                     =M31259
dollars_260                     =M31260
dollars_261                     =M31261
dollars_262                     =M31262
dollars_263                     =M31263
dollars_264                     =M31264
dollars_265                     =M31265
dollars_266                     =M31266
dollars_267                     =M31267
dollars_268                     =M31268
dollars_269                     =M31269
dollars_270                     =M31270
dollars_271                     =M31271
dollars_272                     =M31272
dollars_273                     =M31273
dollars_274                     =M31274
dollars_275                     =M31275
dollars_276                     =M31276
dollars_277                     =M31277
dollars_278                     =M31278
dollars_279                     =M31279
dollars_280                     =M31280
dollars_281                     =M31281
dollars_282                     =M31282
dollars_283                     =M31283
dollars_284                     =M31284
dollars_285                     =M31285
dollars_286                     =M31286
dollars_287                     =M31287
dollars_288                     =M31288
dollars_289                     =M31289
dollars_290                     =M31290
dollars_291                     =M31291
dollars_292                     =M31292
dollars_293                     =M31293
dollars_294                     =M31294
dollars_295                     =M31295
dollars_296                     =M31296
dollars_297                     =M31297
dollars_298                     =M31298
dollars_299                     =M31299
dollars_300                     =M31300
dollars_301                     =M31301
dollars_302                     =M31302
dollars_303                     =M31303
dollars_304                     =M31304
dollars_305                     =M31305
dollars_306                     =M31306
dollars_307                     =M31307
dollars_308                     =M31308
dollars_309                     =M31309
dollars_310                     =M31310
dollars_311                     =M31311
dollars_312                     =M31312
dollars_313                     =M31313
dollars_314                     =M31314
dollars_315                     =M31315
dollars_316                     =M31316
dollars_317                     =M31317
dollars_318                     =M31318
dollars_319                     =M31319
dollars_320                     =M31320
dollars_321                     =M31321
dollars_322                     =M31322
dollars_323                     =M31323
dollars_324                     =M31324
dollars_325                     =M31325
dollars_326                     =M31326
dollars_327                     =M31327
dollars_328                     =M31328
dollars_329                     =M31329
dollars_330                     =M31330
dollars_331                     =M31331
dollars_332                     =M31332
dollars_333                     =M31333
dollars_334                     =M31334
dollars_335                     =M31335
dollars_336                     =M31336
dollars_337                     =M31337
dollars_338                     =M31338
dollars_339                     =M31339
dollars_340                     =M31340
dollars_341                     =M31341
dollars_342                     =M31342
dollars_343                     =M31343
dollars_344                     =M31344
dollars_345                     =M31345
dollars_346                     =M31346
dollars_347                     =M31347
dollars_348                     =M31348
dollars_349                     =M31349
dollars_350                     =M31350
dollars_351                     =M31351
dollars_352                     =M31352
dollars_353                     =M31353
dollars_354                     =M31354
dollars_355                     =M31355
dollars_356                     =M31356
dollars_357                     =M31357
dollars_358                     =M31358
dollars_359                     =M31359
dollars_360                     =M31360
dollars_361                     =M31361
dollars_362                     =M31362
dollars_363                     =M31363
dollars_364                     =M31364
dollars_365                     =M31365
dollars_366                     =M31366
dollars_367                     =M31367
dollars_368                     =M31368
dollars_369                     =M31369
dollars_370                     =M31370
dollars_371                     =M31371
dollars_372                     =M31372
dollars_373                     =M31373
dollars_374                     =M31374
dollars_375                     =M31375
dollars_376                     =M31376
dollars_377                     =M31377
dollars_378                     =M31378
dollars_379                     =M31379
dollars_380                     =M31380
dollars_381                     =M31381
dollars_382                     =M31382
dollars_383                     =M31383
dollars_384                     =M31384
dollars_385                     =M31385
dollars_386                     =M31386
dollars_387                     =M31387
dollars_388                     =M31388
dollars_389                     =M31389
dollars_390                     =M31390
dollars_391                     =M31391
dollars_392                     =M31392
dollars_393                     =M31393
dollars_394                     =M31394
dollars_395                     =M31395
dollars_396                     =M31396
dollars_397                     =M31397
dollars_398                     =M31398
dollars_399                     =M31399
dollars_400                     =M31400
dollars_401                     =M31401
dollars_402                     =M31402
dollars_403                     =M31403
dollars_404                     =M31404
dollars_405                     =M31405
dollars_406                     =M31406
dollars_407                     =M31407
dollars_408                     =M31408
dollars_409                     =M31409
dollars_410                     =M31410
dollars_411                     =M31411
dollars_412                     =M31412
dollars_413                     =M31413
dollars_414                     =M31414
dollars_415                     =M31415
dollars_416                     =M31416
dollars_417                     =M31417
dollars_418                     =M31418
dollars_419                     =M31419
dollars_420                     =M31420
dollars_421                     =M31421
dollars_422                     =M31422
dollars_423                     =M31423
dollars_424                     =M31424
dollars_425                     =M31425
dollars_426                     =M31426
dollars_427                     =M31427
dollars_428                     =M31428
dollars_429                     =M31429
dollars_430                     =M31430
dollars_431                     =M31431
dollars_432                     =M31432
dollars_433                     =M31433
dollars_434                     =M31434
dollars_435                     =M31435
dollars_436                     =M31436
dollars_437                     =M31437
dollars_438                     =M31438
dollars_439                     =M31439
dollars_440                     =M31440
dollars_441                     =M31441
dollars_442                     =M31442
dollars_443                     =M31443
dollars_444                     =M31444
dollars_445                     =M31445
dollars_446                     =M31446
dollars_447                     =M31447
dollars_448                     =M31448
dollars_449                     =M31449
dollars_450                     =M31450
dollars_451                     =M31451
dollars_452                     =M31452
dollars_453                     =M31453
dollars_454                     =M31454
dollars_455                     =M31455
dollars_456                     =M31456
dollars_457                     =M31457
dollars_458                     =M31458
dollars_459                     =M31459
dollars_460                     =M31460
dollars_461                     =M31461
dollars_462                     =M31462
dollars_463                     =M31463
dollars_464                     =M31464
dollars_465                     =M31465
dollars_466                     =M31466
dollars_467                     =M31467
dollars_468                     =M31468
dollars_469                     =M31469
dollars_470                     =M31470
dollars_471                     =M31471
dollars_472                     =M31472
dollars_473                     =M31473
dollars_474                     =M31474
dollars_475                     =M31475
dollars_476                     =M31476
dollars_477                     =M31477
dollars_478                     =M31478
dollars_479                     =M31479
dollars_480                     =M31480
dollars_481                     =M31481
dollars_482                     =M31482
dollars_483                     =M31483
dollars_484                     =M31484
dollars_485                     =M31485
dollars_486                     =M31486
dollars_487                     =M31487
dollars_488                     =M31488
dollars_489                     =M31489
dollars_490                     =M31490
dollars_491                     =M31491
dollars_492                     =M31492
dollars_493                     =M31493
dollars_494                     =M31494
dollars_495                     =M31495
dollars_496                     =M31496
dollars_497                     =M31497
dollars_498                     =M31498
dollars_499                     =M31499
dollars_500                     =M31500
dollars_501                     =M31501
dollars_502                     =M31502
dollars_503                     =M31503
dollars_504                     =M31504
dollars_505                     =M31505
dollars_506                     =M31506
dollars_507                     =M31507
dollars_508                     =M31508
dollars_509                     =M31509
dollars_510                     =M31510
dollars_511                     =M31511
dollars_512                     =M31512
dollars_513                     =M31513
dollars_514                     =M31514
dollars_515                     =M31515
dollars_516                     =M31516
dollars_517                     =M31517
dollars_518                     =M31518
dollars_519                     =M31519
dollars_520                     =M31520
dollars_521                     =M31521
dollars_522                     =M31522
dollars_523                     =M31523
dollars_524                     =M31524
dollars_525                     =M31525
dollars_526                     =M31526
dollars_527                     =M31527
dollars_528                     =M31528
dollars_529                     =M31529
dollars_530                     =M31530
dollars_531                     =M31531
dollars_532                     =M31532
dollars_533                     =M31533
dollars_534                     =M31534
dollars_535                     =M31535
dollars_536                     =M31536
dollars_537                     =M31537
dollars_538                     =M31538
dollars_539                     =M31539
dollars_540                     =M31540
dollars_541                     =M31541
dollars_542                     =M31542
dollars_543                     =M31543
dollars_544                     =M31544
dollars_545                     =M31545
dollars_546                     =M31546
dollars_547                     =M31547
dollars_548                     =M31548
dollars_549                     =M31549
dollars_550                     =M31550
dollars_551                     =M31551
dollars_552                     =M31552
dollars_553                     =M31553
dollars_554                     =M31554
dollars_555                     =M31555
dollars_556                     =M31556
dollars_557                     =M31557
dollars_558                     =M31558
dollars_559                     =M31559
dollars_560                     =M31560
dollars_561                     =M31561
dollars_562                     =M31562
dollars_563                     =M31563
dollars_564                     =M31564
dollars_565                     =M31565
dollars_566                     =M31566
dollars_567                     =M31567
dollars_568                     =M31568
dollars_569                     =M31569
dollars_570                     =M31570
dollars_571                     =M31571
dollars_572                     =M31572
dollars_573                     =M31573
dollars_574                     =M31574
dollars_575                     =M31575
dollars_576                     =M31576
dollars_577                     =M31577
dollars_578                     =M31578
dollars_579                     =M31579
dollars_580                     =M31580
dollars_581                     =M31581
dollars_582                     =M31582
dollars_583                     =M31583
dollars_584                     =M31584
dollars_585                     =M31585
dollars_586                     =M31586
dollars_587                     =M31587
dollars_588                     =M31588
dollars_589                     =M31589
dollars_590                     =M31590
dollars_591                     =M31591
dollars_592                     =M31592
dollars_593                     =M31593
dollars_594                     =M31594
dollars_595                     =M31595
dollars_596                     =M31596
dollars_597                     =M31597
dollars_598                     =M31598
dollars_599                     =M31599
dollars_600                     =M31600
dollars_601                     =M31601
dollars_602                     =M31602
dollars_603                     =M31603
dollars_604                     =M31604
dollars_605                     =M31605
dollars_606                     =M31606
dollars_607                     =M31607
dollars_608                     =M31608
dollars_609                     =M31609
dollars_610                     =M31610
dollars_611                     =M31611
dollars_612                     =M31612
dollars_613                     =M31613
dollars_614                     =M31614
dollars_615                     =M31615
dollars_616                     =M31616
dollars_617                     =M31617
dollars_618                     =M31618
dollars_619                     =M31619
dollars_620                     =M31620
dollars_621                     =M31621
dollars_622                     =M31622
dollars_623                     =M31623
dollars_624                     =M31624
dollars_625                     =M31625
dollars_626                     =M31626
dollars_627                     =M31627
dollars_628                     =M31628
dollars_629                     =M31629
dollars_630                     =M31630
dollars_631                     =M31631
dollars_632                     =M31632
dollars_633                     =M31633
dollars_634                     =M31634
dollars_635                     =M31635
dollars_636                     =M31636
dollars_637                     =M31637
dollars_638                     =M31638
dollars_639                     =M31639
dollars_640                     =M31640
dollars_641                     =M31641
dollars_642                     =M31642
dollars_643                     =M31643
dollars_644                     =M31644
dollars_645                     =M31645
dollars_646                     =M31646
dollars_647                     =M31647
dollars_648                     =M31648
dollars_649                     =M31649
dollars_650                     =M31650
dollars_651                     =M31651
dollars_652                     =M31652
dollars_653                     =M31653
dollars_654                     =M31654
dollars_655                     =M31655
dollars_656                     =M31656
dollars_657                     =M31657
dollars_658                     =M31658
dollars_659                     =M31659
dollars_660                     =M31660
dollars_661                     =M31661
dollars_662                     =M31662
dollars_663                     =M31663
dollars_664                     =M31664
dollars_665                     =M31665
dollars_666                     =M31666
dollars_667                     =M31667
dollars_668                     =M31668
dollars_669                     =M31669
dollars_670                     =M31670
dollars_671                     =M31671
dollars_672                     =M31672
dollars_673                     =M31673
dollars_674                     =M31674
dollars_675                     =M31675
dollars_676                     =M31676
dollars_677                     =M31677
dollars_678                     =M31678
dollars_679                     =M31679
dollars_680                     =M31680
dollars_681                     =M31681
dollars_682                     =M31682
dollars_683                     =M31683
dollars_684                     =M31684
dollars_685                     =M31685
dollars_686                     =M31686
dollars_687                     =M31687
dollars_688                     =M31688
dollars_689                     =M31689
dollars_690                     =M31690
dollars_691                     =M31691
dollars_692                     =M31692
dollars_693                     =M31693
dollars_694                     =M31694
dollars_695                     =M31695
dollars_696                     =M31696
dollars_697                     =M31697
dollars_698                     =M31698
dollars_699                     =M31699
dollars_700                     =M31700
dollars_701                     =M31701
dollars_702                     =M31702
dollars_703                     =M31703
dollars_704                     =M31704
dollars_705                     =M31705
dollars_706                     =M31706
dollars_707                     =M31707
dollars_708                     =M31708
dollars_709                     =M31709
dollars_710                     =M31710
dollars_711                     =M31711
dollars_712                     =M31712
dollars_713                     =M31713
dollars_714                     =M31714
dollars_715                     =M31715
dollars_716                     =M31716
dollars_717                     =M31717
dollars_718                     =M31718
dollars_719                     =M31719
dollars_720                     =M31720
dollars_721                     =M31721
dollars_722                     =M31722
dollars_723                     =M31723
dollars_724                     =M31724
dollars_725                     =M31725
dollars_726                     =M31726
dollars_727                     =M31727
dollars_728                     =M31728
dollars_729                     =M31729
dollars_730                     =M31730
dollars_731                     =M31731
dollars_732                     =M31732
dollars_733                     =M31733
dollars_734                     =M31734
dollars_735                     =M31735
dollars_736                     =M31736
dollars_737                     =M31737
dollars_738                     =M31738
dollars_739                     =M31739
dollars_740                     =M31740
dollars_741                     =M31741
dollars_742                     =M31742
dollars_743                     =M31743
dollars_744                     =M31744
dollars_745                     =M31745
dollars_746                     =M31746
dollars_747                     =M31747
dollars_748                     =M31748
dollars_749                     =M31749
dollars_750                     =M31750
dollars_751                     =M31751
dollars_752                     =M31752
dollars_753                     =M31753
dollars_754                     =M31754
dollars_755                     =M31755
dollars_756                     =M31756
dollars_757                     =M31757
dollars_758                     =M31758
dollars_759                     =M31759
dollars_760                     =M31760
dollars_761                     =M31761
dollars_762                     =M31762
dollars_763                     =M31763
dollars_764                     =M31764
dollars_765                     =M31765
dollars_766                     =M31766
dollars_767                     =M31767
dollars_768                     =M31768
dollars_769                     =M31769
dollars_770                     =M31770
dollars_771                     =M31771
dollars_772                     =M31772
dollars_773                     =M31773
dollars_774                     =M31774
dollars_775                     =M31775
dollars_776                     =M31776
dollars_777                     =M31777
dollars_778                     =M31778
dollars_779                     =M31779
dollars_780                     =M31780
dollars_781                     =M31781
dollars_782                     =M31782
dollars_783                     =M31783
dollars_784                     =M31784
dollars_785                     =M31785
dollars_786                     =M31786
dollars_787                     =M31787
dollars_788                     =M31788
dollars_789                     =M31789
dollars_790                     =M31790
dollars_791                     =M31791
dollars_792                     =M31792
dollars_793                     =M31793
dollars_794                     =M31794
dollars_795                     =M31795
dollars_796                     =M31796
dollars_797                     =M31797
dollars_798                     =M31798
dollars_799                     =M31799
dollars_800                     =M31800
dollars_801                     =M31801
dollars_802                     =M31802
dollars_803                     =M31803
dollars_804                     =M31804
dollars_805                     =M31805
dollars_806                     =M31806
dollars_807                     =M31807
dollars_808                     =M31808
dollars_809                     =M31809
dollars_810                     =M31810
dollars_811                     =M31811
dollars_812                     =M31812
dollars_813                     =M31813
dollars_814                     =M31814
dollars_815                     =M31815
dollars_816                     =M31816
dollars_817                     =M31817
dollars_818                     =M31818
dollars_819                     =M31819
dollars_820                     =M31820
dollars_821                     =M31821
dollars_822                     =M31822
dollars_823                     =M31823
dollars_824                     =M31824
dollars_825                     =M31825
dollars_826                     =M31826
dollars_827                     =M31827
dollars_828                     =M31828
dollars_829                     =M31829
dollars_830                     =M31830
dollars_831                     =M31831
dollars_832                     =M31832
dollars_833                     =M31833
dollars_834                     =M31834
dollars_835                     =M31835
dollars_836                     =M31836
dollars_837                     =M31837
dollars_838                     =M31838
dollars_839                     =M31839
dollars_840                     =M31840
dollars_841                     =M31841
dollars_842                     =M31842
dollars_843                     =M31843
dollars_844                     =M31844
dollars_845                     =M31845
dollars_846                     =M31846
dollars_847                     =M31847
dollars_848                     =M31848
dollars_849                     =M31849
dollars_850                     =M31850
dollars_851                     =M31851
dollars_852                     =M31852
dollars_853                     =M31853
dollars_854                     =M31854
dollars_855                     =M31855
dollars_856                     =M31856
dollars_857                     =M31857
dollars_858                     =M31858
dollars_859                     =M31859
dollars_860                     =M31860
dollars_861                     =M31861
dollars_862                     =M31862
dollars_863                     =M31863
dollars_864                     =M31864
dollars_865                     =M31865
dollars_866                     =M31866
dollars_867                     =M31867
dollars_868                     =M31868
dollars_869                     =M31869
dollars_870                     =M31870
dollars_871                     =M31871
dollars_872                     =M31872
dollars_873                     =M31873
dollars_874                     =M31874
dollars_875                     =M31875
dollars_876                     =M31876
dollars_877                     =M31877
dollars_878                     =M31878;
dollars_879                     =M31879;
dollars_880                     =M31880
dollars_881                     =M31881
dollars_882                     =M31882
dollars_883                     =M31883
dollars_884                     =M31884
dollars_885                     =M31885
dollars_886                     =M31886
dollars_887                     =M31887
dollars_888                     =M31888
dollars_889                     =M31889
dollars_890                     =M31890
dollars_891                     =M31891
dollars_892                     =M31892
dollars_893                     =M31893
dollars_894                     =M31894
dollars_895                     =M31895
dollars_896                     =M31896
dollars_897                     =M31897
dollars_898                     =M31898
dollars_899                     =M31899
dollars_900                     =M31900
dollars_901                     =M31901
dollars_902                     =M31902
dollars_903                     =M31903
dollars_904                     =M31904
dollars_905                     =M31905
dollars_906                     =M31906
dollars_907                     =M31907
dollars_908                     =M31908
dollars_909                     =M31909
dollars_910                     =M31910
dollars_911                     =M31911
dollars_912                     =M31912
dollars_913                     =M31913
dollars_914                     =M31914
dollars_915                     =M31915
dollars_916                     =M31916
dollars_917                     =M31917
dollars_918                     =M31918
dollars_919                     =M31919
dollars_920                     =M31920
dollars_921                     =M31921
dollars_922                     =M31922
dollars_923                     =M31923
dollars_924                     =M31924
dollars_925                     =M31925
dollars_926                     =M31926
dollars_927                     =M31927
dollars_928                     =M31928
dollars_929                     =M31929
dollars_930                     =M31930
dollars_931                     =M31931
dollars_932                     =M31932
dollars_933                     =M31933
dollars_934                     =M31934
dollars_935                     =M31935
dollars_936                     =M31936
dollars_937                     =M31937
dollars_938                     =M31938
dollars_939                     =M31939
dollars_940                     =M31940
dollars_941                     =M31941
dollars_942                     =M31942
dollars_943                     =M31943
dollars_944                     =M31944
dollars_945                     =M31945
dollars_946                     =M31946
dollars_947                     =M31947
dollars_948                     =M31948
dollars_949                     =M31949
dollars_950                     =M31950
dollars_951                     =M31951
dollars_952                     =M31952
dollars_953                     =M31953
dollars_954                     =M31954
dollars_955                     =M31955
dollars_956                     =M31956
dollars_957                     =M31957
dollars_958                     =M31958
dollars_959                     =M31959
dollars_960                     =M31960
dollars_961                     =M31961
dollars_962                     =M31962
dollars_963                     =M31963
dollars_964                     =M31964
dollars_965                     =M31965
dollars_966                     =M31966
dollars_967                     =M31967
dollars_968                     =M31968
dollars_969                     =M31969
dollars_970                     =M31970
dollars_971                     =M31971
dollars_972                     =M31972
dollars_973                     =M31973
dollars_974                     =M31974
dollars_975                     =M31975
dollars_976                     =M31976
dollars_977                     =M31977
dollars_978                     =M31978
dollars_979                     =M31979
dollars_980                     =M31980
dollars_981                     =M31981
dollars_982                     =M31982
dollars_983                     =M31983
dollars_984                     =M31984
dollars_985                     =M31985
dollars_986                     =M31986
dollars_987                     =M31987
dollars_988                     =M31988
dollars_989                     =M31989
dollars_990                     =M31990
dollars_991                     =M31991
dollars_992                     =M31992
dollars_993                     =M31993
dollars_994                     =M31994
dollars_995                     =M31995
dollars_996                     =M31996
dollars_997                     =M31997
dollars_998                     =M31998
dollars_999                     =M31999
/**********************************************************************
* and N cents; N = 1 thru 99
**********************************************************************/
andcents_0                      =M32000
andcents_1                      =M32001
andcents_2                      =M32002
andcents_3                      =M32003
andcents_4                      =M32004
andcents_5                      =M32005
andcents_6                      =M32006
andcents_7                      =M32007
andcents_8                      =M32008
andcents_9                      =M32009
andcents_10                     =M32010
andcents_11                     =M32011
andcents_12                     =M32012
andcents_13                     =M32013
andcents_14                     =M32014
andcents_15                     =M32015
andcents_16                     =M32016
andcents_17                     =M32017
andcents_18                     =M32018
andcents_19                     =M32019
andcents_20                     =M32020
andcents_21                     =M32021
andcents_22                     =M32022
andcents_23                     =M32023
andcents_24                     =M32024
andcents_25                     =M32025
andcents_26                     =M32026
andcents_27                     =M32027
andcents_28                     =M32028
andcents_29                     =M32029
andcents_30                     =M32030
andcents_31                     =M32031
andcents_32                     =M32032
andcents_33                     =M32033
andcents_34                     =M32034
andcents_35                     =M32035
andcents_36                     =M32036
andcents_37                     =M32037
andcents_38                     =M32038
andcents_39                     =M32039
andcents_40                     =M32040
andcents_41                     =M32041
andcents_42                     =M32042
andcents_43                     =M32043
andcents_44                     =M32044
andcents_45                     =M32045
andcents_46                     =M32046
andcents_47                     =M32047
andcents_48                     =M32048
andcents_49                     =M32049
andcents_50                     =M32050
andcents_51                     =M32051
andcents_52                     =M32052
andcents_53                     =M32053
andcents_54                     =M32054
andcents_55                     =M32055
andcents_56                     =M32056
andcents_57                     =M32057
andcents_58                     =M32058
andcents_59                     =M32059
andcents_60                     =M32060
andcents_61                     =M32061
andcents_62                     =M32062
andcents_63                     =M32063
andcents_64                     =M32064
andcents_65                     =M32065
andcents_66                     =M32066
andcents_67                     =M32067
andcents_68                     =M32068
andcents_69                     =M32069
andcents_70                     =M32070
andcents_71                     =M32071
andcents_72                     =M32072
andcents_73                     =M32073
andcents_74                     =M32074
andcents_75                     =M32075
andcents_76                     =M32076
andcents_77                     =M32077
andcents_78                     =M32078
andcents_79                     =M32079
andcents_80                     =M32080
andcents_81                     =M32081
andcents_82                     =M32082
andcents_83                     =M32083
andcents_84                     =M32084
andcents_85                     =M32085
andcents_86                     =M32086
andcents_87                     =M32087
andcents_88                     =M32088
andcents_89                     =M32089
andcents_90                     =M32090
andcents_91                     =M32091
andcents_92                     =M32092
andcents_93                     =M32093
andcents_94                     =M32094
andcents_95                     =M32095
andcents_96                     =M32096
andcents_97                     =M32097
andcents_98                     =M32098
andcents_99                     =M32099
/**********************************************************************
* Tens "10","20","30",...,"90"
**********************************************************************/
ten_1                           =M30010
ten_2                           =M30020
ten_3                           =M30030
ten_4                           =M30040
ten_5                           =M30050
ten_6                           =M30060
ten_7                           =M30070
ten_8                           =M30080
ten_9                           =M30090
tens_1                          =M30010
tens_2                          =M30020
tens_3                          =M30030
tens_4                          =M30040
tens_5                          =M30050
tens_6                          =M30060
tens_7                          =M30070
tens_8                          =M30080
tens_9                          =M30090
/**********************************************************************
* "one hundred" thru "nine hundred"
**********************************************************************/
hundred_1                       =M33155
hundred_2                       =M33156
hundred_3                       =M33157
hundred_4                       =M33158
hundred_5                       =M33159
hundred_6                       =M33160
hundred_7                       =M33161
hundred_8                       =M33162
hundred_9                       =M33163
hundreds_1                      =M33155
hundreds_2                      =M33156
hundreds_3                      =M33157
hundreds_4                      =M33158
hundreds_5                      =M33159
hundreds_6                      =M33160
hundreds_7                      =M33161
hundreds_8                      =M33162
hundreds_9                      =M33163
/**********************************************************************
* "one thousand" thru "nine thousand"
**********************************************************************/
thousand_1                      =M33164
thousand_2                      =M33165
thousand_3                      =M33166
thousand_4                      =M33167
thousand_5                      =M33168
thousand_6                      =M33169
thousand_7                      =M33170
thousand_8                      =M33171
thousand_9                      =M33172
thousands_1                     =M33164
thousands_2                     =M33165
thousands_3                     =M33166
thousands_4                     =M33167
thousands_5                     =M33168
thousands_6                     =M33169
thousands_7                     =M33170
thousands_8                     =M33171
thousands_9                     =M33172
/**********************************************************************
* "one million" thru "nine million"
**********************************************************************/
million_1                       =M33174
million_2                       =M33175
million_3                       =M33176
million_4                       =M33177
million_5                       =M33178
million_6                       =M33179
million_7                       =M33180
million_8                       =M33181
million_9                       =M33182
millions_1                      =M33174
millions_2                      =M33175
millions_3                      =M33176
millions_4                      =M33177
millions_5                      =M33178
millions_6                      =M33179
millions_7                      =M33180
millions_8                      =M33181
millions_9                      =M33182

;"need                  millions
/**********************************************************************
* "one billion" thru "nine billion"
**********************************************************************/
billion_1                       =M33184
billion_2                       =M33185
billion_3                       =M33186
billion_4                       =M33187
billion_5                       =M33188
billion_6                       =M33189
billion_7                       =M33190
billion_8                       =M33191
billion_9                       =M33192
billions_1                      =M33184
billions_2                      =M33185
billions_3                      =M33186
billions_4                      =M33187
billions_5                      =M33188
billions_6                      =M33189
billions_7                      =M33190
billions_8                      =M33191
billions_9                      =M33192
/**********************************************************************
* "ten dollars" thru "ninety dollars"
**********************************************************************/
tenDollars_1                    =M31010
tenDollars_2                    =M31020
tenDollars_3                    =M31030
tenDollars_4                    =M31040
tenDollars_5                    =M31050
tenDollars_6                    =M31060
tenDollars_7                    =M31070
tenDollars_8                    =M31080
tenDollars_9                    =M31090
/**********************************************************************
* "one hundred dollars" thru "nine hundred dollars"
**********************************************************************/
hundredDollars_1                =M32100
hundredDollars_2                =M32101
hundredDollars_3                =M32102
hundredDollars_4                =M32103
hundredDollars_5                =M32104
hundredDollars_6                =M32105
hundredDollars_7                =M32106
hundredDollars_8                =M32107
hundredDollars_9                =M32108
/**********************************************************************
* "one thousand dollars" thru "nine thousand dollars"
**********************************************************************/
thousandDollars_1               =M33220
thousandDollars_2               =M33221
thousandDollars_3               =M33222
thousandDollars_4               =M33223
thousandDollars_5               =M33224
thousandDollars_6               =M33225
thousandDollars_7               =M33226
thousandDollars_8               =M33227
thousandDollars_9               =M33228
/**********************************************************************
* "one million dollars" thru "nine million dollars"
**********************************************************************/
millionDollars_1                =M33230
millionDollars_2                =M33231
millionDollars_3                =M33232
millionDollars_4                =M33233
millionDollars_5                =M33234
millionDollars_6                =M33235
millionDollars_7                =M33236
millionDollars_8                =M33237
millionDollars_9                =M33238
/**********************************************************************
* "one billion dollars" thru "nine billion dollars"
**********************************************************************/
billionDollars_1                =M33240
billionDollars_2                =M33241
billionDollars_3                =M33242
billionDollars_4                =M33243
billionDollars_5                =M33244
billionDollars_6                =M33245
billionDollars_7                =M33246
billionDollars_8                =M33247
billionDollars_9                =M33248
/**********************************************************************
*  billionDollars_10  =M33249
**********************************************************************/
/**********************************************************************
* Years: "nineteen forty" thru "nineteen ninety nine"
*        "two thousand"   thru "two thousand forty"
**********************************************************************/
year_1940                       =M32109
year_1941                       =M32110
year_1942                       =M32111
year_1943                       =M32112
year_1944                       =M32113
year_1945                       =M32114
year_1946                       =M32115
year_1947                       =M32116
year_1948                       =M32117
year_1949                       =M32118
year_1950                       =M32119
year_1951                       =M32120
year_1952                       =M32121
year_1953                       =M32122
year_1954                       =M32123
year_1955                       =M32124
year_1956                       =M32125
year_1957                       =M32126
year_1958                       =M32127
year_1959                       =M32128
year_1960                       =M32129
year_1961                       =M32130
year_1962                       =M32131
year_1963                       =M32132
year_1964                       =M32133
year_1965                       =M32134
year_1966                       =M32135
year_1967                       =M32136
year_1968                       =M32137
year_1969                       =M32138
year_1970                       =M32139
year_1971                       =M32140
year_1972                       =M32141
year_1973                       =M32142
year_1974                       =M32143
year_1975                       =M32144
year_1976                       =M32145
year_1977                       =M32146
year_1978                       =M32147
year_1979                       =M32148
year_1980                       =M32149
year_1981                       =M32150
year_1982                       =M32151
year_1983                       =M32152
year_1984                       =M32153
year_1985                       =M32154
year_1986                       =M32155
year_1987                       =M32156
year_1988                       =M32157
year_1989                       =M32158
year_1990                       =M32159
year_1991                       =M32160
year_1992                       =M32161
year_1993                       =M32162
year_1994                       =M32163
year_1995                       =M32164
year_1996                       =M32165
year_1997                       =M32166
year_1998                       =M32167
year_1999                       =M32168
year_2000                       =M32169
year_2001                       =M32170
year_2002                       =M32171
year_2003                       =M32172
year_2004                       =M32173
year_2005                       =M32174
year_2006                       =M32175
year_2007                       =M32176
year_2008                       =M32177
year_2009                       =M32178
year_2010                       =M32179
year_2011                       =M32180
year_2012                       =M32181
year_2013                       =M32182
year_2014                       =M32183
year_2015                       =M32184
year_2016                       =M32185
year_2017                       =M32186
year_2018                       =M32187
year_2019                       =M32188
year_2020                       =M32189
year_2021                       =M32190
year_2022                       =M32191
year_2023                       =M32192
year_2024                       =M32193
year_2025                       =M32194
year_2026                       =M32195
year_2027                       =M32196
year_2028                       =M32197
year_2029                       =M32198
year_2030                       =M32199
year_2031                       =M32200
year_2032                       =M32201
year_2033                       =M32202
year_2034                       =M32203
year_2035                       =M32204
year_2036                       =M32205
year_2037                       =M32206
year_2038                       =M32207
year_2039                       =M32208
year_2040                       =M32209
/**********************************************************************
* Letters: "A" thru "Z"
**********************************************************************/
letter_1                        =M33194
letter_2                        =M33195
letter_3                        =M33196
letter_4                        =M33197
letter_5                        =M33198
letter_6                        =M33199
letter_7                        =M33200
letter_8                        =M33201
letter_9                        =M33202
letter_10                       =M33203
letter_11                       =M33204
letter_12                       =M33205
letter_13                       =M33206
letter_14                       =M33207
letter_15                       =M33208
letter_16                       =M33209
letter_17                       =M33210
letter_18                       =M33211
letter_19                       =M33212
letter_20                       =M33213
letter_21                       =M33214
letter_22                       =M33215
letter_23                       =M33216
letter_24                       =M33217
letter_25                       =M33218
letter_26                       =M33219
letter_space                    =P10
letter_ampersand                =P10
/**********************************************************************
* Generic Press this: this is 0 thru 9 plus * and #
**********************************************************************/
press_0                         =M4555
press_1                         =M4540
press_2                         =M4541
press_3                         =M4542
press_4                         =M4543
press_5                         =M4544
press_6                         =M4545
press_7                         =M4546
press_8                         =M11385
press_9                         =M11386
press_star                      =M54168
press_pound                     =M11366
/**********************************************************************
* Generic Say this: this is 0 thru 9
**********************************************************************/
say_0                           =M54133
say_1                           =M11438
say_2                           =M11439
say_3                           =M11440
say_4                           =M11441
say_5                           =M11442
say_6                           =M11443
say_7                           =M11444
say_8                           =M11445
say_9                           =M11446

[DIGIT_PROMPTS English 1]
/**********************************************************************
*  DIGIT PROMPTS English Version 1
**********************************************************************/
dollar                          =M33254
dollars                         =M33255
/**********************************************************************
* ????
*   cent                  =
*   cents                 =
*   dollar_and            =
*   dollars_and           =
* ????
**********************************************************************/
thousandSuffix                  =M33251
millionSuffix                   =M33252
thousandsSuffix                 =M33251
millionsSuffix                  =M33252
billionSuffix                   =;??????????
thousandDollarsSuffix           =;?????????
millionDollarsSuffix            =;??????????
billionDollarsSuffix            =;??????????
/**********************************************************************
* Months: January thru December
**********************************************************************/
month_1                         =M33112
month_2                         =M33113
month_3                         =M33114
month_4                         =M33115
month_5                         =M33116
month_6                         =M33117
month_7                         =M33118
month_8                         =M33119
month_9                         =M33120
month_10                        =M33121
month_11                        =M33122
month_12                        =M33123
/**********************************************************************
* Ordinals:  first thru thirty-first
**********************************************************************/
nth_1                           =M33124
nth_2                           =M33125
nth_3                           =M33126
nth_4                           =M33127
nth_5                           =M33128
nth_6                           =M33129
nth_7                           =M33130
nth_8                           =M33131
nth_9                           =M33132
nth_10                          =M33133
nth_11                          =M33134
nth_12                          =M33135
nth_13                          =M33136
nth_14                          =M33137
nth_15                          =M33138
nth_16                          =M33139
nth_17                          =M33140
nth_18                          =M33141
nth_19                          =M33142
nth_20                          =M33143
nth_21                          =M33144
nth_22                          =M33145
nth_23                          =M33146
nth_24                          =M33147
nth_25                          =M33148
nth_26                          =M33149
nth_27                          =M33150
nth_28                          =M33151
nth_29                          =M33152
nth_30                          =M33153
nth_31                          =M33154
/**********************************************************************
* "N" ; N = 1 thru 999
**********************************************************************/
number_0                        =M30000
number_1                        =M30001
number_2                        =M30002
number_3                        =M30003
number_4                        =M30004
number_5                        =M30005
number_6                        =M30006
number_7                        =M30007
number_8                        =M30008
number_9                        =M30009
number_10                       =M30010
number_11                       =M30011
number_12                       =M30012
number_13                       =M30013
number_14                       =M30014
number_15                       =M30015
number_16                       =M30016
number_17                       =M30017
number_18                       =M30018
number_19                       =M30019
number_20                       =M30020
number_21                       =M30021
number_22                       =M30022
number_23                       =M30023
number_24                       =M30024
number_25                       =M30025
number_26                       =M30026
number_27                       =M30027
number_28                       =M30028
number_29                       =M30029
number_30                       =M30030
number_31                       =M30031
number_32                       =M30032
number_33                       =M30033
number_34                       =M30034
number_35                       =M30035
number_36                       =M30036
number_37                       =M30037
number_38                       =M30038
number_39                       =M30039
number_40                       =M30040
number_41                       =M30041
number_42                       =M30042
number_43                       =M30043
number_44                       =M30044
number_45                       =M30045
number_46                       =M30046
number_47                       =M30047
number_48                       =M30048
number_49                       =M30049
number_50                       =M30050
number_51                       =M30051
number_52                       =M30052
number_53                       =M30053
number_54                       =M30054
number_55                       =M30055
number_56                       =M30056
number_57                       =M30057
number_58                       =M30058
number_59                       =M30059
number_60                       =M30060
number_61                       =M30061
number_62                       =M30062
number_63                       =M30063
number_64                       =M30064
number_65                       =M30065
number_66                       =M30066
number_67                       =M30067
number_68                       =M30068
number_69                       =M30069
number_70                       =M30070
number_71                       =M30071
number_72                       =M30072
number_73                       =M30073
number_74                       =M30074
number_75                       =M30075
number_76                       =M30076
number_77                       =M30077
number_78                       =M30078
number_79                       =M30079
number_80                       =M30080
number_81                       =M30081
number_82                       =M30082
number_83                       =M30083
number_84                       =M30084
number_85                       =M30085
number_86                       =M30086
number_87                       =M30087
number_88                       =M30088
number_89                       =M30089
number_90                       =M30090
number_91                       =M30091
number_92                       =M30092
number_93                       =M30093
number_94                       =M30094
number_95                       =M30095
number_96                       =M30096
number_97                       =M30097
number_98                       =M30098
number_99                       =M30099
number_100                      =M30100
number_101                      =M30101
number_102                      =M30102
number_103                      =M30103
number_104                      =M30104
number_105                      =M30105
number_106                      =M30106
number_107                      =M30107
number_108                      =M30108
number_109                      =M30109
number_110                      =M30110
number_111                      =M30111
number_112                      =M30112
number_113                      =M30113
number_114                      =M30114
number_115                      =M30115
number_116                      =M30116
number_117                      =M30117
number_118                      =M30118
number_119                      =M30119
number_120                      =M30120
number_121                      =M30121
number_122                      =M30122
number_123                      =M30123
number_124                      =M30124
number_125                      =M30125
number_126                      =M30126
number_127                      =M30127
number_128                      =M30128
number_129                      =M30129
number_130                      =M30130
number_131                      =M30131
number_132                      =M30132
number_133                      =M30133
number_134                      =M30134
number_135                      =M30135
number_136                      =M30136
number_137                      =M30137
number_138                      =M30138
number_139                      =M30139
number_140                      =M30140
number_141                      =M30141
number_142                      =M30142
number_143                      =M30143
number_144                      =M30144
number_145                      =M30145
number_146                      =M30146
number_147                      =M30147
number_148                      =M30148
number_149                      =M30149
number_150                      =M30150
number_151                      =M30151
number_152                      =M30152
number_153                      =M30153
number_154                      =M30154
number_155                      =M30155
number_156                      =M30156
number_157                      =M30157
number_158                      =M30158
number_159                      =M30159
number_160                      =M30160
number_161                      =M30161
number_162                      =M30162
number_163                      =M30163
number_164                      =M30164
number_165                      =M30165
number_166                      =M30166
number_167                      =M30167
number_168                      =M30168
number_169                      =M30169
number_170                      =M30170
number_171                      =M30171
number_172                      =M30172
number_173                      =M30173
number_174                      =M30174
number_175                      =M30175
number_176                      =M30176
number_177                      =M30177
number_178                      =M30178
number_179                      =M30179
number_180                      =M30180
number_181                      =M30181
number_182                      =M30182
number_183                      =M30183
number_184                      =M30184
number_185                      =M30185
number_186                      =M30186
number_187                      =M30187
number_188                      =M30188
number_189                      =M30189
number_190                      =M30190
number_191                      =M30191
number_192                      =M30192
number_193                      =M30193
number_194                      =M30194
number_195                      =M30195
number_196                      =M30196
number_197                      =M30197
number_198                      =M30198
number_199                      =M30199
number_200                      =M30200
number_201                      =M30201
number_202                      =M30202
number_203                      =M30203
number_204                      =M30204
number_205                      =M30205
number_206                      =M30206
number_207                      =M30207
number_208                      =M30208
number_209                      =M30209
number_210                      =M30210
number_211                      =M30211
number_212                      =M30212
number_213                      =M30213
number_214                      =M30214
number_215                      =M30215
number_216                      =M30216
number_217                      =M30217
number_218                      =M30218
number_219                      =M30219
number_220                      =M30220
number_221                      =M30221
number_222                      =M30222
number_223                      =M30223
number_224                      =M30224
number_225                      =M30225
number_226                      =M30226
number_227                      =M30227
number_228                      =M30228
number_229                      =M30229
number_230                      =M30230
number_231                      =M30231
number_232                      =M30232
number_233                      =M30233
number_234                      =M30234
number_235                      =M30235
number_236                      =M30236
number_237                      =M30237
number_238                      =M30238
number_239                      =M30239
number_240                      =M30240
number_241                      =M30241
number_242                      =M30242
number_243                      =M30243
number_244                      =M30244
number_245                      =M30245
number_246                      =M30246
number_247                      =M30247
number_248                      =M30248
number_249                      =M30249
number_250                      =M30250
number_251                      =M30251
number_252                      =M30252
number_253                      =M30253
number_254                      =M30254
number_255                      =M30255
number_256                      =M30256
number_257                      =M30257
number_258                      =M30258
number_259                      =M30259
number_260                      =M30260
number_261                      =M30261
number_262                      =M30262
number_263                      =M30263
number_264                      =M30264
number_265                      =M30265
number_266                      =M30266
number_267                      =M30267
number_268                      =M30268
number_269                      =M30269
number_270                      =M30270
number_271                      =M30271
number_272                      =M30272
number_273                      =M30273
number_274                      =M30274
number_275                      =M30275
number_276                      =M30276
number_277                      =M30277
number_278                      =M30278
number_279                      =M30279
number_280                      =M30280
number_281                      =M30281
number_282                      =M30282
number_283                      =M30283
number_284                      =M30284
number_285                      =M30285
number_286                      =M30286
number_287                      =M30287
number_288                      =M30288
number_289                      =M30289
number_290                      =M30290
number_291                      =M30291
number_292                      =M30292
number_293                      =M30293
number_294                      =M30294
number_295                      =M30295
number_296                      =M30296
number_297                      =M30297
number_298                      =M30298
number_299                      =M30299
number_300                      =M30300
number_301                      =M30301
number_302                      =M30302
number_303                      =M30303
number_304                      =M30304
number_305                      =M30305
number_306                      =M30306
number_307                      =M30307
number_308                      =M30308
number_309                      =M30309
number_310                      =M30310
number_311                      =M30311
number_312                      =M30312
number_313                      =M30313
number_314                      =M30314
number_315                      =M30315
number_316                      =M30316
number_317                      =M30317
number_318                      =M30318
number_319                      =M30319
number_320                      =M30320
number_321                      =M30321
number_322                      =M30322
number_323                      =M30323
number_324                      =M30324
number_325                      =M30325
number_326                      =M30326
number_327                      =M30327
number_328                      =M30328
number_329                      =M30329
number_330                      =M30330
number_331                      =M30331
number_332                      =M30332
number_333                      =M30333
number_334                      =M30334
number_335                      =M30335
number_336                      =M30336
number_337                      =M30337
number_338                      =M30338
number_339                      =M30339
number_340                      =M30340
number_341                      =M30341
number_342                      =M30342
number_343                      =M30343
number_344                      =M30344
number_345                      =M30345
number_346                      =M30346
number_347                      =M30347
number_348                      =M30348
number_349                      =M30349
number_350                      =M30350
number_351                      =M30351
number_352                      =M30352
number_353                      =M30353
number_354                      =M30354
number_355                      =M30355
number_356                      =M30356
number_357                      =M30357
number_358                      =M30358
number_359                      =M30359
number_360                      =M30360
number_361                      =M30361
number_362                      =M30362
number_363                      =M30363
number_364                      =M30364
number_365                      =M30365
number_366                      =M30366
number_367                      =M30367
number_368                      =M30368
number_369                      =M30369
number_370                      =M30370
number_371                      =M30371
number_372                      =M30372
number_373                      =M30373
number_374                      =M30374
number_375                      =M30375
number_376                      =M30376
number_377                      =M30377
number_378                      =M30378
number_379                      =M30379
number_380                      =M30380
number_381                      =M30381
number_382                      =M30382
number_383                      =M30383
number_384                      =M30384
number_385                      =M30385
number_386                      =M30386
number_387                      =M30387
number_388                      =M30388
number_389                      =M30389
number_390                      =M30390
number_391                      =M30391
number_392                      =M30392
number_393                      =M30393
number_394                      =M30394
number_395                      =M30395
number_396                      =M30396
number_397                      =M30397
number_398                      =M30398
number_399                      =M30399
number_400                      =M30400
number_401                      =M30401
number_402                      =M30402
number_403                      =M30403
number_404                      =M30404
number_405                      =M30405
number_406                      =M30406
number_407                      =M30407
number_408                      =M30408
number_409                      =M30409
number_410                      =M30410
number_411                      =M30411
number_412                      =M30412
number_413                      =M30413
number_414                      =M30414
number_415                      =M30415
number_416                      =M30416
number_417                      =M30417
number_418                      =M30418
number_419                      =M30419
number_420                      =M30420
number_421                      =M30421
number_422                      =M30422
number_423                      =M30423
number_424                      =M30424
number_425                      =M30425
number_426                      =M30426
number_427                      =M30427
number_428                      =M30428
number_429                      =M30429
number_430                      =M30430
number_431                      =M30431
number_432                      =M30432
number_433                      =M30433
number_434                      =M30434
number_435                      =M30435
number_436                      =M30436
number_437                      =M30437
number_438                      =M30438
number_439                      =M30439
number_440                      =M30440
number_441                      =M30441
number_442                      =M30442
number_443                      =M30443
number_444                      =M30444
number_445                      =M30445
number_446                      =M30446
number_447                      =M30447
number_448                      =M30448
number_449                      =M30449
number_450                      =M30450
number_451                      =M30451
number_452                      =M30452
number_453                      =M30453
number_454                      =M30454
number_455                      =M30455
number_456                      =M30456
number_457                      =M30457
number_458                      =M30458
number_459                      =M30459
number_460                      =M30460
number_461                      =M30461
number_462                      =M30462
number_463                      =M30463
number_464                      =M30464
number_465                      =M30465
number_466                      =M30466
number_467                      =M30467
number_468                      =M30468
number_469                      =M30469
number_470                      =M30470
number_471                      =M30471
number_472                      =M30472
number_473                      =M30473
number_474                      =M30474
number_475                      =M30475
number_476                      =M30476
number_477                      =M30477
number_478                      =M30478
number_479                      =M30479
number_480                      =M30480
number_481                      =M30481
number_482                      =M30482
number_483                      =M30483
number_484                      =M30484
number_485                      =M30485
number_486                      =M30486
number_487                      =M30487
number_488                      =M30488
number_489                      =M30489
number_490                      =M30490
number_491                      =M30491
number_492                      =M30492
number_493                      =M30493
number_494                      =M30494
number_495                      =M30495
number_496                      =M30496
number_497                      =M30497
number_498                      =M30498
number_499                      =M30499
number_500                      =M30500
number_501                      =M30501
number_502                      =M30502
number_503                      =M30503
number_504                      =M30504
number_505                      =M30505
number_506                      =M30506
number_507                      =M30507
number_508                      =M30508
number_509                      =M30509
number_510                      =M30510
number_511                      =M30511
number_512                      =M30512
number_513                      =M30513
number_514                      =M30514
number_515                      =M30515
number_516                      =M30516
number_517                      =M30517
number_518                      =M30518
number_519                      =M30519
number_520                      =M30520
number_521                      =M30521
number_522                      =M30522
number_523                      =M30523
number_524                      =M30524
number_525                      =M30525
number_526                      =M30526
number_527                      =M30527
number_528                      =M30528
number_529                      =M30529
number_530                      =M30530
number_531                      =M30531
number_532                      =M30532
number_533                      =M30533
number_534                      =M30534
number_535                      =M30535
number_536                      =M30536
number_537                      =M30537
number_538                      =M30538
number_539                      =M30539
number_540                      =M30540
number_541                      =M30541
number_542                      =M30542
number_543                      =M30543
number_544                      =M30544
number_545                      =M30545
number_546                      =M30546
number_547                      =M30547
number_548                      =M30548
number_549                      =M30549
number_550                      =M30550
number_551                      =M30551
number_552                      =M30552
number_553                      =M30553
number_554                      =M30554
number_555                      =M30555
number_556                      =M30556
number_557                      =M30557
number_558                      =M30558
number_559                      =M30559
number_560                      =M30560
number_561                      =M30561
number_562                      =M30562
number_563                      =M30563
number_564                      =M30564
number_565                      =M30565
number_566                      =M30566
number_567                      =M30567
number_568                      =M30568
number_569                      =M30569
number_570                      =M30570
number_571                      =M30571
number_572                      =M30572
number_573                      =M30573
number_574                      =M30574
number_575                      =M30575
number_576                      =M30576
number_577                      =M30577
number_578                      =M30578
number_579                      =M30579
number_580                      =M30580
number_581                      =M30581
number_582                      =M30582
number_583                      =M30583
number_584                      =M30584
number_585                      =M30585
number_586                      =M30586
number_587                      =M30587
number_588                      =M30588
number_589                      =M30589
number_590                      =M30590
number_591                      =M30591
number_592                      =M30592
number_593                      =M30593
number_594                      =M30594
number_595                      =M30595
number_596                      =M30596
number_597                      =M30597
number_598                      =M30598
number_599                      =M30599
number_600                      =M30600
number_601                      =M30601
number_602                      =M30602
number_603                      =M30603
number_604                      =M30604
number_605                      =M30605
number_606                      =M30606
number_607                      =M30607
number_608                      =M30608
number_609                      =M30609
number_610                      =M30610
number_611                      =M30611
number_612                      =M30612
number_613                      =M30613
number_614                      =M30614
number_615                      =M30615
number_616                      =M30616
number_617                      =M30617
number_618                      =M30618
number_619                      =M30619
number_620                      =M30620
number_621                      =M30621
number_622                      =M30622
number_623                      =M30623
number_624                      =M30624
number_625                      =M30625
number_626                      =M30626
number_627                      =M30627
number_628                      =M30628
number_629                      =M30629
number_630                      =M30630
number_631                      =M30631
number_632                      =M30632
number_633                      =M30633
number_634                      =M30634
number_635                      =M30635
number_636                      =M30636
number_637                      =M30637
number_638                      =M30638
number_639                      =M30639
number_640                      =M30640
number_641                      =M30641
number_642                      =M30642
number_643                      =M30643
number_644                      =M30644
number_645                      =M30645
number_646                      =M30646
number_647                      =M30647
number_648                      =M30648
number_649                      =M30649
number_650                      =M30650
number_651                      =M30651
number_652                      =M30652
number_653                      =M30653
number_654                      =M30654
number_655                      =M30655
number_656                      =M30656
number_657                      =M30657
number_658                      =M30658
number_659                      =M30659
number_660                      =M30660
number_661                      =M30661
number_662                      =M30662
number_663                      =M30663
number_664                      =M30664
number_665                      =M30665
number_666                      =M30666
number_667                      =M30667
number_668                      =M30668
number_669                      =M30669
number_670                      =M30670
number_671                      =M30671
number_672                      =M30672
number_673                      =M30673
number_674                      =M30674
number_675                      =M30675
number_676                      =M30676
number_677                      =M30677
number_678                      =M30678
number_679                      =M30679
number_680                      =M30680
number_681                      =M30681
number_682                      =M30682
number_683                      =M30683
number_684                      =M30684
number_685                      =M30685
number_686                      =M30686
number_687                      =M30687
number_688                      =M30688
number_689                      =M30689
number_690                      =M30690
number_691                      =M30691
number_692                      =M30692
number_693                      =M30693
number_694                      =M30694
number_695                      =M30695
number_696                      =M30696
number_697                      =M30697
number_698                      =M30698
number_699                      =M30699
number_700                      =M30700
number_701                      =M30701
number_702                      =M30702
number_703                      =M30703
number_704                      =M30704
number_705                      =M30705
number_706                      =M30706
number_707                      =M30707
number_708                      =M30708
number_709                      =M30709
number_710                      =M30710
number_711                      =M30711
number_712                      =M30712
number_713                      =M30713
number_714                      =M30714
number_715                      =M30715
number_716                      =M30716
number_717                      =M30717
number_718                      =M30718
number_719                      =M30719
number_720                      =M30720
number_721                      =M30721
number_722                      =M30722
number_723                      =M30723
number_724                      =M30724
number_725                      =M30725
number_726                      =M30726
number_727                      =M30727
number_728                      =M30728
number_729                      =M30729
number_730                      =M30730
number_731                      =M30731
number_732                      =M30732
number_733                      =M30733
number_734                      =M30734
number_735                      =M30735
number_736                      =M30736
number_737                      =M30737
number_738                      =M30738
number_739                      =M30739
number_740                      =M30740
number_741                      =M30741
number_742                      =M30742
number_743                      =M30743
number_744                      =M30744
number_745                      =M30745
number_746                      =M30746
number_747                      =M30747
number_748                      =M30748
number_749                      =M30749
number_750                      =M30750
number_751                      =M30751
number_752                      =M30752
number_753                      =M30753
number_754                      =M30754
number_755                      =M30755
number_756                      =M30756
number_757                      =M30757
number_758                      =M30758
number_759                      =M30759
number_760                      =M30760
number_761                      =M30761
number_762                      =M30762
number_763                      =M30763
number_764                      =M30764
number_765                      =M30765
number_766                      =M30766
number_767                      =M30767
number_768                      =M30768
number_769                      =M30769
number_770                      =M30770
number_771                      =M30771
number_772                      =M30772
number_773                      =M30773
number_774                      =M30774
number_775                      =M30775
number_776                      =M30776
number_777                      =M30777
number_778                      =M30778
number_779                      =M30779
number_780                      =M30780
number_781                      =M30781
number_782                      =M30782
number_783                      =M30783
number_784                      =M30784
number_785                      =M30785
number_786                      =M30786
number_787                      =M30787
number_788                      =M30788
number_789                      =M30789
number_790                      =M30790
number_791                      =M30791
number_792                      =M30792
number_793                      =M30793
number_794                      =M30794
number_795                      =M30795
number_796                      =M30796
number_797                      =M30797
number_798                      =M30798
number_799                      =M30799
number_800                      =M30800
number_801                      =M30801
number_802                      =M30802
number_803                      =M30803
number_804                      =M30804
number_805                      =M30805
number_806                      =M30806
number_807                      =M30807
number_808                      =M30808
number_809                      =M30809
number_810                      =M30810
number_811                      =M30811
number_812                      =M30812
number_813                      =M30813
number_814                      =M30814
number_815                      =M30815
number_816                      =M30816
number_817                      =M30817
number_818                      =M30818
number_819                      =M30819
number_820                      =M30820
number_821                      =M30821
number_822                      =M30822
number_823                      =M30823
number_824                      =M30824
number_825                      =M30825
number_826                      =M30826
number_827                      =M30827
number_828                      =M30828
number_829                      =M30829
number_830                      =M30830
number_831                      =M30831
number_832                      =M30832
number_833                      =M30833
number_834                      =M30834
number_835                      =M30835
number_836                      =M30836
number_837                      =M30837
number_838                      =M30838
number_839                      =M30839
number_840                      =M30840
number_841                      =M30841
number_842                      =M30842
number_843                      =M30843
number_844                      =M30844
number_845                      =M30845
number_846                      =M30846
number_847                      =M30847
number_848                      =M30848
number_849                      =M30849
number_850                      =M30850
number_851                      =M30851
number_852                      =M30852
number_853                      =M30853
number_854                      =M30854
number_855                      =M30855
number_856                      =M30856
number_857                      =M30857
number_858                      =M30858
number_859                      =M30859
number_860                      =M30860
number_861                      =M30861
number_862                      =M30862
number_863                      =M30863
number_864                      =M30864
number_865                      =M30865
number_866                      =M30866
number_867                      =M30867
number_868                      =M30868
number_869                      =M30869
number_870                      =M30870
number_871                      =M30871
number_872                      =M30872
number_873                      =M30873
number_874                      =M30874
number_875                      =M30875
number_876                      =M30876
number_877                      =M30877
number_878                      =M30878
number_879                      =M30879
number_880                      =M30880
number_881                      =M30881
number_882                      =M30882
number_883                      =M30883
number_884                      =M30884
number_885                      =M30885
number_886                      =M30886
number_887                      =M30887
number_888                      =M30888
number_889                      =M30889
number_890                      =M30890
number_891                      =M30891
number_892                      =M30892
number_893                      =M30893
number_894                      =M30894
number_895                      =M30895
number_896                      =M30896
number_897                      =M30897
number_898                      =M30898
number_899                      =M30899
number_900                      =M30900
number_901                      =M30901
number_902                      =M30902
number_903                      =M30903
number_904                      =M30904
number_905                      =M30905
number_906                      =M30906
number_907                      =M30907
number_908                      =M30908
number_909                      =M30909
number_910                      =M30910
number_911                      =M30911
number_912                      =M30912
number_913                      =M30913
number_914                      =M30914
number_915                      =M30915
number_916                      =M30916
number_917                      =M30917
number_918                      =M30918
number_919                      =M30919
number_920                      =M30920
number_921                      =M30921
number_922                      =M30922
number_923                      =M30923
number_924                      =M30924
number_925                      =M30925
number_926                      =M30926
number_927                      =M30927
number_928                      =M30928
number_929                      =M30929
number_930                      =M30930
number_931                      =M30931
number_932                      =M30932
number_933                      =M30933
number_934                      =M30934
number_935                      =M30935
number_936                      =M30936
number_937                      =M30937
number_938                      =M30938
number_939                      =M30939
number_940                      =M30940
number_941                      =M30941
number_942                      =M30942
number_943                      =M30943
number_944                      =M30944
number_945                      =M30945
number_946                      =M30946
number_947                      =M30947
number_948                      =M30948
number_949                      =M30949
number_950                      =M30950
number_951                      =M30951
number_952                      =M30952
number_953                      =M30953
number_954                      =M30954
number_955                      =M30955
number_956                      =M30956
number_957                      =M30957
number_958                      =M30958
number_959                      =M30959
number_960                      =M30960
number_961                      =M30961
number_962                      =M30962
number_963                      =M30963
number_964                      =M30964
number_965                      =M30965
number_966                      =M30966
number_967                      =M30967
number_968                      =M30968
number_969                      =M30969
number_970                      =M30970
number_971                      =M30971
number_972                      =M30972
number_973                      =M30973
number_974                      =M30974
number_975                      =M30975
number_976                      =M30976
number_977                      =M30977
number_978                      =M30978
number_979                      =M30979
number_980                      =M30980
number_981                      =M30981
number_982                      =M30982
number_983                      =M30983
number_984                      =M30984
number_985                      =M30985
number_986                      =M30986
number_987                      =M30987
number_988                      =M30988
number_989                      =M30989
number_990                      =M30990
number_991                      =M30991
number_992                      =M30992
number_993                      =M30993
number_994                      =M30994
number_995                      =M30995
number_996                      =M30996
number_997                      =M30997
number_998                      =M30998
number_999                      =M30999
/**********************************************************************
* Tens "10","20","30",...,"90"
**********************************************************************/
ten_1                           =M30010
ten_2                           =M30020
ten_3                           =M30030
ten_4                           =M30040
ten_5                           =M30050
ten_6                           =M30060
ten_7                           =M30070
ten_8                           =M30080
ten_9                           =M30090
tens_1                          =M30010
tens_2                          =M30020
tens_3                          =M30030
tens_4                          =M30040
tens_5                          =M30050
tens_6                          =M30060
tens_7                          =M30070
tens_8                          =M30080
tens_9                          =M30090
/**********************************************************************
* "one hundred" thru "nine hundred"
**********************************************************************/
hundred_1                       =M33155
hundred_2                       =M33156
hundred_3                       =M33157
hundred_4                       =M33158
hundred_5                       =M33159
hundred_6                       =M33160
hundred_7                       =M33161
hundred_8                       =M33162
hundred_9                       =M33163
hundreds_1                      =M33155
hundreds_2                      =M33156
hundreds_3                      =M33157
hundreds_4                      =M33158
hundreds_5                      =M33159
hundreds_6                      =M33160
hundreds_7                      =M33161
hundreds_8                      =M33162
hundreds_9                      =M33163
/**********************************************************************
* "one thousand" thru "nine thousand"
**********************************************************************/
thousand_1                      =M33164
thousand_2                      =M33165
thousand_3                      =M33166
thousand_4                      =M33167
thousand_5                      =M33168
thousand_6                      =M33169
thousand_7                      =M33170
thousand_8                      =M33171
thousand_9                      =M33172
thousands_1                     =M33164
thousands_2                     =M33165
thousands_3                     =M33166
thousands_4                     =M33167
thousands_5                     =M33168
thousands_6                     =M33169
thousands_7                     =M33170
thousands_8                     =M33171
thousands_9                     =M33172
/**********************************************************************
* "one million" thru "nine million"
**********************************************************************/
million_1                       =M33174
million_2                       =M33175
million_3                       =M33176
million_4                       =M33177
million_5                       =M33178
million_6                       =M33179
million_7                       =M33180
million_8                       =M33181
million_9                       =M33182
millions_1                      =M33174
millions_2                      =M33175
millions_3                      =M33176
millions_4                      =M33177
millions_5                      =M33178
millions_6                      =M33179
millions_7                      =M33180
millions_8                      =M33181
millions_9                      =M33182

;"need                  millions
/**********************************************************************
* "one billion" thru "nine billion"
**********************************************************************/
billion_1                       =M33184
billion_2                       =M33185
billion_3                       =M33186
billion_4                       =M33187
billion_5                       =M33188
billion_6                       =M33189
billion_7                       =M33190
billion_8                       =M33191
billion_9                       =M33192
billions_1                      =M33184
billions_2                      =M33185
billions_3                      =M33186
billions_4                      =M33187
billions_5                      =M33188
billions_6                      =M33189
billions_7                      =M33190
billions_8                      =M33191
billions_9                      =M33192
/**********************************************************************
* Years: "nineteen forty" thru "nineteen ninety nine"
*        "two thousand"   thru "two thousand forty"
**********************************************************************/
year_1940                       =M32109
year_1941                       =M32110
year_1942                       =M32111
year_1943                       =M32112
year_1944                       =M32113
year_1945                       =M32114
year_1946                       =M32115
year_1947                       =M32116
year_1948                       =M32117
year_1949                       =M32118
year_1950                       =M32119
year_1951                       =M32120
year_1952                       =M32121
year_1953                       =M32122
year_1954                       =M32123
year_1955                       =M32124
year_1956                       =M32125
year_1957                       =M32126
year_1958                       =M32127
year_1959                       =M32128
year_1960                       =M32129
year_1961                       =M32130
year_1962                       =M32131
year_1963                       =M32132
year_1964                       =M32133
year_1965                       =M32134
year_1966                       =M32135
year_1967                       =M32136
year_1968                       =M32137
year_1969                       =M32138
year_1970                       =M32139
year_1971                       =M32140
year_1972                       =M32141
year_1973                       =M32142
year_1974                       =M32143
year_1975                       =M32144
year_1976                       =M32145
year_1977                       =M32146
year_1978                       =M32147
year_1979                       =M32148
year_1980                       =M32149
year_1981                       =M32150
year_1982                       =M32151
year_1983                       =M32152
year_1984                       =M32153
year_1985                       =M32154
year_1986                       =M32155
year_1987                       =M32156
year_1988                       =M32157
year_1989                       =M32158
year_1990                       =M32159
year_1991                       =M32160
year_1992                       =M32161
year_1993                       =M32162
year_1994                       =M32163
year_1995                       =M32164
year_1996                       =M32165
year_1997                       =M32166
year_1998                       =M32167
year_1999                       =M32168
year_2000                       =M32169
year_2001                       =M32170
year_2002                       =M32171
year_2003                       =M32172
year_2004                       =M32173
year_2005                       =M32174
year_2006                       =M32175
year_2007                       =M32176
year_2008                       =M32177
year_2009                       =M32178
year_2010                       =M32179
year_2011                       =M32180
year_2012                       =M32181
year_2013                       =M32182
year_2014                       =M32183
year_2015                       =M32184
year_2016                       =M32185
year_2017                       =M32186
year_2018                       =M32187
year_2019                       =M32188
year_2020                       =M32189
year_2021                       =M32190
year_2022                       =M32191
year_2023                       =M32192
year_2024                       =M32193
year_2025                       =M32194
year_2026                       =M32195
year_2027                       =M32196
year_2028                       =M32197
year_2029                       =M32198
year_2030                       =M32199
year_2031                       =M32200
year_2032                       =M32201
year_2033                       =M32202
year_2034                       =M32203
year_2035                       =M32204
year_2036                       =M32205
year_2037                       =M32206
year_2038                       =M32207
year_2039                       =M32208
year_2040                       =M32209
/**********************************************************************
* Letters: "A" thru "Z"
**********************************************************************/
letter_1                        =M33194
letter_2                        =M33195
letter_3                        =M33196
letter_4                        =M33197
letter_5                        =M33198
letter_6                        =M33199
letter_7                        =M33200
letter_8                        =M33201
letter_9                        =M33202
letter_10                       =M33203
letter_11                       =M33204
letter_12                       =M33205
letter_13                       =M33206
letter_14                       =M33207
letter_15                       =M33208
letter_16                       =M33209
letter_17                       =M33210
letter_18                       =M33211
letter_19                       =M33212
letter_20                       =M33213
letter_21                       =M33214
letter_22                       =M33215
letter_23                       =M33216
letter_24                       =M33217
letter_25                       =M33218
letter_26                       =M33219
letter_space                    =P10
letter_ampersand                =P10
/**********************************************************************
* SIVR Generic "Press this" becomes "Press or say this"
**********************************************************************/
press_0                         =M4554
press_1                         =M4547
press_2                         =M4548
press_3                         =M4549
press_4                         =M4550
press_5                         =M4551
press_6                         =M4552
press_7                         =M4553
press_8                         =M40412
press_9                         =M40413
press_star                      =M40444
press_pound                     =M40390
/**********************************************************************
* Generic Say this: this is 0 thru 9
**********************************************************************/
say_0                           =M4554
say_1                           =M4547
say_2                           =M4548
say_3                           =M4549
say_4                           =M4550
say_5                           =M4551
say_6                           =M4552
say_7                           =M4553
say_8                           =M40412
say_9                           =M40413

[GENERAL]
paramFileUsed                   =no
[REFERENCED_APPLICATIONS]
[EXTENSION_DB]
[DNIS_OUTDIAL_DB]
[SPEECH_VOCABULARY]
[REFERENCED_APPLICATIONS]
[ANI_OUTDIAL_DB]
[DNIS_ANI_OUTDIAL_DB]
[HOST_CONFIGURATION]
[ANI_MESSAGE_DB]
[DNIS_MESSAGE_DB]
[DNIS_ANI_MESSAGE_DB]
[END]
