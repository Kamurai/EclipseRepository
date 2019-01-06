package selection;

import java.util.EnumSet;
import java.util.HashSet;

public class Selector {
	/*
	 * The purpose of this class is, given the correct input, to perform the
	 * selection of the Product, Mismo Version, and Test Case (if any).
	 */
	

	public enum Product {
		DU, UCD, ULDD;
	};

	Product product;
	public static EnumSet<Product> productEnumSet = EnumSet.allOf(Product.class);

	public enum MismoVersion {
		v231, v30, v33, v34
	};

	MismoVersion mismoVersion;
	public static EnumSet<MismoVersion> mismoVersionEnumSet = EnumSet.allOf(MismoVersion.class);

	public enum TestCase {
		TC00, // equivalent of "no Test Case"
		TC01, TC02, TC03, TC04, TC05, TC06, TC07, TC08, TC09, TC10, TC11, TC12, TC13, TC14, TC15
	};

	TestCase testCase;
	public static EnumSet<TestCase> testCaseEnumSet = EnumSet.allOf(TestCase.class);

	public Selector() {
		product = Product.DU;
		mismoVersion = MismoVersion.v231;
		testCase = TestCase.TC00;
	}

	public Selector(Product vProduct, MismoVersion vMismoVersion, TestCase vTestCase) {
		this.product = vProduct;
		this.mismoVersion = vMismoVersion;
		this.testCase = vTestCase;
	}

	public String selectTestCase() {
		String result = "-1";
		result = selectTestCase(product, mismoVersion, testCase);

		return result;
	}

	public static String selectTestCase(Product vProduct, MismoVersion vMismoVersion, TestCase vTestCase) {
		String result = "-1";

		switch (vTestCase) {
		case TC00:
			return result;
			
		default:
			result = "Resources/TestCases/";

			switch (vProduct) {
			case DU:
				result += "DU";
				
				switch (vMismoVersion) {
				case v231:
					result += "231/";
					result += "DU_231_";

					switch (vTestCase) {
					case TC01:
						result += "TC01";
						result += "_v10_C01_Fixed_Primary_Attached_BW";
						break;
					case TC02:
						result += "TC02";
						result += "_v10_C02_ARM_FNM_ARM_Plan_4_Unit_Investor_BW_BW_QZ";
						break;
					case TC03:
						result += "TC03";
						result += "_v10_C03_Fixed_Refi_CO_Second_Home_IO_BW_QZ";
						break;
					case TC04:
						result += "TC04";
						result += "_v10_C04_Fixed_Refi_Ltd_CO_Primary_Undrawn_HELOC_BW_QZ";
						break;
					case TC05:
						result += "TC05";
						result += "_v10_C05_Fixed_Construction_Primary_80_10_10_BW";
						break;
					case TC06:
						result += "TC06";
						result += "_v10_C06_Fixed_ConPerm_Primary_BW_BW";
						break;
					case TC07:
						result += "TC07";
						result += "_v10_C07_Fixed_Purchase_Primary_Financed_MI_Ground_Rent_BW";
						break;
					case TC08:
						result += "TC08";
						result += "_v10_C08_Fixed_Purchase_Primary_Manufactured_BW_QZ";
						break;
					case TC09:
						result += "TC09";
						result += "_v10_CL01_Fixed_HomeStyle_Primary_Purchase_80_10_10_BW";
						break;
					case TC10:
						result += "TC10";
						result += "_v10_FHA01_203b";
						break;
					case TC11:
						result += "TC11";
						result += "_v10_FHA02_203b_Refi";
						break;
					case TC12:
						result += "TC12";
						result += "_v10_VA01_30Yr_Fixed";
						break;
					case TC13:
						result += "TC13";
						result += "_v10_VA02_ARM";
						break;
					default:
						result = "-1";
						break;
					}
				break;
				case v34:
					result += "34/";
					result += "DU_34_";

					switch (vTestCase) {
					case TC01:
						result += "TC01";
						result += "_v11_Full_Fixed Primary Attchd_wr_20181204";
						break;
					case TC02:
						result += "TC02";
						result += "_v11_ARM_4-Unit_XML_Match_DI_C02_v5.1_20181204";
						break;
					case TC03:
						result += "TC03";
						result += "_v11_XML_Refi_CO_2nd_Home_wr_20181204";
						break;
					case TC04:
						result += "TC04";
						result += "_v11_XML_Refi Ltd CO Undrawn HELOC_wr_20181204";
						break;
					case TC05:
						result += "TC05";
						result += "_XML_Fixed Construction_wr_20181204";
						break;
					case TC06:
						result += "TC06";
						result += "_v11_XML_Constr-to-Perm_wr_20181204";
						break;
					case TC07:
						result += "TC07";
						result += "_v11_XML_Community 2nd_wr_20181204";
						break;
					case TC08:
						result += "TC08";
						result += "_v11_XML_Purchase Manufactured_wr_20181210";
						break;
					case TC09:
						result += "TC09";
						result += "_v11_XML_Homestyle Purchase_wr_20181212";
						break;
					case TC10:
						result += "TC10";
						result += "_v10_203b251_FHA_ARM_XML_Match_DI-FHA01_v3.1_20180815";
						break;
					case TC11:
						result += "TC11";
						result += "_v10_FHA_203b_Refi_XML_Match_DI-FHA02_v2.0_20180813";
						break;
					case TC12:
						result += "TC12";
						result += "_v10_VA 30_Yr_Fixed_XML_Match_DI-VA01_v3.0_20180810";
						break;
					case TC13:
						result += "TC13";
						result += "_v10_VA_ARM_XML_Match_DI-VA02_v2.0_20180814";
						break;
					case TC14:
						result += "TC14";
						result += "_v10_Purchase_ULAD_XML_20180829";
						break;
					case TC15:
						result += "TC15";
						result += "_v10_Refinance_ULAD_XML_20180830";
						break;
					default:
						result = "-1";
						break;
					}
				break;
				default:
					result = "-1";
					break;
				}
			break;
			case UCD:
				result += "UCD";

				switch (vMismoVersion) {
				case v33:
					result += "33/";
					result += "UCD_33_";

					switch (vTestCase) {
					case TC01:
						result += "TC01";
						result += "_v10_NonSeller_ARM_IO";
						break;
					case TC02:
						result += "TC02";
						result += "_v10_Purchase_Fixed";
						break;
					case TC03:
						result += "TC03";
						result += "_v10_Purchase_ARM";
						break;
					case TC04:
						result += "TC04";
						result += "_v10_NonSeller_Fixed";
						break;
					case TC05:
						result += "TC05";
						result += "_v10__NonSeller_ARM";
						break;
					default:
						result = "-1";
						break;
					}
				break;
				default:
					result = "-1";
					break;
				}
			break;
			case ULDD:
				result += "ULDD";

				switch (vMismoVersion) {
				case v30:
					result += "_30/";
					result += "ULDD_30_";

					switch (vTestCase) {
					case TC01:
						result += "TC01";
						result += "_v27";
						break;
					case TC02:
						result += "TC02";
						result += "_v26";
						break;
					case TC03:
						result += "TC03";
						result += "_v22";
						break;
					case TC04:
						result += "TC04";
						result += "_v25";
						break;
					case TC05:
						result += "TC05";
						result += "_v24";
						break;
					default:
						result = "-1";
						break;
					}
				default:
					result = "-1";
					break;
				}
			break;
			default:
				result = "-1";
				break;
			}
		}

		if (!result.equals("-1")) {
			result += ".xml";
		}

		return result;
	}

	public static String selectSchema(Product vProduct, MismoVersion vMismoVersion) {
		String result = "-1";

			result = "Resources/Schemas/";

			switch (vProduct) {
			case DU:
				result += "DU";
				
				switch (vMismoVersion) {
				case v231:
					result += "231/";
					result += "mismo231dtdextdata.dtd";
					break;
				case v34:
					result += "34/";
					result += "DU_ExtensionV3_4.xsd";
					break;
				default:
					result = "-1";
					break;
				}
				break;
			case UCD:
				result += "UCD";

				switch (vMismoVersion) {
				case v33:
					result += "33/";
					result += "UCD_3.3.0_B299.xsd";
					break;
				default:
					result = "-1";
					break;
				}
				break;
			case ULDD:
				result += "ULDD";

				switch (vMismoVersion) {
				case v30:
					result += "TC01";
					result += "MISMO_3_0.xsd";
					break;
				default:
					result = "-1";
					break;
				}
				break;
			default:
				result = "-1";
				break;
			}
		
//		if (!result.equals("-1")) {
//			result += ".xsd";
//		}

		return result;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public MismoVersion getMismoVersion() {
		return mismoVersion;
	}

	public void setMismoVersion(MismoVersion mismoVersion) {
		this.mismoVersion = mismoVersion;
	}

	public TestCase getTestCase() {
		return testCase;
	}

	public void setTestCase(TestCase testCase) {
		this.testCase = testCase;
	}
}
