
import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.fluentlenium.core.filter.FilterConstructor.*;
import java.util.ArrayList;


import static org.assertj.core.api.Assertions.assertThat;


public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Make a dictionary!");
  }

  @Test
  public void wordIsCreatedTest() {
    goTo("http://localhost:4567/");
    fill("#initalWord").with("fire");
    submit("#wordSubmition");
    assertThat(pageSource()).contains("fire");
  }

  @Test
  public void defIsCreatedTest() {
    goTo("http://localhost:4567/");
    fill("#initalDef").with("is hot");
    submit("#defSubmition");
    assertThat(pageSource()).contains("is hot");
  }

  @Test
  public void defAndWordIsCreatedTest() {
    goTo("http://localhost:4567/");
    fill("#dualInputWord").with("fire");
    fill("#dualInputDef").with("is hot");
    submit("#fullSubmition");
    assertThat(pageSource()).contains("fire");
  }

}
