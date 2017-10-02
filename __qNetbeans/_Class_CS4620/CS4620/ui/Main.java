package ui;

/**
 *
 * @author Chris Kemerait
 */
import javax.swing.JFrame;
import logic.StudentInfoManager;




public class Main
{

	public static void main(String[] args)
	{
		StudentInfoManager manager = new StudentInfoManager();
		JFrame startUpWin = new MainWindow (manager);
		startUpWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
