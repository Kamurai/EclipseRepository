package specification.uLDD30;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Enumeration extends specification.Enumeration {
	
	Set<String> aboutVersionIdentifier = new HashSet<>(Arrays.asList(new String[]{
			"FNM 1.0",
			"FNM 2.0",
			"FNM 3.0"
			}));
	Set<String> addressType = new HashSet<>(Arrays.asList(new String[]{
			"Mailing"
			}));
	Set<String> adjustmentRuleType = new HashSet<>(Arrays.asList(new String[]{
			"First",
			"Subsequent"
			}));
	Set<String> attachmentType = new HashSet<>(Arrays.asList(new String[]{
			"Attached",
			"Detached",
			"SemiDetached"
			}));
	Set<String> automatedUnderwritingRecommendationDescription = new HashSet<>(Arrays.asList(new String[]{
			"ApproveEligible",
			"ApproveIneligible",
			"EAIEligible",
			"EAIIEligible",
			"EAIIIEligible",
			"EAIIIIneligible",
			"EAIIIneligible",
			"EAIIneligible",
			"Error",
			"OutofScope",
			"ReferEligible",
			"ReferIneligible",
			"ReferWithCaution",
			"ReferWithCautionIV",
			"Unknown"
			}));
	Set<String> automatedUnderwritingSystemType = new HashSet<>(Arrays.asList(new String[]{
			"DesktopUnderwriter",
			"Other"
			}));
	Set<String> automatedUnderwritingSystemTypeOtherDescription = new HashSet<>(Arrays.asList(new String[]{
			"GuaranteedUnderwritingSystem"
			}));
	Set<String> aVMModelNameType = new HashSet<>(Arrays.asList(new String[]{
			"AutomatedPropertyService",
			"Casa",
			"FidelityHansen",
			"HomePriceAnalyzer",
			"HomePriceIndex",
			"HomeValueExplorer",
			"Indicator",
			"NetValue",
			"Other",
			"Pass",
			"PropertySurveyAnalysisReport",
			"ValueFinder",
			"ValuePoint",
			"ValuePoint4",
			"ValuePointPlus",
			"ValueSure",
			"ValueWizard",
			"ValueWizardPlus",
			"VeroIndexPlus",
			"VeroValue"			}));
	Set<String> aVMModelNameTypeOtherDescription = new HashSet<>(Arrays.asList(new String[]{
			"MTM"			}));
	Set<String> borrowerClassificationType = new HashSet<>(Arrays.asList(new String[]{
			"Primary",
			"Secondary",
			"Borrower",
			"Lender",
			"Other"
		}));
	Set<String> buydownContributorType = new HashSet<>(Arrays.asList(new String[]{
			"Primary",
			"Secondary"
			}));
	Set<String> buydownContributorTypeOtherDescription = new HashSet<>(Arrays.asList(new String[]{
			"InterestedThirdParty"
			}));
	Set<String> citizenshipResidencyType = new HashSet<>(Arrays.asList(new String[]{
			"NonPermanentResidentAlien",
			"PermanentResidentAlien",
			"USCitizen"
		}));
	Set<String> closingCostFundsType = new HashSet<>(Arrays.asList(new String[]{
			"BridgeLoan",
			"CashOnHand",
			"CheckingSavings",
			"Contribution",
			"CreditCard",
			"EquityOnSoldProperty",
			"EquityOnSubjectProperty",
			"ForgivableSecuredLoan",
			"GiftFunds",
			"Grant",
			"LifeInsuranceCashValue",
			"LotEquity",
			"Other",
			"PremiumFunds",
			"RentWithOptionToPurchase",
			"RetirementFunds",
			"SaleOfChattel",
			"SecuredLoan",
			"StocksAndBonds",
			"SweatEquity",
			"TradeEquity",
			"TrustFunds",
			"UnsecuredBorrowedFunds"
		}));
	Set<String> closingCostFundsTypeOtherDescription = new HashSet<>(Arrays.asList(new String[]{
			"AggregatedRemainingTypes",
			"SecondaryFinancingClosedEnd",
			"SecondaryFinancingHELOC"
		}));
	Set<String> closingCostSourceType = new HashSet<>(Arrays.asList(new String[]{
			"Borrower",
			"CommunityNonProfit",
			"Employer",
			"FederalAgency",
			"Lender",
			"LocalAgency",
			"Other",
			"PropertySeller",
			"Relative",
			"ReligiousNonProfit",
			"StateAgency"
	}));
	Set<String> closingCostSourceTypeOtherDescription = new HashSet<>(Arrays.asList(new String[]{
			"AggregatedRemainingSourceTypes",
			"FHLBAffordableHousingProgram",
			"USDARuralHousing"
		}));
	Set<String> condominiumProjectStatusType = new HashSet<>(Arrays.asList(new String[]{
			"Established",
			"New"
	}));
	Set<String> constructionLoanType = new HashSet<>(Arrays.asList(new String[]{
			"ConstructionOnly",
			"ConstructionToPermanent"
	}));
	Set<String> constructionMethodType = new HashSet<>(Arrays.asList(new String[]{
			"Manufactured",
			"SiteBuilt"
	}));
	Set<String> constructionToPermanentClosingFeatureType = new HashSet<>(Arrays.asList(new String[]{
			"AutomaticConversion",
			"ModificationAgreement",
			"NewNote"
	}));
	Set<String> constructionToPermanentClosingType = new HashSet<>(Arrays.asList(new String[]{
			"OneClosing",
			"TwoClosing"
	}));
	Set<String> convertibleStatusType = new HashSet<>(Arrays.asList(new String[]{
			"Active",
			"Exercised",
			"Expired"
	}));
	Set<String> counselingConfirmationType = new HashSet<>(Arrays.asList(new String[]{
			"GovernmentAgency",
			"HUDApprovedCounselingAgency",
			"LenderTrainedCounseling",
			"NoBorrowerCounseling",
			"Other"
	}));
	Set<String> counselingConfirmationTypeOtherDescription = new HashSet<>(Arrays.asList(new String[]{
			"BorrowerDidNotParticipate",
			"MortgageInsuranceCompany",
			"NonProfitOrganization"
	}));
	Set<String> counselingFormatType = new HashSet<>(Arrays.asList(new String[]{
			"BorrowerEducationNotRequired",
			"Classroom",
			"HomeStudy",
			"Individual",
			"Other"
	}));
	Set<String> counselingFormatTypeOtherDescription = new HashSet<>(Arrays.asList(new String[]{
	"BorrowerDidNotParticipate"
	}));
	Set<String> creditRepositorySourceType = new HashSet<>(Arrays.asList(new String[]{
	"Equifax",
	"Experian",
	"TransUnion"
	}));
	Set<String> creditScoreImpairmentType = new HashSet<>(Arrays.asList(new String[]{
	"InsufficientCreditHistory",
	"SignificantErrorsScore"
	}));
	Set<String> downPaymentSourceType = new HashSet<>(Arrays.asList(new String[]{
	"Borrower",
	"CommunityNonProfit",
	"Employer",
	"FederalAgency",
	"LocalAgency",
	"OriginatingLender",
	"Other",
	"Relative",
	"ReligiousNonProfit",
	"StateAgency"
	}));
	Set<String> downPaymentSourceTypeOtherDescription = new HashSet<>(Arrays.asList(new String[]{
	"AggregatedRemainingSourceTypes",
	"FHLBAffordableHousingProgram",
	"USDARuralHousing"
	}));
	Set<String> downPaymentType = new HashSet<>(Arrays.asList(new String[]{
	"BridgeLoan",
	"CashOnHand",
	"CheckingSavings",
	"EquityOnSoldProperty",
	"EquityOnSubjectProperty",
	"ForgivableSecuredLoan",
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
	"UnsecuredBorrowedFunds"
	}));
	Set<String> downPaymentTypeOtherDescription = new HashSet<>(Arrays.asList(new String[]{
	"AggregatedRemainingTypes",
	"Grant",
	"SecondaryFinancingClosedEnd",
	"SecondaryFinancingHELOC"
	}));
	Set<String> escrowItemType = new HashSet<>(Arrays.asList(new String[]{
	"BoroughPropertyTax",
	"CityPropertyTax",
	"CountyPropertyTax",
	"DistrictPropertyTax",
	"EarthquakeInsurance",
	"FloodInsurance",
	"HazardInsurance",
	"MortgageInsurance",
	"Other",
	"OtherTax",
	"PestInsurance",
	"SchoolPropertyTax",
	"StatePropertyTax",
	"StormInsurance",
	"TownshipPropertyTax"
	}));
	Set<String> escrowItemTypeOtherDescription = new HashSet<>(Arrays.asList(new String[]{
	"Leasehold"
	}));
	Set<String> fNMHomeImprovementProductType = new HashSet<>(Arrays.asList(new String[]{
	"ActualActualBiweekly",
	"ConstructionToPermanent",
	"DailySimpleInterestCashConventional",
	"DailySimpleInterestMBS",
	"GovernmentTitleI"
	}));
	Set<String> genderType = new HashSet<>(Arrays.asList(new String[]{
	"Female",
	"InformationNotProvidedUnknown",
	"Male",
	"NotApplicable"
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
	Set<String> hMDAGenderType = new HashSet<>(Arrays.asList(new String[]{
	"ApplicantSelectedBothMaleAndFemale",
	"Female",
	"InformationNotProvidedUnknown",
	"Male",
	"NotApplicable"
	}));
	Set<String> hMDARaceDesignationType = new HashSet<>(Arrays.asList(new String[]{
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
	Set<String> indexSourceType = new HashSet<>(Arrays.asList(new String[]{
	"Other"
	}));
	Set<String> indexSourceTypeOtherDescription = new HashSet<>(Arrays.asList(new String[]{
	"10YearTreasuryConstantMaturitiesWeeklyAverage",
	"10YearTreasuryConstantMaturityMonthly",
	"11thDistrictDailyGuarRate30DayCom5Yr",
	"12MonthRollingAverageOfThe3MonthCD",
	"1MonthBritishBankersAssociationLIBOROnBloomberg",
	"1MonthBritishBankersAssociationLIBORRateMonthly",
	"1MonthCDRateSecondaryMarketWeeklyAverage",
	"1MonthTreasuryConstantMaturityWeekly",
	"1MonthWallStreetJournalLIBORRateDaily",
	"1MonthWallStreetJournalLIBORRateMonthly",
	"1YearCMTMonthlyLast4WeeksofWeekly",
	"1YearFHLBBostonAdvanceRateDaily",
	"1YearTreasuryBill364DayDiscountRateMonthly",
	"1YearTreasuryBill364DayDiscountRateWeeklyAuctionAverage",
	"1YearTreasuryConstantMaturitiesMonthlyAverage",
	"1YearTreasuryConstantMaturitiesMonthlyAverageCumulativeAveragefortheprevious12MonthsMonthlyAverage",
	"1YearTreasuryConstantMaturitiesWeeklyAverage",
	"1YearWallStreetJournalLIBORRateDaily",
	"1YearWallStreetJournalLIBORRateMonthly",
	"2YearTreasuryConstantMaturitiesWeeklyAverage",
	"30DayFRMConvPostedYieldAA",
	"30DayFRMConvPostedYieldSA",
	"30year60DayConventionalFixedRateDaily",
	"3MonthBritishBankersAssociationLIBOROnBloomberg",
	"3MonthBritishBankersAssociationLIBORRateMonthly",
	"3MonthWallStreetJournalLIBORrateDaily",
	"3MonthWallStreetJournalLIBORRateMonthly",
	"3YearTreasuryConstantMaturitiesMonthlyAverage",
	"3YearTreasuryConstantMaturitiesWeeklyAverage",
	"5YearCMTMonthlyLast4WeeksofWeekly",
	"5YearFHLBNYAdvanceRateDaily",
	"5YearTreasuryConstantMaturitiesMonthlyAverage",
	"5YearTreasuryConstantMaturitiesWeeklyAverage",
	"60DayFRMConvPostedYieldAA",
	"60DayFRMConvPostedYieldSA",
	"6MonthBritishBankersAssociationLIBORRateMonthly",
	"6MonthBritishBankersLIBORDaily",
	"6MonthCDsSecondaryMarketMonthlyAverage",
	"6MonthCDsSecondaryMarketWeeklyAverage",
	"6MonthMoneyMarketComBankWeekly",
	"6MonthTBillAuctionHighDiscountRate",
	"6MonthTreasuryBillAuctionHighDiscountRate",
	"6MonthTreasuryBillAuctionHighInvestmentRate",
	"6MonthTreasuryBillAuctionHighMonthlyAverage",
	"6MonthTreasuryBillSecondaryMarketWeeklyAverage",
	"6MonthTreasuryConstantMaturitiesWeeklyAverage",
	"6MonthTreasuryConstantMaturitySecDaily",
	"6MonthWallStreetJournalLIBORRateDaily",
	"6MonthWallStreetJournalLIBORRateMonthlyAverage",
	"7YearTreasuryConstantMaturitiesWeeklyAverage",
	"Blend50PercentFRM50PercentWeekly1YearTreasurySecurityWeeklyAverage",
	"Blend75PercentFRM25PercentWeekly1YearTreasurySecurityWeeklyAverage",
	"CumulativeAverageForThePrevious12MonthOfThe6MonthTBillMonthlyAverage",
	"CumulativeAverageForThePrevious12Months1YearTreasurySecurityMonthlyAverage",
	"CumulativeAverageforthePrevious26WeeksWeeklyAverage",
	"CumulativeAverageforthePrevious4WeeksWeeklyAverage6MonthAuctionHighDiscRate",
	"CumulativeAverageforthePrevious4WeeksWeeklyAverage6MonthAuctionHighInvestmentRate",
	"FederalReserve6MonthCDRateDaily",
	"FHFB11thDistrictCOFCumulativeAverageForThePrevious12Months",
	"FHLBB11thDistrictCostOfFundsMonthlyAverage",
	"FreddieMac30Year60DayRequiredNetYieldsDaily",
	"FreddieMacCostofFunds",
	"MonthlyAverageOfTheWeeklyAverage1YearTreasurySecurityMonthlyAverage",
	"NationalAverageContractMortgageRateForThePurchaseOfPreviouslyOccupiedHomes",
	"NationalAverageEffectiveRateoOfAllMortgageloansMonthlyAverage",
	"QuarterlyAverageOfTheFederalCOFI",
	"SemiAnnualCOFforCaliforniaSemiannualAverage",
	"SemiAnnualCOFforthe11thDistrictSemiannualAverage",
	"WallStreetJournal6MonthLIBOR",
	"WallStreetJournalPrimeRate",
	"WellsFargoCostofSavingsMonthly",
	"WellsFargoPrimeRateOnBloomberg"
	}));
	Set<String> interestAccrualType = new HashSet<>(Arrays.asList(new String[]{
	"AverageDailyInterestAccrual",
	"DailyInterestAccrual"
	}));
	Set<String> interestCalculationBasisDaysInYearCountType = new HashSet<>(Arrays.asList(new String[]{
	"360",
	"365",
	"366"
	}));
	Set<String> interestCalculationBasisType = new HashSet<>(Arrays.asList(new String[]{
	"AverageBalance",
	"DailyLoanBalance",
	"EndOfPeriod"
	}));
	Set<String> interestCalculationPeriodType = new HashSet<>(Arrays.asList(new String[]{
	"Biweekly",
	"Day",
	"Month"
	}));
	Set<String> interestCalculationType = new HashSet<>(Arrays.asList(new String[]{
	"Simple"
	}));
	Set<String> interestRateRoundingType = new HashSet<>(Arrays.asList(new String[]{
	"Down",
	"Nearest",
	"NoRounding",
	"Up"
	}));
	Set<String> investorCollateralProgramIdentifier = new HashSet<>(Arrays.asList(new String[]{
	"DUPropertyInspectionReportForm2075",
	"DURefiPlusPropertyFieldworkWaiver",
	"Level1PropertyInspectionWaiver",
	"PropertyInspectionWaiver"
	}));
	Set<String> investorRemittanceType = new HashSet<>(Arrays.asList(new String[]{
	"ActualInterestActualPrincipal",
	"ScheduledInterestActualPrincipal",
	"ScheduledInterestScheduledPrincipal"
	}));
	Set<String> legalEntityType = new HashSet<>(Arrays.asList(new String[]{
	"Corporation",
	"GovernmentEntity",
	"JointVenture",
	"LimitedLiabilityCompany",
	"LimitedPartnership",
	"NonProfitCorporation",
	"Other",
	"Partnership"
	}));
	Set<String> legalEntityTypeOtherDescription = new HashSet<>(Arrays.asList(new String[]{
	"LandTrustAndBeneficiaryIsIndividual",
	"LivingTrust"
	}));
	Set<String> lienPriorityType = new HashSet<>(Arrays.asList(new String[]{
	"FirstLien",
	"FourthLien",
	"SecondLien",
	"ThirdLien"
	}));
	Set<String> loanAmortizationPeriodType = new HashSet<>(Arrays.asList(new String[]{
	"Month"
	}));
	Set<String> loanAmortizationType = new HashSet<>(Arrays.asList(new String[]{
	"AdjustableRate",
	"Fixed",
	"GraduatedPaymentARM",
	"GraduatedPaymentMortgage",
	"GrowingEquityMortgage",
	"Step"
	}));
	Set<String> loanDefaultLossPartyType = new HashSet<>(Arrays.asList(new String[]{
	"Investor",
	"Lender",
	"Shared"
	}));
	Set<String> loanIdentifierType = new HashSet<>(Arrays.asList(new String[]{
	"UniversalLoan"
	}));
	Set<String> loanLevelCreditScoreSelectionMethodType = new HashSet<>(Arrays.asList(new String[]{
	"AverageThenAverage",
	"MiddleOrLowerThenAverage",
	"MiddleOrLowerThenLowest",
	"Other"
	}));
	Set<String> loanLevelCreditScoreSelectionMethodTypeOtherDescription = new HashSet<>(Arrays.asList(new String[]{
	"SellerSpecific"
	}));
	Set<String> loanMaturityPeriodType = new HashSet<>(Arrays.asList(new String[]{
	"Month"
	}));
	Set<String> loanOriginatorType = new HashSet<>(Arrays.asList(new String[]{
	"Broker",
	"Correspondent",
	"Lender"
	}));
	Set<String> loanProgramIdentifier = new HashSet<>(Arrays.asList(new String[]{
	"LoanFirstTimeHomebuyer"
	}));
	Set<String> loanPurposeType = new HashSet<>(Arrays.asList(new String[]{
	"Purchase",
	"Refinance"
	}));
	Set<String> loanRoleType = new HashSet<>(Arrays.asList(new String[]{
	"RelatedLoan",
	"SubjectLoan"
	}));
	Set<String> loanStateType = new HashSet<>(Arrays.asList(new String[]{
	"AtClosing",
	"AtModification",
	"Current"
	}));
	Set<String> manufacturedHomeWidthType = new HashSet<>(Arrays.asList(new String[]{
	"MultiWide",
	"SingleWide"
	}));
	Set<String> mICompanyNameType = new HashSet<>(Arrays.asList(new String[]{
	"Essent",
	"Genworth",
	"MGIC",
	"Other",
	"PMI",
	"Radian",
	"RMIC",
	"Triad",
	"UGI"
	}));
	Set<String> mICompanyNameTypeOtherDescription = new HashSet<>(Arrays.asList(new String[]{
	"ArchMI",
	"CAHLIF",
	"MDHousing",
	"MIF",
	"NMI"
	}));
	Set<String> mIPremiumSourceType = new HashSet<>(Arrays.asList(new String[]{
	"Borrower",
	"Lender"
	}));
	Set<String> mISMOReferenceModelIdentifier = new HashSet<>(Arrays.asList(new String[]{
	"3.0.0.263.12"
	}));
	Set<String> mortgageType = new HashSet<>(Arrays.asList(new String[]{
	"Conventional",
	"FHA",
	"USDARuralHousing",
	"VA"
	}));
	Set<String> partyRoleType = new HashSet<>(Arrays.asList(new String[]{
	"Appraiser",
	"AppraiserSupervisor",
	"Borrower",
	"DocumentCustodian",
	"LoanDeliveryFilePreparer",
	"LoanOriginationCompany",
	"LoanOriginator",
	"LoanSeller",
	"NotePayTo",
	"Other",
	"Payee",
	"Servicer",
	"WarehouseLender"
	}));
	Set<String> partyRoleTypeOtherDescription = new HashSet<>(Arrays.asList(new String[]{
	"HomeownersAssociation"
	}));
	Set<String> paymentFrequencyType = new HashSet<>(Arrays.asList(new String[]{
	"Monthly"
	}));
	Set<String> poolAccrualRateStructureType = new HashSet<>(Arrays.asList(new String[]{
	"StatedStructure",
	"WeightedAverageStructure"
	}));
	Set<String> poolAmortizationType = new HashSet<>(Arrays.asList(new String[]{
	"AdjustableRate",
	"Fixed",
	"GraduatedPaymentARM",
	"GraduatedPaymentMortgage",
	"GrowingEquityMortgage",
	"Step"
	}));
	Set<String> poolInterestRateRoundingType = new HashSet<>(Arrays.asList(new String[]{
	"Down",
	"Nearest",
	"NoRounding",
	"Up"
	}));
	Set<String> poolMortgageType = new HashSet<>(Arrays.asList(new String[]{
	"Conventional",
	"FHA",
	"USDARuralHousing",
	"VA"
	}));
	Set<String> poolStructureType = new HashSet<>(Arrays.asList(new String[]{
	"InvestorDefinedMultipleLender",
	"LenderInitiatedMultipleLender",
	"SingleLender"
	}));
	Set<String> primaryMIAbsenceReasonType = new HashSet<>(Arrays.asList(new String[]{
	"MICanceledBasedOnCurrentLTV",
	"NoMIBasedOnOriginalLTV",
	"Other"
	}));
	Set<String> projectAttachmentType = new HashSet<>(Arrays.asList(new String[]{
	"Attached",
	"Detached"
	}));
	Set<String> projectClassificationIdentifier = new HashSet<>(Arrays.asList(new String[]{
	"1",
	"2",
	"E",
	"F",
	"G",
	"P",
	"Q",
	"R",
	"S",
	"T",
	"U",
	"V"
	}));
	Set<String> projectDesignType = new HashSet<>(Arrays.asList(new String[]{
	"GardenProject",
	"HighriseProject",
	"MidriseProject",
	"Other",
	"TownhouseRowhouse"
	}));
	Set<String> projectDesignTypeOtherDescription = new HashSet<>(Arrays.asList(new String[]{
	"OtherSelectedOnValuationDocumentation"
	}));
	Set<String> projectLegalStructureType = new HashSet<>(Arrays.asList(new String[]{
	"Condominium",
	"Cooperative"
	}));
	Set<String> propertyEstateType = new HashSet<>(Arrays.asList(new String[]{
	"FeeSimple",
	"Leasehold",
	"Other"
	}));
	Set<String> propertyEstateTypeOtherDescription = new HashSet<>(Arrays.asList(new String[]{
	"LifeEstate"
	}));
	Set<String> propertyUsageType = new HashSet<>(Arrays.asList(new String[]{
	"Investment",
	"PrimaryResidence",
	"SecondHome"
	}));
	Set<String> propertyValuationFormType = new HashSet<>(Arrays.asList(new String[]{
	"DesktopUnderwriterPropertyInspectionReport",
	"ExteriorOnlyInspectionIndividualCondominiumUnitAppraisalReport",
	"ExteriorOnlyInspectionIndividualCooperativeInterestAppraisalReport",
	"ExteriorOnlyInspectionResidentialAppraisalReport",
	"IndividualCondominiumUnitAppraisalReport",
	"IndividualCooperativeInterestAppraisalReport",
	"ManufacturedHomeAppraisalReport",
	"OneUnitResidentialAppraisalFieldReviewReport",
	"SmallResidentialIncomePropertyAppraisalReport",
	"TwoToFourUnitResidentialAppraisal",
	"UniformResidentialAppraisalReport"
	}));
	Set<String> propertyValuationMethodType = new HashSet<>(Arrays.asList(new String[]{
	"AutomatedValuationModel",
	"DesktopAppraisal",
	"DriveBy",
	"FullAppraisal",
	"None",
	"Other"
	}));
	Set<String> propertyValuationMethodTypeOtherDescription = new HashSet<>(Arrays.asList(new String[]{
	"FieldReview"
	}));
	Set<String> refinanceCashOutDeterminationType = new HashSet<>(Arrays.asList(new String[]{
	"CashOut",
	"LimitedCashOut",
	"NoCashOut"
	}));
	Set<String> refinanceProgramIdentifier = new HashSet<>(Arrays.asList(new String[]{
	"DisasterResponse",
	"DURefiPlus",
	"HighLTVRefi",
	"RefiPlus",
	"TexasEquity"
	}));
	Set<String> relatedLoanInvestorType = new HashSet<>(Arrays.asList(new String[]{
	"FNM"
	}));
	Set<String> rEOMarketingPartyType = new HashSet<>(Arrays.asList(new String[]{
	"Investor",
	"Lender"
	}));
	Set<String> sectionOfActType = new HashSet<>(Arrays.asList(new String[]{
	"184",
	"213",
	"220",
	"221",
	"222",
	"233",
	"235",
	"237",
	"240",
	"245",
	"247",
	"248",
	"251",
	"255",
	"256",
	"257",
	"502",
	"3703",
	"3710",
	"3711",
	"201S",
	"201SD",
	"201U",
	"201UD",
	"203B",
	"203B2",
	"203B241",
	"203B251",
	"203H",
	"203I",
	"203K",
	"203K241",
	"203K251",
	"221D2",
	"221D2251",
	"223E",
	"234C",
	"234C251",
	"3703D",
	"3703D2"
	}));
	Set<String> taxpayerIdentifierType = new HashSet<>(Arrays.asList(new String[]{
	"EmployerIdentificationNumber",
	"IndividualTaxpayerIdentificationNumber",
	"SocialSecurityNumber"
	}));
	
	public Enumeration(){}
}

