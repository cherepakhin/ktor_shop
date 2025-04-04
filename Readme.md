
$ echo $JAVA_HOME
/usr/lib/jvm/openjdk-17/

Генерация заготовки проекта:<br/>
[ktor-sample](https://start.ktor.io/#/final?name=ktor-sample&website=example.com&artifact=com.example.ktor-sample&kotlinVersion=1.9.22&ktorVersion=2.3.7&buildSystem=GRADLE_KTS&engine=NETTY&configurationIn=CODE&addSampleCode=true&plugins=routing%2Chtml-dsl%2Ccontent-negotiation%2Cktor-jackson)

Запуск:<br/>
````shell
chmod +x gradlew
./gradlew build
./gradlew run
````

Ручные тесты:<br/>

````shell
~/prog/kotlin/ktor/ktor-shop$ http :9080/
HTTP/1.1 200 OK
Connection: keep-alive
Content-Length: 12
Content-Type: text/plain; charset=UTF-8

from root
````

````shell
ktor-shop$ http :9080/json/jackson
HTTP/1.1 200 OK
Connection: keep-alive
Content-Type: application/json
transfer-encoding: chunked

{
"hello": "world"
}
````

````shell
$ http :9080/json/product
HTTP/1.1 200 OK
Connection: keep-alive
Content-Type: application/json
transfer-encoding: chunked

{
    "id": 1,
    "name": "Name1"
}
````

Интеграционные тесты: [https://github.com/cherepakhin/ktor_shop_restassured_test](https://github.com/cherepakhin/ktor_shop_restassured_test)

Unit-tests:

````shell
./gradlew test
````

Перезапустить все тесты:

````shell
./gradlew --rerun-tasks test
./gradlew cleanTest test
./gradlew -i --no-build-cache cleanTest test
````
 -i вывод различной информации.

````shell
Initialized native services in: /home/vasi/.gradle/native
Initialized jansi services in: /home/vasi/.gradle/native
Received JVM installation metadata from '/usr/lib/jvm/java-17-openjdk-amd64': {JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64, JAVA_VERSION=17.0.7, JAVA_VENDOR=Private Build, RUNTIME_NAME=OpenJDK Runtime Environment, RUNTIME_VERSION=17.0.7+7-Ubuntu-0ubuntu118.04, VM_NAME=OpenJDK 64-Bit Server VM, VM_VERSION=17.0.7+7-Ubuntu-0ubuntu118.04, VM_VENDOR=Private Build, OS_ARCH=amd64}
The client will now receive all logging from the daemon (pid: 7841). The daemon log file: /home/vasi/.gradle/daemon/8.4/daemon-7841.out.log
Starting 12th build in daemon [uptime: 16 mins 8.271 secs, performance: 100%, GC rate: 0.00/s, heap usage: 0% of 512 MiB, non-heap usage: 38% of 384 MiB]
Using 4 worker leases.
````

Подключен Allure Report. Для просмотра отчета открыть build/reports/tests/test/index.html .

Publish to Nexus:<br/>

````shell
./gradlew publish
````
Версия будет установлена из build.gradle.kts version = "????".

Показать git репозитории:

````shell
$ git remote -v
origin  https://github.com/cherepakhin/ktor_shop.git (fetch)
origin  https://github.com/cherepakhin/ktor_shop.git (push)
````
