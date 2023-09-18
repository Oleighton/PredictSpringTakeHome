package org.example;


import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.example.data.entity.Product;
import org.example.data.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ApplicationContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@EntityScan("org.example.data.entity")
@PageTitle("Main")
@Route(value = "")
public class Main extends VerticalLayout  {
    private TextField searchTerm = new TextField("Search for a Product");
    ComboBox<String> comboBox = new ComboBox<>("Select a category");
    ;
    private Button searchBtn = new Button("Submit");
    private Grid<Product> grid = new Grid<>(Product.class);

    private SolrClient solr = new HttpSolrClient.Builder("http://localhost:8983/solr/ps_products").build();
    private String searchCategory;

    public Main() {
        // Define the items in the drop-down
        comboBox.setItems("sku_id", "image", "additional_image_link",
                "style_id","class_id","size","color","color_code",
                "color_family","size","size_id","department_id",
                "dissection_code","hazmat","redline","promoted",
                "tax_code","vendor","list_price","currency","shoprunner_eligible","title","link","prod_description",
                "featured_color_category","related_products","pre_order","handling_code","proportion","proportion_products",
                "cannot_return","great_find","web_exclusive","ny_deals","partially_promoted","product_category","sort_order",
                "quantity_sold","average_rating");
        setGridColumns();
        searchBtn.addClickListener(e -> {
            String searchTermValue = searchTerm.getValue();
            try {
                if (searchTermValue.isEmpty() || searchCategory.isEmpty()){
                    Notification.show("Please enter a search value/category");
                } else{
                    searchProduct(searchTermValue, searchCategory);
                }
            } catch (SolrServerException ex) {
                throw new RuntimeException(ex);
            } catch (IOException ex) {
                Notification.show("No results found, please try another query");
                throw new RuntimeException(ex);
            }

        });
        // Add a value change listener to react to selection changes
        comboBox.addValueChangeListener(event -> {
            searchCategory = event.getValue();

        });
        searchBtn.addClickShortcut(Key.ENTER);
        // Center align search components

        HorizontalLayout searchLayout = new HorizontalLayout(comboBox, searchTerm, searchBtn);
        add(searchLayout, grid);
    }

    public static void main(String[] args) throws SolrServerException, IOException {
        SpringApplication.run(Main.class, args);
        ApplicationContext context = ApplicationContextProvider.getContext();
        ProductService productService = context.getBean(ProductService.class);
        String tsvFilePath = "src/main/resources/resources/Product_feed.tsv";
        productService.insert(tsvFilePath);
    }

    public void setGridColumns() {
        grid.removeAllColumns();

        // Add columns for your fields
        grid.addColumn(Product::getSkuId).setHeader("SKU ID").setFlexGrow(0).setAutoWidth(true);
        grid.addColumn(Product::getImage).setHeader("Image").setFlexGrow(0).setAutoWidth(true);
        grid.addColumn(Product::getAdditionalImageLink).setHeader("Additional Image").setFlexGrow(0).setAutoWidth(true);
        grid.addColumn(Product::getTitle).setHeader("Title").setFlexGrow(1).setAutoWidth(true);
        grid.addColumn(Product::getStyleId).setHeader("Style ID").setFlexGrow(0).setAutoWidth(true);
        grid.addColumn(Product::getClassId).setHeader("Class ID").setFlexGrow(0).setAutoWidth(true);
        grid.addColumn(Product::getColor).setHeader("Color").setFlexGrow(0).setAutoWidth(true);
        grid.addColumn(Product::getColorCode).setHeader("Color Code").setFlexGrow(0).setAutoWidth(true);
        grid.addColumn(Product::getColorFamily).setHeader("Color Family").setFlexGrow(0).setAutoWidth(true);
        grid.addColumn(Product::getSize).setHeader("Size").setFlexGrow(0).setAutoWidth(true);
        grid.addColumn(Product::getSizeId).setHeader("Size ID").setFlexGrow(0).setAutoWidth(true);
        grid.addColumn(Product::getDepartmentId).setHeader("Department ID").setFlexGrow(0).setAutoWidth(true);
        grid.addColumn(Product::getDissectionCode).setHeader("Dissection Code").setFlexGrow(0).setAutoWidth(true);
        grid.addColumn(Product::getHazmat).setHeader("Hazmat").setFlexGrow(0).setAutoWidth(true);
        grid.addColumn(Product::getRedline).setHeader("Redline").setFlexGrow(0).setAutoWidth(true);
        grid.addColumn(Product::getPromoted).setHeader("Promoted").setFlexGrow(0).setAutoWidth(true);
        grid.addColumn(Product::getTaxCode).setHeader("Tax Code").setFlexGrow(0).setAutoWidth(true);
        grid.addColumn(Product::getVendor).setHeader("Vendor").setFlexGrow(0).setAutoWidth(true);
        grid.addColumn(Product::getListPrice).setHeader("List Price").setFlexGrow(0).setAutoWidth(true);
        grid.addColumn(Product::getSalePrice).setHeader("Sale Price").setFlexGrow(0).setAutoWidth(true);
        grid.addColumn(Product::getSalePriceEffectiveDate).setHeader("Sale Price Effective Date").setFlexGrow(0).setAutoWidth(true);
        grid.addColumn(Product::getCurrency).setHeader("Currency").setFlexGrow(0).setAutoWidth(true);
        grid.addColumn(Product::getShoprunnerEligible).setHeader("Shoprunner Eligible").setFlexGrow(0).setAutoWidth(true);
        grid.addColumn(Product::getTitle).setHeader("Title").setFlexGrow(0).setAutoWidth(true);
        grid.addColumn(Product::getLink).setHeader("Link").setFlexGrow(0).setAutoWidth(true);
        grid.addColumn(Product::getProdDescription).setHeader("Product Description").setFlexGrow(0).setAutoWidth(true);
        grid.addColumn(Product::getStartDate).setHeader("Start Date").setFlexGrow(0).setAutoWidth(true);
        grid.addColumn(Product::getFeaturedColor).setHeader("Featured Color").setFlexGrow(0).setAutoWidth(true);
        grid.addColumn(Product::getFeaturedColorCategory).setHeader("Featured Color Category").setFlexGrow(0).setAutoWidth(true);
        grid.addColumn(Product::getRelatedProducts).setHeader("Related Products").setFlexGrow(0).setAutoWidth(true);
        grid.addColumn(Product::getPreOrder).setHeader("Pre Order").setFlexGrow(0).setAutoWidth(true);
        grid.addColumn(Product::getHandlingCode).setHeader("Handling Code").setFlexGrow(0).setAutoWidth(true);
        grid.addColumn(Product::getVideo).setHeader("Video").setFlexGrow(0).setAutoWidth(true);
        grid.addColumn(Product::getProportion).setHeader("Proportion").setFlexGrow(0).setAutoWidth(true);
        grid.addColumn(Product::getProportionProducts).setHeader("Proportion Products").setFlexGrow(0).setAutoWidth(true);
        grid.addColumn(Product::getMasterStyle).setHeader("Master Style").setFlexGrow(0).setAutoWidth(true);
        grid.addColumn(Product::getCannotReturn).setHeader("Cannot Return").setFlexGrow(0).setAutoWidth(true);
        grid.addColumn(Product::getGreatFind).setHeader("Great Find").setFlexGrow(0).setAutoWidth(true);
        grid.addColumn(Product::getWebExclusive).setHeader("Web Exclusive").setFlexGrow(0).setAutoWidth(true);
        grid.addColumn(Product::getNyDeals).setHeader("NY Deals").setFlexGrow(0).setAutoWidth(true);
        grid.addColumn(Product::getPromoTagline).setHeader("Promo Tagline").setFlexGrow(0).setAutoWidth(true);
        grid.addColumn(Product::getPartiallyPromoted).setHeader("Partially Promoted").setFlexGrow(0).setAutoWidth(true);
        grid.addColumn(Product::getProductCategory).setHeader("Product Category").setFlexGrow(0).setAutoWidth(true);
        grid.addColumn(Product::getSortOrder).setHeader("Sort Order").setFlexGrow(0).setAutoWidth(true);
        grid.addColumn(Product::getQuantitySold).setHeader("Quantity Sold").setFlexGrow(0).setAutoWidth(true);
        grid.addColumn(Product::getAverageRating).setHeader("Average Rating").setFlexGrow(0).setAutoWidth(true);
        // Enable text wrapping for all columns
        for (Grid.Column<Product> column : grid.getColumns()) {
            column.setAutoWidth(true).setFlexGrow(1).setResizable(true).setSortable(true);
            column.getElement().getStyle().set("white-space", "normal");
        }
    }



    public List<Product> searchProduct(String searchTerm, String searchCategory) throws SolrServerException, IOException {
        // Create a Solr query
        if (searchCategory.equals("image") || searchCategory.equals("additional_image_link")
                || searchCategory.equals("link") || searchCategory.equals("product_category")) {
            // Wrap the searchTerm in double quotes
            searchTerm = '"' + searchTerm + '"';
            System.out.println(searchTerm);
        }
        SolrQuery query = new SolrQuery(searchCategory + ":" + searchTerm);
        System.out.println(query);
        // Execute the query
        QueryResponse response = solr.query(query);

        // Check if there are results
        if (response != null && response.getResults() != null) {
            // Process the search results
            List<SolrDocument> solrResults = response.getResults();
            List<Product> products = new ArrayList<>();
            // add found fields
            for (SolrDocument doc : solrResults) {
                Product product = new Product();
                product.setSkuId((String) doc.getFieldValue("sku_id"));
                product.setImage((String) doc.getFieldValue("image"));
                product.setAdditionalImageLink((String) doc.getFieldValue("additional_image_link"));
                product.setStyleId((String) doc.getFieldValue("style_id"));
                product.setClassId((String) doc.getFieldValue("class_id"));
                product.setColor((String) doc.getFieldValue("color"));
                product.setColorCode((String) doc.getFieldValue("color_code"));
                product.setColorFamily((String) doc.getFieldValue("color_family"));
                product.setSize((String) doc.getFieldValue("size"));
                product.setSizeId((String) doc.getFieldValue("size_id"));
                product.setDepartmentId((String) doc.getFieldValue("department_id"));
                product.setDissectionCode((String) doc.getFieldValue("dissection_code"));
                product.setHazmat((String)doc.getFieldValue("hazmat"));
                product.setRedline((String) doc.getFieldValue("redline"));
                product.setPromoted((String) doc.getFieldValue("promoted"));
                product.setTaxCode((String) doc.getFieldValue("tax_code"));
                product.setVendor((String) doc.getFieldValue("vendor"));
                product.setListPrice((Double) doc.getFieldValue("list_price"));
                product.setSalePrice((String) doc.getFieldValue("sale_price"));
                product.setSalePriceEffectiveDate((String) doc.getFieldValue("sale_price_effective_date"));
                product.setCurrency((String) doc.getFieldValue("currency"));
                product.setShoprunnerEligible((String) doc.getFieldValue("shoprunner_eligible"));
                product.setTitle((String) doc.getFieldValue("title"));
                product.setLink((String) doc.getFieldValue("link"));
                products.add(product);

            }
            if (products.isEmpty()){
                Notification.show("No results were found");
            }
            grid.setItems(products);
            return products;
        } else {
            throw new SolrServerException("SOLR Server Error, please check your connection");
        }
    }

}

