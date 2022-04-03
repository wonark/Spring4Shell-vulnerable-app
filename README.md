# Spring4Shell sample vulnerable application

This is a dockerized application that is vulnerable to the Spring4Shell vulnerability (CVE-2022-22965). Full Java source for the war is provided and modifiable, the war will get re-built whenever the docker image is built. The built WAR will then be loaded by Tomcat. There is nothing special about this application, it's a simple hello world that's based off [Spring tutorials](https://spring.io/guides/gs/handling-form-submission/).

Details: https://www.lunasec.io/docs/blog/spring-rce-vulnerabilities


## Run
```
docker run -p 8080:8080 --rm ghcr.io/denniskniep/vulnerable-app-spring4shell:latest
```

App should now be available at http://localhost:8080/helloworld/greeting
![WebPage](screenshots/webpage.png?raw=true)


## Build it yourself
1. Clone the repository
2. Build and run the container: `docker build . -t spring4shell && docker run -p 8080:8080 spring4shell`


## Credits
- [@esheavyind](https://twitter.com/esheavyind) for help on building a PoC. Check out their writeup at: https://gist.github.com/esell/c9731a7e2c5404af7716a6810dc33e1a
- [@LunaSecIO](https://twitter.com/LunaSecIO) for improving the documentation and exploit
- [@rwincey](https://twitter.com/rwincey) for making the exploit replayable without requiring a Tomcat restart
