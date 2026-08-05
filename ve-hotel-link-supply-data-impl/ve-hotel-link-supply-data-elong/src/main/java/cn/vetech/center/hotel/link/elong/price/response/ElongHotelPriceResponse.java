package cn.vetech.center.hotel.link.elong.price.response;

import cn.vetech.center.hotel.link.elong.ratesearch.response.ElongRateSearchResponse;

/**
 * @author xiaotengyu
 * @since 2021/03/03
 */
public class ElongHotelPriceResponse {

    /***
     * 原始数据
     */
    private String result;
    /***
     * 返回结果
     */
    private ElongRateSearchResponse response;

    /***
     * 静态价格
     */
    private ElongDataRateResponse rateResponse;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public ElongRateSearchResponse getResponse() {
        return response;
    }

    public void setResponse(ElongRateSearchResponse response) {
        this.response = response;
    }

    public ElongDataRateResponse getRateResponse() {
        return rateResponse;
    }

    public void setRateResponse(ElongDataRateResponse rateResponse) {
        this.rateResponse = rateResponse;
    }
}
