package org.piano.test.task.ui.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

/**
 * Created by Юрий on 25.01.2017.
 */
public class SearchResult extends HtmlElement {
    @FindBy(className = "title")
    private WebElement name;

    @FindBy(className = "location")
    private WebElement location;

    public String getName() {
        return name.getText();
    }

    public String getLocationName() {
        return  location.getText();
    }


}
