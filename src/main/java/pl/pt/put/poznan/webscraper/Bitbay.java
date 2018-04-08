package pl.pt.put.poznan.webscraper;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pl.pt.put.poznan.webscraperdb.CurrencyManagement;
import pl.pt.put.poznan.webscraperdb.beans.CurrencyValue;

public class Bitbay {

    public Bitbay(WebDriver driver) throws Exception {
        List<WebElement> elements;

        driver.get("https://bitbay.net/pl/kurs-walut");
        elements = driver.findElements(By.xpath("//table[@class='table currency-table__table']/tbody/tr"));

        if (!elements.isEmpty()) {
            elements.stream().forEach((e) -> {
                String position = e.getText();
                System.out.println(position);
                String[] splited = position.split("\\s+");
                System.out.println(splited[1]);
                System.out.println(splited[2]);
                System.out.println(splited[4]);
                System.out.println(splited[5]);
                System.out.println(splited[6]);
                System.out.println(splited[7]);
//                CurrencyValue currencyvalue = new CurrencyValue(splited[1]);
//                currencyvalue.setPriceInDollars(Double.parseDouble(splited[2]));
//                currencyvalue.setBid(Double.parseDouble(splited[4]));
//                currencyvalue.setAsk(Double.parseDouble(splited[5]));
//                currencyvalue.setVolume(Double.parseDouble(splited[6]));
                //CurrencyManagement management = CurrencyManagement.getInstance();
                //management.addEntity(currencyvalue);
                
                
            });
        } else {
            driver.quit();
            throw new Exception("Currencies not found!");
        }
    }
}
