# Spring Security开发安全restful接口



## 代码结构

![1558955626150](C:\Users\Stephen\AppData\Roaming\Typora\typora-user-images\1558955626150.png)







# RestFul接口开发

post 、put、get、delete 



## 测试类编写

```java
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before   //准备上下文环境
    public void setup(){
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test  //使用Mockmvc模拟请求
    public void whenQuerySuccess() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user")
            .contentType(MediaType.APPLICATION_JSON_UTF8))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3));
    }

}
```

 jar包jsonPath可结合mock进行返回结果表达式的编写。





## 常用注解

+ @RestControoler

  声明该类为Controller类并提供RestAPI

+ @RequestMapping

  映射http请求到java方法

+ @RequestParam

  映射请求参数到java方法参数













## springboot错误处理机制

### 默认处理机制



### 源码片段

```java
@RequestMapping(
        produces = {"text/html"}
    )
    public ModelAndView errorHtml(HttpServletRequest request, HttpServletResponse response) {
        HttpStatus status = this.getStatus(request);
        Map<String, Object> model = Collections.unmodifiableMap(this.getErrorAttributes(request, this.isIncludeStackTrace(request, MediaType.TEXT_HTML)));
        response.setStatus(status.value());
        ModelAndView modelAndView = this.resolveErrorView(request, response, status, model);
        return modelAndView == null ? new ModelAndView("error", model) : modelAndView;
    }

    @RequestMapping
    @ResponseBody
    public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
        Map<String, Object> body = this.getErrorAttributes(request, this.isIncludeStackTrace(request, MediaType.ALL));
        HttpStatus status = this.getStatus(request);
        return new ResponseEntity(body, status);
    }
```

两个处理@RequestMapping({"${server.error.path:${error.path:/error}}"}) 的请求方法。

如果请求头包含text/html，则走errorHtml方法，返回html代码，否则返回json。





### 自定义处理机制






## 拦截Restfule

















# 常见问题

1、运行测试类时，提示：Unable to find a @SpringBootConfiguration, you need to use @ContextConfiguration or @SpringBootTest(classes=...) with your test



查看发现为，测试类的包名路径与目标测试类包路径不同，如不同，则需要指明测试类类名@SpringBootTest(classes=...)



