package com.example.application.data.service;


import com.example.application.data.entity.Product;
import com.example.application.data.repository.ProductRepository;
import com.example.application.solr.SolrProduct;
import com.example.application.solr.SolrService;
import jakarta.persistence.EntityManager;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private final ProductRepository productRepository;
    @Autowired
    private final SolrService service;
    List<Product> productsToSave = new ArrayList<>();


    public ProductService(ProductRepository productRepository, SolrService service) {
        this.productRepository = productRepository;
        this.service = service;

    }

    public void insert(String filePath) {
        // load data into database to then be uploaded to SOLR instance

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isFirstLine = true;
            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue; // Skip the header line
                }
                // Split the TSV line into individual fields
                String[] fields = line.split("\t");


                // Create a new Product object and set its properties
                Product product = new Product();
                product.setSkuId(fields[0]);
                product.setImage(fields[1]);
                product.setAdditionalImageLink(fields[2]);
                product.setStyleId(fields[3]);
                product.setClassId(fields[4]);
                product.setColor(fields[5]);
                product.setColorCode(fields[6]);
                product.setColorFamily(fields[7]);
                product.setSize(fields[8]);
                product.setSizeId(fields[9]);
                product.setDepartmentId(fields[10]);
                product.setDissectionCode(fields[11]);
                product.setHazmat(fields[12]);
                product.setRedline(fields[13]);
                product.setPromoted(fields[14]);
                product.setTaxCode(fields[15]);
                product.setVendor(fields[16]);
                product.setListPrice(Double.parseDouble(fields[17]));
                product.setSalePrice(fields[18]);
                product.setSalePriceEffectiveDate(fields[19]);
                product.setCurrency(fields[20]);
                product.setShoprunnerEligible(fields[21]);
                product.setLink(fields[22]);
                product.setTitle(fields[23]);
                product.setProdDescription(fields[24]);
                product.setStartDate(fields[25]);
                product.setFeaturedColor(fields[26]);
                product.setFeaturedColorCategory(fields[27]);
                product.setRelatedProducts(fields[28]);
                product.setPreOrder(fields[29]);
                product.setHandlingCode(fields[30]);
                product.setVideo(fields[31]);
                product.setProportion(fields[32]);
                product.setProportionProducts(fields[33]);
                product.setMasterStyle(fields[34]);
                product.setCannotReturn(fields[35]);
                product.setGreatFind(fields[36]);
                product.setWebExclusive(fields[37]);
                product.setNyDeals(fields[38]);
                product.setPromoTagline(fields[39]);
                product.setPartiallyPromoted(fields[40]);
                product.setProductCategory(fields[41]);

                product.setSortOrder(fields[42]);
                product.setQuantitySold(43);
                // adding a check for null values
                if (fields.length > 44 && !fields[44].isEmpty()) {
                    product.setAverageRating(Double.parseDouble(fields[44]));
                }
                productsToSave.add(product);
                // Insert the product into the database and upload to SOLR

                productRepository.saveAll(productsToSave);

                setSolrProduct(fields);


            }
        } catch (IOException | SolrServerException e) {
            e.printStackTrace();
        }

    }

    public void setSolrProduct(String[] fields) throws SolrServerException, IOException {
        SolrProduct solrProduct = new SolrProduct();
        solrProduct.setSkuId(fields[0]);
        solrProduct.setImage(fields[1]);
        solrProduct.setAdditionalImageLink(fields[2]);
        solrProduct.setStyleId(fields[3]);
        solrProduct.setClassId(fields[4]);
        solrProduct.setColor(fields[5]);
        solrProduct.setColorCode(fields[6]);
        solrProduct.setColorFamily(fields[7]);
        solrProduct.setSize(fields[8]);
        solrProduct.setSizeId(fields[9]);
        solrProduct.setDepartmentId(fields[10]);
        solrProduct.setDissectionCode(fields[11]);
        solrProduct.setHazmat(Boolean.parseBoolean(fields[12]));
        solrProduct.setRedline(Boolean.parseBoolean(fields[13]));
        solrProduct.setPromoted(Boolean.parseBoolean(fields[14]));
        solrProduct.setTaxCode(fields[15]);
        solrProduct.setVendor(fields[16]);
        solrProduct.setListPrice(Double.parseDouble(fields[17]));
        solrProduct.setSalePrice(fields[18]);
        solrProduct.setSalePriceEffectiveDate(fields[19]);
        solrProduct.setCurrency(fields[20]);
        solrProduct.setShoprunnerEligible(Boolean.parseBoolean(fields[21]));
        solrProduct.setLink(fields[22]);
        solrProduct.setTitle(fields[23]);
        solrProduct.setProdDescription(fields[24]);
        solrProduct.setStartDate(fields[25]);
        solrProduct.setFeaturedColor(fields[26]);
        solrProduct.setFeaturedColorCategory(fields[27]);
        solrProduct.setRelatedProducts(fields[28]);
        solrProduct.setPreOrder(Boolean.parseBoolean(fields[29]));
        solrProduct.setHandlingCode(fields[30]);
        solrProduct.setVideo(fields[31]);
        solrProduct.setProportion(fields[32]);
        solrProduct.setProportionProducts(fields[33]);
        solrProduct.setMasterStyle(fields[34]);
        solrProduct.setCannotReturn(Boolean.parseBoolean(fields[35]));
        solrProduct.setGreatFind(Boolean.parseBoolean(fields[36]));
        solrProduct.setWebExclusive(Boolean.parseBoolean(fields[37]));
        solrProduct.setNyDeals(Boolean.parseBoolean(fields[38]));
        solrProduct.setPromoTagline(fields[39]);
        solrProduct.setPartiallyPromoted(Boolean.parseBoolean(fields[40]));
        solrProduct.setProductCategory(fields[41]);
        solrProduct.setSortOrder(fields[42]);
        solrProduct.setQuantitySold(43);
        if (fields.length > 44 && !fields[44].isEmpty()) {
            solrProduct.setAverageRating(Double.parseDouble(fields[44]));
        }
        service.insertProduct(solrProduct);

    }

}
