package exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C), 2017-2022, 赵旭
 * Author: 11931
 * Date: 2022/5/7 22:00
 * FileName: FilterDemo01
 * Description: exercise
 * <p>
 * 责任链模式
 */
public class FilterDemo01 {

    private interface Filter {
        boolean doFilter(Request request, Response res);
    }

    private static class Response {
        String msg;
    }

    private static class Request {
        String msg;
    }

    private static class HTMLFilter implements Filter {
        @Override
        public boolean doFilter(Request request, Response res) {
            request.msg = request.msg.replaceAll("<", "[").replaceAll(">", "]");
            return true;
        }
    }

    private static class SensitiveFilter implements Filter {
        @Override
        public boolean doFilter(Request request, Response res) {
            request.msg = request.msg.replaceAll("996", "955");
            return true;
        }
    }

    private static class FilterChain implements Filter {
        List<Filter> list = new ArrayList<>();

        public FilterChain addFilter(Filter filter) {
            list.add(filter);
            return this;
        }

        public boolean doFilter(Request request, Response res) {
            for (Filter filter : list) {
                filter.doFilter(request, res);
            }
            return true;
        }
    }


    public static void main(String[] args) {

        Response response = new Response();
        Request request = new Request();
        request.msg = "<hello world>,this is 996";

        new FilterChain()
                .addFilter(new HTMLFilter())
                .addFilter(new SensitiveFilter())
                .doFilter(request, response);

        System.out.println(request.msg);
    }

}
