package com.yinlian.core.exception;

import com.alibaba.dubbo.rpc.*;

/**
 * Created by xuhao on 2018/8/21.
 */
public class ExceptionFilter implements Filter {
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        try {
            Result result = invoker.invoke(invocation);
            if (result.hasException()) {
                return new RpcResult("1");
            }
            return result;
        } catch (Exception e) {
            return new RpcResult("1");
        }
    }
}
