package top.caibitv.demo.design;

public interface HandlerInterceptor {

    boolean preHandle(String request, String response, Object handler);
}
