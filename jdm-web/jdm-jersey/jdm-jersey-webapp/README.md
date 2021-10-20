Jersey演示项目

使用外部应用服务器如 Tomcat 的版本。

在 webapp/WEB-INF/web.xml 中，定义了应用的启动方式。使用内置 Grizzly 服务器的应用版本，应用是被作为普通的 Java SE 模块来启动的，而这里的应用会被当作为 Servlet 启动。

虽然强烈推荐使用 Java 配置应用，而不是 web.xml，但这里作为演示给出示例。

