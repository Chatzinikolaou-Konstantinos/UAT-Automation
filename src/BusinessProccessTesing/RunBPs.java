package BusinessProccessTesing;

import java.lang.reflect.Method;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import BusinessProccessTesing.Definitions.Definition;

public class RunBPs {

    RunBPs(Definition definition) throws Exception {

        //Check if the definition is implemented or not
        boolean DefinitionImplemented = false;
        for (Method Function : Definitions.class.getMethods()) {

            if(Function.getName().toLowerCase().equals(
                    definition.name().toLowerCase().replaceAll("_", ""))
            )
            DefinitionImplemented = true;
        }
        //Pop up to inform for the unimplemented method
        if(!DefinitionImplemented) {
            JOptionPane.showMessageDialog(
                null,
                "The Definition you chose for the Business Proccess, is still in the works.",
                "Unimplemented Definition", 
                JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        //Set driver and login to salesforce
        System.setProperty(CreateGenericBP.CHROME_DRIVER_LOCATION_FROM, CreateGenericBP.CHROME_DRIVER_LOCATION_TO);

        WebDriver       chrome_d    = new ChromeDriver();
        WebDriverWait   wait        = new WebDriverWait(chrome_d, CreateGenericBP.TIME_WAIT_PAGE);

        //Open chrome at specific URL
        chrome_d.get(CreateGenericBP.STARING_PAGE);

        //Login to UAT
        chrome_d.findElement(By.id("username")).sendKeys(CreateGenericBP.USERNAME);
        chrome_d.findElement(By.id("password")).sendKeys(CreateGenericBP.PASSWORD);
        chrome_d.findElement(By.id("Login")).click();
        
        CreateGenericBP.Run(chrome_d, wait, definition);
    }
    public static void main(String[] args) throws Exception {
        //Choose Definition to generate
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new DefinitionPickList();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
