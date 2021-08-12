package BusinessProccessTesing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BusinessProccessTesing.Definitions.Definition;

import org.openqa.selenium.JavascriptExecutor;

public class CreateGenericBP {

    public static String CHROME_DRIVER_LOCATION_FROM    = "webdriver.chrome.driver";
    public static String CHROME_DRIVER_LOCATION_TO      = "lib\\chromedriver92.exe";
    public static String STARING_PAGE                   = "https://opap--uat.lightning.force.com/lightning/o/FSTR__Business_Process__c/list?filterName=Recent";
    public static String USERNAME                       = "sfdcadmin@opap.gr.uat";
    public static String PASSWORD                       = "passworD1@7";
    public static int    URL_OBJECT_POSITION            = 6;        //The position of the object inside the URL
    public static int    TIME_WAIT_PAGE                 = 120;      //seconds
    public static int    TIME_WAIT_CHILD_PROCCESS       = 5000;     //milliseconds

    public static void OpenToEditRequestReview(WebDriver driver, WebDriverWait wait) {
        
        String RequestReviewLink_XP = "/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div[1]/div/one-record-home-flexipage2/forcegenerated-adg-rollup_component___force-generated__flexipage_-record-page___-b-p_-pending_-task___-f-s-t-r__-business_-process__c___-v-i-e-w/forcegenerated-flexipage_bp_pending_task_fstr__business_process__c__view_js/record_flexipage-record-page-decorator/div[1]/records-record-layout-event-broker/slot/slot/flexipage-record-home-template-desktop2/div/div[2]/div[2]/slot/slot/flexipage-component2[2]/slot/flexipage-tabset2/div/lightning-tabset/div/slot/slot/slot/flexipage-tab2/slot/flexipage-component2/slot/flexipage-aura-wrapper/div/div/div/div[1]/div[4]/div/ul/li/div/div/div[2]/div[2]/div[1]/div[1]/div/div[2]/div/div[1]/a";
        String EditButton_XP        = "/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div[2]/div/div[1]/div/div[1]/div/header/div[2]/div/div[2]/ul/li[1]/a/div";

        //Open task page
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RequestReviewLink_XP)));
        ((JavascriptExecutor) driver)
            .executeScript("arguments[0].click();", driver.findElement(By.xpath(RequestReviewLink_XP)));
        
        //Edit the task
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EditButton_XP)));
        ((JavascriptExecutor) driver)
            .executeScript("arguments[0].click();", driver.findElement(By.xpath(EditButton_XP)));
    }

    public static void Run(WebDriver driver, WebDriverWait wait, Definition definition) throws Exception {

        /**
         * Follow steps to create a generic busines process test
         */

        //XPaths
        String NewButton_XP                        = "//*[@id='brandBand_1']/div/div/div/div/div[1]/div[1]/div[2]/ul/li[1]/a";
        String GenericBPRadio_XP                   = "/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div[1]/div/div/div[1]/fieldset/div[1]/div[17]/label/div[2]/span";
        String NewBusinessProccessNextButton_XP    = "/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div[2]/div/button[2]";
        String SubjectInputText_XP                 = "/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div[1]/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div/div/div/records-lwc-record-layout/forcegenerated-detailpanel_fstr__business_process__c___0123n00000255joqaq___full___create___recordlayout2/force-record-layout-block/slot/force-record-layout-section[1]/div/div/div/slot/force-record-layout-row[3]/slot/force-record-layout-item/div/span/slot/slot/force-record-layout-base-input/lightning-input/div/input";
        String SegmentInputText_XP                 = "/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div[1]/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div/div/div/records-lwc-record-layout/forcegenerated-detailpanel_fstr__business_process__c___0123n00000255joqaq___full___create___recordlayout2/force-record-layout-block/slot/force-record-layout-section[2]/div/div/div/slot/force-record-layout-row/slot/force-record-layout-item[1]/div/span/slot/slot/force-record-layout-lookup/lightning-lookup/lightning-lookup-desktop/lightning-grouped-combobox/div/div/lightning-base-combobox/div/div[1]/input";
        String SegmentAM3_XP                       = "/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div[1]/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div/div/div/records-lwc-record-layout/forcegenerated-detailpanel_fstr__business_process__c___0123n00000255joqaq___full___create___recordlayout2/force-record-layout-block/slot/force-record-layout-section[2]/div/div/div/slot/force-record-layout-row/slot/force-record-layout-item[1]/div/span/slot/slot/force-record-layout-lookup/lightning-lookup/lightning-lookup-desktop/lightning-grouped-combobox/div[1]/div/lightning-base-combobox/div/div[2]/ul/li[1]";
        String SaveButton_XP                       = "/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div[1]/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div/div/force-form-footer/div/div/div/runtime_platform_actions-actions-ribbon/ul/li[3]/runtime_platform_actions-action-renderer/runtime_platform_actions-executor-lwc-headless/slot[1]/slot/lightning-button/button";

        //Click the "New" button to start the creation of the new business proccess
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(NewButton_XP)));
        driver.findElement(By.xpath(NewButton_XP)).click();

        //Choose the genericBP option and proceed to the next step
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(GenericBPRadio_XP)));
        driver.findElement(By.xpath(GenericBPRadio_XP)).click();

        //Move to next step
        driver.findElement(By.xpath(NewBusinessProccessNextButton_XP)).click();

        //Create an automated subject name
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SubjectInputText_XP)));
        driver.findElement(By.xpath(SubjectInputText_XP)).sendKeys("Automated BP Creation : " + definition);

        //Enter Segment AM3 (Nikolaos Karkoulas) for testing
        driver.findElement(By.xpath(SegmentInputText_XP)).sendKeys("AM3");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SegmentAM3_XP)));
        driver.findElement(By.xpath(SegmentAM3_XP)).click();

        //Save the new Business Process
        driver.findElement(By.xpath(SaveButton_XP)).click();

        //Open the page of the main task to edit
        OpenToEditRequestReview(driver, wait);
        
        /**
         * New Business Process Created.
         * Subject : Automated Business Process
         * Segment : AM3
         * 
         * The programm will proceed to create child bp's to match the needed Definitions
         */

        switch (definition) {
            case NEW_PARTNER_NO_ASSISTED:
                Definitions.NewPartnerNoAssisted(driver, wait);
                break;

            case NEW_PARTNER_RENOVATION:
                Definitions.NewPartnerRenovation(driver, wait);
                break;
        
            default:
                break;
        }
    }
}