package com.olie.utils.aspects.log;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class SystemLogStrategy implements Serializable {

    private boolean async;

    private String threadId;

    private String description;

    private String className;

    private String methodName;

    private String arguments;

    private String result;

    private Long elapsedTime;

    public String beforeFormat() {
        return "线程ID: {}, 方法描述: {}, 目标类名: {}, 目标方法: {}, 调用参数: {}";
    }
    public Object[] beforeArgs() {
        return new Object[]{this.threadId,this.description, this.className, this.methodName, this.arguments};
    }

    public String format() {
        return "线程ID: {}, 方法描述: {}, 目标类名: {}, 目标方法: {}, 调用参数: {}, 返回结果: {}, 花费时间: {}";
    }

    public Object[] args() {
        return new Object[]{this.threadId,this.description, this.className, this.methodName, this.arguments, this.result, this.elapsedTime};
    }

}