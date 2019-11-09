### java client for elasticdata.io project

| Support API  |
| ------------- |
| run task by pipelineId, with supports json patch for pipeline commands |
| stop task by taskId  |
| get task by taskId  |
| get last data by pipelineId  |

#### Install 

##### gradle

add to build.gradle: 
```
repositories {
    ...
    maven { url "https://jitpack.io" }
}
```
 
```
dependencies {
    ...
    implementation 'com.github.stkachenko:elasticdata-java-client:v1.0'
}
```
##### maven

add to pom.xml: 
```xml
    <dependency>
        <groupId>com.github.sergeytkachenko</groupId>
        <artifactId>elasticdata-java-client</artifactId>
        <version>v1.0</version>
    </dependency>
```

```xml
    <repositories>
        <repository>
            <id>jitpack.io</id>
            <url>https://jitpack.io</url>
        </repository>
    </repositories>
```

#### Examples  

See more example https://github.com/sergeytkachenko/elasticdata-java-client/tree/master/src/main/java/elasticdata/io/samples

#### Publish by owner 

Create release on github page. The end. 