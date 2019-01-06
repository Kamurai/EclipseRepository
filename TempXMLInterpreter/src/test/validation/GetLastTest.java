package test.validation;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import common.Utility;
import information.dU34.Message;
import information.dU34.Mes.Deal_Set;
import information.dU34.Mes.Document_Set;
import information.dU34.Mes.DeaSet.Deal;
import information.dU34.Mes.DocSet.Document;
import information.dU34.Mes.DocSet.Doc.Signatory;
import information.uLDD30.Mes.About_Version;
import validation.ComputeError;

public class GetLastTest {
	Message message = new Message();
	About_Version about_Version = new About_Version();
	Deal_Set deal_Set = new Deal_Set();
	Document_Set document_Set = new Document_Set();
	
	public GetLastTest(){
		
	}
	
	//TODO: Replace testing with values that have not been redacted
	@Before
	public void setUpBefore() throws Exception {
//		about_Version.setAboutVersionIdentifier("Apples");
//		
//		deal_Set.getDeals().add(new Deal());
//		deal_Set.getDeals().get(0).getAsset_Summary().setLiquidAssetTotalCashOrMarketValueAmount("25.25");
//			
//		document_Set.getDocuments().add(new Document());
//		document_Set.getDocuments().get(0).getSignatories().add(new Signatory());
//		document_Set.getDocuments().get(0).getSignatories().get(0).getExecution().getExecution_Detail().setExecutionDate(Utility.setDate("1010-10-10"));
//		
//		message.getAbout_Versions().add(about_Version);
//		message.getDeal_Sets().add(deal_Set);
//		message.getDocument_Sets().add(document_Set);
	}
	
	@Test
	public void getLastAbout_Version() 
	{
//		assertEquals("getLastAbout_Version pos test", true, about_Version.getAboutVersionIdentifier().equals(((About_Version) message.getLast("About_Version")).getAboutVersionIdentifier()));
//		
//		assertEquals("getLastAbout_Version neg test", false, about_Version.getAboutVersionIdentifier().equals(message.getLast("Trouble")));
	}
	
	@Test
	public void getLastDeal_Set() 
	{
//		assertEquals("getLastAbout_Version pos test", true, document_Set.getDocuments().get(0).getSignatories().get(0).getExecution().getExecution_Detail().getExecutionDate().equals(((Document_Set) message.getLast("Document_Set")).getDocuments().get(0).getSignatories().get(0).getExecution().getExecution_Detail().getExecutionDate()));
//		
//		assertEquals("getLastAbout_Version neg test", false, about_Version.getAboutVersionIdentifier().equals(message.getLast("Trouble")));
	}
	
	@Test
	public void getLastDocument_Set() 
	{
//		assertEquals("getLastAbout_Version pos test", true, deal_Set.getDeals().get(0).getAsset_Summary().getLiquidAssetTotalCashOrMarketValueAmount().equals(((Deal_Set) message.getLast("Deal_Set")).getDeals().get(0).getAsset_Summary().getLiquidAssetTotalCashOrMarketValueAmount()));
//		
//		assertEquals("getLastAbout_Version neg test", false, about_Version.getAboutVersionIdentifier().equals(message.getLast("Trouble")));
	}
	
	
}
