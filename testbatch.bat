set projectLocation=C:\Users\sakha\.eclipse\Salenium
cd %projectLocation%
set classpath=%projectLocation%\bin;%projectLocation%\lib\*;
java org.testng.TestNG NewTestGMO.xml
pause