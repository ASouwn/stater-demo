## SpringBoot2.7之前
META-INF/spring.factories文件里添加org.springframework.boot.autoconfigure.EnableAutoConfiguration=XXAutoConfiguration
## SpringBoot2.7推出新的自动配置
在META-INF/spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports
文件里添加配置类名称，每行包含一个配置类全限定名
兼容META-INF/spring.factories方式
## SpringBoot3.x 移除spring.factories
移除META-INF/spring.factories方式
只支持META-INF/spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports 增加自动配置

### 这里使用的spring boot 3.2.4

使用时加入以下依赖，之所以是3.2.4版本，是由stater中的pom中的version决定，而我这里把version标签删掉了，所以就以spring boot 的3.2.4决定了
~~~
        <dependency>
            <groupId>com.asouwn</groupId>
            <artifactId>stater-demo</artifactId>
            <version>3.2.4</version>
        </dependency>
~~~
在stater中的pom决定这里的名称与依赖版本
~~~
    <groupId>com.asouwn</groupId>
    <artifactId>stater-demo</artifactId>
~~~
引入依赖后使用以下代码就可像本地一样直接调用（某种方式来说，这个方法确实在本地，因为引入依赖后，在Load时会下载jar包到本地仓库）
~~~
在application.yaml中：
    stater.demo.name=asouwn
在Test类中：
    @Resource
    private User user ;
    @Test
    void contextLoads() {
        if (user == null)
            System.out.println("no object");
        else System.out.println(user.getName());
    }
~~~