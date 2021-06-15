package controller.goibibo;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Constants;
import utils.InvalidDateException;
import utils.Util;

import javax.xml.xpath.XPath;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;





public class Goibibo extends ChromeDriver {
    private WebDriverWait wait=null;

    @FindBy(how = How.XPATH,using = "//input[@id='gosuggest_inputSrc']")
    WebElement inputFrom;

    @FindBy(how = How.XPATH,using = "//input[@id='gosuggest_inputDest']")
    WebElement inputDest;

    @FindBy(how = How.XPATH,using = "//input[@id='departureCalendar']")
    WebElement departureCalender;

    @FindBy(how = How.XPATH,using= "//input[@id='returnCalendar']")
    WebElement returnCalender;

    @FindBy(how = How.ID,using = "gi_search_btn")
    WebElement search;

    @FindBy(how = How.ID,using = "pax_link_common")
    WebElement paxLink;

    @FindBy(how = How.ID,using = "adultPaxPlus")
    WebElement adultPaxPlus;

    @FindBy(how = How.ID,using = "childPaxPlus")
    WebElement childPaxPlus;

    @FindBy(how = How.ID,using = "infantPaxPlus")
    WebElement infantPaxPlus;


    @FindBy(how=How.XPATH,using = "//div[text()='Departure']//following-sibling::div//descendant::span[text()='Before 11am']//parent::span//preceding-sibling::input")
    WebElement departureBefore11;

    @FindBy(how = How.XPATH,using = "//div[text()='Return']//following-sibling::div//descendant::span[text()='Before 11am']//parent::span//preceding-sibling::input")
    WebElement returnBefore11;

    @FindBy(how=How.XPATH,using = "(//div[@class='black fb font14 padB10 quicksand'])[9]//parent::div//following-sibling::div//child::div[contains(@class,'filtersstyles__PreferredRow')]//descendant::input")
    List<WebElement> es;

    @FindBy(how = How.XPATH,using = "((//div[@class='srp-card-uistyles__ResultCard-sc-3flq99-24 kkuOhu lh1 pad10 sticky']//descendant::div[contains(@class,'srp-card-uistyles__Col4-sc-3flq99-29')])[1]//span)[3]")
    WebElement d1;

    @FindBy(how = How.XPATH,using = "((//div[@class='srp-card-uistyles__ResultCard-sc-3flq99-24 kkuOhu lh1 pad10 sticky']//descendant::div[contains(@class,'srp-card-uistyles__Col4-sc-3flq99-29')])[2]//span)[3]")
    WebElement d2;

    @FindBy(how = How.XPATH,using = "//span[text()='PRICE']")
    List<WebElement> prices;


    @FindBy(how=How.CSS,using=".SortOptionsstyles__Wrapper-tji0t1-0.cDxOri + div > div:nth-child(1) > div:nth-child(1) input[type='radio']")
    WebElement flight1;

    @FindBy(how=How.CSS,using=".SortOptionsstyles__Wrapper-tji0t1-0.cDxOri + div > div:nth-child(2) > div:nth-child(1) input[type='radio']")
    WebElement flight2;


    @FindBy(how=How.XPATH,using = "(//input[@class='srp-card-uistyles__Fltbook-sc-3flq99-35 iglaTg fb quicksand widthF105'])[1]")
    WebElement btnBook;


    @FindBy(how=How.XPATH,using = "//input[@id='HDFCEMI']//parent::span")
    WebElement HDFC_VIEW;

    @FindBy(how=How.ID,using = "HDFCEMI")
    WebElement HDFC_RADIO;

    @FindBy(how=How.XPATH,using = "//button[text()='OK']")
    WebElement modalBtnOk;

    @FindBy(how = How.CSS,using = ".fare-summarystyles__TotalAmount-u1o0is-2  > div > div:nth-child(2) span")
    WebElement price;

    @FindBy(how = How.CSS,using = ".fare-summarystyles__TotalAmount-u1o0is-2  > div > div:nth-child(2) .strike")
    WebElement priceCrossed;

    @FindBy(how=How.XPATH,using = "//span[text()='TRAVELLER DETAILS']")
    WebElement spanTraveller;

    @FindBy(how=How.XPATH,using = "//div[contains(@class,'traveller-detailsstyles__TravellerDtlWrp-sc-1xqbced-5')]")
    List<WebElement> travellers;

    @FindBy(how = How.XPATH,using = "//input[@class='common-elementsstyles__IpTxt-ilw4bs-11 cCpVLQ width100' and @placeholder='Email']")
    WebElement email;

    @FindBy(how=How.XPATH,using = "//input[@placeholder='Mobile No']")
    WebElement mobile;

    @FindBy(how=How.XPATH,using = "//button[text()='Proceed']")
    WebElement btnProceed;


    @FindBy(how = How.XPATH,using = "//div[@class='insurancestyles__InsurerBg-sc-1mgjgh5-1 giznqj fGS0']")
    WebElement divIns;

    @FindBy(how = How.XPATH,using = "//button[@class='dweb-commonstyles__ButtonBase-sc-13fxsy5-4 dweb-commonstyles__InsuranceButton-sc-13fxsy5-5 dweb-commonstyles__InsuranceUnselectButton-sc-13fxsy5-7 iKkGzW joMLfq gEvPUo']")
    WebElement btnTakeRisk;




    private Goibibo(){
        super();
        wait=new WebDriverWait(this,15);
    }

    private static volatile Goibibo goibbo=null;

    public static Goibibo getInstance(){
        if(goibbo==null){
            System.setProperty(Constants.CHROME_DRIVER_KEY,Constants.CHROME_DRIVER_LOCATION);
            goibbo=new Goibibo();
            goibbo.goPage();
        }
        return goibbo;
    }


    public void goPage(){
        this.get("https://www.goibibo.com/");
    }

    public void goPage(String url){
        this.get(url);
    }

    public void searchPage() throws InvalidDateException {
        PageFactory.initElements(this,this);
        inputFrom.sendKeys("Chennai");
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='react-autosuggest-1']")));
        inputFrom.sendKeys(Keys.ARROW_DOWN);
        inputFrom.sendKeys(Keys.ENTER);


        inputDest.sendKeys("Delhi");
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='react-autosuggest-1']")));
        inputDest.sendKeys(Keys.ARROW_DOWN);
        inputDest.sendKeys(Keys.ENTER);

        departureCalender.click();
        this.selectDate("June",2021,27);

        returnCalender.click();
        this.selectDate("June",2021,28);

        paxLink.click();
        adultPaxPlus.click();
        childPaxPlus.click();
        infantPaxPlus.click();
        search.click();
    }


    public void selectFlightPage(){
        PageFactory.initElements(this,this);
        Assert.assertEquals(true,this.getCurrentUrl().contains("/flights/"));

        this.clickJs(departureBefore11);
        this.clickJs(returnBefore11);
        if(es.size()!=0){
            int i=0;
            for (WebElement el:es) {
                this.executeJs("arguments[0].scrollIntoView(false)",this.findElement(By.xpath(("((//div[@class='black fb font14 padB10 quicksand'])[9]//parent::div//following-sibling::div//child::div[contains(@class,'filtersstyles__PreferredRow')])["+(i+1)+"]"))));
                this.clickJs(el);
                i++;
            }
            this.executeJs("arguments[0].scrollIntoView(true)",departureBefore11);
        }else{
            System.out.println("No Select Box Found");
        }

        for (WebElement p:prices) {
            this.clickJs(p);
        }

        this.clickJs(flight1);
        this.clickJs(flight2);

        Pattern pattern=Pattern.compile("(^0[0123456]{1}:[012345]{1}\\d{1}$)|(^10:[012345]{1}\\d{1}$)");
        Assert.assertEquals(true,pattern.matcher(d1.getText()).find() || pattern.matcher(d2.getText()).find());
        this.clickJs(btnBook);
    }

    public void memberFillAndDiscountPage(){
        this.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        PageFactory.initElements(this,this);
        Assert.assertEquals(true,this.getCurrentUrl().contains("/flight-review/"));

        Actions builder=new Actions(this);

        this.scrollIntoViewTrue(HDFC_VIEW);
        this.clickJs(HDFC_RADIO);

        this.wait.until(ExpectedConditions.visibilityOf(modalBtnOk));
        modalBtnOk.click();
        int priceParsed =Integer.parseInt(price.getText().replace("₹","").replace(",",""));
        int priceCParsed= Integer.parseInt(priceCrossed.getText().replace("₹","").replace(",",""));

        Assert.assertEquals(true,priceParsed<priceCParsed);

        for(int i=0;i<travellers.size();i++){
            WebElement trv=travellers.get(i);
            builder.moveToElement(trv).click().build().perform();

            Select title=new Select(this.findElement(By.xpath("//select[@class='common-elementsstyles__CustSelectTrvl-ilw4bs-9 jGncYu']")));
            WebElement fn=this.findElement(By.xpath("//input[@class='common-elementsstyles__IpTxt-ilw4bs-11 gVsaoE width100' and @placeholder='First & Middle Name']"));
            WebElement ln=this.findElement(By.xpath("//input[@class='common-elementsstyles__IpTxt-ilw4bs-11 gVsaoE width100' and @placeholder='Last Name']"));

            title.selectByIndex(1);
            fn.sendKeys(Util.getRandomString());
            ln.sendKeys(Util.getRandomString());
            if(trv.getText().contains("Infant")){
                List<WebElement> dob=this.findElements(By.xpath("//select[@class='common-elementsstyles__CustSelectTrvl-ilw4bs-9 jGncYu width100']"));
                dob.forEach(d->{
                    Select s=new Select(d);
                    s.selectByIndex(2);
                });
            }
        }
        email.sendKeys("xyz@gmail.com");
        mobile.sendKeys("8888888888");


        this.scrollIntoViewTrue(divIns);
        btnTakeRisk.click();




        btnProceed.click();
    }



    public void clickJs(WebElement wb){
        ((JavascriptExecutor) this).executeScript("arguments[0].click()",wb);
    }
    public void scrollIntoViewTrue(WebElement wb){((JavascriptExecutor) this).executeScript("arguments[0].scrollIntoView(true)",wb);}

    public void executeJs(String script,WebElement wb){
        ((JavascriptExecutor)this).executeScript(script,wb);
    }

    void selectDate(String month,int year,int date) throws InvalidDateException{
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='DayPicker']")));
        findM(
                this.findElement(By.xpath("//div[@class='DayPicker']//descendant::span[@role='button' and contains(@class,'DayPicker-NavButton--next')]")),
                this.findElement(By.xpath("//div[@class='DayPicker-Caption']//div")),
                month,
                year
        );
        if(this.findElement(By.xpath("//div[text()="+date+" and @class='calDate']/parent::div")).getAttribute("aria-disabled").contains("true")){
            throw new InvalidDateException("Selected Date is Disabled");
        }else{
            this.findElement(By.xpath("//div[text()="+date+" and @class='calDate']")).click();
        }
    }

    void findM(WebElement nav,WebElement wb,String m,int year){
        while(true){
            if(wb.getText().contains(m) && wb.getText().contains(year+"")){
                break;
            }
            nav.click();
        }
    }

    @Override
    public void quit() {
        super.quit();
        goibbo=null;
    }
}
