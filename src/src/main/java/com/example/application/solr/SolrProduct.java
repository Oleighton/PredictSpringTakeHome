package com.example.application.solr;

import org.apache.solr.client.solrj.beans.Field;

public class SolrProduct {

    @Field("sku_id")
    private String skuId;

    @Field("image")
    private String image;

    @Field("additional_image_link")
    private String additionalImageLink;

    @Field("style_id")
    private String styleId;

    @Field("class_id")
    private String classId;

    @Field("color")
    private String color;

    @Field("color_code")
    private String colorCode;

    @Field("color_family")
    private String colorFamily;

    @Field("size")
    private String size;

    @Field("size_id")
    private String sizeId;

    @Field("department_id")
    private String departmentId;

    @Field("dissection_code")
    private String dissectionCode;

    @Field("hazmat")
    private boolean hazmat;

    @Field("redline")
    private boolean redline;

    @Field("promoted")
    private boolean promoted;

    @Field("tax_code")
    private String taxCode;

    @Field("vendor")
    private String vendor;

    @Field("list_price")
    private double listPrice;

    @Field("sale_price")
    private String salePrice;

    @Field("sale_price_effective_date")
    private String salePriceEffectiveDate;

    @Field("currency")
    private String currency;

    @Field("shoprunner_eligible")
    private boolean shoprunnerEligible;

    @Field("title")
    private String title;

    @Field("link")
    private String link;

    @Field("prod_description")
    private String prodDescription;

    @Field("start_date")
    private String startDate;

    @Field("featured_color")
    private String featuredColor;

    @Field("featured_color_category")
    private String featuredColorCategory;

    @Field("related_products")
    private String relatedProducts;

    @Field("pre_order")
    private boolean preOrder;

    @Field("handling_code")
    private String handlingCode;

    @Field("video")
    private String video;

    @Field("proportion")
    private String proportion;

    @Field("proportion_products")
    private String proportionProducts;

    @Field("master_style")
    private String masterStyle;

    @Field("cannot_return")
    private boolean cannotReturn;

    @Field("great_find")
    private boolean greatFind;

    @Field("web_exclusive")
    private boolean webExclusive;

    @Field("ny_deals")
    private boolean nyDeals;

    @Field("promo_tagline")
    private String promoTagline;

    @Field("partially_promoted")
    private boolean partiallyPromoted;

    @Field("product_category")
    private String productCategory;

    @Field("sort_order")
    private String sortOrder;

    @Field("quantity_sold")
    private int quantitySold;

    @Field("average_rating")
    private double averageRating;

    public String getSkuId() {
        return skuId;
    }
    public SolrProduct() {
        // Default constructor (required for SolrJ)
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAdditionalImageLink() {
        return additionalImageLink;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setAdditionalImageLink(String additionalImageLink) {
        this.additionalImageLink = additionalImageLink;
    }

    public String getStyleId() {
        return styleId;
    }

    public void setStyleId(String styleId) {
        this.styleId = styleId;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColorCode() {
        return colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getColorFamily() {
        return colorFamily;
    }

    public void setColorFamily(String colorFamily) {
        this.colorFamily = colorFamily;
    }

    public String getSizeId() {
        return sizeId;
    }

    public void setSizeId(String sizeId) {
        this.sizeId = sizeId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDissectionCode() {
        return dissectionCode;
    }

    public void setDissectionCode(String dissectionCode) {
        this.dissectionCode = dissectionCode;
    }

    public boolean isHazmat() {
        return hazmat;
    }

    public void setHazmat(boolean hazmat) {
        this.hazmat = hazmat;
    }

    public boolean isRedline() {
        return redline;
    }

    public void setRedline(boolean redline) {
        this.redline = redline;
    }

    public boolean isPromoted() {
        return promoted;
    }

    public void setPromoted(boolean promoted) {
        this.promoted = promoted;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public double getListPrice() {
        return listPrice;
    }

    public void setListPrice(double listPrice) {
        this.listPrice = listPrice;
    }

    public String getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(String salePrice) {
        this.salePrice = salePrice;
    }

    public String getSalePriceEffectiveDate() {
        return salePriceEffectiveDate;
    }

    public void setSalePriceEffectiveDate(String salePriceEffectiveDate) {
        this.salePriceEffectiveDate = salePriceEffectiveDate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public boolean isShoprunnerEligible() {
        return shoprunnerEligible;
    }

    public void setShoprunnerEligible(boolean shoprunnerEligible) {
        this.shoprunnerEligible = shoprunnerEligible;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProdDescription() {
        return prodDescription;
    }

    public void setProdDescription(String prodDescription) {
        this.prodDescription = prodDescription;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getFeaturedColor() {
        return featuredColor;
    }

    public void setFeaturedColor(String featuredColor) {
        this.featuredColor = featuredColor;
    }

    public String getFeaturedColorCategory() {
        return featuredColorCategory;
    }

    public void setFeaturedColorCategory(String featuredColorCategory) {
        this.featuredColorCategory = featuredColorCategory;
    }

    public String getRelatedProducts() {
        return relatedProducts;
    }

    public void setRelatedProducts(String relatedProducts) {
        this.relatedProducts = relatedProducts;
    }

    public boolean isPreOrder() {
        return preOrder;
    }

    public void setPreOrder(boolean preOrder) {
        this.preOrder = preOrder;
    }

    public String getHandlingCode() {
        return handlingCode;
    }

    public void setHandlingCode(String handlingCode) {
        this.handlingCode = handlingCode;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getProportion() {
        return proportion;
    }

    public void setProportion(String proportion) {
        this.proportion = proportion;
    }

    public String getProportionProducts() {
        return proportionProducts;
    }

    public void setProportionProducts(String proportionProducts) {
        this.proportionProducts = proportionProducts;
    }

    public String getMasterStyle() {
        return masterStyle;
    }

    public void setMasterStyle(String masterStyle) {
        this.masterStyle = masterStyle;
    }

    public boolean isCannotReturn() {
        return cannotReturn;
    }

    public void setCannotReturn(boolean cannotReturn) {
        this.cannotReturn = cannotReturn;
    }

    public boolean isGreatFind() {
        return greatFind;
    }

    public void setGreatFind(boolean greatFind) {
        this.greatFind = greatFind;
    }

    public boolean isWebExclusive() {
        return webExclusive;
    }

    public void setWebExclusive(boolean webExclusive) {
        this.webExclusive = webExclusive;
    }

    public boolean isNyDeals() {
        return nyDeals;
    }

    public void setNyDeals(boolean nyDeals) {
        this.nyDeals = nyDeals;
    }

    public String getPromoTagline() {
        return promoTagline;
    }

    public void setPromoTagline(String promoTagline) {
        this.promoTagline = promoTagline;
    }

    public boolean isPartiallyPromoted() {
        return partiallyPromoted;
    }

    public void setPartiallyPromoted(boolean partiallyPromoted) {
        this.partiallyPromoted = partiallyPromoted;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    public int getQuantitySold() {
        return quantitySold;
    }

    public void setQuantitySold(int quantitySold) {
        this.quantitySold = quantitySold;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }
// Other Solr fields and their respective getters/setters...
}
