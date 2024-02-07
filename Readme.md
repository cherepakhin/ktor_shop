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

Hello World!
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

[Интеграционные тесты https://github.com/cherepakhin/ktor_shop_restassured_test](https://github.com/cherepakhin/ktor_shop_restassured_test)