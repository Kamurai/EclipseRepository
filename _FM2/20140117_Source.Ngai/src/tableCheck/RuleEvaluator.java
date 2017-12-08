package tableCheck;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * This class uses the original etmProcessor.js engine to validate cells against the rules. 
 * @author wai.ngai
 *
 */
public class RuleEvaluator 
{

	private ScriptEngineManager manager;
	private ScriptEngine engine;
	private static RuleEvaluator instance;

	public static RuleEvaluator getInstance()
	{
		if(instance==null)
		{
			instance = new RuleEvaluator();
		}
		return instance;
	}
	
	/**
	 * Only one instance will exist
	 */
	private RuleEvaluator()
	{
		this.manager = new ScriptEngineManager();
		this.engine = manager.getEngineByName("JavaScript");
		String script = this.generateJavaScript();
		this.evalScript(script);
		//this.
	}

	private String generateJavaScript()
	{
		StringBuilder script = new StringBuilder();
		script.append(this.preScript());
		script.append(this.noopScript());
		script.append(this.failScript());
		script.append(this.stringScript());
		script.append(this.numericScript());
		script.append(this.numericStringScript());
		script.append(this.promptScript());
		script.append(this.enumerationScript());
		script.append(this.boolScript());
		script.append(this.phoneScript());
		script.append(this.regexScript());
		script.append(this.blankScript());
		script.append(this.emptyScript());
		return script.toString();
	}

	public boolean evalCell(String cell, String rule)
	{
		String script = "currentCellValue=\""+cell+"\";";
		script += "result = eval("+rule+");";
		Boolean sucess = this.evalScript(script);
		if(sucess){
//			System.out.println(engine.get("result"));
//			System.out.println("Rule: "+rule);
//			System.out.println("Cell: "+cell);
			Boolean result = false;
			try{
				result  = (Boolean) engine.get("result");
			}catch(ClassCastException e){
				Double resultDouble= (Double)engine.get("result");
				//System.out.println(cell);
				int resultInt = resultDouble.intValue();
				if(resultInt == 1){
					
					result = true;
				}else{
					
					result = false;
				}
			}
			return result;
		}
		return false;
	}

	public boolean validExpression(String expression)
	{
		String script = "result = eval("+expression+");";
		return this.evalScript(script);
	}

	private boolean evalScript(String script)
	{
		try 
		{
			this.engine.eval(script);
		} 
		catch (ScriptException e) 
		{
			e.printStackTrace();
			return false;
		}

		return true;
	}



	private String preScript()
	{
		StringBuilder script = new StringBuilder();
		script.append(this.appendNewLine("var currentCellValue = \"\""));
		script.append(this.appendNewLine("var currentCellErrors = new Array();"));
		return script.toString();
	}

	/**
	 * 
	 * @return Script for noop(), which will always return true
	 */
	private String noopScript()
	{
		StringBuilder script = new StringBuilder();
		script.append(this.appendNewLine("function noop()"));
		script.append(this.appendNewLine("{"));
		script.append(this.appendNewLine("return true;"));
		script.append(this.appendNewLine("}"));
		return script.toString();
	}

	/**
	 * 
	 * @return Script fail(), which will always return true
	 */
	private String failScript()
	{
		StringBuilder script = new StringBuilder();
		script.append(this.appendNewLine("function fail()"));
		script.append(this.appendNewLine("{"));
		script.append(this.appendNewLine(this.pushToCurrentCellErrorsScript("Cell forced failure")));
		script.append(this.appendNewLine("return false;"));
		script.append(this.appendNewLine("}"));
		return script.toString();
	}

	/**
	 * 
	 * @return Script string(), string(lens) -> validate that cell length is one of passed arguments
	 */
	private String stringScript()
	{
		StringBuilder script = new StringBuilder();
		script.append(this.appendNewLine("function string()"));
		script.append(this.appendNewLine("{"));
		script.append(this.appendNewLine("var len = currentCellValue.length;"));
		script.append(this.appendNewLine("for (var i = 0; i < string.arguments.length; i++)"));
		script.append(this.appendNewLine("{"));
		script.append(this.appendNewLine("if (string.arguments[i] == len)"));
		script.append(this.appendNewLine("{"));
		script.append(this.appendNewLine("return true;"));
		script.append(this.appendNewLine("}"));
		script.append(this.appendNewLine("}"));
		script.append(this.appendNewLine(this.pushToCurrentCellErrorsScript("Cell has invalid length")));
		script.append(this.appendNewLine("return false;"));
		script.append(this.appendNewLine("}"));
		return script.toString();
	}

	/**
	 * 
	 * @return Script numeric(), numeric() -> validate that cell is numeric
	 */
	private String numericScript()
	{
		StringBuilder script = new StringBuilder();
		script.append(this.appendNewLine("function numeric()"));
		script.append(this.appendNewLine("{"));
		script.append(this.appendNewLine("var pass = /^\\d+$/.test(currentCellValue);"));
		script.append(this.appendNewLine("if (!pass)"));
		script.append(this.appendNewLine("{"));
		script.append(this.appendNewLine(this.pushToCurrentCellErrorsScript("Cell must be numeric.")));
		script.append(this.appendNewLine("}"));
		script.append(this.appendNewLine("return pass;"));
		script.append(this.appendNewLine("}"));
		return script.toString();
	}

	/**
	 * 
	 * @return Script numericString(len), numericString(len) -> validate that cell is numeric and length is one of passed arguments
	 */
	private String numericStringScript()
	{
		String firstIfCondition = "numeric() == false";
		String firstIfCode = "return false;";
		String firstIfBlock = this.ifBlock(firstIfCondition, firstIfCode);
		String secondIfCondition = "numericString.arguments[i] == len";
		String secondIfCode = "return true;";
		String secondIfBlock = this.ifBlock(secondIfCondition, secondIfCode);
		String firstForBlockCondition = "var i = 0; i < numericString.arguments.length; i++";
		String firstForBlockCode = secondIfBlock;
		String firstForBlock = this.forBlock(firstForBlockCondition, firstForBlockCode);
		String firstElseBlockCode = "var len = currentCellValue.length;"+firstForBlock+this.pushToCurrentCellErrorsScript("Cell has invalid length")+"return false";
		String firstElseBlock = this.elseBlock(firstElseBlockCode);
		String funcitonBlock = this.functionBlock("numericString()", firstIfBlock+firstElseBlock);
		return funcitonBlock;
	}

	/**
	 * 
	 * @return Script prompt(), prompt() -> validate that it's a prompt string of at most 257 characters
	 */
	private String promptScript()
	{
		String functionHeader = "prompt()";
		String functionLine1 = "var pass = /^(P\\d+|M\\d{1,6}|{[\\w\\s.@=\\\"-,]+})+$/i.test(currentCellValue);";
		String firstIfCondition = "!pass";
		String firstIfCode = this.pushToCurrentCellErrorsScript("Cell must contain prompt string.");
		String firstIfBlock = this.ifBlock(firstIfCondition, firstIfCode);
		String functionLine2 = this.appendNewLine("return pass");
		String functionCode = functionLine1+firstIfBlock+functionLine2;
		String functionBlock = this.functionBlock(functionHeader, functionCode);
		return functionBlock;
	}

	/**
	 * 
	 * @return Script enumeration(vals), enumeration(vals) -> validate that it's one of the list of values
	 */
	private String enumerationScript()
	{
		String functionHeader = "enumeration()";
		String functionLine1 = this.pushToCurrentCellErrorsScript("Cell contains invalid value.");
		String firstIfCondition = "new String(enumeration.arguments[i]).toUpperCase() == new String(currentCellValue).toUpperCase()";
		String firstIfCode = this.appendNewLine("return true;");
		String firstIfBlock = this.ifBlock(firstIfCondition, firstIfCode);
		String firstForBlockCondition = "var i = 0; i < enumeration.arguments.length; i++";
		String firstForBlockCode = firstIfBlock;
		String firstForBlock = this.forBlock(firstForBlockCondition, firstForBlockCode);
		String functionLine2 = "return false";
		String functionCode = firstForBlock+functionLine1+functionLine2;
		String functionBlock = this.functionBlock(functionHeader, functionCode);
		return functionBlock;
	}

	/**
	 * 
	 * @return Script bool(), bool() -> enumaration("yes", "no", "true", "false", 1, 0)
	 */
	private String boolScript()
	{
		String functionHeader = "bool()";
		String functionCode = this.appendNewLine("return enumeration(\"yes\", \"no\", \"true\", \"false\", 1, 0)");
		String functionBlock = this.functionBlock(functionHeader, functionCode);
		return functionBlock;
	}

	/**
	 * 
	 * @return Script phone(len), phone(len) -> digit string with length one of passed values (or 0-23 if not provided)
	 */
	private String phoneScript()
	{
		String functionHeader = "phone()";
		String firstIfCondition = "numeric() == false";
		String firstIfCode = "return false";
		String firstIfBlock = this.ifBlock(firstIfCondition, firstIfCode);
		String fourthIfCondition = "phone.arguments[i] == len";
		String fourthIfCode = this.appendNewLine("return true;");
		String fourthIfblock = this.ifBlock(fourthIfCondition, fourthIfCode);
		String firstForCondition = "var i = 0; i < phone.arguments.length; i++";
		String firstForCode = this.appendNewLine(fourthIfblock);
		String firstForBlock = this.forBlock(firstForCondition, firstForCode);
		String thirdIfCodition = "phone.arguments.length > 0";
		String thirdIfCode = firstForBlock;
		String thirdIfBlock = this.ifBlock(thirdIfCodition, thirdIfCode);
		String thirdElseBlock = this.elseBlock(this.appendNewLine("return true"));
		String secondIfCondition = "len < 23";
		String secondIfCode = thirdIfBlock+thirdElseBlock;
		String secondIfBlock = this.ifBlock(secondIfCondition, secondIfCode);
		String firstElseLine1 = this.appendNewLine("var len = currentCellValue.length;");
		String firstElseLine2 = this.appendNewLine(secondIfBlock);
		String firstElseLine3 = this.pushToCurrentCellErrorsScript("Cell has invalid length");
		String firstElseLine4 = this.appendNewLine("return false");
		String firstElseCode = firstElseLine1+firstElseLine2+firstElseLine3+firstElseLine4;
		String firstElseBlock = this.elseBlock(firstElseCode);
		String functionCode = firstIfBlock+firstElseBlock;
		String functionBlock = this.functionBlock(functionHeader, functionCode);
		return functionBlock;
	}

	/**
	 * 
	 * @return Script regex(expr), regex(expr) -> check that cell passes all regex tests on value
	 */
	private String regexScript()
	{
		String functionHeader = "regex()";
		String functionLine1 = this.appendNewLine("var pass = true;");
		String firstForCondition = "var i = 0; i < regex.arguments.length && pass; i++";
		String firstForCode = "pass &= regex.arguments[i].test(currentCellValue);";
		String firstForBlock = this.forBlock(firstForCondition, firstForCode);
		String firstIfCondition = "!pass";
		String firstIfCode = this.pushToCurrentCellErrorsScript("Cell has invalid value");
		String firstIfBlock = this.ifBlock(firstIfCondition, firstIfCode);
		String functionLine2 = this.appendNewLine("return pass");
		String functionCode = functionLine1+firstForBlock+firstIfBlock+functionLine2;
		String functionBlock = this.functionBlock(functionHeader, functionCode);
		return functionBlock;
	}

	/**
	 * 
	 * @return Script blank(), regex(expr) -> blank() -> check that cell is blank
	 */
	private String blankScript()
	{
		String functionHeader = "blank()";
		String functionLine1 = this.appendNewLine("var pass = /^\\s*$/.test(currentCellValue);");
		String firstIfCondition = "!pass";
		String firstIfCode = this.pushToCurrentCellErrorsScript("Cell must be blank.");
		String firstIfBlock = this.ifBlock(firstIfCondition, firstIfCode);
		String functionLine2 = this.appendNewLine("return pass");
		String functionCode = functionLine1+firstIfBlock+functionLine2;
		String functionBlock = this.functionBlock(functionHeader, functionCode);
		return functionBlock;
	}

	/**
	 * 
	 * @return Script empty(), empty() -> check if the cell is empty 
	 */
	private String emptyScript()
	{
		String functionHeader = "empty()";
		String functionLine1 = this.appendNewLine("var pass = (currentCellValue == \"\");");
		String firstIfCondition = "!pass";
		String firstIfCode = this.pushToCurrentCellErrorsScript("Cell must be empty.");
		String firstIfBlock = this.ifBlock(firstIfCondition, firstIfCode);
		String functionLine2 = this.appendNewLine("return pass");
		String functionCode = functionLine1+firstIfBlock+functionLine2;
		String functionBlock = this.functionBlock(functionHeader, functionCode);
		return functionBlock;
	}

	private String functionBlock(String functionHeader, String code)
	{
		StringBuilder function = new StringBuilder();
		function.append("function ");
		function.append(this.appendNewLine(functionHeader));
		function.append(this.appendNewLine("{"));
		function.append(code);
		function.append(this.appendNewLine("}"));
		function.append("\n");
		return function.toString();
	}

	private String elseBlock(String code){
		StringBuilder function = new StringBuilder();
		function.append("else");
		function.append(this.appendNewLine("{"));
		function.append(code);
		function.append(this.appendNewLine("}"));
		return function.toString();
	}
	/*
	private String elseIfBlock(String condition, String code){
		StringBuilder function = new StringBuilder();
		function.append("else if");
		function.append("(");
		function.append(condition);
		function.append(this.appendNewLine(")"));
		function.append(this.appendNewLine("{"));
		function.append(code);
		function.append(this.appendNewLine("}"));
		return function.toString();
	}
	 */
	private String ifBlock(String condition, String code){
		StringBuilder function = new StringBuilder();
		function.append("if");
		function.append("(");
		function.append(condition);
		function.append(this.appendNewLine(")"));
		function.append(this.appendNewLine("{"));
		function.append(code);
		function.append(this.appendNewLine("}"));
		return function.toString();
	}

	private String forBlock(String condition, String code){
		StringBuilder function = new StringBuilder();
		function.append("for");
		function.append("(");
		function.append(condition);
		function.append(this.appendNewLine(")"));
		function.append(this.appendNewLine("{"));
		function.append(code);
		function.append(this.appendNewLine("}"));
		return function.toString();
	}
	private String appendNewLine(String script){
		return script + "\n";
	}

	private String pushToCurrentCellErrorsScript(String errorToPush){
		return "currentCellErrors.push(\""+errorToPush+"\");";
	}
}
