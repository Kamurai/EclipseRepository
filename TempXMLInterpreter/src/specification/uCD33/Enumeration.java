package specification.uCD33;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Enumeration extends specification.Enumeration {
	
	
	Set<String> identifierOwnerURI = new HashSet<>(Arrays.asList(new String[]{
		"mortgage.nationwidelicensingsystem.org",
		"www.fanniemae.com",
		"www.freddiemac.com",
		"http://www.mismo.org/residential/2009/SMARTDocProfile",
		"https://www.uniformdataportal.com/VAMAuthUtility/login.aspx"
	}));
	Set<String> mISMOReferenceModelIdentifier = new HashSet<>(Arrays.asList(new String[]{
			"3.3.0299"
		}));
	Set<String> SequenceNumber = new HashSet<>(Arrays.asList(new String[]{
			"1",
			"2",
			"3",
			"4",
			"5",
			"6",
			"7",
			"8",
			"9",
			"10",
			"11",
			"12",
			"13",
			"14"
		}));
	Set<String> arcrole = new HashSet<>(Arrays.asList(new String[]{
			"urn:fdc:mismo.org:2009:residential/ROLE_IsAssociatedWith_SIGNATORY",
			"urn:fdc:mismo.org:2009:residential/ROLE_IsEmployedBy_ROLE"

	}));
	Set<String> from = new HashSet<>(Arrays.asList(new String[]{
			"PARTY2_ROLE1",
			"PARTY4_ROLE1",
			"PARTY6_ROLE1",
			"PARTY8_ROLE1",
			"PARTY10_ROLE1",
			"PARTY11_ROLE1",
			"PARTY12_ROLE1",
			"PARTY13_ROLE1",
			"PARTY14_ROLE1"
	}));
	Set<String> labelRole = new HashSet<>(Arrays.asList(new String[]{
			"PARTY1_ROLE1",
			"PARTY2_ROLE1",
			"PARTY3_ROLE1",
			"PARTY4_ROLE1",
			"PARTY5_ROLE1",
			"PARTY6_ROLE1",
			"PARTY7_ROLE1",
			"PARTY8_ROLE1",
			"PARTY9_ROLE1",
			"PARTY10_ROLE1",
			"PARTY11_ROLE1",
			"PARTY12_ROLE1",
			"PARTY13_ROLE1",
			"PARTY14_ROLE1"
	}));
	Set<String> labelSignatory = new HashSet<>(Arrays.asList(new String[]{
			"SIGNATORY_1",
			"SIGNATORY_2",
			"SIGNATORY_3",
			"SIGNATORY_4"
	}));
	Set<String> to = new HashSet<>(Arrays.asList(new String[]{
			"PARTY1_ROLE1",
			"PARTY3_ROLE1",
			"PARTY5_ROLE1",
			"PARTY7_ROLE1",
			"PARTY9_ROLE1",
			"SIGNATORY_1",
			"SIGNATORY_2",
			"SIGNATORY_3",
			"SIGNATORY_4"
	}));
	Set<String> abilityToRepayExemptionReasonType = new HashSet<>(Arrays.asList(new String[]{
			"LoanProgram",
			"PropertyUsage"
	}));
	Set<String> abilityToRepayMethodType = new HashSet<>(Arrays.asList(new String[]{
			"Exempt",
			"General"
	}));
	Set<String> aboutVersionIdentifier = new HashSet<>(Arrays.asList(new String[]{
			"Retrievable"
	}));
	Set<String> actualSignatureType = new HashSet<>(Arrays.asList(new String[]{
			"Digital",
			"Image",
			"Other",
			"Text",
			"Wet"
	}));
	Set<String> addressType = new HashSet<>(Arrays.asList(new String[]{
			"Mailing"
			}));
	Set<String> addressUnitDesignatorType = new HashSet<>(Arrays.asList(new String[]{
			"Apartment",
			"Basement",
			"Building",
			"Condo",
			"Department",
			"Floor",
			"Front",
			"Hanger",
			"Key",
			"Lobby",
			"Lot",
			"Lower",
			"Office",
			"Penthouse",
			"Pier",
			"Rear",
			"Room",
			"Side",
			"Space",
			"Stop",
			"Suite",
			"Trailer",
			"Unit",
			"Upper"
			}));
	Set<String> adjustmentRuleType = new HashSet<>(Arrays.asList(new String[]{
			"First",
			"Subsequent"
			}));
	Set<String> amortizationType = new HashSet<>(Arrays.asList(new String[]{
			"AdjustableRate",
			"Fixed",
			"GEM",
			"GPM",
			"GraduatedPaymentARM",
			"Step"
			}));
	Set<String> assetType = new HashSet<>(Arrays.asList(new String[]{
			"Annuity",
			"Automobile",
			"Boat",
			"Bond",
			"CertificateOfDepositTimeDeposit",
			"LifeInsurance",
			"MoneyMarketFund",
			"MutualFund",
			"NetWorthOfBusinessOwned",
			"RetirementFund",
			"SaleOtherAssets",
			"SavingsAccount",
			"SavingsBond",
			"SecuredBorrowedFundsNotDeposited",
			"SeverancePackage",
			"Stock",
			"TrustAccount",
		}));
	Set<String> automatedUnderwritingSystemType = new HashSet<>(Arrays.asList(new String[]{
			"Assetwise",
			"Capstone",
			"Clues",
			"DesktopUnderwriter",
			"ECS",
			"FHAScorecard",
			"LoanProspector",
			"Other",
			"Strategyware",
			"Zippy"
		}));
	Set<String> automatedUnderwritingSystemTypeOtherDescription = new HashSet<>(Arrays.asList(new String[]{
			"DecisionEngine",
			"FirstMortgageCreditScore",
			"GuaranteedUnderwritingSystem"
		}));
	Set<String> closingAdjustmentItemType = new HashSet<>(Arrays.asList(new String[]{
			"FuelCosts",
			"Gift",
			"Grant",
			"Other",
			"ProceedsOfSubordinateLiens",
			"RebateCredit",
			"RelocationFunds",
			"RepairCompletionEscrowHoldback",
			"Repairs",
			"SellerCredit",
			"SellersEscrowAssumption",
			"SellersMortgageInsuranceAssumption",
			"SweatEquity",
			"TenantSecurityDeposit",
			"TradeEquity",
			"UnpaidUtilityEscrowHoldback"
		}));
	Set<String> closingAdjustmentItemTypeOtherDescription = new HashSet<>(Arrays.asList(new String[]{
			"PrincipalReduction",
			"SellersReserveAccountAssumption"
		}));
	Set<String> constructionLoanType = new HashSet<>(Arrays.asList(new String[]{
			"ConstructionOnly",
			"ConstructionToPermanent"
		}));
	Set<String> dataVersionIdentifier = new HashSet<>(Arrays.asList(new String[]{
			"UCD Delivery Specification 1.4"
	}));
	Set<String> documentFormIssuingEntityNameType = new HashSet<>(Arrays.asList(new String[]{
			"CFPB"
	}));
	Set<String> documentFormIssuingEntityVersionIdentifier = new HashSet<>(Arrays.asList(new String[]{
			"11-20-2013"
	}));
	Set<String> documentType = new HashSet<>(Arrays.asList(new String[]{
			"Other"
	}));
	Set<String> documentTypeOtherDescription = new HashSet<>(Arrays.asList(new String[]{
			"ClosingDisclosure:AlternateForm",
			"ClosingDisclosure:BorrowerOnly",
			"ClosingDisclosure:ModelForm",
			"ClosingDisclosure:SellerOnly"
	}));
	Set<String> escrowAbsenceReasonType = new HashSet<>(Arrays.asList(new String[]{
			"BorrowerDeclined",
			"LenderDoesNotOffer"
	}));
	Set<String> escrowItemPaymentPaidByType = new HashSet<>(Arrays.asList(new String[]{
			"Buyer",
			"Lender",
			"Seller",
			"ThirdParty"
	}));
	Set<String> escrowItemPaymentTimingType = new HashSet<>(Arrays.asList(new String[]{
			"AtClosing"
	}));
	Set<String> escrowItemType = new HashSet<>(Arrays.asList(new String[]{
			"AssessmentTax",
			"CityBondTax",
			"CityPropertyTax",
			"CondominiumAssociationDues",
			"CondominiumAssociationSpecialAssessment",
			"CooperativeAssociationDues",
			"CooperativeAssociationSpecialAssessment",
			"CountyBondTax",
			"CountyPropertyTax",
			"DistrictPropertyTax",
			"EarthquakeInsurance",
			"EnergyEfficientImprovementFunds",
			"FloodInsurance",
			"HailInsurancePremium",
			"HazardInsurance",
			"HomeownersAssociationDues",
			"HomeownersAssociationSpecialAssessment",
			"HomeownersInsurance",
			"MortgageInsurance",
			"Other",
			"ParishTax",
			"PestInsurance",
			"RehabilitationFunds",
			"SchoolPropertyTax",
			"StatePropertyTax",
			"TownPropertyTax",
			"TownshipPropertyTax",
			"VillagePropertyTax",
			"VolcanoInsurance",
			"WindstormInsurance"
	}));
	Set<String> escrowItemTypeOtherDescription = new HashSet<>(Arrays.asList(new String[]{
			"BoroughPropertyTax"
	}));
	Set<String> eventType = new HashSet<>(Arrays.asList(new String[]{
			"Other"
	}));
	Set<String> eventTypeOtherDescription = new HashSet<>(Arrays.asList(new String[]{
			"AppliedTamperEvidentSignature"
	}));
	Set<String> feePaidToType = new HashSet<>(Arrays.asList(new String[]{
			"Broker",
			"Investor",
			"Lender",
			"Other",
			"ThirdPartyProvider"
	}));
	Set<String> feePaidToTypeOtherDescription = new HashSet<>(Arrays.asList(new String[]{
			"BrokerAffiliate",
			"LenderAffiliate"
	}));
	Set<String> feePaymentPaidByType = new HashSet<>(Arrays.asList(new String[]{
			"Buyer",
			"Lender",
			"Seller",
			"ThirdParty"
	}));
	Set<String> feePercentBasisType = new HashSet<>(Arrays.asList(new String[]{
			"OriginalLoanAmount"
	}));
	Set<String> feeType = new HashSet<>(Arrays.asList(new String[]{
			"203KArchitecturalAndEngineeringFee",
			"203KConsultantFee",
			"203KDiscountOnRepairs",
			"203KInspectionFee",
			"203KPermits",
			"203KSupplementalOriginationFee",
			"203KTitleUpdate",
			"ApplicationFee",
			"AppraisalDeskReviewFee",
			"AppraisalFee",
			"AppraisalFieldReviewFee",
			"AppraisalManagementCompanyFee",
			"AsbestosInspectionFee",
			"AssumptionFee",
			"AutomatedUnderwritingFee",
			"AVMFee",
			"BondFee",
			"CertificationFee",
			"CondominiumAssociationDues",
			"CondominiumAssociationSpecialAssessment",
			"CooperativeAssociationDues",
			"CooperativeAssociationSpecialAssessment",
			"CopyOrFaxFee",
			"CourierFee",
			"CreditDisabilityInsurancePremium",
			"CreditLifeInsurancePremium",
			"CreditPropertyInsurancePremium",
			"CreditReportFee",
			"CreditUnemploymentInsurancePremium",
			"DebtCancellationInsurancePremium",
			"DisasterInspectionFee",
			"DocumentPreparationFee",
			"DryWallInspectionFee",
			"ElectricalInspectionFee",
			"ElectronicDocumentDeliveryFee",
			"EnvironmentalInspectionFee",
			"EscrowWaiverFee",
			"FilingFee",
			"FloodCertification",
			"FoundationInspectionFee",
			"HeatingCoolingInspectionFee",
			"HighCostMortgageCounselingFee",
			"HomeInspectionFee",
			"HomeownersAssociationDues",
			"HomeownersAssociationSpecialAssessment",
			"HomeWarrantyFee",
			"LeadInspectionFee",
			"LendersAttorneyFee",
			"LoanDiscountPoints",
			"LoanLevelPriceAdjustment",
			"LoanOriginationFee",
			"LoanOriginatorCompensation",
			"ManualUnderwritingFee",
			"MERSRegistrationFee",
			"MIUpfrontPremium",
			"MoldInspectionFee",
			"MortgageSurchargeCountyOrParish",
			"MortgageSurchargeMunicipal",
			"MortgageSurchargeState",
			"MunicipalLienCertificateFee",
			"NotaryFee",
			"Other",
			"PestInspectionFee",
			"PlumbingInspectionFee",
			"PowerOfAttorneyPreparationFee",
			"PowerOfAttorneyRecordingFee",
			"PreclosingVerificationControlFee",
			"ProcessingFee",
			"PropertyInspectionWaiverFee",
			"PropertyTaxStatusResearchFee",
			"RadonInspectionFee",
			"RateLockFee",
			"RealEstateCommissionBuyersBroker",
			"RealEstateCommissionSellersBroker",
			"ReconveyanceFee",
			"RecordingFeeForDeed",
			"RecordingFeeForMortgage",
			"RecordingFeeTotal",
			"ReinspectionFee",
			"RoofInspectionFee",
			"SepticInspectionFee",
			"SettlementFee",
			"SigningAgentFee",
			"SmokeDetectorInspectionFee",
			"StructuralInspectionFee",
			"SubordinationFee",
			"SurveyFee",
			"TemporaryBuydownAdministrationFee",
			"TemporaryBuydownPoints",
			"TitleClosingFee",
			"TitleClosingProtectionLetterFee",
			"TitleDocumentPreparationFee",
			"TitleEndorsementFee",
			"TitleExaminationFee",
			"TitleInsuranceBinderFee",
			"TitleLendersCoveragePremium",
			"TitleNotaryFee",
			"TitleOwnersCoveragePremium",
			"TitleUnderwritingIssueResolutionFee",
			"TransferTaxTotal",
			"USDARuralDevelopmentGuaranteeFee",
			"VAFundingFee",
			"VerificationOfAssetsFee",
			"VerificationOfEmploymentFee",
			"VerificationOfIncomeFee",
			"VerificationOfResidencyStatusFee",
			"VerificationOfTaxpayerIdentificationFee",
			"VerificationOfTaxReturnFee",
			"WaterTestingFee",
			"WellInspectionFee",
			"WireTransferFee"
	}));
	Set<String> feeTypeOtherDescription = new HashSet<>(Arrays.asList(new String[]{
			"DebtSuspensionInsurancePremium"
	}));
	Set<String> fundsType = new HashSet<>(Arrays.asList(new String[]{
			"DepositOnSalesContract",
			"ExcessDeposit"
	}));
	Set<String> indexType = new HashSet<>(Arrays.asList(new String[]{
			"BankPrimeLoan",
			"CertificateOfDepositIndex",
			"ConstantMaturityTreasury",
			"CostOfSavingsIndex",
			"EleventhDistrictCostOfFundsIndex",
			"LIBOR",
			"Other",
			"TreasuryBill",
			"TwelveMonthTreasuryAverage"
	}));
	Set<String> integratedDisclosureCashToCloseItemPaymentType = new HashSet<>(Arrays.asList(new String[]{
			"FromBorrower",
			"ToBorrower"
	}));
	Set<String> integratedDisclosureCashToCloseItemType = new HashSet<>(Arrays.asList(new String[]{
			"AdjustmentsAndOtherCredits",
			"CashToCloseTotal",
			"ClosingCostsFinanced",
			"ClosingCostsPaidBeforeClosing",
			"Deposit",
			"DownPayment",
			"FundsForBorrower",
			"FundsFromBorrower",
			"LoanAmount",
			"SellerCredits",
			"TotalClosingCosts",
			"TotalPayoffsAndPayments"
	}));
	Set<String> integratedDisclosureSectionType = new HashSet<>(Arrays.asList(new String[]{
			"DueFromBorrowerAtClosing",
			"DueFromSellerAtClosing",
			"DueToSellerAtClosing",
			"InitialEscrowPaymentAtClosing",
			"OriginationCharges",
			"OtherCosts",
			"PaidAlreadyByOrOnBehalfOfBorrowerAtClosing",
			"PayoffsAndPayments",
			"Prepaids",
			"ServicesBorrowerDidNotShopFor",
			"ServicesBorrowerDidShopFor",
			"TaxesAndOtherGovernmentFees",
			"TotalClosingCosts",
			"TotalLoanCosts",
			"TotalOtherCosts"
	}));
	Set<String> integratedDisclosureSubsectionPaidByType = new HashSet<>(Arrays.asList(new String[]{
			"Buyer",
			"Seller",
			"ThirdParty"
	}));
	Set<String> integratedDisclosureSubsectionPaymentTimingType = new HashSet<>(Arrays.asList(new String[]{
			"AtClosing",
			"BeforeClosing"
	}));
	Set<String> integratedDisclosureSubsectionType = new HashSet<>(Arrays.asList(new String[]{
			"Adjustments",
			"AdjustmentsForItemsPaidBySellerInAdvance",
			"AdjustmentsForItemsUnpaidBySeller",
			"ClosingCostsSubtotal",
			"LenderCredits",
			"LoanCostsSubtotal",
			"OtherCostsSubtotal",
			"OtherCredits"
	}));
	Set<String> lateChargeType = new HashSet<>(Arrays.asList(new String[]{
			"FlatDollarAmount",
			"NoLateCharges",
			"PercentageOfDelinquentInterest",
			"PercentageOfNetPayment",
			"PercentageOfPrincipalBalance",
			"PercentageOfTotalPayment",
			"PercentOfPrincipalAndInterest"
	}));
	Set<String> liabilityType = new HashSet<>(Arrays.asList(new String[]{
			"BorrowerEstimatedTotalMonthlyLiabilityPayment",
			"CollectionsJudgmentsAndLiens",
			"DeferredStudentLoan",
			"DelinquentTaxes",
			"FirstPositionMortgageLien",
			"Garnishments",
			"HELOC",
			"HomeownersAssociationLien",
			"Installment",
			"LeasePayment",
			"MortgageLoan",
			"Open30DayChargeAccount",
			"Other",
			"PersonalLoan",
			"Revolving",
			"SecondPositionMortgageLien",
			"Taxes",
			"TaxLien",
			"ThirdPositionMortgageLien",
			"UnsecuredHomeImprovementLoanInstallment",
			"UnsecuredHomeImprovementLoanRevolving"
	}));
	Set<String> licenseAuthorityLevelType = new HashSet<>(Arrays.asList(new String[]{
			"Private",
			"PublicFederal",
			"PublicLocal",
			"PublicState"
	}));
	Set<String> lienPriorityType = new HashSet<>(Arrays.asList(new String[]{
			"FirstLien",
			"FourthLien",
			"SecondLien",
			"ThirdLien"
	}));
	Set<String> loanIdentifierType = new HashSet<>(Arrays.asList(new String[]{
			"AgencyCase",
			"LenderLoan",
			"MERS_MIN"
	}));
	Set<String> loanMaturityPeriodType = new HashSet<>(Arrays.asList(new String[]{
			"Month"
		}));
	Set<String> loanPurposeType = new HashSet<>(Arrays.asList(new String[]{
			"Purchase",
			"Refinance"
		}));
	Set<String> mICompanyNameType = new HashSet<>(Arrays.asList(new String[]{
			"CMG",
			"Essent",
			"Genworth",
			"MGIC",
			"NationalMI",
			"Other",
			"PMI",
			"Radian",
			"RMIC",
			"Triad",
			"UGI"
	}));
	Set<String> mIMETypeIdentifier = new HashSet<>(Arrays.asList(new String[]{
			"application/pdf"
	}));
	Set<String> mortgageType = new HashSet<>(Arrays.asList(new String[]{
			"Conventional",
			"FHA",
			"LocalAgency",
			"Other",
			"PublicAndIndianHousing",
			"StateAgency",
			"USDARuralDevelopment",
			"VA"
		}));
	Set<String> objectEncodingType = new HashSet<>(Arrays.asList(new String[]{
			"Base64"
		}));
	Set<String> negativeAmortizationType = new HashSet<>(Arrays.asList(new String[]{
			"PotentialNegativeAmortization",
			"ScheduledNegativeAmortization"
		}));
	Set<String> partialPaymentApplicationMethodType = new HashSet<>(Arrays.asList(new String[]{
			"ApplyPartialPayment",
			"HoldUntilCompleteAmount",
			"Other"
	}));
	Set<String> partyRoleType = new HashSet<>(Arrays.asList(new String[]{
			"Borrower",
			"ClosingAgent",
			"LoanDeliveryFilePreparer",
			"MortgageBroker",
			"NonTitleSpouse",
			"NotePayTo",
			"Other",
			"PropertySeller",
			"RealEstateAgent",
			"TitleHolder"
	}));
	Set<String> partyRoleTypeOtherDescription = new HashSet<>(Arrays.asList(new String[]{
			"NonTitleNonSpouseOwnershipInterest"
	}));
	Set<String> paymentFrequencyType = new HashSet<>(Arrays.asList(new String[]{
			"Annual",
			"AtMaturity",
			"Biweekly",
			"Monthly",
			"Quarterly",
			"Semiannual",
			"Semimonthly",
			"Weekly"
	}));
	Set<String> prepaidItemPaymentPaidByType = new HashSet<>(Arrays.asList(new String[]{
			"Buyer",
			"Lender",
			"Seller",
			"ThirdParty"
	}));
	Set<String> prepaidItemPaymentTimingType = new HashSet<>(Arrays.asList(new String[]{
			"AtClosing",
			"BeforeClosing"
	}));
	Set<String> prepaidItemPerDiemCalculationMethodType = new HashSet<>(Arrays.asList(new String[]{
			"360",
			"365",
			"365Or366"
	}));
	Set<String> prepaidItemType = new HashSet<>(Arrays.asList(new String[]{
			"BoroughPropertyTax",
			"CityPropertyTax",
			"CondominiumAssociationDues",
			"CondominiumAssociationSpecialAssessment",
			"CooperativeAssociationDues",
			"CooperativeAssociationSpecialAssessment",
			"CountyPropertyTax",
			"DistrictPropertyTax",
			"EarthquakeInsurancePremium",
			"FloodInsurancePremium",
			"HailInsurancePremium",
			"HazardInsurancePremium",
			"HomeownersAssociationDues",
			"HomeownersAssociationSpecialAssessment",
			"HomeownersInsurancePremium",
			"MortgageInsurancePremium",
			"Other",
			"PrepaidInterest",
			"StatePropertyTax",
			"TownPropertyTax",
			"VolcanoInsurancePremium",
			"WindAndStormInsurancePremium"
	}));
	Set<String> projectedPaymentCalculationPeriodTermType = new HashSet<>(Arrays.asList(new String[]{
			"Other",
			"Yearly",
			"FinalPayment"
	}));
	Set<String> projectedPaymentCalculationPeriodTermTypeOtherDescription = new HashSet<>(Arrays.asList(new String[]{
			"FinalPayment"
	}));
	Set<String> ProjectedPaymentEscrowedType = new HashSet<>(Arrays.asList(new String[]{
			"Escrowed",
			"NotEscrowed"
	}));
	Set<String> projectedPaymentEstimatedTaxesInsuranceAssessmentComponentType = new HashSet<>(Arrays.asList(new String[]{
			"CondominiumAssociationDues",
			"CondominiumAssociationSpecialAssessment",
			"CooperativeAssociationDues",
			"CooperativeAssociationSpecialAssessment",
			"GroundRent",
			"HomeownersAssociationDues",
			"HomeownersAssociationSpecialAssessment",
			"HomeownersInsurance",
			"LeaseholdPayment",
			"Other",
			"PropertyTaxes"
	}));
	Set<String> propertyValuationMethodType = new HashSet<>(Arrays.asList(new String[]{
			"AutomatedValuationModel",
			"DesktopAppraisal",
			"DriveBy",
			"FullAppraisal",
			"None",
			"Other",
			"PriorAppraisalUsed"
	}));
//	static Set<String> propertyValuationMethodType = new HashSet<>(Arrays.asList(new String[]{
//			"AutomatedValuationModel",
//			"DesktopAppraisal",
//			"DriveBy",
//			"FullAppraisal",
//			"None",
//			"Other"
//			}));
//	static Set<String> PropertyValuationMethodTypeOtherDescription = new HashSet<>(Arrays.asList(new String[]{
//			"FieldReview"
//			}));
	Set<String> prorationItemType = new HashSet<>(Arrays.asList(new String[]{
			"BoroughPropertyTax",
			"CityPropertyTax",
			"CondominiumAssociationDues",
			"CondominiumAssociationSpecialAssessment",
			"CooperativeAssociationDues",
			"CooperativeAssociationSpecialAssessment",
			"CountyPropertyTax",
			"DistrictPropertyTax",
			"EarthquakeInsurancePremium",
			"FloodInsurancePremium",
			"GroundRent",
			"HailInsurancePremium",
			"HazardInsurancePremium",
			"HomeownersAssociationDues",
			"HomeownersAssociationSpecialAssessment",
			"HomeownersInsurancePremium",
			"InterestOnLoanAssumption",
			"MortgageInsurancePremium",
			"Other",
			"PastDuePropertyTax",
			"RentFromSubjectProperty",
			"StatePropertyTax",
			"TownPropertyTax",
			"Utilities",
			"VolcanoInsurancePremium",
			"WindAndStormInsurancePremium"
	}));
	Set<String> prorationItemTypeOtherDescription = new HashSet<>(Arrays.asList(new String[]{
			"OtherAssessments"
	}));
	Set<String> realEstateAgentType = new HashSet<>(Arrays.asList(new String[]{
			"Listing",
			"Selling"
	}));
	
	public Enumeration(){}
}

