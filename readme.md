# Spring Boot Graal Demo

(not working yet...)

# Setup Graal
Follow the instructions under https://www.graalvm.org/docs/getting-started/

# Build Package
```
mvn clean package
```

# Build Native Image
```
$GRAALVM_HOME/bin/native-image \
  --report-unsupported-elements-at-runtime \
  -jar target/spring-boot-helloworld-0.0.1-SNAPSHOT.jar
```

Output
```
$ $GRAALVM_HOME/bin/native-image --report-unsupported-elements-at-runtime -jar target/spring-boot-helloworld-0.0.1-SNAPSHOT.jar
Build on Server(pid: 15994, port: 38077)
[spring-boot-helloworld-0.0.1-SNAPSHOT:15994]    classlist:     118.23 ms
[spring-boot-helloworld-0.0.1-SNAPSHOT:15994]        (cap):     392.83 ms
[spring-boot-helloworld-0.0.1-SNAPSHOT:15994]        setup:     612.86 ms
[spring-boot-helloworld-0.0.1-SNAPSHOT:15994]   (typeflow):   3,910.00 ms
[spring-boot-helloworld-0.0.1-SNAPSHOT:15994]    (objects):   2,790.45 ms
[spring-boot-helloworld-0.0.1-SNAPSHOT:15994]   (features):     133.59 ms
[spring-boot-helloworld-0.0.1-SNAPSHOT:15994]     analysis:   6,948.34 ms
[spring-boot-helloworld-0.0.1-SNAPSHOT:15994]     universe:     176.60 ms
[spring-boot-helloworld-0.0.1-SNAPSHOT:15994]      (parse):     760.38 ms
[spring-boot-helloworld-0.0.1-SNAPSHOT:15994]     (inline):   1,563.12 ms
[spring-boot-helloworld-0.0.1-SNAPSHOT:15994]    (compile):   5,974.04 ms
[spring-boot-helloworld-0.0.1-SNAPSHOT:15994]      compile:   8,696.79 ms
[spring-boot-helloworld-0.0.1-SNAPSHOT:15994]        image:     749.13 ms
[spring-boot-helloworld-0.0.1-SNAPSHOT:15994]        write:     108.51 ms
[spring-boot-helloworld-0.0.1-SNAPSHOT:15994]      [total]:  17,455.83 ms
```

#Run the Native Image
```
./spring-boot-helloworld-0.0.1-SNAPSHOT
```

Output:
```
$ ./spring-boot-helloworld-0.0.1-SNAPSHOT 
Exception in thread "main" java.lang.IllegalStateException: java.lang.IllegalStateException: Unable to determine code source archive
	at org.springframework.boot.loader.ExecutableArchiveLauncher.<init>(ExecutableArchiveLauncher.java:41)
	at org.springframework.boot.loader.JarLauncher.<init>(JarLauncher.java:35)
	at org.springframework.boot.loader.JarLauncher.main(JarLauncher.java:51)
Caused by: java.lang.IllegalStateException: Unable to determine code source archive
	at org.springframework.boot.loader.Launcher.createArchive(Launcher.java:122)
	at org.springframework.boot.loader.ExecutableArchiveLauncher.<init>(ExecutableArchiveLauncher.java:38)
	... 2 more
```