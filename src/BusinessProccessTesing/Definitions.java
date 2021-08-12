package BusinessProccessTesing;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Definitions {

    /**
     * Enum names must keep the same pattern to identify them by their functions
     */
    public enum Definition {
        NEW_PARTNER_NO_ASSISTED,
        NEW_PARTNER_RENOVATION
    }

    /**
     * 
     * Definition functions should have the same name as the enum types
     * in order to identify if an enum type is being implemented.
     * 
     */

    public static void NewPartnerRenovation(WebDriver driver, WebDriverWait wait) throws InterruptedException {

        String YpeuthinosEpeksergasias_XP   = "/html/body/div[4]/div[2]/div/div[2]/div/div[2]/article/div/div[2]/div/div/div[1]/flowruntime-picklist-input-lwc/div/lightning-select/div/div/select";
        String TyposAitimatos_XP            = "/html/body/div[4]/div[2]/div/div[2]/div/div[2]/article/div/div[2]/div/div/div[3]/flowruntime-picklist-input-lwc/div/lightning-select/div/div/select";
        String SistasiEterias_XP            = "/html/body/div[4]/div[2]/div/div[2]/div/div[2]/article/div/div[2]/div/div/div[3]/flowruntime-picklist-input-lwc/div/lightning-select/div/div/select/option[20]";  
        String StatusRadio_XP               = "/html/body/div[4]/div[2]/div/div[2]/div/div[2]/article/div/div[2]/div/div/div[17]/flowruntime-radio-button-input-lwc/fieldset/div/span[1]/label/span[1]";
        String SaveRequestReview_XP         = "/html/body/div[4]/div[2]/div/div[2]/div/div[3]/footer/div[2]/button";
        String Related_XP                   = "/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div/div/one-record-home-flexipage2/forcegenerated-adg-rollup_component___force-generated__flexipage_-record-page___-b-p_-pending_-task___-f-s-t-r__-business_-process__c___-v-i-e-w/forcegenerated-flexipage_bp_pending_task_fstr__business_process__c__view_js/record_flexipage-record-page-decorator/div[1]/records-record-layout-event-broker/slot/slot/flexipage-record-home-template-desktop2/div/div[2]/div[1]/slot/slot/flexipage-component2/slot/flexipage-tabset2/div/lightning-tabset/div/lightning-tab-bar/ul/li[1]/a";
        String Child_XP                     = "/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div/div/one-record-home-flexipage2/forcegenerated-adg-rollup_component___force-generated__flexipage_-record-page___-b-p_-pending_-task___-f-s-t-r__-business_-process__c___-v-i-e-w/forcegenerated-flexipage_bp_pending_task_fstr__business_process__c__view_js/record_flexipage-record-page-decorator/div[1]/records-record-layout-event-broker/slot/slot/flexipage-record-home-template-desktop2/div/div[2]/div[1]/slot/slot/flexipage-component2/slot/flexipage-tabset2/div/lightning-tabset/div/slot/slot/slot/flexipage-tab2[1]/slot/flexipage-component2/slot/lst-related-list-container/div/div[3]/lst-related-list-single-container/laf-progressive-container/slot/lst-related-list-single-app-builder-mapper/article/lst-related-list-view-manager/lst-common-list/div/div/lst-primary-display-manager/div/lst-primary-display/lst-primary-display-grid/lst-customized-datatable/div[2]/div/div/table/tbody/tr/th/lightning-primitive-cell-factory/span/div/lightning-primitive-custom-cell/force-lookup/div/force-hoverable-link/div/a/span";

        //To keep checking if the child proccess has been created
        boolean ChildCreated = false;

        //Select an Ypeuthinos Epeksergasias
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(YpeuthinosEpeksergasias_XP)));
        WebElement Ypeuthinos_Epeksergasias = driver.findElement(By.xpath(YpeuthinosEpeksergasias_XP));
        ((JavascriptExecutor) driver)
            .executeScript("arguments[0].click();", driver.findElement(By.xpath(YpeuthinosEpeksergasias_XP)));
        Ypeuthinos_Epeksergasias.sendKeys(Keys.ARROW_UP);
        ((JavascriptExecutor) driver)
            .executeScript("arguments[0].click();", driver.findElement(By.xpath(YpeuthinosEpeksergasias_XP)));

        //Select Sistasi Eterias as Typos Aitimatos
        driver.findElement(By.xpath(TyposAitimatos_XP)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SistasiEterias_XP)));
        driver.findElement(By.xpath(SistasiEterias_XP)).click();

        //Select Accepted as status
        ((JavascriptExecutor) driver)
            .executeScript("window.scrollTo(0, document.body.scrollHeight)");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(StatusRadio_XP)));
        ((JavascriptExecutor) driver)
            .executeScript("arguments[0].click();", driver.findElement(By.xpath(StatusRadio_XP)));

        //Save
        driver.findElement(By.xpath(SaveRequestReview_XP)).click();

        //Go to previews page
        driver.navigate().back();     
        while(!ChildCreated) {
            //Open related link to find child proccess
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Related_XP)));
            ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", driver.findElement(By.xpath(Related_XP)));

            Thread.sleep(CreateGenericBP.TIME_WAIT_CHILD_PROCCESS);

            try {
                //Open the child proccess
                ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", driver.findElement(By.xpath(Child_XP)));
                ChildCreated = true;
            } catch (Exception e) {
                driver.navigate().refresh();
            }
        }
    }

    public static void NewPartnerNoAssisted(WebDriver driver, WebDriverWait wait) throws InterruptedException {
        //The new partner renovaion is a subtotal of this one
        NewPartnerRenovation(driver, wait);

        String AssistedConstructionLink_XP      = "/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div/div/one-record-home-flexipage2/forcegenerated-adg-rollup_component___force-generated__flexipage_-record-page___-n-e-w_-p-a-r-t-n-e-r_-n-e-w_-s-i-t-e_-e-x-p-a-n-s-i-o-n___-f-s-t-r__-business_-process__c___-v-i-e-w/forcegenerated-flexipage_new_partner_new_site_expansion_fstr__business_process__c__view_js/record_flexipage-record-page-decorator/div[1]/records-record-layout-event-broker/slot/slot/flexipage-record-home-template-desktop2/div/div[2]/div[2]/slot/slot/flexipage-component2/slot/flexipage-aura-wrapper/div/div/div/div[1]/div[4]/div/ul/li/div/div/div[2]/div[2]/div[1]/div[1]/div/div[2]/div/div[1]/a";
        String EditAssistedConstruction_XP      = "//*[@id='brandBand_2']/div/div/div/div/div[1]/div/div[1]/div/header/div[2]/div/div[2]/ul/li[1]/a";
        String TyposErgon_XP                    = "/html/body/div[4]/div[2]/div/div[2]/div/div[2]/article/div/div[2]/div/div/div[2]/flowruntime-picklist-input-lwc/div/lightning-select/div/div/select";
        String AssistedConstructionStatus_XP    = "/html/body/div[4]/div[2]/div/div[2]/div/div[2]/article/div/div[2]/div/div/div[3]/flowruntime-picklist-input-lwc/div/lightning-select/div/div/select";
        String SaveAssistedConstruction_XP      = "/html/body/div[4]/div[2]/div/div[2]/div/div[3]/footer/div[2]/button";
        String FinishFlow_XP                    = "/html/body/div[4]/div[2]/div/div[2]/div/div[1]/button";
        String ChildBpLink_XP                   = "/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr/th/span/a";

        //To keep checking if the child proccess has been created
        boolean ChildCreated = false;

        //Open task page to edit from there
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(AssistedConstructionLink_XP)));
        ((JavascriptExecutor) driver)
            .executeScript("arguments[0].click();", driver.findElement(By.xpath(AssistedConstructionLink_XP)));

        //Edit task
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EditAssistedConstruction_XP)));
        ((JavascriptExecutor) driver)
            .executeScript("arguments[0].click();", driver.findElement(By.xpath(EditAssistedConstruction_XP)));

        //Click Typos Ergon to reveal list and enter NONE option
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TyposErgon_XP)));
        WebElement Typos_Ergon = driver.findElement(By.xpath(TyposErgon_XP));
        ((JavascriptExecutor) driver)
            .executeScript("arguments[0].click();", driver.findElement(By.xpath(TyposErgon_XP)));
        Typos_Ergon.sendKeys(Keys.ARROW_DOWN);
        Typos_Ergon.sendKeys(Keys.ARROW_DOWN);
        Typos_Ergon.sendKeys(Keys.ENTER);

        //Select COMPLETED as Assisted Construction Status
        WebElement Assisted_Construction_Status = driver.findElement(By.xpath(AssistedConstructionStatus_XP));
        ((JavascriptExecutor) driver)
            .executeScript("arguments[0].click();", driver.findElement(By.xpath(AssistedConstructionStatus_XP)));
        Assisted_Construction_Status.sendKeys(Keys.ARROW_DOWN);
        Assisted_Construction_Status.sendKeys(Keys.ENTER);

        //Save
        ((JavascriptExecutor) driver)
            .executeScript("arguments[0].click();", driver.findElement(By.xpath(SaveAssistedConstruction_XP)));

        //Close Flow Finished window
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FinishFlow_XP)));
        ((JavascriptExecutor) driver)
            .executeScript("arguments[0].click();", driver.findElement(By.xpath(FinishFlow_XP)));

        //Go to previews page
        driver.navigate().back();

        //get id to go to child businesses page
        String[] URL        = driver.getCurrentUrl().split("/");
        String ID           = URL[CreateGenericBP.URL_OBJECT_POSITION];
        String ChildBpURL   = "https://opap--uat.lightning.force.com/lightning/r/" +  ID + "/related/FSTR__Business_Processes__r/view";
        driver.get(ChildBpURL);

        while(!ChildCreated) {
            try {
                Thread.sleep(CreateGenericBP.TIME_WAIT_CHILD_PROCCESS);

                //Open the child proccess
                ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", driver.findElement(By.xpath(ChildBpLink_XP)));
                ChildCreated = true;
            } catch (Exception e) {
                driver.navigate().refresh();
            }
        }
    }
}