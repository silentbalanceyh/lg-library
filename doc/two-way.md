# Two - Way Authenticate

## 1. Workflow

![Two-Way](img/Two-Way.png)

## 2. References

1. [Enable HTTPS in spring-boot](https://drissamri.be/blog/java/enable-https-in-spring-boot/)
2. [Two-way in spring-boot](http://www.robinhowlett.com/blog/2016/01/05/everything-you-ever-wanted-to-know-about-ssl-but-were-afraid-to-ask/#two-way-spring-boot)
3. [Add SSL support to embedded server](https://dzone.com/articles/adding-ssl-support-embedded)
4. [Mutual Authentication ( Two-way ) with spring-boot and tomcat](http://blog.modo.lv/en/post/1825)
5. [SpringBoot Jetty SSL Server Example](https://www.youtube.com/watch?v=oJF13lWN25s)

## 3. Steps with JSSE ( In Java )

JSSE( Java Security Socket Extension ) implemented SSL/TSL protocol. To implement message authentication, we need to focus on following:

* Server Side:
	* KeyStore: stored private key of server
	* Trust KeyStore: stored client certificate of authorization
* Client Side:
	* KeyStore: stored private key of client
	* Trust KeyStore: stored server certificate of authorization

Also you could generate all required files with openssl, but we recommend to use keytool in java.

		