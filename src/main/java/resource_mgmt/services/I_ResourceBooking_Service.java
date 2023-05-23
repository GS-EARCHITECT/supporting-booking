package resource_mgmt.services;

public interface I_ResourceBooking_Service 
{
abstract public Long res_cate_Strictprocess(Long allocSeqNo);
abstract public Long res_assets_Strictprocess(Long allocSeqNo);
abstract public Long resource_Alloc_Asset(Long companySeqNo, Long assetSeqNo, String assetLocationId, String frDtTm, String toDtTm);
abstract public Long resource_Alloc_Cate(Long companySeqNo, Long resSeqNo, String resLocationId, String frDtTm,	String toDtTm, Long qtySeqNo, Float qty);
}