package read;

import java.io.File;
import java.util.ArrayList;

import javax.xml.soap.Node;

import org.w3c.dom.Document;
import org.w3c.dom.NameList;
import org.w3c.dom.NodeList;

import common.Read;

public abstract class FileReader implements Read {

	public Document readFile(File subject) {
		return null;
	}
}
