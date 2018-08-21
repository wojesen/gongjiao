package com.yinlian.core.exception;

import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.*;
import com.yinlian.core.common.Response;

/**
 * Created by xuhao on 2018/8/21.
 */
@Activate
public class ExtendExceptionFilter implements Filter {
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        try {
            Result result = invoker.invoke(invocation);
            if (result.hasException()) {
                return new RpcResult(Response.fail("服务器内部错误"));
            }
            return result;
        } catch (Exception e) {
            return new RpcResult(Response.fail("服务器内部错误"));
        }
    }
}
