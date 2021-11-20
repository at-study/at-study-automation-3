package at.study.automation.cucumber;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import org.openqa.selenium.WebElement;
import org.reflections.Reflections;

import at.study.automation.ui.pages.Page;
import lombok.SneakyThrows;

public class PageObjectHelper {

    /**
     *
     * @param pageName
     * @param elementName
     * @return
     */
    public static WebElement findElement(String pageName, String elementName) {
        return getElement(getPage(pageName), elementName);
    }

    /**
     *
     * @param pageName
     * @param elementsName
     * @return
     */
    public static List<WebElement> findElements(String pageName, String elementsName) {
        return getElements(getPage(pageName), elementsName);
    }

    private static <T extends Page> T getPage(String pageName) {
        Set<Class<? extends Page>> allPages = new Reflections("at.study.automation.ui.pages").getSubTypesOf(Page.class);
        Class<? extends Page> pageObjectClass = allPages.stream()
                .filter(page -> page.isAnnotationPresent(PageName.class))
                .filter(page -> page.getAnnotation(PageName.class).value().equals(pageName))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Не найдено страницы с аннотацией @PageName(\"" + pageName + "\")"));
        return (T) Page.getPage(pageObjectClass);
    }

    private static WebElement getElement(Page page, String elementName) {
        return (WebElement) getObject(page, elementName);
    }

    private static List<WebElement> getElements(Page page, String elementsName) {
        return (List<WebElement>) getObject(page, elementsName);
    }

    @SneakyThrows
    private static Object getObject(Page page, String elementName) {
        Field[] allFields = page.getClass().getDeclaredFields();
        Field elementField = Stream.of(allFields)
                .filter(field -> field.isAnnotationPresent(ElementName.class))
                .filter(field -> field.getAnnotation(ElementName.class).value().equals(elementName))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Не найдено элемента с аннотацией @ElementName(\"" + elementName + "\")"));
        elementField.setAccessible(true);
        return elementField.get(page);
    }


}
