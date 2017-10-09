import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Google {

    @FindBy(css ="input#lst-ib")
    private WebElement searchBar;

    void search(String text){
        searchBar.sendKeys(text);
        searchBar.submit();
    }

    boolean isSearchBarExists(){
        return searchBar.isDisplayed();
    }
}
