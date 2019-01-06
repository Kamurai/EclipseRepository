package specification.dU231;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Enumeration extends specification.Enumeration{
	
	Set<String> amountType = new HashSet<>(Arrays.asList(new String[]{
			"IPCs:ExcessFinancingConcessionsOrSalesConcessionsAmount",
			"UndrawnHELOC",
			"TotalMonthlyIncomeNotIncludingNetRentalIncome",
			"SubtotalLiabilitiesPaidByClosingNotIncludingSubjectPropertyLiensBalance",
			"TotalPresentHousingExpense",
			"TotalLiabilitiesBalance",
			"SubtotalLiabilitiesMonthlyPayment",
			"SubtotalOmittedLiabilitiesBalance",
			"SubtotalOmittedLiabilitiesMonthlyPayment",
			"SubtotalLiabilitiesPaidByClosingNotIncludingSubjectPropertyLiensMonthlyPayment",
			"SubtotalResubordinatedLiabilitiesMonthlyPaymentForSubjectProperty",
			"SubtotalSubjectPropertyLiensPaidByClosingBalance",
			"SubtotalSubjectPropertyLiensPaidByClosingMonthlyPayment",
			"SubtotalLiabilitiesForRentalPropertyBalance",
			"SubtotalLiabilitiesForRentalPropertyMonthlyPayment",
			"SubtotalResubordinatedLiabilitiesBalanceForSubjectProperty",
			"SubtotalLiquidAssetsNotIncludingGift",
			"SubtotalNonLiquidAssets",
			"SubtotalResubordinatedLiabilitiesMonthlyPaymentforSubjectProperty",
			"EnergyImprovementAmount",
			"PACELoanPayoffAmount"
		}));
	Set<String> baseDateType = new HashSet<>(Arrays.asList(new String[]{
			"NoteDate",
			"FirstPaymentDate",
			"LastPaymentDate"
		}));
	Set<String> calculationType = new HashSet<>(Arrays.asList(new String[]{
			"AddPercenttoCurrentRate",
			"AddPercenttoOriginalRate",
			"IndexPlusMargin"
		}));
	Set<String> contributorType = new HashSet<>(Arrays.asList(new String[]{
			"Borrower",
			"Other",
			"LenderPremiumFinanced",
			"Seller",
			"Builder"
		}));
	Set<String> dispositionStatusType = new HashSet<>(Arrays.asList(new String[]{
			"PendingSale",
			"RetainForRental",
			"RetainForPrimaryOrSecondaryResidence",
			"Sold"
		}));
	Set<String> indexType = new HashSet<>(Arrays.asList(new String[]{
			"EleventhDistrictCostOfFunds",
			"OneYearTreasury",
			"ThreeYearTreasury",
			"SixMonthTreasury",
			"DailyCertificateOfDepositRate",
			"FNM60DayRequiredNetYield",
			"FNM_LIBOR",
			"FederalCostOfFunds",
			"FRE60DayRequiredNetYield",
			"FRE_LIBOR",
			"LIBOR",
			"MonthlyAverageConstantMaturingTreasury",
			"NationalAverageContractRateFHLBB",
			"NationalMonthlyMedianCostOfFunds",
			"Other",
			"TreasuryBillDailyValue",
			"WallStreetJournalLIBOR",
			"WeeklyAverageCertificateOfDepositRate",
			"WeeklyAverageConstantMaturingTreasury",
			"WeeklyAveragePrimeRate",
			"WeeklyAverageSecondaryMarketTreasuryBillInvestmentYield",
			"WeeklyAverageTreasuryAuctionAverageBondDiscountYield",
			"WeeklyAverageTreasuryAuctionAverageInvestmentYield"
		}));
	Set<String> methodType = new HashSet<>(Arrays.asList(new String[]{
			"FNM1004"
		}));
	Set<String> printPositionType = new HashSet<>(Arrays.asList(new String[]{
			"Borrower",
			"CoBorrower"
		}));
	Set<String> roleType = new HashSet<>(Arrays.asList(new String[]{
			"Home",
			"Mobile",
			"Work"
		}));
	Set<String> sourceType = new HashSet<>(Arrays.asList(new String[]{
			"BorrowerPaidOutsideClosing",
			"PropertySeller",
			"Lender",
			"NonParentRelative"
		}));
	Set<String> type = new HashSet<>(Arrays.asList(new String[]{
		"Alimony",
		"AlimonyChildSupport",
		"AmericanIndianOrAlaskaNative",
		"Automobile",
		"Bond",
		"Bridge Loan",
		"BridgeLoanNotDeposited",
		"CashOnHand",
		"CertificateOfDepositTimeDeposit",
		"CheckingAccount",
		"ConstructionOnly",
		"EarnestMoney",
		"Email",
		"GE_IQScore",
		"GiftOfEquity",
		"GiftsNotDeposited",
		"GiftsTotal",
		"LifeInsurance",
		"MetesAndBounds",
		"MoneyMarketFund",
		"MutualFund",
		"NetWorthOfBusinessOwned",
		"OtherLiquidAssets",
		"OtherNonLiquidAssets",
		"PendingNetSaleProceedsFromRealEstateAssets",
		"RelocationMoney",
		"RetirementFund",
		"SaleOtherAssets",
		"SavingsAccount",
		"SecuredBorrowedFundsNotDeposited",
		"Stock",
		"TrustAccount"
		
		}));
	Set<String> typeAsset = new HashSet<>(Arrays.asList(new String[]{
			"Automobile",
			"Bond",
			"BridgeLoanNotDeposited",
			"CashOnHand",
			"CertificateOfDepositTimeDeposit",
			"CheckingAccount",                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 
			"GiftOfEquity",
			"GiftsTotal",
			"GiftsNotDeposited",
			"LifeInsurance",
			"MoneyMarketFund",
			"MutualFund",
			"NetWorthOfBusinessOwned",
			"OtherLiquidAssets",
			"OtherNonLiquidAssets",
			"PendingNetSaleProceedsFromRealEstateAssets",
			"RelocationMoney",
			"RetirementFund",
			"SaleOtherAssets",
			"SavingsAccount",
			"SecuredBorrowedFundsNotDeposited",
			"Stock",
			"TrustAccount"
	}));
	Set<String> typeDown_Payment = new HashSet<>(Arrays.asList(new String[]{
			"BridgeLoan", //might be wrong
			"Bridge Loan", //might be wrong
			"CashOnHand",
			"CheckingSavings",
			"DepositOnSalesContract",
			"EquityOnPendingSale",
			"EquityOnSoldProperty",
			"EquityOnSubjectProperty",
			"GiftFunds",
			"LifeInsuranceCashValue",
			"LotEquity",
			"OtherTypeOfDownPayment",
			"RentWithOptionToPurchase",
			"RetirementFunds",
			"SaleOfChattel",
			"SecuredBorrowedFunds",
			"StocksAndBonds",
			"SweatEquity",
			"TradeEquity",
			"TrustFunds",
			"UnsecuredBorrowedFunds",
			"FHAGiftSourceNA",
			"FHAGiftSourceRelative",
			"FHAGiftSourceGovernmentAssistance",
			"FHAGiftSourceEmployer",
			"FHAGiftSourceNonprofitReligiousCommunitySellerFunded",
			"FHAGiftSourceNonprofitReligiousCommunityNonSellerFunded"
			}));
	Set<String> typeContact_Point = new HashSet<>(Arrays.asList(new String[]{
			"Email",
			"Fax",
			"Other",
			"Phone"
			}));
	Set<String> typeLiability = new HashSet<>(Arrays.asList(new String[]{
			"Alimony",
			"ChildCare",
			"ChildSupport",
			"CollectionsJudgementsAndLiens",
			"HELOC",
			"Installment",
			"JobRelatedExpenses",
			"LeasePayments",
			"MortgageLoan",
			"Open30DayChargeAccount",
			"OtherLiability",
			"Revolving",
			"SeparateMaintenanceExpense",
			"OtherExpense",
			"Taxes"
			}));
	Set<String> typeMortgage_Score = new HashSet<>(Arrays.asList(new String[]{
			"GE_IQScore",
			"PMIAuraAQIScore",
			"UGIAccuscore",
			"FraudFilterScore",
			"Other"
			}));
	Set<String> typePurchase_Credit = new HashSet<>(Arrays.asList(new String[]{
			"EarnestMoney",
			"RelocationFunds",
			"EmployerAssistedHousing",
			"LeasePurchaseFund",
			"Other",
			"SweatEquity"
			}));
	Set<String> applicationTakenMethodType = new HashSet<>(Arrays.asList(new String[]{
			"FaceToFace",
			"Mail",
			"Telephone",
			"Internet"
		}));
	Set<String> borrowerResidencyBasisType = new HashSet<>(Arrays.asList(new String[]{
			"LivingRentFree",
			"Own",
			"Rent"
		}));
	Set<String> borrowerResidencyType = new HashSet<>(Arrays.asList(new String[]{
			"Current",
			"Prior"
		}));
	Set<String> buildingStatusType = new HashSet<>(Arrays.asList(new String[]{
			"Existing",
			"Proposed",
			"SubjectToAlterationImprovementRepairAndRehabilitation",
			"SubstantiallyRehabilitated",
			"UnderConstruction"
		}));
	Set<String> caseStateType = new HashSet<>(Arrays.asList(new String[]{
			"Application",
			"FinalDisposition",
			"PostClosingQualityControl",
			"Prequalification",
			"Underwriting"
		}));
	Set<String> citizenshipResidencyType = new HashSet<>(Arrays.asList(new String[]{
			"USCitizen",
			"PermanentResidentAlien",
			"NonPermanentResidentAlien",
			"NonResidentAlien",
			"Unknown"
		}));
	Set<String> constructionPurposeType = new HashSet<>(Arrays.asList(new String[]{
			"ConstructionOnly",
			"ConstructionToPermanent"
		}));
	Set<String> counselingConfirmationIndicator = new HashSet<>(Arrays.asList(new String[]{
			"HomeBuyerEducationComplete",
			"OneOnOneCounselingComplete"
		}));
	Set<String> currentFirstMortgageHolderType = new HashSet<>(Arrays.asList(new String[]{
			"FNM",
			"FRE",
			"Other",
			"Unknown"
		}));
	Set<String> fHAAlimonyLiabilityTreatmentType = new HashSet<>(Arrays.asList(new String[]{
			"AdditionToDebt",
			"ReductionToIncome"
		}));
	Set<String> firstTimeHomebuyerCouncelType = new HashSet<>(Arrays.asList(new String[]{
			"NotCounseled",
			"HUDApprovedCounselingAgency"
		}));
	Set<String> fNMCommunityLendingProductType = new HashSet<>(Arrays.asList(new String[]{
			"MyCommunityMortgage",
			"HFAPreferredRiskSharing",
			"HFAPreferred",
			"HomeReady",
			"Other"
		}));
	Set<String> fNMCondominiumCharacteristicsType = new HashSet<>(Arrays.asList(new String[]{
			"Condotel",
			"TwoToFourUnitCondominiumProject",
			"KiddieCondominium",
			"OtherTypeCondominium"
		}));
	Set<String> fNMConstructionType = new HashSet<>(Arrays.asList(new String[]{
			"StickBuilt",
			"ManufacturedSingleWide",
			"ManufacturedDoubleWide",
			"PrecutModularKit",
			"Other"
		}));
	Set<String> fNMFirstLienFinancingProviderType = new HashSet<>(Arrays.asList(new String[]{
			"SameLenderAsSecondLien",
			"PrivatelyHeld",
			"OtherInstitution",
			"OtherProvider"
		}));
	Set<String> fNMFirstLienFinancingType = new HashSet<>(Arrays.asList(new String[]{
			"Fixed",
			"ARMWithoutNegativeAmortization",
			"ARMWithNegativeAmortization",
			"BalloonMortgage",
			"Reverse",
			"OpenEnd",
			"LandContract",
			"InstallmentSale",
			"Other"
		}));
	Set<String> fNMProjectWarrantyType = new HashSet<>(Arrays.asList(new String[]{
			"FNMAndFREStandardWarranty",
			"FNMLimitedWarranty",
			"FNMStandardWarranty",
			"FRELimitedWarranty",
			"FREStandardWarranty",
			"OtherWarrantable",
			"NonWarrantable",
			"FNM1028",
			"FNMExpeditedWarranty",
			"FHA",
			"FNMEXpandFRELmtdWarranty"
		}));
	Set<String> fNMPropertyLocationType = new HashSet<>(Arrays.asList(new String[]{
			"Rural",
			"Urban",
			"Suburban"
		}));
	Set<String> fNMPropertyUseType = new HashSet<>(Arrays.asList(new String[]{
			"Residential",
			"MixedResidentialAndCommercial",
			"MixedResidentialAndAgriculture",
			"MixedResidentialAndOther",
			"NonResidential",
			"UnimprovedLand",
			"Other"
		}));
	Set<String> fNMPropertyZoningType = new HashSet<>(Arrays.asList(new String[]{
			"Residential",
			"Commercial",
			"Industrial",
			"Agricultural",
			"NonResidentialWithGrandfatheredResidentialUse",
			"NoZoning",
			"Other"
		}));
	Set<String> fNMSecondLienFinancingType = new HashSet<>(Arrays.asList(new String[]{
			"StandAloneOpenEnd",
			"StandAloneClosedEnd",
			"ConcurrentOpenEnd",
			"ConcurrentClosedEnd",
			"Unknown",
			"Other"
		}));
	Set<String> fNMSubordinateLienFinancingProviderType = new HashSet<>(Arrays.asList(new String[]{
			"SameLenderAsSecondLien",
			"OtherInstitution",
			"PrivatelyHeld",
			"OtherProvider"
		}));
	Set<String> fNMUniquePropertyType = new HashSet<>(Arrays.asList(new String[]{
			"LogHome",
			"GeodesicDome",
			"Houseboat",
			"Timeshare",
			"PropertyOnIndianLand",
			"NonArmsLengthTransaction",
			"TaxShelteredSyndication",
			"BuilderModelHome",
			"PropertyCurrentlyVacant",
			"InLawSuite",
			"1031EquityExchange",
			"OtherUniqueProperty",
			"None"
		}));
	Set<String> fullPrepaymentPenaltyOptionType = new HashSet<>(Arrays.asList(new String[]{
			"Hard",
			"Soft"
		}));
	Set<String> genderType = new HashSet<>(Arrays.asList(new String[]{
			"Female",
			"Male",
			"InformationNotProvidedUnknown",
			"NotApplicable"
		}));
	Set<String> governmentRefinanceType = new HashSet<>(Arrays.asList(new String[]{
			"FullDocumentation",
			"HOPEforHomeowners",
			"InterestRateReductionRefinanceLoan",
			"PriorFHA",
			"StreamlineWithAppraisal",
			"StreamlineWithoutAppraisal"
		}));
	Set<String> gSEProjectClassificationType = new HashSet<>(Arrays.asList(new String[]{
			"OneCooperative",
			"TwoCooperative",
			"E_PUD",
			"F_PUD",
			"PCondominium",
			"QCondominium",
			"RCondominium",
			"SCondominium",
			"TCondominium",
			"UCondominium",
			"Vcondo",
			"GNotInaProjectOrDevelopment"
		}));
	Set<String> gSEPropertyTypeLoan_Features = new HashSet<>(Arrays.asList(new String[]{
			"Attached",
			"Condominium",
			"Cooperative",
			"Detached",
			"DetachedCondominium",
			"HighRiseCondominium",
			"MHSelect",
			"ManufacturedHousing",
			"ManufacturedHousingSingleWide",
			"ManufacturedHousingMultiWide",
			"ManufacturedHousingDoubleWide",
			"Modular",
			"ManufacturedHomeCondominium",
			"ManufacturedHomeCondominiumOrPUDOrCooperative",
			"PUD",
			"MHAdvantage"
		}));
	Set<String> gSEPropertyTypeReo_Property = new HashSet<>(Arrays.asList(new String[]{
			"SingleFamily",
			"Condominium",
			"Townhouse",
			"Cooperative",
			"TwoToFourUnitProperty",
			"MultifamilyMoreThanFourUnits",
			"ManufacturedMobileHome",
			"CommercialNonResidential",
			"MixedUseResidential",
			"Farm",
			"HomeAndBusinessCombined",
			"Land"
		}));
	Set<String> gSERefinancePurposeType = new HashSet<>(Arrays.asList(new String[]{
			"CashOutDebtConsolidation",
			"CashOutHomeImprovement",
			"CashOutLimited",
			"CashOutOther",
			"NoCashOutOther",
			"NoCashOutFHAStreamlinedRefinance",
			"NoCashOutFREOwnedRefinance",
			"NoCashOutStreamlinedRefinance",
			"ChangeInRateTerm"
		}));
	Set<String> hMDAEthnicityOriginType = new HashSet<>(Arrays.asList(new String[]{
			"Cuban",
			"Mexican",
			"Other",
			"PuertoRican"
		}));
	Set<String> hMDAEthnicityType = new HashSet<>(Arrays.asList(new String[]{
			"HispanicOrLatino",
			"InformationNotProvidedByApplicantInMailInternetOrTelephoneApplication",
			"NotApplicable",
			"NotHispanicOrLatino"
		}));
	Set<String> hMDAGenderCollectedBasedOnVisualObservationOrNameIndicator = new HashSet<>(Arrays.asList(new String[]{
			"yyy"
		}));
	Set<String> hMDAGenderType = new HashSet<>(Arrays.asList(new String[]{
			"ApplicantSelectedBothMaleAndFemale",
			"Female",
			"Male",
			"InformationNotProvidedUnknown",
			"NotApplicable"
		}));
	Set<String> hMDAPreapprovalType = new HashSet<>(Arrays.asList(new String[]{
			"PreapprovalWasRequested",
			"PreapprovalWasNotRequested",
			"NotApplicable"
		}));
	Set<String> hMDAPurposeOfLoanType = new HashSet<>(Arrays.asList(new String[]{
			"HomePurchase",
			"HomeImprovement",
			"Refinancing"
		}));
	Set<String> hMDARaceDesignationType   = new HashSet<>(Arrays.asList(new String[]{
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
	Set<String> hMDARaceType = new HashSet<>(Arrays.asList(new String[]{
			"AmericanIndianOrAlaskaNative",
			"Asian",
			"BlackOrAfricanAmerican",
			"InformationNotProvidedByApplicantInMailInternetOrTelephoneApplication",
			"NativeHawaiianOrOtherPacificIslander",
			"NotApplicable",
			"White"
		}));
	Set<String> homeownerPastThreeYearsType = new HashSet<>(Arrays.asList(new String[]{
			"Yes",
			"No",
			"Unknown"
		}));
	Set<String> housingExpenseTypePresent_Housing_Expense = new HashSet<>(Arrays.asList(new String[]{
			"FirstMortgagePrincipalAndInterest",
			"HazardInsurance",
			"HomeownersAssociationDuesAndCondominiumFees",
			"MI",
			"OtherHousingExpense",
			"OtherMortgageLoanPrincipalAndInterest",
			"RealEstateTax",
			"Rent"
		}));
	Set<String> housingExpenseTypeProposed_Housing_Expense = new HashSet<>(Arrays.asList(new String[]{
			"FirstMortgagePrincipalAndInterest",
			"GroundRent",
			"HazardInsurance",
			"HomeownersAssociationDuesAndCondominiumFees",
			"MI",
			"OtherHousingExpense",
			"OtherMortgageLoanPrincipalAndInterest",
			"RealEstateTax"
		}));
	Set<String> hUDLendingIncomeLimitAmount = new HashSet<>(Arrays.asList(new String[]{
			"yyy"
		}));
	Set<String> hUDMedianIncomeAmount = new HashSet<>(Arrays.asList(new String[]{
			"yyy"
		}));
	Set<String> incomeAssetVerificationType = new HashSet<>(Arrays.asList(new String[]{
			"DataVerify",
			"Formfree",
			"Placeholder"
		}));
	Set<String> incomeEmploymentMonthlyAmount = new HashSet<>(Arrays.asList(new String[]{
			"yyy"
		}));
	Set<String> incomeType = new HashSet<>(Arrays.asList(new String[]{
			"AlimonyChildSupport",
			"AutomobileExpenseAccount",
			"AccessoryUnitIncome",
			"Base",
			"Bonus",
			"CapitalGains",
			"Commissions",
			"DividendsInterest",
			"EmploymentRelatedAssets",
			"FNMBoarderIncome",
			"FNMGovernmentMortgageCreditCertificate",
			"FNMTrailingCoBorrower",
			"ForeignIncome",
			"FosterCare",
			"HousingChoiceVoucherProgramSection8",
			"MilitaryBasePay",
			"MilitaryClothesAllowance",
			"MilitaryCombatPay",
			"MilitaryFlightPay",
			"MilitaryHazardPay",
			"MilitaryOverseasPay",
			"MilitaryPropPay",
			"MilitaryQuartersAllowance",
			"MilitaryRationsAllowance",
			"MilitaryVariableHousingAllowance",
			"MortgageDifferential",
			"NetRentalIncome",
			"NonBorrowerHouseholdIncome",
			"NotesReceivableInstallment",
			"OtherTypesOfIncome",
			"Overtime",
			"Pension",
			"PublicAssistance",
			"RoyaltyPayment",
			"SeasonalIncome",
			"SocialSecurity",
			"SubjectPropertyNetCashFlow",
			"TemporaryLeave",
			"TipIncome",
			"Trust",
			"Unemployment",
			"VABenefitsNonEducational"
		}));
	Set<String> intentToOccupyType = new HashSet<>(Arrays.asList(new String[]{
			"Yes",
			"No",
			"Unknown"
		}));
	Set<String> interestOnlyTerm = new HashSet<>(Arrays.asList(new String[]{
			"yyy"
		}));
	Set<String> interviewerApplicationSignedDate = new HashSet<>(Arrays.asList(new String[]{
			"yyy"
		}));
	Set<String> investorInstitutionIdentifier = new HashSet<>(Arrays.asList(new String[]{
			"yyy"
		}));
	Set<String> jointAssetBorrowerID = new HashSet<>(Arrays.asList(new String[]{
			"yyy"
		}));
	Set<String> jointAssetLiabilityReportingType = new HashSet<>(Arrays.asList(new String[]{
			"Jointly",
			"NotJointly"
		}));
	Set<String> landTrustType = new HashSet<>(Arrays.asList(new String[]{
			"IllinoisLandTrust"
		}));
	Set<String> lenderCaseIdentifier = new HashSet<>(Arrays.asList(new String[]{
			"yyy"
		}));
	Set<String> lenderSelfInsuredIndicator = new HashSet<>(Arrays.asList(new String[]{
			"yyy"
		}));
	Set<String> lienPriorityType = new HashSet<>(Arrays.asList(new String[]{
			"FirstLien",
			"Other",
			"SecondLien"
		}));
	Set<String> lifeInsuranceFaceValueAmount = new HashSet<>(Arrays.asList(new String[]{
			"yyy"
		}));
	Set<String> loanAmortizationTermMonths = new HashSet<>(Arrays.asList(new String[]{
			"yyy"
		}));
	Set<String> loanAmortizationType = new HashSet<>(Arrays.asList(new String[]{
			"AdjustableRate",
			"Fixed",
			"GraduatedPaymentMortgage",
			"GrowingEquityMortgage",
			"OtherAmortizationType"
		}));
	Set<String> loanClosingStatusType = new HashSet<>(Arrays.asList(new String[]{
			"Closed",
			"TableFunded"
		}));
	Set<String> loanDocumentationType = new HashSet<>(Arrays.asList(new String[]{
			"Alternative",
			"FullDocumentation",
			"NoVerificationOfStatedAssets",
			"NoVerificationOfStatedIncomeEmploymentOrAssets",
			"NoDocumentation",
			"NoVerificationOfStatedIncomeOrEmployment",
			"Reduced",
			"NoRatio",
			"StreamlineRefinance",
			"FNMLimitedDocumentation",
			"NoIncomeNoEmploymentAndNoAssetsOn1003",
			"FNMNoIncomeAndNoAssetsOn1003",
			"FNMNoAssetsOn1003",
			"FNMNoIncomeAndNoEmploymentOn1003",
			"NoIncomeOn1003",
			"NoVerificationOfStatedIncomeOrAssests",
			"NoVerificationOfStatedIncome",
			"VerbalVerificationOfEmployment",
			"OnePaystub",
			"OnePaystubAndVerbalVerificationOfEmployment",
			"OnePaystubAndOneW2AndVerbalVerificationOfEmploymentOrOneYear1040",
			"NoEmploymentVerificationOrIncomeVerification",
			"NoDepositVerification",
			"NoDepositVerificationEmploymentVerificationOrIncomeVerification"
		}));
	Set<String> loanForeclosureOrJudgementIndicator = new HashSet<>(Arrays.asList(new String[]{
			"yyy"
		}));
	Set<String> loanRepaymentType = new HashSet<>(Arrays.asList(new String[]{
			"NoNegativeAmortization",
			"PotentialNegativeAmortization",
			"ScheduledAmortization",
			"ScheduledNegativeAmortization"
		}));
	Set<String> maritalStatusType = new HashSet<>(Arrays.asList(new String[]{
			"Married",
			"NotProvided",
			"Separated",
			"Unknown",
			"Unmarried"
		}));
	Set<String> methodTypeOtherDescription = new HashSet<>(Arrays.asList(new String[]{
			"yyy"
		}));
	Set<String> mIAndFundingFeeFinancedAmount = new HashSet<>(Arrays.asList(new String[]{
			"yyy"
		}));
	Set<String> mIAndFundingFeeTotalAmount = new HashSet<>(Arrays.asList(new String[]{
			"yyy"
		}));
	Set<String> mICertificationStatusType = new HashSet<>(Arrays.asList(new String[]{
			"LendertoObtain",
			"SellerofLoantoObtain"
		}));
	Set<String> mICompanyNameType = new HashSet<>(Arrays.asList(new String[]{
			"CMG_MICompany",
			"Essent",
			"GECapitalMICorporation",
			"MortgageGuarantyInsuranceCorporation",
			"PMI_MICorporation",
			"NMI",
			"RadianGuarantyIncorporated",
			"RepublicMICompany",
			"TriadGuarantyInsuranceCorporation",
			"UnitedGuarantyCorporation"
		}));
	Set<String> mortgageType = new HashSet<>(Arrays.asList(new String[]{
			"Conventional",
			"FarmersHomeAdministration",
			"FHA",
			"Other",
			"VA",
			"HELOC"
		}));
	Set<String> mSAIdentifier = new HashSet<>(Arrays.asList(new String[]{
			"yyy"
		}));
	Set<String> nameDocumentsDrawnInType = new HashSet<>(Arrays.asList(new String[]{
			"Broker",
			"Lender",
			"Investor"
		}));
	Set<String> negativeAmortizationLimitPercent = new HashSet<>(Arrays.asList(new String[]{
			"yyy"
		}));
	Set<String> nonStructuralAlterationsConventionalAmount = new HashSet<>(Arrays.asList(new String[]{
			"yyy"
		}));
	Set<String> otherAmortizationTypeDescription = new HashSet<>(Arrays.asList(new String[]{
			"yyy"
		}));
	Set<String> otherLoanPurposeDescription = new HashSet<>(Arrays.asList(new String[]{
			"yyy"
		}));
	Set<String> otherMortgageTypeDescription = new HashSet<>(Arrays.asList(new String[]{
			"yyy"
		}));
	Set<String> otherPartyPaidFHA_VAClosingCostsAmount = new HashSet<>(Arrays.asList(new String[]{
			"yyy"
		}));
	Set<String> otherPartyPaidFHA_VAClosingCostsPercent = new HashSet<>(Arrays.asList(new String[]{
			"yyy"
		}));
	Set<String> otherRaceNationalOriginDescription = new HashSet<>(Arrays.asList(new String[]{
			"HispanicOrLatino",
			"NotHispanicOrLatino",
			"InformationNotProvidedByApplicantInMailInternetOrTelephoneApplication",
			"NotApplicable"
		}));
	Set<String> outstandingJudgementsIndicator = new HashSet<>(Arrays.asList(new String[]{
			"yyy"
		}));
	Set<String> partyToLawsuitIndicator = new HashSet<>(Arrays.asList(new String[]{
			"yyy"
		}));
	Set<String> paymentFrequencyType = new HashSet<>(Arrays.asList(new String[]{
			"Biweekly",
			"Monthly"
		}));
	Set<String> plannedUnitDevelopment = new HashSet<>(Arrays.asList(new String[]{
			"yyy"
		}));
	Set<String> prepaidItemsEstimatedAmount = new HashSet<>(Arrays.asList(new String[]{
			"yyy"
		}));
	Set<String> prepaymentPenaltyIndicator = new HashSet<>(Arrays.asList(new String[]{
			"yyy"
		}));
	Set<String> prepaymentRestrictionIndicator = new HashSet<>(Arrays.asList(new String[]{
			"yyy"
		}));
	Set<String> presentlyDelinquentIndicator = new HashSet<>(Arrays.asList(new String[]{
			"yyy"
		}));
	Set<String> previousEmploymentEndDate = new HashSet<>(Arrays.asList(new String[]{
			"yyy"
		}));
	Set<String> previousEmploymentStartDate = new HashSet<>(Arrays.asList(new String[]{
			"yyy"
		}));
	Set<String> priorPropertyTitleType = new HashSet<>(Arrays.asList(new String[]{
			"Sole",
			"JointWithSpouse",
			"JointWithOtherThanSpouse"
		}));
	Set<String> priorPropertyUsageType = new HashSet<>(Arrays.asList(new String[]{
			"Investment",
			"PrimaryResidence",
			"SecondaryResidence"
		}));
	Set<String> propertyAppraisedValueAmount = new HashSet<>(Arrays.asList(new String[]{
			"yyy"
		}));
	Set<String> propertyEnergyEfficientHomeIndicator = new HashSet<>(Arrays.asList(new String[]{
			"yyy"
		}));
	Set<String> propertyExistingLienAmount = new HashSet<>(Arrays.asList(new String[]{
			"yyy"
		}));
	Set<String> propertyForeclosedPastSevenYearsIndicator = new HashSet<>(Arrays.asList(new String[]{
			"yyy"
		}));
	Set<String> propertyRightsType = new HashSet<>(Arrays.asList(new String[]{
			"yyy"
		}));
	Set<String> propertyUsageType = new HashSet<>(Arrays.asList(new String[]{
			"yyy"
		}));
	Set<String> purchasePriceAmount = new HashSet<>(Arrays.asList(new String[]{
			"yyy"
		}));
	Set<String> raceNationalOriginType = new HashSet<>(Arrays.asList(new String[]{
			"AmericanIndianOrAlaskanNative",
			"AsianOrPacificIslander",
			"BlackNotOfHispanicOrigin",
			"Hispanic",
			"InformationNotProvided",
			"Other",
			"WhiteNotOfHispanicOrigin"
		}));
	Set<String> rateLockRequestedExtensionDays = new HashSet<>(Arrays.asList(new String[]{
			"yyy"
		}));
	Set<String> rateLockType = new HashSet<>(Arrays.asList(new String[]{
			"BestEfforts",
			"Mandatory"
		}));
	Set<String> refinanceImprovementCostsAmount = new HashSet<>(Arrays.asList(new String[]{
			"yyy"
		}));
	Set<String> refinanceImprovementsType = new HashSet<>(Arrays.asList(new String[]{
			"Made",
			"ToBeMade",
			"Unknown"
		}));
	Set<String> refinanceIncludingDebtsToBePaidOffAmount = new HashSet<>(Arrays.asList(new String[]{
			"yyy"
		}));
	Set<String> refinanceProposedImprovementsDescription = new HashSet<>(Arrays.asList(new String[]{
			"yyy"
		}));
	Set<String> rEO_ID = new HashSet<>(Arrays.asList(new String[]{
			"yyy"
		}));
	Set<String> salesConcessionAmount = new HashSet<>(Arrays.asList(new String[]{
			"yyy"
		}));
	Set<String> secondaryFinancingRefinanceIndicator = new HashSet<>(Arrays.asList(new String[]{
			"yyy"
		}));
	Set<String> sectionOfActType = new HashSet<>(Arrays.asList(new String[]{
			"203B",
			"203B251",
			"203B2",
			"203K",
			"203K251",
			"221D2",
			"221D2251",
			"234C",
			"234C251",
			"257"
		}));
	Set<String> sellerPaidClosingCostsAmount = new HashSet<>(Arrays.asList(new String[]{
			"yyy"
		}));
	Set<String> sellerPaidFHA_VAClosingCostsPercent = new HashSet<>(Arrays.asList(new String[]{
			"yyy"
		}));
	Set<String> servicingTransferStatusType = new HashSet<>(Arrays.asList(new String[]{
			"Retained",
			"Released"
		}));
	Set<String> structuralAlterationsConventionalAmount = new HashSet<>(Arrays.asList(new String[]{
			"yyy"
		}));
	Set<String> subjectLoanResubordinationIndicator = new HashSet<>(Arrays.asList(new String[]{
			"yyy"
		}));
	Set<String> subordinateLienAmount = new HashSet<>(Arrays.asList(new String[]{
			"yyy"
		}));
	Set<String> vABorrowerCoBorrowerMarriedIndicator = new HashSet<>(Arrays.asList(new String[]{
			"yyy"
		}));
	Set<String> vACoBorrowerNonTaxableIncomeAmount = new HashSet<>(Arrays.asList(new String[]{
			"yyy"
		}));
	Set<String> vAFederalTaxAmount = new HashSet<>(Arrays.asList(new String[]{
			"yyy"
		}));
	Set<String> vALocalTaxAmount = new HashSet<>(Arrays.asList(new String[]{
			"yyy"
		}));
	Set<String> vAMaintenanceExpenseMonthlyAmount = new HashSet<>(Arrays.asList(new String[]{
			"yyy"
		}));
	Set<String> vAPrimaryBorrowerNonTaxableIncomeAmount = new HashSet<>(Arrays.asList(new String[]{
			"yyy"
		}));
	Set<String> vAPrimaryBorrowerTaxableIncomeAmount = new HashSet<>(Arrays.asList(new String[]{
			"yyy"
		}));
	Set<String> vAResidualIncomeAmount = new HashSet<>(Arrays.asList(new String[]{
			"yyy"
		}));
	Set<String> vASocialSecurityTaxAmount = new HashSet<>(Arrays.asList(new String[]{
			"yyy"
		}));
	Set<String> vAStateTaxAmount = new HashSet<>(Arrays.asList(new String[]{
			"yyy"
		}));
	Set<String> vAUtilityExpenseMonthlyAmount = new HashSet<>(Arrays.asList(new String[]{
			"yyy"
		}));
	Set<String> veteranStatusIndicator = new HashSet<>(Arrays.asList(new String[]{
			"yyy"
		}));
	
	public Enumeration(){}
}
