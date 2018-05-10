# Environment setup steps
<hr>
***
### Downloading of desired files
1. [Download Intellij Idea by link](https://www.jetbrains.com/idea/download/download-thanks.html?platform=windows&code=IIC)
2. [Download Java SE Development Kit by link](http://www.oracle.com/technetwork/java/javase/downloads/jdk10-downloads-4416644.html)
***
### Installation of downloaded files
1. Install Java SE Development Kit **use default settings during installation**
2. Install Intellij Idea **use default settings during installation**
3. Install Firefox browser
***
### Creating new project in Intellij Idea
1. Launch Intellij Idea
2. Create New project
3. Select 'Maven' tab from the left panel [Screenshot](http://prntscr.com/j9gbe7)
4. Select jdk in 'Project SDK' field [Screenshot](http://prntscr.com/j9gdbz)
5. Click on 'Next' button [Screenshot](http://prntscr.com/j9gdtf)
6. Type any text in 'GroupID' and 'ArtifactID' fields and click 'Next' button [Screenshot](http://prntscr.com/j9ge9x)
7. Type project name in 'Project Name' and 'Project Location' fields as in 'ArtifactID' field in previous step
8. Click 'Finish' button [Screenshot](http://prntscr.com/j9ghaz)
***
### Adding Selenium WebDriver
1. Go to [Maven repository by link](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/3.11.0)
2. Copy 'Selenium dependency' [Screenshot](http://prntscr.com/j9gkx8)
3. Open 'pom.xml' file [Screenshot](http://prntscr.com/j9gmd2)
4. Insert 'copied dependency' [Screenshot](http://prntscr.com/j9gnsu)
<!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java -->
  <dependency>
     <groupId>org.seleniumhq.selenium</groupId>
     <artifactId>selenium-java</artifactId>
     <version>3.11.0</version>
 </dependency>
5. Add <dependencies> tag above <dependency> and </dependencies> tag below </dependency> [Screenshot](http://prntscr.com/j9goy5)
6. Note that if text between tags has red color - need to wait for a few minutes
***
### Adding geckodriver
1. Go to [Geckodriver page](https://github.com/mozilla/geckodriver/releases)
2. [Download geckodriver by link](http://prntscr.com/j9hb0k)
3. Unpack downloaded ZIP file
4. Copy 'geckodriver.exe' to 'C:\Windows\System32'
***
### Adding additional panels
1. Click on 'View' tab in Main menu and click on 'Toolbar' and 'Tool Buttons' points [Screenshot](http://prntscr.com/j9h329)
2. Check new panels appear from the right [Screenshot](http://prntscr.com/j9h9cm)
***
### Adding new Class
1. Click right mouse button on 'java' folder in path 'Name of the project > src > main > java' [Screenshot](http://prntscr.com/j9gz63)
2. Hover mouse on 'New' tab [Screenshot](http://prntscr.com/j9gzfh)
3. Click on 'Java Class' option [Screenshot](http://prntscr.com/j9gzvj)
4. Type any name of class in 'Name' field [Screenshot](http://prntscr.com/j9h0eb)
5. Click on 'Ok' button [Screenshot](http://prntscr.com/j9h15m)
***
### Adding main method
1. Type main method 'public static void main(String args[]) {}'
***
### Print 'Hello world!' text
1. System.out.println("Hello world!"); [Screenshot](http://prntscr.com/j9h60e)
***
### Connecting Firefox browser with opening 'Google' page
1. Type next strings:
 WebDriver WebDriver = new FirefoxDriver();
 WebDriver.get("https://www.google.com/");
[Screenshot](http://prntscr.com/j9h6sf)
2. Note thst if 'WebDriver' has red color - you need to press ALT+ENTER and this string 'import org.openqa.selenium.WebDriver;' appears st the top [Screenshot](http://prntscr.com/j9h88z)
3. Note thst if 'FirefoxDriver' has red color - you need to press ALT+ENTER and this string 'import org.openqa.selenium.firefox.FirefoxDriver;' appears st the top [Screenshot](http://prntscr.com/j9h8t8)
***
### Launching of the project
1. Click on green arrow from the left of 'Main' method [Screenshot](http://prntscr.com/j9hkn1)
2. Check 'Hello world!' text is displayed in console [Screenshot](http://prntscr.com/j9hl55)
3. Check 'Process finished with exit code 0' text is displayed in console [Screenshot](http://prntscr.com/j9hlfa)
4. Check Firefox browser launched and 'https://www.google.com/' page is opened [Screenshot](http://prntscr.com/j9hm1b)