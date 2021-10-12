package cn.mingyu.admin.domain;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author yimingyu
 * @date 2021/09/26
 */
@Data
public class BaseObj implements Serializable {
    private static final long serialVersionUID = 4611325466079899055L;

    private int id;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
