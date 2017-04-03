# Example Spring Boot application showing distributed tracing with stagemonitor and Zipkin
This is an example app where two Spring Boot (Java) services collaborate on an http request.
Notably, timing of these requests are recorded into Zipkin, a distributed tracing system.
This allows you to see the how long the whole operation took, as well how much time was spent in each service.

Stagemonitor automatically instruments the Client and Server Spring Boot application so that tracing data is sent to Zipkin.
No code changes required.

# Run the example
- Open the project in IntelliJ (other IDEs with Maven support should work as well)
- Run BootZipkinClientApplication and BootZipkinServerApplication
- Run [Zipkin](http://zipkin.io) which stores and queries traces reported by the above services.
 ```
 wget -O zipkin.jar 'https://search.maven.org/remote_content?g=io.zipkin.java&a=zipkin-server&v=LATEST&c=exec'
 java -jar zipkin.jar
 ```
- Open the client application at http://localhost:8080. This will call the server application at http://localhost:8081 and display a message.
- Next, you can view traces that went through the client applciation via http://localhost:9411/?serviceName=client
- Also note the little stagemonitor icon at the bottom right of the client application.
  Clicking on it opens the stagemonitor in-browser-widget which lets you analyze the call tree of the current request,
  view live metrics, adjust the configuration and more.
