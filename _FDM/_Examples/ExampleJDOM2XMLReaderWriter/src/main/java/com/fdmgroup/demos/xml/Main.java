package com.fdmgroup.demos.xml;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;


public class Main {

	
	List<Student> students = new ArrayList<Student>();

	XMLOutputter printer =  new XMLOutputter();
	Element rootElement = new Element("students");
	Document doc = new Document(rootElement);

	
	// Populates ArrayList with randomly generated information
	void populateListRandomly(){
		
		Random r = new Random();
		String name,major;
		Student s;
		
		for(int i = 0; i<10 ; i++){
			
			name = (char)(r.nextInt(26)+'a')+"";
			major = (char)(r.nextInt(26)+'a')+"";
			
			s = new Student( 
					name.toUpperCase()+name+name+name+name, 
					Math.abs(r.nextInt()%42), 
					major.toUpperCase() );
			
			students.add(s);
		}		
	}
	
	// Populates ArrayList with interactive input from the user
	void populateListInteractively(){
		
		Scanner scanner = new Scanner(System.in);
		
		String name,major;
		int age;
		Student s;
		
		String decision = "y";
		
		while(decision.equals("y")){
			
			System.out.println("\n[New Student]");
			
			System.out.print("Name: ");
			name = scanner.next();
			
			System.out.print("Age: ");		
			age = scanner.nextInt();
			
			System.out.print("Major: ");
			major = scanner.next();
	
			s = new Student(name,age,major);
			students.add(s);
			
			System.out.print("Another? (y/n)");
			decision = scanner.next();			
		}
		
		
		System.out.println();
	}
	
	// Prints ArrayList of Students
	void displayStudents(){

		for( Student s : students)
			System.out.println(s.name+" "+s.age+" "+s.major);
		
	}

	
	
	// Builds the Document object from ArrayList of Students
	void populateDocFromList(){
	
		Element student;
		
		for( Student s : students){
		
			student = new Element("student");
			
			student.addContent(new Element("name").addContent(s.name));
			student.addContent(new Element("age").addContent(s.age+""));
			student.addContent(new Element("major").addContent(s.major));

			rootElement.addContent(student);	

		}
	}
	
	// Builds ArrayList from Document object
	void populateListFromDoc(){
		
		Student s;
		
		for( Object elem : doc.getRootElement().getChildren() ){
			Element StudentElement = (Element) elem;
			s = new Student(StudentElement.getChildText("name"),
					Integer.parseInt(StudentElement.getChildText("age")),
					StudentElement.getChildText("major"));
					
			students.add(s);
		}
	}
	

	
	// Writes Document object into specified XML file
	void writeDocToFile(String filename){
		
		try{
			FileWriter writer = new FileWriter(filename);
			Format f = Format.getPrettyFormat();
			printer.setFormat(f);
			printer.output(doc, writer);
			writer.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}

	}
	
	// Creates Document object from specified XML file
	void populateDocFromFile(String filename){

		try {
			  SAXBuilder builder = new SAXBuilder();
			  doc = builder.build(new File(filename));
			  
		} catch(JDOMException e) {
			  e.printStackTrace();
		} catch(NullPointerException e) {
			  e.printStackTrace();
		} catch (IOException e) {
			  e.printStackTrace();
		}

	}
	

	
	
	
	public static void main(String[] args) {

		Main m = new Main();
		
		/* ----- WRITING -----
		 * 
		 * Makes Students, 
		 * puts them into a list, 
		 * writes the list as an XML file 
		 * 
		 */
		
		m.populateListRandomly();
		//m.populateListInteractively();
		m.displayStudents();
		
		m.populateDocFromList();
		m.writeDocToFile("students.xml");
		
		/* ----- READING ----- 
		 * 
		 * Reads XML file into Document object, 
		 * makes Student ArrayList from Document object, 
		 * prints ArrayList of Students
		 * 
		 */
		
//		 m.populateDocFromFile("students.xml");
//		 m.populateListFromDoc();
//		 m.displayStudents();

	}
	
	
	

}
