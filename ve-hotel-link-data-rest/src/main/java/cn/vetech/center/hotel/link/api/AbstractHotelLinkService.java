package cn.vetech.center.hotel.link.api;

import cn.vetech.center.hotel.link.api.data.enums.DataResponseEnum;
import cn.vetech.center.hotel.link.api.ddtk.dto.LinkHotelDdtkDTO;
import cn.vetech.center.hotel.link.api.ddtk.vo.LinkHotelDdtkVO;
import cn.vetech.center.hotel.link.api.ddvalidate.dto.LinkHotelDdValidateDTO;
import cn.vetech.center.hotel.link.api.ddvalidate.vo.LinkHotelDdValidateVO;
import cn.vetech.center.hotel.link.api.guarantee.dto.LinkHotelGuaranteeDTO;
import cn.vetech.center.hotel.link.api.guarantee.vo.LinkHotelGuaranteeVO;
import cn.vetech.center.hotel.link.api.hotelbuyerbillpush.HotelBuyerBillPushDTO;
import cn.vetech.center.hotel.link.api.hotelbuyerbillpush.HotelBuyerBillPushVO;
import cn.vetech.center.hotel.link.api.hotelguestreviews.dto.HotelGuestReviewsDTO;
import cn.vetech.center.hotel.link.api.hotelguestreviews.vo.HotelGuestReviewsVO;
import cn.vetech.center.hotel.link.api.hotelimage.dto.HotelImageConvertDTO;
import cn.vetech.center.hotel.link.api.hotelimage.vo.HotelImageConvertVO;
import cn.vetech.center.hotel.link.api.member.dto.LinkHotelRegistrationDTO;
import cn.vetech.center.hotel.link.api.member.vo.LinkHotelRegistrationVO;
import cn.vetech.center.hotel.link.api.orderbook.dto.LinkHotelOrderBookDTO;
import cn.vetech.center.hotel.link.api.orderbook.vo.LinkHotelOrderBookVO;
import cn.vetech.center.hotel.link.api.ordercancel.dto.LinkHotelOrderCancelDTO;
import cn.vetech.center.hotel.link.api.ordercancel.vo.LinkHotelOrderCancelVO;
import cn.vetech.center.hotel.link.api.orderdetail.dto.LinkHotelOrderDetailDTO;
import cn.vetech.center.hotel.link.api.orderdetail.vo.LinkHotelOrderDetailVO;
import cn.vetech.center.hotel.link.api.orderlist.dto.LinkHotelOrderListDTO;
import cn.vetech.center.hotel.link.api.orderlist.vo.LinkHotelOrderListVO;
import cn.vetech.center.hotel.link.api.orderpay.dto.LinkHotelOrderPayDTO;
import cn.vetech.center.hotel.link.api.orderpay.vo.LinkHotelOrderPayVO;
import cn.vetech.center.hotel.link.api.ord
import cn.vetech.center.hotel.link.api.paydk.dto.LinkHotelPayDkDTO;
import cn.vetech.center.hotel.link.api.paydk.vo.LinkHotelPayDkVO;
import cn.vetech.center.hotel.link.api.paydkmix.dto.LinkHotelPayWithholdingMixDTO;
import cn.vetech.center.hotel.link.api.paydkmix.vo.LinkHotelPayWithholdingMixVO;
import cn.vetech.center.hotel.link.api.ratesearch.dto.LinkHotelRateSearchDTO;
import cn.vetech.center.hotel.link.api.ratesearch.vo.LinkHotelRateSearchVO;
import cn.vetech.center.hotel.link.api.tdsq.dto.LinkHotelCgtdsqDTO;
import cn.vetech.center.hotel.link.api.tdsq.vo.LinkHotelCgtdsqVO;
import cn.vetech.center.hotel.link.api.tdxx.dto.LinkHotelCgtdxxDTO;
import cn.vetech.center.hotel.link.api.tdxx.vo.LinkHotelCgtdxxVO;
import cn.vetech.center.hotel.link.api.validate.dto.LinkHotelValidateDTO;
import cn.vetech.center.hotel.link.api.validate.vo.LinkHotelValidateVO;
import cn.vetech.center.hotel.link.util.ApiRes;
import cn.vetech.charge.cloud.springcloud.api.RestResponse;

/**
 * @author vetech
 * @since 2023/10/11
 */
public abstract class AbstractHotelLinkService implements IHotelLinkService{


    @Override
    public RestResponse<LinkHotelRateSearchVO> rateSearch(LinkHotelRateSearchDTO linkHotelRateSearchDTO) {
        return ApiRes.response(DataResponseEnum.DATA_NOT_SUPPORT);
    }

    @Override
    public RestResponse<LinkHotelGuaranteeVO> guarantee(LinkHotelGuaranteeDTO linkHotelGuaranteeDTO) {
        return ApiRes.response(DataResponseEnum.DATA_NOT_SUPPORT);
    }

    @Override
    public RestResponse<LinkHotelValidateVO> validate(LinkHotelValidateDTO linkHotelValidateDTO) {
        return ApiRes.response(DataResponseEnum.DATA_NOT_SUPPORT);
    }

    @Override
    public RestResponse<LinkHotelOrderBookVO> orderBook(LinkHotelOrderBookDTO linkHotelOrderBookDTO) {
        return ApiRes.response(DataResponseEnum.DATA_NOT_SUPPORT);
    }

   @Override
    public RestResponse<LinkHotelOrderPayVO> orderPay(LinkHotelOrderPayDTO linkHotelOrderPayDTO) {
        return ApiRes.response(DataResponseEnum.DATA_NOT_SUPPORT);
    }

    @Override
    public RestResponse<LinkHotelOrderDetailVO> orderDetail(LinkHotelOrderDetailDTO linkHotelOrderDetailDTO) {
        return ApiRes.response(DataResponseEnum.DATA_NOT_SUPPORT);
    }

    @Override
    public RestResponse<LinkHotelOrderCancelVO> orderCancel(LinkHotelOrderCancelDTO linkHotelOrderCancelDTO) {
        return ApiRes.response(DataResponseEnum.DATA_NOT_SUPPORT);
    }

    @Override
    public RestResponse<LinkHotelCgtdsqVO> hotelTdsq(LinkHotelCgtdsqDTO linkHotelCgtdsqDTO) {
        return ApiRes.response(DataResponseEnum.DATA_NOT_SUPPORT);
    }

    @Override
    public RestResponse<LinkHotelCgtdxxVO> hotelTdxx(LinkHotelCgtdxxDTO linkHotelCgtdxxDTO) {
        return ApiRes.response(DataResponseEnum.DATA_NOT_SUPPORT);
    }

    @Override
    public RestResponse<LinkHotelPayDkVO> hotelPayDk(LinkHotelPayDkDTO linkHotelPayDkDTO) {
        return ApiRes.response(DataResponseEnum.DATA_NOT_SUPPORT);
    }

    @Override
    public RestResponse<LinkHotelPayWithholdingMixVO> hotelPayDkMix(LinkHotelPayWithholdingMixDTO linkHotelPayWithholdingMixDTO) {
        return ApiRes.response(DataResponseEnum.DATA_NOT_SUPPORT);
    }

    @Override
    public RestResponse<LinkHotelDdtkVO> hotelDdtk(LinkHotelDdtkDTO linkHotelDdtkDTO) {
        return ApiRes.response(DataResponseEnum.DATA_NOT_SUPPORT);
    }

    @Override
    public RestResponse<LinkHotelOrderListVO> orderList(LinkHotelOrderListDTO linkHotelOrderListDTO) {
        return ApiRes.response(DataResponseEnum.DATA_NOT_SUPPORT);
    }

    @Override
    public RestResponse<LinkHotelDdValidateVO> ddValidate(LinkHotelDdValidateDTO linkHotelDdValidateDTO) {
        return ApiRes.response(DataResponseEnum.DATA_NOT_SUPPORT);
    }

    @Override
    public RestResponse<LinkHotelRegistrationVO> registration(LinkHotelRegistrationDTO linkHotelRegistrationDTO) {
        return ApiRes.response(DataResponseEnum.DATA_NOT_SUPPORT);
    }

    @Override
    public RestResponse<HotelBuyerBillPushVO> hotelBuyerBillPush(HotelBuyerBillPushDTO hotelBuyerBillPushDTO) {
        return ApiRes.response(DataResponseEnum.DATA_NOT_SUPPORT);
    }

    @Override
    public RestResponse<HotelImageConvertVO> hotelImageConvert(HotelImageConvertDTO hotelImageConvertDTO) {
        return ApiRes.response(DataResponseEnum.DATA_NOT_SUPPORT);
    }

    @Override
    public RestResponse<LinkHotelOrderReminderVO> orderReminder(LinkHotelOrderReminderDTO hotelOrderReminderDTO) {
        return ApiRes.response(DataResponseEnum.DATA_NOT_SUPPORT);
    }

    @Override
    public RestResponse<HotelGuestReviewsVO> hotelGuestReviews(HotelGuestReviewsDTO hotelGuestReviewsDTO) {
        return ApiRes.response(DataResponseEnum.DATA_NOT_SUPPORT);
    }
    @Override
    public RestResponse<LinkHotelOrderReviewVO> orderReview(LinkHotelOrderReviewDTO linkHotelOrderReviewDTO) {
        return ApiRes.response(DataResponseEnum.DATA_NOT_SUPPORT);
    }
}
