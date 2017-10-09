package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import testBase.FuncBase;

public class BarbourHomePopup extends FuncBase {

     private static WebElement ele = null;

     private static String BarbourLogo_xp = "html/body/main/div[5]/div[3]/div/div/div[1]/div/div/figure/a/img";
     private static String CloseBtn_xp="html/body/main/div[4]/div[3]/div/div/div[1]/button";
     private static String Msg1_xp = "html/body/main/div[5]/div[3]/div/div/div[2]/p";
     private static String Msg2_xp = "html/body/main/div[5]/div[3]/div/div/div[2]/div[1]/form/h4";
     private static String MensRadioBtn_id="newsletterOptions1";
     private static String MensLabel_xp = "html/body/main/div[5]/div[3]/div/div/div[2]/div[1]/form/div[1]/div[1]/label";
     private static String WomensRadioBtn_id="newsletterOptions2";
     private static String WomensLabel_xp = "html/body/main/div[5]/div[3]/div/div/div[2]/div[1]/form/div[1]/div[2]/label";
     private static String BothRadioBtn_id="newsletterOptions3";
     private static String BothLabel_xp = "html/body/main/div[5]/div[3]/div/div/div[2]/div[1]/form/div[1]/div[3]/label";
     private static String EmailTextBox_id="newsletter-email";
     private static String SubscribeBtn_xp="html/body/main/div[4]/div[3]/div/div/div[2]/div[1]/form/div[2]/div/div/span/input";
     private static String TermsChkbox_xp="html/body/main/div[5]/div[3]/div/div/div[2]/div[2]/div/div/label/input";
     private static String PolicyLink_xp="html/body/main/div/div[3]/div/div/div[2]/div[2]/div/a";
     private static String CoockiesCloseIcon_xp="html/body/div[1]/p/a[3]";
     private static String Msg3_xp = "html/body/main/div[5]/div[3]/div/div/div[2]/div[2]/div/div/label";
     private static String PrivacyPolicyLink_xp = "html/body/main/div[5]/div[3]/div/div/div[2]/div[2]/div/a";
     private static String CloseBtnAfterSubscription_xp="html/body/main/div[4]/div[3]/div/div/div[1]/button";
     private static String SubscriptionText1_xp="html/body/main/div[5]/div[3]/div/div/div[2]/p";
     private static String SubscriptionText2_xp="html/body/main/div[5]/div[3]/div/div/div[2]/div[1]/div/div/p";
     
     
/*ElementDeclarationEndsHere*/

     public static WebElement BarbourLogo (WebDriver dr) throws InterruptedException{
         ele = Locate(BarbourLogo_xp ,"xp" );
     return ele;
     }
     public static WebElement CloseBtn (WebDriver dr) throws InterruptedException{
         ele = Locate(CloseBtn_xp ,"xp" );
     return ele;
     }
     public static WebElement Msg1 (WebDriver dr) throws InterruptedException{
         ele = Locate(Msg1_xp ,"xp" );
     return ele;
     }
     public static WebElement Msg2 (WebDriver dr) throws InterruptedException{
         ele = Locate(Msg2_xp ,"xp" );
     return ele;
     }
     public static WebElement MensRadioBtn (WebDriver dr) throws InterruptedException{
         ele = Locate(MensRadioBtn_id ,"id" );
     return ele;
     }
     public static WebElement MensLabel (WebDriver dr) throws InterruptedException{
         ele = Locate(MensLabel_xp ,"xp" );
     return ele;
     }
     public static WebElement WomensRadioBtn (WebDriver dr) throws InterruptedException{
         ele = Locate(WomensRadioBtn_id ,"id" );
     return ele;
     }
     public static WebElement WomensLabel (WebDriver dr) throws InterruptedException{
         ele = Locate(WomensLabel_xp ,"xp" );
     return ele;
     }
     public static WebElement BothRadioBtn (WebDriver dr) throws InterruptedException{
         ele = Locate(BothRadioBtn_id ,"id" );
     return ele;
     }
     public static WebElement BothLabel (WebDriver dr) throws InterruptedException{
         ele = Locate(BothLabel_xp ,"xp" );
     return ele;
     }
     public static WebElement EmailTextBox (WebDriver dr) throws InterruptedException{
         ele = Locate(EmailTextBox_id ,"id" );
     return ele;
     }
     public static WebElement SubscribeBtn (WebDriver dr) throws InterruptedException{
         ele = Locate(SubscribeBtn_xp ,"xp" );
     return ele;
     }
     public static WebElement TermsChkbox (WebDriver dr) throws InterruptedException{
         ele = Locate(TermsChkbox_xp ,"xp" );
     return ele;
     }
     public static WebElement PolicyLink (WebDriver dr) throws InterruptedException{
         ele = Locate(PolicyLink_xp ,"xp" );
     return ele;
     }
     public static WebElement CoockiesCloseIcon (WebDriver dr) throws InterruptedException{
         ele = Locate(CoockiesCloseIcon_xp ,"xp" );
     return ele;
     }
     public static WebElement Msg3 (WebDriver dr) throws InterruptedException{
         ele = Locate(Msg3_xp ,"xp" );
     return ele;
     }
     public static WebElement PrivacyPolicyLink (WebDriver dr) throws InterruptedException{
         ele = Locate(PrivacyPolicyLink_xp ,"xp" );
     return ele;
     }
     public static WebElement CloseBtnAfterSubscription (WebDriver dr) throws InterruptedException{
         ele = Locate(CloseBtnAfterSubscription_xp ,"xp" );
     return ele;
     }
     public static WebElement SubscriptionText1 (WebDriver dr) throws InterruptedException{
         ele = Locate(SubscriptionText1_xp ,"xp" );
     return ele;
     }
     public static WebElement SubscriptionText2 (WebDriver dr) throws InterruptedException{
         ele = Locate(SubscriptionText2_xp ,"xp" );
     return ele;
     }
     
     /*LocateMethodsEndsHere*/
}
