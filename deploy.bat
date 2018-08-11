RD /S /Q C:\apache-tomcat-8.0.22\webapps\JSFSpringJPAExample
RD /S /Q C:\apache-tomcat-8.0.22\work\Catalina\localhost\JSFSpringJPAExample
DEL /Q C:\apache-tomcat-8.0.22\webapps\JSFSpringJPAExample.war
COPY /Y war\JSFSpringJPAExample.war C:\apache-tomcat-8.0.22\webapps\