package cn.vetech.center.hotel.link.api.data.enums;

/**
 * <p>
 * 初始化的运行状态
 * </p>
 *
 * @author wangkai
 * @since 2020/10/26
 */
public enum InitHotelEnum {

    /**
     * 正在运行
     */
    RUNNER(1),

    /**
     * 完成
     */
    COMPLETE(2),


    /**
     * 完成
     */
    COMPLETETHENRUNNER(3),;

    /**
     * 获取方式
     */
    private final int status;

    private InitHotelEnum(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }


}
