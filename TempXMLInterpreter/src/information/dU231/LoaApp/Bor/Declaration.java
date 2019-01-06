package information.dU231.LoaApp.Bor;

import java.util.ArrayList;
import java.util.List;

import information.dU231.LoaApp.Bor.Dec.Explanation;

public class Declaration 
{
	boolean alimonyChildSupportObligationIndicator;
	boolean bankruptcyIndicator;
	boolean borrowedDownPaymentIndicator;
	String citizenshipResidencyType; //Enumeration
	boolean coMakerEndorserOfNoteIndicator;
	String homeownerPastThreeYearsType; //Enumeration
	String intentToOccupyType; //Enumeration
	boolean loanForeclosureOrJudgementIndicator;
	boolean outstandingJudgementsIndicator;
	boolean partyToLawsuitIndicator;
	boolean presentlyDelinquentIndicator;
	String priorPropertyTitleType; //Enumeration
	String priorPropertyUsageType; //Enumeration
	boolean propertyForeclosedPastSevenYearsIndicator;
	List<Explanation> explanation;

	public Declaration()
	{}
}
