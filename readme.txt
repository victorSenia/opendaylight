install link
https://wiki.opendaylight.org/view/GettingStarted:Development_Environment_Setup

example link
https://wiki.opendaylight.org/view/OpenDaylight_Controller:MD-SAL:Startup_Project_Archetype

For generating
run from intellij
"C:\Program Files\Java\jdk1.8.0_92\bin\java" -Dmaven.multiModuleProjectDirectory=D:\android\eclipse\workspace\onendaylight -Dmaven.home=D:\Downloads\Programs\apache-maven-3.3.9 -Dclassworlds.conf=D:\Downloads\Programs\apache-maven-3.3.9\bin\m2.conf -Didea.launcher.port=7534 "-Didea.launcher.bin.path=C:\Program Files (x86)\JetBrains\IntelliJ IDEA 15.0\bin" -Dfile.encoding=UTF-8 -classpath "D:\Downloads\Programs\apache-maven-3.3.9\boot\plexus-classworlds-2.5.2.jar;C:\Program Files (x86)\JetBrains\IntelliJ IDEA 15.0\lib\idea_rt.jar" com.intellij.rt.execution.application.AppMain org.codehaus.classworlds.Launcher -Didea.version=15.0 -s ./settings.xml archetype:generate -DarchetypeGroupId=org.opendaylight.controller -DarchetypeArtifactId=opendaylight-startup-archetype -DarchetypeRepository=http://nexus.opendaylight.org/content/repositories/opendaylight.snapshot/ -DarchetypeCatalog=http://nexus.opendaylight.org/content/repositories/opendaylight.snapshot/archetype-catalog.xml

if maven is installed this also should work
mvc -s ./settings.xml archetype:generate -DarchetypeGroupId=org.opendaylight.controller -DarchetypeArtifactId=opendaylight-startup-archetype -DarchetypeRepository=http://nexus.opendaylight.org/content/repositories/opendaylight.snapshot/ -DarchetypeCatalog=http://nexus.opendaylight.org/content/repositories/opendaylight.snapshot/archetype-catalog.xml

for me successfully only on 3-th time
mvn install

start server
"karaf/target/assembly/bin/karaf"

check that logs are writen
log:display | grep Ext

watch in browser login/password : admin/admin
http://localhost:8181/apidoc/explorer/index.html

send request from REST
http://localhost:8181/restconf/operations/ext:ext-hello-world
{"input": {"name": "Giles"}}
Content-Type: application/json
authorization: Basic YWRtaW46YWRtaW4=

stop server
shutdown -f
Ctrl+D