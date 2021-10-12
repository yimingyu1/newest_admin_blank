package cn.mingyu.admin.common;

import lombok.Data;

/**
 * @author yimingyu
 * @date 2021/09/26
 */
@Data
public class Paging {
    private int offset;
    private int limit;
    private int total;
    private boolean hasMore;
}
