package com.pzj.base.entity.json;

/**
 * @author liyh <levart@163.com>
 * @version 20160506
 */
public class QueryProductPriceDto implements  java.io.Serializable{

    private String startTime;       // 开始时间
    private String endTime;         // 结束时间

    private Integer productId;      // 产品ID
    private Integer pkgId;          // 打包ID
    private Integer tsId;           // 时间段ID

    private Integer[] attrId;         // 属性IDS
    private Integer[] attrNum;        // 属性IDS数量

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getPkgId() {
        return pkgId;
    }

    public void setPkgId(Integer pkgId) {
        this.pkgId = pkgId;
    }

    public Integer getTsId() {
        return tsId;
    }

    public void setTsId(Integer tsId) {
        this.tsId = tsId;
    }

    public Integer[] getAttrId() {
        return attrId;
    }

    public void setAttrId(Integer[] attrId) {
        this.attrId = attrId;
    }

    public Integer[] getAttrNum() {
        return attrNum;
    }

    public void setAttrNum(Integer[] attrNum) {
        this.attrNum = attrNum;
    }
}
