

服务注册
1.eureka  定位服务，实现负载均衡和中间服务的故障转移
2.load banlancer 将请求均匀的分摊到多个服务上，从而达到系统的高可用
默认轮询算法，并且可以更换默认的负载均衡算法,
ribbonClient本质是配置  服务的分配给客户的方式
集群 euraka的defaultzone不能是自己的
负载均衡
3.openForeign
针对客户端的配置
简化ribbon的操作
Feign集成了Ribbon，利用Ribbon维护了Payment的服务列表信息，并且通过轮询实现了客户端的负载均衡
，而与Ribbon不同的是，通过Feign值需要定义服务绑定接口且一声明式的方法，
注意在conusmer里面要配置用户和provider的接口。paymentService里面的接口和provider的接口是一致的
断路器
4.hystrix
针对服务器端的配置
对某个server的调用超出一定时间或者次数，断路器会将连接断开，返回一个fallback
服务降级，服务熔断，实时监控
@HystrixCommand(fallbackMethod = "getHystrixNews")，执行getHystrixNews()回调函数
降级是提供更好的当前用户体验，会暂时的执行回调函数，而不是提供请求的内容，
降级是为了更好的用户体验，当一个方法调用异常时，通过执行另一种代码逻辑来给用户友好的回复

5.gate   Zunl
前向代理   动态路由   同时有个过滤器
  （1）自己写个config把路由配置一下
  （2） filter  pre在请求前过滤，post在response之前过滤

6.bus消息总线+spring cloud config实现动态配置



