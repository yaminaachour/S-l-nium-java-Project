
//La classe DriverFactory simplifie la gestion des pilotes WebDriver
// en centralisant l'initialisation, la configuration des délais et
// d'autres paramètres de configuration, ce qui facilite la maintenance
// et la réutilisabilité des tests automatisés.

package com.qacart.todo.factory;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;
public class DriverFactory {

//  but :classe DriverFactory qui permet d'initialiser et de configurer différents pilotes WebDriver (Chrome, Firefox, Safari)
    public WebDriver initializeDriver() {
// n3ml run 3la ay browser
            // WebDriver driver;
                     // WebDriverManager.chromedriver().setup();
            // driver = new ChromeDriver();
        String browser = System.getProperty("browser", "CHROME").toUpperCase(); //toUpperCase();convertir la valeur de la propriété browser en majuscules si ktet= firfox = mvn clean test -Dbrowser=FIREFOX sinon nl8ha w nlteb maj men1

        //  Si aucune valeur n'est définie pour  key :browser, par défaut, il utilisera  def "CHROME" kna mktbtich def ykteb "The browser is not supported")
        WebDriver driver;
        switch (browser) {
                case "CHROME":
                    WebDriverManager.chromedriver().setup(); //pour télécharger et configurer automatiquement le pilote Chrome  (si ce n'est pas déjà fait) avant de l'initialiser.
                    driver = new ChromeDriver();
                    break;
                case "FIREFOX":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "SAFARI":
                    driver = new SafariDriver();//  macOS,Création d'une instance de SafariDriver(new SafariDriver()
                    break;
                default:
                    throw new RuntimeException("The browser is not supported");

            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
            return driver;
        }
        }
