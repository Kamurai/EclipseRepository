package specification.dU34;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Enumeration extends specification.Enumeration {
	
	static Set<String> mISMOReferenceModelIdentifier = new HashSet<>(Arrays.asList(new String[]{
			"3.4.032420160128"
			}));
	static Set<String> xmlns = new HashSet<>(Arrays.asList(new String[]{
			"http://www.mismo.org/residential/2009/schemas"
			}));
	static Set<String> xmlnsxsi = new HashSet<>(Arrays.asList(new String[]{
			"http://www.w3.org/2001/XMLSchema-instance"
			}));
	static Set<String> xmlnsULAD = new HashSet<>(Arrays.asList(new String[]{
			"http://www.datamodelextension.org/Schema/ULAD"
			}));
	static Set<String> xmlnsDU = new HashSet<>(Arrays.asList(new String[]{
			"http://www.datamodelextension.org/Schema/DU"
			}));
	static Set<String> xmlnsxlink = new HashSet<>(Arrays.asList(new String[]{
			"http://www.w3.org/1999/xlink"
			}));
	static Set<String> addressType = new HashSet<>(Arrays.asList(new String[]{
			"Mailing"
			}));
	static Set<String> adjustmentRuleType = new HashSet<>(Arrays.asList(new String[]{
			"First"
			}));
	static Set<String> amortizationType = new HashSet<>(Arrays.asList(new String[]{
			"AdjustableRate",
			"Fixed",
			"GEM",
			"GPM",
			"Other"
			}));
	static Set<String> applicationTakenMethodType = new HashSet<>(Arrays.asList(new String[]{
			"Email",
			"FaceToFace",
			"Fax",
			"Internet",
			"Mail",
			"Telephone"
			}));
	static Set<String> assetType = new HashSet<>(Arrays.asList(new String[]{
			"Bond",
			"BridgeLoanNotDeposited",
			"CertificateOfDepositTimeDeposit",
			"CheckingAccount",
			"IndividualDevelopmentAccount",
			"LifeInsurance",
			"MoneyMarketFund",
			"MutualFund",
			"RetirementFund",
			"SavingsAccount",
			"Stock",
			"StockOptions",
			"TrustAccount",
			"EarnestMoneyCashDepositTowardPurchase",
			"EmployerAssistance",
			"Other",
			"Other",
			"PendingNetSaleProceedsFromRealEstateAssets",
			"ProceedsFromSaleOfNonRealEstateAsset",
			"ProceedsFromSecuredLoan",
			"ProceedsFromUnsecuredLoan"
		}));
	static Set<String> assetTypeOtherDescription = new HashSet<>(Arrays.asList(new String[]{
			"OtherLiquidAsset",
			"OtherNonLiquidAsset"	
	}));
	static Set<String> attachmentType = new HashSet<>(Arrays.asList(new String[]{
			"Attached",
			"Detached"
			}));
	static Set<String> bankruptcyChapterType = new HashSet<>(Arrays.asList(new String[]{
			"ChapterEleven",
			"ChapterSeven",
			"ChapterThirteen",
			"ChapterTwelve"
			}));
	static Set<String> borrowerResidencyBasisType = new HashSet<>(Arrays.asList(new String[]{
			"LivingRentFree",
			"Own",
			"Rent"
			}));
	static Set<String> borrowerResidencyType = new HashSet<>(Arrays.asList(new String[]{
			"Current",
			"Prior"
			}));
	static Set<String> citizenshipResidencyType = new HashSet<>(Arrays.asList(new String[]{
			"NonPermanentResidentAlien",
			"PermanentResidentAlien",
			"USCitizen"
			}));
	static Set<String> closingAdjustmentItemType = new HashSet<>(Arrays.asList(new String[]{
			"LenderCredit"
		}));
	static Set<String> communityLendingProductType = new HashSet<>(Arrays.asList(new String[]{
			"HFAPreferred",
			"HFAPreferredRiskSharing",
			"HomeReady",
			"MyCommunityMortgage"
		}));
	static Set<String> communitySecondsRepaymentType = new HashSet<>(Arrays.asList(new String[]{
			"DeferredFullyForgiven",
			"DeferredNotFullyForgiven",
			"NonDeferred"
		}));
	static Set<String> constructionLoanType = new HashSet<>(Arrays.asList(new String[]{
			"ConstructionOnly",
			"ConstructionToPermanent"
		}));
	static Set<String> constructionMethodType = new HashSet<>(Arrays.asList(new String[]{
			"Manufactured",
			"Other",
			"SiteBuilt"
		}));
	static Set<String> constructionMethodTypeOtherDescription = new HashSet<>(Arrays.asList(new String[]{
			"MHAdvantage"
		}));
	static Set<String> constructionToPermanentClosingType = new HashSet<>(Arrays.asList(new String[]{
			"OneClosing",
			"TwoClosing"
		}));
	static Set<String> contactPointRoleType = new HashSet<>(Arrays.asList(new String[]{
			"Home",
			"Mobile",
			"Work"
		}));
	static Set<String> counselingFormatType = new HashSet<>(Arrays.asList(new String[]{
			"FaceToFace",
			"Internet",
			"Telephone"
			}));
	static Set<String> counselingType = new HashSet<>(Arrays.asList(new String[]{
			"Counseling",
			"Education"
			}));
	static Set<String> currentFirstMortgageHolderType = new HashSet<>(Arrays.asList(new String[]{
			"FNM"
		}));
	static Set<String> declarationExplanationDescription = new HashSet<>(Arrays.asList(new String[]{
			"ConfirmedFCEC",
			"ConfirmedFCIncorrect"
		}));
	static Set<String> declarationExplanationType = new HashSet<>(Arrays.asList(new String[]{
			"AlimonyChildSupport",
			"BorrowedDownPayment",
			"CoMakerEndorserOnNote",
			"DeclaredBankruptcyPastSevenYears",
			"DelinquencyOrDefault",
			"DirectIndirectForeclosedPropertyPastSevenYears",
			"ObligatedOnLoanForeclosedOrDeedInLieuOfJudgment",
			"OutstandingJudgments",
			"PartyToLawsuit"
		}));
	static Set<String> domesticRelationshipType = new HashSet<>(Arrays.asList(new String[]{
			"CivilUnion",
			"DomesticPartnership",
			"Other",
			"RegisteredReciprocalBeneficiaryRelationship"
			}));
	static Set<String> employmentClassificationType = new HashSet<>(Arrays.asList(new String[]{
			"Primary",
			"Secondary"
		}));
	static Set<String> employmentStatusType = new HashSet<>(Arrays.asList(new String[]{
			"Current",
			"Previous"
			}));
	static Set<String> expenseType = new HashSet<>(Arrays.asList(new String[]{
		"Alimony",
		"ChildSupport",
		"JobRelatedExpenses",
		"Other",
		"SeparateMaintenanceExpense"
		}));
	static Set<String> fundsSourceType = new HashSet<>(Arrays.asList(new String[]{
			"CommunityNonprofit",
			"Employer",
			"FederalAgency",
			"LocalAgency",
			"Other",
			"Relative",
			"ReligiousNonprofit",
			"StateAgency",
			"UnmarriedPartner"
	}));
	static Set<String> fundsSourceTypeOtherDescription = new HashSet<>(Arrays.asList(new String[]{
			"NonProfitInstrumentalityOfGovernment"
	}));
	static Set<String> governmentRefinanceType = new HashSet<>(Arrays.asList(new String[]{
			"FullDocumentation",
			"InterestRateReductionRefinanceLoan",
			"Other",
			"StreamlineWithAppraisal",
			"StreamlineWithoutAppraisal"
		}));
	static Set<String> governmentRefinanceTypeOtherDescription = new HashSet<>(Arrays.asList(new String[]{
			"203k",
			"RateTerm",
			"Short",
			"Simple",
			"StreamlinedCredit",
			"StreamlinedNonCredit"
		}));
	static Set<String> hMDAEthnicityOriginType = new HashSet<>(Arrays.asList(new String[]{
			"Cuban",
			"Mexican",
			"Other",
			"PuertoRican"
		}));
	static Set<String> HMDAEthnicityType = new HashSet<>(Arrays.asList(new String[]{
			"HispanicOrLatino",
			"NotHispanicOrLatino"
		}));
	static Set<String> hMDAGenderType = new HashSet<>(Arrays.asList(new String[]{
			"ApplicantSelectedBothMaleAndFemale",
			"Female",
			"Male"
			}));
	static Set<String> hMDARaceDesignationType = new HashSet<>(Arrays.asList(new String[]{
			"AsianIndian",
			"Chinese",
			"Filipino",
			"GuamanianOrChamorro",
			"Japanese",
			"Korean",
			"NativeHawaiian",
			"OtherAsian",
			"OtherPacificIslander",
			"Samoan",
			"Vietnamese"
			}));
	static Set<String> hMDARaceType = new HashSet<>(Arrays.asList(new String[]{
			"AmericanIndianOrAlaskaNative",
			"Asian",
			"BlackOrAfricanAmerican",
			"NativeHawaiianOrOtherPacificIslander",
			"White"
			}));
	static Set<String> homeownerPastThreeYearsType = new HashSet<>(Arrays.asList(new String[]{
			"No",
			"Unknown",
			"Yes"
			}));
	static Set<String> housingExpenseTimingType = new HashSet<>(Arrays.asList(new String[]{
			"Proposed",
		}));
	static Set<String> housingExpenseType = new HashSet<>(Arrays.asList(new String[]{
			"FirstMortgagePrincipalAndInterest",
			"HomeownersAssociationDuesAndCondominiumFees",
			"HomeownersInsurance",
			"MIPremium",
			"Other",
			"OtherMortgageLoanPrincipalAndInterest",
			"RealEstateTax",
			"Rent",
			"SupplementalPropertyInsurance"
		}));
	static Set<String> incomeType = new HashSet<>(Arrays.asList(new String[]{
			"AccessoryUnitIncome",
			"Alimony",
			"AutomobileAllowance",
			"Base",
			"BoarderIncome",
			"Bonus",
			"CapitalGains",
			"ChildSupport",
			"Commissions",
			"ContractBasis",
			"DefinedContirbutionPlan",
			"Disability",
			"DividendsInterest",
			"EmploymentRelatedAccount",
			"FosterCare",
			"HousingAllowance",
			"HousingChoiceVoucherProgram",
			"MilitaryClothesAllowance",
			"MilitaryCombatPay",
			"MilitaryFlightPay",
			"MilitaryHazardPay",
			"MilitaryOverseasPay",
			"MilitaryPropPay",
			"MilitaryQuartersAllowance",
			"MilitaryRationsAllowance",
			"MilitaryVariableHousingAllowance",
			"MortgageCreditCertificate",
			"MortgageDifferential",
			"NonBorrowerHouseholdIncome",
			"NotesReceivableInstallment",
			"Other",
			"Overtime",
			"Pension",
			"PublicAssistance",
			"Royalties",
			"SeparateMaintenance",
			"SocialSecurity",
			"TemporaryLeave",
			"TipIncome",
			"Trust",
			"Unemployment",
			"VABenefitsNonEducational"
			}));
	static Set<String> indexSourceType = new HashSet<>(Arrays.asList(new String[]{
			"Other",
		}));
	static Set<String> indexSourceTypeOtherDescription = new HashSet<>(Arrays.asList(new String[]{
			"11thDistrictCOF",
			"DailyCDRate",
			"FannieMae60DayRequiredNetYield",
			"FannieMaeLIBOR",
			"FederalCostOfFunds",
			"FreddieMac60DayRequiredNetYield",
			"FreddieMacLIBOR",
			"MonthlyAverageCMT",
			"NationalAverageContractRate",			
			"NationalMonthlyMedianCostOfFunds",
			"TBillDailyValue",
			"WallStreetJournalLIBOR",
			"WeeklyAvePrimeRate",
			"WeeklyAverageCDRate",
			"WeeklyAverageCMT",
			"WeeklyAverageSMTI",
			"WeeklyAverageTAABD",
			"WeeklyAverageTAAI"
		}));
	
	static Set<String> intentToOccupyType = new HashSet<>(Arrays.asList(new String[]{
			"No",
			"Unknown",
			"Yes"
			}));
	
	static Set<String> investorProductPlanIdentifier = new HashSet<>(Arrays.asList(new String[]{
			"57",
			"251",
			"649",
			"650",
			"651",
			"652",
			"660",
			"661",
			"681",
			"682",
			"710",
			"720",
			"721",
			"750",
			"751",
			"760",
			"761",
			"861",
			"1030",
			"1423",
			"1437",
			"3252",
			"!FNMA",
			"FHAHY",
			"GEN06",
			"GEN10",
			"GEN1A",
			"GEN1B",
			"GEN3",
			"GEN5",
			"GEN7",
			"HY101",
			"HY31",
			"HY51",
			"HY71",
			"VA1YR"
			}));
	static Set<String> languageCode = new HashSet<>(Arrays.asList(new String[]{
			"chi",
			"eng",
			"kor",
			"spa",
			"tgl",
			"vie",
			"zxx"
		}));
	static Set<String> liabilityType = new HashSet<>(Arrays.asList(new String[]{
		"CollectionsJudgmentsAndLiens",
		"DelinquentTaxes",
		"HELOC",
		"Installment",
		"LeasePayment",
		"MortgageLoan",
		"Open30DayChargeAccount",
		"Other",
		"Revolving",
		"Taxes",
		"TaxLien"
		}));	
	static Set<String> licenseAuthorityLevelType = new HashSet<>(Arrays.asList(new String[]{
			"Private",
			"PublicState"
			}));
	static Set<String> lienPriorityType = new HashSet<>(Arrays.asList(new String[]{
			"FirstLien",
			"Other",
			"SecondLien"
		}));
	static Set<String> loanAmortizationPeriodType = new HashSet<>(Arrays.asList(new String[]{
			"Month"
		}));
	static Set<String> loanIdentifierType = new HashSet<>(Arrays.asList(new String[]{
			"AgencyCase",
			"LenderLoan",
			"UniversalLoan"
		}));
	static Set<String> loanMaturityPeriodType = new HashSet<>(Arrays.asList(new String[]{
			"Month"
		}));
	static Set<String> loanPurposeType = new HashSet<>(Arrays.asList(new String[]{
			"Purchase",
			"Refinance"
		}));
	static Set<String> loanRoleType = new HashSet<>(Arrays.asList(new String[]{
			"RelatedLoan",
			"SubjectLoan"
		}));
	static Set<String> maritalStatusType = new HashSet<>(Arrays.asList(new String[]{
			"Married",
			"Separated",
			"Unmarried"
			}));
	static Set<String> militaryStatusType = new HashSet<>(Arrays.asList(new String[]{
			"ActiveDuty",
			"ReserveNationalGuardNeverActivated",
			"Veteran"
			}));
	static Set<String> mortgageType = new HashSet<>(Arrays.asList(new String[]{
			"Conventional",
			"FHA",
			"USDARuralDevelopment",
			"VA"
		}));
	static Set<String> nativeAmericanLandsType = new HashSet<>(Arrays.asList(new String[]{
			"FeeSimple",
			"IndividualTrustLand",
			"Other"
		}));
	static Set<String> nativeAmericanLandsTypeOtherDescription = new HashSet<>(Arrays.asList(new String[]{
			"AlaskaNativeCorporationLand",
			"TribalTrustLandOffReservation",
			"TribalTrustLandOnAReservation"
		}));
	static Set<String> negativeAmortizationType = new HashSet<>(Arrays.asList(new String[]{
			"PotentialNegativeAmortization",
			"ScheduledNegativeAmortization"
		}));
	static Set<String> ownedPropertyDispositionStatusType = new HashSet<>(Arrays.asList(new String[]{
			"PendingSale",
			"Retain",
			"Sold"
		}));
	static Set<String> ownershipInterestType = new HashSet<>(Arrays.asList(new String[]{
			"GreaterThanOrEqualTo25Percent",
			"LessThan25Percent"
			}));
	static Set<String> partyRoleType = new HashSet<>(Arrays.asList(new String[]{
			"Borrower",
			"HousingCounselingAgency",
			"LoanOriginationCompany",
			"LoanOriginator",
			"NotePayTo",
			"PropertyOwner",
			"SubmittingParty",
			"Trust"
			}));
	static Set<String> priorPropertyTitleType = new HashSet<>(Arrays.asList(new String[]{
			"JointWithOtherThanSpouse",
			"JointWithSpouse",
			"Sole"
			}));
	static Set<String> priorPropertyUsageType = new HashSet<>(Arrays.asList(new String[]{
			"Investment",
			"PrimaryResidence",
			"SecondHome"
			}));
	static Set<String> productDescription = new HashSet<>(Arrays.asList(new String[]{
			"AffordableLTV",
			"StandardLCOR"
			}));
	static Set<String> projectDesignType = new HashSet<>(Arrays.asList(new String[]{
		"HighriseProject"
	}));
	static Set<String> projectLegalStructureType = new HashSet<>(Arrays.asList(new String[]{
		"Condominium",
		"Cooperative"
	}));
	static Set<String> propertyCurrentUsageType = new HashSet<>(Arrays.asList(new String[]{
			"Investment",
			"PrimaryResidence",
			"SecondHome"
			}));
	static Set<String> propertyEstateType = new HashSet<>(Arrays.asList(new String[]{
			"FeeSimple",
			"Leasehold"
		}));
	static Set<String> propertyOwnerStatusType = new HashSet<>(Arrays.asList(new String[]{
			"Current",
			"Proposed"
			}));
	static Set<String> propertyUsageType = new HashSet<>(Arrays.asList(new String[]{
			"Investment",
			"PrimaryResidence",
			"SecondHome"
			}));
	static Set<String> purchaseCreditType = new HashSet<>(Arrays.asList(new String[]{
			"EarnestMoney",
			"EmployerAssistedHousing",
			"LeasePurchaseFund",
			"Other",
			"RelocationFunds",
			"SweatEquity"
		}));
	static Set<String> purchaseCreditTypeOtherDescription = new HashSet<>(Arrays.asList(new String[]{
		"BorrowerPaidFees"
	}));
	static Set<String> refinanceCashOutDeterminationType = new HashSet<>(Arrays.asList(new String[]{
		"CashOut",
		"LimitedCashOut",
		"NoCashOut"
	}));
	static Set<String> refinanceImprovementsType = new HashSet<>(Arrays.asList(new String[]{
			"Made",
			"ToBeMade",
			"Unknown"
		}));
	static Set<String> refinancePrimaryPurposeType = new HashSet<>(Arrays.asList(new String[]{
			"DebtConsolidation",
			"HomeImprovement"
			}));
	static Set<String> relationshipVestingType = new HashSet<>(Arrays.asList(new String[]{
			"Individual",
			"JointTenantsWithRightOfSurvivorship",
			"LifeEstate",
			"Other",
			"TenantsByTheEntirety",
			"TenantsInCommon"
			}));
	static Set<String> salesConcessionType = new HashSet<>(Arrays.asList(new String[]{
			"Automobile",
			"ClosingCosts",
			"Downpayment",
			"InteriorDecorationAllowance",
			"Other",
			"Prepaids",
			"Repairs",
			"ThirdPartyFinancingDiscounts",
			"Unknown"
			}));
	static Set<String> sectionOfActType = new HashSet<>(Arrays.asList(new String[]{
			"257",
			"203B",
			"203B251",
			"203K",
			"203K251",
			"234C",
			"234C251"
		}));					
	static Set<String> taxpayerIdentifierType = new HashSet<>(Arrays.asList(new String[]{
			"EmployerIdentificationNumber",
			"IndividualTaxpayerIdentificationNumber",
			"SocialSecurityNumber"
		}));
	static Set<String> trustClassificationType = new HashSet<>(Arrays.asList(new String[]{
			"LandTrust",
			"LivingTrust"
			}));
		static Set<String> validationReportSupplierType = new HashSet<>(Arrays.asList(new String[]{
			"AdvancedData",
			"Avantus",
			"Blend",
			"Chronos",
			"CoreLogic",
			"CreditInterlink",
			"DataVerify",
			"Formfree",
			"Finicity",
			"FirstAmerican",
			"Informative",
			"MeridianLink",
			"NCS",
			"PointServ",
			"PrivateEyes",
			"Sharper"
		}));
	static Set<String> validationReportType = new HashSet<>(Arrays.asList(new String[]{
			"VOA",
			"VOE",
			"VOI",
			"TAXTRANSCRIPT"
		}));
	static Set<String> verificationReportSupplierType = new HashSet<>(Arrays.asList(new String[]{
			"AdvancedData",
			"Avantus",
			"BankVOD",
			"BeSmartee",
			"Blend",
			"BlendLabs",
			"Chronos",
			"ComplianceEase",
			"CoreLogic",
			"CreditInterlink",
			"DataVerify",
			"EWS",
			"FannieMaeQA",
			"Finicity",
			"FinLocker",
			"FirstAmerican",
			"Formfree",
			"FraudTechnology",
			"Frisco",
			"IncoCheck",
			"Informative",
			"LendSnap",
			"MeridianLink",
			"NCS",
			"Placeholder",
			"Plaid",
			"PointServ",
			"PrivateEyes",
			"QuestSoft",
			"Quovo",
			"Roostify",
			"Sharper",
			"SharperLending",
			"Universal",
			"VeriTax",
			"Yodlee"
		}));
	static Set<String> verificationReportType = new HashSet<>(Arrays.asList(new String[]{
			"VOD",
			"VOE",
			"VOI",
			"TAXTRANSCRIPT"
		}));
	
	public Enumeration(){}

	public static Set<String> getMISMOReferenceModelIdentifier() {
		return mISMOReferenceModelIdentifier;
	}
	
	public static Set<String> getAddressType() {
		return addressType;
	}

	public void setAddressType(Set<String> addressType) {
		this.addressType = addressType;
	}

	public static Set<String> getAdjustmentRuleType() {
		return adjustmentRuleType;
	}

	public void setAdjustmentRuleType(Set<String> adjustmentRuleType) {
		this.adjustmentRuleType = adjustmentRuleType;
	}

	public static Set<String> getAmortizationType() {
		return amortizationType;
	}

	public void setAmortizationType(Set<String> amortizationType) {
		this.amortizationType = amortizationType;
	}

	public static Set<String> getApplicationTakenMethodType() {
		return applicationTakenMethodType;
	}

	public void setApplicationTakenMethodType(Set<String> applicationTakenMethodType) {
		this.applicationTakenMethodType = applicationTakenMethodType;
	}

	public static Set<String> getAssetType() {
		return assetType;
	}

	public void setAssetType(Set<String> assetType) {
		this.assetType = assetType;
	}

	public static Set<String> getAssetTypeOtherDescription() {
		return assetTypeOtherDescription;
	}

	public void setAssetTypeOtherDescription(Set<String> assetTypeOtherDescription) {
		this.assetTypeOtherDescription = assetTypeOtherDescription;
	}

	public static Set<String> getAttachmentType() {
		return attachmentType;
	}

	public void setAttachmentType(Set<String> attachmentType) {
		this.attachmentType = attachmentType;
	}

	public static Set<String> getBankruptcyChapterType() {
		return bankruptcyChapterType;
	}

	public void setBankruptcyChapterType(Set<String> bankruptcyChapterType) {
		this.bankruptcyChapterType = bankruptcyChapterType;
	}

	public static Set<String> getBorrowerResidencyBasisType() {
		return borrowerResidencyBasisType;
	}

	public void setBorrowerResidencyBasisType(Set<String> borrowerResidencyBasisType) {
		this.borrowerResidencyBasisType = borrowerResidencyBasisType;
	}

	public static Set<String> getBorrowerResidencyType() {
		return borrowerResidencyType;
	}

	public void setBorrowerResidencyType(Set<String> borrowerResidencyType) {
		this.borrowerResidencyType = borrowerResidencyType;
	}

	public static Set<String> getCitizenshipResidencyType() {
		return citizenshipResidencyType;
	}

	public void setCitizenshipResidencyType(Set<String> citizenshipResidencyType) {
		this.citizenshipResidencyType = citizenshipResidencyType;
	}

	public static Set<String> getClosingAdjustmentItemType() {
		return closingAdjustmentItemType;
	}

	public void setClosingAdjustmentItemType(Set<String> closingAdjustmentItemType) {
		this.closingAdjustmentItemType = closingAdjustmentItemType;
	}

	public static Set<String> getCommunityLendingProductType() {
		return communityLendingProductType;
	}

	public void setCommunityLendingProductType(Set<String> communityLendingProductType) {
		this.communityLendingProductType = communityLendingProductType;
	}

	public static Set<String> getCommunitySecondsRepaymentType() {
		return communitySecondsRepaymentType;
	}

	public void setCommunitySecondsRepaymentType(Set<String> communitySecondsRepaymentType) {
		this.communitySecondsRepaymentType = communitySecondsRepaymentType;
	}

	public static Set<String> getConstructionLoanType() {
		return constructionLoanType;
	}

	public void setConstructionLoanType(Set<String> constructionLoanType) {
		this.constructionLoanType = constructionLoanType;
	}

	public static Set<String> getConstructionMethodType() {
		return constructionMethodType;
	}

	public void setConstructionMethodType(Set<String> constructionMethodType) {
		this.constructionMethodType = constructionMethodType;
	}

	public static Set<String> getConstructionMethodTypeOtherDescription() {
		return constructionMethodTypeOtherDescription;
	}

	public void setConstructionMethodTypeOtherDescription(Set<String> constructionMethodTypeOtherDescription) {
		this.constructionMethodTypeOtherDescription = constructionMethodTypeOtherDescription;
	}

	public static Set<String> getConstructionToPermanentClosingType() {
		return constructionToPermanentClosingType;
	}

	public void setConstructionToPermanentClosingType(Set<String> constructionToPermanentClosingType) {
		this.constructionToPermanentClosingType = constructionToPermanentClosingType;
	}

	public static Set<String> getContactPointRoleType() {
		return contactPointRoleType;
	}

	public void setContactPointRoleType(Set<String> contactPointRoleType) {
		this.contactPointRoleType = contactPointRoleType;
	}

	public static Set<String> getCounselingFormatType() {
		return counselingFormatType;
	}

	public void setCounselingFormatType(Set<String> counselingFormatType) {
		this.counselingFormatType = counselingFormatType;
	}

	public static Set<String> getCounselingType() {
		return counselingType;
	}

	public void setCounselingType(Set<String> counselingType) {
		this.counselingType = counselingType;
	}

	public static Set<String> getCurrentFirstMortgageHolderType() {
		return currentFirstMortgageHolderType;
	}

	public void setCurrentFirstMortgageHolderType(Set<String> currentFirstMortgageHolderType) {
		this.currentFirstMortgageHolderType = currentFirstMortgageHolderType;
	}

	public static Set<String> getDeclarationExplanationDescription() {
		return declarationExplanationDescription;
	}

	public void setDeclarationExplanationDescription(Set<String> declarationExplanationDescription) {
		this.declarationExplanationDescription = declarationExplanationDescription;
	}

	public static Set<String> getDeclarationExplanationType() {
		return declarationExplanationType;
	}

	public void setDeclarationExplanationType(Set<String> declarationExplanationType) {
		this.declarationExplanationType = declarationExplanationType;
	}

	public static Set<String> getDomesticRelationshipType() {
		return domesticRelationshipType;
	}

	public void setDomesticRelationshipType(Set<String> domesticRelationshipType) {
		this.domesticRelationshipType = domesticRelationshipType;
	}

	public static Set<String> getEmploymentStatusType() {
		return employmentStatusType;
	}

	public void setEmploymentStatusType(Set<String> employmentStatusType) {
		this.employmentStatusType = employmentStatusType;
	}

	public static Set<String> getExpenseType() {
		return expenseType;
	}

	public void setExpenseType(Set<String> expenseType) {
		this.expenseType = expenseType;
	}

	public static Set<String> getFundsSourceType() {
		return fundsSourceType;
	}

	public void setFundsSourceType(Set<String> fundsSourceType) {
		this.fundsSourceType = fundsSourceType;
	}

	public static Set<String> getFundsSourceTypeOtherDescription() {
		return fundsSourceTypeOtherDescription;
	}

	public void setFundsSourceTypeOtherDescription(Set<String> fundsSourceTypeOtherDescription) {
		this.fundsSourceTypeOtherDescription = fundsSourceTypeOtherDescription;
	}

	public static Set<String> getGovernmentRefinanceType() {
		return governmentRefinanceType;
	}

	public void setGovernmentRefinanceType(Set<String> governmentRefinanceType) {
		this.governmentRefinanceType = governmentRefinanceType;
	}

	public static Set<String> getGovernmentRefinanceTypeOtherDescription() {
		return governmentRefinanceTypeOtherDescription;
	}

	public void setGovernmentRefinanceTypeOtherDescription(Set<String> governmentRefinanceTypeOtherDescription) {
		this.governmentRefinanceTypeOtherDescription = governmentRefinanceTypeOtherDescription;
	}

	public static Set<String> getHMDAEthnicityOriginType() {
		return hMDAEthnicityOriginType;
	}

	public void setHMDAEthnicityOriginType(Set<String> hMDAEthnicityOriginType) {
		this.hMDAEthnicityOriginType = hMDAEthnicityOriginType;
	}

	public static Set<String> getHMDAEthnicityType() {
		return HMDAEthnicityType;
	}

	public void setHMDAEthnicityType(Set<String> hMDAEthnicityType) {
		HMDAEthnicityType = hMDAEthnicityType;
	}

	public static Set<String> getHMDAGenderType() {
		return hMDAGenderType;
	}

	public void setHMDAGenderType(Set<String> hMDAGenderType) {
		this.hMDAGenderType = hMDAGenderType;
	}

	public static Set<String> getHMDARaceDesignationType() {
		return hMDARaceDesignationType;
	}

	public void setHMDARaceDesignationType(Set<String> hMDARaceDesignationType) {
		this.hMDARaceDesignationType = hMDARaceDesignationType;
	}

	public static Set<String> getHMDARaceType() {
		return hMDARaceType;
	}

	public void setHMDARaceType(Set<String> hMDARaceType) {
		this.hMDARaceType = hMDARaceType;
	}

	public static Set<String> getHomeownerPastThreeYearsType() {
		return homeownerPastThreeYearsType;
	}

	public void setHomeownerPastThreeYearsType(Set<String> homeownerPastThreeYearsType) {
		this.homeownerPastThreeYearsType = homeownerPastThreeYearsType;
	}

	public static Set<String> getHousingExpenseTimingType() {
		return housingExpenseTimingType;
	}

	public void setHousingExpenseTimingType(Set<String> housingExpenseTimingType) {
		this.housingExpenseTimingType = housingExpenseTimingType;
	}

	public static Set<String> getHousingExpenseType() {
		return housingExpenseType;
	}

	public void setHousingExpenseType(Set<String> housingExpenseType) {
		this.housingExpenseType = housingExpenseType;
	}

	public static Set<String> getIncomeType() {
		return incomeType;
	}

	public void setIncomeType(Set<String> incomeType) {
		this.incomeType = incomeType;
	}

	public static Set<String> getIndexSourceType() {
		return indexSourceType;
	}

	public void setIndexSourceType(Set<String> indexSourceType) {
		this.indexSourceType = indexSourceType;
	}

	public static Set<String> getIndexSourceTypeOtherDescription() {
		return indexSourceTypeOtherDescription;
	}

	public void setIndexSourceTypeOtherDescription(Set<String> indexSourceTypeOtherDescription) {
		this.indexSourceTypeOtherDescription = indexSourceTypeOtherDescription;
	}

	public static Set<String> getIntentToOccupyType() {
		return intentToOccupyType;
	}

	public void setIntentToOccupyType(Set<String> intentToOccupyType) {
		this.intentToOccupyType = intentToOccupyType;
	}

	public static Set<String> getInvestorProductPlanIdentifier() {
		return investorProductPlanIdentifier;
	}

	public void setInvestorProductPlanIdentifier(Set<String> investorProductPlanIdentifier) {
		this.investorProductPlanIdentifier = investorProductPlanIdentifier;
	}

	public static Set<String> getLanguageCode() {
		return languageCode;
	}

	public void setLanguageCode(Set<String> languageCode) {
		this.languageCode = languageCode;
	}

	public static Set<String> getLiabilityType() {
		return liabilityType;
	}

	public void setLiabilityType(Set<String> liabilityType) {
		this.liabilityType = liabilityType;
	}

	public static Set<String> getLicenseAuthorityLevelType() {
		return licenseAuthorityLevelType;
	}

	public void setLicenseAuthorityLevelType(Set<String> licenseAuthorityLevelType) {
		this.licenseAuthorityLevelType = licenseAuthorityLevelType;
	}

	public static Set<String> getLienPriorityType() {
		return lienPriorityType;
	}

	public void setLienPriorityType(Set<String> lienPriorityType) {
		this.lienPriorityType = lienPriorityType;
	}

	public static Set<String> getLoanAmortizationPeriodType() {
		return loanAmortizationPeriodType;
	}

	public void setLoanAmortizationPeriodType(Set<String> loanAmortizationPeriodType) {
		this.loanAmortizationPeriodType = loanAmortizationPeriodType;
	}

	public static Set<String> getLoanIdentifierType() {
		return loanIdentifierType;
	}

	public void setLoanIdentifierType(Set<String> loanIdentifierType) {
		this.loanIdentifierType = loanIdentifierType;
	}

	public static Set<String> getLoanMaturityPeriodType() {
		return loanMaturityPeriodType;
	}

	public void setLoanMaturityPeriodType(Set<String> loanMaturityPeriodType) {
		this.loanMaturityPeriodType = loanMaturityPeriodType;
	}

	public static Set<String> getLoanPurposeType() {
		return loanPurposeType;
	}

	public void setLoanPurposeType(Set<String> loanPurposeType) {
		this.loanPurposeType = loanPurposeType;
	}

	public static Set<String> getLoanRoleType() {
		return loanRoleType;
	}

	public void setLoanRoleType(Set<String> loanRoleType) {
		this.loanRoleType = loanRoleType;
	}

	public static Set<String> getMaritalStatusType() {
		return maritalStatusType;
	}

	public void setMaritalStatusType(Set<String> maritalStatusType) {
		this.maritalStatusType = maritalStatusType;
	}

	public static Set<String> getmISMOReferenceModelIdentifier() {
		return mISMOReferenceModelIdentifier;
	}

	public void setmISMOReferenceModelIdentifier(Set<String> mISMOReferenceModelIdentifier) {
		this.mISMOReferenceModelIdentifier = mISMOReferenceModelIdentifier;
	}

	public static Set<String> getMilitaryStatusType() {
		return militaryStatusType;
	}

	public void setMilitaryStatusType(Set<String> militaryStatusType) {
		this.militaryStatusType = militaryStatusType;
	}

	public static Set<String> getMortgageType() {
		return mortgageType;
	}

	public void setMortgageType(Set<String> mortgageType) {
		this.mortgageType = mortgageType;
	}

	public static Set<String> getNativeAmericanLandsType() {
		return nativeAmericanLandsType;
	}

	public void setNativeAmericanLandsType(Set<String> nativeAmericanLandsType) {
		this.nativeAmericanLandsType = nativeAmericanLandsType;
	}

	public static Set<String> getNativeAmericanLandsTypeOtherDescription() {
		return nativeAmericanLandsTypeOtherDescription;
	}

	public void setNativeAmericanLandsTypeOtherDescription(Set<String> nativeAmericanLandsTypeOtherDescription) {
		this.nativeAmericanLandsTypeOtherDescription = nativeAmericanLandsTypeOtherDescription;
	}

	public static Set<String> getNegativeAmortizationType() {
		return negativeAmortizationType;
	}

	public void setNegativeAmortizationType(Set<String> negativeAmortizationType) {
		this.negativeAmortizationType = negativeAmortizationType;
	}

	public static Set<String> getOwnedPropertyDispositionStatusType() {
		return ownedPropertyDispositionStatusType;
	}

	public void setOwnedPropertyDispositionStatusType(Set<String> ownedPropertyDispositionStatusType) {
		this.ownedPropertyDispositionStatusType = ownedPropertyDispositionStatusType;
	}

	public static Set<String> getOwnershipInterestType() {
		return ownershipInterestType;
	}

	public void setOwnershipInterestType(Set<String> ownershipInterestType) {
		this.ownershipInterestType = ownershipInterestType;
	}

	public static Set<String> getPartyRoleType() {
		return partyRoleType;
	}

	public void setPartyRoleType(Set<String> partyRoleType) {
		this.partyRoleType = partyRoleType;
	}

	public static Set<String> getPriorPropertyTitleType() {
		return priorPropertyTitleType;
	}

	public void setPriorPropertyTitleType(Set<String> priorPropertyTitleType) {
		this.priorPropertyTitleType = priorPropertyTitleType;
	}

	public static Set<String> getPriorPropertyUsageType() {
		return priorPropertyUsageType;
	}

	public void setPriorPropertyUsageType(Set<String> priorPropertyUsageType) {
		this.priorPropertyUsageType = priorPropertyUsageType;
	}

	public static Set<String> getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(Set<String> productDescription) {
		this.productDescription = productDescription;
	}

	public static Set<String> getProjectDesignType() {
		return projectDesignType;
	}

	public void setProjectDesignType(Set<String> projectDesignType) {
		this.projectDesignType = projectDesignType;
	}

	public static Set<String> getProjectLegalStructureType() {
		return projectLegalStructureType;
	}

	public void setProjectLegalStructureType(Set<String> projectLegalStructureType) {
		this.projectLegalStructureType = projectLegalStructureType;
	}

	public static Set<String> getPropertyEstateType() {
		return propertyEstateType;
	}

	public void setPropertyEstateType(Set<String> propertyEstateType) {
		this.propertyEstateType = propertyEstateType;
	}

	public static Set<String> getPropertyOwnerStatusType() {
		return propertyOwnerStatusType;
	}

	public void setPropertyOwnerStatusType(Set<String> propertyOwnerStatusType) {
		this.propertyOwnerStatusType = propertyOwnerStatusType;
	}

	public static Set<String> getPropertyUsageType() {
		return propertyUsageType;
	}

	public void setPropertyUsageType(Set<String> propertyUsageType) {
		this.propertyUsageType = propertyUsageType;
	}

	public static Set<String> getPurchaseCreditType() {
		return purchaseCreditType;
	}

	public void setPurchaseCreditType(Set<String> purchaseCreditType) {
		this.purchaseCreditType = purchaseCreditType;
	}

	public static Set<String> getPurchaseCreditTypeOtherDescription() {
		return purchaseCreditTypeOtherDescription;
	}

	public void setPurchaseCreditTypeOtherDescription(Set<String> purchaseCreditTypeOtherDescription) {
		this.purchaseCreditTypeOtherDescription = purchaseCreditTypeOtherDescription;
	}

	public static Set<String> getRefinanceCashOutDeterminationType() {
		return refinanceCashOutDeterminationType;
	}

	public void setRefinanceCashOutDeterminationType(Set<String> refinanceCashOutDeterminationType) {
		this.refinanceCashOutDeterminationType = refinanceCashOutDeterminationType;
	}

	public static Set<String> getRefinanceImprovementsType() {
		return refinanceImprovementsType;
	}

	public void setRefinanceImprovementsType(Set<String> refinanceImprovementsType) {
		this.refinanceImprovementsType = refinanceImprovementsType;
	}

	public static Set<String> getRefinancePrimaryPurposeType() {
		return refinancePrimaryPurposeType;
	}

	public void setRefinancePrimaryPurposeType(Set<String> refinancePrimaryPurposeType) {
		this.refinancePrimaryPurposeType = refinancePrimaryPurposeType;
	}

	public static Set<String> getRelationshipVestingType() {
		return relationshipVestingType;
	}

	public void setRelationshipVestingType(Set<String> relationshipVestingType) {
		this.relationshipVestingType = relationshipVestingType;
	}

	public static Set<String> getSalesConcessionType() {
		return salesConcessionType;
	}

	public void setSalesConcessionType(Set<String> salesConcessionType) {
		this.salesConcessionType = salesConcessionType;
	}

	public static Set<String> getSectionOfActType() {
		return sectionOfActType;
	}

	public void setSectionOfActType(Set<String> sectionOfActType) {
		this.sectionOfActType = sectionOfActType;
	}

	public static Set<String> getTaxpayerIdentifierType() {
		return taxpayerIdentifierType;
	}

	public void setTaxpayerIdentifierType(Set<String> taxpayerIdentifierType) {
		this.taxpayerIdentifierType = taxpayerIdentifierType;
	}

	public static Set<String> getTrustClassificationType() {
		return trustClassificationType;
	}

	public void setTrustClassificationType(Set<String> trustClassificationType) {
		this.trustClassificationType = trustClassificationType;
	}

	public static Set<String> getValidationReportSupplierType() {
		return validationReportSupplierType;
	}

	public void setValidationReportSupplierType(Set<String> validationReportSupplierType) {
		this.validationReportSupplierType = validationReportSupplierType;
	}

	public static Set<String> getValidationReportType() {
		return validationReportType;
	}

	public void setValidationReportType(Set<String> validationReportType) {
		this.validationReportType = validationReportType;
	}

	public static Set<String> getEmploymentClassificationType() {
		return employmentClassificationType;
	}

	public static void setEmploymentClassificationType(Set<String> employmentClassificationType) {
		Enumeration.employmentClassificationType = employmentClassificationType;
	}

	public static Set<String> gethMDAEthnicityOriginType() {
		return hMDAEthnicityOriginType;
	}

	public static void sethMDAEthnicityOriginType(Set<String> hMDAEthnicityOriginType) {
		Enumeration.hMDAEthnicityOriginType = hMDAEthnicityOriginType;
	}

	public static Set<String> gethMDAGenderType() {
		return hMDAGenderType;
	}

	public static void sethMDAGenderType(Set<String> hMDAGenderType) {
		Enumeration.hMDAGenderType = hMDAGenderType;
	}

	public static Set<String> gethMDARaceDesignationType() {
		return hMDARaceDesignationType;
	}

	public static void sethMDARaceDesignationType(Set<String> hMDARaceDesignationType) {
		Enumeration.hMDARaceDesignationType = hMDARaceDesignationType;
	}

	public static Set<String> gethMDARaceType() {
		return hMDARaceType;
	}

	public static void sethMDARaceType(Set<String> hMDARaceType) {
		Enumeration.hMDARaceType = hMDARaceType;
	}

	public static Set<String> getPropertyCurrentUsageType() {
		return propertyCurrentUsageType;
	}

	public static void setPropertyCurrentUsageType(Set<String> propertyCurrentUsageType) {
		Enumeration.propertyCurrentUsageType = propertyCurrentUsageType;
	}

	public static Set<String> getVerificationReportSupplierType() {
		return verificationReportSupplierType;
	}

	public static void setVerificationReportSupplierType(Set<String> verificationReportSupplierType) {
		Enumeration.verificationReportSupplierType = verificationReportSupplierType;
	}

	public static Set<String> getVerificationReportType() {
		return verificationReportType;
	}

	public static void setVerificationReportType(Set<String> verificationReportType) {
		Enumeration.verificationReportType = verificationReportType;
	}

	public static Set<String> getXmlns() {
		return xmlns;
	}

	public static void setXmlns(Set<String> xmlns) {
		Enumeration.xmlns = xmlns;
	}

	public static Set<String> getXmlnsxsi() {
		return xmlnsxsi;
	}

	public static void setXmlnsxsi(Set<String> xmlnsxsi) {
		Enumeration.xmlnsxsi = xmlnsxsi;
	}

	public static Set<String> getXmlnsULAD() {
		return xmlnsULAD;
	}

	public static void setXmlnsULAD(Set<String> xmlnsULAD) {
		Enumeration.xmlnsULAD = xmlnsULAD;
	}

	public static Set<String> getXmlnsDU() {
		return xmlnsDU;
	}

	public static void setXmlnsDU(Set<String> xmlnsDU) {
		Enumeration.xmlnsDU = xmlnsDU;
	}

	public static Set<String> getXmlnsxlink() {
		return xmlnsxlink;
	}

	public static void setXmlnsxlink(Set<String> xmlnsxlink) {
		Enumeration.xmlnsxlink = xmlnsxlink;
	}
}
